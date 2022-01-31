package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import com.tencent.mm.ay.j;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;

final class m$3
  implements Runnable
{
  m$3(m paramm, boolean paramBoolean, ProgressDialog paramProgressDialog) {}
  
  public final void run()
  {
    boolean bool = this.hZO;
    String str;
    int i;
    if (bool)
    {
      str = "3";
      bt.o(6, str);
      i = q.Gu();
      if (!bool) {
        break label133;
      }
      i &= 0xFFFFFF7F;
    }
    for (;;)
    {
      au.Hx();
      c.Dz().o(34, Integer.valueOf(i));
      au.Hx();
      c.Fv().b(new j("", "", "", "", "", "", "", "", i, "", ""));
      if (!this.hZO)
      {
        bd.iL("qqsync");
        au.Hx();
        c.FB().abu("qqsync");
      }
      ai.d(new m.3.1(this));
      return;
      str = "4";
      break;
      label133:
      i |= 0x80;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.m.3
 * JD-Core Version:    0.7.0.1
 */