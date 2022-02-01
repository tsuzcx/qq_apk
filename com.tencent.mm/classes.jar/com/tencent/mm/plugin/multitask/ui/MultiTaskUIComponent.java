package com.tencent.mm.plugin.multitask.ui;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "multiTaskRootView", "Lcom/tencent/mm/ui/base/CustomViewPager;", "getMultiTaskRootView", "()Lcom/tencent/mm/ui/base/CustomViewPager;", "setMultiTaskRootView", "(Lcom/tencent/mm/ui/base/CustomViewPager;)V", "onMultiTaskInit", "", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskItemDelete", "onMultiTaskPageDestroy", "onMultiTaskPagePause", "onMultiTaskPageResume", "onTaskBarItemExposed", "plugin-multitask_release"})
public abstract class MultiTaskUIComponent
  extends UIComponent
  implements a
{
  public CustomViewPager zZC;
  
  public MultiTaskUIComponent(Fragment paramFragment)
  {
    super(paramFragment);
  }
  
  public MultiTaskUIComponent(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public boolean Js(int paramInt)
  {
    return false;
  }
  
  public void a(View paramView, MultiTaskInfo paramMultiTaskInfo, crq paramcrq, Object paramObject)
  {
    p.h(paramMultiTaskInfo, "info");
    p.h(paramcrq, "animateData");
  }
  
  public void a(MultiTaskInfo paramMultiTaskInfo)
  {
    p.h(paramMultiTaskInfo, "info");
  }
  
  public void a(MStorageEventData paramMStorageEventData) {}
  
  public void dF(Object paramObject) {}
  
  public void dk(Object paramObject) {}
  
  public void dkr() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
 * JD-Core Version:    0.7.0.1
 */