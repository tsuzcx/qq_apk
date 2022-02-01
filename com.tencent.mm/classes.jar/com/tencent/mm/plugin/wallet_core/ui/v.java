package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import java.util.ArrayList;

public final class v
  extends BaseAdapter
{
  ac VTq = null;
  private Context mContext;
  ArrayList<ac> mlK = null;
  
  public v(Context paramContext, ArrayList<ac> paramArrayList)
  {
    this.mContext = paramContext;
    this.mlK = paramArrayList;
  }
  
  public final ac asy(int paramInt)
  {
    AppMethodBeat.i(71254);
    if ((this.mlK != null) && (getCount() > paramInt))
    {
      ac localac = (ac)this.mlK.get(paramInt);
      AppMethodBeat.o(71254);
      return localac;
    }
    AppMethodBeat.o(71254);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(71253);
    if (this.mlK != null)
    {
      int i = this.mlK.size();
      AppMethodBeat.o(71253);
      return i;
    }
    AppMethodBeat.o(71253);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(71255);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, a.g.wallet_switch_wallet_kind_item, null);
      paramViewGroup = new a((byte)0);
      paramViewGroup.mll = ((TextView)paramView.findViewById(a.f.title));
      paramViewGroup.VTr = ((ImageView)paramView.findViewById(a.f.selected_icon));
      paramView.setTag(paramViewGroup);
      ac localac = asy(paramInt);
      if (localac != null)
      {
        paramViewGroup.mll.setText(localac.field_wallet_name);
        if (localac.field_wallet_selected != 1) {
          break label131;
        }
        this.VTq = localac;
        paramViewGroup.VTr.setImageResource(a.h.radio_on);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(71255);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label131:
      paramViewGroup.VTr.setImageResource(a.h.radio_off);
    }
  }
  
  final class a
  {
    ImageView VTr;
    TextView mll;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.v
 * JD-Core Version:    0.7.0.1
 */