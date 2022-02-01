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
import com.tencent.thumbplayer.utils.f;

public final class c
  implements b.a, b.b, b.c, b.d, b.e, b.f, b.g, b.h, b.i, b.j, b.k
{
  private static String TAG = "TPPlayerListenerS";
  b.h KiA;
  b.f KiB;
  a KiC;
  b.e Kir;
  b.b Kis;
  b.d Kit;
  b.c Kiu;
  b.g Kiv;
  b.k Kiw;
  b.i Kix;
  b.j Kiy;
  b.a Kiz;
  
  public c(String paramString)
  {
    AppMethodBeat.i(188103);
    TAG = paramString;
    this.KiC = new a((byte)0);
    this.Kir = this.KiC;
    this.Kis = this.KiC;
    this.Kit = this.KiC;
    this.Kiu = this.KiC;
    this.Kiv = this.KiC;
    this.Kiw = this.KiC;
    this.Kix = this.KiC;
    this.Kiy = this.KiC;
    this.Kiz = this.KiC;
    this.KiA = this.KiC;
    this.KiB = this.KiC;
    AppMethodBeat.o(188103);
  }
  
  public final int a(a parama, long paramLong, String paramString)
  {
    AppMethodBeat.i(188116);
    int i = this.KiB.a(parama, paramLong, paramString);
    AppMethodBeat.o(188116);
    return i;
  }
  
  public final int a(a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(188114);
    int i = this.KiB.a(parama, paramLong1, paramString, paramLong2, paramLong3);
    AppMethodBeat.o(188114);
    return i;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(188104);
    this.Kir.a(parama);
    AppMethodBeat.o(188104);
  }
  
  public final void a(a parama, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(188107);
    this.Kiu.a(parama, paramInt1, paramInt2, paramLong1, paramLong2);
    AppMethodBeat.o(188107);
  }
  
  public final void a(a parama, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(188106);
    this.Kit.a(parama, paramInt, paramLong1, paramLong2, paramObject);
    AppMethodBeat.o(188106);
  }
  
  public final void a(a parama, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(188109);
    this.Kiw.a(parama, paramLong1, paramLong2);
    AppMethodBeat.o(188109);
  }
  
  public final void a(a parama, com.tencent.thumbplayer.b.c paramc)
  {
    AppMethodBeat.i(188112);
    this.Kiz.a(parama, paramc);
    AppMethodBeat.o(188112);
  }
  
  public final void a(a parama, m paramm)
  {
    AppMethodBeat.i(188110);
    this.Kix.a(parama, paramm);
    AppMethodBeat.o(188110);
  }
  
  public final void a(a parama, o paramo)
  {
    AppMethodBeat.i(188111);
    this.Kiy.a(parama, paramo);
    AppMethodBeat.o(188111);
  }
  
  public final int b(a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(188115);
    int i = this.KiB.b(parama, paramLong1, paramString, paramLong2, paramLong3);
    AppMethodBeat.o(188115);
    return i;
  }
  
  public final long b(a parama, long paramLong, String paramString)
  {
    AppMethodBeat.i(188117);
    paramLong = this.KiB.b(parama, paramLong, paramString);
    AppMethodBeat.o(188117);
    return paramLong;
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(188105);
    this.Kis.b(parama);
    AppMethodBeat.o(188105);
  }
  
  public final String c(a parama, long paramLong, String paramString)
  {
    AppMethodBeat.i(188118);
    parama = this.KiB.c(parama, paramLong, paramString);
    AppMethodBeat.o(188118);
    return parama;
  }
  
  public final void c(a parama)
  {
    AppMethodBeat.i(188108);
    this.Kiv.c(parama);
    AppMethodBeat.o(188108);
  }
  
  public final String d(a parama, long paramLong, String paramString)
  {
    AppMethodBeat.i(188119);
    parama = this.KiB.d(parama, paramLong, paramString);
    AppMethodBeat.o(188119);
    return parama;
  }
  
  public final void fI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188113);
    this.KiA.fI(paramInt1, paramInt2);
    AppMethodBeat.o(188113);
  }
  
  static final class a
    implements b.a, b.b, b.c, b.d, b.e, b.f, b.g, b.h, b.i, b.j, b.k
  {
    public final int a(a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(188099);
      f.i(c.TAG, " empty player listener , notify , onStopReadData");
      AppMethodBeat.o(188099);
      return 0;
    }
    
    public final int a(a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(188097);
      f.i(c.TAG, " empty player listener , notify , onStartReadData");
      AppMethodBeat.o(188097);
      return 0;
    }
    
    public final void a(a parama)
    {
      AppMethodBeat.i(188087);
      f.i(c.TAG, " empty player listener , notify , onPrepared");
      AppMethodBeat.o(188087);
    }
    
    public final void a(a parama, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(188090);
      f.i(c.TAG, " empty player listener , notify , onError");
      AppMethodBeat.o(188090);
    }
    
    public final void a(a parama, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(188089);
      f.i(c.TAG, " empty player listener , notify , onInfo");
      AppMethodBeat.o(188089);
    }
    
    public final void a(a parama, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(188092);
      f.i(c.TAG, " empty player listener , notify , onVideoSizeChanged");
      AppMethodBeat.o(188092);
    }
    
    public final void a(a parama, com.tencent.thumbplayer.b.c paramc)
    {
      AppMethodBeat.i(188095);
      f.i(c.TAG, " empty player listener , notify , onAudioFrameOut");
      AppMethodBeat.o(188095);
    }
    
    public final void a(a parama, m paramm)
    {
      AppMethodBeat.i(188093);
      f.i(c.TAG, " empty player listener , notify , onSubtitleData");
      AppMethodBeat.o(188093);
    }
    
    public final void a(a parama, o paramo)
    {
      AppMethodBeat.i(188094);
      f.i(c.TAG, " empty player listener , notify , onVideoFrameOut");
      AppMethodBeat.o(188094);
    }
    
    public final int b(a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(188098);
      f.i(c.TAG, " empty player listener , notify , onReadData");
      AppMethodBeat.o(188098);
      return 0;
    }
    
    public final long b(a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(188100);
      f.i(c.TAG, " empty player listener , notify , getDataTotalSize");
      AppMethodBeat.o(188100);
      return 0L;
    }
    
    public final void b(a parama)
    {
      AppMethodBeat.i(188088);
      f.i(c.TAG, " empty player listener , notify , onCompletion");
      AppMethodBeat.o(188088);
    }
    
    public final String c(a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(188101);
      f.i(c.TAG, " empty player listener , notify , getDataFilePath");
      AppMethodBeat.o(188101);
      return "";
    }
    
    public final void c(a parama)
    {
      AppMethodBeat.i(188091);
      f.i(c.TAG, " empty player listener , notify , onSeekComplete");
      AppMethodBeat.o(188091);
    }
    
    public final String d(a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(188102);
      f.i(c.TAG, " empty player listener , notify , getContentType");
      AppMethodBeat.o(188102);
      return "";
    }
    
    public final void fI(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(188096);
      f.i(c.TAG, " empty player listener , notify , onStateChange");
      AppMethodBeat.o(188096);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.g.c
 * JD-Core Version:    0.7.0.1
 */