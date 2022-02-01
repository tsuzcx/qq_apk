package com.tencent.mm.plugin.subapp.ui.autoadd;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class AutoAddFriendUI
  extends MMActivity
{
  private MMSwitchBtn FKr;
  private TextView FKs;
  private MMSwitchBtn FKt;
  private SparseIntArray FKu;
  private int status;
  
  public AutoAddFriendUI()
  {
    AppMethodBeat.i(29009);
    this.FKr = null;
    this.FKs = null;
    this.FKt = null;
    this.FKu = new SparseIntArray();
    AppMethodBeat.o(29009);
  }
  
  private boolean UM(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  private boolean ftj()
  {
    AppMethodBeat.i(29011);
    bg.aVF();
    c.azQ().set(7, Integer.valueOf(this.status));
    int i = 0;
    while (i < this.FKu.size())
    {
      int j = this.FKu.keyAt(i);
      int k = this.FKu.valueAt(i);
      bfx localbfx = new bfx();
      localbfx.LPB = j;
      localbfx.BsD = k;
      bg.aVF();
      c.aSM().d(new k.a(23, localbfx));
      Log.d("MicroMsg.AutoAddFriendUI", "switch  " + j + " " + k);
      i += 1;
    }
    this.FKu.clear();
    AppMethodBeat.o(29011);
    return true;
  }
  
  private static int ftk()
  {
    AppMethodBeat.i(29013);
    String str2 = h.aqJ().getValue("AutoAddFriendShow");
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = "0";
    }
    try
    {
      i = Util.getInt(str1, 0);
      Log.d("MicroMsg.AutoAddFriendUI", "getAutoAddDynamicConfig, autoAdd = %d", new Object[] { Integer.valueOf(i) });
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
    return 2131493164;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29012);
    this.FKr = ((MMSwitchBtn)findViewById(2131305268));
    this.FKs = ((TextView)findViewById(2131297108));
    this.FKt = ((MMSwitchBtn)findViewById(2131297107));
    boolean bool = UM(32);
    this.FKr.setCheck(bool);
    if (ftk() == 1)
    {
      this.FKt.setCheck(UM(2097152));
      this.FKt.setSwitchListener(new MMSwitchBtn.a()
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
      this.FKr.setSwitchListener(new MMSwitchBtn.a()
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
      this.FKs.setVisibility(8);
      this.FKt.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29010);
    super.onCreate(paramBundle);
    setMMTitle(2131756216);
    this.status = z.aUc();
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
    ftj();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.autoadd.AutoAddFriendUI
 * JD-Core Version:    0.7.0.1
 */