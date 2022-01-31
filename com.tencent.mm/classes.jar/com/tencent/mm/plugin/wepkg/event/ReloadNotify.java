package com.tencent.mm.plugin.wepkg.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashSet;
import java.util.Set;

public class ReloadNotify
  implements Parcelable
{
  public static Parcelable.Creator<ReloadNotify> CREATOR = new ReloadNotify.2();
  private static Set<String> rOR = new HashSet();
  public String[] rOS;
  
  private ReloadNotify(Parcel paramParcel)
  {
    this.rOS = paramParcel.createStringArray();
  }
  
  private ReloadNotify(String[] paramArrayOfString)
  {
    this.rOS = paramArrayOfString;
  }
  
  public static void cjW()
  {
    if (rOR.size() != 0) {
      b.a(new ReloadNotify((String[])rOR.toArray(new String[rOR.size()])), new ReloadNotify.1());
    }
  }
  
  public static void qh(String paramString)
  {
    rOR.add(paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStringArray(this.rOS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.event.ReloadNotify
 * JD-Core Version:    0.7.0.1
 */