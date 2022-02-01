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
  a.a ahEg;
  a.b ahEh;
  TPSubtitleParser ahEi;
  String ahEj;
  private Future<?> ahEk;
  private final Object ahEl;
  private a ahEm;
  
  public c()
  {
    AppMethodBeat.i(228623);
    this.ahEk = null;
    this.ahEl = new Object();
    this.ahEm = a.ahEo;
    AppMethodBeat.o(228623);
  }
  
  public final void a(a.a parama)
  {
    this.ahEg = parama;
  }
  
  public final void a(a.b paramb)
  {
    this.ahEh = paramb;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(228648);
    if (this.ahEm != a.ahEp)
    {
      g.e("TPSysPlayerExternalSubtitle", "prepare, illegalState, state:" + this.ahEm);
      AppMethodBeat.o(228648);
      return;
    }
    g.i("TPSysPlayerExternalSubtitle", "prepare.");
    this.ahEi.init();
    ??? = this.ahEi.getTrackInfo();
    if ((??? == null) || (???.length <= 0))
    {
      g.w("TPSysPlayerExternalSubtitle", "prepare, err, trackInfos is empty.");
      this.ahEm = a.ahEs;
      AppMethodBeat.o(228648);
      return;
    }
    if (???[0].trackType != 3)
    {
      this.ahEm = a.ahEs;
      g.w("TPSysPlayerExternalSubtitle", "prepare, err, track type not match.");
      AppMethodBeat.o(228648);
      return;
    }
    long l = System.currentTimeMillis();
    this.ahEi.selectTrackAsync(0, l);
    this.ahEm = a.ahEq;
    synchronized (this.ahEl)
    {
      if (this.ahEk != null)
      {
        this.ahEk.cancel(true);
        this.ahEk = null;
      }
      this.ahEk = j.getScheduledExecutorServiceInstance().scheduleAtFixedRate(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(228594);
          c localc = c.this;
          Object localObject = localc.ahEh;
          a.a locala = localc.ahEg;
          if ((localObject == null) || (locala == null))
          {
            g.w("TPSysPlayerExternalSubtitle", "subPollFunc, posLis:" + localObject + ", subLis:" + locala);
            AppMethodBeat.o(228594);
            return;
          }
          long l = ((a.b)localObject).getCurrentPosition();
          if (l < 0L)
          {
            g.w("TPSysPlayerExternalSubtitle", "subPollFunc, cur position:".concat(String.valueOf(l)));
            AppMethodBeat.o(228594);
            return;
          }
          localObject = localc.ahEi.getSubtitleText(l, 0);
          if (!TextUtils.equals(localc.ahEj, (CharSequence)localObject))
          {
            localc.ahEj = ((String)localObject);
            locala.a(new a.c((String)localObject));
          }
          AppMethodBeat.o(228594);
        }
      }, 0L, 200L, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(228648);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(228667);
    g.i("TPSysPlayerExternalSubtitle", "release.");
    this.ahEh = null;
    this.ahEg = null;
    AppMethodBeat.o(228667);
  }
  
  /* Error */
  public final void reset()
  {
    // Byte code:
    //   0: ldc 167
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 48	com/tencent/thumbplayer/a/a/a/c:ahEm	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   9: getstatic 46	com/tencent/thumbplayer/a/a/a/c$a:ahEo	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   12: if_acmpeq +22 -> 34
    //   15: aload_0
    //   16: getfield 92	com/tencent/thumbplayer/a/a/a/c:ahEi	Lcom/tencent/thumbplayer/core/subtitle/TPSubtitleParser;
    //   19: ifnull +10 -> 29
    //   22: aload_0
    //   23: getfield 92	com/tencent/thumbplayer/a/a/a/c:ahEi	Lcom/tencent/thumbplayer/core/subtitle/TPSubtitleParser;
    //   26: invokevirtual 170	com/tencent/thumbplayer/core/subtitle/TPSubtitleParser:unInit	()V
    //   29: aload_0
    //   30: aconst_null
    //   31: putfield 92	com/tencent/thumbplayer/a/a/a/c:ahEi	Lcom/tencent/thumbplayer/core/subtitle/TPSubtitleParser;
    //   34: aload_0
    //   35: getfield 43	com/tencent/thumbplayer/a/a/a/c:ahEl	Ljava/lang/Object;
    //   38: astore_1
    //   39: aload_1
    //   40: monitorenter
    //   41: aload_0
    //   42: getfield 41	com/tencent/thumbplayer/a/a/a/c:ahEk	Ljava/util/concurrent/Future;
    //   45: ifnull +19 -> 64
    //   48: aload_0
    //   49: getfield 41	com/tencent/thumbplayer/a/a/a/c:ahEk	Ljava/util/concurrent/Future;
    //   52: iconst_1
    //   53: invokeinterface 136 2 0
    //   58: pop
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 41	com/tencent/thumbplayer/a/a/a/c:ahEk	Ljava/util/concurrent/Future;
    //   64: aload_1
    //   65: monitorexit
    //   66: aload_0
    //   67: getstatic 46	com/tencent/thumbplayer/a/a/a/c$a:ahEo	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   70: putfield 48	com/tencent/thumbplayer/a/a/a/c:ahEm	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   73: ldc 167
    //   75: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   94: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(228639);
    if (this.ahEm != a.ahEo)
    {
      g.e("TPSysPlayerExternalSubtitle", "setDataSource, illegalState, state:" + this.ahEm);
      AppMethodBeat.o(228639);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      g.e("TPSysPlayerExternalSubtitle", "setDataSource, illegal argument, url:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(228639);
      return;
    }
    g.i("TPSysPlayerExternalSubtitle", "setDataSource, url: ".concat(String.valueOf(paramString)));
    if (this.ahEi != null) {
      g.w("TPSysPlayerExternalSubtitle", "setDataSource, mTpSubParser != null.");
    }
    try
    {
      this.ahEi.unInit();
      label107:
      this.ahEi = null;
      this.ahEi = new TPSubtitleParser(paramString, new ITPSubtitleParserCallback()
      {
        public final void onLoadResult(int paramAnonymousInt)
        {
          AppMethodBeat.i(228604);
          g.i("TPSysPlayerExternalSubtitle", "onLoadResult, index:".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(228604);
        }
        
        public final void onSelectResult(int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(228612);
          g.i("TPSysPlayerExternalSubtitle", "onSelectResult, index:" + paramAnonymousInt + ", long:" + paramAnonymousLong);
          AppMethodBeat.o(228612);
        }
      });
      this.ahEm = a.ahEp;
      AppMethodBeat.o(228639);
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
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 65
    //   7: ldc 207
    //   9: invokestatic 90	com/tencent/thumbplayer/utils/g:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 48	com/tencent/thumbplayer/a/a/a/c:ahEm	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   16: getstatic 63	com/tencent/thumbplayer/a/a/a/c$a:ahEp	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   19: if_acmpeq +23 -> 42
    //   22: aload_0
    //   23: getfield 48	com/tencent/thumbplayer/a/a/a/c:ahEm	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   26: getstatic 130	com/tencent/thumbplayer/a/a/a/c$a:ahEq	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   29: if_acmpeq +13 -> 42
    //   32: aload_0
    //   33: getfield 48	com/tencent/thumbplayer/a/a/a/c:ahEm	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   36: getstatic 109	com/tencent/thumbplayer/a/a/a/c$a:ahEs	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   39: if_acmpne +22 -> 61
    //   42: aload_0
    //   43: getfield 92	com/tencent/thumbplayer/a/a/a/c:ahEi	Lcom/tencent/thumbplayer/core/subtitle/TPSubtitleParser;
    //   46: ifnull +10 -> 56
    //   49: aload_0
    //   50: getfield 92	com/tencent/thumbplayer/a/a/a/c:ahEi	Lcom/tencent/thumbplayer/core/subtitle/TPSubtitleParser;
    //   53: invokevirtual 170	com/tencent/thumbplayer/core/subtitle/TPSubtitleParser:unInit	()V
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 92	com/tencent/thumbplayer/a/a/a/c:ahEi	Lcom/tencent/thumbplayer/core/subtitle/TPSubtitleParser;
    //   61: aload_0
    //   62: getfield 43	com/tencent/thumbplayer/a/a/a/c:ahEl	Ljava/lang/Object;
    //   65: astore_1
    //   66: aload_1
    //   67: monitorenter
    //   68: aload_0
    //   69: getfield 41	com/tencent/thumbplayer/a/a/a/c:ahEk	Ljava/util/concurrent/Future;
    //   72: ifnull +19 -> 91
    //   75: aload_0
    //   76: getfield 41	com/tencent/thumbplayer/a/a/a/c:ahEk	Ljava/util/concurrent/Future;
    //   79: iconst_1
    //   80: invokeinterface 136 2 0
    //   85: pop
    //   86: aload_0
    //   87: aconst_null
    //   88: putfield 41	com/tencent/thumbplayer/a/a/a/c:ahEk	Ljava/util/concurrent/Future;
    //   91: aload_1
    //   92: monitorexit
    //   93: aload_0
    //   94: getstatic 210	com/tencent/thumbplayer/a/a/a/c$a:ahEr	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   97: putfield 48	com/tencent/thumbplayer/a/a/a/c:ahEm	Lcom/tencent/thumbplayer/a/a/a/c$a;
    //   100: ldc 205
    //   102: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   121: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(228700);
      ahEo = new a("IDLE", 0);
      ahEp = new a("INITED", 1);
      ahEq = new a("PREPARED", 2);
      ahEr = new a("STOPED", 3);
      ahEs = new a("ERROR", 4);
      ahEt = new a[] { ahEo, ahEp, ahEq, ahEr, ahEs };
      AppMethodBeat.o(228700);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */