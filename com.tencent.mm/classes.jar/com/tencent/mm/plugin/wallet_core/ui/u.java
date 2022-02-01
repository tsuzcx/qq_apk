package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import java.util.ArrayList;

public final class u
  extends BaseAdapter
{
  ae PcK = null;
  private Context mContext;
  ArrayList<ae> mData = null;
  
  public u(Context paramContext, ArrayList<ae> paramArrayList)
  {
    this.mContext = paramContext;
    this.mData = paramArrayList;
  }
  
  public final ae amJ(int paramInt)
  {
    AppMethodBeat.i(71254);
    if ((this.mData != null) && (getCount() > paramInt))
    {
      ae localae = (ae)this.mData.get(paramInt);
      AppMethodBeat.o(71254);
      return localae;
    }
    AppMethodBeat.o(71254);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(71253);
    if (this.mData != null)
    {
      int i = this.mData.size();
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
      paramViewGroup.jMg = ((TextView)paramView.findViewById(a.f.title));
      paramViewGroup.PcL = ((ImageView)paramView.findViewById(a.f.selected_icon));
      paramView.setTag(paramViewGroup);
      ae localae = amJ(paramInt);
      if (localae != null)
      {
        paramViewGroup.jMg.setText(localae.field_wallet_name);
        if (localae.field_wallet_selected != 1) {
          break label131;
        }
        this.PcK = localae;
        paramViewGroup.PcL.setImageResource(a.h.radio_on);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(71255);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label131:
      paramViewGroup.PcL.setImageResource(a.h.radio_off);
    }
  }
  
  final class a
  {
    ImageView PcL;
    TextView jMg;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.u
 * JD-Core Version:    0.7.0.1
 */