package com.tencent.mm.plugin.subapp.ui.autoadd;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class AutoAddFriendUI
  extends MMActivity
{
  private MMSwitchBtn Bii;
  private TextView Bij;
  private MMSwitchBtn Bik;
  private SparseIntArray Bil;
  private int status;
  
  public AutoAddFriendUI()
  {
    AppMethodBeat.i(29009);
    this.Bii = null;
    this.Bij = null;
    this.Bik = null;
    this.Bil = new SparseIntArray();
    AppMethodBeat.o(29009);
  }
  
  private boolean MT(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  private boolean enb()
  {
    AppMethodBeat.i(29011);
    ba.aBQ();
    c.ajl().set(7, Integer.valueOf(this.status));
    int i = 0;
    while (i < this.Bil.size())
    {
      int j = this.Bil.keyAt(i);
      int k = this.Bil.valueAt(i);
      aty localaty = new aty();
      localaty.GrZ = j;
      localaty.xcI = k;
      ba.aBQ();
      c.azo().c(new k.a(23, localaty));
      ad.d("MicroMsg.AutoAddFriendUI", "switch  " + j + " " + k);
      i += 1;
    }
    this.Bil.clear();
    AppMethodBeat.o(29011);
    return true;
  }
  
  private static int enc()
  {
    AppMethodBeat.i(29013);
    String str2 = g.acA().getValue("AutoAddFriendShow");
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
    this.Bii = ((MMSwitchBtn)findViewById(2131302705));
    this.Bij = ((TextView)findViewById(2131296990));
    this.Bik = ((MMSwitchBtn)findViewById(2131296989));
    boolean bool = MT(32);
    this.Bii.setCheck(bool);
    if (enc() == 1)
    {
      this.Bik.setCheck(MT(2097152));
      this.Bik.setSwitchListener(new MMSwitchBtn.a()
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
      this.Bii.setSwitchListener(new MMSwitchBtn.a()
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
      this.Bij.setVisibility(8);
      this.Bik.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29010);
    super.onCreate(paramBundle);
    setMMTitle(2131756085);
    this.status = u.aAq();
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
    enb();
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