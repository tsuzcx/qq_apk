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
import androidx.fragment.app.FragmentManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.WXActionMenuView;
import com.tencent.mm.ui.widget.WXActionMenuView.a;
import com.tencent.mm.ui.widget.WXActionMenuView.b;
import com.tencent.mm.ui.y;
import java.lang.reflect.Method;
import java.util.List;

public final class a
{
  public s Vtk;
  public int afCZ;
  public WXActionMenuView.a afDa;
  public boolean afDb;
  private int afDc;
  private int afDd;
  private ViewGroup afDe;
  
  public a(Activity paramActivity, WXActionMenuView.a parama)
  {
    AppMethodBeat.i(251036);
    this.afDb = false;
    this.Vtk = new s(paramActivity);
    this.afDa = parama;
    parama = paramActivity.getResources();
    if (nD(paramActivity)) {}
    for (int i = a.e.DefaultActionbarHeightLand;; i = a.e.DefaultActionbarHeightPort)
    {
      this.afCZ = com.tencent.mm.compatible.util.a.c(paramActivity, (int)parama.getDimension(i));
      this.afDc = (this.afCZ * 3);
      this.afDd = ((int)paramActivity.getResources().getDimension(a.e.back_icon_common_width));
      Log.i("MicroMsg.ActionBarMenuViewHelper", "mDefaultNormalActionbarHeight: %s, needTitleCenterMode: %s.", new Object[] { Integer.valueOf(this.afCZ), Boolean.valueOf(this.afDa.afWk) });
      AppMethodBeat.o(251036);
      return;
    }
  }
  
  private int a(ViewGroup paramViewGroup, Activity paramActivity, int paramInt, View paramView)
  {
    AppMethodBeat.i(251042);
    int k = paramViewGroup.getMeasuredWidth();
    int j = ma(paramView);
    Log.i("MicroMsg.ActionBarMenuViewHelper", "getAvailableWidth, padding is %s, maxPadding: %s, minPadding: %s, backWidth:%s, visibleItemCount:%s.", new Object[] { Integer.valueOf(k), Integer.valueOf(this.afDc), Integer.valueOf(this.afDd), Integer.valueOf(j), Integer.valueOf(paramInt) });
    if (this.afDc == 0)
    {
      paramViewGroup = paramActivity.getResources();
      if (nD(paramActivity))
      {
        i = a.e.DefaultActionbarHeightLand;
        this.afCZ = ((int)paramViewGroup.getDimension(i));
        this.afDc = (this.afCZ * 3);
      }
    }
    else
    {
      if (k <= this.afDc) {
        break label181;
      }
    }
    label181:
    for (int i = this.afCZ * paramInt;; i = k)
    {
      paramInt = i;
      if (i < this.afDd) {
        paramInt = this.afDd;
      }
      i = paramInt;
      if (j > paramInt) {
        i = j;
      }
      AppMethodBeat.o(251042);
      return i;
      i = a.e.DefaultActionbarHeightPort;
      break;
    }
  }
  
  private void a(ActionBar paramActionBar, int paramInt)
  {
    AppMethodBeat.i(251050);
    if (!this.afDa.afWk)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "checkTitleSize, no need TitleCenterMode.");
      AppMethodBeat.o(251050);
      return;
    }
    paramActionBar = paramActionBar.getCustomView().findViewById(a.g.actionbar_center_layout);
    if (paramActionBar == null)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "checkTitleSize, centerLayout is null");
      AppMethodBeat.o(251050);
      return;
    }
    Log.i("MicroMsg.ActionBarMenuViewHelper", "checkTitleSize, padding = %s.", new Object[] { Integer.valueOf(paramInt) });
    paramInt = Math.min(this.afDc, paramInt);
    Log.i("MicroMsg.ActionBarMenuViewHelper", "checkTitleSize, min padding = %s.", new Object[] { Integer.valueOf(paramInt) });
    paramActionBar.setPadding(paramInt, 0, paramInt, 0);
    AppMethodBeat.o(251050);
  }
  
  private static void a(AppCompatActivity paramAppCompatActivity, y paramy, Menu paramMenu)
  {
    AppMethodBeat.i(251045);
    if (paramy.jjN())
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "clearMenu, isFromFragment");
      paramMenu.clear();
      AppMethodBeat.o(251045);
      return;
    }
    paramAppCompatActivity = paramAppCompatActivity.getSupportFragmentManager().getFragments();
    if ((paramAppCompatActivity == null) || (paramAppCompatActivity.size() <= 0))
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "clearMenu, iFragment no has size");
      paramMenu.clear();
      AppMethodBeat.o(251045);
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
      paramy = (Fragment)paramAppCompatActivity.get(i);
      if ((paramy instanceof MMFragment))
      {
        bool1 = z((MMFragment)paramy);
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
    AppMethodBeat.o(251045);
  }
  
  public static boolean a(Activity paramActivity, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(251048);
    if (paramActivity != null)
    {
      paramActivity.onOptionsItemSelected(paramMenuItem);
      AppMethodBeat.o(251048);
      return true;
    }
    AppMethodBeat.o(251048);
    return false;
  }
  
  private int ma(View paramView)
  {
    AppMethodBeat.i(251040);
    View localView = paramView.findViewById(a.g.actionbar_up_indicator);
    int i = (int)paramView.getResources().getDimension(a.e.back_icon_common_width);
    if (localView != null) {
      i = localView.getMeasuredWidth();
    }
    if (i > this.afDd)
    {
      AppMethodBeat.o(251040);
      return i;
    }
    i = this.afDd;
    AppMethodBeat.o(251040);
    return i;
  }
  
  private static boolean nD(Context paramContext)
  {
    AppMethodBeat.i(251038);
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(251038);
      return true;
    }
    AppMethodBeat.o(251038);
    return false;
  }
  
  private static boolean z(Fragment paramFragment)
  {
    AppMethodBeat.i(251046);
    try
    {
      Object localObject = paramFragment.getClass().newInstance();
      boolean bool = ((Boolean)paramFragment.getClass().getMethod("hasOptionsMenu", new Class[0]).invoke(localObject, new Object[0])).booleanValue();
      AppMethodBeat.o(251046);
      return bool;
    }
    catch (Exception paramFragment)
    {
      AppMethodBeat.o(251046);
    }
    return false;
  }
  
  public final void a(AppCompatActivity paramAppCompatActivity, Menu paramMenu, y paramy)
  {
    AppMethodBeat.i(251061);
    this.afDb = false;
    Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu");
    if (paramAppCompatActivity == null)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu, activity is null | mActionBar is null.");
      AppMethodBeat.o(251061);
      return;
    }
    if (paramMenu == null)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu, menu = null");
      AppMethodBeat.o(251061);
      return;
    }
    if (this.afDa.afWl)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu, useOrginalSysMode.");
      AppMethodBeat.o(251061);
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
    if ((i >= this.afDa.afWj) && (this.afDa.afWk))
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu, menu is null visibleItemCount: %s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(251061);
      return;
    }
    ActionBar localActionBar = paramy.getSupportActionBar();
    if (localActionBar == null)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu, actionBar is null");
      AppMethodBeat.o(251061);
      return;
    }
    View localView = localActionBar.getCustomView();
    if (localView == null)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu, customView is null");
      AppMethodBeat.o(251061);
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)localView.findViewById(a.g.custom_menu_container);
    if (localViewGroup == null)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu, WXMenus is null");
      AppMethodBeat.o(251061);
      return;
    }
    if (!paramy.jjN())
    {
      this.Vtk.adRW.clear();
      localViewGroup.removeAllViews();
      Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu, is no FromFragment.");
    }
    if (paramMenu.size() <= 0)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu, menu size is 0");
      AppMethodBeat.o(251061);
      return;
    }
    this.Vtk.adRW.clear();
    localViewGroup.removeAllViews();
    this.afDb = true;
    Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu, menu = " + paramMenu.size());
    j = 0;
    while (j < paramMenu.size())
    {
      localObject = paramMenu.getItem(j);
      if (localObject != null)
      {
        this.Vtk.j((MenuItem)localObject);
        if (!((MenuItem)localObject).isVisible()) {
          Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menuItem is unenble.");
        }
      }
      else
      {
        j += 1;
        continue;
      }
      Log.i("MicroMsg.ActionBarMenuViewHelper", "on create options menu, menuItem is %s, searchViewHelper: %s.,", new Object[] { localObject, paramy.lMw });
      if ((((MenuItem)localObject).getItemId() == a.g.menu_search) && (paramy.lMw != null)) {}
      for (localObject = WXActionMenuView.a(paramAppCompatActivity, (MenuItem)localObject, this.afDa, new WXActionMenuView.b()
          {
            public final boolean b(Activity paramAnonymousActivity, MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(251146);
              boolean bool = a.a(paramAnonymousActivity, paramAnonymousMenuItem);
              AppMethodBeat.o(251146);
              return bool;
            }
          }, paramy);; localObject = WXActionMenuView.a(paramAppCompatActivity, (MenuItem)localObject, this.afDa, new WXActionMenuView.b()
          {
            public final boolean b(Activity paramAnonymousActivity, MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(251145);
              boolean bool = a.a(paramAnonymousActivity, paramAnonymousMenuItem);
              AppMethodBeat.o(251145);
              return bool;
            }
          }))
      {
        localViewGroup.addView((View)localObject);
        break;
      }
    }
    this.afDe = localViewGroup;
    i = a(localViewGroup, paramAppCompatActivity, i, localView);
    a(paramAppCompatActivity, paramy, paramMenu);
    a(localActionBar, i);
    AppMethodBeat.o(251061);
  }
  
  public final void b(ActionBar paramActionBar)
  {
    AppMethodBeat.i(251055);
    Log.i("MicroMsg.ActionBarMenuViewHelper", "resetStatus, actionBar is %s.", new Object[] { paramActionBar });
    this.afDb = false;
    this.Vtk.adRW.clear();
    if (paramActionBar == null)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "resetStatus, actionBar is null");
      AppMethodBeat.o(251055);
      return;
    }
    paramActionBar = paramActionBar.getCustomView();
    if (paramActionBar == null)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "resetStatus, customView is null");
      AppMethodBeat.o(251055);
      return;
    }
    paramActionBar = (ViewGroup)paramActionBar.findViewById(a.g.custom_menu_container);
    if (paramActionBar == null)
    {
      Log.i("MicroMsg.ActionBarMenuViewHelper", "resetStatus, WXMenus is null");
      AppMethodBeat.o(251055);
      return;
    }
    paramActionBar.removeAllViews();
    AppMethodBeat.o(251055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.tools.a
 * JD-Core Version:    0.7.0.1
 */