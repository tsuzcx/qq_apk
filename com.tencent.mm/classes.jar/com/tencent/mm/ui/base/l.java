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

public final class l
  implements ContextMenu
{
  public List<MenuItem> FYt;
  public CharSequence adA;
  public Context mContext;
  
  public l(Context paramContext)
  {
    AppMethodBeat.i(159211);
    this.mContext = paramContext;
    this.FYt = new ArrayList();
    AppMethodBeat.o(159211);
  }
  
  public final MenuItem a(int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159229);
    m localm = new m(this.mContext, paramInt1, 0);
    paramCharSequence = new SpannableString(paramCharSequence);
    paramCharSequence.setSpan(new ForegroundColorSpan(paramInt2), 0, paramCharSequence.length(), 0);
    localm.setTitle(paramCharSequence);
    this.FYt.add(localm);
    AppMethodBeat.o(159229);
    return localm;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    AppMethodBeat.i(159226);
    m localm = new m(this.mContext, paramInt1, 0);
    localm.setTitle(paramCharSequence);
    localm.setIcon(paramInt2);
    this.FYt.add(localm);
    AppMethodBeat.o(159226);
    return localm;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159227);
    m localm = new m(this.mContext, paramInt1, 0);
    localm.setTitle(paramCharSequence);
    localm.jk(paramInt2, paramInt3);
    this.FYt.add(localm);
    AppMethodBeat.o(159227);
    return localm;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(159228);
    m localm = new m(this.mContext, paramInt1, 0);
    localm.setTitle(paramCharSequence);
    localm.jk(paramInt2, paramInt3);
    localm.kRX = paramBoolean;
    this.FYt.add(localm);
    AppMethodBeat.o(159228);
    return localm;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(159221);
    m localm = new m(this.mContext, paramInt1, 0);
    localm.setTitle(paramCharSequence);
    localm.setIcon(paramInt2);
    localm.kRX = paramBoolean;
    this.FYt.add(localm);
    AppMethodBeat.o(159221);
    return localm;
  }
  
  public final MenuItem a(int paramInt, CharSequence paramCharSequence, Drawable paramDrawable)
  {
    AppMethodBeat.i(159218);
    m localm = new m(this.mContext, paramInt, 0);
    localm.setTitle(paramCharSequence);
    localm.setIcon(paramDrawable);
    this.FYt.add(localm);
    AppMethodBeat.o(159218);
    return localm;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt2)
  {
    AppMethodBeat.i(159222);
    m localm = new m(this.mContext, paramInt1, 0);
    localm.setTitle(paramCharSequence1);
    localm.rvA = paramCharSequence2;
    localm.setIcon(paramInt2);
    this.FYt.add(localm);
    AppMethodBeat.o(159222);
    return localm;
  }
  
  public final MenuItem a(int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2, Drawable paramDrawable, boolean paramBoolean)
  {
    AppMethodBeat.i(159219);
    m localm = new m(this.mContext, paramInt, 0);
    localm.setTitle(paramCharSequence1);
    localm.rvA = paramCharSequence2;
    localm.setIcon(paramDrawable);
    localm.kRX = paramBoolean;
    this.FYt.add(localm);
    AppMethodBeat.o(159219);
    return localm;
  }
  
  public final MenuItem a(int paramInt, CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(179496);
    m localm = new m(this.mContext, paramInt, 0);
    localm.FYu = paramBoolean;
    localm.dyl = false;
    localm.setTitle(paramCharSequence);
    this.FYt.add(localm);
    AppMethodBeat.o(179496);
    return localm;
  }
  
  public final MenuItem aI(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159217);
    m localm = new m(this.mContext, paramInt1, 0);
    localm.setTitle(paramInt2);
    localm.setIcon(paramInt3);
    this.FYt.add(localm);
    AppMethodBeat.o(159217);
    return localm;
  }
  
  public final MenuItem add(int paramInt)
  {
    AppMethodBeat.i(159215);
    m localm = new m(this.mContext, 0, 0);
    localm.setTitle(paramInt);
    this.FYt.add(localm);
    AppMethodBeat.o(159215);
    return localm;
  }
  
  public final MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159213);
    m localm = new m(this.mContext, paramInt2, paramInt1);
    localm.setTitle(paramInt4);
    this.FYt.add(localm);
    AppMethodBeat.o(159213);
    return localm;
  }
  
  public final MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159214);
    m localm = new m(this.mContext, paramInt2, paramInt1);
    localm.setTitle(paramCharSequence);
    this.FYt.add(localm);
    AppMethodBeat.o(159214);
    return localm;
  }
  
  public final MenuItem add(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159216);
    m localm = new m(this.mContext, 0, 0);
    localm.setTitle(paramCharSequence);
    this.FYt.add(localm);
    AppMethodBeat.o(159216);
    return localm;
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
  
  public final MenuItem b(int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2, Drawable paramDrawable, boolean paramBoolean)
  {
    AppMethodBeat.i(159220);
    m localm = new m(this.mContext, paramInt, 0);
    localm.setTitle(paramCharSequence1);
    localm.rvA = paramCharSequence2;
    localm.D(paramDrawable);
    localm.kRX = paramBoolean;
    this.FYt.add(localm);
    AppMethodBeat.o(159220);
    return localm;
  }
  
  public final MenuItem c(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159224);
    m localm = new m(this.mContext, paramInt, 0);
    localm.setTitle(paramCharSequence);
    this.FYt.add(localm);
    AppMethodBeat.o(159224);
    return localm;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(159232);
    Iterator localIterator = this.FYt.iterator();
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      ((m)localMenuItem).FYy = null;
      ((m)localMenuItem).setOnMenuItemClickListener(null);
    }
    this.FYt.clear();
    this.adA = null;
    AppMethodBeat.o(159232);
  }
  
  public final void clearHeader() {}
  
  public final void close() {}
  
  public final boolean eSQ()
  {
    AppMethodBeat.i(159212);
    if (this.FYt.size() == 0)
    {
      AppMethodBeat.o(159212);
      return true;
    }
    AppMethodBeat.o(159212);
    return false;
  }
  
  public final MenuItem findItem(int paramInt)
  {
    AppMethodBeat.i(159233);
    Iterator localIterator = this.FYt.iterator();
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
      this.FYt.add(paramMenuItem);
    }
    AppMethodBeat.o(159230);
    return null;
  }
  
  public final MenuItem getItem(int paramInt)
  {
    AppMethodBeat.i(159235);
    MenuItem localMenuItem = (MenuItem)this.FYt.get(paramInt);
    AppMethodBeat.o(159235);
    return localMenuItem;
  }
  
  public final List<MenuItem> getItemList()
  {
    return this.FYt;
  }
  
  public final boolean hasVisibleItems()
  {
    return false;
  }
  
  public final boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public final MenuItem jj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159223);
    m localm = new m(this.mContext, paramInt1, 0);
    localm.setTitle(paramInt2);
    this.FYt.add(localm);
    AppMethodBeat.o(159223);
    return localm;
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
    Iterator localIterator = this.FYt.iterator();
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      if (localMenuItem.getItemId() == paramInt) {
        localArrayList.add(localMenuItem);
      }
    }
    this.FYt.removeAll(localArrayList);
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
    this.adA = paramCharSequence;
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
    if (this.FYt == null)
    {
      AppMethodBeat.o(159234);
      return 0;
    }
    int i = this.FYt.size();
    AppMethodBeat.o(159234);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.l
 * JD-Core Version:    0.7.0.1
 */