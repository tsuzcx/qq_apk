package com.tencent.mm.plugin.profile;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.a.au.a;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;

final class a$6$1
  implements Runnable
{
  a$6$1(a.6 param6, au paramau) {}
  
  public final void run()
  {
    AppMethodBeat.i(23209);
    final String str1 = this.pxt.cof.cog;
    this.pxu.pxs.jpX.getIntent().putExtra("inviteer", str1);
    String str2 = a.b(this.pxu.pxs.efi, this.pxt.cof.cog);
    ab.i("MicroMsg.NewContactWidgetNormal", "[ChatroomMemberInviterUpdatedEvent callback] inviter:%s inviterDisplayName:%s", new Object[] { str1, str2 });
    if (bo.isNullOrNil(str2))
    {
      ao.a.flI.a(str1, "", new ao.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(23208);
          ab.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, a.6.1.this.pxu.pxs.egF, Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            aw.aaz();
            paramAnonymousString = c.YA().arw(paramAnonymousString).Oe();
            a.a(a.6.1.this.pxu.pxs.iLA, a.6.1.this.pxu.pxs.jpX, str1, paramAnonymousString);
          }
          AppMethodBeat.o(23208);
        }
      });
      AppMethodBeat.o(23209);
      return;
    }
    a.a(this.pxu.pxs.iLA, this.pxu.pxs.jpX, str1, str2);
    AppMethodBeat.o(23209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.6.1
 * JD-Core Version:    0.7.0.1
 */