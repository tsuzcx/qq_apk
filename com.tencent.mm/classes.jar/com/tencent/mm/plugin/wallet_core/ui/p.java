package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import java.util.ArrayList;

public final class p
  extends BaseAdapter
{
  private Context mContext;
  ArrayList<x> mData = null;
  x qGQ = null;
  
  public p(Context paramContext, ArrayList<x> paramArrayList)
  {
    this.mContext = paramContext;
    this.mData = paramArrayList;
  }
  
  public final x AY(int paramInt)
  {
    if ((this.mData != null) && (getCount() > paramInt)) {
      return (x)this.mData.get(paramInt);
    }
    return null;
  }
  
  public final int getCount()
  {
    if (this.mData != null) {
      return this.mData.size();
    }
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, a.g.wallet_switch_wallet_kind_item, null);
      paramViewGroup = new a((byte)0);
      paramViewGroup.fcy = ((TextView)paramView.findViewById(a.f.title));
      paramViewGroup.qGR = ((ImageView)paramView.findViewById(a.f.selected_icon));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      x localx = AY(paramInt);
      if (localx != null)
      {
        paramViewGroup.fcy.setText(localx.field_wallet_name);
        if (localx.field_wallet_selected != 1) {
          break;
        }
        this.qGQ = localx;
        paramViewGroup.qGR.setImageResource(a.h.radio_on);
      }
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    paramViewGroup.qGR.setImageResource(a.h.radio_off);
    return paramView;
  }
  
  private final class a
  {
    TextView fcy;
    ImageView qGR;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.p
 * JD-Core Version:    0.7.0.1
 */