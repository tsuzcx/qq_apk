package com.tencent.mm.ui.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class m
  implements ContextMenu
{
  public List<MenuItem> ORD;
  public CharSequence agy;
  public Context mContext;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(159211);
    this.mContext = paramContext;
    this.ORD = new ArrayList();
    AppMethodBeat.o(159211);
  }
  
  public final MenuItem a(int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159229);
    n localn = new n(this.mContext, paramInt1, 0);
    paramCharSequence = new SpannableString(paramCharSequence);
    paramCharSequence.setSpan(new ForegroundColorSpan(paramInt2), 0, paramCharSequence.length(), 0);
    localn.setTitle(paramCharSequence);
    this.ORD.add(localn);
    AppMethodBeat.o(159229);
    return localn;
  }
  
  public final MenuItem a(int paramInt1, int paramInt2, CharSequence paramCharSequence, int paramInt3)
  {
    AppMethodBeat.i(198200);
    n localn = new n(this.mContext, paramInt2, paramInt1);
    localn.setTitle(paramCharSequence);
    localn.setIcon(paramInt3);
    this.ORD.add(localn);
    AppMethodBeat.o(198200);
    return localn;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159227);
    n localn = new n(this.mContext, paramInt1, 0);
    localn.setTitle(paramCharSequence);
    localn.kW(paramInt2, paramInt3);
    this.ORD.add(localn);
    AppMethodBeat.o(159227);
    return localn;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(159228);
    n localn = new n(this.mContext, paramInt1, 0);
    localn.setTitle(paramCharSequence);
    localn.kW(paramInt2, paramInt3);
    localn.neT = paramBoolean;
    this.ORD.add(localn);
    AppMethodBeat.o(159228);
    return localn;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(159221);
    n localn = new n(this.mContext, paramInt1, 0);
    localn.setTitle(paramCharSequence);
    localn.setIcon(paramInt2);
    localn.neT = paramBoolean;
    this.ORD.add(localn);
    AppMethodBeat.o(159221);
    return localn;
  }
  
  public final MenuItem a(int paramInt, CharSequence paramCharSequence, Drawable paramDrawable)
  {
    AppMethodBeat.i(159218);
    n localn = new n(this.mContext, paramInt, 0);
    localn.setTitle(paramCharSequence);
    localn.setIcon(paramDrawable);
    this.ORD.add(localn);
    AppMethodBeat.o(159218);
    return localn;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt2)
  {
    AppMethodBeat.i(159222);
    n localn = new n(this.mContext, paramInt1, 0);
    localn.setTitle(paramCharSequence1);
    localn.xdb = paramCharSequence2;
    localn.setIcon(paramInt2);
    this.ORD.add(localn);
    AppMethodBeat.o(159222);
    return localn;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence1, CharSequence paramCharSequence2, Drawable paramDrawable, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(198201);
    n localn = new n(this.mContext, paramInt1, 0);
    localn.setTitle(paramCharSequence1);
    localn.xdb = paramCharSequence2;
    localn.f(paramDrawable, paramInt2);
    localn.neT = paramBoolean;
    this.ORD.add(localn);
    AppMethodBeat.o(198201);
    return localn;
  }
  
  public final MenuItem a(int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2, Drawable paramDrawable, boolean paramBoolean)
  {
    AppMethodBeat.i(159219);
    n localn = new n(this.mContext, paramInt, 0);
    localn.setTitle(paramCharSequence1);
    localn.xdb = paramCharSequence2;
    localn.setIcon(paramDrawable);
    localn.neT = paramBoolean;
    this.ORD.add(localn);
    AppMethodBeat.o(159219);
    return localn;
  }
  
  public final MenuItem a(int paramInt, CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(179496);
    n localn = new n(this.mContext, paramInt, 0);
    localn.ORE = paramBoolean;
    localn.eaY = false;
    localn.setTitle(paramCharSequence);
    this.ORD.add(localn);
    AppMethodBeat.o(179496);
    return localn;
  }
  
  public final MenuItem a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    AppMethodBeat.i(198204);
    n localn = new n(this.mContext, 3, 0);
    localn.setTitle(paramCharSequence1);
    localn.xdb = paramCharSequence2;
    localn.kW(0, paramInt);
    this.ORD.add(localn);
    AppMethodBeat.o(198204);
    return localn;
  }
  
  public final MenuItem aS(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159217);
    n localn = new n(this.mContext, paramInt1, 0);
    localn.setTitle(paramInt2);
    localn.setIcon(paramInt3);
    this.ORD.add(localn);
    AppMethodBeat.o(159217);
    return localn;
  }
  
  public final MenuItem add(int paramInt)
  {
    AppMethodBeat.i(159215);
    n localn = new n(this.mContext, 0, 0);
    localn.setTitle(paramInt);
    this.ORD.add(localn);
    AppMethodBeat.o(159215);
    return localn;
  }
  
  public final MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159213);
    n localn = new n(this.mContext, paramInt2, paramInt1);
    localn.setTitle(paramInt4);
    this.ORD.add(localn);
    AppMethodBeat.o(159213);
    return localn;
  }
  
  public final MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159214);
    n localn = new n(this.mContext, paramInt2, paramInt1);
    localn.setTitle(paramCharSequence);
    this.ORD.add(localn);
    AppMethodBeat.o(159214);
    return localn;
  }
  
  public final MenuItem add(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159216);
    n localn = new n(this.mContext, 0, 0);
    localn.setTitle(paramCharSequence);
    this.ORD.add(localn);
    AppMethodBeat.o(159216);
    return localn;
  }
  
  public final int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    return 0;
  }
  
  public final SubMenu addSubMenu(int paramInt)
  {
    return null;
  }
  
  public final SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return null;
  }
  
  public final SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return null;
  }
  
  public final SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return null;
  }
  
  public final List<MenuItem> avn()
  {
    return this.ORD;
  }
  
  public final MenuItem b(int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    AppMethodBeat.i(159226);
    n localn = new n(this.mContext, paramInt1, 0);
    localn.setTitle(paramCharSequence);
    localn.setIcon(paramInt2);
    this.ORD.add(localn);
    AppMethodBeat.o(159226);
    return localn;
  }
  
  public final MenuItem b(int paramInt, CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(198205);
    n localn = new n(this.mContext, 45, 0);
    localn.setTitle(paramCharSequence);
    localn.kW(0, 0);
    localn.neT = paramBoolean;
    this.ORD.add(paramInt, localn);
    AppMethodBeat.o(198205);
    return localn;
  }
  
  public final MenuItem c(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(198202);
    n localn = new n(this.mContext, paramInt, 0);
    localn.setTitle(paramCharSequence);
    localn.neT = false;
    this.ORD.add(localn);
    AppMethodBeat.o(198202);
    return localn;
  }
  
  public final MenuItem c(int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    AppMethodBeat.i(198203);
    n localn = new n(this.mContext, paramInt1, 0);
    localn.setTitle(paramCharSequence);
    localn.setIcon(paramInt2);
    localn.ORJ = true;
    this.ORD.add(localn);
    AppMethodBeat.o(198203);
    return localn;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(159232);
    Iterator localIterator = this.ORD.iterator();
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      ((n)localMenuItem).ORH = null;
      ((n)localMenuItem).setOnMenuItemClickListener(null);
    }
    this.ORD.clear();
    this.agy = null;
    AppMethodBeat.o(159232);
  }
  
  public final void clearHeader() {}
  
  public final void close() {}
  
  public final MenuItem d(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159224);
    n localn = new n(this.mContext, paramInt, 0);
    localn.setTitle(paramCharSequence);
    this.ORD.add(localn);
    AppMethodBeat.o(159224);
    return localn;
  }
  
  public final MenuItem findItem(int paramInt)
  {
    AppMethodBeat.i(159233);
    Iterator localIterator = this.ORD.iterator();
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      if (localMenuItem.getItemId() == paramInt)
      {
        AppMethodBeat.o(159233);
        return localMenuItem;
      }
    }
    AppMethodBeat.o(159233);
    return null;
  }
  
  public final MenuItem g(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(159230);
    if (paramMenuItem != null) {
      this.ORD.add(paramMenuItem);
    }
    AppMethodBeat.o(159230);
    return null;
  }
  
  public final boolean gKQ()
  {
    AppMethodBeat.i(159212);
    if (this.ORD.size() == 0)
    {
      AppMethodBeat.o(159212);
      return true;
    }
    AppMethodBeat.o(159212);
    return false;
  }
  
  public final int gKR()
  {
    AppMethodBeat.i(198206);
    Iterator localIterator = this.ORD.iterator();
    int i = -1;
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      int j = i + 1;
      i = j;
      if (localMenuItem.getItemId() == 7)
      {
        AppMethodBeat.o(198206);
        return j;
      }
    }
    AppMethodBeat.o(198206);
    return -1;
  }
  
  public final MenuItem getItem(int paramInt)
  {
    AppMethodBeat.i(159235);
    MenuItem localMenuItem = (MenuItem)this.ORD.get(paramInt);
    AppMethodBeat.o(159235);
    return localMenuItem;
  }
  
  public final boolean hasVisibleItems()
  {
    return false;
  }
  
  public final boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public final MenuItem kV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159223);
    n localn = new n(this.mContext, paramInt1, 0);
    localn.setTitle(paramInt2);
    this.ORD.add(localn);
    AppMethodBeat.o(159223);
    return localn;
  }
  
  public final boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public final boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    return false;
  }
  
  public final void removeGroup(int paramInt) {}
  
  public final void removeItem(int paramInt)
  {
    AppMethodBeat.i(159231);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.ORD.iterator();
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      if (localMenuItem.getItemId() == paramInt) {
        localArrayList.add(localMenuItem);
      }
    }
    this.ORD.removeAll(localArrayList);
    AppMethodBeat.o(159231);
  }
  
  public final void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void setGroupEnabled(int paramInt, boolean paramBoolean) {}
  
  public final void setGroupVisible(int paramInt, boolean paramBoolean) {}
  
  public final ContextMenu setHeaderIcon(int paramInt)
  {
    return this;
  }
  
  public final ContextMenu setHeaderIcon(Drawable paramDrawable)
  {
    return this;
  }
  
  public final ContextMenu setHeaderTitle(int paramInt)
  {
    AppMethodBeat.i(159236);
    if (paramInt > 0)
    {
      ContextMenu localContextMenu = setHeaderTitle(this.mContext.getString(paramInt));
      AppMethodBeat.o(159236);
      return localContextMenu;
    }
    AppMethodBeat.o(159236);
    return this;
  }
  
  public final ContextMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return this;
    }
    this.agy = paramCharSequence;
    return this;
  }
  
  public final ContextMenu setHeaderView(View paramView)
  {
    return this;
  }
  
  public final void setQwertyMode(boolean paramBoolean) {}
  
  public final int size()
  {
    AppMethodBeat.i(159234);
    if (this.ORD == null)
    {
      AppMethodBeat.o(159234);
      return 0;
    }
    int i = this.ORD.size();
    AppMethodBeat.o(159234);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.m
 * JD-Core Version:    0.7.0.1
 */