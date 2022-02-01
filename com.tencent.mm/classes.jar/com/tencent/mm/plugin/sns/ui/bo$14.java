package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.ary;

final class bo$14
  implements View.OnClickListener
{
  bo$14(bo parambo) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(99735);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof TimeLineObject)))
    {
      paramView = (TimeLineObject)paramView.getTag();
      if ((paramView.HUG != null) && (paramView.HUG.GtB != null))
      {
        long l = r.azz(paramView.HUG.GtB.objectId);
        if (l != 0L)
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("report_scene", 3);
          ((Intent)localObject).putExtra("from_user", paramView.nIJ);
          ((Intent)localObject).putExtra("feed_object_id", l);
          ((Intent)localObject).putExtra("feed_object_nonceId", paramView.HUG.GtB.objectNonceId);
          ((Intent)localObject).putExtra("key_from_user_name", paramView.nIJ);
          ((Intent)localObject).putExtra("tab_type", 5);
          ((t)g.ad(t.class)).fillContextIdToIntent(4, 2, 38, (Intent)localObject);
          ((t)g.ad(t.class)).enterFinderShareFeedUI(this.AHD.context, (Intent)localObject);
        }
      }
    }
    a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(99735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bo.14
 * JD-Core Version:    0.7.0.1
 */