package com.tencent.mm.ui.chatting.viewitems;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;

final class am$4$1$1
  implements f
{
  am$4$1$1(am.4.1 param1) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramInt1 + " errCode " + paramInt2 + "  scene " + paramm.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.vGI.vGH.vGC.field_content;
      if (paramString == null) {
        break label232;
      }
    }
    label232:
    for (paramString = g.a.gp(paramString);; paramString = null)
    {
      if (paramString != null) {
        l.ha(this.vGI.vGH.vGC.field_msgId);
      }
      bd.bC(this.vGI.vGH.vGC.field_msgId);
      Toast.makeText(am.a(this.vGI.vGH.vGE).vtz.getContext(), am.a(this.vGI.vGH.vGE).vtz.getMMResources().getString(R.l.chatting_item_voice_reminder_del_succ), 0).show();
      au.Dk().b(331, am.b(this.vGI.vGH.vGE));
      am.a(this.vGI.vGH.vGE, null);
      if (am.c(this.vGI.vGH.vGE) != null) {
        am.c(this.vGI.vGH.vGE).dismiss();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.4.1.1
 * JD-Core Version:    0.7.0.1
 */