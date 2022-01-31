package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BankRemitSelectArriveTimeUI
  extends MMPreference
{
  private List<EnterTimeParcel> qio;
  private List<Preference> qip;
  private int qiq;
  private f screen;
  
  public int getResourceId()
  {
    return 2130968829;
  }
  
  public void initView()
  {
    AppMethodBeat.i(44661);
    this.screen = getPreferenceScreen();
    if ((this.qio != null) && (this.qio.size() > 0))
    {
      this.qip = new ArrayList();
      int i = 0;
      if (i < this.qio.size())
      {
        EnterTimeParcel localEnterTimeParcel = (EnterTimeParcel)this.qio.get(i);
        ab.d("MicroMsg.BankRemitSelectArriveTimeUI", "enter scene: %d", new Object[] { Integer.valueOf(localEnterTimeParcel.qgh) });
        Preference localPreference = new Preference(this);
        localPreference.setLayoutResource(2130968828);
        localPreference.zsk = false;
        localPreference.setKey(localEnterTimeParcel.qgh);
        localPreference.setTitle(localEnterTimeParcel.qgi);
        if (localEnterTimeParcel.qgh == this.qiq) {
          localPreference.setWidgetLayoutResource(2130970249);
        }
        for (;;)
        {
          if (localEnterTimeParcel.qgk == 0)
          {
            if (!bo.isNullOrNil(localEnterTimeParcel.qgj)) {
              localPreference.setSummary(localEnterTimeParcel.qgj);
            }
            localPreference.setEnabled(false);
          }
          localPreference.getExtras().putParcelable("arrive_time", localEnterTimeParcel);
          this.screen.b(localPreference);
          this.qip.add(localPreference);
          i += 1;
          break;
          localPreference.setWidgetLayoutResource(2130970250);
        }
      }
    }
    AppMethodBeat.o(44661);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(44660);
    super.onCreate(paramBundle);
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131689743)));
    paramBundle = getSupportActionBar().getCustomView();
    if (paramBundle != null)
    {
      View localView = paramBundle.findViewById(2131821148);
      if (localView != null) {
        localView.setBackgroundColor(getResources().getColor(2131689763));
      }
      paramBundle = paramBundle.findViewById(16908308);
      if ((paramBundle != null) && ((paramBundle instanceof TextView))) {
        ((TextView)paramBundle).setTextColor(getResources().getColor(2131689763));
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(2131689743));
    }
    BankRemitBaseUI.ae(this);
    getContentView().setFitsSystemWindows(true);
    setMMTitle(2131297509);
    this.qio = getIntent().getParcelableArrayListExtra("key_arrive_time_parcel_list");
    this.qiq = getIntent().getIntExtra("key_select_arrive_time", -1);
    initView();
    findViewById(16908298).setBackgroundColor(getResources().getColor(2131689743));
    setBackBtn(new BankRemitSelectArriveTimeUI.1(this), 2131230737);
    AppMethodBeat.o(44660);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(44662);
    paramf = this.qip.iterator();
    while (paramf.hasNext())
    {
      Preference localPreference = (Preference)paramf.next();
      if (localPreference == paramPreference) {
        localPreference.setWidgetLayoutResource(2130970249);
      } else {
        localPreference.setWidgetLayoutResource(2130970250);
      }
    }
    this.screen.notifyDataSetChanged();
    paramf = (EnterTimeParcel)paramPreference.getExtras().getParcelable("arrive_time");
    if (paramf == null)
    {
      ab.i("MicroMsg.BankRemitSelectArriveTimeUI", "is header");
      AppMethodBeat.o(44662);
      return false;
    }
    paramPreference = new Intent();
    paramPreference.putExtra("key_enter_time_scene", paramf.qgh);
    setResult(-1, paramPreference);
    finish();
    AppMethodBeat.o(44662);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectArriveTimeUI
 * JD-Core Version:    0.7.0.1
 */