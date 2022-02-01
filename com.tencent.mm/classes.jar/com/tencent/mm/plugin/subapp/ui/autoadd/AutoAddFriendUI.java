package com.tencent.mm.plugin.subapp.ui.autoadd;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class AutoAddFriendUI
  extends MMActivity
{
  private MMSwitchBtn Meo;
  private TextView Mep;
  private MMSwitchBtn Meq;
  private SparseIntArray Mer;
  private int status;
  
  public AutoAddFriendUI()
  {
    AppMethodBeat.i(29009);
    this.Meo = null;
    this.Mep = null;
    this.Meq = null;
    this.Mer = new SparseIntArray();
    AppMethodBeat.o(29009);
  }
  
  private boolean abt(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  private boolean ghI()
  {
    AppMethodBeat.i(29011);
    bh.beI();
    c.aHp().i(7, Integer.valueOf(this.status));
    int i = 0;
    while (i < this.Mer.size())
    {
      int j = this.Mer.keyAt(i);
      int k = this.Mer.valueAt(i);
      bmy localbmy = new bmy();
      localbmy.SXP = j;
      localbmy.HmX = k;
      bh.beI();
      c.bbK().d(new k.a(23, localbmy));
      Log.d("MicroMsg.AutoAddFriendUI", "switch  " + j + " " + k);
      i += 1;
    }
    this.Mer.clear();
    AppMethodBeat.o(29011);
    return true;
  }
  
  private static int ghJ()
  {
    AppMethodBeat.i(29013);
    String str2 = h.axc().getValue("AutoAddFriendShow");
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
    return R.i.ebN;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29012);
    this.Meo = ((MMSwitchBtn)findViewById(R.h.dNm));
    this.Mep = ((TextView)findViewById(R.h.dsb));
    this.Meq = ((MMSwitchBtn)findViewById(R.h.dsa));
    boolean bool = abt(32);
    this.Meo.setCheck(bool);
    if (ghJ() == 1)
    {
      this.Meq.setCheck(abt(2097152));
      this.Meq.setSwitchListener(new MMSwitchBtn.a()
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
      this.Meo.setSwitchListener(new MMSwitchBtn.a()
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
      this.Mep.setVisibility(8);
      this.Meq.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29010);
    super.onCreate(paramBundle);
    setMMTitle(R.l.epi);
    this.status = z.bdd();
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
    ghI();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.autoadd.AutoAddFriendUI
 * JD-Core Version:    0.7.0.1
 */