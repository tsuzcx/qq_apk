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
import com.tencent.mm.ui.as;
import com.tencent.toybrick.c.f;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.d.a.a;
import com.tencent.toybrick.e.b.1;
import com.tencent.toybrick.e.c;
import com.tencent.toybrick.e.c.b;
import com.tencent.toybrick.e.c.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends RecyclerView.a<com.tencent.toybrick.f.a>
  implements View.OnClickListener
{
  public ArrayList<g> Sng;
  public LinkedList<g> Snh;
  public HashMap<g, Integer> Sni;
  private SparseArray<g> Snj;
  private com.tencent.toybrick.e.b Snk;
  public a.a Snl;
  private Context mContext;
  
  public b(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(159919);
    a(new a((byte)0));
    this.mContext = paramContext;
    this.Snl = parama;
    paramContext = parama.Soh;
    parama = paramContext.iterator();
    int i = 0;
    while (parama.hasNext())
    {
      ((g)parama.next()).bJH = i;
      i += 1;
    }
    this.Snh = paramContext;
    this.Snj = new SparseArray();
    this.Sni = new HashMap();
    this.Sng = new ArrayList();
    this.Snk = new com.tencent.toybrick.e.b(this);
    paramContext = this.Snk;
    paramContext.mMainHandler.removeCallbacks(paramContext.Soo);
    parama = paramContext.mMainHandler;
    b.1 local1 = new b.1(paramContext);
    paramContext.Soo = local1;
    parama.post(local1);
    AppMethodBeat.o(159919);
  }
  
  private com.tencent.toybrick.f.a asy(int paramInt)
  {
    AppMethodBeat.i(159921);
    long l = System.currentTimeMillis();
    try
    {
      Object localObject1 = LayoutInflater.from(this.mContext).inflate(paramInt, null);
      ((View)localObject1).setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      ((View)localObject1).setOnClickListener(this);
      localObject1 = ((g)this.Snj.get(paramInt)).hM((View)localObject1);
      return localObject1;
    }
    finally
    {
      as.d("VerticalToyAdapter", "[onCreateViewHolder] cost:%sms toyBrick:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), ((g)this.Snj.get(paramInt)).SnT });
      AppMethodBeat.o(159921);
    }
  }
  
  public final g asz(int paramInt)
  {
    AppMethodBeat.i(159924);
    if (this.Sng.size() > paramInt)
    {
      g localg = (g)this.Sng.get(paramInt);
      AppMethodBeat.o(159924);
      return localg;
    }
    AppMethodBeat.o(159924);
    return null;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(159922);
    int i = this.Sng.size();
    AppMethodBeat.o(159922);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(159920);
    g localg = asz(paramInt);
    paramInt = localg.getLayoutResource();
    this.Snj.put(paramInt, localg);
    AppMethodBeat.o(159920);
    return paramInt;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(159923);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/toybrick/adapter/VerticalToyAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    asz(((com.tencent.toybrick.f.a)paramView.getTag()).lR());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/toybrick/adapter/VerticalToyAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(159923);
  }
  
  final class a
    extends RecyclerView.c
  {
    private a() {}
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(159918);
      super.onItemRangeChanged(paramInt1, paramInt2);
      as.d("NotifyObserver", "[onItemRangeChanged] positionStart:%d, itemCount:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      g localg = b.this.asz(paramInt1);
      if ((localg != null) && (localg.SnU != null)) {
        c.execute(new c.d(c.Sox, localg, localg.SnU, new c.b() {}));
      }
      AppMethodBeat.o(159918);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.toybrick.b.b
 * JD-Core Version:    0.7.0.1
 */