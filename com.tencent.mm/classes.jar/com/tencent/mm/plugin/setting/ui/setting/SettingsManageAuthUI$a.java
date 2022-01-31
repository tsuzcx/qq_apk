package com.tencent.mm.plugin.setting.ui.setting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cpe;
import java.util.List;

final class SettingsManageAuthUI$a
  extends BaseAdapter
{
  List<cpe> qIG;
  
  private SettingsManageAuthUI$a(SettingsManageAuthUI paramSettingsManageAuthUI) {}
  
  public final cpe Db(int paramInt)
  {
    AppMethodBeat.i(127255);
    if ((paramInt >= 0) && (paramInt < getCount()))
    {
      cpe localcpe = (cpe)this.qIG.get(paramInt);
      AppMethodBeat.o(127255);
      return localcpe;
    }
    AppMethodBeat.o(127255);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(127254);
    if ((this.qIG != null) && (!this.qIG.isEmpty()))
    {
      int i = this.qIG.size();
      AppMethodBeat.o(127254);
      return i;
    }
    AppMethodBeat.o(127254);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(127256);
    View localView;
    if (paramView == null)
    {
      localView = this.qIF.getLayoutInflater().inflate(2130970691, null);
      paramView = new SettingsManageAuthUI.a.a(this, (byte)0);
      localView.setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.iVS = ((TextView)localView.findViewById(2131827606));
      paramViewGroup.qIK = ((TextView)localView.findViewById(2131827607));
      paramViewGroup.qIL = ((TextView)localView.findViewById(2131827608));
      paramViewGroup.gBJ = ((Button)localView.findViewById(2131827609));
      paramViewGroup.gBJ.setOnClickListener(new SettingsManageAuthUI.a.1(this, paramInt));
      if (!SettingsManageAuthUI.c(this.qIF)) {
        break label210;
      }
      paramViewGroup.gBJ.setVisibility(0);
    }
    for (;;)
    {
      if (Db(paramInt) != null)
      {
        paramViewGroup.iVS.setText(Db(paramInt).fhP);
        paramViewGroup.qIK.setText(Db(paramInt).xXX);
        paramViewGroup.qIL.setText(SettingsManageAuthUI.cT(Db(paramInt).xXW));
      }
      AppMethodBeat.o(127256);
      return localView;
      paramViewGroup = (SettingsManageAuthUI.a.a)paramView.getTag();
      localView = paramView;
      break;
      label210:
      paramViewGroup.gBJ.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI.a
 * JD-Core Version:    0.7.0.1
 */