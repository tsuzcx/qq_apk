package com.tencent.mm.plugin.multitask.ui;

import android.view.View;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.ui.component.d;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent;", "Lcom/tencent/mm/ui/component/IUIComponent;", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "onMultiTaskChange", "", "event", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "onMultiTaskInit", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "info", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskItemDelete", "onMultiTaskPageDestroy", "onMultiTaskPagePause", "onMultiTaskPageResume", "onTaskBarItemExposed", "supportMultiTaskType", "", "multiTaskType", "", "MultiTaskMode", "plugin-multitask_release"})
public abstract interface a
  extends d
{
  public abstract void a(View paramView, MultiTaskInfo paramMultiTaskInfo, dal paramdal, Object paramObject);
  
  public abstract a.b dKp();
  
  @l(iBK={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.a
 * JD-Core Version:    0.7.0.1
 */