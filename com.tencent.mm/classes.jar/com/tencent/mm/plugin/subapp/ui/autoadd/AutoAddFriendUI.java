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
import com.tencent.mm.protocal.protobuf.amy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class AutoAddFriendUI
  extends MMActivity
{
  private int status;
  private MMSwitchBtn yDs;
  private TextView yDt;
  private MMSwitchBtn yDu;
  private SparseIntArray yDv;
  
  public AutoAddFriendUI()
  {
    AppMethodBeat.i(29009);
    this.yDs = null;
    this.yDt = null;
    this.yDu = null;
    this.yDv = new SparseIntArray();
    AppMethodBeat.o(29009);
  }
  
  private boolean Js(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  private boolean dMl()
  {
    AppMethodBeat.i(29011);
    az.arV();
    c.afk().set(7, Integer.valueOf(this.status));
    int i = 0;
    while (i < this.yDv.size())
    {
      int j = this.yDv.keyAt(i);
      int k = this.yDv.valueAt(i);
      amy localamy = new amy();
      localamy.DnY = j;
      localamy.uMR = k;
      az.arV();
      c.apL().c(new j.a(23, localamy));
      ad.d("MicroMsg.AutoAddFriendUI", "switch  " + j + " " + k);
      i += 1;
    }
    this.yDv.clear();
    AppMethodBeat.o(29011);
    return true;
  }
  
  private static int dMm()
  {
    AppMethodBeat.i(29013);
    String str2 = g.Zd().getValue("AutoAddFriendShow");
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = "0";
    }
    try
    {
      i = bt.getInt(str1, 0);
      ad.d("MicroMsg.AutoAddFriendUI", "getAutoAddDynamicConfig, autoAdd = %d", new Object[] { Integer.valueOf(i) });
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
    this.yDs = ((MMSwitchBtn)findViewById(2131302705));
    this.yDt = ((TextView)findViewById(2131296990));
    this.yDu = ((MMSwitchBtn)findViewById(2131296989));
    boolean bool = Js(32);
    this.yDs.setCheck(bool);
    if (dMm() == 1)
    {
      this.yDu.setCheck(Js(2097152));
      this.yDu.setSwitchListener(new MMSwitchBtn.a()
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
      this.yDs.setSwitchListener(new MMSwitchBtn.a()
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
      this.yDt.setVisibility(8);
      this.yDu.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29010);
    super.onCreate(paramBundle);
    setMMTitle(2131756085);
    this.status = u.aqK();
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
    dMl();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.autoadd.AutoAddFriendUI
 * JD-Core Version:    0.7.0.1
 */