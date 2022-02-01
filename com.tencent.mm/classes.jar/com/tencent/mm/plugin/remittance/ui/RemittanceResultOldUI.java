package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.h;
import com.tencent.mm.plugin.remittance.model.ac;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.f;
import java.util.List;

@a(19)
public class RemittanceResultOldUI
  extends RemittanceResultUI
{
  private Orders CwO;
  private boolean CwP;
  private int mPayScene;
  private String mReceiverName;
  
  private void eOl()
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
        localRealnameGuideHelper.b(this, localBundle, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68305);
            RemittanceResultOldUI.b(RemittanceResultOldUI.this);
            AppMethodBeat.o(68305);
          }
        });
        getInput().remove("key_realname_guide_helper");
      }
      AppMethodBeat.o(68310);
      return;
    }
    eOm();
    AppMethodBeat.o(68310);
  }
  
  private void eOm()
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
          com.tencent.mm.br.c.f(RemittanceResultOldUI.this, ".ui.chatting.ChattingUI", localIntent);
          AppMethodBeat.o(68306);
          return;
        }
        RemittanceResultOldUI.this.finish();
        AppMethodBeat.o(68306);
      }
    }, 100L);
    AppMethodBeat.o(68311);
  }
  
  protected final boolean eOn()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131496111;
  }
  
  public void initView()
  {
    int k = 1;
    AppMethodBeat.i(68309);
    setMMTitle(getString(2131764593));
    setBackBtn(null);
    showHomeBtn(false);
    enableBackMenu(false);
    Object localObject1 = (TextView)findViewById(2131306933);
    if (this.CwO != null) {
      ((TextView)localObject1).setText(f.d(this.CwO.dDO, this.CwO.AOl));
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
    if (((PayInfo)localObject3).iqp != null)
    {
      this.CwP = ((PayInfo)localObject3).iqp.getBoolean("extinfo_key_4");
      localObject1 = ((PayInfo)localObject3).iqp.getString("extinfo_key_1");
    }
    int i = ((PayInfo)localObject3).dVv;
    this.mPayScene = i;
    this.mReceiverName = ((String)localObject1);
    Object localObject2 = f.getDisplayName((String)localObject1);
    if (i == 31)
    {
      localObject1 = (TextView)findViewById(2131306935);
      localObject2 = getString(2131764592, new Object[] { localObject2 });
      if (!Util.isNullOrNil((String)localObject2))
      {
        ((TextView)localObject1).setText(l.b(this, (CharSequence)localObject2, ((TextView)localObject1).getTextSize()));
        ((TextView)localObject1).setVisibility(0);
      }
      for (;;)
      {
        findViewById(2131306926).setVisibility(8);
        if (this.CwO.CoZ > 0.0D)
        {
          localObject1 = getResources().getString(2131764590, new Object[] { f.d(this.CwO.CoZ, this.CwO.AOl) });
          ((TextView)findViewById(2131298288)).setText((CharSequence)localObject1);
          findViewById(2131298289).setVisibility(0);
        }
        ((Button)findViewById(2131306934)).setOnClickListener(new RemittanceResultOldUI.1(this));
        ((h)g.af(h.class)).i(this);
        AppMethodBeat.o(68309);
        return;
        ((TextView)localObject1).setVisibility(8);
      }
    }
    localObject1 = "";
    if (((PayInfo)localObject3).iqp != null) {
      localObject1 = ((PayInfo)localObject3).iqp.getString("extinfo_key_2");
    }
    if ((i != 32) && (i != 33)) {
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject1 = f.bps((String)localObject1);
        localObject1 = (String)localObject2 + "（" + (String)localObject1 + "）";
      }
    }
    for (;;)
    {
      label454:
      localObject2 = (TextView)findViewById(2131306935);
      label509:
      TextView localTextView;
      String str1;
      if (!Util.isNullOrNil((String)localObject1))
      {
        ((TextView)localObject2).setText(l.b(this, getString(2131764591, new Object[] { localObject1 }), ((TextView)localObject2).getTextSize()));
        ((TextView)localObject2).setVisibility(0);
        if ((i != 33) && (i != 32)) {
          break label830;
        }
        localObject1 = findViewById(2131306931);
        localObject2 = (TextView)findViewById(2131306932);
        localTextView = (TextView)findViewById(2131306930);
        str1 = ((PayInfo)localObject3).iqp.getString("extinfo_key_3");
        String str2 = ((PayInfo)localObject3).iqp.getString("extinfo_key_8");
        if (Util.isNullOrNil(str1)) {
          break label806;
        }
        localTextView.setText(l.b(this, str1, localTextView.getTextSize()));
        ((View)localObject1).setVisibility(0);
        if (Util.isNullOrNil(str2)) {
          break label913;
        }
        ((TextView)localObject2).setText(str2);
        i = 1;
      }
      for (;;)
      {
        label627:
        localObject1 = findViewById(2131306928);
        localObject2 = (TextView)findViewById(2131306929);
        localTextView = (TextView)findViewById(2131306927);
        str1 = ((PayInfo)localObject3).iqp.getString("extinfo_key_6");
        localObject3 = ((PayInfo)localObject3).iqp.getString("extinfo_key_7");
        if (!Util.isNullOrNil((String)localObject3))
        {
          localTextView.setText(l.b(this, (CharSequence)localObject3, localTextView.getTextSize()));
          localTextView.setVisibility(0);
          j = k;
          if (!Util.isNullOrNil(str1)) {
            ((TextView)localObject2).setText(l.b(this, str1, ((TextView)localObject2).getTextSize()));
          }
        }
        for (int j = k;; j = 0)
        {
          if ((i != 0) || (j != 0)) {
            break label828;
          }
          findViewById(2131306926).setVisibility(8);
          break;
          localObject1 = (String)localObject2 + getString(2131764609);
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
        if ((i != 5) || (this.CwO.HZd == null) || (this.CwO.HZd.get(0) == null) || (TextUtils.isEmpty(((Orders.Commodity)this.CwO.HZd.get(0)).AOa))) {
          break;
        }
        ((TextView)localObject2).setText(((Orders.Commodity)this.CwO.HZd.get(0)).AOa);
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
    this.CwO = ((Orders)getInput().getParcelable("key_orders"));
    initView();
    if (this.mPayScene == 31)
    {
      paramBundle = "";
      if (this.CwO.HZd.size() > 0) {
        paramBundle = ((Orders.Commodity)this.CwO.HZd.get(0)).dDM;
      }
      Log.i("MicroMsg.RemittanceResultOldUI", "transId: %s", new Object[] { paramBundle });
      com.tencent.mm.plugin.remittance.a.c.eMU().eMX().jM(paramBundle, this.mReceiverName);
    }
    AppMethodBeat.o(68307);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68308);
    if (paramInt == 4) {
      eOl();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(68308);
    return bool;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultOldUI
 * JD-Core Version:    0.7.0.1
 */