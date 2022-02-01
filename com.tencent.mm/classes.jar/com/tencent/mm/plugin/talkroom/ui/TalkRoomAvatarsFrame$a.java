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
  List<String> BGn;
  private Context mContext;
  String vpi;
  
  public TalkRoomAvatarsFrame$a(Context paramContext)
  {
    AppMethodBeat.i(29577);
    this.BGn = new LinkedList();
    this.mContext = paramContext;
    AppMethodBeat.o(29577);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(29579);
    int i = this.BGn.size();
    AppMethodBeat.o(29579);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(29580);
    Object localObject = this.BGn.get(paramInt);
    AppMethodBeat.o(29580);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(29581);
    String str = (String)this.BGn.get(paramInt);
    ImageView localImageView;
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2131495742, null);
      paramViewGroup = new a();
      paramViewGroup.fQl = ((ImageView)paramView.findViewById(2131301204));
      paramViewGroup.fQm = ((TextView)paramView.findViewById(2131306142));
      paramView.setTag(paramViewGroup);
      localImageView = paramViewGroup.fQl;
      if (!str.equals(this.vpi)) {
        break label140;
      }
    }
    label140:
    for (paramInt = 2131234301;; paramInt = 0)
    {
      localImageView.setBackgroundResource(paramInt);
      paramViewGroup.fQm.setVisibility(8);
      a.b.w(paramViewGroup.fQl, str);
      AppMethodBeat.o(29581);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
    }
  }
  
  public final int indexOf(String paramString)
  {
    AppMethodBeat.i(29578);
    int i = this.BGn.indexOf(paramString);
    AppMethodBeat.o(29578);
    return i;
  }
  
  final class a
  {
    public ImageView fQl;
    public TextView fQm;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame.a
 * JD-Core Version:    0.7.0.1
 */