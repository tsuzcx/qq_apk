package com.tencent.mm.plugin.qqmail.ui;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.tencent.mm.plugin.qqmail.b.o;
import java.util.ArrayList;
import java.util.List;

final class MailAddrsViewControl$b$a
  extends Filter
{
  private MailAddrsViewControl$b$a(MailAddrsViewControl.b paramb) {}
  
  protected final Filter.FilterResults performFiltering(CharSequence arg1)
  {
    Filter.FilterResults localFilterResults1 = new Filter.FilterResults();
    if (MailAddrsViewControl.b.a(this.niw) == null) {}
    synchronized (MailAddrsViewControl.b.b(this.niw))
    {
      MailAddrsViewControl.b.a(this.niw, new ArrayList(MailAddrsViewControl.b.c(this.niw)));
      if (??? != null) {
        if (???.length() != 0) {
          break label130;
        }
      }
    }
    synchronized (MailAddrsViewControl.b.b(this.niw))
    {
      ??? = new ArrayList(MailAddrsViewControl.b.a(this.niw));
      localFilterResults1.values = ???;
      localFilterResults1.count = ((ArrayList)???).size();
      return localFilterResults1;
      ??? = finally;
      throw ???;
    }
    label130:
    ??? = ???.toString().toLowerCase();
    ??? = MailAddrsViewControl.b.a(this.niw);
    int j = ((ArrayList)???).size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      o localo = (o)((ArrayList)???).get(i);
      if ((localo.name.toLowerCase().contains(???)) || (localo.lCF.toLowerCase().contains(???))) {
        localArrayList.add(localo);
      }
      i += 1;
    }
    localFilterResults2.values = localArrayList;
    localFilterResults2.count = localArrayList.size();
    return localFilterResults2;
  }
  
  protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    MailAddrsViewControl.b.a(this.niw, (List)paramFilterResults.values);
    if (paramFilterResults.count > 0)
    {
      this.niw.notifyDataSetChanged();
      return;
    }
    MailAddrsViewControl.b.a(this.niw, new ArrayList(MailAddrsViewControl.b.a(this.niw)));
    this.niw.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.b.a
 * JD-Core Version:    0.7.0.1
 */