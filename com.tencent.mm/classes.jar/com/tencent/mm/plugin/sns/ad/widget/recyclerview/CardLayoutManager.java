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
  int JMP;
  int JMQ;
  int JMR;
  int JMS;
  int JMT;
  private int JMU;
  int JMV;
  private int JMW;
  private float JMX;
  boolean JMY;
  a JMZ;
  int JNa;
  private CardLayoutManager.d JNb;
  private final e JNc;
  public c JNd;
  boolean JNe;
  private boolean JNf;
  int JNg;
  final RecyclerView mRecyclerView;
  public int source;
  
  public CardLayoutManager(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(194255);
    this.JMQ = -1;
    this.JMR = -1;
    this.JMS = 3;
    this.JMU = -2147483648;
    this.JMV = -2147483648;
    this.JMW = 0;
    this.JMX = 0.0F;
    this.JMY = true;
    this.JNa = 0;
    this.JNe = false;
    this.JNf = false;
    this.JNg = 0;
    this.JNc = new e();
    this.mRecyclerView = paramRecyclerView;
    if (this.mRecyclerView != null)
    {
      this.mRecyclerView.setOnFlingListener(new b());
      this.JMZ = new a(this.mRecyclerView.getContext(), this);
      Log.i("SnsAd.CardLayoutManager", "new CardLayoutManager, and recyclerView hashCode is " + this.mRecyclerView.hashCode());
      AppMethodBeat.o(194255);
      return;
    }
    Log.e("SnsAd.CardLayoutManager", "the layout manager will not work properly, because of null recycler view!!!");
    AppMethodBeat.o(194255);
  }
  
  private void afp(int paramInt)
  {
    if (this.JMV != paramInt)
    {
      this.JMU = this.JMV;
      this.JMV = paramInt;
      this.JNf = true;
    }
  }
  
  private int afq(int paramInt)
  {
    if (this.JMT == 0) {}
    do
    {
      return 0;
      if (paramInt >= 0) {
        return paramInt % this.JMT;
      }
    } while (paramInt % this.JMT == 0);
    int i = this.JMT;
    return i + paramInt % i;
  }
  
  private int afr(int paramInt)
  {
    AppMethodBeat.i(194303);
    int i = this.JNa;
    this.JNa = 0;
    if (i == 2)
    {
      AppMethodBeat.o(194303);
      return paramInt + 1;
    }
    if (i == 1)
    {
      AppMethodBeat.o(194303);
      return paramInt;
    }
    if (fMr() < 0.5F)
    {
      AppMethodBeat.o(194303);
      return paramInt;
    }
    AppMethodBeat.o(194303);
    return paramInt + 1;
  }
  
  private void afs(int paramInt)
  {
    AppMethodBeat.i(194304);
    int i = this.JMQ;
    this.mRecyclerView.a(i * paramInt - this.JMP, 0, null);
    AppMethodBeat.o(194304);
  }
  
  private void c(RecyclerView.n paramn, int paramInt)
  {
    float f1 = 0.5F;
    AppMethodBeat.i(194293);
    if ((this.JMT == 0) || (this.JMQ <= 0) || (this.JMR <= 0) || (this.JNb == null))
    {
      AppMethodBeat.o(194293);
      return;
    }
    int j = fMp();
    int k = fMq();
    float f2 = fMr();
    if ((this.JMX > 0.5F) && (f2 < 0.5F) && (paramInt < 0)) {}
    for (;;)
    {
      int i = j;
      while (i <= k)
      {
        int m = afq(i);
        if ((m >= 0) && (m < this.JMT))
        {
          View localView = paramn.cR(m);
          this.JNb.gl(localView);
          if ((localView != null) && (this.JNc != null))
          {
            addView(localView, 0);
            measureChildWithMargins(localView, 0, 0);
            this.JNb.a(this.JMP, f1, localView, i - j, paramInt);
            this.JNc.afv(m);
          }
        }
        i += 1;
      }
      this.JMX = f1;
      afp(j);
      AppMethodBeat.o(194293);
      return;
      f1 = f2;
    }
  }
  
  private int fMp()
  {
    AppMethodBeat.i(194296);
    if ((this.JMQ <= 0) || (this.JMR <= 0))
    {
      AppMethodBeat.o(194296);
      return 0;
    }
    int i = (int)Math.floor(this.JMP * 1.0D / this.JMQ);
    AppMethodBeat.o(194296);
    return i;
  }
  
  private int fMq()
  {
    AppMethodBeat.i(194297);
    int i = fMp();
    int j = this.JMS;
    AppMethodBeat.o(194297);
    return i + j;
  }
  
  private float fMr()
  {
    if ((this.JMQ <= 0) || (this.JMR <= 0)) {}
    do
    {
      return 0.0F;
      if (this.JMP >= 0) {
        return this.JMP % this.JMQ * 1.0F / this.JMQ;
      }
    } while (this.JMP % this.JMQ == 0);
    return this.JMP % this.JMQ * 1.0F / this.JMQ + 1.0F;
  }
  
  private void fMs()
  {
    AppMethodBeat.i(194306);
    afs(afr(fMp()));
    AppMethodBeat.o(194306);
  }
  
  private void jy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194270);
    Log.d("SnsAd.CardLayoutManager", "firstVirtualPosition is " + paramInt1 + ", lastVirtualPosition " + paramInt2 + ", should notify " + this.JNf);
    c localc = this.JNd;
    if ((this.JNf) && (localc != null) && (paramInt1 != -2147483648))
    {
      int i = afq(paramInt1);
      paramInt1 = -1;
      if (paramInt2 != -2147483648) {
        paramInt1 = afq(paramInt2);
      }
      localc.a(this, i, paramInt1);
    }
    this.JNf = false;
    AppMethodBeat.o(194270);
  }
  
  public final void a(CardLayoutManager.d paramd)
  {
    this.JNb = paramd;
    if (this.JNb != null) {
      this.JNb.JNk = this;
    }
  }
  
  public final RecyclerView.v afo(int paramInt)
  {
    AppMethodBeat.i(194265);
    if (this.mRecyclerView == null)
    {
      AppMethodBeat.o(194265);
      return null;
    }
    try
    {
      int i = this.mRecyclerView.getChildCount() - 1;
      while (i >= 0)
      {
        Object localObject = this.mRecyclerView.getChildAt(i);
        if (RecyclerView.bh((View)localObject) == paramInt)
        {
          localObject = this.mRecyclerView.aQ((View)localObject);
          AppMethodBeat.o(194265);
          return localObject;
        }
        i -= 1;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(194265);
    }
  }
  
  public boolean canScrollHorizontally()
  {
    return (this.JMQ > 0) && (this.JMR > 0);
  }
  
  public final RecyclerView.a dlX()
  {
    AppMethodBeat.i(194260);
    try
    {
      if (this.mRecyclerView != null)
      {
        RecyclerView.a locala = this.mRecyclerView.getAdapter();
        AppMethodBeat.o(194260);
        return locala;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(194260);
    }
    return null;
  }
  
  public final void fMl()
  {
    AppMethodBeat.i(194257);
    try
    {
      if (this.JMZ != null) {
        this.JMZ.fMt();
      }
      AppMethodBeat.o(194257);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(194257);
    }
  }
  
  public final void fMm()
  {
    AppMethodBeat.i(194258);
    try
    {
      if ((this.JMZ != null) && (3000L > 0L)) {
        this.JMZ.fMu();
      }
      AppMethodBeat.o(194258);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(194258);
    }
  }
  
  public final void fMn()
  {
    AppMethodBeat.i(194259);
    try
    {
      if (this.JMZ != null) {
        this.JMZ.cancel();
      }
      AppMethodBeat.o(194259);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(194259);
    }
  }
  
  public final int fMo()
  {
    AppMethodBeat.i(194263);
    try
    {
      if (this.JNe)
      {
        int i = afq(this.JMV);
        AppMethodBeat.o(194263);
        return i;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(194263);
    }
    return -1;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(194266);
    RecyclerView.LayoutParams localLayoutParams = new RecyclerView.LayoutParams(-2, -2);
    AppMethodBeat.o(194266);
    return localLayoutParams;
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.n paramn)
  {
    AppMethodBeat.i(194273);
    super.onDetachedFromWindow(paramRecyclerView, paramn);
    if (this.source == 0)
    {
      this.JMP = 0;
      this.JMV = -2147483648;
    }
    AppMethodBeat.o(194273);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(194278);
    this.JNe = false;
    if ((params == null) || (paramn == null))
    {
      Log.e("SnsAd.CardLayoutManager", "the state or recycler is null!!! Right?");
      AppMethodBeat.o(194278);
      return;
    }
    try
    {
      this.JMT = params.getItemCount();
      if ((this.JMT == 0) || (params.alW))
      {
        Log.d("SnsAd.CardLayoutManager", "there is no item or is pre layout remove all cached view!!");
        removeAndRecycleAllViews(paramn);
        AppMethodBeat.o(194278);
        return;
      }
      if ((this.JMQ == -1) || (this.JMR == -1))
      {
        params = this.JNb;
        if (params != null)
        {
          View localView = paramn.cR(0);
          params.gl(localView);
          addView(localView);
          measureChildWithMargins(localView, 0, 0);
          this.JMQ = getDecoratedMeasuredWidth(localView);
          this.JMR = getDecoratedMeasuredHeight(localView);
          params.aft(this.JMS);
          params.jz(this.JMQ, this.JMR);
        }
      }
      detachAndScrapAttachedViews(paramn);
      c(paramn, 0);
      AppMethodBeat.o(194278);
      return;
    }
    catch (Throwable paramn)
    {
      AppMethodBeat.o(194278);
    }
  }
  
  public void onLayoutCompleted(RecyclerView.s params)
  {
    AppMethodBeat.i(194281);
    try
    {
      super.onLayoutCompleted(params);
      if (!this.JNe) {
        jy(this.JMV, this.JMU);
      }
      this.JNe = true;
      AppMethodBeat.o(194281);
      return;
    }
    catch (Throwable params)
    {
      AppMethodBeat.o(194281);
    }
  }
  
  public void onMeasure(RecyclerView.n paramn, RecyclerView.s params, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194271);
    try
    {
      CardLayoutManager.d locald = this.JNb;
      if ((locald == null) || (!locald.afu(paramInt1))) {
        super.onMeasure(paramn, params, paramInt1, paramInt2);
      }
      AppMethodBeat.o(194271);
      return;
    }
    catch (Throwable paramn)
    {
      AppMethodBeat.o(194271);
    }
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(194269);
    try
    {
      super.onScrollStateChanged(paramInt);
      Log.d("SnsAd.CardLayoutManager", "the onScrollStateChanged is called, state = ".concat(String.valueOf(paramInt)));
      if (this.JNd != null) {
        this.JNd.a(this, paramInt);
      }
      if (paramInt == 0)
      {
        Log.d("SnsAd.CardLayoutManager", "the onScrollStateChanged is called, mScrollFixed = " + this.JMY);
        if (!this.JMY)
        {
          fMs();
          this.JMY = true;
          AppMethodBeat.o(194269);
          return;
        }
        jy(this.JMV, this.JMU);
        AppMethodBeat.o(194269);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(194269);
      return;
    }
    if (paramInt == 1)
    {
      this.JMY = false;
      CardLayoutManager.d locald = this.JNb;
      if ((this.JNg == 1) && (locald != null) && (fMr() > 0.5F))
      {
        this.JNf = true;
        this.JNg = 0;
      }
    }
    AppMethodBeat.o(194269);
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(194287);
    for (;;)
    {
      int i;
      try
      {
        params = this.JNc.JNm;
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
        this.JMP += paramInt;
        detachAndScrapAttachedViews(paramn);
        c(paramn, paramInt);
        Object localObject1 = this.JNc;
        params = ((e)localObject1).JNm;
        Object localObject2 = ((e)localObject1).JNn;
        if (params != null)
        {
          i = params.size();
          if ((i != 0) && (localObject2 != null)) {}
        }
        else
        {
          AppMethodBeat.o(194287);
          return paramInt;
        }
        ((List)localObject2).clear();
        i = 0;
        if (i < params.size())
        {
          int j = params.keyAt(i);
          boolean bool = params.get(j);
          if ((j < 0) || (j >= ((e)localObject1).JNh.JMT) || (bool)) {
            break label309;
          }
          View localView = paramn.cR(j);
          Log.d("SnsAd.CardLayoutManager", "pos is " + j + ", recycle view " + localView);
          ((e)localObject1).JNh.removeAndRecycleView(localView, paramn);
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
        AppMethodBeat.o(194287);
        return 0;
      }
      continue;
      label309:
      i += 1;
    }
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(194288);
    if ((params == null) || (this.JMQ == 0) || (this.JMR == 0))
    {
      AppMethodBeat.o(194288);
      return;
    }
    try
    {
      if (params.getItemCount() == 0)
      {
        Log.d("SnsAd.CardLayoutManager", "the item is 0, can't smooth scroll.");
        AppMethodBeat.o(194288);
        return;
      }
      Log.d("SnsAd.CardLayoutManager", "smoothScrollToPosition the position is ".concat(String.valueOf(paramInt)));
      paramRecyclerView.a(this.JMQ * paramInt - this.JMP, 0, null);
      AppMethodBeat.o(194288);
      return;
    }
    catch (Throwable paramRecyclerView)
    {
      AppMethodBeat.o(194288);
    }
  }
  
  static final class a
    implements Handler.Callback
  {
    private final Handler mUiHandler;
    private final WeakReference<CardLayoutManager> yAq;
    
    a(Context paramContext, CardLayoutManager paramCardLayoutManager)
    {
      AppMethodBeat.i(250399);
      this.mUiHandler = new Handler(paramContext.getMainLooper(), this);
      this.yAq = new WeakReference(paramCardLayoutManager);
      AppMethodBeat.o(250399);
    }
    
    final void cancel()
    {
      AppMethodBeat.i(250406);
      if (this.mUiHandler != null) {
        this.mUiHandler.removeMessages(0);
      }
      AppMethodBeat.o(250406);
    }
    
    final void fMt()
    {
      AppMethodBeat.i(250402);
      if (this.mUiHandler != null)
      {
        cancel();
        this.mUiHandler.sendEmptyMessage(0);
      }
      AppMethodBeat.o(250402);
    }
    
    final void fMu()
    {
      AppMethodBeat.i(250404);
      if (this.mUiHandler != null)
      {
        cancel();
        this.mUiHandler.sendEmptyMessageDelayed(0, 3000L);
      }
      AppMethodBeat.o(250404);
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(250409);
      if (paramMessage == null)
      {
        AppMethodBeat.o(250409);
        return false;
      }
      if (paramMessage.what == 0) {
        try
        {
          if (this.yAq != null)
          {
            paramMessage = (CardLayoutManager)this.yAq.get();
            if (paramMessage != null)
            {
              Object localObject = paramMessage.JNd;
              if (localObject != null) {
                ((CardLayoutManager.c)localObject).afa((paramMessage.fMo() + 1) % paramMessage.getItemCount());
              }
              if ((paramMessage.JNe) && (paramMessage.mRecyclerView != null) && (paramMessage.mRecyclerView.isAttachedToWindow()))
              {
                int i = paramMessage.JMV;
                paramMessage.JNg = 1;
                paramMessage = paramMessage.mRecyclerView;
                localObject = c.a(i + 1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.b(paramMessage, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/sns/ad/widget/recyclerview/CardLayoutManager", "smoothScrollToNextItem", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                paramMessage.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.c(paramMessage, "com/tencent/mm/plugin/sns/ad/widget/recyclerview/CardLayoutManager", "smoothScrollToNextItem", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
              }
              AppMethodBeat.o(250409);
              return true;
            }
          }
          AppMethodBeat.o(250409);
          return false;
        }
        catch (Throwable paramMessage) {}
      }
      AppMethodBeat.o(250409);
      return false;
    }
  }
  
  final class b
    extends RecyclerView.j
  {
    b() {}
    
    public final boolean aI(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(264521);
      for (;;)
      {
        try
        {
          Log.d("SnsAd.CardLayoutManager", "on fling called velocityX = ".concat(String.valueOf(paramInt1)));
          if (paramInt1 <= CardLayoutManager.c(CardLayoutManager.this)) {
            continue;
          }
          CardLayoutManager.this.JNa = 2;
          if (CardLayoutManager.this.JNa != 0) {
            CardLayoutManager.this.JMY = true;
          }
          CardLayoutManager.d(CardLayoutManager.this);
        }
        catch (Throwable localThrowable)
        {
          continue;
        }
        AppMethodBeat.o(264521);
        return true;
        if (paramInt1 < -CardLayoutManager.c(CardLayoutManager.this)) {
          CardLayoutManager.this.JNa = 1;
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(CardLayoutManager paramCardLayoutManager, int paramInt);
    
    public abstract void a(CardLayoutManager paramCardLayoutManager, int paramInt1, int paramInt2);
    
    public abstract void afa(int paramInt);
  }
  
  final class e
  {
    SparseBooleanArray JNm;
    List<Integer> JNn;
    
    e()
    {
      AppMethodBeat.i(227286);
      this.JNm = new SparseBooleanArray();
      this.JNn = new LinkedList();
      AppMethodBeat.o(227286);
    }
    
    final void afv(int paramInt)
    {
      AppMethodBeat.i(227289);
      SparseBooleanArray localSparseBooleanArray = this.JNm;
      if (localSparseBooleanArray != null) {
        localSparseBooleanArray.append(paramInt, true);
      }
      AppMethodBeat.o(227289);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager
 * JD-Core Version:    0.7.0.1
 */