package com.tencent.mm.plugin.subapp.ui.autoadd;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.protocal.protobuf.aqc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class AutoAddFriendUI
  extends MMActivity
{
  private int status;
  private MMSwitchBtn zQG;
  private TextView zQH;
  private MMSwitchBtn zQI;
  private SparseIntArray zQJ;
  
  public AutoAddFriendUI()
  {
    AppMethodBeat.i(29009);
    this.zQG = null;
    this.zQH = null;
    this.zQI = null;
    this.zQJ = new SparseIntArray();
    AppMethodBeat.o(29009);
  }
  
  private boolean Lr(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  private boolean eaL()
  {
    AppMethodBeat.i(29011);
    az.ayM();
    c.agA().set(7, Integer.valueOf(this.status));
    int i = 0;
    while (i < this.zQJ.size())
    {
      int j = this.zQJ.keyAt(i);
      int k = this.zQJ.valueAt(i);
      aqc localaqc = new aqc();
      localaqc.EIY = j;
      localaqc.vVH = k;
      az.ayM();
      c.awA().c(new j.a(23, localaqc));
      ac.d("MicroMsg.AutoAddFriendUI", "switch  " + j + " " + k);
      i += 1;
    }
    this.zQJ.clear();
    AppMethodBeat.o(29011);
    return true;
  }
  
  private static int eaM()
  {
    AppMethodBeat.i(29013);
    String str2 = g.ZY().getValue("AutoAddFriendShow");
    String str1 = str2;
    if (bs.isNullOrNil(str2)) {
      str1 = "0";
    }
    try
    {
      i = bs.getInt(str1, 0);
      ac.d("MicroMsg.AutoAddFriendUI", "getAutoAddDynamicConfig, autoAdd = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(29013);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131493122;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29012);
    this.zQG = ((MMSwitchBtn)findViewById(2131302705));
    this.zQH = ((TextView)findViewById(2131296990));
    this.zQI = ((MMSwitchBtn)findViewById(2131296989));
    boolean bool = Lr(32);
    this.zQG.setCheck(bool);
    if (eaM() == 1)
    {
      this.zQI.setCheck(Lr(2097152));
      this.zQI.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(29006);
          AutoAddFriendUI.a(AutoAddFriendUI.this, paramAnonymousBoolean, 2097152, 32);
          AppMethodBeat.o(29006);
        }
      });
    }
    for (;;)
    {
      this.zQG.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(29007);
          AutoAddFriendUI.a(AutoAddFriendUI.this, paramAnonymousBoolean, 32, 4);
          AppMethodBeat.o(29007);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(29008);
          AutoAddFriendUI.this.finish();
          AppMethodBeat.o(29008);
          return true;
        }
      });
      AppMethodBeat.o(29012);
      return;
      this.zQH.setVisibility(8);
      this.zQI.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29010);
    super.onCreate(paramBundle);
    setMMTitle(2131756085);
    this.status = u.axA();
    initView();
    AppMethodBeat.o(29010);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29016);
    super.onDestroy();
    AppMethodBeat.o(29016);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29015);
    super.onPause();
    eaL();
    AppMethodBeat.o(29015);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29014);
    super.onResume();
    AppMethodBeat.o(29014);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.autoadd.AutoAddFriendUI
 * JD-Core Version:    0.7.0.1
 */