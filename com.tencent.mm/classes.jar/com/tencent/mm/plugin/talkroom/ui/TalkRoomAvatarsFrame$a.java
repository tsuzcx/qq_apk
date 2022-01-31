package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import java.util.LinkedList;
import java.util.List;

final class TalkRoomAvatarsFrame$a
  extends BaseAdapter
{
  String lGc;
  private Context mContext;
  List<String> pBT = new LinkedList();
  
  public TalkRoomAvatarsFrame$a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final int getCount()
  {
    return this.pBT.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.pBT.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = (String)this.pBT.get(paramInt);
    ImageView localImageView;
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, R.i.talk_room_avatar_item, null);
      paramViewGroup = new TalkRoomAvatarsFrame.a.a(this);
      paramViewGroup.doU = ((ImageView)paramView.findViewById(R.h.iv_avatar));
      paramViewGroup.doV = ((TextView)paramView.findViewById(R.h.tv_nickname));
      paramView.setTag(paramViewGroup);
      localImageView = paramViewGroup.doU;
      if (!str.equals(this.lGc)) {
        break label132;
      }
    }
    label132:
    for (paramInt = R.g.talk_room_avatar_item_frame;; paramInt = 0)
    {
      localImageView.setBackgroundResource(paramInt);
      paramViewGroup.doV.setVisibility(8);
      a.b.p(paramViewGroup.doU, str);
      return paramView;
      paramViewGroup = (TalkRoomAvatarsFrame.a.a)paramView.getTag();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame.a
 * JD-Core Version:    0.7.0.1
 */