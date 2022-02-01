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

public final class n
  implements MenuItem
{
  public boolean Bno;
  private Drawable JlN;
  public boolean ORE;
  public TextUtils.TruncateAt ORF;
  public boolean ORG;
  public ContextMenu.ContextMenuInfo ORH;
  private MenuItem.OnMenuItemClickListener ORI;
  public boolean ORJ;
  public o.d ORK;
  public o.h ORL;
  private int adT;
  private int aea;
  public boolean eaY;
  private int iconId;
  private Intent intent;
  public String lDS;
  private Context mContext;
  public boolean neT;
  private CharSequence title;
  private int uQk;
  public int uzt;
  public CharSequence xdb;
  
  public n(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159237);
    this.Bno = false;
    this.xdb = null;
    this.neT = false;
    this.ORG = true;
    this.ORJ = false;
    this.ORK = null;
    this.ORL = null;
    this.mContext = paramContext;
    this.aea = paramInt1;
    this.adT = paramInt2;
    this.uzt = paramContext.getResources().getColor(2131099746);
    AppMethodBeat.o(159237);
  }
  
  public final MenuItem Bw(boolean paramBoolean)
  {
    this.neT = paramBoolean;
    return this;
  }
  
  public final void a(ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    this.ORH = paramContextMenuInfo;
  }
  
  public final void a(o.h paramh)
  {
    this.ORL = paramh;
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
    AppMethodBeat.i(198208);
    this.JlN = paramDrawable;
    this.uzt = paramInt;
    if (this.ORK != null) {
      this.ORK.a(this);
    }
    AppMethodBeat.o(198208);
    return this;
  }
  
  public final CharSequence gKS()
  {
    return this.xdb;
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
    return this.adT;
  }
  
  public final Drawable getIcon()
  {
    AppMethodBeat.i(159239);
    if (this.JlN == null)
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
    Drawable localDrawable = this.JlN;
    AppMethodBeat.o(159239);
    return localDrawable;
  }
  
  public final Intent getIntent()
  {
    return this.intent;
  }
  
  public final int getItemId()
  {
    return this.aea;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return this.ORH;
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
      if ((this.uQk != 0) && (this.mContext != null))
      {
        localObject = this.mContext.getString(this.uQk);
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
  
  public final MenuItem kW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198210);
    this.iconId = paramInt1;
    this.uzt = paramInt2;
    if (this.ORK != null) {
      this.ORK.a(this);
    }
    AppMethodBeat.o(198210);
    return this;
  }
  
  public final boolean performClick()
  {
    AppMethodBeat.i(159240);
    if (this.ORI != null)
    {
      boolean bool = this.ORI.onMenuItemClick(this);
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
    AppMethodBeat.i(198209);
    this.iconId = paramInt;
    if (this.ORK != null) {
      this.ORK.a(this);
    }
    AppMethodBeat.o(198209);
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(198207);
    this.JlN = paramDrawable;
    if (this.ORK != null) {
      this.ORK.a(this);
    }
    AppMethodBeat.o(198207);
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
    this.ORI = paramOnMenuItemClickListener;
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
    this.uQk = paramInt;
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
 * Qualified Name:     com.tencent.mm.ui.base.n
 * JD-Core Version:    0.7.0.1
 */