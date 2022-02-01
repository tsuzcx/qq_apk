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

public class s
  implements ContextMenu
{
  public List<MenuItem> adRW;
  public Context mContext;
  public CharSequence nH;
  
  public s(Context paramContext)
  {
    AppMethodBeat.i(159211);
    this.mContext = paramContext;
    this.adRW = new ArrayList();
    AppMethodBeat.o(159211);
  }
  
  public final MenuItem a(int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159229);
    t localt = new t(this.mContext, paramInt1, 0);
    paramCharSequence = new SpannableString(paramCharSequence);
    paramCharSequence.setSpan(new ForegroundColorSpan(paramInt2), 0, paramCharSequence.length(), 0);
    localt.setTitle(paramCharSequence);
    this.adRW.add(localt);
    AppMethodBeat.o(159229);
    return localt;
  }
  
  public final MenuItem a(int paramInt1, int paramInt2, CharSequence paramCharSequence, int paramInt3)
  {
    AppMethodBeat.i(251344);
    t localt = new t(this.mContext, paramInt2, paramInt1);
    localt.setTitle(paramCharSequence);
    localt.setIcon(paramInt3);
    this.adRW.add(localt);
    AppMethodBeat.o(251344);
    return localt;
  }
  
  public final MenuItem a(int paramInt1, int paramInt2, CharSequence paramCharSequence, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(251391);
    t localt = new t(this.mContext, paramInt1, 0);
    localt.setTitle(paramCharSequence);
    localt.oi(paramInt3, 0);
    localt.disable = paramBoolean;
    this.adRW.add(paramInt2, localt);
    AppMethodBeat.o(251391);
    return localt;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    AppMethodBeat.i(159226);
    t localt = new t(this.mContext, paramInt1, 0);
    localt.setTitle(paramCharSequence);
    localt.setIcon(paramInt2);
    this.adRW.add(localt);
    AppMethodBeat.o(159226);
    return localt;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159227);
    t localt = new t(this.mContext, paramInt1, 0);
    localt.setTitle(paramCharSequence);
    localt.oi(paramInt2, paramInt3);
    this.adRW.add(localt);
    AppMethodBeat.o(159227);
    return localt;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(369636);
    t localt = new t(this.mContext, paramInt1, 0);
    localt.r(paramCharSequence, paramInt2);
    localt.oi(paramInt3, paramInt4);
    this.adRW.add(localt);
    AppMethodBeat.o(369636);
    return localt;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(159228);
    t localt = new t(this.mContext, paramInt1, 0);
    localt.setTitle(paramCharSequence);
    localt.oi(paramInt2, paramInt3);
    localt.disable = paramBoolean;
    this.adRW.add(localt);
    AppMethodBeat.o(159228);
    return localt;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(159221);
    t localt = new t(this.mContext, paramInt1, 0);
    localt.setTitle(paramCharSequence);
    localt.setIcon(paramInt2);
    localt.disable = paramBoolean;
    this.adRW.add(localt);
    AppMethodBeat.o(159221);
    return localt;
  }
  
  public final MenuItem a(int paramInt, CharSequence paramCharSequence, Drawable paramDrawable)
  {
    AppMethodBeat.i(159218);
    t localt = new t(this.mContext, paramInt, 0);
    localt.setTitle(paramCharSequence);
    localt.setIcon(paramDrawable);
    this.adRW.add(localt);
    AppMethodBeat.o(159218);
    return localt;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence, Drawable paramDrawable, int paramInt2)
  {
    AppMethodBeat.i(251357);
    t localt = new t(this.mContext, paramInt1, 0);
    localt.setTitle(paramCharSequence);
    localt.setIcon(paramDrawable);
    localt.f(paramDrawable, paramInt2);
    this.adRW.add(localt);
    AppMethodBeat.o(251357);
    return localt;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt2)
  {
    AppMethodBeat.i(159222);
    t localt = new t(this.mContext, paramInt1, 0);
    localt.setTitle(paramCharSequence1);
    localt.BdX = paramCharSequence2;
    localt.setIcon(paramInt2);
    this.adRW.add(localt);
    AppMethodBeat.o(159222);
    return localt;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence1, CharSequence paramCharSequence2, Drawable paramDrawable, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(251366);
    t localt = new t(this.mContext, paramInt1, 0);
    localt.setTitle(paramCharSequence1);
    localt.BdX = paramCharSequence2;
    localt.f(paramDrawable, paramInt2);
    localt.disable = paramBoolean;
    this.adRW.add(localt);
    AppMethodBeat.o(251366);
    return localt;
  }
  
  public final MenuItem a(int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2, Drawable paramDrawable, boolean paramBoolean)
  {
    AppMethodBeat.i(159219);
    t localt = new t(this.mContext, paramInt, 0);
    localt.setTitle(paramCharSequence1);
    localt.BdX = paramCharSequence2;
    localt.setIcon(paramDrawable);
    localt.disable = paramBoolean;
    this.adRW.add(localt);
    AppMethodBeat.o(159219);
    return localt;
  }
  
  public final MenuItem a(int paramInt, CharSequence paramCharSequence, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(251394);
    t localt = new t(this.mContext, paramInt, 0);
    localt.nickName = paramCharSequence;
    localt.rDm = paramString;
    localt.disable = paramBoolean;
    this.adRW.add(localt);
    AppMethodBeat.o(251394);
    return localt;
  }
  
  public final MenuItem a(int paramInt, CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(179496);
    t localt = new t(this.mContext, paramInt, 0);
    localt.adRX = paramBoolean;
    localt.iaS = false;
    localt.setTitle(paramCharSequence);
    this.adRW.add(localt);
    AppMethodBeat.o(179496);
    return localt;
  }
  
  public final MenuItem aAV(int paramInt)
  {
    AppMethodBeat.i(251385);
    t localt = new t(this.mContext, paramInt, 0);
    localt.NfE = true;
    this.adRW.add(localt);
    AppMethodBeat.o(251385);
    return localt;
  }
  
  public final int aAW(int paramInt)
  {
    AppMethodBeat.i(251419);
    Iterator localIterator = this.adRW.iterator();
    int i = -1;
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      int j = i + 1;
      i = j;
      if (localMenuItem.getItemId() == paramInt)
      {
        AppMethodBeat.o(251419);
        return j;
      }
    }
    AppMethodBeat.o(251419);
    return -1;
  }
  
  public MenuItem add(int paramInt)
  {
    AppMethodBeat.i(159215);
    t localt = new t(this.mContext, 0, 0);
    localt.setTitle(paramInt);
    this.adRW.add(localt);
    AppMethodBeat.o(159215);
    return localt;
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159213);
    t localt = new t(this.mContext, paramInt2, paramInt1);
    localt.setTitle(paramInt4);
    this.adRW.add(localt);
    AppMethodBeat.o(159213);
    return localt;
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159214);
    t localt = new t(this.mContext, paramInt2, paramInt1);
    localt.setTitle(paramCharSequence);
    this.adRW.add(localt);
    AppMethodBeat.o(159214);
    return localt;
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159216);
    t localt = new t(this.mContext, 0, 0);
    localt.setTitle(paramCharSequence);
    this.adRW.add(localt);
    AppMethodBeat.o(159216);
    return localt;
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    return 0;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    return null;
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return null;
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return null;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return null;
  }
  
  public final MenuItem b(int paramInt1, CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt2)
  {
    AppMethodBeat.i(251387);
    t localt = new t(this.mContext, paramInt1, 0);
    localt.setTitle(paramCharSequence1);
    localt.BdX = paramCharSequence2;
    localt.oi(0, paramInt2);
    this.adRW.add(localt);
    AppMethodBeat.o(251387);
    return localt;
  }
  
  public final MenuItem bx(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159217);
    t localt = new t(this.mContext, paramInt1, 0);
    localt.setTitle(paramInt2);
    localt.setIcon(paramInt3);
    this.adRW.add(localt);
    AppMethodBeat.o(159217);
    return localt;
  }
  
  public final MenuItem c(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159224);
    t localt = new t(this.mContext, paramInt, 0);
    localt.setTitle(paramCharSequence);
    this.adRW.add(localt);
    AppMethodBeat.o(159224);
    return localt;
  }
  
  public void clear()
  {
    AppMethodBeat.i(159232);
    Iterator localIterator = this.adRW.iterator();
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      ((t)localMenuItem).adSb = null;
      ((t)localMenuItem).setOnMenuItemClickListener(null);
    }
    this.adRW.clear();
    this.nH = null;
    AppMethodBeat.o(159232);
  }
  
  public void clearHeader() {}
  
  public void close() {}
  
  public MenuItem findItem(int paramInt)
  {
    AppMethodBeat.i(159233);
    Iterator localIterator = this.adRW.iterator();
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
  
  public MenuItem getItem(int paramInt)
  {
    AppMethodBeat.i(159235);
    MenuItem localMenuItem = (MenuItem)this.adRW.get(paramInt);
    AppMethodBeat.o(159235);
    return localMenuItem;
  }
  
  public boolean hasVisibleItems()
  {
    return false;
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public final MenuItem j(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(159230);
    if (paramMenuItem != null) {
      this.adRW.add(paramMenuItem);
    }
    AppMethodBeat.o(159230);
    return null;
  }
  
  public final boolean jmw()
  {
    AppMethodBeat.i(159212);
    if (this.adRW.size() == 0)
    {
      AppMethodBeat.o(159212);
      return true;
    }
    AppMethodBeat.o(159212);
    return false;
  }
  
  public final MenuItem oh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159223);
    t localt = new t(this.mContext, paramInt1, 0);
    localt.setTitle(paramInt2);
    this.adRW.add(localt);
    AppMethodBeat.o(159223);
    return localt;
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    return false;
  }
  
  public void removeGroup(int paramInt) {}
  
  public void removeItem(int paramInt)
  {
    AppMethodBeat.i(159231);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.adRW.iterator();
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      if (localMenuItem.getItemId() == paramInt) {
        localArrayList.add(localMenuItem);
      }
    }
    this.adRW.removeAll(localArrayList);
    AppMethodBeat.o(159231);
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean) {}
  
  public void setGroupVisible(int paramInt, boolean paramBoolean) {}
  
  public ContextMenu setHeaderIcon(int paramInt)
  {
    return this;
  }
  
  public ContextMenu setHeaderIcon(Drawable paramDrawable)
  {
    return this;
  }
  
  public ContextMenu setHeaderTitle(int paramInt)
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
  
  public ContextMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return this;
    }
    this.nH = paramCharSequence;
    return this;
  }
  
  public ContextMenu setHeaderView(View paramView)
  {
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean) {}
  
  public int size()
  {
    AppMethodBeat.i(159234);
    if (this.adRW == null)
    {
      AppMethodBeat.o(159234);
      return 0;
    }
    int i = this.adRW.size();
    AppMethodBeat.o(159234);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.s
 * JD-Core Version:    0.7.0.1
 */