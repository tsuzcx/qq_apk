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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
  extends BaseAdapter
  implements Filterable
{
  private Context mContext;
  private List<TransferRecordParcel> yij;
  private List<TransferRecordParcel> yik;
  private List<Pair<Integer, Integer>> yil;
  private Filter yim;
  
  public c(Context paramContext, List<TransferRecordParcel> paramList)
  {
    AppMethodBeat.i(67412);
    this.yik = new ArrayList();
    this.yil = new ArrayList();
    this.mContext = paramContext;
    this.yij = paramList;
    AppMethodBeat.o(67412);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67413);
    int i = this.yik.size();
    AppMethodBeat.o(67413);
    return i;
  }
  
  public final Filter getFilter()
  {
    AppMethodBeat.i(67416);
    if (this.yim == null) {
      this.yim = new a((byte)0);
    }
    Filter localFilter = this.yim;
    AppMethodBeat.o(67416);
    return localFilter;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(67414);
    Object localObject = this.yik.get(paramInt);
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
      localView = LayoutInflater.from(this.mContext).inflate(2131493159, paramViewGroup, false);
      paramView = new b((byte)0);
      paramView.yip = ((CdnImageView)localView.findViewById(2131297560));
      paramView.yiq = ((TextView)localView.findViewById(2131297562));
      paramView.yir = ((TextView)localView.findViewById(2131297561));
      localView.setTag(paramView);
    }
    paramView = (b)localView.getTag();
    paramViewGroup = (TransferRecordParcel)getItem(paramInt);
    Pair localPair = (Pair)this.yil.get(paramInt);
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(this.mContext.getResources().getColor(2131100711));
    SpannableString localSpannableString = new SpannableString(paramViewGroup.yiu);
    localSpannableString.setSpan(localForegroundColorSpan, ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue(), 18);
    paramView.yip.setUrl(paramViewGroup.yhW);
    paramView.yiq.setText(localSpannableString);
    paramView.yir.setText(this.mContext.getString(2131756399, new Object[] { paramViewGroup.uVs, paramViewGroup.yit }));
    AppMethodBeat.o(67415);
    return localView;
  }
  
  final class a
    extends Filter
  {
    List<TransferRecordParcel> yin;
    
    private a()
    {
      AppMethodBeat.i(67409);
      this.yin = new ArrayList();
      AppMethodBeat.o(67409);
    }
    
    protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(67410);
      this.yin.clear();
      c.a(c.this).clear();
      ae.d("MicroMsg.PayeeAutoCompleteAdapter", "input: %s", new Object[] { paramCharSequence });
      Iterator localIterator = c.b(c.this).iterator();
      while (localIterator.hasNext())
      {
        TransferRecordParcel localTransferRecordParcel = (TransferRecordParcel)localIterator.next();
        if ((!bu.ah(paramCharSequence)) && (localTransferRecordParcel.yiu.contains(paramCharSequence)))
        {
          int i = localTransferRecordParcel.yiu.indexOf((String)paramCharSequence);
          int j = paramCharSequence.length() + i;
          ae.i("MicroMsg.PayeeAutoCompleteAdapter", "match payee: %s, start: %s, end: %s", new Object[] { localTransferRecordParcel.yiu, Integer.valueOf(i), Integer.valueOf(j) });
          Pair localPair = new Pair(Integer.valueOf(i), Integer.valueOf(j));
          c.a(c.this).add(localPair);
          this.yin.add(localTransferRecordParcel);
        }
      }
      paramCharSequence = new Filter.FilterResults();
      paramCharSequence.count = this.yin.size();
      paramCharSequence.values = this.yin;
      AppMethodBeat.o(67410);
      return paramCharSequence;
    }
    
    protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      AppMethodBeat.i(67411);
      c.a(c.this, (List)paramFilterResults.values);
      ae.i("MicroMsg.PayeeAutoCompleteAdapter", "match count: %d", new Object[] { Integer.valueOf(c.c(c.this).size()) });
      c.this.notifyDataSetChanged();
      AppMethodBeat.o(67411);
    }
  }
  
  final class b
  {
    CdnImageView yip;
    TextView yiq;
    TextView yir;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.c
 * JD-Core Version:    0.7.0.1
 */