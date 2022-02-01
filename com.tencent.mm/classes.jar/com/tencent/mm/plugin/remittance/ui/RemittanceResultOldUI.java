package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.remittance.model.am;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.i;
import java.util.List;

@a(19)
public class RemittanceResultOldUI
  extends RemittanceResultUI
{
  private Orders OsJ;
  private boolean OsK;
  private int mPayScene;
  private String mReceiverName;
  
  private void gMZ()
  {
    AppMethodBeat.i(68310);
    if (getInput().containsKey("key_realname_guide_helper"))
    {
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)getInput().getParcelable("key_realname_guide_helper");
      if (localRealnameGuideHelper != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceResultUI");
        localBundle.putString("realname_verify_process_jump_plugin", "remittance");
        localRealnameGuideHelper.b(this, localBundle, new RemittanceResultOldUI.2(this));
        getInput().remove("key_realname_guide_helper");
      }
      AppMethodBeat.o(68310);
      return;
    }
    gNa();
    AppMethodBeat.o(68310);
  }
  
  private void gNa()
  {
    AppMethodBeat.i(68311);
    getProcess().b(this, getInput());
    new MMHandler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68306);
        if ((RemittanceResultOldUI.c(RemittanceResultOldUI.this) == 33) || (RemittanceResultOldUI.c(RemittanceResultOldUI.this) == 32))
        {
          RemittanceResultOldUI.this.finish();
          AppMethodBeat.o(68306);
          return;
        }
        if ((!Util.isNullOrNil(RemittanceResultOldUI.d(RemittanceResultOldUI.this))) && (!RemittanceResultOldUI.e(RemittanceResultOldUI.this)))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("Chat_User", RemittanceResultOldUI.d(RemittanceResultOldUI.this));
          localIntent.putExtra("finish_direct", false);
          com.tencent.mm.br.c.g(RemittanceResultOldUI.this, ".ui.chatting.ChattingUI", localIntent);
          AppMethodBeat.o(68306);
          return;
        }
        RemittanceResultOldUI.this.finish();
        AppMethodBeat.o(68306);
      }
    }, 100L);
    AppMethodBeat.o(68311);
  }
  
  protected final boolean gNb()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return a.g.remittance_result_ui;
  }
  
  public void initView()
  {
    int k = 1;
    AppMethodBeat.i(68309);
    setMMTitle(getString(a.i.remittance_result_title));
    setBackBtn(null);
    showHomeBtn(false);
    enableBackMenu(false);
    Object localObject1 = (TextView)findViewById(a.f.remittance_result_fee);
    if (this.OsJ != null) {
      ((TextView)localObject1).setText(i.e(this.OsJ.hAW, this.OsJ.MEq));
    }
    Object localObject3 = (PayInfo)getInput().getParcelable("key_pay_info");
    if (localObject3 == null)
    {
      Log.e("MicroMsg.RemittanceResultOldUI", "payInfo is null!!!");
      finish();
      AppMethodBeat.o(68309);
      return;
    }
    localObject1 = "";
    if (((PayInfo)localObject3).nKf != null)
    {
      this.OsK = ((PayInfo)localObject3).nKf.getBoolean("extinfo_key_4");
      localObject1 = ((PayInfo)localObject3).nKf.getString("extinfo_key_1");
    }
    int i = ((PayInfo)localObject3).hUR;
    this.mPayScene = i;
    this.mReceiverName = ((String)localObject1);
    Object localObject2 = i.getDisplayName((String)localObject1);
    if (i == 31)
    {
      localObject1 = (TextView)findViewById(a.f.remittance_result_receiver_desc);
      localObject2 = getString(a.i.remittance_result_receiver_desc, new Object[] { localObject2 });
      if (!Util.isNullOrNil((String)localObject2))
      {
        ((TextView)localObject1).setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, (CharSequence)localObject2, ((TextView)localObject1).getTextSize()));
        ((TextView)localObject1).setVisibility(0);
      }
      for (;;)
      {
        findViewById(a.f.remittance_result_f2f_area).setVisibility(8);
        if (this.OsJ.OjF > 0.0D)
        {
          localObject1 = getResources().getString(a.i.remittance_result_charge_info, new Object[] { i.e(this.OsJ.OjF, this.OsJ.MEq) });
          ((TextView)findViewById(a.f.charge_fee)).setText((CharSequence)localObject1);
          findViewById(a.f.charge_fee_container).setVisibility(0);
        }
        ((Button)findViewById(a.f.remittance_result_next_btn)).setOnClickListener(new RemittanceResultOldUI.1(this));
        ((com.tencent.mm.plugin.fingerprint.mgr.e)h.ax(com.tencent.mm.plugin.fingerprint.mgr.e.class)).l(this);
        AppMethodBeat.o(68309);
        return;
        ((TextView)localObject1).setVisibility(8);
      }
    }
    localObject1 = "";
    if (((PayInfo)localObject3).nKf != null) {
      localObject1 = ((PayInfo)localObject3).nKf.getString("extinfo_key_2");
    }
    if ((i != 32) && (i != 33)) {
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject1 = i.bEN((String)localObject1);
        localObject1 = (String)localObject2 + "（" + (String)localObject1 + "）";
      }
    }
    for (;;)
    {
      label463:
      localObject2 = (TextView)findViewById(a.f.remittance_result_receiver_desc);
      label519:
      TextView localTextView;
      String str1;
      if (!Util.isNullOrNil((String)localObject1))
      {
        ((TextView)localObject2).setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, getString(a.i.remittance_result_payer_desc, new Object[] { localObject1 }), ((TextView)localObject2).getTextSize()));
        ((TextView)localObject2).setVisibility(0);
        if ((i != 33) && (i != 32)) {
          break label841;
        }
        localObject1 = findViewById(a.f.remittance_result_f2f_recv_desc_area);
        localObject2 = (TextView)findViewById(a.f.remittance_result_f2f_recv_desc_title);
        localTextView = (TextView)findViewById(a.f.remittance_result_f2f_recv_desc);
        str1 = ((PayInfo)localObject3).nKf.getString("extinfo_key_3");
        String str2 = ((PayInfo)localObject3).nKf.getString("extinfo_key_8");
        if (Util.isNullOrNil(str1)) {
          break label817;
        }
        localTextView.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, str1, localTextView.getTextSize()));
        ((View)localObject1).setVisibility(0);
        if (Util.isNullOrNil(str2)) {
          break label924;
        }
        ((TextView)localObject2).setText(str2);
        i = 1;
      }
      for (;;)
      {
        label637:
        localObject1 = findViewById(a.f.remittance_result_f2f_payer_desc_area);
        localObject2 = (TextView)findViewById(a.f.remittance_result_f2f_payer_desc_title);
        localTextView = (TextView)findViewById(a.f.remittance_result_f2f_payer_desc);
        str1 = ((PayInfo)localObject3).nKf.getString("extinfo_key_6");
        localObject3 = ((PayInfo)localObject3).nKf.getString("extinfo_key_7");
        if (!Util.isNullOrNil((String)localObject3))
        {
          localTextView.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, (CharSequence)localObject3, localTextView.getTextSize()));
          localTextView.setVisibility(0);
          j = k;
          if (!Util.isNullOrNil(str1)) {
            ((TextView)localObject2).setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, str1, ((TextView)localObject2).getTextSize()));
          }
        }
        for (int j = k;; j = 0)
        {
          if ((i != 0) || (j != 0)) {
            break label839;
          }
          findViewById(a.f.remittance_result_f2f_area).setVisibility(8);
          break;
          localObject1 = (String)localObject2 + getString(a.i.remittance_without_realname_title);
          break label463;
          ((TextView)localObject2).setVisibility(8);
          break label519;
          label817:
          ((View)localObject1).setVisibility(8);
          i = 0;
          break label637;
          ((View)localObject1).setVisibility(8);
        }
        label839:
        break;
        label841:
        if ((i != 5) || (this.OsJ.VGX == null) || (this.OsJ.VGX.get(0) == null) || (TextUtils.isEmpty(((Orders.Commodity)this.OsJ.VGX.get(0)).MEf))) {
          break;
        }
        ((TextView)localObject2).setText(((Orders.Commodity)this.OsJ.VGX.get(0)).MEf);
        break;
        label924:
        i = 1;
      }
      localObject1 = localObject2;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68307);
    super.onCreate(paramBundle);
    this.OsJ = ((Orders)getInput().getParcelable("key_orders"));
    initView();
    if (this.mPayScene == 31)
    {
      paramBundle = "";
      if (this.OsJ.VGX.size() > 0) {
        paramBundle = ((Orders.Commodity)this.OsJ.VGX.get(0)).hAU;
      }
      Log.i("MicroMsg.RemittanceResultOldUI", "transId: %s", new Object[] { paramBundle });
      com.tencent.mm.plugin.remittance.app.c.gLv().gLy().lz(paramBundle, this.mReceiverName);
    }
    AppMethodBeat.o(68307);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68308);
    if (paramInt == 4) {
      gMZ();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(68308);
    return bool;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultOldUI
 * JD-Core Version:    0.7.0.1
 */