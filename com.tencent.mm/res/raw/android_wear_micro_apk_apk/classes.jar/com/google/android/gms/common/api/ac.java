package com.google.android.gms.common.api;

import android.support.v4.b.a;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.internal.ef;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class ac
  extends Exception
{
  private final a<ef<?>, ConnectionResult> HT;
  
  public ac(a<ef<?>, ConnectionResult> parama)
  {
    this.HT = parama;
  }
  
  public final ConnectionResult a(ad<? extends b> paramad)
  {
    paramad = paramad.gJ();
    if (this.HT.get(paramad) != null) {}
    for (boolean bool = true;; bool = false)
    {
      d.b(bool, "The given API was not part of the availability request.");
      return (ConnectionResult)this.HT.get(paramad);
    }
  }
  
  public final a<ef<?>, ConnectionResult> gH()
  {
    return this.HT;
  }
  
  public final String getMessage()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.HT.keySet().iterator();
    int i = 1;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (ef)((Iterator)localObject1).next();
      Object localObject2 = (ConnectionResult)this.HT.get(localObject3);
      if (((ConnectionResult)localObject2).gm()) {
        i = 0;
      }
      localObject3 = String.valueOf(((ef)localObject3).kk());
      localObject2 = String.valueOf(localObject2);
      localArrayList.add(String.valueOf(localObject3).length() + 2 + String.valueOf(localObject2).length() + (String)localObject3 + ": " + (String)localObject2);
    }
    localObject1 = new StringBuilder();
    if (i != 0) {
      ((StringBuilder)localObject1).append("None of the queried APIs are available. ");
    }
    for (;;)
    {
      ((StringBuilder)localObject1).append(TextUtils.join("; ", localArrayList));
      return ((StringBuilder)localObject1).toString();
      ((StringBuilder)localObject1).append("Some of the queried APIs are unavailable. ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.ac
 * JD-Core Version:    0.7.0.1
 */