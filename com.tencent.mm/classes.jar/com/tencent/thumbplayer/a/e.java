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
import com.tencent.thumbplayer.utils.f;

public final class e
  implements c.a, c.b, c.c, c.d, c.e, c.f, c.g, c.h, c.i, c.j
{
  private static String TAG = "TPPlayerListenerS";
  public c.e KcO;
  public c.b KcP;
  public c.d KcQ;
  public c.c KcR;
  public c.f KcS;
  public c.j KcT;
  public c.h KcU;
  public c.i KcV;
  public c.a KcW;
  c.g KcX;
  private a KcY;
  
  public e(String paramString)
  {
    AppMethodBeat.i(187600);
    TAG = paramString;
    this.KcY = new a((byte)0);
    this.KcO = this.KcY;
    this.KcP = this.KcY;
    this.KcQ = this.KcY;
    this.KcR = this.KcY;
    this.KcS = this.KcY;
    this.KcT = this.KcY;
    this.KcU = this.KcY;
    this.KcV = this.KcY;
    this.KcW = this.KcY;
    AppMethodBeat.o(187600);
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(187604);
    this.KcR.a(paramInt1, paramInt2, paramLong1, paramLong2);
    AppMethodBeat.o(187604);
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(187603);
    this.KcQ.a(paramInt, paramLong1, paramLong2, paramObject);
    AppMethodBeat.o(187603);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(187609);
    this.KcW.a(paramc);
    AppMethodBeat.o(187609);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(187607);
    this.KcU.a(paramm);
    AppMethodBeat.o(187607);
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(187608);
    this.KcV.a(paramo);
    AppMethodBeat.o(187608);
  }
  
  public final void ay(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(187606);
    this.KcT.ay(paramLong1, paramLong2);
    AppMethodBeat.o(187606);
  }
  
  public final void cfM()
  {
    AppMethodBeat.i(187605);
    this.KcS.cfM();
    AppMethodBeat.o(187605);
  }
  
  public final void clear()
  {
    this.KcO = this.KcY;
    this.KcP = this.KcY;
    this.KcQ = this.KcY;
    this.KcR = this.KcY;
    this.KcS = this.KcY;
    this.KcT = this.KcY;
    this.KcU = this.KcY;
    this.KcV = this.KcY;
    this.KcW = this.KcY;
    this.KcX = this.KcY;
  }
  
  public final void fI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187610);
    this.KcX.fI(paramInt1, paramInt2);
    AppMethodBeat.o(187610);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(187602);
    this.KcP.onCompletion();
    AppMethodBeat.o(187602);
  }
  
  public final void rB()
  {
    AppMethodBeat.i(187601);
    this.KcO.rB();
    AppMethodBeat.o(187601);
  }
  
  static final class a
    implements c.a, c.b, c.c, c.d, c.e, c.f, c.g, c.h, c.i, c.j
  {
    public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(187593);
      f.i(e.TAG, " empty base listener , notify , onError");
      AppMethodBeat.o(187593);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(187592);
      f.i(e.TAG, " empty base listener , notify , onInfo");
      AppMethodBeat.o(187592);
    }
    
    public final void a(c paramc)
    {
      AppMethodBeat.i(187598);
      f.i(e.TAG, " empty base listener , notify , onAudioFrameOut");
      AppMethodBeat.o(187598);
    }
    
    public final void a(m paramm)
    {
      AppMethodBeat.i(187596);
      f.i(e.TAG, " empty base listener , notify , onSubtitleData");
      AppMethodBeat.o(187596);
    }
    
    public final void a(o paramo)
    {
      AppMethodBeat.i(187597);
      f.i(e.TAG, " empty base listener , notify , onVideoFrameOut");
      AppMethodBeat.o(187597);
    }
    
    public final void ay(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(187595);
      f.i(e.TAG, " empty base listener , notify , onVideoSizeChanged");
      AppMethodBeat.o(187595);
    }
    
    public final void cfM()
    {
      AppMethodBeat.i(187594);
      f.i(e.TAG, " empty base listener , notify , onSeekComplete");
      AppMethodBeat.o(187594);
    }
    
    public final void fI(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(187599);
      f.i(e.TAG, " empty base listener , notify , onStateChange");
      AppMethodBeat.o(187599);
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(187591);
      f.i(e.TAG, " empty base listener , notify , onCompletion");
      AppMethodBeat.o(187591);
    }
    
    public final void rB()
    {
      AppMethodBeat.i(187590);
      f.i(e.TAG, " empty base listener , notify , onPrepared");
      AppMethodBeat.o(187590);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.a.e
 * JD-Core Version:    0.7.0.1
 */