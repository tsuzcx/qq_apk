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
  public boolean FYu;
  private int FYv;
  public int FYw;
  private Drawable FYx;
  public ContextMenu.ContextMenuInfo FYy;
  private MenuItem.OnMenuItemClickListener FYz;
  private int aaU;
  private int abb;
  public boolean dyl;
  private int iconId;
  private Intent intent;
  public String jBp;
  public boolean kRX;
  private Context mContext;
  public CharSequence rvA;
  private CharSequence title;
  
  public m(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159237);
    this.rvA = null;
    this.kRX = false;
    this.mContext = paramContext;
    this.abb = paramInt1;
    this.aaU = paramInt2;
    this.FYw = paramContext.getResources().getColor(2131099732);
    AppMethodBeat.o(159237);
  }
  
  public final MenuItem D(Drawable paramDrawable)
  {
    this.FYx = paramDrawable;
    this.FYw = 0;
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
    return this.aaU;
  }
  
  public final Drawable getIcon()
  {
    AppMethodBeat.i(159239);
    if (this.FYx == null)
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
    Drawable localDrawable = this.FYx;
    AppMethodBeat.o(159239);
    return localDrawable;
  }
  
  public final Intent getIntent()
  {
    return this.intent;
  }
  
  public final int getItemId()
  {
    return this.abb;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return this.FYy;
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
      if ((this.FYv != 0) && (this.mContext != null))
      {
        localObject = this.mContext.getString(this.FYv);
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
  
  public final MenuItem jk(int paramInt1, int paramInt2)
  {
    this.iconId = paramInt1;
    this.FYw = paramInt2;
    return this;
  }
  
  public final boolean performClick()
  {
    AppMethodBeat.i(159240);
    if (this.FYz != null)
    {
      boolean bool = this.FYz.onMenuItemClick(this);
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
    this.FYx = paramDrawable;
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
    this.FYz = paramOnMenuItemClickListener;
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
    this.FYv = paramInt;
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