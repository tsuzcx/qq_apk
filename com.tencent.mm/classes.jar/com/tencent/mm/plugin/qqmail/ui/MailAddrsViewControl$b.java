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
import com.tencent.mm.plugin.qqmail.d.l;
import java.util.ArrayList;
import java.util.List;

public final class MailAddrsViewControl$b
  extends BaseAdapter
  implements Filterable
{
  private List<l> jlP;
  private ArrayList<l> jlQ;
  private Context mContext;
  private final Object mLock;
  private boolean xwk;
  private a xwl;
  
  public MailAddrsViewControl$b(Context paramContext, List<l> paramList)
  {
    AppMethodBeat.i(123077);
    this.mLock = new Object();
    this.xwk = true;
    this.mContext = paramContext;
    this.jlP = paramList;
    AppMethodBeat.o(123077);
  }
  
  public final l NT(int paramInt)
  {
    AppMethodBeat.i(123080);
    l locall = (l)this.jlP.get(paramInt);
    AppMethodBeat.o(123080);
    return locall;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(123079);
    int i = this.jlP.size();
    AppMethodBeat.o(123079);
    return i;
  }
  
  public final Filter getFilter()
  {
    AppMethodBeat.i(123082);
    if (this.xwl == null) {
      this.xwl = new a((byte)0);
    }
    a locala = this.xwl;
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
      paramViewGroup.jiC = ((TextView)paramView.findViewById(2131303579));
      paramViewGroup.xvV = ((TextView)paramView.findViewById(2131303576));
      paramViewGroup.xwn = ((CheckBox)paramView.findViewById(2131303580));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup = NT(paramInt);
      b localb = (b)paramView.getTag();
      localb.jiC.setText(paramViewGroup.name);
      localb.xvV.setText(paramViewGroup.vly);
      localb.xwn.setVisibility(8);
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
    this.xwk = true;
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
          l locall = (l)((ArrayList)???).get(i);
          if ((locall.name.toLowerCase().contains(???)) || (locall.vly.toLowerCase().contains(???))) {
            localArrayList.add(locall);
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
    TextView jiC;
    TextView xvV;
    CheckBox xwn;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.b
 * JD-Core Version:    0.7.0.1
 */