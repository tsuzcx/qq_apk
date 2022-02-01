package com.tencent.mm.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;

final class FindMoreFriendsUI$1
  extends ap
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
      if (FindMoreFriendsUI.a(this.FJN) != null) {
        FindMoreFriendsUI.b(this.FJN);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.1
 * JD-Core Version:    0.7.0.1
 */