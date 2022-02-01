package com.tencent.mm.plugin.sns.ad.widget.recyclerview;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.SparseBooleanArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.j;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
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
  int QhA;
  private d QhB;
  private final e QhC;
  public c QhD;
  boolean QhE;
  private boolean QhF;
  int QhG;
  int Qhp;
  int Qhq;
  int Qhr;
  int Qhs;
  int Qht;
  private int Qhu;
  int Qhv;
  private int Qhw;
  private float Qhx;
  boolean Qhy;
  a Qhz;
  final RecyclerView mRecyclerView;
  public int source;
  
  public CardLayoutManager(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(310192);
    this.Qhq = -1;
    this.Qhr = -1;
    this.Qhs = 3;
    this.Qhu = -2147483648;
    this.Qhv = -2147483648;
    this.Qhw = 0;
    this.Qhx = 0.0F;
    this.Qhy = true;
    this.QhA = 0;
    this.QhE = false;
    this.QhF = false;
    this.QhG = 0;
    this.QhC = new e();
    this.mRecyclerView = paramRecyclerView;
    if (this.mRecyclerView != null)
    {
      this.mRecyclerView.setOnFlingListener(new b());
      this.Qhz = new a(this.mRecyclerView.getContext(), this);
      Log.i("SnsAd.CardLayoutManager", "new CardLayoutManager, and recyclerView hashCode is " + this.mRecyclerView.hashCode());
      AppMethodBeat.o(310192);
      return;
    }
    Log.e("SnsAd.CardLayoutManager", "the layout manager will not work properly, because of null recycler view!!!");
    AppMethodBeat.o(310192);
  }
  
  private void akb(int paramInt)
  {
    if (this.Qhv != paramInt)
    {
      this.Qhu = this.Qhv;
      this.Qhv = paramInt;
      this.QhF = true;
    }
  }
  
  private int akc(int paramInt)
  {
    if (this.Qht == 0) {}
    do
    {
      return 0;
      if (paramInt >= 0) {
        return paramInt % this.Qht;
      }
    } while (paramInt % this.Qht == 0);
    int i = this.Qht;
    return i + paramInt % i;
  }
  
  private int akd(int paramInt)
  {
    AppMethodBeat.i(310242);
    int i = this.QhA;
    this.QhA = 0;
    if (i == 2)
    {
      AppMethodBeat.o(310242);
      return paramInt + 1;
    }
    if (i == 1)
    {
      AppMethodBeat.o(310242);
      return paramInt;
    }
    if (hdn() < 0.5F)
    {
      AppMethodBeat.o(310242);
      return paramInt;
    }
    AppMethodBeat.o(310242);
    return paramInt + 1;
  }
  
  private void ake(int paramInt)
  {
    AppMethodBeat.i(310246);
    int i = this.Qhq;
    this.mRecyclerView.br(i * paramInt - this.Qhp, 0);
    AppMethodBeat.o(310246);
  }
  
  private void c(RecyclerView.n paramn, int paramInt)
  {
    AppMethodBeat.i(310210);
    if ((this.Qht == 0) || (this.Qhq <= 0) || (this.Qhr <= 0) || (this.QhB == null))
    {
      AppMethodBeat.o(310210);
      return;
    }
    int j = hdl();
    int k = hdm();
    float f1 = hdn();
    float f2 = this.QhB.hdr();
    if ((this.Qhx > f2) && (f1 < f2) && (paramInt < 0)) {
      f1 = f2;
    }
    for (;;)
    {
      int i = j;
      while (i <= k)
      {
        int m = akc(i);
        if ((m >= 0) && (m < this.Qht))
        {
          View localView = paramn.gb(m);
          this.QhB.jp(localView);
          if ((localView != null) && (this.QhC != null))
          {
            addView(localView, 0);
            measureChildWithMargins(localView, 0, 0);
            this.QhB.a(this.Qhp, f1, localView, i - j, paramInt);
            this.QhC.akh(m);
          }
        }
        i += 1;
      }
      this.Qhx = f1;
      akb(j);
      AppMethodBeat.o(310210);
      return;
    }
  }
  
  private int hdl()
  {
    AppMethodBeat.i(310214);
    if ((this.Qhq <= 0) || (this.Qhr <= 0))
    {
      AppMethodBeat.o(310214);
      return 0;
    }
    int i = (int)Math.floor(this.Qhp * 1.0D / this.Qhq);
    AppMethodBeat.o(310214);
    return i;
  }
  
  private int hdm()
  {
    AppMethodBeat.i(310222);
    int i = hdl();
    int j = this.Qhs;
    AppMethodBeat.o(310222);
    return i + j;
  }
  
  private float hdn()
  {
    if ((this.Qhq <= 0) || (this.Qhr <= 0)) {}
    do
    {
      return 0.0F;
      if (this.Qhp >= 0) {
        return this.Qhp % this.Qhq * 1.0F / this.Qhq;
      }
    } while (this.Qhp % this.Qhq == 0);
    return this.Qhp % this.Qhq * 1.0F / this.Qhq + 1.0F;
  }
  
  private void hdo()
  {
    AppMethodBeat.i(310250);
    ake(akd(hdl()));
    AppMethodBeat.o(310250);
  }
  
  private void li(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(310204);
    Log.d("SnsAd.CardLayoutManager", "firstVirtualPosition is " + paramInt1 + ", lastVirtualPosition " + paramInt2 + ", should notify " + this.QhF);
    c localc = this.QhD;
    if ((this.QhF) && (localc != null) && (paramInt1 != -2147483648))
    {
      int i = akc(paramInt1);
      paramInt1 = -1;
      if (paramInt2 != -2147483648) {
        paramInt1 = akc(paramInt2);
      }
      localc.a(this, i, paramInt1);
    }
    this.QhF = false;
    AppMethodBeat.o(310204);
  }
  
  public final void a(d paramd)
  {
    this.QhB = paramd;
    if (this.QhB != null) {
      this.QhB.QhK = this;
    }
  }
  
  public final RecyclerView.v aka(int paramInt)
  {
    AppMethodBeat.i(310304);
    if (this.mRecyclerView == null)
    {
      AppMethodBeat.o(310304);
      return null;
    }
    try
    {
      int i = this.mRecyclerView.getChildCount() - 1;
      while (i >= 0)
      {
        Object localObject1 = this.mRecyclerView.getChildAt(i);
        if (RecyclerView.bA((View)localObject1) == paramInt)
        {
          localObject1 = this.mRecyclerView.bj((View)localObject1);
          return localObject1;
        }
        i -= 1;
      }
      return null;
    }
    finally
    {
      AppMethodBeat.o(310304);
    }
  }
  
  public boolean canScrollHorizontally()
  {
    return (this.Qhq > 0) && (this.Qhr > 0);
  }
  
  public final RecyclerView.a dSN()
  {
    AppMethodBeat.i(310294);
    try
    {
      if (this.mRecyclerView != null)
      {
        RecyclerView.a locala = this.mRecyclerView.getAdapter();
        return locala;
      }
    }
    finally
    {
      AppMethodBeat.o(310294);
    }
    return null;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(310310);
    RecyclerView.LayoutParams localLayoutParams = new RecyclerView.LayoutParams(-2, -2);
    AppMethodBeat.o(310310);
    return localLayoutParams;
  }
  
  public final void hdh()
  {
    AppMethodBeat.i(310274);
    try
    {
      if (this.Qhz != null) {
        this.Qhz.hdp();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310274);
    }
  }
  
  public final void hdi()
  {
    AppMethodBeat.i(310278);
    try
    {
      if ((this.Qhz != null) && (3000L > 0L)) {
        this.Qhz.hdq();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310278);
    }
  }
  
  public final void hdj()
  {
    AppMethodBeat.i(310287);
    try
    {
      if (this.Qhz != null) {
        this.Qhz.cancel();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310287);
    }
  }
  
  public final int hdk()
  {
    AppMethodBeat.i(310299);
    try
    {
      if (this.QhE)
      {
        int i = akc(this.Qhv);
        return i;
      }
    }
    finally
    {
      AppMethodBeat.o(310299);
    }
    return -1;
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.n paramn)
  {
    AppMethodBeat.i(310332);
    super.onDetachedFromWindow(paramRecyclerView, paramn);
    if (this.source == 0)
    {
      this.Qhp = 0;
      this.Qhv = -2147483648;
    }
    AppMethodBeat.o(310332);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(310337);
    this.QhE = false;
    if ((params == null) || (paramn == null))
    {
      Log.e("SnsAd.CardLayoutManager", "the state or recycler is null!!! Right?");
      AppMethodBeat.o(310337);
      return;
    }
    try
    {
      this.Qht = params.getItemCount();
      if ((this.Qht == 0) || (params.caw))
      {
        Log.d("SnsAd.CardLayoutManager", "there is no item or is pre layout remove all cached view!!");
        removeAndRecycleAllViews(paramn);
        return;
      }
      if ((this.Qhq == -1) || (this.Qhr == -1))
      {
        params = this.QhB;
        if (params != null)
        {
          View localView = paramn.gb(0);
          params.jp(localView);
          addView(localView);
          measureChildWithMargins(localView, 0, 0);
          this.Qhq = getDecoratedMeasuredWidth(localView);
          this.Qhr = getDecoratedMeasuredHeight(localView);
          params.akf(this.Qhs);
          params.lj(this.Qhq, this.Qhr);
        }
      }
      detachAndScrapAttachedViews(paramn);
      c(paramn, 0);
      return;
    }
    finally
    {
      AppMethodBeat.o(310337);
    }
  }
  
  public void onLayoutCompleted(RecyclerView.s params)
  {
    AppMethodBeat.i(310346);
    try
    {
      super.onLayoutCompleted(params);
      if (!this.QhE) {
        li(this.Qhv, this.Qhu);
      }
      this.QhE = true;
      return;
    }
    finally
    {
      AppMethodBeat.o(310346);
    }
  }
  
  public void onMeasure(RecyclerView.n paramn, RecyclerView.s params, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(310326);
    try
    {
      d locald = this.QhB;
      if ((locald == null) || (!locald.akg(paramInt1))) {
        super.onMeasure(paramn, params, paramInt1, paramInt2);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310326);
    }
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(310320);
    try
    {
      super.onScrollStateChanged(paramInt);
      Log.d("SnsAd.CardLayoutManager", "the onScrollStateChanged is called, state = ".concat(String.valueOf(paramInt)));
      if (this.QhD != null) {
        this.QhD.a(this, paramInt);
      }
      if (paramInt == 0)
      {
        Log.d("SnsAd.CardLayoutManager", "the onScrollStateChanged is called, mScrollFixed = " + this.Qhy);
        if (!this.Qhy)
        {
          hdo();
          this.Qhy = true;
          AppMethodBeat.o(310320);
          return;
        }
        li(this.Qhv, this.Qhu);
      }
    }
    finally
    {
      AppMethodBeat.o(310320);
      return;
    }
    if (paramInt == 1)
    {
      this.Qhy = false;
      d locald = this.QhB;
      if ((this.QhG == 1) && (locald != null) && (hdn() > locald.hdr()))
      {
        this.QhF = true;
        this.QhG = 0;
      }
    }
    AppMethodBeat.o(310320);
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(310362);
    for (;;)
    {
      int i;
      try
      {
        params = this.QhC.QhM;
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
        this.Qhp += paramInt;
        detachAndScrapAttachedViews(paramn);
        c(paramn, paramInt);
        Object localObject1 = this.QhC;
        params = ((e)localObject1).QhM;
        Object localObject2 = ((e)localObject1).QhN;
        if (params != null)
        {
          i = params.size();
          if ((i != 0) && (localObject2 != null)) {}
        }
        else
        {
          AppMethodBeat.o(310362);
          return paramInt;
        }
        ((List)localObject2).clear();
        i = 0;
        if (i < params.size())
        {
          int j = params.keyAt(i);
          boolean bool = params.get(j);
          if ((j < 0) || (j >= ((e)localObject1).QhH.Qht) || (bool)) {
            break label309;
          }
          View localView = paramn.gb(j);
          Log.d("SnsAd.CardLayoutManager", "pos is " + j + ", recycle view " + localView);
          ((e)localObject1).QhH.removeAndRecycleView(localView, paramn);
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
      finally
      {
        AppMethodBeat.o(310362);
        return 0;
      }
      continue;
      label309:
      i += 1;
    }
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(310373);
    if ((params == null) || (this.Qhq == 0) || (this.Qhr == 0))
    {
      AppMethodBeat.o(310373);
      return;
    }
    try
    {
      if (params.getItemCount() == 0)
      {
        Log.d("SnsAd.CardLayoutManager", "the item is 0, can't smooth scroll.");
        return;
      }
      Log.d("SnsAd.CardLayoutManager", "smoothScrollToPosition the position is ".concat(String.valueOf(paramInt)));
      paramRecyclerView.br(this.Qhq * paramInt - this.Qhp, 0);
      return;
    }
    finally
    {
      AppMethodBeat.o(310373);
    }
  }
  
  static final class a
    implements Handler.Callback
  {
    private final WeakReference<CardLayoutManager> Dno;
    private final Handler mUiHandler;
    
    a(Context paramContext, CardLayoutManager paramCardLayoutManager)
    {
      AppMethodBeat.i(310182);
      this.mUiHandler = new Handler(paramContext.getMainLooper(), this);
      this.Dno = new WeakReference(paramCardLayoutManager);
      AppMethodBeat.o(310182);
    }
    
    final void cancel()
    {
      AppMethodBeat.i(310199);
      if (this.mUiHandler != null) {
        this.mUiHandler.removeMessages(0);
      }
      AppMethodBeat.o(310199);
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(310208);
      if (paramMessage == null)
      {
        AppMethodBeat.o(310208);
        return false;
      }
      if (paramMessage.what == 0) {
        try
        {
          if (this.Dno != null)
          {
            paramMessage = (CardLayoutManager)this.Dno.get();
            if (paramMessage != null)
            {
              Object localObject = paramMessage.QhD;
              if (localObject != null) {
                ((CardLayoutManager.c)localObject).ajJ((paramMessage.hdk() + 1) % paramMessage.getItemCount());
              }
              if ((paramMessage.QhE) && (paramMessage.mRecyclerView != null) && (paramMessage.mRecyclerView.isAttachedToWindow()))
              {
                int i = paramMessage.Qhv;
                paramMessage.QhG = 1;
                paramMessage = paramMessage.mRecyclerView;
                localObject = c.a(i + 1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.b(paramMessage, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/sns/ad/widget/recyclerview/CardLayoutManager", "smoothScrollToNextItem", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                paramMessage.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.c(paramMessage, "com/tencent/mm/plugin/sns/ad/widget/recyclerview/CardLayoutManager", "smoothScrollToNextItem", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
              }
              AppMethodBeat.o(310208);
              return true;
            }
          }
          AppMethodBeat.o(310208);
          return false;
        }
        finally {}
      }
      AppMethodBeat.o(310208);
      return false;
    }
    
    final void hdp()
    {
      AppMethodBeat.i(310188);
      if (this.mUiHandler != null)
      {
        cancel();
        this.mUiHandler.sendEmptyMessage(0);
      }
      AppMethodBeat.o(310188);
    }
    
    final void hdq()
    {
      AppMethodBeat.i(310195);
      if (this.mUiHandler != null)
      {
        cancel();
        this.mUiHandler.sendEmptyMessageDelayed(0, 3000L);
      }
      AppMethodBeat.o(310195);
    }
  }
  
  final class b
    extends RecyclerView.j
  {
    b() {}
    
    public final boolean bC(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(310185);
      for (;;)
      {
        try
        {
          Log.d("SnsAd.CardLayoutManager", "on fling called velocityX = ".concat(String.valueOf(paramInt1)));
          if (paramInt1 <= CardLayoutManager.c(CardLayoutManager.this)) {
            continue;
          }
          CardLayoutManager.this.QhA = 2;
          if (CardLayoutManager.this.QhA != 0) {
            CardLayoutManager.this.Qhy = true;
          }
          CardLayoutManager.d(CardLayoutManager.this);
        }
        finally
        {
          continue;
        }
        AppMethodBeat.o(310185);
        return true;
        if (paramInt1 < -CardLayoutManager.c(CardLayoutManager.this)) {
          CardLayoutManager.this.QhA = 1;
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(CardLayoutManager paramCardLayoutManager, int paramInt);
    
    public abstract void a(CardLayoutManager paramCardLayoutManager, int paramInt1, int paramInt2);
    
    public abstract void ajJ(int paramInt);
  }
  
  public static abstract class d
  {
    protected int QhI;
    protected int QhJ;
    CardLayoutManager QhK;
    protected int QhL;
    
    public abstract void a(int paramInt1, float paramFloat, View paramView, int paramInt2, int paramInt3);
    
    public final void akf(int paramInt)
    {
      this.QhL = paramInt;
    }
    
    public boolean akg(int paramInt)
    {
      return false;
    }
    
    public abstract float hdr();
    
    public void jp(View paramView) {}
    
    public final void lj(int paramInt1, int paramInt2)
    {
      this.QhI = paramInt1;
      this.QhJ = paramInt2;
    }
  }
  
  final class e
  {
    SparseBooleanArray QhM;
    List<Integer> QhN;
    
    e()
    {
      AppMethodBeat.i(310186);
      this.QhM = new SparseBooleanArray();
      this.QhN = new LinkedList();
      AppMethodBeat.o(310186);
    }
    
    final void akh(int paramInt)
    {
      AppMethodBeat.i(310194);
      SparseBooleanArray localSparseBooleanArray = this.QhM;
      if (localSparseBooleanArray != null) {
        localSparseBooleanArray.append(paramInt, true);
      }
      AppMethodBeat.o(310194);
    }
  }
  
  public static final class f
  {
    int height;
    int width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager
 * JD-Core Version:    0.7.0.1
 */