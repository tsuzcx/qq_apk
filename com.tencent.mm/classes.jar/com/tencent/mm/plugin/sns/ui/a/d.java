package com.tencent.mm.plugin.sns.ui.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.aa;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.base.Vending;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends BaseAdapter
  implements aa
{
  public bk ESp;
  public List<bl> dataList;
  
  public d(MMActivity paramMMActivity, ListView paramListView, c paramc, i parami)
  {
    AppMethodBeat.i(203864);
    this.dataList = new ArrayList();
    this.ESp = new bk(paramMMActivity, paramListView, paramc, parami, this);
    AppMethodBeat.o(203864);
  }
  
  public final SnsInfo Zv(int paramInt)
  {
    AppMethodBeat.i(203868);
    SnsInfo localSnsInfo = ((bl)this.dataList.get(paramInt)).DqO;
    AppMethodBeat.o(203868);
    return localSnsInfo;
  }
  
  public final bl Zw(int paramInt)
  {
    AppMethodBeat.i(203866);
    bl localbl = (bl)this.dataList.get(paramInt);
    AppMethodBeat.o(203866);
    return localbl;
  }
  
  public final void ffM()
  {
    AppMethodBeat.i(203867);
    this.ESp.notifyDataSetChanged();
    AppMethodBeat.o(203867);
  }
  
  public final Vending ffN()
  {
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(203865);
    int i = this.dataList.size();
    AppMethodBeat.o(203865);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(203869);
    if ((paramInt >= 0) && (paramInt < this.dataList.size()))
    {
      paramViewGroup = (bl)this.dataList.get(paramInt);
      e locale = e.DUQ;
      long l = paramViewGroup.ENp;
      if (!locale.DVJ.contains(Long.valueOf(l))) {
        locale.DVJ.add(Long.valueOf(l));
      }
    }
    paramView = this.ESp.o(paramInt, paramView);
    AppMethodBeat.o(203869);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.d
 * JD-Core Version:    0.7.0.1
 */