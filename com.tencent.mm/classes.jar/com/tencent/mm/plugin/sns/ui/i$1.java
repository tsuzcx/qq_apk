package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.os.StrictMode;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.j.6;
import com.tencent.mm.plugin.sns.ui.item.j.a;
import com.tencent.mm.plugin.sns.ui.item.j.b;
import com.tencent.mm.plugin.sns.ui.widget.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;

final class i$1
  extends com.tencent.mm.plugin.sns.ui.d.b
{
  i$1(i parami, Activity paramActivity, af paramaf)
  {
    super(0, paramActivity, paramaf);
  }
  
  public final void b(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38167);
    if (paramInt2 >= 0)
    {
      AppMethodBeat.o(38167);
      return;
    }
    new i.1.1(this, paramInt1, paramInt2, paramInt3, paramView).run();
    AppMethodBeat.o(38167);
  }
  
  public final void ci(Object paramObject)
  {
    AppMethodBeat.i(38168);
    long l2 = 0L;
    Object localObject = ((View)paramObject).getTag();
    long l1 = l2;
    if ((localObject instanceof ao))
    {
      localObject = (ao)localObject;
      l1 = l2;
      if (this.rFD.rFk != null) {
        l1 = this.rFD.rFk.di(((ao)localObject).ctV, 6);
      }
    }
    this.rFD.rFq.a((View)paramObject, 1, 0, this.rFD.rFl, l1);
    AppMethodBeat.o(38168);
  }
  
  public final void cts()
  {
    AppMethodBeat.i(38169);
    if (this.rFD.rkX != null) {
      this.rFD.rkX.cvW();
    }
    AppMethodBeat.o(38169);
  }
  
  public final void ctt()
  {
    AppMethodBeat.i(38175);
    this.rFD.rFw.ctj();
    AppMethodBeat.o(38175);
  }
  
  public final void dJ(View paramView)
  {
    AppMethodBeat.i(38170);
    paramView = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
    if (this.rFD.rkX.cvT() == null)
    {
      AppMethodBeat.o(38170);
      return;
    }
    this.rFD.rkX.cvT().ctC();
    new n();
    n localn = this.rFD.rkX.EE(paramView.position);
    if (!localn.isValid())
    {
      AppMethodBeat.o(38170);
      return;
    }
    Object localObject1 = com.tencent.mm.modelsns.b.lV(741);
    Object localObject2 = com.tencent.mm.plugin.sns.model.ak.q(localn);
    Object localObject3 = ((com.tencent.mm.modelsns.b)localObject1).uv(com.tencent.mm.plugin.sns.data.i.j(localn)).lY(localn.field_type).de(localn.Ex(32)).uv(localn.csP()).uv(localn.field_userName);
    if (localObject2 == null)
    {
      i = 0;
      localObject3 = ((com.tencent.mm.modelsns.b)localObject3).lY(i);
      if (localObject2 != null) {
        break label364;
      }
    }
    label364:
    for (int i = 0;; i = ((SnsObject)localObject2).CommentCount)
    {
      ((com.tencent.mm.modelsns.b)localObject3).lY(i);
      ((com.tencent.mm.modelsns.b)localObject1).ake();
      if ((!localn.Ex(32)) || ((localn.csh().xTS.wOb & 0x8) == 0)) {
        break label373;
      }
      localObject1 = this.rFD;
      localObject2 = new cds();
      ((i)localObject1).rFs = null;
      ab.i("MicroMsg.BaseTimeLine", "[performAdAtFriendClick] onCommentClick:  commentkey " + ((i)localObject1).rFs + " " + paramView.czw + " position:" + paramView.position);
      ((i)localObject1).rFo.setTag(localn);
      ((i)localObject1).ctq();
      ((i)localObject1).rFo.setVisibility(0);
      ((i)localObject1).rFo.setCommentFlag(0);
      ((i)localObject1).rFo.setCommentHint("");
      ((i)localObject1).rFo.setCommentInfo((cds)localObject2);
      ((i)localObject1).rFo.lD(true);
      ((i)localObject1).rFo.h(i.rFu, "");
      ((i)localObject1).c(paramView);
      AppMethodBeat.o(38170);
      return;
      i = ((SnsObject)localObject2).LikeCount;
      break;
    }
    label373:
    localObject1 = this.rFD;
    localObject2 = new cds();
    localObject3 = paramView.czw;
    ((i)localObject1).rFs = ((String)localObject3);
    ab.i("MicroMsg.BaseTimeLine", "[performCommentIconClick] onCommentClick:  commentkey " + ((i)localObject1).rFs + " " + paramView.czw + " position:" + paramView.position);
    ((i)localObject1).rFo.setTag(localn);
    ((i)localObject1).ctq();
    ((i)localObject1).rFo.setVisibility(0);
    ((i)localObject1).rFo.rQa = i.du((String)localObject3, 0);
    ((i)localObject1).rFo.setCommentInfo((cds)localObject2);
    ((i)localObject1).rFo.setCommentHint(((i)localObject1).context.getString(2131304029));
    ((i)localObject1).rFo.h(i.rFu, (String)localObject3);
    ((i)localObject1).rFo.lD(false);
    ((i)localObject1).c(paramView);
    AppMethodBeat.o(38170);
  }
  
  public final void dK(View paramView)
  {
    AppMethodBeat.i(38171);
    n localn;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
    {
      paramView = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
      if (this.rFD.rkX.cvT() == null)
      {
        AppMethodBeat.o(38171);
        return;
      }
      this.rFD.rkX.cvT().ctC();
      new n();
      localn = this.rFD.rkX.EE(paramView.position);
      if (!localn.isValid())
      {
        AppMethodBeat.o(38171);
        return;
      }
      localObject1 = com.tencent.mm.modelsns.b.lV(741);
      localObject2 = com.tencent.mm.plugin.sns.model.ak.q(localn);
      localObject3 = ((com.tencent.mm.modelsns.b)localObject1).uv(com.tencent.mm.plugin.sns.data.i.j(localn)).lY(localn.field_type).de(localn.Ex(32)).uv(localn.csP()).uv(localn.field_userName);
      if (localObject2 != null) {
        break label399;
      }
      i = 0;
      localObject3 = ((com.tencent.mm.modelsns.b)localObject3).lY(i);
      if (localObject2 != null) {
        break label408;
      }
    }
    label399:
    label408:
    for (int i = 0;; i = ((SnsObject)localObject2).CommentCount)
    {
      ((com.tencent.mm.modelsns.b)localObject3).lY(i);
      ((com.tencent.mm.modelsns.b)localObject1).ake();
      localObject1 = this.rFD;
      localObject2 = new cds();
      localObject3 = paramView.czw + "@boss";
      ((i)localObject1).rFs = ((String)localObject3);
      ab.i("MicroMsg.BaseTimeLine", "[performAdAtBossClick] onCommentClick:  commentkey " + ((i)localObject1).rFs + " " + paramView.czw + " position:" + paramView.position);
      com.tencent.mm.kernel.g.RM();
      String str = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().aru(localn.field_userName).Of();
      ((i)localObject1).rFo.setTag(localn);
      ((i)localObject1).ctq();
      ((i)localObject1).rFo.setVisibility(0);
      ((i)localObject1).rFo.setCommentFlag(i.du((String)localObject3, 1));
      ((i)localObject1).rFo.setCommentHint(str);
      ((i)localObject1).rFo.setCommentInfo((cds)localObject2);
      ((i)localObject1).rFo.h(i.rFu, (String)localObject3);
      ((i)localObject1).c(paramView);
      AppMethodBeat.o(38171);
      return;
      i = ((SnsObject)localObject2).LikeCount;
      break;
    }
  }
  
  public final void dL(View paramView)
  {
    AppMethodBeat.i(38172);
    if (this.rFD.rkX != null) {
      this.rFD.rkX.dR(paramView);
    }
    AppMethodBeat.o(38172);
  }
  
  public final void dM(final View paramView)
  {
    AppMethodBeat.i(38173);
    final BaseTimeLineItem.BaseViewHolder localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
    final n localn = ag.cpf().abv(localBaseViewHolder.crk);
    if ((localn == null) || (localn.coN()) || (i.a(this.rFD)))
    {
      AppMethodBeat.o(38173);
      return;
    }
    int j = 0;
    int i = j;
    Object localObject1;
    label361:
    long l;
    if (localn.Ex(32))
    {
      i = j;
      if (localn.csh().xTS.wNZ == 27)
      {
        i = j;
        if ((localBaseViewHolder.shL instanceof com.tencent.mm.plugin.sns.ui.item.j))
        {
          localObject1 = (com.tencent.mm.plugin.sns.ui.item.j)localBaseViewHolder.shL;
          Object localObject2 = ((j.b)localBaseViewHolder).siO;
          if (((j.a)localObject2).siL == null) {
            break label629;
          }
          Object localObject3 = ((j.a)localObject2).siK;
          localObject2 = ((j.a)localObject2).rMD;
          Object localObject4 = ((BaseTimeLineItem.BaseViewHolder)localObject3).timeLineObject;
          Object localObject6 = (j.b)localObject3;
          localObject3 = ((j.b)localObject6).siO;
          if ((((TimeLineObject)localObject4).xTS.wNZ != 27) || (((TimeLineObject)localObject4).xTS.wOa.size() < 2)) {
            break label629;
          }
          j = 0;
          if (((n)localObject2).field_likeFlag != 1) {
            break label612;
          }
          j = 1;
          i = 0;
          Object localObject5 = (bcs)((TimeLineObject)localObject4).xTS.wOa.get(j);
          ((TimeLineObject)localObject4).xTS.wOa.get(i);
          localObject4 = ((j.b)localObject6).siM;
          localObject5 = com.tencent.mm.plugin.sns.ui.item.j.v(((j.b)localObject6).siM, j, ((bcs)localObject5).jKs);
          localObject6 = com.tencent.mm.plugin.sns.ui.item.j.v(((j.b)localObject6).siM, i, 2);
          int[] arrayOfInt = new int[2];
          ((View)localObject4).getLocationOnScreen(arrayOfInt);
          ((View)localObject4).setPivotY(((com.tencent.mm.plugin.sns.ui.item.j)localObject1).mScreenHeight / 2 - arrayOfInt[1]);
          ((View)localObject4).setCameraDistance(8000.0F);
          float f1 = ((View)localObject4).getWidth() / 2.0F;
          float f2 = ((View)localObject4).getHeight() / 2.0F;
          if (((n)localObject2).field_likeFlag != 1) {
            break label618;
          }
          j = -90;
          i = 90;
          localObject2 = new a(((View)localObject4).getContext(), 0.0F, i, f1, f2, true);
          ((a)localObject2).setDuration(187L);
          ((a)localObject2).setInterpolator(new AccelerateInterpolator());
          ((a)localObject2).setAnimationListener(new j.6((com.tencent.mm.plugin.sns.ui.item.j)localObject1, (View)localObject6, (View)localObject5, (j.a)localObject3, (View)localObject4, j, f1, f2));
          ((View)localObject4).startAnimation((Animation)localObject2);
          i = 374;
          label440:
          if (localn.field_likeFlag == 0) {
            this.rFD.rFk.lk(localBaseViewHolder.sgK);
          }
          if ((localn.csh().xTS.wOa.size() > ((j.b)localBaseViewHolder).siO.index) && (((bcs)localn.csh().xTS.wOa.get(((j.b)localBaseViewHolder).siO.index)).jKs == 6))
          {
            localObject1 = this.rFD.rFk;
            l = localBaseViewHolder.sgK;
            if (((j.b)localBaseViewHolder).siO.index <= 0) {
              break label635;
            }
          }
        }
      }
    }
    label612:
    label618:
    label629:
    label635:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.sns.a.b.g)localObject1).y(l, bool);
      i.a(this.rFD, true);
      new com.tencent.mm.sdk.platformtools.ak().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38166);
          if (i.1.this.rFD.rFl != null) {
            i.1.this.rFD.rFl.rhS.w(localn);
          }
          Object localObject1;
          Object localObject2;
          int i;
          if (localBaseViewHolder.sgL == 0)
          {
            localObject1 = com.tencent.mm.plugin.sns.model.ak.q(localn);
            localObject2 = com.tencent.mm.modelsns.b.lV(707);
            ((com.tencent.mm.modelsns.b)localObject2).uv(com.tencent.mm.plugin.sns.data.i.j(localn)).lY(localn.field_type).de(localn.Ex(32)).uv(localn.csP()).uv(localn.field_userName).lY(((SnsObject)localObject1).LikeCount).lY(((SnsObject)localObject1).CommentCount);
            ((com.tencent.mm.modelsns.b)localObject2).ake();
            StrictMode.allowThreadDiskReads();
            localBaseViewHolder.sgL = 1;
            localn.field_likeFlag = localBaseViewHolder.sgL;
            h.a(localn.getSnsId(), localn);
            ((TextView)paramView.findViewById(2131827924)).setText(2131303830);
            localObject1 = localn;
            if (localn.Ex(32))
            {
              i = 7;
              an.a.a((n)localObject1, i, "", 0);
            }
          }
          for (;;)
          {
            localObject1 = i.1.this.rFD.rkX;
            localObject2 = (LinearLayout)paramView;
            i.1.2.1 local1 = new i.1.2.1(this);
            ImageView localImageView = (ImageView)((LinearLayout)localObject2).findViewById(2131827923);
            ScaleAnimation localScaleAnimation = new ScaleAnimation(0.9F, 1.2F, 0.9F, 1.2F, 1, 0.5F, 1, 0.5F);
            localScaleAnimation.setDuration(400L);
            localScaleAnimation.setStartOffset(100L);
            localScaleAnimation.setRepeatCount(0);
            localImageView.clearAnimation();
            localImageView.startAnimation(localScaleAnimation);
            localScaleAnimation.setAnimationListener(new av.9((av)localObject1, (LinearLayout)localObject2, local1));
            AppMethodBeat.o(38166);
            return;
            i = 1;
            break;
            localBaseViewHolder.sgL = 0;
            localn.field_likeFlag = localBaseViewHolder.sgL;
            h.a(localn.getSnsId(), localn);
            ((TextView)paramView.findViewById(2131827924)).setText(2131303873);
            an.a.aaC(localn.getSnsId());
          }
        }
      }, i);
      AppMethodBeat.o(38173);
      return;
      i = 1;
      break;
      j = 90;
      i = -90;
      break label361;
      i = 0;
      break label440;
    }
  }
  
  public final void dN(View paramView)
  {
    AppMethodBeat.i(38174);
    this.rFD.rFv.ctC();
    this.rFD.rFw.jew = true;
    this.rFD.rFw.dI(paramView);
    AppMethodBeat.o(38174);
  }
  
  public final void dO(View paramView)
  {
    AppMethodBeat.i(38176);
    this.rFD.rFw.cpX();
    if (paramView.getTag() != null)
    {
      paramView = (com.tencent.mm.plugin.sns.data.b)paramView.getTag();
      this.rFD.rFk.k(paramView.position, paramView.crk, 1);
    }
    AppMethodBeat.o(38176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.i.1
 * JD-Core Version:    0.7.0.1
 */