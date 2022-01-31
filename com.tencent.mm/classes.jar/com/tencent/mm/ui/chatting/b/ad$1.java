package com.tencent.mm.ui.chatting.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.br.d.a;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;

final class ad$1
  implements d.a
{
  ad$1(ad paramad, Intent paramIntent) {}
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.val$intent.removeExtra("SendAppMessageWrapper_Scene");
    if (paramInt1 == 228)
    {
      if (paramInt2 != -1) {
        break label77;
      }
      if ((paramIntent == null) || (!paramIntent.getBooleanExtra("Select_stay_in_wx", false))) {
        break label41;
      }
      ReportUtil.y(false, 0);
    }
    label41:
    label77:
    do
    {
      do
      {
        return;
      } while (this.vrJ.byx.vtz.getContext().isFinishing());
      this.vrJ.byx.vtz.getContext().finish();
      return;
      paramIntent = ReportUtil.c(this.val$intent.getExtras(), 0);
      ReportUtil.a(this.vrJ.byx.vtz.getContext(), paramIntent, true);
    } while (this.vrJ.byx.vtz.getContext().isFinishing());
    this.vrJ.byx.vtz.getContext().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.ad.1
 * JD-Core Version:    0.7.0.1
 */