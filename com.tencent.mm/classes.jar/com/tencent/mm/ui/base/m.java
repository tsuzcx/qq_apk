package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  implements MenuItem
{
  public boolean Hyj;
  private int Hyk;
  public int Hyl;
  private Drawable Hym;
  public ContextMenu.ContextMenuInfo Hyn;
  private MenuItem.OnMenuItemClickListener Hyo;
  private int abP;
  private int abW;
  public boolean dvX;
  private int iconId;
  private Intent intent;
  public String kbL;
  public boolean ltx;
  private Context mContext;
  public CharSequence sEs;
  private CharSequence title;
  
  public m(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159237);
    this.sEs = null;
    this.ltx = false;
    this.mContext = paramContext;
    this.abW = paramInt1;
    this.abP = paramInt2;
    this.Hyl = paramContext.getResources().getColor(2131099732);
    AppMethodBeat.o(159237);
  }
  
  public final MenuItem C(Drawable paramDrawable)
  {
    this.Hym = paramDrawable;
    this.Hyl = 0;
    return this;
  }
  
  public final boolean collapseActionView()
  {
    return false;
  }
  
  public final boolean expandActionView()
  {
    return false;
  }
  
  public final ActionProvider getActionProvider()
  {
    return null;
  }
  
  public final View getActionView()
  {
    return null;
  }
  
  public final char getAlphabeticShortcut()
  {
    return '\000';
  }
  
  public final int getGroupId()
  {
    return this.abP;
  }
  
  public final Drawable getIcon()
  {
    AppMethodBeat.i(159239);
    if (this.Hym == null)
    {
      if ((this.iconId != 0) && (this.mContext != null))
      {
        localDrawable = this.mContext.getResources().getDrawable(this.iconId);
        AppMethodBeat.o(159239);
        return localDrawable;
      }
      AppMethodBeat.o(159239);
      return null;
    }
    Drawable localDrawable = this.Hym;
    AppMethodBeat.o(159239);
    return localDrawable;
  }
  
  public final Intent getIntent()
  {
    return this.intent;
  }
  
  public final int getItemId()
  {
    return this.abW;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return this.Hyn;
  }
  
  public final char getNumericShortcut()
  {
    return '\000';
  }
  
  public final int getOrder()
  {
    return 0;
  }
  
  public final SubMenu getSubMenu()
  {
    return null;
  }
  
  public final CharSequence getTitle()
  {
    AppMethodBeat.i(159238);
    if (this.title == null)
    {
      if ((this.Hyk != 0) && (this.mContext != null))
      {
        localObject = this.mContext.getString(this.Hyk);
        AppMethodBeat.o(159238);
        return localObject;
      }
      AppMethodBeat.o(159238);
      return null;
    }
    Object localObject = this.title;
    AppMethodBeat.o(159238);
    return localObject;
  }
  
  public final CharSequence getTitleCondensed()
  {
    return null;
  }
  
  public final boolean hasSubMenu()
  {
    return false;
  }
  
  public final boolean isActionViewExpanded()
  {
    return false;
  }
  
  public final boolean isCheckable()
  {
    return false;
  }
  
  public final boolean isChecked()
  {
    return false;
  }
  
  public final boolean isEnabled()
  {
    return true;
  }
  
  public final boolean isVisible()
  {
    return true;
  }
  
  public final MenuItem jx(int paramInt1, int paramInt2)
  {
    this.iconId = paramInt1;
    this.Hyl = paramInt2;
    return this;
  }
  
  public final boolean performClick()
  {
    AppMethodBeat.i(159240);
    if (this.Hyo != null)
    {
      boolean bool = this.Hyo.onMenuItemClick(this);
      AppMethodBeat.o(159240);
      return bool;
    }
    AppMethodBeat.o(159240);
    return false;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    return null;
  }
  
  public final MenuItem setActionView(int paramInt)
  {
    return null;
  }
  
  public final MenuItem setActionView(View paramView)
  {
    return null;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    return this;
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    return this;
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    return this;
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    this.iconId = paramInt;
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    this.Hym = paramDrawable;
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.intent = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    return null;
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.Hyo = paramOnMenuItemClickListener;
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    return this;
  }
  
  public final void setShowAsAction(int paramInt) {}
  
  public final MenuItem setShowAsActionFlags(int paramInt)
  {
    return null;
  }
  
  public final MenuItem setTitle(int paramInt)
  {
    this.Hyk = paramInt;
    return this;
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.title = paramCharSequence;
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.m
 * JD-Core Version:    0.7.0.1
 */