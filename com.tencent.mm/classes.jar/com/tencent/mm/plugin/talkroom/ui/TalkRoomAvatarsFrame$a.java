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
  String EmR;
  List<String> Mlf;
  private Context mContext;
  
  public TalkRoomAvatarsFrame$a(Context paramContext)
  {
    AppMethodBeat.i(29577);
    this.Mlf = new LinkedList();
    this.mContext = paramContext;
    AppMethodBeat.o(29577);
  }
  
  public final int bf(String paramString)
  {
    AppMethodBeat.i(29578);
    int i = this.Mlf.indexOf(paramString);
    AppMethodBeat.o(29578);
    return i;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(29579);
    int i = this.Mlf.size();
    AppMethodBeat.o(29579);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(29580);
    Object localObject = this.Mlf.get(paramInt);
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
    String str = (String)this.Mlf.get(paramInt);
    ImageView localImageView;
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, R.i.elw, null);
      paramViewGroup = new a();
      paramViewGroup.iZG = ((ImageView)paramView.findViewById(R.h.dKq));
      paramViewGroup.iZH = ((TextView)paramView.findViewById(R.h.dYk));
      paramView.setTag(paramViewGroup);
      localImageView = paramViewGroup.iZG;
      if (!str.equals(this.EmR)) {
        break label144;
      }
    }
    label144:
    for (paramInt = R.g.dpb;; paramInt = 0)
    {
      localImageView.setBackgroundResource(paramInt);
      paramViewGroup.iZH.setVisibility(8);
      a.b.C(paramViewGroup.iZG, str);
      AppMethodBeat.o(29581);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
    }
  }
  
  final class a
  {
    public ImageView iZG;
    public TextView iZH;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame.a
 * JD-Core Version:    0.7.0.1
 */