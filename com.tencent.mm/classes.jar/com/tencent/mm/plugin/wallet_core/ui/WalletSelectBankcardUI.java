package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

@a(19)
public class WalletSelectBankcardUI
  extends WalletBaseUI
{
  private TextView Aqr;
  private MaxListView Aqs;
  private WalletSelectBankcardUI.a Aqt = null;
  private String Aqu = null;
  private boolean Aqv = true;
  private String Aqw = null;
  private List<Bankcard> Aqx = null;
  private int mScene = 0;
  private TextView nVR;
  
  public int getLayoutId()
  {
    return 2131496027;
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71227);
    super.onCreate(paramBundle);
    setMMTitle(2131765035);
    this.mScene = getInput().getInt("key_scene", 0);
    this.Aqu = getInput().getString("key_top_tips");
    this.Aqv = getInput().getBoolean("key_is_show_new_bankcard", true);
    this.Aqw = getInput().getString("bottom_tips");
    this.Aqx = getInput().getParcelableArrayList("key_showing_bankcards");
    if (this.Aqx == null) {
      this.Aqx = s.ecc().ecZ();
    }
    this.Aqr = ((TextView)findViewById(2131305947));
    this.Aqs = ((MaxListView)findViewById(2131297167));
    this.nVR = ((TextView)findViewById(2131297475));
    if (!bt.isNullOrNil(this.Aqu))
    {
      this.Aqr.setVisibility(0);
      this.Aqr.setText(this.Aqu);
      if (bt.isNullOrNil(this.Aqw)) {
        break label342;
      }
      this.nVR.setVisibility(0);
      this.nVR.setText(this.Aqw);
    }
    for (;;)
    {
      if (this.mScene == 0)
      {
        this.nVR.setVisibility(0);
        paramBundle = new l(this);
        paramBundle.Anf = new l.a()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71220);
            ad.i("MicroMsg.WalletSelectBankcardUI", "hy: user clicked the phone.go to dial");
            e.cn(WalletSelectBankcardUI.this, WalletSelectBankcardUI.this.getString(2131765040));
            AppMethodBeat.o(71220);
          }
        };
        String str = getString(2131765843);
        SpannableString localSpannableString = new SpannableString(str);
        localSpannableString.setSpan(paramBundle, str.length() - 14, str.length(), 33);
        this.nVR.setText(localSpannableString);
        this.nVR.setMovementMethod(LinkMovementMethod.getInstance());
      }
      this.Aqt = new WalletSelectBankcardUI.a(this, (byte)0);
      this.Aqs.setAdapter(this.Aqt);
      this.Aqs.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(71223);
          paramAnonymousAdapterView = (Bankcard)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
          if (paramAnonymousAdapterView != null)
          {
            com.tencent.mm.ui.base.h.a(WalletSelectBankcardUI.this, true, WalletSelectBankcardUI.this.getString(2131765845, new Object[] { paramAnonymousAdapterView.field_desc, paramAnonymousAdapterView.field_mobile }), WalletSelectBankcardUI.this.getString(2131765847), WalletSelectBankcardUI.this.getString(2131765844), WalletSelectBankcardUI.this.getString(2131765846), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(71221);
                WalletSelectBankcardUI.this.getInput().putBoolean("key_balance_change_phone_need_confirm_phone", false);
                WalletSelectBankcardUI.a(WalletSelectBankcardUI.this, paramAnonymousAdapterView);
                com.tencent.mm.plugin.report.service.h.vKh.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
                AppMethodBeat.o(71221);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(71222);
                WalletSelectBankcardUI.this.getInput().putBoolean("key_balance_change_phone_need_confirm_phone", true);
                WalletSelectBankcardUI.a(WalletSelectBankcardUI.this, paramAnonymousAdapterView);
                AppMethodBeat.o(71222);
              }
            });
            AppMethodBeat.o(71223);
            return;
          }
          WalletSelectBankcardUI.this.getInput().putBoolean("key_balance_change_phone_need_confirm_phone", false);
          WalletSelectBankcardUI.a(WalletSelectBankcardUI.this, null);
          AppMethodBeat.o(71223);
        }
      });
      AppMethodBeat.o(71227);
      return;
      this.Aqr.setVisibility(8);
      break;
      label342:
      this.nVR.setVisibility(8);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI
 * JD-Core Version:    0.7.0.1
 */