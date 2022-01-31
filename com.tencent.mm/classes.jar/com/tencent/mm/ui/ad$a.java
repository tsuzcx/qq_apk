package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.e;

final class ad$a
  implements Runnable
{
  int aYY;
  int bQU;
  Intent bQV;
  int uQe = 0;
  
  private ad$a(ad paramad) {}
  
  public final void run()
  {
    if ((au.DK()) && (this.uPW.ohK != null))
    {
      y.i("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, acc has ready, retry count %d", new Object[] { Integer.valueOf(this.uQe) });
      this.uPW.startChatting(this.uPW.uPO, null, false);
      ai.d(new Runnable()
      {
        public final void run()
        {
          boolean bool = true;
          if (ad.a.this.uPW.uPR == null) {}
          for (;;)
          {
            y.d("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. after creat chattingUI, chatting fragment is null? %B", new Object[] { Boolean.valueOf(bool) });
            if (ad.a.this.uPW.uPR != null)
            {
              y.d("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. do post activity result");
              ad.a.this.uPW.uPR.onActivityResult(ad.a.this.bQU & 0xFFFF, ad.a.this.aYY, ad.a.this.bQV);
            }
            return;
            bool = false;
          }
        }
        
        public final String toString()
        {
          return super.toString() + "|PostSelectImageJob_onActivityResult";
        }
      });
      return;
    }
    if (this.uQe >= 3)
    {
      y.w("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, match max retry count");
      return;
    }
    if (this.uPW.ohK != null) {}
    for (boolean bool = true;; bool = false)
    {
      y.w("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, acc not ready or view init(%B), cur retry count %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.uQe) });
      this.uQe += 1;
      ai.l(this, 300L);
      return;
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|PostSelectImageJob";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.ad.a
 * JD-Core Version:    0.7.0.1
 */