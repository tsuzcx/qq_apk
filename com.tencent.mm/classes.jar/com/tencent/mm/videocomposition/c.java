package com.tencent.mm.videocomposition;

import android.graphics.Bitmap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "", "cancel", "", "callback", "Lkotlin/Function2;", "", "Landroid/graphics/Bitmap;", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "time", "destroy", "requestFrames", "times", "", "setSize", "width", "", "height", "video_composition_release"}, k=1, mv={1, 1, 15})
public abstract interface c
{
  public abstract void b(List<Long> paramList, m<? super Long, ? super Bitmap, ah> paramm);
  
  public abstract void cancel(long paramLong);
  
  public abstract void destroy();
  
  public abstract void setSize(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.videocomposition.c
 * JD-Core Version:    0.7.0.1
 */