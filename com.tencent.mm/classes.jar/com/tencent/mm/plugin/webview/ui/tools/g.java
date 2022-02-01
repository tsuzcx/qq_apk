package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.protocal.protobuf.dcn;
import com.tencent.mm.protocal.protobuf.fuw;
import com.tencent.mm.ui.widget.a.j;
import java.util.LinkedList;

public final class g
{
  a WSU;
  public LinkedList<dcn> WSV;
  public LinkedList<fuw> WSW;
  x<Integer> WSX;
  int WSY;
  final Context mContext;
  private RecyclerView mRecyclerView;
  View tss;
  j xcO;
  
  public g(Context paramContext, LinkedList<dcn> paramLinkedList, LinkedList<fuw> paramLinkedList1)
  {
    AppMethodBeat.i(296214);
    this.WSX = new x();
    this.WSY = 0;
    this.mContext = paramContext;
    this.xcO = new j(paramContext, 0, 3);
    this.WSV = paramLinkedList;
    this.WSW = paramLinkedList1;
    ixq();
    AppMethodBeat.o(296214);
  }
  
  final void ixq()
  {
    AppMethodBeat.i(296222);
    this.mRecyclerView = new RecyclerView(this.mContext);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.mRecyclerView.setLayoutParams(localLayoutParams);
    this.mRecyclerView.setLayoutManager(new LinearLayoutManager());
    this.mRecyclerView.setPadding(0, 0, 0, com.tencent.mm.cd.a.fromDPToPix(this.mContext, 98));
    this.WSU = new a();
    this.mRecyclerView.setAdapter(this.WSU);
    if (this.xcO != null) {
      this.xcO.setCustomView(this.mRecyclerView);
    }
    AppMethodBeat.o(296222);
  }
  
  public final class a
    extends RecyclerView.a<a>
  {
    public a() {}
    
    public final int getItemCount()
    {
      AppMethodBeat.i(296240);
      int i = ((dcn)g.this.WSV.get(g.this.WSY)).aaIv.size();
      AppMethodBeat.o(296240);
      return i;
    }
    
    public final class a
      extends RecyclerView.v
    {
      View WTb;
      TextView WTc;
      View WTd;
      ImageView WTe;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(296391);
        this.WTb = paramView;
        this.WTc = ((TextView)paramView.findViewById(c.f.appdata_auth_half_bottom_selection));
        this.WTd = paramView.findViewById(c.f.appdata_auth_half_bottom_selection_mark);
        this.WTe = ((ImageView)paramView.findViewById(c.f.bottom_line));
        AppMethodBeat.o(296391);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.g
 * JD-Core Version:    0.7.0.1
 */