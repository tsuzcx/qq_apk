package com.tencent.mm.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import java.lang.ref.WeakReference;
import kotlin.ah;
import kotlin.g.a.b;

public final class aq
  implements b<SubscribeMsgRequestResult, ah>
{
  private final WeakReference<Activity> adJV;
  private final String sWX;
  
  public aq(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(249329);
    this.adJV = new WeakReference(paramActivity);
    this.sWX = paramString;
    AppMethodBeat.o(249329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.aq
 * JD-Core Version:    0.7.0.1
 */