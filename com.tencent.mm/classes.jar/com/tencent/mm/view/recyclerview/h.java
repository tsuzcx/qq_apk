package com.tencent.mm.view.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashSet;

public class h
  extends RecyclerView.v
{
  private final LinkedHashSet<Integer> RqY;
  private final LinkedHashSet<Integer> RqZ;
  public Object Rra;
  private final Context context;
  public RecyclerView hak;
  private RecyclerView.a hbg;
  private Object tag;
  
  public h(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(164329);
    this.hak = null;
    this.RqY = new LinkedHashSet();
    this.RqZ = new LinkedHashSet();
    this.context = paramView.getContext();
    AppMethodBeat.o(164329);
  }
  
  public final <T extends View> T Mn(int paramInt)
  {
    AppMethodBeat.i(164335);
    View localView = this.aus.findViewById(paramInt);
    AppMethodBeat.o(164335);
    return localView;
  }
  
  public final h aqe(int paramInt)
  {
    AppMethodBeat.i(164332);
    ((TextView)Mn(2131298942)).setText(paramInt);
    AppMethodBeat.o(164332);
    return this;
  }
  
  public final h b(RecyclerView.a parama)
  {
    this.hbg = parama;
    return this;
  }
  
  public final h e(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(164331);
    ((TextView)Mn(paramInt)).setText(paramCharSequence);
    AppMethodBeat.o(164331);
    return this;
  }
  
  public final void et(Object paramObject)
  {
    this.Rra = paramObject;
  }
  
  public final RecyclerView.a getAdapter()
  {
    return this.hbg;
  }
  
  public final Context getContext()
  {
    return this.context;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(164330);
    if ((this.hak == null) && ((this.aus.getParent() instanceof RecyclerView)))
    {
      this.hak = ((RecyclerView)this.aus.getParent());
      localRecyclerView = this.hak;
      AppMethodBeat.o(164330);
      return localRecyclerView;
    }
    RecyclerView localRecyclerView = this.hak;
    AppMethodBeat.o(164330);
    return localRecyclerView;
  }
  
  public final Object getTag()
  {
    return this.tag;
  }
  
  public final <T> T hgv()
  {
    return this.Rra;
  }
  
  public final h me(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206185);
    ((TextView)Mn(paramInt1)).setTextColor(paramInt2);
    AppMethodBeat.o(206185);
    return this;
  }
  
  public final h mf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164334);
    Mn(paramInt1).setVisibility(paramInt2);
    AppMethodBeat.o(164334);
    return this;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    this.hak = paramRecyclerView;
  }
  
  public final void setTag(Object paramObject)
  {
    this.tag = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.h
 * JD-Core Version:    0.7.0.1
 */