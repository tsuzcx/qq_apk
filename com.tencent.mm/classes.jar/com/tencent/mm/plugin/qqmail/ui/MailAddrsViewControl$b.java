package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.e.c;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.plugin.qqmail.model.k;
import java.util.ArrayList;
import java.util.List;

public class MailAddrsViewControl$b
  extends BaseAdapter
  implements Filterable
{
  private boolean Nou;
  private a Nov;
  private Context mContext;
  private final Object mLock;
  private List<k> pYV;
  private ArrayList<k> pYW;
  
  public MailAddrsViewControl$b(Context paramContext, List<k> paramList)
  {
    AppMethodBeat.i(123077);
    this.mLock = new Object();
    this.Nou = true;
    this.mContext = paramContext;
    this.pYV = paramList;
    AppMethodBeat.o(123077);
  }
  
  public final k age(int paramInt)
  {
    AppMethodBeat.i(123080);
    k localk = (k)this.pYV.get(paramInt);
    AppMethodBeat.o(123080);
    return localk;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(123079);
    int i = this.pYV.size();
    AppMethodBeat.o(123079);
    return i;
  }
  
  public Filter getFilter()
  {
    AppMethodBeat.i(123082);
    if (this.Nov == null) {
      this.Nov = new a((byte)0);
    }
    a locala = this.Nov;
    AppMethodBeat.o(123082);
    return locala;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(123081);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, e.f.qqmail_dropdown_addrlist_item, null);
      paramViewGroup = new b((byte)0);
      paramViewGroup.pUL = ((TextView)paramView.findViewById(e.e.qqmail_addrlist_item_name_tv));
      paramViewGroup.Nof = ((TextView)paramView.findViewById(e.e.qqmail_addrlist_item_addr_iv));
      paramViewGroup.Nox = ((CheckBox)paramView.findViewById(e.e.qqmail_addrlist_item_select_cb));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup = age(paramInt);
      b localb = (b)paramView.getTag();
      localb.pUL.setText(paramViewGroup.name);
      localb.Nof.setText(paramViewGroup.KbS);
      localb.Nox.setVisibility(8);
      paramView.setBackgroundColor(this.mContext.getResources().getColor(e.c.white));
      AppMethodBeat.o(123081);
      return paramView;
      paramView = (ViewGroup)paramView;
    }
  }
  
  public void notifyDataSetChanged()
  {
    AppMethodBeat.i(123078);
    super.notifyDataSetChanged();
    this.Nou = true;
    AppMethodBeat.o(123078);
  }
  
  final class a
    extends Filter
  {
    private a() {}
    
    protected final Filter.FilterResults performFiltering(CharSequence arg1)
    {
      AppMethodBeat.i(123075);
      Filter.FilterResults localFilterResults = new Filter.FilterResults();
      if (MailAddrsViewControl.b.a(MailAddrsViewControl.b.this) == null) {}
      synchronized (MailAddrsViewControl.b.b(MailAddrsViewControl.b.this))
      {
        MailAddrsViewControl.b.a(MailAddrsViewControl.b.this, new ArrayList(MailAddrsViewControl.b.c(MailAddrsViewControl.b.this)));
        if (??? != null) {
          if (???.length() != 0) {
            break label150;
          }
        }
      }
      for (;;)
      {
        synchronized (MailAddrsViewControl.b.b(MailAddrsViewControl.b.this))
        {
          ??? = new ArrayList(MailAddrsViewControl.b.a(MailAddrsViewControl.b.this));
          localFilterResults.values = ???;
          localFilterResults.count = ((ArrayList)???).size();
          AppMethodBeat.o(123075);
          return localFilterResults;
          ??? = finally;
          AppMethodBeat.o(123075);
          throw ???;
        }
        label150:
        ??? = ???.toString().toLowerCase();
        ??? = MailAddrsViewControl.b.a(MailAddrsViewControl.b.this);
        int j = ((ArrayList)???).size();
        ArrayList localArrayList = new ArrayList(j);
        int i = 0;
        while (i < j)
        {
          k localk = (k)((ArrayList)???).get(i);
          if ((localk.name.toLowerCase().contains(???)) || (localk.KbS.toLowerCase().contains(???))) {
            localArrayList.add(localk);
          }
          i += 1;
        }
        localObject1.values = localArrayList;
        localObject1.count = localArrayList.size();
      }
    }
    
    protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      AppMethodBeat.i(123076);
      MailAddrsViewControl.b.a(MailAddrsViewControl.b.this, (List)paramFilterResults.values);
      if (paramFilterResults.count > 0)
      {
        MailAddrsViewControl.b.this.notifyDataSetChanged();
        AppMethodBeat.o(123076);
        return;
      }
      MailAddrsViewControl.b.a(MailAddrsViewControl.b.this, new ArrayList(MailAddrsViewControl.b.a(MailAddrsViewControl.b.this)));
      MailAddrsViewControl.b.this.notifyDataSetInvalidated();
      AppMethodBeat.o(123076);
    }
  }
  
  final class b
  {
    TextView Nof;
    CheckBox Nox;
    TextView pUL;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.b
 * JD-Core Version:    0.7.0.1
 */