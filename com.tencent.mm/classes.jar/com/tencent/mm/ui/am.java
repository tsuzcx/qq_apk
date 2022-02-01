package com.tencent.mm.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aad;
import com.tencent.mm.f.a.aad.a;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.sdk.event.EventCenter;
import java.lang.ref.WeakReference;
import kotlin.g.a.b;
import kotlin.x;

public final class am
  implements b<SubscribeMsgRequestResult, x>
{
  private final WeakReference<Activity> Wes;
  private final String pRV;
  
  public am(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(201962);
    this.Wes = new WeakReference(paramActivity);
    this.pRV = paramString;
    AppMethodBeat.o(201962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.am
 * JD-Core Version:    0.7.0.1
 */