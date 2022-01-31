package com.tencent.mm.plugin.sns.ui.b.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.b.c;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.widget.RoundedCornerRelativeLayout;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

public final class c
  extends a
{
  private Context context;
  com.tencent.mm.plugin.sns.a.b.g oWw;
  public View pmd;
  public View pme;
  private TextView pmf;
  private TextView pmg;
  private TextView pmh;
  private TextView pmi;
  public MaskImageView pmj;
  private b.c pmk;
  
  public c(bxk parambxk, n paramn, com.tencent.mm.plugin.sns.ui.d.b paramb, com.tencent.mm.plugin.sns.a.b.g paramg)
  {
    this.plP = parambxk;
    this.oUH = paramn;
    this.oWx = paramb;
    this.oWw = paramg;
  }
  
  public final void aqU()
  {
    this.oUH = h.OA(this.oUH.bGk());
    this.pmk = null;
    if ((this.oUH != null) && (this.oUH.bFZ() != null)) {
      this.pmk = this.oUH.bFZ().oBy;
    }
    Object localObject1 = null;
    int i = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth();
    if (this.pmk != null)
    {
      i = i - com.tencent.mm.cb.a.fromDPToPix(this.context, 50) - this.context.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.context.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.context.getResources().getDimensionPixelSize(i.d.SmallPadding);
      if (this.pmk.oBK == 0)
      {
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = i;
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(((ViewGroup.LayoutParams)localObject1).width * 0.75F));
      }
    }
    Object localObject2;
    label447:
    label491:
    final long l1;
    label526:
    label827:
    label839:
    label970:
    do
    {
      do
      {
        break label771;
        break label771;
        if (localObject1 != null)
        {
          localObject2 = this.contentView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
          this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ((RoundedCornerRelativeLayout)this.contentView).setRadius(8);
          localObject2 = this.pmj.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
          this.pmj.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject2 = this.plQ.oTG.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
          this.plQ.oTG.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.plQ.ogP.dL(((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
        }
        int j;
        if (this.pmk.oBM == 0)
        {
          i = Color.argb((int)(this.pmk.oBL * 2.55F), 0, 0, 0);
          j = Color.argb(0, 0, 0, 0);
          localObject1 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, j });
          ((GradientDrawable)localObject1).setGradientType(0);
          this.pmd.setBackground((Drawable)localObject1);
          if ((!bk.bl(this.pmk.title)) || (!bk.bl(this.pmk.description)))
          {
            this.pmd.setVisibility(0);
            this.pme.setVisibility(8);
            if (bk.bl(this.pmk.title)) {
              break label827;
            }
            this.pmf.setVisibility(0);
            this.pmf.setText(this.pmk.title);
            if (bk.bl(this.pmk.description)) {
              break label839;
            }
            this.pmg.setVisibility(0);
            this.pmg.setText(this.pmk.description);
            if ((this.plP.tNr == null) || (this.plP.tNr.sPJ.size() <= 0)) {
              break label1091;
            }
          }
        }
        for (localObject1 = (awd)this.plP.tNr.sPJ.get(0);; localObject1 = null)
        {
          this.plQ.a(this.plP, 0, this.oUH.bGE(), true);
          this.plQ.oGU.setVisibility(8);
          localObject2 = af.bDC();
          if (localObject1 == null) {
            break label2024;
          }
          l1 = this.oUH.field_snsId;
          this.plQ.ogP.setOnCompletionListener(new b.e()
          {
            public final void d(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
            {
              if (paramAnonymousInt != -1) {
                c.this.oWw.q(l1, false);
              }
            }
          });
          if ((this.oWw != null) && (!this.oWw.fG(l1))) {
            this.plQ.ogP.setOnDecodeDurationListener(new c.2(this, l1));
          }
          if (this.plP.tNr.sPI != 1) {
            break label1097;
          }
          this.pmj.setVisibility(0);
          this.pmj.setTag(this);
          this.pmj.setOnClickListener(this.oWx.ppf);
          localObject3 = this.pmj;
          i = this.context.hashCode();
          localObject4 = az.cuY();
          ((az)localObject4).time = this.plP.mPL;
          ((com.tencent.mm.plugin.sns.model.g)localObject2).a((awd)localObject1, (View)localObject3, -1, i, (az)localObject4, 3);
          return;
          if (this.pmk.oBK != 1) {
            break;
          }
          localObject1 = new ViewGroup.LayoutParams(-2, -2);
          ((ViewGroup.LayoutParams)localObject1).width = i;
          ((ViewGroup.LayoutParams)localObject1).height = ((ViewGroup.LayoutParams)localObject1).width;
          break;
          this.pmd.setVisibility(8);
          break label447;
          this.pmf.setVisibility(8);
          break label491;
          this.pmg.setVisibility(8);
          break label526;
          if (this.pmk.oBM != 1) {
            break label526;
          }
          i = Color.argb((int)(this.pmk.oBL * 2.55F), 0, 0, 0);
          j = Color.argb(0, 0, 0, 0);
          localObject1 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { i, j });
          ((GradientDrawable)localObject1).setGradientType(0);
          this.pmd.setVisibility(8);
          this.pme.setBackground((Drawable)localObject1);
          if ((!bk.bl(this.pmk.title)) || (!bk.bl(this.pmk.description)))
          {
            this.pme.setVisibility(0);
            if (bk.bl(this.pmk.title)) {
              break label1055;
            }
            this.pmh.setVisibility(0);
            this.pmh.setText(this.pmk.title);
          }
          for (;;)
          {
            if (bk.bl(this.pmk.description)) {
              break label1067;
            }
            this.pmi.setVisibility(0);
            this.pmi.setText(this.pmk.description);
            break;
            this.pme.setVisibility(8);
            break label970;
            this.pmh.setVisibility(8);
          }
          this.pmi.setVisibility(8);
          break label526;
          y.e("MicroMsg.FullCardAdDetailItem", "invalid full card");
          break label526;
        }
      } while ((this.plP.tNr.sPI != 15) && (this.plP.tNr.sPI != 5));
      this.plQ.oTG.setVisibility(0);
      long l2 = System.nanoTime();
      bool = com.tencent.mm.plugin.sns.model.g.t((awd)localObject1);
      y.i("MicroMsg.FullCardAdDetailItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l2) });
      if (bool) {
        break label1639;
      }
      if (!((com.tencent.mm.plugin.sns.model.g)localObject2).w((awd)localObject1)) {
        break;
      }
      this.plQ.oGT.setVisibility(8);
      this.plQ.oTI.setVisibility(0);
      this.plQ.oTI.cJO();
      this.plQ.oTG.setVisibility(0);
      this.plQ.ogP.setTagObject(this.plQ);
      this.plQ.oTH.setTag(this);
      this.plQ.oTG.setOnClickListener(this.oWx.ppf);
      Object localObject3 = this.oUH;
      Object localObject4 = this.plQ.ogP;
      i = this.context.hashCode();
      az localaz = az.cuY();
      localaz.time = this.plP.mPL;
      ((com.tencent.mm.plugin.sns.model.g)localObject2).a((n)localObject3, (awd)localObject1, (com.tencent.mm.plugin.sight.decode.a.a)localObject4, i, 0, localaz, true, true);
      localObject2 = an.eJ(af.getAccSnsPath(), ((awd)localObject1).lsK);
      localObject1 = i.j((awd)localObject1);
    } while (this.oWw == null);
    label771:
    label1055:
    label1067:
    label1091:
    label1097:
    if (e.bK((String)localObject2 + (String)localObject1))
    {
      this.oWw.r(l1, true);
      label1405:
      if (af.bDC().b(this.oUH, null) != 5) {
        break label2018;
      }
    }
    label2004:
    label2018:
    for (boolean bool = true;; bool = false)
    {
      this.oWw.a(l1, bool, false);
      return;
      if (((com.tencent.mm.plugin.sns.model.g)localObject2).b(this.oUH, null) == 5)
      {
        ((com.tencent.mm.plugin.sns.model.g)localObject2).A((awd)localObject1);
        this.plQ.oGT.setVisibility(8);
        this.plQ.oTI.setVisibility(0);
        this.plQ.oTI.cJO();
        break;
      }
      if (((com.tencent.mm.plugin.sns.model.g)localObject2).x((awd)localObject1))
      {
        this.plQ.oTI.setVisibility(8);
        this.plQ.oGT.setImageResource(i.e.sight_chat_error);
        this.plQ.oGT.setVisibility(0);
        break;
      }
      ((com.tencent.mm.plugin.sns.model.g)localObject2).y((awd)localObject1);
      this.plQ.oGT.setVisibility(0);
      this.plQ.oTI.setVisibility(8);
      this.plQ.oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.context, i.i.shortvideo_play_btn));
      this.plQ.oGT.setContentDescription(this.context.getString(i.j.play_sight_desc));
      if (((com.tencent.mm.plugin.sns.model.g)localObject2).b(this.oUH, null) != 4) {
        break;
      }
      this.plQ.oGU.setVisibility(0);
      break;
      label1639:
      if (((com.tencent.mm.plugin.sns.model.g)localObject2).u((awd)localObject1))
      {
        this.plQ.oGT.setVisibility(0);
        this.plQ.oTI.setVisibility(8);
        this.plQ.oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.context, i.i.shortvideo_play_btn));
        this.plQ.oGT.setContentDescription(this.context.getString(i.j.play_sight_desc));
      }
      for (;;)
      {
        if (!this.plQ.ogP.bAY()) {
          break label2004;
        }
        y.d("MicroMsg.FullCardAdDetailItem", "play video error " + ((awd)localObject1).lsK + " " + ((awd)localObject1).kSC + " " + ((awd)localObject1).trP);
        ((com.tencent.mm.plugin.sns.model.g)localObject2).y((awd)localObject1);
        this.plQ.oGT.setVisibility(0);
        this.plQ.oTI.setVisibility(8);
        this.plQ.oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.context, i.i.shortvideo_play_btn));
        this.plQ.oGT.setContentDescription(this.context.getString(i.j.play_sight_desc));
        break;
        if (((com.tencent.mm.plugin.sns.model.g)localObject2).v((awd)localObject1))
        {
          this.plQ.oGT.setVisibility(8);
          this.plQ.oTI.setVisibility(8);
        }
        else if (((com.tencent.mm.plugin.sns.model.g)localObject2).b(this.oUH, null) <= 5)
        {
          this.plQ.oGT.setVisibility(8);
          this.plQ.oTI.setVisibility(8);
        }
        else
        {
          ((com.tencent.mm.plugin.sns.model.g)localObject2).y((awd)localObject1);
          this.plQ.oGT.setVisibility(0);
          this.plQ.oTI.setVisibility(8);
          this.plQ.oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.context, i.i.shortvideo_play_btn));
          this.plQ.oGT.setContentDescription(this.context.getString(i.j.play_sight_desc));
        }
      }
      break;
      this.oWw.r(l1, false);
      break label1405;
    }
    label2024:
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
    this.pmd = paramView1.findViewById(i.f.top_layer);
    this.pme = paramView1.findViewById(i.f.bottom_layer);
    this.pmf = ((TextView)paramView1.findViewById(i.f.top_layer_title));
    this.pmg = ((TextView)paramView1.findViewById(i.f.top_layer_desc));
    this.pmh = ((TextView)paramView1.findViewById(i.f.bottom_layer_title));
    this.pmi = ((TextView)paramView1.findViewById(i.f.bottom_layer_desc));
    this.pmj = ((MaskImageView)paramView1.findViewById(i.f.full_card_img));
    this.pmj.setScaleType(QImageView.a.wkS);
    this.plQ = new aj();
    this.plQ.oTH = paramView1.findViewById(i.f.full_card_video);
    this.plQ.oTG = this.plQ.oTH;
    this.plQ.oTH.setOnClickListener(this.oWx.poW);
    this.plQ.ogP = ((com.tencent.mm.plugin.sight.decode.a.a)this.plQ.oTH.findViewById(i.f.image));
    this.plQ.oGT = ((ImageView)this.plQ.oTH.findViewById(i.f.status_btn));
    this.plQ.oTI = ((MMPinProgressBtn)this.plQ.oTH.findViewById(i.f.progress));
    this.plQ.oTJ = ((TextView)this.plQ.oTH.findViewById(i.f.endtv));
    this.plQ.oGU = ((TextView)this.plQ.oTH.findViewById(i.f.errorTv));
    ((SightPlayImageView)this.plQ.ogP).ofL = true;
    ((SightPlayImageView)this.plQ.ogP).setScaleType(QImageView.a.wkS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.c
 * JD-Core Version:    0.7.0.1
 */