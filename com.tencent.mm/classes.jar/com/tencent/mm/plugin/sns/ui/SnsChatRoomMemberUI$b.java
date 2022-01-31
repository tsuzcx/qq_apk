package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.openim.room.a.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.u;
import java.util.List;

final class SnsChatRoomMemberUI$b
  extends BaseAdapter
{
  private String eeu;
  private u efi;
  private List<String> ejc;
  private boolean eje = false;
  private String ejf = null;
  private Context mContext;
  
  public SnsChatRoomMemberUI$b(Context paramContext, u paramu, String paramString, List<String> paramList)
  {
    this.efi = paramString;
    this.eeu = paramList;
    this.ejc = null;
    Object localObject;
    this.ejf = localObject;
    this.mContext = paramu;
  }
  
  public final SnsChatRoomMemberUI.a EL(int paramInt)
  {
    AppMethodBeat.i(145529);
    SnsChatRoomMemberUI.a locala = (SnsChatRoomMemberUI.a)SnsChatRoomMemberUI.c(this.rOn).get(paramInt);
    AppMethodBeat.o(145529);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(145531);
    int i = SnsChatRoomMemberUI.c(this.rOn).size();
    AppMethodBeat.o(145531);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(145530);
    View localView;
    SnsChatRoomMemberUI.c localc;
    String str;
    if (paramView == null)
    {
      localView = View.inflate(this.mContext, 2130970811, null);
      localc = new SnsChatRoomMemberUI.c((byte)0);
      localc.egq = ((ImageView)localView.findViewById(2131822799));
      localc.ejj = ((TextView)localView.findViewById(2131822801));
      paramView = (WindowManager)this.mContext.getSystemService("window");
      localc.ejj.setMaxWidth(paramView.getDefaultDisplay().getWidth() * 2 / 3);
      localc.ejk = ((TextView)localView.findViewById(2131827527));
      localView.setTag(localc);
      if (localc.ejk != null) {
        localc.ejk.setVisibility(8);
      }
      paramView = (SnsChatRoomMemberUI.a)SnsChatRoomMemberUI.c(this.rOn).get(paramInt);
      if ((paramView != null) && (paramView.type == 1))
      {
        ad localad = paramView.contact;
        a.b.c(localc.egq, localad.field_username);
        str = SnsChatRoomMemberUI.c(this.efi, localad.field_username);
        if (bo.isNullOrNil(localad.field_conRemark)) {
          break label376;
        }
        paramViewGroup = localad.field_conRemark;
        label214:
        paramView = paramViewGroup;
        if (bo.isNullOrNil(paramViewGroup)) {
          paramView = localad.Oe();
        }
        paramViewGroup = paramView;
        if (str != null)
        {
          paramViewGroup = paramView;
          if (!str.equals(""))
          {
            paramViewGroup = paramView;
            if (!paramView.equals(str)) {
              paramViewGroup = str + "( " + paramView + " )";
            }
          }
        }
        localc.ejj.setVisibility(0);
        localc.ejj.setText(j.b(this.mContext, paramViewGroup, localc.ejj.getTextSize()));
        if (localc.ejk != null)
        {
          paramView = a.A(localad);
          if (!TextUtils.isEmpty(paramView)) {
            break label382;
          }
          localc.ejk.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(145530);
      return localView;
      localc = (SnsChatRoomMemberUI.c)paramView.getTag();
      localView = paramView;
      break;
      label376:
      paramViewGroup = str;
      break label214;
      label382:
      localc.ejk.setVisibility(0);
      localc.ejk.setText(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsChatRoomMemberUI.b
 * JD-Core Version:    0.7.0.1
 */