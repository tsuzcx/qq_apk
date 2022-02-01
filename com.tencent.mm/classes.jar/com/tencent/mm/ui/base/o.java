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

public class o
  implements ContextMenu
{
  public List<MenuItem> WkP;
  public Context mContext;
  public CharSequence mJ;
  
  public o(Context paramContext)
  {
    AppMethodBeat.i(159211);
    this.mContext = paramContext;
    this.WkP = new ArrayList();
    AppMethodBeat.o(159211);
  }
  
  public final MenuItem a(int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159229);
    p localp = new p(this.mContext, paramInt1, 0);
    paramCharSequence = new SpannableString(paramCharSequence);
    paramCharSequence.setSpan(new ForegroundColorSpan(paramInt2), 0, paramCharSequence.length(), 0);
    localp.setTitle(paramCharSequence);
    this.WkP.add(localp);
    AppMethodBeat.o(159229);
    return localp;
  }
  
  public final MenuItem a(int paramInt1, int paramInt2, CharSequence paramCharSequence, int paramInt3)
  {
    AppMethodBeat.i(251772);
    p localp = new p(this.mContext, paramInt2, paramInt1);
    localp.setTitle(paramCharSequence);
    localp.setIcon(paramInt3);
    this.WkP.add(localp);
    AppMethodBeat.o(251772);
    return localp;
  }
  
  public final MenuItem a(int paramInt1, int paramInt2, CharSequence paramCharSequence, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(251802);
    p localp = new p(this.mContext, paramInt1, 0);
    localp.setTitle(paramCharSequence);
    localp.mo(paramInt3, 0);
    localp.qfB = paramBoolean;
    this.WkP.add(paramInt2, localp);
    AppMethodBeat.o(251802);
    return localp;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159227);
    p localp = new p(this.mContext, paramInt1, 0);
    localp.setTitle(paramCharSequence);
    localp.mo(paramInt2, paramInt3);
    this.WkP.add(localp);
    AppMethodBeat.o(159227);
    return localp;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(159228);
    p localp = new p(this.mContext, paramInt1, 0);
    localp.setTitle(paramCharSequence);
    localp.mo(paramInt2, paramInt3);
    localp.qfB = paramBoolean;
    this.WkP.add(localp);
    AppMethodBeat.o(159228);
    return localp;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(159221);
    p localp = new p(this.mContext, paramInt1, 0);
    localp.setTitle(paramCharSequence);
    localp.setIcon(paramInt2);
    localp.qfB = paramBoolean;
    this.WkP.add(localp);
    AppMethodBeat.o(159221);
    return localp;
  }
  
  public final MenuItem a(int paramInt, CharSequence paramCharSequence, Drawable paramDrawable)
  {
    AppMethodBeat.i(159218);
    p localp = new p(this.mContext, paramInt, 0);
    localp.setTitle(paramCharSequence);
    localp.setIcon(paramDrawable);
    this.WkP.add(localp);
    AppMethodBeat.o(159218);
    return localp;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence, Drawable paramDrawable, int paramInt2)
  {
    AppMethodBeat.i(251781);
    p localp = new p(this.mContext, paramInt1, 0);
    localp.setTitle(paramCharSequence);
    localp.setIcon(paramDrawable);
    localp.f(paramDrawable, paramInt2);
    this.WkP.add(localp);
    AppMethodBeat.o(251781);
    return localp;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt2)
  {
    AppMethodBeat.i(159222);
    p localp = new p(this.mContext, paramInt1, 0);
    localp.setTitle(paramCharSequence1);
    localp.BOZ = paramCharSequence2;
    localp.setIcon(paramInt2);
    this.WkP.add(localp);
    AppMethodBeat.o(159222);
    return localp;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence1, CharSequence paramCharSequence2, Drawable paramDrawable, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(251786);
    p localp = new p(this.mContext, paramInt1, 0);
    localp.setTitle(paramCharSequence1);
    localp.BOZ = paramCharSequence2;
    localp.f(paramDrawable, paramInt2);
    localp.qfB = paramBoolean;
    this.WkP.add(localp);
    AppMethodBeat.o(251786);
    return localp;
  }
  
  public final MenuItem a(int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2, Drawable paramDrawable, boolean paramBoolean)
  {
    AppMethodBeat.i(159219);
    p localp = new p(this.mContext, paramInt, 0);
    localp.setTitle(paramCharSequence1);
    localp.BOZ = paramCharSequence2;
    localp.setIcon(paramDrawable);
    localp.qfB = paramBoolean;
    this.WkP.add(localp);
    AppMethodBeat.o(159219);
    return localp;
  }
  
  public final MenuItem a(int paramInt, CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(179496);
    p localp = new p(this.mContext, paramInt, 0);
    localp.WkQ = paramBoolean;
    localp.fUV = false;
    localp.setTitle(paramCharSequence);
    this.WkP.add(localp);
    AppMethodBeat.o(179496);
    return localp;
  }
  
  public final List<MenuItem> aCj()
  {
    return this.WkP;
  }
  
  public final MenuItem aW(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159217);
    p localp = new p(this.mContext, paramInt1, 0);
    localp.setTitle(paramInt2);
    localp.setIcon(paramInt3);
    this.WkP.add(localp);
    AppMethodBeat.o(159217);
    return localp;
  }
  
  public MenuItem add(int paramInt)
  {
    AppMethodBeat.i(159215);
    p localp = new p(this.mContext, 0, 0);
    localp.setTitle(paramInt);
    this.WkP.add(localp);
    AppMethodBeat.o(159215);
    return localp;
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159213);
    p localp = new p(this.mContext, paramInt2, paramInt1);
    localp.setTitle(paramInt4);
    this.WkP.add(localp);
    AppMethodBeat.o(159213);
    return localp;
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159214);
    p localp = new p(this.mContext, paramInt2, paramInt1);
    localp.setTitle(paramCharSequence);
    this.WkP.add(localp);
    AppMethodBeat.o(159214);
    return localp;
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159216);
    p localp = new p(this.mContext, 0, 0);
    localp.setTitle(paramCharSequence);
    this.WkP.add(localp);
    AppMethodBeat.o(159216);
    return localp;
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
  
  public final MenuItem b(int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    AppMethodBeat.i(159226);
    p localp = new p(this.mContext, paramInt1, 0);
    localp.setTitle(paramCharSequence);
    localp.setIcon(paramInt2);
    this.WkP.add(localp);
    AppMethodBeat.o(159226);
    return localp;
  }
  
  public final MenuItem b(int paramInt1, CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt2)
  {
    AppMethodBeat.i(251798);
    p localp = new p(this.mContext, 3, 0);
    localp.setTitle(paramCharSequence1);
    localp.BOZ = paramCharSequence2;
    localp.mo(0, paramInt2);
    this.WkP.add(localp);
    AppMethodBeat.o(251798);
    return localp;
  }
  
  public final MenuItem c(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(251788);
    p localp = new p(this.mContext, paramInt, 0);
    localp.setTitle(paramCharSequence);
    localp.qfB = false;
    this.WkP.add(localp);
    AppMethodBeat.o(251788);
    return localp;
  }
  
  public final MenuItem c(int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    AppMethodBeat.i(251794);
    p localp = new p(this.mContext, paramInt1, 0);
    localp.setTitle(paramCharSequence);
    localp.setIcon(paramInt2);
    localp.WkW = true;
    this.WkP.add(localp);
    AppMethodBeat.o(251794);
    return localp;
  }
  
  public void clear()
  {
    AppMethodBeat.i(159232);
    Iterator localIterator = this.WkP.iterator();
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      ((p)localMenuItem).WkU = null;
      ((p)localMenuItem).setOnMenuItemClickListener(null);
    }
    this.WkP.clear();
    this.mJ = null;
    AppMethodBeat.o(159232);
  }
  
  public void clearHeader() {}
  
  public void close() {}
  
  public final MenuItem d(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159224);
    p localp = new p(this.mContext, paramInt, 0);
    localp.setTitle(paramCharSequence);
    this.WkP.add(localp);
    AppMethodBeat.o(159224);
    return localp;
  }
  
  public MenuItem findItem(int paramInt)
  {
    AppMethodBeat.i(159233);
    Iterator localIterator = this.WkP.iterator();
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
    MenuItem localMenuItem = (MenuItem)this.WkP.get(paramInt);
    AppMethodBeat.o(159235);
    return localMenuItem;
  }
  
  public final MenuItem h(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(159230);
    if (paramMenuItem != null) {
      this.WkP.add(paramMenuItem);
    }
    AppMethodBeat.o(159230);
    return null;
  }
  
  public final boolean hJO()
  {
    AppMethodBeat.i(159212);
    if (this.WkP.size() == 0)
    {
      AppMethodBeat.o(159212);
      return true;
    }
    AppMethodBeat.o(159212);
    return false;
  }
  
  public final int hJP()
  {
    AppMethodBeat.i(251818);
    Iterator localIterator = this.WkP.iterator();
    int i = -1;
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      int j = i + 1;
      i = j;
      if (localMenuItem.getItemId() == 7)
      {
        AppMethodBeat.o(251818);
        return j;
      }
    }
    AppMethodBeat.o(251818);
    return -1;
  }
  
  public boolean hasVisibleItems()
  {
    return false;
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public final MenuItem mn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159223);
    p localp = new p(this.mContext, paramInt1, 0);
    localp.setTitle(paramInt2);
    this.WkP.add(localp);
    AppMethodBeat.o(159223);
    return localp;
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
    Iterator localIterator = this.WkP.iterator();
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      if (localMenuItem.getItemId() == paramInt) {
        localArrayList.add(localMenuItem);
      }
    }
    this.WkP.removeAll(localArrayList);
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
    this.mJ = paramCharSequence;
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
    if (this.WkP == null)
    {
      AppMethodBeat.o(159234);
      return 0;
    }
    int i = this.WkP.size();
    AppMethodBeat.o(159234);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.o
 * JD-Core Version:    0.7.0.1
 */