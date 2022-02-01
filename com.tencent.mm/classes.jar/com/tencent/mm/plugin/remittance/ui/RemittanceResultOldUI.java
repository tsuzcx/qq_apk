package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.h;
import com.tencent.mm.plugin.remittance.a.c;
import com.tencent.mm.plugin.remittance.model.ac;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.f;
import java.util.List;

@a(19)
public class RemittanceResultOldUI
  extends RemittanceResultUI
{
  private int mPayScene;
  private String mReceiverName;
  private Orders yvS;
  private boolean yvT;
  
  private void dNl()
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
    dNm();
    AppMethodBeat.o(68310);
  }
  
  private void dNm()
  {
    AppMethodBeat.i(68311);
    getProcess().b(this, getInput());
    new aq().postDelayed(new Runnable()
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
        if ((!bu.isNullOrNil(RemittanceResultOldUI.d(RemittanceResultOldUI.this))) && (!RemittanceResultOldUI.e(RemittanceResultOldUI.this)))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("Chat_User", RemittanceResultOldUI.d(RemittanceResultOldUI.this));
          localIntent.putExtra("finish_direct", false);
          com.tencent.mm.br.d.f(RemittanceResultOldUI.this, ".ui.chatting.ChattingUI", localIntent);
          AppMethodBeat.o(68306);
          return;
        }
        RemittanceResultOldUI.this.finish();
        AppMethodBeat.o(68306);
      }
    }, 100L);
    AppMethodBeat.o(68311);
  }
  
  protected final boolean dNn()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131495262;
  }
  
  public void initView()
  {
    int k = 1;
    AppMethodBeat.i(68309);
    setMMTitle(getString(2131762526));
    setBackBtn(null);
    showHomeBtn(false);
    enableBackMenu(false);
    Object localObject1 = (TextView)findViewById(2131304070);
    if (this.yvS != null) {
      ((TextView)localObject1).setText(f.d(this.yvS.dmz, this.yvS.wSq));
    }
    Object localObject3 = (PayInfo)getInput().getParcelable("key_pay_info");
    if (localObject3 == null)
    {
      ae.e("MicroMsg.RemittanceResultOldUI", "payInfo is null!!!");
      finish();
      AppMethodBeat.o(68309);
      return;
    }
    localObject1 = "";
    if (((PayInfo)localObject3).hwN != null)
    {
      this.yvT = ((PayInfo)localObject3).hwN.getBoolean("extinfo_key_4");
      localObject1 = ((PayInfo)localObject3).hwN.getString("extinfo_key_1");
    }
    int i = ((PayInfo)localObject3).dDH;
    this.mPayScene = i;
    this.mReceiverName = ((String)localObject1);
    Object localObject2 = f.zP((String)localObject1);
    if (i == 31)
    {
      localObject1 = (TextView)findViewById(2131304072);
      localObject2 = getString(2131762525, new Object[] { localObject2 });
      if (!bu.isNullOrNil((String)localObject2))
      {
        ((TextView)localObject1).setText(k.b(this, (CharSequence)localObject2, ((TextView)localObject1).getTextSize()));
        ((TextView)localObject1).setVisibility(0);
      }
      for (;;)
      {
        findViewById(2131304063).setVisibility(8);
        if (this.yvS.yoj > 0.0D)
        {
          localObject1 = getResources().getString(2131762523, new Object[] { f.d(this.yvS.yoj, this.yvS.wSq) });
          ((TextView)findViewById(2131297953)).setText((CharSequence)localObject1);
          findViewById(2131297954).setVisibility(0);
        }
        ((Button)findViewById(2131304071)).setOnClickListener(new RemittanceResultOldUI.1(this));
        ((h)g.ab(h.class)).i(this);
        AppMethodBeat.o(68309);
        return;
        ((TextView)localObject1).setVisibility(8);
      }
    }
    localObject1 = "";
    if (((PayInfo)localObject3).hwN != null) {
      localObject1 = ((PayInfo)localObject3).hwN.getString("extinfo_key_2");
    }
    if ((i != 32) && (i != 33)) {
      if (!bu.isNullOrNil((String)localObject1))
      {
        localObject1 = f.bak((String)localObject1);
        localObject1 = (String)localObject2 + "（" + (String)localObject1 + "）";
      }
    }
    for (;;)
    {
      label454:
      localObject2 = (TextView)findViewById(2131304072);
      label509:
      TextView localTextView;
      String str1;
      if (!bu.isNullOrNil((String)localObject1))
      {
        ((TextView)localObject2).setText(k.b(this, getString(2131762524, new Object[] { localObject1 }), ((TextView)localObject2).getTextSize()));
        ((TextView)localObject2).setVisibility(0);
        if ((i != 33) && (i != 32)) {
          break label830;
        }
        localObject1 = findViewById(2131304068);
        localObject2 = (TextView)findViewById(2131304069);
        localTextView = (TextView)findViewById(2131304067);
        str1 = ((PayInfo)localObject3).hwN.getString("extinfo_key_3");
        String str2 = ((PayInfo)localObject3).hwN.getString("extinfo_key_8");
        if (bu.isNullOrNil(str1)) {
          break label806;
        }
        localTextView.setText(k.b(this, str1, localTextView.getTextSize()));
        ((View)localObject1).setVisibility(0);
        if (bu.isNullOrNil(str2)) {
          break label913;
        }
        ((TextView)localObject2).setText(str2);
        i = 1;
      }
      for (;;)
      {
        label627:
        localObject1 = findViewById(2131304065);
        localObject2 = (TextView)findViewById(2131304066);
        localTextView = (TextView)findViewById(2131304064);
        str1 = ((PayInfo)localObject3).hwN.getString("extinfo_key_6");
        localObject3 = ((PayInfo)localObject3).hwN.getString("extinfo_key_7");
        if (!bu.isNullOrNil((String)localObject3))
        {
          localTextView.setText(k.b(this, (CharSequence)localObject3, localTextView.getTextSize()));
          localTextView.setVisibility(0);
          j = k;
          if (!bu.isNullOrNil(str1)) {
            ((TextView)localObject2).setText(k.b(this, str1, ((TextView)localObject2).getTextSize()));
          }
        }
        for (int j = k;; j = 0)
        {
          if ((i != 0) || (j != 0)) {
            break label828;
          }
          findViewById(2131304063).setVisibility(8);
          break;
          localObject1 = (String)localObject2 + getString(2131762542);
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
        if ((i != 5) || (this.yvS.DpP == null) || (this.yvS.DpP.get(0) == null) || (TextUtils.isEmpty(((Orders.Commodity)this.yvS.DpP.get(0)).wSf))) {
          break;
        }
        ((TextView)localObject2).setText(((Orders.Commodity)this.yvS.DpP.get(0)).wSf);
        break;
        label913:
        i = 1;
      }
      localObject1 = localObject2;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68307);
    super.onCreate(paramBundle);
    this.yvS = ((Orders)getInput().getParcelable("key_orders"));
    initView();
    if (this.mPayScene == 31)
    {
      paramBundle = "";
      if (this.yvS.DpP.size() > 0) {
        paramBundle = ((Orders.Commodity)this.yvS.DpP.get(0)).dmx;
      }
      ae.i("MicroMsg.RemittanceResultOldUI", "transId: %s", new Object[] { paramBundle });
      c.dLS().dLV().jb(paramBundle, this.mReceiverName);
    }
    AppMethodBeat.o(68307);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68308);
    if (paramInt == 4) {
      dNl();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(68308);
    return bool;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultOldUI
 * JD-Core Version:    0.7.0.1
 */