package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.sdk.platformtools.Util;

final class br$19
  implements View.OnClickListener
{
  br$19(br parambr) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(99735);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof TimeLineObject)))
    {
      localObject = (TimeLineObject)paramView.getTag();
      long l1 = r.aOw(((TimeLineObject)localObject).ContentObj.Lpc.hJs);
      long l2 = r.aOw(((TimeLineObject)localObject).ContentObj.Lpc.feedId);
      if ((l1 != 0L) && (l2 != 0L))
      {
        if (Util.isEqual(z.aUg(), ((TimeLineObject)localObject).ContentObj.Lpc.username))
        {
          ((aj)g.ah(aj.class)).enterFinderLiveAnchorUI(this.ERz.context, l2, Long.valueOf(l1), ((TimeLineObject)localObject).ContentObj.Lpc.objectNonceId, ((TimeLineObject)localObject).ContentObj.Lpc.desc, "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99735);
          return;
        }
        label208:
        String str;
        if (((TimeLineObject)localObject).UserName == null)
        {
          paramView = "";
          c.sEq = paramView;
          c.sEr = ((TimeLineObject)localObject).Id;
          com.tencent.mm.plugin.expt.hellhound.a.aox("temp_6");
          paramView = (aj)g.ah(aj.class);
          str = ((TimeLineObject)localObject).ContentObj.Lpc.username;
          if (((TimeLineObject)localObject).ContentObj.Lpc.liveStatus != 1) {
            break label371;
          }
        }
        label371:
        for (int i = 1;; i = 2)
        {
          paramView.report21053OnClick(l2, l1, str, -1, -1, 7L, "temp_6", i, c.cPi(), c.sEq, c.sEr, System.currentTimeMillis(), 1);
          ((aj)g.ah(aj.class)).enterFinderLiveVisitorUI(this.ERz.context, l2, Long.valueOf(l1), ((TimeLineObject)localObject).ContentObj.Lpc.username, ((TimeLineObject)localObject).ContentObj.Lpc.objectNonceId, ((TimeLineObject)localObject).ContentObj.Lpc.desc, "", "");
          break;
          paramView = ((TimeLineObject)localObject).UserName;
          break label208;
        }
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(99735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.br.19
 * JD-Core Version:    0.7.0.1
 */