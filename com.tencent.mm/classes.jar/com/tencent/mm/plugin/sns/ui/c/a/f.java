package com.tencent.mm.plugin.sns.ui.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
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
import com.tencent.mm.plugin.sns.ui.d.c;
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

public final class f
  extends a
{
  k EBv;
  boolean ESr;
  public View EWf;
  public View EWg;
  private int[] EWh;
  private final int EWi;
  Context context;
  public int currentIndex;
  
  public f(TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo, c paramc, k paramk)
  {
    AppMethodBeat.i(100040);
    this.ESr = false;
    this.EWh = new int[] { 2131309432, 2131309433 };
    this.EWi = 2131309434;
    this.timeLineObject = paramTimeLineObject;
    this.DsC = paramSnsInfo;
    this.Dyw = paramc;
    this.EBv = paramk;
    AppMethodBeat.o(100040);
  }
  
  private View a(cnb paramcnb, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(100044);
    int[] arrayOfInt = new int[2];
    int[] tmp12_10 = arrayOfInt;
    tmp12_10[0] = 2131309432;
    int[] tmp17_12 = tmp12_10;
    tmp17_12[1] = 2131309433;
    tmp17_12;
    if (paramBoolean)
    {
      paramcnb = this.contentView.findViewById(arrayOfInt[paramInt]);
      AppMethodBeat.o(100044);
      return paramcnb;
    }
    if (paramcnb.oUv == 6)
    {
      paramcnb = this.contentView.findViewById(2131309434);
      AppMethodBeat.o(100044);
      return paramcnb;
    }
    if (paramcnb.oUv == 2)
    {
      paramcnb = this.contentView.findViewById(arrayOfInt[paramInt]);
      AppMethodBeat.o(100044);
      return paramcnb;
    }
    AppMethodBeat.o(100044);
    return null;
  }
  
  final void aad(int paramInt)
  {
    AppMethodBeat.i(100042);
    if ((this.EWg == null) || (this.EWf == null))
    {
      AppMethodBeat.o(100042);
      return;
    }
    this.currentIndex = paramInt;
    this.EWg.setVisibility(8);
    this.EWf.setVisibility(8);
    ((TextView)this.contentView.findViewById(2131309437)).setText(null);
    ((TextView)this.contentView.findViewById(2131309438)).setText(null);
    ((TextView)this.contentView.findViewById(2131309435)).setText(null);
    ((TextView)this.contentView.findViewById(2131309436)).setText(null);
    Object localObject2 = { 2131309438, 2131309436 };
    Object localObject3 = { 2131309437, 2131309435 };
    int[] arrayOfInt = { 2131309437, 2131309436 };
    Object localObject1 = this.DsC.getAdXml();
    if ((((ADXml)localObject1).adTurnInfo != null) && (((ADXml)localObject1).adTurnInfo.DWP != null) && (((ADXml)localObject1).adTurnInfo.DWP.size() >= 2))
    {
      localObject1 = (ADXml.o)((ADXml)localObject1).adTurnInfo.DWP.get(paramInt);
      if ((((ADXml.o)localObject1).DWw >= 0) && (((ADXml.o)localObject1).DWw < 3))
      {
        paramInt = ((ADXml.o)localObject1).DWw;
        localObject3 = new int[][] { localObject2, localObject3, arrayOfInt }[paramInt];
        localObject2 = (TextView)this.contentView.findViewById(localObject3[0]);
        localObject3 = (TextView)this.contentView.findViewById(localObject3[1]);
        if (!Util.isNullOrNil(((ADXml.o)localObject1).title)) {
          break label349;
        }
        ((TextView)localObject2).setVisibility(8);
        if (!Util.isNullOrNil(((ADXml.o)localObject1).desc)) {
          break label365;
        }
        ((TextView)localObject3).setVisibility(8);
      }
    }
    for (;;)
    {
      ((View)((TextView)localObject2).getParent()).setVisibility(0);
      ((View)((TextView)localObject3).getParent()).setVisibility(0);
      AppMethodBeat.o(100042);
      return;
      label349:
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setText(((ADXml.o)localObject1).title);
      break;
      label365:
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setText(((ADXml.o)localObject1).desc);
    }
  }
  
  public final void fko()
  {
    AppMethodBeat.i(100043);
    final int i;
    Object localObject1;
    label130:
    label136:
    Object localObject2;
    Object localObject3;
    final float f1;
    final float f2;
    final int k;
    if (this.timeLineObject.ContentObj.LoV.size() >= 2)
    {
      long l;
      if (this.DsC.getLikeFlag() == 1)
      {
        i = 1;
        if ((this.EBv != null) && (((cnb)this.timeLineObject.ContentObj.LoV.get(i)).oUv == 6))
        {
          localObject1 = this.EBv;
          l = this.DsC.field_snsId;
          if (this.DsC.getLikeFlag() != 1) {
            break label130;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        ((k)localObject1).K(l, bool);
        if (!this.ESr) {
          break label136;
        }
        Log.i("MicroMsg.TurnCardAdDetailItem", "isPlayAnimation, return");
        AppMethodBeat.o(100043);
        return;
        i = 0;
        break;
      }
      if (this.DsC.getLikeFlag() != 1) {
        break label399;
      }
      i = 0;
      j = 1;
      localObject1 = (cnb)this.timeLineObject.ContentObj.LoV.get(j);
      localObject2 = (cnb)this.timeLineObject.ContentObj.LoV.get(i);
      localObject1 = a((cnb)localObject1, j, false);
      localObject2 = a((cnb)localObject2, i, true);
      j = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth();
      localObject3 = new int[2];
      this.contentView.getLocationOnScreen((int[])localObject3);
      f1 = j / 2 - localObject3[1];
      this.contentView.setPivotY(f1);
      this.contentView.setCameraDistance(8000.0F);
      f1 = this.contentView.getWidth() / 2.0F;
      f2 = this.contentView.getHeight() / 2.0F;
      if (this.DsC.getLikeFlag() != 1) {
        break label407;
      }
      k = -90;
    }
    for (int j = 90;; j = -90)
    {
      localObject3 = new com.tencent.mm.plugin.sns.ui.widget.a(this.context, 0.0F, j, f1, f2, true);
      ((com.tencent.mm.plugin.sns.ui.widget.a)localObject3).setDuration(187L);
      ((com.tencent.mm.plugin.sns.ui.widget.a)localObject3).setInterpolator(new AccelerateInterpolator());
      ((com.tencent.mm.plugin.sns.ui.widget.a)localObject3).setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(100035);
          f.this.contentView.setLayerType(0, null);
          this.EWk.setVisibility(0);
          this.EWl.setVisibility(8);
          f.this.aad(i);
          paramAnonymousAnimation = new com.tencent.mm.plugin.sns.ui.widget.a(f.this.context, k, 0.0F, f1, f2, false);
          paramAnonymousAnimation.setDuration(187L);
          paramAnonymousAnimation.setInterpolator(new DecelerateInterpolator());
          f.this.contentView.startAnimation(paramAnonymousAnimation);
          f.this.ESr = false;
          f.this.refreshView();
          AppMethodBeat.o(100035);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(100034);
          f.this.contentView.setLayerType(2, null);
          AppMethodBeat.o(100034);
        }
      });
      this.contentView.startAnimation((Animation)localObject3);
      this.ESr = true;
      AppMethodBeat.o(100043);
      return;
      label399:
      i = 1;
      j = 0;
      break;
      label407:
      k = 90;
    }
  }
  
  public final void n(View paramView1, View paramView2)
  {
    AppMethodBeat.i(100041);
    this.contentView = paramView1;
    this.EAV = paramView2;
    this.context = paramView1.getContext();
    paramView2 = (WindowManager)this.context.getSystemService("window");
    int j = Math.min(paramView2.getDefaultDisplay().getWidth(), paramView2.getDefaultDisplay().getHeight()) - com.tencent.mm.cb.a.aG(this.context, 2131166954) - com.tencent.mm.cb.a.aG(this.context, 2131165593) - this.context.getResources().getDimensionPixelSize(2131165534) - this.context.getResources().getDimensionPixelSize(2131165534) - this.context.getResources().getDimensionPixelSize(2131165586);
    paramView2 = (LinearLayout.LayoutParams)paramView1.getLayoutParams();
    paramView2.topMargin = this.context.getResources().getDimensionPixelOffset(2131165518);
    paramView2.bottomMargin = 0;
    paramView2.width = j;
    paramView2.height = j;
    paramView1.setLayoutParams(paramView2);
    ((RoundedCornerFrameLayout)paramView1).setRadius(8.0F);
    if ((paramView1.getParent() instanceof ViewGroup))
    {
      ((ViewGroup)paramView1.getParent()).setClipChildren(false);
      ((ViewGroup)paramView1.getParent()).setClipToPadding(false);
    }
    paramView2 = this.EWh;
    int k = paramView2.length;
    int i = 0;
    while (i < k)
    {
      MaskImageView localMaskImageView = (MaskImageView)paramView1.findViewById(paramView2[i]);
      localMaskImageView.setVisibility(8);
      localMaskImageView.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return false;
        }
      });
      i += 1;
    }
    paramView2 = paramView1.findViewById(this.EWi);
    paramView2.setBackground(null);
    paramView2.setVisibility(8);
    ((ViewGroup)paramView2).setClipChildren(false);
    this.EUK = new at();
    this.EUK.Ewu = paramView2;
    this.EUK.Ewr = this.EUK.Ewu;
    this.EUK.Ews = ((VideoSightView)this.EUK.Ewu.findViewById(2131302526));
    this.EUK.Ews.setMute(true);
    this.EUK.EeS = ((ImageView)this.EUK.Ewu.findViewById(2131308392));
    this.EUK.Ewv = ((MMPinProgressBtn)this.EUK.Ewu.findViewById(2131306281));
    this.EUK.Eww = ((TextView)this.EUK.Ewu.findViewById(2131300128));
    this.EUK.EeT = ((TextView)this.EUK.Ewu.findViewById(2131300154));
    this.EUK.Ewu.setTag(this);
    this.EUK.Ewu.setOnClickListener(null);
    this.EUK.Ews.Dnz = true;
    this.EUK.Ews.setScaleType(QImageView.a.QEL);
    this.EUK.Ews.im(j, j);
    this.EWg = paramView1.findViewById(2131308987);
    this.EWf = paramView1.findViewById(2131308986);
    aad(0);
    AppMethodBeat.o(100041);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(100045);
    this.DsC = com.tencent.mm.plugin.sns.storage.f.aQl(this.DsC.getSnsId());
    Log.i("MicroMsg.TurnCardAdDetailItem", "refresh view");
    int k = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.cb.a.fromDPToPix(this.context, 50) - this.context.getResources().getDimensionPixelSize(2131165534) - this.context.getResources().getDimensionPixelSize(2131165534) - this.context.getResources().getDimensionPixelSize(2131165586);
    label141:
    label306:
    label570:
    label705:
    label1475:
    label1477:
    if (this.DsC.getTimeLine().ContentObj.LoV.size() >= 2)
    {
      final int i;
      final int j;
      Object localObject1;
      Object localObject2;
      g localg;
      int m;
      bp localbp;
      label252:
      final boolean bool1;
      label328:
      final long l1;
      if (this.DsC.field_likeFlag == 1)
      {
        i = 1;
        aad(i);
        j = 0;
        if (j >= 2) {
          break label1502;
        }
        localObject1 = (cnb)this.DsC.getTimeLine().ContentObj.LoV.get(j);
        localObject2 = (MaskImageView)this.contentView.findViewById(this.EWh[j]);
        ViewGroup.LayoutParams localLayoutParams = ((MaskImageView)localObject2).getLayoutParams();
        ((MaskImageView)localObject2).setTag(this);
        if (((cnb)localObject1).oUv != 2) {
          break label817;
        }
        localg = aj.faL();
        m = hashCode();
        localbp = bp.gCY();
        localbp.hXs = this.timeLineObject.CreateTime;
        localg.a((cnb)localObject1, (View)localObject2, -1, m, localbp, 3);
        ((MaskImageView)localObject2).setScaleType(QImageView.a.QEL);
        localLayoutParams.width = k;
        localLayoutParams.height = k;
        if ((i != j) || (((cnb)localObject1).oUv != 2)) {
          break label861;
        }
        ((MaskImageView)localObject2).setVisibility(0);
        ((MaskImageView)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(100036);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if ((f.this.EBv != null) && (i > 0)) {
              f.this.EBv.IS(f.this.DsC.field_snsId);
            }
            f.this.Dyw.Fbd.onClick(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100036);
          }
        });
        if ((((cnb)localObject1).oUv == 6) && (i == j))
        {
          if (i <= 0) {
            break label877;
          }
          bool1 = true;
          l1 = this.DsC.field_snsId;
          localObject2 = this.EUK.Ewr.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = k;
          ((ViewGroup.LayoutParams)localObject2).height = k;
          this.EUK.Ews.im(k, k);
          this.EUK.Ewr.setVisibility(0);
          aj.faL().a(this.DsC, (cnb)localObject1, this.EUK.Ews, this.context.hashCode(), 0, bp.Oqs, this.DsC.isAd(), true);
          this.EUK.Ews.start();
          this.EUK.Ewy = true;
          this.EUK.Ewz = j;
          this.EUK.Ewq = this.timeLineObject;
          this.EUK.position = 0;
          this.EUK.dHp = this.DsC.getLocalid();
          this.EUK.Ewu.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(100037);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              if ((f.this.EBv != null) && (bool1)) {
                f.this.EBv.IS(f.this.DsC.field_snsId);
              }
              f.this.Dyw.Fbd.onClick(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(100037);
            }
          });
          this.EUK.Ews.setOnCompletionListener(new b.e()
          {
            public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
            {
              AppMethodBeat.i(100038);
              if (paramAnonymousInt != -1) {
                f.this.EBv.I(l1, this.Dvz);
              }
              AppMethodBeat.o(100038);
            }
          });
          if (this.EBv != null)
          {
            if (this.EBv.IQ(j + l1)) {
              break label883;
            }
            this.EUK.Ews.setOnDecodeDurationListener(new b.f()
            {
              public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
              {
                AppMethodBeat.i(100039);
                if (paramAnonymousLong >= 3L)
                {
                  int i = (int)paramAnonymousb.eVC();
                  if (f.this.EBv != null)
                  {
                    f.this.EBv.c(l1, Util.currentTicks(), j);
                    f.this.EBv.e(l1, i, j);
                    f.this.EBv.an(l1, l1 + this.val$index);
                  }
                  f.this.EUK.Ews.setOnDecodeDurationListener(null);
                }
                AppMethodBeat.o(100039);
              }
            });
          }
          this.EUK.a(this.timeLineObject, 0, this.DsC.getLocalid(), this.DsC.isAd());
          this.EUK.EeT.setVisibility(8);
          localObject2 = aj.faL();
          long l2 = System.nanoTime();
          bool2 = g.u((cnb)localObject1);
          Log.i("MicroMsg.TurnCardAdDetailItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l2) });
          if (bool2) {
            break label1104;
          }
          if (!((g)localObject2).x((cnb)localObject1)) {
            break label900;
          }
          this.EUK.EeS.setVisibility(8);
          this.EUK.Ewv.setVisibility(0);
          this.EUK.Ewv.gYN();
          if (this.EBv != null)
          {
            localObject2 = ar.ki(aj.getAccSnsPath(), ((cnb)localObject1).Id);
            localObject1 = r.j((cnb)localObject1);
            if (!s.YS((String)localObject2 + (String)localObject1)) {
              break label1477;
            }
            this.EBv.f(this.DsC.field_snsId, 0, true);
            if (aj.faL().b(this.DsC, null) != 5) {
              break label1496;
            }
          }
        }
      }
      label1104:
      label1496:
      for (boolean bool2 = true;; bool2 = false)
      {
        this.EBv.d(l1, bool2, bool1);
        j += 1;
        break label141;
        i = 0;
        break;
        localg = aj.faL();
        m = hashCode();
        localbp = bp.gCY();
        localbp.hXs = this.timeLineObject.CreateTime;
        localg.a((cnb)localObject1, (View)localObject2, m, localbp);
        break label252;
        label861:
        ((MaskImageView)localObject2).setVisibility(8);
        ((MaskImageView)localObject2).setOnClickListener(null);
        break label306;
        label877:
        bool1 = false;
        break label328;
        label883:
        this.EBv.c(l1, Util.currentTicks(), bool1);
        break label570;
        if (((g)localObject2).b(this.DsC, null) == 5)
        {
          ((g)localObject2).B((cnb)localObject1);
          this.EUK.EeS.setVisibility(8);
          this.EUK.Ewv.setVisibility(0);
          this.EUK.Ewv.gYN();
          break label705;
        }
        if (((g)localObject2).y((cnb)localObject1))
        {
          this.EUK.Ewv.setVisibility(8);
          this.EUK.EeS.setImageResource(2131691482);
          this.EUK.EeS.setVisibility(0);
          break label705;
        }
        ((g)localObject2).z((cnb)localObject1);
        this.EUK.EeS.setVisibility(0);
        this.EUK.Ewv.setVisibility(8);
        this.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691480));
        this.EUK.EeS.setContentDescription(this.context.getString(2131763945));
        if (((g)localObject2).b(this.DsC, null) != 4) {
          break label705;
        }
        this.EUK.EeT.setVisibility(0);
        break label705;
        if (((g)localObject2).v((cnb)localObject1))
        {
          this.EUK.EeS.setVisibility(0);
          this.EUK.Ewv.setVisibility(8);
          this.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691480));
          this.EUK.EeS.setContentDescription(this.context.getString(2131763945));
        }
        for (;;)
        {
          if (!this.EUK.Ews.Dnr.eVz()) {
            break label1475;
          }
          Log.d("MicroMsg.TurnCardAdDetailItem", "play video error " + ((cnb)localObject1).Id + " " + ((cnb)localObject1).Url + " " + ((cnb)localObject1).Msz + " 0");
          ((g)localObject2).z((cnb)localObject1);
          this.EUK.EeS.setVisibility(0);
          this.EUK.Ewv.setVisibility(8);
          this.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691480));
          this.EUK.EeS.setContentDescription(this.context.getString(2131763945));
          break;
          if (((g)localObject2).w((cnb)localObject1))
          {
            this.EUK.EeS.setVisibility(8);
            this.EUK.Ewv.setVisibility(8);
          }
          else if (((g)localObject2).b(this.DsC, null) <= 5)
          {
            this.EUK.EeS.setVisibility(8);
            this.EUK.Ewv.setVisibility(8);
          }
          else
          {
            ((g)localObject2).z((cnb)localObject1);
            this.EUK.EeS.setVisibility(0);
            this.EUK.Ewv.setVisibility(8);
            this.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691480));
            this.EUK.EeS.setContentDescription(this.context.getString(2131763945));
          }
        }
        break label705;
        this.EBv.f(this.DsC.field_snsId, 0, false);
        break label774;
      }
    }
    label774:
    label817:
    label1502:
    AppMethodBeat.o(100045);
    label900:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.f
 * JD-Core Version:    0.7.0.1
 */