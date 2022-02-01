package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
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
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.gt;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.c;
import com.tenpay.android.wechat.TenpaySecureEditText;

@com.tencent.mm.ui.base.a(3)
public class RemittanceF2fLargeMoneyUI
  extends WalletBaseUI
{
  private WalletFormView IjM;
  private int Iko = 4;
  private RelativeLayout IqN;
  private double IqP;
  private String mDesc;
  private TextView mMA;
  private int mMr;
  private WcPayKeyboard mMt;
  private RelativeLayout mMx;
  private TextView mMy;
  private RelativeLayout mMz;
  private String mTitle;
  private TextView pPT;
  private RelativeLayout qcr;
  
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
    this.qcr = ((RelativeLayout)findViewById(a.f.root_view));
    this.pPT = ((TextView)findViewById(a.f.f2f_large_money_title_tv));
    this.mMA = ((TextView)findViewById(a.f.f2f_large_money_desc_tv));
    this.IjM = ((WalletFormView)findViewById(a.f.remittance_busi_money_et));
    this.mMt = ((WcPayKeyboard)findViewById(a.f.wp_kb));
    this.mMz = ((RelativeLayout)findViewById(a.f.wallet_max_unit_container));
    this.IqN = ((RelativeLayout)findViewById(a.f.wallet_max_unit_line_container));
    this.pPT.setText(this.mTitle);
    this.mMA.setText(this.mDesc);
    ((WalletTextView)this.IjM.getTitleTv()).setTypeface(4);
    Object localObject = (TenpaySecureEditText)this.IjM.getContentEt();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((TenpaySecureEditText)localObject).getLayoutParams();
    localLayoutParams.leftMargin = 0;
    ((TenpaySecureEditText)localObject).setLayoutParams(localLayoutParams);
    localObject = this.IjM.getTitleTv();
    localLayoutParams = (LinearLayout.LayoutParams)((TextView)localObject).getLayoutParams();
    localLayoutParams.width = -2;
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    setWPKeyboard(this.IjM.getContentEt(), true, true);
    this.mMt.setActionText(getString(a.i.remittance_busi_confirm));
    ((RelativeLayout.LayoutParams)this.mMt.getLayoutParams()).addRule(12);
    this.IjM.ijD();
    this.IjM.azN(com.tencent.mm.ci.a.fromDPToPix(getContext(), 2));
    this.IjM.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(163847);
        if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66))
        {
          Log.i("MicroMsg.RemittanceF2fLargeMoneyUI", "click enter, mTotalAmt:%s", new Object[] { Double.valueOf(RemittanceF2fLargeMoneyUI.a(RemittanceF2fLargeMoneyUI.this)) });
          if (RemittanceF2fLargeMoneyUI.a(RemittanceF2fLargeMoneyUI.this) <= 0.0D)
          {
            w.makeText(RemittanceF2fLargeMoneyUI.this.getContext(), a.i.wallet_balance_save_input_invalid, 0).show();
            AppMethodBeat.o(163847);
            return true;
          }
          paramAnonymousInt = (int)Math.round(RemittanceF2fLargeMoneyUI.a(RemittanceF2fLargeMoneyUI.this) * 100.0D);
          paramAnonymousTextView = new gt();
          paramAnonymousTextView.fDg.fDh = RemittanceF2fLargeMoneyUI.this.getIntent().getStringExtra("key_amount_remind_sign");
          paramAnonymousTextView.fDg.fDi = paramAnonymousInt;
          paramAnonymousTextView.fDg.fDf = RemittanceF2fLargeMoneyUI.this;
          EventCenter.instance.publish(paramAnonymousTextView);
          AppMethodBeat.o(163847);
          return true;
        }
        AppMethodBeat.o(163847);
        return true;
      }
    });
    this.IjM.a(new TextWatcher()
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
    this.IqN.setVisibility(0);
    if ((LocaleUtil.getApplicationLanguage().equals("zh_CN")) || (LocaleUtil.getApplicationLanguage().equals("zh_TW")) || (LocaleUtil.getApplicationLanguage().equals("zh_HK")))
    {
      this.mMx = ((RelativeLayout)findViewById(a.f.wallet_max_unit_layout));
      this.mMy = ((TextView)findViewById(a.f.wallet_max_unit_tv));
      this.mMx.post(new Runnable()
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
      this.IjM.setmWalletFormViewListener(new WalletFormView.c()
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
            j = RemittanceF2fLargeMoneyUI.b(RemittanceF2fLargeMoneyUI.this).k(paramAnonymousCharSequence, RemittanceF2fLargeMoneyUI.e(RemittanceF2fLargeMoneyUI.this), j);
            j = RemittanceF2fLargeMoneyUI.b(RemittanceF2fLargeMoneyUI.this).getLeft() + j;
            if (j != 0)
            {
              RemittanceF2fLargeMoneyUI.d(RemittanceF2fLargeMoneyUI.this).setVisibility(0);
              paramAnonymousCharSequence = ag.bk(MMApplicationContext.getContext(), i);
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
      this.qcr.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(163851);
          if ((RemittanceF2fLargeMoneyUI.h(RemittanceF2fLargeMoneyUI.this) != null) && (RemittanceF2fLargeMoneyUI.i(RemittanceF2fLargeMoneyUI.this).isShown()) && (RemittanceF2fLargeMoneyUI.j(RemittanceF2fLargeMoneyUI.this).iir()))
          {
            RemittanceF2fLargeMoneyUI.k(RemittanceF2fLargeMoneyUI.this).iip();
            AppMethodBeat.o(163851);
            return true;
          }
          AppMethodBeat.o(163851);
          return false;
        }
      });
      AppMethodBeat.o(163853);
      return;
      this.mMz.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(163852);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.RemittanceF2fLargeMoneyUI", "RemittanceF2fLargeMoneyUI show");
    this.Iko = getIntent().getIntExtra("key_amount_remind_bit", 4);
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
    e.fAJ().fB(this);
    AppMethodBeat.o(163854);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceF2fLargeMoneyUI
 * JD-Core Version:    0.7.0.1
 */