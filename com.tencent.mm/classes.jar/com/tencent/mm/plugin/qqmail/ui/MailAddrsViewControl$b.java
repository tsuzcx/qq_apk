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
import com.tencent.mm.plugin.qqmail.b.p;
import java.util.ArrayList;
import java.util.List;

public final class MailAddrsViewControl$b
  extends BaseAdapter
  implements Filterable
{
  private List<p> ipH;
  private ArrayList<p> ipI;
  private Context mContext;
  private final Object mLock;
  private boolean uPT;
  private a uPU;
  
  public MailAddrsViewControl$b(Context paramContext, List<p> paramList)
  {
    AppMethodBeat.i(123077);
    this.mLock = new Object();
    this.uPT = true;
    this.mContext = paramContext;
    this.ipH = paramList;
    AppMethodBeat.o(123077);
  }
  
  public final p JP(int paramInt)
  {
    AppMethodBeat.i(123080);
    p localp = (p)this.ipH.get(paramInt);
    AppMethodBeat.o(123080);
    return localp;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(123079);
    int i = this.ipH.size();
    AppMethodBeat.o(123079);
    return i;
  }
  
  public final Filter getFilter()
  {
    AppMethodBeat.i(123082);
    if (this.uPU == null) {
      this.uPU = new a((byte)0);
    }
    a locala = this.uPU;
    AppMethodBeat.o(123082);
    return locala;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(123081);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2131495158, null);
      paramViewGroup = new b((byte)0);
      paramViewGroup.imt = ((TextView)paramView.findViewById(2131303579));
      paramViewGroup.uPE = ((TextView)paramView.findViewById(2131303576));
      paramViewGroup.uPW = ((CheckBox)paramView.findViewById(2131303580));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup = JP(paramInt);
      b localb = (b)paramView.getTag();
      localb.imt.setText(paramViewGroup.name);
      localb.uPE.setText(paramViewGroup.sOr);
      localb.uPW.setVisibility(8);
      paramView.setBackgroundColor(this.mContext.getResources().getColor(2131101179));
      AppMethodBeat.o(123081);
      return paramView;
      paramView = (ViewGroup)paramView;
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(123078);
    super.notifyDataSetChanged();
    this.uPT = true;
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
          p localp = (p)((ArrayList)???).get(i);
          if ((localp.name.toLowerCase().contains(???)) || (localp.sOr.toLowerCase().contains(???))) {
            localArrayList.add(localp);
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
    TextView imt;
    TextView uPE;
    CheckBox uPW;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.b
 * JD-Core Version:    0.7.0.1
 */