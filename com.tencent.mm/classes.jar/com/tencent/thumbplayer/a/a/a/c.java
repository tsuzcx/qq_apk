package com.tencent.thumbplayer.a.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPMediaTrackInfo;
import com.tencent.thumbplayer.core.subtitle.ITPSubtitleParserCallback;
import com.tencent.thumbplayer.core.subtitle.TPSubtitleParser;
import com.tencent.thumbplayer.utils.g;
import com.tencent.thumbplayer.utils.j;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class c
  implements a
{
  a.a Zze;
  a.b Zzf;
  TPSubtitleParser Zzg;
  String Zzh;
  private Future<?> Zzi;
  private final Object Zzj;
  private c.a Zzk;
  
  public c()
  {
    AppMethodBeat.i(218958);
    this.Zzi = null;
    this.Zzj = new Object();
    this.Zzk = c.a.Zzm;
    AppMethodBeat.o(218958);
  }
  
  public final void a(a.a parama)
  {
    this.Zze = parama;
  }
  
  public final void a(a.b paramb)
  {
    this.Zzf = paramb;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(218962);
    if (this.Zzk != c.a.Zzn)
    {
      g.e("TPSysPlayerExternalSubtitle", "prepare, illegalState, state:" + this.Zzk);
      AppMethodBeat.o(218962);
      return;
    }
    g.i("TPSysPlayerExternalSubtitle", "prepare.");
    this.Zzg.init();
    ??? = this.Zzg.getTrackInfo();
    if ((??? == null) || (???.length <= 0))
    {
      g.w("TPSysPlayerExternalSubtitle", "prepare, err, trackInfos is empty.");
      this.Zzk = c.a.Zzq;
      AppMethodBeat.o(218962);
      return;
    }
    if (???[0].trackType != 3)
    {
      this.Zzk = c.a.Zzq;
      g.w("TPSysPlayerExternalSubtitle", "prepare, err, track type not match.");
      AppMethodBeat.o(218962);
      return;
    }
    long l = System.currentTimeMillis();
    this.Zzg.selectTrackAsync(0, l);
    this.Zzk = c.a.Zzo;
    synchronized (this.Zzj)
    {
      if (this.Zzi != null)
      {
        this.Zzi.cancel(true);
        this.Zzi = null;
      }
      this.Zzi = j.getScheduledExecutorServiceInstance().scheduleAtFixedRate(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(218953);
          c localc = c.this;
          Object localObject = localc.Zzf;
          a.a locala = localc.Zze;
          if ((localObject == null) || (locala == null))
          {
            g.w("TPSysPlayerExternalSubtitle", "subPollFunc, posLis:" + localObject + ", subLis:" + locala);
            AppMethodBeat.o(218953);
            return;
          }
          long l = ((a.b)localObject).getCurrentPosition();
          if (l < 0L)
          {
            g.w("TPSysPlayerExternalSubtitle", "subPollFunc, cur position:".concat(String.valueOf(l)));
            AppMethodBeat.o(218953);
            return;
          }
          localObject = localc.Zzg.getSubtitleText(l, 0);
          if (!TextUtils.equals(localc.Zzh, (CharSequence)localObject))
          {
            localc.Zzh = ((String)localObject);
            locala.a(new a.c((String)localObject));
          }
          AppMethodBeat.o(218953);
        }
      }, 0L, 200L, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(218962);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(218972);
    g.i("TPSysPlayerExternalSubtitle", "release.");
    this.Zzf = null;
    this.Zze = null;
    AppMethodBeat.o(218972);
  }
  
  /* Error */
  public final void reset()
  {
    // Byte code:
    //   0: ldc 167
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 47	com/tencent/thumbplayer/a/a/a/c:Zzk	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   9: getstatic 45	com/tencent/thumbplayer/a/a/a/c$a:Zzm	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   12: if_acmpeq +22 -> 34
    //   15: aload_0
    //   16: getfield 92	com/tencent/thumbplayer/a/a/a/c:Zzg	Lcom/tencent/thumbplayer/core/subtitle/TPSubtitleParser;
    //   19: ifnull +10 -> 29
    //   22: aload_0
    //   23: getfield 92	com/tencent/thumbplayer/a/a/a/c:Zzg	Lcom/tencent/thumbplayer/core/subtitle/TPSubtitleParser;
    //   26: invokevirtual 170	com/tencent/thumbplayer/core/subtitle/TPSubtitleParser:unInit	()V
    //   29: aload_0
    //   30: aconst_null
    //   31: putfield 92	com/tencent/thumbplayer/a/a/a/c:Zzg	Lcom/tencent/thumbplayer/core/subtitle/TPSubtitleParser;
    //   34: aload_0
    //   35: getfield 42	com/tencent/thumbplayer/a/a/a/c:Zzj	Ljava/lang/Object;
    //   38: astore_1
    //   39: aload_1
    //   40: monitorenter
    //   41: aload_0
    //   42: getfield 40	com/tencent/thumbplayer/a/a/a/c:Zzi	Ljava/util/concurrent/Future;
    //   45: ifnull +19 -> 64
    //   48: aload_0
    //   49: getfield 40	com/tencent/thumbplayer/a/a/a/c:Zzi	Ljava/util/concurrent/Future;
    //   52: iconst_1
    //   53: invokeinterface 136 2 0
    //   58: pop
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 40	com/tencent/thumbplayer/a/a/a/c:Zzi	Ljava/util/concurrent/Future;
    //   64: aload_1
    //   65: monitorexit
    //   66: aload_0
    //   67: getstatic 45	com/tencent/thumbplayer/a/a/a/c$a:Zzm	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   70: putfield 47	com/tencent/thumbplayer/a/a/a/c:Zzk	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   73: ldc 167
    //   75: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: return
    //   79: astore_1
    //   80: ldc 65
    //   82: aload_1
    //   83: invokestatic 173	com/tencent/thumbplayer/utils/g:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   86: goto -57 -> 29
    //   89: astore_2
    //   90: aload_1
    //   91: monitorexit
    //   92: ldc 167
    //   94: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_2
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	c
    //   79	12	1	localException	Exception
    //   89	9	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   22	29	79	java/lang/Exception
    //   41	64	89	finally
    //   64	66	89	finally
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(218961);
    if (this.Zzk != c.a.Zzm)
    {
      g.e("TPSysPlayerExternalSubtitle", "setDataSource, illegalState, state:" + this.Zzk);
      AppMethodBeat.o(218961);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      g.e("TPSysPlayerExternalSubtitle", "setDataSource, illegal argument, url:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(218961);
      return;
    }
    g.i("TPSysPlayerExternalSubtitle", "setDataSource, url: ".concat(String.valueOf(paramString)));
    if (this.Zzg != null) {
      g.w("TPSysPlayerExternalSubtitle", "setDataSource, mTpSubParser != null.");
    }
    try
    {
      this.Zzg.unInit();
      label107:
      this.Zzg = null;
      this.Zzg = new TPSubtitleParser(paramString, new ITPSubtitleParserCallback()
      {
        public final void onLoadResult(int paramAnonymousInt)
        {
          AppMethodBeat.i(218948);
          g.i("TPSysPlayerExternalSubtitle", "onLoadResult, index:".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(218948);
        }
        
        public final void onSelectResult(int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(218950);
          g.i("TPSysPlayerExternalSubtitle", "onSelectResult, index:" + paramAnonymousInt + ", long:" + paramAnonymousLong);
          AppMethodBeat.o(218950);
        }
      });
      this.Zzk = c.a.Zzn;
      AppMethodBeat.o(218961);
      return;
    }
    catch (Exception localException)
    {
      break label107;
    }
  }
  
  /* Error */
  public final void stop()
  {
    // Byte code:
    //   0: ldc 205
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 65
    //   7: ldc 207
    //   9: invokestatic 90	com/tencent/thumbplayer/utils/g:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 47	com/tencent/thumbplayer/a/a/a/c:Zzk	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   16: getstatic 63	com/tencent/thumbplayer/a/a/a/c$a:Zzn	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   19: if_acmpeq +23 -> 42
    //   22: aload_0
    //   23: getfield 47	com/tencent/thumbplayer/a/a/a/c:Zzk	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   26: getstatic 130	com/tencent/thumbplayer/a/a/a/c$a:Zzo	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   29: if_acmpeq +13 -> 42
    //   32: aload_0
    //   33: getfield 47	com/tencent/thumbplayer/a/a/a/c:Zzk	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   36: getstatic 109	com/tencent/thumbplayer/a/a/a/c$a:Zzq	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   39: if_acmpne +22 -> 61
    //   42: aload_0
    //   43: getfield 92	com/tencent/thumbplayer/a/a/a/c:Zzg	Lcom/tencent/thumbplayer/core/subtitle/TPSubtitleParser;
    //   46: ifnull +10 -> 56
    //   49: aload_0
    //   50: getfield 92	com/tencent/thumbplayer/a/a/a/c:Zzg	Lcom/tencent/thumbplayer/core/subtitle/TPSubtitleParser;
    //   53: invokevirtual 170	com/tencent/thumbplayer/core/subtitle/TPSubtitleParser:unInit	()V
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 92	com/tencent/thumbplayer/a/a/a/c:Zzg	Lcom/tencent/thumbplayer/core/subtitle/TPSubtitleParser;
    //   61: aload_0
    //   62: getfield 42	com/tencent/thumbplayer/a/a/a/c:Zzj	Ljava/lang/Object;
    //   65: astore_1
    //   66: aload_1
    //   67: monitorenter
    //   68: aload_0
    //   69: getfield 40	com/tencent/thumbplayer/a/a/a/c:Zzi	Ljava/util/concurrent/Future;
    //   72: ifnull +19 -> 91
    //   75: aload_0
    //   76: getfield 40	com/tencent/thumbplayer/a/a/a/c:Zzi	Ljava/util/concurrent/Future;
    //   79: iconst_1
    //   80: invokeinterface 136 2 0
    //   85: pop
    //   86: aload_0
    //   87: aconst_null
    //   88: putfield 40	com/tencent/thumbplayer/a/a/a/c:Zzi	Ljava/util/concurrent/Future;
    //   91: aload_1
    //   92: monitorexit
    //   93: aload_0
    //   94: getstatic 210	com/tencent/thumbplayer/a/a/a/c$a:Zzp	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   97: putfield 47	com/tencent/thumbplayer/a/a/a/c:Zzk	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   100: ldc 205
    //   102: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: return
    //   106: astore_1
    //   107: ldc 65
    //   109: aload_1
    //   110: invokestatic 173	com/tencent/thumbplayer/utils/g:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   113: goto -57 -> 56
    //   116: astore_2
    //   117: aload_1
    //   118: monitorexit
    //   119: ldc 205
    //   121: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: aload_2
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	c
    //   106	12	1	localException	Exception
    //   116	9	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   49	56	106	java/lang/Exception
    //   68	91	116	finally
    //   91	93	116	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */