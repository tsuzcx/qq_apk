package com.tencent.mm.plugin.subapp.ui.autoadd;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class AutoAddFriendUI
  extends MMActivity
{
  private MMSwitchBtn pvZ = null;
  private TextView pwa = null;
  private MMSwitchBtn pwb = null;
  private SparseIntArray pwc = new SparseIntArray();
  private int status;
  
  private static int bLZ()
  {
    String str2 = g.AA().getValue("AutoAddFriendShow");
    String str1 = str2;
    if (bk.bl(str2)) {
      str1 = "0";
    }
    try
    {
      i = bk.getInt(str1, 0);
      y.d("MicroMsg.AutoAddFriendUI", "getAutoAddDynamicConfig, autoAdd = %d", new Object[] { Integer.valueOf(i) });
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
  
  private boolean wb(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  protected final int getLayoutId()
  {
    return R.i.auto_add_friend;
  }
  
  protected final void initView()
  {
    this.pvZ = ((MMSwitchBtn)findViewById(R.h.need_to_verify));
    this.pwa = ((TextView)findViewById(R.h.auto_add_contact_text));
    this.pwb = ((MMSwitchBtn)findViewById(R.h.auto_add_contact));
    boolean bool = wb(32);
    this.pvZ.setCheck(bool);
    if (bLZ() == 1)
    {
      this.pwb.setCheck(wb(2097152));
      this.pwb.setSwitchListener(new AutoAddFriendUI.1(this));
    }
    for (;;)
    {
      this.pvZ.setSwitchListener(new AutoAddFriendUI.2(this));
      setBackBtn(new AutoAddFriendUI.3(this));
      return;
      this.pwa.setVisibility(8);
      this.pwb.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(R.l.auto_add_friend_title);
    this.status = q.Gn();
    initView();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    au.Hx();
    c.Dz().o(7, Integer.valueOf(this.status));
    int i = 0;
    while (i < this.pwc.size())
    {
      int j = this.pwc.keyAt(i);
      int k = this.pwc.valueAt(i);
      zr localzr = new zr();
      localzr.sYS = j;
      localzr.nfn = k;
      au.Hx();
      c.Fv().b(new i.a(23, localzr));
      y.d("MicroMsg.AutoAddFriendUI", "switch  " + j + " " + k);
      i += 1;
    }
    this.pwc.clear();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.autoadd.AutoAddFriendUI
 * JD-Core Version:    0.7.0.1
 */