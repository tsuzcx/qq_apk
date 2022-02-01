package com.tencent.mm.plugin.multitask.ui;

import android.view.View;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.ui.component.g;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent;", "Lcom/tencent/mm/ui/component/IUIComponent;", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "onMultiTaskChange", "", "event", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "onMultiTaskInit", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "info", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskItemDelete", "onMultiTaskPageDestroy", "onMultiTaskPagePause", "onMultiTaskPageResume", "onTaskBarItemExposed", "supportMultiTaskType", "", "multiTaskType", "", "MultiTaskMode", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
  extends g
{
  public abstract void a(View paramView, MultiTaskInfo paramMultiTaskInfo, drt paramdrt, Object paramObject);
  
  public abstract a.b eDe();
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.a
 * JD-Core Version:    0.7.0.1
 */