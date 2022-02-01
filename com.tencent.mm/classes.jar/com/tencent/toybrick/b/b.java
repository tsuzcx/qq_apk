package com.tencent.toybrick.b;

import android.content.Context;
import android.os.Handler;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.av;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.d.a.a;
import com.tencent.toybrick.e.b.1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends RecyclerView.a<com.tencent.toybrick.f.a>
  implements View.OnClickListener
{
  public ArrayList<g> ZPR;
  public LinkedList<g> ZPS;
  public HashMap<g, Integer> ZPT;
  private SparseArray<g> ZPU;
  private com.tencent.toybrick.e.b ZPV;
  public a.a ZPW;
  private Context mContext;
  
  public b(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(159919);
    a(new a((byte)0));
    this.mContext = paramContext;
    this.ZPW = parama;
    paramContext = parama.ZQa;
    parama = paramContext.iterator();
    if (parama.hasNext())
    {
      parama.next();
      AppMethodBeat.o(159919);
      throw null;
    }
    this.ZPS = paramContext;
    this.ZPU = new SparseArray();
    this.ZPT = new HashMap();
    this.ZPR = new ArrayList();
    this.ZPV = new com.tencent.toybrick.e.b(this);
    paramContext = this.ZPV;
    paramContext.mMainHandler.removeCallbacks(paramContext.ZQh);
    parama = paramContext.mMainHandler;
    b.1 local1 = new b.1(paramContext);
    paramContext.ZQh = local1;
    parama.post(local1);
    AppMethodBeat.o(159919);
  }
  
  private com.tencent.toybrick.f.a aCm(int paramInt)
  {
    AppMethodBeat.i(159921);
    long l = System.currentTimeMillis();
    try
    {
      View localView = LayoutInflater.from(this.mContext).inflate(paramInt, null);
      localView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      localView.setOnClickListener(this);
      this.ZPU.get(paramInt);
      AppMethodBeat.o(159921);
      throw null;
    }
    finally
    {
      new Object[2][0] = Long.valueOf(System.currentTimeMillis() - l);
      this.ZPU.get(paramInt);
      AppMethodBeat.o(159921);
    }
  }
  
  public final g aCn(int paramInt)
  {
    AppMethodBeat.i(159924);
    if (this.ZPR.size() > paramInt)
    {
      g localg = (g)this.ZPR.get(paramInt);
      AppMethodBeat.o(159924);
      return localg;
    }
    AppMethodBeat.o(159924);
    return null;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(159922);
    int i = this.ZPR.size();
    AppMethodBeat.o(159922);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(159920);
    aCn(paramInt);
    AppMethodBeat.o(159920);
    throw null;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(159923);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/toybrick/adapter/VerticalToyAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    aCn(((com.tencent.toybrick.f.a)paramView.getTag()).md());
    AppMethodBeat.o(159923);
    throw null;
  }
  
  final class a
    extends RecyclerView.c
  {
    private a() {}
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(159918);
      super.onItemRangeChanged(paramInt1, paramInt2);
      av.d("NotifyObserver", "[onItemRangeChanged] positionStart:%d, itemCount:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (b.this.aCn(paramInt1) != null)
      {
        AppMethodBeat.o(159918);
        throw null;
      }
      AppMethodBeat.o(159918);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.toybrick.b.b
 * JD-Core Version:    0.7.0.1
 */