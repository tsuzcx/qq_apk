package com.tencent.mm.vfs;

import android.os.Parcel;

public abstract class SingletonSchemeResolver
  implements SchemeResolver, SchemeResolver.a
{
  public int describeContents()
  {
    return 0;
  }
  
  public final SchemeResolver.a fTc()
  {
    return this;
  }
  
  public final SchemeResolver fTd()
  {
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.SingletonSchemeResolver
 * JD-Core Version:    0.7.0.1
 */