package com.tencent.mm.ui.mmfb.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class LoginMethodHandler
  implements Parcelable
{
  Map<String, String> afAd;
  protected LoginClient afAe;
  
  LoginMethodHandler(Parcel paramParcel)
  {
    this.afAd = v(paramParcel);
  }
  
  LoginMethodHandler(LoginClient paramLoginClient)
  {
    this.afAe = paramLoginClient;
  }
  
  public static void a(Parcel paramParcel, Map<String, String> paramMap)
  {
    if (paramMap == null) {
      paramParcel.writeInt(-1);
    }
    for (;;)
    {
      return;
      paramParcel.writeInt(paramMap.size());
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        paramParcel.writeString((String)localEntry.getKey());
        paramParcel.writeString((String)localEntry.getValue());
      }
    }
  }
  
  private static Map<String, String> v(Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    Object localObject;
    if (j < 0)
    {
      localObject = null;
      return localObject;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    for (;;)
    {
      localObject = localHashMap;
      if (i >= j) {
        break;
      }
      localHashMap.put(paramParcel.readString(), paramParcel.readString());
      i += 1;
    }
  }
  
  final void a(LoginClient paramLoginClient)
  {
    if (this.afAe != null) {
      throw new RuntimeException("Can't set LoginClient if it is already set.");
    }
    this.afAe = paramLoginClient;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, this.afAd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.mmfb.sdk.LoginMethodHandler
 * JD-Core Version:    0.7.0.1
 */