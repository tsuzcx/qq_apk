package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "destroy", "", "invoke", "pts", "seekFrame", "timeMs", "start", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface c
  extends b<Long, Bitmap>
{
  public abstract void destroy();
  
  public abstract void start();
  
  public abstract Bitmap tG(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b.c
 * JD-Core Version:    0.7.0.1
 */