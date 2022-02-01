package com.tencent.mm.plugin.transvoice.ui.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends RecyclerView.a<b>
{
  public int BEk;
  private ImageView BEl;
  public List<a> fSq;
  
  public a()
  {
    AppMethodBeat.i(185311);
    this.fSq = new ArrayList();
    this.BEk = -1;
    this.BEl = null;
    AppMethodBeat.o(185311);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(185312);
    int i = this.fSq.size();
    AppMethodBeat.o(185312);
    return i;
  }
  
  public final void gs(List<a> paramList)
  {
    AppMethodBeat.i(185313);
    this.fSq.clear();
    this.fSq.addAll(paramList);
    AppMethodBeat.o(185313);
  }
  
  public static final class a
  {
    public String BEo = "";
    public int BEp = -1;
    
    public a(String paramString, int paramInt)
    {
      this.BEo = paramString;
      this.BEp = paramInt;
    }
  }
  
  final class b
    extends RecyclerView.w
  {
    public ImageView fUN;
    public TextView titleTv;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(185310);
      this.titleTv = null;
      this.fUN = null;
      this.titleTv = ((TextView)paramView.findViewById(2131302831));
      this.fUN = ((ImageView)paramView.findViewById(2131302826));
      AppMethodBeat.o(185310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.a.a
 * JD-Core Version:    0.7.0.1
 */