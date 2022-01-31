package com.tencent.mm.plugin.setting.ui.setting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.protocal.c.cby;
import java.util.List;

final class SettingsManageAuthUI$a
  extends BaseAdapter
{
  List<cby> nUB;
  
  private SettingsManageAuthUI$a(SettingsManageAuthUI paramSettingsManageAuthUI) {}
  
  public final int getCount()
  {
    if ((this.nUB != null) && (!this.nUB.isEmpty())) {
      return this.nUB.size();
    }
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.nUA.getLayoutInflater().inflate(a.g.settings_auth_list_item, null);
      paramView = new a((byte)0);
      localView.setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.izy = ((TextView)localView.findViewById(a.f.settings_auth_item_name));
      paramViewGroup.nUF = ((TextView)localView.findViewById(a.f.settings_auth_item_type));
      paramViewGroup.nUG = ((TextView)localView.findViewById(a.f.settings_auth_item_auth_list));
      paramViewGroup.fks = ((Button)localView.findViewById(a.f.settings_auth_del_btn));
      paramViewGroup.fks.setOnClickListener(new SettingsManageAuthUI.a.1(this, paramInt));
      if (!SettingsManageAuthUI.c(this.nUA)) {
        break label205;
      }
      paramViewGroup.fks.setVisibility(0);
    }
    for (;;)
    {
      if (xd(paramInt) != null)
      {
        paramViewGroup.izy.setText(xd(paramInt).dRQ);
        paramViewGroup.nUF.setText(xd(paramInt).tRd);
        paramViewGroup.nUG.setText(SettingsManageAuthUI.cp(xd(paramInt).tRc));
      }
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      label205:
      paramViewGroup.fks.setVisibility(8);
    }
  }
  
  public final cby xd(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getCount())) {
      return (cby)this.nUB.get(paramInt);
    }
    return null;
  }
  
  private final class a
  {
    Button fks;
    TextView izy;
    TextView nUF;
    TextView nUG;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI.a
 * JD-Core Version:    0.7.0.1
 */