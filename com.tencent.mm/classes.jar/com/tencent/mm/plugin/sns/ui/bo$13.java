package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.arj;

final class bo$13
  implements View.OnClickListener
{
  bo$13(bo parambo) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(99734);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof TimeLineObject)))
    {
      paramView = (TimeLineObject)paramView.getTag();
      if ((paramView.HAT != null) && (paramView.HAT.GaU != null))
      {
        long l = q.ayi(paramView.HAT.GaU.objectId);
        if (l != 0L)
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("report_scene", 3);
          ((Intent)localObject).putExtra("from_user", paramView.nDo);
          ((Intent)localObject).putExtra("feed_object_id", l);
          ((Intent)localObject).putExtra("feed_object_nonceId", paramView.HAT.GaU.objectNonceId);
          ((Intent)localObject).putExtra("key_from_user_name", paramView.nDo);
          ((Intent)localObject).putExtra("tab_type", 5);
          ((Intent)localObject).putExtra("key_comment_scene", 38);
          ((t)g.ad(t.class)).fillContextIdToIntent(4, 2, 38, (Intent)localObject);
          ((t)g.ad(t.class)).enterFinderShareFeedUI(this.Aqp.context, (Intent)localObject);
        }
      }
    }
    a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(99734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bo.13
 * JD-Core Version:    0.7.0.1
 */