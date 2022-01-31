package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.k;
import com.tencent.mm.plugin.sns.a.b.k.a;
import com.tencent.mm.plugin.sns.a.b.k.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ak;

final class SnsSightPlayerUI$7
  implements View.OnClickListener
{
  SnsSightPlayerUI$7(SnsSightPlayerUI paramSnsSightPlayerUI, TimeLineObject paramTimeLineObject, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39256);
    Object localObject1;
    Object localObject2;
    if (k.b.ram.value != 0)
    {
      localObject1 = k.a.rag;
      localObject2 = this.rVV.Id;
      if (SnsSightPlayerUI.a(this.rVT) != null) {
        break label218;
      }
    }
    label218:
    for (paramView = "";; paramView = SnsSightPlayerUI.a(this.rVT).cFe)
    {
      k.a((k.a)localObject1, (String)localObject2, paramView, 1, k.b.ram.value, this.rVV.jJA, null, this.rVV.Id, 0L, 0, 0);
      localObject2 = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putString("key_snsad_statextstr", this.rVV.rHA);
      localObject1 = this.mAe;
      paramView = (View)localObject1;
      if (SnsSightPlayerUI.a(this.rVT) != null) {
        paramView = i.gg((String)localObject1, SnsSightPlayerUI.a(this.rVT).cFe);
      }
      ((Intent)localObject2).putExtra("jsapiargs", localBundle);
      ((Intent)localObject2).putExtra("rawUrl", paramView);
      ((Intent)localObject2).putExtra("useJs", true);
      i.a(new SnsAdClick(SnsSightPlayerUI.b(this.rVT), 5, SnsSightPlayerUI.c(this.rVT).field_snsId, 18, 0));
      new ak(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(39255);
          com.tencent.mm.plugin.sns.c.a.gmO.i(this.val$intent, SnsSightPlayerUI.7.this.rVT);
          SnsSightPlayerUI.7.this.rVT.finish();
          AppMethodBeat.o(39255);
        }
      });
      AppMethodBeat.o(39256);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.7
 * JD-Core Version:    0.7.0.1
 */