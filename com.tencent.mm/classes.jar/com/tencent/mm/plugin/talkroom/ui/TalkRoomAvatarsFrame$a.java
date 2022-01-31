package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import java.util.LinkedList;
import java.util.List;

final class TalkRoomAvatarsFrame$a
  extends BaseAdapter
{
  private Context mContext;
  String odp;
  List<String> tdC;
  
  public TalkRoomAvatarsFrame$a(Context paramContext)
  {
    AppMethodBeat.i(25895);
    this.tdC = new LinkedList();
    this.mContext = paramContext;
    AppMethodBeat.o(25895);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(25897);
    int i = this.tdC.size();
    AppMethodBeat.o(25897);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(25898);
    Object localObject = this.tdC.get(paramInt);
    AppMethodBeat.o(25898);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(25899);
    String str = (String)this.tdC.get(paramInt);
    ImageView localImageView;
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2130970986, null);
      paramViewGroup = new TalkRoomAvatarsFrame.a.a(this);
      paramViewGroup.egq = ((ImageView)paramView.findViewById(2131828477));
      paramViewGroup.egr = ((TextView)paramView.findViewById(2131828478));
      paramView.setTag(paramViewGroup);
      localImageView = paramViewGroup.egq;
      if (!str.equals(this.odp)) {
        break label140;
      }
    }
    label140:
    for (paramInt = 2130840512;; paramInt = 0)
    {
      localImageView.setBackgroundResource(paramInt);
      paramViewGroup.egr.setVisibility(8);
      a.b.u(paramViewGroup.egq, str);
      AppMethodBeat.o(25899);
      return paramView;
      paramViewGroup = (TalkRoomAvatarsFrame.a.a)paramView.getTag();
      break;
    }
  }
  
  public final int indexOf(String paramString)
  {
    AppMethodBeat.i(25896);
    int i = this.tdC.indexOf(paramString);
    AppMethodBeat.o(25896);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame.a
 * JD-Core Version:    0.7.0.1
 */