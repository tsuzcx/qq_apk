package com.tencent.mm.plugin.multitalk.c;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class o$1
  extends MMHandler
{
  TelephonyManager wVW;
  PhoneStateListener wVX;
  
  o$1(o paramo, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(285078);
    super.handleMessage(paramMessage);
    if (paramMessage.what == 272)
    {
      if (this.wVW == null)
      {
        this.wVW = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
        this.wVX = new PhoneStateListener()
        {
          public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(285088);
            super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
            switch (paramAnonymousInt)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(285088);
              return;
              o.1.this.Lkz.au(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(285022);
                  Log.i("MicroMsg.Multitalk.ILinkService", "hy: hy: phone broken. exit room if in room");
                  o.a(o.1.this.Lkz, o.a.LlQ);
                  AppMethodBeat.o(285022);
                }
              });
            }
          }
        };
      }
      paramMessage = this.wVW;
      Object localObject = this.wVX;
      localObject = c.a(32, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramMessage, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/multitalk/ilinkservice/ILinkService$1", "handleMessage", "(Landroid/os/Message;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      paramMessage.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramMessage, "com/tencent/mm/plugin/multitalk/ilinkservice/ILinkService$1", "handleMessage", "(Landroid/os/Message;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    }
    AppMethodBeat.o(285078);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.c.o.1
 * JD-Core Version:    0.7.0.1
 */