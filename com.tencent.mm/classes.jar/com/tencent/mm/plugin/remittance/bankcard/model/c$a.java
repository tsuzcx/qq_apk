package com.tencent.mm.plugin.remittance.bankcard.model;

import android.util.Pair;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class c$a
  extends Filter
{
  List<TransferRecordParcel> qgp;
  
  private c$a(c paramc)
  {
    AppMethodBeat.i(44500);
    this.qgp = new ArrayList();
    AppMethodBeat.o(44500);
  }
  
  protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(44501);
    this.qgp.clear();
    c.a(this.qgq).clear();
    ab.d("MicroMsg.PayeeAutoCompleteAdapter", "input: %s", new Object[] { paramCharSequence });
    Iterator localIterator = c.b(this.qgq).iterator();
    while (localIterator.hasNext())
    {
      TransferRecordParcel localTransferRecordParcel = (TransferRecordParcel)localIterator.next();
      if ((!bo.aa(paramCharSequence)) && (localTransferRecordParcel.qgw.contains(paramCharSequence)))
      {
        int i = localTransferRecordParcel.qgw.indexOf((String)paramCharSequence);
        int j = paramCharSequence.length() + i;
        ab.i("MicroMsg.PayeeAutoCompleteAdapter", "match payee: %s, start: %s, end: %s", new Object[] { localTransferRecordParcel.qgw, Integer.valueOf(i), Integer.valueOf(j) });
        Pair localPair = new Pair(Integer.valueOf(i), Integer.valueOf(j));
        c.a(this.qgq).add(localPair);
        this.qgp.add(localTransferRecordParcel);
      }
    }
    paramCharSequence = new Filter.FilterResults();
    paramCharSequence.count = this.qgp.size();
    paramCharSequence.values = this.qgp;
    AppMethodBeat.o(44501);
    return paramCharSequence;
  }
  
  protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    AppMethodBeat.i(44502);
    c.a(this.qgq, (List)paramFilterResults.values);
    ab.i("MicroMsg.PayeeAutoCompleteAdapter", "match count: %d", new Object[] { Integer.valueOf(c.c(this.qgq).size()) });
    this.qgq.notifyDataSetChanged();
    AppMethodBeat.o(44502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.c.a
 * JD-Core Version:    0.7.0.1
 */