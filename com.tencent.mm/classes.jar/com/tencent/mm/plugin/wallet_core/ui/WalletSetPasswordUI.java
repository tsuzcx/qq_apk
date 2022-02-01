package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.utils.j;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;
import com.tencent.mm.wallet_core.ui.g;

@com.tencent.mm.ui.base.a(1)
public class WalletSetPasswordUI
  extends WalletBaseUI
{
  protected EditHintPasswdView DLa;
  private ScrollView mPe;
  private TextView pPT;
  private TextView tuS;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_set_pwd;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71235);
    this.mPe = ((ScrollView)findViewById(a.f.root_view));
    this.pPT = ((TextView)findViewById(a.f.wallet_pwd_title));
    this.tuS = ((TextView)findViewById(a.f.wallet_pwd_content));
    g.N(this.pPT);
    if ((getInput().getBoolean("key_is_forgot_process", false)) && (!Util.isNullOrNil(getInput().getString("key_identity"))) && (getInput().getInt("key_id_type", -1) != -1) && (!Util.isNullOrNil(getInput().getString("key_true_name")))) {
      this.tuS.setVisibility(4);
    }
    Object localObject;
    if (((getProcess() == null) || (!"ModifyPwdProcess".equals(getProcess().epb()))) && (getProcess() != null) && ("ResetPwdProcessByToken".equals(getProcess().epb())))
    {
      str = getInput().getString("key_pwd_title");
      localObject = getInput().getString("key_pwd_desc");
      if (!Util.isNullOrNil(str)) {
        this.pPT.setText(str);
      }
      if (!Util.isNullOrNil((String)localObject))
      {
        this.tuS.setText((CharSequence)localObject);
        this.tuS.setVisibility(0);
      }
    }
    if (getInput().getInt("key_err_code", 0) == -1002)
    {
      this.tuS.setTextColor(getResources().getColor(a.c.Red));
      localObject = this.tuS;
      if (!z.bdq()) {
        break label372;
      }
    }
    label372:
    for (String str = getString(a.i.wallet_set_password_no_same_payu);; str = getString(a.i.wallet_set_password_no_same))
    {
      ((TextView)localObject).setText(str);
      getInput().putInt("key_err_code", 0);
      this.DLa = ((EditHintPasswdView)findViewById(a.f.input_et));
      com.tencent.mm.wallet_core.ui.formview.a.a(this.DLa);
      findViewById(a.f.bind_wallet_verify_hint).setVisibility(8);
      this.DLa.setOnInputValidListener(new EditHintPasswdView.a()
      {
        public final void onInputValidChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(71233);
          if (paramAnonymousBoolean)
          {
            String str = WalletSetPasswordUI.this.DLa.getMd5Value();
            Bundle localBundle = new Bundle();
            localBundle.putString("key_new_pwd1", str);
            WalletSetPasswordUI.this.DLa.fuo();
            com.tencent.mm.wallet_core.a.l(WalletSetPasswordUI.this, localBundle);
          }
          AppMethodBeat.o(71233);
        }
      });
      setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
      {
        public final void onVisibleStateChange(final boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(257824);
          WalletSetPasswordUI.a(WalletSetPasswordUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(268961);
              if (paramAnonymousBoolean)
              {
                WalletSetPasswordUI.a(WalletSetPasswordUI.this).fullScroll(130);
                AppMethodBeat.o(268961);
                return;
              }
              WalletSetPasswordUI.a(WalletSetPasswordUI.this).fullScroll(33);
              AppMethodBeat.o(268961);
            }
          });
          AppMethodBeat.o(257824);
        }
      });
      hideKeyboardPushDownBtn();
      setEditFocusListener(this.DLa, 0, false);
      showTenpayKB();
      AppMethodBeat.o(71235);
      return;
    }
  }
  
  public boolean needConfirmFinish()
  {
    AppMethodBeat.i(274237);
    if ((getProcess() instanceof com.tencent.mm.plugin.wallet_core.id_verify.a))
    {
      AppMethodBeat.o(274237);
      return false;
    }
    AppMethodBeat.o(274237);
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71234);
    super.onCreate(paramBundle);
    overridePendingTransition(a.a.slide_right_in, a.a.slide_left_out);
    setActionbarColor(getContext().getResources().getColor(a.c.white));
    hideActionbarLine();
    setMMTitle("");
    initView();
    j.a(this, getInput(), 5);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(264757);
        if (WalletSetPasswordUI.this.needConfirmFinish())
        {
          WalletSetPasswordUI.this.hideVKB();
          WalletSetPasswordUI.this.showDialog(1000);
        }
        for (;;)
        {
          AppMethodBeat.o(264757);
          return false;
          WalletSetPasswordUI.this.finish();
        }
      }
    });
    if (g.ijx()) {
      getWindow().addFlags(8192);
    }
    AppMethodBeat.o(71234);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71236);
    this.DLa.requestFocus();
    super.onResume();
    AppMethodBeat.o(71236);
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
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI
 * JD-Core Version:    0.7.0.1
 */