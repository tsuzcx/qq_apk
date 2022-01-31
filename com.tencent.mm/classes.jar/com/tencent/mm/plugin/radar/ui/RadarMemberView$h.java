package com.tencent.mm.plugin.radar.ui;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bv;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class RadarMemberView$h
  implements View.OnClickListener
{
  RadarMemberView$h(RadarMemberView paramRadarMemberView) {}
  
  public final void onClick(View paramView)
  {
    RadarMemberView localRadarMemberView = null;
    AppMethodBeat.i(102954);
    String str = "";
    paramView = str;
    if (RadarMemberView.c(this.pRw) != null)
    {
      paramView = RadarMemberView.c(this.pRw);
      if ((paramView == null) || (paramView.NT() != true)) {
        break label152;
      }
      paramView = RadarMemberView.c(this.pRw);
      if (paramView == null) {
        break label147;
      }
    }
    int i;
    label147:
    for (paramView = paramView.Hr();; paramView = null)
    {
      localObject = (CharSequence)paramView;
      if ((localObject != null) && (!a.l.m.ap((CharSequence)localObject))) {
        break;
      }
      i = 1;
      label80:
      localObject = paramView;
      if (i != 0)
      {
        localObject = paramView;
        if (this.pRw.getMember() != null)
        {
          localObject = this.pRw.getMember();
          paramView = localRadarMemberView;
          if (localObject != null) {
            paramView = ((brg)localObject).jKG;
          }
          localObject = paramView;
        }
      }
      localRadarMemberView = this.pRw;
      paramView = (View)localObject;
      if (localObject == null) {
        paramView = "";
      }
      RadarMemberView.a(localRadarMemberView, paramView);
      AppMethodBeat.o(102954);
      return;
    }
    label152:
    paramView = g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
    a.f.b.j.p(paramView, "service(IMessengerStorage::class.java)");
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)paramView).YB();
    paramView = RadarMemberView.c(this.pRw);
    if (paramView != null)
    {
      paramView = paramView.getUsername();
      label191:
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.m)localObject).TM(paramView);
      if (localObject != null)
      {
        paramView = (CharSequence)((bv)localObject).Hv();
        if ((paramView != null) && (!a.l.m.ap(paramView))) {
          break label334;
        }
        i = 1;
        label224:
        if (i == 0) {
          break label359;
        }
      }
      paramView = RadarMemberView.c(this.pRw);
      if (paramView == null) {
        break label339;
      }
      paramView = paramView.Hv();
      label245:
      paramView = (CharSequence)paramView;
      if ((paramView != null) && (!a.l.m.ap(paramView))) {
        break label344;
      }
      i = 1;
      label263:
      if (i != 0) {
        break label359;
      }
      paramView = g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
      a.f.b.j.p(paramView, "service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)paramView).YB();
      paramView = RadarMemberView.c(this.pRw);
      if (paramView == null) {
        break label349;
      }
      paramView = paramView.Hv();
      label306:
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.m)localObject).TM(paramView);
    }
    label334:
    label339:
    label344:
    label349:
    label359:
    for (;;)
    {
      paramView = str;
      if (localObject == null) {
        break;
      }
      paramView = ((bv)localObject).Hr();
      break;
      paramView = null;
      break label191;
      i = 0;
      break label224;
      paramView = null;
      break label245;
      i = 0;
      break label263;
      paramView = null;
      break label306;
      i = 0;
      break label80;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView.h
 * JD-Core Version:    0.7.0.1
 */