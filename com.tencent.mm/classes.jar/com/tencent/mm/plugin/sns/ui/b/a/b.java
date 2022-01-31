package com.tencent.mm.plugin.sns.ui.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.b.f;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.awf;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends a
{
  private Context context;
  private com.tencent.mm.ui.widget.b.a iep;
  com.tencent.mm.plugin.sns.a.b.g oWw;
  public TextView plR;
  public TextView plS;
  public View plT;
  public Button plU;
  public Button plV;
  public View plW;
  public MaskImageView plX;
  public SnsCardAdTagListView plY;
  public View plZ;
  public View pma;
  public View pmb;
  
  public b(bxk parambxk, n paramn, com.tencent.mm.plugin.sns.ui.d.b paramb, com.tencent.mm.plugin.sns.a.b.g paramg)
  {
    this.plP = parambxk;
    this.oUH = paramn;
    this.oWx = paramb;
    this.oWw = paramg;
  }
  
  private void G(n paramn)
  {
    int j = 0;
    if ((paramn == null) || (!paramn.bEJ())) {}
    for (;;)
    {
      return;
      int k = i.e.sns_card_select_btn_solid_white;
      int m = Color.parseColor("#cdcdcd");
      int n = Color.parseColor("#ffffff");
      if ((this.plU != null) && (this.plV != null))
      {
        this.plU.setOnClickListener(this.oWx.ppd);
        this.plV.setOnClickListener(this.oWx.ppe);
        int i1;
        int i;
        if (paramn.bFZ().bEM())
        {
          i1 = v.eY(paramn.bFZ().oBH.oBR, paramn.bGM());
          if ((i1 > 0) && (i1 <= 2)) {
            if (i1 == 1)
            {
              this.plV.setBackgroundColor(n);
              this.plV.setTextColor(m);
              this.plV.setText(paramn.bFZ().oBH.ya(1));
              this.plU.setBackgroundResource(k);
              this.plU.setTextColor(-16777216);
              this.plU.setText(paramn.bFZ().oBH.xZ(0));
              i = j;
            }
          }
        }
        while (i != 0)
        {
          this.plU.setTextColor(-16777216);
          this.plU.setBackgroundResource(k);
          this.plV.setTextColor(-16777216);
          this.plV.setBackgroundResource(k);
          this.plU.setText(paramn.bFZ().bEF());
          this.plV.setText(paramn.bFZ().bEG());
          return;
          i = j;
          if (i1 == 2)
          {
            this.plU.setBackgroundColor(n);
            this.plU.setTextColor(m);
            this.plU.setText(paramn.bFZ().oBH.ya(0));
            this.plV.setBackgroundResource(k);
            this.plV.setTextColor(-16777216);
            this.plV.setText(paramn.bFZ().oBH.xZ(1));
            i = j;
            continue;
            i = 1;
          }
        }
      }
    }
  }
  
  public final void aqU()
  {
    this.oUH = com.tencent.mm.plugin.sns.storage.h.OA(this.oUH.bGk());
    y.i("MicroMsg.CardAdDetailItemView", "refreshView");
    G(this.oUH);
    this.plQ.oGU.setVisibility(8);
    Object localObject2 = af.bDC();
    int i;
    int j;
    if ((this.plP.tNr != null) && (this.plP.tNr.sPJ.size() > 0))
    {
      localObject1 = (awd)this.plP.tNr.sPJ.get(0);
      i = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth();
      if (localObject1 != null)
      {
        i = i - com.tencent.mm.cb.a.fromDPToPix(this.context, 50) - this.context.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.context.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.context.getResources().getDimensionPixelSize(i.d.SmallPadding) - this.context.getResources().getDimensionPixelSize(i.d.MiddlePadding) - this.context.getResources().getDimensionPixelSize(i.d.MiddlePadding);
        j = (int)(i * ((awd)localObject1).trS.tsG / ((awd)localObject1).trS.tsF);
        if (this.plP.tNr.sPI != 1) {
          break label375;
        }
        localObject2 = this.plX.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = i;
        ((ViewGroup.LayoutParams)localObject2).height = j;
        this.plX.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        af.bDC().b((awd)localObject1, this.plX, -1, this.context.hashCode(), az.uBJ);
        this.plX.setVisibility(0);
        this.plX.setTag(this);
        this.contentView.setTag(this);
        this.plU.setTag(this);
        this.plV.setTag(this);
        this.plX.setOnClickListener(this.oWx.oPK);
        this.iep.c(this.plX, this.oWx.poR, this.oWx.poz);
      }
    }
    label375:
    Object localObject3;
    do
    {
      return;
      localObject1 = null;
      break;
      if ((this.plP.tNr.sPI != 5) && (this.plP.tNr.sPI != 15)) {
        break label1401;
      }
      this.plQ.oTG.setVisibility(0);
      this.iep.c(this.plQ.oTH, this.oWx.poR, this.oWx.poz);
      localObject3 = this.plQ.oTG.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject3).width = i;
      ((ViewGroup.LayoutParams)localObject3).height = j;
      this.plQ.oTG.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      this.plQ.ogP.dL(i, j);
      this.plQ.ogP.setOnCompletionListener(new b.1(this));
      if ((this.oWw != null) && (!this.oWw.fG(this.oUH.field_snsId))) {
        this.plQ.ogP.setOnDecodeDurationListener(new b.2(this));
      }
      long l = System.nanoTime();
      bool = com.tencent.mm.plugin.sns.model.g.t((awd)localObject1);
      y.i("MicroMsg.CardAdDetailItemView", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
      localObject3 = this.plQ;
      this.plQ.bJQ = this.oUH.bGE();
      if (bool) {
        break label1036;
      }
      if (!((com.tencent.mm.plugin.sns.model.g)localObject2).w((awd)localObject1)) {
        break label851;
      }
      ((aj)localObject3).oGT.setVisibility(8);
      ((aj)localObject3).oTI.setVisibility(0);
      ((aj)localObject3).oTI.cJO();
      this.plQ.oTG.setVisibility(0);
      ((aj)localObject3).ogP.setTagObject(localObject3);
      ((aj)localObject3).oTH.setTag(this);
      this.contentView.setTag(this);
      this.plU.setTag(this);
      this.plV.setTag(this);
      ((com.tencent.mm.plugin.sns.model.g)localObject2).a(this.oUH, (awd)localObject1, ((aj)localObject3).ogP, this.context.hashCode(), 0, az.uBJ, true, true);
    } while (this.oWw == null);
    localObject2 = an.eJ(af.getAccSnsPath(), ((awd)localObject1).lsK);
    Object localObject1 = i.j((awd)localObject1);
    if (e.bK((String)localObject2 + (String)localObject1))
    {
      this.oWw.r(this.oUH.field_snsId, true);
      label815:
      if (af.bDC().b(this.oUH, null) != 5) {
        break label1395;
      }
    }
    label851:
    label1375:
    label1395:
    for (boolean bool = true;; bool = false)
    {
      this.oWw.a(this.oUH.field_snsId, bool, false);
      return;
      if (((com.tencent.mm.plugin.sns.model.g)localObject2).b(this.oUH, null) == 5)
      {
        ((com.tencent.mm.plugin.sns.model.g)localObject2).A((awd)localObject1);
        ((aj)localObject3).oGT.setVisibility(8);
        ((aj)localObject3).oTI.setVisibility(0);
        ((aj)localObject3).oTI.cJO();
        break;
      }
      if (((com.tencent.mm.plugin.sns.model.g)localObject2).x((awd)localObject1))
      {
        ((aj)localObject3).oTI.setVisibility(8);
        ((aj)localObject3).oGT.setImageResource(i.e.sight_chat_error);
        ((aj)localObject3).oGT.setVisibility(0);
        break;
      }
      ((com.tencent.mm.plugin.sns.model.g)localObject2).y((awd)localObject1);
      ((aj)localObject3).oGT.setVisibility(0);
      ((aj)localObject3).oTI.setVisibility(8);
      ((aj)localObject3).oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.context, i.i.shortvideo_play_btn));
      ((aj)localObject3).oGT.setContentDescription(this.context.getResources().getString(i.j.play_sight_desc));
      if (((com.tencent.mm.plugin.sns.model.g)localObject2).b(this.oUH, null) != 4) {
        break;
      }
      ((aj)localObject3).oGU.setVisibility(0);
      break;
      if (((com.tencent.mm.plugin.sns.model.g)localObject2).u((awd)localObject1))
      {
        ((aj)localObject3).oGT.setVisibility(0);
        ((aj)localObject3).oTI.setVisibility(8);
        ((aj)localObject3).oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.context, i.i.shortvideo_play_btn));
        ((aj)localObject3).oGT.setContentDescription(this.context.getResources().getString(i.j.play_sight_desc));
      }
      for (;;)
      {
        if (!((aj)localObject3).ogP.bAY()) {
          break label1375;
        }
        y.d("MicroMsg.CardAdDetailItemView", "play video error " + ((awd)localObject1).lsK + " " + ((awd)localObject1).kSC + " " + ((awd)localObject1).trP);
        ((com.tencent.mm.plugin.sns.model.g)localObject2).y((awd)localObject1);
        ((aj)localObject3).oGT.setVisibility(0);
        ((aj)localObject3).oTI.setVisibility(8);
        ((aj)localObject3).oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.context, i.i.shortvideo_play_btn));
        ((aj)localObject3).oGT.setContentDescription(this.context.getResources().getString(i.j.play_sight_desc));
        break;
        if (((com.tencent.mm.plugin.sns.model.g)localObject2).v((awd)localObject1))
        {
          ((aj)localObject3).oGT.setVisibility(8);
          ((aj)localObject3).oTI.setVisibility(8);
        }
        else if (((com.tencent.mm.plugin.sns.model.g)localObject2).b(this.oUH, null) <= 5)
        {
          ((aj)localObject3).oGT.setVisibility(8);
          ((aj)localObject3).oTI.setVisibility(8);
        }
        else
        {
          ((com.tencent.mm.plugin.sns.model.g)localObject2).y((awd)localObject1);
          ((aj)localObject3).oGT.setVisibility(0);
          ((aj)localObject3).oTI.setVisibility(8);
          ((aj)localObject3).oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.context, i.i.shortvideo_play_btn));
          ((aj)localObject3).oGT.setContentDescription(this.context.getResources().getString(i.j.play_sight_desc));
        }
      }
      break;
      this.oWw.r(this.oUH.field_snsId, false);
      break label815;
    }
    label1036:
    label1401:
    ((com.tencent.mm.plugin.sns.model.g)localObject2).a(this.plQ.ogP, this.context.hashCode());
    this.plQ.oTJ.setVisibility(8);
    this.plQ.ogP.setOnSightCompletionAction(null);
    this.plQ.ogP.setOnCompletionListener(null);
    this.plQ.ogP.setOnDecodeDurationListener(null);
  }
  
  public final void f(View paramView1, View paramView2)
  {
    this.contentView = paramView1;
    this.oVY = paramView2;
    this.context = paramView1.getContext();
    this.pma = paramView1.findViewById(i.f.media_container);
    this.pmb = paramView1.findViewById(i.f.other_container);
    this.plT = paramView1.findViewById(i.f.card_btn_container);
    this.plT.setVisibility(8);
    this.plW = paramView1.findViewById(i.f.card_weapp_tag);
    this.plW.setVisibility(8);
    this.plX = ((MaskImageView)paramView1.findViewById(i.f.sns_card_ad_image));
    this.plU = ((Button)paramView1.findViewById(i.f.card_btn_left));
    this.plV = ((Button)paramView1.findViewById(i.f.card_btn_right));
    paramView2 = this.oUH.bGb();
    if ((paramView2 != null) && (paramView2.bEC()) && (!this.oUH.bGQ())) {
      this.plW.setVisibility(0);
    }
    this.plS = ((TextView)paramView1.findViewById(i.f.desc_collapse_pic_style_tv));
    this.plS.setClickable(false);
    this.plS.setLongClickable(false);
    int i = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth();
    int j = com.tencent.mm.cb.a.fromDPToPix(this.context, 50);
    int k = this.context.getResources().getDimensionPixelSize(i.d.NormalPadding);
    int m = this.context.getResources().getDimensionPixelSize(i.d.NormalPadding);
    int n = this.context.getResources().getDimensionPixelSize(i.d.SmallPadding);
    paramView2 = (LinearLayout.LayoutParams)paramView1.getLayoutParams();
    paramView2.topMargin = this.context.getResources().getDimensionPixelOffset(i.d.MiddlePadding);
    paramView2.bottomMargin = 0;
    paramView2.width = (i - j - k - m - n);
    paramView2.height = -2;
    paramView1.setLayoutParams(paramView2);
    paramView1.setBackground(this.context.getResources().getDrawable(i.e.sns_ad_pic_style_bg));
    this.plR = ((TextView)paramView1.findViewById(i.f.desc_collapse_pic_style_title_tv));
    this.plR.setClickable(false);
    this.plR.setLongClickable(false);
    if (!bk.bl(this.oUH.bFZ().oBs))
    {
      this.plR.setText(this.oUH.bFZ().oBs + " ");
      j.h(this.plR, 2);
      this.plR.setVisibility(0);
      if (!bk.bl(this.oUH.bFZ().oBt)) {
        break label1297;
      }
      paramView2 = this.plP.tNo;
      label464:
      if (bk.bl(paramView2)) {
        break label1311;
      }
      this.plS.setText(paramView2 + " ");
      j.h(this.plS, 2);
      this.plS.setVisibility(0);
      label515:
      this.iep = new com.tencent.mm.ui.widget.b.a(this.context);
      this.iep.c(paramView1, this.oWx.poR, this.oWx.poz);
      if ((!this.oUH.bFZ().bEL()) && (!this.oUH.bFZ().bEM())) {
        break label1323;
      }
      this.plT.setVisibility(0);
      G(this.oUH);
    }
    for (;;)
    {
      this.plQ = new aj();
      this.plQ.oTH = paramView1.findViewById(i.f.sns_card_ad_sight);
      this.plQ.oTG = this.plQ.oTH;
      this.plQ.oTH.setOnClickListener(this.oWx.poW);
      this.plQ.ogP = ((com.tencent.mm.plugin.sight.decode.a.a)this.plQ.oTH.findViewById(i.f.image));
      this.plQ.oGT = ((ImageView)this.plQ.oTH.findViewById(i.f.status_btn));
      this.plQ.oTI = ((MMPinProgressBtn)this.plQ.oTH.findViewById(i.f.progress));
      this.plQ.oTJ = ((TextView)this.plQ.oTH.findViewById(i.f.endtv));
      this.plQ.oGU = ((TextView)this.plQ.oTH.findViewById(i.f.errorTv));
      paramView2 = (RelativeLayout.LayoutParams)this.plX.getLayoutParams();
      paramView2.leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
      paramView2.rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
      paramView2.topMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
      paramView2.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
      this.plX.setLayoutParams(paramView2);
      paramView2 = (RelativeLayout.LayoutParams)this.plQ.oTG.getLayoutParams();
      paramView2.leftMargin = com.tencent.mm.cb.a.aa(this.context, i.d.MiddlePadding);
      paramView2.rightMargin = com.tencent.mm.cb.a.aa(this.context, i.d.MiddlePadding);
      paramView2.topMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
      paramView2.bottomMargin = com.tencent.mm.cb.a.aa(this.context, i.d.MiddlePadding);
      this.plQ.oTG.setLayoutParams(paramView2);
      this.plZ = paramView1.findViewById(i.f.sns_ad_card_header_container);
      paramView2 = (RelativeLayout.LayoutParams)this.plZ.getLayoutParams();
      paramView2.leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
      paramView2.rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
      paramView2.topMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
      this.plZ.setLayoutParams(paramView2);
      this.plY = ((SnsCardAdTagListView)this.contentView.findViewById(i.f.card_ad_tag_list));
      this.plY.setActivityContext((Activity)this.context);
      this.plY.removeAllViews();
      if (this.oUH.bFZ().oBw.size() > 0)
      {
        this.plY.setVisibility(0);
        this.plY.setTagSpace(com.tencent.mm.cb.a.fromDPToPix(this.context, 6));
        this.plY.cL(this.oUH.bFZ().oBw);
      }
      if (!bk.bl(this.oUH.bFZ().oBu))
      {
        this.plZ.setVisibility(0);
        this.plZ.findViewById(i.f.sns_ad_card_header_title).setVisibility(0);
        ((TextView)this.plZ.findViewById(i.f.sns_ad_card_header_title)).setText(this.oUH.bFZ().oBu);
      }
      if (!bk.bl(this.oUH.bFZ().oBv)) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(this.oUH.bFZ().oBv, new b.3(this));
      }
      this.iep.c(paramView1, this.oWx.poR, this.oWx.poz);
      this.plX.setVisibility(8);
      this.plX.setScaleType(QImageView.a.wkS);
      this.plQ.oTG.setVisibility(8);
      ((SightPlayImageView)this.plQ.ogP).ofL = true;
      ((SightPlayImageView)this.plQ.ogP).setScaleType(QImageView.a.wkS);
      paramView1.setBackgroundResource(i.e.sns_ad_pic_style_bg);
      paramView1.setOnClickListener(this.oWx.ppf);
      return;
      this.plR.setVisibility(8);
      break;
      label1297:
      paramView2 = this.oUH.bFZ().oBt;
      break label464;
      label1311:
      this.plS.setVisibility(8);
      break label515;
      label1323:
      this.plT.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.b
 * JD-Core Version:    0.7.0.1
 */