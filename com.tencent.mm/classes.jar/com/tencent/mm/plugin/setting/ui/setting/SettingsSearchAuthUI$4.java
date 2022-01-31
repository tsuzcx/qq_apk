package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Parcelable.Creator;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.protocal.c.cby;
import com.tencent.mm.protocal.c.cbz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

final class SettingsSearchAuthUI$4
  implements AdapterView.OnItemClickListener
{
  SettingsSearchAuthUI$4(SettingsSearchAuthUI paramSettingsSearchAuthUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!SettingsSearchAuthUI.f(this.nVN))
    {
      paramAdapterView = SettingsSearchAuthUI.g(this.nVN).xd(paramInt);
      if (paramAdapterView != null)
      {
        paramView = new Intent(this.nVN, SettingsModifyUserAuthUI.class);
        UserAuthItemParcelable[] arrayOfUserAuthItemParcelable = (UserAuthItemParcelable[])UserAuthItemParcelable.CREATOR.newArray(paramAdapterView.tRc.size());
        paramInt = 0;
        while (paramInt < paramAdapterView.tRc.size())
        {
          cbz localcbz = (cbz)paramAdapterView.tRc.get(paramInt);
          UserAuthItemParcelable localUserAuthItemParcelable = new UserAuthItemParcelable();
          localUserAuthItemParcelable.scope = localcbz.scope;
          localUserAuthItemParcelable.nRj = localcbz.nRj;
          localUserAuthItemParcelable.state = localcbz.state;
          localUserAuthItemParcelable.nRk = localcbz.nRk;
          arrayOfUserAuthItemParcelable[paramInt] = localUserAuthItemParcelable;
          paramInt += 1;
        }
        paramView.putExtra("app_id", paramAdapterView.bOL);
        paramView.putExtra("app_name", paramAdapterView.dRQ);
        paramView.putExtra("modify_scene", 2);
        paramView.putParcelableArrayListExtra("app_auth_items", new ArrayList(Arrays.asList(arrayOfUserAuthItemParcelable)));
        this.nVN.startActivity(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI.4
 * JD-Core Version:    0.7.0.1
 */