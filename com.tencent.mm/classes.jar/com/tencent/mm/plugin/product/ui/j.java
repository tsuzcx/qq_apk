package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.m;
import java.util.LinkedList;

public final class j
  extends BaseAdapter
{
  m BbG;
  String BbH;
  private Context mContext;
  
  public j(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private h Uw(int paramInt)
  {
    AppMethodBeat.i(67032);
    h localh = (h)this.BbG.Bag.get(paramInt);
    AppMethodBeat.o(67032);
    return localh;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67031);
    if (this.BbG.Bag != null)
    {
      int i = this.BbG.Bag.size();
      AppMethodBeat.o(67031);
      return i;
    }
    AppMethodBeat.o(67031);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(67034);
    paramViewGroup = Uw(paramInt);
    if ((paramView == null) || (paramView.getTag() == null)) {
      paramView = View.inflate(this.mContext, 2131495969, null);
    }
    for (;;)
    {
      CheckBox localCheckBox = (CheckBox)paramView;
      localCheckBox.setText(paramViewGroup.name);
      localCheckBox.setEnabled(paramViewGroup.iJ);
      localCheckBox.setChecked(paramViewGroup.id.equals(this.BbH));
      if (!paramViewGroup.iJ) {
        paramView.setBackgroundResource(2131234462);
      }
      for (;;)
      {
        paramView.setTag(new Pair(this.BbG.Bae, paramViewGroup.id));
        AppMethodBeat.o(67034);
        return paramView;
        if (paramViewGroup.id.equals(this.BbH)) {
          paramView.setBackgroundResource(2131234464);
        } else {
          paramView.setBackgroundResource(2131234463);
        }
      }
    }
  }
  
  public final boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(67033);
    boolean bool = Uw(paramInt).iJ;
    AppMethodBeat.o(67033);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.j
 * JD-Core Version:    0.7.0.1
 */