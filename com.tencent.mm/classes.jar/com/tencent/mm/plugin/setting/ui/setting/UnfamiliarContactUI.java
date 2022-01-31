package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.ui.base.preference.CheckPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.TextButtonPreference;
import com.tencent.mm.ui.base.preference.f;

public class UnfamiliarContactUI
  extends MMPreference
{
  private boolean nQP;
  private boolean nQQ;
  private boolean nQR;
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    boolean bool2 = false;
    CheckPreference localCheckPreference;
    boolean bool1;
    if ((paramPreference instanceof CheckPreference))
    {
      localCheckPreference = (CheckPreference)paramPreference;
      if (paramPreference.mKey.equals("settings_half_year_not_chat")) {
        if (!this.nQP)
        {
          bool1 = true;
          localCheckPreference.rHo = bool1;
          if (this.nQP) {
            break label113;
          }
          bool1 = true;
          label52:
          this.nQP = bool1;
          label57:
          paramPreference = (TextButtonPreference)paramf.add("settings_next_step");
          if ((!this.nQP) && (!this.nQR))
          {
            bool1 = bool2;
            if (!this.nQQ) {}
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
      return true;
      bool1 = false;
      break;
      label113:
      bool1 = false;
      break label52;
      if (paramPreference.mKey.equals("settings_has_not_same_chatroom"))
      {
        if (!this.nQR)
        {
          bool1 = true;
          label139:
          localCheckPreference.rHo = bool1;
          if (this.nQR) {
            break label167;
          }
        }
        label167:
        for (bool1 = true;; bool1 = false)
        {
          this.nQR = bool1;
          break;
          bool1 = false;
          break label139;
        }
      }
      if (!paramPreference.mKey.equals("settings_half_year_not_response")) {
        break label57;
      }
      if (!this.nQQ)
      {
        bool1 = true;
        label193:
        localCheckPreference.rHo = bool1;
        if (this.nQQ) {
          break label221;
        }
      }
      label221:
      for (bool1 = true;; bool1 = false)
      {
        this.nQQ = bool1;
        break;
        bool1 = false;
        break label193;
      }
      if (paramPreference.mKey.equals("settings_next_step"))
      {
        paramPreference = new Intent(this, UnfamiliarContactDetailUI.class);
        paramPreference.putExtra("half_year_not_chat", this.nQP);
        paramPreference.putExtra("half_year_not_response", this.nQQ);
        paramPreference.putExtra("has_not_same_chatroom", this.nQR);
        startActivityForResult(paramPreference, 291);
      }
    }
  }
  
  protected final void initView()
  {
    super.initView();
    setMMTitle(a.i.settings_unfamiliar_contact);
    setBackBtn(new UnfamiliarContactUI.1(this));
    ((CheckPreference)this.vdd.add("settings_half_year_not_chat")).vbY = 0;
    ((CheckPreference)this.vdd.add("settings_has_not_same_chatroom")).vbY = 0;
    ((CheckPreference)this.vdd.add("settings_half_year_not_response")).vbY = 0;
    ((TextButtonPreference)this.vdd.add("settings_next_step")).setEnabled(false);
    this.vdd.notifyDataSetChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      onBackPressed();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final int xj()
  {
    return a.k.settings_unfamiliar_contact_ui;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactUI
 * JD-Core Version:    0.7.0.1
 */