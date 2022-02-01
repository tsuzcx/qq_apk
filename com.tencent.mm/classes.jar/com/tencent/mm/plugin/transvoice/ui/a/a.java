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
  public int BVI;
  private ImageView BVJ;
  public List<a> fUw;
  
  public a()
  {
    AppMethodBeat.i(185311);
    this.fUw = new ArrayList();
    this.BVI = -1;
    this.BVJ = null;
    AppMethodBeat.o(185311);
  }
  
  public final void gB(List<a> paramList)
  {
    AppMethodBeat.i(185313);
    this.fUw.clear();
    this.fUw.addAll(paramList);
    AppMethodBeat.o(185313);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(185312);
    int i = this.fUw.size();
    AppMethodBeat.o(185312);
    return i;
  }
  
  public static final class a
  {
    public String BVM = "";
    public int BVN = -1;
    
    public a(String paramString, int paramInt)
    {
      this.BVM = paramString;
      this.BVN = paramInt;
    }
  }
  
  final class b
    extends RecyclerView.w
  {
    public ImageView fWT;
    public TextView titleTv;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(185310);
      this.titleTv = null;
      this.fWT = null;
      this.titleTv = ((TextView)paramView.findViewById(2131302831));
      this.fWT = ((ImageView)paramView.findViewById(2131302826));
      AppMethodBeat.o(185310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.a.a
 * JD-Core Version:    0.7.0.1
 */