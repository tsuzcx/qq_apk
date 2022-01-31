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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class l
  implements ContextMenu
{
  public CharSequence VF;
  private Context mContext;
  public List<MenuItem> uWD;
  
  public l(Context paramContext)
  {
    this.mContext = paramContext;
    this.uWD = new ArrayList();
  }
  
  public final MenuItem a(int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    m localm = new m(this.mContext, paramInt1, 0);
    paramCharSequence = new SpannableString(paramCharSequence);
    paramCharSequence.setSpan(new ForegroundColorSpan(paramInt2), 0, paramCharSequence.length(), 0);
    localm.setTitle(paramCharSequence);
    this.uWD.add(localm);
    return localm;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    m localm = new m(this.mContext, paramInt1, 0);
    localm.setTitle(paramCharSequence);
    localm.setIcon(paramInt2);
    this.uWD.add(localm);
    return localm;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence, int paramInt2, boolean paramBoolean)
  {
    m localm = new m(this.mContext, paramInt1, 0);
    localm.setTitle(paramCharSequence);
    localm.setIcon(paramInt2);
    localm.tMS = paramBoolean;
    this.uWD.add(localm);
    return localm;
  }
  
  public final MenuItem a(int paramInt, CharSequence paramCharSequence, Drawable paramDrawable)
  {
    m localm = new m(this.mContext, paramInt, 0);
    localm.setTitle(paramCharSequence);
    localm.setIcon(paramDrawable);
    this.uWD.add(localm);
    return localm;
  }
  
  public final MenuItem a(int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    m localm = new m(this.mContext, paramInt, 0);
    localm.setTitle(paramCharSequence1);
    localm.kDf = paramCharSequence2;
    localm.setIcon(0);
    this.uWD.add(localm);
    return localm;
  }
  
  public final MenuItem a(int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2, Drawable paramDrawable, boolean paramBoolean)
  {
    m localm = new m(this.mContext, paramInt, 0);
    localm.setTitle(paramCharSequence1);
    localm.kDf = paramCharSequence2;
    localm.setIcon(paramDrawable);
    localm.tMS = paramBoolean;
    this.uWD.add(localm);
    return localm;
  }
  
  public final MenuItem add(int paramInt)
  {
    m localm = new m(this.mContext, 0, 0);
    localm.setTitle(paramInt);
    this.uWD.add(localm);
    return localm;
  }
  
  public final MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    m localm = new m(this.mContext, paramInt2, paramInt1);
    localm.setTitle(paramInt4);
    this.uWD.add(localm);
    return localm;
  }
  
  public final MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    m localm = new m(this.mContext, paramInt2, paramInt1);
    localm.setTitle(paramCharSequence);
    this.uWD.add(localm);
    return localm;
  }
  
  public final MenuItem add(CharSequence paramCharSequence)
  {
    m localm = new m(this.mContext, 0, 0);
    localm.setTitle(paramCharSequence);
    this.uWD.add(localm);
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
  
  public final MenuItem ak(int paramInt1, int paramInt2, int paramInt3)
  {
    m localm = new m(this.mContext, paramInt1, 0);
    localm.setTitle(paramInt2);
    localm.setIcon(paramInt3);
    this.uWD.add(localm);
    return localm;
  }
  
  public final boolean cAR()
  {
    return this.uWD.size() == 0;
  }
  
  public final void clear()
  {
    Iterator localIterator = this.uWD.iterator();
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      ((m)localMenuItem).uWG = null;
      ((m)localMenuItem).setOnMenuItemClickListener(null);
    }
    this.uWD.clear();
    this.VF = null;
  }
  
  public final void clearHeader() {}
  
  public final void close() {}
  
  public final MenuItem e(int paramInt, CharSequence paramCharSequence)
  {
    m localm = new m(this.mContext, paramInt, 0);
    localm.setTitle(paramCharSequence);
    this.uWD.add(localm);
    return localm;
  }
  
  public final MenuItem findItem(int paramInt)
  {
    Iterator localIterator = this.uWD.iterator();
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      if (localMenuItem.getItemId() == paramInt) {
        return localMenuItem;
      }
    }
    return null;
  }
  
  public final MenuItem fq(int paramInt1, int paramInt2)
  {
    m localm = new m(this.mContext, paramInt1, 0);
    localm.setTitle(paramInt2);
    this.uWD.add(localm);
    return localm;
  }
  
  public final MenuItem getItem(int paramInt)
  {
    return (MenuItem)this.uWD.get(paramInt);
  }
  
  public final boolean hasVisibleItems()
  {
    return false;
  }
  
  public final MenuItem i(MenuItem paramMenuItem)
  {
    if (paramMenuItem != null) {
      this.uWD.add(paramMenuItem);
    }
    return null;
  }
  
  public final boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
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
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.uWD.iterator();
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      if (localMenuItem.getItemId() == paramInt) {
        localArrayList.add(localMenuItem);
      }
    }
    this.uWD.removeAll(localArrayList);
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
    Object localObject = this;
    if (paramInt > 0) {
      localObject = setHeaderTitle(this.mContext.getString(paramInt));
    }
    return localObject;
  }
  
  public final ContextMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return this;
    }
    this.VF = paramCharSequence;
    return this;
  }
  
  public final ContextMenu setHeaderView(View paramView)
  {
    return this;
  }
  
  public final void setQwertyMode(boolean paramBoolean) {}
  
  public final int size()
  {
    if (this.uWD == null) {
      return 0;
    }
    return this.uWD.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.l
 * JD-Core Version:    0.7.0.1
 */