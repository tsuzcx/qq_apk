package com.tencent.mm.plugin.sns.ui.item;

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
import com.tencent.mm.plugin.sight.decode.model.SightPlayController;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.d;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.e;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.g.l;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.j;
import com.tencent.mm.plugin.sns.storage.ADXml.o;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;
import java.util.List;

public final class p
  extends BaseTimeLineItem
{
  private static int[] RKg = { b.f.turn_media_type_img_0, b.f.turn_media_type_img_1 };
  private static int[] RNq = { b.f.turn_media_type_sight_0 };
  private static int[][] RNr;
  private int RNp = 0;
  public int mScreenHeight = 0;
  private int mScreenWidth = 0;
  
  static
  {
    int i = b.f.turn_media_type_title_1;
    int j = b.f.turn_media_type_subtitle_1;
    int k = b.f.turn_media_type_title_0;
    int m = b.f.turn_media_type_subtitle_0;
    int n = b.f.turn_media_type_title_0;
    int i1 = b.f.turn_media_type_subtitle_1;
    RNr = new int[][] { { i, j }, { k, m }, { n, i1 } };
  }
  
  public static View D(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100118);
    if (paramInt2 == 6)
    {
      paramView = paramView.findViewById(RNq[0]);
      AppMethodBeat.o(100118);
      return paramView;
    }
    paramView = paramView.findViewById(RKg[paramInt1]);
    AppMethodBeat.o(100118);
    return paramView;
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(100119);
    parama.RNy.GBf.setVisibility(8);
    parama.RNy.QbY.setVisibility(8);
    ((TextView)parama.RNy.RNA.findViewById(b.f.turn_media_type_title_0)).setText(null);
    ((TextView)parama.RNy.RNA.findViewById(b.f.turn_media_type_title_1)).setText(null);
    ((TextView)parama.RNy.RNA.findViewById(b.f.turn_media_type_subtitle_0)).setText(null);
    ((TextView)parama.RNy.RNA.findViewById(b.f.turn_media_type_subtitle_1)).setText(null);
    Object localObject = parama.PNI.getAdXml();
    TextView localTextView;
    if ((((ADXml)localObject).adTurnInfo != null) && (((ADXml)localObject).adTurnInfo.QHY != null) && (((ADXml)localObject).adTurnInfo.QHY.size() >= 2))
    {
      localObject = (ADXml.o)((ADXml)localObject).adTurnInfo.QHY.get(parama.index);
      if ((((ADXml.o)localObject).QHE >= 0) && (((ADXml.o)localObject).QHE < RNr.length))
      {
        int[] arrayOfInt = RNr[localObject.QHE];
        localTextView = (TextView)parama.RNy.RNA.findViewById(arrayOfInt[0]);
        parama = (TextView)parama.RNy.RNA.findViewById(arrayOfInt[1]);
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
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bo parambo, TimeLineObject paramTimeLineObject, final int paramInt2, final bn parambn)
  {
    AppMethodBeat.i(100117);
    Log.i("MiroMsg.TurnMediaTimeLineItem", "fill turn card ad item %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramBaseViewHolder.mtE)
    {
      Log.i("MiroMsg.TurnMediaTimeLineItem", "holder is busy");
      AppMethodBeat.o(100117);
      return;
    }
    final b localb = (b)paramBaseViewHolder;
    localb.RNA.setTag(localb);
    localb.RNA.setVisibility(0);
    Object localObject1 = (b)localb;
    Object localObject2 = RKg;
    int j = localObject2.length;
    final int i = 0;
    int k;
    Object localObject3;
    while (i < j)
    {
      k = localObject2[i];
      localObject3 = ((b)localObject1).RNA.findViewById(k);
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(8);
      }
      if ((localObject3 instanceof MaskImageView)) {
        ((MaskImageView)localObject3).setScaleType(QImageView.a.afVc);
      }
      i += 1;
    }
    localObject2 = RNq;
    j = localObject2.length;
    i = 0;
    while (i < j)
    {
      k = localObject2[i];
      localObject3 = ((b)localObject1).RNA.findViewById(k);
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
    localObject1 = new LinearLayout.LayoutParams(((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 54) - this.mActivity.getResources().getDimensionPixelSize(b.d.LittlePadding) - this.mActivity.getResources().getDimensionPixelSize(b.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(b.d.SmallPadding), -2);
    paramBaseViewHolder.RKF.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    label398:
    dmz localdmz;
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
    if ((parambo.Rbg) && (paramInt2 == 11)) {
      if ((paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.Zpr != null) && (paramTimeLineObject.ContentObj.Zpr.size() >= 2)) {
        if (localb.RKy == 1)
        {
          paramInt2 = 1;
          localObject2 = null;
          localObject1 = null;
          i = 0;
          if (i >= Math.min(paramTimeLineObject.ContentObj.Zpr.size(), 2)) {
            break label1939;
          }
          localdmz = (dmz)paramTimeLineObject.ContentObj.Zpr.get(i);
          localView = D(localb.RNA, i, 2);
          localView.setVisibility(4);
          if (localView == null) {
            break label2051;
          }
          localView.setTag(paramBaseViewHolder);
          localView.setOnClickListener(parambn.QBf.RQG);
          if (localdmz.vhJ != 2) {
            break label1289;
          }
          localObject3 = al.hgy();
          j = this.mActivity.hashCode();
          localObject4 = br.jbh();
          ((br)localObject4).time = paramTimeLineObject.CreateTime;
          ((g)localObject3).a(localdmz, localView, -1, j, (br)localObject4, 3);
          localObject4 = null;
          localObject3 = localObject4;
          if (localdmz.vhJ == 6)
          {
            localObject3 = localObject4;
            if (paramInt2 == i)
            {
              if (paramInt2 <= 0) {
                break label1334;
              }
              bool1 = true;
              l = parambo.RBq;
              localObject5 = localb.RND;
              localObject4 = parambo.PJQ;
              localObject3 = ((aw)localObject5).RjL;
              ((aw)localObject5).RjK = paramTimeLineObject;
              ((aw)localObject5).RjM.setOnCompletionListener(new SightPlayController.d()
              {
                public final void c(SightPlayController paramAnonymousSightPlayController, int paramAnonymousInt)
                {
                  AppMethodBeat.i(100109);
                  if (paramAnonymousInt != -1)
                  {
                    if ((parambn == null) || (parambn.Ryp == null) || (parambn.Ryp.Rbv == null))
                    {
                      AppMethodBeat.o(100109);
                      return;
                    }
                    parambn.Ryp.Rbv.S(l, this.PVY);
                  }
                  AppMethodBeat.o(100109);
                }
              });
              if (parambn.Ryp.Rbv.uq(i + l)) {
                break label1340;
              }
              ((aw)localObject5).RjM.setOnDecodeDurationListener(new SightPlayController.e()
              {
                public final void b(SightPlayController paramAnonymousSightPlayController, long paramAnonymousLong)
                {
                  AppMethodBeat.i(100110);
                  if ((parambn == null) || (parambn.Ryp == null) || (parambn.Ryp.Rbv == null))
                  {
                    AppMethodBeat.o(100110);
                    return;
                  }
                  if (paramAnonymousLong >= 3L)
                  {
                    int i = (int)paramAnonymousSightPlayController.gYy();
                    parambn.Ryp.Rbv.c(l, Util.currentTicks(), i);
                    parambn.Ryp.Rbv.f(l, i, i);
                    parambn.Ryp.Rbv.bi(l, l + this.val$index);
                    this.RNt.RjM.setOnDecodeDurationListener(null);
                  }
                  AppMethodBeat.o(100110);
                }
              });
              ((aw)localObject5).a(paramTimeLineObject, paramInt1, parambo.Rdg, parambo.Rbg);
              ((aw)localObject5).QRC.setVisibility(8);
              localObject6 = al.hgy();
              l = System.nanoTime();
              bool2 = g.u(localdmz);
              Log.i("MiroMsg.TurnMediaTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l) });
              if (bool2) {
                break label1563;
              }
              if (!((g)localObject6).x(localdmz)) {
                break label1385;
              }
              ((aw)localObject5).PQu.setVisibility(8);
              ((aw)localObject5).RjP.setVisibility(0);
              ((aw)localObject5).RjP.jEN();
              label787:
              Object localObject7 = ((aw)localObject5).RjQ.getLayoutParams();
              ((ViewGroup.LayoutParams)localObject7).width = this.RNp;
              ((ViewGroup.LayoutParams)localObject7).height = this.RNp;
              ((aw)localObject5).RjQ.setLayoutParams((ViewGroup.LayoutParams)localObject7);
              ((aw)localObject5).RjM.setTagObject(localObject5);
              localObject7 = ((aw)localObject5).RjM;
              j = this.mActivity.hashCode();
              br localbr = br.jbh();
              localbr.time = paramTimeLineObject.CreateTime;
              ((g)localObject6).a((SnsInfo)localObject4, localdmz, (VideoSightView)localObject7, j, paramInt1, localbr, parambo.Rbg, true);
              ((g)localObject6).start();
              ((View)localObject3).setVisibility(0);
              ((aw)localObject5).RjO.setTag(paramBaseViewHolder);
              ((aw)localObject5).RjO.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(100111);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/item/TurnMediaTimeLineItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  if (paramInt2 > 0) {
                    parambn.Ryp.Rbv.us(localb.RKx);
                  }
                  parambn.QBf.RQG.onClick(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/TurnMediaTimeLineItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(100111);
                }
              });
              localObject5 = as.mg(al.getAccSnsPath(), localdmz.Id);
              localObject6 = t.i(localdmz);
              if (!y.ZC((String)localObject5 + (String)localObject6)) {
                break label1904;
              }
              parambn.Ryp.Rbv.b(parambo.RBq, 0, true, bool1);
              label995:
              if (al.hgy().b((SnsInfo)localObject4, null) != 5) {
                break label1926;
              }
              bool2 = true;
              label1011:
              parambn.Ryp.Rbv.e(parambo.RBq, bool2, bool1);
            }
          }
          localObject4 = localView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject4).width = this.RNp;
          ((ViewGroup.LayoutParams)localObject4).height = this.RNp;
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          if (localObject3 != null)
          {
            localObject4 = ((View)localObject3).getLayoutParams();
            ((ViewGroup.LayoutParams)localObject4).width = this.RNp;
            ((ViewGroup.LayoutParams)localObject4).height = this.RNp;
            ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          }
          if ((paramInt2 == i) && (localdmz.vhJ == 2))
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
          ((a)localObject4).RNx = localView;
          ((a)localObject4).RNy = localb;
          ((a)localObject4).Qsr = localdmz;
          ((a)localObject4).PNI = parambo.PJQ;
          if (localObject2 == null) {
            break label1932;
          }
          ((a)localObject2).RNz = ((a)localObject4);
          label1212:
          if (i == paramTimeLineObject.ContentObj.Zpr.size() - 1) {
            ((a)localObject4).RNz = ((a)localObject1);
          }
          if (i == paramInt2)
          {
            localb.RNC = ((a)localObject4);
            a((a)localObject4);
          }
          localObject2 = localObject4;
        }
      }
    }
    label2051:
    for (;;)
    {
      i += 1;
      break label398;
      paramInt2 = 0;
      break;
      Log.e("MiroMsg.TurnMediaTimeLineItem", "not enough medias!");
      AppMethodBeat.o(100117);
      return;
      label1289:
      localObject3 = al.hgy();
      j = this.mActivity.hashCode();
      localObject4 = br.jbh();
      ((br)localObject4).time = paramTimeLineObject.CreateTime;
      ((g)localObject3).a(localdmz, localView, j, (br)localObject4);
      break label533;
      label1334:
      bool1 = false;
      break label569;
      label1340:
      if ((parambn == null) || (parambn.Ryp == null) || (parambn.Ryp.Rbv == null)) {
        break label670;
      }
      parambn.Ryp.Rbv.c(l, Util.currentTicks(), bool1);
      break label670;
      label1385:
      if (((g)localObject6).b((SnsInfo)localObject4, null) == 5)
      {
        ((g)localObject6).B(localdmz);
        ((aw)localObject5).PQu.setVisibility(8);
        ((aw)localObject5).RjP.setVisibility(0);
        ((aw)localObject5).RjP.jEN();
        break label787;
      }
      if (((g)localObject6).y(localdmz))
      {
        ((aw)localObject5).RjP.setVisibility(8);
        ((aw)localObject5).PQu.setImageResource(b.i.shortvideo_play_icon_err);
        ((aw)localObject5).PQu.setVisibility(0);
        break label787;
      }
      ((g)localObject6).z(localdmz);
      ((aw)localObject5).PQu.setVisibility(0);
      ((aw)localObject5).RjP.setVisibility(8);
      ((aw)localObject5).PQu.setImageDrawable(com.tencent.mm.cd.a.m(this.mActivity, b.i.shortvideo_play_btn));
      ((aw)localObject5).PQu.setContentDescription(this.mActivity.getString(b.j.play_sight_desc));
      if (((g)localObject6).b((SnsInfo)localObject4, null) != 4) {
        break label787;
      }
      ((aw)localObject5).QRC.setVisibility(0);
      break label787;
      label1563:
      if (((g)localObject6).v(localdmz))
      {
        ((aw)localObject5).PQu.setVisibility(0);
        ((aw)localObject5).RjP.setVisibility(8);
        ((aw)localObject5).PQu.setImageDrawable(com.tencent.mm.cd.a.m(this.mActivity, b.i.shortvideo_play_btn));
        ((aw)localObject5).PQu.setContentDescription(this.mActivity.getString(b.j.play_sight_desc));
      }
      for (;;)
      {
        if (!((aw)localObject5).RjM.PGy.gYv()) {
          break label1902;
        }
        Log.d("MiroMsg.TurnMediaTimeLineItem", "play video error " + localdmz.Id + " " + localdmz.Url + " " + localdmz.aaTl + " " + paramInt1);
        ((g)localObject6).z(localdmz);
        ((aw)localObject5).PQu.setVisibility(0);
        ((aw)localObject5).RjP.setVisibility(8);
        ((aw)localObject5).PQu.setImageDrawable(com.tencent.mm.cd.a.m(this.mActivity, b.i.shortvideo_play_btn));
        ((aw)localObject5).PQu.setContentDescription(this.mActivity.getString(b.j.play_sight_desc));
        break;
        if (((g)localObject6).w(localdmz))
        {
          ((aw)localObject5).PQu.setVisibility(8);
          ((aw)localObject5).RjP.setVisibility(8);
        }
        else if (((g)localObject6).b((SnsInfo)localObject4, null) <= 5)
        {
          ((aw)localObject5).PQu.setVisibility(8);
          ((aw)localObject5).RjP.setVisibility(8);
        }
        else
        {
          ((g)localObject6).z(localdmz);
          ((aw)localObject5).PQu.setVisibility(0);
          ((aw)localObject5).RjP.setVisibility(8);
          ((aw)localObject5).PQu.setImageDrawable(com.tencent.mm.cd.a.m(this.mActivity, b.i.shortvideo_play_btn));
          ((aw)localObject5).PQu.setContentDescription(this.mActivity.getString(b.j.play_sight_desc));
        }
      }
      label1902:
      break label787;
      label1904:
      parambn.Ryp.Rbv.b(parambo.RBq, 0, false, bool1);
      break label995;
      label1926:
      bool2 = false;
      break label1011;
      label1932:
      localObject1 = localObject4;
      break label1212;
      label1939:
      if ((localb.convertView != null) && ((localb.convertView instanceof FrameLayout))) {
        ((FrameLayout)localb.convertView).setClipChildren(false);
      }
      if (localb.RKF != null) {
        localb.RKF.setClipChildren(false);
      }
      if ((localb.RLy != null) && ((localb.RLy instanceof LinearLayout))) {
        ((LinearLayout)localb.RLy).setClipChildren(false);
      }
      localb.RNA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(100112);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/item/TurnMediaTimeLineItem$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          parambn.QBf.RQG.onClick(paramAnonymousView);
          if (paramInt2 > 0) {
            parambn.Ryp.Rbv.us(localb.RKx);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/TurnMediaTimeLineItem$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100112);
        }
      });
      a(parambo, 1);
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
      this.RNp = (Math.min(this.mScreenWidth, this.mScreenHeight) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 54) - this.mActivity.getResources().getDimensionPixelSize(b.d.LittlePadding) - this.mActivity.getResources().getDimensionPixelSize(b.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(b.d.SmallPadding));
    }
    Object localObject1 = (b)paramBaseViewHolder;
    if ((((BaseTimeLineItem.BaseViewHolder)localObject1).RKG != null) && (!((b)localObject1).RNB))
    {
      ((BaseTimeLineItem.BaseViewHolder)localObject1).RKG.setLayoutResource(b.g.sns_timeline_turn_media);
      if (!((b)localObject1).RNB)
      {
        ((b)localObject1).RNA = ((BaseTimeLineItem.BaseViewHolder)localObject1).RKG.inflate();
        ((b)localObject1).RNB = true;
      }
    }
    for (;;)
    {
      Object localObject2 = ((b)localObject1).RNA.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = this.RNp;
      ((ViewGroup.LayoutParams)localObject2).height = this.RNp;
      ((RoundedCornerFrameLayout)((b)localObject1).RNA).setRadius(8.0F);
      localObject2 = ((b)localObject1).RND;
      ((aw)localObject2).RjO = D(((b)localObject1).RNA, 0, 6);
      ((aw)localObject2).RjL = ((aw)localObject2).RjO;
      ((aw)localObject2).RjM = ((VideoSightView)((aw)localObject2).RjO.findViewById(b.f.image));
      paramBaseViewHolder.Qcj.RjM.setMute(true);
      ((aw)localObject2).PQu = ((ImageView)((aw)localObject2).RjO.findViewById(b.f.status_btn));
      ((aw)localObject2).RjP = ((MMPinProgressBtn)((aw)localObject2).RjO.findViewById(b.f.progress));
      ((aw)localObject2).RjQ = ((TextView)((aw)localObject2).RjO.findViewById(b.f.endtv));
      ((aw)localObject2).QRC = ((TextView)((aw)localObject2).RjO.findViewById(b.f.errorTv));
      ((aw)localObject2).RjM.PGE = true;
      ((aw)localObject2).RjM.setScaleType(QImageView.a.afVc);
      ((aw)localObject2).RjM.ld(this.RNp, this.RNp);
      ((b)localObject1).GBf = ((b)localObject1).RNA.findViewById(b.f.text_area_top);
      ((b)localObject1).QbY = ((b)localObject1).RNA.findViewById(b.f.text_area_bottom);
      AppMethodBeat.o(100116);
      return;
      if (!((b)localObject1).RNB)
      {
        ((b)localObject1).RNA = ((b)localObject1).convertView.findViewById(b.f.turn_media_container);
        ((b)localObject1).RNB = true;
      }
    }
  }
  
  public static final class a
  {
    public SnsInfo PNI;
    public dmz Qsr;
    public View RNx;
    public p.b RNy;
    public a RNz;
    public int index;
    public View view;
  }
  
  public static class b
    extends BaseTimeLineItem.BaseViewHolder
  {
    public View GBf;
    public View QbY;
    public View RNA;
    public boolean RNB;
    public p.a RNC;
    public aw RND;
    
    public b()
    {
      AppMethodBeat.i(100115);
      this.RNB = false;
      this.RND = new aw();
      AppMethodBeat.o(100115);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.p
 * JD-Core Version:    0.7.0.1
 */