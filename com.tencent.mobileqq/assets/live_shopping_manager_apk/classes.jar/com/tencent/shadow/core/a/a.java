package com.tencent.shadow.core.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class a
  implements Parcelable
{
  public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator()
  {
    public a a(Parcel paramAnonymousParcel)
    {
      return new a(paramAnonymousParcel);
    }
    
    public a[] a(int paramAnonymousInt)
    {
      return new a[paramAnonymousInt];
    }
  };
  public final String a;
  public final String b;
  public final String[] c;
  public final String[] d;
  
  public a(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.createStringArray();
    this.d = paramParcel.createStringArray();
  }
  
  public a(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramArrayOfString1;
    this.d = paramArrayOfString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeStringArray(this.c);
    paramParcel.writeStringArray(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.a.a
 * JD-Core Version:    0.7.0.1
 */