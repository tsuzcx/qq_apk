package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBar.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends ActionBar
{
  private ActionBar YaD;
  private View YaE;
  
  private d(ActionBar paramActionBar)
  {
    this.YaD = paramActionBar;
  }
  
  public static ActionBar c(ActionBar paramActionBar)
  {
    AppMethodBeat.i(194456);
    if (paramActionBar == null)
    {
      AppMethodBeat.o(194456);
      return paramActionBar;
    }
    paramActionBar = new d(paramActionBar);
    AppMethodBeat.o(194456);
    return paramActionBar;
  }
  
  private void hZr()
  {
    AppMethodBeat.i(194468);
    if (this.YaD.getCustomView() == null)
    {
      Log.i("MicroMsg.MMActionBarProxy", "updateMenuView, getCustomView is null.");
      this.YaE = null;
      AppMethodBeat.o(194468);
      return;
    }
    Object localObject = (ViewGroup)this.YaD.getCustomView().findViewById(a.g.custom_menu_container_outside);
    if (localObject == null)
    {
      this.YaE = null;
      Log.i("MicroMsg.MMActionBarProxy", "preSetCustomView, mActionbar.customMenuContainerOutside is null.");
      AppMethodBeat.o(194468);
      return;
    }
    localObject = ((ViewGroup)localObject).findViewById(a.g.custom_menu_container);
    if (!(localObject instanceof ViewGroup))
    {
      this.YaE = null;
      Log.i("MicroMsg.MMActionBarProxy", "preSetCustomView, menuView no instanceof ViewGroup.");
      AppMethodBeat.o(194468);
      return;
    }
    Log.i("MicroMsg.MMActionBarProxy", "preSetCustomView,, ((ViewGroup)menuView).getChildCount(): " + ((ViewGroup)localObject).getChildCount() + ", menuView = " + localObject);
    this.YaE = ((View)localObject).findViewById(a.g.custom_menu_container);
    iH(this.YaE);
    Log.i("MicroMsg.MMActionBarProxy", "preSetCustomView, menuViewCache: " + this.YaE);
    AppMethodBeat.o(194468);
  }
  
  private void hZs()
  {
    AppMethodBeat.i(194473);
    Object localObject = this.YaD.getCustomView();
    if (localObject == null)
    {
      Log.i("MicroMsg.MMActionBarProxy", "updateMenuView, getCustomView is null.");
      AppMethodBeat.o(194473);
      return;
    }
    localObject = (ViewGroup)((View)localObject).findViewById(a.g.custom_menu_container_outside);
    if (localObject == null)
    {
      Log.i("MicroMsg.MMActionBarProxy", "updateMenuView, customMenuContainerOutside is null.");
      AppMethodBeat.o(194473);
      return;
    }
    if (!(this.YaE instanceof ViewGroup))
    {
      Log.i("MicroMsg.MMActionBarProxy", "preSetCustomView, menuView no instanceof ViewGroup.");
      AppMethodBeat.o(194473);
      return;
    }
    Log.i("MicroMsg.MMActionBarProxy", "updateMenuView, menuViewCache = ." + this.YaE + ", menuView childCount = " + ((ViewGroup)this.YaE).getChildCount() + ", customMenuContainerOutside = " + localObject);
    iH(this.YaE);
    ((ViewGroup)localObject).removeAllViews();
    ((ViewGroup)localObject).addView(this.YaE);
    AppMethodBeat.o(194473);
  }
  
  private static void iH(View paramView)
  {
    AppMethodBeat.i(194475);
    if ((paramView.getParent() instanceof ViewGroup))
    {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
      Log.i("MicroMsg.MMActionBarProxy", "removeParentHold, menuView is hasparent, has ? " + paramView.getParent());
    }
    AppMethodBeat.o(194475);
  }
  
  public final void N(int paramInt)
  {
    AppMethodBeat.i(194463);
    hZr();
    this.YaD.N(paramInt);
    hZs();
    AppMethodBeat.o(194463);
  }
  
  public final void O(int paramInt)
  {
    AppMethodBeat.i(194481);
    this.YaD.O(paramInt);
    AppMethodBeat.o(194481);
  }
  
  public final void a(View paramView, ActionBar.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(194460);
    hZr();
    this.YaD.a(paramView, paramLayoutParams);
    hZs();
    AppMethodBeat.o(194460);
  }
  
  public final int aC()
  {
    AppMethodBeat.i(194499);
    int i = this.YaD.aC();
    AppMethodBeat.o(194499);
    return i;
  }
  
  public final Context aD()
  {
    AppMethodBeat.i(194508);
    Context localContext = this.YaD.aD();
    AppMethodBeat.o(194508);
    return localContext;
  }
  
  public final void e(float paramFloat)
  {
    AppMethodBeat.i(194512);
    this.YaD.e(paramFloat);
    AppMethodBeat.o(194512);
  }
  
  public final View getCustomView()
  {
    AppMethodBeat.i(194494);
    View localView = this.YaD.getCustomView();
    AppMethodBeat.o(194494);
    return localView;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(194501);
    int i = this.YaD.getHeight();
    AppMethodBeat.o(194501);
    return i;
  }
  
  public final CharSequence getTitle()
  {
    AppMethodBeat.i(194498);
    CharSequence localCharSequence = this.YaD.getTitle();
    AppMethodBeat.o(194498);
    return localCharSequence;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(194504);
    this.YaD.hide();
    AppMethodBeat.o(194504);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(194507);
    boolean bool = this.YaD.isShowing();
    AppMethodBeat.o(194507);
    return bool;
  }
  
  public final void r(boolean paramBoolean)
  {
    AppMethodBeat.i(194483);
    this.YaD.r(paramBoolean);
    AppMethodBeat.o(194483);
  }
  
  public final void s(boolean paramBoolean)
  {
    AppMethodBeat.i(194485);
    this.YaD.s(paramBoolean);
    AppMethodBeat.o(194485);
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(194492);
    this.YaD.setBackgroundDrawable(paramDrawable);
    AppMethodBeat.o(194492);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(194459);
    hZr();
    this.YaD.setCustomView(paramView);
    hZs();
    AppMethodBeat.o(194459);
  }
  
  public final void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(194509);
    this.YaD.setHideOnContentScrollEnabled(paramBoolean);
    AppMethodBeat.o(194509);
  }
  
  public final void setIcon(int paramInt)
  {
    AppMethodBeat.i(194476);
    this.YaD.setIcon(paramInt);
    AppMethodBeat.o(194476);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    AppMethodBeat.i(194479);
    this.YaD.setLogo(paramDrawable);
    AppMethodBeat.o(194479);
  }
  
  public final void show()
  {
    AppMethodBeat.i(194503);
    this.YaD.show();
    AppMethodBeat.o(194503);
  }
  
  public final void t(boolean paramBoolean)
  {
    AppMethodBeat.i(194487);
    this.YaD.t(paramBoolean);
    AppMethodBeat.o(194487);
  }
  
  public final void u(boolean paramBoolean)
  {
    AppMethodBeat.i(194490);
    this.YaD.u(paramBoolean);
    AppMethodBeat.o(194490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */