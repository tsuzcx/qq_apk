package com.tencent.mm.plugin.voip.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.h;
import com.tencent.mm.plugin.voip.model.i.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(4770);
    i.a locala;
    if (InviteRemindDialog.a(this.tBT) != null) {
      try
      {
        paramView = i.a.aeE((String)g.RL().Ru().get(77829, null));
        if (paramView == null) {
          break label370;
        }
        if ((paramView != null) && (paramView.size() > 0))
        {
          if (!paramView.containsKey(InviteRemindDialog.a(this.tBT))) {
            break label334;
          }
          locala = (i.a)paramView.get(InviteRemindDialog.a(this.tBT));
          locala.fMA += 1;
          paramView.put(InviteRemindDialog.a(this.tBT), locala);
        }
        g.RL().Ru().set(77829, i.a.ah(paramView));
        paramView = paramView.entrySet().iterator();
        while (paramView.hasNext())
        {
          locala = (i.a)((Map.Entry)paramView.next()).getValue();
          ab.d("MMInviteRemindDialog", "val " + locala.hitCount + " " + locala.fMA);
        }
        if (InviteRemindDialog.b(this.tBT) != 0) {
          break label504;
        }
      }
      catch (Exception paramView)
      {
        ab.printErrStackTrace("MMInviteRemindDialog", paramView, "", new Object[0]);
      }
    } else {
      label216:
      paramView = this.tBT.getString(2131304696);
    }
    for (;;)
    {
      paramView = new h(InviteRemindDialog.a(this.tBT), paramView, t.oF(InviteRemindDialog.a(this.tBT)));
      g.Rc().a(paramView, 0);
      paramView = new Intent();
      paramView.addFlags(536870912);
      paramView.addFlags(67108864);
      paramView.putExtra("Chat_User", InviteRemindDialog.a(this.tBT));
      c.gmO.d(paramView, this.tBT);
      this.tBT.finish();
      AppMethodBeat.o(4770);
      return;
      label334:
      locala = new i.a();
      locala.fMA += 1;
      paramView.put(InviteRemindDialog.a(this.tBT), locala);
      break;
      label370:
      paramView = new HashMap();
      locala = new i.a();
      locala.fMA += 1;
      paramView.put(InviteRemindDialog.a(this.tBT), locala);
      g.RL().Ru().set(77829, i.a.ah(paramView));
      paramView = paramView.entrySet().iterator();
      while (paramView.hasNext())
      {
        locala = (i.a)((Map.Entry)paramView.next()).getValue();
        ab.d("MMInviteRemindDialog", "val " + locala.hitCount + " " + locala.fMA);
      }
      break label216;
      label504:
      if (InviteRemindDialog.b(this.tBT) == 1) {
        paramView = this.tBT.getString(2131304755);
      } else {
        paramView = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.InviteRemindDialog.1
 * JD-Core Version:    0.7.0.1
 */