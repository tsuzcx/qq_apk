package com.tencent.mm.plugin.taskbar.api;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.appbrand.widget.c.a.a;
import com.tencent.mm.ui.MMFragmentActivity;

public abstract class HeaderContainer
  extends RelativeLayout
{
  public HeaderContainer(Context paramContext)
  {
    super(paramContext);
  }
  
  public HeaderContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HeaderContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract boolean abw(int paramInt);
  
  public void abx(int paramInt) {}
  
  public void ac(long paramLong, int paramInt) {}
  
  public void ad(long paramLong, int paramInt) {}
  
  public void f(Configuration paramConfiguration) {}
  
  public abstract void fuA();
  
  public abstract boolean fuw();
  
  public abstract int getAnimationScrollOffset();
  
  public abstract Rect getBackUpFooterRect();
  
  public abstract View getBackgroundGLSurfaceContainer();
  
  public abstract View getBackgroundGLSurfaceView();
  
  public abstract View getBackgroundGradientView();
  
  public abstract View getDesktopBgView();
  
  public abstract View getDesktopContainerView();
  
  public abstract View getEmptyView();
  
  public abstract int getExtraBottomHeight();
  
  public abstract GyroView getGyroView();
  
  public abstract a getHeaderView();
  
  public abstract View getMaskView();
  
  public abstract LinearLayout getRootLayout();
  
  public int getViewHeight()
  {
    return 0;
  }
  
  public boolean isFullScreen()
  {
    return false;
  }
  
  public void jh(int paramInt1, int paramInt2) {}
  
  public void ji(int paramInt1, int paramInt2) {}
  
  public abstract void o(View paramView1, View paramView2);
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void setActionBar(View paramView) {}
  
  public abstract void setActivity(MMFragmentActivity paramMMFragmentActivity);
  
  public abstract void setAnimController(b paramb);
  
  public abstract void setBlurAlpha(float paramFloat);
  
  public abstract void setBlurAnimateStatue(boolean paramBoolean);
  
  public abstract void setDynamicBackgroundView(View paramView);
  
  public abstract void setExtraBottomHeight(int paramInt);
  
  public abstract void setFixedHeight(boolean paramBoolean);
  
  public void wn(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.api.HeaderContainer
 * JD-Core Version:    0.7.0.1
 */