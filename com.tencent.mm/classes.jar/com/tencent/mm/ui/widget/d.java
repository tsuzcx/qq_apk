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
  private ActionBar afSu;
  private View afSv;
  
  private d(ActionBar paramActionBar)
  {
    this.afSu = paramActionBar;
  }
  
  public static ActionBar c(ActionBar paramActionBar)
  {
    AppMethodBeat.i(251569);
    if (paramActionBar == null)
    {
      AppMethodBeat.o(251569);
      return paramActionBar;
    }
    paramActionBar = new d(paramActionBar);
    AppMethodBeat.o(251569);
    return paramActionBar;
  }
  
  private void jEA()
  {
    AppMethodBeat.i(251575);
    if (this.afSu.getCustomView() == null)
    {
      Log.i("MicroMsg.MMActionBarProxy", "updateMenuView, getCustomView is null.");
      this.afSv = null;
      AppMethodBeat.o(251575);
      return;
    }
    Object localObject = (ViewGroup)this.afSu.getCustomView().findViewById(a.g.custom_menu_container_outside);
    if (localObject == null)
    {
      this.afSv = null;
      Log.i("MicroMsg.MMActionBarProxy", "preSetCustomView, mActionbar.customMenuContainerOutside is null.");
      AppMethodBeat.o(251575);
      return;
    }
    localObject = ((ViewGroup)localObject).findViewById(a.g.custom_menu_container);
    if (!(localObject instanceof ViewGroup))
    {
      this.afSv = null;
      Log.i("MicroMsg.MMActionBarProxy", "preSetCustomView, menuView no instanceof ViewGroup.");
      AppMethodBeat.o(251575);
      return;
    }
    Log.i("MicroMsg.MMActionBarProxy", "preSetCustomView,, ((ViewGroup)menuView).getChildCount(): " + ((ViewGroup)localObject).getChildCount() + ", menuView = " + localObject);
    this.afSv = ((View)localObject).findViewById(a.g.custom_menu_container);
    mc(this.afSv);
    Log.i("MicroMsg.MMActionBarProxy", "preSetCustomView, menuViewCache: " + this.afSv);
    AppMethodBeat.o(251575);
  }
  
  private void jEB()
  {
    AppMethodBeat.i(251579);
    Object localObject = this.afSu.getCustomView();
    if (localObject == null)
    {
      Log.i("MicroMsg.MMActionBarProxy", "updateMenuView, getCustomView is null.");
      AppMethodBeat.o(251579);
      return;
    }
    localObject = (ViewGroup)((View)localObject).findViewById(a.g.custom_menu_container_outside);
    if (localObject == null)
    {
      Log.i("MicroMsg.MMActionBarProxy", "updateMenuView, customMenuContainerOutside is null.");
      AppMethodBeat.o(251579);
      return;
    }
    if (!(this.afSv instanceof ViewGroup))
    {
      Log.i("MicroMsg.MMActionBarProxy", "preSetCustomView, menuView no instanceof ViewGroup.");
      AppMethodBeat.o(251579);
      return;
    }
    Log.i("MicroMsg.MMActionBarProxy", "updateMenuView, menuViewCache = ." + this.afSv + ", menuView childCount = " + ((ViewGroup)this.afSv).getChildCount() + ", customMenuContainerOutside = " + localObject);
    mc(this.afSv);
    ((ViewGroup)localObject).removeAllViews();
    ((ViewGroup)localObject).addView(this.afSv);
    AppMethodBeat.o(251579);
  }
  
  private static void mc(View paramView)
  {
    AppMethodBeat.i(251581);
    if ((paramView.getParent() instanceof ViewGroup))
    {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
      Log.i("MicroMsg.MMActionBarProxy", "removeParentHold, menuView is hasparent, has ? " + paramView.getParent());
    }
    AppMethodBeat.o(251581);
  }
  
  public final void L(int paramInt)
  {
    AppMethodBeat.i(251590);
    jEA();
    this.afSu.L(paramInt);
    jEB();
    AppMethodBeat.o(251590);
  }
  
  public final void M(int paramInt)
  {
    AppMethodBeat.i(251600);
    this.afSu.M(paramInt);
    AppMethodBeat.o(251600);
  }
  
  public final void a(View paramView, ActionBar.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(251586);
    jEA();
    this.afSu.a(paramView, paramLayoutParams);
    jEB();
    AppMethodBeat.o(251586);
  }
  
  public final int bu()
  {
    AppMethodBeat.i(251633);
    int i = this.afSu.bu();
    AppMethodBeat.o(251633);
    return i;
  }
  
  public final Context bw()
  {
    AppMethodBeat.i(251653);
    Context localContext = this.afSu.bw();
    AppMethodBeat.o(251653);
    return localContext;
  }
  
  public final void g(float paramFloat)
  {
    AppMethodBeat.i(251663);
    this.afSu.g(paramFloat);
    AppMethodBeat.o(251663);
  }
  
  public final View getCustomView()
  {
    AppMethodBeat.i(251620);
    View localView = this.afSu.getCustomView();
    AppMethodBeat.o(251620);
    return localView;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(251638);
    int i = this.afSu.getHeight();
    AppMethodBeat.o(251638);
    return i;
  }
  
  public final CharSequence getTitle()
  {
    AppMethodBeat.i(251627);
    CharSequence localCharSequence = this.afSu.getTitle();
    AppMethodBeat.o(251627);
    return localCharSequence;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(251644);
    this.afSu.hide();
    AppMethodBeat.o(251644);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(251649);
    boolean bool = this.afSu.isShowing();
    AppMethodBeat.o(251649);
    return bool;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(251616);
    this.afSu.setBackgroundDrawable(paramDrawable);
    AppMethodBeat.o(251616);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(251582);
    jEA();
    this.afSu.setCustomView(paramView);
    jEB();
    AppMethodBeat.o(251582);
  }
  
  public final void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(251657);
    this.afSu.setHideOnContentScrollEnabled(paramBoolean);
    AppMethodBeat.o(251657);
  }
  
  public final void setIcon(int paramInt)
  {
    AppMethodBeat.i(251594);
    this.afSu.setIcon(paramInt);
    AppMethodBeat.o(251594);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    AppMethodBeat.i(251596);
    this.afSu.setLogo(paramDrawable);
    AppMethodBeat.o(251596);
  }
  
  public final void show()
  {
    AppMethodBeat.i(251642);
    this.afSu.show();
    AppMethodBeat.o(251642);
  }
  
  public final void v(boolean paramBoolean)
  {
    AppMethodBeat.i(251603);
    this.afSu.v(paramBoolean);
    AppMethodBeat.o(251603);
  }
  
  public final void w(boolean paramBoolean)
  {
    AppMethodBeat.i(251605);
    this.afSu.w(paramBoolean);
    AppMethodBeat.o(251605);
  }
  
  public final void x(boolean paramBoolean)
  {
    AppMethodBeat.i(251608);
    this.afSu.x(paramBoolean);
    AppMethodBeat.o(251608);
  }
  
  public final void y(boolean paramBoolean)
  {
    AppMethodBeat.i(251612);
    this.afSu.y(paramBoolean);
    AppMethodBeat.o(251612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */