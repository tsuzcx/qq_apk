package com.tencent.mm.plugin.multitask.a;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.multitask.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "indicatorBottomMargin", "", "getIndicatorBottomMargin", "()I", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "isSupportSwipeToMultiTask", "", "()Z", "maskView", "getMaskView", "multiTaskRootView", "Lcom/tencent/mm/ui/base/CustomViewPager;", "getMultiTaskRootView", "()Lcom/tencent/mm/ui/base/CustomViewPager;", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "addMultiTaskWrapper", "", "pageHelper", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "canConvertToTranslucent", "convertToTranslucent", "translucentCallback", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$TranslucentCallback;", "convertToTranslucentIfNeed", "finish", "withAnimation", "helper", "degree", "onCaptureBitmapBefore", "onCaptureBitmapCancel", "setMultiTaskType", "type", "setSwipeAheadEnable", "enable", "setSwipeBackEnable", "setSwipeBackListener", "listener", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "IMultiTaskSwipeBackListener", "TranslucentCallback", "plugin-multitask_release"})
public abstract interface a
{
  public abstract void RE(int paramInt);
  
  public abstract void a(a.a parama);
  
  public abstract void a(a.b paramb);
  
  public abstract void a(b paramb);
  
  public abstract void a(boolean paramBoolean, b paramb);
  
  public abstract Bitmap ag(Bitmap paramBitmap);
  
  public abstract boolean bCI();
  
  public abstract boolean bPp();
  
  public abstract boolean bPv();
  
  public abstract ViewGroup chG();
  
  public abstract int chH();
  
  public abstract Activity getActivity();
  
  public abstract Bitmap getBitmap();
  
  public abstract View getContentView();
  
  public abstract Intent getIntent();
  
  public abstract View getMaskView();
  
  public abstract void sj(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.a.a
 * JD-Core Version:    0.7.0.1
 */