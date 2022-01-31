package com.tencent.toybrick.b;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.ao;
import com.tencent.toybrick.c.f;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.d.a.a;
import com.tencent.toybrick.e.b.1;
import com.tencent.toybrick.f.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends RecyclerView.a<a>
  implements View.OnClickListener
{
  private Context mContext;
  public ArrayList<g> xam;
  public LinkedList<g> xan;
  public HashMap<g, Integer> xao;
  private SparseArray<g> xap;
  private com.tencent.toybrick.e.b xaq;
  public a.a xar;
  
  public b(Context paramContext, a.a parama)
  {
    a(new b.a(this, (byte)0));
    this.mContext = paramContext;
    this.xar = parama;
    paramContext = parama.xbo;
    parama = paramContext.iterator();
    int i = 0;
    while (parama.hasNext())
    {
      ((g)parama.next()).vdE = i;
      i += 1;
    }
    this.xan = paramContext;
    this.xap = new SparseArray();
    this.xao = new HashMap();
    this.xam = new ArrayList();
    this.xaq = new com.tencent.toybrick.e.b(this);
    paramContext = this.xaq;
    paramContext.mMainHandler.removeCallbacks(paramContext.xbw);
    parama = paramContext.mMainHandler;
    b.1 local1 = new b.1(paramContext);
    paramContext.xbw = local1;
    parama.post(local1);
  }
  
  private a Kp(int paramInt)
  {
    long l = System.currentTimeMillis();
    try
    {
      Object localObject1 = LayoutInflater.from(this.mContext).inflate(paramInt, null);
      ((View)localObject1).setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      ((View)localObject1).setOnClickListener(this);
      localObject1 = ((g)this.xap.get(paramInt)).er((View)localObject1);
      return localObject1;
    }
    finally
    {
      ao.s("[onCreateViewHolder] cost:%sms toyBrick:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), ((g)this.xap.get(paramInt)).xba });
    }
  }
  
  public final g Kq(int paramInt)
  {
    if (this.xam.size() > paramInt) {
      return (g)this.xam.get(paramInt);
    }
    return null;
  }
  
  public final int getItemCount()
  {
    return this.xam.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    g localg = Kq(paramInt);
    paramInt = localg.getLayoutResource();
    this.xap.put(paramInt, localg);
    return paramInt;
  }
  
  public final void onClick(View paramView)
  {
    Kq(((a)paramView.getTag()).id());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.toybrick.b.b
 * JD-Core Version:    0.7.0.1
 */