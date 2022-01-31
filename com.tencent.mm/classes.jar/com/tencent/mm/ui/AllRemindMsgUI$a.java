package com.tencent.mm.ui;

import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;

final class AllRemindMsgUI$a
  implements f, Runnable
{
  AllRemindMsgUI$a(AllRemindMsgUI paramAllRemindMsgUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramm.getType() != 866) {
        return;
      }
      e.post(new AllRemindMsgUI.a.1(this, paramm), "MicroMsg.emoji.AllRemindMsgUI[onSceneEnd]");
      return;
    }
    y.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AllRemindMsgUI.c(this.uGB).setVisibility(0);
    AllRemindMsgUI.e(this.uGB).setVisibility(8);
  }
  
  public final void run()
  {
    n localn = new n();
    au.Dk().a(localn, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI.a
 * JD-Core Version:    0.7.0.1
 */