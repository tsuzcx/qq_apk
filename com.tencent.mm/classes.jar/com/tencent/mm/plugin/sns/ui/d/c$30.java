package com.tencent.mm.plugin.sns.ui.d;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.bcj;

final class c$30
  implements View.OnClickListener
{
  c$30(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163130);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    if ((paramView.getTag() instanceof TimeLineObject))
    {
      localObject = (TimeLineObject)paramView.getTag();
      bcj localbcj = ((TimeLineObject)localObject).ContentObj.dME;
      Intent localIntent = new Intent();
      localIntent.putExtra("feed_object_id", r.aOw(localbcj.objectId));
      localIntent.putExtra("feed_object_nonceId", localbcj.objectNonceId);
      localIntent.putExtra("business_type", 0);
      localIntent.putExtra("finder_user_name", localbcj.username);
      localIntent.putExtra("report_scene", 3);
      localIntent.putExtra("from_user", ((TimeLineObject)localObject).UserName);
      ((aj)g.ah(aj.class)).fillContextIdToIntent(4, 2, 25, localIntent);
      ((aj)g.ah(aj.class)).enterFinderShareFeedUI(paramView.getContext(), localIntent);
    }
    a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(163130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.c.30
 * JD-Core Version:    0.7.0.1
 */