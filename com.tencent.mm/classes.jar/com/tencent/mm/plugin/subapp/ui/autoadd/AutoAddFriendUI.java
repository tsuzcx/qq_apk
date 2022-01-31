package com.tencent.mm.plugin.subapp.ui.autoadd;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class AutoAddFriendUI
  extends MMActivity
{
  private MMSwitchBtn sXF;
  private TextView sXG;
  private MMSwitchBtn sXH;
  private SparseIntArray sXI;
  private int status;
  
  public AutoAddFriendUI()
  {
    AppMethodBeat.i(25332);
    this.sXF = null;
    this.sXG = null;
    this.sXH = null;
    this.sXI = new SparseIntArray();
    AppMethodBeat.o(25332);
  }
  
  private boolean BF(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  private boolean cGV()
  {
    AppMethodBeat.i(25334);
    aw.aaz();
    c.Ru().set(7, Integer.valueOf(this.status));
    int i = 0;
    while (i < this.sXI.size())
    {
      int j = this.sXI.keyAt(i);
      int k = this.sXI.valueAt(i);
      aek localaek = new aek();
      localaek.wXn = j;
      localaek.pKC = k;
      aw.aaz();
      c.Yz().c(new j.a(23, localaek));
      ab.d("MicroMsg.AutoAddFriendUI", "switch  " + j + " " + k);
      i += 1;
    }
    this.sXI.clear();
    AppMethodBeat.o(25334);
    return true;
  }
  
  private static int cGW()
  {
    AppMethodBeat.i(25336);
    String str2 = g.Nq().getValue("AutoAddFriendShow");
    String str1 = str2;
    if (bo.isNullOrNil(str2)) {
      str1 = "0";
    }
    try
    {
      i = bo.getInt(str1, 0);
      ab.d("MicroMsg.AutoAddFriendUI", "getAutoAddDynamicConfig, autoAdd = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(25336);
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
    return 2130968793;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25335);
    this.sXF = ((MMSwitchBtn)findViewById(2131821589));
    this.sXG = ((TextView)findViewById(2131821590));
    this.sXH = ((MMSwitchBtn)findViewById(2131821591));
    boolean bool = BF(32);
    this.sXF.setCheck(bool);
    if (cGW() == 1)
    {
      this.sXH.setCheck(BF(2097152));
      this.sXH.setSwitchListener(new AutoAddFriendUI.1(this));
    }
    for (;;)
    {
      this.sXF.setSwitchListener(new AutoAddFriendUI.2(this));
      setBackBtn(new AutoAddFriendUI.3(this));
      AppMethodBeat.o(25335);
      return;
      this.sXG.setVisibility(8);
      this.sXH.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25333);
    super.onCreate(paramBundle);
    setMMTitle(2131297215);
    this.status = r.Zr();
    initView();
    AppMethodBeat.o(25333);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25339);
    super.onDestroy();
    AppMethodBeat.o(25339);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(25338);
    super.onPause();
    cGV();
    AppMethodBeat.o(25338);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25337);
    super.onResume();
    AppMethodBeat.o(25337);
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