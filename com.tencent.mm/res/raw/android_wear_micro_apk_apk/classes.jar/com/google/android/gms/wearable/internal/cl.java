package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.p;
import com.google.android.gms.common.api.t;
import com.google.android.gms.wearable.b;
import com.google.android.gms.wearable.c;

public final class cl
  implements b
{
  public final t<Status> a(p paramp, c paramc)
  {
    com.google.android.gms.common.internal.d.e(paramp, "client is null");
    com.google.android.gms.common.internal.d.e(paramc, "listener is null");
    IntentFilter localIntentFilter = new IntentFilter("com.google.android.gms.wearable.CHANNEL_EVENT");
    localIntentFilter.addDataScheme("wear");
    localIntentFilter.addDataAuthority("*", null);
    u.a(paramp, new v() {}, paramc);
  }
  
  public final t<com.google.android.gms.wearable.d> a(p paramp, final String paramString1, final String paramString2)
  {
    com.google.android.gms.common.internal.d.e(paramp, "client is null");
    com.google.android.gms.common.internal.d.e(paramString1, "nodeId is null");
    com.google.android.gms.common.internal.d.e(paramString2, "path is null");
    paramp.a(new ci(paramp) {});
  }
  
  public final t<Status> b(p paramp, c paramc)
  {
    com.google.android.gms.common.internal.d.e(paramp, "client is null");
    com.google.android.gms.common.internal.d.e(paramc, "listener is null");
    return paramp.a(new cn(paramp, paramc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.cl
 * JD-Core Version:    0.7.0.1
 */