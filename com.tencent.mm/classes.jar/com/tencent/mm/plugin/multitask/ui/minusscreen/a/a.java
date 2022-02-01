package com.tencent.mm.plugin.multitask.ui.minusscreen.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.v4.view.u;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f.c;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator;", "Landroid/support/v7/widget/SimpleItemAnimator;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onItemListener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(Landroid/support/v7/widget/RecyclerView;Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "addDelay", "", "getAddDelay", "()J", "changeDelay", "getChangeDelay", "mAddAnimations", "Ljava/util/ArrayList;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Lkotlin/collections/ArrayList;", "getMAddAnimations", "()Ljava/util/ArrayList;", "setMAddAnimations", "(Ljava/util/ArrayList;)V", "mAdditionsList", "getMAdditionsList", "setMAdditionsList", "mChangeAnimations", "getMChangeAnimations", "setMChangeAnimations", "mChangesList", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$ChangeInfo;", "getMChangesList", "setMChangesList", "mLayoutsList", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$LayoutInfo;", "getMLayoutsList", "setMLayoutsList", "mMoveAnimations", "getMMoveAnimations", "setMMoveAnimations", "mMovesList", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$MoveInfo;", "getMMovesList", "setMMovesList", "mPendingAdditions", "getMPendingAdditions", "setMPendingAdditions", "mPendingChanges", "getMPendingChanges", "mPendingMoves", "getMPendingMoves", "mPendingRemovals", "getMPendingRemovals", "setMPendingRemovals", "mRemoveAnimations", "getMRemoveAnimations", "setMRemoveAnimations", "moveDelay", "getMoveDelay", "getOnItemListener", "()Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "removeDelay", "getRemoveDelay", "animateAdd", "", "viewHolder", "animateAddImpl", "", "holder", "animateChange", "oldHolder", "newHolder", "fromX", "", "fromY", "toX", "toY", "animateChangeImpl", "changeInfo", "animateLayoutImpl", "info", "animateMove", "animateMove1", "moveType", "animateMove2", "animateMove3", "finalY", "animateMoveImpl", "animatePersistence", "preInfo", "Landroid/support/v7/widget/RecyclerView$ItemAnimator$ItemHolderInfo;", "postInfo", "animateRemove", "animateRemoveImpl", "canReuseUpdatedViewHolder", "payloads", "", "", "cancelAll", "viewHolders", "checkRefreshLayout", "removalsPending", "movesPending", "changesPending", "dispatchFinishedWhenDone", "endAnimation", "item", "endAnimations", "endChangeAnimation", "infoList", "", "endChangeAnimationIfNecessary", "isAddAnimation", "isChangeAnimation", "isMoveAnimation", "isRemoveAnimation", "isRunning", "onAnimationFinished", "resetAnimation", "runPendingAnimations", "ChangeInfo", "Companion", "LayoutInfo", "MoveInfo", "ui-multitask_release"})
public final class a
  extends as
{
  public static final a.b AdS;
  private static TimeInterpolator amk;
  ArrayList<ArrayList<c>> AdQ;
  private final com.tencent.mm.plugin.multitask.ui.minusscreen.d.a AdR;
  final String TAG;
  private ArrayList<RecyclerView.v> aml;
  private ArrayList<RecyclerView.v> amm;
  private final ArrayList<d> amn;
  private final ArrayList<a> amo;
  ArrayList<ArrayList<RecyclerView.v>> amp;
  ArrayList<ArrayList<d>> amq;
  ArrayList<ArrayList<a>> amr;
  ArrayList<RecyclerView.v> ams;
  ArrayList<RecyclerView.v> amt;
  ArrayList<RecyclerView.v> amu;
  ArrayList<RecyclerView.v> amv;
  final RecyclerView hak;
  
  static
  {
    AppMethodBeat.i(236500);
    AdS = new a.b((byte)0);
    AppMethodBeat.o(236500);
  }
  
  public a(RecyclerView paramRecyclerView, com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama)
  {
    AppMethodBeat.i(236499);
    this.hak = paramRecyclerView;
    this.AdR = parama;
    this.TAG = "MicroMsg.MultiTask.MinusAnimator";
    this.aml = new ArrayList();
    this.amm = new ArrayList();
    this.amn = new ArrayList();
    this.amo = new ArrayList();
    this.amp = new ArrayList();
    this.amq = new ArrayList();
    this.amr = new ArrayList();
    this.AdQ = new ArrayList();
    this.ams = new ArrayList();
    this.amt = new ArrayList();
    this.amu = new ArrayList();
    this.amv = new ArrayList();
    AppMethodBeat.o(236499);
  }
  
  private final void a(a parama)
  {
    AppMethodBeat.i(236489);
    if (parama.amI != null) {
      a(parama, parama.amI);
    }
    if (parama.amJ != null) {
      a(parama, parama.amJ);
    }
    AppMethodBeat.o(236489);
  }
  
  private final void a(List<a> paramList, RecyclerView.v paramv)
  {
    AppMethodBeat.i(236488);
    int i = ((Collection)paramList).size() - 1;
    while (i >= 0)
    {
      a locala = (a)paramList.get(i);
      if ((a(locala, paramv)) && (locala.amI == null) && (locala.amJ == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
    AppMethodBeat.o(236488);
  }
  
  private boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(236486);
    p.h(paramv, "holder");
    Object localObject1 = paramv.aus;
    p.g(localObject1, "holder.itemView");
    Object localObject2 = paramv.aus;
    p.g(localObject2, "holder.itemView");
    paramInt1 += (int)((View)localObject2).getTranslationX();
    localObject2 = paramv.aus;
    p.g(localObject2, "holder.itemView");
    paramInt2 += (int)((View)localObject2).getTranslationY();
    e(paramv);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      x(paramv);
      AppMethodBeat.o(236486);
      return false;
    }
    if (i != 0) {
      ((View)localObject1).setTranslationX(-i);
    }
    if (j != 0) {
      ((View)localObject1).setTranslationY(-j);
    }
    this.amn.add(new d(paramv, paramInt1, paramInt4, paramInt3, paramInt5, 2));
    localObject1 = this.TAG;
    localObject2 = new StringBuilder("animateMove3 fromX:").append(paramInt1).append(" fromY:").append(paramInt2).append(" toX:").append(paramInt3).append(" toY:").append(paramInt4).append(" deltaX:").append(i).append(" deltaY:").append(j).append(" holder.left:");
    View localView = paramv.aus;
    p.g(localView, "holder.itemView");
    localObject2 = ((StringBuilder)localObject2).append(localView.getLeft()).append(" holder.top:");
    localView = paramv.aus;
    p.g(localView, "holder.itemView");
    Log.d((String)localObject1, localView.getTop() + " holder.position:" + paramv.lR());
    AppMethodBeat.o(236486);
    return true;
  }
  
  private final boolean a(a parama, RecyclerView.v paramv)
  {
    AppMethodBeat.i(236490);
    if (parama.amJ == paramv) {
      parama.amJ = null;
    }
    for (;;)
    {
      if (paramv != null)
      {
        View localView = paramv.aus;
        p.g(localView, "it.itemView");
        localView.setAlpha(1.0F);
        localView = paramv.aus;
        p.g(localView, "it.itemView");
        localView.setTranslationX(parama.AdT);
        localView = paramv.aus;
        p.g(localView, "it.itemView");
        localView.setTranslationY(parama.AdU);
        Log.d(this.TAG, "endAnimations,change reset!, transX: " + parama.AdT + " transY: " + parama.AdU);
      }
      z(paramv);
      AppMethodBeat.o(236490);
      return true;
      if (parama.amI != paramv) {
        break;
      }
      parama.amI = null;
    }
    AppMethodBeat.o(236490);
    return false;
  }
  
  private boolean b(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(236485);
    p.h(paramv, "holder");
    Object localObject1 = paramv.aus;
    p.g(localObject1, "holder.itemView");
    Object localObject2 = paramv.aus;
    p.g(localObject2, "holder.itemView");
    paramInt1 += (int)((View)localObject2).getTranslationX();
    localObject2 = paramv.aus;
    p.g(localObject2, "holder.itemView");
    paramInt2 += (int)((View)localObject2).getTranslationY();
    e(paramv);
    localObject2 = paramv.aus;
    p.g(localObject2, "holder.itemView");
    int i = paramInt1 - ((View)localObject2).getLeft();
    localObject2 = paramv.aus;
    p.g(localObject2, "holder.itemView");
    int j = paramInt2 - ((View)localObject2).getTop();
    if ((i == 0) && (j == 0))
    {
      x(paramv);
      AppMethodBeat.o(236485);
      return false;
    }
    if (i != 0) {
      ((View)localObject1).setTranslationX(i);
    }
    if (j != 0) {
      ((View)localObject1).setTranslationY(j);
    }
    this.amn.add(new d(paramv, paramInt1, paramInt2, paramInt3, paramInt4, 1));
    localObject1 = this.TAG;
    localObject2 = new StringBuilder("animateMove1 fromX:").append(paramInt1).append(" fromY:").append(paramInt2).append(" toX:").append(paramInt3).append(" toY:").append(paramInt4).append(" deltaX:").append(i).append(" deltaY:").append(j).append(" holder.left:");
    View localView = paramv.aus;
    p.g(localView, "holder.itemView");
    localObject2 = ((StringBuilder)localObject2).append(localView.getLeft()).append(" holder.top:");
    localView = paramv.aus;
    p.g(localView, "holder.itemView");
    Log.d((String)localObject1, localView.getTop() + " holder.position:" + paramv.lR());
    AppMethodBeat.o(236485);
    return true;
  }
  
  private void e(RecyclerView.v paramv)
  {
    AppMethodBeat.i(236492);
    p.h(paramv, "holder");
    if (amk == null) {
      amk = new ValueAnimator().getInterpolator();
    }
    ViewPropertyAnimator localViewPropertyAnimator = paramv.aus.animate();
    p.g(localViewPropertyAnimator, "holder.itemView.animate()");
    localViewPropertyAnimator.setInterpolator(amk);
    d(paramv);
    AppMethodBeat.o(236492);
  }
  
  private final boolean erD()
  {
    AppMethodBeat.i(236481);
    if (this.amm.size() > 0)
    {
      AppMethodBeat.o(236481);
      return true;
    }
    AppMethodBeat.o(236481);
    return false;
  }
  
  private final void l(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(236479);
    Object localObject1 = this.hak.getAdapter();
    int i;
    final ArrayList localArrayList;
    int j;
    label60:
    View localView;
    Object localObject2;
    if (localObject1 != null)
    {
      i = ((RecyclerView.a)localObject1).getItemCount();
      if (i < 2) {
        break label519;
      }
      localArrayList = new ArrayList();
      if (i != 2) {
        break label228;
      }
      j = this.hak.getChildCount();
      i = 0;
      if (i >= j) {
        break label408;
      }
      localView = this.hak.getChildAt(i);
      localObject2 = this.hak.bu(localView);
      if (localObject2 != null) {
        if ((localObject2 instanceof h)) {
          break label533;
        }
      }
    }
    label519:
    label526:
    label533:
    for (localObject1 = null;; localObject1 = localObject2)
    {
      localObject1 = (h)localObject1;
      int k;
      if ((localObject1 != null) && ((com.tencent.mm.plugin.multitask.ui.minusscreen.b.a)((h)localObject1).hgv() != null))
      {
        p.g(localView, "child");
        k = localView.getWidth();
        localObject1 = MultiTaskUIC.Ago;
        if (k < MultiTaskUIC.esg())
        {
          p.g(localObject2, "viewHolder");
          localObject1 = ((RecyclerView.v)localObject2).aus;
          p.g(localObject1, "viewHolder.itemView");
          k = ((View)localObject1).getWidth();
          localObject1 = MultiTaskUIC.Ago;
          localArrayList.add(new c((RecyclerView.v)localObject2, k, MultiTaskUIC.esg(), (byte)0));
        }
      }
      i += 1;
      break label60;
      i = 0;
      break;
      label228:
      if (i >= 3)
      {
        j = this.hak.getChildCount();
        i = 0;
        if (i < j)
        {
          localView = this.hak.getChildAt(i);
          localObject2 = this.hak.bu(localView);
          if (localObject2 != null) {
            if ((localObject2 instanceof h)) {
              break label526;
            }
          }
        }
      }
      for (localObject1 = null;; localObject1 = localObject2)
      {
        localObject1 = (h)localObject1;
        if ((localObject1 != null) && ((com.tencent.mm.plugin.multitask.ui.minusscreen.b.a)((h)localObject1).hgv() != null))
        {
          p.g(localView, "child");
          k = localView.getWidth();
          localObject1 = MultiTaskUIC.Ago;
          if (k > MultiTaskUIC.ese())
          {
            p.g(localObject2, "viewHolder");
            localObject1 = ((RecyclerView.v)localObject2).aus;
            p.g(localObject1, "viewHolder.itemView");
            k = ((View)localObject1).getWidth();
            localObject1 = MultiTaskUIC.Ago;
            localArrayList.add(new c((RecyclerView.v)localObject2, k, MultiTaskUIC.ese(), (byte)0));
          }
        }
        i += 1;
        break;
        label408:
        this.AdQ.add(localArrayList);
        localObject1 = (Runnable)new l(this, localArrayList);
        if ((paramBoolean1) || (paramBoolean2) || (paramBoolean3))
        {
          localObject2 = (c)j.kt((List)localArrayList);
          if (localObject2 != null)
          {
            localObject2 = ((c)localObject2).amO;
            if (localObject2 != null)
            {
              localObject2 = ((RecyclerView.v)localObject2).aus;
              if (localObject2 != null)
              {
                u.a((View)localObject2, (Runnable)localObject1, ly());
                AppMethodBeat.o(236479);
                return;
              }
            }
          }
          AppMethodBeat.o(236479);
          return;
        }
        ((Runnable)localObject1).run();
        AppMethodBeat.o(236479);
        return;
      }
    }
  }
  
  private static void n(List<? extends RecyclerView.v> paramList)
  {
    AppMethodBeat.i(236497);
    p.h(paramList, "viewHolders");
    int i = ((Collection)paramList).size() - 1;
    while (i >= 0)
    {
      Object localObject = (RecyclerView.v)paramList.get(i);
      if (localObject != null)
      {
        localObject = ((RecyclerView.v)localObject).aus;
        if (localObject != null)
        {
          localObject = ((View)localObject).animate();
          if (localObject != null) {
            ((ViewPropertyAnimator)localObject).cancel();
          }
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(236497);
  }
  
  public final boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(236484);
    p.h(paramv, "holder");
    Object localObject1 = paramv.aus;
    p.g(localObject1, "holder.itemView");
    Object localObject2 = paramv.aus;
    p.g(localObject2, "holder.itemView");
    paramInt1 += (int)((View)localObject2).getTranslationX();
    localObject2 = paramv.aus;
    p.g(localObject2, "holder.itemView");
    paramInt2 += (int)((View)localObject2).getTranslationY();
    e(paramv);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      x(paramv);
      AppMethodBeat.o(236484);
      return false;
    }
    if (i != 0) {
      ((View)localObject1).setTranslationX(-i);
    }
    if (j != 0) {
      ((View)localObject1).setTranslationY(-j);
    }
    this.amn.add(new d(paramv, paramInt1, paramInt2, paramInt3, paramInt4));
    localObject1 = this.TAG;
    localObject2 = new StringBuilder("animateMove fromX:").append(paramInt1).append(" fromY:").append(paramInt2).append(" toX:").append(paramInt3).append(" toY:").append(paramInt4).append(" deltaX:").append(i).append(" deltaY:").append(j).append(" holder.left:");
    View localView = paramv.aus;
    p.g(localView, "holder.itemView");
    localObject2 = ((StringBuilder)localObject2).append(localView.getLeft()).append(" holder.top:");
    localView = paramv.aus;
    p.g(localView, "holder.itemView");
    Log.d((String)localObject1, localView.getTop() + " holder.position:" + paramv.lR());
    AppMethodBeat.o(236484);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(236487);
    p.h(paramv1, "oldHolder");
    p.h(paramv2, "newHolder");
    if (paramv1 == paramv2)
    {
      boolean bool = a(paramv1, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(236487);
      return bool;
    }
    Object localObject = paramv1.aus;
    p.g(localObject, "oldHolder.itemView");
    float f1 = ((View)localObject).getTranslationX();
    localObject = paramv1.aus;
    p.g(localObject, "oldHolder.itemView");
    float f2 = ((View)localObject).getTranslationY();
    localObject = paramv1.aus;
    p.g(localObject, "oldHolder.itemView");
    float f3 = ((View)localObject).getAlpha();
    e(paramv1);
    int i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    localObject = paramv1.aus;
    p.g(localObject, "oldHolder.itemView");
    ((View)localObject).setTranslationX(f1);
    localObject = paramv1.aus;
    p.g(localObject, "oldHolder.itemView");
    ((View)localObject).setTranslationY(f2);
    localObject = paramv1.aus;
    p.g(localObject, "oldHolder.itemView");
    ((View)localObject).setAlpha(f3);
    e(paramv2);
    localObject = paramv2.aus;
    p.g(localObject, "newHolder.itemView");
    ((View)localObject).setTranslationX(-i);
    localObject = paramv2.aus;
    p.g(localObject, "newHolder.itemView");
    ((View)localObject).setTranslationY(-j);
    localObject = paramv2.aus;
    p.g(localObject, "newHolder.itemView");
    ((View)localObject).setAlpha(0.0F);
    localObject = this.hak.getAdapter();
    if (localObject != null)
    {
      i = ((RecyclerView.a)localObject).getItemCount();
      if (((i != 2) && (i != 3)) || (paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
        break label362;
      }
      this.amo.add(new a(paramv1, paramv2, paramInt1, paramInt2, paramInt3, paramInt4, f1, f2));
    }
    for (;;)
    {
      AppMethodBeat.o(236487);
      return true;
      i = 0;
      break;
      label362:
      this.amo.add(new a(paramv1, paramv2, paramInt1, paramInt2, paramInt3, paramInt4, 0.0F, 0.0F));
    }
  }
  
  public final boolean a(RecyclerView.v paramv, List<? extends Object> paramList)
  {
    AppMethodBeat.i(236498);
    p.h(paramv, "viewHolder");
    p.h(paramList, "payloads");
    if (!((Collection)paramList).isEmpty()) {}
    for (int i = 1; (i != 0) || (super.a(paramv, paramList)); i = 0)
    {
      AppMethodBeat.o(236498);
      return true;
    }
    AppMethodBeat.o(236498);
    return false;
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(236482);
    p.h(paramv, "viewHolder");
    Log.d(this.TAG, "animateRemove layoutPosition:" + paramv.lQ() + " adapterPosition:" + paramv.lR() + " hashCode:" + paramv.hashCode());
    e(paramv);
    this.aml.add(paramv);
    Object localObject1 = this.hak.getAdapter();
    Object localObject2;
    int i;
    int j;
    int k;
    if ((localObject1 != null) && (((RecyclerView.a)localObject1).getItemCount() == 3))
    {
      Log.d(this.TAG, "animateRemove layoutPosition:" + paramv.lQ());
      if (paramv.lQ() != 2) {
        break label396;
      }
      paramv = this.hak.ch(1);
      if (paramv != null)
      {
        Log.d(this.TAG, "animateRemove add moveInfo from adapterPosition 1");
        localObject1 = this.amn;
        p.g(paramv, "it");
        localObject2 = paramv.aus;
        p.g(localObject2, "it.itemView");
        i = ((View)localObject2).getLeft();
        localObject2 = paramv.aus;
        p.g(localObject2, "it.itemView");
        j = ((View)localObject2).getTop();
        localObject2 = paramv.aus;
        p.g(localObject2, "it.itemView");
        k = ((View)localObject2).getLeft();
        localObject2 = MultiTaskUIC.Ago;
        ((ArrayList)localObject1).add(new d(paramv, i, j, k, MultiTaskUIC.esp(), 1));
      }
      paramv = this.hak.ch(2);
      if (paramv != null)
      {
        Log.d(this.TAG, "animateRemove add moveInfo from adapterPosition 2");
        localObject1 = this.amn;
        p.g(paramv, "it");
        localObject2 = paramv.aus;
        p.g(localObject2, "it.itemView");
        i = ((View)localObject2).getLeft();
        localObject2 = paramv.aus;
        p.g(localObject2, "it.itemView");
        j = ((View)localObject2).getTop();
        localObject2 = paramv.aus;
        p.g(localObject2, "it.itemView");
        k = ((View)localObject2).getLeft();
        localObject2 = MultiTaskUIC.Ago;
        ((ArrayList)localObject1).add(new d(paramv, i, j, k, MultiTaskUIC.esp(), 1));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(236482);
      return true;
      label396:
      if (paramv.lQ() == 1)
      {
        paramv = this.hak.ch(1);
        if (paramv != null)
        {
          Log.d(this.TAG, "animateRemove add moveInfo from adapterPosition 1");
          localObject1 = this.amn;
          p.g(paramv, "it");
          localObject2 = paramv.aus;
          p.g(localObject2, "it.itemView");
          i = ((View)localObject2).getLeft();
          localObject2 = paramv.aus;
          p.g(localObject2, "it.itemView");
          j = ((View)localObject2).getTop();
          localObject2 = paramv.aus;
          p.g(localObject2, "it.itemView");
          k = ((View)localObject2).getLeft();
          localObject2 = MultiTaskUIC.Ago;
          ((ArrayList)localObject1).add(new d(paramv, i, j, k, MultiTaskUIC.esp(), 1));
        }
      }
    }
  }
  
  public final boolean c(RecyclerView.v paramv)
  {
    AppMethodBeat.i(236483);
    p.h(paramv, "viewHolder");
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("animateAdd layoutPosition:").append(paramv.lQ()).append(" adapterPosition:").append(paramv.lR()).append(" hashCode:").append(paramv.hashCode()).append(" itemCount:");
    Object localObject1 = this.hak.getAdapter();
    int i;
    label163:
    int j;
    int k;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((RecyclerView.a)localObject1).getItemCount());
      Log.d((String)localObject2, localObject1);
      e(paramv);
      localObject1 = paramv.aus;
      p.g(localObject1, "viewHolder.itemView");
      ((View)localObject1).setAlpha(0.0F);
      this.amm.add(paramv);
      localObject1 = this.hak.getAdapter();
      if (localObject1 == null) {
        break label274;
      }
      i = ((RecyclerView.a)localObject1).getItemCount();
      if (i != 2) {
        break label279;
      }
      if (paramv.lQ() == 1)
      {
        localObject1 = this.amn;
        localObject2 = paramv.aus;
        p.g(localObject2, "viewHolder.itemView");
        i = ((View)localObject2).getLeft();
        localObject2 = paramv.aus;
        p.g(localObject2, "viewHolder.itemView");
        j = ((View)localObject2).getTop();
        localObject2 = MultiTaskUIC.Ago;
        k = MultiTaskUIC.esn();
        localObject2 = MultiTaskUIC.Ago;
        ((ArrayList)localObject1).add(new d(paramv, i, j, k, MultiTaskUIC.esm(), 1));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(236483);
      return true;
      localObject1 = null;
      break;
      label274:
      i = 0;
      break label163;
      label279:
      if (i == 3)
      {
        localObject1 = this.amn;
        localObject2 = paramv.aus;
        p.g(localObject2, "viewHolder.itemView");
        i = ((View)localObject2).getLeft();
        localObject2 = paramv.aus;
        p.g(localObject2, "viewHolder.itemView");
        j = ((View)localObject2).getTop();
        localObject2 = MultiTaskUIC.Ago;
        ((ArrayList)localObject1).add(new d(paramv, i, j, 0, MultiTaskUIC.esp(), 1));
        paramv = this.hak.ch(2);
        if (paramv != null)
        {
          localObject1 = this.amn;
          p.g(paramv, "it");
          localObject2 = paramv.aus;
          p.g(localObject2, "it.itemView");
          i = ((View)localObject2).getLeft();
          localObject2 = paramv.aus;
          p.g(localObject2, "it.itemView");
          j = ((View)localObject2).getTop();
          localObject2 = paramv.aus;
          p.g(localObject2, "it.itemView");
          k = ((View)localObject2).getLeft();
          localObject2 = MultiTaskUIC.Ago;
          ((ArrayList)localObject1).add(new d(paramv, i, j, k, MultiTaskUIC.esp(), 1));
        }
      }
      else if (i >= 4)
      {
        paramv = paramv.aus.findViewById(2131302800);
        if (paramv != null)
        {
          paramv.setTranslationX(0.0F);
          paramv.setTranslationY(0.0F);
        }
      }
    }
  }
  
  public final void d(RecyclerView.v paramv)
  {
    AppMethodBeat.i(236491);
    p.h(paramv, "item");
    Log.d(this.TAG, "endAnimation " + paramv.lR());
    View localView1 = paramv.aus;
    p.g(localView1, "item.itemView");
    View localView2 = paramv.aus.findViewById(2131305006);
    localView1.animate().cancel();
    int i = ((Collection)this.amn).size() - 1;
    Object localObject1;
    while (i >= 0)
    {
      localObject1 = this.amn.get(i);
      p.g(localObject1, "mPendingMoves[i]");
      if (((d)localObject1).amO == paramv)
      {
        localView1.setTranslationY(0.0F);
        localView1.setTranslationX(0.0F);
        x(paramv);
        this.amn.remove(i);
        Log.d(this.TAG, "endAnimation, reset");
      }
      i -= 1;
    }
    a((List)this.amo, paramv);
    if (this.aml.remove(paramv))
    {
      localView1.setAlpha(1.0F);
      w(paramv);
    }
    if (this.amm.remove(paramv))
    {
      localView1.setAlpha(1.0F);
      y(paramv);
    }
    i = ((Collection)this.amr).size() - 1;
    while (i >= 0)
    {
      localObject1 = this.amr.get(i);
      p.g(localObject1, "mChangesList[i]");
      localObject1 = (ArrayList)localObject1;
      a((List)localObject1, paramv);
      if (((ArrayList)localObject1).isEmpty()) {
        this.amr.remove(i);
      }
      i -= 1;
    }
    i = ((Collection)this.amq).size() - 1;
    int j;
    Object localObject2;
    if (i >= 0)
    {
      localObject1 = this.amq.get(i);
      p.g(localObject1, "mMovesList[i]");
      localObject1 = (ArrayList)localObject1;
      j = ((Collection)localObject1).size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          localObject2 = ((ArrayList)localObject1).get(j);
          p.g(localObject2, "moves[j]");
          if (((d)localObject2).amO == paramv)
          {
            localView1.setTranslationY(0.0F);
            localView1.setTranslationX(0.0F);
            x(paramv);
            ((ArrayList)localObject1).remove(j);
            if (((ArrayList)localObject1).isEmpty()) {
              this.amq.remove(i);
            }
            Log.d(this.TAG, "endAnimations,move reset!");
          }
        }
        else
        {
          i -= 1;
          break;
        }
        j -= 1;
      }
    }
    i = ((Collection)this.amp).size() - 1;
    while (i >= 0)
    {
      localObject1 = this.amp.get(i);
      p.g(localObject1, "mAdditionsList[i]");
      localObject1 = (ArrayList)localObject1;
      if (((ArrayList)localObject1).remove(paramv))
      {
        localView1.setAlpha(1.0F);
        y(paramv);
        if (((ArrayList)localObject1).isEmpty()) {
          this.amp.remove(i);
        }
      }
      i -= 1;
    }
    i = ((Collection)this.AdQ).size() - 1;
    if (i >= 0)
    {
      localObject1 = this.AdQ.get(i);
      p.g(localObject1, "mLayoutsList[i]");
      localObject1 = (ArrayList)localObject1;
      j = ((Collection)localObject1).size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          localObject2 = ((ArrayList)localObject1).get(j);
          p.g(localObject2, "layouts[j]");
          localObject2 = (c)localObject2;
          if (((c)localObject2).amO != paramv) {
            break label779;
          }
          p.g(localView2, "imgView");
          ViewGroup.LayoutParams localLayoutParams = localView2.getLayoutParams();
          int k = ((c)localObject2).AdW;
          MultiTaskUIC.a locala = MultiTaskUIC.Ago;
          float f = k - MultiTaskUIC.esb();
          locala = MultiTaskUIC.Ago;
          localLayoutParams.height = kotlin.h.a.cR(f * MultiTaskUIC.esw());
          localView1.getLayoutParams().width = ((c)localObject2).AdW;
          localLayoutParams = localView1.getLayoutParams();
          f = ((c)localObject2).AdW;
          localObject2 = MultiTaskUIC.Ago;
          localLayoutParams.height = kotlin.h.a.cR(f * MultiTaskUIC.esv());
          localView1.requestLayout();
          ((ArrayList)localObject1).remove(j);
          if (((ArrayList)localObject1).isEmpty()) {
            this.AdQ.remove(i);
          }
        }
        i -= 1;
        break;
        label779:
        j -= 1;
      }
    }
    this.amu.remove(paramv);
    this.ams.remove(paramv);
    this.amv.remove(paramv);
    this.amt.remove(paramv);
    jE();
    AppMethodBeat.o(236491);
  }
  
  public final boolean f(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(236480);
    p.h(paramv, "viewHolder");
    p.h(paramc1, "preInfo");
    p.h(paramc2, "postInfo");
    Log.d(this.TAG, "animatePersistence layoutPosition:" + paramv.lQ() + " adapterPosition:" + paramv.lR() + " hashCode:" + paramv.hashCode());
    int k;
    int m;
    int i;
    int j;
    Object localObject;
    if ((paramc1.left == paramc2.left) && (paramc1.top == paramc2.top))
    {
      if (!erD())
      {
        paramc2 = this.hak.getAdapter();
        if ((paramc2 != null) && (paramc2.getItemCount() == 2) && (paramv.lR() == 1))
        {
          k = paramc1.left;
          m = paramc1.top;
          paramc1 = MultiTaskUIC.Ago;
          i = MultiTaskUIC.esn();
          paramc1 = MultiTaskUIC.Ago;
          j = MultiTaskUIC.esm();
          p.h(paramv, "holder");
          paramc1 = paramv.aus;
          p.g(paramc1, "holder.itemView");
          paramc2 = paramv.aus;
          p.g(paramc2, "holder.itemView");
          k = (int)paramc2.getTranslationX() + k;
          paramc2 = paramv.aus;
          p.g(paramc2, "holder.itemView");
          m += (int)paramc2.getTranslationY();
          e(paramv);
          paramc2 = paramv.aus;
          p.g(paramc2, "holder.itemView");
          int n = k - paramc2.getLeft();
          paramc2 = paramv.aus;
          p.g(paramc2, "holder.itemView");
          int i1 = m - paramc2.getTop();
          if (n != 0) {
            paramc1.setTranslationX(n);
          }
          if (i1 != 0) {
            paramc1.setTranslationY(i1);
          }
          this.amn.add(new d(paramv, k, m, i, j, 1));
          paramc1 = this.TAG;
          paramc2 = new StringBuilder("animateMove2 fromX:").append(k).append(" fromY:").append(m).append(" toX:").append(i).append(" toY:").append(j).append(" deltaX:").append(n).append(" deltaY:").append(i1).append(" holder.left:");
          localObject = paramv.aus;
          p.g(localObject, "holder.itemView");
          paramc2 = paramc2.append(((View)localObject).getLeft()).append(" holder.top:");
          localObject = paramv.aus;
          p.g(localObject, "holder.itemView");
          Log.d(paramc1, ((View)localObject).getTop() + " holder.position:" + paramv.lR());
          AppMethodBeat.o(236480);
          return true;
        }
      }
      x(paramv);
      AppMethodBeat.o(236480);
      return false;
    }
    if (!erD())
    {
      localObject = this.hak.getAdapter();
      if ((localObject != null) && (((RecyclerView.a)localObject).getItemCount() == 2) && (paramv.lR() == 1))
      {
        i = paramc1.left;
        j = paramc1.top;
        paramc1 = MultiTaskUIC.Ago;
        k = MultiTaskUIC.esn();
        paramc1 = MultiTaskUIC.Ago;
        b(paramv, i, j, k, MultiTaskUIC.esm());
        AppMethodBeat.o(236480);
        return true;
      }
      localObject = this.hak.getAdapter();
      if ((localObject != null) && (((RecyclerView.a)localObject).getItemCount() == 3))
      {
        if (paramv.lR() == 1)
        {
          i = paramc1.left;
          j = paramc1.top;
          paramc1 = MultiTaskUIC.Ago;
          b(paramv, i, j, 0, MultiTaskUIC.esp());
          AppMethodBeat.o(236480);
          return true;
        }
        if (paramv.lR() == 2)
        {
          i = paramc1.left;
          j = paramc1.top;
          k = paramc2.left;
          m = paramc2.top;
          paramc1 = MultiTaskUIC.Ago;
          a(paramv, i, j, k, m, MultiTaskUIC.esp());
          AppMethodBeat.o(236480);
          return true;
        }
      }
    }
    if (erD())
    {
      localObject = this.hak.getAdapter();
      if ((localObject != null) && (((RecyclerView.a)localObject).getItemCount() == 3))
      {
        paramv.lR();
        if (paramv.lR() == 2)
        {
          i = paramc1.left;
          j = paramc1.top;
          k = paramc2.left;
          m = paramc2.top;
          paramc1 = MultiTaskUIC.Ago;
          a(paramv, i, j, k, m, MultiTaskUIC.esp());
          AppMethodBeat.o(236480);
          return true;
        }
      }
    }
    boolean bool = a(paramv, paramc1.left, paramc1.top, paramc2.left, paramc2.top);
    AppMethodBeat.o(236480);
    return bool;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(236493);
    if (!((Collection)this.amm).isEmpty())
    {
      i = 1;
      label128:
      label149:
      label170:
      if (i == 0)
      {
        if (((Collection)this.amo).isEmpty()) {
          break label250;
        }
        i = 1;
        label44:
        label191:
        if (i == 0)
        {
          if (((Collection)this.amn).isEmpty()) {
            break label255;
          }
          i = 1;
          label65:
          label212:
          if (i == 0)
          {
            if (((Collection)this.aml).isEmpty()) {
              break label260;
            }
            i = 1;
            label86:
            if (i == 0)
            {
              if (((Collection)this.amt).isEmpty()) {
                break label265;
              }
              i = 1;
              label107:
              if (i == 0)
              {
                if (((Collection)this.amu).isEmpty()) {
                  break label270;
                }
                i = 1;
                if (i == 0)
                {
                  if (((Collection)this.ams).isEmpty()) {
                    break label275;
                  }
                  i = 1;
                  if (i == 0)
                  {
                    if (((Collection)this.amv).isEmpty()) {
                      break label280;
                    }
                    i = 1;
                    if (i == 0)
                    {
                      if (((Collection)this.amq).isEmpty()) {
                        break label285;
                      }
                      i = 1;
                      if (i == 0)
                      {
                        if (((Collection)this.amp).isEmpty()) {
                          break label290;
                        }
                        i = 1;
                        if (i == 0) {
                          if (((Collection)this.amr).isEmpty()) {
                            break label295;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label260:
    label265:
    label270:
    label275:
    label280:
    label285:
    label290:
    label295:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label300;
      }
      AppMethodBeat.o(236493);
      return true;
      i = 0;
      break;
      label250:
      i = 0;
      break label44;
      label255:
      i = 0;
      break label65;
      i = 0;
      break label86;
      i = 0;
      break label107;
      i = 0;
      break label128;
      i = 0;
      break label149;
      i = 0;
      break label170;
      i = 0;
      break label191;
      i = 0;
      break label212;
    }
    label300:
    AppMethodBeat.o(236493);
    return false;
  }
  
  public final void jD()
  {
    AppMethodBeat.i(236478);
    Log.d(this.TAG, "runPendingAnimations");
    boolean bool1;
    boolean bool2;
    label50:
    boolean bool3;
    if (!((Collection)this.aml).isEmpty())
    {
      bool1 = true;
      if (((Collection)this.amn).isEmpty()) {
        break label208;
      }
      bool2 = true;
      if (((Collection)this.amo).isEmpty()) {
        break label213;
      }
      bool3 = true;
      label68:
      if (((Collection)this.amm).isEmpty()) {
        break label219;
      }
    }
    Object localObject1;
    Object localObject2;
    label208:
    label213:
    label219:
    for (int i = 1;; i = 0)
    {
      localObject1 = this.aml.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RecyclerView.v)((Iterator)localObject1).next();
        p.g(localObject2, "holder");
        p.h(localObject2, "holder");
        final View localView = ((RecyclerView.v)localObject2).aus;
        p.g(localView, "holder.itemView");
        final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
        this.amu.add(localObject2);
        localViewPropertyAnimator.setDuration(ly()).alpha(0.0F).setListener((Animator.AnimatorListener)new k(this, (RecyclerView.v)localObject2, localViewPropertyAnimator, localView)).start();
      }
      bool1 = false;
      break;
      bool2 = false;
      break label50;
      bool3 = false;
      break label68;
    }
    this.aml.clear();
    if (bool2)
    {
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).addAll((Collection)this.amn);
      this.amq.add(localObject2);
      this.amn.clear();
      localObject1 = (Runnable)new o(this, (ArrayList)localObject2);
      if (bool1)
      {
        localObject2 = ((d)((ArrayList)localObject2).get(0)).amO.aus;
        p.g(localObject2, "moves[0].holder.itemView");
        u.a((View)localObject2, (Runnable)localObject1, ly());
      }
    }
    else
    {
      if (bool3)
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll((Collection)this.amo);
        this.amr.add(localObject2);
        this.amo.clear();
        localObject1 = (Runnable)new n(this, (ArrayList)localObject2);
        if (!bool1) {
          break label554;
        }
        localObject2 = ((a)((ArrayList)localObject2).get(0)).amI;
        if (localObject2 == null) {
          break label554;
        }
        u.a(((RecyclerView.v)localObject2).aus, (Runnable)localObject1, ly());
      }
      label425:
      if (i != 0)
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll((Collection)this.amm);
        this.amp.add(localObject2);
        this.amm.clear();
        localObject1 = (Runnable)new m(this, (ArrayList)localObject2);
        if ((!bool1) && (!bool2) && (!bool3)) {
          break label564;
        }
        localObject2 = ((RecyclerView.v)((ArrayList)localObject2).get(0)).aus;
        p.g(localObject2, "additions[0].itemView");
        u.a((View)localObject2, (Runnable)localObject1, ly());
      }
    }
    for (;;)
    {
      l(bool1, bool2, bool3);
      AppMethodBeat.o(236478);
      return;
      ((Runnable)localObject1).run();
      break;
      label554:
      ((Runnable)localObject1).run();
      break label425;
      label564:
      ((Runnable)localObject1).run();
    }
  }
  
  public final void jE()
  {
    AppMethodBeat.i(236494);
    if (!isRunning()) {
      lC();
    }
    AppMethodBeat.o(236494);
  }
  
  public final void jF()
  {
    AppMethodBeat.i(236496);
    Log.d(this.TAG, "endAnimations");
    int i = this.amn.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = this.amn.get(i);
      p.g(localObject1, "mPendingMoves[i]");
      localObject1 = (d)localObject1;
      localObject2 = ((d)localObject1).amO.aus;
      p.g(localObject2, "item.holder.itemView");
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      x(((d)localObject1).amO);
      this.amn.remove(i);
      Log.d(this.TAG, "endAnimations, pending move reset!");
      i -= 1;
    }
    i = this.aml.size() - 1;
    while (i >= 0)
    {
      localObject1 = this.aml.get(i);
      p.g(localObject1, "mPendingRemovals[i]");
      w((RecyclerView.v)localObject1);
      this.aml.remove(i);
      i -= 1;
    }
    i = this.amm.size() - 1;
    while (i >= 0)
    {
      localObject1 = this.amm.get(i);
      p.g(localObject1, "mPendingAdditions[i]");
      localObject1 = (RecyclerView.v)localObject1;
      localObject2 = ((RecyclerView.v)localObject1).aus;
      p.g(localObject2, "item.itemView");
      ((View)localObject2).setAlpha(1.0F);
      y((RecyclerView.v)localObject1);
      this.amm.remove(i);
      i -= 1;
    }
    i = this.amo.size() - 1;
    while (i >= 0)
    {
      localObject1 = this.amo.get(i);
      p.g(localObject1, "mPendingChanges[i]");
      a((a)localObject1);
      i -= 1;
    }
    this.amo.clear();
    if (!isRunning())
    {
      AppMethodBeat.o(236496);
      return;
    }
    i = this.amq.size() - 1;
    int j;
    View localView;
    while (i >= 0)
    {
      localObject1 = this.amq.get(i);
      p.g(localObject1, "mMovesList[i]");
      localObject1 = (ArrayList)localObject1;
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = ((ArrayList)localObject1).get(j);
        p.g(localObject2, "moves[j]");
        localObject2 = (d)localObject2;
        localView = ((d)localObject2).amO.aus;
        p.g(localView, "item.itemView");
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        x(((d)localObject2).amO);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.amq.remove(localObject1);
        }
        Log.d(this.TAG, "endAnimations, moveReset Translation");
        j -= 1;
      }
      i -= 1;
    }
    i = this.amp.size() - 1;
    while (i >= 0)
    {
      localObject1 = this.amp.get(i);
      p.g(localObject1, "mAdditionsList[i]");
      localObject1 = (ArrayList)localObject1;
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = ((ArrayList)localObject1).get(j);
        p.g(localObject2, "additions[j]");
        localObject2 = (RecyclerView.v)localObject2;
        localView = ((RecyclerView.v)localObject2).aus;
        p.g(localView, "item.itemView");
        localView.setAlpha(1.0F);
        y((RecyclerView.v)localObject2);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.amp.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.amr.size() - 1;
    while (i >= 0)
    {
      localObject1 = this.amr.get(i);
      p.g(localObject1, "mChangesList[i]");
      localObject1 = (ArrayList)localObject1;
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = ((ArrayList)localObject1).get(j);
        p.g(localObject2, "changes[j]");
        a((a)localObject2);
        if (((ArrayList)localObject1).isEmpty()) {
          this.amr.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    n((List)this.amu);
    n((List)this.amt);
    n((List)this.ams);
    n((List)this.amv);
    lC();
    AppMethodBeat.o(236496);
  }
  
  public final void o(RecyclerView.v paramv)
  {
    AppMethodBeat.i(236495);
    p.h(paramv, "viewHolder");
    super.o(paramv);
    com.tencent.mm.plugin.multitask.ui.minusscreen.d.a locala = this.AdR;
    if (locala != null)
    {
      locala.ac(paramv);
      AppMethodBeat.o(236495);
      return;
    }
    AppMethodBeat.o(236495);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$ChangeInfo;", "", "oldHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "newHolder", "fromX", "", "fromY", "toX", "toY", "newTransX", "", "newTransY", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator;Landroid/support/v7/widget/RecyclerView$ViewHolder;Landroid/support/v7/widget/RecyclerView$ViewHolder;IIIIFF)V", "getFromX", "()I", "setFromX", "(I)V", "getFromY", "setFromY", "getNewHolder", "()Landroid/support/v7/widget/RecyclerView$ViewHolder;", "setNewHolder", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;)V", "getNewTransX", "()F", "setNewTransX", "(F)V", "getNewTransY", "setNewTransY", "getOldHolder", "setOldHolder", "getToX", "setToX", "getToY", "setToY", "ui-multitask_release"})
  public final class a
  {
    float AdT;
    float AdU;
    RecyclerView.v amI;
    RecyclerView.v amJ;
    int amK;
    int amL;
    int amM;
    int amN;
    
    public a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2)
    {
      this.amI = paramv;
      this.amJ = paramInt1;
      this.amK = paramInt2;
      this.amL = paramInt3;
      this.amM = paramInt4;
      this.amN = paramFloat1;
      this.AdT = paramFloat2;
      Object localObject;
      this.AdU = localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$LayoutInfo;", "", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "fromWidth", "", "toWidth", "animator", "Landroid/animation/ValueAnimator;", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator;Landroid/support/v7/widget/RecyclerView$ViewHolder;IILandroid/animation/ValueAnimator;)V", "getAnimator", "()Landroid/animation/ValueAnimator;", "setAnimator", "(Landroid/animation/ValueAnimator;)V", "getFromWidth", "()I", "setFromWidth", "(I)V", "getHolder", "()Landroid/support/v7/widget/RecyclerView$ViewHolder;", "setHolder", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;)V", "getToWidth", "setToWidth", "ui-multitask_release"})
  public final class c
  {
    int AdW;
    int AdX;
    RecyclerView.v amO;
    ValueAnimator animator;
    
    private c(int paramInt1, int paramInt2, ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(236456);
      this.amO = paramInt1;
      this.AdW = paramInt2;
      this.AdX = paramValueAnimator;
      this.animator = null;
      AppMethodBeat.o(236456);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$MoveInfo;", "", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "fromX", "", "fromY", "toX", "toY", "moveType", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator;Landroid/support/v7/widget/RecyclerView$ViewHolder;IIIII)V", "getFromX", "()I", "setFromX", "(I)V", "getFromY", "setFromY", "getHolder", "()Landroid/support/v7/widget/RecyclerView$ViewHolder;", "setHolder", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;)V", "getMoveType", "getToX", "setToX", "getToY", "setToY", "ui-multitask_release"})
  public final class d
  {
    int amK;
    int amL;
    int amM;
    int amN;
    RecyclerView.v amO;
    final int oMi;
    
    public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      AppMethodBeat.i(236457);
      this.amO = paramInt1;
      this.amK = paramInt2;
      this.amL = paramInt3;
      this.amM = paramInt4;
      this.amN = paramInt5;
      int i;
      this.oMi = i;
      AppMethodBeat.o(236457);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateAddImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "ui-multitask_release"})
  public static final class e
    extends AnimatorListenerAdapter
  {
    e(RecyclerView.v paramv, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(236459);
      p.h(paramAnimator, "animator");
      this.hCI.setAlpha(1.0F);
      AppMethodBeat.o(236459);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(236460);
      p.h(paramAnimator, "animator");
      this.wrO.setListener(null);
      this.AdV.y(this.wrN);
      this.AdV.ams.remove(this.wrN);
      this.AdV.jE();
      AppMethodBeat.o(236460);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(236458);
      p.h(paramAnimator, "animator");
      AppMethodBeat.o(236458);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateChangeImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animator", "Landroid/animation/Animator;", "onAnimationStart", "ui-multitask_release"})
  public static final class f
    extends AnimatorListenerAdapter
  {
    f(a.a parama, ViewPropertyAnimator paramViewPropertyAnimator, View paramView, float paramFloat1, float paramFloat2) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(236462);
      p.h(paramAnimator, "animator");
      this.AdZ.setListener(null);
      this.hCI.setAlpha(1.0F);
      this.hCI.setTranslationX(this.Aea);
      this.hCI.setTranslationY(this.Aeb);
      this.AdV.z(this.AdY.amI);
      this.AdV.amv.remove(this.AdY.amI);
      this.AdV.jE();
      AppMethodBeat.o(236462);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(236461);
      p.h(paramAnimator, "animator");
      AppMethodBeat.o(236461);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateChangeImpl$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animator", "Landroid/animation/Animator;", "onAnimationStart", "ui-multitask_release"})
  public static final class g
    extends AnimatorListenerAdapter
  {
    g(a.a parama, ViewPropertyAnimator paramViewPropertyAnimator, View paramView, float paramFloat1, float paramFloat2) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(236464);
      p.h(paramAnimator, "animator");
      this.Aec.setListener(null);
      this.Aed.setAlpha(1.0F);
      this.Aed.setTranslationX(this.Aea);
      this.Aed.setTranslationY(this.Aeb);
      this.AdV.z(this.AdY.amJ);
      this.AdV.amv.remove(this.AdY.amJ);
      this.AdV.jE();
      AppMethodBeat.o(236464);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(236463);
      p.h(paramAnimator, "animator");
      AppMethodBeat.o(236463);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateLayoutImpl$1$1"})
  static final class h
    implements ValueAnimator.AnimatorUpdateListener
  {
    h(a parama, View paramView1, View paramView2, a.c paramc) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(236465);
      p.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(236465);
        throw paramValueAnimator;
      }
      int i = ((Integer)paramValueAnimator).intValue();
      paramValueAnimator = this.Aee;
      p.g(paramValueAnimator, "imgView");
      paramValueAnimator = paramValueAnimator.getLayoutParams();
      MultiTaskUIC.a locala = MultiTaskUIC.Ago;
      float f = i - MultiTaskUIC.esb();
      locala = MultiTaskUIC.Ago;
      paramValueAnimator.height = kotlin.h.a.cR(f * MultiTaskUIC.esw());
      this.tBN.getLayoutParams().width = i;
      paramValueAnimator = this.tBN.getLayoutParams();
      f = i;
      locala = MultiTaskUIC.Ago;
      paramValueAnimator.height = kotlin.h.a.cR(f * MultiTaskUIC.esv());
      this.tBN.requestLayout();
      AppMethodBeat.o(236465);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateLayoutImpl$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "ui-multitask_release"})
  public static final class i
    extends AnimatorListenerAdapter
  {
    i(ValueAnimator paramValueAnimator, a parama, View paramView1, View paramView2, a.c paramc) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(236467);
      p.h(paramAnimator, "animator");
      paramAnimator = this.Aee;
      p.g(paramAnimator, "imgView");
      paramAnimator = paramAnimator.getLayoutParams();
      int i = this.Aef.AdX;
      MultiTaskUIC.a locala = MultiTaskUIC.Ago;
      float f = i - MultiTaskUIC.esb();
      locala = MultiTaskUIC.Ago;
      paramAnimator.height = kotlin.h.a.cR(f * MultiTaskUIC.esw());
      this.tBN.getLayoutParams().width = this.Aef.AdX;
      paramAnimator = this.tBN.getLayoutParams();
      f = this.Aef.AdX;
      locala = MultiTaskUIC.Ago;
      paramAnimator.height = kotlin.h.a.cR(f * MultiTaskUIC.esv());
      this.tBN.requestLayout();
      AppMethodBeat.o(236467);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(236468);
      p.h(paramAnimator, "animator");
      this.Aeg.removeListener((Animator.AnimatorListener)this);
      this.Aef.animator = null;
      AppMethodBeat.o(236468);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(236466);
      p.h(paramAnimator, "animator");
      AppMethodBeat.o(236466);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateMoveImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "ui-multitask_release"})
  public static final class j
    extends AnimatorListenerAdapter
  {
    j(RecyclerView.v paramv, int paramInt1, View paramView, int paramInt2, ViewPropertyAnimator paramViewPropertyAnimator) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(236470);
      p.h(paramAnimator, "animator");
      if (this.Aeh != 0) {
        this.hCI.setTranslationX(0.0F);
      }
      if (this.Aei != 0) {
        this.hCI.setTranslationY(0.0F);
      }
      AppMethodBeat.o(236470);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(236471);
      p.h(paramAnimator, "animator");
      this.wrO.setListener(null);
      this.AdV.x(this.wrN);
      this.AdV.amt.remove(this.wrN);
      this.AdV.jE();
      AppMethodBeat.o(236471);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(236469);
      p.h(paramAnimator, "animator");
      this.AdV.B(this.wrN);
      AppMethodBeat.o(236469);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateRemoveImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animator", "Landroid/animation/Animator;", "onAnimationStart", "ui-multitask_release"})
  public static final class k
    extends AnimatorListenerAdapter
  {
    k(RecyclerView.v paramv, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(236473);
      p.h(paramAnimator, "animator");
      localViewPropertyAnimator.setListener(null);
      localView.setAlpha(1.0F);
      this.AdV.w(this.wrN);
      this.AdV.amu.remove(this.wrN);
      this.AdV.jE();
      AppMethodBeat.o(236473);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(236472);
      p.h(paramAnimator, "animator");
      this.AdV.A(this.wrN);
      AppMethodBeat.o(236472);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(a parama, ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(236474);
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (a.c)localIterator.next();
        Object localObject2 = this.AdV;
        Object localObject4 = ((a.c)localObject1).amO;
        p.g(localObject1, "info");
        p.h(localObject4, "holder");
        p.h(localObject1, "info");
        View localView = ((RecyclerView.v)localObject4).aus;
        p.g(localView, "holder.itemView");
        Object localObject3 = ((RecyclerView.v)localObject4).aus.findViewById(2131305006);
        Log.d(((a)localObject2).TAG, "animateLayoutImpl adapterPosition:" + ((RecyclerView.v)localObject4).lR() + " width:" + localView.getLayoutParams().width + " height:" + localView.getLayoutParams().height + " fromWidth:" + ((a.c)localObject1).AdW + " toWidth:" + ((a.c)localObject1).AdX);
        if (Math.abs(((a.c)localObject1).AdW - ((a.c)localObject1).AdX) > 1)
        {
          localObject4 = ValueAnimator.ofInt(new int[] { ((a.c)localObject1).AdW, ((a.c)localObject1).AdX });
          ((ValueAnimator)localObject4).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a.h((a)localObject2, (View)localObject3, localView, (a.c)localObject1));
          ((ValueAnimator)localObject4).addListener((Animator.AnimatorListener)new a.i((ValueAnimator)localObject4, (a)localObject2, (View)localObject3, localView, (a.c)localObject1));
          p.g(localObject4, "it");
          ((ValueAnimator)localObject4).setDuration(((a)localObject2).lv());
          ((ValueAnimator)localObject4).start();
          ((a.c)localObject1).animator = ((ValueAnimator)localObject4);
        }
        else
        {
          p.g(localObject3, "imgView");
          localObject2 = ((View)localObject3).getLayoutParams();
          int i = ((a.c)localObject1).AdX;
          localObject3 = MultiTaskUIC.Ago;
          float f = i - MultiTaskUIC.esb();
          localObject3 = MultiTaskUIC.Ago;
          ((ViewGroup.LayoutParams)localObject2).height = kotlin.h.a.cR(f * MultiTaskUIC.esw());
          localView.getLayoutParams().width = ((a.c)localObject1).AdX;
          localObject2 = localView.getLayoutParams();
          f = ((a.c)localObject1).AdX;
          localObject1 = MultiTaskUIC.Ago;
          ((ViewGroup.LayoutParams)localObject2).height = kotlin.h.a.cR(f * MultiTaskUIC.esv());
          localView.requestLayout();
        }
      }
      localArrayList.clear();
      this.AdV.AdQ.remove(localArrayList);
      AppMethodBeat.o(236474);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(a parama, ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(236475);
      Iterator localIterator = this.Aek.iterator();
      while (localIterator.hasNext())
      {
        RecyclerView.v localv = (RecyclerView.v)localIterator.next();
        a locala = this.AdV;
        p.g(localv, "holder");
        p.h(localv, "holder");
        View localView = localv.aus;
        p.g(localView, "holder.itemView");
        ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
        locala.ams.add(localv);
        localViewPropertyAnimator.alpha(1.0F).setDuration(locala.lx()).setListener((Animator.AnimatorListener)new a.e(locala, localv, localView, localViewPropertyAnimator)).start();
      }
      this.Aek.clear();
      this.AdV.amp.remove(this.Aek);
      AppMethodBeat.o(236475);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(a parama, ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(236476);
      Iterator localIterator = this.Ael.iterator();
      if (localIterator.hasNext())
      {
        a.a locala = (a.a)localIterator.next();
        a locala1 = this.AdV;
        p.g(locala, "change");
        p.h(locala, "changeInfo");
        Object localObject1 = locala.amI;
        if (localObject1 != null)
        {
          localObject1 = ((RecyclerView.v)localObject1).aus;
          label71:
          localObject2 = locala.amJ;
          if (localObject2 == null) {
            break label282;
          }
        }
        label282:
        for (Object localObject2 = ((RecyclerView.v)localObject2).aus;; localObject2 = null)
        {
          float f1 = locala.AdT;
          float f2 = locala.AdU;
          if (localObject1 != null)
          {
            ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject1).animate().setDuration(locala1.lA());
            locala1.amv.add(locala.amI);
            localViewPropertyAnimator.translationX(locala.amM - locala.amK);
            localViewPropertyAnimator.translationY(locala.amN - locala.amL);
            localViewPropertyAnimator.alpha(0.0F).setListener((Animator.AnimatorListener)new a.f(locala1, locala, localViewPropertyAnimator, (View)localObject1, f1, f2)).start();
          }
          if (localObject2 == null) {
            break;
          }
          localObject1 = ((View)localObject2).animate();
          locala1.amv.add(locala.amJ);
          ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(locala1.lA()).alpha(1.0F).setListener((Animator.AnimatorListener)new a.g(locala1, locala, (ViewPropertyAnimator)localObject1, (View)localObject2, f1, f2)).start();
          break;
          localObject1 = null;
          break label71;
        }
      }
      this.Ael.clear();
      this.AdV.amr.remove(this.Ael);
      AppMethodBeat.o(236476);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(a parama, ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(236477);
      Iterator localIterator = this.Aem.iterator();
      if (localIterator.hasNext())
      {
        Object localObject1 = (a.d)localIterator.next();
        a locala = this.AdV;
        RecyclerView.v localv = ((a.d)localObject1).amO;
        int i1 = ((a.d)localObject1).amK;
        int n = ((a.d)localObject1).amL;
        int j = ((a.d)localObject1).amM;
        int k = ((a.d)localObject1).amN;
        int m = ((a.d)localObject1).oMi;
        p.h(localv, "holder");
        localObject1 = locala.TAG;
        Object localObject2 = new StringBuilder("animateMoveImpl pos:").append(localv.lR()).append(" fromX:").append(i1).append(" fromY:").append(n).append(" toX:").append(j).append(" toY:").append(k).append(" holder.left:");
        View localView = localv.aus;
        p.g(localView, "holder.itemView");
        localObject2 = ((StringBuilder)localObject2).append(localView.getLeft()).append(" holder.top:");
        localView = localv.aus;
        p.g(localView, "holder.itemView");
        Log.d((String)localObject1, localView.getTop());
        localObject1 = locala.hak.getAdapter();
        int i;
        if (localObject1 != null)
        {
          i = ((RecyclerView.a)localObject1).getItemCount();
          label242:
          localObject1 = localv.aus;
          p.g(localObject1, "holder.itemView");
          i1 = j - i1;
          n = k - n;
          if (i1 != 0)
          {
            if ((i > 3) || (m != 1)) {
              break label386;
            }
            ((View)localObject1).animate().translationX(j);
          }
          label295:
          if (n != 0)
          {
            if ((i > 3) || (m != 1)) {
              break label423;
            }
            ((View)localObject1).animate().translationY(k);
          }
        }
        for (;;)
        {
          localObject2 = ((View)localObject1).animate();
          locala.amt.add(localv);
          ((ViewPropertyAnimator)localObject2).setDuration(locala.lv()).setListener((Animator.AnimatorListener)new a.j(locala, localv, i1, (View)localObject1, n, (ViewPropertyAnimator)localObject2)).start();
          break;
          i = 0;
          break label242;
          label386:
          if ((i <= 3) && (m == 2))
          {
            ((View)localObject1).animate().translationX(0.0F);
            break label295;
          }
          ((View)localObject1).animate().translationX(0.0F);
          break label295;
          label423:
          if ((i <= 3) && (m == 2)) {
            ((View)localObject1).animate().translationY(k);
          } else {
            ((View)localObject1).animate().translationY(0.0F);
          }
        }
      }
      this.Aem.clear();
      this.AdV.amq.remove(this.Aem);
      AppMethodBeat.o(236477);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.a.a
 * JD-Core Version:    0.7.0.1
 */