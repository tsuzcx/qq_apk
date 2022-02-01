package com.tencent.mm.view.recyclerview;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashSet;

public class j
  extends RecyclerView.v
{
  public Object CSA;
  private final LinkedHashSet<Integer> agOj;
  private final LinkedHashSet<Integer> agOk;
  public final Context context;
  public RecyclerView mkw;
  public RecyclerView.a mlt;
  public Object tag;
  
  public j(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(164329);
    this.mkw = null;
    this.agOj = new LinkedHashSet();
    this.agOk = new LinkedHashSet();
    this.context = paramView.getContext();
    AppMethodBeat.o(164329);
  }
  
  public final <T extends View> T UH(int paramInt)
  {
    AppMethodBeat.i(164335);
    View localView = this.caK.findViewById(paramInt);
    AppMethodBeat.o(164335);
    return localView;
  }
  
  public final j d(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(164331);
    ((TextView)UH(paramInt)).setText(paramCharSequence);
    AppMethodBeat.o(164331);
    return this;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(234929);
    if ((this.mkw == null) && ((this.caK.getParent() instanceof RecyclerView)))
    {
      this.mkw = ((RecyclerView)this.caK.getParent());
      localRecyclerView = this.mkw;
      AppMethodBeat.o(234929);
      return localRecyclerView;
    }
    RecyclerView localRecyclerView = this.mkw;
    AppMethodBeat.o(234929);
    return localRecyclerView;
  }
  
  public final j pr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234940);
    ((TextView)UH(paramInt1)).setText(paramInt2);
    AppMethodBeat.o(234940);
    return this;
  }
  
  public final j ps(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234948);
    ((TextView)UH(paramInt1)).setTextColor(paramInt2);
    AppMethodBeat.o(234948);
    return this;
  }
  
  public final j pt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164334);
    UH(paramInt1).setVisibility(paramInt2);
    AppMethodBeat.o(164334);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.j
 * JD-Core Version:    0.7.0.1
 */