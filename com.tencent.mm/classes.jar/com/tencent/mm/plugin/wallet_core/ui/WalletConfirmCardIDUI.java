package com.tencent.mm.plugin.wallet_core.ui;

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
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.bankcard.TenpaySegmentEditText;

public class WalletConfirmCardIDUI
  extends WalletBaseUI
{
  private Button laG;
  private TenpaySegmentEditText qDp;
  private boolean qDq = true;
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    paramString = new Bundle();
    boolean bool = this.BX.getBoolean("key_is_reset_with_new_card", false);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof t))
      {
        paramm = (t)paramm;
        paramString.putBoolean("key_need_area", paramm.bUJ());
        paramString.putBoolean("key_need_profession", paramm.bUK());
        paramString.putParcelableArray("key_profession_list", paramm.qrb);
        if (paramm.qqX != null)
        {
          if ((paramm.qqX.qvd) && (paramm.qqX.isError()))
          {
            h.h(this, a.i.wallet_bank_broken, a.i.app_tip);
            return true;
          }
          paramString.putBoolean("key_is_reset_with_new_card", bool);
          paramString.putString("bank_name", paramm.qqX.lnT);
          paramString.putParcelable("elemt_query", paramm.qqX);
          paramString.putString("key_card_id", this.qDp.getEncryptDataWithHash(false));
          a.j(this, paramString);
          return true;
        }
        paramString.putBoolean("key_is_reset_with_new_card", bool);
        paramString.putString("bank_name", "");
        paramString.putParcelable("elemt_query", new ElementQuery());
        paramString.putString("key_card_id", this.qDp.getEncryptDataWithHash(false));
        a.j(this, paramString);
      }
    }
    while ((paramInt2 != 1) || (!(paramm instanceof t))) {
      return false;
    }
    paramString.putString("bank_name", "");
    paramString.putBoolean("key_is_reset_with_new_card", bool);
    paramString.putParcelable("elemt_query", new ElementQuery());
    paramString.putString("key_card_id", this.qDp.getEncryptDataWithHash(false));
    a.j(this, paramString);
    return true;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_confirm_card_id_ui;
  }
  
  protected final void initView()
  {
    Object localObject = this.BX.getString("key_bankcard_id");
    String str = this.BX.getString("key_bankcard_des");
    Bitmap localBitmap = (Bitmap)this.BX.getParcelable("key_bankcard_cropimg");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      y.e("MicroMsg.WalletConfirmCardIDUI", "cardID is empty");
      finish();
      return;
    }
    if (localBitmap == null)
    {
      y.e("MicroMsg.WalletConfirmCardIDUI", "cardID bitmap is null");
      finish();
      return;
    }
    setMMTitle(a.i.wallet_confirm_card_id_ui_title);
    this.laG = ((Button)findViewById(a.f.next_btn));
    this.qDp = ((TenpaySegmentEditText)findViewById(a.f.edit_card_id));
    this.qDp.setText((String)localObject, str);
    this.mKeyboard = ((MyKeyboardWindow)findViewById(a.f.tenpay_num_keyboard));
    this.lMr = findViewById(a.f.tenpay_keyboard_layout);
    ((ImageView)findViewById(a.f.card_id_src_bmp)).setImageBitmap(localBitmap);
    this.qDp.setKeyboard(this.mKeyboard);
    this.mKeyboard.setXMode(0);
    ((InputMethodManager)this.mController.uMN.getSystemService("input_method")).hideSoftInputFromWindow(this.qDp.getWindowToken(), 0);
    this.lMr.setVisibility(8);
    this.qDp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if ((!WalletConfirmCardIDUI.a(WalletConfirmCardIDUI.this).isShown()) && (!WalletConfirmCardIDUI.b(WalletConfirmCardIDUI.this)))
        {
          WalletConfirmCardIDUI.c(WalletConfirmCardIDUI.this).setVisibility(0);
          WalletConfirmCardIDUI.d(WalletConfirmCardIDUI.this).setVisibility(0);
        }
        WalletConfirmCardIDUI.e(WalletConfirmCardIDUI.this);
      }
    });
    localObject = this.qDp.get3DesEncrptData();
    this.laG.setOnClickListener(new WalletConfirmCardIDUI.3(this, (String)localObject));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(a.f.tenpay_num_keyboard));
    this.lMr = findViewById(a.f.tenpay_keyboard_layout);
    localObject = findViewById(a.f.tenpay_push_down);
    if ((this.mKeyboard == null) || (this.lMr == null)) {}
    for (;;)
    {
      this.qDp.setFocusable(false);
      this.qDp.setFocusableInTouchMode(true);
      return;
      ((View)localObject).setOnClickListener(new WalletConfirmCardIDUI.4(this));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        v.cMD();
        WalletConfirmCardIDUI.this.finish();
        return false;
      }
    });
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI
 * JD-Core Version:    0.7.0.1
 */