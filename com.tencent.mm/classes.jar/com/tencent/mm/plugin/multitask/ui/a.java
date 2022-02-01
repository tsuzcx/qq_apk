package com.tencent.mm.plugin.multitask.ui;

import android.view.View;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.crq;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent;", "Lcom/tencent/mm/ui/component/IUIComponent;", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "onMultiTaskChange", "", "event", "", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onMultiTaskInit", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskItemDelete", "onMultiTaskPageDestroy", "onMultiTaskPagePause", "onMultiTaskPageResume", "onTaskBarItemExposed", "supportMultiTaskType", "", "multiTaskType", "", "MultiTaskMode", "plugin-multitask_release"})
public abstract interface a
{
  public abstract void a(View paramView, MultiTaskInfo paramMultiTaskInfo, crq paramcrq, Object paramObject);
  
  public abstract a.b dks();
  
  @l(hxD={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.a
 * JD-Core Version:    0.7.0.1
 */