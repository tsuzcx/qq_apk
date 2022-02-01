package com.tencent.mm.ui.widget.pulldown;

import android.graphics.drawable.Drawable;
import android.view.View;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/pulldown/IBounceView;", "Lcom/tencent/mm/ui/widget/pulldown/IBounceCommon;", "enableEnd2Start", "", "enable", "", "enableStart2End", "getOffset", "", "getView", "Landroid/view/View;", "initBounce", "isBounceEnabled", "setAtEndCallback", "callback", "Lcom/tencent/mm/ui/widget/pulldown/AtEndCallback;", "target", "setAtStartCallback", "Lcom/tencent/mm/ui/widget/pulldown/AtStartCallback;", "setBg", "drawable", "Landroid/graphics/drawable/Drawable;", "setBgColor", "color", "setBounceEnabled", "enabled", "setEnd2StartBg", "setEnd2StartBgColor", "setEnd2StartBgColorByNavigationBar", "setStart2EndBg", "setStart2EndBgColor", "setStart2EndBgColorByActionBar", "setView", "bgView", "contentView", "BounceOffsetChangedListener", "weui-native-android-lib_release"})
public abstract interface e
  extends g
{
  public abstract void HO(boolean paramBoolean);
  
  public abstract void a(a parama, View paramView);
  
  public abstract int getOffset();
  
  public abstract View getView();
  
  public abstract void h(View paramView1, View paramView2);
  
  public abstract void idC();
  
  public abstract void setBg(Drawable paramDrawable);
  
  public abstract void setBounceEnabled(boolean paramBoolean);
  
  public abstract void setEnd2StartBgColor(int paramInt);
  
  public abstract void setEnd2StartBgColorByNavigationBar(int paramInt);
  
  public abstract void setStart2EndBgColor(int paramInt);
  
  public abstract void setStart2EndBgColorByActionBar(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.pulldown.e
 * JD-Core Version:    0.7.0.1
 */