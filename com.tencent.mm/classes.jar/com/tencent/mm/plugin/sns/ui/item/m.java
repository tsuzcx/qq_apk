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
import com.tencent.mm.plugin.sns.ad.e.j;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.b.k;
import com.tencent.mm.plugin.sns.storage.b.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.vfs.o;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends BaseTimeLineItem
{
  private static int[] ALV = { 2131306089, 2131306090 };
  private static int[] AOO = { 2131306091 };
  private static int[][] AOP = { { 2131306095, 2131306093 }, { 2131306094, 2131306092 }, { 2131306094, 2131306093 } };
  private int AON = 0;
  public int mScreenHeight = 0;
  private int mScreenWidth = 0;
  
  private static void a(a parama)
  {
    AppMethodBeat.i(100119);
    parama.AOW.tgh.setVisibility(8);
    parama.AOW.ALc.setVisibility(8);
    ((TextView)parama.AOW.AOY.findViewById(2131306094)).setText(null);
    ((TextView)parama.AOW.AOY.findViewById(2131306095)).setText(null);
    ((TextView)parama.AOW.AOY.findViewById(2131306092)).setText(null);
    ((TextView)parama.AOW.AOY.findViewById(2131306093)).setText(null);
    Object localObject = parama.znm.dVj();
    TextView localTextView;
    if ((((com.tencent.mm.plugin.sns.storage.b)localObject).zNJ != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject).zNJ.zOY != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject).zNJ.zOY.size() >= 2))
    {
      localObject = (b.o)((com.tencent.mm.plugin.sns.storage.b)localObject).zNJ.zOY.get(parama.index);
      if ((((b.o)localObject).zOE >= 0) && (((b.o)localObject).zOE < AOP.length))
      {
        int[] arrayOfInt = AOP[localObject.zOE];
        localTextView = (TextView)parama.AOW.AOY.findViewById(arrayOfInt[0]);
        parama = (TextView)parama.AOW.AOY.findViewById(arrayOfInt[1]);
        if (!bu.isNullOrNil(((b.o)localObject).title)) {
          break label287;
        }
        localTextView.setVisibility(8);
        if (!bu.isNullOrNil(((b.o)localObject).desc)) {
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
      localTextView.setText(((b.o)localObject).title);
      break;
      label303:
      parama.setVisibility(0);
      parama.setText(((b.o)localObject).desc);
    }
  }
  
  public static View w(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100118);
    if (paramInt2 == 6)
    {
      paramView = paramView.findViewById(AOO[0]);
      AppMethodBeat.o(100118);
      return paramView;
    }
    paramView = paramView.findViewById(ALV[paramInt1]);
    AppMethodBeat.o(100118);
    return paramView;
  }
  
  @TargetApi(16)
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bi parambi, TimeLineObject paramTimeLineObject, final int paramInt2, final bh parambh)
  {
    AppMethodBeat.i(100117);
    ae.i("MiroMsg.TurnMediaTimeLineItem", "fill turn card ad item %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramBaseViewHolder.guz)
    {
      ae.i("MiroMsg.TurnMediaTimeLineItem", "holder is busy");
      AppMethodBeat.o(100117);
      return;
    }
    final b localb = (b)paramBaseViewHolder;
    localb.AOY.setTag(localb);
    localb.AOY.setVisibility(0);
    Object localObject1 = (b)localb;
    Object localObject2 = ALV;
    int j = localObject2.length;
    final int i = 0;
    int k;
    Object localObject3;
    while (i < j)
    {
      k = localObject2[i];
      localObject3 = ((b)localObject1).AOY.findViewById(k);
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(8);
      }
      if ((localObject3 instanceof MaskImageView)) {
        ((MaskImageView)localObject3).setScaleType(QImageView.a.Lpz);
      }
      i += 1;
    }
    localObject2 = AOO;
    j = localObject2.length;
    i = 0;
    while (i < j)
    {
      k = localObject2[i];
      localObject3 = ((b)localObject1).AOY.findViewById(k);
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
    localObject1 = new LinearLayout.LayoutParams(((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 54) - this.mActivity.getResources().getDimensionPixelSize(2131165490) - this.mActivity.getResources().getDimensionPixelSize(2131165516) - this.mActivity.getResources().getDimensionPixelSize(2131165568), -2);
    paramBaseViewHolder.AMr.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    label397:
    bzh localbzh;
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
    if ((parambi.AfT) && (paramInt2 == 11)) {
      if ((paramTimeLineObject.HUG != null) && (paramTimeLineObject.HUG.Gtx != null) && (paramTimeLineObject.HUG.Gtx.size() >= 2)) {
        if (localb.AMk == 1)
        {
          paramInt2 = 1;
          localObject2 = null;
          localObject1 = null;
          i = 0;
          if (i >= Math.min(paramTimeLineObject.HUG.Gtx.size(), 2)) {
            break label1938;
          }
          localbzh = (bzh)paramTimeLineObject.HUG.Gtx.get(i);
          localView = w(localb.AOY, i, 2);
          localView.setVisibility(4);
          if (localView == null) {
            break label2045;
          }
          localView.setTag(paramBaseViewHolder);
          localView.setOnClickListener(parambh.zGs.AQy);
          if (localbzh.nJA != 2) {
            break label1288;
          }
          localObject3 = ah.dXB();
          j = this.mActivity.hashCode();
          localObject4 = bk.fvn();
          ((bk)localObject4).heF = paramTimeLineObject.CreateTime;
          ((g)localObject3).a(localbzh, localView, -1, j, (bk)localObject4, 3);
          localObject4 = null;
          localObject3 = localObject4;
          if (localbzh.nJA == 6)
          {
            localObject3 = localObject4;
            if (paramInt2 == i)
            {
              if (paramInt2 <= 0) {
                break label1333;
              }
              bool1 = true;
              l = parambi.ADP;
              localObject5 = localb.APb;
              localObject4 = parambi.zlW;
              localObject3 = ((aq)localObject5).AnG;
              ((aq)localObject5).AnF = paramTimeLineObject;
              ((aq)localObject5).AnH.setOnCompletionListener(new b.e()
              {
                public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
                {
                  AppMethodBeat.i(100109);
                  if (paramAnonymousInt != -1)
                  {
                    if ((parambh == null) || (parambh.AAQ == null) || (parambh.AAQ.Agi == null))
                    {
                      AppMethodBeat.o(100109);
                      return;
                    }
                    parambh.AAQ.Agi.C(l, this.zpp);
                  }
                  AppMethodBeat.o(100109);
                }
              });
              if (parambh.AAQ.Agi.zL(i + l)) {
                break label1339;
              }
              ((aq)localObject5).AnH.setOnDecodeDurationListener(new b.f()
              {
                public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
                {
                  AppMethodBeat.i(100110);
                  if ((parambh == null) || (parambh.AAQ == null) || (parambh.AAQ.Agi == null))
                  {
                    AppMethodBeat.o(100110);
                    return;
                  }
                  if (paramAnonymousLong >= 3L)
                  {
                    int i = (int)paramAnonymousb.dTD();
                    parambh.AAQ.Agi.d(l, bu.HQ(), i);
                    parambh.AAQ.Agi.e(l, i, i);
                    parambh.AAQ.Agi.ai(l, l + this.val$index);
                    this.AOR.AnH.setOnDecodeDurationListener(null);
                  }
                  AppMethodBeat.o(100110);
                }
              });
              ((aq)localObject5).a(paramTimeLineObject, paramInt1, parambi.AhK, parambi.AfT);
              ((aq)localObject5).zWK.setVisibility(8);
              localObject6 = ah.dXB();
              l = System.nanoTime();
              bool2 = g.t(localbzh);
              ae.i("MiroMsg.TurnMediaTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l) });
              if (bool2) {
                break label1562;
              }
              if (!((g)localObject6).w(localbzh)) {
                break label1384;
              }
              ((aq)localObject5).zWJ.setVisibility(8);
              ((aq)localObject5).AnK.setVisibility(0);
              ((aq)localObject5).AnK.fPL();
              label786:
              Object localObject7 = ((aq)localObject5).AnL.getLayoutParams();
              ((ViewGroup.LayoutParams)localObject7).width = this.AON;
              ((ViewGroup.LayoutParams)localObject7).height = this.AON;
              ((aq)localObject5).AnL.setLayoutParams((ViewGroup.LayoutParams)localObject7);
              ((aq)localObject5).AnH.setTagObject(localObject5);
              localObject7 = ((aq)localObject5).AnH;
              j = this.mActivity.hashCode();
              bk localbk = bk.fvn();
              localbk.heF = paramTimeLineObject.CreateTime;
              ((g)localObject6).a((p)localObject4, localbzh, (VideoSightView)localObject7, j, paramInt1, localbk, parambi.AfT, true);
              ((g)localObject6).start();
              ((View)localObject3).setVisibility(0);
              ((aq)localObject5).AnJ.setTag(paramBaseViewHolder);
              ((aq)localObject5).AnJ.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(100111);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/TurnMediaTimeLineItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                  if (paramInt2 > 0) {
                    parambh.AAQ.Agi.zN(localb.AMj);
                  }
                  parambh.zGs.AQy.onClick(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/TurnMediaTimeLineItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(100111);
                }
              });
              localObject5 = ap.jv(ah.getAccSnsPath(), localbzh.Id);
              localObject6 = r.i(localbzh);
              if (!o.fB((String)localObject5 + (String)localObject6)) {
                break label1903;
              }
              parambh.AAQ.Agi.b(parambi.ADP, 0, true, bool1);
              label994:
              if (ah.dXB().b((p)localObject4, null) != 5) {
                break label1925;
              }
              bool2 = true;
              label1010:
              parambh.AAQ.Agi.c(parambi.ADP, bool2, bool1);
            }
          }
          localObject4 = localView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject4).width = this.AON;
          ((ViewGroup.LayoutParams)localObject4).height = this.AON;
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          if (localObject3 != null)
          {
            localObject4 = ((View)localObject3).getLayoutParams();
            ((ViewGroup.LayoutParams)localObject4).width = this.AON;
            ((ViewGroup.LayoutParams)localObject4).height = this.AON;
            ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          }
          if ((paramInt2 == i) && (localbzh.nJA == 2))
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
          ((a)localObject4).AOV = localView;
          ((a)localObject4).AOW = localb;
          ((a)localObject4).zyh = localbzh;
          ((a)localObject4).znm = parambi.zlW;
          if (localObject2 == null) {
            break label1931;
          }
          ((a)localObject2).AOX = ((a)localObject4);
          label1211:
          if (i == paramTimeLineObject.HUG.Gtx.size() - 1) {
            ((a)localObject4).AOX = ((a)localObject1);
          }
          if (i == paramInt2)
          {
            localb.APa = ((a)localObject4);
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
      ae.e("MiroMsg.TurnMediaTimeLineItem", "not enough medias!");
      AppMethodBeat.o(100117);
      return;
      localObject3 = ah.dXB();
      j = this.mActivity.hashCode();
      localObject4 = bk.fvn();
      ((bk)localObject4).heF = paramTimeLineObject.CreateTime;
      ((g)localObject3).a(localbzh, localView, j, (bk)localObject4);
      break label532;
      bool1 = false;
      break label568;
      if ((parambh == null) || (parambh.AAQ == null) || (parambh.AAQ.Agi == null)) {
        break label669;
      }
      parambh.AAQ.Agi.d(l, bu.HQ(), bool1);
      break label669;
      if (((g)localObject6).b((p)localObject4, null) == 5)
      {
        ((g)localObject6).A(localbzh);
        ((aq)localObject5).zWJ.setVisibility(8);
        ((aq)localObject5).AnK.setVisibility(0);
        ((aq)localObject5).AnK.fPL();
        break label786;
      }
      if (((g)localObject6).x(localbzh))
      {
        ((aq)localObject5).AnK.setVisibility(8);
        ((aq)localObject5).zWJ.setImageResource(2131691612);
        ((aq)localObject5).zWJ.setVisibility(0);
        break label786;
      }
      ((g)localObject6).y(localbzh);
      ((aq)localObject5).zWJ.setVisibility(0);
      ((aq)localObject5).AnK.setVisibility(8);
      ((aq)localObject5).zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691166));
      ((aq)localObject5).zWJ.setContentDescription(this.mActivity.getString(2131761939));
      if (((g)localObject6).b((p)localObject4, null) != 4) {
        break label786;
      }
      ((aq)localObject5).zWK.setVisibility(0);
      break label786;
      if (((g)localObject6).u(localbzh))
      {
        ((aq)localObject5).zWJ.setVisibility(0);
        ((aq)localObject5).AnK.setVisibility(8);
        ((aq)localObject5).zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691166));
        ((aq)localObject5).zWJ.setContentDescription(this.mActivity.getString(2131761939));
      }
      for (;;)
      {
        if (!((aq)localObject5).AnH.ziA.dTA()) {
          break label1901;
        }
        ae.d("MiroMsg.TurnMediaTimeLineItem", "play video error " + localbzh.Id + " " + localbzh.Url + " " + localbzh.Hmj + " " + paramInt1);
        ((g)localObject6).y(localbzh);
        ((aq)localObject5).zWJ.setVisibility(0);
        ((aq)localObject5).AnK.setVisibility(8);
        ((aq)localObject5).zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691166));
        ((aq)localObject5).zWJ.setContentDescription(this.mActivity.getString(2131761939));
        break;
        if (((g)localObject6).v(localbzh))
        {
          ((aq)localObject5).zWJ.setVisibility(8);
          ((aq)localObject5).AnK.setVisibility(8);
        }
        else if (((g)localObject6).b((p)localObject4, null) <= 5)
        {
          ((aq)localObject5).zWJ.setVisibility(8);
          ((aq)localObject5).AnK.setVisibility(8);
        }
        else
        {
          ((g)localObject6).y(localbzh);
          ((aq)localObject5).zWJ.setVisibility(0);
          ((aq)localObject5).AnK.setVisibility(8);
          ((aq)localObject5).zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691166));
          ((aq)localObject5).zWJ.setContentDescription(this.mActivity.getString(2131761939));
        }
      }
      break label786;
      parambh.AAQ.Agi.b(parambi.ADP, 0, false, bool1);
      break label994;
      bool2 = false;
      break label1010;
      localObject1 = localObject4;
      break label1211;
      if ((localb.uan != null) && ((localb.uan instanceof FrameLayout))) {
        ((FrameLayout)localb.uan).setClipChildren(false);
      }
      if (localb.AMr != null) {
        localb.AMr.setClipChildren(false);
      }
      if ((localb.ANm != null) && ((localb.ANm instanceof LinearLayout))) {
        ((LinearLayout)localb.ANm).setClipChildren(false);
      }
      localb.AOY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(100112);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/TurnMediaTimeLineItem$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          parambh.zGs.AQy.onClick(paramAnonymousView);
          if (paramInt2 > 0) {
            parambh.AAQ.Agi.zN(localb.AMj);
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
      this.AON = (Math.min(this.mScreenWidth, this.mScreenHeight) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 54) - this.mActivity.getResources().getDimensionPixelSize(2131165490) - this.mActivity.getResources().getDimensionPixelSize(2131165516) - this.mActivity.getResources().getDimensionPixelSize(2131165568));
    }
    Object localObject1 = (b)paramBaseViewHolder;
    if ((((BaseTimeLineItem.BaseViewHolder)localObject1).AMs != null) && (!((b)localObject1).AOZ))
    {
      ((BaseTimeLineItem.BaseViewHolder)localObject1).AMs.setLayoutResource(2131495614);
      if (!((b)localObject1).AOZ)
      {
        ((b)localObject1).AOY = ((BaseTimeLineItem.BaseViewHolder)localObject1).AMs.inflate();
        ((b)localObject1).AOZ = true;
      }
    }
    for (;;)
    {
      Object localObject2 = ((b)localObject1).AOY.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = this.AON;
      ((ViewGroup.LayoutParams)localObject2).height = this.AON;
      ((RoundedCornerFrameLayout)((b)localObject1).AOY).setRadius(8.0F);
      localObject2 = ((b)localObject1).APb;
      ((aq)localObject2).AnJ = w(((b)localObject1).AOY, 0, 6);
      ((aq)localObject2).AnG = ((aq)localObject2).AnJ;
      ((aq)localObject2).AnH = ((VideoSightView)((aq)localObject2).AnJ.findViewById(2131300914));
      paramBaseViewHolder.AKJ.AnH.setMute(true);
      ((aq)localObject2).zWJ = ((ImageView)((aq)localObject2).AnJ.findViewById(2131305196));
      ((aq)localObject2).AnK = ((MMPinProgressBtn)((aq)localObject2).AnJ.findViewById(2131303515));
      ((aq)localObject2).AnL = ((TextView)((aq)localObject2).AnJ.findViewById(2131299492));
      ((aq)localObject2).zWK = ((TextView)((aq)localObject2).AnJ.findViewById(2131299517));
      ((aq)localObject2).AnH.ziI = true;
      ((aq)localObject2).AnH.setScaleType(QImageView.a.Lpz);
      ((aq)localObject2).AnH.hy(this.AON, this.AON);
      ((b)localObject1).tgh = ((b)localObject1).AOY.findViewById(2131305720);
      ((b)localObject1).ALc = ((b)localObject1).AOY.findViewById(2131305719);
      AppMethodBeat.o(100116);
      return;
      if (!((b)localObject1).AOZ)
      {
        ((b)localObject1).AOY = ((b)localObject1).uan.findViewById(2131306088);
        ((b)localObject1).AOZ = true;
      }
    }
  }
  
  public static final class a
  {
    public View AOV;
    public m.b AOW;
    public a AOX;
    public int index;
    public View view;
    public p znm;
    public bzh zyh;
  }
  
  public static class b
    extends BaseTimeLineItem.BaseViewHolder
  {
    public View ALc;
    public View AOY;
    public boolean AOZ;
    public m.a APa;
    public aq APb;
    public View tgh;
    
    public b()
    {
      AppMethodBeat.i(100115);
      this.AOZ = false;
      this.APb = new aq();
      AppMethodBeat.o(100115);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.m
 * JD-Core Version:    0.7.0.1
 */