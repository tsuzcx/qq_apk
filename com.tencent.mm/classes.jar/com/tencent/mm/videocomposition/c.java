package com.tencent.mm.videocomposition;

import android.graphics.Bitmap;
import d.g.a.m;
import d.l;
import d.z;
import java.util.List;

@l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "", "cancel", "", "callback", "Lkotlin/Function2;", "", "Landroid/graphics/Bitmap;", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "time", "destroy", "requestFrames", "times", "", "setSize", "width", "", "height", "video_composition_release"})
public abstract interface c
{
  public abstract void b(List<Long> paramList, m<? super Long, ? super Bitmap, z> paramm);
  
  public abstract void c(m<? super Long, ? super Bitmap, z> paramm);
  
  public abstract void destroy();
  
  public abstract void setSize(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.videocomposition.c
 * JD-Core Version:    0.7.0.1
 */