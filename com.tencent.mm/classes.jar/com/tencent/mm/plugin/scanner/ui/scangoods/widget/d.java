package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import com.tencent.mm.plugin.scanner.model.aj;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "", "addAnimationDots", "", "pointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "refreshView", "release", "setDuration", "duration", "", "show", "visible", "", "startAnimation", "stopAnimation", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface d
{
  public abstract void b(aj paramaj);
  
  public abstract void refreshView();
  
  public abstract void release();
  
  public abstract void setDuration(long paramLong);
  
  public abstract void startAnimation();
  
  public abstract void stopAnimation();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.d
 * JD-Core Version:    0.7.0.1
 */