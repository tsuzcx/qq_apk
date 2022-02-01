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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BankRemitSelectArriveTimeUI
  extends MMPreference
{
  private List<EnterTimeParcel> Clr;
  private List<Preference> Cls;
  private int Clt;
  private f screen;
  
  public int getResourceId()
  {
    return 2131493207;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67574);
    this.screen = getPreferenceScreen();
    if ((this.Clr != null) && (this.Clr.size() > 0))
    {
      this.Cls = new ArrayList();
      int i = 0;
      if (i < this.Clr.size())
      {
        EnterTimeParcel localEnterTimeParcel = (EnterTimeParcel)this.Clr.get(i);
        Log.d("MicroMsg.BankRemitSelectArriveTimeUI", "enter scene: %d", new Object[] { Integer.valueOf(localEnterTimeParcel.Cjg) });
        Preference localPreference = new Preference(this);
        localPreference.setLayoutResource(2131493206);
        localPreference.OZw = false;
        localPreference.setKey(localEnterTimeParcel.Cjg);
        localPreference.setTitle(localEnterTimeParcel.Cjh);
        if (localEnterTimeParcel.Cjg == this.Clt) {
          localPreference.setWidgetLayoutResource(2131495615);
        }
        for (;;)
        {
          if (localEnterTimeParcel.Cjj == 0)
          {
            if (!Util.isNullOrNil(localEnterTimeParcel.Cji)) {
              localPreference.setSummary(localEnterTimeParcel.Cji);
            }
            localPreference.setEnabled(false);
          }
          localPreference.getExtras().putParcelable("arrive_time", localEnterTimeParcel);
          this.screen.c(localPreference);
          this.Cls.add(localPreference);
          i += 1;
          break;
          localPreference.setWidgetLayoutResource(2131495616);
        }
      }
    }
    AppMethodBeat.o(67574);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67573);
    super.onCreate(paramBundle);
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131100019)));
    paramBundle = getSupportActionBar().getCustomView();
    if (paramBundle != null)
    {
      View localView = paramBundle.findViewById(2131299682);
      if (localView != null) {
        localView.setBackgroundColor(getResources().getColor(2131100042));
      }
      paramBundle = paramBundle.findViewById(16908308);
      if ((paramBundle != null) && ((paramBundle instanceof TextView))) {
        ((TextView)paramBundle).setTextColor(getResources().getColor(2131100904));
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(2131100019));
    }
    BankRemitBaseUI.aC(this);
    getContentView().setFitsSystemWindows(true);
    setMMTitle(2131756530);
    this.Clr = getIntent().getParcelableArrayListExtra("key_arrive_time_parcel_list");
    this.Clt = getIntent().getIntExtra("key_select_arrive_time", -1);
    initView();
    findViewById(16908298).setBackgroundColor(getResources().getColor(2131100019));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(67572);
        BankRemitSelectArriveTimeUI.this.finish();
        AppMethodBeat.o(67572);
        return false;
      }
    }, 2131689492);
    AppMethodBeat.o(67573);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(67575);
    paramf = this.Cls.iterator();
    while (paramf.hasNext())
    {
      Preference localPreference = (Preference)paramf.next();
      if (localPreference == paramPreference) {
        localPreference.setWidgetLayoutResource(2131495615);
      } else {
        localPreference.setWidgetLayoutResource(2131495616);
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
    paramPreference.putExtra("key_enter_time_scene", paramf.Cjg);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectArriveTimeUI
 * JD-Core Version:    0.7.0.1
 */