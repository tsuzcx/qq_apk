package com.tencent.mm.view.recyclerview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashSet;

public class i
  extends RecyclerView.v
{
  private final LinkedHashSet<Integer> YSx;
  private final LinkedHashSet<Integer> YSy;
  public Object YSz;
  private final Context context;
  public RecyclerView jLl;
  private RecyclerView.a jMq;
  private Object tag;
  
  public i(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(164329);
    this.jLl = null;
    this.YSx = new LinkedHashSet();
    this.YSy = new LinkedHashSet();
    this.context = paramView.getContext();
    AppMethodBeat.o(164329);
  }
  
  public final <T extends View> T RD(int paramInt)
  {
    AppMethodBeat.i(164335);
    View localView = this.amk.findViewById(paramInt);
    AppMethodBeat.o(164335);
    return localView;
  }
  
  public final i b(int paramInt, Drawable paramDrawable)
  {
    AppMethodBeat.i(221728);
    ((ImageView)RD(paramInt)).setImageDrawable(paramDrawable);
    AppMethodBeat.o(221728);
    return this;
  }
  
  public final i b(RecyclerView.a parama)
  {
    this.jMq = parama;
    return this;
  }
  
  public final i e(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(164331);
    ((TextView)RD(paramInt)).setText(paramCharSequence);
    AppMethodBeat.o(164331);
    return this;
  }
  
  public final void ez(Object paramObject)
  {
    this.YSz = paramObject;
  }
  
  public final RecyclerView.a getAdapter()
  {
    return this.jMq;
  }
  
  public final Context getContext()
  {
    return this.context;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(221719);
    if ((this.jLl == null) && ((this.amk.getParent() instanceof RecyclerView)))
    {
      this.jLl = ((RecyclerView)this.amk.getParent());
      localRecyclerView = this.jLl;
      AppMethodBeat.o(221719);
      return localRecyclerView;
    }
    RecyclerView localRecyclerView = this.jLl;
    AppMethodBeat.o(221719);
    return localRecyclerView;
  }
  
  public final Object getTag()
  {
    return this.tag;
  }
  
  public final <T> T ihX()
  {
    return this.YSz;
  }
  
  public final i nv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221725);
    ((TextView)RD(paramInt1)).setText(paramInt2);
    AppMethodBeat.o(221725);
    return this;
  }
  
  public final i nw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221726);
    ((TextView)RD(paramInt1)).setTextColor(paramInt2);
    AppMethodBeat.o(221726);
    return this;
  }
  
  public final i nx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164334);
    RD(paramInt1).setVisibility(paramInt2);
    AppMethodBeat.o(164334);
    return this;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    this.jLl = paramRecyclerView;
  }
  
  public final void setTag(Object paramObject)
  {
    this.tag = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.i
 * JD-Core Version:    0.7.0.1
 */