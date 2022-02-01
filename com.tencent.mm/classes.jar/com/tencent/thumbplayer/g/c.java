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
  b.e MbG;
  b.b MbH;
  b.d MbI;
  b.c MbJ;
  b.g MbK;
  b.k MbL;
  b.i MbM;
  b.j MbN;
  b.a MbO;
  b.h MbP;
  b.f MbQ;
  a MbR;
  
  public c(String paramString)
  {
    AppMethodBeat.i(192125);
    TAG = paramString;
    this.MbR = new a((byte)0);
    this.MbG = this.MbR;
    this.MbH = this.MbR;
    this.MbI = this.MbR;
    this.MbJ = this.MbR;
    this.MbK = this.MbR;
    this.MbL = this.MbR;
    this.MbM = this.MbR;
    this.MbN = this.MbR;
    this.MbO = this.MbR;
    this.MbP = this.MbR;
    this.MbQ = this.MbR;
    AppMethodBeat.o(192125);
  }
  
  public final int a(a parama, long paramLong, String paramString)
  {
    AppMethodBeat.i(192138);
    int i = this.MbQ.a(parama, paramLong, paramString);
    AppMethodBeat.o(192138);
    return i;
  }
  
  public final int a(a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(192136);
    int i = this.MbQ.a(parama, paramLong1, paramString, paramLong2, paramLong3);
    AppMethodBeat.o(192136);
    return i;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(192126);
    this.MbG.a(parama);
    AppMethodBeat.o(192126);
  }
  
  public final void a(a parama, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(192129);
    this.MbJ.a(parama, paramInt1, paramInt2, paramLong1, paramLong2);
    AppMethodBeat.o(192129);
  }
  
  public final void a(a parama, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(192128);
    this.MbI.a(parama, paramInt, paramLong1, paramLong2, paramObject);
    AppMethodBeat.o(192128);
  }
  
  public final void a(a parama, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(192131);
    this.MbL.a(parama, paramLong1, paramLong2);
    AppMethodBeat.o(192131);
  }
  
  public final void a(a parama, com.tencent.thumbplayer.b.c paramc)
  {
    AppMethodBeat.i(192134);
    this.MbO.a(parama, paramc);
    AppMethodBeat.o(192134);
  }
  
  public final void a(a parama, m paramm)
  {
    AppMethodBeat.i(192132);
    this.MbM.a(parama, paramm);
    AppMethodBeat.o(192132);
  }
  
  public final void a(a parama, o paramo)
  {
    AppMethodBeat.i(192133);
    this.MbN.a(parama, paramo);
    AppMethodBeat.o(192133);
  }
  
  public final int b(a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(192137);
    int i = this.MbQ.b(parama, paramLong1, paramString, paramLong2, paramLong3);
    AppMethodBeat.o(192137);
    return i;
  }
  
  public final long b(a parama, long paramLong, String paramString)
  {
    AppMethodBeat.i(192139);
    paramLong = this.MbQ.b(parama, paramLong, paramString);
    AppMethodBeat.o(192139);
    return paramLong;
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(192127);
    this.MbH.b(parama);
    AppMethodBeat.o(192127);
  }
  
  public final String c(a parama, long paramLong, String paramString)
  {
    AppMethodBeat.i(192140);
    parama = this.MbQ.c(parama, paramLong, paramString);
    AppMethodBeat.o(192140);
    return parama;
  }
  
  public final void c(a parama)
  {
    AppMethodBeat.i(192130);
    this.MbK.c(parama);
    AppMethodBeat.o(192130);
  }
  
  public final String d(a parama, long paramLong, String paramString)
  {
    AppMethodBeat.i(192141);
    parama = this.MbQ.d(parama, paramLong, paramString);
    AppMethodBeat.o(192141);
    return parama;
  }
  
  public final void fW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192135);
    this.MbP.fW(paramInt1, paramInt2);
    AppMethodBeat.o(192135);
  }
  
  static final class a
    implements b.a, b.b, b.c, b.d, b.e, b.f, b.g, b.h, b.i, b.j, b.k
  {
    public final int a(a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(192121);
      d.i(c.TAG, " empty player listener , notify , onStopReadData");
      AppMethodBeat.o(192121);
      return 0;
    }
    
    public final int a(a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(192119);
      d.i(c.TAG, " empty player listener , notify , onStartReadData");
      AppMethodBeat.o(192119);
      return 0;
    }
    
    public final void a(a parama)
    {
      AppMethodBeat.i(192109);
      d.i(c.TAG, " empty player listener , notify , onPrepared");
      AppMethodBeat.o(192109);
    }
    
    public final void a(a parama, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(192112);
      d.i(c.TAG, " empty player listener , notify , onError");
      AppMethodBeat.o(192112);
    }
    
    public final void a(a parama, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(192111);
      d.i(c.TAG, " empty player listener , notify , onInfo");
      AppMethodBeat.o(192111);
    }
    
    public final void a(a parama, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(192114);
      d.i(c.TAG, " empty player listener , notify , onVideoSizeChanged");
      AppMethodBeat.o(192114);
    }
    
    public final void a(a parama, com.tencent.thumbplayer.b.c paramc)
    {
      AppMethodBeat.i(192117);
      d.i(c.TAG, " empty player listener , notify , onAudioFrameOut");
      AppMethodBeat.o(192117);
    }
    
    public final void a(a parama, m paramm)
    {
      AppMethodBeat.i(192115);
      d.i(c.TAG, " empty player listener , notify , onSubtitleData");
      AppMethodBeat.o(192115);
    }
    
    public final void a(a parama, o paramo)
    {
      AppMethodBeat.i(192116);
      d.i(c.TAG, " empty player listener , notify , onVideoFrameOut");
      AppMethodBeat.o(192116);
    }
    
    public final int b(a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(192120);
      d.i(c.TAG, " empty player listener , notify , onReadData");
      AppMethodBeat.o(192120);
      return 0;
    }
    
    public final long b(a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(192122);
      d.i(c.TAG, " empty player listener , notify , getDataTotalSize");
      AppMethodBeat.o(192122);
      return 0L;
    }
    
    public final void b(a parama)
    {
      AppMethodBeat.i(192110);
      d.i(c.TAG, " empty player listener , notify , onCompletion");
      AppMethodBeat.o(192110);
    }
    
    public final String c(a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(192123);
      d.i(c.TAG, " empty player listener , notify , getDataFilePath");
      AppMethodBeat.o(192123);
      return "";
    }
    
    public final void c(a parama)
    {
      AppMethodBeat.i(192113);
      d.i(c.TAG, " empty player listener , notify , onSeekComplete");
      AppMethodBeat.o(192113);
    }
    
    public final String d(a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(192124);
      d.i(c.TAG, " empty player listener , notify , getContentType");
      AppMethodBeat.o(192124);
      return "";
    }
    
    public final void fW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(192118);
      d.i(c.TAG, " empty player listener , notify , onStateChange");
      AppMethodBeat.o(192118);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.g.c
 * JD-Core Version:    0.7.0.1
 */