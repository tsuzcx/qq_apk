package com.tencent.mm.ui.chatting.viewitems.a;

import android.view.View;
import com.tencent.d.a.a.a.b;
import com.tencent.d.a.a.a.d.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.cg;
import com.tencent.mm.plugin.findersdk.a.cf;
import com.tencent.mm.plugin.findersdk.a.cf.a;
import com.tencent.mm.storage.cc;
import com.tencent.mm.view.e.b;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1$filling$3", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$f
  extends e.b
{
  c$f(cc paramcc, String paramString1, String paramString2, long paramLong, String paramString3) {}
  
  public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(255457);
    s.u(paramView, "view");
    Object localObject;
    g localg;
    label64:
    int i;
    if (paramBoolean)
    {
      paramView = ((b)com.tencent.mm.kernel.h.az(b.class)).getFinderLiveNotifyExposureInfoStorage();
      localObject = this.ERZ;
      if (localObject != null) {
        break label158;
      }
      paramLong1 = -1L;
      localg = paramView.oC(paramLong1);
      paramView = localg.field_businessBuf;
      if (paramView != null) {
        break label167;
      }
      paramView = null;
      localObject = paramView;
      if (paramView == null) {
        localObject = "";
      }
      paramView = this.BfQ;
      s.s(paramView, "noticeId");
      if (((CharSequence)paramView).length() != 0) {
        break label182;
      }
      i = 1;
      label101:
      if (i == 0) {
        break label188;
      }
    }
    label158:
    label167:
    label182:
    label188:
    for (paramLong1 = 2L;; paramLong1 = 1L)
    {
      cf.a.a((cf)k.Doi, q.cg.DFu, this.aeZz, this.mIn, "", localg.field_forcePushId, Long.valueOf(paramLong1), (String)localObject, this.aeZA, null, null, 1536);
      AppMethodBeat.o(255457);
      return;
      paramLong1 = ((fi)localObject).field_msgId;
      break;
      paramView = new String(paramView, d.UTF_8);
      break label64;
      i = 0;
      break label101;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.a.c.f
 * JD-Core Version:    0.7.0.1
 */