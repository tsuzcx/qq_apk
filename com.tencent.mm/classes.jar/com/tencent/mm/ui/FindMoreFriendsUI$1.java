package com.tencent.mm.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class FindMoreFriendsUI$1
  extends ak
{
  FindMoreFriendsUI$1(FindMoreFriendsUI paramFindMoreFriendsUI, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(29207);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29207);
      return;
      if (FindMoreFriendsUI.a(this.yWI) != null) {
        FindMoreFriendsUI.b(this.yWI);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.1
 * JD-Core Version:    0.7.0.1
 */