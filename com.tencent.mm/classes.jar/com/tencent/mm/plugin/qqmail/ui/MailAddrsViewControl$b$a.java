package com.tencent.mm.plugin.qqmail.ui;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.o;
import java.util.ArrayList;
import java.util.List;

final class MailAddrsViewControl$b$a
  extends Filter
{
  private MailAddrsViewControl$b$a(MailAddrsViewControl.b paramb) {}
  
  protected final Filter.FilterResults performFiltering(CharSequence arg1)
  {
    AppMethodBeat.i(68349);
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    if (MailAddrsViewControl.b.a(this.pNJ) == null) {}
    synchronized (MailAddrsViewControl.b.b(this.pNJ))
    {
      MailAddrsViewControl.b.a(this.pNJ, new ArrayList(MailAddrsViewControl.b.c(this.pNJ)));
      if (??? != null) {
        if (???.length() != 0) {
          break label150;
        }
      }
    }
    for (;;)
    {
      synchronized (MailAddrsViewControl.b.b(this.pNJ))
      {
        ??? = new ArrayList(MailAddrsViewControl.b.a(this.pNJ));
        localFilterResults.values = ???;
        localFilterResults.count = ((ArrayList)???).size();
        AppMethodBeat.o(68349);
        return localFilterResults;
        ??? = finally;
        AppMethodBeat.o(68349);
        throw ???;
      }
      label150:
      ??? = ???.toString().toLowerCase();
      ??? = MailAddrsViewControl.b.a(this.pNJ);
      int j = ((ArrayList)???).size();
      ArrayList localArrayList = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        o localo = (o)((ArrayList)???).get(i);
        if ((localo.name.toLowerCase().contains(???)) || (localo.nZR.toLowerCase().contains(???))) {
          localArrayList.add(localo);
        }
        i += 1;
      }
      localObject1.values = localArrayList;
      localObject1.count = localArrayList.size();
    }
  }
  
  protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    AppMethodBeat.i(68350);
    MailAddrsViewControl.b.a(this.pNJ, (List)paramFilterResults.values);
    if (paramFilterResults.count > 0)
    {
      this.pNJ.notifyDataSetChanged();
      AppMethodBeat.o(68350);
      return;
    }
    MailAddrsViewControl.b.a(this.pNJ, new ArrayList(MailAddrsViewControl.b.a(this.pNJ)));
    this.pNJ.notifyDataSetInvalidated();
    AppMethodBeat.o(68350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.b.a
 * JD-Core Version:    0.7.0.1
 */