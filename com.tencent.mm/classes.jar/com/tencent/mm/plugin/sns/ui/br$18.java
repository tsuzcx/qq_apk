package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;

final class br$18
  implements View.OnClickListener
{
  br$18(br parambr) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(99734);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    long l1;
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof TimeLineObject)))
    {
      if (!WeChatBrands.Business.Entries.MomentChannels.checkAvailable(paramView.getContext()))
      {
        a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99734);
        return;
      }
      paramView = (TimeLineObject)paramView.getTag();
      if ((paramView.ContentObj == null) || (paramView.ContentObj.dME == null)) {
        break label410;
      }
      l1 = r.aOw(paramView.ContentObj.dME.objectId);
      long l2 = paramView.ContentObj.dME.localId;
      if ((l1 != 0L) || (l2 != 0L))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("report_scene", 3);
        ((Intent)localObject).putExtra("from_user", paramView.UserName);
        ((Intent)localObject).putExtra("feed_object_id", l1);
        ((Intent)localObject).putExtra("feed_object_nonceId", paramView.ContentObj.dME.objectNonceId);
        ((Intent)localObject).putExtra("business_type", 0);
        ((Intent)localObject).putExtra("finder_user_name", paramView.ContentObj.dME.username);
        ((Intent)localObject).putExtra("key_from_user_name", paramView.UserName);
        ((Intent)localObject).putExtra("tab_type", 5);
        ((Intent)localObject).putExtra("key_comment_scene", 38);
        ((Intent)localObject).putExtra("feed_local_id", l2);
        ((Intent)localObject).putExtra("key_finder_teen_mode_check", true);
        ((Intent)localObject).putExtra("key_finder_teen_mode_scene", 3);
        ((Intent)localObject).putExtra("key_finder_teen_mode_user_name", paramView.ContentObj.dME.nickname);
        ((Intent)localObject).putExtra("key_finder_teen_mode_user_id", paramView.ContentObj.dME.username);
        if ((l1 == 0L) && (l2 != 0L)) {
          ((Intent)localObject).putExtra("key_posting_scene", true);
        }
        ((aj)g.ah(aj.class)).fillContextIdToIntent(4, 2, 38, (Intent)localObject);
        ((aj)g.ah(aj.class)).enterFinderShareFeedUI(this.ERz.context, (Intent)localObject);
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(99734);
      return;
      label410:
      if ((paramView.ContentObj != null) && (paramView.ContentObj.Lpd != null))
      {
        l1 = r.aOw(paramView.ContentObj.Lpd.objectId);
        if (l1 != 0L)
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("report_scene", 3);
          ((Intent)localObject).putExtra("from_user", paramView.UserName);
          ((Intent)localObject).putExtra("feed_object_id", l1);
          ((Intent)localObject).putExtra("feed_object_nonceId", paramView.ContentObj.Lpd.objectNonceId);
          ((Intent)localObject).putExtra("business_type", 1);
          ((Intent)localObject).putExtra("key_from_user_name", paramView.UserName);
          ((Intent)localObject).putExtra("tab_type", 5);
          ((Intent)localObject).putExtra("key_comment_scene", 53);
          ((Intent)localObject).putExtra("key_finder_teen_mode_check", true);
          ((Intent)localObject).putExtra("key_finder_teen_mode_scene", 3);
          ((Intent)localObject).putExtra("key_finder_teen_mode_user_name", paramView.ContentObj.Lpd.nickname);
          ((Intent)localObject).putExtra("key_finder_teen_mode_user_id", paramView.ContentObj.Lpd.username);
          ((aj)g.ah(aj.class)).fillContextIdToIntent(4, 2, 38, (Intent)localObject);
          ((aj)g.ah(aj.class)).enterFinderShareFeedUI(this.ERz.context, (Intent)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.br.18
 * JD-Core Version:    0.7.0.1
 */