package com.tencent.mm.plugin.multitalk.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "", "drawAvatar", "", "drawBitmap", "userName", "", "bm", "Landroid/graphics/Bitmap;", "angle", "", "mirror", "getAvatarIv", "Landroid/widget/ImageView;", "getUsername", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface f
{
  public abstract void a(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  public abstract ImageView getAvatarIv();
  
  public abstract String getUsername();
  
  public abstract void gfe();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.f
 * JD-Core Version:    0.7.0.1
 */