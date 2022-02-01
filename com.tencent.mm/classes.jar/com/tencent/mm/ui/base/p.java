package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.c;

public final class p
  implements MenuItem
{
  public CharSequence BOZ;
  public boolean HhK;
  private CharSequence Ig;
  private Drawable Qjf;
  public boolean WkQ;
  public TextUtils.TruncateAt WkR;
  private int WkS;
  public boolean WkT;
  public ContextMenu.ContextMenuInfo WkU;
  private MenuItem.OnMenuItemClickListener WkV;
  public boolean WkW;
  public q.d WkX;
  public q.h WkY;
  public boolean fUV;
  public int iconColor;
  private Intent intent;
  private int ka;
  private int kh;
  private Context mContext;
  public String ozt;
  public boolean qfB;
  private int zDq;
  
  public p(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159237);
    this.HhK = false;
    this.BOZ = null;
    this.qfB = false;
    this.WkT = true;
    this.WkW = false;
    this.WkX = null;
    this.WkY = null;
    this.mContext = paramContext;
    this.kh = paramInt1;
    this.ka = paramInt2;
    this.iconColor = paramContext.getResources().getColor(a.c.FG_0);
    AppMethodBeat.o(159237);
  }
  
  public final MenuItem FO(boolean paramBoolean)
  {
    this.qfB = paramBoolean;
    return this;
  }
  
  public final void a(ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    this.WkU = paramContextMenuInfo;
  }
  
  public final void a(q.h paramh)
  {
    this.WkY = paramh;
  }
  
  public final boolean collapseActionView()
  {
    return false;
  }
  
  public final boolean expandActionView()
  {
    return false;
  }
  
  public final MenuItem f(Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(251869);
    this.Qjf = paramDrawable;
    this.iconColor = paramInt;
    if (this.WkX != null) {
      this.WkX.a(this);
    }
    AppMethodBeat.o(251869);
    return this;
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
    return this.ka;
  }
  
  public final Drawable getIcon()
  {
    AppMethodBeat.i(159239);
    if (this.Qjf == null)
    {
      if ((this.WkS != 0) && (this.mContext != null))
      {
        localDrawable = this.mContext.getResources().getDrawable(this.WkS);
        AppMethodBeat.o(159239);
        return localDrawable;
      }
      AppMethodBeat.o(159239);
      return null;
    }
    Drawable localDrawable = this.Qjf;
    AppMethodBeat.o(159239);
    return localDrawable;
  }
  
  public final Intent getIntent()
  {
    return this.intent;
  }
  
  public final int getItemId()
  {
    return this.kh;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return this.WkU;
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
    if (this.Ig == null)
    {
      if ((this.zDq != 0) && (this.mContext != null))
      {
        localObject = this.mContext.getString(this.zDq);
        AppMethodBeat.o(159238);
        return localObject;
      }
      AppMethodBeat.o(159238);
      return null;
    }
    Object localObject = this.Ig;
    AppMethodBeat.o(159238);
    return localObject;
  }
  
  public final CharSequence getTitleCondensed()
  {
    return null;
  }
  
  public final CharSequence hJQ()
  {
    return this.BOZ;
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
  
  public final MenuItem mo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251875);
    this.WkS = paramInt1;
    this.iconColor = paramInt2;
    if (this.WkX != null) {
      this.WkX.a(this);
    }
    AppMethodBeat.o(251875);
    return this;
  }
  
  public final boolean performClick()
  {
    AppMethodBeat.i(159240);
    if (this.WkV != null)
    {
      boolean bool = this.WkV.onMenuItemClick(this);
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
    AppMethodBeat.i(251871);
    this.WkS = paramInt;
    if (this.WkX != null) {
      this.WkX.a(this);
    }
    AppMethodBeat.o(251871);
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(251865);
    this.Qjf = paramDrawable;
    if (this.WkX != null) {
      this.WkX.a(this);
    }
    AppMethodBeat.o(251865);
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
    this.WkV = paramOnMenuItemClickListener;
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
    this.zDq = paramInt;
    return this;
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.Ig = paramCharSequence;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.p
 * JD-Core Version:    0.7.0.1
 */