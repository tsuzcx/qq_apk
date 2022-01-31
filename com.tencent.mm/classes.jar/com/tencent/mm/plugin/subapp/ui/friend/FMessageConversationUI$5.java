package com.tencent.mm.plugin.subapp.ui.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class FMessageConversationUI$5
  extends BaseAdapter
{
  FMessageConversationUI$5(FMessageConversationUI paramFMessageConversationUI) {}
  
  public final int getCount()
  {
    return 1;
  }
  
  public final Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(this.pwx.mController.uMN).inflate(R.i.fmessage_conversation_empty_list_item, null);
      paramViewGroup = new FMessageConversationUI.a(this.pwx, paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        paramViewGroup.hic.setImageResource(R.k.find_more_friend_mobile_icon);
        paramViewGroup.fcy.setText(R.l.find_friends_by_mobile);
      }
      return paramView;
      paramViewGroup = (FMessageConversationUI.a)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.5
 * JD-Core Version:    0.7.0.1
 */