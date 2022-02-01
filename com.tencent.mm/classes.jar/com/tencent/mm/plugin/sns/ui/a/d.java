package com.tencent.mm.plugin.sns.ui.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.ac;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.base.Vending;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends BaseAdapter
  implements ac
{
  public bm Lgs;
  public List<bn> dataList;
  
  public d(MMActivity paramMMActivity, ListView paramListView, c paramc, i parami)
  {
    AppMethodBeat.i(269543);
    this.dataList = new ArrayList();
    this.Lgs = new bm(paramMMActivity, paramListView, paramc, parami, this);
    AppMethodBeat.o(269543);
  }
  
  public final SnsInfo agM(int paramInt)
  {
    AppMethodBeat.i(269548);
    SnsInfo localSnsInfo = ((bn)this.dataList.get(paramInt)).Jws;
    AppMethodBeat.o(269548);
    return localSnsInfo;
  }
  
  public final bn agN(int paramInt)
  {
    AppMethodBeat.i(269546);
    bn localbn = (bn)this.dataList.get(paramInt);
    AppMethodBeat.o(269546);
    return localbn;
  }
  
  public final void fTJ()
  {
    AppMethodBeat.i(269547);
    this.Lgs.notifyDataSetChanged();
    AppMethodBeat.o(269547);
  }
  
  public final Vending fTK()
  {
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(269544);
    int i = this.dataList.size();
    AppMethodBeat.o(269544);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(269549);
    if ((paramInt >= 0) && (paramInt < this.dataList.size()))
    {
      paramViewGroup = (bn)this.dataList.get(paramInt);
      g localg = g.Kia;
      long l = paramViewGroup.Lbm;
      if (!localg.KiT.contains(Long.valueOf(l))) {
        localg.KiT.add(Long.valueOf(l));
      }
    }
    paramView = this.Lgs.r(paramInt, paramView);
    AppMethodBeat.o(269549);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.d
 * JD-Core Version:    0.7.0.1
 */