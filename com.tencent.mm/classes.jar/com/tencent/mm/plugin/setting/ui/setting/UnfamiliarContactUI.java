package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.CheckPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.TextButtonPreference;
import com.tencent.mm.ui.base.preference.f;

public class UnfamiliarContactUI
  extends MMPreference
{
  private boolean qEM;
  private boolean qEN;
  private boolean qEO;
  
  public int getResourceId()
  {
    return 2131165295;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127687);
    super.initView();
    setMMTitle(2131303501);
    setBackBtn(new UnfamiliarContactUI.1(this));
    ((CheckPreference)getPreferenceScreen().atx("settings_half_year_not_chat")).zqz = 0;
    ((CheckPreference)getPreferenceScreen().atx("settings_has_not_same_chatroom")).zqz = 0;
    ((CheckPreference)getPreferenceScreen().atx("settings_half_year_not_response")).zqz = 0;
    ((TextButtonPreference)getPreferenceScreen().atx("settings_next_step")).setEnabled(false);
    getPreferenceScreen().notifyDataSetChanged();
    AppMethodBeat.o(127687);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127685);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(127685);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(127688);
    if (paramInt == 4)
    {
      onBackPressed();
      AppMethodBeat.o(127688);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(127688);
    return bool;
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    boolean bool2 = false;
    AppMethodBeat.i(127686);
    CheckPreference localCheckPreference;
    boolean bool1;
    if ((paramPreference instanceof CheckPreference))
    {
      localCheckPreference = (CheckPreference)paramPreference;
      if (paramPreference.mKey.equals("settings_half_year_not_chat")) {
        if (!this.qEM)
        {
          bool1 = true;
          localCheckPreference.vxW = bool1;
          if (this.qEM) {
            break label123;
          }
          bool1 = true;
          label57:
          this.qEM = bool1;
          label62:
          paramPreference = (TextButtonPreference)paramf.atx("settings_next_step");
          if ((!this.qEM) && (!this.qEO))
          {
            bool1 = bool2;
            if (!this.qEN) {}
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
      AppMethodBeat.o(127686);
      return true;
      bool1 = false;
      break;
      label123:
      bool1 = false;
      break label57;
      if (paramPreference.mKey.equals("settings_has_not_same_chatroom"))
      {
        if (!this.qEO)
        {
          bool1 = true;
          label149:
          localCheckPreference.vxW = bool1;
          if (this.qEO) {
            break label177;
          }
        }
        label177:
        for (bool1 = true;; bool1 = false)
        {
          this.qEO = bool1;
          break;
          bool1 = false;
          break label149;
        }
      }
      if (!paramPreference.mKey.equals("settings_half_year_not_response")) {
        break label62;
      }
      if (!this.qEN)
      {
        bool1 = true;
        label203:
        localCheckPreference.vxW = bool1;
        if (this.qEN) {
          break label231;
        }
      }
      label231:
      for (bool1 = true;; bool1 = false)
      {
        this.qEN = bool1;
        break;
        bool1 = false;
        break label203;
      }
      if (paramPreference.mKey.equals("settings_next_step"))
      {
        paramPreference = new Intent(this, UnfamiliarContactDetailUI.class);
        paramPreference.putExtra("half_year_not_chat", this.qEM);
        paramPreference.putExtra("half_year_not_response", this.qEN);
        paramPreference.putExtra("has_not_same_chatroom", this.qEO);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactUI
 * JD-Core Version:    0.7.0.1
 */