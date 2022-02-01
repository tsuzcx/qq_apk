package com.tencent.mm.plugin.profile;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.bh.a;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

final class a$7$1
  implements Runnable
{
  a$7$1(a.7 param7, com.tencent.mm.f.a.bh parambh) {}
  
  public final void run()
  {
    AppMethodBeat.i(293366);
    final String str1 = this.OdC.fxa.fxb;
    this.OdD.GWs.tmY.getIntent().putExtra("inviteer", str1);
    String str2 = a.b(this.OdD.GWs.iXp, this.OdC.fxa.fxb);
    Log.i("MicroMsg.NewContactWidgetNormal", "[ChatroomMemberInviterUpdatedEvent callback] inviter:%s inviterDisplayName:%s", new Object[] { str1, str2 });
    if (Util.isNullOrNil(str2))
    {
      this.OdD.GWs.GWn.add(str1);
      az.a.ltq.a(str1, "", new az.b.a()
      {
        public final void s(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(293219);
          Log.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, a.7.1.this.OdD.GWs.jaK, Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            com.tencent.mm.model.bh.beI();
            paramAnonymousString = c.bbL().RG(paramAnonymousString).ayr();
            a.a(a.7.1.this.OdD.GWs.mrf, a.7.1.this.OdD.GWs.tmY, str1, paramAnonymousString);
          }
          AppMethodBeat.o(293219);
        }
      });
      AppMethodBeat.o(293366);
      return;
    }
    a.a(this.OdD.GWs.mrf, this.OdD.GWs.tmY, str1, str2);
    AppMethodBeat.o(293366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.7.1
 * JD-Core Version:    0.7.0.1
 */