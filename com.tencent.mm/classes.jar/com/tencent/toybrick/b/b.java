package com.tencent.toybrick.b;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.an;
import com.tencent.toybrick.c.f;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.d.a.a;
import com.tencent.toybrick.e.b.1;
import com.tencent.toybrick.e.c;
import com.tencent.toybrick.e.c.b;
import com.tencent.toybrick.e.c.d;
import com.tencent.toybrick.f.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends RecyclerView.a<a>
  implements View.OnClickListener
{
  public ArrayList<g> Ksh;
  public LinkedList<g> Ksi;
  public HashMap<g, Integer> Ksj;
  private SparseArray<g> Ksk;
  private com.tencent.toybrick.e.b Ksl;
  public a.a Ksm;
  private Context mContext;
  
  public b(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(159919);
    a(new a((byte)0));
    this.mContext = paramContext;
    this.Ksm = parama;
    paramContext = parama.Kti;
    parama = paramContext.iterator();
    int i = 0;
    while (parama.hasNext())
    {
      ((g)parama.next()).bzd = i;
      i += 1;
    }
    this.Ksi = paramContext;
    this.Ksk = new SparseArray();
    this.Ksj = new HashMap();
    this.Ksh = new ArrayList();
    this.Ksl = new com.tencent.toybrick.e.b(this);
    paramContext = this.Ksl;
    paramContext.mMainHandler.removeCallbacks(paramContext.Ktq);
    parama = paramContext.mMainHandler;
    b.1 local1 = new b.1(paramContext);
    paramContext.Ktq = local1;
    parama.post(local1);
    AppMethodBeat.o(159919);
  }
  
  private a afM(int paramInt)
  {
    AppMethodBeat.i(159921);
    long l = System.currentTimeMillis();
    try
    {
      Object localObject1 = LayoutInflater.from(this.mContext).inflate(paramInt, null);
      ((View)localObject1).setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      ((View)localObject1).setOnClickListener(this);
      localObject1 = ((g)this.Ksk.get(paramInt)).gY((View)localObject1);
      return localObject1;
    }
    finally
    {
      an.d("VerticalToyAdapter", "[onCreateViewHolder] cost:%sms toyBrick:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), ((g)this.Ksk.get(paramInt)).KsU });
      AppMethodBeat.o(159921);
    }
  }
  
  public final g afN(int paramInt)
  {
    AppMethodBeat.i(159924);
    if (this.Ksh.size() > paramInt)
    {
      g localg = (g)this.Ksh.get(paramInt);
      AppMethodBeat.o(159924);
      return localg;
    }
    AppMethodBeat.o(159924);
    return null;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(159922);
    int i = this.Ksh.size();
    AppMethodBeat.o(159922);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(159920);
    g localg = afN(paramInt);
    paramInt = localg.getLayoutResource();
    this.Ksk.put(paramInt, localg);
    AppMethodBeat.o(159920);
    return paramInt;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(159923);
    afN(((a)paramView.getTag()).lv());
    AppMethodBeat.o(159923);
  }
  
  final class a
    extends RecyclerView.c
  {
    private a() {}
    
    public final void as(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(159918);
      super.as(paramInt1, paramInt2);
      an.d("NotifyObserver", "[onItemRangeChanged] positionStart:%d, itemCount:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      g localg = b.this.afN(paramInt1);
      if ((localg != null) && (localg.KsV != null)) {
        c.execute(new c.d(c.Ktz, localg, localg.KsV, new c.b() {}));
      }
      AppMethodBeat.o(159918);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.toybrick.b.b
 * JD-Core Version:    0.7.0.1
 */