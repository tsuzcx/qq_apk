package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ac;
import java.util.ArrayList;

public final class r
  extends BaseAdapter
{
  private Context mContext;
  ArrayList<ac> mData = null;
  ac utW = null;
  
  public r(Context paramContext, ArrayList<ac> paramArrayList)
  {
    this.mContext = paramContext;
    this.mData = paramArrayList;
  }
  
  public final ac II(int paramInt)
  {
    AppMethodBeat.i(47686);
    if ((this.mData != null) && (getCount() > paramInt))
    {
      ac localac = (ac)this.mData.get(paramInt);
      AppMethodBeat.o(47686);
      return localac;
    }
    AppMethodBeat.o(47686);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(47685);
    if (this.mData != null)
    {
      int i = this.mData.size();
      AppMethodBeat.o(47685);
      return i;
    }
    AppMethodBeat.o(47685);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(47687);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2130971260, null);
      paramViewGroup = new r.a(this, (byte)0);
      paramViewGroup.gui = ((TextView)paramView.findViewById(2131820680));
      paramViewGroup.utX = ((ImageView)paramView.findViewById(2131829393));
      paramView.setTag(paramViewGroup);
      ac localac = II(paramInt);
      if (localac != null)
      {
        paramViewGroup.gui.setText(localac.field_wallet_name);
        if (localac.field_wallet_selected != 1) {
          break label127;
        }
        this.utW = localac;
        paramViewGroup.utX.setImageResource(2131231906);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(47687);
      return paramView;
      paramViewGroup = (r.a)paramView.getTag();
      break;
      label127:
      paramViewGroup.utX.setImageResource(2131231905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.r
 * JD-Core Version:    0.7.0.1
 */