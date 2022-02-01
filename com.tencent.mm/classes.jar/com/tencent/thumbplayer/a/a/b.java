package com.tencent.thumbplayer.a.a;

import android.os.ParcelFileDescriptor;
import android.view.Surface;
import com.tencent.thumbplayer.b.a.a;
import com.tencent.thumbplayer.b.d;
import com.tencent.thumbplayer.b.e;
import com.tencent.thumbplayer.b.f;
import com.tencent.thumbplayer.b.k;
import com.tencent.thumbplayer.b.n;
import java.util.List;
import java.util.Map;

public abstract interface b
{
  public abstract void L(String paramString, int paramInt, long paramLong);
  
  public abstract void a(c.a parama);
  
  public abstract void a(c.b paramb);
  
  public abstract void a(c.c paramc);
  
  public abstract void a(c.d paramd);
  
  public abstract void a(c.e parame);
  
  public abstract void a(c.f paramf);
  
  public abstract void a(c.h paramh);
  
  public abstract void a(c.i parami);
  
  public abstract void a(c.j paramj);
  
  public abstract void a(a parama);
  
  public abstract void a(a parama, int paramInt, long paramLong);
  
  public abstract void a(e parame, d paramd);
  
  public abstract void aR(int paramInt, long paramLong);
  
  public abstract void aS(int paramInt, long paramLong);
  
  public abstract void aT(int paramInt, long paramLong);
  
  public abstract void b(ParcelFileDescriptor paramParcelFileDescriptor);
  
  public abstract void b(f paramf);
  
  public abstract void bl(String paramString1, String paramString2, String paramString3);
  
  public abstract void c(boolean paramBoolean, long paramLong1, long paramLong2);
  
  public abstract void cg(float paramFloat);
  
  public abstract void ch(float paramFloat);
  
  public abstract void g(String paramString1, String paramString2, List<f> paramList);
  
  public abstract n[] gaF();
  
  public abstract k[] gaG();
  
  public abstract long getBufferedDurationMs();
  
  public abstract long getCurrentPositionMs();
  
  public abstract long getDurationMs();
  
  public abstract long getPropertyLong(int paramInt);
  
  public abstract String getPropertyString(int paramInt);
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract void kZ(int paramInt1, int paramInt2);
  
  public abstract void pause();
  
  public abstract void prepare();
  
  public abstract void prepareAsync();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void setDataSource(String paramString);
  
  public abstract void setDataSource(String paramString, Map<String, String> paramMap);
  
  public abstract void setSurface(Surface paramSurface);
  
  public abstract void start();
  
  public abstract void stop();
  
  public abstract void zJ(boolean paramBoolean);
  
  public abstract void zK(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.b
 * JD-Core Version:    0.7.0.1
 */