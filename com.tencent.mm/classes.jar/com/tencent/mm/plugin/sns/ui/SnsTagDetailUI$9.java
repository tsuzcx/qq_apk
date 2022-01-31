package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class SnsTagDetailUI$9
  implements ContactListExpandPreference.a
{
  SnsTagDetailUI$9(SnsTagDetailUI paramSnsTagDetailUI) {}
  
  public final void gh(int paramInt)
  {
    String str = this.pdQ.dnv.Ed(paramInt);
    y.d("MicroMsg.SnsTagDetailUI", "roomPref del " + paramInt + " userName : " + str);
    g.DQ();
    if (bk.aM((String)g.DP().Dz().get(2, null), "").equals(str))
    {
      h.h(this.pdQ.mController.uMN, i.j.room_delete_self_tip, i.j.app_tip);
      return;
    }
    this.pdQ.eR(str);
    if (((this.pdQ.pdN + " " + bk.c(this.pdQ.iSZ, ",")).equals(this.pdQ.bIW)) && (this.pdQ.oqH != 0L))
    {
      this.pdQ.enableOptionMenu(false);
      return;
    }
    this.pdQ.enableOptionMenu(true);
  }
  
  public final void gi(int paramInt)
  {
    String str = this.pdQ.dnv.Ed(paramInt);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", str);
    a.eUR.d(localIntent, this.pdQ);
  }
  
  public final void gj(int paramInt)
  {
    y.d("MicroMsg.SnsTagDetailUI", "roomPref add " + paramInt);
    SnsTagDetailUI.a(this.pdQ);
  }
  
  public final void xy()
  {
    if (this.pdQ.dnv != null) {
      this.pdQ.dnv.cmP();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTagDetailUI.9
 * JD-Core Version:    0.7.0.1
 */