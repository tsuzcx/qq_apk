package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Parcelable.Creator;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.protocal.protobuf.cpe;
import com.tencent.mm.protocal.protobuf.cpf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

final class SettingsManageAuthUI$2
  implements AdapterView.OnItemClickListener
{
  SettingsManageAuthUI$2(SettingsManageAuthUI paramSettingsManageAuthUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(127247);
    if (!SettingsManageAuthUI.c(this.qIF))
    {
      paramAdapterView = SettingsManageAuthUI.d(this.qIF).Db(paramInt);
      if (paramAdapterView != null)
      {
        paramView = new Intent(this.qIF, SettingsModifyUserAuthUI.class);
        UserAuthItemParcelable[] arrayOfUserAuthItemParcelable = (UserAuthItemParcelable[])UserAuthItemParcelable.CREATOR.newArray(paramAdapterView.xXW.size());
        paramInt = 0;
        while (paramInt < paramAdapterView.xXW.size())
        {
          cpf localcpf = (cpf)paramAdapterView.xXW.get(paramInt);
          UserAuthItemParcelable localUserAuthItemParcelable = new UserAuthItemParcelable();
          localUserAuthItemParcelable.scope = localcpf.scope;
          localUserAuthItemParcelable.qFg = localcpf.qFg;
          localUserAuthItemParcelable.state = localcpf.state;
          localUserAuthItemParcelable.qFh = localcpf.qFh;
          arrayOfUserAuthItemParcelable[paramInt] = localUserAuthItemParcelable;
          paramInt += 1;
        }
        paramView.putExtra("app_id", paramAdapterView.cwc);
        paramView.putExtra("app_name", paramAdapterView.fhP);
        paramView.putExtra("modify_scene", 1);
        paramView.putParcelableArrayListExtra("app_auth_items", new ArrayList(Arrays.asList(arrayOfUserAuthItemParcelable)));
        this.qIF.startActivity(paramView);
      }
    }
    AppMethodBeat.o(127247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI.2
 * JD-Core Version:    0.7.0.1
 */