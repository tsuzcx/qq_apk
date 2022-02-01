package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.CheckPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.TextButtonPreference;
import com.tencent.mm.ui.base.preference.f;

public class UnfamiliarContactUI
  extends MMPreference
{
  private boolean wdf;
  private boolean wdg;
  private boolean wdh;
  
  public int getResourceId()
  {
    return 2131951739;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74623);
    super.initView();
    setMMTitle(2131763483);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74620);
        UnfamiliarContactUI.this.finish();
        AppMethodBeat.o(74620);
        return true;
      }
    });
    ((CheckPreference)getPreferenceScreen().aKk("settings_half_year_not_chat")).Gea = 0;
    ((CheckPreference)getPreferenceScreen().aKk("settings_has_not_same_chatroom")).Gea = 0;
    ((CheckPreference)getPreferenceScreen().aKk("settings_half_year_not_response")).Gea = 0;
    ((TextButtonPreference)getPreferenceScreen().aKk("settings_next_step")).setEnabled(false);
    getPreferenceScreen().notifyDataSetChanged();
    AppMethodBeat.o(74623);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74621);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(74621);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(74624);
    if (paramInt == 4)
    {
      onBackPressed();
      AppMethodBeat.o(74624);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(74624);
    return bool;
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    boolean bool2 = false;
    AppMethodBeat.i(74622);
    CheckPreference localCheckPreference;
    boolean bool1;
    if ((paramPreference instanceof CheckPreference))
    {
      localCheckPreference = (CheckPreference)paramPreference;
      if (paramPreference.mKey.equals("settings_half_year_not_chat")) {
        if (!this.wdf)
        {
          bool1 = true;
          localCheckPreference.lG = bool1;
          if (this.wdf) {
            break label123;
          }
          bool1 = true;
          label57:
          this.wdf = bool1;
          label62:
          paramPreference = (TextButtonPreference)paramf.aKk("settings_next_step");
          if ((!this.wdf) && (!this.wdh))
          {
            bool1 = bool2;
            if (!this.wdg) {}
          }
          else
          {
            bool1 = true;
          }
          paramPreference.setEnabled(bool1);
        }
      }
    }
    for (;;)
    {
      paramf.notifyDataSetChanged();
      AppMethodBeat.o(74622);
      return true;
      bool1 = false;
      break;
      label123:
      bool1 = false;
      break label57;
      if (paramPreference.mKey.equals("settings_has_not_same_chatroom"))
      {
        if (!this.wdh)
        {
          bool1 = true;
          label149:
          localCheckPreference.lG = bool1;
          if (this.wdh) {
            break label177;
          }
        }
        label177:
        for (bool1 = true;; bool1 = false)
        {
          this.wdh = bool1;
          break;
          bool1 = false;
          break label149;
        }
      }
      if (!paramPreference.mKey.equals("settings_half_year_not_response")) {
        break label62;
      }
      if (!this.wdg)
      {
        bool1 = true;
        label203:
        localCheckPreference.lG = bool1;
        if (this.wdg) {
          break label231;
        }
      }
      label231:
      for (bool1 = true;; bool1 = false)
      {
        this.wdg = bool1;
        break;
        bool1 = false;
        break label203;
      }
      if (paramPreference.mKey.equals("settings_next_step"))
      {
        paramPreference = new Intent(this, UnfamiliarContactDetailUI.class);
        paramPreference.putExtra("half_year_not_chat", this.wdf);
        paramPreference.putExtra("half_year_not_response", this.wdg);
        paramPreference.putExtra("has_not_same_chatroom", this.wdh);
        startActivityForResult(paramPreference, 291);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactUI
 * JD-Core Version:    0.7.0.1
 */