package com.tencent.mm.plugin.sns.ui.item;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.f.l;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.j;
import com.tencent.mm.plugin.sns.storage.ADXml.o;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;
import java.util.List;

public final class r
  extends BaseTimeLineItem
{
  private static int[] Lks = { i.f.turn_media_type_img_0, i.f.turn_media_type_img_1 };
  private static int[] LnN = { i.f.turn_media_type_sight_0 };
  private static int[][] LnO = { { i.f.turn_media_type_title_1, i.f.turn_media_type_subtitle_1 }, { i.f.turn_media_type_title_0, i.f.turn_media_type_subtitle_0 }, { i.f.turn_media_type_title_0, i.f.turn_media_type_subtitle_1 } };
  private int LnM = 0;
  public int mScreenHeight = 0;
  private int mScreenWidth = 0;
  
  private static void a(a parama)
  {
    AppMethodBeat.i(100119);
    parama.LnV.AZc.setVisibility(8);
    parama.LnV.JKr.setVisibility(8);
    ((TextView)parama.LnV.LnX.findViewById(i.f.turn_media_type_title_0)).setText(null);
    ((TextView)parama.LnV.LnX.findViewById(i.f.turn_media_type_title_1)).setText(null);
    ((TextView)parama.LnV.LnX.findViewById(i.f.turn_media_type_subtitle_0)).setText(null);
    ((TextView)parama.LnV.LnX.findViewById(i.f.turn_media_type_subtitle_1)).setText(null);
    Object localObject = parama.Jzk.getAdXml();
    TextView localTextView;
    if ((((ADXml)localObject).adTurnInfo != null) && (((ADXml)localObject).adTurnInfo.Kka != null) && (((ADXml)localObject).adTurnInfo.Kka.size() >= 2))
    {
      localObject = (ADXml.o)((ADXml)localObject).adTurnInfo.Kka.get(parama.index);
      if ((((ADXml.o)localObject).KjH >= 0) && (((ADXml.o)localObject).KjH < LnO.length))
      {
        int[] arrayOfInt = LnO[localObject.KjH];
        localTextView = (TextView)parama.LnV.LnX.findViewById(arrayOfInt[0]);
        parama = (TextView)parama.LnV.LnX.findViewById(arrayOfInt[1]);
        if (!Util.isNullOrNil(((ADXml.o)localObject).title)) {
          break label291;
        }
        localTextView.setVisibility(8);
        if (!Util.isNullOrNil(((ADXml.o)localObject).desc)) {
          break label307;
        }
        parama.setVisibility(8);
      }
    }
    for (;;)
    {
      ((View)localTextView.getParent()).setVisibility(0);
      ((View)parama.getParent()).setVisibility(0);
      AppMethodBeat.o(100119);
      return;
      label291:
      localTextView.setVisibility(0);
      localTextView.setText(((ADXml.o)localObject).title);
      break;
      label307:
      parama.setVisibility(0);
      parama.setText(((ADXml.o)localObject).desc);
    }
  }
  
  public static View y(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100118);
    if (paramInt2 == 6)
    {
      paramView = paramView.findViewById(LnN[0]);
      AppMethodBeat.o(100118);
      return paramView;
    }
    paramView = paramView.findViewById(Lks[paramInt1]);
    AppMethodBeat.o(100118);
    return paramView;
  }
  
  public final void a(ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(269049);
    if (this.mActivity != null)
    {
      paramViewStub = new DisplayMetrics();
      this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(paramViewStub);
      this.mScreenWidth = paramViewStub.widthPixels;
      this.mScreenHeight = paramViewStub.heightPixels;
      this.LnM = (Math.min(this.mScreenWidth, this.mScreenHeight) - com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 54) - this.mActivity.getResources().getDimensionPixelSize(i.d.LittlePadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.SmallPadding));
    }
    paramViewStub = (b)paramBaseViewHolder;
    if ((paramViewStub.LkR != null) && (!paramViewStub.LnY))
    {
      paramViewStub.LkR.setLayoutResource(i.g.sns_timeline_turn_media);
      if (!paramViewStub.LnY)
      {
        paramViewStub.LnX = paramViewStub.LkR.inflate();
        paramViewStub.LnY = true;
      }
    }
    for (;;)
    {
      Object localObject = paramViewStub.LnX.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = this.LnM;
      ((ViewGroup.LayoutParams)localObject).height = this.LnM;
      ((RoundedCornerFrameLayout)paramViewStub.LnX).setRadius(8.0F);
      localObject = paramViewStub.Loa;
      ((av)localObject).KKm = y(paramViewStub.LnX, 0, 6);
      ((av)localObject).KKj = ((av)localObject).KKm;
      ((av)localObject).KKk = ((VideoSightView)((av)localObject).KKm.findViewById(i.f.image));
      paramBaseViewHolder.JKG.KKk.setMute(true);
      ((av)localObject).JAL = ((ImageView)((av)localObject).KKm.findViewById(i.f.status_btn));
      ((av)localObject).KKn = ((MMPinProgressBtn)((av)localObject).KKm.findViewById(i.f.progress));
      ((av)localObject).KKo = ((TextView)((av)localObject).KKm.findViewById(i.f.endtv));
      ((av)localObject).Ktc = ((TextView)((av)localObject).KKm.findViewById(i.f.errorTv));
      ((av)localObject).KKk.Jte = true;
      ((av)localObject).KKk.setScaleType(QImageView.a.Ydm);
      ((av)localObject).KKk.ju(this.LnM, this.LnM);
      paramViewStub.AZc = paramViewStub.LnX.findViewById(i.f.text_area_top);
      paramViewStub.JKr = paramViewStub.LnX.findViewById(i.f.text_area_bottom);
      AppMethodBeat.o(269049);
      return;
      if (!paramViewStub.LnY)
      {
        paramViewStub.LnX = paramViewStub.convertView.findViewById(i.f.turn_media_container);
        paramViewStub.LnY = true;
      }
    }
  }
  
  @TargetApi(16)
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bn parambn, TimeLineObject paramTimeLineObject, final int paramInt2, final bm parambm)
  {
    AppMethodBeat.i(100117);
    Log.i("MiroMsg.TurnMediaTimeLineItem", "fill turn card ad item %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramBaseViewHolder.jTm)
    {
      Log.i("MiroMsg.TurnMediaTimeLineItem", "holder is busy");
      AppMethodBeat.o(100117);
      return;
    }
    final b localb = (b)paramBaseViewHolder;
    localb.LnX.setTag(localb);
    localb.LnX.setVisibility(0);
    Object localObject1 = (b)localb;
    Object localObject2 = Lks;
    int j = localObject2.length;
    final int i = 0;
    int k;
    Object localObject3;
    while (i < j)
    {
      k = localObject2[i];
      localObject3 = ((b)localObject1).LnX.findViewById(k);
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(8);
      }
      if ((localObject3 instanceof MaskImageView)) {
        ((MaskImageView)localObject3).setScaleType(QImageView.a.Ydm);
      }
      i += 1;
    }
    localObject2 = LnN;
    j = localObject2.length;
    i = 0;
    while (i < j)
    {
      k = localObject2[i];
      localObject3 = ((b)localObject1).LnX.findViewById(k);
      if (localObject3 != null)
      {
        ((View)localObject3).setBackground(null);
        ((View)localObject3).setVisibility(8);
        if ((localObject3 instanceof ViewGroup)) {
          ((ViewGroup)localObject3).setClipChildren(false);
        }
      }
      i += 1;
    }
    localObject1 = new LinearLayout.LayoutParams(((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 54) - this.mActivity.getResources().getDimensionPixelSize(i.d.LittlePadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.SmallPadding), -2);
    paramBaseViewHolder.LkQ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    label405:
    cvt localcvt;
    View localView;
    Object localObject4;
    label540:
    boolean bool1;
    label576:
    final long l;
    Object localObject5;
    label677:
    Object localObject6;
    boolean bool2;
    if ((parambn.KBz) && (paramInt2 == 11)) {
      if ((paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.Sqr != null) && (paramTimeLineObject.ContentObj.Sqr.size() >= 2)) {
        if (localb.LkJ == 1)
        {
          paramInt2 = 1;
          localObject2 = null;
          localObject1 = null;
          i = 0;
          if (i >= Math.min(paramTimeLineObject.ContentObj.Sqr.size(), 2)) {
            break label1950;
          }
          localcvt = (cvt)paramTimeLineObject.ContentObj.Sqr.get(i);
          localView = y(localb.LnX, i, 2);
          localView.setVisibility(4);
          if (localView == null) {
            break label2058;
          }
          localView.setTag(paramBaseViewHolder);
          localView.setOnClickListener(parambm.Kdz.LpB);
          if (localcvt.rWu != 2) {
            break label1299;
          }
          localObject3 = aj.fOF();
          j = this.mActivity.hashCode();
          localObject4 = bp.hzh();
          ((bp)localObject4).time = paramTimeLineObject.CreateTime;
          ((g)localObject3).a(localcvt, localView, -1, j, (bp)localObject4, 3);
          localObject4 = null;
          localObject3 = localObject4;
          if (localcvt.rWu == 6)
          {
            localObject3 = localObject4;
            if (paramInt2 == i)
            {
              if (paramInt2 <= 0) {
                break label1344;
              }
              bool1 = true;
              l = parambn.Lbm;
              localObject5 = localb.Loa;
              localObject4 = parambn.Jws;
              localObject3 = ((av)localObject5).KKj;
              ((av)localObject5).KKi = paramTimeLineObject;
              ((av)localObject5).KKk.setOnCompletionListener(new b.e()
              {
                public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
                {
                  AppMethodBeat.i(100109);
                  if (paramAnonymousInt != -1)
                  {
                    if ((parambm == null) || (parambm.KYo == null) || (parambm.KYo.KBN == null))
                    {
                      AppMethodBeat.o(100109);
                      return;
                    }
                    parambm.KYo.KBN.I(l, this.JEX);
                  }
                  AppMethodBeat.o(100109);
                }
              });
              if (parambm.KYo.KBN.Qj(i + l)) {
                break label1350;
              }
              ((av)localObject5).KKk.setOnDecodeDurationListener(new b.f()
              {
                public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
                {
                  AppMethodBeat.i(100110);
                  if ((parambm == null) || (parambm.KYo == null) || (parambm.KYo.KBN == null))
                  {
                    AppMethodBeat.o(100110);
                    return;
                  }
                  if (paramAnonymousLong >= 3L)
                  {
                    int i = (int)paramAnonymousb.fIF();
                    parambm.KYo.KBN.c(l, Util.currentTicks(), i);
                    parambm.KYo.KBN.e(l, i, i);
                    parambm.KYo.KBN.ay(l, l + this.val$index);
                    this.LnQ.KKk.setOnDecodeDurationListener(null);
                  }
                  AppMethodBeat.o(100110);
                }
              });
              ((av)localObject5).a(paramTimeLineObject, paramInt1, parambn.KDB, parambn.KBz);
              ((av)localObject5).Ktc.setVisibility(8);
              localObject6 = aj.fOF();
              l = System.nanoTime();
              bool2 = g.u(localcvt);
              Log.i("MiroMsg.TurnMediaTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l) });
              if (bool2) {
                break label1573;
              }
              if (!((g)localObject6).x(localcvt)) {
                break label1395;
              }
              ((av)localObject5).JAL.setVisibility(8);
              ((av)localObject5).KKn.setVisibility(0);
              ((av)localObject5).KKn.hZF();
              label795:
              Object localObject7 = ((av)localObject5).KKo.getLayoutParams();
              ((ViewGroup.LayoutParams)localObject7).width = this.LnM;
              ((ViewGroup.LayoutParams)localObject7).height = this.LnM;
              ((av)localObject5).KKo.setLayoutParams((ViewGroup.LayoutParams)localObject7);
              ((av)localObject5).KKk.setTagObject(localObject5);
              localObject7 = ((av)localObject5).KKk;
              j = this.mActivity.hashCode();
              bp localbp = bp.hzh();
              localbp.time = paramTimeLineObject.CreateTime;
              ((g)localObject6).a((SnsInfo)localObject4, localcvt, (VideoSightView)localObject7, j, paramInt1, localbp, parambn.KBz, true);
              ((g)localObject6).start();
              ((View)localObject3).setVisibility(0);
              ((av)localObject5).KKm.setTag(paramBaseViewHolder);
              ((av)localObject5).KKm.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(100111);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/item/TurnMediaTimeLineItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  if (paramInt2 > 0) {
                    parambm.KYo.KBN.Ql(localb.LkI);
                  }
                  parambm.Kdz.LpB.onClick(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/TurnMediaTimeLineItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(100111);
                }
              });
              localObject5 = aq.kD(aj.getAccSnsPath(), localcvt.Id);
              localObject6 = t.i(localcvt);
              if (!u.agG((String)localObject5 + (String)localObject6)) {
                break label1915;
              }
              parambm.KYo.KBN.b(parambn.Lbm, 0, true, bool1);
              label1003:
              if (aj.fOF().b((SnsInfo)localObject4, null) != 5) {
                break label1937;
              }
              bool2 = true;
              label1019:
              parambm.KYo.KBN.d(parambn.Lbm, bool2, bool1);
            }
          }
          localObject4 = localView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject4).width = this.LnM;
          ((ViewGroup.LayoutParams)localObject4).height = this.LnM;
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          if (localObject3 != null)
          {
            localObject4 = ((View)localObject3).getLayoutParams();
            ((ViewGroup.LayoutParams)localObject4).width = this.LnM;
            ((ViewGroup.LayoutParams)localObject4).height = this.LnM;
            ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          }
          if ((paramInt2 == i) && (localcvt.rWu == 2))
          {
            localView.setVisibility(0);
            localView.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                return false;
              }
            });
          }
          localObject4 = new a();
          ((a)localObject4).index = i;
          localObject5 = localObject3;
          if (localObject3 == null) {
            localObject5 = localView;
          }
          ((a)localObject4).view = ((View)localObject5);
          ((a)localObject4).LnU = localView;
          ((a)localObject4).LnV = localb;
          ((a)localObject4).JVq = localcvt;
          ((a)localObject4).Jzk = parambn.Jws;
          if (localObject2 == null) {
            break label1943;
          }
          ((a)localObject2).LnW = ((a)localObject4);
          label1220:
          if (i == paramTimeLineObject.ContentObj.Sqr.size() - 1) {
            ((a)localObject4).LnW = ((a)localObject1);
          }
          if (i == paramInt2)
          {
            localb.LnZ = ((a)localObject4);
            a((a)localObject4);
          }
          localObject2 = localObject4;
        }
      }
    }
    label2058:
    for (;;)
    {
      i += 1;
      break label405;
      paramInt2 = 0;
      break;
      Log.e("MiroMsg.TurnMediaTimeLineItem", "not enough medias!");
      AppMethodBeat.o(100117);
      return;
      label1299:
      localObject3 = aj.fOF();
      j = this.mActivity.hashCode();
      localObject4 = bp.hzh();
      ((bp)localObject4).time = paramTimeLineObject.CreateTime;
      ((g)localObject3).a(localcvt, localView, j, (bp)localObject4);
      break label540;
      label1344:
      bool1 = false;
      break label576;
      label1350:
      if ((parambm == null) || (parambm.KYo == null) || (parambm.KYo.KBN == null)) {
        break label677;
      }
      parambm.KYo.KBN.c(l, Util.currentTicks(), bool1);
      break label677;
      label1395:
      if (((g)localObject6).b((SnsInfo)localObject4, null) == 5)
      {
        ((g)localObject6).B(localcvt);
        ((av)localObject5).JAL.setVisibility(8);
        ((av)localObject5).KKn.setVisibility(0);
        ((av)localObject5).KKn.hZF();
        break label795;
      }
      if (((g)localObject6).y(localcvt))
      {
        ((av)localObject5).KKn.setVisibility(8);
        ((av)localObject5).JAL.setImageResource(i.i.shortvideo_play_icon_err);
        ((av)localObject5).JAL.setVisibility(0);
        break label795;
      }
      ((g)localObject6).z(localcvt);
      ((av)localObject5).JAL.setVisibility(0);
      ((av)localObject5).KKn.setVisibility(8);
      ((av)localObject5).JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mActivity, i.i.shortvideo_play_btn));
      ((av)localObject5).JAL.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
      if (((g)localObject6).b((SnsInfo)localObject4, null) != 4) {
        break label795;
      }
      ((av)localObject5).Ktc.setVisibility(0);
      break label795;
      label1573:
      if (((g)localObject6).v(localcvt))
      {
        ((av)localObject5).JAL.setVisibility(0);
        ((av)localObject5).KKn.setVisibility(8);
        ((av)localObject5).JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mActivity, i.i.shortvideo_play_btn));
        ((av)localObject5).JAL.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
      }
      for (;;)
      {
        if (!((av)localObject5).KKk.JsW.fIC()) {
          break label1913;
        }
        Log.d("MiroMsg.TurnMediaTimeLineItem", "play video error " + localcvt.Id + " " + localcvt.Url + " " + localcvt.TDF + " " + paramInt1);
        ((g)localObject6).z(localcvt);
        ((av)localObject5).JAL.setVisibility(0);
        ((av)localObject5).KKn.setVisibility(8);
        ((av)localObject5).JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mActivity, i.i.shortvideo_play_btn));
        ((av)localObject5).JAL.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
        break;
        if (((g)localObject6).w(localcvt))
        {
          ((av)localObject5).JAL.setVisibility(8);
          ((av)localObject5).KKn.setVisibility(8);
        }
        else if (((g)localObject6).b((SnsInfo)localObject4, null) <= 5)
        {
          ((av)localObject5).JAL.setVisibility(8);
          ((av)localObject5).KKn.setVisibility(8);
        }
        else
        {
          ((g)localObject6).z(localcvt);
          ((av)localObject5).JAL.setVisibility(0);
          ((av)localObject5).KKn.setVisibility(8);
          ((av)localObject5).JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mActivity, i.i.shortvideo_play_btn));
          ((av)localObject5).JAL.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
        }
      }
      label1913:
      break label795;
      label1915:
      parambm.KYo.KBN.b(parambn.Lbm, 0, false, bool1);
      break label1003;
      label1937:
      bool2 = false;
      break label1019;
      label1943:
      localObject1 = localObject4;
      break label1220;
      label1950:
      if ((localb.convertView != null) && ((localb.convertView instanceof FrameLayout))) {
        ((FrameLayout)localb.convertView).setClipChildren(false);
      }
      if (localb.LkQ != null) {
        localb.LkQ.setClipChildren(false);
      }
      if ((localb.LlK != null) && ((localb.LlK instanceof LinearLayout))) {
        ((LinearLayout)localb.LlK).setClipChildren(false);
      }
      localb.LnX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(100112);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/item/TurnMediaTimeLineItem$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          parambm.Kdz.LpB.onClick(paramAnonymousView);
          if (paramInt2 > 0) {
            parambm.KYo.KBN.Ql(localb.LkI);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/TurnMediaTimeLineItem$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100112);
        }
      });
      AppMethodBeat.o(100117);
      return;
    }
  }
  
  public static final class a
  {
    public cvt JVq;
    public SnsInfo Jzk;
    public View LnU;
    public r.b LnV;
    public a LnW;
    public int index;
    public View view;
  }
  
  public static class b
    extends BaseTimeLineItem.BaseViewHolder
  {
    public View AZc;
    public View JKr;
    public View LnX;
    public boolean LnY;
    public r.a LnZ;
    public av Loa;
    
    public b()
    {
      AppMethodBeat.i(100115);
      this.LnY = false;
      this.Loa = new av();
      AppMethodBeat.o(100115);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.r
 * JD-Core Version:    0.7.0.1
 */