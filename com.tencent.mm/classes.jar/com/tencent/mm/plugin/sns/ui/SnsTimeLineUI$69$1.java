package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.g;
import com.tencent.mm.sdk.platformtools.Log;

final class SnsTimeLineUI$69$1
  implements View.OnClickListener
{
  SnsTimeLineUI$69$1(SnsTimeLineUI.69 param69, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203720);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$72$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    Log.d("MicroMsg.SnsTimeLineUI", "collapse tips click");
    localObject = new Intent(this.EMH.EMn, SnsCommentDetailUI.class);
    ((Intent)localObject).putExtra("INTENT_TALKER", this.EMH.DxI.getUserName());
    ((Intent)localObject).putExtra("INTENT_SNS_LOCAL_ID", this.EMH.DxI.localid);
    ((Intent)localObject).putExtra("INTENT_FROMGALLERY", false);
    ((Intent)localObject).putExtra("intent_show_collapse_info", true);
    ((Intent)localObject).putExtra("intent_content_collapse_hint", this.EMG);
    paramView = this.EMH.EMn;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$72$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$72$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    g.JH(this.EMH.EDI);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$72$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(203720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.69.1
 * JD-Core Version:    0.7.0.1
 */