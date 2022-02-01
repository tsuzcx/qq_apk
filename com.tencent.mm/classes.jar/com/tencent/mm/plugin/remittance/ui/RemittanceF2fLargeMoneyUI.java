package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.he;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.model.ah;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.c;
import com.tenpay.android.wechat.TenpaySecureEditText;

@com.tencent.mm.ui.base.a(3)
public class RemittanceF2fLargeMoneyUI
  extends WalletBaseUI
{
  private WalletFormView Ogy;
  private int Ohb = 4;
  private RelativeLayout Oos;
  private double Oou;
  private String mDesc;
  private String mTitle;
  private int pIZ;
  private WcPayKeyboard pJb;
  private RelativeLayout pJf;
  private TextView pJg;
  private RelativeLayout pJh;
  private TextView pJi;
  private TextView sUt;
  private RelativeLayout thl;
  
  public void finish()
  {
    AppMethodBeat.i(163855);
    super.finish();
    Log.i("MicroMsg.RemittanceF2fLargeMoneyUI", "finish()");
    AppMethodBeat.o(163855);
  }
  
  public int getLayoutId()
  {
    return a.g.remittance_f2f_large_money_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(163853);
    super.initView();
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.c.white));
    setBackGroundColorResource(a.c.white);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(163846);
        RemittanceF2fLargeMoneyUI.this.finish();
        AppMethodBeat.o(163846);
        return true;
      }
    });
    this.thl = ((RelativeLayout)findViewById(a.f.root_view));
    this.sUt = ((TextView)findViewById(a.f.f2f_large_money_title_tv));
    this.pJi = ((TextView)findViewById(a.f.f2f_large_money_desc_tv));
    this.Ogy = ((WalletFormView)findViewById(a.f.remittance_busi_money_et));
    this.pJb = ((WcPayKeyboard)findViewById(a.f.wp_kb));
    this.pJh = ((RelativeLayout)findViewById(a.f.wallet_max_unit_container));
    this.Oos = ((RelativeLayout)findViewById(a.f.wallet_max_unit_line_container));
    this.sUt.setText(this.mTitle);
    this.pJi.setText(this.mDesc);
    ((WalletTextView)this.Ogy.getTitleTv()).setTypeface(4);
    Object localObject = (TenpaySecureEditText)this.Ogy.getContentEt();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((TenpaySecureEditText)localObject).getLayoutParams();
    localLayoutParams.leftMargin = 0;
    ((TenpaySecureEditText)localObject).setLayoutParams(localLayoutParams);
    localObject = this.Ogy.getTitleTv();
    localLayoutParams = (LinearLayout.LayoutParams)((TextView)localObject).getLayoutParams();
    localLayoutParams.width = -2;
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    setWPKeyboard(this.Ogy.getContentEt(), true, true);
    this.pJb.setActionText(getString(a.i.remittance_busi_confirm));
    ((RelativeLayout.LayoutParams)this.pJb.getLayoutParams()).addRule(12);
    this.Ogy.jPD();
    this.Ogy.aGD(com.tencent.mm.cd.a.fromDPToPix(getContext(), 2));
    this.Ogy.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(163847);
        if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66))
        {
          Log.i("MicroMsg.RemittanceF2fLargeMoneyUI", "click enter, mTotalAmt:%s", new Object[] { Double.valueOf(RemittanceF2fLargeMoneyUI.a(RemittanceF2fLargeMoneyUI.this)) });
          if (RemittanceF2fLargeMoneyUI.a(RemittanceF2fLargeMoneyUI.this) <= 0.0D)
          {
            aa.makeText(RemittanceF2fLargeMoneyUI.this.getContext(), a.i.wallet_balance_save_input_invalid, 0).show();
            AppMethodBeat.o(163847);
            return true;
          }
          paramAnonymousInt = (int)Math.round(RemittanceF2fLargeMoneyUI.a(RemittanceF2fLargeMoneyUI.this) * 100.0D);
          paramAnonymousTextView = new he();
          paramAnonymousTextView.hHV.hHW = RemittanceF2fLargeMoneyUI.this.getIntent().getStringExtra("key_amount_remind_sign");
          paramAnonymousTextView.hHV.hHY = RemittanceF2fLargeMoneyUI.this.getIntent().getStringExtra("key_qr_code");
          paramAnonymousTextView.hHV.hHX = paramAnonymousInt;
          paramAnonymousTextView.hHV.hHU = RemittanceF2fLargeMoneyUI.this;
          paramAnonymousTextView.publish();
          AppMethodBeat.o(163847);
          return true;
        }
        AppMethodBeat.o(163847);
        return true;
      }
    });
    this.Ogy.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(163848);
        RemittanceF2fLargeMoneyUI.a(RemittanceF2fLargeMoneyUI.this, Util.getDouble(RemittanceF2fLargeMoneyUI.b(RemittanceF2fLargeMoneyUI.this).getText(), 0.0D));
        if (RemittanceF2fLargeMoneyUI.a(RemittanceF2fLargeMoneyUI.this) <= 0.0D)
        {
          RemittanceF2fLargeMoneyUI.a(RemittanceF2fLargeMoneyUI.this, false);
          AppMethodBeat.o(163848);
          return;
        }
        RemittanceF2fLargeMoneyUI.a(RemittanceF2fLargeMoneyUI.this, true);
        AppMethodBeat.o(163848);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.Oos.setVisibility(0);
    if ((LocaleUtil.getApplicationLanguage().equals("zh_CN")) || (LocaleUtil.getApplicationLanguage().equals("zh_TW")) || (LocaleUtil.getApplicationLanguage().equals("zh_HK")))
    {
      this.pJf = ((RelativeLayout)findViewById(a.f.wallet_max_unit_layout));
      this.pJg = ((TextView)findViewById(a.f.wallet_max_unit_tv));
      this.pJf.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(163849);
          RemittanceF2fLargeMoneyUI.a(RemittanceF2fLargeMoneyUI.this, RemittanceF2fLargeMoneyUI.c(RemittanceF2fLargeMoneyUI.this).getWidth());
          RemittanceF2fLargeMoneyUI.d(RemittanceF2fLargeMoneyUI.this).setVisibility(8);
          Log.d("MicroMsg.RemittanceF2fLargeMoneyUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(RemittanceF2fLargeMoneyUI.e(RemittanceF2fLargeMoneyUI.this)) });
          AppMethodBeat.o(163849);
        }
      });
      this.Ogy.setmWalletFormViewListener(new WalletFormView.c()
      {
        public final void f(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(163850);
          if (Util.isEqual(RemittanceF2fLargeMoneyUI.f(RemittanceF2fLargeMoneyUI.this), 0))
          {
            Log.i("MicroMsg.RemittanceF2fLargeMoneyUI", "mAmountRemindBit == 0");
            RemittanceF2fLargeMoneyUI.d(RemittanceF2fLargeMoneyUI.this).setVisibility(8);
            AppMethodBeat.o(163850);
            return;
          }
          long l = Double.valueOf(Util.getDouble(paramAnonymousCharSequence.toString(), 0.0D)).longValue();
          int j = 0;
          int i = 0;
          while (l != 0L)
          {
            j = (int)(l % 10L);
            l /= 10L;
            i += 1;
          }
          if (i >= RemittanceF2fLargeMoneyUI.f(RemittanceF2fLargeMoneyUI.this))
          {
            j = RemittanceF2fLargeMoneyUI.b(RemittanceF2fLargeMoneyUI.this).i(paramAnonymousCharSequence, RemittanceF2fLargeMoneyUI.e(RemittanceF2fLargeMoneyUI.this), j);
            j = RemittanceF2fLargeMoneyUI.b(RemittanceF2fLargeMoneyUI.this).getLeft() + j;
            if (j != 0)
            {
              RemittanceF2fLargeMoneyUI.d(RemittanceF2fLargeMoneyUI.this).setVisibility(0);
              paramAnonymousCharSequence = ah.bD(MMApplicationContext.getContext(), i);
              RemittanceF2fLargeMoneyUI.g(RemittanceF2fLargeMoneyUI.this).setText(paramAnonymousCharSequence);
              paramAnonymousCharSequence = (RelativeLayout.LayoutParams)RemittanceF2fLargeMoneyUI.c(RemittanceF2fLargeMoneyUI.this).getLayoutParams();
              paramAnonymousCharSequence.leftMargin = j;
              RemittanceF2fLargeMoneyUI.c(RemittanceF2fLargeMoneyUI.this).setLayoutParams(paramAnonymousCharSequence);
              AppMethodBeat.o(163850);
              return;
            }
            RemittanceF2fLargeMoneyUI.d(RemittanceF2fLargeMoneyUI.this).setVisibility(8);
            AppMethodBeat.o(163850);
            return;
          }
          RemittanceF2fLargeMoneyUI.d(RemittanceF2fLargeMoneyUI.this).setVisibility(8);
          AppMethodBeat.o(163850);
        }
      });
    }
    for (;;)
    {
      this.thl.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(163851);
          RemittanceF2fLargeMoneyUI.this.handleKeyboardTouchEvent(paramAnonymousMotionEvent);
          AppMethodBeat.o(163851);
          return false;
        }
      });
      AppMethodBeat.o(163853);
      return;
      this.pJh.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(163852);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.RemittanceF2fLargeMoneyUI", "RemittanceF2fLargeMoneyUI show");
    this.Ohb = getIntent().getIntExtra("key_amount_remind_bit", 4);
    this.mTitle = getIntent().getStringExtra("key_title");
    this.mDesc = getIntent().getStringExtra("key_desc");
    initView();
    AppMethodBeat.o(163852);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(163854);
    super.onResume();
    Log.i("MicroMsg.RemittanceF2fLargeMoneyUI", "onResume()");
    f.gMD().jt(this);
    AppMethodBeat.o(163854);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceF2fLargeMoneyUI
 * JD-Core Version:    0.7.0.1
 */