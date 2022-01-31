package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import java.util.List;

public final class l
  extends BaseAdapter
{
  private List<String> eYb;
  private Context mContext;
  private List<String> sdm;
  
  public l(Context paramContext, List<String> paramList1, List<String> paramList2)
  {
    this.mContext = paramContext;
    this.eYb = paramList2;
    this.sdm = paramList1;
  }
  
  private static l.a dy(View paramView)
  {
    l.a locala = new l.a((byte)0);
    locala.doU = ((ImageView)paramView.findViewById(R.h.chatroom_member_avatar));
    locala.fhD = ((TextView)paramView.findViewById(R.h.chatroom_member_name));
    paramView.setTag(locala);
    return locala;
  }
  
  public final int getCount()
  {
    return this.eYb.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.eYb.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, R.i.chatroom_avatar_item, null);
      paramViewGroup = dy(paramView);
    }
    label245:
    for (;;)
    {
      int i = this.eYb.size();
      if ((paramInt >= 0) && (paramInt < this.eYb.size()) && (paramInt < this.sdm.size()))
      {
        paramViewGroup.doU.setVisibility(0);
        paramViewGroup.fhD.setVisibility(0);
        a.b.a(paramViewGroup.doU, (String)this.sdm.get(paramInt));
        paramViewGroup.fhD.setText((CharSequence)this.eYb.get(paramInt));
        paramViewGroup.fhD.setText(((com.tencent.mm.plugin.emoji.b.a)g.r(com.tencent.mm.plugin.emoji.b.a.class)).a((CharSequence)this.eYb.get(paramInt), paramViewGroup.fhD.getTextSize()));
        if ((this.eYb.size() > 12) && (paramInt >= this.eYb.size() - i % 4)) {
          paramViewGroup.fhD.setPadding(0, 0, 0, com.tencent.mm.cb.a.aa(this.mContext, R.f.DialogAvatarLinePadding));
        }
      }
      else
      {
        return paramView;
        paramViewGroup = (l.a)paramView.getTag();
        if (paramViewGroup != null) {
          break label245;
        }
        paramViewGroup = dy(paramView);
        continue;
      }
      paramViewGroup.fhD.setPadding(0, 0, 0, 0);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.l
 * JD-Core Version:    0.7.0.1
 */