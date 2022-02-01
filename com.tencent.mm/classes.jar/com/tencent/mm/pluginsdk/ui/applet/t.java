package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import java.util.List;

public final class t
  extends BaseAdapter
{
  private List<String> RgR;
  private Context mContext;
  private List<String> mNr;
  
  public t(Context paramContext, List<String> paramList1, List<String> paramList2)
  {
    this.mContext = paramContext;
    this.mNr = paramList2;
    this.RgR = paramList1;
  }
  
  private static a hx(View paramView)
  {
    AppMethodBeat.i(31426);
    a locala = new a((byte)0);
    locala.iZG = ((ImageView)paramView.findViewById(R.h.chatroom_member_avatar));
    locala.mYd = ((TextView)paramView.findViewById(R.h.chatroom_member_name));
    paramView.setTag(locala);
    AppMethodBeat.o(31426);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(31423);
    int i = this.mNr.size();
    AppMethodBeat.o(31423);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(31424);
    Object localObject = this.mNr.get(paramInt);
    AppMethodBeat.o(31424);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31425);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, R.i.chatroom_avatar_item, null);
      paramViewGroup = hx(paramView);
    }
    label262:
    for (;;)
    {
      int i = this.mNr.size();
      if ((paramInt >= 0) && (paramInt < this.mNr.size()) && (paramInt < this.RgR.size()))
      {
        paramViewGroup.iZG.setVisibility(0);
        paramViewGroup.mYd.setVisibility(0);
        a.b.c(paramViewGroup.iZG, (String)this.RgR.get(paramInt));
        paramViewGroup.mYd.setText((CharSequence)this.mNr.get(paramInt));
        paramViewGroup.mYd.setText(((com.tencent.mm.plugin.emoji.b.a)h.ae(com.tencent.mm.plugin.emoji.b.a.class)).a(this.mContext, (CharSequence)this.mNr.get(paramInt), paramViewGroup.mYd.getTextSize()));
        if ((this.mNr.size() <= 12) || (paramInt < this.mNr.size() - i % 4)) {
          break label248;
        }
        paramViewGroup.mYd.setPadding(0, 0, 0, com.tencent.mm.ci.a.aY(this.mContext, R.f.DialogAvatarLinePadding));
      }
      for (;;)
      {
        AppMethodBeat.o(31425);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        if (paramViewGroup != null) {
          break label262;
        }
        paramViewGroup = hx(paramView);
        break;
        label248:
        paramViewGroup.mYd.setPadding(0, 0, 0, 0);
      }
    }
  }
  
  static final class a
  {
    public ImageView iZG;
    public TextView mYd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.t
 * JD-Core Version:    0.7.0.1
 */