package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d$a
  extends BaseAdapter
{
  public HashMap<Integer, Boolean> AJh;
  private ArrayList<Integer> AJi;
  private Context context;
  
  public d$a(d paramd, Context paramContext)
  {
    AppMethodBeat.i(112843);
    this.AJh = new HashMap();
    this.context = paramContext;
    AppMethodBeat.o(112843);
  }
  
  public final void dPq()
  {
    AppMethodBeat.i(112847);
    if (this.AJg.AJd == null)
    {
      AppMethodBeat.o(112847);
      return;
    }
    int i = 0;
    if (i < getCount())
    {
      if (this.AJg.AJd.contains(Integer.valueOf(i))) {
        this.AJh.put(Integer.valueOf(i), Boolean.TRUE);
      }
      for (;;)
      {
        i += 1;
        break;
        this.AJh.put(Integer.valueOf(i), Boolean.FALSE);
      }
    }
    AppMethodBeat.o(112847);
  }
  
  public final ArrayList<Integer> dPr()
  {
    AppMethodBeat.i(112848);
    if (this.AJh == null)
    {
      AppMethodBeat.o(112848);
      return null;
    }
    this.AJi = new ArrayList();
    int i = 0;
    while (i < getCount())
    {
      if (((Boolean)this.AJh.get(Integer.valueOf(i))).booleanValue()) {
        this.AJi.add(Integer.valueOf(i));
      }
      i += 1;
    }
    ArrayList localArrayList = this.AJi;
    AppMethodBeat.o(112848);
    return localArrayList;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(112844);
    int i = this.AJg.saq.size();
    AppMethodBeat.o(112844);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(112845);
    Object localObject = this.AJg.saq.zkW.get(paramInt);
    AppMethodBeat.o(112845);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(112846);
    m localm = (m)this.AJg.saq.zkW.get(paramInt);
    paramViewGroup = LayoutInflater.from(this.context);
    View localView;
    if (paramView == null)
    {
      localView = paramViewGroup.inflate(2130970317, null);
      paramView = new d.a.a(this);
      paramView.AHq = ((LinearLayout)localView.findViewById(2131826401));
      paramView.mCC = ((CheckBox)localView.findViewById(2131826403));
      paramView.gpL = ((TextView)localView.findViewById(2131823680));
      paramView.gpM = ((TextView)localView.findViewById(2131826402));
      localView.setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.gpL.setText(localm.getTitle());
      paramViewGroup.AHq.setOnClickListener(new d.a.1(this, paramInt, localm));
      if (paramViewGroup.gpM != null)
      {
        if ((localm.mZb == null) || (localm.mZb.length() <= 0)) {
          break label304;
        }
        paramViewGroup.gpM.setVisibility(0);
        paramViewGroup.gpM.setText(localm.mZb);
      }
      label198:
      if (!localm.xTc) {
        break label316;
      }
      paramViewGroup.gpL.setTextColor(this.AJg.mContext.getResources().getColor(2131689775));
      paramViewGroup.gpM.setTextColor(this.AJg.mContext.getResources().getColor(2131689775));
      paramViewGroup.mCC.setChecked(((Boolean)this.AJh.get(Integer.valueOf(paramInt))).booleanValue());
      paramViewGroup.mCC.setEnabled(false);
    }
    for (;;)
    {
      AppMethodBeat.o(112846);
      return localView;
      paramViewGroup = (d.a.a)paramView.getTag();
      localView = paramView;
      break;
      label304:
      paramViewGroup.gpM.setVisibility(8);
      break label198;
      label316:
      paramViewGroup.gpL.setTextColor(this.AJg.mContext.getResources().getColor(2131689774));
      paramViewGroup.gpM.setTextColor(this.AJg.mContext.getResources().getColor(2131689776));
      paramViewGroup.mCC.setChecked(((Boolean)this.AJh.get(Integer.valueOf(paramInt))).booleanValue());
      paramViewGroup.mCC.setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.d.a
 * JD-Core Version:    0.7.0.1
 */