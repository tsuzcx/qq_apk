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
  public int NjH;
  private ImageView NjI;
  public List<a> jjG;
  
  public a()
  {
    AppMethodBeat.i(185311);
    this.jjG = new ArrayList();
    this.NjH = -1;
    this.NjI = null;
    AppMethodBeat.o(185311);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(185312);
    int i = this.jjG.size();
    AppMethodBeat.o(185312);
    return i;
  }
  
  public final void ig(List<a> paramList)
  {
    AppMethodBeat.i(185313);
    this.jjG.clear();
    this.jjG.addAll(paramList);
    AppMethodBeat.o(185313);
  }
  
  public static final class a
  {
    public String NjL = "";
    public int NjM = -1;
    
    public a(String paramString, int paramInt)
    {
      this.NjL = paramString;
      this.NjM = paramInt;
    }
  }
  
  final class b
    extends RecyclerView.v
  {
    public ImageView jmf;
    public TextView titleTv;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(185310);
      this.titleTv = null;
      this.jmf = null;
      this.titleTv = ((TextView)paramView.findViewById(a.d.NgA));
      this.jmf = ((ImageView)paramView.findViewById(a.d.Ngx));
      AppMethodBeat.o(185310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.a.a
 * JD-Core Version:    0.7.0.1
 */