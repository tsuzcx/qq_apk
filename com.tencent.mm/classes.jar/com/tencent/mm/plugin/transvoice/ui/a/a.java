package com.tencent.mm.plugin.transvoice.ui.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.transvoice.a.d;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends RecyclerView.a<b>
{
  public int TWC;
  private ImageView TWD;
  public List<a> lMl;
  
  public a()
  {
    AppMethodBeat.i(185311);
    this.lMl = new ArrayList();
    this.TWC = -1;
    this.TWD = null;
    AppMethodBeat.o(185311);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(185312);
    int i = this.lMl.size();
    AppMethodBeat.o(185312);
    return i;
  }
  
  public final void lG(List<a> paramList)
  {
    AppMethodBeat.i(185313);
    this.lMl.clear();
    this.lMl.addAll(paramList);
    AppMethodBeat.o(185313);
  }
  
  public static final class a
  {
    public String TWG = "";
    public int TWH = -1;
    
    public a(String paramString, int paramInt)
    {
      this.TWG = paramString;
      this.TWH = paramInt;
    }
  }
  
  final class b
    extends RecyclerView.v
  {
    public ImageView lPb;
    public TextView titleTv;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(185310);
      this.titleTv = null;
      this.lPb = null;
      this.titleTv = ((TextView)paramView.findViewById(a.d.TTy));
      this.lPb = ((ImageView)paramView.findViewById(a.d.TTv));
      AppMethodBeat.o(185310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.a.a
 * JD-Core Version:    0.7.0.1
 */