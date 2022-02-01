package com.tencent.mm.plugin.transvoice.ui.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
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
  public int Gwo;
  private ImageView Gwp;
  public List<a> gzD;
  
  public a()
  {
    AppMethodBeat.i(185311);
    this.gzD = new ArrayList();
    this.Gwo = -1;
    this.Gwp = null;
    AppMethodBeat.o(185311);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(185312);
    int i = this.gzD.size();
    AppMethodBeat.o(185312);
    return i;
  }
  
  public final void hy(List<a> paramList)
  {
    AppMethodBeat.i(185313);
    this.gzD.clear();
    this.gzD.addAll(paramList);
    AppMethodBeat.o(185313);
  }
  
  public static final class a
  {
    public String Gws = "";
    public int Gwt = -1;
    
    public a(String paramString, int paramInt)
    {
      this.Gws = paramString;
      this.Gwt = paramInt;
    }
  }
  
  final class b
    extends RecyclerView.v
  {
    public ImageView gBZ;
    public TextView titleTv;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(185310);
      this.titleTv = null;
      this.gBZ = null;
      this.titleTv = ((TextView)paramView.findViewById(2131305401));
      this.gBZ = ((ImageView)paramView.findViewById(2131305396));
      AppMethodBeat.o(185310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.a.a
 * JD-Core Version:    0.7.0.1
 */