package com.tencent.mm.plugin.multitask.ui.minusscreen.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import androidx.core.g.z;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.f.c;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.ui.e.c;
import com.tencent.mm.plugin.multitask.ui.uic.c;
import com.tencent.mm.plugin.multitask.ui.uic.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator;", "Landroidx/recyclerview/widget/SimpleItemAnimator;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onItemListener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "addDelay", "", "getAddDelay", "()J", "changeDelay", "getChangeDelay", "mAddAnimations", "Ljava/util/ArrayList;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlin/collections/ArrayList;", "getMAddAnimations", "()Ljava/util/ArrayList;", "setMAddAnimations", "(Ljava/util/ArrayList;)V", "mAdditionsList", "getMAdditionsList", "setMAdditionsList", "mChangeAnimations", "getMChangeAnimations", "setMChangeAnimations", "mChangesList", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$ChangeInfo;", "getMChangesList", "setMChangesList", "mLayoutsList", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$LayoutInfo;", "getMLayoutsList", "setMLayoutsList", "mMoveAnimations", "getMMoveAnimations", "setMMoveAnimations", "mMovesList", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$MoveInfo;", "getMMovesList", "setMMovesList", "mPendingAdditions", "getMPendingAdditions", "setMPendingAdditions", "mPendingChanges", "getMPendingChanges", "mPendingMoves", "getMPendingMoves", "mPendingRemovals", "getMPendingRemovals", "setMPendingRemovals", "mRemoveAnimations", "getMRemoveAnimations", "setMRemoveAnimations", "moveDelay", "getMoveDelay", "getOnItemListener", "()Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "removeDelay", "getRemoveDelay", "animateAdd", "", "viewHolder", "animateAddImpl", "", "holder", "animateChange", "oldHolder", "newHolder", "fromX", "", "fromY", "toX", "toY", "animateChangeImpl", "changeInfo", "animateLayoutImpl", "info", "animateMove", "animateMove1", "moveType", "animateMove2", "animateMove3", "finalY", "animateMoveImpl", "animatePersistence", "preInfo", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;", "postInfo", "animateRemove", "animateRemoveImpl", "canReuseUpdatedViewHolder", "payloads", "", "", "cancelAll", "viewHolders", "checkRefreshLayout", "removalsPending", "movesPending", "changesPending", "dispatchFinishedWhenDone", "endAnimation", "item", "endAnimations", "endChangeAnimation", "infoList", "", "endChangeAnimationIfNecessary", "isAddAnimation", "isChangeAnimation", "isMoveAnimation", "isRemoveAnimation", "isRunning", "onAnimationFinished", "resetAnimation", "runPendingAnimations", "ChangeInfo", "Companion", "LayoutInfo", "MoveInfo", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends w
{
  public static final a.b LFH;
  private static TimeInterpolator bUE;
  private final com.tencent.mm.plugin.multitask.ui.minusscreen.d.a LFI;
  private ArrayList<ArrayList<c>> LFJ;
  private final String TAG;
  private ArrayList<RecyclerView.v> bUF;
  private ArrayList<RecyclerView.v> bUG;
  private final ArrayList<d> bUH;
  private final ArrayList<a> bUI;
  private ArrayList<ArrayList<RecyclerView.v>> bUJ;
  private ArrayList<ArrayList<d>> bUK;
  private ArrayList<ArrayList<a>> bUL;
  ArrayList<RecyclerView.v> bUM;
  ArrayList<RecyclerView.v> bUN;
  ArrayList<RecyclerView.v> bUO;
  ArrayList<RecyclerView.v> bUP;
  private final RecyclerView mkw;
  
  static
  {
    AppMethodBeat.i(304582);
    LFH = new a.b((byte)0);
    AppMethodBeat.o(304582);
  }
  
  public a(RecyclerView paramRecyclerView, com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama)
  {
    AppMethodBeat.i(304462);
    this.mkw = paramRecyclerView;
    this.LFI = parama;
    this.TAG = "MicroMsg.MultiTask.MinusAnimator";
    this.bUF = new ArrayList();
    this.bUG = new ArrayList();
    this.bUH = new ArrayList();
    this.bUI = new ArrayList();
    this.bUJ = new ArrayList();
    this.bUK = new ArrayList();
    this.bUL = new ArrayList();
    this.LFJ = new ArrayList();
    this.bUM = new ArrayList();
    this.bUN = new ArrayList();
    this.bUO = new ArrayList();
    this.bUP = new ArrayList();
    AppMethodBeat.o(304462);
  }
  
  private final void a(a parama)
  {
    AppMethodBeat.i(304505);
    if (parama.bVc != null) {
      a(parama, parama.bVc);
    }
    if (parama.bVd != null) {
      a(parama, parama.bVd);
    }
    AppMethodBeat.o(304505);
  }
  
  private static final void a(ArrayList paramArrayList, a parama)
  {
    AppMethodBeat.i(304536);
    s.u(paramArrayList, "$moves");
    s.u(parama, "this$0");
    Iterator localIterator = paramArrayList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (d)localIterator.next();
      final RecyclerView.v localv = ((d)localObject).bVi;
      final int i1 = ((d)localObject).bVe;
      final int n = ((d)localObject).bVf;
      int j = ((d)localObject).bVg;
      int k = ((d)localObject).bVh;
      int m = ((d)localObject).uZr;
      s.u(localv, "holder");
      Log.d(parama.TAG, "animateMoveImpl pos:" + localv.KJ() + " fromX:" + i1 + " fromY:" + n + " toX:" + j + " toY:" + k + " holder.left:" + localv.caK.getLeft() + " holder.top:" + localv.caK.getTop());
      localObject = parama.mkw.getAdapter();
      int i;
      if (localObject == null)
      {
        i = 0;
        label218:
        localObject = localv.caK;
        s.s(localObject, "holder.itemView");
        i1 = j - i1;
        n = k - n;
        if (i1 != 0)
        {
          if ((i > 3) || (m != 1)) {
            break label366;
          }
          ((View)localObject).animate().translationX(j);
        }
        label273:
        if (n != 0)
        {
          if ((i > 3) || (m != 1)) {
            break label403;
          }
          ((View)localObject).animate().translationY(k);
        }
      }
      for (;;)
      {
        final ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject).animate();
        parama.bUN.add(localv);
        localViewPropertyAnimator.setDuration(parama.bZK).setListener((Animator.AnimatorListener)new i(parama, localv, i1, (View)localObject, n, localViewPropertyAnimator)).start();
        break;
        i = ((RecyclerView.a)localObject).getItemCount();
        break label218;
        label366:
        if ((i <= 3) && (m == 2))
        {
          ((View)localObject).animate().translationX(0.0F);
          break label273;
        }
        ((View)localObject).animate().translationX(0.0F);
        break label273;
        label403:
        if ((i <= 3) && (m == 2)) {
          ((View)localObject).animate().translationY(k);
        } else {
          ((View)localObject).animate().translationY(0.0F);
        }
      }
    }
    paramArrayList.clear();
    parama.bUK.remove(paramArrayList);
    AppMethodBeat.o(304536);
  }
  
  private final void a(List<a> paramList, RecyclerView.v paramv)
  {
    AppMethodBeat.i(304497);
    int i = paramList.size() - 1;
    if (i >= 0) {}
    for (;;)
    {
      int j = i - 1;
      a locala = (a)paramList.get(i);
      if ((a(locala, paramv)) && (locala.bVc == null) && (locala.bVd == null)) {
        paramList.remove(locala);
      }
      if (j < 0)
      {
        AppMethodBeat.o(304497);
        return;
      }
      i = j;
    }
  }
  
  private boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(304490);
    s.u(paramv, "holder");
    View localView = paramv.caK;
    s.s(localView, "holder.itemView");
    paramInt1 += (int)paramv.caK.getTranslationX();
    paramInt2 += (int)paramv.caK.getTranslationY();
    d(paramv);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      B(paramv);
      AppMethodBeat.o(304490);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    this.bUH.add(new d(paramv, paramInt1, paramInt4, paramInt3, paramInt5, 2));
    Log.d(this.TAG, "animateMove3 fromX:" + paramInt1 + " fromY:" + paramInt2 + " toX:" + paramInt3 + " toY:" + paramInt4 + " deltaX:" + i + " deltaY:" + j + " holder.left:" + paramv.caK.getLeft() + " holder.top:" + paramv.caK.getTop() + " holder.position:" + paramv.KJ());
    AppMethodBeat.o(304490);
    return true;
  }
  
  private final boolean a(a parama, RecyclerView.v paramv)
  {
    AppMethodBeat.i(304511);
    if (parama.bVd == paramv) {
      parama.bVd = null;
    }
    for (;;)
    {
      if (paramv != null)
      {
        paramv.caK.setAlpha(1.0F);
        paramv.caK.setTranslationX(parama.LFK);
        paramv.caK.setTranslationY(parama.LFL);
        Log.d(this.TAG, "endAnimations,change reset!, transX: " + parama.LFK + " transY: " + parama.LFL);
      }
      r(paramv);
      AppMethodBeat.o(304511);
      return true;
      if (parama.bVc != paramv) {
        break;
      }
      parama.bVc = null;
    }
    AppMethodBeat.o(304511);
    return false;
  }
  
  private static void ae(List<? extends RecyclerView.v> paramList)
  {
    AppMethodBeat.i(304524);
    s.u(paramList, "viewHolders");
    int i = paramList.size() - 1;
    if (i >= 0) {}
    for (;;)
    {
      int j = i - 1;
      Object localObject = (RecyclerView.v)paramList.get(i);
      if (localObject != null)
      {
        localObject = ((RecyclerView.v)localObject).caK;
        if (localObject != null)
        {
          localObject = ((View)localObject).animate();
          if (localObject != null) {
            ((ViewPropertyAnimator)localObject).cancel();
          }
        }
      }
      if (j < 0)
      {
        AppMethodBeat.o(304524);
        return;
      }
      i = j;
    }
  }
  
  private static final void b(ArrayList paramArrayList, a parama)
  {
    AppMethodBeat.i(304548);
    s.u(paramArrayList, "$changes");
    s.u(parama, "this$0");
    Iterator localIterator = paramArrayList.iterator();
    if (localIterator.hasNext())
    {
      final a locala = (a)localIterator.next();
      s.s(locala, "change");
      s.u(locala, "changeInfo");
      Object localObject1 = locala.bVc;
      if (localObject1 == null)
      {
        localObject1 = null;
        label79:
        localObject2 = locala.bVd;
        if (localObject2 != null) {
          break label291;
        }
      }
      label291:
      for (Object localObject2 = null;; localObject2 = ((RecyclerView.v)localObject2).caK)
      {
        final float f1 = locala.LFK;
        final float f2 = locala.LFL;
        if (localObject1 != null)
        {
          final ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject1).animate().setDuration(parama.bZL);
          parama.bUP.add(locala.bVc);
          localViewPropertyAnimator.translationX(locala.bVg - locala.bVe);
          localViewPropertyAnimator.translationY(locala.bVh - locala.bVf);
          localViewPropertyAnimator.alpha(0.0F).setListener((Animator.AnimatorListener)new f(parama, locala, localViewPropertyAnimator, (View)localObject1, f1, f2)).start();
        }
        if (localObject2 == null) {
          break;
        }
        localObject1 = ((View)localObject2).animate();
        parama.bUP.add(locala.bVd);
        ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(parama.bZL).alpha(1.0F).setListener((Animator.AnimatorListener)new g(parama, locala, (ViewPropertyAnimator)localObject1, (View)localObject2, f1, f2)).start();
        break;
        localObject1 = ((RecyclerView.v)localObject1).caK;
        break label79;
      }
    }
    paramArrayList.clear();
    parama.bUL.remove(paramArrayList);
    AppMethodBeat.o(304548);
  }
  
  private boolean b(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(304480);
    s.u(paramv, "holder");
    View localView = paramv.caK;
    s.s(localView, "holder.itemView");
    paramInt1 += (int)paramv.caK.getTranslationX();
    paramInt2 += (int)paramv.caK.getTranslationY();
    d(paramv);
    int i = paramInt1 - paramv.caK.getLeft();
    int j = paramInt2 - paramv.caK.getTop();
    if ((i == 0) && (j == 0))
    {
      B(paramv);
      AppMethodBeat.o(304480);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(i);
    }
    if (j != 0) {
      localView.setTranslationY(j);
    }
    this.bUH.add(new d(paramv, paramInt1, paramInt2, paramInt3, paramInt4, 1));
    Log.d(this.TAG, "animateMove1 fromX:" + paramInt1 + " fromY:" + paramInt2 + " toX:" + paramInt3 + " toY:" + paramInt4 + " deltaX:" + i + " deltaY:" + j + " holder.left:" + paramv.caK.getLeft() + " holder.top:" + paramv.caK.getTop() + " holder.position:" + paramv.KJ());
    AppMethodBeat.o(304480);
    return true;
  }
  
  private static final void c(View paramView1, View paramView2, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(304575);
    s.u(paramView2, "$view");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramView1 = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(304575);
      throw paramView1;
    }
    int i = ((Integer)paramValueAnimator).intValue();
    paramView1 = paramView1.getLayoutParams();
    paramValueAnimator = c.LHl;
    float f = i - c.access$get_2A$cp();
    paramValueAnimator = c.LHl;
    paramView1.height = kotlin.h.a.eH(f * c.glI());
    paramView2.getLayoutParams().width = i;
    paramView1 = paramView2.getLayoutParams();
    f = i;
    paramValueAnimator = c.LHl;
    paramView1.height = kotlin.h.a.eH(f * c.glH());
    paramView2.requestLayout();
    AppMethodBeat.o(304575);
  }
  
  private static final void c(ArrayList paramArrayList, a parama)
  {
    AppMethodBeat.i(304552);
    s.u(paramArrayList, "$additions");
    s.u(parama, "this$0");
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      final RecyclerView.v localv = (RecyclerView.v)localIterator.next();
      s.s(localv, "holder");
      s.u(localv, "holder");
      final View localView = localv.caK;
      s.s(localView, "holder.itemView");
      final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
      parama.bUM.add(localv);
      localViewPropertyAnimator.alpha(1.0F).setDuration(parama.Kt()).setListener((Animator.AnimatorListener)new e(parama, localv, localView, localViewPropertyAnimator)).start();
    }
    paramArrayList.clear();
    parama.bUJ.remove(paramArrayList);
    AppMethodBeat.o(304552);
  }
  
  private void d(RecyclerView.v paramv)
  {
    AppMethodBeat.i(304516);
    s.u(paramv, "holder");
    if (bUE == null) {
      bUE = new ValueAnimator().getInterpolator();
    }
    paramv.caK.animate().setInterpolator(bUE);
    c(paramv);
    AppMethodBeat.o(304516);
  }
  
  private static final void d(ArrayList paramArrayList, a parama)
  {
    AppMethodBeat.i(304565);
    s.u(paramArrayList, "$layouts");
    s.u(parama, "this$0");
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (c)localIterator.next();
      Object localObject4 = ((c)localObject1).bVi;
      s.s(localObject1, "info");
      s.u(localObject4, "holder");
      s.u(localObject1, "info");
      Object localObject2 = ((RecyclerView.v)localObject4).caK;
      s.s(localObject2, "holder.itemView");
      Object localObject3 = ((RecyclerView.v)localObject4).caK.findViewById(e.c.multi_task_item_bg);
      Log.d(parama.TAG, "animateLayoutImpl adapterPosition:" + ((RecyclerView.v)localObject4).KJ() + " width:" + ((View)localObject2).getLayoutParams().width + " height:" + ((View)localObject2).getLayoutParams().height + " fromWidth:" + ((c)localObject1).LFN + " toWidth:" + ((c)localObject1).LFO);
      if (Math.abs(((c)localObject1).LFN - ((c)localObject1).LFO) > 1)
      {
        localObject4 = ValueAnimator.ofInt(new int[] { ((c)localObject1).LFN, ((c)localObject1).LFO });
        ((ValueAnimator)localObject4).addUpdateListener(new a..ExternalSyntheticLambda0((View)localObject3, (View)localObject2));
        ((ValueAnimator)localObject4).addListener((Animator.AnimatorListener)new h((View)localObject3, (c)localObject1, (View)localObject2, (ValueAnimator)localObject4));
        ((ValueAnimator)localObject4).setDuration(parama.bZK);
        ((ValueAnimator)localObject4).start();
        localObject2 = ah.aiuX;
        ((c)localObject1).animator = ((ValueAnimator)localObject4);
      }
      else
      {
        localObject3 = ((View)localObject3).getLayoutParams();
        int i = ((c)localObject1).LFO;
        localObject4 = c.LHl;
        float f = i - c.access$get_2A$cp();
        localObject4 = c.LHl;
        ((ViewGroup.LayoutParams)localObject3).height = kotlin.h.a.eH(f * c.glI());
        ((View)localObject2).getLayoutParams().width = ((c)localObject1).LFO;
        localObject3 = ((View)localObject2).getLayoutParams();
        f = ((c)localObject1).LFO;
        localObject1 = c.LHl;
        ((ViewGroup.LayoutParams)localObject3).height = kotlin.h.a.eH(f * c.glH());
        ((View)localObject2).requestLayout();
      }
    }
    paramArrayList.clear();
    parama.LFJ.remove(paramArrayList);
    AppMethodBeat.o(304565);
  }
  
  private final boolean gkM()
  {
    AppMethodBeat.i(304472);
    if (this.bUG.size() > 0)
    {
      AppMethodBeat.o(304472);
      return true;
    }
    AppMethodBeat.o(304472);
    return false;
  }
  
  private final void m(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(304469);
    Object localObject1 = this.mkw.getAdapter();
    Object localObject2;
    int k;
    if (localObject1 == null)
    {
      i = 0;
      if (i < 2) {
        break label461;
      }
      localObject2 = new ArrayList();
      if (i != 2) {
        break label290;
      }
      k = this.mkw.getChildCount();
      if (k <= 0) {}
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      View localView = this.mkw.getChildAt(i);
      RecyclerView.v localv = this.mkw.by(localView);
      if (localv != null)
      {
        if (!(localv instanceof j)) {
          break label284;
        }
        localObject1 = (j)localv;
        label109:
        if ((localObject1 != null) && ((com.tencent.mm.plugin.multitask.ui.minusscreen.b.a)((j)localObject1).CSA != null))
        {
          i = localView.getWidth();
          localObject1 = c.LHl;
          if (i < c.glr())
          {
            i = localv.caK.getWidth();
            localObject1 = c.LHl;
            ((ArrayList)localObject2).add(new c(localv, i, c.glr(), (byte)0));
          }
        }
      }
      if (j >= k)
      {
        label284:
        label290:
        do
        {
          do
          {
            this.LFJ.add(localObject2);
            localObject1 = new a..ExternalSyntheticLambda3((ArrayList)localObject2, this);
            if ((!paramBoolean1) && (!paramBoolean2) && (!paramBoolean3)) {
              break label454;
            }
            localObject2 = (c)p.oL((List)localObject2);
            if (localObject2 == null) {
              break label461;
            }
            localObject2 = ((c)localObject2).bVi.caK;
            if (localObject2 == null) {
              break label461;
            }
            z.a((View)localObject2, (Runnable)localObject1, Ku());
            AppMethodBeat.o(304469);
            return;
            i = ((RecyclerView.a)localObject1).getItemCount();
            break;
            localObject1 = null;
            break label109;
          } while (i < 3);
          k = this.mkw.getChildCount();
        } while (k <= 0);
        i = 0;
        label313:
        j = i + 1;
        localView = this.mkw.getChildAt(i);
        localv = this.mkw.by(localView);
        if (localv != null) {
          if (!(localv instanceof j)) {
            break label448;
          }
        }
        label448:
        for (localObject1 = (j)localv;; localObject1 = null)
        {
          if ((localObject1 != null) && ((com.tencent.mm.plugin.multitask.ui.minusscreen.b.a)((j)localObject1).CSA != null))
          {
            i = localView.getWidth();
            localObject1 = c.LHl;
            if (i > c.glp())
            {
              i = localv.caK.getWidth();
              localObject1 = c.LHl;
              ((ArrayList)localObject2).add(new c(localv, i, c.glp(), (byte)0));
            }
          }
          if (j >= k) {
            break;
          }
          i = j;
          break label313;
        }
        label454:
        ((Runnable)localObject1).run();
        label461:
        AppMethodBeat.o(304469);
        return;
      }
    }
  }
  
  public final void IW()
  {
    AppMethodBeat.i(304613);
    Log.d(this.TAG, "runPendingAnimations");
    boolean bool1;
    boolean bool2;
    label50:
    boolean bool3;
    if (!((Collection)this.bUF).isEmpty())
    {
      bool1 = true;
      if (((Collection)this.bUH).isEmpty()) {
        break label208;
      }
      bool2 = true;
      if (((Collection)this.bUI).isEmpty()) {
        break label213;
      }
      bool3 = true;
      label68:
      if (((Collection)this.bUG).isEmpty()) {
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
      localObject1 = this.bUF.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RecyclerView.v)((Iterator)localObject1).next();
        s.s(localObject2, "holder");
        s.u(localObject2, "holder");
        final View localView = ((RecyclerView.v)localObject2).caK;
        s.s(localView, "holder.itemView");
        final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
        this.bUO.add(localObject2);
        localViewPropertyAnimator.setDuration(Ku()).alpha(0.0F).setListener((Animator.AnimatorListener)new j(this, (RecyclerView.v)localObject2, localViewPropertyAnimator, localView)).start();
      }
      bool1 = false;
      break;
      bool2 = false;
      break label50;
      bool3 = false;
      break label68;
    }
    this.bUF.clear();
    if (bool2)
    {
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).addAll((Collection)this.bUH);
      this.bUK.add(localObject2);
      this.bUH.clear();
      localObject1 = new a..ExternalSyntheticLambda4((ArrayList)localObject2, this);
      if (bool1)
      {
        localObject2 = ((d)((ArrayList)localObject2).get(0)).bVi.caK;
        s.s(localObject2, "moves[0].holder.itemView");
        z.a((View)localObject2, (Runnable)localObject1, Ku());
      }
    }
    else
    {
      if (bool3)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll((Collection)this.bUI);
        this.bUL.add(localObject1);
        this.bUI.clear();
        localObject2 = new a..ExternalSyntheticLambda1((ArrayList)localObject1, this);
        if (bool1)
        {
          localObject1 = ((a)((ArrayList)localObject1).get(0)).bVc;
          if (localObject1 != null) {
            break label546;
          }
          localObject1 = null;
          label408:
          if (localObject1 != null) {}
        }
        else
        {
          ((Runnable)localObject2).run();
        }
      }
      if (i != 0)
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll((Collection)this.bUG);
        this.bUJ.add(localObject2);
        this.bUG.clear();
        localObject1 = new a..ExternalSyntheticLambda2((ArrayList)localObject2, this);
        if ((!bool1) && (!bool2) && (!bool3)) {
          break label568;
        }
        localObject2 = ((RecyclerView.v)((ArrayList)localObject2).get(0)).caK;
        s.s(localObject2, "additions[0].itemView");
        z.a((View)localObject2, (Runnable)localObject1, Ku());
      }
    }
    for (;;)
    {
      m(bool1, bool2, bool3);
      AppMethodBeat.o(304613);
      return;
      ((Runnable)localObject1).run();
      break;
      label546:
      z.a(((RecyclerView.v)localObject1).caK, (Runnable)localObject2, Ku());
      localObject1 = ah.aiuX;
      break label408;
      label568:
      ((Runnable)localObject1).run();
    }
  }
  
  public final void IX()
  {
    AppMethodBeat.i(304670);
    if (!isRunning()) {
      Kv();
    }
    AppMethodBeat.o(304670);
  }
  
  public final void IY()
  {
    AppMethodBeat.i(304682);
    Log.d(this.TAG, "endAnimations");
    int i = this.bUH.size() - 1;
    if (i >= 0) {}
    for (;;)
    {
      int j = i - 1;
      Object localObject1 = this.bUH.get(i);
      s.s(localObject1, "mPendingMoves[i]");
      localObject1 = (d)localObject1;
      Object localObject2 = ((d)localObject1).bVi.caK;
      s.s(localObject2, "item.holder.itemView");
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      B(((d)localObject1).bVi);
      this.bUH.remove(i);
      Log.d(this.TAG, "endAnimations, pending move reset!");
      if (j < 0)
      {
        i = this.bUF.size() - 1;
        if (i >= 0) {}
        for (;;)
        {
          j = i - 1;
          localObject1 = this.bUF.get(i);
          s.s(localObject1, "mPendingRemovals[i]");
          A((RecyclerView.v)localObject1);
          this.bUF.remove(i);
          if (j < 0)
          {
            i = this.bUG.size() - 1;
            if (i >= 0) {}
            for (;;)
            {
              j = i - 1;
              localObject1 = this.bUG.get(i);
              s.s(localObject1, "mPendingAdditions[i]");
              localObject1 = (RecyclerView.v)localObject1;
              ((RecyclerView.v)localObject1).caK.setAlpha(1.0F);
              r((RecyclerView.v)localObject1);
              this.bUG.remove(i);
              if (j < 0)
              {
                i = this.bUI.size() - 1;
                if (i >= 0) {}
                for (;;)
                {
                  j = i - 1;
                  localObject1 = this.bUI.get(i);
                  s.s(localObject1, "mPendingChanges[i]");
                  a((a)localObject1);
                  if (j < 0)
                  {
                    this.bUI.clear();
                    if (!isRunning())
                    {
                      AppMethodBeat.o(304682);
                      return;
                    }
                    i = this.bUK.size() - 1;
                    if (i >= 0)
                    {
                      j = i - 1;
                      localObject1 = this.bUK.get(i);
                      s.s(localObject1, "mMovesList[i]");
                      localObject1 = (ArrayList)localObject1;
                      i = ((ArrayList)localObject1).size() - 1;
                      if (i < 0) {}
                    }
                    for (;;)
                    {
                      int k = i - 1;
                      localObject2 = ((ArrayList)localObject1).get(i);
                      s.s(localObject2, "moves[j]");
                      localObject2 = (d)localObject2;
                      View localView = ((d)localObject2).bVi.caK;
                      s.s(localView, "item.itemView");
                      localView.setTranslationY(0.0F);
                      localView.setTranslationX(0.0F);
                      B(((d)localObject2).bVi);
                      ((ArrayList)localObject1).remove(i);
                      if (((ArrayList)localObject1).isEmpty()) {
                        this.bUK.remove(localObject1);
                      }
                      Log.d(this.TAG, "endAnimations, moveReset Translation");
                      if (k < 0)
                      {
                        if (j < 0)
                        {
                          i = this.bUJ.size() - 1;
                          if (i >= 0)
                          {
                            j = i - 1;
                            localObject1 = this.bUJ.get(i);
                            s.s(localObject1, "mAdditionsList[i]");
                            localObject1 = (ArrayList)localObject1;
                            i = ((ArrayList)localObject1).size() - 1;
                            if (i < 0) {}
                          }
                          for (;;)
                          {
                            k = i - 1;
                            localObject2 = ((ArrayList)localObject1).get(i);
                            s.s(localObject2, "additions[j]");
                            localObject2 = (RecyclerView.v)localObject2;
                            localView = ((RecyclerView.v)localObject2).caK;
                            s.s(localView, "item.itemView");
                            localView.setAlpha(1.0F);
                            r((RecyclerView.v)localObject2);
                            ((ArrayList)localObject1).remove(i);
                            if (((ArrayList)localObject1).isEmpty()) {
                              this.bUJ.remove(localObject1);
                            }
                            if (k < 0)
                            {
                              if (j < 0)
                              {
                                i = this.bUL.size() - 1;
                                if (i >= 0)
                                {
                                  j = i - 1;
                                  localObject1 = this.bUL.get(i);
                                  s.s(localObject1, "mChangesList[i]");
                                  localObject1 = (ArrayList)localObject1;
                                  i = ((ArrayList)localObject1).size() - 1;
                                  if (i < 0) {}
                                }
                                for (;;)
                                {
                                  k = i - 1;
                                  localObject2 = ((ArrayList)localObject1).get(i);
                                  s.s(localObject2, "changes[j]");
                                  a((a)localObject2);
                                  if (((ArrayList)localObject1).isEmpty()) {
                                    this.bUL.remove(localObject1);
                                  }
                                  if (k < 0)
                                  {
                                    if (j < 0)
                                    {
                                      ae((List)this.bUO);
                                      ae((List)this.bUN);
                                      ae((List)this.bUM);
                                      ae((List)this.bUP);
                                      Kv();
                                      AppMethodBeat.o(304682);
                                      return;
                                    }
                                    i = j;
                                    break;
                                  }
                                  i = k;
                                }
                              }
                              i = j;
                              break;
                            }
                            i = k;
                          }
                        }
                        i = j;
                        break;
                      }
                      i = k;
                    }
                  }
                  i = j;
                }
              }
              i = j;
            }
          }
          i = j;
        }
      }
      i = j;
    }
  }
  
  public final boolean a(RecyclerView.v paramv)
  {
    AppMethodBeat.i(304627);
    s.u(paramv, "viewHolder");
    Log.d(this.TAG, "animateRemove layoutPosition:" + paramv.KI() + " adapterPosition:" + paramv.KJ() + " hashCode:" + paramv.hashCode());
    d(paramv);
    this.bUF.add(paramv);
    Object localObject = this.mkw.getAdapter();
    int i;
    int j;
    int k;
    c.a locala;
    if ((localObject != null) && (((RecyclerView.a)localObject).getItemCount() == 3))
    {
      i = 1;
      if (i != 0)
      {
        Log.d(this.TAG, s.X("animateRemove layoutPosition:", Integer.valueOf(paramv.KI())));
        if (paramv.KI() != 2) {
          break label314;
        }
        paramv = this.mkw.fU(1);
        if (paramv != null)
        {
          Log.d(this.TAG, "animateRemove add moveInfo from adapterPosition 1");
          localObject = this.bUH;
          i = paramv.caK.getLeft();
          j = paramv.caK.getTop();
          k = paramv.caK.getLeft();
          locala = c.LHl;
          ((ArrayList)localObject).add(new d(paramv, i, j, k, c.glA(), 1));
        }
        paramv = this.mkw.fU(2);
        if (paramv != null)
        {
          Log.d(this.TAG, "animateRemove add moveInfo from adapterPosition 2");
          localObject = this.bUH;
          i = paramv.caK.getLeft();
          j = paramv.caK.getTop();
          k = paramv.caK.getLeft();
          locala = c.LHl;
          ((ArrayList)localObject).add(new d(paramv, i, j, k, c.glA(), 1));
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(304627);
      return true;
      i = 0;
      break;
      label314:
      if (paramv.KI() == 1)
      {
        paramv = this.mkw.fU(1);
        if (paramv != null)
        {
          Log.d(this.TAG, "animateRemove add moveInfo from adapterPosition 1");
          localObject = this.bUH;
          i = paramv.caK.getLeft();
          j = paramv.caK.getTop();
          k = paramv.caK.getLeft();
          locala = c.LHl;
          ((ArrayList)localObject).add(new d(paramv, i, j, k, c.glA(), 1));
        }
      }
    }
  }
  
  public final boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(304638);
    s.u(paramv, "holder");
    View localView = paramv.caK;
    s.s(localView, "holder.itemView");
    paramInt1 += (int)paramv.caK.getTranslationX();
    paramInt2 += (int)paramv.caK.getTranslationY();
    d(paramv);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      B(paramv);
      AppMethodBeat.o(304638);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    this.bUH.add(new d(paramv, paramInt1, paramInt2, paramInt3, paramInt4));
    Log.d(this.TAG, "animateMove fromX:" + paramInt1 + " fromY:" + paramInt2 + " toX:" + paramInt3 + " toY:" + paramInt4 + " deltaX:" + i + " deltaY:" + j + " holder.left:" + paramv.caK.getLeft() + " holder.top:" + paramv.caK.getTop() + " holder.position:" + paramv.KJ());
    AppMethodBeat.o(304638);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(304650);
    s.u(paramv1, "oldHolder");
    s.u(paramv2, "newHolder");
    if (paramv1 == paramv2)
    {
      boolean bool = a(paramv1, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(304650);
      return bool;
    }
    float f1 = paramv1.caK.getTranslationX();
    float f2 = paramv1.caK.getTranslationY();
    float f3 = paramv1.caK.getAlpha();
    d(paramv1);
    int i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    paramv1.caK.setTranslationX(f1);
    paramv1.caK.setTranslationY(f2);
    paramv1.caK.setAlpha(f3);
    d(paramv2);
    paramv2.caK.setTranslationX(-i);
    paramv2.caK.setTranslationY(-j);
    paramv2.caK.setAlpha(0.0F);
    RecyclerView.a locala = this.mkw.getAdapter();
    if (locala == null)
    {
      i = 0;
      if (((i != 2) && (i != 3)) || (paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
        break label254;
      }
      this.bUI.add(new a(paramv1, paramv2, paramInt1, paramInt2, paramInt3, paramInt4, f1, f2));
    }
    for (;;)
    {
      AppMethodBeat.o(304650);
      return true;
      i = locala.getItemCount();
      break;
      label254:
      this.bUI.add(new a(paramv1, paramv2, paramInt1, paramInt2, paramInt3, paramInt4, 0.0F, 0.0F));
    }
  }
  
  public final boolean a(RecyclerView.v paramv, List<? extends Object> paramList)
  {
    AppMethodBeat.i(304690);
    s.u(paramv, "viewHolder");
    s.u(paramList, "payloads");
    if (!((Collection)paramList).isEmpty()) {}
    for (int i = 1; (i != 0) || (super.a(paramv, paramList)); i = 0)
    {
      AppMethodBeat.o(304690);
      return true;
    }
    AppMethodBeat.o(304690);
    return false;
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(304633);
    s.u(paramv, "viewHolder");
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("animateAdd layoutPosition:").append(paramv.KI()).append(" adapterPosition:").append(paramv.KJ()).append(" hashCode:").append(paramv.hashCode()).append(" itemCount:");
    Object localObject1 = this.mkw.getAdapter();
    int i;
    label140:
    int j;
    int k;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.d((String)localObject2, localObject1);
      d(paramv);
      paramv.caK.setAlpha(0.0F);
      this.bUG.add(paramv);
      localObject1 = this.mkw.getAdapter();
      if (localObject1 != null) {
        break label234;
      }
      i = 0;
      if (i != 2) {
        break label243;
      }
      if (paramv.KI() == 1)
      {
        localObject1 = this.bUH;
        i = paramv.caK.getLeft();
        j = paramv.caK.getTop();
        localObject2 = c.LHl;
        k = c.gly();
        localObject2 = c.LHl;
        ((ArrayList)localObject1).add(new d(paramv, i, j, k, c.glx(), 1));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(304633);
      return true;
      localObject1 = Integer.valueOf(((RecyclerView.a)localObject1).getItemCount());
      break;
      label234:
      i = ((RecyclerView.a)localObject1).getItemCount();
      break label140;
      label243:
      if (i == 3)
      {
        localObject1 = this.bUH;
        i = paramv.caK.getLeft();
        j = paramv.caK.getTop();
        localObject2 = c.LHl;
        ((ArrayList)localObject1).add(new d(paramv, i, j, 0, c.glA(), 1));
        paramv = this.mkw.fU(2);
        if (paramv != null)
        {
          localObject1 = this.bUH;
          i = paramv.caK.getLeft();
          j = paramv.caK.getTop();
          k = paramv.caK.getLeft();
          localObject2 = c.LHl;
          ((ArrayList)localObject1).add(new d(paramv, i, j, k, c.glA(), 1));
        }
      }
      else if (i >= 4)
      {
        paramv = paramv.caK.findViewById(e.c.LDI);
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
    AppMethodBeat.i(304657);
    s.u(paramv, "item");
    Log.d(this.TAG, s.X("endAnimation ", Integer.valueOf(paramv.KJ())));
    View localView1 = paramv.caK;
    s.s(localView1, "item.itemView");
    View localView2 = paramv.caK.findViewById(e.c.multi_task_item_bg);
    localView1.animate().cancel();
    int i = this.bUH.size() - 1;
    if (i >= 0) {}
    for (;;)
    {
      int j = i - 1;
      Object localObject1 = this.bUH.get(i);
      s.s(localObject1, "mPendingMoves[i]");
      if (((d)localObject1).bVi == paramv)
      {
        localView1.setTranslationY(0.0F);
        localView1.setTranslationX(0.0F);
        B(paramv);
        this.bUH.remove(i);
        Log.d(this.TAG, "endAnimation, reset");
      }
      if (j < 0)
      {
        a((List)this.bUI, paramv);
        if (this.bUF.remove(paramv))
        {
          localView1.setAlpha(1.0F);
          A(paramv);
        }
        if (this.bUG.remove(paramv))
        {
          localView1.setAlpha(1.0F);
          r(paramv);
        }
        i = this.bUL.size() - 1;
        if (i >= 0) {}
        for (;;)
        {
          j = i - 1;
          localObject1 = this.bUL.get(i);
          s.s(localObject1, "mChangesList[i]");
          localObject1 = (ArrayList)localObject1;
          a((List)localObject1, paramv);
          if (((ArrayList)localObject1).isEmpty()) {
            this.bUL.remove(i);
          }
          if (j < 0)
          {
            i = this.bUK.size() - 1;
            if (i >= 0) {}
            for (;;)
            {
              int k = i - 1;
              localObject1 = this.bUK.get(i);
              s.s(localObject1, "mMovesList[i]");
              localObject1 = (ArrayList)localObject1;
              j = ((ArrayList)localObject1).size() - 1;
              int m;
              Object localObject2;
              if (j >= 0)
              {
                m = j - 1;
                localObject2 = ((ArrayList)localObject1).get(j);
                s.s(localObject2, "moves[j]");
                if (((d)localObject2).bVi == paramv)
                {
                  localView1.setTranslationY(0.0F);
                  localView1.setTranslationX(0.0F);
                  B(paramv);
                  ((ArrayList)localObject1).remove(j);
                  if (((ArrayList)localObject1).isEmpty()) {
                    this.bUK.remove(i);
                  }
                  Log.d(this.TAG, "endAnimations,move reset!");
                }
              }
              else
              {
                label434:
                if (k >= 0) {
                  break label830;
                }
                i = this.bUJ.size() - 1;
                if (i < 0) {}
              }
              for (;;)
              {
                j = i - 1;
                localObject1 = this.bUJ.get(i);
                s.s(localObject1, "mAdditionsList[i]");
                localObject1 = (ArrayList)localObject1;
                if (((ArrayList)localObject1).remove(paramv))
                {
                  localView1.setAlpha(1.0F);
                  r(paramv);
                  if (((ArrayList)localObject1).isEmpty()) {
                    this.bUJ.remove(i);
                  }
                }
                if (j < 0)
                {
                  i = this.LFJ.size() - 1;
                  if (i >= 0) {}
                  for (;;)
                  {
                    k = i - 1;
                    localObject1 = this.LFJ.get(i);
                    s.s(localObject1, "mLayoutsList[i]");
                    localObject1 = (ArrayList)localObject1;
                    j = ((ArrayList)localObject1).size() - 1;
                    if (j >= 0) {}
                    for (;;)
                    {
                      m = j - 1;
                      localObject2 = ((ArrayList)localObject1).get(j);
                      s.s(localObject2, "layouts[j]");
                      localObject2 = (c)localObject2;
                      if (((c)localObject2).bVi == paramv)
                      {
                        localLayoutParams = localView2.getLayoutParams();
                        m = ((c)localObject2).LFN;
                        locala = c.LHl;
                        f = m - c.access$get_2A$cp();
                        locala = c.LHl;
                        localLayoutParams.height = kotlin.h.a.eH(f * c.glI());
                        localView1.getLayoutParams().width = ((c)localObject2).LFN;
                        localLayoutParams = localView1.getLayoutParams();
                        f = ((c)localObject2).LFN;
                        localObject2 = c.LHl;
                        localLayoutParams.height = kotlin.h.a.eH(f * c.glH());
                        localView1.requestLayout();
                        ((ArrayList)localObject1).remove(j);
                        if (((ArrayList)localObject1).isEmpty()) {
                          this.LFJ.remove(i);
                        }
                      }
                      while (m < 0)
                      {
                        ViewGroup.LayoutParams localLayoutParams;
                        c.a locala;
                        float f;
                        if (k >= 0) {
                          break label818;
                        }
                        this.bUO.remove(paramv);
                        this.bUM.remove(paramv);
                        this.bUP.remove(paramv);
                        this.bUN.remove(paramv);
                        IX();
                        AppMethodBeat.o(304657);
                        return;
                        if (m < 0) {
                          break label434;
                        }
                        j = m;
                        break;
                      }
                      j = m;
                    }
                    label818:
                    i = k;
                  }
                }
                i = j;
              }
              label830:
              i = k;
            }
          }
          i = j;
        }
      }
      i = j;
    }
  }
  
  public final boolean f(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    int j = 0;
    AppMethodBeat.i(304620);
    s.u(paramv, "viewHolder");
    s.u(paramc1, "preInfo");
    s.u(paramc2, "postInfo");
    Log.d(this.TAG, "animatePersistence layoutPosition:" + paramv.KI() + " adapterPosition:" + paramv.KJ() + " hashCode:" + paramv.hashCode());
    int i;
    int k;
    int m;
    if ((paramc1.left == paramc2.left) && (paramc1.top == paramc2.top))
    {
      if (!gkM())
      {
        paramc2 = this.mkw.getAdapter();
        if ((paramc2 != null) && (paramc2.getItemCount() == 2)) {}
        for (i = 1; (i != 0) && (paramv.KJ() == 1); i = 0)
        {
          k = paramc1.left;
          m = paramc1.top;
          paramc1 = c.LHl;
          i = c.gly();
          paramc1 = c.LHl;
          j = c.glx();
          s.u(paramv, "holder");
          paramc1 = paramv.caK;
          s.s(paramc1, "holder.itemView");
          k = (int)paramv.caK.getTranslationX() + k;
          m += (int)paramv.caK.getTranslationY();
          d(paramv);
          int n = k - paramv.caK.getLeft();
          int i1 = m - paramv.caK.getTop();
          if (n != 0) {
            paramc1.setTranslationX(n);
          }
          if (i1 != 0) {
            paramc1.setTranslationY(i1);
          }
          this.bUH.add(new d(paramv, k, m, i, j, 1));
          Log.d(this.TAG, "animateMove2 fromX:" + k + " fromY:" + m + " toX:" + i + " toY:" + j + " deltaX:" + n + " deltaY:" + i1 + " holder.left:" + paramv.caK.getLeft() + " holder.top:" + paramv.caK.getTop() + " holder.position:" + paramv.KJ());
          AppMethodBeat.o(304620);
          return true;
        }
      }
      B(paramv);
      AppMethodBeat.o(304620);
      return false;
    }
    RecyclerView.a locala;
    if (!gkM())
    {
      locala = this.mkw.getAdapter();
      if ((locala != null) && (locala.getItemCount() == 2)) {}
      for (i = 1; (i != 0) && (paramv.KJ() == 1); i = 0)
      {
        i = paramc1.left;
        j = paramc1.top;
        paramc1 = c.LHl;
        k = c.gly();
        paramc1 = c.LHl;
        b(paramv, i, j, k, c.glx());
        AppMethodBeat.o(304620);
        return true;
      }
      locala = this.mkw.getAdapter();
      if ((locala != null) && (locala.getItemCount() == 3)) {
        i = 1;
      }
      while (i != 0) {
        if (paramv.KJ() == 1)
        {
          i = paramc1.left;
          j = paramc1.top;
          paramc1 = c.LHl;
          b(paramv, i, j, 0, c.glA());
          AppMethodBeat.o(304620);
          return true;
          i = 0;
        }
        else if (paramv.KJ() == 2)
        {
          i = paramc1.left;
          j = paramc1.top;
          k = paramc2.left;
          m = paramc2.top;
          paramc1 = c.LHl;
          a(paramv, i, j, k, m, c.glA());
          AppMethodBeat.o(304620);
          return true;
        }
      }
    }
    if (gkM())
    {
      locala = this.mkw.getAdapter();
      i = j;
      if (locala != null)
      {
        i = j;
        if (locala.getItemCount() == 3) {
          i = 1;
        }
      }
      if (i != 0)
      {
        paramv.KJ();
        if (paramv.KJ() == 2)
        {
          i = paramc1.left;
          j = paramc1.top;
          k = paramc2.left;
          m = paramc2.top;
          paramc1 = c.LHl;
          a(paramv, i, j, k, m, c.glA());
          AppMethodBeat.o(304620);
          return true;
        }
      }
    }
    boolean bool = a(paramv, paramc1.left, paramc1.top, paramc2.left, paramc2.top);
    AppMethodBeat.o(304620);
    return bool;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(304664);
    if (!((Collection)this.bUG).isEmpty())
    {
      i = 1;
      label128:
      label149:
      label170:
      if (i == 0)
      {
        if (((Collection)this.bUI).isEmpty()) {
          break label250;
        }
        i = 1;
        label44:
        label191:
        if (i == 0)
        {
          if (((Collection)this.bUH).isEmpty()) {
            break label255;
          }
          i = 1;
          label65:
          label212:
          if (i == 0)
          {
            if (((Collection)this.bUF).isEmpty()) {
              break label260;
            }
            i = 1;
            label86:
            if (i == 0)
            {
              if (((Collection)this.bUN).isEmpty()) {
                break label265;
              }
              i = 1;
              label107:
              if (i == 0)
              {
                if (((Collection)this.bUO).isEmpty()) {
                  break label270;
                }
                i = 1;
                if (i == 0)
                {
                  if (((Collection)this.bUM).isEmpty()) {
                    break label275;
                  }
                  i = 1;
                  if (i == 0)
                  {
                    if (((Collection)this.bUP).isEmpty()) {
                      break label280;
                    }
                    i = 1;
                    if (i == 0)
                    {
                      if (((Collection)this.bUK).isEmpty()) {
                        break label285;
                      }
                      i = 1;
                      if (i == 0)
                      {
                        if (((Collection)this.bUJ).isEmpty()) {
                          break label290;
                        }
                        i = 1;
                        if (i == 0) {
                          if (((Collection)this.bUL).isEmpty()) {
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
      AppMethodBeat.o(304664);
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
    AppMethodBeat.o(304664);
    return false;
  }
  
  public final void s(RecyclerView.v paramv)
  {
    AppMethodBeat.i(304674);
    s.u(paramv, "viewHolder");
    super.s(paramv);
    com.tencent.mm.plugin.multitask.ui.minusscreen.d.a locala = this.LFI;
    if (locala != null) {
      locala.Y(paramv);
    }
    AppMethodBeat.o(304674);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$ChangeInfo;", "", "oldHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "newHolder", "fromX", "", "fromY", "toX", "toY", "newTransX", "", "newTransY", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIIIFF)V", "getFromX", "()I", "setFromX", "(I)V", "getFromY", "setFromY", "getNewHolder", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "setNewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "getNewTransX", "()F", "setNewTransX", "(F)V", "getNewTransY", "setNewTransY", "getOldHolder", "setOldHolder", "getToX", "setToX", "getToY", "setToY", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
  {
    float LFK;
    float LFL;
    RecyclerView.v bVc;
    RecyclerView.v bVd;
    int bVe;
    int bVf;
    int bVg;
    int bVh;
    
    public a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(304464);
      this.bVc = paramv;
      this.bVd = paramInt1;
      this.bVe = paramInt2;
      this.bVf = paramInt3;
      this.bVg = paramInt4;
      this.bVh = paramFloat1;
      this.LFK = paramFloat2;
      Object localObject;
      this.LFL = localObject;
      AppMethodBeat.o(304464);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$LayoutInfo;", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "fromWidth", "", "toWidth", "animator", "Landroid/animation/ValueAnimator;", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IILandroid/animation/ValueAnimator;)V", "getAnimator", "()Landroid/animation/ValueAnimator;", "setAnimator", "(Landroid/animation/ValueAnimator;)V", "getFromWidth", "()I", "setFromWidth", "(I)V", "getHolder", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "setHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "getToWidth", "setToWidth", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
  {
    int LFN;
    int LFO;
    ValueAnimator animator;
    RecyclerView.v bVi;
    
    private c(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(304465);
      this.bVi = paramInt1;
      this.LFN = paramInt2;
      int i;
      this.LFO = i;
      this.animator = null;
      AppMethodBeat.o(304465);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$MoveInfo;", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "fromX", "", "fromY", "toX", "toY", "moveType", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIIII)V", "getFromX", "()I", "setFromX", "(I)V", "getFromY", "setFromY", "getHolder", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "setHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "getMoveType", "getToX", "setToX", "getToY", "setToY", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
  {
    int bVe;
    int bVf;
    int bVg;
    int bVh;
    RecyclerView.v bVi;
    final int uZr;
    
    public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      AppMethodBeat.i(304470);
      this.bVi = paramInt1;
      this.bVe = paramInt2;
      this.bVf = paramInt3;
      this.bVg = paramInt4;
      this.bVh = paramInt5;
      int i;
      this.uZr = i;
      AppMethodBeat.o(304470);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateAddImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends AnimatorListenerAdapter
  {
    e(a parama, RecyclerView.v paramv, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(304474);
      s.u(paramAnimator, "animator");
      localView.setAlpha(1.0F);
      AppMethodBeat.o(304474);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(304481);
      s.u(paramAnimator, "animator");
      localViewPropertyAnimator.setListener(null);
      this.LFM.r(localv);
      this.LFM.bUM.remove(localv);
      this.LFM.IX();
      AppMethodBeat.o(304481);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(304471);
      s.u(paramAnimator, "animator");
      AppMethodBeat.o(304471);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateChangeImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animator", "Landroid/animation/Animator;", "onAnimationStart", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends AnimatorListenerAdapter
  {
    f(a parama, a.a parama1, ViewPropertyAnimator paramViewPropertyAnimator, View paramView, float paramFloat1, float paramFloat2) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(304500);
      s.u(paramAnimator, "animator");
      localViewPropertyAnimator.setListener(null);
      this.$view.setAlpha(1.0F);
      this.$view.setTranslationX(f1);
      this.$view.setTranslationY(f2);
      this.LFM.r(locala.bVc);
      this.LFM.bUP.remove(locala.bVc);
      this.LFM.IX();
      AppMethodBeat.o(304500);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(304485);
      s.u(paramAnimator, "animator");
      AppMethodBeat.o(304485);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateChangeImpl$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animator", "Landroid/animation/Animator;", "onAnimationStart", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends AnimatorListenerAdapter
  {
    g(a parama, a.a parama1, ViewPropertyAnimator paramViewPropertyAnimator, View paramView, float paramFloat1, float paramFloat2) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(304499);
      s.u(paramAnimator, "animator");
      this.LFT.setListener(null);
      this.LFU.setAlpha(1.0F);
      this.LFU.setTranslationX(f1);
      this.LFU.setTranslationY(f2);
      this.LFM.r(locala.bVd);
      this.LFM.bUP.remove(locala.bVd);
      this.LFM.IX();
      AppMethodBeat.o(304499);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(304486);
      s.u(paramAnimator, "animator");
      AppMethodBeat.o(304486);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateLayoutImpl$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends AnimatorListenerAdapter
  {
    h(View paramView1, a.c paramc, View paramView2, ValueAnimator paramValueAnimator) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(304482);
      s.u(paramAnimator, "animator");
      paramAnimator = this.LFV.getLayoutParams();
      int i = this.LFW.LFO;
      c.a locala = c.LHl;
      float f = i - c.access$get_2A$cp();
      locala = c.LHl;
      paramAnimator.height = kotlin.h.a.eH(f * c.glI());
      this.$view.getLayoutParams().width = this.LFW.LFO;
      paramAnimator = this.$view.getLayoutParams();
      f = this.LFW.LFO;
      locala = c.LHl;
      paramAnimator.height = kotlin.h.a.eH(f * c.glH());
      this.$view.requestLayout();
      AppMethodBeat.o(304482);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(304489);
      s.u(paramAnimator, "animator");
      this.LFX.removeListener((Animator.AnimatorListener)this);
      this.LFW.animator = null;
      AppMethodBeat.o(304489);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(304475);
      s.u(paramAnimator, "animator");
      AppMethodBeat.o(304475);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateMoveImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    extends AnimatorListenerAdapter
  {
    i(a parama, RecyclerView.v paramv, int paramInt1, View paramView, int paramInt2, ViewPropertyAnimator paramViewPropertyAnimator) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(304484);
      s.u(paramAnimator, "animator");
      if (i1 != 0) {
        this.$view.setTranslationX(0.0F);
      }
      if (n != 0) {
        this.$view.setTranslationY(0.0F);
      }
      AppMethodBeat.o(304484);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(304492);
      s.u(paramAnimator, "animator");
      localViewPropertyAnimator.setListener(null);
      this.LFM.B(localv);
      this.LFM.bUN.remove(localv);
      this.LFM.IX();
      AppMethodBeat.o(304492);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(304477);
      s.u(paramAnimator, "animator");
      this.LFM.E(localv);
      AppMethodBeat.o(304477);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateRemoveImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animator", "Landroid/animation/Animator;", "onAnimationStart", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    extends AnimatorListenerAdapter
  {
    j(a parama, RecyclerView.v paramv, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(304479);
      s.u(paramAnimator, "animator");
      localViewPropertyAnimator.setListener(null);
      localView.setAlpha(1.0F);
      this.LFM.A(this.ucs);
      this.LFM.bUO.remove(this.ucs);
      this.LFM.IX();
      AppMethodBeat.o(304479);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(304473);
      s.u(paramAnimator, "animator");
      this.LFM.C(this.ucs);
      AppMethodBeat.o(304473);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.a.a
 * JD-Core Version:    0.7.0.1
 */