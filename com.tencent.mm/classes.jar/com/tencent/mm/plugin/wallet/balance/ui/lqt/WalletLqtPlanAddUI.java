package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.wallet.balance.a.a.h;
import com.tencent.mm.plugin.wallet.balance.a.a.u;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.bmo;
import com.tencent.mm.protocal.protobuf.bnx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WalletLqtPlanAddUI
  extends WalletLqtBasePresenterUI
{
  private static final int tPZ;
  private static final int tQa;
  private int mMode;
  private ScrollView tQb;
  private WalletFormView tQc;
  private TextView tQd;
  private CdnImageView tQe;
  private TextView tQf;
  private LinearLayout tQg;
  private TextView tQh;
  private LinearLayout tQi;
  private Button tQj;
  private CheckBox tQk;
  private TextView tQl;
  private LinearLayout tQm;
  private u tQn;
  private List<Bankcard> tQo;
  private awi tQp;
  private bnx tQq;
  private boolean tQr;
  private bmo tQs;
  private ImageView tQt;
  private LinearLayout tQu;
  private long tQv;
  private int tQw;
  private String tQx;
  private String tQy;
  private String[] tQz;
  
  static
  {
    AppMethodBeat.i(45603);
    tPZ = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 48);
    tQa = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 8);
    AppMethodBeat.o(45603);
  }
  
  public WalletLqtPlanAddUI()
  {
    AppMethodBeat.i(45580);
    this.tQn = ((u)P(u.class));
    this.tQo = new ArrayList();
    this.tQs = new bmo();
    AppMethodBeat.o(45580);
  }
  
  private Bankcard aeU(String paramString)
  {
    AppMethodBeat.i(45591);
    Iterator localIterator = this.tQo.iterator();
    while (localIterator.hasNext())
    {
      Bankcard localBankcard = (Bankcard)localIterator.next();
      if (localBankcard.field_bindSerial.equals(paramString))
      {
        AppMethodBeat.o(45591);
        return localBankcard;
      }
    }
    paramString = t.cTN().i(paramString, false, false);
    AppMethodBeat.o(45591);
    return paramString;
  }
  
  private void bJ()
  {
    AppMethodBeat.i(45586);
    cRn();
    cRo();
    cRp();
    cRq();
    AppMethodBeat.o(45586);
  }
  
  private void cRn()
  {
    AppMethodBeat.i(45587);
    if (this.mMode == 2)
    {
      BigDecimal localBigDecimal = e.a(this.tQs.cNd, "100", 2, RoundingMode.HALF_UP);
      if (localBigDecimal.intValue() == localBigDecimal.doubleValue())
      {
        this.tQc.setText(localBigDecimal.intValue());
        AppMethodBeat.o(45587);
        return;
      }
      this.tQc.setText(localBigDecimal.toString());
    }
    AppMethodBeat.o(45587);
  }
  
  private void cRo()
  {
    AppMethodBeat.i(45588);
    Bankcard localBankcard = aeU(this.tQs.wpe);
    if (localBankcard != null)
    {
      this.tQf.setText(String.format("%s(%s)", new Object[] { this.tQs.nLq, this.tQs.ppo }));
      this.tQe.setTag(this.tQs.wpe);
      if (localBankcard.cTf())
      {
        this.tQe.setImageResource(2130840794);
        AppMethodBeat.o(45588);
        return;
      }
      Object localObject = "";
      com.tencent.mm.plugin.wallet_core.model.g localg = b.h(this, localBankcard.field_bankcardType, localBankcard.cTe());
      if (localg != null) {
        localObject = localg.pek;
      }
      localObject = x.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject));
      if (localObject != null) {
        this.tQe.setImageBitmap((Bitmap)localObject);
      }
      x.a(new WalletLqtPlanAddUI.8(this, localBankcard));
    }
    AppMethodBeat.o(45588);
  }
  
  private void cRp()
  {
    AppMethodBeat.i(45589);
    int i = this.tQs.eel - 1;
    ab.i("MicroMsg.WalletLqtPlanAddUI", "select day index: %s", new Object[] { Integer.valueOf(i) });
    if ((i >= 0) && (i < this.tQz.length)) {
      this.tQh.setText(this.tQz[i]);
    }
    AppMethodBeat.o(45589);
  }
  
  private void cRq()
  {
    AppMethodBeat.i(45590);
    if ((this.tQq != null) && (!bo.isNullOrNil(this.tQq.title)))
    {
      this.tQl.setClickable(true);
      this.tQl.setOnTouchListener(new m(this));
      com.tencent.mm.plugin.wallet_core.ui.o localo = new com.tencent.mm.plugin.wallet_core.ui.o(new WalletLqtPlanAddUI.9(this));
      String str = getString(2131305264);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
      localSpannableStringBuilder.append(this.tQq.title);
      localSpannableStringBuilder.setSpan(localo, str.length(), localSpannableStringBuilder.length(), 18);
      this.tQl.setText(localSpannableStringBuilder);
      if (this.tQq.xCh) {
        this.tQk.setChecked(true);
      }
      this.tQm.setVisibility(0);
      AppMethodBeat.o(45590);
      return;
    }
    this.tQm.setVisibility(8);
    AppMethodBeat.o(45590);
  }
  
  private void np(boolean paramBoolean)
  {
    Dialog localDialog = null;
    AppMethodBeat.i(45585);
    ab.i("MicroMsg.WalletLqtPlanAddUI", "do pre add plan: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    int i;
    if ((this.mMode == 2) && (this.tQs != null))
    {
      i = this.tQs.wpg;
      localDialog = com.tencent.mm.wallet_core.ui.g.c(getContext(), false, null);
    }
    for (;;)
    {
      com.tencent.mm.plugin.wallet.balance.a.a.o localo = new com.tencent.mm.plugin.wallet.balance.a.a.o();
      localo.b(new h(this.mMode, i));
      localo.a(new WalletLqtPlanAddUI.18(this, paramBoolean, localDialog));
      AppMethodBeat.o(45585);
      return;
      i = 0;
    }
  }
  
  public int getLayoutId()
  {
    return 2130970010;
  }
  
  public void initView()
  {
    AppMethodBeat.i(45582);
    this.tQb = ((ScrollView)findViewById(2131825520));
    this.tQc = ((WalletFormView)findViewById(2131825521));
    this.tQd = ((TextView)findViewById(2131825523));
    this.tQe = ((CdnImageView)findViewById(2131825526));
    this.tQf = ((TextView)findViewById(2131825527));
    this.tQg = ((LinearLayout)findViewById(2131825525));
    this.tQh = ((TextView)findViewById(2131825529));
    this.tQi = ((LinearLayout)findViewById(2131825528));
    this.tQj = ((Button)findViewById(2131825530));
    this.tQk = ((CheckBox)findViewById(2131825532));
    this.tQl = ((TextView)findViewById(2131825533));
    this.tQm = ((LinearLayout)findViewById(2131825531));
    this.tQt = ((ImageView)findViewById(2131825524));
    this.tQu = ((LinearLayout)findViewById(2131825522));
    this.tQc.dSY();
    this.tQc.setTitleText(ae.dSz());
    setEditFocusListener(this.tQc, 2, false, false, false);
    this.tQj.setOnClickListener(new WalletLqtPlanAddUI.1(this));
    this.tQk.setOnCheckedChangeListener(new WalletLqtPlanAddUI.11(this));
    this.tQg.setOnClickListener(new WalletLqtPlanAddUI.12(this));
    this.tQi.setOnClickListener(new WalletLqtPlanAddUI.13(this));
    this.tQc.a(new WalletLqtPlanAddUI.14(this));
    int i = com.tencent.mm.cb.a.fromDPToPix(this, 50);
    bo.n(this.tQt, i, i, i, i);
    this.tQt.setOnClickListener(new WalletLqtPlanAddUI.15(this));
    setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
    {
      public final void onVisibleStateChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(45576);
        if (paramAnonymousBoolean)
        {
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.bottomMargin = WalletLqtPlanAddUI.cQS();
            WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).setLayoutParams(localLayoutParams);
          }
          WalletLqtPlanAddUI.h(WalletLqtPlanAddUI.this).post(new WalletLqtPlanAddUI.16.1(this));
          AppMethodBeat.o(45576);
          return;
        }
        WalletLqtPlanAddUI.h(WalletLqtPlanAddUI.this).post(new WalletLqtPlanAddUI.16.2(this));
        AppMethodBeat.o(45576);
      }
    });
    AppMethodBeat.o(45582);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(45584);
    ab.i("MicroMsg.WalletLqtPlanAddUI", "activity result: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str1;
    int i;
    String str2;
    String str3;
    String str4;
    int j;
    int k;
    Dialog localDialog;
    Object localObject;
    if (paramInt1 == 0) {
      if (paramInt2 == -1)
      {
        str1 = paramIntent.getStringExtra("encrypt_pwd");
        i = e.iL(this.tQc.getText(), "100");
        str2 = this.tQs.poq;
        str3 = this.tQs.ppo;
        str4 = this.tQs.wpe;
        j = this.tQs.eel;
        k = this.tQs.wpg;
        localDialog = com.tencent.mm.wallet_core.ui.g.c(getContext(), false, null);
        localObject = this.tQn.tMQ;
        f.a(str1, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k)).c((com.tencent.mm.vending.c.a)localObject).f(new WalletLqtPlanAddUI.3(this, localDialog)).a(new WalletLqtPlanAddUI.2(this, localDialog));
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(45584);
      return;
      if ((paramInt1 == 4) && (paramInt2 == -1))
      {
        str1 = paramIntent.getStringExtra("encrypt_pwd");
        i = e.iL(this.tQc.getText(), "100");
        j = this.tQs.wpg;
        str2 = this.tQs.poq;
        str3 = this.tQs.ppo;
        str4 = this.tQs.wpe;
        k = this.tQs.eel;
        localDialog = com.tencent.mm.wallet_core.ui.g.c(getContext(), false, null);
        localObject = this.tQn.tMR;
        f.a(Integer.valueOf(j), str2, str3, str4, Integer.valueOf(i), Integer.valueOf(k), str1).c((com.tencent.mm.vending.c.a)localObject).f(new WalletLqtPlanAddUI.5(this, localDialog)).a(new WalletLqtPlanAddUI.4(this, localDialog));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45581);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setMMTitle(2131305273);
    setActionbarColor(getResources().getColor(2131690709));
    hideActionbarLine();
    this.mMode = getIntent().getIntExtra("key_mode", 0);
    if (this.mMode == 2) {}
    try
    {
      paramBundle = new bmo();
      byte[] arrayOfByte = getIntent().getByteArrayExtra("key_plan_item");
      if (arrayOfByte != null)
      {
        this.tQs = ((bmo)paramBundle.parseFrom(arrayOfByte));
        this.tQv = this.tQs.cNd;
        this.tQw = this.tQs.eel;
        this.tQx = this.tQs.wpe;
      }
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        int i;
        ab.printErrStackTrace("MicroMsg.WalletLqtPlanAddUI", paramBundle, "", new Object[0]);
      }
      initView();
      bJ();
      np(true);
      AppMethodBeat.o(45581);
    }
    this.tQz = new String[28];
    i = 0;
    while (i < 28)
    {
      this.tQz[i] = getString(2131305227, new Object[] { String.valueOf(i + 1) });
      i += 1;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45583);
    super.onDestroy();
    AppMethodBeat.o(45583);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI
 * JD-Core Version:    0.7.0.1
 */