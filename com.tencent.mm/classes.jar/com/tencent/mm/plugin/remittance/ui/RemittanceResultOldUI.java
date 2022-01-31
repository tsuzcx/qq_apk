package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

@a(19)
public class RemittanceResultOldUI
  extends RemittanceResultUI
{
  private int mPayScene;
  private String mReceiverName;
  private Orders qrf;
  private boolean qrg;
  
  private void chD()
  {
    AppMethodBeat.i(45151);
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
      AppMethodBeat.o(45151);
      return;
    }
    chE();
    AppMethodBeat.o(45151);
  }
  
  private void chE()
  {
    AppMethodBeat.i(45152);
    getProcess().b(this, getInput());
    new ak().postDelayed(new RemittanceResultOldUI.3(this), 100L);
    AppMethodBeat.o(45152);
  }
  
  protected final boolean chF()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return 2130970578;
  }
  
  public void initView()
  {
    int k = 1;
    AppMethodBeat.i(45153);
    setMMTitle(getString(2131302620));
    setBackBtn(null);
    showHomeBtn(false);
    enableBackMenu(false);
    Object localObject1 = (TextView)findViewById(2131827341);
    if (this.qrf != null) {
      ((TextView)localObject1).setText(e.e(this.qrf.cnL, this.qrf.ppp));
    }
    Object localObject3 = (PayInfo)getInput().getParcelable("key_pay_info");
    if (localObject3 == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.RemittanceResultOldUI", "payInfo is null!!!");
      finish();
      AppMethodBeat.o(45153);
      return;
    }
    localObject1 = "";
    if (((PayInfo)localObject3).wgv != null)
    {
      this.qrg = ((PayInfo)localObject3).wgv.getBoolean("extinfo_key_4");
      localObject1 = ((PayInfo)localObject3).wgv.getString("extinfo_key_1");
    }
    int i = ((PayInfo)localObject3).cCD;
    this.mPayScene = i;
    this.mReceiverName = ((String)localObject1);
    Object localObject2 = e.nE((String)localObject1);
    if (i == 31)
    {
      localObject1 = (TextView)findViewById(2131827340);
      localObject2 = getString(2131302619, new Object[] { localObject2 });
      if (!bo.isNullOrNil((String)localObject2))
      {
        ((TextView)localObject1).setText(j.b(this, (CharSequence)localObject2, ((TextView)localObject1).getTextSize()));
        ((TextView)localObject1).setVisibility(0);
      }
      for (;;)
      {
        findViewById(2131827344).setVisibility(8);
        if (this.qrf.qjD > 0.0D)
        {
          localObject1 = getResources().getString(2131302617, new Object[] { e.e(this.qrf.qjD, this.qrf.ppp) });
          ((TextView)findViewById(2131827343)).setText((CharSequence)localObject1);
          findViewById(2131827342).setVisibility(0);
        }
        ((Button)findViewById(2131827351)).setOnClickListener(new RemittanceResultOldUI.1(this));
        ((i)g.E(i.class)).g(this);
        AppMethodBeat.o(45153);
        return;
        ((TextView)localObject1).setVisibility(8);
      }
    }
    localObject1 = "";
    if (((PayInfo)localObject3).wgv != null) {
      localObject1 = ((PayInfo)localObject3).wgv.getString("extinfo_key_2");
    }
    if ((i != 32) && (i != 33)) {
      if (!bo.isNullOrNil((String)localObject1))
      {
        localObject1 = e.awc((String)localObject1);
        localObject1 = (String)localObject2 + "（" + (String)localObject1 + "）";
      }
    }
    for (;;)
    {
      label454:
      localObject2 = (TextView)findViewById(2131827340);
      label509:
      TextView localTextView;
      String str1;
      if (!bo.isNullOrNil((String)localObject1))
      {
        ((TextView)localObject2).setText(j.b(this, getString(2131302618, new Object[] { localObject1 }), ((TextView)localObject2).getTextSize()));
        ((TextView)localObject2).setVisibility(0);
        if ((i != 33) && (i != 32)) {
          break label830;
        }
        localObject1 = findViewById(2131827345);
        localObject2 = (TextView)findViewById(2131827346);
        localTextView = (TextView)findViewById(2131827347);
        str1 = ((PayInfo)localObject3).wgv.getString("extinfo_key_3");
        String str2 = ((PayInfo)localObject3).wgv.getString("extinfo_key_8");
        if (bo.isNullOrNil(str1)) {
          break label806;
        }
        localTextView.setText(j.b(this, str1, localTextView.getTextSize()));
        ((View)localObject1).setVisibility(0);
        if (bo.isNullOrNil(str2)) {
          break label913;
        }
        ((TextView)localObject2).setText(str2);
        i = 1;
      }
      for (;;)
      {
        label627:
        localObject1 = findViewById(2131827348);
        localObject2 = (TextView)findViewById(2131827349);
        localTextView = (TextView)findViewById(2131827350);
        str1 = ((PayInfo)localObject3).wgv.getString("extinfo_key_6");
        localObject3 = ((PayInfo)localObject3).wgv.getString("extinfo_key_7");
        if (!bo.isNullOrNil((String)localObject3))
        {
          localTextView.setText(j.b(this, (CharSequence)localObject3, localTextView.getTextSize()));
          localTextView.setVisibility(0);
          j = k;
          if (!bo.isNullOrNil(str1)) {
            ((TextView)localObject2).setText(j.b(this, str1, ((TextView)localObject2).getTextSize()));
          }
        }
        for (int j = k;; j = 0)
        {
          if ((i != 0) || (j != 0)) {
            break label828;
          }
          findViewById(2131827344).setVisibility(8);
          break;
          localObject1 = (String)localObject2 + getString(2131302636);
          break label454;
          ((TextView)localObject2).setVisibility(8);
          break label509;
          label806:
          ((View)localObject1).setVisibility(8);
          i = 0;
          break label627;
          ((View)localObject1).setVisibility(8);
        }
        label828:
        break;
        label830:
        if ((i != 5) || (this.qrf.ujl == null) || (this.qrf.ujl.get(0) == null) || (TextUtils.isEmpty(((Orders.Commodity)this.qrf.ujl.get(0)).ppe))) {
          break;
        }
        ((TextView)localObject2).setText(((Orders.Commodity)this.qrf.ujl.get(0)).ppe);
        break;
        label913:
        i = 1;
      }
      localObject1 = localObject2;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45148);
    super.onCreate(paramBundle);
    this.qrf = ((Orders)getInput().getParcelable("key_orders"));
    initView();
    if (this.mPayScene == 31)
    {
      paramBundle = "";
      if (this.qrf.ujl.size() > 0) {
        paramBundle = ((Orders.Commodity)this.qrf.ujl.get(0)).cnJ;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RemittanceResultOldUI", "transId: %s", new Object[] { paramBundle });
      com.tencent.mm.plugin.remittance.a.c.cgH().cgK().fY(paramBundle, this.mReceiverName);
    }
    AppMethodBeat.o(45148);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(45149);
    if (paramInt == 4) {
      chD();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(45149);
    return bool;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultOldUI
 * JD-Core Version:    0.7.0.1
 */