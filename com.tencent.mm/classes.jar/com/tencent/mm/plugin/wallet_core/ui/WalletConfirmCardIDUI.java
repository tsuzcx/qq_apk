package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.bankcard.TenpaySegmentEditText;

public class WalletConfirmCardIDUI
  extends WalletBaseUI
{
  private Button nyC;
  private TenpaySegmentEditText uqk;
  private boolean uql = true;
  
  public int getLayoutId()
  {
    return 2130971164;
  }
  
  public void initView()
  {
    AppMethodBeat.i(47373);
    Object localObject = getInput().getString("key_bankcard_id");
    String str = getInput().getString("key_bankcard_des");
    Bitmap localBitmap = (Bitmap)getInput().getParcelable("key_bankcard_cropimg");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      ab.e("MicroMsg.WalletConfirmCardIDUI", "cardID is empty");
      finish();
      AppMethodBeat.o(47373);
      return;
    }
    if (localBitmap == null)
    {
      ab.e("MicroMsg.WalletConfirmCardIDUI", "cardID bitmap is null");
      finish();
      AppMethodBeat.o(47373);
      return;
    }
    setMMTitle(2131305023);
    this.nyC = ((Button)findViewById(2131822914));
    this.uqk = ((TenpaySegmentEditText)findViewById(2131829092));
    this.uqk.setText((String)localObject, str);
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131822419));
    this.mKBLayout = findViewById(2131822418);
    ((ImageView)findViewById(2131829091)).setImageBitmap(localBitmap);
    this.uqk.setKeyboard(this.mKeyboard);
    this.mKeyboard.setXMode(0);
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.uqk.getWindowToken(), 0);
    this.mKBLayout.setVisibility(8);
    this.uqk.setOnClickListener(new WalletConfirmCardIDUI.2(this));
    localObject = this.uqk.get3DesEncrptData();
    this.nyC.setOnClickListener(new WalletConfirmCardIDUI.3(this, (String)localObject));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131822419));
    this.mKBLayout = findViewById(2131822418);
    localObject = findViewById(2131822420);
    if ((this.mKeyboard == null) || (this.mKBLayout == null)) {}
    for (;;)
    {
      this.uqk.setFocusable(false);
      this.uqk.setFocusableInTouchMode(true);
      AppMethodBeat.o(47373);
      return;
      ((View)localObject).setOnClickListener(new WalletConfirmCardIDUI.4(this));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47369);
    super.onCreate(paramBundle);
    initView();
    setBackBtn(new WalletConfirmCardIDUI.1(this));
    AppMethodBeat.o(47369);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(47370);
    super.onDestroy();
    AppMethodBeat.o(47370);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(47372);
    paramString = new Bundle();
    boolean bool2 = getInput().getBoolean("key_is_reset_with_new_card", false);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof w))
      {
        paramm = (w)paramm;
        paramString.putBoolean("key_need_area", paramm.cSY());
        paramString.putBoolean("key_need_profession", paramm.cSZ());
        paramString.putParcelableArray("key_profession_list", paramm.mProfessions);
        if (paramm.ubX == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          paramString.putBoolean("key_need_country", bool1);
          paramString.putStringArray("key_country_excludes", paramm.ubY);
          if (paramm.ubT == null) {
            break label233;
          }
          if ((!paramm.ubT.uhv) || (!paramm.ubT.isError())) {
            break;
          }
          h.h(this, 2131304850, 2131297087);
          AppMethodBeat.o(47372);
          return true;
        }
        paramString.putBoolean("key_is_reset_with_new_card", bool2);
        paramString.putString("bank_name", paramm.ubT.nLq);
        paramString.putParcelable("elemt_query", paramm.ubT);
        paramString.putString("key_card_id", this.uqk.getEncryptDataWithHash(false));
        a.j(this, paramString);
        AppMethodBeat.o(47372);
        return true;
        label233:
        paramString.putBoolean("key_is_reset_with_new_card", bool2);
        paramString.putString("bank_name", "");
        paramString.putParcelable("elemt_query", new ElementQuery());
        paramString.putString("key_card_id", this.uqk.getEncryptDataWithHash(false));
        a.j(this, paramString);
      }
    }
    while ((paramInt2 != 1) || (!(paramm instanceof w)))
    {
      boolean bool1;
      AppMethodBeat.o(47372);
      return false;
    }
    paramString.putString("bank_name", "");
    paramString.putBoolean("key_is_reset_with_new_card", bool2);
    paramString.putParcelable("elemt_query", new ElementQuery());
    paramString.putString("key_card_id", this.uqk.getEncryptDataWithHash(false));
    a.j(this, paramString);
    AppMethodBeat.o(47372);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI
 * JD-Core Version:    0.7.0.1
 */