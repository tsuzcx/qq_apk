package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import java.util.LinkedList;
import java.util.List;

final class TalkRoomAvatarsFrame$a
  extends BaseAdapter
{
  String Kfz;
  List<String> SOz;
  private Context mContext;
  
  public TalkRoomAvatarsFrame$a(Context paramContext)
  {
    AppMethodBeat.i(29577);
    this.SOz = new LinkedList();
    this.mContext = paramContext;
    AppMethodBeat.o(29577);
  }
  
  public final int cs(String paramString)
  {
    AppMethodBeat.i(29578);
    int i = this.SOz.indexOf(paramString);
    AppMethodBeat.o(29578);
    return i;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(29579);
    int i = this.SOz.size();
    AppMethodBeat.o(29579);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(29580);
    Object localObject = this.SOz.get(paramInt);
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
    String str = (String)this.SOz.get(paramInt);
    ImageView localImageView;
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, R.i.goA, null);
      paramViewGroup = new a();
      paramViewGroup.lBC = ((ImageView)paramView.findViewById(R.h.fLL));
      paramViewGroup.lBD = ((TextView)paramView.findViewById(R.h.gaV));
      paramView.setTag(paramViewGroup);
      localImageView = paramViewGroup.lBC;
      if (!str.equals(this.Kfz)) {
        break label144;
      }
    }
    label144:
    for (paramInt = R.g.fpp;; paramInt = 0)
    {
      localImageView.setBackgroundResource(paramInt);
      paramViewGroup.lBD.setVisibility(8);
      a.b.C(paramViewGroup.lBC, str);
      AppMethodBeat.o(29581);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
    }
  }
  
  final class a
  {
    public ImageView lBC;
    public TextView lBD;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame.a
 * JD-Core Version:    0.7.0.1
 */