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
import com.tencent.mm.ck.a.c;

public final class t
  implements MenuItem
{
  public CharSequence BdX;
  private int EHx;
  private MenuItem.OnMenuItemClickListener JVE;
  public boolean NfE;
  public int XXf;
  private Drawable Xbc;
  public boolean adRX;
  public TextUtils.TruncateAt adRY;
  private int adRZ;
  public boolean adSa;
  public ContextMenu.ContextMenuInfo adSb;
  public boolean adSc;
  public u.e adSd;
  public u.k adSe;
  public u.j adSf;
  public boolean disable;
  public boolean iaS;
  public int iconColor;
  private Intent intent;
  private int kW;
  private int ld;
  private Context mContext;
  public CharSequence nickName;
  public String rDm;
  private CharSequence title;
  
  public t(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159237);
    this.NfE = false;
    this.BdX = null;
    this.disable = false;
    this.adSa = true;
    this.adSc = false;
    this.adSd = null;
    this.adSe = null;
    this.adSf = null;
    this.mContext = paramContext;
    this.ld = paramInt1;
    this.kW = paramInt2;
    this.iconColor = paramContext.getResources().getColor(a.c.FG_0);
    AppMethodBeat.o(159237);
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
    AppMethodBeat.i(251372);
    this.Xbc = paramDrawable;
    this.iconColor = paramInt;
    if (this.adSd != null) {
      this.adSd.a(this);
    }
    AppMethodBeat.o(251372);
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
    return this.kW;
  }
  
  public final Drawable getIcon()
  {
    AppMethodBeat.i(159239);
    if (this.Xbc == null)
    {
      if ((this.adRZ != 0) && (this.mContext != null))
      {
        localDrawable = this.mContext.getResources().getDrawable(this.adRZ);
        AppMethodBeat.o(159239);
        return localDrawable;
      }
      AppMethodBeat.o(159239);
      return null;
    }
    Drawable localDrawable = this.Xbc;
    AppMethodBeat.o(159239);
    return localDrawable;
  }
  
  public final Intent getIntent()
  {
    return this.intent;
  }
  
  public final int getItemId()
  {
    return this.ld;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return this.adSb;
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
      if ((this.EHx != 0) && (this.mContext != null))
      {
        localObject = this.mContext.getString(this.EHx);
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
  
  public final MenuItem oi(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251378);
    this.adRZ = paramInt1;
    this.iconColor = paramInt2;
    if (this.adSd != null) {
      this.adSd.a(this);
    }
    AppMethodBeat.o(251378);
    return this;
  }
  
  public final boolean performClick()
  {
    AppMethodBeat.i(159240);
    if (this.JVE != null)
    {
      boolean bool = this.JVE.onMenuItemClick(this);
      AppMethodBeat.o(159240);
      return bool;
    }
    AppMethodBeat.o(159240);
    return false;
  }
  
  public final MenuItem r(CharSequence paramCharSequence, int paramInt)
  {
    this.title = paramCharSequence;
    this.XXf = paramInt;
    return this;
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
    AppMethodBeat.i(251376);
    this.adRZ = paramInt;
    if (this.adSd != null) {
      this.adSd.a(this);
    }
    AppMethodBeat.o(251376);
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(251367);
    this.Xbc = paramDrawable;
    if (this.adSd != null) {
      this.adSd.a(this);
    }
    AppMethodBeat.o(251367);
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
    this.JVE = paramOnMenuItemClickListener;
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
    this.EHx = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.t
 * JD-Core Version:    0.7.0.1
 */