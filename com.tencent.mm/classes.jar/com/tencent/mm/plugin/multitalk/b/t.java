package com.tencent.mm.plugin.multitalk.b;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.d.d;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.ae;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.ada;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.wxmm.v2conference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public final class t
{
  public static int zKD = 14745600;
  private byte[] frameData;
  private boolean mStarted;
  private HandlerThread mThread;
  private Timer mTimer;
  private int qve;
  private int qvf;
  private final Map<String, c> qvg;
  private k zHs;
  private int zKB;
  private Timer zKC;
  private byte[] zKE;
  
  public t(k paramk)
  {
    AppMethodBeat.i(239314);
    this.zHs = null;
    this.mThread = null;
    this.qve = 0;
    this.zKB = 0;
    this.qvf = 0;
    this.mTimer = null;
    this.zKC = null;
    this.frameData = new byte[zKD];
    this.zKE = new byte[zKD];
    this.qvg = new HashMap();
    this.mStarted = false;
    this.zHs = paramk;
    AppMethodBeat.o(239314);
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(239318);
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
    if (this.zKC != null)
    {
      this.zKC.cancel();
      this.zKC = null;
    }
    AppMethodBeat.o(239318);
  }
  
  final void a(ada arg1)
  {
    AppMethodBeat.i(239317);
    Log.e("MicroMsg.Multitalk.ILinkVideoMgr", "updateMembers");
    if ((??? == null) || (???.KHx == null) || (???.KHx.size() == 0))
    {
      AppMethodBeat.o(239317);
      return;
    }
    Object localObject1 = ???.KHx;
    synchronized (this.qvg)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        acz localacz = (acz)((Iterator)localObject1).next();
        c localc = (c)this.qvg.get(localacz.openid);
        if (localc != null) {
          localc.ES(localacz.Lnt);
        }
      }
    }
    AppMethodBeat.o(239317);
  }
  
  public final boolean czm()
  {
    AppMethodBeat.i(239315);
    Log.e("MicroMsg.Multitalk.ILinkVideoMgr", "startPlay");
    try
    {
      try
      {
        if (this.mStarted) {
          return false;
        }
        this.mStarted = true;
        if (this.mTimer != null)
        {
          this.mTimer.cancel();
          this.mTimer = null;
        }
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(239309);
            int k = 8;
            if (k > 0) {}
            for (;;)
            {
              int i;
              try
              {
                if (t.this.isStarted())
                {
                  j = 0;
                  int m = 0;
                  i = (byte)(j + 1);
                  if (j < 2)
                  {
                    t.a(t.this)[0] = i;
                    Object localObject = p.zHS;
                    j = p.Y(t.a(t.this), 0);
                    int n = m.czd().field_remoteImgLength;
                    final int i1 = m.czd().field_remoteImgHeight;
                    final int i2 = m.czd().field_remoteImgWidth;
                    int i3 = m.czd().field_remoteImgMember;
                    if (t.b(t.this) % 100 == 0) {
                      Log.d("MicroMsg.Multitalk.ILinkVideoMgr", "GetVideo, mark:" + (i - 1) + " ret:" + j + ", len:" + t.a(t.this).length + ", rLen:" + n + ", rHeight:" + i1 + ", rWidth:" + i2 + ", rMid:" + i3 + ", drawCnt:" + t.c(t.this) + ", format:0");
                    }
                    if ((j <= 0) || (n <= 0) || (i1 <= 0) || (i2 <= 0)) {
                      break label356;
                    }
                    if (i3 >= 0)
                    {
                      localObject = t.d(t.this).QX(i3);
                      final int[] arrayOfInt = v.Z(t.a(t.this), n);
                      Log.d("MicroMsg.Multitalk.ILinkVideoMgr", "handleIdleObj get username: %s", new Object[] { localObject });
                      if (localObject != null) {
                        MMHandlerThread.postToMainThread(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(239308);
                            ac.eom().enz().a(this.zKG, arrayOfInt, i2, i1, 0, OpenGlRender.FLAG_Angle90);
                            AppMethodBeat.o(239308);
                          }
                        });
                      }
                    }
                    j = i;
                    m = 1;
                    continue;
                  }
                  if (m != 0) {}
                }
                else
                {
                  AppMethodBeat.o(239309);
                  return;
                }
              }
              catch (Exception localException)
              {
                Log.printErrStackTrace("MicroMsg.Multitalk.ILinkVideoMgr", localException, "timer task crash", new Object[0]);
                AppMethodBeat.o(239309);
                return;
              }
              k -= 1;
              break;
              label356:
              int j = i;
            }
          }
        }, 0L, 20L);
        if (this.zKC != null)
        {
          this.zKC.cancel();
          this.zKC = null;
        }
        this.zKC = new Timer();
        this.zKC.schedule(new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(239313);
            int m = 8;
            if (m > 0) {}
            for (;;)
            {
              int i;
              try
              {
                if (t.this.isStarted())
                {
                  int k = 0;
                  j = 0;
                  i = (byte)(j + 1);
                  if (j < 2)
                  {
                    t.e(t.this)[0] = i;
                    Object localObject1 = p.zHS;
                    j = p.Y(t.e(t.this), 128);
                    int n = m.czd().field_remoteScreenImgLength;
                    final int i1 = m.czd().field_remoteScreenImgHeight;
                    final int i2 = m.czd().field_remoteScreenImgWidth;
                    int i3 = m.czd().field_remoteScreenImgMember;
                    if (t.f(t.this) % 100 == 0) {
                      Log.d("MicroMsg.Multitalk.ILinkVideoMgr", "GetScreen, mark:" + (i - 1) + " ret:" + j + ", len:" + t.e(t.this).length + ", rLen:" + n + ", rHeight:" + i1 + ", rWidth:" + i2 + ", rMid:" + i3 + ", drawCnt:" + t.g(t.this) + ", format:128");
                    }
                    if ((j <= 0) || (n <= 0)) {
                      break label556;
                    }
                    if (i3 >= 0)
                    {
                      localObject1 = t.d(t.this).QX(i3);
                      Log.i("MicroMsg.Multitalk.ILinkVideoMgr", "yuemwang: nGetVideoData mid : " + i3 + " user: " + (String)localObject1 + "  size:" + i2 + "x" + i1);
                      Log.d("MicroMsg.Multitalk.ILinkVideoMgr", "GetScreen handleIdleObj get username: %s, position: %d", new Object[] { localObject1, Integer.valueOf(0) });
                      if ((j != 1) || (i2 != 0) || (i1 >= 3)) {
                        break label561;
                      }
                      j = 1;
                      if (localObject1 != null)
                      {
                        Object localObject2;
                        if (j != 0)
                        {
                          localObject2 = d.zZa;
                          d.RC(2);
                          Log.d("MicroMsg.Multitalk.ILinkVideoMgr", "receive screen frame using HW decode");
                          MMHandlerThread.postToMainThread(new Runnable()
                          {
                            public final void run()
                            {
                              AppMethodBeat.i(239310);
                              ac.eom().enz().a(this.zKG, t.e(t.this), i1, OpenGlRender.FLAG_Angle90);
                              AppMethodBeat.o(239310);
                            }
                          });
                          j = i;
                          k = 1;
                          continue;
                        }
                        Log.d("MicroMsg.Multitalk.ILinkVideoMgr", "receive screen frame using SW decode");
                        if (i2 > 480)
                        {
                          localObject2 = d.zZa;
                          d.RC(1);
                          MMHandlerThread.postToMainThread(new Runnable()
                          {
                            public final void run()
                            {
                              AppMethodBeat.i(239311);
                              ac.eom().enz().a(this.zKG, this.rAZ, i2, i1, OpenGlRender.FLAG_Angle90);
                              AppMethodBeat.o(239311);
                            }
                          });
                          j = i;
                          k = 1;
                          continue;
                        }
                        if (i3 >= 0)
                        {
                          localObject2 = v.Z(t.e(t.this), n);
                          Log.d("MicroMsg.Multitalk.ILinkVideoMgr", "handleIdleObj get username: %s", new Object[] { localObject1 });
                          if (localObject1 != null) {
                            MMHandlerThread.postToMainThread(new Runnable()
                            {
                              public final void run()
                              {
                                AppMethodBeat.i(239312);
                                ac.eom().enz().a(this.zKG, this.rAZ, i2, i1, 0, OpenGlRender.FLAG_Angle90);
                                AppMethodBeat.o(239312);
                              }
                            });
                          }
                        }
                      }
                    }
                    j = i;
                    k = 1;
                    continue;
                  }
                  if (k != 0) {}
                }
                else
                {
                  AppMethodBeat.o(239313);
                  return;
                }
              }
              catch (Exception localException)
              {
                Log.printErrStackTrace("MicroMsg.Multitalk.ILinkVideoMgr", localException, "timer task crash", new Object[0]);
                AppMethodBeat.o(239313);
                return;
              }
              m -= 1;
              break;
              label556:
              int j = i;
              continue;
              label561:
              j = 0;
            }
          }
        }, 0L, 20L);
        AppMethodBeat.o(239315);
        return true;
      }
      finally
      {
        AppMethodBeat.o(239315);
      }
      return false;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Multitalk.ILinkVideoMgr", "startPlay error:" + localException.toString());
      AppMethodBeat.o(239315);
    }
  }
  
  public final boolean isStarted()
  {
    try
    {
      boolean bool = this.mStarted;
      return bool;
    }
    finally {}
  }
  
  /* Error */
  public final void release()
  {
    // Byte code:
    //   0: ldc 191
    //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 102
    //   7: ldc 192
    //   9: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 78	com/tencent/mm/plugin/multitalk/b/t:mStarted	Z
    //   18: ifne +11 -> 29
    //   21: aload_0
    //   22: monitorexit
    //   23: ldc 191
    //   25: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: return
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield 78	com/tencent/mm/plugin/multitalk/b/t:mStarted	Z
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_0
    //   37: invokespecial 194	com/tencent/mm/plugin/multitalk/b/t:stopTimer	()V
    //   40: aload_0
    //   41: getfield 76	com/tencent/mm/plugin/multitalk/b/t:qvg	Ljava/util/Map;
    //   44: astore_1
    //   45: aload_1
    //   46: monitorenter
    //   47: aload_0
    //   48: getfield 76	com/tencent/mm/plugin/multitalk/b/t:qvg	Ljava/util/Map;
    //   51: invokeinterface 197 1 0
    //   56: aload_1
    //   57: monitorexit
    //   58: ldc 191
    //   60: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: return
    //   64: astore_1
    //   65: ldc 102
    //   67: new 174	java/lang/StringBuilder
    //   70: dup
    //   71: ldc 199
    //   73: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   76: aload_1
    //   77: invokevirtual 183	java/lang/Exception:toString	()Ljava/lang/String;
    //   80: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: ldc 191
    //   91: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: return
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: ldc 191
    //   100: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_1
    //   104: athrow
    //   105: astore_2
    //   106: aload_1
    //   107: monitorexit
    //   108: ldc 191
    //   110: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_2
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	t
    //   64	13	1	localException	Exception
    //   95	12	1	localObject1	Object
    //   105	9	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	14	64	java/lang/Exception
    //   36	47	64	java/lang/Exception
    //   58	63	64	java/lang/Exception
    //   98	105	64	java/lang/Exception
    //   108	115	64	java/lang/Exception
    //   14	23	95	finally
    //   29	36	95	finally
    //   96	98	95	finally
    //   47	58	105	finally
    //   106	108	105	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.t
 * JD-Core Version:    0.7.0.1
 */