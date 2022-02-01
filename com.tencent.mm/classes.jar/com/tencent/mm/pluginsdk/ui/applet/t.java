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
  private List<String> GGS;
  private Context mContext;
  private List<String> pJZ;
  
  public t(Context paramContext, List<String> paramList1, List<String> paramList2)
  {
    this.mContext = paramContext;
    this.pJZ = paramList2;
    this.GGS = paramList1;
  }
  
  private static a kN(View paramView)
  {
    AppMethodBeat.i(31426);
    a locala = new a((byte)0);
    locala.lBC = ((ImageView)paramView.findViewById(R.h.chatroom_member_avatar));
    locala.pUL = ((TextView)paramView.findViewById(R.h.chatroom_member_name));
    paramView.setTag(locala);
    AppMethodBeat.o(31426);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(31423);
    int i = this.pJZ.size();
    AppMethodBeat.o(31423);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(31424);
    Object localObject = this.pJZ.get(paramInt);
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
      paramView.findViewById(R.h.chatroom_member_avatar).setImportantForAccessibility(2);
      paramViewGroup = kN(paramView);
    }
    label259:
    label273:
    for (;;)
    {
      int i = this.pJZ.size();
      if ((paramInt >= 0) && (paramInt < this.pJZ.size()) && (paramInt < this.GGS.size()))
      {
        paramViewGroup.lBC.setVisibility(0);
        paramViewGroup.pUL.setVisibility(0);
        a.b.g(paramViewGroup.lBC, (String)this.GGS.get(paramInt));
        paramViewGroup.pUL.setText((CharSequence)this.pJZ.get(paramInt));
        paramViewGroup.pUL.setText(((com.tencent.mm.plugin.emoji.c.a)h.ax(com.tencent.mm.plugin.emoji.c.a.class)).a(this.mContext, (CharSequence)this.pJZ.get(paramInt), paramViewGroup.pUL.getTextSize()));
        if ((this.pJZ.size() <= 12) || (paramInt < this.pJZ.size() - i % 4)) {
          break label259;
        }
        paramViewGroup.pUL.setPadding(0, 0, 0, com.tencent.mm.cd.a.br(this.mContext, R.f.DialogAvatarLinePadding));
      }
      for (;;)
      {
        AppMethodBeat.o(31425);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        if (paramViewGroup != null) {
          break label273;
        }
        paramViewGroup = kN(paramView);
        break;
        paramViewGroup.pUL.setPadding(0, 0, 0, 0);
      }
    }
  }
  
  static final class a
  {
    public ImageView lBC;
    public TextView pUL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.t
 * JD-Core Version:    0.7.0.1
 */