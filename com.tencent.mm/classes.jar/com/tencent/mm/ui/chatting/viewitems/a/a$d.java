package com.tencent.mm.ui.chatting.viewitems.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.c.a.a.a.b.b;
import com.tencent.c.a.a.a.d.a.e;
import com.tencent.c.a.a.a.d.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s;
import com.tencent.mm.plugin.finder.live.report.s.bn;
import com.tencent.mm.plugin.finder.live.report.s.l;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class a$d
  implements View.OnClickListener
{
  a$d(a parama, String paramString1, com.tencent.mm.ui.chatting.e.a parama1, long paramLong1, long paramLong2, String paramString2, ca paramca, String paramString3, String paramString4) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(279086);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1$filling$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    for (;;)
    {
      try
      {
        localObject1 = new Intent();
        paramView = this.AGN;
        p.j(paramView, "noticeId");
        if (((CharSequence)paramView).length() != 0) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        ((Intent)localObject1).putExtra("key_chnl_extra", "\"{\"type\":\"2\"}");
        paramView = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).genContextId(24, 2, 65);
        localObject2 = k.yBj;
        k.dDm().aCC("temp_7");
        localObject2 = (com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class);
        localObject3 = (Context)this.Xcd.getContext();
        l1 = this.xhm;
        l2 = this.khN;
        String str = this.wWl;
        p.j(paramView, "contextId");
        b.b.a((com.tencent.c.a.a.a.b)localObject2, (Intent)localObject1, (Context)localObject3, l1, Long.valueOf(l2), "", str, "", paramView, "", "", "", 0);
        paramView = com.tencent.mm.plugin.finder.live.h.xVt;
        com.tencent.mm.plugin.finder.live.h.dwr();
        paramView = ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveNotifyExposureInfoStorage();
        localObject1 = this.lEd;
        if (localObject1 == null) {
          continue;
        }
        l1 = ((ca)localObject1).apG();
        paramView = paramView.Lv(l1);
        com.tencent.mm.plugin.expt.hellhound.a.aww(s.l.yFV.scene);
        localObject1 = this.AGN;
        p.j(localObject1, "noticeId");
        if (((CharSequence)localObject1).length() != 0) {
          continue;
        }
        i = 1;
      }
      catch (Throwable paramView)
      {
        int i;
        Object localObject2;
        Object localObject3;
        long l2;
        Log.i(this.Xok.TAG, "click ,err msg: " + paramView.getMessage());
        continue;
        if (i == 0) {
          continue;
        }
        long l1 = 2L;
        continue;
      }
      localObject1 = m.yCt;
      localObject1 = s.bn.yNc;
      localObject2 = this.Xol;
      l2 = this.khN;
      localObject3 = paramView.field_forcePushId;
      paramView = paramView.field_businessBuf;
      p.j(paramView, "info.field_businessBuf");
      m.a((s.bn)localObject1, (String)localObject2, l2, "", (String)localObject3, Long.valueOf(l1), new String(paramView, d.UTF_8), this.Xom, null, 512);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1$filling$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(279086);
      return;
      i = 0;
      continue;
      ((Intent)localObject1).putExtra("key_chnl_extra", "\"{\"type\":\"1\"}");
      paramView = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).genContextId(24, 2, 65);
      continue;
      l1 = -1L;
      continue;
      i = 0;
      continue;
      l1 = 1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.a.a.d
 * JD-Core Version:    0.7.0.1
 */