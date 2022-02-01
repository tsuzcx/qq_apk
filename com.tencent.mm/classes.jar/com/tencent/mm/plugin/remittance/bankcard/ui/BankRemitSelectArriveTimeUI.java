package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BankRemitSelectArriveTimeUI
  extends MMPreference
{
  private f screen;
  private List<EnterTimeParcel> wGR;
  private List<Preference> wGS;
  private int wGT;
  
  public int getResourceId()
  {
    return 2131493161;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67574);
    this.screen = getPreferenceScreen();
    if ((this.wGR != null) && (this.wGR.size() > 0))
    {
      this.wGS = new ArrayList();
      int i = 0;
      if (i < this.wGR.size())
      {
        EnterTimeParcel localEnterTimeParcel = (EnterTimeParcel)this.wGR.get(i);
        ac.d("MicroMsg.BankRemitSelectArriveTimeUI", "enter scene: %d", new Object[] { Integer.valueOf(localEnterTimeParcel.wEF) });
        Preference localPreference = new Preference(this);
        localPreference.setLayoutResource(2131493160);
        localPreference.HFK = false;
        localPreference.setKey(localEnterTimeParcel.wEF);
        localPreference.setTitle(localEnterTimeParcel.wEG);
        if (localEnterTimeParcel.wEF == this.wGT) {
          localPreference.setWidgetLayoutResource(2131494878);
        }
        for (;;)
        {
          if (localEnterTimeParcel.wEI == 0)
          {
            if (!bs.isNullOrNil(localEnterTimeParcel.wEH)) {
              localPreference.setSummary(localEnterTimeParcel.wEH);
            }
            localPreference.setEnabled(false);
          }
          localPreference.getExtras().putParcelable("arrive_time", localEnterTimeParcel);
          this.screen.b(localPreference);
          this.wGS.add(localPreference);
          i += 1;
          break;
          localPreference.setWidgetLayoutResource(2131494879);
        }
      }
    }
    AppMethodBeat.o(67574);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67573);
    super.onCreate(paramBundle);
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131099994)));
    paramBundle = getSupportActionBar().getCustomView();
    if (paramBundle != null)
    {
      View localView = paramBundle.findViewById(2131299154);
      if (localView != null) {
        localView.setBackgroundColor(getResources().getColor(2131100017));
      }
      paramBundle = paramBundle.findViewById(16908308);
      if ((paramBundle != null) && ((paramBundle instanceof TextView))) {
        ((TextView)paramBundle).setTextColor(getResources().getColor(2131100711));
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(2131099994));
    }
    BankRemitBaseUI.aA(this);
    getContentView().setFitsSystemWindows(true);
    setMMTitle(2131756395);
    this.wGR = getIntent().getParcelableArrayListExtra("key_arrive_time_parcel_list");
    this.wGT = getIntent().getIntExtra("key_select_arrive_time", -1);
    initView();
    findViewById(16908298).setBackgroundColor(getResources().getColor(2131099994));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(67572);
        BankRemitSelectArriveTimeUI.this.finish();
        AppMethodBeat.o(67572);
        return false;
      }
    }, 2131689490);
    AppMethodBeat.o(67573);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(67575);
    paramf = this.wGS.iterator();
    while (paramf.hasNext())
    {
      Preference localPreference = (Preference)paramf.next();
      if (localPreference == paramPreference) {
        localPreference.setWidgetLayoutResource(2131494878);
      } else {
        localPreference.setWidgetLayoutResource(2131494879);
      }
    }
    this.screen.notifyDataSetChanged();
    paramf = (EnterTimeParcel)paramPreference.getExtras().getParcelable("arrive_time");
    if (paramf == null)
    {
      ac.i("MicroMsg.BankRemitSelectArriveTimeUI", "is header");
      AppMethodBeat.o(67575);
      return false;
    }
    paramPreference = new Intent();
    paramPreference.putExtra("key_enter_time_scene", paramf.wEF);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectArriveTimeUI
 * JD-Core Version:    0.7.0.1
 */