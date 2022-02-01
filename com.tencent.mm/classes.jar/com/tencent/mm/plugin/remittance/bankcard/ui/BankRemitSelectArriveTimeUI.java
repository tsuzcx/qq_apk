package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.component.UIComponent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class BankRemitSelectArriveTimeUI
  extends MMPreference
{
  private List<EnterTimeParcel> OeU;
  private List<Preference> OeV;
  private int OeW;
  private f screen;
  
  public int getResourceId()
  {
    return a.g.bank_remit_select_arrive_time_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67574);
    this.screen = getPreferenceScreen();
    if ((this.OeU != null) && (this.OeU.size() > 0))
    {
      this.OeV = new ArrayList();
      int i = 0;
      if (i < this.OeU.size())
      {
        EnterTimeParcel localEnterTimeParcel = (EnterTimeParcel)this.OeU.get(i);
        Log.d("MicroMsg.BankRemitSelectArriveTimeUI", "enter scene: %d", new Object[] { Integer.valueOf(localEnterTimeParcel.Ocy) });
        Preference localPreference = new Preference(this);
        localPreference.setLayoutResource(a.g.bank_remit_select_arrive_preference);
        localPreference.adZV = false;
        localPreference.setKey(localEnterTimeParcel.Ocy);
        localPreference.setTitle(localEnterTimeParcel.Ocz);
        if (localEnterTimeParcel.Ocy == this.OeW) {
          localPreference.aBp(a.g.mm_preference_radio_checked);
        }
        for (;;)
        {
          if (localEnterTimeParcel.OcB == 0)
          {
            if (!Util.isNullOrNil(localEnterTimeParcel.OcA)) {
              localPreference.aS(localEnterTimeParcel.OcA);
            }
            localPreference.setEnabled(false);
          }
          localPreference.getExtras().putParcelable("arrive_time", localEnterTimeParcel);
          this.screen.c(localPreference);
          this.OeV.add(localPreference);
          i += 1;
          break;
          localPreference.aBp(a.g.mm_preference_radio_unchecked);
        }
      }
    }
    AppMethodBeat.o(67574);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67573);
    super.onCreate(paramBundle);
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.bank_remit_common_bg)));
    paramBundle = getSupportActionBar().getCustomView();
    if (paramBundle != null)
    {
      View localView = paramBundle.findViewById(a.f.divider);
      if (localView != null) {
        localView.setBackgroundColor(getResources().getColor(a.c.black));
      }
      paramBundle = paramBundle.findViewById(16908308);
      if ((paramBundle != null) && ((paramBundle instanceof TextView))) {
        ((TextView)paramBundle).setTextColor(getResources().getColor(a.c.normal_text_color));
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(a.c.bank_remit_common_bg));
    }
    BankRemitBaseUI.bk(this);
    getContentView().setFitsSystemWindows(true);
    setMMTitle(a.i.bank_remit_select_arrive_time_title);
    this.OeU = getIntent().getParcelableArrayListExtra("key_arrive_time_parcel_list");
    this.OeW = getIntent().getIntExtra("key_select_arrive_time", -1);
    initView();
    findViewById(16908298).setBackgroundColor(getResources().getColor(a.c.bank_remit_common_bg));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(67572);
        BankRemitSelectArriveTimeUI.this.finish();
        AppMethodBeat.o(67572);
        return false;
      }
    }, a.h.actionbar_icon_dark_back);
    AppMethodBeat.o(67573);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(67575);
    paramf = this.OeV.iterator();
    while (paramf.hasNext())
    {
      Preference localPreference = (Preference)paramf.next();
      if (localPreference == paramPreference) {
        localPreference.aBp(a.g.mm_preference_radio_checked);
      } else {
        localPreference.aBp(a.g.mm_preference_radio_unchecked);
      }
    }
    this.screen.notifyDataSetChanged();
    paramf = (EnterTimeParcel)paramPreference.getExtras().getParcelable("arrive_time");
    if (paramf == null)
    {
      Log.i("MicroMsg.BankRemitSelectArriveTimeUI", "is header");
      AppMethodBeat.o(67575);
      return false;
    }
    paramPreference = new Intent();
    paramPreference.putExtra("key_enter_time_scene", paramf.Ocy);
    setResult(-1, paramPreference);
    finish();
    AppMethodBeat.o(67575);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(288766);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(BankRemitSelectArriveTimeUI.a.class);
    AppMethodBeat.o(288766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectArriveTimeUI
 * JD-Core Version:    0.7.0.1
 */