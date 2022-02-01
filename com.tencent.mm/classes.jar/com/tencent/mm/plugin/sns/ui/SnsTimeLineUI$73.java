package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.br;
import java.util.LinkedList;

final class SnsTimeLineUI$73
  implements Runnable
{
  SnsTimeLineUI$73(SnsTimeLineUI paramSnsTimeLineUI, LayoutInflater paramLayoutInflater, TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(307557);
    View localView = this.wJz.inflate(b.g.sns_header_collapse_item, SnsTimeLineUI.H(this.RAo), false);
    SnsTimeLineUI.H(this.RAo).addView(localView);
    if (SnsTimeLineUI.H(this.RAo).getChildCount() > 0) {
      SnsTimeLineUI.H(this.RAo).setVisibility(0);
    }
    Object localObject = (ImageView)localView.findViewById(b.f.sns_notify_preview);
    TextView localTextView = (TextView)localView.findViewById(b.f.sns_notify_tips);
    if (localTextView == null)
    {
      AppMethodBeat.o(307557);
      return;
    }
    if (this.RpR.ContentObj.Zpr.size() > 0)
    {
      dmz localdmz = (dmz)this.RpR.ContentObj.Zpr.get(0);
      g localg = al.hgy();
      int i = this.RAo.hashCode();
      br localbr = br.jbh();
      localbr.time = this.RpR.CreateTime;
      localg.b(localdmz, (View)localObject, i, localbr);
    }
    if (this.RpR.ContentObj.Zpq == 1)
    {
      localTextView.setText(b.j.sns_photo_collapse);
      localObject = this.RAo.getString(b.j.sns_photo_collapse_hint);
    }
    for (;;)
    {
      localView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(307846);
          Object localObject = new b();
          ((b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$76$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
          Log.d("MicroMsg.SnsTimeLineUI", "collapse tips click");
          localObject = new Intent(SnsTimeLineUI.73.this.RAo, SnsCommentDetailUI.class);
          ((Intent)localObject).putExtra("INTENT_TALKER", SnsTimeLineUI.73.this.PNW.getUserName());
          ((Intent)localObject).putExtra("INTENT_SNS_LOCAL_ID", SnsTimeLineUI.73.this.PNW.localid);
          ((Intent)localObject).putExtra("INTENT_FROMGALLERY", false);
          ((Intent)localObject).putExtra("intent_show_collapse_info", true);
          ((Intent)localObject).putExtra("intent_content_collapse_hint", this.RAJ);
          paramAnonymousView = SnsTimeLineUI.73.this.RAo;
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$76$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$76$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          n.vg(SnsTimeLineUI.73.this.RAI);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$76$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(307846);
        }
      });
      AppMethodBeat.o(307557);
      return;
      if (this.RpR.ContentObj.Zpq == 15)
      {
        localTextView.setText(b.j.sns_sight_collapse);
        localObject = this.RAo.getString(b.j.sns_sight_collapse_hint);
      }
      else
      {
        localObject = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.73
 * JD-Core Version:    0.7.0.1
 */