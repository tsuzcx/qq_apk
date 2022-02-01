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
  public c.e LWK;
  public c.b LWL;
  public c.d LWM;
  public c.c LWN;
  public c.f LWO;
  public c.j LWP;
  public c.h LWQ;
  public c.i LWR;
  public c.a LWS;
  c.g LWT;
  private a LWU;
  
  public e(String paramString)
  {
    AppMethodBeat.i(191621);
    TAG = paramString;
    this.LWU = new a((byte)0);
    this.LWK = this.LWU;
    this.LWL = this.LWU;
    this.LWM = this.LWU;
    this.LWN = this.LWU;
    this.LWO = this.LWU;
    this.LWP = this.LWU;
    this.LWQ = this.LWU;
    this.LWR = this.LWU;
    this.LWS = this.LWU;
    AppMethodBeat.o(191621);
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(191625);
    this.LWN.a(paramInt1, paramInt2, paramLong1, paramLong2);
    AppMethodBeat.o(191625);
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(191624);
    this.LWM.a(paramInt, paramLong1, paramLong2, paramObject);
    AppMethodBeat.o(191624);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(191630);
    this.LWS.a(paramc);
    AppMethodBeat.o(191630);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(191628);
    this.LWQ.a(paramm);
    AppMethodBeat.o(191628);
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(191629);
    this.LWR.a(paramo);
    AppMethodBeat.o(191629);
  }
  
  public final void aD(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(191627);
    this.LWP.aD(paramLong1, paramLong2);
    AppMethodBeat.o(191627);
  }
  
  public final void ckp()
  {
    AppMethodBeat.i(191626);
    this.LWO.ckp();
    AppMethodBeat.o(191626);
  }
  
  public final void clear()
  {
    this.LWK = this.LWU;
    this.LWL = this.LWU;
    this.LWM = this.LWU;
    this.LWN = this.LWU;
    this.LWO = this.LWU;
    this.LWP = this.LWU;
    this.LWQ = this.LWU;
    this.LWR = this.LWU;
    this.LWS = this.LWU;
    this.LWT = this.LWU;
  }
  
  public final void fW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191631);
    this.LWT.fW(paramInt1, paramInt2);
    AppMethodBeat.o(191631);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(191623);
    this.LWL.onCompletion();
    AppMethodBeat.o(191623);
  }
  
  public final void ta()
  {
    AppMethodBeat.i(191622);
    this.LWK.ta();
    AppMethodBeat.o(191622);
  }
  
  static final class a
    implements c.a, c.b, c.c, c.d, c.e, c.f, c.g, c.h, c.i, c.j
  {
    public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(191614);
      d.i(e.TAG, " empty base listener , notify , onError");
      AppMethodBeat.o(191614);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(191613);
      d.i(e.TAG, " empty base listener , notify , onInfo");
      AppMethodBeat.o(191613);
    }
    
    public final void a(c paramc)
    {
      AppMethodBeat.i(191619);
      d.i(e.TAG, " empty base listener , notify , onAudioFrameOut");
      AppMethodBeat.o(191619);
    }
    
    public final void a(m paramm)
    {
      AppMethodBeat.i(191617);
      d.i(e.TAG, " empty base listener , notify , onSubtitleData");
      AppMethodBeat.o(191617);
    }
    
    public final void a(o paramo)
    {
      AppMethodBeat.i(191618);
      d.i(e.TAG, " empty base listener , notify , onVideoFrameOut");
      AppMethodBeat.o(191618);
    }
    
    public final void aD(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(191616);
      d.i(e.TAG, " empty base listener , notify , onVideoSizeChanged");
      AppMethodBeat.o(191616);
    }
    
    public final void ckp()
    {
      AppMethodBeat.i(191615);
      d.i(e.TAG, " empty base listener , notify , onSeekComplete");
      AppMethodBeat.o(191615);
    }
    
    public final void fW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(191620);
      d.i(e.TAG, " empty base listener , notify , onStateChange");
      AppMethodBeat.o(191620);
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(191612);
      d.i(e.TAG, " empty base listener , notify , onCompletion");
      AppMethodBeat.o(191612);
    }
    
    public final void ta()
    {
      AppMethodBeat.i(191611);
      d.i(e.TAG, " empty base listener , notify , onPrepared");
      AppMethodBeat.o(191611);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.a.e
 * JD-Core Version:    0.7.0.1
 */