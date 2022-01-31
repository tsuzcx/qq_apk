package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Handler;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.y;
import com.tencent.mm.ui.tools.TestTimeForChatting;

final class NewChattingTabUI$1
  implements MessageQueue.IdleHandler
{
  NewChattingTabUI$1(NewChattingTabUI paramNewChattingTabUI) {}
  
  @TargetApi(17)
  public final boolean queueIdle()
  {
    boolean bool2 = true;
    AppMethodBeat.i(29792);
    try
    {
      if ((NewChattingTabUI.a(this.zei).isFinishing()) || (NewChattingTabUI.a(this.zei).isDestroyed()))
      {
        boolean bool1 = bool2;
        if (!NewChattingTabUI.a(this.zei).isDestroyed()) {
          if (!NewChattingTabUI.a(this.zei).isFinishing()) {
            break label90;
          }
        }
        label90:
        for (bool1 = bool2;; bool1 = false)
        {
          ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "prepare chattingUI but activity finished isDestroyed[%b]", new Object[] { Boolean.valueOf(bool1) });
          AppMethodBeat.o(29792);
          return false;
        }
      }
      ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "prepare chattingUI logic start");
      long l = System.currentTimeMillis();
      if (NewChattingTabUI.d(this.zei) == null)
      {
        Intent localIntent = new Intent().putExtra("Chat_User", "");
        NewChattingTabUI.a(this.zei, localIntent, true);
        NewChattingTabUI.d(this.zei).setVisibility(8);
        NewChattingTabUI.e(this.zei).dBR();
        y.d(true, new Intent().putExtra("classname", LauncherUI.class.getName()));
      }
      ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "prepare chattingUI logic use %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.LauncherUI.NewChattingTabUI", localException, "", new Object[0]);
        new Handler().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(29791);
            RuntimeException localRuntimeException = new RuntimeException(localException);
            AppMethodBeat.o(29791);
            throw localRuntimeException;
          }
        });
      }
    }
    AppMethodBeat.o(29792);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.NewChattingTabUI.1
 * JD-Core Version:    0.7.0.1
 */