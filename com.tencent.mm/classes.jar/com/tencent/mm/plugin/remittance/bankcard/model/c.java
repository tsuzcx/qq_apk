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
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
  extends BaseAdapter
  implements Filterable
{
  private List<TransferRecordParcel> Cjk;
  private List<TransferRecordParcel> Cjl;
  private List<Pair<Integer, Integer>> Cjm;
  private Filter Cjn;
  private Context mContext;
  
  public c(Context paramContext, List<TransferRecordParcel> paramList)
  {
    AppMethodBeat.i(67412);
    this.Cjl = new ArrayList();
    this.Cjm = new ArrayList();
    this.mContext = paramContext;
    this.Cjk = paramList;
    AppMethodBeat.o(67412);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67413);
    int i = this.Cjl.size();
    AppMethodBeat.o(67413);
    return i;
  }
  
  public final Filter getFilter()
  {
    AppMethodBeat.i(67416);
    if (this.Cjn == null) {
      this.Cjn = new a((byte)0);
    }
    Filter localFilter = this.Cjn;
    AppMethodBeat.o(67416);
    return localFilter;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(67414);
    Object localObject = this.Cjl.get(paramInt);
    AppMethodBeat.o(67414);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(67415);
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.mContext).inflate(2131493205, paramViewGroup, false);
      paramView = new b((byte)0);
      paramView.Cjq = ((CdnImageView)localView.findViewById(2131297799));
      paramView.Cjr = ((TextView)localView.findViewById(2131297801));
      paramView.Cjs = ((TextView)localView.findViewById(2131297800));
      localView.setTag(paramView);
    }
    paramView = (b)localView.getTag();
    paramViewGroup = (TransferRecordParcel)getItem(paramInt);
    Pair localPair = (Pair)this.Cjm.get(paramInt);
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(this.mContext.getResources().getColor(2131100904));
    SpannableString localSpannableString = new SpannableString(paramViewGroup.Cjv);
    localSpannableString.setSpan(localForegroundColorSpan, ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue(), 18);
    paramView.Cjq.setUrl(paramViewGroup.CiX);
    paramView.Cjr.setText(localSpannableString);
    paramView.Cjs.setText(this.mContext.getString(2131756534, new Object[] { paramViewGroup.ynT, paramViewGroup.Cju }));
    AppMethodBeat.o(67415);
    return localView;
  }
  
  final class a
    extends Filter
  {
    List<TransferRecordParcel> Cjo;
    
    private a()
    {
      AppMethodBeat.i(67409);
      this.Cjo = new ArrayList();
      AppMethodBeat.o(67409);
    }
    
    protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(67410);
      this.Cjo.clear();
      c.a(c.this).clear();
      Log.d("MicroMsg.PayeeAutoCompleteAdapter", "input: %s", new Object[] { paramCharSequence });
      Iterator localIterator = c.b(c.this).iterator();
      while (localIterator.hasNext())
      {
        TransferRecordParcel localTransferRecordParcel = (TransferRecordParcel)localIterator.next();
        if ((!Util.isNullOrNil(paramCharSequence)) && (localTransferRecordParcel.Cjv.contains(paramCharSequence)))
        {
          int i = localTransferRecordParcel.Cjv.indexOf((String)paramCharSequence);
          int j = paramCharSequence.length() + i;
          Log.i("MicroMsg.PayeeAutoCompleteAdapter", "match payee: %s, start: %s, end: %s", new Object[] { localTransferRecordParcel.Cjv, Integer.valueOf(i), Integer.valueOf(j) });
          Pair localPair = new Pair(Integer.valueOf(i), Integer.valueOf(j));
          c.a(c.this).add(localPair);
          this.Cjo.add(localTransferRecordParcel);
        }
      }
      paramCharSequence = new Filter.FilterResults();
      paramCharSequence.count = this.Cjo.size();
      paramCharSequence.values = this.Cjo;
      AppMethodBeat.o(67410);
      return paramCharSequence;
    }
    
    protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      AppMethodBeat.i(67411);
      c.a(c.this, (List)paramFilterResults.values);
      Log.i("MicroMsg.PayeeAutoCompleteAdapter", "match count: %d", new Object[] { Integer.valueOf(c.c(c.this).size()) });
      c.this.notifyDataSetChanged();
      AppMethodBeat.o(67411);
    }
  }
  
  final class b
  {
    CdnImageView Cjq;
    TextView Cjr;
    TextView Cjs;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.c
 * JD-Core Version:    0.7.0.1
 */