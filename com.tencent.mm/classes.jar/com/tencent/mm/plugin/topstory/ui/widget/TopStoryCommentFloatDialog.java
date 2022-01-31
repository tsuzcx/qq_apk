package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.i;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.in;
import com.tencent.mm.kernel.d;
import com.tencent.mm.plugin.sns.ui.SnsEditText;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.ckr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;

public class TopStoryCommentFloatDialog
  extends RelativeLayout
  implements com.tencent.mm.ai.f, com.tencent.mm.ui.tools.g
{
  public com.tencent.mm.ui.tools.h ehl;
  MMActivity hwZ;
  TextView nUz;
  long sbQ;
  TextView ths;
  SnsEditText thv;
  com.tencent.mm.ui.base.p tipDialog;
  com.tencent.mm.plugin.topstory.a.c.f tmA;
  View tmE;
  boolean tmF;
  TopStoryCommentFloatDialog.a tmG;
  TextView tmH;
  private View.OnClickListener tmI;
  
  public TopStoryCommentFloatDialog(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(2250);
    this.tipDialog = null;
    this.tmF = false;
    this.sbQ = 0L;
    this.tmI = new TopStoryCommentFloatDialog.8(this);
    init();
    AppMethodBeat.o(2250);
  }
  
  public TopStoryCommentFloatDialog(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(2251);
    this.tipDialog = null;
    this.tmF = false;
    this.sbQ = 0L;
    this.tmI = new TopStoryCommentFloatDialog.8(this);
    init();
    AppMethodBeat.o(2251);
  }
  
  protected static boolean bDC()
  {
    AppMethodBeat.i(2263);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).SD())
    {
      i = com.tencent.mm.kernel.g.Rc().adt();
      if ((i == 4) || (i == 6))
      {
        AppMethodBeat.o(2263);
        return true;
      }
      AppMethodBeat.o(2263);
      return false;
    }
    if (at.isConnected(ah.getContext())) {}
    for (int i = 6; i == 6; i = 0)
    {
      AppMethodBeat.o(2263);
      return true;
    }
    AppMethodBeat.o(2263);
    return false;
  }
  
  private void cIW()
  {
    AppMethodBeat.i(2260);
    int j = this.thv.getText().toString().length();
    if (j < 180)
    {
      this.nUz.setVisibility(8);
      this.ths.setVisibility(8);
      AppMethodBeat.o(2260);
      return;
    }
    this.nUz.setVisibility(0);
    this.ths.setVisibility(0);
    if (j <= 200) {}
    for (int i = getResources().getColor(2131690595);; i = getResources().getColor(2131690391))
    {
      this.nUz.setText(String.valueOf(j));
      this.nUz.setTextColor(i);
      AppMethodBeat.o(2260);
      return;
    }
  }
  
  private void cKE()
  {
    AppMethodBeat.i(2261);
    int i = this.thv.getText().toString().length();
    int j = this.thv.getText().toString().trim().length();
    if ((i > 200) || (i <= 0) || (j <= 0))
    {
      this.tmH.setBackgroundResource(2130840616);
      AppMethodBeat.o(2261);
      return;
    }
    this.tmH.setBackgroundResource(2130840615);
    AppMethodBeat.o(2261);
  }
  
  private void init()
  {
    AppMethodBeat.i(2252);
    inflate(getContext(), 2130971010, this);
    this.tmE = findViewById(2131828522);
    this.thv = ((SnsEditText)findViewById(2131828527));
    this.nUz = ((TextView)findViewById(2131828526));
    this.ths = ((TextView)findViewById(2131828525));
    AppMethodBeat.o(2252);
  }
  
  public final void a(com.tencent.mm.plugin.topstory.a.c.f paramf, TopStoryCommentFloatDialog.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2254);
    this.tmF = true;
    this.tmA = paramf;
    setVisibility(0);
    this.thv.requestFocus();
    this.hwZ.showVKB();
    this.tmG = parama;
    paramf = paramf.cIF();
    paramf = "action=14&channelId=" + paramInt1 + "&mpScene=0&kykScene=" + paramf.Scene + "&kykSubScene=0&itemType=" + paramInt2 + "&searchId=" + paramf.xqX + "&docId=" + paramf.xHJ + "&byPass=" + paramf.xIg;
    com.tencent.mm.plugin.report.service.h.qsU.e(17080, new Object[] { Integer.valueOf(7), Integer.valueOf(2), paramf });
    AppMethodBeat.o(2254);
  }
  
  public final void cKD()
  {
    AppMethodBeat.i(2256);
    this.thv.setText("");
    setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.tmE.getLayoutParams();
    localLayoutParams.bottomMargin = 0;
    this.tmE.setLayoutParams(localLayoutParams);
    this.hwZ.hideVKB();
    this.tmF = false;
    if (this.tmG != null) {
      this.tmG.onDismiss();
    }
    AppMethodBeat.o(2256);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(2255);
    if (this.thv.getText().toString().length() > 0)
    {
      com.tencent.mm.ui.base.h.a(this.hwZ, 2131304346, 0, 2131297115, 2131297014, true, new TopStoryCommentFloatDialog.6(this), new TopStoryCommentFloatDialog.7(this), 2131689778);
      AppMethodBeat.o(2255);
      return;
    }
    cKD();
    AppMethodBeat.o(2255);
  }
  
  public final void k(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(2253);
    this.hwZ = paramMMActivity;
    this.ehl = new com.tencent.mm.ui.tools.h(paramMMActivity);
    setOnClickListener(this.tmI);
    findViewById(2131828523).setOnClickListener(new TopStoryCommentFloatDialog.1(this));
    this.tmH = ((TextView)findViewById(2131828524));
    this.tmH.setOnClickListener(new TopStoryCommentFloatDialog.2(this, paramMMActivity));
    cIW();
    cKE();
    this.thv.addTextChangedListener(new TopStoryCommentFloatDialog.3(this));
    post(new TopStoryCommentFloatDialog.4(this));
    AppMethodBeat.o(2253);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(2257);
    this.ehl.Avp = null;
    com.tencent.mm.kernel.g.Rc().b(2906, this);
    AppMethodBeat.o(2257);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(2258);
    this.ehl.Avp = this;
    com.tencent.mm.kernel.g.Rc().a(2906, this);
    AppMethodBeat.o(2258);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(2262);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    com.tencent.mm.plugin.topstory.a.c.f localf;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label271;
      }
      cKD();
      if (this.tmG != null) {
        this.tmG.cKs();
      }
      if ((paramm instanceof com.tencent.mm.plugin.topstory.a.c.f))
      {
        localf = (com.tencent.mm.plugin.topstory.a.c.f)paramm;
        paramm = new i();
      }
    }
    for (;;)
    {
      try
      {
        paramString = (ckq)localf.rr.fsV.fta;
        if (paramString == null) {
          continue;
        }
        paramString = paramString.ntu;
        paramm.f("content", paramString);
        paramm.f("id", localf.cIE().xUF);
        paramString = (ckq)localf.rr.fsV.fta;
        if (paramString == null) {
          continue;
        }
        paramString = paramString.xHJ;
        paramm.f("docId", paramString);
        paramm.f("opType", "REPLY_ARTICLE_BY_ME");
        paramString = new in();
        paramString.cxU.cxV = paramm.toString();
        paramString.cxU.cxW = "";
        a.ymk.l(paramString);
      }
      catch (com.tencent.mm.aa.g paramString)
      {
        ab.e("MicroMsg.TopStoryCommentFloatDialog", "notify tl failed");
        continue;
      }
      t.makeText(this.hwZ, 2131304348, 0).show();
      AppMethodBeat.o(2262);
      return;
      paramInt1 = 0;
      break;
      paramString = "";
      continue;
      paramString = "";
    }
    label271:
    com.tencent.mm.ui.base.h.b(this.hwZ, this.hwZ.getString(2131296926), "", true);
    AppMethodBeat.o(2262);
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(156639);
    ab.i("MicroMsg.TopStoryCommentFloatDialog", "onKeyboardHeightChanged in pixels: ".concat(String.valueOf(paramInt)));
    TopStoryCommentFloatDialog.5 local5;
    if (this.tmF)
    {
      this.tmE.setVisibility(0);
      if (((RelativeLayout.LayoutParams)this.tmE.getLayoutParams()).bottomMargin != paramInt)
      {
        local5 = new TopStoryCommentFloatDialog.5(this, paramInt);
        if (paramInt == 0) {
          break label103;
        }
        local5.setDuration(200L);
      }
    }
    for (;;)
    {
      this.tmE.startAnimation(local5);
      this.thv.requestFocus();
      setVisibility(0);
      AppMethodBeat.o(156639);
      return;
      label103:
      local5.setDuration(300L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog
 * JD-Core Version:    0.7.0.1
 */