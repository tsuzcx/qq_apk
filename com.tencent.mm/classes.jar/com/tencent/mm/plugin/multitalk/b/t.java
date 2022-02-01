package com.tencent.mm.plugin.multitalk.b;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.d.d;
import com.tencent.mm.plugin.multitalk.model.ab;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.z;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.protocal.protobuf.aba;
import com.tencent.mm.protocal.protobuf.abb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.wxmm.v2conference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public final class t
{
  public static int wpq = 8294400;
  private byte[] frameData;
  private boolean mStarted;
  private HandlerThread mThread;
  private Timer mTimer;
  private int pga;
  private int pgb;
  private final Map<String, c> pgc;
  private k wmo;
  private int wpo;
  private Timer wpp;
  private byte[] wpr;
  
  public t(k paramk)
  {
    AppMethodBeat.i(190719);
    this.wmo = null;
    this.mThread = null;
    this.pga = 0;
    this.wpo = 0;
    this.pgb = 0;
    this.mTimer = null;
    this.wpp = null;
    this.frameData = new byte[wpq];
    this.wpr = new byte[wpq];
    this.pgc = new HashMap();
    this.mStarted = false;
    this.wmo = paramk;
    AppMethodBeat.o(190719);
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(190723);
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
    if (this.wpp != null)
    {
      this.wpp.cancel();
      this.wpp = null;
    }
    AppMethodBeat.o(190723);
  }
  
  final void a(abb arg1)
  {
    AppMethodBeat.i(190722);
    ae.e("MicroMsg.Multitalk.ILinkVideoMgr", "updateMembers");
    if ((??? == null) || (???.FNS == null) || (???.FNS.size() == 0))
    {
      AppMethodBeat.o(190722);
      return;
    }
    Object localObject1 = ???.FNS;
    synchronized (this.pgc)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        aba localaba = (aba)((Iterator)localObject1).next();
        c localc = (c)this.pgc.get(localaba.FQc);
        if (localc != null) {
          localc.Bk(localaba.Gsd);
        }
      }
    }
    AppMethodBeat.o(190722);
  }
  
  public final boolean cbu()
  {
    AppMethodBeat.i(190720);
    ae.e("MicroMsg.Multitalk.ILinkVideoMgr", "startPlay");
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
            AppMethodBeat.i(190715);
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
                    Object localObject = p.wmO;
                    j = p.W(t.a(t.this), 0);
                    int n = m.cbn().field_remoteImgLength;
                    final int i1 = m.cbn().field_remoteImgHeight;
                    final int i2 = m.cbn().field_remoteImgWidth;
                    int i3 = m.cbn().field_remoteImgMember;
                    if (t.b(t.this) % 100 == 0) {
                      ae.d("MicroMsg.Multitalk.ILinkVideoMgr", "GetVideo, mark:" + (i - 1) + " ret:" + j + ", len:" + t.a(t.this).length + ", rLen:" + n + ", rHeight:" + i1 + ", rWidth:" + i2 + ", rMid:" + i3 + ", drawCnt:" + t.c(t.this) + ", format:0");
                    }
                    if ((j <= 0) || (n <= 0) || (i1 <= 0) || (i2 <= 0)) {
                      break label356;
                    }
                    if (i3 >= 0)
                    {
                      localObject = t.d(t.this).KX(i3);
                      final int[] arrayOfInt = v.X(t.a(t.this), n);
                      ae.d("MicroMsg.Multitalk.ILinkVideoMgr", "handleIdleObj get username: %s", new Object[] { localObject });
                      if (localObject != null) {
                        ar.f(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(190714);
                            z.dtK().dte().a(this.wpu, arrayOfInt, i2, i1, 0, OpenGlRender.FLAG_Angle90);
                            AppMethodBeat.o(190714);
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
                  AppMethodBeat.o(190715);
                  return;
                }
              }
              catch (Exception localException)
              {
                ae.printErrStackTrace("MicroMsg.Multitalk.ILinkVideoMgr", localException, "timer task crash", new Object[0]);
                AppMethodBeat.o(190715);
                return;
              }
              k -= 1;
              break;
              label356:
              int j = i;
            }
          }
        }, 0L, 20L);
        if (this.wpp != null)
        {
          this.wpp.cancel();
          this.wpp = null;
        }
        this.wpp = new Timer();
        this.wpp.schedule(new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(190718);
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
                    Object localObject = p.wmO;
                    j = p.W(t.e(t.this), 128);
                    int n = m.cbn().field_remoteScreenImgLength;
                    final int i1 = m.cbn().field_remoteScreenImgHeight;
                    final int i2 = m.cbn().field_remoteScreenImgWidth;
                    int i3 = m.cbn().field_remoteScreenImgMember;
                    if (t.f(t.this) % 100 == 0) {
                      ae.d("MicroMsg.Multitalk.ILinkVideoMgr", "GetScreen, mark:" + (i - 1) + " ret:" + j + ", len:" + t.e(t.this).length + ", rLen:" + n + ", rHeight:" + i1 + ", rWidth:" + i2 + ", rMid:" + i3 + ", drawCnt:" + t.g(t.this) + ", format:128");
                    }
                    if ((j <= 0) || (n <= 0)) {
                      break label430;
                    }
                    if (i3 >= 0)
                    {
                      localObject = t.d(t.this).KX(i3);
                      ae.d("MicroMsg.Multitalk.ILinkVideoMgr", "GetScreen handleIdleObj get username: %s, position: %d", new Object[] { localObject, Integer.valueOf(0) });
                      if ((j != 1) || (i2 != 0) || (i1 >= 3)) {
                        break label435;
                      }
                      j = 1;
                      if (localObject != null)
                      {
                        if (j != 0)
                        {
                          locald = d.wxl;
                          d.Lt(2);
                          ae.d("MicroMsg.Multitalk.ILinkVideoMgr", "receive screen frame using HW decode");
                          ar.f(new Runnable()
                          {
                            public final void run()
                            {
                              AppMethodBeat.i(190716);
                              z.dtK().dte().a(this.wpu, t.e(t.this), i1, OpenGlRender.FLAG_Angle90);
                              AppMethodBeat.o(190716);
                            }
                          });
                          j = i;
                          k = 1;
                          continue;
                        }
                        ae.d("MicroMsg.Multitalk.ILinkVideoMgr", "receive screen frame using SW decode");
                        d locald = d.wxl;
                        d.Lt(1);
                        ar.f(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(190717);
                            z.dtK().dte().a(this.wpu, this.qke, i2, i1, OpenGlRender.FLAG_Angle90);
                            AppMethodBeat.o(190717);
                          }
                        });
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
                  AppMethodBeat.o(190718);
                  return;
                }
              }
              catch (Exception localException)
              {
                ae.printErrStackTrace("MicroMsg.Multitalk.ILinkVideoMgr", localException, "timer task crash", new Object[0]);
                AppMethodBeat.o(190718);
                return;
              }
              m -= 1;
              break;
              label430:
              int j = i;
              continue;
              label435:
              j = 0;
            }
          }
        }, 0L, 20L);
        AppMethodBeat.o(190720);
        return true;
      }
      finally
      {
        AppMethodBeat.o(190720);
      }
      return false;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.Multitalk.ILinkVideoMgr", "startPlay error:" + localException.toString());
      AppMethodBeat.o(190720);
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
    //   0: ldc 189
    //   2: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 100
    //   7: ldc 190
    //   9: invokestatic 107	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 76	com/tencent/mm/plugin/multitalk/b/t:mStarted	Z
    //   18: ifne +11 -> 29
    //   21: aload_0
    //   22: monitorexit
    //   23: ldc 189
    //   25: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: return
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield 76	com/tencent/mm/plugin/multitalk/b/t:mStarted	Z
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_0
    //   37: invokespecial 192	com/tencent/mm/plugin/multitalk/b/t:stopTimer	()V
    //   40: aload_0
    //   41: getfield 74	com/tencent/mm/plugin/multitalk/b/t:pgc	Ljava/util/Map;
    //   44: astore_1
    //   45: aload_1
    //   46: monitorenter
    //   47: aload_0
    //   48: getfield 74	com/tencent/mm/plugin/multitalk/b/t:pgc	Ljava/util/Map;
    //   51: invokeinterface 195 1 0
    //   56: aload_1
    //   57: monitorexit
    //   58: ldc 189
    //   60: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: return
    //   64: astore_1
    //   65: ldc 100
    //   67: new 172	java/lang/StringBuilder
    //   70: dup
    //   71: ldc 197
    //   73: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   76: aload_1
    //   77: invokevirtual 181	java/lang/Exception:toString	()Ljava/lang/String;
    //   80: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 107	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: ldc 189
    //   91: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: return
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: ldc 189
    //   100: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_1
    //   104: athrow
    //   105: astore_2
    //   106: aload_1
    //   107: monitorexit
    //   108: ldc 189
    //   110: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.t
 * JD-Core Version:    0.7.0.1
 */