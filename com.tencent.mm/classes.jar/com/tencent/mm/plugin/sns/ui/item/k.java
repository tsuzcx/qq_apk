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
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.b.i;
import com.tencent.mm.plugin.sns.storage.b.l;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends BaseTimeLineItem
{
  private static int[] xPZ = { 2131306089, 2131306090 };
  private static int[] xSC = { 2131306091 };
  private static int[][] xSD;
  public int mScreenHeight = 0;
  private int mScreenWidth = 0;
  private int xSB = 0;
  
  static
  {
    int[] arrayOfInt = { 2131306094, 2131306093 };
    xSD = new int[][] { { 2131306095, 2131306093 }, { 2131306094, 2131306092 }, arrayOfInt };
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(100119);
    parama.xSK.qXs.setVisibility(8);
    parama.xSK.xPg.setVisibility(8);
    ((TextView)parama.xSK.xSM.findViewById(2131306094)).setText(null);
    ((TextView)parama.xSK.xSM.findViewById(2131306095)).setText(null);
    ((TextView)parama.xSK.xSM.findViewById(2131306092)).setText(null);
    ((TextView)parama.xSK.xSM.findViewById(2131306093)).setText(null);
    Object localObject = parama.wwP.dxs();
    TextView localTextView;
    if ((((com.tencent.mm.plugin.sns.storage.b)localObject).wTC != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject).wTC.wUE != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject).wTC.wUE.size() >= 2))
    {
      localObject = (b.l)((com.tencent.mm.plugin.sns.storage.b)localObject).wTC.wUE.get(parama.index);
      if ((((b.l)localObject).wUk >= 0) && (((b.l)localObject).wUk < xSD.length))
      {
        int[] arrayOfInt = xSD[localObject.wUk];
        localTextView = (TextView)parama.xSK.xSM.findViewById(arrayOfInt[0]);
        parama = (TextView)parama.xSK.xSM.findViewById(arrayOfInt[1]);
        if (!bt.isNullOrNil(((b.l)localObject).title)) {
          break label287;
        }
        localTextView.setVisibility(8);
        if (!bt.isNullOrNil(((b.l)localObject).desc)) {
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
      localTextView.setText(((b.l)localObject).title);
      break;
      label303:
      parama.setVisibility(0);
      parama.setText(((b.l)localObject).desc);
    }
  }
  
  public static View w(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100118);
    if (paramInt2 == 6)
    {
      paramView = paramView.findViewById(xSC[0]);
      AppMethodBeat.o(100118);
      return paramView;
    }
    paramView = paramView.findViewById(xPZ[paramInt1]);
    AppMethodBeat.o(100118);
    return paramView;
  }
  
  @TargetApi(16)
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bf parambf, TimeLineObject paramTimeLineObject, final int paramInt2, final be parambe)
  {
    AppMethodBeat.i(100117);
    ad.i("MiroMsg.TurnMediaTimeLineItem", "fill turn card ad item %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramBaseViewHolder.fUH)
    {
      ad.i("MiroMsg.TurnMediaTimeLineItem", "holder is busy");
      AppMethodBeat.o(100117);
      return;
    }
    final b localb = (b)paramBaseViewHolder;
    localb.xSM.setTag(localb);
    localb.xSM.setVisibility(0);
    Object localObject1 = (b)localb;
    Object localObject2 = xPZ;
    int j = localObject2.length;
    final int i = 0;
    int k;
    Object localObject3;
    while (i < j)
    {
      k = localObject2[i];
      localObject3 = ((b)localObject1).xSM.findViewById(k);
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(8);
      }
      if ((localObject3 instanceof MaskImageView)) {
        ((MaskImageView)localObject3).setScaleType(QImageView.a.HBy);
      }
      i += 1;
    }
    localObject2 = xSC;
    j = localObject2.length;
    i = 0;
    while (i < j)
    {
      k = localObject2[i];
      localObject3 = ((b)localObject1).xSM.findViewById(k);
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
    localObject1 = new LinearLayout.LayoutParams(((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 54) - this.mActivity.getResources().getDimensionPixelSize(2131165490) - this.mActivity.getResources().getDimensionPixelSize(2131165516) - this.mActivity.getResources().getDimensionPixelSize(2131165568), -2);
    paramBaseViewHolder.xQv.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    label398:
    bpi localbpi;
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
    if ((parambf.xkI) && (paramInt2 == 11)) {
      if ((paramTimeLineObject.Etm != null) && (paramTimeLineObject.Etm.DaC != null) && (paramTimeLineObject.Etm.DaC.size() >= 2)) {
        if (localb.xQo == 1)
        {
          paramInt2 = 1;
          localObject2 = null;
          localObject1 = null;
          i = 0;
          if (i >= Math.min(paramTimeLineObject.Etm.DaC.size(), 2)) {
            break label1939;
          }
          localbpi = (bpi)paramTimeLineObject.Etm.DaC.get(i);
          localView = w(localb.xSM, i, 2);
          localView.setVisibility(4);
          if (localView == null) {
            break label2046;
          }
          localView.setTag(paramBaseViewHolder);
          localView.setOnClickListener(parambe.wMy.xUd);
          if (localbpi.mBH != 2) {
            break label1289;
          }
          localObject3 = af.dtr();
          j = this.mActivity.hashCode();
          localObject4 = bc.eLG();
          ((bc)localObject4).tGD = paramTimeLineObject.CreateTime;
          ((f)localObject3).a(localbpi, localView, -1, j, (bc)localObject4, 3);
          localObject4 = null;
          localObject3 = localObject4;
          if (localbpi.mBH == 6)
          {
            localObject3 = localObject4;
            if (paramInt2 == i)
            {
              if (paramInt2 <= 0) {
                break label1334;
              }
              bool1 = true;
              l = parambf.xIc;
              localObject5 = localb.xSP;
              localObject4 = parambf.wvM;
              localObject3 = ((com.tencent.mm.plugin.sns.ui.an)localObject5).xsm;
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).xsl = paramTimeLineObject;
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).xsn.setOnCompletionListener(new b.e()
              {
                public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
                {
                  AppMethodBeat.i(100109);
                  if (paramAnonymousInt != -1)
                  {
                    if ((parambe == null) || (parambe.xFq == null) || (parambe.xFq.xkX == null))
                    {
                      AppMethodBeat.o(100109);
                      return;
                    }
                    parambe.xFq.xkX.A(l, this.wxY);
                  }
                  AppMethodBeat.o(100109);
                }
              });
              if (parambe.xFq.xkX.sj(i + l)) {
                break label1340;
              }
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).xsn.setOnDecodeDurationListener(new b.f()
              {
                public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
                {
                  AppMethodBeat.i(100110);
                  if ((parambe == null) || (parambe.xFq == null) || (parambe.xFq.xkX == null))
                  {
                    AppMethodBeat.o(100110);
                    return;
                  }
                  if (paramAnonymousLong >= 3L)
                  {
                    int i = (int)paramAnonymousb.dqu();
                    parambe.xFq.xkX.d(l, bt.GC(), i);
                    parambe.xFq.xkX.e(l, i, i);
                    parambe.xFq.xkX.aj(l, l + this.hmM);
                    this.xSF.xsn.setOnDecodeDurationListener(null);
                  }
                  AppMethodBeat.o(100110);
                }
              });
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).a(paramTimeLineObject, paramInt1, parambf.xmu, parambf.xkI);
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).xbU.setVisibility(8);
              localObject6 = af.dtr();
              l = System.nanoTime();
              bool2 = f.t(localbpi);
              ad.i("MiroMsg.TurnMediaTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l) });
              if (bool2) {
                break label1563;
              }
              if (!((f)localObject6).w(localbpi)) {
                break label1385;
              }
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).xbT.setVisibility(8);
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).xsq.setVisibility(0);
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).xsq.feJ();
              label787:
              Object localObject7 = ((com.tencent.mm.plugin.sns.ui.an)localObject5).xsr.getLayoutParams();
              ((ViewGroup.LayoutParams)localObject7).width = this.xSB;
              ((ViewGroup.LayoutParams)localObject7).height = this.xSB;
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).xsr.setLayoutParams((ViewGroup.LayoutParams)localObject7);
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).xsn.setTagObject(localObject5);
              localObject7 = ((com.tencent.mm.plugin.sns.ui.an)localObject5).xsn;
              j = this.mActivity.hashCode();
              bc localbc = bc.eLG();
              localbc.tGD = paramTimeLineObject.CreateTime;
              ((f)localObject6).a((p)localObject4, localbpi, (VideoSightView)localObject7, j, paramInt1, localbc, parambf.xkI, true);
              ((f)localObject6).start();
              ((View)localObject3).setVisibility(0);
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).xsp.setTag(paramBaseViewHolder);
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).xsp.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(100111);
                  if (paramInt2 > 0) {
                    parambe.xFq.xkX.sl(localb.xQn);
                  }
                  parambe.wMy.xUd.onClick(paramAnonymousView);
                  AppMethodBeat.o(100111);
                }
              });
              localObject5 = com.tencent.mm.plugin.sns.model.an.iF(af.getAccSnsPath(), localbpi.Id);
              localObject6 = q.i(localbpi);
              if (!com.tencent.mm.vfs.i.eK((String)localObject5 + (String)localObject6)) {
                break label1904;
              }
              parambe.xFq.xkX.a(parambf.xIc, 0, true, bool1);
              label995:
              if (af.dtr().b((p)localObject4, null) != 5) {
                break label1926;
              }
              bool2 = true;
              label1011:
              parambe.xFq.xkX.e(parambf.xIc, bool2, bool1);
            }
          }
          localObject4 = localView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject4).width = this.xSB;
          ((ViewGroup.LayoutParams)localObject4).height = this.xSB;
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          if (localObject3 != null)
          {
            localObject4 = ((View)localObject3).getLayoutParams();
            ((ViewGroup.LayoutParams)localObject4).width = this.xSB;
            ((ViewGroup.LayoutParams)localObject4).height = this.xSB;
            ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          }
          if ((paramInt2 == i) && (localbpi.mBH == 2))
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
          ((a)localObject4).xSJ = localView;
          ((a)localObject4).xSK = localb;
          ((a)localObject4).wFd = localbpi;
          ((a)localObject4).wwP = parambf.wvM;
          if (localObject2 == null) {
            break label1932;
          }
          ((a)localObject2).xSL = ((a)localObject4);
          label1212:
          if (i == paramTimeLineObject.Etm.DaC.size() - 1) {
            ((a)localObject4).xSL = ((a)localObject1);
          }
          if (i == paramInt2)
          {
            localb.xSO = ((a)localObject4);
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
      ad.e("MiroMsg.TurnMediaTimeLineItem", "not enough medias!");
      AppMethodBeat.o(100117);
      return;
      localObject3 = af.dtr();
      j = this.mActivity.hashCode();
      localObject4 = bc.eLG();
      ((bc)localObject4).tGD = paramTimeLineObject.CreateTime;
      ((f)localObject3).a(localbpi, localView, j, (bc)localObject4);
      break label533;
      bool1 = false;
      break label569;
      if ((parambe == null) || (parambe.xFq == null) || (parambe.xFq.xkX == null)) {
        break label670;
      }
      parambe.xFq.xkX.d(l, bt.GC(), bool1);
      break label670;
      if (((f)localObject6).b((p)localObject4, null) == 5)
      {
        ((f)localObject6).A(localbpi);
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).xbT.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).xsq.setVisibility(0);
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).xsq.feJ();
        break label787;
      }
      if (((f)localObject6).x(localbpi))
      {
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).xsq.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).xbT.setImageResource(2131234034);
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).xbT.setVisibility(0);
        break label787;
      }
      ((f)localObject6).y(localbpi);
      ((com.tencent.mm.plugin.sns.ui.an)localObject5).xbT.setVisibility(0);
      ((com.tencent.mm.plugin.sns.ui.an)localObject5).xsq.setVisibility(8);
      ((com.tencent.mm.plugin.sns.ui.an)localObject5).xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.mActivity, 2131691166));
      ((com.tencent.mm.plugin.sns.ui.an)localObject5).xbT.setContentDescription(this.mActivity.getString(2131761939));
      if (((f)localObject6).b((p)localObject4, null) != 4) {
        break label787;
      }
      ((com.tencent.mm.plugin.sns.ui.an)localObject5).xbU.setVisibility(0);
      break label787;
      if (((f)localObject6).u(localbpi))
      {
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).xbT.setVisibility(0);
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).xsq.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.mActivity, 2131691166));
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).xbT.setContentDescription(this.mActivity.getString(2131761939));
      }
      for (;;)
      {
        if (!((com.tencent.mm.plugin.sns.ui.an)localObject5).xsn.wsq.dqr()) {
          break label1902;
        }
        ad.d("MiroMsg.TurnMediaTimeLineItem", "play video error " + localbpi.Id + " " + localbpi.Url + " " + localbpi.DMQ + " " + paramInt1);
        ((f)localObject6).y(localbpi);
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).xbT.setVisibility(0);
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).xsq.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.mActivity, 2131691166));
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).xbT.setContentDescription(this.mActivity.getString(2131761939));
        break;
        if (((f)localObject6).v(localbpi))
        {
          ((com.tencent.mm.plugin.sns.ui.an)localObject5).xbT.setVisibility(8);
          ((com.tencent.mm.plugin.sns.ui.an)localObject5).xsq.setVisibility(8);
        }
        else if (((f)localObject6).b((p)localObject4, null) <= 5)
        {
          ((com.tencent.mm.plugin.sns.ui.an)localObject5).xbT.setVisibility(8);
          ((com.tencent.mm.plugin.sns.ui.an)localObject5).xsq.setVisibility(8);
        }
        else
        {
          ((f)localObject6).y(localbpi);
          ((com.tencent.mm.plugin.sns.ui.an)localObject5).xbT.setVisibility(0);
          ((com.tencent.mm.plugin.sns.ui.an)localObject5).xsq.setVisibility(8);
          ((com.tencent.mm.plugin.sns.ui.an)localObject5).xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.mActivity, 2131691166));
          ((com.tencent.mm.plugin.sns.ui.an)localObject5).xbT.setContentDescription(this.mActivity.getString(2131761939));
        }
      }
      break label787;
      parambe.xFq.xkX.a(parambf.xIc, 0, false, bool1);
      break label995;
      bool2 = false;
      break label1011;
      localObject1 = localObject4;
      break label1212;
      if ((localb.rLd != null) && ((localb.rLd instanceof FrameLayout))) {
        ((FrameLayout)localb.rLd).setClipChildren(false);
      }
      if (localb.xQv != null) {
        localb.xQv.setClipChildren(false);
      }
      if ((localb.xRp != null) && ((localb.xRp instanceof LinearLayout))) {
        ((LinearLayout)localb.xRp).setClipChildren(false);
      }
      localb.xSM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(100112);
          parambe.wMy.xUd.onClick(paramAnonymousView);
          if (paramInt2 > 0) {
            parambe.xFq.xkX.sl(localb.xQn);
          }
          AppMethodBeat.o(100112);
        }
      });
      AppMethodBeat.o(100117);
      return;
    }
  }
  
  public final void e(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100116);
    if (this.mActivity != null)
    {
      localObject1 = new DisplayMetrics();
      this.mActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
      this.mScreenWidth = ((DisplayMetrics)localObject1).widthPixels;
      this.mScreenHeight = ((DisplayMetrics)localObject1).heightPixels;
      this.xSB = (Math.min(this.mScreenWidth, this.mScreenHeight) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 54) - this.mActivity.getResources().getDimensionPixelSize(2131165490) - this.mActivity.getResources().getDimensionPixelSize(2131165516) - this.mActivity.getResources().getDimensionPixelSize(2131165568));
    }
    Object localObject1 = (b)paramBaseViewHolder;
    if ((((BaseTimeLineItem.BaseViewHolder)localObject1).xQw != null) && (!((b)localObject1).xSN))
    {
      ((BaseTimeLineItem.BaseViewHolder)localObject1).xQw.setLayoutResource(2131495614);
      if (!((b)localObject1).xSN)
      {
        ((b)localObject1).xSM = ((BaseTimeLineItem.BaseViewHolder)localObject1).xQw.inflate();
        ((b)localObject1).xSN = true;
      }
    }
    for (;;)
    {
      Object localObject2 = ((b)localObject1).xSM.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = this.xSB;
      ((ViewGroup.LayoutParams)localObject2).height = this.xSB;
      ((RoundedCornerFrameLayout)((b)localObject1).xSM).setRadius(8.0F);
      localObject2 = ((b)localObject1).xSP;
      ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsp = w(((b)localObject1).xSM, 0, 6);
      ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsm = ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsp;
      ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsn = ((VideoSightView)((com.tencent.mm.plugin.sns.ui.an)localObject2).xsp.findViewById(2131300914));
      paramBaseViewHolder.xOO.xsn.setMute(true);
      ((com.tencent.mm.plugin.sns.ui.an)localObject2).xbT = ((ImageView)((com.tencent.mm.plugin.sns.ui.an)localObject2).xsp.findViewById(2131305196));
      ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsq = ((MMPinProgressBtn)((com.tencent.mm.plugin.sns.ui.an)localObject2).xsp.findViewById(2131303515));
      ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsr = ((TextView)((com.tencent.mm.plugin.sns.ui.an)localObject2).xsp.findViewById(2131299492));
      ((com.tencent.mm.plugin.sns.ui.an)localObject2).xbU = ((TextView)((com.tencent.mm.plugin.sns.ui.an)localObject2).xsp.findViewById(2131299517));
      ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsn.wsy = true;
      ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsn.setScaleType(QImageView.a.HBy);
      ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsn.gW(this.xSB, this.xSB);
      ((b)localObject1).qXs = ((b)localObject1).xSM.findViewById(2131305720);
      ((b)localObject1).xPg = ((b)localObject1).xSM.findViewById(2131305719);
      AppMethodBeat.o(100116);
      return;
      if (!((b)localObject1).xSN)
      {
        ((b)localObject1).xSM = ((b)localObject1).rLd.findViewById(2131306088);
        ((b)localObject1).xSN = true;
      }
    }
  }
  
  public static final class a
  {
    public int index;
    public View view;
    public bpi wFd;
    public p wwP;
    public View xSJ;
    public k.b xSK;
    public a xSL;
  }
  
  public static class b
    extends BaseTimeLineItem.BaseViewHolder
  {
    public View qXs;
    public View xPg;
    public View xSM;
    public boolean xSN;
    public k.a xSO;
    public com.tencent.mm.plugin.sns.ui.an xSP;
    
    public b()
    {
      AppMethodBeat.i(100115);
      this.xSN = false;
      this.xSP = new com.tencent.mm.plugin.sns.ui.an();
      AppMethodBeat.o(100115);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.k
 * JD-Core Version:    0.7.0.1
 */