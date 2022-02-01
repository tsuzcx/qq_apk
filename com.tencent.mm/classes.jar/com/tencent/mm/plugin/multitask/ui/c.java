package com.tencent.mm.plugin.multitask.ui;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.sdk.storage.observer.StorageObserverEvent;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "multiTaskRootView", "Lcom/tencent/mm/ui/base/CustomViewPager;", "getMultiTaskRootView", "()Lcom/tencent/mm/ui/base/CustomViewPager;", "setMultiTaskRootView", "(Lcom/tencent/mm/ui/base/CustomViewPager;)V", "onMultiTaskInit", "", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskItemDelete", "onMultiTaskPageDestroy", "onMultiTaskPagePause", "onMultiTaskPageResume", "onTaskBarItemExposed", "plugin-multitask_release"})
public abstract class c
  extends UIComponent
  implements a
{
  public CustomViewPager FFs;
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public c(Fragment paramFragment)
  {
    super(paramFragment);
  }
  
  public boolean Of(int paramInt)
  {
    return false;
  }
  
  public void a(View paramView, MultiTaskInfo paramMultiTaskInfo, dal paramdal, Object paramObject)
  {
    p.k(paramMultiTaskInfo, "info");
    p.k(paramdal, "animateData");
  }
  
  public void a(MultiTaskInfo paramMultiTaskInfo)
  {
    p.k(paramMultiTaskInfo, "info");
  }
  
  public void a(StorageObserverEvent<MultiTaskInfo> paramStorageObserverEvent)
  {
    p.k(paramStorageObserverEvent, "event");
    p.k(paramStorageObserverEvent, "event");
  }
  
  public void dI(Object paramObject) {}
  
  public void dKo() {}
  
  public void dp(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.c
 * JD-Core Version:    0.7.0.1
 */