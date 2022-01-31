package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.o;
import java.util.ArrayList;
import java.util.List;

public final class MailAddrsViewControl$b
  extends BaseAdapter
  implements Filterable
{
  private List<o> gCn;
  private ArrayList<o> gCo;
  private Context mContext;
  private final Object mLock;
  private boolean pNH;
  private MailAddrsViewControl.b.a pNI;
  
  public MailAddrsViewControl$b(Context paramContext, List<o> paramList)
  {
    AppMethodBeat.i(68351);
    this.mLock = new Object();
    this.pNH = true;
    this.mContext = paramContext;
    this.gCn = paramList;
    AppMethodBeat.o(68351);
  }
  
  public final o Ca(int paramInt)
  {
    AppMethodBeat.i(68354);
    o localo = (o)this.gCn.get(paramInt);
    AppMethodBeat.o(68354);
    return localo;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(68353);
    int i = this.gCn.size();
    AppMethodBeat.o(68353);
    return i;
  }
  
  public final Filter getFilter()
  {
    AppMethodBeat.i(68356);
    if (this.pNI == null) {
      this.pNI = new MailAddrsViewControl.b.a(this, (byte)0);
    }
    MailAddrsViewControl.b.a locala = this.pNI;
    AppMethodBeat.o(68356);
    return locala;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(68355);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2130970485, null);
      paramViewGroup = new MailAddrsViewControl.b.b(this, (byte)0);
      paramViewGroup.gzk = ((TextView)paramView.findViewById(2131826885));
      paramViewGroup.pNs = ((TextView)paramView.findViewById(2131826886));
      paramViewGroup.pNK = ((CheckBox)paramView.findViewById(2131826887));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup = Ca(paramInt);
      MailAddrsViewControl.b.b localb = (MailAddrsViewControl.b.b)paramView.getTag();
      localb.gzk.setText(paramViewGroup.name);
      localb.pNs.setText(paramViewGroup.nZR);
      localb.pNK.setVisibility(8);
      paramView.setBackgroundColor(-789517);
      AppMethodBeat.o(68355);
      return paramView;
      paramView = (ViewGroup)paramView;
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(68352);
    super.notifyDataSetChanged();
    this.pNH = true;
    AppMethodBeat.o(68352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.b
 * JD-Core Version:    0.7.0.1
 */