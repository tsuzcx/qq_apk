package com.tencent.mm.plugin.sns.ui.item;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.b.f;
import com.tencent.mm.plugin.sns.storage.b.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerRelativeLayout;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends BaseTimeLineItem
{
  private static int[] sgy = { 2131828155, 2131828156 };
  private static int[] siD = { 2131828157 };
  private static int[][] siE = { { 2131828162, 2131828163 }, { 2131828159, 2131828160 }, { 2131828159, 2131828163 } };
  public int mScreenHeight = 0;
  private int mScreenWidth = 0;
  private int siC = 0;
  
  private static void a(j.a parama)
  {
    AppMethodBeat.i(40165);
    parama.siK.sfT.setVisibility(8);
    parama.siK.sfU.setVisibility(8);
    ((TextView)parama.siK.siM.findViewById(2131828159)).setText(null);
    ((TextView)parama.siK.siM.findViewById(2131828162)).setText(null);
    ((TextView)parama.siK.siM.findViewById(2131828160)).setText(null);
    ((TextView)parama.siK.siM.findViewById(2131828163)).setText(null);
    Object localObject = parama.rMD.csb();
    TextView localTextView;
    if ((((com.tencent.mm.plugin.sns.storage.b)localObject).rqH != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject).rqH.rrj != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject).rqH.rrj.size() >= 2))
    {
      localObject = (b.i)((com.tencent.mm.plugin.sns.storage.b)localObject).rqH.rrj.get(parama.index);
      if ((((b.i)localObject).rqV >= 0) && (((b.i)localObject).rqV < siE.length))
      {
        int[] arrayOfInt = siE[localObject.rqV];
        localTextView = (TextView)parama.siK.siM.findViewById(arrayOfInt[0]);
        parama = (TextView)parama.siK.siM.findViewById(arrayOfInt[1]);
        if (!bo.isNullOrNil(((b.i)localObject).title)) {
          break label287;
        }
        localTextView.setVisibility(8);
        if (!bo.isNullOrNil(((b.i)localObject).desc)) {
          break label303;
        }
        parama.setVisibility(8);
      }
    }
    for (;;)
    {
      ((View)localTextView.getParent()).setVisibility(0);
      ((View)parama.getParent()).setVisibility(0);
      AppMethodBeat.o(40165);
      return;
      label287:
      localTextView.setVisibility(0);
      localTextView.setText(((b.i)localObject).title);
      break;
      label303:
      parama.setVisibility(0);
      parama.setText(((b.i)localObject).desc);
    }
  }
  
  public static View v(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40164);
    if (paramInt2 == 6)
    {
      paramView = paramView.findViewById(siD[0]);
      AppMethodBeat.o(40164);
      return paramView;
    }
    paramView = paramView.findViewById(sgy[paramInt1]);
    AppMethodBeat.o(40164);
    return paramView;
  }
  
  @TargetApi(16)
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, aw paramaw, TimeLineObject paramTimeLineObject, int paramInt2, av paramav)
  {
    AppMethodBeat.i(40163);
    ab.i("MiroMsg.TurnMediaTimeLineItem", "fill turn card ad item %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramBaseViewHolder.ezJ)
    {
      ab.i("MiroMsg.TurnMediaTimeLineItem", "holder is busy");
      AppMethodBeat.o(40163);
      return;
    }
    j.b localb = (j.b)paramBaseViewHolder;
    localb.siM.setTag(localb);
    localb.siM.setVisibility(0);
    localb.siM.setLayerType(2, null);
    Object localObject1 = (j.b)localb;
    Object localObject2 = sgy;
    int j = localObject2.length;
    int i = 0;
    int k;
    Object localObject3;
    while (i < j)
    {
      k = localObject2[i];
      localObject3 = ((j.b)localObject1).siM.findViewById(k);
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(8);
      }
      if ((localObject3 instanceof MaskImageView)) {
        ((MaskImageView)localObject3).setScaleType(QImageView.a.AED);
      }
      i += 1;
    }
    localObject2 = siD;
    j = localObject2.length;
    i = 0;
    while (i < j)
    {
      k = localObject2[i];
      localObject3 = ((j.b)localObject1).siM.findViewById(k);
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
    localObject1 = new LinearLayout.LayoutParams(((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 54) - this.mActivity.getResources().getDimensionPixelSize(2131427782) - this.mActivity.getResources().getDimensionPixelSize(2131427808) - this.mActivity.getResources().getDimensionPixelSize(2131427854), -2);
    paramBaseViewHolder.sgS.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    label406:
    bcs localbcs;
    View localView;
    Object localObject4;
    label541:
    boolean bool1;
    label577:
    long l;
    Object localObject5;
    label682:
    Object localObject6;
    boolean bool2;
    if ((paramaw.rEX) && (paramInt2 == 11)) {
      if ((paramTimeLineObject.xTS != null) && (paramTimeLineObject.xTS.wOa != null) && (paramTimeLineObject.xTS.wOa.size() >= 2)) {
        if (localb.sgL == 1)
        {
          paramInt2 = 1;
          localObject2 = null;
          localObject1 = null;
          i = 0;
          if (i >= Math.min(paramTimeLineObject.xTS.wOa.size(), 2)) {
            break label1947;
          }
          localbcs = (bcs)paramTimeLineObject.xTS.wOa.get(i);
          localView = v(localb.siM, i, 2);
          localView.setVisibility(4);
          if (localView == null) {
            break label2054;
          }
          localView.setTag(paramBaseViewHolder);
          localView.setOnClickListener(paramav.rks.sjX);
          if (localbcs.jKs != 2) {
            break label1298;
          }
          localObject3 = ag.cpc();
          j = this.mActivity.hashCode();
          localObject4 = az.dxB();
          ((az)localObject4).oLs = paramTimeLineObject.CreateTime;
          ((com.tencent.mm.plugin.sns.model.g)localObject3).a(localbcs, localView, -1, j, (az)localObject4, 3);
          localObject4 = null;
          localObject3 = localObject4;
          if (localbcs.jKs == 6)
          {
            localObject3 = localObject4;
            if (paramInt2 == i)
            {
              if (paramInt2 <= 0) {
                break label1343;
              }
              bool1 = true;
              l = paramaw.rZw;
              localObject5 = localb.siP;
              localObject4 = paramaw.qXp;
              localObject3 = ((aj)localObject5).rLD;
              ((aj)localObject5).rLC = paramTimeLineObject;
              ((aj)localObject5).qVe.setOnCompletionListener(new j.1(this, paramav, l, bool1));
              if (paramav.rWP.rFk.lj(i + l)) {
                break label1349;
              }
              ((aj)localObject5).qVe.setOnDecodeDurationListener(new j.2(this, paramav, l, bool1, i, (aj)localObject5));
              ((aj)localObject5).a(paramTimeLineObject, paramInt1, paramaw.rGx, paramaw.rEX);
              ((aj)localObject5).rwK.setVisibility(8);
              localObject6 = ag.cpc();
              l = System.nanoTime();
              bool2 = com.tencent.mm.plugin.sns.model.g.t(localbcs);
              ab.i("MiroMsg.TurnMediaTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l) });
              if (bool2) {
                break label1572;
              }
              if (!((com.tencent.mm.plugin.sns.model.g)localObject6).w(localbcs)) {
                break label1394;
              }
              ((aj)localObject5).rwJ.setVisibility(8);
              ((aj)localObject5).rLF.setVisibility(0);
              ((aj)localObject5).rLF.dOF();
              label799:
              Object localObject7 = ((aj)localObject5).rLG.getLayoutParams();
              ((ViewGroup.LayoutParams)localObject7).width = this.siC;
              ((ViewGroup.LayoutParams)localObject7).height = this.siC;
              ((aj)localObject5).rLG.setLayoutParams((ViewGroup.LayoutParams)localObject7);
              ((aj)localObject5).qVe.setTagObject(localObject5);
              localObject7 = ((aj)localObject5).qVe;
              j = this.mActivity.hashCode();
              az localaz = az.dxB();
              localaz.oLs = paramTimeLineObject.CreateTime;
              ((com.tencent.mm.plugin.sns.model.g)localObject6).a((n)localObject4, localbcs, (com.tencent.mm.plugin.sight.decode.a.a)localObject7, j, paramInt1, localaz, paramaw.rEX, true);
              ((View)localObject3).setVisibility(0);
              ((aj)localObject5).rLE.setTag(paramBaseViewHolder);
              ((aj)localObject5).rLE.setOnClickListener(new j.3(this, paramInt2, paramav, localb));
              localObject5 = ao.gl(ag.getAccSnsPath(), localbcs.Id);
              localObject6 = com.tencent.mm.plugin.sns.data.i.j(localbcs);
              if (!e.cN((String)localObject5 + (String)localObject6)) {
                break label1912;
              }
              paramav.rWP.rFk.a(paramaw.rZw, 0, true, bool1);
              label1004:
              if (ag.cpc().b((n)localObject4, null) != 5) {
                break label1934;
              }
              bool2 = true;
              label1020:
              paramav.rWP.rFk.c(paramaw.rZw, bool2, bool1);
            }
          }
          localObject4 = localView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject4).width = this.siC;
          ((ViewGroup.LayoutParams)localObject4).height = this.siC;
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          if (localObject3 != null)
          {
            localObject4 = ((View)localObject3).getLayoutParams();
            ((ViewGroup.LayoutParams)localObject4).width = this.siC;
            ((ViewGroup.LayoutParams)localObject4).height = this.siC;
            ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          }
          if ((paramInt2 == i) && (localbcs.jKs == 2))
          {
            localView.setVisibility(0);
            localView.setOnTouchListener(new j.4(this));
          }
          localObject4 = new j.a();
          ((j.a)localObject4).index = i;
          localObject5 = localObject3;
          if (localObject3 == null) {
            localObject5 = localView;
          }
          ((j.a)localObject4).view = ((View)localObject5);
          ((j.a)localObject4).siJ = localView;
          ((j.a)localObject4).siK = localb;
          ((j.a)localObject4).reH = localbcs;
          ((j.a)localObject4).rMD = paramaw.qXp;
          if (localObject2 == null) {
            break label1940;
          }
          ((j.a)localObject2).siL = ((j.a)localObject4);
          label1221:
          if (i == paramTimeLineObject.xTS.wOa.size() - 1) {
            ((j.a)localObject4).siL = ((j.a)localObject1);
          }
          if (i == paramInt2)
          {
            localb.siO = ((j.a)localObject4);
            a((j.a)localObject4);
          }
          localObject2 = localObject4;
        }
      }
    }
    label2054:
    for (;;)
    {
      i += 1;
      break label406;
      paramInt2 = 0;
      break;
      ab.e("MiroMsg.TurnMediaTimeLineItem", "not enough medias!");
      AppMethodBeat.o(40163);
      return;
      label1298:
      localObject3 = ag.cpc();
      j = this.mActivity.hashCode();
      localObject4 = az.dxB();
      ((az)localObject4).oLs = paramTimeLineObject.CreateTime;
      ((com.tencent.mm.plugin.sns.model.g)localObject3).a(localbcs, localView, j, (az)localObject4);
      break label541;
      label1343:
      bool1 = false;
      break label577;
      label1349:
      if ((paramav == null) || (paramav.rWP == null) || (paramav.rWP.rFk == null)) {
        break label682;
      }
      paramav.rWP.rFk.c(l, bo.yB(), bool1);
      break label682;
      label1394:
      if (((com.tencent.mm.plugin.sns.model.g)localObject6).b((n)localObject4, null) == 5)
      {
        ((com.tencent.mm.plugin.sns.model.g)localObject6).A(localbcs);
        ((aj)localObject5).rwJ.setVisibility(8);
        ((aj)localObject5).rLF.setVisibility(0);
        ((aj)localObject5).rLF.dOF();
        break label799;
      }
      if (((com.tencent.mm.plugin.sns.model.g)localObject6).x(localbcs))
      {
        ((aj)localObject5).rLF.setVisibility(8);
        ((aj)localObject5).rwJ.setImageResource(2130840321);
        ((aj)localObject5).rwJ.setVisibility(0);
        break label799;
      }
      ((com.tencent.mm.plugin.sns.model.g)localObject6).y(localbcs);
      ((aj)localObject5).rwJ.setVisibility(0);
      ((aj)localObject5).rLF.setVisibility(8);
      ((aj)localObject5).rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.mActivity, 2131231980));
      ((aj)localObject5).rwJ.setContentDescription(this.mActivity.getString(2131302100));
      if (((com.tencent.mm.plugin.sns.model.g)localObject6).b((n)localObject4, null) != 4) {
        break label799;
      }
      ((aj)localObject5).rwK.setVisibility(0);
      break label799;
      label1572:
      if (((com.tencent.mm.plugin.sns.model.g)localObject6).u(localbcs))
      {
        ((aj)localObject5).rwJ.setVisibility(0);
        ((aj)localObject5).rLF.setVisibility(8);
        ((aj)localObject5).rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.mActivity, 2131231980));
        ((aj)localObject5).rwJ.setContentDescription(this.mActivity.getString(2131302100));
      }
      for (;;)
      {
        if (!((aj)localObject5).qVe.cmy()) {
          break label1910;
        }
        ab.d("MiroMsg.TurnMediaTimeLineItem", "play video error " + localbcs.Id + " " + localbcs.Url + " " + localbcs.xrS + " " + paramInt1);
        ((com.tencent.mm.plugin.sns.model.g)localObject6).y(localbcs);
        ((aj)localObject5).rwJ.setVisibility(0);
        ((aj)localObject5).rLF.setVisibility(8);
        ((aj)localObject5).rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.mActivity, 2131231980));
        ((aj)localObject5).rwJ.setContentDescription(this.mActivity.getString(2131302100));
        break;
        if (((com.tencent.mm.plugin.sns.model.g)localObject6).v(localbcs))
        {
          ((aj)localObject5).rwJ.setVisibility(8);
          ((aj)localObject5).rLF.setVisibility(8);
        }
        else if (((com.tencent.mm.plugin.sns.model.g)localObject6).b((n)localObject4, null) <= 5)
        {
          ((aj)localObject5).rwJ.setVisibility(8);
          ((aj)localObject5).rLF.setVisibility(8);
        }
        else
        {
          ((com.tencent.mm.plugin.sns.model.g)localObject6).y(localbcs);
          ((aj)localObject5).rwJ.setVisibility(0);
          ((aj)localObject5).rLF.setVisibility(8);
          ((aj)localObject5).rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.mActivity, 2131231980));
          ((aj)localObject5).rwJ.setContentDescription(this.mActivity.getString(2131302100));
        }
      }
      label1910:
      break label799;
      label1912:
      paramav.rWP.rFk.a(paramaw.rZw, 0, false, bool1);
      break label1004;
      label1934:
      bool2 = false;
      break label1020;
      label1940:
      localObject1 = localObject4;
      break label1221;
      label1947:
      if ((localb.ngZ != null) && ((localb.ngZ instanceof FrameLayout))) {
        ((FrameLayout)localb.ngZ).setClipChildren(false);
      }
      if (localb.sgS != null) {
        localb.sgS.setClipChildren(false);
      }
      if ((localb.shK != null) && ((localb.shK instanceof LinearLayout))) {
        ((LinearLayout)localb.shK).setClipChildren(false);
      }
      localb.siM.setOnClickListener(new j.5(this, paramav, paramInt2, localb));
      AppMethodBeat.o(40163);
      return;
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(40162);
    Object localObject;
    if (this.mActivity != null)
    {
      localObject = new DisplayMetrics();
      this.mActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      this.mScreenWidth = ((DisplayMetrics)localObject).widthPixels;
      this.mScreenHeight = ((DisplayMetrics)localObject).heightPixels;
      this.siC = (Math.min(this.mScreenWidth, this.mScreenHeight) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 54) - this.mActivity.getResources().getDimensionPixelSize(2131427782) - this.mActivity.getResources().getDimensionPixelSize(2131427808) - this.mActivity.getResources().getDimensionPixelSize(2131427854));
    }
    paramBaseViewHolder = (j.b)paramBaseViewHolder;
    if ((paramBaseViewHolder.sgT != null) && (!paramBaseViewHolder.siN))
    {
      paramBaseViewHolder.sgT.setLayoutResource(2130970888);
      if (!paramBaseViewHolder.siN)
      {
        paramBaseViewHolder.siM = paramBaseViewHolder.sgT.inflate();
        paramBaseViewHolder.siN = true;
      }
    }
    for (;;)
    {
      localObject = paramBaseViewHolder.siM.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = this.siC;
      ((ViewGroup.LayoutParams)localObject).height = this.siC;
      ((RoundedCornerRelativeLayout)paramBaseViewHolder.siM).setRadius(8.0F);
      localObject = paramBaseViewHolder.siP;
      ((aj)localObject).rLE = v(paramBaseViewHolder.siM, 0, 6);
      ((aj)localObject).rLD = ((aj)localObject).rLE;
      ((aj)localObject).qVe = ((com.tencent.mm.plugin.sight.decode.a.a)((aj)localObject).rLE.findViewById(2131820629));
      ((aj)localObject).rwJ = ((ImageView)((aj)localObject).rLE.findViewById(2131820996));
      ((aj)localObject).rLF = ((MMPinProgressBtn)((aj)localObject).rLE.findViewById(2131821404));
      ((aj)localObject).rLG = ((TextView)((aj)localObject).rLE.findViewById(2131827795));
      ((aj)localObject).rwK = ((TextView)((aj)localObject).rLE.findViewById(2131827796));
      ((SightPlayImageView)((aj)localObject).qVe).qTZ = true;
      ((SightPlayImageView)((aj)localObject).qVe).setScaleType(QImageView.a.AED);
      ((aj)localObject).qVe.ft(this.siC, this.siC);
      paramBaseViewHolder.sfT = paramBaseViewHolder.siM.findViewById(2131828158);
      paramBaseViewHolder.sfU = paramBaseViewHolder.siM.findViewById(2131828161);
      AppMethodBeat.o(40162);
      return;
      if (!paramBaseViewHolder.siN)
      {
        paramBaseViewHolder.siM = paramBaseViewHolder.ngZ.findViewById(2131828154);
        paramBaseViewHolder.siN = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.j
 * JD-Core Version:    0.7.0.1
 */