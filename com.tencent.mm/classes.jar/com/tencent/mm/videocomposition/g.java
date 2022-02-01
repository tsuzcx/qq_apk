package com.tencent.mm.videocomposition;

import android.graphics.Bitmap;
import java.util.List;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "", "cancel", "", "callback", "Lkotlin/Function2;", "", "Landroid/graphics/Bitmap;", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "time", "destroy", "requestFrames", "times", "", "setSize", "width", "", "height", "video_composition_release"})
public abstract interface g
{
  public abstract void b(List<Long> paramList, m<? super Long, ? super Bitmap, x> paramm);
  
  public abstract void cancel(long paramLong);
  
  public abstract void destroy();
  
  public abstract void setSize(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.videocomposition.g
 * JD-Core Version:    0.7.0.1
 */