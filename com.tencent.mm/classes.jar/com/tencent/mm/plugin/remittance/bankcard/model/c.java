package com.tencent.mm.plugin.remittance.bankcard.model;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends BaseAdapter
  implements Filterable
{
  private Context mContext;
  private List<TransferRecordParcel> qgl;
  private List<TransferRecordParcel> qgm;
  private List<Pair<Integer, Integer>> qgn;
  private Filter qgo;
  
  public c(Context paramContext, List<TransferRecordParcel> paramList)
  {
    AppMethodBeat.i(44503);
    this.qgm = new ArrayList();
    this.qgn = new ArrayList();
    this.mContext = paramContext;
    this.qgl = paramList;
    AppMethodBeat.o(44503);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(44504);
    int i = this.qgm.size();
    AppMethodBeat.o(44504);
    return i;
  }
  
  public final Filter getFilter()
  {
    AppMethodBeat.i(44507);
    if (this.qgo == null) {
      this.qgo = new c.a(this, (byte)0);
    }
    Filter localFilter = this.qgo;
    AppMethodBeat.o(44507);
    return localFilter;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(44505);
    Object localObject = this.qgm.get(paramInt);
    AppMethodBeat.o(44505);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(44506);
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.mContext).inflate(2130968827, paramViewGroup, false);
      paramView = new c.b(this, (byte)0);
      paramView.qgr = ((CdnImageView)localView.findViewById(2131821721));
      paramView.qgs = ((TextView)localView.findViewById(2131821722));
      paramView.qgt = ((TextView)localView.findViewById(2131821723));
      localView.setTag(paramView);
    }
    paramView = (c.b)localView.getTag();
    paramViewGroup = (TransferRecordParcel)getItem(paramInt);
    Pair localPair = (Pair)this.qgn.get(paramInt);
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(this.mContext.getResources().getColor(2131690322));
    SpannableString localSpannableString = new SpannableString(paramViewGroup.qgw);
    localSpannableString.setSpan(localForegroundColorSpan, ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue(), 18);
    paramView.qgr.setUrl(paramViewGroup.qfY);
    paramView.qgs.setText(localSpannableString);
    paramView.qgt.setText(this.mContext.getString(2131297513, new Object[] { paramViewGroup.nLq, paramViewGroup.qgv }));
    AppMethodBeat.o(44506);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.c
 * JD-Core Version:    0.7.0.1
 */