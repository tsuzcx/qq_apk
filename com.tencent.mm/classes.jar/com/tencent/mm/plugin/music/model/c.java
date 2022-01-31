package com.tencent.mm.plugin.music.model;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.mm.a.f;
import com.tencent.mm.as.a.c.g;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class c
{
  public f<String, Bitmap> diW = new f(5);
  public c.a mzr;
  public g mzs = new c.1(this);
  public ah mzt = new ah(Looper.getMainLooper());
  
  public final void a(a parama, Bitmap paramBitmap)
  {
    y.i("MicroMsg.Music.MusicImageLoader", "putBitmapToCache %s", new Object[] { parama.field_musicId });
    this.diW.put(parama.field_musicId, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.c
 * JD-Core Version:    0.7.0.1
 */