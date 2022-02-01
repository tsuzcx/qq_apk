package com.tencent.mm.ui.chatting.viewitems.a;

import android.view.View;
import com.tencent.c.a.a.a.b;
import com.tencent.c.a.a.a.d.a.e;
import com.tencent.c.a.a.a.d.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.bn;
import com.tencent.mm.storage.ca;
import com.tencent.mm.view.e.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1$filling$8", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "app_release"})
public final class a$g
  extends e.b
{
  a$g(ca paramca, String paramString1, String paramString2, long paramLong, String paramString3) {}
  
  public final void p(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(267908);
    p.k(paramView, "view");
    Object localObject1;
    label77:
    Object localObject2;
    int i;
    if (paramBoolean)
    {
      paramView = ((b)h.ag(b.class)).getFinderLiveNotifyExposureInfoStorage();
      localObject1 = this.lEd;
      if (localObject1 == null) {
        break label160;
      }
      l = ((ca)localObject1).apG();
      localObject1 = paramView.Lv(l);
      paramView = ((e)localObject1).field_businessBuf;
      if (paramView == null) {
        break label168;
      }
      paramView = new String(paramView, d.UTF_8);
      localObject2 = this.AGN;
      p.j(localObject2, "noticeId");
      if (((CharSequence)localObject2).length() != 0) {
        break label174;
      }
      i = 1;
      label105:
      if (i == 0) {
        break label179;
      }
    }
    label160:
    label168:
    label174:
    label179:
    for (long l = 2L;; l = 1L)
    {
      localObject2 = m.yCt;
      m.a(s.bn.yNb, this.Xol, this.khN, "", ((e)localObject1).field_forcePushId, Long.valueOf(l), paramView, this.Xom, null, 512);
      AppMethodBeat.o(267908);
      return;
      l = -1L;
      break;
      paramView = "";
      break label77;
      i = 0;
      break label105;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.a.a.g
 * JD-Core Version:    0.7.0.1
 */