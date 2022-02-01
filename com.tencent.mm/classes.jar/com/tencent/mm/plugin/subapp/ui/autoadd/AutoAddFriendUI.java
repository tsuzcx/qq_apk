package com.tencent.mm.plugin.subapp.ui.autoadd;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class AutoAddFriendUI
  extends MMActivity
{
  private MMSwitchBtn SFE;
  private TextView SFF;
  private MMSwitchBtn SFG;
  private SparseIntArray SFH;
  private int status;
  
  public AutoAddFriendUI()
  {
    AppMethodBeat.i(29009);
    this.SFE = null;
    this.SFF = null;
    this.SFG = null;
    this.SFH = new SparseIntArray();
    AppMethodBeat.o(29009);
  }
  
  private boolean afN(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  private boolean hBb()
  {
    AppMethodBeat.i(29011);
    bh.bCz();
    c.ban().B(7, Integer.valueOf(this.status));
    int i = 0;
    while (i < this.SFH.size())
    {
      int j = this.SFH.keyAt(i);
      int k = this.SFH.valueAt(i);
      cas localcas = new cas();
      localcas.aajJ = j;
      localcas.NkL = k;
      bh.bCz();
      c.bzz().d(new k.a(23, localcas));
      Log.d("MicroMsg.AutoAddFriendUI", "switch  " + j + " " + k);
      i += 1;
    }
    this.SFH.clear();
    AppMethodBeat.o(29011);
    return true;
  }
  
  private static int hBc()
  {
    AppMethodBeat.i(29013);
    String str2 = i.aRC().getValue("AutoAddFriendShow");
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
    return R.i.gev;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29012);
    this.SFE = ((MMSwitchBtn)findViewById(R.h.fPn));
    this.SFF = ((TextView)findViewById(R.h.fsr));
    this.SFG = ((MMSwitchBtn)findViewById(R.h.fsq));
    boolean bool = afN(32);
    this.SFE.setCheck(bool);
    if (hBc() == 1)
    {
      this.SFG.setCheck(afN(2097152));
      this.SFG.setSwitchListener(new MMSwitchBtn.a()
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
      this.SFE.setSwitchListener(new MMSwitchBtn.a()
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
      this.SFF.setVisibility(8);
      this.SFG.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29010);
    super.onCreate(paramBundle);
    setMMTitle(R.l.gsj);
    this.status = z.bAQ();
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
    hBb();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.autoadd.AutoAddFriendUI
 * JD-Core Version:    0.7.0.1
 */