package com.tencent.mm.ui.widget.pulldown;

import android.graphics.drawable.Drawable;
import android.view.View;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/pulldown/IBounceView;", "Lcom/tencent/mm/ui/widget/pulldown/IBounceCommon;", "getOffset", "", "getView", "Landroid/view/View;", "initBounce", "", "isBounceEnabled", "", "setAtEndCallback", "callback", "Lcom/tencent/mm/ui/widget/pulldown/AtEndCallback;", "target", "setAtStartCallback", "Lcom/tencent/mm/ui/widget/pulldown/AtStartCallback;", "setBg", "drawable", "Landroid/graphics/drawable/Drawable;", "setBgColor", "color", "setBounceEnabled", "enabled", "setEnd2StartBg", "setEnd2StartBgColor", "setEnd2StartBgColorByNavigationBar", "setStart2EndBg", "setStart2EndBgColor", "setStart2EndBgColorByActionBar", "setView", "contentView", "BounceOffsetChangedListener", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface f
  extends e
{
  public abstract void a(a parama, View paramView);
  
  public abstract int getOffset();
  
  public abstract View getView();
  
  public abstract void jIK();
  
  public abstract void setBg(Drawable paramDrawable);
  
  public abstract void setBgColor(int paramInt);
  
  public abstract void setBounceEnabled(boolean paramBoolean);
  
  public abstract void setEnd2StartBgColor(int paramInt);
  
  public abstract void setEnd2StartBgColorByNavigationBar(int paramInt);
  
  public abstract void setStart2EndBgColor(int paramInt);
  
  public abstract void setStart2EndBgColorByActionBar(int paramInt);
  
  public abstract void setView(View paramView);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/pulldown/IBounceView$BounceOffsetChangedListener;", "", "onBounceOffsetChanged", "", "offset", "", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void Wm(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.pulldown.f
 * JD-Core Version:    0.7.0.1
 */