package com.tencent.toybrick.b;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;
import com.tencent.toybrick.c.f;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.d.a.a;
import com.tencent.toybrick.e.b.1;
import com.tencent.toybrick.e.c.b;
import com.tencent.toybrick.f.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends RecyclerView.a<a>
  implements View.OnClickListener
{
  public ArrayList<g> BwS;
  public LinkedList<g> BwT;
  public HashMap<g, Integer> BwU;
  private SparseArray<g> BwV;
  private com.tencent.toybrick.e.b BwW;
  public a.a BwX;
  private Context mContext;
  
  public b(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(113182);
    a(new b.a(this, (byte)0));
    this.mContext = paramContext;
    this.BwX = parama;
    paramContext = parama.BxU;
    parama = paramContext.iterator();
    int i = 0;
    while (parama.hasNext())
    {
      ((g)parama.next()).bdv = i;
      i += 1;
    }
    this.BwT = paramContext;
    this.BwV = new SparseArray();
    this.BwU = new HashMap();
    this.BwS = new ArrayList();
    this.BwW = new com.tencent.toybrick.e.b(this);
    paramContext = this.BwW;
    paramContext.mMainHandler.removeCallbacks(paramContext.Byc);
    parama = paramContext.mMainHandler;
    b.1 local1 = new b.1(paramContext);
    paramContext.Byc = local1;
    parama.post(local1);
    AppMethodBeat.o(113182);
  }
  
  private a Tj(int paramInt)
  {
    AppMethodBeat.i(113184);
    long l = System.currentTimeMillis();
    try
    {
      Object localObject1 = LayoutInflater.from(this.mContext).inflate(paramInt, null);
      ((View)localObject1).setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      ((View)localObject1).setOnClickListener(this);
      localObject1 = ((g)this.BwV.get(paramInt)).fF((View)localObject1);
      return localObject1;
    }
    finally
    {
      ak.d("VerticalToyAdapter", "[onCreateViewHolder] cost:%sms toyBrick:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), ((g)this.BwV.get(paramInt)).BxG });
      AppMethodBeat.o(113184);
    }
  }
  
  public final g Tk(int paramInt)
  {
    AppMethodBeat.i(113187);
    if (this.BwS.size() > paramInt)
    {
      g localg = (g)this.BwS.get(paramInt);
      AppMethodBeat.o(113187);
      return localg;
    }
    AppMethodBeat.o(113187);
    return null;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(113185);
    int i = this.BwS.size();
    AppMethodBeat.o(113185);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(113183);
    g localg = Tk(paramInt);
    paramInt = localg.getLayoutResource();
    this.BwV.put(paramInt, localg);
    AppMethodBeat.o(113183);
    return paramInt;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113186);
    Tk(((a)paramView.getTag()).jN());
    AppMethodBeat.o(113186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.toybrick.b.b
 * JD-Core Version:    0.7.0.1
 */