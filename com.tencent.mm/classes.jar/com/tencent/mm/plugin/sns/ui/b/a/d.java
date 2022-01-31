package com.tencent.mm.plugin.sns.ui.b.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.b.h;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aj;
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
import java.util.List;

public final class d
  extends a
{
  Context context;
  public int currentIndex;
  com.tencent.mm.plugin.sns.a.b.g oWw;
  boolean pgy = false;
  public View pmn;
  public View pmo;
  private int[] pmp = { i.f.turn_media_type_img_0, i.f.turn_media_type_img_1 };
  private final int pmq = i.f.turn_media_type_sight_0;
  
  public d(bxk parambxk, n paramn, com.tencent.mm.plugin.sns.ui.d.b paramb, com.tencent.mm.plugin.sns.a.b.g paramg)
  {
    this.plP = parambxk;
    this.oUH = paramn;
    this.oWx = paramb;
    this.oWw = paramg;
  }
  
  private View a(awd paramawd, int paramInt, boolean paramBoolean)
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = i.f.turn_media_type_img_0;
    arrayOfInt[1] = i.f.turn_media_type_img_1;
    int i = i.f.turn_media_type_sight_0;
    if (paramBoolean) {
      return this.contentView.findViewById(arrayOfInt[paramInt]);
    }
    if (paramawd.hQR == 6) {
      return this.contentView.findViewById(i);
    }
    if (paramawd.hQR == 2) {
      return this.contentView.findViewById(arrayOfInt[paramInt]);
    }
    return null;
  }
  
  public final void aqU()
  {
    this.oUH = h.OA(this.oUH.bGk());
    y.i("MicroMsg.TurnCardAdDetailItem", "refresh view");
    int k = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.cb.a.fromDPToPix(this.context, 50) - this.context.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.context.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.context.getResources().getDimensionPixelSize(i.d.SmallPadding);
    label134:
    label299:
    label560:
    label697:
    label1465:
    label1467:
    if (this.oUH.bGe().tNr.sPJ.size() >= 2)
    {
      int i;
      final int j;
      Object localObject1;
      Object localObject2;
      com.tencent.mm.plugin.sns.model.g localg;
      int m;
      az localaz;
      label245:
      boolean bool1;
      label321:
      final long l1;
      if (this.oUH.field_likeFlag == 1)
      {
        i = 1;
        yY(i);
        j = 0;
        if (j >= 2) {
          return;
        }
        localObject1 = (awd)this.oUH.bGe().tNr.sPJ.get(j);
        localObject2 = (MaskImageView)this.contentView.findViewById(this.pmp[j]);
        ViewGroup.LayoutParams localLayoutParams = ((MaskImageView)localObject2).getLayoutParams();
        ((MaskImageView)localObject2).setTag(this);
        if (((awd)localObject1).hQR != 2) {
          break label808;
        }
        localg = af.bDC();
        m = hashCode();
        localaz = az.cvc();
        localaz.time = this.plP.mPL;
        localg.a((awd)localObject1, (View)localObject2, -1, m, localaz, 3);
        ((MaskImageView)localObject2).setScaleType(QImageView.a.wkS);
        localLayoutParams.width = k;
        localLayoutParams.height = k;
        if ((i != j) || (((awd)localObject1).hQR != 2)) {
          break label852;
        }
        ((MaskImageView)localObject2).setVisibility(0);
        ((MaskImageView)localObject2).setOnClickListener(new d.3(this, i));
        if ((((awd)localObject1).hQR == 6) && (i == j))
        {
          if (i <= 0) {
            break label868;
          }
          bool1 = true;
          l1 = this.oUH.field_snsId;
          localObject2 = this.plQ.oTG.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = k;
          ((ViewGroup.LayoutParams)localObject2).height = k;
          this.plQ.ogP.dL(k, k);
          this.plQ.oTG.setVisibility(0);
          af.bDC().a(this.oUH, (awd)localObject1, this.plQ.ogP, this.context.hashCode(), 0, az.uBJ, this.oUH.yr(32), true);
          this.plQ.oTK = true;
          this.plQ.oTL = j;
          this.plQ.oTF = this.plP;
          this.plQ.position = 0;
          this.plQ.bJQ = this.oUH.bGE();
          this.plQ.oTH.setOnClickListener(new d.4(this, bool1));
          this.plQ.ogP.setOnCompletionListener(new com.tencent.mm.plugin.sight.decode.a.b.e()
          {
            public final void d(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
            {
              if (paramAnonymousInt != -1) {
                d.this.oWw.q(l1, this.oli);
              }
            }
          });
          if (this.oWw != null)
          {
            if (this.oWw.fG(j + l1)) {
              break label874;
            }
            this.plQ.ogP.setOnDecodeDurationListener(new b.f()
            {
              public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
              {
                int i = (int)paramAnonymousb.bBe();
                if (d.this.oWw != null)
                {
                  d.this.oWw.b(l1, bk.UZ(), j);
                  d.this.oWw.d(l1, i, j);
                  d.this.oWw.G(l1, l1 + this.val$index);
                }
                d.this.plQ.ogP.setOnDecodeDurationListener(null);
              }
            });
          }
          this.plQ.a(this.plP, 0, this.oUH.bGE(), this.oUH.yr(32));
          this.plQ.oGU.setVisibility(8);
          localObject2 = af.bDC();
          long l2 = System.nanoTime();
          bool2 = com.tencent.mm.plugin.sns.model.g.t((awd)localObject1);
          y.i("MicroMsg.TurnCardAdDetailItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l2) });
          if (bool2) {
            break label1095;
          }
          if (!((com.tencent.mm.plugin.sns.model.g)localObject2).w((awd)localObject1)) {
            break label891;
          }
          this.plQ.oGT.setVisibility(8);
          this.plQ.oTI.setVisibility(0);
          this.plQ.oTI.cJO();
          if (this.oWw != null)
          {
            localObject2 = an.eJ(af.getAccSnsPath(), ((awd)localObject1).lsK);
            localObject1 = i.j((awd)localObject1);
            if (!e.bK((String)localObject2 + (String)localObject1)) {
              break label1467;
            }
            this.oWw.r(this.oUH.field_snsId, true);
            label765:
            if (af.bDC().b(this.oUH, null) != 5) {
              break label1485;
            }
          }
        }
      }
      label1095:
      label1485:
      for (boolean bool2 = true;; bool2 = false)
      {
        this.oWw.a(l1, bool2, bool1);
        j += 1;
        break label134;
        i = 0;
        break;
        localg = af.bDC();
        m = hashCode();
        localaz = az.cvc();
        localaz.time = this.plP.mPL;
        localg.a((awd)localObject1, (View)localObject2, m, localaz);
        break label245;
        label852:
        ((MaskImageView)localObject2).setVisibility(8);
        ((MaskImageView)localObject2).setOnClickListener(null);
        break label299;
        label868:
        bool1 = false;
        break label321;
        label874:
        this.oWw.b(l1, bk.UZ(), bool1);
        break label560;
        label891:
        if (((com.tencent.mm.plugin.sns.model.g)localObject2).b(this.oUH, null) == 5)
        {
          ((com.tencent.mm.plugin.sns.model.g)localObject2).A((awd)localObject1);
          this.plQ.oGT.setVisibility(8);
          this.plQ.oTI.setVisibility(0);
          this.plQ.oTI.cJO();
          break label697;
        }
        if (((com.tencent.mm.plugin.sns.model.g)localObject2).x((awd)localObject1))
        {
          this.plQ.oTI.setVisibility(8);
          this.plQ.oGT.setImageResource(i.e.sight_chat_error);
          this.plQ.oGT.setVisibility(0);
          break label697;
        }
        ((com.tencent.mm.plugin.sns.model.g)localObject2).y((awd)localObject1);
        this.plQ.oGT.setVisibility(0);
        this.plQ.oTI.setVisibility(8);
        this.plQ.oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.context, i.i.shortvideo_play_btn));
        this.plQ.oGT.setContentDescription(this.context.getString(i.j.play_sight_desc));
        if (((com.tencent.mm.plugin.sns.model.g)localObject2).b(this.oUH, null) != 4) {
          break label697;
        }
        this.plQ.oGU.setVisibility(0);
        break label697;
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
            break label1465;
          }
          y.d("MicroMsg.TurnCardAdDetailItem", "play video error " + ((awd)localObject1).lsK + " " + ((awd)localObject1).kSC + " " + ((awd)localObject1).trP + " 0");
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
        break label697;
        this.oWw.r(this.oUH.field_snsId, false);
        break label765;
      }
    }
    label808:
  }
  
  public final void bKj()
  {
    int i;
    Object localObject1;
    long l;
    if (this.plP.tNr.sPJ.size() >= 2)
    {
      if (this.oUH.field_likeFlag != 1) {
        break label116;
      }
      i = 1;
      if ((this.oWw != null) && (((awd)this.plP.tNr.sPJ.get(i)).hQR == 6))
      {
        localObject1 = this.oWw;
        l = this.oUH.field_snsId;
        if (this.oUH.field_likeFlag != 1) {
          break label121;
        }
      }
    }
    label116:
    label121:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.sns.a.b.g)localObject1).t(l, bool);
      if (!this.pgy) {
        break label127;
      }
      y.i("MicroMsg.TurnCardAdDetailItem", "isPlayAnimation, return");
      return;
      i = 0;
      break;
    }
    label127:
    Object localObject2;
    Object localObject3;
    float f1;
    float f2;
    int k;
    if (this.oUH.field_likeFlag == 1)
    {
      i = 0;
      j = 1;
      localObject1 = (awd)this.plP.tNr.sPJ.get(j);
      localObject2 = (awd)this.plP.tNr.sPJ.get(i);
      localObject1 = a((awd)localObject1, j, false);
      localObject2 = a((awd)localObject2, i, true);
      j = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth();
      localObject3 = new int[2];
      this.contentView.getLocationOnScreen((int[])localObject3);
      f1 = j / 2 - localObject3[1];
      this.contentView.setPivotY(f1);
      this.contentView.setCameraDistance(8000.0F);
      f1 = this.contentView.getWidth() / 2.0F;
      f2 = this.contentView.getHeight() / 2.0F;
      if (this.oUH.field_likeFlag != 1) {
        break label394;
      }
      k = -90;
    }
    for (int j = 90;; j = -90)
    {
      localObject3 = new com.tencent.mm.plugin.sns.ui.widget.a(this.context, 0.0F, j, f1, f2, true);
      ((com.tencent.mm.plugin.sns.ui.widget.a)localObject3).setDuration(187L);
      ((com.tencent.mm.plugin.sns.ui.widget.a)localObject3).setInterpolator(new AccelerateInterpolator());
      ((com.tencent.mm.plugin.sns.ui.widget.a)localObject3).setAnimationListener(new d.2(this, (View)localObject2, (View)localObject1, i, k, f1, f2));
      this.contentView.startAnimation((Animation)localObject3);
      this.pgy = true;
      return;
      i = 1;
      j = 0;
      break;
      label394:
      k = 90;
    }
  }
  
  public final void f(View paramView1, View paramView2)
  {
    this.contentView = paramView1;
    this.oVY = paramView2;
    this.context = paramView1.getContext();
    int j = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.cb.a.fromDPToPix(this.context, 50) - this.context.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.context.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.context.getResources().getDimensionPixelSize(i.d.SmallPadding);
    paramView2 = (LinearLayout.LayoutParams)paramView1.getLayoutParams();
    paramView2.topMargin = this.context.getResources().getDimensionPixelOffset(i.d.MiddlePadding);
    paramView2.bottomMargin = 0;
    paramView2.width = j;
    paramView2.height = j;
    paramView1.setLayoutParams(paramView2);
    if ((paramView1.getParent() instanceof ViewGroup))
    {
      ((ViewGroup)paramView1.getParent()).setClipChildren(false);
      ((ViewGroup)paramView1.getParent()).setClipToPadding(false);
    }
    paramView2 = this.pmp;
    int k = paramView2.length;
    int i = 0;
    while (i < k)
    {
      MaskImageView localMaskImageView = (MaskImageView)paramView1.findViewById(paramView2[i]);
      localMaskImageView.setVisibility(8);
      localMaskImageView.setOnTouchListener(new d.1(this));
      i += 1;
    }
    paramView2 = paramView1.findViewById(this.pmq);
    paramView2.setBackground(null);
    paramView2.setVisibility(8);
    ((ViewGroup)paramView2).setClipChildren(false);
    this.plQ = new aj();
    this.plQ.oTH = paramView2;
    this.plQ.oTG = this.plQ.oTH;
    this.plQ.ogP = ((com.tencent.mm.plugin.sight.decode.a.a)this.plQ.oTH.findViewById(i.f.image));
    this.plQ.oGT = ((ImageView)this.plQ.oTH.findViewById(i.f.status_btn));
    this.plQ.oTI = ((MMPinProgressBtn)this.plQ.oTH.findViewById(i.f.progress));
    this.plQ.oTJ = ((TextView)this.plQ.oTH.findViewById(i.f.endtv));
    this.plQ.oGU = ((TextView)this.plQ.oTH.findViewById(i.f.errorTv));
    this.plQ.oTH.setTag(this);
    this.plQ.oTH.setOnClickListener(null);
    ((SightPlayImageView)this.plQ.ogP).ofL = true;
    ((SightPlayImageView)this.plQ.ogP).setScaleType(QImageView.a.wkS);
    this.plQ.ogP.dL(j, j);
    paramView1.setLayerType(2, null);
    this.pmo = paramView1.findViewById(i.f.text_area_top);
    this.pmn = paramView1.findViewById(i.f.text_area_bottom);
    yY(0);
  }
  
  final void yY(int paramInt)
  {
    if ((this.pmo == null) || (this.pmn == null)) {}
    int i;
    int j;
    int k;
    int m;
    Object localObject1;
    do
    {
      do
      {
        return;
        this.currentIndex = paramInt;
        this.pmo.setVisibility(8);
        this.pmn.setVisibility(8);
        ((TextView)this.contentView.findViewById(i.f.turn_media_type_title_0)).setText(null);
        ((TextView)this.contentView.findViewById(i.f.turn_media_type_title_1)).setText(null);
        ((TextView)this.contentView.findViewById(i.f.turn_media_type_subtitle_0)).setText(null);
        ((TextView)this.contentView.findViewById(i.f.turn_media_type_subtitle_1)).setText(null);
        localObject2 = new int[] { i.f.turn_media_type_title_1, i.f.turn_media_type_subtitle_1 };
        i = i.f.turn_media_type_title_0;
        j = i.f.turn_media_type_subtitle_0;
        k = i.f.turn_media_type_title_0;
        m = i.f.turn_media_type_subtitle_1;
        localObject1 = this.oUH.bFZ();
      } while ((((com.tencent.mm.plugin.sns.storage.b)localObject1).oBx == null) || (((com.tencent.mm.plugin.sns.storage.b)localObject1).oBx.oBQ == null) || (((com.tencent.mm.plugin.sns.storage.b)localObject1).oBx.oBQ.size() < 2));
      localObject1 = (b.h)((com.tencent.mm.plugin.sns.storage.b)localObject1).oBx.oBQ.get(paramInt);
    } while ((((b.h)localObject1).oBK < 0) || (((b.h)localObject1).oBK >= 3));
    paramInt = ((b.h)localObject1).oBK;
    Object localObject3 = new int[][] { localObject2, { i, j }, { k, m } }[paramInt];
    Object localObject2 = (TextView)this.contentView.findViewById(localObject3[0]);
    localObject3 = (TextView)this.contentView.findViewById(localObject3[1]);
    if (bk.bl(((b.h)localObject1).title))
    {
      ((TextView)localObject2).setVisibility(8);
      if (!bk.bl(((b.h)localObject1).desc)) {
        break label383;
      }
      ((TextView)localObject3).setVisibility(8);
    }
    for (;;)
    {
      ((View)((TextView)localObject2).getParent()).setVisibility(0);
      ((View)((TextView)localObject3).getParent()).setVisibility(0);
      return;
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setText(((b.h)localObject1).title);
      break;
      label383:
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setText(((b.h)localObject1).desc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.d
 * JD-Core Version:    0.7.0.1
 */