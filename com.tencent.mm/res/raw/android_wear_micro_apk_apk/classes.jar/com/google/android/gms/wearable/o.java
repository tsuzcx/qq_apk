package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.dh;
import com.google.android.gms.internal.di;
import com.google.android.gms.internal.dj;
import com.google.android.gms.internal.dv;
import com.google.android.gms.internal.dw;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class o
{
  private final Uri Kv;
  private final n Uh;
  
  private o(l paraml)
  {
    this.Kv = paraml.getUri();
    this.Uh = b((l)paraml.freeze());
  }
  
  public static o a(l paraml)
  {
    if (paraml == null) {
      throw new IllegalStateException("provided dataItem is null");
    }
    return new o(paraml);
  }
  
  private static n b(l paraml)
  {
    if ((paraml.getData() == null) && (paraml.kE().size() > 0)) {
      throw new IllegalArgumentException("Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.");
    }
    if (paraml.getData() == null) {
      return new n();
    }
    try
    {
      localObject1 = new ArrayList();
      j = paraml.kE().size();
      i = 0;
    }
    catch (dv localdv)
    {
      for (;;)
      {
        Object localObject1;
        int j;
        int i;
        localObject2 = String.valueOf(paraml.getUri());
        String str = String.valueOf(Base64.encodeToString(paraml.getData(), 0));
        Log.w("DataItem", String.valueOf(localObject2).length() + 50 + String.valueOf(str).length() + "Unable to parse datamap from dataItem. uri=" + (String)localObject2 + ", data=" + str);
        paraml = String.valueOf(paraml.getUri());
        throw new IllegalStateException(String.valueOf(paraml).length() + 44 + "Unable to parse datamap from dataItem.  uri=" + paraml, localdv);
        localdv.add(Asset.t(((m)localObject2).getId()));
        i += 1;
      }
      Object localObject2 = paraml.getData();
      n localn = dh.a(new di((dj)dw.a(new dj(), (byte[])localObject2, localObject2.length), localdv));
      return localn;
    }
    catch (NullPointerException localNullPointerException)
    {
      break label154;
    }
    if (i < j)
    {
      localObject2 = (m)paraml.kE().get(Integer.toString(i));
      if (localObject2 == null)
      {
        localObject1 = String.valueOf(paraml);
        throw new IllegalStateException(String.valueOf(localObject1).length() + 64 + "Cannot find DataItemAsset referenced in data at " + i + " for " + (String)localObject1);
      }
    }
  }
  
  public final n kG()
  {
    return this.Uh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.o
 * JD-Core Version:    0.7.0.1
 */