package com.tencent.thumbplayer.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.c.a;
import com.tencent.thumbplayer.a.a.c.b;
import com.tencent.thumbplayer.a.a.c.c;
import com.tencent.thumbplayer.a.a.c.d;
import com.tencent.thumbplayer.a.a.c.e;
import com.tencent.thumbplayer.a.a.c.f;
import com.tencent.thumbplayer.a.a.c.g;
import com.tencent.thumbplayer.a.a.c.h;
import com.tencent.thumbplayer.a.a.c.i;
import com.tencent.thumbplayer.a.a.c.j;
import com.tencent.thumbplayer.b.c;
import com.tencent.thumbplayer.b.m;
import com.tencent.thumbplayer.b.o;
import com.tencent.thumbplayer.utils.d;

public final class e
  implements c.a, c.b, c.c, c.d, c.e, c.f, c.g, c.h, c.i, c.j
{
  private static String TAG = "TPPlayerListenerS";
  public c.e MtF;
  public c.b MtG;
  public c.d MtH;
  public c.c MtI;
  public c.f MtJ;
  public c.j MtK;
  public c.h MtL;
  public c.i MtM;
  public c.a MtN;
  c.g MtO;
  private a MtP;
  
  public e(String paramString)
  {
    AppMethodBeat.i(194299);
    TAG = paramString;
    this.MtP = new a((byte)0);
    this.MtF = this.MtP;
    this.MtG = this.MtP;
    this.MtH = this.MtP;
    this.MtI = this.MtP;
    this.MtJ = this.MtP;
    this.MtK = this.MtP;
    this.MtL = this.MtP;
    this.MtM = this.MtP;
    this.MtN = this.MtP;
    AppMethodBeat.o(194299);
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194303);
    this.MtI.a(paramInt1, paramInt2, paramLong1, paramLong2);
    AppMethodBeat.o(194303);
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(194302);
    this.MtH.a(paramInt, paramLong1, paramLong2, paramObject);
    AppMethodBeat.o(194302);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(194308);
    this.MtN.a(paramc);
    AppMethodBeat.o(194308);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(194306);
    this.MtL.a(paramm);
    AppMethodBeat.o(194306);
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(194307);
    this.MtM.a(paramo);
    AppMethodBeat.o(194307);
  }
  
  public final void aC(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194305);
    this.MtK.aC(paramLong1, paramLong2);
    AppMethodBeat.o(194305);
  }
  
  public final void clF()
  {
    AppMethodBeat.i(194304);
    this.MtJ.clF();
    AppMethodBeat.o(194304);
  }
  
  public final void clear()
  {
    this.MtF = this.MtP;
    this.MtG = this.MtP;
    this.MtH = this.MtP;
    this.MtI = this.MtP;
    this.MtJ = this.MtP;
    this.MtK = this.MtP;
    this.MtL = this.MtP;
    this.MtM = this.MtP;
    this.MtN = this.MtP;
    this.MtO = this.MtP;
  }
  
  public final void fW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194309);
    this.MtO.fW(paramInt1, paramInt2);
    AppMethodBeat.o(194309);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(194301);
    this.MtG.onCompletion();
    AppMethodBeat.o(194301);
  }
  
  public final void ta()
  {
    AppMethodBeat.i(194300);
    this.MtF.ta();
    AppMethodBeat.o(194300);
  }
  
  static final class a
    implements c.a, c.b, c.c, c.d, c.e, c.f, c.g, c.h, c.i, c.j
  {
    public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(194292);
      d.i(e.TAG, " empty base listener , notify , onError");
      AppMethodBeat.o(194292);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(194291);
      d.i(e.TAG, " empty base listener , notify , onInfo");
      AppMethodBeat.o(194291);
    }
    
    public final void a(c paramc)
    {
      AppMethodBeat.i(194297);
      d.i(e.TAG, " empty base listener , notify , onAudioFrameOut");
      AppMethodBeat.o(194297);
    }
    
    public final void a(m paramm)
    {
      AppMethodBeat.i(194295);
      d.i(e.TAG, " empty base listener , notify , onSubtitleData");
      AppMethodBeat.o(194295);
    }
    
    public final void a(o paramo)
    {
      AppMethodBeat.i(194296);
      d.i(e.TAG, " empty base listener , notify , onVideoFrameOut");
      AppMethodBeat.o(194296);
    }
    
    public final void aC(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(194294);
      d.i(e.TAG, " empty base listener , notify , onVideoSizeChanged");
      AppMethodBeat.o(194294);
    }
    
    public final void clF()
    {
      AppMethodBeat.i(194293);
      d.i(e.TAG, " empty base listener , notify , onSeekComplete");
      AppMethodBeat.o(194293);
    }
    
    public final void fW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(194298);
      d.i(e.TAG, " empty base listener , notify , onStateChange");
      AppMethodBeat.o(194298);
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(194290);
      d.i(e.TAG, " empty base listener , notify , onCompletion");
      AppMethodBeat.o(194290);
    }
    
    public final void ta()
    {
      AppMethodBeat.i(194289);
      d.i(e.TAG, " empty base listener , notify , onPrepared");
      AppMethodBeat.o(194289);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.a.e
 * JD-Core Version:    0.7.0.1
 */