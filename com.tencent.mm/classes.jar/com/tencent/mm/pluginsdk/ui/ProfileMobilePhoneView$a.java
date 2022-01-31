package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import java.util.List;
import junit.framework.Assert;

final class ProfileMobilePhoneView$a
  extends BaseAdapter
{
  private List<String> kZk = null;
  private Context mContext = null;
  
  public ProfileMobilePhoneView$a(Context paramContext, List<String> paramList)
  {
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.mContext = paramContext;
      this.kZk = paramList;
      return;
    }
  }
  
  public final int getCount()
  {
    if (this.kZk == null) {
      return 0;
    }
    return this.kZk.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.kZk.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = (String)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(R.i.chatting_item_phone_alert_item_normal, paramViewGroup, false);
      paramView = new ProfileMobilePhoneView.a.a(this, (byte)0);
      ((ProfileMobilePhoneView.a.a)paramView).fcy = ((TextView)localView.findViewById(R.h.title));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      ((ProfileMobilePhoneView.a.a)paramViewGroup).fcy.setText(str);
      return localView;
      paramViewGroup = paramView.getTag();
      localView = paramView;
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView.a
 * JD-Core Version:    0.7.0.1
 */