package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.mm.plugin.product.a.a;
import com.tencent.mm.plugin.product.b.d;
import java.util.List;

public final class h
  extends BaseAdapter
  implements Filterable
{
  private Context mContext;
  private List<String> mSh = null;
  private List<String> mTY = null;
  Filter mTZ = new h.1(this);
  
  public h(Context paramContext)
  {
    this.mContext = paramContext;
    this.mTY = a.brN().brP().mSh;
  }
  
  private String ke(int paramInt)
  {
    return (String)this.mSh.get(paramInt);
  }
  
  public final int getCount()
  {
    if (this.mSh != null) {
      return this.mSh.size();
    }
    return 0;
  }
  
  public final Filter getFilter()
  {
    return this.mTZ;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new h.a(this);
      localView = LayoutInflater.from(this.mContext).inflate(17367043, null);
      paramView.mTE = ((TextView)localView.findViewById(16908308));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.mTE.setText(ke(paramInt));
      return localView;
      paramViewGroup = (h.a)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.h
 * JD-Core Version:    0.7.0.1
 */