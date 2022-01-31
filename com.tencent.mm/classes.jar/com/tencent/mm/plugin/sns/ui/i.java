package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.h.a.bt;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMEditText.a;
import java.util.LinkedList;
import java.util.List;

public final class i
{
  public static List<k> oNL = new LinkedList();
  private Context context;
  String diG;
  ClipboardManager kgn;
  protected ListView lwE;
  public com.tencent.mm.plugin.sns.a.b.g oNB;
  public com.tencent.mm.plugin.sns.model.au oNC;
  boolean oND;
  boolean oNE = false;
  SnsCommentFooter oNF;
  bh oNG;
  an oNH;
  private boolean oNI = false;
  private String oNJ = "";
  private boolean oNK = false;
  bg oNM;
  b oNN;
  com.tencent.mm.plugin.sns.f.b oNO;
  public com.tencent.mm.plugin.sns.ui.d.b oNP;
  com.tencent.mm.ui.base.p oNQ = null;
  c oNR = new c() {};
  View.OnLongClickListener oNS = new i.5(this);
  FrameLayout ovy;
  public au owd;
  
  public i(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    this.context = paramContext;
    this.diG = q.Gj();
    this.oNC = new com.tencent.mm.plugin.sns.model.au();
    this.oNC.ota = new com.tencent.mm.plugin.sns.h.b(paramInt1, paramString, paramInt2);
    this.oNP = new i.1(this, (Activity)paramContext, this.oNC);
    this.oNP.bdj();
    com.tencent.mm.sdk.b.a.udP.c(this.oNR);
  }
  
  private void bHm()
  {
    if (this.oNI) {}
    SnsCommentFooter localSnsCommentFooter;
    MMEditText.a local4;
    do
    {
      return;
      this.oNI = true;
      this.oNF.setAfterEditAction(this.oNG.pks);
      this.oNF.setOnCommentSendImp(new i.3(this));
      localSnsCommentFooter = this.oNF;
      local4 = new MMEditText.a()
      {
        public final void bgg()
        {
          if (i.this.oNF.getVisibility() == 0)
          {
            i.this.oNF.setVisibility(8);
            return;
          }
          ((Activity)i.c(i.this)).finish();
        }
      };
    } while (localSnsCommentFooter.lXN == null);
    localSnsCommentFooter.lXN.setBackListener(local4);
  }
  
  private void c(a.c paramc)
  {
    int i = com.tencent.mm.cb.a.fromDPToPix(this.context, 8);
    if (paramc.pmT != null)
    {
      i += paramc.pmV.getHeight() - paramc.pmT.getBottom();
      y.i("MicroMsg.BaseTimeLine", "comment item bottom = " + paramc.pmT.getBottom());
    }
    for (;;)
    {
      this.oNG.position = paramc.position;
      this.oNG.pkm = (paramc.kKz.getHeight() - i);
      paramc.pmT = null;
      this.oNG.pkn = paramc.kKz.getTop();
      this.oNG.oWf = this.lwE.getBottom();
      y.e("MicroMsg.BaseTimeLine", "originalTop:" + this.oNG.pkn);
      if ((!(this.context instanceof MMActivity)) || (((MMActivity)this.context).mController.uNh == 1)) {
        break;
      }
      this.oND = true;
      return;
      i = 0;
    }
    this.oNG.bKh();
  }
  
  public final void a(a.c paramc, n paramn, btd parambtd)
  {
    String str1 = paramc.bRV + "@boss";
    this.oNJ = str1;
    y.d("MicroMsg.BaseTimeLine", "onCommentClick:  commentkey " + this.oNJ + " " + paramc.bRV + " position:" + paramc.position);
    com.tencent.mm.kernel.g.DQ();
    String str2 = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abj(paramn.field_userName).Bq();
    this.oNF.setTag(paramn);
    bHm();
    this.oNF.setVisibility(0);
    this.oNF.setCommentFlag(1);
    this.oNF.setCommentHint(str2);
    this.oNF.setCommentInfo(parambtd);
    this.oNF.h(oNL, str1);
    c(paramc);
  }
  
  public final void a(a.c paramc, n paramn, String paramString, btd parambtd)
  {
    String str = paramc.bRV + paramString;
    this.oNJ = str;
    y.d("MicroMsg.BaseTimeLine", "onCommentClick:  commentkey " + this.oNJ + " " + paramc.bRV + " position:" + paramc.position);
    this.oNF.setTag(paramn);
    bHm();
    this.oNF.setVisibility(0);
    this.oNF.setCommentFlag(0);
    this.oNF.setCommentHint(paramString + this.context.getString(i.j.sns_after_reply));
    this.oNF.setCommentInfo(parambtd);
    this.oNF.h(oNL, str);
    this.oNF.jx(false);
    c(paramc);
  }
  
  public final void b(a.c paramc, n paramn, btd parambtd)
  {
    this.oNJ = null;
    y.d("MicroMsg.BaseTimeLine", "onCommentClick:  commentkey " + this.oNJ + " " + paramc.bRV + " position:" + paramc.position);
    this.oNF.setTag(paramn);
    bHm();
    this.oNF.setVisibility(0);
    this.oNF.setCommentFlag(0);
    this.oNF.setCommentHint("");
    this.oNF.setCommentInfo(parambtd);
    this.oNF.jx(true);
    this.oNF.h(oNL, "");
    c(paramc);
  }
  
  final void bHn()
  {
    if (!this.oNI) {
      return;
    }
    if (this.oNF.getVisibility() != 8) {
      this.oNF.setVisibility(8);
    }
    au localau = this.owd;
    if (localau.pef != null) {
      localau.pef.setVisibility(8);
    }
    localau.pef = null;
  }
  
  public final void c(a.c paramc, n paramn, btd parambtd)
  {
    String str = paramc.bRV;
    this.oNJ = str;
    y.d("MicroMsg.BaseTimeLine", "onCommentClick:  commentkey " + this.oNJ + " " + paramc.bRV + " position:" + paramc.position);
    this.oNF.setTag(paramn);
    bHm();
    this.oNF.setVisibility(0);
    this.oNF.setCommentFlag(0);
    this.oNF.setCommentInfo(parambtd);
    this.oNF.setCommentHint(this.context.getString(i.j.sns_ui_comment));
    this.oNF.h(oNL, str);
    this.oNF.jx(false);
    c(paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.i
 * JD-Core Version:    0.7.0.1
 */