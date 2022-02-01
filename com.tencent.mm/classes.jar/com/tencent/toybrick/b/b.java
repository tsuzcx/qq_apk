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
import com.tencent.mm.ui.ap;
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
  public ArrayList<g> MFf;
  public LinkedList<g> MFg;
  public HashMap<g, Integer> MFh;
  private SparseArray<g> MFi;
  private com.tencent.toybrick.e.b MFj;
  public a.a MFk;
  private Context mContext;
  
  public b(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(159919);
    a(new a((byte)0));
    this.mContext = paramContext;
    this.MFk = parama;
    paramContext = parama.MGg;
    parama = paramContext.iterator();
    int i = 0;
    while (parama.hasNext())
    {
      ((g)parama.next()).bJr = i;
      i += 1;
    }
    this.MFg = paramContext;
    this.MFi = new SparseArray();
    this.MFh = new HashMap();
    this.MFf = new ArrayList();
    this.MFj = new com.tencent.toybrick.e.b(this);
    paramContext = this.MFj;
    paramContext.mMainHandler.removeCallbacks(paramContext.MGo);
    parama = paramContext.mMainHandler;
    b.1 local1 = new b.1(paramContext);
    paramContext.MGo = local1;
    parama.post(local1);
    AppMethodBeat.o(159919);
  }
  
  private com.tencent.toybrick.f.a aiV(int paramInt)
  {
    AppMethodBeat.i(159921);
    long l = System.currentTimeMillis();
    try
    {
      Object localObject1 = LayoutInflater.from(this.mContext).inflate(paramInt, null);
      ((View)localObject1).setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      ((View)localObject1).setOnClickListener(this);
      localObject1 = ((g)this.MFi.get(paramInt)).hu((View)localObject1);
      return localObject1;
    }
    finally
    {
      ap.d("VerticalToyAdapter", "[onCreateViewHolder] cost:%sms toyBrick:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), ((g)this.MFi.get(paramInt)).MFS });
      AppMethodBeat.o(159921);
    }
  }
  
  public final g aiW(int paramInt)
  {
    AppMethodBeat.i(159924);
    if (this.MFf.size() > paramInt)
    {
      g localg = (g)this.MFf.get(paramInt);
      AppMethodBeat.o(159924);
      return localg;
    }
    AppMethodBeat.o(159924);
    return null;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(159922);
    int i = this.MFf.size();
    AppMethodBeat.o(159922);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(159920);
    g localg = aiW(paramInt);
    paramInt = localg.getLayoutResource();
    this.MFi.put(paramInt, localg);
    AppMethodBeat.o(159920);
    return paramInt;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(159923);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/toybrick/adapter/VerticalToyAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    aiW(((com.tencent.toybrick.f.a)paramView.getTag()).lN());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/toybrick/adapter/VerticalToyAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(159923);
  }
  
  final class a
    extends RecyclerView.c
  {
    private a() {}
    
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(159918);
      super.at(paramInt1, paramInt2);
      ap.d("NotifyObserver", "[onItemRangeChanged] positionStart:%d, itemCount:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      g localg = b.this.aiW(paramInt1);
      if ((localg != null) && (localg.MFT != null)) {
        c.execute(new c.d(c.MGx, localg, localg.MFT, new c.b() {}));
      }
      AppMethodBeat.o(159918);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.toybrick.b.b
 * JD-Core Version:    0.7.0.1
 */