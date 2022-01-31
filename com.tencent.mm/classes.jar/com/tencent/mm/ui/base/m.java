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
  private int TR;
  private int TY;
  public String hBM;
  private int iconId;
  private Intent intent;
  private Context mContext;
  public CharSequence mZb = null;
  private CharSequence title;
  public boolean xTc = false;
  private int zkX;
  private Drawable zkY;
  public ContextMenu.ContextMenuInfo zkZ;
  private MenuItem.OnMenuItemClickListener zla;
  
  public m(Context paramContext, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.TY = paramInt1;
    this.TR = paramInt2;
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
    return this.TR;
  }
  
  public final Drawable getIcon()
  {
    AppMethodBeat.i(112556);
    if (this.zkY == null)
    {
      if ((this.iconId != 0) && (this.mContext != null))
      {
        localDrawable = this.mContext.getResources().getDrawable(this.iconId);
        AppMethodBeat.o(112556);
        return localDrawable;
      }
      AppMethodBeat.o(112556);
      return null;
    }
    Drawable localDrawable = this.zkY;
    AppMethodBeat.o(112556);
    return localDrawable;
  }
  
  public final Intent getIntent()
  {
    return this.intent;
  }
  
  public final int getItemId()
  {
    return this.TY;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return this.zkZ;
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
    AppMethodBeat.i(112555);
    if (this.title == null)
    {
      if ((this.zkX != 0) && (this.mContext != null))
      {
        localObject = this.mContext.getString(this.zkX);
        AppMethodBeat.o(112555);
        return localObject;
      }
      AppMethodBeat.o(112555);
      return null;
    }
    Object localObject = this.title;
    AppMethodBeat.o(112555);
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
  
  public final boolean performClick()
  {
    AppMethodBeat.i(112557);
    if (this.zla != null)
    {
      boolean bool = this.zla.onMenuItemClick(this);
      AppMethodBeat.o(112557);
      return bool;
    }
    AppMethodBeat.o(112557);
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
    this.zkY = paramDrawable;
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
    this.zla = paramOnMenuItemClickListener;
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
    this.zkX = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.m
 * JD-Core Version:    0.7.0.1
 */