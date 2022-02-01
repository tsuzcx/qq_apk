package com.tencent.mm.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yw;
import com.tencent.mm.g.a.yw.a;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.sdk.event.EventCenter;
import java.lang.ref.WeakReference;
import kotlin.g.a.b;
import kotlin.x;

public final class aj
  implements b<SubscribeMsgRequestResult, x>
{
  private final WeakReference<Activity> OKT;
  private final String mRa;
  
  public aj(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(232714);
    this.OKT = new WeakReference(paramActivity);
    this.mRa = paramString;
    AppMethodBeat.o(232714);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.aj
 * JD-Core Version:    0.7.0.1
 */