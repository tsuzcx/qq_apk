package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.a.a;
import com.tencent.mm.plugin.product.model.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h
  extends BaseAdapter
  implements Filterable
{
  private List<String> MQR;
  private List<String> MSC;
  Filter MSD;
  private Context mContext;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(66991);
    this.MSC = null;
    this.MQR = null;
    this.MSD = new Filter()
    {
      protected final Filter.FilterResults performFiltering(CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(66990);
        Filter.FilterResults localFilterResults = new Filter.FilterResults();
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = h.a(h.this).iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if ((str != null) && (paramAnonymousCharSequence != null) && (str.contains(paramAnonymousCharSequence))) {
            localArrayList.add(str);
          }
        }
        localFilterResults.values = localArrayList;
        localFilterResults.count = localArrayList.size();
        AppMethodBeat.o(66990);
        return localFilterResults;
      }
      
      protected final void publishResults(CharSequence paramAnonymousCharSequence, Filter.FilterResults paramAnonymousFilterResults)
      {
        try
        {
          AppMethodBeat.i(66989);
          h.a(h.this, (List)paramAnonymousFilterResults.values);
          h.this.notifyDataSetChanged();
          AppMethodBeat.o(66989);
          return;
        }
        finally
        {
          paramAnonymousCharSequence = finally;
          throw paramAnonymousCharSequence;
        }
      }
    };
    this.mContext = paramContext;
    this.MSC = a.gzY().gAa().MQR;
    AppMethodBeat.o(66991);
  }
  
  private String getItem(int paramInt)
  {
    AppMethodBeat.i(66993);
    String str = (String)this.MQR.get(paramInt);
    AppMethodBeat.o(66993);
    return str;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66992);
    if (this.MQR != null)
    {
      int i = this.MQR.size();
      AppMethodBeat.o(66992);
      return i;
    }
    AppMethodBeat.o(66992);
    return 0;
  }
  
  public final Filter getFilter()
  {
    return this.MSD;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66994);
    View localView;
    if (paramView == null)
    {
      paramView = new a();
      localView = LayoutInflater.from(this.mContext).inflate(17367043, null);
      paramView.ElR = ((TextView)localView.findViewById(16908308));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.ElR.setText(getItem(paramInt));
      AppMethodBeat.o(66994);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
  }
  
  final class a
  {
    TextView ElR;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.h
 * JD-Core Version:    0.7.0.1
 */