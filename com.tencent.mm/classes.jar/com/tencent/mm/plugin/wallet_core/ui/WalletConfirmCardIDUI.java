package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.bankcard.TenpaySegmentEditText;

public class WalletConfirmCardIDUI
  extends WalletBaseUI
{
  private TenpaySegmentEditText BFB;
  private boolean BFC = true;
  private Button tpW;
  
  public void finish()
  {
    AppMethodBeat.i(162422);
    super.finish();
    z.fAp();
    getInput().remove("key_bankcard_cropimg");
    AppMethodBeat.o(162422);
  }
  
  public int getLayoutId()
  {
    return 2131495938;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70936);
    Object localObject = getInput().getString("key_bankcard_id");
    String str = getInput().getString("key_bankcard_des");
    Bitmap localBitmap = (Bitmap)getInput().getParcelable("key_bankcard_cropimg");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      ac.e("MicroMsg.WalletConfirmCardIDUI", "cardID is empty");
      finish();
      AppMethodBeat.o(70936);
      return;
    }
    if (localBitmap == null)
    {
      ac.e("MicroMsg.WalletConfirmCardIDUI", "cardID bitmap is null");
      finish();
      AppMethodBeat.o(70936);
      return;
    }
    setMMTitle(2131765215);
    this.tpW = ((Button)findViewById(2131302852));
    this.BFB = ((TenpaySegmentEditText)findViewById(2131299255));
    this.BFB.setText((String)localObject, str);
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
    this.mKBLayout = findViewById(2131305693);
    ((ImageView)findViewById(2131297827)).setImageBitmap(localBitmap);
    this.BFB.setKeyboard(this.mKeyboard);
    this.mKeyboard.setXMode(0);
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.BFB.getWindowToken(), 0);
    this.mKBLayout.setVisibility(8);
    this.BFB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70931);
        if ((!WalletConfirmCardIDUI.a(WalletConfirmCardIDUI.this).isShown()) && (!WalletConfirmCardIDUI.b(WalletConfirmCardIDUI.this)))
        {
          WalletConfirmCardIDUI.c(WalletConfirmCardIDUI.this).setVisibility(0);
          WalletConfirmCardIDUI.d(WalletConfirmCardIDUI.this).setVisibility(0);
        }
        WalletConfirmCardIDUI.e(WalletConfirmCardIDUI.this);
        AppMethodBeat.o(70931);
      }
    });
    localObject = this.BFB.get3DesEncrptData();
    this.tpW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70932);
        paramAnonymousView = WalletConfirmCardIDUI.f(WalletConfirmCardIDUI.this).get3DesEncrptData();
        if ((paramAnonymousView != null) && (paramAnonymousView.equals(this.BFE))) {
          com.tencent.mm.plugin.report.service.h.wUl.f(11353, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
        }
        for (;;)
        {
          WalletConfirmCardIDUI.g(WalletConfirmCardIDUI.this);
          AppMethodBeat.o(70932);
          return;
          com.tencent.mm.plugin.report.service.h.wUl.f(11353, new Object[] { Integer.valueOf(0), Integer.valueOf(2) });
        }
      }
    });
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
    this.mKBLayout = findViewById(2131305693);
    localObject = findViewById(2131305696);
    if ((this.mKeyboard == null) || (this.mKBLayout == null)) {}
    for (;;)
    {
      this.BFB.setFocusable(false);
      this.BFB.setFocusableInTouchMode(true);
      AppMethodBeat.o(70936);
      return;
      ((View)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70933);
          WalletConfirmCardIDUI.this.hideTenpayKB();
          AppMethodBeat.o(70933);
        }
      });
    }
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70934);
    super.onCreate(paramBundle);
    initView();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(70930);
        if (WalletConfirmCardIDUI.this.needConfirmFinish())
        {
          WalletConfirmCardIDUI.this.hideVKB();
          WalletConfirmCardIDUI.this.showDialog(1000);
        }
        for (;;)
        {
          AppMethodBeat.o(70930);
          return false;
          WalletConfirmCardIDUI.this.finish();
        }
      }
    });
    AppMethodBeat.o(70934);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(70935);
    super.onDestroy();
    AppMethodBeat.o(70935);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70937);
    paramString = new Bundle();
    boolean bool2 = getInput().getBoolean("key_is_reset_with_new_card", false);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramn instanceof y))
      {
        paramn = (y)paramn;
        paramString.putBoolean("key_need_area", paramn.eqI());
        paramString.putBoolean("key_need_profession", paramn.eqJ());
        paramString.putParcelableArray("key_profession_list", paramn.mProfessions);
        if (paramn.BoX == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          paramString.putBoolean("key_need_country", bool1);
          paramString.putStringArray("key_country_excludes", paramn.BoY);
          if (paramn.BoT == null) {
            break label238;
          }
          if ((!paramn.BoT.BvW) || (!paramn.BoT.isError())) {
            break;
          }
          com.tencent.mm.ui.base.h.l(this, 2131765036, 2131755906);
          AppMethodBeat.o(70937);
          return true;
        }
        paramString.putBoolean("key_is_reset_with_new_card", bool2);
        paramString.putString("bank_name", paramn.BoT.tGS);
        paramString.putParcelable("elemt_query", paramn.BoT);
        paramString.putString("key_card_id", this.BFB.getEncryptDataWithHash(false));
        a.k(this, paramString);
        AppMethodBeat.o(70937);
        return true;
        label238:
        paramString.putBoolean("key_is_reset_with_new_card", bool2);
        paramString.putString("bank_name", "");
        paramString.putParcelable("elemt_query", new ElementQuery());
        paramString.putString("key_card_id", this.BFB.getEncryptDataWithHash(false));
        a.k(this, paramString);
      }
    }
    while ((paramInt2 != 1) || (!(paramn instanceof y)))
    {
      boolean bool1;
      AppMethodBeat.o(70937);
      return false;
    }
    paramString.putString("bank_name", "");
    paramString.putBoolean("key_is_reset_with_new_card", bool2);
    paramString.putParcelable("elemt_query", new ElementQuery());
    paramString.putString("key_card_id", this.BFB.getEncryptDataWithHash(false));
    a.k(this, paramString);
    AppMethodBeat.o(70937);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI
 * JD-Core Version:    0.7.0.1
 */