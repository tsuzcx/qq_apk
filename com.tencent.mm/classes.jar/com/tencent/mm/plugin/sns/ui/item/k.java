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
import com.tencent.mm.plugin.sns.storage.b.j;
import com.tencent.mm.plugin.sns.storage.b.m;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends BaseTimeLineItem
{
  private static int[] zcP = { 2131306089, 2131306090 };
  private static int[] zfx = { 2131306091 };
  private static int[][] zfy = { { 2131306095, 2131306093 }, { 2131306094, 2131306092 }, { 2131306094, 2131306093 } };
  public int mScreenHeight = 0;
  private int mScreenWidth = 0;
  private int zfw = 0;
  
  private static void a(a parama)
  {
    AppMethodBeat.i(100119);
    parama.zfF.rXY.setVisibility(8);
    parama.zfF.zbW.setVisibility(8);
    ((TextView)parama.zfF.zfH.findViewById(2131306094)).setText(null);
    ((TextView)parama.zfF.zfH.findViewById(2131306095)).setText(null);
    ((TextView)parama.zfF.zfH.findViewById(2131306092)).setText(null);
    ((TextView)parama.zfF.zfH.findViewById(2131306093)).setText(null);
    Object localObject = parama.xIq.dFR();
    TextView localTextView;
    if ((((com.tencent.mm.plugin.sns.storage.b)localObject).ygm != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject).ygm.yhs != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject).ygm.yhs.size() >= 2))
    {
      localObject = (b.m)((com.tencent.mm.plugin.sns.storage.b)localObject).ygm.yhs.get(parama.index);
      if ((((b.m)localObject).ygY >= 0) && (((b.m)localObject).ygY < zfy.length))
      {
        int[] arrayOfInt = zfy[localObject.ygY];
        localTextView = (TextView)parama.zfF.zfH.findViewById(arrayOfInt[0]);
        parama = (TextView)parama.zfF.zfH.findViewById(arrayOfInt[1]);
        if (!bs.isNullOrNil(((b.m)localObject).title)) {
          break label287;
        }
        localTextView.setVisibility(8);
        if (!bs.isNullOrNil(((b.m)localObject).desc)) {
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
  
  public static View w(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100118);
    if (paramInt2 == 6)
    {
      paramView = paramView.findViewById(zfx[0]);
      AppMethodBeat.o(100118);
      return paramView;
    }
    paramView = paramView.findViewById(zcP[paramInt1]);
    AppMethodBeat.o(100118);
    return paramView;
  }
  
  @TargetApi(16)
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, com.tencent.mm.plugin.sns.ui.bf parambf, TimeLineObject paramTimeLineObject, final int paramInt2, final be parambe)
  {
    AppMethodBeat.i(100117);
    ac.i("MiroMsg.TurnMediaTimeLineItem", "fill turn card ad item %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramBaseViewHolder.fYC)
    {
      ac.i("MiroMsg.TurnMediaTimeLineItem", "holder is busy");
      AppMethodBeat.o(100117);
      return;
    }
    final b localb = (b)paramBaseViewHolder;
    localb.zfH.setTag(localb);
    localb.zfH.setVisibility(0);
    Object localObject1 = (b)localb;
    Object localObject2 = zcP;
    int j = localObject2.length;
    final int i = 0;
    int k;
    Object localObject3;
    while (i < j)
    {
      k = localObject2[i];
      localObject3 = ((b)localObject1).zfH.findViewById(k);
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(8);
      }
      if ((localObject3 instanceof MaskImageView)) {
        ((MaskImageView)localObject3).setScaleType(QImageView.a.JbU);
      }
      i += 1;
    }
    localObject2 = zfx;
    j = localObject2.length;
    i = 0;
    while (i < j)
    {
      k = localObject2[i];
      localObject3 = ((b)localObject1).zfH.findViewById(k);
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
    paramBaseViewHolder.zdl.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    label398:
    btz localbtz;
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
    if ((parambf.yxA) && (paramInt2 == 11)) {
      if ((paramTimeLineObject.FQo != null) && (paramTimeLineObject.FQo.Etz != null) && (paramTimeLineObject.FQo.Etz.size() >= 2)) {
        if (localb.zde == 1)
        {
          paramInt2 = 1;
          localObject2 = null;
          localObject1 = null;
          i = 0;
          if (i >= Math.min(paramTimeLineObject.FQo.Etz.size(), 2)) {
            break label1939;
          }
          localbtz = (btz)paramTimeLineObject.FQo.Etz.get(i);
          localView = w(localb.zfH, i, 2);
          localView.setVisibility(4);
          if (localView == null) {
            break label2046;
          }
          localView.setTag(paramBaseViewHolder);
          localView.setOnClickListener(parambe.xZe.zgZ);
          if (localbtz.ndI != 2) {
            break label1289;
          }
          localObject3 = af.dHO();
          j = this.mActivity.hashCode();
          localObject4 = com.tencent.mm.storage.bf.fbk();
          ((com.tencent.mm.storage.bf)localObject4).gIh = paramTimeLineObject.CreateTime;
          ((f)localObject3).a(localbtz, localView, -1, j, (com.tencent.mm.storage.bf)localObject4, 3);
          localObject4 = null;
          localObject3 = localObject4;
          if (localbtz.ndI == 6)
          {
            localObject3 = localObject4;
            if (paramInt2 == i)
            {
              if (paramInt2 <= 0) {
                break label1334;
              }
              bool1 = true;
              l = parambf.yUS;
              localObject5 = localb.zfK;
              localObject4 = parambf.xHc;
              localObject3 = ((com.tencent.mm.plugin.sns.ui.an)localObject5).yFc;
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).yFb = paramTimeLineObject;
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).yFd.setOnCompletionListener(new b.e()
              {
                public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
                {
                  AppMethodBeat.i(100109);
                  if (paramAnonymousInt != -1)
                  {
                    if ((parambe == null) || (parambe.ySd == null) || (parambe.ySd.yxP == null))
                    {
                      AppMethodBeat.o(100109);
                      return;
                    }
                    parambe.ySd.yxP.A(l, this.xJz);
                  }
                  AppMethodBeat.o(100109);
                }
              });
              if (parambe.ySd.yxP.wM(i + l)) {
                break label1340;
              }
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).yFd.setOnDecodeDurationListener(new b.f()
              {
                public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
                {
                  AppMethodBeat.i(100110);
                  if ((parambe == null) || (parambe.ySd == null) || (parambe.ySd.yxP == null))
                  {
                    AppMethodBeat.o(100110);
                    return;
                  }
                  if (paramAnonymousLong >= 3L)
                  {
                    int i = (int)paramAnonymousb.dED();
                    parambe.ySd.yxP.d(l, bs.Gn(), i);
                    parambe.ySd.yxP.e(l, i, i);
                    parambe.ySd.yxP.ag(l, l + this.hNp);
                    this.zfA.yFd.setOnDecodeDurationListener(null);
                  }
                  AppMethodBeat.o(100110);
                }
              });
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).a(paramTimeLineObject, paramInt1, parambf.yzm, parambf.yxA);
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).yoJ.setVisibility(8);
              localObject6 = af.dHO();
              l = System.nanoTime();
              bool2 = f.t(localbtz);
              ac.i("MiroMsg.TurnMediaTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l) });
              if (bool2) {
                break label1563;
              }
              if (!((f)localObject6).w(localbtz)) {
                break label1385;
              }
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).yoI.setVisibility(8);
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).yFg.setVisibility(0);
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).yFg.fuE();
              label787:
              Object localObject7 = ((com.tencent.mm.plugin.sns.ui.an)localObject5).yFh.getLayoutParams();
              ((ViewGroup.LayoutParams)localObject7).width = this.zfw;
              ((ViewGroup.LayoutParams)localObject7).height = this.zfw;
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).yFh.setLayoutParams((ViewGroup.LayoutParams)localObject7);
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).yFd.setTagObject(localObject5);
              localObject7 = ((com.tencent.mm.plugin.sns.ui.an)localObject5).yFd;
              j = this.mActivity.hashCode();
              com.tencent.mm.storage.bf localbf = com.tencent.mm.storage.bf.fbk();
              localbf.gIh = paramTimeLineObject.CreateTime;
              ((f)localObject6).a((p)localObject4, localbtz, (VideoSightView)localObject7, j, paramInt1, localbf, parambf.yxA, true);
              ((f)localObject6).start();
              ((View)localObject3).setVisibility(0);
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).yFf.setTag(paramBaseViewHolder);
              ((com.tencent.mm.plugin.sns.ui.an)localObject5).yFf.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(100111);
                  if (paramInt2 > 0) {
                    parambe.ySd.yxP.wO(localb.zdd);
                  }
                  parambe.xZe.zgZ.onClick(paramAnonymousView);
                  AppMethodBeat.o(100111);
                }
              });
              localObject5 = com.tencent.mm.plugin.sns.model.an.jc(af.getAccSnsPath(), localbtz.Id);
              localObject6 = q.i(localbtz);
              if (!com.tencent.mm.vfs.i.eA((String)localObject5 + (String)localObject6)) {
                break label1904;
              }
              parambe.ySd.yxP.a(parambf.yUS, 0, true, bool1);
              label995:
              if (af.dHO().b((p)localObject4, null) != 5) {
                break label1926;
              }
              bool2 = true;
              label1011:
              parambe.ySd.yxP.c(parambf.yUS, bool2, bool1);
            }
          }
          localObject4 = localView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject4).width = this.zfw;
          ((ViewGroup.LayoutParams)localObject4).height = this.zfw;
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          if (localObject3 != null)
          {
            localObject4 = ((View)localObject3).getLayoutParams();
            ((ViewGroup.LayoutParams)localObject4).width = this.zfw;
            ((ViewGroup.LayoutParams)localObject4).height = this.zfw;
            ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          }
          if ((paramInt2 == i) && (localbtz.ndI == 2))
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
          ((a)localObject4).zfE = localView;
          ((a)localObject4).zfF = localb;
          ((a)localObject4).xRy = localbtz;
          ((a)localObject4).xIq = parambf.xHc;
          if (localObject2 == null) {
            break label1932;
          }
          ((a)localObject2).zfG = ((a)localObject4);
          label1212:
          if (i == paramTimeLineObject.FQo.Etz.size() - 1) {
            ((a)localObject4).zfG = ((a)localObject1);
          }
          if (i == paramInt2)
          {
            localb.zfJ = ((a)localObject4);
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
      ac.e("MiroMsg.TurnMediaTimeLineItem", "not enough medias!");
      AppMethodBeat.o(100117);
      return;
      localObject3 = af.dHO();
      j = this.mActivity.hashCode();
      localObject4 = com.tencent.mm.storage.bf.fbk();
      ((com.tencent.mm.storage.bf)localObject4).gIh = paramTimeLineObject.CreateTime;
      ((f)localObject3).a(localbtz, localView, j, (com.tencent.mm.storage.bf)localObject4);
      break label533;
      bool1 = false;
      break label569;
      if ((parambe == null) || (parambe.ySd == null) || (parambe.ySd.yxP == null)) {
        break label670;
      }
      parambe.ySd.yxP.d(l, bs.Gn(), bool1);
      break label670;
      if (((f)localObject6).b((p)localObject4, null) == 5)
      {
        ((f)localObject6).A(localbtz);
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).yoI.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).yFg.setVisibility(0);
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).yFg.fuE();
        break label787;
      }
      if (((f)localObject6).x(localbtz))
      {
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).yFg.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).yoI.setImageResource(2131234034);
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).yoI.setVisibility(0);
        break label787;
      }
      ((f)localObject6).y(localbtz);
      ((com.tencent.mm.plugin.sns.ui.an)localObject5).yoI.setVisibility(0);
      ((com.tencent.mm.plugin.sns.ui.an)localObject5).yFg.setVisibility(8);
      ((com.tencent.mm.plugin.sns.ui.an)localObject5).yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
      ((com.tencent.mm.plugin.sns.ui.an)localObject5).yoI.setContentDescription(this.mActivity.getString(2131761939));
      if (((f)localObject6).b((p)localObject4, null) != 4) {
        break label787;
      }
      ((com.tencent.mm.plugin.sns.ui.an)localObject5).yoJ.setVisibility(0);
      break label787;
      if (((f)localObject6).u(localbtz))
      {
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).yoI.setVisibility(0);
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).yFg.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).yoI.setContentDescription(this.mActivity.getString(2131761939));
      }
      for (;;)
      {
        if (!((com.tencent.mm.plugin.sns.ui.an)localObject5).yFd.xDG.dEA()) {
          break label1902;
        }
        ac.d("MiroMsg.TurnMediaTimeLineItem", "play video error " + localbtz.Id + " " + localbtz.Url + " " + localbtz.Fjh + " " + paramInt1);
        ((f)localObject6).y(localbtz);
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).yoI.setVisibility(0);
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).yFg.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
        ((com.tencent.mm.plugin.sns.ui.an)localObject5).yoI.setContentDescription(this.mActivity.getString(2131761939));
        break;
        if (((f)localObject6).v(localbtz))
        {
          ((com.tencent.mm.plugin.sns.ui.an)localObject5).yoI.setVisibility(8);
          ((com.tencent.mm.plugin.sns.ui.an)localObject5).yFg.setVisibility(8);
        }
        else if (((f)localObject6).b((p)localObject4, null) <= 5)
        {
          ((com.tencent.mm.plugin.sns.ui.an)localObject5).yoI.setVisibility(8);
          ((com.tencent.mm.plugin.sns.ui.an)localObject5).yFg.setVisibility(8);
        }
        else
        {
          ((f)localObject6).y(localbtz);
          ((com.tencent.mm.plugin.sns.ui.an)localObject5).yoI.setVisibility(0);
          ((com.tencent.mm.plugin.sns.ui.an)localObject5).yFg.setVisibility(8);
          ((com.tencent.mm.plugin.sns.ui.an)localObject5).yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
          ((com.tencent.mm.plugin.sns.ui.an)localObject5).yoI.setContentDescription(this.mActivity.getString(2131761939));
        }
      }
      break label787;
      parambe.ySd.yxP.a(parambf.yUS, 0, false, bool1);
      break label995;
      bool2 = false;
      break label1011;
      localObject1 = localObject4;
      break label1212;
      if ((localb.sSS != null) && ((localb.sSS instanceof FrameLayout))) {
        ((FrameLayout)localb.sSS).setClipChildren(false);
      }
      if (localb.zdl != null) {
        localb.zdl.setClipChildren(false);
      }
      if ((localb.zef != null) && ((localb.zef instanceof LinearLayout))) {
        ((LinearLayout)localb.zef).setClipChildren(false);
      }
      localb.zfH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(100112);
          parambe.xZe.zgZ.onClick(paramAnonymousView);
          if (paramInt2 > 0) {
            parambe.ySd.yxP.wO(localb.zdd);
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
      this.zfw = (Math.min(this.mScreenWidth, this.mScreenHeight) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 54) - this.mActivity.getResources().getDimensionPixelSize(2131165490) - this.mActivity.getResources().getDimensionPixelSize(2131165516) - this.mActivity.getResources().getDimensionPixelSize(2131165568));
    }
    Object localObject1 = (b)paramBaseViewHolder;
    if ((((BaseTimeLineItem.BaseViewHolder)localObject1).zdm != null) && (!((b)localObject1).zfI))
    {
      ((BaseTimeLineItem.BaseViewHolder)localObject1).zdm.setLayoutResource(2131495614);
      if (!((b)localObject1).zfI)
      {
        ((b)localObject1).zfH = ((BaseTimeLineItem.BaseViewHolder)localObject1).zdm.inflate();
        ((b)localObject1).zfI = true;
      }
    }
    for (;;)
    {
      Object localObject2 = ((b)localObject1).zfH.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = this.zfw;
      ((ViewGroup.LayoutParams)localObject2).height = this.zfw;
      ((RoundedCornerFrameLayout)((b)localObject1).zfH).setRadius(8.0F);
      localObject2 = ((b)localObject1).zfK;
      ((com.tencent.mm.plugin.sns.ui.an)localObject2).yFf = w(((b)localObject1).zfH, 0, 6);
      ((com.tencent.mm.plugin.sns.ui.an)localObject2).yFc = ((com.tencent.mm.plugin.sns.ui.an)localObject2).yFf;
      ((com.tencent.mm.plugin.sns.ui.an)localObject2).yFd = ((VideoSightView)((com.tencent.mm.plugin.sns.ui.an)localObject2).yFf.findViewById(2131300914));
      paramBaseViewHolder.zbE.yFd.setMute(true);
      ((com.tencent.mm.plugin.sns.ui.an)localObject2).yoI = ((ImageView)((com.tencent.mm.plugin.sns.ui.an)localObject2).yFf.findViewById(2131305196));
      ((com.tencent.mm.plugin.sns.ui.an)localObject2).yFg = ((MMPinProgressBtn)((com.tencent.mm.plugin.sns.ui.an)localObject2).yFf.findViewById(2131303515));
      ((com.tencent.mm.plugin.sns.ui.an)localObject2).yFh = ((TextView)((com.tencent.mm.plugin.sns.ui.an)localObject2).yFf.findViewById(2131299492));
      ((com.tencent.mm.plugin.sns.ui.an)localObject2).yoJ = ((TextView)((com.tencent.mm.plugin.sns.ui.an)localObject2).yFf.findViewById(2131299517));
      ((com.tencent.mm.plugin.sns.ui.an)localObject2).yFd.xDO = true;
      ((com.tencent.mm.plugin.sns.ui.an)localObject2).yFd.setScaleType(QImageView.a.JbU);
      ((com.tencent.mm.plugin.sns.ui.an)localObject2).yFd.hf(this.zfw, this.zfw);
      ((b)localObject1).rXY = ((b)localObject1).zfH.findViewById(2131305720);
      ((b)localObject1).zbW = ((b)localObject1).zfH.findViewById(2131305719);
      AppMethodBeat.o(100116);
      return;
      if (!((b)localObject1).zfI)
      {
        ((b)localObject1).zfH = ((b)localObject1).sSS.findViewById(2131306088);
        ((b)localObject1).zfI = true;
      }
    }
  }
  
  public static final class a
  {
    public int index;
    public View view;
    public p xIq;
    public btz xRy;
    public View zfE;
    public k.b zfF;
    public a zfG;
  }
  
  public static class b
    extends BaseTimeLineItem.BaseViewHolder
  {
    public View rXY;
    public View zbW;
    public View zfH;
    public boolean zfI;
    public k.a zfJ;
    public com.tencent.mm.plugin.sns.ui.an zfK;
    
    public b()
    {
      AppMethodBeat.i(100115);
      this.zfI = false;
      this.zfK = new com.tencent.mm.plugin.sns.ui.an();
      AppMethodBeat.o(100115);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.k
 * JD-Core Version:    0.7.0.1
 */