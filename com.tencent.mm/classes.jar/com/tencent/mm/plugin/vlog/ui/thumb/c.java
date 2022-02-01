package com.tencent.mm.plugin.vlog.ui.thumb;

import android.graphics.Bitmap;
import d.g.a.m;
import d.l;
import d.y;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/thumb/ITrackThumbFetcher;", "", "destroy", "", "init", "requestFrames", "times", "", "", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "setSize", "width", "", "height", "plugin-vlog_release"})
public abstract interface c
{
  public abstract void b(List<Long> paramList, m<? super Long, ? super Bitmap, y> paramm);
  
  public abstract void destroy();
  
  public abstract void init();
  
  public abstract void setSize(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.c
 * JD-Core Version:    0.7.0.1
 */