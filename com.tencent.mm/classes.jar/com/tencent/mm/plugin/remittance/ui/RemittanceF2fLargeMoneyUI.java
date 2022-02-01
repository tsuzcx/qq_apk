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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.ge;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
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
  private TextView kEu;
  private TextView kFd;
  private String mDesc;
  private String mTitle;
  private RelativeLayout vEO;
  private double vEQ;
  private RelativeLayout vHU;
  private int vyQ = 4;
  private int vyX;
  private WcPayKeyboard vyZ;
  private WalletFormView vyo;
  private RelativeLayout vzh;
  private TextView vzi;
  private RelativeLayout vzj;
  
  public void finish()
  {
    AppMethodBeat.i(163855);
    super.finish();
    ad.i("MicroMsg.RemittanceF2fLargeMoneyUI", "finish()");
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
    this.vHU = ((RelativeLayout)findViewById(2131304251));
    this.kEu = ((TextView)findViewById(2131299644));
    this.kFd = ((TextView)findViewById(2131299643));
    this.vyo = ((WalletFormView)findViewById(2131304007));
    this.vyZ = ((WcPayKeyboard)findViewById(2131307020));
    this.vzj = ((RelativeLayout)findViewById(2131306751));
    this.vEO = ((RelativeLayout)findViewById(2131306754));
    this.kEu.setText(this.mTitle);
    this.kFd.setText(this.mDesc);
    ((WalletTextView)this.vyo.getTitleTv()).setTypeface(4);
    Object localObject = (TenpaySecureEditText)this.vyo.getContentEt();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((TenpaySecureEditText)localObject).getLayoutParams();
    localLayoutParams.leftMargin = 0;
    ((TenpaySecureEditText)localObject).setLayoutParams(localLayoutParams);
    localObject = this.vyo.getTitleTv();
    localLayoutParams = (LinearLayout.LayoutParams)((TextView)localObject).getLayoutParams();
    localLayoutParams.width = -2;
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    setWPKeyboard(this.vyo.getContentEt(), true, true);
    this.vyZ.setActionText(getString(2131762422));
    ((RelativeLayout.LayoutParams)this.vyZ.getLayoutParams()).addRule(12);
    this.vyo.fkH();
    this.vyo.setContentPadding$3b4dfe4b(com.tencent.mm.cd.a.fromDPToPix(getContext(), 2));
    this.vyo.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(163847);
        if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66))
        {
          ad.i("MicroMsg.RemittanceF2fLargeMoneyUI", "click enter, mTotalAmt:%s", new Object[] { Double.valueOf(RemittanceF2fLargeMoneyUI.a(RemittanceF2fLargeMoneyUI.this)) });
          if (RemittanceF2fLargeMoneyUI.a(RemittanceF2fLargeMoneyUI.this) <= 0.0D)
          {
            t.makeText(RemittanceF2fLargeMoneyUI.this.getContext(), 2131765031, 0).show();
            AppMethodBeat.o(163847);
            return true;
          }
          paramAnonymousInt = (int)Math.round(RemittanceF2fLargeMoneyUI.a(RemittanceF2fLargeMoneyUI.this) * 100.0D);
          paramAnonymousTextView = new ge();
          paramAnonymousTextView.djk.djl = RemittanceF2fLargeMoneyUI.this.getIntent().getStringExtra("key_amount_remind_sign");
          paramAnonymousTextView.djk.djm = paramAnonymousInt;
          paramAnonymousTextView.djk.djj = RemittanceF2fLargeMoneyUI.this;
          com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousTextView);
          AppMethodBeat.o(163847);
          return true;
        }
        AppMethodBeat.o(163847);
        return true;
      }
    });
    this.vyo.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(163848);
        RemittanceF2fLargeMoneyUI.a(RemittanceF2fLargeMoneyUI.this, bt.getDouble(RemittanceF2fLargeMoneyUI.b(RemittanceF2fLargeMoneyUI.this).getText(), 0.0D));
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
    this.vEO.setVisibility(0);
    if ((ac.eFu().equals("zh_CN")) || (ac.eFu().equals("zh_TW")) || (ac.eFu().equals("zh_HK")))
    {
      this.vzh = ((RelativeLayout)findViewById(2131306753));
      this.vzi = ((TextView)findViewById(2131306756));
      this.vzh.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(163849);
          RemittanceF2fLargeMoneyUI.a(RemittanceF2fLargeMoneyUI.this, RemittanceF2fLargeMoneyUI.c(RemittanceF2fLargeMoneyUI.this).getWidth());
          RemittanceF2fLargeMoneyUI.d(RemittanceF2fLargeMoneyUI.this).setVisibility(8);
          ad.d("MicroMsg.RemittanceF2fLargeMoneyUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(RemittanceF2fLargeMoneyUI.e(RemittanceF2fLargeMoneyUI.this)) });
          AppMethodBeat.o(163849);
        }
      });
      this.vyo.setmWalletFormViewListener(new WalletFormView.c()
      {
        public final void p(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(163850);
          if (bt.iY(RemittanceF2fLargeMoneyUI.f(RemittanceF2fLargeMoneyUI.this), 0))
          {
            ad.i("MicroMsg.RemittanceF2fLargeMoneyUI", "mAmountRemindBit == 0");
            RemittanceF2fLargeMoneyUI.d(RemittanceF2fLargeMoneyUI.this).setVisibility(8);
            AppMethodBeat.o(163850);
            return;
          }
          long l = Double.valueOf(bt.getDouble(paramAnonymousCharSequence.toString(), 0.0D)).longValue();
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
            j = RemittanceF2fLargeMoneyUI.b(RemittanceF2fLargeMoneyUI.this).m(paramAnonymousCharSequence, RemittanceF2fLargeMoneyUI.e(RemittanceF2fLargeMoneyUI.this), j);
            j = RemittanceF2fLargeMoneyUI.b(RemittanceF2fLargeMoneyUI.this).getLeft() + j;
            if (j != 0)
            {
              RemittanceF2fLargeMoneyUI.d(RemittanceF2fLargeMoneyUI.this).setVisibility(0);
              paramAnonymousCharSequence = ag.aH(aj.getContext(), i);
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
      this.vHU.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(163851);
          if ((RemittanceF2fLargeMoneyUI.h(RemittanceF2fLargeMoneyUI.this) != null) && (RemittanceF2fLargeMoneyUI.i(RemittanceF2fLargeMoneyUI.this).isShown()) && (RemittanceF2fLargeMoneyUI.j(RemittanceF2fLargeMoneyUI.this).fjx()))
          {
            RemittanceF2fLargeMoneyUI.k(RemittanceF2fLargeMoneyUI.this).fjv();
            AppMethodBeat.o(163851);
            return true;
          }
          AppMethodBeat.o(163851);
          return false;
        }
      });
      AppMethodBeat.o(163853);
      return;
      this.vzj.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(163852);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.RemittanceF2fLargeMoneyUI", "RemittanceF2fLargeMoneyUI show");
    this.vyQ = getIntent().getIntExtra("key_amount_remind_bit", 4);
    this.mTitle = getIntent().getStringExtra("key_title");
    this.mDesc = getIntent().getStringExtra("key_desc");
    initView();
    AppMethodBeat.o(163852);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(163854);
    super.onResume();
    ad.i("MicroMsg.RemittanceF2fLargeMoneyUI", "onResume()");
    e.dki().fM(this);
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