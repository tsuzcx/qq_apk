package com.tencent.mm.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class FindMoreFriendsUI$1
  extends MMHandler
{
  FindMoreFriendsUI$1(FindMoreFriendsUI paramFindMoreFriendsUI, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(33032);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33032);
      return;
      if (FindMoreFriendsUI.a(this.VUs) != null) {
        FindMoreFriendsUI.b(this.VUs);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.1
 * JD-Core Version:    0.7.0.1
 */