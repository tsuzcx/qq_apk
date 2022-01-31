package com.tencent.mm.plugin.remittance.bankcard.model;

import android.util.Pair;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class c$a
  extends Filter
{
  List<TransferRecordParcel> nvt = new ArrayList();
  
  private c$a(c paramc) {}
  
  protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    this.nvt.clear();
    c.a(this.nvu).clear();
    y.d("MicroMsg.PayeeAutoCompleteAdapter", "input: %s", new Object[] { paramCharSequence });
    Iterator localIterator = c.b(this.nvu).iterator();
    while (localIterator.hasNext())
    {
      TransferRecordParcel localTransferRecordParcel = (TransferRecordParcel)localIterator.next();
      if ((!bk.L(paramCharSequence)) && (localTransferRecordParcel.nvA.contains(paramCharSequence)))
      {
        int i = localTransferRecordParcel.nvA.indexOf((String)paramCharSequence);
        int j = paramCharSequence.length() + i;
        y.i("MicroMsg.PayeeAutoCompleteAdapter", "match payee: %s, start: %s, end: %s", new Object[] { localTransferRecordParcel.nvA, Integer.valueOf(i), Integer.valueOf(j) });
        Pair localPair = new Pair(Integer.valueOf(i), Integer.valueOf(j));
        c.a(this.nvu).add(localPair);
        this.nvt.add(localTransferRecordParcel);
      }
    }
    paramCharSequence = new Filter.FilterResults();
    paramCharSequence.count = this.nvt.size();
    paramCharSequence.values = this.nvt;
    return paramCharSequence;
  }
  
  protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    c.a(this.nvu, (List)paramFilterResults.values);
    y.i("MicroMsg.PayeeAutoCompleteAdapter", "match count: %d", new Object[] { Integer.valueOf(c.c(this.nvu).size()) });
    this.nvu.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.c.a
 * JD-Core Version:    0.7.0.1
 */