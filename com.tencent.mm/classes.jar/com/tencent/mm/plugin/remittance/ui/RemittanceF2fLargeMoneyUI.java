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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.gf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.t;
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
  private TextView lfN;
  private TextView lgw;
  private String mDesc;
  private String mTitle;
  private int wIV = 4;
  private WalletFormView wIt;
  private int wJc;
  private WcPayKeyboard wJe;
  private RelativeLayout wJm;
  private TextView wJn;
  private RelativeLayout wJo;
  private RelativeLayout wOT;
  private double wOV;
  private RelativeLayout wRY;
  
  public void finish()
  {
    AppMethodBeat.i(163855);
    super.finish();
    ac.i("MicroMsg.RemittanceF2fLargeMoneyUI", "finish()");
    AppMethodBeat.o(163855);
  }
  
  public int getLayoutId()
  {
    return 2131495256;
  }
  
  public void initView()
  {
    AppMethodBeat.i(163853);
    super.initView();
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    setBackGroundColorResource(2131101179);
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
    this.wRY = ((RelativeLayout)findViewById(2131304251));
    this.lfN = ((TextView)findViewById(2131299644));
    this.lgw = ((TextView)findViewById(2131299643));
    this.wIt = ((WalletFormView)findViewById(2131304007));
    this.wJe = ((WcPayKeyboard)findViewById(2131307020));
    this.wJo = ((RelativeLayout)findViewById(2131306751));
    this.wOT = ((RelativeLayout)findViewById(2131306754));
    this.lfN.setText(this.mTitle);
    this.lgw.setText(this.mDesc);
    ((WalletTextView)this.wIt.getTitleTv()).setTypeface(4);
    Object localObject = (TenpaySecureEditText)this.wIt.getContentEt();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((TenpaySecureEditText)localObject).getLayoutParams();
    localLayoutParams.leftMargin = 0;
    ((TenpaySecureEditText)localObject).setLayoutParams(localLayoutParams);
    localObject = this.wIt.getTitleTv();
    localLayoutParams = (LinearLayout.LayoutParams)((TextView)localObject).getLayoutParams();
    localLayoutParams.width = -2;
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    setWPKeyboard(this.wIt.getContentEt(), true, true);
    this.wJe.setActionText(getString(2131762422));
    ((RelativeLayout.LayoutParams)this.wJe.getLayoutParams()).addRule(12);
    this.wIt.fAX();
    this.wIt.setContentPadding$3b4dfe4b(com.tencent.mm.cc.a.fromDPToPix(getContext(), 2));
    this.wIt.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(163847);
        if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66))
        {
          ac.i("MicroMsg.RemittanceF2fLargeMoneyUI", "click enter, mTotalAmt:%s", new Object[] { Double.valueOf(RemittanceF2fLargeMoneyUI.a(RemittanceF2fLargeMoneyUI.this)) });
          if (RemittanceF2fLargeMoneyUI.a(RemittanceF2fLargeMoneyUI.this) <= 0.0D)
          {
            t.makeText(RemittanceF2fLargeMoneyUI.this.getContext(), 2131765031, 0).show();
            AppMethodBeat.o(163847);
            return true;
          }
          paramAnonymousInt = (int)Math.round(RemittanceF2fLargeMoneyUI.a(RemittanceF2fLargeMoneyUI.this) * 100.0D);
          paramAnonymousTextView = new gf();
          paramAnonymousTextView.dgF.dgG = RemittanceF2fLargeMoneyUI.this.getIntent().getStringExtra("key_amount_remind_sign");
          paramAnonymousTextView.dgF.dgH = paramAnonymousInt;
          paramAnonymousTextView.dgF.dgE = RemittanceF2fLargeMoneyUI.this;
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousTextView);
          AppMethodBeat.o(163847);
          return true;
        }
        AppMethodBeat.o(163847);
        return true;
      }
    });
    this.wIt.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(163848);
        RemittanceF2fLargeMoneyUI.a(RemittanceF2fLargeMoneyUI.this, bs.getDouble(RemittanceF2fLargeMoneyUI.b(RemittanceF2fLargeMoneyUI.this).getText(), 0.0D));
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
    this.wOT.setVisibility(0);
    if ((ab.eUO().equals("zh_CN")) || (ab.eUO().equals("zh_TW")) || (ab.eUO().equals("zh_HK")))
    {
      this.wJm = ((RelativeLayout)findViewById(2131306753));
      this.wJn = ((TextView)findViewById(2131306756));
      this.wJm.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(163849);
          RemittanceF2fLargeMoneyUI.a(RemittanceF2fLargeMoneyUI.this, RemittanceF2fLargeMoneyUI.c(RemittanceF2fLargeMoneyUI.this).getWidth());
          RemittanceF2fLargeMoneyUI.d(RemittanceF2fLargeMoneyUI.this).setVisibility(8);
          ac.d("MicroMsg.RemittanceF2fLargeMoneyUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(RemittanceF2fLargeMoneyUI.e(RemittanceF2fLargeMoneyUI.this)) });
          AppMethodBeat.o(163849);
        }
      });
      this.wIt.setmWalletFormViewListener(new WalletFormView.c()
      {
        public final void p(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(163850);
          if (bs.jl(RemittanceF2fLargeMoneyUI.f(RemittanceF2fLargeMoneyUI.this), 0))
          {
            ac.i("MicroMsg.RemittanceF2fLargeMoneyUI", "mAmountRemindBit == 0");
            RemittanceF2fLargeMoneyUI.d(RemittanceF2fLargeMoneyUI.this).setVisibility(8);
            AppMethodBeat.o(163850);
            return;
          }
          long l = Double.valueOf(bs.getDouble(paramAnonymousCharSequence.toString(), 0.0D)).longValue();
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
            j = RemittanceF2fLargeMoneyUI.b(RemittanceF2fLargeMoneyUI.this).n(paramAnonymousCharSequence, RemittanceF2fLargeMoneyUI.e(RemittanceF2fLargeMoneyUI.this), j);
            j = RemittanceF2fLargeMoneyUI.b(RemittanceF2fLargeMoneyUI.this).getLeft() + j;
            if (j != 0)
            {
              RemittanceF2fLargeMoneyUI.d(RemittanceF2fLargeMoneyUI.this).setVisibility(0);
              paramAnonymousCharSequence = ag.aN(ai.getContext(), i);
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
      this.wRY.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(163851);
          if ((RemittanceF2fLargeMoneyUI.h(RemittanceF2fLargeMoneyUI.this) != null) && (RemittanceF2fLargeMoneyUI.i(RemittanceF2fLargeMoneyUI.this).isShown()) && (RemittanceF2fLargeMoneyUI.j(RemittanceF2fLargeMoneyUI.this).fzM()))
          {
            RemittanceF2fLargeMoneyUI.k(RemittanceF2fLargeMoneyUI.this).fzK();
            AppMethodBeat.o(163851);
            return true;
          }
          AppMethodBeat.o(163851);
          return false;
        }
      });
      AppMethodBeat.o(163853);
      return;
      this.wJo.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(163852);
    super.onCreate(paramBundle);
    ac.i("MicroMsg.RemittanceF2fLargeMoneyUI", "RemittanceF2fLargeMoneyUI show");
    this.wIV = getIntent().getIntExtra("key_amount_remind_bit", 4);
    this.mTitle = getIntent().getStringExtra("key_title");
    this.mDesc = getIntent().getStringExtra("key_desc");
    initView();
    AppMethodBeat.o(163852);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(163854);
    super.onResume();
    ac.i("MicroMsg.RemittanceF2fLargeMoneyUI", "onResume()");
    e.dyk().fX(this);
    AppMethodBeat.o(163854);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceF2fLargeMoneyUI
 * JD-Core Version:    0.7.0.1
 */