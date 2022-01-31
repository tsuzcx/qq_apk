package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.p;

@a(19)
public class BankRemitDetailUI
  extends BankRemitBaseUI
{
  private int gst;
  private LinearLayout iCt;
  private int mState;
  private Button nJm;
  private View qhA;
  private View qhB;
  private ViewGroup qhC;
  private String qhD;
  private ImageView qhr;
  private ImageView qhs;
  private ImageView qht;
  private TextView qhu;
  private TextView qhv;
  private TextView qhw;
  private TextView qhx;
  private TextView qhy;
  private TextView qhz;
  
  protected final void bHV()
  {
    AppMethodBeat.i(44601);
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131690709)));
    Object localObject = getSupportActionBar().getCustomView();
    if (localObject != null)
    {
      View localView = ((View)localObject).findViewById(2131821148);
      if (localView != null) {
        localView.setBackgroundColor(getResources().getColor(2131690161));
      }
      localObject = ((View)localObject).findViewById(16908308);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        ((TextView)localObject).setTextColor(getResources().getColor(2131689763));
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = getWindow();
      ((Window)localObject).addFlags(-2147483648);
      ((Window)localObject).setStatusBarColor(getResources().getColor(2131690709));
    }
    BankRemitBaseUI.ae(this);
    getContentView().setFitsSystemWindows(true);
    AppMethodBeat.o(44601);
  }
  
  public int getLayoutId()
  {
    return 2130968821;
  }
  
  public void initView()
  {
    AppMethodBeat.i(44600);
    this.qhr = ((ImageView)findViewById(2131821685));
    this.qhs = ((ImageView)findViewById(2131821689));
    this.qht = ((ImageView)findViewById(2131821693));
    this.qhu = ((TextView)findViewById(2131821686));
    this.qhv = ((TextView)findViewById(2131821690));
    this.qhw = ((TextView)findViewById(2131821694));
    this.qhx = ((TextView)findViewById(2131821687));
    this.qhy = ((TextView)findViewById(2131821691));
    this.qhz = ((TextView)findViewById(2131821695));
    this.qhA = findViewById(2131821682);
    this.qhB = findViewById(2131821683);
    this.iCt = ((LinearLayout)findViewById(2131821698));
    this.qhC = ((ViewGroup)findViewById(2131821680));
    if (this.gst == 1)
    {
      findViewById(2131821700).setVisibility(8);
      AppMethodBeat.o(44600);
      return;
    }
    this.nJm = ((Button)findViewById(2131821701));
    this.nJm.setOnClickListener(new BankRemitDetailUI.2(this));
    AppMethodBeat.o(44600);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(44599);
    super.onCreate(paramBundle);
    addSceneEndListener(1579);
    this.qhD = getIntent().getStringExtra("key_transfer_bill_id");
    this.gst = getIntent().getIntExtra("key_enter_scene", 0);
    ab.i("MicroMsg.BankRemitDetailUI", "billId: %s, enterScene: %s", new Object[] { this.qhD, Integer.valueOf(this.gst) });
    initView();
    ab.i("MicroMsg.BankRemitDetailUI", "do query detail");
    doSceneProgress(new l(this.qhD));
    if (this.gst == 0)
    {
      showHomeBtn(false);
      enableBackMenu(false);
      setMMTitle(2131297491);
    }
    for (;;)
    {
      setBackBtn(new BankRemitDetailUI.1(this));
      AppMethodBeat.o(44599);
      return;
      showHomeBtn(true);
      enableBackMenu(true);
      setMMTitle(2131297490);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(44603);
    super.onDestroy();
    removeSceneEndListener(1579);
    AppMethodBeat.o(44603);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44602);
    if ((paramm instanceof l))
    {
      paramString = (l)paramm;
      paramString.a(new BankRemitDetailUI.5(this, paramString)).b(new BankRemitDetailUI.4(this, paramString)).c(new BankRemitDetailUI.3(this));
    }
    AppMethodBeat.o(44602);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI
 * JD-Core Version:    0.7.0.1
 */