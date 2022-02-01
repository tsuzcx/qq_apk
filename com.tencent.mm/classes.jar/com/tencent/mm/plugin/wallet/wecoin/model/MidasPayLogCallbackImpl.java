package com.tencent.mm.plugin.wallet.wecoin.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.IMidasLogCallback;
import com.tencent.mm.sdk.platformtools.Log;

public class MidasPayLogCallbackImpl
  implements IMidasLogCallback
{
  private static final int LOG_LEVEL_DEBUG = 2;
  private static final int LOG_LEVEL_ERROR = 5;
  private static final int LOG_LEVEL_INFO = 3;
  private static final int LOG_LEVEL_VERBOSE = 1;
  private static final int LOG_LEVEL_WARN = 4;
  private static final String TAG = "MicroMsg.MidasPayLogCallbackImpl";
  
  public void onLogging(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(315733);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(315733);
      return;
      Log.v("MicroMsg.MidasPayLogCallbackImpl", "tag:%s msg:%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(315733);
      return;
      Log.d("MicroMsg.MidasPayLogCallbackImpl", "tag:%s msg:%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(315733);
      return;
      Log.i("MicroMsg.MidasPayLogCallbackImpl", "tag:%s msg:%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(315733);
      return;
      Log.w("MicroMsg.MidasPayLogCallbackImpl", "tag:%s msg:%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(315733);
      return;
      Log.e("MicroMsg.MidasPayLogCallbackImpl", "tag:%s msg:%s", new Object[] { paramString1, paramString2 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.MidasPayLogCallbackImpl
 * JD-Core Version:    0.7.0.1
 */