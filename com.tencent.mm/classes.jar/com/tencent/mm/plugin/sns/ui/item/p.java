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
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.j;
import com.tencent.mm.plugin.sns.storage.ADXml.o;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;
import java.util.List;

public final class p
  extends BaseTimeLineItem
{
  private static int[] EWh = { 2131309432, 2131309433 };
  private static int[] EZt = { 2131309434 };
  private static int[][] EZu = { { 2131309438, 2131309436 }, { 2131309437, 2131309435 }, { 2131309437, 2131309436 } };
  private int EZs = 0;
  public int mScreenHeight = 0;
  private int mScreenWidth = 0;
  
  private static void a(a parama)
  {
    AppMethodBeat.i(100119);
    parama.EZB.wnX.setVisibility(8);
    parama.EZB.EVh.setVisibility(8);
    ((TextView)parama.EZB.EZD.findViewById(2131309437)).setText(null);
    ((TextView)parama.EZB.EZD.findViewById(2131309438)).setText(null);
    ((TextView)parama.EZB.EZD.findViewById(2131309435)).setText(null);
    ((TextView)parama.EZB.EZD.findViewById(2131309436)).setText(null);
    Object localObject = parama.DsC.getAdXml();
    TextView localTextView;
    if ((((ADXml)localObject).adTurnInfo != null) && (((ADXml)localObject).adTurnInfo.DWP != null) && (((ADXml)localObject).adTurnInfo.DWP.size() >= 2))
    {
      localObject = (ADXml.o)((ADXml)localObject).adTurnInfo.DWP.get(parama.index);
      if ((((ADXml.o)localObject).DWw >= 0) && (((ADXml.o)localObject).DWw < EZu.length))
      {
        int[] arrayOfInt = EZu[localObject.DWw];
        localTextView = (TextView)parama.EZB.EZD.findViewById(arrayOfInt[0]);
        parama = (TextView)parama.EZB.EZD.findViewById(arrayOfInt[1]);
        if (!Util.isNullOrNil(((ADXml.o)localObject).title)) {
          break label287;
        }
        localTextView.setVisibility(8);
        if (!Util.isNullOrNil(((ADXml.o)localObject).desc)) {
          break label303;
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
      label287:
      localTextView.setVisibility(0);
      localTextView.setText(((ADXml.o)localObject).title);
      break;
      label303:
      parama.setVisibility(0);
      parama.setText(((ADXml.o)localObject).desc);
    }
  }
  
  public static View w(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100118);
    if (paramInt2 == 6)
    {
      paramView = paramView.findViewById(EZt[0]);
      AppMethodBeat.o(100118);
      return paramView;
    }
    paramView = paramView.findViewById(EWh[paramInt1]);
    AppMethodBeat.o(100118);
    return paramView;
  }
  
  @TargetApi(16)
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bl parambl, TimeLineObject paramTimeLineObject, final int paramInt2, final bk parambk)
  {
    AppMethodBeat.i(100117);
    Log.i("MiroMsg.TurnMediaTimeLineItem", "fill turn card ad item %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramBaseViewHolder.hho)
    {
      Log.i("MiroMsg.TurnMediaTimeLineItem", "holder is busy");
      AppMethodBeat.o(100117);
      return;
    }
    final b localb = (b)paramBaseViewHolder;
    localb.EZD.setTag(localb);
    localb.EZD.setVisibility(0);
    Object localObject1 = (b)localb;
    Object localObject2 = EWh;
    int j = localObject2.length;
    final int i = 0;
    int k;
    Object localObject3;
    while (i < j)
    {
      k = localObject2[i];
      localObject3 = ((b)localObject1).EZD.findViewById(k);
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(8);
      }
      if ((localObject3 instanceof MaskImageView)) {
        ((MaskImageView)localObject3).setScaleType(QImageView.a.QEL);
      }
      i += 1;
    }
    localObject2 = EZt;
    j = localObject2.length;
    i = 0;
    while (i < j)
    {
      k = localObject2[i];
      localObject3 = ((b)localObject1).EZD.findViewById(k);
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
    localObject1 = new LinearLayout.LayoutParams(((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 54) - this.mActivity.getResources().getDimensionPixelSize(2131165508) - this.mActivity.getResources().getDimensionPixelSize(2131165534) - this.mActivity.getResources().getDimensionPixelSize(2131165586), -2);
    paramBaseViewHolder.EWC.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    label398:
    cnb localcnb;
    View localView;
    Object localObject4;
    label533:
    boolean bool1;
    label569:
    final long l;
    Object localObject5;
    label670:
    Object localObject6;
    boolean bool2;
    if ((parambl.Eoq) && (paramInt2 == 11)) {
      if ((paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.LoV != null) && (paramTimeLineObject.ContentObj.LoV.size() >= 2)) {
        if (localb.EWv == 1)
        {
          paramInt2 = 1;
          localObject2 = null;
          localObject1 = null;
          i = 0;
          if (i >= Math.min(paramTimeLineObject.ContentObj.LoV.size(), 2)) {
            break label1939;
          }
          localcnb = (cnb)paramTimeLineObject.ContentObj.LoV.get(i);
          localView = w(localb.EZD, i, 2);
          localView.setVisibility(4);
          if (localView == null) {
            break label2046;
          }
          localView.setTag(paramBaseViewHolder);
          localView.setOnClickListener(parambk.DQs.Fbd);
          if (localcnb.oUv != 2) {
            break label1289;
          }
          localObject3 = aj.faL();
          j = this.mActivity.hashCode();
          localObject4 = bp.gCU();
          ((bp)localObject4).hXs = paramTimeLineObject.CreateTime;
          ((g)localObject3).a(localcnb, localView, -1, j, (bp)localObject4, 3);
          localObject4 = null;
          localObject3 = localObject4;
          if (localcnb.oUv == 6)
          {
            localObject3 = localObject4;
            if (paramInt2 == i)
            {
              if (paramInt2 <= 0) {
                break label1334;
              }
              bool1 = true;
              l = parambl.ENp;
              localObject5 = localb.EZG;
              localObject4 = parambl.DqO;
              localObject3 = ((at)localObject5).Ewr;
              ((at)localObject5).Ewq = paramTimeLineObject;
              ((at)localObject5).Ews.setOnCompletionListener(new b.e()
              {
                public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
                {
                  AppMethodBeat.i(100109);
                  if (paramAnonymousInt != -1)
                  {
                    if ((parambk == null) || (parambk.EKl == null) || (parambk.EKl.EoE == null))
                    {
                      AppMethodBeat.o(100109);
                      return;
                    }
                    parambk.EKl.EoE.I(l, this.Dvz);
                  }
                  AppMethodBeat.o(100109);
                }
              });
              if (parambk.EKl.EoE.IQ(i + l)) {
                break label1340;
              }
              ((at)localObject5).Ews.setOnDecodeDurationListener(new b.f()
              {
                public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
                {
                  AppMethodBeat.i(100110);
                  if ((parambk == null) || (parambk.EKl == null) || (parambk.EKl.EoE == null))
                  {
                    AppMethodBeat.o(100110);
                    return;
                  }
                  if (paramAnonymousLong >= 3L)
                  {
                    int i = (int)paramAnonymousb.eVC();
                    parambk.EKl.EoE.c(l, Util.currentTicks(), i);
                    parambk.EKl.EoE.e(l, i, i);
                    parambk.EKl.EoE.an(l, l + this.val$index);
                    this.EZw.Ews.setOnDecodeDurationListener(null);
                  }
                  AppMethodBeat.o(100110);
                }
              });
              ((at)localObject5).a(paramTimeLineObject, paramInt1, parambl.Eql, parambl.Eoq);
              ((at)localObject5).EeT.setVisibility(8);
              localObject6 = aj.faL();
              l = System.nanoTime();
              bool2 = g.u(localcnb);
              Log.i("MiroMsg.TurnMediaTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l) });
              if (bool2) {
                break label1563;
              }
              if (!((g)localObject6).x(localcnb)) {
                break label1385;
              }
              ((at)localObject5).EeS.setVisibility(8);
              ((at)localObject5).Ewv.setVisibility(0);
              ((at)localObject5).Ewv.gYN();
              label787:
              Object localObject7 = ((at)localObject5).Eww.getLayoutParams();
              ((ViewGroup.LayoutParams)localObject7).width = this.EZs;
              ((ViewGroup.LayoutParams)localObject7).height = this.EZs;
              ((at)localObject5).Eww.setLayoutParams((ViewGroup.LayoutParams)localObject7);
              ((at)localObject5).Ews.setTagObject(localObject5);
              localObject7 = ((at)localObject5).Ews;
              j = this.mActivity.hashCode();
              bp localbp = bp.gCU();
              localbp.hXs = paramTimeLineObject.CreateTime;
              ((g)localObject6).a((SnsInfo)localObject4, localcnb, (VideoSightView)localObject7, j, paramInt1, localbp, parambl.Eoq, true);
              ((g)localObject6).start();
              ((View)localObject3).setVisibility(0);
              ((at)localObject5).Ewu.setTag(paramBaseViewHolder);
              ((at)localObject5).Ewu.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(100111);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/TurnMediaTimeLineItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  if (paramInt2 > 0) {
                    parambk.EKl.EoE.IS(localb.EWu);
                  }
                  parambk.DQs.Fbd.onClick(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/TurnMediaTimeLineItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(100111);
                }
              });
              localObject5 = ar.ki(aj.getAccSnsPath(), localcnb.Id);
              localObject6 = r.j(localcnb);
              if (!s.YS((String)localObject5 + (String)localObject6)) {
                break label1904;
              }
              parambk.EKl.EoE.b(parambl.ENp, 0, true, bool1);
              label995:
              if (aj.faL().b((SnsInfo)localObject4, null) != 5) {
                break label1926;
              }
              bool2 = true;
              label1011:
              parambk.EKl.EoE.d(parambl.ENp, bool2, bool1);
            }
          }
          localObject4 = localView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject4).width = this.EZs;
          ((ViewGroup.LayoutParams)localObject4).height = this.EZs;
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          if (localObject3 != null)
          {
            localObject4 = ((View)localObject3).getLayoutParams();
            ((ViewGroup.LayoutParams)localObject4).width = this.EZs;
            ((ViewGroup.LayoutParams)localObject4).height = this.EZs;
            ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          }
          if ((paramInt2 == i) && (localcnb.oUv == 2))
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
          ((a)localObject4).EZA = localView;
          ((a)localObject4).EZB = localb;
          ((a)localObject4).DIq = localcnb;
          ((a)localObject4).DsC = parambl.DqO;
          if (localObject2 == null) {
            break label1932;
          }
          ((a)localObject2).EZC = ((a)localObject4);
          label1212:
          if (i == paramTimeLineObject.ContentObj.LoV.size() - 1) {
            ((a)localObject4).EZC = ((a)localObject1);
          }
          if (i == paramInt2)
          {
            localb.EZF = ((a)localObject4);
            a((a)localObject4);
          }
          localObject2 = localObject4;
        }
      }
    }
    label1289:
    label1334:
    label1340:
    label1385:
    label1902:
    label1904:
    label2046:
    for (;;)
    {
      i += 1;
      break label398;
      paramInt2 = 0;
      break;
      Log.e("MiroMsg.TurnMediaTimeLineItem", "not enough medias!");
      AppMethodBeat.o(100117);
      return;
      localObject3 = aj.faL();
      j = this.mActivity.hashCode();
      localObject4 = bp.gCU();
      ((bp)localObject4).hXs = paramTimeLineObject.CreateTime;
      ((g)localObject3).a(localcnb, localView, j, (bp)localObject4);
      break label533;
      bool1 = false;
      break label569;
      if ((parambk == null) || (parambk.EKl == null) || (parambk.EKl.EoE == null)) {
        break label670;
      }
      parambk.EKl.EoE.c(l, Util.currentTicks(), bool1);
      break label670;
      if (((g)localObject6).b((SnsInfo)localObject4, null) == 5)
      {
        ((g)localObject6).B(localcnb);
        ((at)localObject5).EeS.setVisibility(8);
        ((at)localObject5).Ewv.setVisibility(0);
        ((at)localObject5).Ewv.gYN();
        break label787;
      }
      if (((g)localObject6).y(localcnb))
      {
        ((at)localObject5).Ewv.setVisibility(8);
        ((at)localObject5).EeS.setImageResource(2131691482);
        ((at)localObject5).EeS.setVisibility(0);
        break label787;
      }
      ((g)localObject6).z(localcnb);
      ((at)localObject5).EeS.setVisibility(0);
      ((at)localObject5).Ewv.setVisibility(8);
      ((at)localObject5).EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691480));
      ((at)localObject5).EeS.setContentDescription(this.mActivity.getString(2131763945));
      if (((g)localObject6).b((SnsInfo)localObject4, null) != 4) {
        break label787;
      }
      ((at)localObject5).EeT.setVisibility(0);
      break label787;
      if (((g)localObject6).v(localcnb))
      {
        ((at)localObject5).EeS.setVisibility(0);
        ((at)localObject5).Ewv.setVisibility(8);
        ((at)localObject5).EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691480));
        ((at)localObject5).EeS.setContentDescription(this.mActivity.getString(2131763945));
      }
      for (;;)
      {
        if (!((at)localObject5).Ews.Dnr.eVz()) {
          break label1902;
        }
        Log.d("MiroMsg.TurnMediaTimeLineItem", "play video error " + localcnb.Id + " " + localcnb.Url + " " + localcnb.Msz + " " + paramInt1);
        ((g)localObject6).z(localcnb);
        ((at)localObject5).EeS.setVisibility(0);
        ((at)localObject5).Ewv.setVisibility(8);
        ((at)localObject5).EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691480));
        ((at)localObject5).EeS.setContentDescription(this.mActivity.getString(2131763945));
        break;
        if (((g)localObject6).w(localcnb))
        {
          ((at)localObject5).EeS.setVisibility(8);
          ((at)localObject5).Ewv.setVisibility(8);
        }
        else if (((g)localObject6).b((SnsInfo)localObject4, null) <= 5)
        {
          ((at)localObject5).EeS.setVisibility(8);
          ((at)localObject5).Ewv.setVisibility(8);
        }
        else
        {
          ((g)localObject6).z(localcnb);
          ((at)localObject5).EeS.setVisibility(0);
          ((at)localObject5).Ewv.setVisibility(8);
          ((at)localObject5).EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691480));
          ((at)localObject5).EeS.setContentDescription(this.mActivity.getString(2131763945));
        }
      }
      break label787;
      parambk.EKl.EoE.b(parambl.ENp, 0, false, bool1);
      break label995;
      bool2 = false;
      break label1011;
      localObject1 = localObject4;
      break label1212;
      if ((localb.convertView != null) && ((localb.convertView instanceof FrameLayout))) {
        ((FrameLayout)localb.convertView).setClipChildren(false);
      }
      if (localb.EWC != null) {
        localb.EWC.setClipChildren(false);
      }
      if ((localb.EXw != null) && ((localb.EXw instanceof LinearLayout))) {
        ((LinearLayout)localb.EXw).setClipChildren(false);
      }
      localb.EZD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(100112);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/TurnMediaTimeLineItem$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          parambk.DQs.Fbd.onClick(paramAnonymousView);
          if (paramInt2 > 0) {
            parambk.EKl.EoE.IS(localb.EWu);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/TurnMediaTimeLineItem$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100112);
        }
      });
      AppMethodBeat.o(100117);
      return;
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100116);
    if (this.mActivity != null)
    {
      localObject1 = new DisplayMetrics();
      this.mActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
      this.mScreenWidth = ((DisplayMetrics)localObject1).widthPixels;
      this.mScreenHeight = ((DisplayMetrics)localObject1).heightPixels;
      this.EZs = (Math.min(this.mScreenWidth, this.mScreenHeight) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 54) - this.mActivity.getResources().getDimensionPixelSize(2131165508) - this.mActivity.getResources().getDimensionPixelSize(2131165534) - this.mActivity.getResources().getDimensionPixelSize(2131165586));
    }
    Object localObject1 = (b)paramBaseViewHolder;
    if ((((BaseTimeLineItem.BaseViewHolder)localObject1).EWD != null) && (!((b)localObject1).EZE))
    {
      ((BaseTimeLineItem.BaseViewHolder)localObject1).EWD.setLayoutResource(2131496513);
      if (!((b)localObject1).EZE)
      {
        ((b)localObject1).EZD = ((BaseTimeLineItem.BaseViewHolder)localObject1).EWD.inflate();
        ((b)localObject1).EZE = true;
      }
    }
    for (;;)
    {
      Object localObject2 = ((b)localObject1).EZD.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = this.EZs;
      ((ViewGroup.LayoutParams)localObject2).height = this.EZs;
      ((RoundedCornerFrameLayout)((b)localObject1).EZD).setRadius(8.0F);
      localObject2 = ((b)localObject1).EZG;
      ((at)localObject2).Ewu = w(((b)localObject1).EZD, 0, 6);
      ((at)localObject2).Ewr = ((at)localObject2).Ewu;
      ((at)localObject2).Ews = ((VideoSightView)((at)localObject2).Ewu.findViewById(2131302526));
      paramBaseViewHolder.EUK.Ews.setMute(true);
      ((at)localObject2).EeS = ((ImageView)((at)localObject2).Ewu.findViewById(2131308392));
      ((at)localObject2).Ewv = ((MMPinProgressBtn)((at)localObject2).Ewu.findViewById(2131306281));
      ((at)localObject2).Eww = ((TextView)((at)localObject2).Ewu.findViewById(2131300128));
      ((at)localObject2).EeT = ((TextView)((at)localObject2).Ewu.findViewById(2131300154));
      ((at)localObject2).Ews.Dnz = true;
      ((at)localObject2).Ews.setScaleType(QImageView.a.QEL);
      ((at)localObject2).Ews.im(this.EZs, this.EZs);
      ((b)localObject1).wnX = ((b)localObject1).EZD.findViewById(2131308987);
      ((b)localObject1).EVh = ((b)localObject1).EZD.findViewById(2131308986);
      AppMethodBeat.o(100116);
      return;
      if (!((b)localObject1).EZE)
      {
        ((b)localObject1).EZD = ((b)localObject1).convertView.findViewById(2131309431);
        ((b)localObject1).EZE = true;
      }
    }
  }
  
  public static final class a
  {
    public cnb DIq;
    public SnsInfo DsC;
    public View EZA;
    public p.b EZB;
    public a EZC;
    public int index;
    public View view;
  }
  
  public static class b
    extends BaseTimeLineItem.BaseViewHolder
  {
    public View EVh;
    public View EZD;
    public boolean EZE;
    public p.a EZF;
    public at EZG;
    public View wnX;
    
    public b()
    {
      AppMethodBeat.i(100115);
      this.EZE = false;
      this.EZG = new at();
      AppMethodBeat.o(100115);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.p
 * JD-Core Version:    0.7.0.1
 */