package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;

final class SnsTagDetailUI$9
  implements ContactListExpandPreference.a
{
  SnsTagDetailUI$9(SnsTagDetailUI paramSnsTagDetailUI) {}
  
  public final void JR()
  {
    AppMethodBeat.i(39355);
    if (this.rWD.eeU != null) {
      this.rWD.eeU.dnF();
    }
    AppMethodBeat.o(39355);
  }
  
  public final void iw(int paramInt)
  {
    AppMethodBeat.i(39352);
    String str = this.rWD.eeU.Mb(paramInt);
    ab.d("MicroMsg.SnsTagDetailUI", "roomPref del " + paramInt + " userName : " + str);
    g.RM();
    if (bo.bf((String)g.RL().Ru().get(2, null), "").equals(str))
    {
      h.h(this.rWD.getContext(), 2131302702, 2131297087);
      AppMethodBeat.o(39352);
      return;
    }
    this.rWD.lc(str);
    if (((this.rWD.rWA + " " + bo.d(this.rWD.lbK, ",")).equals(this.rWD.cqq)) && (this.rWD.rfr != 0L))
    {
      this.rWD.enableOptionMenu(false);
      AppMethodBeat.o(39352);
      return;
    }
    this.rWD.enableOptionMenu(true);
    AppMethodBeat.o(39352);
  }
  
  public final void ix(int paramInt)
  {
    AppMethodBeat.i(39354);
    String str = this.rWD.eeU.Mb(paramInt);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", str);
    if (this.rWD.rfr == 4L) {
      localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 18);
    }
    for (;;)
    {
      a.gmO.c(localIntent, this.rWD);
      AppMethodBeat.o(39354);
      return;
      if (this.rWD.rfr == 5L) {
        localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 19);
      }
    }
  }
  
  public final void iy(int paramInt)
  {
    AppMethodBeat.i(39353);
    ab.d("MicroMsg.SnsTagDetailUI", "roomPref add ".concat(String.valueOf(paramInt)));
    SnsTagDetailUI.a(this.rWD);
    AppMethodBeat.o(39353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTagDetailUI.9
 * JD-Core Version:    0.7.0.1
 */