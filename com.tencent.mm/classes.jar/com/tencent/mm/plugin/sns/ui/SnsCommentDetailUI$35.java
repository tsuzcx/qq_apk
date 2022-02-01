package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;

final class SnsCommentDetailUI$35
  implements View.OnClickListener
{
  SnsCommentDetailUI$35(SnsCommentDetailUI paramSnsCommentDetailUI, TimeLineObject paramTimeLineObject) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163113);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    if (!WeChatBrands.Business.Entries.MomentChannels.checkAvailable(paramView.getContext()))
    {
      a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163113);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_profile_share_scene", 3);
    localIntent.putExtra("key_enter_profile_type", 8);
    String str1;
    String str2;
    if (this.ECp.ContentObj.dME != null) {
      if (Util.isNullOrNil(this.ECp.ContentObj.dME.username))
      {
        localIntent.putExtra("finder_username", "");
        localIntent.putExtra("key_finder_object_Id", this.ECp.ContentObj.dME.objectId);
        localIntent.putExtra("key_finder_object_nonce_id_key", this.ECp.ContentObj.dME.objectNonceId);
        str1 = Util.nullAsNil(((c)g.af(c.class)).cMD());
        str2 = Util.nullAsNil(this.ECp.UserName);
        localObject = "";
        if (this.ECp.ContentObj.dME == null) {
          break label508;
        }
        localObject = this.ECp.ContentObj.dME.objectId;
      }
    }
    for (;;)
    {
      String str3 = this.ECp.Id;
      localObject = str1 + "," + str2 + "," + (String)localObject + "," + str3;
      Log.i("MicroMsg.SnsCommentDetailUI", "report20587, ".concat(String.valueOf(localObject)));
      h.CyF.kvStat(20587, (String)localObject);
      localIntent.putExtra("key_finder_teen_mode_check", true);
      localIntent.putExtra("key_finder_teen_mode_scene", 3);
      localIntent.putExtra("key_finder_teen_mode_user_name", this.ECp.ContentObj.dME.nickname);
      localIntent.putExtra("key_finder_teen_mode_user_id", this.ECp.ContentObj.dME.username);
      ((aj)g.ah(aj.class)).fillContextIdToIntent(4, 2, 32, localIntent);
      ((aj)g.ah(aj.class)).enterFinderProfileUI(paramView.getContext(), localIntent);
      a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163113);
      return;
      localIntent.putExtra("finder_username", this.ECp.ContentObj.dME.username);
      break;
      if (this.ECp.ContentObj.Lpd == null) {
        break;
      }
      localIntent.putExtra("finder_username", "");
      localIntent.putExtra("key_finder_object_Id", this.ECp.ContentObj.Lpd.objectId);
      localIntent.putExtra("key_finder_object_nonce_id_key", this.ECp.ContentObj.Lpd.objectNonceId);
      break;
      label508:
      if (this.ECp.ContentObj.Lpd != null) {
        localObject = this.ECp.ContentObj.Lpd.objectId;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.35
 * JD-Core Version:    0.7.0.1
 */