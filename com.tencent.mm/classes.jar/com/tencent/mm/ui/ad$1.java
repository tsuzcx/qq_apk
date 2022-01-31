package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Handler;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.x;
import com.tencent.mm.ui.tools.TestTimeForChatting;

final class ad$1
  implements MessageQueue.IdleHandler
{
  ad$1(ad paramad) {}
  
  @TargetApi(17)
  public final boolean queueIdle()
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        if ((this.uPW.ohK.isFinishing()) || (this.uPW.ohK.isDestroyed()))
        {
          bool1 = bool2;
          if (!this.uPW.ohK.isDestroyed())
          {
            if (this.uPW.ohK.isFinishing()) {
              bool1 = bool2;
            }
          }
          else
          {
            y.i("MicroMsg.LauncherUI.NewChattingTabUI", "prepare chattingUI but activity finished isDestroyed[%b]", new Object[] { Boolean.valueOf(bool1) });
            return false;
          }
        }
        else
        {
          y.i("MicroMsg.LauncherUI.NewChattingTabUI", "prepare chattingUI logic start");
          long l = System.currentTimeMillis();
          if (this.uPW.uPK == null)
          {
            Intent localIntent = new Intent().putExtra("Chat_User", "");
            ad.a(this.uPW, localIntent, true);
            this.uPW.uPK.setVisibility(8);
            this.uPW.uPI.cyJ();
            x.b(true, new Intent().putExtra("classname", LauncherUI.class.getName()));
          }
          y.i("MicroMsg.LauncherUI.NewChattingTabUI", "prepare chattingUI logic use %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          return false;
        }
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.LauncherUI.NewChattingTabUI", localException, "", new Object[0]);
        new Handler().post(new ad.1.1(this, localException));
        return false;
      }
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.ad.1
 * JD-Core Version:    0.7.0.1
 */