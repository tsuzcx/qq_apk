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

public final class t
  extends BaseAdapter
{
  ac BJk = null;
  private Context mContext;
  ArrayList<ac> mData = null;
  
  public t(Context paramContext, ArrayList<ac> paramArrayList)
  {
    this.mContext = paramContext;
    this.mData = paramArrayList;
  }
  
  public final ac TQ(int paramInt)
  {
    AppMethodBeat.i(71254);
    if ((this.mData != null) && (getCount() > paramInt))
    {
      ac localac = (ac)this.mData.get(paramInt);
      AppMethodBeat.o(71254);
      return localac;
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
      paramView = View.inflate(this.mContext, 2131496037, null);
      paramViewGroup = new a((byte)0);
      paramViewGroup.fUk = ((TextView)paramView.findViewById(2131305902));
      paramViewGroup.BJl = ((ImageView)paramView.findViewById(2131304542));
      paramView.setTag(paramViewGroup);
      ac localac = TQ(paramInt);
      if (localac != null)
      {
        paramViewGroup.fUk.setText(localac.field_wallet_name);
        if (localac.field_wallet_selected != 1) {
          break label127;
        }
        this.BJk = localac;
        paramViewGroup.BJl.setImageResource(2131691078);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(71255);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label127:
      paramViewGroup.BJl.setImageResource(2131691077);
    }
  }
  
  final class a
  {
    ImageView BJl;
    TextView fUk;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.t
 * JD-Core Version:    0.7.0.1
 */