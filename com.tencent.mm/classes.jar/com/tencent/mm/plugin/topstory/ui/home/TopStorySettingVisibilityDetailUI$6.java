package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;

final class TopStorySettingVisibilityDetailUI$6
  implements ContactListExpandPreference.a
{
  TopStorySettingVisibilityDetailUI$6(TopStorySettingVisibilityDetailUI paramTopStorySettingVisibilityDetailUI) {}
  
  public final void JR()
  {
    AppMethodBeat.i(1643);
    if (this.thh.eeU != null) {
      this.thh.eeU.dnF();
    }
    AppMethodBeat.o(1643);
  }
  
  public final void iw(int paramInt)
  {
    AppMethodBeat.i(1640);
    String str = this.thh.eeU.Mb(paramInt);
    ab.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "roomPref del " + paramInt + " userName : " + str);
    g.RM();
    if (bo.bf((String)g.RL().Ru().get(2, null), "").equals(str))
    {
      h.b(this.thh.getContext(), this.thh.getString(2131302702), "", true);
      AppMethodBeat.o(1640);
      return;
    }
    this.thh.lc(str);
    if (((this.thh.rWA + " " + bo.d(this.thh.lbK, ",")).equals(this.thh.cqq)) && (this.thh.rfr != 0L))
    {
      this.thh.enableOptionMenu(false);
      AppMethodBeat.o(1640);
      return;
    }
    this.thh.enableOptionMenu(true);
    AppMethodBeat.o(1640);
  }
  
  public final void ix(int paramInt)
  {
    AppMethodBeat.i(1642);
    String str = this.thh.eeU.Mb(paramInt);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", str);
    d.b(this.thh, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(1642);
  }
  
  public final void iy(int paramInt)
  {
    AppMethodBeat.i(1641);
    ab.d("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "roomPref add ".concat(String.valueOf(paramInt)));
    TopStorySettingVisibilityDetailUI.c(this.thh);
    AppMethodBeat.o(1641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI.6
 * JD-Core Version:    0.7.0.1
 */