package com.tencent.mm.plugin.multitalk.b;

import android.os.HandlerThread;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitalk.model.af;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.wxmm.v2conference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TimerTask;

public final class s
{
  public static int tTY = 14745600;
  private j FmD;
  private int FpT;
  private com.tencent.e.i.d<?> FpU;
  private com.tencent.e.i.d<?> FpV;
  private boolean mStarted;
  private HandlerThread mThread;
  private int tTT;
  private final Map<String, Object> tUa;
  private int tUd;
  
  public s(j paramj)
  {
    AppMethodBeat.i(197060);
    this.FmD = null;
    this.mThread = null;
    this.FpT = 0;
    this.tTT = 0;
    this.tUd = 0;
    this.FpU = null;
    this.FpV = null;
    this.tUa = new HashMap();
    this.mStarted = false;
    this.FmD = paramj;
    AppMethodBeat.o(197060);
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(197086);
    if (this.FpU != null)
    {
      this.FpU.cancel(false);
      this.FpU = null;
    }
    if (this.FpV != null)
    {
      this.FpV.cancel(false);
      this.FpV = null;
    }
    AppMethodBeat.o(197086);
  }
  
  final void b(adi arg1)
  {
    AppMethodBeat.i(197082);
    Log.e("MicroMsg.Multitalk.ILinkVideoMgr", "updateMembers");
    if ((??? == null) || (???.RIQ == null) || (???.RIQ.size() == 0))
    {
      AppMethodBeat.o(197082);
      return;
    }
    Object localObject1 = ???.RIQ;
    synchronized (this.tUa)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        adh localadh = (adh)((Iterator)localObject1).next();
        this.tUa.get(localadh.openid);
      }
    }
    AppMethodBeat.o(197082);
  }
  
  public final boolean cNM()
  {
    AppMethodBeat.i(197067);
    Log.e("MicroMsg.Multitalk.ILinkVideoMgr", "startPlay");
    try
    {
      try
      {
        if (this.mStarted) {
          return false;
        }
        this.mStarted = true;
        if (this.FpU != null)
        {
          this.FpU.cancel(false);
          this.FpU = null;
        }
        final byte[] arrayOfByte = new byte[tTY];
        this.FpU = h.ZvG.b(new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(199715);
            int k = 8;
            if (k > 0) {}
            for (;;)
            {
              int i;
              try
              {
                if (s.this.isStarted())
                {
                  j = 0;
                  int m = 0;
                  i = (byte)(j + 1);
                  if (j < 2)
                  {
                    arrayOfByte[0] = i;
                    Object localObject = o.Fne;
                    j = o.U(arrayOfByte, 0);
                    int n = l.cNC().field_remoteImgLength;
                    final int i1 = l.cNC().field_remoteImgHeight;
                    final int i2 = l.cNC().field_remoteImgWidth;
                    int i3 = l.cNC().field_remoteImgMember;
                    if (s.a(s.this) % 100 == 0) {
                      Log.d("MicroMsg.Multitalk.ILinkVideoMgr", "GetVideo, mark:" + (i - 1) + " ret:" + j + ", len:" + arrayOfByte.length + ", rLen:" + n + ", rHeight:" + i1 + ", rWidth:" + i2 + ", rMid:" + i3 + ", drawCnt:" + s.b(s.this) + ", format:0");
                    }
                    if ((j <= 0) || (n <= 0) || (i1 <= 0) || (i2 <= 0)) {
                      break label344;
                    }
                    if (i3 >= 0)
                    {
                      localObject = s.c(s.this).Xl(i3);
                      final int[] arrayOfInt = u.aa(arrayOfByte, n);
                      Log.d("MicroMsg.Multitalk.ILinkVideoMgr", "handleIdleObj get username: %s", new Object[] { localObject });
                      if (localObject != null) {
                        MMHandlerThread.postToMainThread(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(195979);
                            ad.eYc().eXp().a(this.FpX, arrayOfInt, i2, i1, 0, OpenGlRender.FLAG_Angle90);
                            AppMethodBeat.o(195979);
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
                  AppMethodBeat.o(199715);
                  return;
                }
              }
              catch (Exception localException)
              {
                Log.printErrStackTrace("MicroMsg.Multitalk.ILinkVideoMgr", localException, "timer task crash", new Object[0]);
                AppMethodBeat.o(199715);
                return;
              }
              k -= 1;
              break;
              label344:
              int j = i;
            }
          }
        }, 0L, 20L);
        if (this.FpV != null)
        {
          this.FpV.cancel(false);
          this.FpV = null;
        }
        arrayOfByte = new byte[tTY];
        this.FpV = h.ZvG.b(new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(200024);
            int n = 8;
            if (n > 0) {}
            for (;;)
            {
              int k;
              int i;
              int i6;
              int m;
              try
              {
                if (s.this.isStarted())
                {
                  k = 0;
                  j = 0;
                  i = (byte)(j + 1);
                  if (j < 2)
                  {
                    arrayOfByte[0] = i;
                    Object localObject1 = o.Fne;
                    int i5 = o.U(arrayOfByte, 128);
                    int i1 = l.cNC().field_remoteScreenImgLength;
                    final int i2 = l.cNC().field_remoteScreenImgHeight;
                    final int i3 = l.cNC().field_remoteScreenImgWidth;
                    int i4 = l.cNC().field_remoteScreenImgMember;
                    i6 = l.cNC().field_remoteScreenImgFormat;
                    m = 1;
                    j = 1;
                    if ((i6 & 0x100) == 0)
                    {
                      if ((i6 & 0x200) == 0) {
                        break label589;
                      }
                      m = 2;
                      break label589;
                    }
                    if (s.d(s.this) % 100 == 0) {
                      Log.d("MicroMsg.Multitalk.ILinkVideoMgr", "GetScreen, mark:" + (i - 1) + " ret:" + i5 + ", len:" + arrayOfByte.length + ", rLen:" + i1 + ", rHeight:" + i2 + ", rWidth:" + i3 + ", rMid:" + i4 + ", drawCnt:" + s.e(s.this) + ", format:128");
                    }
                    if ((i5 <= 0) || (i1 <= 0)) {
                      break label584;
                    }
                    if (i4 >= 0)
                    {
                      localObject1 = s.c(s.this).Xl(i4);
                      Log.i("MicroMsg.Multitalk.ILinkVideoMgr", "yuemwang: nGetVideoData mid : " + i4 + " user: " + (String)localObject1 + "  size:" + i3 + "x" + i2);
                      Log.d("MicroMsg.Multitalk.ILinkVideoMgr", "GetScreen handleIdleObj get username: %s, position: %d", new Object[] { localObject1, Integer.valueOf(0) });
                      if ((i5 != 1) || (i3 != 0) || (i2 >= 3)) {
                        break label609;
                      }
                      k = 1;
                      if (localObject1 != null)
                      {
                        Object localObject2;
                        if (k != 0)
                        {
                          localObject2 = com.tencent.mm.plugin.multitalk.d.d.FEN;
                          com.tencent.mm.plugin.multitalk.d.d.XS(2);
                          Log.d("MicroMsg.Multitalk.ILinkVideoMgr", "receive screen frame using HW decode");
                          MMHandlerThread.postToMainThread(new Runnable()
                          {
                            public final void run()
                            {
                              AppMethodBeat.i(197767);
                              ad.eYc().eXp().a(this.FpX, s.2.this.GWz, i2, j);
                              AppMethodBeat.o(197767);
                            }
                          });
                          j = i;
                          k = 1;
                          continue;
                        }
                        Log.d("MicroMsg.Multitalk.ILinkVideoMgr", "receive screen frame using SW decode");
                        if (i3 > 480)
                        {
                          localObject2 = com.tencent.mm.plugin.multitalk.d.d.FEN;
                          com.tencent.mm.plugin.multitalk.d.d.XS(1);
                          MMHandlerThread.postToMainThread(new Runnable()
                          {
                            public final void run()
                            {
                              AppMethodBeat.i(199515);
                              ad.eYc().eXp().a(this.FpX, this.vgG, i3, i2, j);
                              AppMethodBeat.o(199515);
                            }
                          });
                          j = i;
                          k = 1;
                          continue;
                        }
                        if (i4 >= 0)
                        {
                          localObject2 = u.aa(arrayOfByte, i1);
                          Log.d("MicroMsg.Multitalk.ILinkVideoMgr", "handleIdleObj get username: %s", new Object[] { localObject1 });
                          if (localObject1 != null) {
                            MMHandlerThread.postToMainThread(new Runnable()
                            {
                              public final void run()
                              {
                                AppMethodBeat.i(200075);
                                ad.eYc().eXp().a(this.FpX, this.vgG, i3, i2, 0, OpenGlRender.FLAG_Angle90);
                                AppMethodBeat.o(200075);
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
                  AppMethodBeat.o(200024);
                  return;
                }
              }
              catch (Exception localException)
              {
                Log.printErrStackTrace("MicroMsg.Multitalk.ILinkVideoMgr", localException, "timer task crash", new Object[0]);
                AppMethodBeat.o(200024);
                return;
              }
              n -= 1;
              break;
              label584:
              final int j = i;
              continue;
              label589:
              j = m;
              if ((i6 & 0x400) != 0)
              {
                j = m + 2;
                continue;
                label609:
                k = 0;
              }
            }
          }
        }, 0L, 20L);
        AppMethodBeat.o(197067);
        return true;
      }
      finally
      {
        AppMethodBeat.o(197067);
      }
      return false;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Multitalk.ILinkVideoMgr", "startPlay error:" + localException.toString());
      AppMethodBeat.o(197067);
    }
  }
  
  public final boolean isStarted()
  {
    try
    {
      boolean bool = this.mStarted;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void release()
  {
    // Byte code:
    //   0: ldc 181
    //   2: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 94
    //   7: ldc 182
    //   9: invokestatic 101	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 72	com/tencent/mm/plugin/multitalk/b/s:mStarted	Z
    //   18: ifne +11 -> 29
    //   21: aload_0
    //   22: monitorexit
    //   23: ldc 181
    //   25: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: return
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield 72	com/tencent/mm/plugin/multitalk/b/s:mStarted	Z
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_0
    //   37: invokespecial 184	com/tencent/mm/plugin/multitalk/b/s:stopTimer	()V
    //   40: aload_0
    //   41: getfield 70	com/tencent/mm/plugin/multitalk/b/s:tUa	Ljava/util/Map;
    //   44: astore_1
    //   45: aload_1
    //   46: monitorenter
    //   47: aload_0
    //   48: getfield 70	com/tencent/mm/plugin/multitalk/b/s:tUa	Ljava/util/Map;
    //   51: invokeinterface 187 1 0
    //   56: aload_1
    //   57: monitorexit
    //   58: ldc 181
    //   60: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: return
    //   64: astore_1
    //   65: ldc 94
    //   67: new 164	java/lang/StringBuilder
    //   70: dup
    //   71: ldc 189
    //   73: invokespecial 169	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   76: aload_1
    //   77: invokevirtual 173	java/lang/Exception:toString	()Ljava/lang/String;
    //   80: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 101	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: ldc 181
    //   91: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: return
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: ldc 181
    //   100: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_1
    //   104: athrow
    //   105: astore_2
    //   106: aload_1
    //   107: monitorexit
    //   108: ldc 181
    //   110: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_2
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	s
    //   64	13	1	localException	Exception
    //   95	12	1	localObject1	Object
    //   105	9	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	14	64	java/lang/Exception
    //   36	47	64	java/lang/Exception
    //   58	63	64	java/lang/Exception
    //   96	105	64	java/lang/Exception
    //   106	115	64	java/lang/Exception
    //   14	23	95	finally
    //   29	36	95	finally
    //   47	58	105	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.s
 * JD-Core Version:    0.7.0.1
 */