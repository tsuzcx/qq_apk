package com.tencent.mm.plugin.voip.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.voip.a.e;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.h.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class InviteRemindDialog$1
  implements View.OnClickListener
{
  InviteRemindDialog$1(InviteRemindDialog paramInviteRemindDialog) {}
  
  public final void onClick(View paramView)
  {
    h.a locala;
    if (InviteRemindDialog.a(this.pWq) != null) {
      try
      {
        paramView = h.a.PY((String)com.tencent.mm.kernel.g.DP().Dz().get(77829, null));
        if (paramView == null) {
          break label359;
        }
        if ((paramView != null) && (paramView.size() > 0))
        {
          if (!paramView.containsKey(InviteRemindDialog.a(this.pWq))) {
            break label323;
          }
          locala = (h.a)paramView.get(InviteRemindDialog.a(this.pWq));
          locala.ewK += 1;
          paramView.put(InviteRemindDialog.a(this.pWq), locala);
        }
        com.tencent.mm.kernel.g.DP().Dz().o(77829, h.a.N(paramView));
        paramView = paramView.entrySet().iterator();
        while (paramView.hasNext())
        {
          locala = (h.a)((Map.Entry)paramView.next()).getValue();
          y.d("MMInviteRemindDialog", "val " + locala.hitCount + " " + locala.ewK);
        }
        if (InviteRemindDialog.b(this.pWq) != 0) {
          break label493;
        }
      }
      catch (Exception paramView)
      {
        y.printErrStackTrace("MMInviteRemindDialog", paramView, "", new Object[0]);
      }
    } else {
      label210:
      paramView = this.pWq.getString(a.e.voip_invite_msg_text);
    }
    for (;;)
    {
      paramView = new com.tencent.mm.plugin.voip.model.g(InviteRemindDialog.a(this.pWq), paramView, s.hW(InviteRemindDialog.a(this.pWq)));
      com.tencent.mm.kernel.g.Dk().a(paramView, 0);
      paramView = new Intent();
      paramView.addFlags(536870912);
      paramView.addFlags(67108864);
      paramView.putExtra("Chat_User", InviteRemindDialog.a(this.pWq));
      c.eUR.e(paramView, this.pWq);
      this.pWq.finish();
      return;
      label323:
      locala = new h.a();
      locala.ewK += 1;
      paramView.put(InviteRemindDialog.a(this.pWq), locala);
      break;
      label359:
      paramView = new HashMap();
      locala = new h.a();
      locala.ewK += 1;
      paramView.put(InviteRemindDialog.a(this.pWq), locala);
      com.tencent.mm.kernel.g.DP().Dz().o(77829, h.a.N(paramView));
      paramView = paramView.entrySet().iterator();
      while (paramView.hasNext())
      {
        locala = (h.a)((Map.Entry)paramView.next()).getValue();
        y.d("MMInviteRemindDialog", "val " + locala.hitCount + " " + locala.ewK);
      }
      break label210;
      label493:
      if (InviteRemindDialog.b(this.pWq) == 1) {
        paramView = this.pWq.getString(a.e.voip_voice_invite_msg_text);
      } else {
        paramView = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.InviteRemindDialog.1
 * JD-Core Version:    0.7.0.1
 */