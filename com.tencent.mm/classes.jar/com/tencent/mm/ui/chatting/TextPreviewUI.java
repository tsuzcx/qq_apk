package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.cd.g;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.widget.textview.a.a;

@com.tencent.mm.ui.base.a(3)
public class TextPreviewUI
  extends MMActivity
  implements f
{
  private int bottom = 0;
  private bi cEE;
  private TextView md = null;
  private Animation qUG;
  private Animation qUH;
  private int rN;
  private CharSequence text = null;
  private boolean vZB = false;
  private View zCA;
  private View zCB;
  private CustomScrollView zCC;
  private final int zCD = 0;
  private final int zCE = 1;
  private final int zCF = 2;
  private boolean zCG = false;
  private ToolsBar zCH;
  private View zCI;
  private com.tencent.mm.ui.widget.textview.a zCw;
  private com.tencent.mm.ui.widget.c.a zCx;
  private CharSequence zCy;
  private View zCz;
  private TextView zzS = null;
  
  private void bb(bi parambi)
  {
    AppMethodBeat.i(31063);
    com.tencent.mm.ui.chatting.view.b localb = new com.tencent.mm.ui.chatting.view.b(getContext());
    localb.zRc = new TextPreviewUI.4(this, localb, parambi);
    localb.show();
    AppMethodBeat.o(31063);
  }
  
  public int getLayoutId()
  {
    return 2130969092;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(31062);
    finish();
    AppMethodBeat.o(31062);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(31060);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    if (d.fv(19)) {
      getWindow().setFlags(67109888, 67109888);
    }
    this.zCz = findViewById(2131822698);
    this.text = getIntent().getCharSequenceExtra("key_chat_text");
    long l = getIntent().getLongExtra("Chat_Msg_Id", 0L);
    aw.aaz();
    this.cEE = c.YC().kB(l);
    this.md = ((TextView)findViewById(2131822701));
    this.zzS = ((TextView)findViewById(2131822699));
    Object localObject = this.text;
    TextView localTextView = this.zzS;
    paramBundle = (Bundle)localObject;
    if ((localObject instanceof SpannableString))
    {
      localTextView.setText(((SpannableString)localObject).toString());
      j.k(localTextView, 1);
      paramBundle = localTextView.getText();
    }
    this.text = paramBundle;
    paramBundle = this.md;
    localObject = g.dvk();
    getContext();
    paramBundle.setText(((g)localObject).b(this.text, this.md.getTextSize()));
    this.zCA = findViewById(2131822703);
    this.zCB = this.zCA.findViewById(2131822704);
    this.zCC = ((CustomScrollView)findViewById(2131822700));
    this.md.getViewTreeObserver().addOnPreDrawListener(new TextPreviewUI.1(this));
    this.qUH = AnimationUtils.loadAnimation(getContext(), 2131034230);
    this.qUG = AnimationUtils.loadAnimation(getContext(), 2131034228);
    this.zCx = new com.tencent.mm.ui.widget.c.a(getContext(), this.md);
    this.zCx.AIH = true;
    this.zCx.AIG = new TextPreviewUI.8(this);
    this.zCx.sap = new TextPreviewUI.9(this);
    if ((this.zCw == null) && (!bh.o(this.cEE)))
    {
      paramBundle = new a.a(this.md, this.zCx);
      paramBundle.ANa = 2131690431;
      paramBundle.ANb = 2131689914;
      this.zCw = paramBundle.dPX();
      this.zCw.AMS = new TextPreviewUI.10(this);
    }
    this.zCz.setOnClickListener(new TextPreviewUI.11(this));
    this.md.setOnClickListener(new TextPreviewUI.12(this));
    if (!bo.isNullOrNil(bh.r(this.cEE)))
    {
      this.zCA.setVisibility(0);
      this.zCB.setOnClickListener(new TextPreviewUI.13(this));
    }
    for (;;)
    {
      setBackBtn(new TextPreviewUI.14(this));
      this.zCC.setOnTouchListener(new TextPreviewUI.15(this));
      this.zCC.setOnScrollChangeListener(new TextPreviewUI.2(this));
      aw.Rc().a(525, this);
      AppMethodBeat.o(31060);
      return;
      if (!bh.o(this.cEE))
      {
        paramBundle = (ViewStub)findViewById(2131822702);
        if (paramBundle != null) {
          this.zCI = paramBundle.inflate();
        }
        this.zCH = ((ToolsBar)findViewById(2131828507));
        this.zCH.setVisibility(0);
        if (this.zCH != null)
        {
          this.zCH.c(0, new TextPreviewUI.5(this));
          this.zCH.c(1, new TextPreviewUI.6(this));
          this.zCH.c(2, new TextPreviewUI.7(this));
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(31064);
    super.onDestroy();
    aw.Rc().b(525, this);
    AppMethodBeat.o(31064);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(31061);
    super.onResume();
    if (this.zCw != null)
    {
      if (!this.zCw.ANj) {
        this.zCw.dPW();
      }
      if (!this.zCw.ANk) {
        this.zCw.dPS();
      }
    }
    AppMethodBeat.o(31061);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(31065);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramm.getType())
      {
      default: 
        AppMethodBeat.o(31065);
        return;
      }
      ab.i("MicroMsg.TextPreviewUI", "set msg remind!");
      com.tencent.mm.ui.widget.snackbar.b.a(getContext(), getContext().getResources().getString(2131300635), "", null);
      AppMethodBeat.o(31065);
      return;
    }
    if (paramm.getType() == 525)
    {
      ab.e("MicroMsg.TextPreviewUI", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[] { Integer.valueOf(525), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), bo.nullAsNil(paramString) });
      AppCompatActivity localAppCompatActivity = getContext();
      paramm = paramString;
      if (bo.isNullOrNil(paramString)) {
        paramm = getResources().getString(2131302506);
      }
      com.tencent.mm.ui.base.h.b(localAppCompatActivity, paramm, getContext().getResources().getString(2131302507), true);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(795L, 4L, 1L, false);
    }
    AppMethodBeat.o(31065);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI
 * JD-Core Version:    0.7.0.1
 */