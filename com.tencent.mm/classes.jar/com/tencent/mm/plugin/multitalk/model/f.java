package com.tencent.mm.plugin.multitalk.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "", "drawAvatar", "", "drawBitmap", "userName", "", "bm", "Landroid/graphics/Bitmap;", "angle", "", "mirror", "getAvatarIv", "Landroid/widget/ImageView;", "getUsername", "plugin-multitalk_release"})
public abstract interface f
{
  public abstract void a(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  public abstract void emz();
  
  public abstract ImageView getAvatarIv();
  
  public abstract String getUsername();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.f
 * JD-Core Version:    0.7.0.1
 */