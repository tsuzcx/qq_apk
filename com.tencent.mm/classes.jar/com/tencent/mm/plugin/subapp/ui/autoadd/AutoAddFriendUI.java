package com.tencent.mm.plugin.subapp.ui.autoadd;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class AutoAddFriendUI
  extends MMActivity
{
  private MMSwitchBtn BzG;
  private TextView BzH;
  private MMSwitchBtn BzI;
  private SparseIntArray BzJ;
  private int status;
  
  public AutoAddFriendUI()
  {
    AppMethodBeat.i(29009);
    this.BzG = null;
    this.BzH = null;
    this.BzI = null;
    this.BzJ = new SparseIntArray();
    AppMethodBeat.o(29009);
  }
  
  private boolean Nz(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  private boolean eqK()
  {
    AppMethodBeat.i(29011);
    bc.aCg();
    c.ajA().set(7, Integer.valueOf(this.status));
    int i = 0;
    while (i < this.BzJ.size())
    {
      int j = this.BzJ.keyAt(i);
      int k = this.BzJ.valueAt(i);
      auo localauo = new auo();
      localauo.GLx = j;
      localauo.xsz = k;
      bc.aCg();
      c.azE().d(new k.a(23, localauo));
      ae.d("MicroMsg.AutoAddFriendUI", "switch  " + j + " " + k);
      i += 1;
    }
    this.BzJ.clear();
    AppMethodBeat.o(29011);
    return true;
  }
  
  private static int eqL()
  {
    AppMethodBeat.i(29013);
    String str2 = g.acL().getValue("AutoAddFriendShow");
    String str1 = str2;
    if (bu.isNullOrNil(str2)) {
      str1 = "0";
    }
    try
    {
      i = bu.getInt(str1, 0);
      ae.d("MicroMsg.AutoAddFriendUI", "getAutoAddDynamicConfig, autoAdd = %d", new Object[] { Integer.valueOf(i) });
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
    this.BzG = ((MMSwitchBtn)findViewById(2131302705));
    this.BzH = ((TextView)findViewById(2131296990));
    this.BzI = ((MMSwitchBtn)findViewById(2131296989));
    boolean bool = Nz(32);
    this.BzG.setCheck(bool);
    if (eqL() == 1)
    {
      this.BzI.setCheck(Nz(2097152));
      this.BzI.setSwitchListener(new MMSwitchBtn.a()
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
      this.BzG.setSwitchListener(new MMSwitchBtn.a()
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
      this.BzH.setVisibility(8);
      this.BzI.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29010);
    super.onCreate(paramBundle);
    setMMTitle(2131756085);
    this.status = v.aAG();
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
    eqK();
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