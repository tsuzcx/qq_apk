package com.tencent.mm.plugin.radar.ui;

import a.h.e;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bv;

final class RadarMemberView$h
  implements View.OnClickListener
{
  RadarMemberView$h(RadarMemberView paramRadarMemberView) {}
  
  public final void onClick(View paramView)
  {
    RadarMemberView localRadarMemberView = null;
    String str = "";
    paramView = str;
    if (RadarMemberView.c(this.nmh) != null)
    {
      paramView = RadarMemberView.c(this.nmh);
      if ((paramView == null) || (paramView.Bd() != true)) {
        break label142;
      }
      paramView = RadarMemberView.c(this.nmh);
      if (paramView == null) {
        break label137;
      }
    }
    int i;
    label137:
    for (paramView = paramView.vl();; paramView = null)
    {
      localObject = (CharSequence)paramView;
      if ((localObject != null) && (!e.X((CharSequence)localObject))) {
        break;
      }
      i = 1;
      label75:
      localObject = paramView;
      if (i != 0)
      {
        localObject = paramView;
        if (this.nmh.getMember() != null)
        {
          localObject = this.nmh.getMember();
          paramView = localRadarMemberView;
          if (localObject != null) {
            paramView = ((bio)localObject).hRf;
          }
          localObject = paramView;
        }
      }
      localRadarMemberView = this.nmh;
      paramView = (View)localObject;
      if (localObject == null) {
        paramView = "";
      }
      RadarMemberView.a(localRadarMemberView, paramView);
      return;
    }
    label142:
    paramView = com.tencent.mm.kernel.g.r(j.class);
    a.d.b.g.j(paramView, "service(IMessengerStorage::class.java)");
    Object localObject = ((j)paramView).Fx();
    paramView = RadarMemberView.c(this.nmh);
    if (paramView != null)
    {
      paramView = paramView.getUsername();
      label181:
      localObject = ((l)localObject).Id(paramView);
      if (localObject != null)
      {
        paramView = (CharSequence)((bv)localObject).vp();
        if ((paramView != null) && (!e.X(paramView))) {
          break label324;
        }
        i = 1;
        label214:
        if (i == 0) {
          break label349;
        }
      }
      paramView = RadarMemberView.c(this.nmh);
      if (paramView == null) {
        break label329;
      }
      paramView = paramView.vp();
      label235:
      paramView = (CharSequence)paramView;
      if ((paramView != null) && (!e.X(paramView))) {
        break label334;
      }
      i = 1;
      label253:
      if (i != 0) {
        break label349;
      }
      paramView = com.tencent.mm.kernel.g.r(j.class);
      a.d.b.g.j(paramView, "service(IMessengerStorage::class.java)");
      localObject = ((j)paramView).Fx();
      paramView = RadarMemberView.c(this.nmh);
      if (paramView == null) {
        break label339;
      }
      paramView = paramView.vp();
      label296:
      localObject = ((l)localObject).Id(paramView);
    }
    label324:
    label329:
    label334:
    label339:
    label349:
    for (;;)
    {
      paramView = str;
      if (localObject == null) {
        break;
      }
      paramView = ((bv)localObject).vl();
      break;
      paramView = null;
      break label181;
      i = 0;
      break label214;
      paramView = null;
      break label235;
      i = 0;
      break label253;
      paramView = null;
      break label296;
      i = 0;
      break label75;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView.h
 * JD-Core Version:    0.7.0.1
 */