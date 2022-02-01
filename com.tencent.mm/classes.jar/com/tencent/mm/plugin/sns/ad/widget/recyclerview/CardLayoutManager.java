package com.tencent.mm.plugin.sns.ad.widget.recyclerview;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.j;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.util.SparseBooleanArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CardLayoutManager
  extends RecyclerView.LayoutManager
{
  int DBe;
  int DBf;
  int DBg;
  int DBh;
  int DBi;
  private int DBj;
  int DBk;
  private int DBl;
  private float DBm;
  boolean DBn;
  public a DBo;
  int DBp;
  private d DBq;
  private final e DBr;
  public c DBs;
  boolean DBt;
  private boolean DBu;
  int DBv;
  final RecyclerView mRecyclerView;
  
  public CardLayoutManager(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(202465);
    this.DBf = -1;
    this.DBg = -1;
    this.DBh = 3;
    this.DBj = -2147483648;
    this.DBk = -2147483648;
    this.DBl = 0;
    this.DBm = 0.0F;
    this.DBn = true;
    this.DBp = 0;
    this.DBt = false;
    this.DBu = false;
    this.DBv = 0;
    this.DBr = new e();
    this.mRecyclerView = paramRecyclerView;
    if (this.mRecyclerView != null)
    {
      this.mRecyclerView.setOnFlingListener(new b());
      this.DBo = new a(this.mRecyclerView.getContext(), this);
      AppMethodBeat.o(202465);
      return;
    }
    Log.e("SnsAd.CardLayoutManager", "the layout manager will not work properly, because of null recycler view!!!");
    AppMethodBeat.o(202465);
  }
  
  private void Ya(int paramInt)
  {
    if (this.DBk != paramInt)
    {
      this.DBj = this.DBk;
      this.DBk = paramInt;
      this.DBu = true;
    }
  }
  
  private int Yb(int paramInt)
  {
    if (this.DBi == 0) {}
    do
    {
      return 0;
      if (paramInt >= 0) {
        return paramInt % this.DBi;
      }
    } while (paramInt % this.DBi == 0);
    int i = this.DBi;
    return i + paramInt % i;
  }
  
  private int Yc(int paramInt)
  {
    AppMethodBeat.i(202483);
    int i = this.DBp;
    this.DBp = 0;
    if (i == 2)
    {
      AppMethodBeat.o(202483);
      return paramInt + 1;
    }
    if (i == 1)
    {
      AppMethodBeat.o(202483);
      return paramInt;
    }
    if (eYG() < 0.5F)
    {
      AppMethodBeat.o(202483);
      return paramInt;
    }
    AppMethodBeat.o(202483);
    return paramInt + 1;
  }
  
  private void Yd(int paramInt)
  {
    AppMethodBeat.i(202484);
    int i = this.DBf;
    this.mRecyclerView.a(i * paramInt - this.DBe, 0, null);
    AppMethodBeat.o(202484);
  }
  
  private void c(RecyclerView.n paramn, int paramInt)
  {
    float f1 = 0.5F;
    AppMethodBeat.i(202480);
    if ((this.DBi == 0) || (this.DBf <= 0) || (this.DBg <= 0) || (this.DBq == null))
    {
      AppMethodBeat.o(202480);
      return;
    }
    int j = eYE();
    int k = eYF();
    float f2 = eYG();
    if ((this.DBm > 0.5F) && (f2 < 0.5F) && (paramInt < 0)) {}
    for (;;)
    {
      int i = j;
      while (i <= k)
      {
        int m = Yb(i);
        if ((m >= 0) && (m < this.DBi))
        {
          View localView = paramn.cp(m);
          this.DBq.fe(localView);
          if ((localView != null) && (this.DBr != null))
          {
            addView(localView, 0);
            measureChildWithMargins(localView, 0, 0);
            this.DBq.a(this.DBe, f1, localView, i - j, paramInt);
            this.DBr.Yg(m);
          }
        }
        i += 1;
      }
      this.DBm = f1;
      Ya(j);
      AppMethodBeat.o(202480);
      return;
      f1 = f2;
    }
  }
  
  private int eYE()
  {
    AppMethodBeat.i(202481);
    if ((this.DBf <= 0) || (this.DBg <= 0))
    {
      AppMethodBeat.o(202481);
      return 0;
    }
    int i = (int)Math.floor(this.DBe * 1.0D / this.DBf);
    AppMethodBeat.o(202481);
    return i;
  }
  
  private int eYF()
  {
    AppMethodBeat.i(202482);
    int i = eYE();
    int j = this.DBh;
    AppMethodBeat.o(202482);
    return i + j;
  }
  
  private float eYG()
  {
    if ((this.DBf <= 0) || (this.DBg <= 0)) {}
    do
    {
      return 0.0F;
      if (this.DBe >= 0) {
        return this.DBe % this.DBf * 1.0F / this.DBf;
      }
    } while (this.DBe % this.DBf == 0);
    return this.DBe % this.DBf * 1.0F / this.DBf + 1.0F;
  }
  
  private void eYH()
  {
    AppMethodBeat.i(202485);
    Yd(Yc(eYE()));
    AppMethodBeat.o(202485);
  }
  
  private void ip(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202473);
    Log.d("SnsAd.CardLayoutManager", "firstVirtualPosition is " + paramInt1 + ", lastVirtualPosition " + paramInt2 + ", should notify " + this.DBu);
    c localc = this.DBs;
    if ((this.DBu) && (localc != null) && (paramInt1 != -2147483648))
    {
      int i = Yb(paramInt1);
      paramInt1 = -1;
      if (paramInt2 != -2147483648) {
        paramInt1 = Yb(paramInt2);
      }
      localc.a(this, i, paramInt1);
    }
    this.DBu = false;
    AppMethodBeat.o(202473);
  }
  
  public final RecyclerView.v XZ(int paramInt)
  {
    AppMethodBeat.i(202470);
    if (this.mRecyclerView == null)
    {
      AppMethodBeat.o(202470);
      return null;
    }
    try
    {
      int i = this.mRecyclerView.getChildCount() - 1;
      while (i >= 0)
      {
        Object localObject = this.mRecyclerView.getChildAt(i);
        if (RecyclerView.bw((View)localObject) == paramInt)
        {
          localObject = this.mRecyclerView.bi((View)localObject);
          AppMethodBeat.o(202470);
          return localObject;
        }
        i -= 1;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202470);
    }
  }
  
  public final void a(d paramd)
  {
    this.DBq = paramd;
    if (this.DBq != null) {
      this.DBq.DBz = this;
    }
  }
  
  public final RecyclerView.a cWP()
  {
    AppMethodBeat.i(202468);
    try
    {
      if (this.mRecyclerView != null)
      {
        RecyclerView.a locala = this.mRecyclerView.getAdapter();
        AppMethodBeat.o(202468);
        return locala;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202468);
    }
    return null;
  }
  
  public boolean canScrollHorizontally()
  {
    return (this.DBf > 0) && (this.DBg > 0);
  }
  
  public final void eYB()
  {
    AppMethodBeat.i(202466);
    try
    {
      if ((this.DBo != null) && (3000L > 0L)) {
        this.DBo.eYI();
      }
      AppMethodBeat.o(202466);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202466);
    }
  }
  
  public final void eYC()
  {
    AppMethodBeat.i(202467);
    try
    {
      if (this.DBo != null) {
        this.DBo.cancel();
      }
      AppMethodBeat.o(202467);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202467);
    }
  }
  
  public final int eYD()
  {
    AppMethodBeat.i(202469);
    try
    {
      if (this.DBt)
      {
        int i = Yb(this.DBk);
        AppMethodBeat.o(202469);
        return i;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202469);
    }
    return -1;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(202471);
    RecyclerView.LayoutParams localLayoutParams = new RecyclerView.LayoutParams(-2, -2);
    AppMethodBeat.o(202471);
    return localLayoutParams;
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.n paramn)
  {
    AppMethodBeat.i(202475);
    super.onDetachedFromWindow(paramRecyclerView, paramn);
    this.DBe = 0;
    AppMethodBeat.o(202475);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(202476);
    this.DBt = false;
    if ((params == null) || (paramn == null))
    {
      Log.e("SnsAd.CardLayoutManager", "the state or recycler is null!!! Right?");
      AppMethodBeat.o(202476);
      return;
    }
    try
    {
      this.DBi = params.getItemCount();
      if ((this.DBi == 0) || (params.aue))
      {
        Log.d("SnsAd.CardLayoutManager", "there is no item or is pre layout remove all cached view!!");
        removeAndRecycleAllViews(paramn);
        AppMethodBeat.o(202476);
        return;
      }
      if ((this.DBf == -1) || (this.DBg == -1))
      {
        params = this.DBq;
        if (params != null)
        {
          View localView = paramn.cp(0);
          params.fe(localView);
          addView(localView);
          measureChildWithMargins(localView, 0, 0);
          this.DBf = getDecoratedMeasuredWidth(localView);
          this.DBg = getDecoratedMeasuredHeight(localView);
          params.Ye(this.DBh);
          params.iq(this.DBf, this.DBg);
        }
      }
      detachAndScrapAttachedViews(paramn);
      c(paramn, 0);
      AppMethodBeat.o(202476);
      return;
    }
    catch (Throwable paramn)
    {
      AppMethodBeat.o(202476);
    }
  }
  
  public void onLayoutCompleted(RecyclerView.s params)
  {
    AppMethodBeat.i(202477);
    try
    {
      super.onLayoutCompleted(params);
      if (!this.DBt) {
        ip(this.DBk, this.DBj);
      }
      this.DBt = true;
      AppMethodBeat.o(202477);
      return;
    }
    catch (Throwable params)
    {
      AppMethodBeat.o(202477);
    }
  }
  
  public void onMeasure(RecyclerView.n paramn, RecyclerView.s params, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202474);
    try
    {
      d locald = this.DBq;
      if ((locald == null) || (!locald.Yf(paramInt1))) {
        super.onMeasure(paramn, params, paramInt1, paramInt2);
      }
      AppMethodBeat.o(202474);
      return;
    }
    catch (Throwable paramn)
    {
      AppMethodBeat.o(202474);
    }
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(202472);
    try
    {
      super.onScrollStateChanged(paramInt);
      Log.d("SnsAd.CardLayoutManager", "the onScrollStateChanged is called, state = ".concat(String.valueOf(paramInt)));
      if (this.DBs != null) {
        this.DBs.a(this, paramInt);
      }
      if (paramInt == 0)
      {
        Log.d("SnsAd.CardLayoutManager", "the onScrollStateChanged is called, mScrollFixed = " + this.DBn);
        if (!this.DBn)
        {
          eYH();
          this.DBn = true;
          AppMethodBeat.o(202472);
          return;
        }
        ip(this.DBk, this.DBj);
        AppMethodBeat.o(202472);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202472);
      return;
    }
    if (paramInt == 1)
    {
      this.DBn = false;
      d locald = this.DBq;
      if ((this.DBv == 1) && (locald != null) && (eYG() > 0.5F))
      {
        this.DBu = true;
        this.DBv = 0;
      }
    }
    AppMethodBeat.o(202472);
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(202478);
    for (;;)
    {
      int i;
      try
      {
        params = this.DBr.DBB;
        if (params != null)
        {
          i = 0;
          if (i < params.size())
          {
            params.put(params.keyAt(i), false);
            i += 1;
            continue;
          }
        }
        this.DBe += paramInt;
        detachAndScrapAttachedViews(paramn);
        c(paramn, paramInt);
        Object localObject1 = this.DBr;
        params = ((e)localObject1).DBB;
        Object localObject2 = ((e)localObject1).DBC;
        if (params != null)
        {
          i = params.size();
          if ((i != 0) && (localObject2 != null)) {}
        }
        else
        {
          AppMethodBeat.o(202478);
          return paramInt;
        }
        ((List)localObject2).clear();
        i = 0;
        if (i < params.size())
        {
          int j = params.keyAt(i);
          boolean bool = params.get(j);
          if ((j < 0) || (j >= ((e)localObject1).DBw.DBi) || (bool)) {
            break label309;
          }
          View localView = paramn.cp(j);
          Log.d("SnsAd.CardLayoutManager", "pos is " + j + ", recycle view " + localView);
          ((e)localObject1).DBw.removeAndRecycleView(localView, paramn);
          ((List)localObject2).add(Integer.valueOf(j));
          break label309;
        }
        localObject1 = ((List)localObject2).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Integer)((Iterator)localObject1).next();
          if (localObject2 == null) {
            continue;
          }
          params.delete(((Integer)localObject2).intValue());
          continue;
        }
        paramn.clear();
      }
      catch (Throwable paramn)
      {
        AppMethodBeat.o(202478);
        return 0;
      }
      continue;
      label309:
      i += 1;
    }
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(202479);
    if ((params == null) || (this.DBf == 0) || (this.DBg == 0))
    {
      AppMethodBeat.o(202479);
      return;
    }
    try
    {
      if (params.getItemCount() == 0)
      {
        Log.d("SnsAd.CardLayoutManager", "the item is 0, can't smooth scroll.");
        AppMethodBeat.o(202479);
        return;
      }
      Log.d("SnsAd.CardLayoutManager", "smoothScrollToPosition the position is ".concat(String.valueOf(paramInt)));
      paramRecyclerView.a(this.DBf * paramInt - this.DBe, 0, null);
      AppMethodBeat.o(202479);
      return;
    }
    catch (Throwable paramRecyclerView)
    {
      AppMethodBeat.o(202479);
    }
  }
  
  public static final class a
    implements Handler.Callback
  {
    public final Handler sCt;
    private final WeakReference<CardLayoutManager> vjn;
    
    a(Context paramContext, CardLayoutManager paramCardLayoutManager)
    {
      AppMethodBeat.i(202458);
      this.sCt = new Handler(paramContext.getMainLooper(), this);
      this.vjn = new WeakReference(paramCardLayoutManager);
      AppMethodBeat.o(202458);
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(202460);
      if (this.sCt != null) {
        this.sCt.removeMessages(0);
      }
      AppMethodBeat.o(202460);
    }
    
    final void eYI()
    {
      AppMethodBeat.i(202459);
      if (this.sCt != null)
      {
        cancel();
        this.sCt.sendEmptyMessageDelayed(0, 3000L);
      }
      AppMethodBeat.o(202459);
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(202461);
      if (paramMessage == null)
      {
        AppMethodBeat.o(202461);
        return false;
      }
      if (paramMessage.what == 0) {
        try
        {
          if (this.vjn != null)
          {
            paramMessage = (CardLayoutManager)this.vjn.get();
            if (paramMessage != null)
            {
              if ((paramMessage.DBt) && (paramMessage.mRecyclerView != null) && (paramMessage.mRecyclerView.isAttachedToWindow()))
              {
                int i = paramMessage.DBk;
                paramMessage.DBv = 1;
                paramMessage = paramMessage.mRecyclerView;
                com.tencent.mm.hellhoundlib.b.a locala = c.a(i + 1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(paramMessage, locala.axQ(), "com/tencent/mm/plugin/sns/ad/widget/recyclerview/CardLayoutManager", "smoothScrollToNextItem", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                paramMessage.smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(paramMessage, "com/tencent/mm/plugin/sns/ad/widget/recyclerview/CardLayoutManager", "smoothScrollToNextItem", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
              }
              AppMethodBeat.o(202461);
              return true;
            }
          }
          AppMethodBeat.o(202461);
          return false;
        }
        catch (Throwable paramMessage) {}
      }
      AppMethodBeat.o(202461);
      return false;
    }
  }
  
  final class b
    extends RecyclerView.j
  {
    b() {}
    
    public final boolean av(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202462);
      for (;;)
      {
        try
        {
          Log.d("SnsAd.CardLayoutManager", "on fling called velocityX = ".concat(String.valueOf(paramInt1)));
          if (paramInt1 <= CardLayoutManager.c(CardLayoutManager.this)) {
            continue;
          }
          CardLayoutManager.this.DBp = 2;
          if (CardLayoutManager.this.DBp != 0) {
            CardLayoutManager.this.DBn = true;
          }
          CardLayoutManager.d(CardLayoutManager.this);
        }
        catch (Throwable localThrowable)
        {
          continue;
        }
        AppMethodBeat.o(202462);
        return true;
        if (paramInt1 < -CardLayoutManager.c(CardLayoutManager.this)) {
          CardLayoutManager.this.DBp = 1;
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(CardLayoutManager paramCardLayoutManager, int paramInt);
    
    public abstract void a(CardLayoutManager paramCardLayoutManager, int paramInt1, int paramInt2);
  }
  
  public static abstract class d
  {
    protected int DBA;
    protected int DBx;
    protected int DBy;
    CardLayoutManager DBz;
    
    public final void Ye(int paramInt)
    {
      this.DBA = paramInt;
    }
    
    public boolean Yf(int paramInt)
    {
      return false;
    }
    
    public abstract void a(int paramInt1, float paramFloat, View paramView, int paramInt2, int paramInt3);
    
    public void fe(View paramView) {}
    
    public final void iq(int paramInt1, int paramInt2)
    {
      this.DBx = paramInt1;
      this.DBy = paramInt2;
    }
  }
  
  final class e
  {
    SparseBooleanArray DBB;
    List<Integer> DBC;
    
    e()
    {
      AppMethodBeat.i(202463);
      this.DBB = new SparseBooleanArray();
      this.DBC = new LinkedList();
      AppMethodBeat.o(202463);
    }
    
    final void Yg(int paramInt)
    {
      AppMethodBeat.i(202464);
      SparseBooleanArray localSparseBooleanArray = this.DBB;
      if (localSparseBooleanArray != null) {
        localSparseBooleanArray.append(paramInt, true);
      }
      AppMethodBeat.o(202464);
    }
  }
  
  public static final class f
  {
    int height;
    int width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager
 * JD-Core Version:    0.7.0.1
 */