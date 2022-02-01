package com.tencent.mm.plugin.sns.ui.item;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.b.j;
import com.tencent.mm.plugin.sns.storage.b.m;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends BaseTimeLineItem
{
  private static int[] AuF = { 2131306089, 2131306090 };
  private static int[] Axv = { 2131306091 };
  private static int[][] Axw;
  private int Axu = 0;
  public int mScreenHeight = 0;
  private int mScreenWidth = 0;
  
  static
  {
    int[] arrayOfInt1 = { 2131306094, 2131306092 };
    int[] arrayOfInt2 = { 2131306094, 2131306093 };
    Axw = new int[][] { { 2131306095, 2131306093 }, arrayOfInt1, arrayOfInt2 };
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(100119);
    parama.AxD.sUS.setVisibility(8);
    parama.AxD.AtN.setVisibility(8);
    ((TextView)parama.AxD.AxF.findViewById(2131306094)).setText(null);
    ((TextView)parama.AxD.AxF.findViewById(2131306095)).setText(null);
    ((TextView)parama.AxD.AxF.findViewById(2131306092)).setText(null);
    ((TextView)parama.AxD.AxF.findViewById(2131306093)).setText(null);
    Object localObject = parama.yXF.dRL();
    TextView localTextView;
    if ((((com.tencent.mm.plugin.sns.storage.b)localObject).zwo != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject).zwo.zxz != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject).zwo.zxz.size() >= 2))
    {
      localObject = (b.m)((com.tencent.mm.plugin.sns.storage.b)localObject).zwo.zxz.get(parama.index);
      if ((((b.m)localObject).zxf >= 0) && (((b.m)localObject).zxf < Axw.length))
      {
        int[] arrayOfInt = Axw[localObject.zxf];
        localTextView = (TextView)parama.AxD.AxF.findViewById(arrayOfInt[0]);
        parama = (TextView)parama.AxD.AxF.findViewById(arrayOfInt[1]);
        if (!bt.isNullOrNil(((b.m)localObject).title)) {
          break label287;
        }
        localTextView.setVisibility(8);
        if (!bt.isNullOrNil(((b.m)localObject).desc)) {
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
      localTextView.setText(((b.m)localObject).title);
      break;
      label303:
      parama.setVisibility(0);
      parama.setText(((b.m)localObject).desc);
    }
  }
  
  public static View x(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100118);
    if (paramInt2 == 6)
    {
      paramView = paramView.findViewById(Axv[0]);
      AppMethodBeat.o(100118);
      return paramView;
    }
    paramView = paramView.findViewById(AuF[paramInt1]);
    AppMethodBeat.o(100118);
    return paramView;
  }
  
  @TargetApi(16)
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bi parambi, TimeLineObject paramTimeLineObject, final int paramInt2, final bh parambh)
  {
    AppMethodBeat.i(100117);
    ad.i("MiroMsg.TurnMediaTimeLineItem", "fill turn card ad item %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramBaseViewHolder.grY)
    {
      ad.i("MiroMsg.TurnMediaTimeLineItem", "holder is busy");
      AppMethodBeat.o(100117);
      return;
    }
    final b localb = (b)paramBaseViewHolder;
    localb.AxF.setTag(localb);
    localb.AxF.setVisibility(0);
    Object localObject1 = (b)localb;
    Object localObject2 = AuF;
    int j = localObject2.length;
    final int i = 0;
    int k;
    Object localObject3;
    while (i < j)
    {
      k = localObject2[i];
      localObject3 = ((b)localObject1).AxF.findViewById(k);
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(8);
      }
      if ((localObject3 instanceof MaskImageView)) {
        ((MaskImageView)localObject3).setScaleType(QImageView.a.KTb);
      }
      i += 1;
    }
    localObject2 = Axv;
    j = localObject2.length;
    i = 0;
    while (i < j)
    {
      k = localObject2[i];
      localObject3 = ((b)localObject1).AxF.findViewById(k);
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
    localObject1 = new LinearLayout.LayoutParams(((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 54) - this.mActivity.getResources().getDimensionPixelSize(2131165490) - this.mActivity.getResources().getDimensionPixelSize(2131165516) - this.mActivity.getResources().getDimensionPixelSize(2131165568), -2);
    paramBaseViewHolder.Avb.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    label397:
    byn localbyn;
    View localView;
    Object localObject4;
    label532:
    boolean bool1;
    label568:
    final long l;
    Object localObject5;
    label669:
    Object localObject6;
    boolean bool2;
    if ((parambi.zOM) && (paramInt2 == 11)) {
      if ((paramTimeLineObject.HAT != null) && (paramTimeLineObject.HAT.GaQ != null) && (paramTimeLineObject.HAT.GaQ.size() >= 2)) {
        if (localb.AuU == 1)
        {
          paramInt2 = 1;
          localObject2 = null;
          localObject1 = null;
          i = 0;
          if (i >= Math.min(paramTimeLineObject.HAT.GaQ.size(), 2)) {
            break label1938;
          }
          localbyn = (byn)paramTimeLineObject.HAT.GaQ.get(i);
          localView = x(localb.AxF, i, 2);
          localView.setVisibility(4);
          if (localView == null) {
            break label2045;
          }
          localView.setTag(paramBaseViewHolder);
          localView.setOnClickListener(parambh.zpd.Azc);
          if (localbyn.nEf != 2) {
            break label1288;
          }
          localObject3 = ag.dUb();
          j = this.mActivity.hashCode();
          localObject4 = bj.frn();
          ((bj)localObject4).hbR = paramTimeLineObject.CreateTime;
          ((f)localObject3).a(localbyn, localView, -1, j, (bj)localObject4, 3);
          localObject4 = null;
          localObject3 = localObject4;
          if (localbyn.nEf == 6)
          {
            localObject3 = localObject4;
            if (paramInt2 == i)
            {
              if (paramInt2 <= 0) {
                break label1333;
              }
              bool1 = true;
              l = parambi.AmB;
              localObject5 = localb.AxI;
              localObject4 = parambi.yVM;
              localObject3 = ((aq)localObject5).zWx;
              ((aq)localObject5).zWw = paramTimeLineObject;
              ((aq)localObject5).zWy.setOnCompletionListener(new b.e()
              {
                public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
                {
                  AppMethodBeat.i(100109);
                  if (paramAnonymousInt != -1)
                  {
                    if ((parambh == null) || (parambh.AjE == null) || (parambh.AjE.zPb == null))
                    {
                      AppMethodBeat.o(100109);
                      return;
                    }
                    parambh.AjE.zPb.A(l, this.yYO);
                  }
                  AppMethodBeat.o(100109);
                }
              });
              if (parambh.AjE.zPb.zm(i + l)) {
                break label1339;
              }
              ((aq)localObject5).zWy.setOnDecodeDurationListener(new b.f()
              {
                public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
                {
                  AppMethodBeat.i(100110);
                  if ((parambh == null) || (parambh.AjE == null) || (parambh.AjE.zPb == null))
                  {
                    AppMethodBeat.o(100110);
                    return;
                  }
                  if (paramAnonymousLong >= 3L)
                  {
                    int i = (int)paramAnonymousb.dQg();
                    parambh.AjE.zPb.d(l, bt.HI(), i);
                    parambh.AjE.zPb.e(l, i, i);
                    parambh.AjE.zPb.aj(l, l + this.val$index);
                    this.Axy.zWy.setOnDecodeDurationListener(null);
                  }
                  AppMethodBeat.o(100110);
                }
              });
              ((aq)localObject5).a(paramTimeLineObject, paramInt1, parambi.zQD, parambi.zOM);
              ((aq)localObject5).zFE.setVisibility(8);
              localObject6 = ag.dUb();
              l = System.nanoTime();
              bool2 = f.t(localbyn);
              ad.i("MiroMsg.TurnMediaTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l) });
              if (bool2) {
                break label1562;
              }
              if (!((f)localObject6).w(localbyn)) {
                break label1384;
              }
              ((aq)localObject5).zFD.setVisibility(8);
              ((aq)localObject5).zWB.setVisibility(0);
              ((aq)localObject5).zWB.fLr();
              label786:
              Object localObject7 = ((aq)localObject5).zWC.getLayoutParams();
              ((ViewGroup.LayoutParams)localObject7).width = this.Axu;
              ((ViewGroup.LayoutParams)localObject7).height = this.Axu;
              ((aq)localObject5).zWC.setLayoutParams((ViewGroup.LayoutParams)localObject7);
              ((aq)localObject5).zWy.setTagObject(localObject5);
              localObject7 = ((aq)localObject5).zWy;
              j = this.mActivity.hashCode();
              bj localbj = bj.frn();
              localbj.hbR = paramTimeLineObject.CreateTime;
              ((f)localObject6).a((p)localObject4, localbyn, (VideoSightView)localObject7, j, paramInt1, localbj, parambi.zOM, true);
              ((f)localObject6).start();
              ((View)localObject3).setVisibility(0);
              ((aq)localObject5).zWA.setTag(paramBaseViewHolder);
              ((aq)localObject5).zWA.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(100111);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/TurnMediaTimeLineItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  if (paramInt2 > 0) {
                    parambh.AjE.zPb.zo(localb.AuT);
                  }
                  parambh.zpd.Azc.onClick(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/TurnMediaTimeLineItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(100111);
                }
              });
              localObject5 = ao.jo(ag.getAccSnsPath(), localbyn.Id);
              localObject6 = q.i(localbyn);
              if (!com.tencent.mm.vfs.i.fv((String)localObject5 + (String)localObject6)) {
                break label1903;
              }
              parambh.AjE.zPb.b(parambi.AmB, 0, true, bool1);
              label994:
              if (ag.dUb().b((p)localObject4, null) != 5) {
                break label1925;
              }
              bool2 = true;
              label1010:
              parambh.AjE.zPb.c(parambi.AmB, bool2, bool1);
            }
          }
          localObject4 = localView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject4).width = this.Axu;
          ((ViewGroup.LayoutParams)localObject4).height = this.Axu;
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          if (localObject3 != null)
          {
            localObject4 = ((View)localObject3).getLayoutParams();
            ((ViewGroup.LayoutParams)localObject4).width = this.Axu;
            ((ViewGroup.LayoutParams)localObject4).height = this.Axu;
            ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          }
          if ((paramInt2 == i) && (localbyn.nEf == 2))
          {
            localView.setVisibility(0);
            localView.setOnTouchListener(new m.4(this));
          }
          localObject4 = new a();
          ((a)localObject4).index = i;
          localObject5 = localObject3;
          if (localObject3 == null) {
            localObject5 = localView;
          }
          ((a)localObject4).view = ((View)localObject5);
          ((a)localObject4).AxC = localView;
          ((a)localObject4).AxD = localb;
          ((a)localObject4).zhs = localbyn;
          ((a)localObject4).yXF = parambi.yVM;
          if (localObject2 == null) {
            break label1931;
          }
          ((a)localObject2).AxE = ((a)localObject4);
          label1211:
          if (i == paramTimeLineObject.HAT.GaQ.size() - 1) {
            ((a)localObject4).AxE = ((a)localObject1);
          }
          if (i == paramInt2)
          {
            localb.AxH = ((a)localObject4);
            a((a)localObject4);
          }
          localObject2 = localObject4;
        }
      }
    }
    label1288:
    label1333:
    label1339:
    label1384:
    label1901:
    label1903:
    label2045:
    for (;;)
    {
      i += 1;
      break label397;
      paramInt2 = 0;
      break;
      ad.e("MiroMsg.TurnMediaTimeLineItem", "not enough medias!");
      AppMethodBeat.o(100117);
      return;
      localObject3 = ag.dUb();
      j = this.mActivity.hashCode();
      localObject4 = bj.frn();
      ((bj)localObject4).hbR = paramTimeLineObject.CreateTime;
      ((f)localObject3).a(localbyn, localView, j, (bj)localObject4);
      break label532;
      bool1 = false;
      break label568;
      if ((parambh == null) || (parambh.AjE == null) || (parambh.AjE.zPb == null)) {
        break label669;
      }
      parambh.AjE.zPb.d(l, bt.HI(), bool1);
      break label669;
      if (((f)localObject6).b((p)localObject4, null) == 5)
      {
        ((f)localObject6).A(localbyn);
        ((aq)localObject5).zFD.setVisibility(8);
        ((aq)localObject5).zWB.setVisibility(0);
        ((aq)localObject5).zWB.fLr();
        break label786;
      }
      if (((f)localObject6).x(localbyn))
      {
        ((aq)localObject5).zWB.setVisibility(8);
        ((aq)localObject5).zFD.setImageResource(2131691612);
        ((aq)localObject5).zFD.setVisibility(0);
        break label786;
      }
      ((f)localObject6).y(localbyn);
      ((aq)localObject5).zFD.setVisibility(0);
      ((aq)localObject5).zWB.setVisibility(8);
      ((aq)localObject5).zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
      ((aq)localObject5).zFD.setContentDescription(this.mActivity.getString(2131761939));
      if (((f)localObject6).b((p)localObject4, null) != 4) {
        break label786;
      }
      ((aq)localObject5).zFE.setVisibility(0);
      break label786;
      if (((f)localObject6).u(localbyn))
      {
        ((aq)localObject5).zFD.setVisibility(0);
        ((aq)localObject5).zWB.setVisibility(8);
        ((aq)localObject5).zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
        ((aq)localObject5).zFD.setContentDescription(this.mActivity.getString(2131761939));
      }
      for (;;)
      {
        if (!((aq)localObject5).zWy.ySq.dQd()) {
          break label1901;
        }
        ad.d("MiroMsg.TurnMediaTimeLineItem", "play video error " + localbyn.Id + " " + localbyn.Url + " " + localbyn.GSI + " " + paramInt1);
        ((f)localObject6).y(localbyn);
        ((aq)localObject5).zFD.setVisibility(0);
        ((aq)localObject5).zWB.setVisibility(8);
        ((aq)localObject5).zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
        ((aq)localObject5).zFD.setContentDescription(this.mActivity.getString(2131761939));
        break;
        if (((f)localObject6).v(localbyn))
        {
          ((aq)localObject5).zFD.setVisibility(8);
          ((aq)localObject5).zWB.setVisibility(8);
        }
        else if (((f)localObject6).b((p)localObject4, null) <= 5)
        {
          ((aq)localObject5).zFD.setVisibility(8);
          ((aq)localObject5).zWB.setVisibility(8);
        }
        else
        {
          ((f)localObject6).y(localbyn);
          ((aq)localObject5).zFD.setVisibility(0);
          ((aq)localObject5).zWB.setVisibility(8);
          ((aq)localObject5).zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
          ((aq)localObject5).zFD.setContentDescription(this.mActivity.getString(2131761939));
        }
      }
      break label786;
      parambh.AjE.zPb.b(parambi.AmB, 0, false, bool1);
      break label994;
      bool2 = false;
      break label1010;
      localObject1 = localObject4;
      break label1211;
      if ((localb.tPw != null) && ((localb.tPw instanceof FrameLayout))) {
        ((FrameLayout)localb.tPw).setClipChildren(false);
      }
      if (localb.Avb != null) {
        localb.Avb.setClipChildren(false);
      }
      if ((localb.AvV != null) && ((localb.AvV instanceof LinearLayout))) {
        ((LinearLayout)localb.AvV).setClipChildren(false);
      }
      localb.AxF.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(100112);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/TurnMediaTimeLineItem$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          parambh.zpd.Azc.onClick(paramAnonymousView);
          if (paramInt2 > 0) {
            parambh.AjE.zPb.zo(localb.AuT);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/TurnMediaTimeLineItem$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100112);
        }
      });
      AppMethodBeat.o(100117);
      return;
    }
  }
  
  public final void h(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100116);
    if (this.mActivity != null)
    {
      localObject1 = new DisplayMetrics();
      this.mActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
      this.mScreenWidth = ((DisplayMetrics)localObject1).widthPixels;
      this.mScreenHeight = ((DisplayMetrics)localObject1).heightPixels;
      this.Axu = (Math.min(this.mScreenWidth, this.mScreenHeight) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 54) - this.mActivity.getResources().getDimensionPixelSize(2131165490) - this.mActivity.getResources().getDimensionPixelSize(2131165516) - this.mActivity.getResources().getDimensionPixelSize(2131165568));
    }
    Object localObject1 = (b)paramBaseViewHolder;
    if ((((BaseTimeLineItem.BaseViewHolder)localObject1).Avc != null) && (!((b)localObject1).AxG))
    {
      ((BaseTimeLineItem.BaseViewHolder)localObject1).Avc.setLayoutResource(2131495614);
      if (!((b)localObject1).AxG)
      {
        ((b)localObject1).AxF = ((BaseTimeLineItem.BaseViewHolder)localObject1).Avc.inflate();
        ((b)localObject1).AxG = true;
      }
    }
    for (;;)
    {
      Object localObject2 = ((b)localObject1).AxF.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = this.Axu;
      ((ViewGroup.LayoutParams)localObject2).height = this.Axu;
      ((RoundedCornerFrameLayout)((b)localObject1).AxF).setRadius(8.0F);
      localObject2 = ((b)localObject1).AxI;
      ((aq)localObject2).zWA = x(((b)localObject1).AxF, 0, 6);
      ((aq)localObject2).zWx = ((aq)localObject2).zWA;
      ((aq)localObject2).zWy = ((VideoSightView)((aq)localObject2).zWA.findViewById(2131300914));
      paramBaseViewHolder.Atv.zWy.setMute(true);
      ((aq)localObject2).zFD = ((ImageView)((aq)localObject2).zWA.findViewById(2131305196));
      ((aq)localObject2).zWB = ((MMPinProgressBtn)((aq)localObject2).zWA.findViewById(2131303515));
      ((aq)localObject2).zWC = ((TextView)((aq)localObject2).zWA.findViewById(2131299492));
      ((aq)localObject2).zFE = ((TextView)((aq)localObject2).zWA.findViewById(2131299517));
      ((aq)localObject2).zWy.ySy = true;
      ((aq)localObject2).zWy.setScaleType(QImageView.a.KTb);
      ((aq)localObject2).zWy.hw(this.Axu, this.Axu);
      ((b)localObject1).sUS = ((b)localObject1).AxF.findViewById(2131305720);
      ((b)localObject1).AtN = ((b)localObject1).AxF.findViewById(2131305719);
      AppMethodBeat.o(100116);
      return;
      if (!((b)localObject1).AxG)
      {
        ((b)localObject1).AxF = ((b)localObject1).tPw.findViewById(2131306088);
        ((b)localObject1).AxG = true;
      }
    }
  }
  
  public static final class a
  {
    public View AxC;
    public m.b AxD;
    public a AxE;
    public int index;
    public View view;
    public p yXF;
    public byn zhs;
  }
  
  public static class b
    extends BaseTimeLineItem.BaseViewHolder
  {
    public View AtN;
    public View AxF;
    public boolean AxG;
    public m.a AxH;
    public aq AxI;
    public View sUS;
    
    public b()
    {
      AppMethodBeat.i(100115);
      this.AxG = false;
      this.AxI = new aq();
      AppMethodBeat.o(100115);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.m
 * JD-Core Version:    0.7.0.1
 */