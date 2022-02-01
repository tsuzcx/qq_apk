package com.tencent.mm.ui.vas;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBar.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/vas/VASActionBar;", "Landroidx/appcompat/app/ActionBar;", "vasActivity", "Lcom/tencent/mm/ui/vas/VASActivity;", "(Lcom/tencent/mm/ui/vas/VASActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "actionBarWrapper", "Landroid/view/ViewGroup;", "getActionBarWrapper", "()Landroid/view/ViewGroup;", "setActionBarWrapper", "(Landroid/view/ViewGroup;)V", "mCustomView", "Landroid/view/View;", "getMCustomView", "()Landroid/view/View;", "setMCustomView", "(Landroid/view/View;)V", "getVasActivity", "()Lcom/tencent/mm/ui/vas/VASActivity;", "addOnMenuVisibilityListener", "", "listener", "Landroidx/appcompat/app/ActionBar$OnMenuVisibilityListener;", "addTab", "tab", "Landroidx/appcompat/app/ActionBar$Tab;", "setSelected", "", "position", "", "getCustomView", "getDisplayOptions", "getHeight", "getNavigationItemCount", "getNavigationMode", "getSelectedNavigationIndex", "getSelectedTab", "getSubtitle", "", "getTabAt", "index", "getTabCount", "getTitle", "hide", "isShowing", "newTab", "removeAllTabs", "removeOnMenuVisibilityListener", "removeTab", "removeTabAt", "selectTab", "setBackgroundDrawable", "d", "Landroid/graphics/drawable/Drawable;", "setCustomView", "view", "layoutParams", "Landroidx/appcompat/app/ActionBar$LayoutParams;", "resId", "setDisplayHomeAsUpEnabled", "showHomeAsUp", "setDisplayOptions", "options", "mask", "setDisplayShowCustomEnabled", "showCustom", "setDisplayShowHomeEnabled", "showHome", "setDisplayShowTitleEnabled", "showTitle", "setDisplayUseLogoEnabled", "useLogo", "setIcon", "icon", "setListNavigationCallbacks", "adapter", "Landroid/widget/SpinnerAdapter;", "callback", "Landroidx/appcompat/app/ActionBar$OnNavigationListener;", "setLogo", "logo", "setNavigationMode", "mode", "setSelectedNavigationItem", "setSubtitle", "subtitle", "setTitle", "title", "show", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends ActionBar
{
  public static final b.a afQm;
  private String TAG;
  private final VASActivity afQn;
  ViewGroup afQo;
  private View oW;
  
  static
  {
    AppMethodBeat.i(249931);
    afQm = new b.a((byte)0);
    AppMethodBeat.o(249931);
  }
  
  public b(VASActivity paramVASActivity)
  {
    AppMethodBeat.i(249925);
    this.afQn = paramVASActivity;
    this.TAG = s.X("MicroMsg.VAS.VASActionBar@", Integer.valueOf(hashCode()));
    this.afQo = ((ViewGroup)new FrameLayout((Context)this.afQn.get_activity()));
    this.afQo.setId(a.g.layout_actionbar_wrapper);
    AppMethodBeat.o(249925);
  }
  
  public final void L(int paramInt) {}
  
  public final void M(int paramInt) {}
  
  public final void a(View paramView, ActionBar.LayoutParams paramLayoutParams) {}
  
  public final int bu()
  {
    return 0;
  }
  
  public final View getCustomView()
  {
    return this.oW;
  }
  
  public final int getHeight()
  {
    return 0;
  }
  
  public final CharSequence getTitle()
  {
    return (CharSequence)"";
  }
  
  public final void hide()
  {
    AppMethodBeat.i(249996);
    this.afQn.hideActionBar();
    AppMethodBeat.o(249996);
  }
  
  public final boolean isShowing()
  {
    return false;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable) {}
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(249937);
    View localView = this.oW;
    if (localView != null) {
      this.afQo.removeView(localView);
    }
    if (paramView != null) {
      this.afQo.addView(paramView);
    }
    this.oW = paramView;
    AppMethodBeat.o(249937);
  }
  
  public final void setIcon(int paramInt) {}
  
  public final void setLogo(Drawable paramDrawable) {}
  
  public final void show() {}
  
  public final void v(boolean paramBoolean) {}
  
  public final void w(boolean paramBoolean) {}
  
  public final void x(boolean paramBoolean) {}
  
  public final void y(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.vas.b
 * JD-Core Version:    0.7.0.1
 */