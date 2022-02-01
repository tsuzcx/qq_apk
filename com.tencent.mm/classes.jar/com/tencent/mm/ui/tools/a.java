package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.WXActionMenuView;
import com.tencent.mm.ui.widget.WXActionMenuView.a;
import com.tencent.mm.ui.widget.WXActionMenuView.b;
import java.lang.reflect.Method;
import java.util.List;

public final class a
{
  public o ODY;
  public int XMM;
  public WXActionMenuView.a XMN;
  public boolean XMO;
  private int XMP;
  private int XMQ;
  private ViewGroup XMR;
  
  public a(Activity paramActivity, WXActionMenuView.a parama)
  {
    AppMethodBeat.i(206228);
    this.XMO = false;
    this.ODY = new o(paramActivity);
    this.XMN = parama;
    parama = paramActivity.getResources();
    if (lA(paramActivity)) {}
    for (int i = a.e.DefaultActionbarHeightLand;; i = a.e.DefaultActionbarHeightPort)
    {
      this.XMM = com.tencent.mm.compatible.util.a.c(paramActivity, (int)parama.getDimension(i));
      this.XMP = (this.XMM * 3);
      this.XMQ = ((int)paramActivity.getResources().getDimension(a.e.back_icon_common_width));
      Log.i("MicroMsg.ActionBarMenuViewHelper", "mDefaultNormalActionbarHeight: %s, needTitleCenterMode: %s.", new Object[] { Integer.valueOf(this.XMM), Boolean.valueOf(this.XMN.Yer) });
      AppMethodBeat.o(206228);
      return;
    }
  }
  
  private int a(ViewGroup paramViewGroup, Activity paramActivity, int paramInt, View paramView)
  {
    AppMethodBeat.i(206235);
    int k = paramViewGroup.getMeasuredWidth();
    int j = iE(paramView);
    Log.i("MicroMsg.ActionBarMenuViewHelper", "getAvailableWidth, padding is %s, maxPadding: %s, minPadding: %s, backWidth:%s, visibleItemCount:%s.", new Object[] { Integer.valueOf(k), Integer.valueOf(this.XMP), Integer.valueOf(this.XMQ), Integer.valueOf(j), Integer.valueOf(paramInt) });
    if (this.XMP == 0)
    {
      paramViewGroup = paramActivity.getResources();
      if (lA(paramActivity))
      {
        i = a.e.DefaultActionbarHeightLand;
        this.XMM = ((int)paramViewGroup.getDimension(i));
        this.XMP = (this.XMM * 3);
      }
    }
    else
    {
      if (k <= this.XMP) {
        break label181;
      }
    }
    label181:
    for (int i = this.XMM * paramInt;; i = k)
    {
      paramInt = i;
      if (i < this.XMQ) {
        paramInt = this.XMQ;
      }
      i = paramInt;
      if (j > paramInt) {
        i = j;
      }
      AppMethodBeat.o(206235);
      return i;
      i = a.e.DefaultActionbarHeightPort;
      break;
    }
  }
  
  private void a(ActionBar paramActionBar, int paramInt)
  {
    AppMethodBeat.i(206240);
    if (!this.XMN.Yer)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "checkTitleSize, no need TitleCenterMode.");
      AppMethodBeat.o(206240);
      return;
    }
    paramActionBar = paramActionBar.getCustomView().findViewById(a.g.actionbar_center_layout);
    if (paramActionBar == null)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "checkTitleSize, centerLayout is null");
      AppMethodBeat.o(206240);
      return;
    }
    Log.i("MicroMsg.ActionBarMenuViewHelper", "checkTitleSize, padding = %s.", new Object[] { Integer.valueOf(paramInt) });
    paramInt = Math.min(this.XMP, paramInt);
    Log.i("MicroMsg.ActionBarMenuViewHelper", "checkTitleSize, min padding = %s.", new Object[] { Integer.valueOf(paramInt) });
    paramActionBar.setPadding(paramInt, 0, paramInt, 0);
    AppMethodBeat.o(206240);
  }
  
  private static void a(AppCompatActivity paramAppCompatActivity, w paramw, Menu paramMenu)
  {
    AppMethodBeat.i(206237);
    if (paramw.hHD())
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "clearMenu, isFromFragment");
      paramMenu.clear();
      AppMethodBeat.o(206237);
      return;
    }
    paramAppCompatActivity = paramAppCompatActivity.getSupportFragmentManager().getFragments();
    if ((paramAppCompatActivity == null) || (paramAppCompatActivity.size() <= 0))
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "clearMenu, iFragment no has size");
      paramMenu.clear();
      AppMethodBeat.o(206237);
      return;
    }
    Log.i("MicroMsg.ActionBarMenuViewHelper", "clearMenu, fragments.size(): %s.", new Object[] { Integer.valueOf(paramAppCompatActivity.size()) });
    int i = 0;
    boolean bool1 = false;
    boolean bool2;
    for (;;)
    {
      bool2 = bool1;
      if (i >= paramAppCompatActivity.size()) {
        break;
      }
      paramw = (Fragment)paramAppCompatActivity.get(i);
      if ((paramw instanceof MMFragment))
      {
        bool1 = i((MMFragment)paramw);
        Log.i("MicroMsg.ActionBarMenuViewHelper", "clearMenu, getHasOptionMenu: %s.", new Object[] { Boolean.valueOf(bool1) });
        bool2 = bool1;
        if (bool1) {
          break;
        }
      }
      i += 1;
    }
    if (!bool2) {
      paramMenu.clear();
    }
    Log.i("MicroMsg.ActionBarMenuViewHelper", "clearMenu, iFragment has size, noNeedClear: %s.", new Object[] { Boolean.valueOf(bool2) });
    AppMethodBeat.o(206237);
  }
  
  public static boolean a(Activity paramActivity, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(206239);
    if (paramActivity != null)
    {
      paramActivity.onOptionsItemSelected(paramMenuItem);
      AppMethodBeat.o(206239);
      return true;
    }
    AppMethodBeat.o(206239);
    return false;
  }
  
  private static boolean i(Fragment paramFragment)
  {
    AppMethodBeat.i(206238);
    try
    {
      Object localObject = paramFragment.getClass().newInstance();
      boolean bool = ((Boolean)paramFragment.getClass().getMethod("hasOptionsMenu", new Class[0]).invoke(localObject, new Object[0])).booleanValue();
      AppMethodBeat.o(206238);
      return bool;
    }
    catch (Exception paramFragment)
    {
      AppMethodBeat.o(206238);
    }
    return false;
  }
  
  private int iE(View paramView)
  {
    AppMethodBeat.i(206234);
    View localView = paramView.findViewById(a.g.actionbar_up_indicator);
    int i = (int)paramView.getResources().getDimension(a.e.back_icon_common_width);
    if (localView != null) {
      i = localView.getMeasuredWidth();
    }
    if (i > this.XMQ)
    {
      AppMethodBeat.o(206234);
      return i;
    }
    i = this.XMQ;
    AppMethodBeat.o(206234);
    return i;
  }
  
  private static boolean lA(Context paramContext)
  {
    AppMethodBeat.i(206230);
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(206230);
      return true;
    }
    AppMethodBeat.o(206230);
    return false;
  }
  
  public final void a(AppCompatActivity paramAppCompatActivity, Menu paramMenu, w paramw)
  {
    AppMethodBeat.i(206232);
    this.XMO = false;
    Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu");
    if (paramAppCompatActivity == null)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu, activity is null | mActionBar is null.");
      AppMethodBeat.o(206232);
      return;
    }
    if (paramMenu == null)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu, menu = null");
      AppMethodBeat.o(206232);
      return;
    }
    if (this.XMN.Yes)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu, useOrginalSysMode.");
      AppMethodBeat.o(206232);
      return;
    }
    int i = 0;
    int j = 0;
    Object localObject;
    while (j < paramMenu.size())
    {
      localObject = paramMenu.getItem(j);
      int k = i;
      if (localObject != null)
      {
        k = i;
        if (((MenuItem)localObject).isVisible()) {
          k = i + 1;
        }
      }
      j += 1;
      i = k;
    }
    if ((i >= this.XMN.Yeq) && (this.XMN.Yer))
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu, menu is null visibleItemCount: %s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(206232);
      return;
    }
    ActionBar localActionBar = paramw.getSupportActionBar();
    if (localActionBar == null)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu, actionBar is null");
      AppMethodBeat.o(206232);
      return;
    }
    View localView = localActionBar.getCustomView();
    if (localView == null)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu, customView is null");
      AppMethodBeat.o(206232);
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)localView.findViewById(a.g.custom_menu_container);
    if (localViewGroup == null)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu, WXMenus is null");
      AppMethodBeat.o(206232);
      return;
    }
    if (!paramw.hHD())
    {
      this.ODY.WkP.clear();
      localViewGroup.removeAllViews();
      Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu, is no FromFragment.");
    }
    if (paramMenu.size() <= 0)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu, menu size is 0");
      AppMethodBeat.o(206232);
      return;
    }
    this.ODY.WkP.clear();
    localViewGroup.removeAllViews();
    this.XMO = true;
    Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu, menu = " + paramMenu.size());
    j = 0;
    while (j < paramMenu.size())
    {
      localObject = paramMenu.getItem(j);
      if (localObject != null)
      {
        this.ODY.h((MenuItem)localObject);
        if (!((MenuItem)localObject).isVisible()) {
          Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menuItem is unenble.");
        }
      }
      else
      {
        j += 1;
        continue;
      }
      Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu, menuItem is %s, searchViewHelper: %s.,", new Object[] { localObject, paramw.jjS });
      if ((((MenuItem)localObject).getItemId() == a.g.menu_search) && (paramw.jjS != null)) {}
      for (localObject = WXActionMenuView.a(paramAppCompatActivity, (MenuItem)localObject, this.XMN, new WXActionMenuView.b()
          {
            public final boolean b(Activity paramAnonymousActivity, MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(189326);
              boolean bool = a.a(paramAnonymousActivity, paramAnonymousMenuItem);
              AppMethodBeat.o(189326);
              return bool;
            }
          }, paramw);; localObject = WXActionMenuView.a(paramAppCompatActivity, (MenuItem)localObject, this.XMN, new WXActionMenuView.b()
          {
            public final boolean b(Activity paramAnonymousActivity, MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(205797);
              boolean bool = a.a(paramAnonymousActivity, paramAnonymousMenuItem);
              AppMethodBeat.o(205797);
              return bool;
            }
          }))
      {
        localViewGroup.addView((View)localObject);
        break;
      }
    }
    this.XMR = localViewGroup;
    i = a(localViewGroup, paramAppCompatActivity, i, localView);
    a(paramAppCompatActivity, paramw, paramMenu);
    a(localActionBar, i);
    AppMethodBeat.o(206232);
  }
  
  public final void b(ActionBar paramActionBar)
  {
    AppMethodBeat.i(206231);
    Log.i("MicroMsg.ActionBarMenuViewHelper", "resetStatus, actionBar is %s.", new Object[] { paramActionBar });
    this.XMO = false;
    this.ODY.WkP.clear();
    if (paramActionBar == null)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "resetStatus, actionBar is null");
      AppMethodBeat.o(206231);
      return;
    }
    paramActionBar = paramActionBar.getCustomView();
    if (paramActionBar == null)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "resetStatus, customView is null");
      AppMethodBeat.o(206231);
      return;
    }
    paramActionBar = (ViewGroup)paramActionBar.findViewById(a.g.custom_menu_container);
    if (paramActionBar == null)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "resetStatus, WXMenus is null");
      AppMethodBeat.o(206231);
      return;
    }
    paramActionBar.removeAllViews();
    AppMethodBeat.o(206231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.a
 * JD-Core Version:    0.7.0.1
 */