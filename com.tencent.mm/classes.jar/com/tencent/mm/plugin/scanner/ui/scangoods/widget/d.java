package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import com.tencent.mm.plugin.scanner.model.y;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "", "addAnimationDots", "", "pointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "refreshView", "release", "setDuration", "duration", "", "show", "visible", "", "startAnimation", "stopAnimation", "plugin-scan_release"})
public abstract interface d
{
  public abstract void b(y paramy);
  
  public abstract void refreshView();
  
  public abstract void release();
  
  public abstract void setDuration(long paramLong);
  
  public abstract void startAnimation();
  
  public abstract void stopAnimation();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.d
 * JD-Core Version:    0.7.0.1
 */