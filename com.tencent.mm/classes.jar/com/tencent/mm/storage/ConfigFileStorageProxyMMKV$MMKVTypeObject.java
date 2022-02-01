package com.tencent.mm.storage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class ConfigFileStorageProxyMMKV$MMKVTypeObject
  implements Parcelable
{
  public static final Parcelable.Creator<MMKVTypeObject> CREATOR;
  Object object;
  String type;
  
  static
  {
    AppMethodBeat.i(133239);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(133239);
  }
  
  protected ConfigFileStorageProxyMMKV$MMKVTypeObject(Parcel paramParcel)
  {
    AppMethodBeat.i(133236);
    try
    {
      this.type = paramParcel.readString();
      return;
    }
    catch (RuntimeException paramParcel)
    {
      try
      {
        if ((!TextUtils.equals(this.type, HashMap.class.getSimpleName())) && (!TextUtils.equals(this.type, HashSet.class.getSimpleName()))) {
          TextUtils.equals(this.type, LinkedHashMap.class.getSimpleName());
        }
        paramParcel = paramParcel.readValue(null);
        if ((paramParcel instanceof ConfigFileStorageProxyMMKV.a))
        {
          this.object = ((ConfigFileStorageProxyMMKV.a)paramParcel).obj;
          AppMethodBeat.o(133236);
          return;
        }
        this.object = paramParcel;
        AppMethodBeat.o(133236);
        return;
      }
      catch (Exception paramParcel)
      {
        f.Ozc.idkeyStat(1041L, 44L, 1L, true);
        Log.printErrStackTrace("MicroMsg.ConfigFileStorageProxyMMKV", paramParcel, "MMKVTypeObject readValue error", new Object[0]);
        AppMethodBeat.o(133236);
      }
      paramParcel = paramParcel;
      Log.printErrStackTrace("MicroMsg.ConfigFileStorageProxyMMKV", paramParcel, "", new Object[0]);
      AppMethodBeat.o(133236);
      return;
    }
  }
  
  public ConfigFileStorageProxyMMKV$MMKVTypeObject(String paramString, Object paramObject)
  {
    AppMethodBeat.i(133235);
    this.type = paramString;
    if ((paramObject instanceof LinkedHashMap))
    {
      this.object = new ConfigFileStorageProxyMMKV.a(paramObject);
      AppMethodBeat.o(133235);
      return;
    }
    this.object = paramObject;
    AppMethodBeat.o(133235);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(133238);
    StringBuilder localStringBuilder = new StringBuilder("type = ").append(this.type).append(" object = ");
    if (this.object != null) {}
    for (String str = this.object.toString();; str = "")
    {
      str = str;
      AppMethodBeat.o(133238);
      return str;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(133237);
    try
    {
      paramParcel.writeString(this.type);
      paramParcel.writeValue(this.object);
      AppMethodBeat.o(133237);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      Log.printErrStackTrace("MicroMsg.ConfigFileStorageProxyMMKV", paramParcel, "", new Object[0]);
      AppMethodBeat.o(133237);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.ConfigFileStorageProxyMMKV.MMKVTypeObject
 * JD-Core Version:    0.7.0.1
 */