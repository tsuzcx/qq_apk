package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class SnsCommentDetailUI$31
  implements View.OnClickListener
{
  SnsCommentDetailUI$31(SnsCommentDetailUI paramSnsCommentDetailUI, TimeLineObject paramTimeLineObject) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98571);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_from_profile_share_scene", 3);
    ((Intent)localObject).putExtra("key_enter_profile_type", 8);
    if (bt.isNullOrNil(this.AbX.HAT.GaU.username))
    {
      ((Intent)localObject).putExtra("finder_username", "");
      ((Intent)localObject).putExtra("key_finder_object_Id", this.AbX.HAT.GaU.objectId);
      ((Intent)localObject).putExtra("key_finder_object_nonce_id_key", this.AbX.HAT.GaU.objectNonceId);
    }
    for (;;)
    {
      String str1 = bt.nullAsNil(((c)com.tencent.mm.kernel.g.ab(c.class)).cnc());
      String str2 = bt.nullAsNil(this.AbX.nDo);
      String str3 = this.AbX.HAT.GaU.objectId;
      String str4 = this.AbX.Id;
      str1 = str1 + "," + str2 + "," + str3 + "," + str4;
      ad.i("MicroMsg.SnsCommentDetailUI", "report20587, ".concat(String.valueOf(str1)));
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(20587, str1);
      ((t)com.tencent.mm.kernel.g.ad(t.class)).fillContextIdToIntent(4, 2, 32, (Intent)localObject);
      ((t)com.tencent.mm.kernel.g.ad(t.class)).enterFinderProfileUI(paramView.getContext(), (Intent)localObject);
      a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(98571);
      return;
      ((Intent)localObject).putExtra("finder_username", this.AbX.HAT.GaU.username);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.31
 * JD-Core Version:    0.7.0.1
 */