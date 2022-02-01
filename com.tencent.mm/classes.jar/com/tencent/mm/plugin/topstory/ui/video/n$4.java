package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.s;

final class n$4
  implements az.b.a
{
  n$4(s params, boolean[] paramArrayOfBoolean, esy paramesy, Context paramContext) {}
  
  public final void s(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(205902);
    this.NaD.dismiss();
    Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "jumpToProfile getNow:%s, isCancel:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.NaC[0]) });
    if (this.NaC[0] != 0)
    {
      AppMethodBeat.o(205902);
      return;
    }
    if (paramBoolean)
    {
      paramString = new Intent();
      paramString.putExtra("Contact_User", this.MZV.fvZ);
      paramString.putExtra("biz_profile_tab_type", 1);
      c.b(this.val$context, "profile", ".ui.ContactInfoUI", paramString);
    }
    AppMethodBeat.o(205902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.n.4
 * JD-Core Version:    0.7.0.1
 */