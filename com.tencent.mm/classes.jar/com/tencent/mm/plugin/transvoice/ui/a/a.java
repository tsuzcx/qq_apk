package com.tencent.mm.plugin.transvoice.ui.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends RecyclerView.a<b>
{
  public List<a> fvw;
  public int yYJ;
  private ImageView yYK;
  
  public a()
  {
    AppMethodBeat.i(185311);
    this.fvw = new ArrayList();
    this.yYJ = -1;
    this.yYK = null;
    AppMethodBeat.o(185311);
  }
  
  public final void ga(List<a> paramList)
  {
    AppMethodBeat.i(185313);
    this.fvw.clear();
    this.fvw.addAll(paramList);
    AppMethodBeat.o(185313);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(185312);
    int i = this.fvw.size();
    AppMethodBeat.o(185312);
    return i;
  }
  
  public static final class a
  {
    public String yYN = "";
    public int yYO = -1;
    
    public a(String paramString, int paramInt)
    {
      this.yYN = paramString;
      this.yYO = paramInt;
    }
  }
  
  final class b
    extends RecyclerView.v
  {
    public ImageView fxT;
    public TextView titleTv;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(185310);
      this.titleTv = null;
      this.fxT = null;
      this.titleTv = ((TextView)paramView.findViewById(2131302831));
      this.fxT = ((ImageView)paramView.findViewById(2131302826));
      AppMethodBeat.o(185310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.a.a
 * JD-Core Version:    0.7.0.1
 */