package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.plugin.wallet_core.utils.m;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;
import com.tencent.mm.wallet_core.ui.i;
import java.util.HashSet;

@com.tencent.mm.ui.base.a(1)
public class WalletSetPasswordUI
  extends WalletBaseUI
{
  protected EditHintPasswdView JCc;
  private ScrollView pLK;
  private TextView sUt;
  private TextView wzp;
  
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
    this.pLK = ((ScrollView)findViewById(a.f.root_view));
    this.sUt = ((TextView)findViewById(a.f.wallet_pwd_title));
    this.wzp = ((TextView)findViewById(a.f.wallet_pwd_content));
    i.Q(this.sUt);
    if ((getInput().getBoolean("key_is_forgot_process", false)) && (!Util.isNullOrNil(getInput().getString("key_identity"))) && (getInput().getInt("key_id_type", -1) != -1) && (!Util.isNullOrNil(getInput().getString("key_true_name")))) {
      this.wzp.setVisibility(4);
    }
    Object localObject;
    if (((getProcess() == null) || (!"ModifyPwdProcess".equals(getProcess().fud()))) && (getProcess() != null) && ("ResetPwdProcessByToken".equals(getProcess().fud())))
    {
      str = getInput().getString("key_pwd_title");
      localObject = getInput().getString("key_pwd_desc");
      if (!Util.isNullOrNil(str)) {
        this.sUt.setText(str);
      }
      if (!Util.isNullOrNil((String)localObject))
      {
        this.wzp.setText((CharSequence)localObject);
        this.wzp.setVisibility(0);
      }
    }
    if (getInput().getInt("key_err_code", 0) == -1002)
    {
      this.wzp.setTextColor(getResources().getColor(a.c.Red));
      localObject = this.wzp;
      if (!z.bBi()) {
        break label372;
      }
    }
    label372:
    for (String str = getString(a.i.wallet_set_password_no_same_payu);; str = getString(a.i.wallet_set_password_no_same))
    {
      ((TextView)localObject).setText(str);
      getInput().putInt("key_err_code", 0);
      this.JCc = ((EditHintPasswdView)findViewById(a.f.input_et));
      com.tencent.mm.wallet_core.ui.formview.a.a(this.JCc);
      findViewById(a.f.bind_wallet_verify_hint).setVisibility(8);
      this.JCc.setOnInputValidListener(new EditHintPasswdView.a()
      {
        public final void onInputValidChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(71233);
          if (paramAnonymousBoolean)
          {
            String str = WalletSetPasswordUI.this.JCc.getMd5Value();
            Bundle localBundle = new Bundle();
            localBundle.putString("key_new_pwd1", str);
            WalletSetPasswordUI.this.JCc.gGd();
            com.tencent.mm.wallet_core.a.k(WalletSetPasswordUI.this, localBundle);
          }
          AppMethodBeat.o(71233);
        }
      });
      setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
      {
        public final void onVisibleStateChange(final boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(301281);
          WalletSetPasswordUI.a(WalletSetPasswordUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(301279);
              if (paramAnonymousBoolean)
              {
                WalletSetPasswordUI.a(WalletSetPasswordUI.this).fullScroll(130);
                AppMethodBeat.o(301279);
                return;
              }
              WalletSetPasswordUI.a(WalletSetPasswordUI.this).fullScroll(33);
              AppMethodBeat.o(301279);
            }
          });
          AppMethodBeat.o(301281);
        }
      });
      hideKeyboardPushDownBtn();
      setEditFocusListener(this.JCc, 0, false);
      showTenpayKB();
      AppMethodBeat.o(71235);
      return;
    }
  }
  
  public boolean needConfirmFinish()
  {
    AppMethodBeat.i(301225);
    if ((getProcess() instanceof com.tencent.mm.plugin.wallet_core.id_verify.a))
    {
      AppMethodBeat.o(301225);
      return false;
    }
    AppMethodBeat.o(301225);
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
    m.a(this, getInput(), 5);
    setBackBtn(new WalletSetPasswordUI.1(this));
    if (i.jPv()) {
      getWindow().addFlags(8192);
    }
    AppMethodBeat.o(71234);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71236);
    this.JCc.requestFocus();
    super.onResume();
    AppMethodBeat.o(71236);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(301217);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(g.class);
    AppMethodBeat.o(301217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI
 * JD-Core Version:    0.7.0.1
 */