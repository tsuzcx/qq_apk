package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import android.graphics.Bitmap;
import d.g.a.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "destroy", "", "invoke", "pts", "seekFrame", "timeMs", "start", "plugin-recordvideo_release"})
public abstract interface c
  extends b<Long, Bitmap>
{
  public abstract void destroy();
  
  public abstract void start();
  
  public abstract Bitmap zo(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b.c
 * JD-Core Version:    0.7.0.1
 */