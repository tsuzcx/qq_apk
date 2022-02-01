package com.tencent.mm.plugin.multitask.ui;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.sdk.storage.observer.StorageObserverEvent;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "multiTaskRootView", "Lcom/tencent/mm/ui/base/CustomViewPager;", "getMultiTaskRootView", "()Lcom/tencent/mm/ui/base/CustomViewPager;", "setMultiTaskRootView", "(Lcom/tencent/mm/ui/base/CustomViewPager;)V", "onMultiTaskInit", "", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskItemDelete", "onMultiTaskPageDestroy", "onMultiTaskPagePause", "onMultiTaskPageResume", "onTaskBarItemExposed", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
  extends UIComponent
  implements a
{
  public CustomViewPager LBs;
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public c(Fragment paramFragment)
  {
    super(paramFragment);
  }
  
  public boolean Qs(int paramInt)
  {
    s.u(this, "this");
    return false;
  }
  
  public void a(View paramView, MultiTaskInfo paramMultiTaskInfo, drt paramdrt, Object paramObject)
  {
    s.u(paramMultiTaskInfo, "info");
    s.u(paramdrt, "animateData");
  }
  
  public void a(MultiTaskInfo paramMultiTaskInfo)
  {
    s.u(paramMultiTaskInfo, "info");
  }
  
  public void a(StorageObserverEvent<MultiTaskInfo> paramStorageObserverEvent)
  {
    s.u(this, "this");
    s.u(paramStorageObserverEvent, "event");
  }
  
  public void eDd() {}
  
  public void fZ(Object paramObject) {}
  
  public void fw(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.c
 * JD-Core Version:    0.7.0.1
 */