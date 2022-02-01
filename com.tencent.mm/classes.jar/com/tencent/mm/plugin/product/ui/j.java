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
  private Context mContext;
  m vHj;
  String vHk;
  
  public j(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private h La(int paramInt)
  {
    AppMethodBeat.i(67032);
    h localh = (h)this.vHj.vFK.get(paramInt);
    AppMethodBeat.o(67032);
    return localh;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67031);
    if (this.vHj.vFK != null)
    {
      int i = this.vHj.vFK.size();
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
    paramViewGroup = La(paramInt);
    if ((paramView == null) || (paramView.getTag() == null)) {
      paramView = View.inflate(this.mContext, 2131495126, null);
    }
    for (;;)
    {
      CheckBox localCheckBox = (CheckBox)paramView;
      localCheckBox.setText(paramViewGroup.name);
      localCheckBox.setEnabled(paramViewGroup.gM);
      localCheckBox.setChecked(paramViewGroup.id.equals(this.vHk));
      if (!paramViewGroup.gM) {
        paramView.setBackgroundResource(2131233649);
      }
      for (;;)
      {
        paramView.setTag(new Pair(this.vHj.vFI, paramViewGroup.id));
        AppMethodBeat.o(67034);
        return paramView;
        if (paramViewGroup.id.equals(this.vHk)) {
          paramView.setBackgroundResource(2131233651);
        } else {
          paramView.setBackgroundResource(2131233650);
        }
      }
    }
  }
  
  public final boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(67033);
    boolean bool = La(paramInt).gM;
    AppMethodBeat.o(67033);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.j
 * JD-Core Version:    0.7.0.1
 */