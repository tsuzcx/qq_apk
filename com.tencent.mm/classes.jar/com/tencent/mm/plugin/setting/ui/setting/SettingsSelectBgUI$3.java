package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.tencent.mm.ah.p;
import com.tencent.mm.az.j;
import com.tencent.mm.az.m;
import com.tencent.mm.az.n;
import com.tencent.mm.az.r;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class SettingsSelectBgUI$3
  implements AdapterView.OnItemClickListener
{
  SettingsSelectBgUI$3(SettingsSelectBgUI paramSettingsSelectBgUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == 0)
    {
      SettingsSelectBgUI.a(this.nVW, -2);
      SettingsSelectBgUI.b(this.nVW).yc();
      if (!SettingsSelectBgUI.c(this.nVW))
      {
        this.nVW.setResult(-1);
        this.nVW.finish();
      }
    }
    do
    {
      return;
      if (paramInt != 1) {
        break;
      }
      SettingsSelectBgUI.a(this.nVW, 0);
      SettingsSelectBgUI.b(this.nVW).yc();
    } while (SettingsSelectBgUI.c(this.nVW));
    this.nVW.setResult(-1);
    this.nVW.finish();
    return;
    if (!g.DP().isSDCardAvailable())
    {
      Toast.makeText(this.nVW, a.i.settings_select_bg_sdcard_fail, 1).show();
      return;
    }
    paramAdapterView = (m)paramAdapterView.getItemAtPosition(paramInt - 2);
    if (paramAdapterView == null)
    {
      y.e("MicroMsg.SettingsSelectBgUI", "onItemClick fail, info is null, position = " + paramInt);
      return;
    }
    switch (paramAdapterView.status)
    {
    default: 
      return;
    case 1: 
    case 2: 
      SettingsSelectBgUI.a(this.nVW, paramAdapterView.id);
      if (SettingsSelectBgUI.c(this.nVW))
      {
        paramAdapterView.status = 1;
        paramView = r.PK();
        paramView.iY(paramAdapterView.bOa);
        paramAdapterView.status = 1;
        paramView.b(paramAdapterView);
      }
      break;
    }
    while (!SettingsSelectBgUI.c(this.nVW))
    {
      this.nVW.setResult(-1);
      this.nVW.finish();
      return;
      if (SettingsSelectBgUI.d(this.nVW) == null)
      {
        SettingsSelectBgUI.a(this.nVW, new j(paramAdapterView.id, 1));
        g.Dk().a(SettingsSelectBgUI.d(this.nVW), 0);
        return;
      }
      SettingsSelectBgUI.e(this.nVW).add(new j(paramAdapterView.id, 1));
      return;
      if ((SettingsSelectBgUI.d(this.nVW) != null) && (SettingsSelectBgUI.d(this.nVW).ewN == paramAdapterView.id))
      {
        g.Dk().c(SettingsSelectBgUI.d(this.nVW));
        r.PK().bt(SettingsSelectBgUI.d(this.nVW).ewN, 1);
        SettingsSelectBgUI.a(this.nVW, SettingsSelectBgUI.e(this.nVW));
      }
      SettingsSelectBgUI.g(paramAdapterView.id, SettingsSelectBgUI.e(this.nVW));
      paramView = r.PK();
      paramAdapterView.status = 4;
      paramView.b(paramAdapterView);
      new SettingsSelectBgUI.3.1(this, paramView, paramAdapterView.id).sendEmptyMessageDelayed(0, 1000L);
      return;
      r.PK().bt(paramAdapterView.id, 1);
      return;
      SettingsSelectBgUI.b(this.nVW).yc();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSelectBgUI.3
 * JD-Core Version:    0.7.0.1
 */