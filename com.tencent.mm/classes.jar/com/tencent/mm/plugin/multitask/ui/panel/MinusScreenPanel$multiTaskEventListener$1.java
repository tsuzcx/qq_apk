package com.tencent.mm.plugin.multitask.ui.panel;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.a.or;
import com.tencent.mm.autogen.a.or.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.multitask.g;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/panel/MinusScreenPanel$multiTaskEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MulitTaskEvent;", "callback", "", "event", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MinusScreenPanel$multiTaskEventListener$1
  extends IListener<or>
{
  MinusScreenPanel$multiTaskEventListener$1(b paramb, AppCompatActivity paramAppCompatActivity, com.tencent.mm.app.f paramf)
  {
    super((q)paramf);
    AppMethodBeat.i(304529);
    AppMethodBeat.o(304529);
  }
  
  private boolean a(or paramor)
  {
    AppMethodBeat.i(304545);
    s.u(paramor, "event");
    Object localObject1 = paramor.hRw;
    Object localObject2;
    label201:
    int i;
    if (localObject1 != null)
    {
      b localb = this.LGw;
      localObject2 = this.Awh;
      if (((or.a)localObject1).hRx != 0) {
        break label345;
      }
      paramor = localb.LGr;
      if (paramor != null) {
        break label290;
      }
      paramor = null;
      if (paramor != a.b.LDs)
      {
        paramor = ((or.a)localObject1).id;
        g localg = g.LBa;
        if (!s.p(paramor, g.gjs()))
        {
          paramor = k.aeZF;
          paramor = (com.tencent.mm.plugin.multitask.ui.uic.c)k.d((AppCompatActivity)localObject2).q(com.tencent.mm.plugin.multitask.ui.uic.c.class);
          if (paramor.gkZ()) {
            paramor.glf();
          }
        }
      }
      localObject2 = new MultiTaskInfo();
      ((MultiTaskInfo)localObject2).field_type = ((or.a)localObject1).type;
      ((MultiTaskInfo)localObject2).field_id = ((or.a)localObject1).id;
      s.u(localObject2, "multiTaskInfo");
      if (!localb.LGs.containsKey(((MultiTaskInfo)localObject2).field_id)) {
        break label340;
      }
      localObject1 = new ah.f();
      ((ah.f)localObject1).aqH = localb.LGs.get(((MultiTaskInfo)localObject2).field_id);
      paramor = (com.tencent.mm.plugin.multitask.ui.c)((ah.f)localObject1).aqH;
      if (paramor != null) {
        break label298;
      }
      paramor = null;
      if (s.p(paramor, localb.LGp)) {
        d.uiThread((kotlin.g.a.a)new a.a((ah.f)localObject1));
      }
      if ((!s.p(((ah.f)localObject1).aqH, localb.LGr)) || (localb.LGr == null)) {
        break label320;
      }
      localb.eDd();
      localb.LGr = null;
      label258:
      i = 1;
      label260:
      if (i != 0) {
        Log.i("MicroMsg.MultiTask.MinusScreenPanel", "HideMultiTaskEvent, hideUIComponent, id:%s", new Object[] { ((MultiTaskInfo)localObject2).field_id });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(304545);
      return false;
      label290:
      paramor = paramor.eDe();
      break;
      label298:
      paramor = paramor.getRootView();
      if (paramor == null)
      {
        paramor = null;
        break label201;
      }
      paramor = paramor.getParent();
      break label201;
      label320:
      paramor = (com.tencent.mm.plugin.multitask.ui.c)((ah.f)localObject1).aqH;
      if (paramor == null) {
        break label258;
      }
      paramor.eDd();
      break label258;
      label340:
      i = 0;
      break label260;
      label345:
      if (((or.a)localObject1).hRx == 1)
      {
        paramor = k.aeZF;
        paramor = k.d((AppCompatActivity)localObject2).q(com.tencent.mm.plugin.multitask.ui.uic.c.class);
        s.s(paramor, "UICProvider.of(activity)…MultiTaskUIC::class.java)");
        com.tencent.mm.plugin.multitask.ui.uic.c.a((com.tencent.mm.plugin.multitask.ui.uic.c)paramor, false, false, true, true, false, false, false, 240);
        Log.i("MicroMsg.MultiTask.MinusScreenPanel", "showHome");
      }
      else if (((or.a)localObject1).hRx == 2)
      {
        h.baE().ban().set(at.a.adgS, "");
        Log.i("MicroMsg.MultiTask.MinusScreenPanel", "reset show id");
      }
      else if (((or.a)localObject1).hRx == 3)
      {
        paramor = k.aeZF;
        ((com.tencent.mm.plugin.multitask.ui.uic.c)k.d((AppCompatActivity)localObject2).q(com.tencent.mm.plugin.multitask.ui.uic.c.class)).glc();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.panel.MinusScreenPanel.multiTaskEventListener.1
 * JD-Core Version:    0.7.0.1
 */