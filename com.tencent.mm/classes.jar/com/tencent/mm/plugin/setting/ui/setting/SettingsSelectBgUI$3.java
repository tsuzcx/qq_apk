package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.ba.j;
import com.tencent.mm.ba.m;
import com.tencent.mm.ba.n;
import com.tencent.mm.ba.r;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.List;

final class SettingsSelectBgUI$3
  implements AdapterView.OnItemClickListener
{
  SettingsSelectBgUI$3(SettingsSelectBgUI paramSettingsSelectBgUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, final View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(127473);
    if (paramInt == 0)
    {
      SettingsSelectBgUI.a(this.qKf, -2);
      SettingsSelectBgUI.b(this.qKf).Ku();
      if (!SettingsSelectBgUI.c(this.qKf))
      {
        this.qKf.setResult(-1);
        this.qKf.finish();
      }
      AppMethodBeat.o(127473);
      return;
    }
    if (paramInt == 1)
    {
      SettingsSelectBgUI.a(this.qKf, 0);
      SettingsSelectBgUI.b(this.qKf).Ku();
      if (!SettingsSelectBgUI.c(this.qKf))
      {
        this.qKf.setResult(-1);
        this.qKf.finish();
      }
      AppMethodBeat.o(127473);
      return;
    }
    if (!g.RL().isSDCardAvailable())
    {
      Toast.makeText(this.qKf, 2131303417, 1).show();
      AppMethodBeat.o(127473);
      return;
    }
    paramAdapterView = (m)paramAdapterView.getItemAtPosition(paramInt - 2);
    if (paramAdapterView == null)
    {
      ab.e("MicroMsg.SettingsSelectBgUI", "onItemClick fail, info is null, position = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(127473);
      return;
    }
    switch (paramAdapterView.status)
    {
    }
    label537:
    for (;;)
    {
      AppMethodBeat.o(127473);
      return;
      if (SettingsSelectBgUI.d(this.qKf) == null)
      {
        SettingsSelectBgUI.a(this.qKf, new j(paramAdapterView.id, 1));
        g.Rc().a(SettingsSelectBgUI.d(this.qKf), 0);
        AppMethodBeat.o(127473);
        return;
      }
      SettingsSelectBgUI.e(this.qKf).add(new j(paramAdapterView.id, 1));
      AppMethodBeat.o(127473);
      return;
      if ((SettingsSelectBgUI.d(this.qKf) != null) && (SettingsSelectBgUI.d(this.qKf).fMD == paramAdapterView.id))
      {
        g.Rc().a(SettingsSelectBgUI.d(this.qKf));
        r.aiP().cD(SettingsSelectBgUI.d(this.qKf).fMD, 1);
        SettingsSelectBgUI.a(this.qKf, SettingsSelectBgUI.e(this.qKf));
      }
      SettingsSelectBgUI.h(paramAdapterView.id, SettingsSelectBgUI.e(this.qKf));
      paramView = r.aiP();
      paramAdapterView.status = 4;
      paramView.b(paramAdapterView);
      new ak()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(127472);
          paramView.cD(this.qKh, 1);
          AppMethodBeat.o(127472);
        }
      }.sendEmptyMessageDelayed(0, 1000L);
      AppMethodBeat.o(127473);
      return;
      r.aiP().cD(paramAdapterView.id, 1);
      AppMethodBeat.o(127473);
      return;
      SettingsSelectBgUI.a(this.qKf, paramAdapterView.id);
      if (SettingsSelectBgUI.c(this.qKf))
      {
        paramAdapterView.status = 1;
        paramView = r.aiP();
        paramView.lQ(paramAdapterView.cvs);
        paramAdapterView.status = 1;
        paramView.b(paramAdapterView);
      }
      for (;;)
      {
        if (SettingsSelectBgUI.c(this.qKf)) {
          break label537;
        }
        this.qKf.setResult(-1);
        this.qKf.finish();
        break;
        SettingsSelectBgUI.b(this.qKf).Ku();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSelectBgUI.3
 * JD-Core Version:    0.7.0.1
 */