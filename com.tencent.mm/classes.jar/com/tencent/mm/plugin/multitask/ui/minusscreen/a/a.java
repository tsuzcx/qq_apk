package com.tencent.mm.plugin.multitask.ui.minusscreen.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import androidx.core.g.w;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.f.c;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.ui.a.c;
import com.tencent.mm.plugin.multitask.ui.a.c.a;
import com.tencent.mm.plugin.multitask.ui.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator;", "Landroidx/recyclerview/widget/SimpleItemAnimator;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onItemListener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "addDelay", "", "getAddDelay", "()J", "changeDelay", "getChangeDelay", "mAddAnimations", "Ljava/util/ArrayList;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlin/collections/ArrayList;", "getMAddAnimations", "()Ljava/util/ArrayList;", "setMAddAnimations", "(Ljava/util/ArrayList;)V", "mAdditionsList", "getMAdditionsList", "setMAdditionsList", "mChangeAnimations", "getMChangeAnimations", "setMChangeAnimations", "mChangesList", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$ChangeInfo;", "getMChangesList", "setMChangesList", "mLayoutsList", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$LayoutInfo;", "getMLayoutsList", "setMLayoutsList", "mMoveAnimations", "getMMoveAnimations", "setMMoveAnimations", "mMovesList", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$MoveInfo;", "getMMovesList", "setMMovesList", "mPendingAdditions", "getMPendingAdditions", "setMPendingAdditions", "mPendingChanges", "getMPendingChanges", "mPendingMoves", "getMPendingMoves", "mPendingRemovals", "getMPendingRemovals", "setMPendingRemovals", "mRemoveAnimations", "getMRemoveAnimations", "setMRemoveAnimations", "moveDelay", "getMoveDelay", "getOnItemListener", "()Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "removeDelay", "getRemoveDelay", "animateAdd", "", "viewHolder", "animateAddImpl", "", "holder", "animateChange", "oldHolder", "newHolder", "fromX", "", "fromY", "toX", "toY", "animateChangeImpl", "changeInfo", "animateLayoutImpl", "info", "animateMove", "animateMove1", "moveType", "animateMove2", "animateMove3", "finalY", "animateMoveImpl", "animatePersistence", "preInfo", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;", "postInfo", "animateRemove", "animateRemoveImpl", "canReuseUpdatedViewHolder", "payloads", "", "", "cancelAll", "viewHolders", "checkRefreshLayout", "removalsPending", "movesPending", "changesPending", "dispatchFinishedWhenDone", "endAnimation", "item", "endAnimations", "endChangeAnimation", "infoList", "", "endChangeAnimationIfNecessary", "isAddAnimation", "isChangeAnimation", "isMoveAnimation", "isRemoveAnimation", "isRunning", "onAnimationFinished", "resetAnimation", "runPendingAnimations", "ChangeInfo", "Companion", "LayoutInfo", "MoveInfo", "ui-multitask_release"})
public final class a
  extends y
{
  public static final a.b FKu;
  private static TimeInterpolator afY;
  ArrayList<ArrayList<c>> FKs;
  private final com.tencent.mm.plugin.multitask.ui.minusscreen.d.a FKt;
  final String TAG;
  private ArrayList<RecyclerView.v> afZ;
  private ArrayList<RecyclerView.v> aga;
  private final ArrayList<d> agb;
  private final ArrayList<a> agc;
  ArrayList<ArrayList<RecyclerView.v>> agd;
  ArrayList<ArrayList<d>> age;
  ArrayList<ArrayList<a>> agf;
  ArrayList<RecyclerView.v> agg;
  ArrayList<RecyclerView.v> agh;
  ArrayList<RecyclerView.v> agi;
  ArrayList<RecyclerView.v> agj;
  final RecyclerView jLl;
  
  static
  {
    AppMethodBeat.i(196832);
    FKu = new a.b((byte)0);
    AppMethodBeat.o(196832);
  }
  
  public a(RecyclerView paramRecyclerView, com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama)
  {
    AppMethodBeat.i(196830);
    this.jLl = paramRecyclerView;
    this.FKt = parama;
    this.TAG = "MicroMsg.MultiTask.MinusAnimator";
    this.afZ = new ArrayList();
    this.aga = new ArrayList();
    this.agb = new ArrayList();
    this.agc = new ArrayList();
    this.agd = new ArrayList();
    this.age = new ArrayList();
    this.agf = new ArrayList();
    this.FKs = new ArrayList();
    this.agg = new ArrayList();
    this.agh = new ArrayList();
    this.agi = new ArrayList();
    this.agj = new ArrayList();
    AppMethodBeat.o(196830);
  }
  
  private final void a(a parama)
  {
    AppMethodBeat.i(196788);
    if (parama.agw != null) {
      a(parama, parama.agw);
    }
    if (parama.agx != null) {
      a(parama, parama.agx);
    }
    AppMethodBeat.o(196788);
  }
  
  private final void a(List<a> paramList, RecyclerView.v paramv)
  {
    AppMethodBeat.i(196787);
    int i = ((Collection)paramList).size() - 1;
    while (i >= 0)
    {
      a locala = (a)paramList.get(i);
      if ((a(locala, paramv)) && (locala.agw == null) && (locala.agx == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
    AppMethodBeat.o(196787);
  }
  
  private boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(196781);
    p.k(paramv, "holder");
    Object localObject1 = paramv.amk;
    p.j(localObject1, "holder.itemView");
    Object localObject2 = paramv.amk;
    p.j(localObject2, "holder.itemView");
    paramInt1 += (int)((View)localObject2).getTranslationX();
    localObject2 = paramv.amk;
    p.j(localObject2, "holder.itemView");
    paramInt2 += (int)((View)localObject2).getTranslationY();
    d(paramv);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      A(paramv);
      AppMethodBeat.o(196781);
      return false;
    }
    if (i != 0) {
      ((View)localObject1).setTranslationX(-i);
    }
    if (j != 0) {
      ((View)localObject1).setTranslationY(-j);
    }
    this.agb.add(new d(paramv, paramInt1, paramInt4, paramInt3, paramInt5, 2));
    localObject1 = this.TAG;
    localObject2 = new StringBuilder("animateMove3 fromX:").append(paramInt1).append(" fromY:").append(paramInt2).append(" toX:").append(paramInt3).append(" toY:").append(paramInt4).append(" deltaX:").append(i).append(" deltaY:").append(j).append(" holder.left:");
    View localView = paramv.amk;
    p.j(localView, "holder.itemView");
    localObject2 = ((StringBuilder)localObject2).append(localView.getLeft()).append(" holder.top:");
    localView = paramv.amk;
    p.j(localView, "holder.itemView");
    Log.d((String)localObject1, localView.getTop() + " holder.position:" + paramv.md());
    AppMethodBeat.o(196781);
    return true;
  }
  
  private final boolean a(a parama, RecyclerView.v paramv)
  {
    AppMethodBeat.i(196795);
    if (parama.agx == paramv) {
      parama.agx = null;
    }
    for (;;)
    {
      if (paramv != null)
      {
        View localView = paramv.amk;
        p.j(localView, "it.itemView");
        localView.setAlpha(1.0F);
        localView = paramv.amk;
        p.j(localView, "it.itemView");
        localView.setTranslationX(parama.FKv);
        localView = paramv.amk;
        p.j(localView, "it.itemView");
        localView.setTranslationY(parama.FKw);
        Log.d(this.TAG, "endAnimations,change reset!, transX: " + parama.FKv + " transY: " + parama.FKw);
      }
      C(paramv);
      AppMethodBeat.o(196795);
      return true;
      if (parama.agw != paramv) {
        break;
      }
      parama.agw = null;
    }
    AppMethodBeat.o(196795);
    return false;
  }
  
  private boolean b(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(196773);
    p.k(paramv, "holder");
    Object localObject1 = paramv.amk;
    p.j(localObject1, "holder.itemView");
    Object localObject2 = paramv.amk;
    p.j(localObject2, "holder.itemView");
    paramInt1 += (int)((View)localObject2).getTranslationX();
    localObject2 = paramv.amk;
    p.j(localObject2, "holder.itemView");
    paramInt2 += (int)((View)localObject2).getTranslationY();
    d(paramv);
    localObject2 = paramv.amk;
    p.j(localObject2, "holder.itemView");
    int i = paramInt1 - ((View)localObject2).getLeft();
    localObject2 = paramv.amk;
    p.j(localObject2, "holder.itemView");
    int j = paramInt2 - ((View)localObject2).getTop();
    if ((i == 0) && (j == 0))
    {
      A(paramv);
      AppMethodBeat.o(196773);
      return false;
    }
    if (i != 0) {
      ((View)localObject1).setTranslationX(i);
    }
    if (j != 0) {
      ((View)localObject1).setTranslationY(j);
    }
    this.agb.add(new d(paramv, paramInt1, paramInt2, paramInt3, paramInt4, 1));
    localObject1 = this.TAG;
    localObject2 = new StringBuilder("animateMove1 fromX:").append(paramInt1).append(" fromY:").append(paramInt2).append(" toX:").append(paramInt3).append(" toY:").append(paramInt4).append(" deltaX:").append(i).append(" deltaY:").append(j).append(" holder.left:");
    View localView = paramv.amk;
    p.j(localView, "holder.itemView");
    localObject2 = ((StringBuilder)localObject2).append(localView.getLeft()).append(" holder.top:");
    localView = paramv.amk;
    p.j(localView, "holder.itemView");
    Log.d((String)localObject1, localView.getTop() + " holder.position:" + paramv.md());
    AppMethodBeat.o(196773);
    return true;
  }
  
  private void d(RecyclerView.v paramv)
  {
    AppMethodBeat.i(196800);
    p.k(paramv, "holder");
    if (afY == null) {
      afY = new ValueAnimator().getInterpolator();
    }
    ViewPropertyAnimator localViewPropertyAnimator = paramv.amk.animate();
    p.j(localViewPropertyAnimator, "holder.itemView.animate()");
    localViewPropertyAnimator.setInterpolator(afY);
    c(paramv);
    AppMethodBeat.o(196800);
  }
  
  private final boolean fbI()
  {
    AppMethodBeat.i(196726);
    if (this.aga.size() > 0)
    {
      AppMethodBeat.o(196726);
      return true;
    }
    AppMethodBeat.o(196726);
    return false;
  }
  
  private final void k(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(196713);
    Object localObject1 = this.jLl.getAdapter();
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
      j = this.jLl.getChildCount();
      i = 0;
      if (i >= j) {
        break label408;
      }
      localView = this.jLl.getChildAt(i);
      localObject2 = this.jLl.bf(localView);
      if (localObject2 != null) {
        if ((localObject2 instanceof i)) {
          break label533;
        }
      }
    }
    label519:
    label526:
    label533:
    for (localObject1 = null;; localObject1 = localObject2)
    {
      localObject1 = (i)localObject1;
      int k;
      if ((localObject1 != null) && ((com.tencent.mm.plugin.multitask.ui.minusscreen.b.a)((i)localObject1).ihX() != null))
      {
        p.j(localView, "child");
        k = localView.getWidth();
        localObject1 = c.FNc;
        if (k < c.fco())
        {
          p.j(localObject2, "viewHolder");
          localObject1 = ((RecyclerView.v)localObject2).amk;
          p.j(localObject1, "viewHolder.itemView");
          k = ((View)localObject1).getWidth();
          localObject1 = c.FNc;
          localArrayList.add(new c((RecyclerView.v)localObject2, k, c.fco(), (byte)0));
        }
      }
      i += 1;
      break label60;
      i = 0;
      break;
      label228:
      if (i >= 3)
      {
        j = this.jLl.getChildCount();
        i = 0;
        if (i < j)
        {
          localView = this.jLl.getChildAt(i);
          localObject2 = this.jLl.bf(localView);
          if (localObject2 != null) {
            if ((localObject2 instanceof i)) {
              break label526;
            }
          }
        }
      }
      for (localObject1 = null;; localObject1 = localObject2)
      {
        localObject1 = (i)localObject1;
        if ((localObject1 != null) && ((com.tencent.mm.plugin.multitask.ui.minusscreen.b.a)((i)localObject1).ihX() != null))
        {
          p.j(localView, "child");
          k = localView.getWidth();
          localObject1 = c.FNc;
          if (k > c.fcm())
          {
            p.j(localObject2, "viewHolder");
            localObject1 = ((RecyclerView.v)localObject2).amk;
            p.j(localObject1, "viewHolder.itemView");
            k = ((View)localObject1).getWidth();
            localObject1 = c.FNc;
            localArrayList.add(new c((RecyclerView.v)localObject2, k, c.fcm(), (byte)0));
          }
        }
        i += 1;
        break;
        label408:
        this.FKs.add(localArrayList);
        localObject1 = (Runnable)new l(this, localArrayList);
        if ((paramBoolean1) || (paramBoolean2) || (paramBoolean3))
        {
          localObject2 = (c)j.lp((List)localArrayList);
          if (localObject2 != null)
          {
            localObject2 = ((c)localObject2).agC;
            if (localObject2 != null)
            {
              localObject2 = ((RecyclerView.v)localObject2).amk;
              if (localObject2 != null)
              {
                w.a((View)localObject2, (Runnable)localObject1, lK());
                AppMethodBeat.o(196713);
                return;
              }
            }
          }
          AppMethodBeat.o(196713);
          return;
        }
        ((Runnable)localObject1).run();
        AppMethodBeat.o(196713);
        return;
      }
    }
  }
  
  private static void l(List<? extends RecyclerView.v> paramList)
  {
    AppMethodBeat.i(196825);
    p.k(paramList, "viewHolders");
    int i = ((Collection)paramList).size() - 1;
    while (i >= 0)
    {
      Object localObject = (RecyclerView.v)paramList.get(i);
      if (localObject != null)
      {
        localObject = ((RecyclerView.v)localObject).amk;
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
    AppMethodBeat.o(196825);
  }
  
  public final boolean a(RecyclerView.v paramv)
  {
    AppMethodBeat.i(196741);
    p.k(paramv, "viewHolder");
    Log.d(this.TAG, "animateRemove layoutPosition:" + paramv.mc() + " adapterPosition:" + paramv.md() + " hashCode:" + paramv.hashCode());
    d(paramv);
    this.afZ.add(paramv);
    Object localObject1 = this.jLl.getAdapter();
    Object localObject2;
    int i;
    int j;
    int k;
    if ((localObject1 != null) && (((RecyclerView.a)localObject1).getItemCount() == 3))
    {
      Log.d(this.TAG, "animateRemove layoutPosition:" + paramv.mc());
      if (paramv.mc() != 2) {
        break label396;
      }
      paramv = this.jLl.cK(1);
      if (paramv != null)
      {
        Log.d(this.TAG, "animateRemove add moveInfo from adapterPosition 1");
        localObject1 = this.agb;
        p.j(paramv, "it");
        localObject2 = paramv.amk;
        p.j(localObject2, "it.itemView");
        i = ((View)localObject2).getLeft();
        localObject2 = paramv.amk;
        p.j(localObject2, "it.itemView");
        j = ((View)localObject2).getTop();
        localObject2 = paramv.amk;
        p.j(localObject2, "it.itemView");
        k = ((View)localObject2).getLeft();
        localObject2 = c.FNc;
        ((ArrayList)localObject1).add(new d(paramv, i, j, k, c.fcx(), 1));
      }
      paramv = this.jLl.cK(2);
      if (paramv != null)
      {
        Log.d(this.TAG, "animateRemove add moveInfo from adapterPosition 2");
        localObject1 = this.agb;
        p.j(paramv, "it");
        localObject2 = paramv.amk;
        p.j(localObject2, "it.itemView");
        i = ((View)localObject2).getLeft();
        localObject2 = paramv.amk;
        p.j(localObject2, "it.itemView");
        j = ((View)localObject2).getTop();
        localObject2 = paramv.amk;
        p.j(localObject2, "it.itemView");
        k = ((View)localObject2).getLeft();
        localObject2 = c.FNc;
        ((ArrayList)localObject1).add(new d(paramv, i, j, k, c.fcx(), 1));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(196741);
      return true;
      label396:
      if (paramv.mc() == 1)
      {
        paramv = this.jLl.cK(1);
        if (paramv != null)
        {
          Log.d(this.TAG, "animateRemove add moveInfo from adapterPosition 1");
          localObject1 = this.agb;
          p.j(paramv, "it");
          localObject2 = paramv.amk;
          p.j(localObject2, "it.itemView");
          i = ((View)localObject2).getLeft();
          localObject2 = paramv.amk;
          p.j(localObject2, "it.itemView");
          j = ((View)localObject2).getTop();
          localObject2 = paramv.amk;
          p.j(localObject2, "it.itemView");
          k = ((View)localObject2).getLeft();
          localObject2 = c.FNc;
          ((ArrayList)localObject1).add(new d(paramv, i, j, k, c.fcx(), 1));
        }
      }
    }
  }
  
  public final boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(196761);
    p.k(paramv, "holder");
    Object localObject1 = paramv.amk;
    p.j(localObject1, "holder.itemView");
    Object localObject2 = paramv.amk;
    p.j(localObject2, "holder.itemView");
    paramInt1 += (int)((View)localObject2).getTranslationX();
    localObject2 = paramv.amk;
    p.j(localObject2, "holder.itemView");
    paramInt2 += (int)((View)localObject2).getTranslationY();
    d(paramv);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      A(paramv);
      AppMethodBeat.o(196761);
      return false;
    }
    if (i != 0) {
      ((View)localObject1).setTranslationX(-i);
    }
    if (j != 0) {
      ((View)localObject1).setTranslationY(-j);
    }
    this.agb.add(new d(paramv, paramInt1, paramInt2, paramInt3, paramInt4));
    localObject1 = this.TAG;
    localObject2 = new StringBuilder("animateMove fromX:").append(paramInt1).append(" fromY:").append(paramInt2).append(" toX:").append(paramInt3).append(" toY:").append(paramInt4).append(" deltaX:").append(i).append(" deltaY:").append(j).append(" holder.left:");
    View localView = paramv.amk;
    p.j(localView, "holder.itemView");
    localObject2 = ((StringBuilder)localObject2).append(localView.getLeft()).append(" holder.top:");
    localView = paramv.amk;
    p.j(localView, "holder.itemView");
    Log.d((String)localObject1, localView.getTop() + " holder.position:" + paramv.md());
    AppMethodBeat.o(196761);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(196785);
    p.k(paramv1, "oldHolder");
    p.k(paramv2, "newHolder");
    if (paramv1 == paramv2)
    {
      boolean bool = a(paramv1, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(196785);
      return bool;
    }
    Object localObject = paramv1.amk;
    p.j(localObject, "oldHolder.itemView");
    float f1 = ((View)localObject).getTranslationX();
    localObject = paramv1.amk;
    p.j(localObject, "oldHolder.itemView");
    float f2 = ((View)localObject).getTranslationY();
    localObject = paramv1.amk;
    p.j(localObject, "oldHolder.itemView");
    float f3 = ((View)localObject).getAlpha();
    d(paramv1);
    int i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    localObject = paramv1.amk;
    p.j(localObject, "oldHolder.itemView");
    ((View)localObject).setTranslationX(f1);
    localObject = paramv1.amk;
    p.j(localObject, "oldHolder.itemView");
    ((View)localObject).setTranslationY(f2);
    localObject = paramv1.amk;
    p.j(localObject, "oldHolder.itemView");
    ((View)localObject).setAlpha(f3);
    d(paramv2);
    localObject = paramv2.amk;
    p.j(localObject, "newHolder.itemView");
    ((View)localObject).setTranslationX(-i);
    localObject = paramv2.amk;
    p.j(localObject, "newHolder.itemView");
    ((View)localObject).setTranslationY(-j);
    localObject = paramv2.amk;
    p.j(localObject, "newHolder.itemView");
    ((View)localObject).setAlpha(0.0F);
    localObject = this.jLl.getAdapter();
    if (localObject != null)
    {
      i = ((RecyclerView.a)localObject).getItemCount();
      if (((i != 2) && (i != 3)) || (paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
        break label362;
      }
      this.agc.add(new a(paramv1, paramv2, paramInt1, paramInt2, paramInt3, paramInt4, f1, f2));
    }
    for (;;)
    {
      AppMethodBeat.o(196785);
      return true;
      i = 0;
      break;
      label362:
      this.agc.add(new a(paramv1, paramv2, paramInt1, paramInt2, paramInt3, paramInt4, 0.0F, 0.0F));
    }
  }
  
  public final boolean a(RecyclerView.v paramv, List<? extends Object> paramList)
  {
    AppMethodBeat.i(196826);
    p.k(paramv, "viewHolder");
    p.k(paramList, "payloads");
    if (!((Collection)paramList).isEmpty()) {}
    for (int i = 1; (i != 0) || (super.a(paramv, paramList)); i = 0)
    {
      AppMethodBeat.o(196826);
      return true;
    }
    AppMethodBeat.o(196826);
    return false;
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(196752);
    p.k(paramv, "viewHolder");
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("animateAdd layoutPosition:").append(paramv.mc()).append(" adapterPosition:").append(paramv.md()).append(" hashCode:").append(paramv.hashCode()).append(" itemCount:");
    Object localObject1 = this.jLl.getAdapter();
    int i;
    label163:
    int j;
    int k;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((RecyclerView.a)localObject1).getItemCount());
      Log.d((String)localObject2, localObject1);
      d(paramv);
      localObject1 = paramv.amk;
      p.j(localObject1, "viewHolder.itemView");
      ((View)localObject1).setAlpha(0.0F);
      this.aga.add(paramv);
      localObject1 = this.jLl.getAdapter();
      if (localObject1 == null) {
        break label274;
      }
      i = ((RecyclerView.a)localObject1).getItemCount();
      if (i != 2) {
        break label279;
      }
      if (paramv.mc() == 1)
      {
        localObject1 = this.agb;
        localObject2 = paramv.amk;
        p.j(localObject2, "viewHolder.itemView");
        i = ((View)localObject2).getLeft();
        localObject2 = paramv.amk;
        p.j(localObject2, "viewHolder.itemView");
        j = ((View)localObject2).getTop();
        localObject2 = c.FNc;
        k = c.fcv();
        localObject2 = c.FNc;
        ((ArrayList)localObject1).add(new d(paramv, i, j, k, c.fcu(), 1));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(196752);
      return true;
      localObject1 = null;
      break;
      label274:
      i = 0;
      break label163;
      label279:
      if (i == 3)
      {
        localObject1 = this.agb;
        localObject2 = paramv.amk;
        p.j(localObject2, "viewHolder.itemView");
        i = ((View)localObject2).getLeft();
        localObject2 = paramv.amk;
        p.j(localObject2, "viewHolder.itemView");
        j = ((View)localObject2).getTop();
        localObject2 = c.FNc;
        ((ArrayList)localObject1).add(new d(paramv, i, j, 0, c.fcx(), 1));
        paramv = this.jLl.cK(2);
        if (paramv != null)
        {
          localObject1 = this.agb;
          p.j(paramv, "it");
          localObject2 = paramv.amk;
          p.j(localObject2, "it.itemView");
          i = ((View)localObject2).getLeft();
          localObject2 = paramv.amk;
          p.j(localObject2, "it.itemView");
          j = ((View)localObject2).getTop();
          localObject2 = paramv.amk;
          p.j(localObject2, "it.itemView");
          k = ((View)localObject2).getLeft();
          localObject2 = c.FNc;
          ((ArrayList)localObject1).add(new d(paramv, i, j, k, c.fcx(), 1));
        }
      }
      else if (i >= 4)
      {
        paramv = paramv.amk.findViewById(e.c.FIy);
        if (paramv != null)
        {
          paramv.setTranslationX(0.0F);
          paramv.setTranslationY(0.0F);
        }
      }
    }
  }
  
  public final void c(RecyclerView.v paramv)
  {
    AppMethodBeat.i(196799);
    p.k(paramv, "item");
    Log.d(this.TAG, "endAnimation " + paramv.md());
    View localView1 = paramv.amk;
    p.j(localView1, "item.itemView");
    View localView2 = paramv.amk.findViewById(e.c.multi_task_item_bg);
    localView1.animate().cancel();
    int i = ((Collection)this.agb).size() - 1;
    Object localObject1;
    while (i >= 0)
    {
      localObject1 = this.agb.get(i);
      p.j(localObject1, "mPendingMoves[i]");
      if (((d)localObject1).agC == paramv)
      {
        localView1.setTranslationY(0.0F);
        localView1.setTranslationX(0.0F);
        A(paramv);
        this.agb.remove(i);
        Log.d(this.TAG, "endAnimation, reset");
      }
      i -= 1;
    }
    a((List)this.agc, paramv);
    if (this.afZ.remove(paramv))
    {
      localView1.setAlpha(1.0F);
      z(paramv);
    }
    if (this.aga.remove(paramv))
    {
      localView1.setAlpha(1.0F);
      B(paramv);
    }
    i = ((Collection)this.agf).size() - 1;
    while (i >= 0)
    {
      localObject1 = this.agf.get(i);
      p.j(localObject1, "mChangesList[i]");
      localObject1 = (ArrayList)localObject1;
      a((List)localObject1, paramv);
      if (((ArrayList)localObject1).isEmpty()) {
        this.agf.remove(i);
      }
      i -= 1;
    }
    i = ((Collection)this.age).size() - 1;
    int j;
    Object localObject2;
    if (i >= 0)
    {
      localObject1 = this.age.get(i);
      p.j(localObject1, "mMovesList[i]");
      localObject1 = (ArrayList)localObject1;
      j = ((Collection)localObject1).size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          localObject2 = ((ArrayList)localObject1).get(j);
          p.j(localObject2, "moves[j]");
          if (((d)localObject2).agC == paramv)
          {
            localView1.setTranslationY(0.0F);
            localView1.setTranslationX(0.0F);
            A(paramv);
            ((ArrayList)localObject1).remove(j);
            if (((ArrayList)localObject1).isEmpty()) {
              this.age.remove(i);
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
    i = ((Collection)this.agd).size() - 1;
    while (i >= 0)
    {
      localObject1 = this.agd.get(i);
      p.j(localObject1, "mAdditionsList[i]");
      localObject1 = (ArrayList)localObject1;
      if (((ArrayList)localObject1).remove(paramv))
      {
        localView1.setAlpha(1.0F);
        B(paramv);
        if (((ArrayList)localObject1).isEmpty()) {
          this.agd.remove(i);
        }
      }
      i -= 1;
    }
    i = ((Collection)this.FKs).size() - 1;
    if (i >= 0)
    {
      localObject1 = this.FKs.get(i);
      p.j(localObject1, "mLayoutsList[i]");
      localObject1 = (ArrayList)localObject1;
      j = ((Collection)localObject1).size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          localObject2 = ((ArrayList)localObject1).get(j);
          p.j(localObject2, "layouts[j]");
          localObject2 = (c)localObject2;
          if (((c)localObject2).agC != paramv) {
            break label779;
          }
          p.j(localView2, "imgView");
          ViewGroup.LayoutParams localLayoutParams = localView2.getLayoutParams();
          int k = ((c)localObject2).FKy;
          c.a locala = c.FNc;
          float f = k - c.fcj();
          locala = c.FNc;
          localLayoutParams.height = kotlin.h.a.dm(f * c.fcF());
          localView1.getLayoutParams().width = ((c)localObject2).FKy;
          localLayoutParams = localView1.getLayoutParams();
          f = ((c)localObject2).FKy;
          localObject2 = c.FNc;
          localLayoutParams.height = kotlin.h.a.dm(f * c.fcE());
          localView1.requestLayout();
          ((ArrayList)localObject1).remove(j);
          if (((ArrayList)localObject1).isEmpty()) {
            this.FKs.remove(i);
          }
        }
        i -= 1;
        break;
        label779:
        j -= 1;
      }
    }
    this.agi.remove(paramv);
    this.agg.remove(paramv);
    this.agj.remove(paramv);
    this.agh.remove(paramv);
    km();
    AppMethodBeat.o(196799);
  }
  
  public final boolean f(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(196724);
    p.k(paramv, "viewHolder");
    p.k(paramc1, "preInfo");
    p.k(paramc2, "postInfo");
    Log.d(this.TAG, "animatePersistence layoutPosition:" + paramv.mc() + " adapterPosition:" + paramv.md() + " hashCode:" + paramv.hashCode());
    int k;
    int m;
    int i;
    int j;
    Object localObject;
    if ((paramc1.left == paramc2.left) && (paramc1.top == paramc2.top))
    {
      if (!fbI())
      {
        paramc2 = this.jLl.getAdapter();
        if ((paramc2 != null) && (paramc2.getItemCount() == 2) && (paramv.md() == 1))
        {
          k = paramc1.left;
          m = paramc1.top;
          paramc1 = c.FNc;
          i = c.fcv();
          paramc1 = c.FNc;
          j = c.fcu();
          p.k(paramv, "holder");
          paramc1 = paramv.amk;
          p.j(paramc1, "holder.itemView");
          paramc2 = paramv.amk;
          p.j(paramc2, "holder.itemView");
          k = (int)paramc2.getTranslationX() + k;
          paramc2 = paramv.amk;
          p.j(paramc2, "holder.itemView");
          m += (int)paramc2.getTranslationY();
          d(paramv);
          paramc2 = paramv.amk;
          p.j(paramc2, "holder.itemView");
          int n = k - paramc2.getLeft();
          paramc2 = paramv.amk;
          p.j(paramc2, "holder.itemView");
          int i1 = m - paramc2.getTop();
          if (n != 0) {
            paramc1.setTranslationX(n);
          }
          if (i1 != 0) {
            paramc1.setTranslationY(i1);
          }
          this.agb.add(new d(paramv, k, m, i, j, 1));
          paramc1 = this.TAG;
          paramc2 = new StringBuilder("animateMove2 fromX:").append(k).append(" fromY:").append(m).append(" toX:").append(i).append(" toY:").append(j).append(" deltaX:").append(n).append(" deltaY:").append(i1).append(" holder.left:");
          localObject = paramv.amk;
          p.j(localObject, "holder.itemView");
          paramc2 = paramc2.append(((View)localObject).getLeft()).append(" holder.top:");
          localObject = paramv.amk;
          p.j(localObject, "holder.itemView");
          Log.d(paramc1, ((View)localObject).getTop() + " holder.position:" + paramv.md());
          AppMethodBeat.o(196724);
          return true;
        }
      }
      A(paramv);
      AppMethodBeat.o(196724);
      return false;
    }
    if (!fbI())
    {
      localObject = this.jLl.getAdapter();
      if ((localObject != null) && (((RecyclerView.a)localObject).getItemCount() == 2) && (paramv.md() == 1))
      {
        i = paramc1.left;
        j = paramc1.top;
        paramc1 = c.FNc;
        k = c.fcv();
        paramc1 = c.FNc;
        b(paramv, i, j, k, c.fcu());
        AppMethodBeat.o(196724);
        return true;
      }
      localObject = this.jLl.getAdapter();
      if ((localObject != null) && (((RecyclerView.a)localObject).getItemCount() == 3))
      {
        if (paramv.md() == 1)
        {
          i = paramc1.left;
          j = paramc1.top;
          paramc1 = c.FNc;
          b(paramv, i, j, 0, c.fcx());
          AppMethodBeat.o(196724);
          return true;
        }
        if (paramv.md() == 2)
        {
          i = paramc1.left;
          j = paramc1.top;
          k = paramc2.left;
          m = paramc2.top;
          paramc1 = c.FNc;
          a(paramv, i, j, k, m, c.fcx());
          AppMethodBeat.o(196724);
          return true;
        }
      }
    }
    if (fbI())
    {
      localObject = this.jLl.getAdapter();
      if ((localObject != null) && (((RecyclerView.a)localObject).getItemCount() == 3))
      {
        paramv.md();
        if (paramv.md() == 2)
        {
          i = paramc1.left;
          j = paramc1.top;
          k = paramc2.left;
          m = paramc2.top;
          paramc1 = c.FNc;
          a(paramv, i, j, k, m, c.fcx());
          AppMethodBeat.o(196724);
          return true;
        }
      }
    }
    boolean bool = a(paramv, paramc1.left, paramc1.top, paramc2.left, paramc2.top);
    AppMethodBeat.o(196724);
    return bool;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(196808);
    if (!((Collection)this.aga).isEmpty())
    {
      i = 1;
      label128:
      label149:
      label170:
      if (i == 0)
      {
        if (((Collection)this.agc).isEmpty()) {
          break label250;
        }
        i = 1;
        label44:
        label191:
        if (i == 0)
        {
          if (((Collection)this.agb).isEmpty()) {
            break label255;
          }
          i = 1;
          label65:
          label212:
          if (i == 0)
          {
            if (((Collection)this.afZ).isEmpty()) {
              break label260;
            }
            i = 1;
            label86:
            if (i == 0)
            {
              if (((Collection)this.agh).isEmpty()) {
                break label265;
              }
              i = 1;
              label107:
              if (i == 0)
              {
                if (((Collection)this.agi).isEmpty()) {
                  break label270;
                }
                i = 1;
                if (i == 0)
                {
                  if (((Collection)this.agg).isEmpty()) {
                    break label275;
                  }
                  i = 1;
                  if (i == 0)
                  {
                    if (((Collection)this.agj).isEmpty()) {
                      break label280;
                    }
                    i = 1;
                    if (i == 0)
                    {
                      if (((Collection)this.age).isEmpty()) {
                        break label285;
                      }
                      i = 1;
                      if (i == 0)
                      {
                        if (((Collection)this.agd).isEmpty()) {
                          break label290;
                        }
                        i = 1;
                        if (i == 0) {
                          if (((Collection)this.agf).isEmpty()) {
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
      AppMethodBeat.o(196808);
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
    AppMethodBeat.o(196808);
    return false;
  }
  
  public final void kl()
  {
    AppMethodBeat.i(196704);
    Log.d(this.TAG, "runPendingAnimations");
    boolean bool1;
    boolean bool2;
    label50:
    boolean bool3;
    if (!((Collection)this.afZ).isEmpty())
    {
      bool1 = true;
      if (((Collection)this.agb).isEmpty()) {
        break label208;
      }
      bool2 = true;
      if (((Collection)this.agc).isEmpty()) {
        break label213;
      }
      bool3 = true;
      label68:
      if (((Collection)this.aga).isEmpty()) {
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
      localObject1 = this.afZ.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RecyclerView.v)((Iterator)localObject1).next();
        p.j(localObject2, "holder");
        p.k(localObject2, "holder");
        final View localView = ((RecyclerView.v)localObject2).amk;
        p.j(localView, "holder.itemView");
        final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
        this.agi.add(localObject2);
        localViewPropertyAnimator.setDuration(lK()).alpha(0.0F).setListener((Animator.AnimatorListener)new k(this, (RecyclerView.v)localObject2, localViewPropertyAnimator, localView)).start();
      }
      bool1 = false;
      break;
      bool2 = false;
      break label50;
      bool3 = false;
      break label68;
    }
    this.afZ.clear();
    if (bool2)
    {
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).addAll((Collection)this.agb);
      this.age.add(localObject2);
      this.agb.clear();
      localObject1 = (Runnable)new o(this, (ArrayList)localObject2);
      if (bool1)
      {
        localObject2 = ((d)((ArrayList)localObject2).get(0)).agC.amk;
        p.j(localObject2, "moves[0].holder.itemView");
        w.a((View)localObject2, (Runnable)localObject1, lK());
      }
    }
    else
    {
      if (bool3)
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll((Collection)this.agc);
        this.agf.add(localObject2);
        this.agc.clear();
        localObject1 = (Runnable)new n(this, (ArrayList)localObject2);
        if (!bool1) {
          break label554;
        }
        localObject2 = ((a)((ArrayList)localObject2).get(0)).agw;
        if (localObject2 == null) {
          break label554;
        }
        w.a(((RecyclerView.v)localObject2).amk, (Runnable)localObject1, lK());
      }
      label425:
      if (i != 0)
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll((Collection)this.aga);
        this.agd.add(localObject2);
        this.aga.clear();
        localObject1 = (Runnable)new m(this, (ArrayList)localObject2);
        if ((!bool1) && (!bool2) && (!bool3)) {
          break label564;
        }
        localObject2 = ((RecyclerView.v)((ArrayList)localObject2).get(0)).amk;
        p.j(localObject2, "additions[0].itemView");
        w.a((View)localObject2, (Runnable)localObject1, lK());
      }
    }
    for (;;)
    {
      k(bool1, bool2, bool3);
      AppMethodBeat.o(196704);
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
  
  public final void km()
  {
    AppMethodBeat.i(196809);
    if (!isRunning()) {
      lM();
    }
    AppMethodBeat.o(196809);
  }
  
  public final void kn()
  {
    AppMethodBeat.i(196821);
    Log.d(this.TAG, "endAnimations");
    int i = this.agb.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = this.agb.get(i);
      p.j(localObject1, "mPendingMoves[i]");
      localObject1 = (d)localObject1;
      localObject2 = ((d)localObject1).agC.amk;
      p.j(localObject2, "item.holder.itemView");
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      A(((d)localObject1).agC);
      this.agb.remove(i);
      Log.d(this.TAG, "endAnimations, pending move reset!");
      i -= 1;
    }
    i = this.afZ.size() - 1;
    while (i >= 0)
    {
      localObject1 = this.afZ.get(i);
      p.j(localObject1, "mPendingRemovals[i]");
      z((RecyclerView.v)localObject1);
      this.afZ.remove(i);
      i -= 1;
    }
    i = this.aga.size() - 1;
    while (i >= 0)
    {
      localObject1 = this.aga.get(i);
      p.j(localObject1, "mPendingAdditions[i]");
      localObject1 = (RecyclerView.v)localObject1;
      localObject2 = ((RecyclerView.v)localObject1).amk;
      p.j(localObject2, "item.itemView");
      ((View)localObject2).setAlpha(1.0F);
      B((RecyclerView.v)localObject1);
      this.aga.remove(i);
      i -= 1;
    }
    i = this.agc.size() - 1;
    while (i >= 0)
    {
      localObject1 = this.agc.get(i);
      p.j(localObject1, "mPendingChanges[i]");
      a((a)localObject1);
      i -= 1;
    }
    this.agc.clear();
    if (!isRunning())
    {
      AppMethodBeat.o(196821);
      return;
    }
    i = this.age.size() - 1;
    int j;
    View localView;
    while (i >= 0)
    {
      localObject1 = this.age.get(i);
      p.j(localObject1, "mMovesList[i]");
      localObject1 = (ArrayList)localObject1;
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = ((ArrayList)localObject1).get(j);
        p.j(localObject2, "moves[j]");
        localObject2 = (d)localObject2;
        localView = ((d)localObject2).agC.amk;
        p.j(localView, "item.itemView");
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        A(((d)localObject2).agC);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.age.remove(localObject1);
        }
        Log.d(this.TAG, "endAnimations, moveReset Translation");
        j -= 1;
      }
      i -= 1;
    }
    i = this.agd.size() - 1;
    while (i >= 0)
    {
      localObject1 = this.agd.get(i);
      p.j(localObject1, "mAdditionsList[i]");
      localObject1 = (ArrayList)localObject1;
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = ((ArrayList)localObject1).get(j);
        p.j(localObject2, "additions[j]");
        localObject2 = (RecyclerView.v)localObject2;
        localView = ((RecyclerView.v)localObject2).amk;
        p.j(localView, "item.itemView");
        localView.setAlpha(1.0F);
        B((RecyclerView.v)localObject2);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.agd.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.agf.size() - 1;
    while (i >= 0)
    {
      localObject1 = this.agf.get(i);
      p.j(localObject1, "mChangesList[i]");
      localObject1 = (ArrayList)localObject1;
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = ((ArrayList)localObject1).get(j);
        p.j(localObject2, "changes[j]");
        a((a)localObject2);
        if (((ArrayList)localObject1).isEmpty()) {
          this.agf.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    l((List)this.agi);
    l((List)this.agh);
    l((List)this.agg);
    l((List)this.agj);
    lM();
    AppMethodBeat.o(196821);
  }
  
  public final void r(RecyclerView.v paramv)
  {
    AppMethodBeat.i(196811);
    p.k(paramv, "viewHolder");
    super.r(paramv);
    com.tencent.mm.plugin.multitask.ui.minusscreen.d.a locala = this.FKt;
    if (locala != null)
    {
      locala.ad(paramv);
      AppMethodBeat.o(196811);
      return;
    }
    AppMethodBeat.o(196811);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$ChangeInfo;", "", "oldHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "newHolder", "fromX", "", "fromY", "toX", "toY", "newTransX", "", "newTransY", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIIIFF)V", "getFromX", "()I", "setFromX", "(I)V", "getFromY", "setFromY", "getNewHolder", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "setNewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "getNewTransX", "()F", "setNewTransX", "(F)V", "getNewTransY", "setNewTransY", "getOldHolder", "setOldHolder", "getToX", "setToX", "getToY", "setToY", "ui-multitask_release"})
  public final class a
  {
    float FKv;
    float FKw;
    int agA;
    int agB;
    RecyclerView.v agw;
    RecyclerView.v agx;
    int agy;
    int agz;
    
    public a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2)
    {
      this.agw = paramv;
      this.agx = paramInt1;
      this.agy = paramInt2;
      this.agz = paramInt3;
      this.agA = paramInt4;
      this.agB = paramFloat1;
      this.FKv = paramFloat2;
      Object localObject;
      this.FKw = localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$LayoutInfo;", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "fromWidth", "", "toWidth", "animator", "Landroid/animation/ValueAnimator;", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IILandroid/animation/ValueAnimator;)V", "getAnimator", "()Landroid/animation/ValueAnimator;", "setAnimator", "(Landroid/animation/ValueAnimator;)V", "getFromWidth", "()I", "setFromWidth", "(I)V", "getHolder", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "setHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "getToWidth", "setToWidth", "ui-multitask_release"})
  public final class c
  {
    int FKy;
    int FKz;
    RecyclerView.v agC;
    ValueAnimator animator;
    
    private c(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(196903);
      this.agC = paramInt1;
      this.FKy = paramInt2;
      int i;
      this.FKz = i;
      this.animator = null;
      AppMethodBeat.o(196903);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$MoveInfo;", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "fromX", "", "fromY", "toX", "toY", "moveType", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIIII)V", "getFromX", "()I", "setFromX", "(I)V", "getFromY", "setFromY", "getHolder", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "setHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "getMoveType", "getToX", "setToX", "getToY", "setToY", "ui-multitask_release"})
  public final class d
  {
    int agA;
    int agB;
    RecyclerView.v agC;
    int agy;
    int agz;
    final int rOd;
    
    public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      AppMethodBeat.i(196402);
      this.agC = paramInt1;
      this.agy = paramInt2;
      this.agz = paramInt3;
      this.agA = paramInt4;
      this.agB = paramInt5;
      int i;
      this.rOd = i;
      AppMethodBeat.o(196402);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateAddImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "ui-multitask_release"})
  public static final class e
    extends AnimatorListenerAdapter
  {
    e(RecyclerView.v paramv, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(196479);
      p.k(paramAnimator, "animator");
      this.kqJ.setAlpha(1.0F);
      AppMethodBeat.o(196479);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(196481);
      p.k(paramAnimator, "animator");
      this.BdS.setListener(null);
      this.FKx.B(this.BdR);
      this.FKx.agg.remove(this.BdR);
      this.FKx.km();
      AppMethodBeat.o(196481);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(196477);
      p.k(paramAnimator, "animator");
      AppMethodBeat.o(196477);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateChangeImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animator", "Landroid/animation/Animator;", "onAnimationStart", "ui-multitask_release"})
  public static final class f
    extends AnimatorListenerAdapter
  {
    f(a.a parama, ViewPropertyAnimator paramViewPropertyAnimator, View paramView, float paramFloat1, float paramFloat2) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(197494);
      p.k(paramAnimator, "animator");
      this.FKB.setListener(null);
      this.kqJ.setAlpha(1.0F);
      this.kqJ.setTranslationX(this.FKC);
      this.kqJ.setTranslationY(this.FKD);
      this.FKx.C(this.FKA.agw);
      this.FKx.agj.remove(this.FKA.agw);
      this.FKx.km();
      AppMethodBeat.o(197494);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(197490);
      p.k(paramAnimator, "animator");
      AppMethodBeat.o(197490);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateChangeImpl$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animator", "Landroid/animation/Animator;", "onAnimationStart", "ui-multitask_release"})
  public static final class g
    extends AnimatorListenerAdapter
  {
    g(a.a parama, ViewPropertyAnimator paramViewPropertyAnimator, View paramView, float paramFloat1, float paramFloat2) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(197229);
      p.k(paramAnimator, "animator");
      this.FKE.setListener(null);
      this.FKF.setAlpha(1.0F);
      this.FKF.setTranslationX(this.FKC);
      this.FKF.setTranslationY(this.FKD);
      this.FKx.C(this.FKA.agx);
      this.FKx.agj.remove(this.FKA.agx);
      this.FKx.km();
      AppMethodBeat.o(197229);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(197221);
      p.k(paramAnimator, "animator");
      AppMethodBeat.o(197221);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateLayoutImpl$1$1"})
  static final class h
    implements ValueAnimator.AnimatorUpdateListener
  {
    h(a parama, View paramView1, View paramView2, a.c paramc) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(196567);
      p.j(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(196567);
        throw paramValueAnimator;
      }
      int i = ((Integer)paramValueAnimator).intValue();
      paramValueAnimator = this.FKG;
      p.j(paramValueAnimator, "imgView");
      paramValueAnimator = paramValueAnimator.getLayoutParams();
      c.a locala = c.FNc;
      float f = i - c.fcj();
      locala = c.FNc;
      paramValueAnimator.height = kotlin.h.a.dm(f * c.fcF());
      this.xkM.getLayoutParams().width = i;
      paramValueAnimator = this.xkM.getLayoutParams();
      f = i;
      locala = c.FNc;
      paramValueAnimator.height = kotlin.h.a.dm(f * c.fcE());
      this.xkM.requestLayout();
      AppMethodBeat.o(196567);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateLayoutImpl$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "ui-multitask_release"})
  public static final class i
    extends AnimatorListenerAdapter
  {
    i(ValueAnimator paramValueAnimator, a parama, View paramView1, View paramView2, a.c paramc) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(196079);
      p.k(paramAnimator, "animator");
      paramAnimator = this.FKG;
      p.j(paramAnimator, "imgView");
      paramAnimator = paramAnimator.getLayoutParams();
      int i = this.FKH.FKz;
      c.a locala = c.FNc;
      float f = i - c.fcj();
      locala = c.FNc;
      paramAnimator.height = kotlin.h.a.dm(f * c.fcF());
      this.xkM.getLayoutParams().width = this.FKH.FKz;
      paramAnimator = this.xkM.getLayoutParams();
      f = this.FKH.FKz;
      locala = c.FNc;
      paramAnimator.height = kotlin.h.a.dm(f * c.fcE());
      this.xkM.requestLayout();
      AppMethodBeat.o(196079);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(196080);
      p.k(paramAnimator, "animator");
      this.FKI.removeListener((Animator.AnimatorListener)this);
      this.FKH.animator = null;
      AppMethodBeat.o(196080);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(196075);
      p.k(paramAnimator, "animator");
      AppMethodBeat.o(196075);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateMoveImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "ui-multitask_release"})
  public static final class j
    extends AnimatorListenerAdapter
  {
    j(RecyclerView.v paramv, int paramInt1, View paramView, int paramInt2, ViewPropertyAnimator paramViewPropertyAnimator) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(197456);
      p.k(paramAnimator, "animator");
      if (this.FKJ != 0) {
        this.kqJ.setTranslationX(0.0F);
      }
      if (this.FKK != 0) {
        this.kqJ.setTranslationY(0.0F);
      }
      AppMethodBeat.o(197456);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(197458);
      p.k(paramAnimator, "animator");
      this.BdS.setListener(null);
      this.FKx.A(this.BdR);
      this.FKx.agh.remove(this.BdR);
      this.FKx.km();
      AppMethodBeat.o(197458);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(197455);
      p.k(paramAnimator, "animator");
      this.FKx.E(this.BdR);
      AppMethodBeat.o(197455);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateRemoveImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animator", "Landroid/animation/Animator;", "onAnimationStart", "ui-multitask_release"})
  public static final class k
    extends AnimatorListenerAdapter
  {
    k(RecyclerView.v paramv, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(196541);
      p.k(paramAnimator, "animator");
      localViewPropertyAnimator.setListener(null);
      localView.setAlpha(1.0F);
      this.FKx.z(this.BdR);
      this.FKx.agi.remove(this.BdR);
      this.FKx.km();
      AppMethodBeat.o(196541);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(196540);
      p.k(paramAnimator, "animator");
      this.FKx.D(this.BdR);
      AppMethodBeat.o(196540);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(a parama, ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(196526);
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (a.c)localIterator.next();
        Object localObject2 = this.FKx;
        Object localObject4 = ((a.c)localObject1).agC;
        p.j(localObject1, "info");
        p.k(localObject4, "holder");
        p.k(localObject1, "info");
        View localView = ((RecyclerView.v)localObject4).amk;
        p.j(localView, "holder.itemView");
        Object localObject3 = ((RecyclerView.v)localObject4).amk.findViewById(e.c.multi_task_item_bg);
        Log.d(((a)localObject2).TAG, "animateLayoutImpl adapterPosition:" + ((RecyclerView.v)localObject4).md() + " width:" + localView.getLayoutParams().width + " height:" + localView.getLayoutParams().height + " fromWidth:" + ((a.c)localObject1).FKy + " toWidth:" + ((a.c)localObject1).FKz);
        if (Math.abs(((a.c)localObject1).FKy - ((a.c)localObject1).FKz) > 1)
        {
          localObject4 = ValueAnimator.ofInt(new int[] { ((a.c)localObject1).FKy, ((a.c)localObject1).FKz });
          ((ValueAnimator)localObject4).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a.h((a)localObject2, (View)localObject3, localView, (a.c)localObject1));
          ((ValueAnimator)localObject4).addListener((Animator.AnimatorListener)new a.i((ValueAnimator)localObject4, (a)localObject2, (View)localObject3, localView, (a.c)localObject1));
          p.j(localObject4, "it");
          ((ValueAnimator)localObject4).setDuration(((a)localObject2).lI());
          ((ValueAnimator)localObject4).start();
          ((a.c)localObject1).animator = ((ValueAnimator)localObject4);
        }
        else
        {
          p.j(localObject3, "imgView");
          localObject2 = ((View)localObject3).getLayoutParams();
          int i = ((a.c)localObject1).FKz;
          localObject3 = c.FNc;
          float f = i - c.fcj();
          localObject3 = c.FNc;
          ((ViewGroup.LayoutParams)localObject2).height = kotlin.h.a.dm(f * c.fcF());
          localView.getLayoutParams().width = ((a.c)localObject1).FKz;
          localObject2 = localView.getLayoutParams();
          f = ((a.c)localObject1).FKz;
          localObject1 = c.FNc;
          ((ViewGroup.LayoutParams)localObject2).height = kotlin.h.a.dm(f * c.fcE());
          localView.requestLayout();
        }
      }
      localArrayList.clear();
      this.FKx.FKs.remove(localArrayList);
      AppMethodBeat.o(196526);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(a parama, ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(197538);
      Iterator localIterator = this.FKM.iterator();
      while (localIterator.hasNext())
      {
        RecyclerView.v localv = (RecyclerView.v)localIterator.next();
        a locala = this.FKx;
        p.j(localv, "holder");
        p.k(localv, "holder");
        View localView = localv.amk;
        p.j(localView, "holder.itemView");
        ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
        locala.agg.add(localv);
        localViewPropertyAnimator.alpha(1.0F).setDuration(locala.lJ()).setListener((Animator.AnimatorListener)new a.e(locala, localv, localView, localViewPropertyAnimator)).start();
      }
      this.FKM.clear();
      this.FKx.agd.remove(this.FKM);
      AppMethodBeat.o(197538);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(a parama, ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(196489);
      Iterator localIterator = this.FKN.iterator();
      if (localIterator.hasNext())
      {
        a.a locala = (a.a)localIterator.next();
        a locala1 = this.FKx;
        p.j(locala, "change");
        p.k(locala, "changeInfo");
        Object localObject1 = locala.agw;
        if (localObject1 != null)
        {
          localObject1 = ((RecyclerView.v)localObject1).amk;
          label71:
          localObject2 = locala.agx;
          if (localObject2 == null) {
            break label282;
          }
        }
        label282:
        for (Object localObject2 = ((RecyclerView.v)localObject2).amk;; localObject2 = null)
        {
          float f1 = locala.FKv;
          float f2 = locala.FKw;
          if (localObject1 != null)
          {
            ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject1).animate().setDuration(locala1.lL());
            locala1.agj.add(locala.agw);
            localViewPropertyAnimator.translationX(locala.agA - locala.agy);
            localViewPropertyAnimator.translationY(locala.agB - locala.agz);
            localViewPropertyAnimator.alpha(0.0F).setListener((Animator.AnimatorListener)new a.f(locala1, locala, localViewPropertyAnimator, (View)localObject1, f1, f2)).start();
          }
          if (localObject2 == null) {
            break;
          }
          localObject1 = ((View)localObject2).animate();
          locala1.agj.add(locala.agx);
          ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(locala1.lL()).alpha(1.0F).setListener((Animator.AnimatorListener)new a.g(locala1, locala, (ViewPropertyAnimator)localObject1, (View)localObject2, f1, f2)).start();
          break;
          localObject1 = null;
          break label71;
        }
      }
      this.FKN.clear();
      this.FKx.agf.remove(this.FKN);
      AppMethodBeat.o(196489);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(a parama, ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(196381);
      Iterator localIterator = this.FKO.iterator();
      if (localIterator.hasNext())
      {
        Object localObject1 = (a.d)localIterator.next();
        a locala = this.FKx;
        RecyclerView.v localv = ((a.d)localObject1).agC;
        int i1 = ((a.d)localObject1).agy;
        int n = ((a.d)localObject1).agz;
        int j = ((a.d)localObject1).agA;
        int k = ((a.d)localObject1).agB;
        int m = ((a.d)localObject1).rOd;
        p.k(localv, "holder");
        localObject1 = locala.TAG;
        Object localObject2 = new StringBuilder("animateMoveImpl pos:").append(localv.md()).append(" fromX:").append(i1).append(" fromY:").append(n).append(" toX:").append(j).append(" toY:").append(k).append(" holder.left:");
        View localView = localv.amk;
        p.j(localView, "holder.itemView");
        localObject2 = ((StringBuilder)localObject2).append(localView.getLeft()).append(" holder.top:");
        localView = localv.amk;
        p.j(localView, "holder.itemView");
        Log.d((String)localObject1, localView.getTop());
        localObject1 = locala.jLl.getAdapter();
        int i;
        if (localObject1 != null)
        {
          i = ((RecyclerView.a)localObject1).getItemCount();
          label242:
          localObject1 = localv.amk;
          p.j(localObject1, "holder.itemView");
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
          locala.agh.add(localv);
          ((ViewPropertyAnimator)localObject2).setDuration(locala.lI()).setListener((Animator.AnimatorListener)new a.j(locala, localv, i1, (View)localObject1, n, (ViewPropertyAnimator)localObject2)).start();
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
      this.FKO.clear();
      this.FKx.age.remove(this.FKO);
      AppMethodBeat.o(196381);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.a.a
 * JD-Core Version:    0.7.0.1
 */