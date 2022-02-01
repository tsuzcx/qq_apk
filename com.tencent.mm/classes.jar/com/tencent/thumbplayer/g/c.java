package com.tencent.thumbplayer.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.b.a;
import com.tencent.thumbplayer.b.b.a;
import com.tencent.thumbplayer.b.b.b;
import com.tencent.thumbplayer.b.b.c;
import com.tencent.thumbplayer.b.b.d;
import com.tencent.thumbplayer.b.b.e;
import com.tencent.thumbplayer.b.b.f;
import com.tencent.thumbplayer.b.b.g;
import com.tencent.thumbplayer.b.b.h;
import com.tencent.thumbplayer.b.b.i;
import com.tencent.thumbplayer.b.b.j;
import com.tencent.thumbplayer.b.b.k;
import com.tencent.thumbplayer.b.m;
import com.tencent.thumbplayer.b.o;
import com.tencent.thumbplayer.utils.d;

public final class c
  implements b.a, b.b, b.c, b.d, b.e, b.f, b.g, b.h, b.i, b.j, b.k
{
  private static String TAG = "TPPlayerListenerS";
  b.e MyB;
  b.b MyC;
  b.d MyD;
  b.c MyE;
  b.g MyF;
  b.k MyG;
  b.i MyH;
  b.j MyI;
  b.a MyJ;
  b.h MyK;
  b.f MyL;
  a MyM;
  
  public c(String paramString)
  {
    AppMethodBeat.i(194803);
    TAG = paramString;
    this.MyM = new a((byte)0);
    this.MyB = this.MyM;
    this.MyC = this.MyM;
    this.MyD = this.MyM;
    this.MyE = this.MyM;
    this.MyF = this.MyM;
    this.MyG = this.MyM;
    this.MyH = this.MyM;
    this.MyI = this.MyM;
    this.MyJ = this.MyM;
    this.MyK = this.MyM;
    this.MyL = this.MyM;
    AppMethodBeat.o(194803);
  }
  
  public final int a(a parama, long paramLong, String paramString)
  {
    AppMethodBeat.i(194816);
    int i = this.MyL.a(parama, paramLong, paramString);
    AppMethodBeat.o(194816);
    return i;
  }
  
  public final int a(a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(194814);
    int i = this.MyL.a(parama, paramLong1, paramString, paramLong2, paramLong3);
    AppMethodBeat.o(194814);
    return i;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(194804);
    this.MyB.a(parama);
    AppMethodBeat.o(194804);
  }
  
  public final void a(a parama, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194807);
    this.MyE.a(parama, paramInt1, paramInt2, paramLong1, paramLong2);
    AppMethodBeat.o(194807);
  }
  
  public final void a(a parama, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(194806);
    this.MyD.a(parama, paramInt, paramLong1, paramLong2, paramObject);
    AppMethodBeat.o(194806);
  }
  
  public final void a(a parama, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194809);
    this.MyG.a(parama, paramLong1, paramLong2);
    AppMethodBeat.o(194809);
  }
  
  public final void a(a parama, com.tencent.thumbplayer.b.c paramc)
  {
    AppMethodBeat.i(194812);
    this.MyJ.a(parama, paramc);
    AppMethodBeat.o(194812);
  }
  
  public final void a(a parama, m paramm)
  {
    AppMethodBeat.i(194810);
    this.MyH.a(parama, paramm);
    AppMethodBeat.o(194810);
  }
  
  public final void a(a parama, o paramo)
  {
    AppMethodBeat.i(194811);
    this.MyI.a(parama, paramo);
    AppMethodBeat.o(194811);
  }
  
  public final int b(a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(194815);
    int i = this.MyL.b(parama, paramLong1, paramString, paramLong2, paramLong3);
    AppMethodBeat.o(194815);
    return i;
  }
  
  public final long b(a parama, long paramLong, String paramString)
  {
    AppMethodBeat.i(194817);
    paramLong = this.MyL.b(parama, paramLong, paramString);
    AppMethodBeat.o(194817);
    return paramLong;
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(194805);
    this.MyC.b(parama);
    AppMethodBeat.o(194805);
  }
  
  public final String c(a parama, long paramLong, String paramString)
  {
    AppMethodBeat.i(194818);
    parama = this.MyL.c(parama, paramLong, paramString);
    AppMethodBeat.o(194818);
    return parama;
  }
  
  public final void c(a parama)
  {
    AppMethodBeat.i(194808);
    this.MyF.c(parama);
    AppMethodBeat.o(194808);
  }
  
  public final String d(a parama, long paramLong, String paramString)
  {
    AppMethodBeat.i(194819);
    parama = this.MyL.d(parama, paramLong, paramString);
    AppMethodBeat.o(194819);
    return parama;
  }
  
  public final void fW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194813);
    this.MyK.fW(paramInt1, paramInt2);
    AppMethodBeat.o(194813);
  }
  
  static final class a
    implements b.a, b.b, b.c, b.d, b.e, b.f, b.g, b.h, b.i, b.j, b.k
  {
    public final int a(a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(194799);
      d.i(c.TAG, " empty player listener , notify , onStopReadData");
      AppMethodBeat.o(194799);
      return 0;
    }
    
    public final int a(a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(194797);
      d.i(c.TAG, " empty player listener , notify , onStartReadData");
      AppMethodBeat.o(194797);
      return 0;
    }
    
    public final void a(a parama)
    {
      AppMethodBeat.i(194787);
      d.i(c.TAG, " empty player listener , notify , onPrepared");
      AppMethodBeat.o(194787);
    }
    
    public final void a(a parama, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(194790);
      d.i(c.TAG, " empty player listener , notify , onError");
      AppMethodBeat.o(194790);
    }
    
    public final void a(a parama, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(194789);
      d.i(c.TAG, " empty player listener , notify , onInfo");
      AppMethodBeat.o(194789);
    }
    
    public final void a(a parama, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(194792);
      d.i(c.TAG, " empty player listener , notify , onVideoSizeChanged");
      AppMethodBeat.o(194792);
    }
    
    public final void a(a parama, com.tencent.thumbplayer.b.c paramc)
    {
      AppMethodBeat.i(194795);
      d.i(c.TAG, " empty player listener , notify , onAudioFrameOut");
      AppMethodBeat.o(194795);
    }
    
    public final void a(a parama, m paramm)
    {
      AppMethodBeat.i(194793);
      d.i(c.TAG, " empty player listener , notify , onSubtitleData");
      AppMethodBeat.o(194793);
    }
    
    public final void a(a parama, o paramo)
    {
      AppMethodBeat.i(194794);
      d.i(c.TAG, " empty player listener , notify , onVideoFrameOut");
      AppMethodBeat.o(194794);
    }
    
    public final int b(a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(194798);
      d.i(c.TAG, " empty player listener , notify , onReadData");
      AppMethodBeat.o(194798);
      return 0;
    }
    
    public final long b(a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(194800);
      d.i(c.TAG, " empty player listener , notify , getDataTotalSize");
      AppMethodBeat.o(194800);
      return 0L;
    }
    
    public final void b(a parama)
    {
      AppMethodBeat.i(194788);
      d.i(c.TAG, " empty player listener , notify , onCompletion");
      AppMethodBeat.o(194788);
    }
    
    public final String c(a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(194801);
      d.i(c.TAG, " empty player listener , notify , getDataFilePath");
      AppMethodBeat.o(194801);
      return "";
    }
    
    public final void c(a parama)
    {
      AppMethodBeat.i(194791);
      d.i(c.TAG, " empty player listener , notify , onSeekComplete");
      AppMethodBeat.o(194791);
    }
    
    public final String d(a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(194802);
      d.i(c.TAG, " empty player listener , notify , getContentType");
      AppMethodBeat.o(194802);
      return "";
    }
    
    public final void fW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(194796);
      d.i(c.TAG, " empty player listener , notify , onStateChange");
      AppMethodBeat.o(194796);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.g.c
 * JD-Core Version:    0.7.0.1
 */