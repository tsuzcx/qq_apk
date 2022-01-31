package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BankRemitSelectArriveTimeUI
  extends MMPreference
{
  private f dnn;
  private List<EnterTimeParcel> nxn;
  private List<Preference> nxo;
  private int nxp;
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    paramf = this.nxo.iterator();
    while (paramf.hasNext())
    {
      Preference localPreference = (Preference)paramf.next();
      if (localPreference == paramPreference) {
        localPreference.setWidgetLayoutResource(a.g.mm_preference_radio_checked);
      } else {
        localPreference.setWidgetLayoutResource(a.g.mm_preference_radio_unchecked);
      }
    }
    this.dnn.notifyDataSetChanged();
    paramf = (EnterTimeParcel)paramPreference.getExtras().getParcelable("arrive_time");
    if (paramf == null)
    {
      y.i("MicroMsg.BankRemitSelectArriveTimeUI", "is header");
      return false;
    }
    paramPreference = new Intent();
    paramPreference.putExtra("key_enter_time_scene", paramf.nvl);
    setResult(-1, paramPreference);
    finish();
    return false;
  }
  
  protected final void initView()
  {
    this.dnn = this.vdd;
    if ((this.nxn != null) && (this.nxn.size() > 0))
    {
      this.nxo = new ArrayList();
      int i = 0;
      if (i < this.nxn.size())
      {
        EnterTimeParcel localEnterTimeParcel = (EnterTimeParcel)this.nxn.get(i);
        y.d("MicroMsg.BankRemitSelectArriveTimeUI", "enter scene: %d", new Object[] { Integer.valueOf(localEnterTimeParcel.nvl) });
        Preference localPreference = new Preference(this);
        localPreference.setLayoutResource(a.g.bank_remit_select_arrive_preference);
        localPreference.vdK = false;
        localPreference.setKey(localEnterTimeParcel.nvl);
        localPreference.setTitle(localEnterTimeParcel.nvm);
        if (localEnterTimeParcel.nvl == this.nxp) {
          localPreference.setWidgetLayoutResource(a.g.mm_preference_radio_checked);
        }
        for (;;)
        {
          if (localEnterTimeParcel.nvo == 0)
          {
            if (!bk.bl(localEnterTimeParcel.nvn)) {
              localPreference.setSummary(localEnterTimeParcel.nvn);
            }
            localPreference.setEnabled(false);
          }
          localPreference.getExtras().putParcelable("arrive_time", localEnterTimeParcel);
          this.dnn.a(localPreference);
          this.nxo.add(localPreference);
          i += 1;
          break;
          localPreference.setWidgetLayoutResource(a.g.mm_preference_radio_unchecked);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
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
        ((TextView)paramBundle).setTextColor(getResources().getColor(a.c.black));
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(a.c.bank_remit_common_bg));
    }
    BankRemitBaseUI.J(this);
    this.mController.contentView.setFitsSystemWindows(true);
    setMMTitle(a.i.bank_remit_select_arrive_time_title);
    this.nxn = getIntent().getParcelableArrayListExtra("key_arrive_time_parcel_list");
    this.nxp = getIntent().getIntExtra("key_select_arrive_time", -1);
    initView();
    findViewById(16908298).setBackgroundColor(getResources().getColor(a.c.bank_remit_common_bg));
    setBackBtn(new BankRemitSelectArriveTimeUI.1(this), a.h.actionbar_icon_dark_back);
  }
  
  public final int xj()
  {
    return a.g.bank_remit_select_arrive_time_ui;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectArriveTimeUI
 * JD-Core Version:    0.7.0.1
 */