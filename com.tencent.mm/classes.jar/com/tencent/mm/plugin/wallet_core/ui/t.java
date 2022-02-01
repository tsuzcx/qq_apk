package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ad;
import java.util.ArrayList;

public final class t
  extends BaseAdapter
{
  ad DjC = null;
  private Context mContext;
  ArrayList<ad> mData = null;
  
  public t(Context paramContext, ArrayList<ad> paramArrayList)
  {
    this.mContext = paramContext;
    this.mData = paramArrayList;
  }
  
  public final ad VI(int paramInt)
  {
    AppMethodBeat.i(71254);
    if ((this.mData != null) && (getCount() > paramInt))
    {
      ad localad = (ad)this.mData.get(paramInt);
      AppMethodBeat.o(71254);
      return localad;
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
      paramViewGroup.gnM = ((TextView)paramView.findViewById(2131305902));
      paramViewGroup.DjD = ((ImageView)paramView.findViewById(2131304542));
      paramView.setTag(paramViewGroup);
      ad localad = VI(paramInt);
      if (localad != null)
      {
        paramViewGroup.gnM.setText(localad.field_wallet_name);
        if (localad.field_wallet_selected != 1) {
          break label127;
        }
        this.DjC = localad;
        paramViewGroup.DjD.setImageResource(2131691078);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(71255);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label127:
      paramViewGroup.DjD.setImageResource(2131691077);
    }
  }
  
  final class a
  {
    ImageView DjD;
    TextView gnM;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.t
 * JD-Core Version:    0.7.0.1
 */