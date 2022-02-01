package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;

public abstract interface SchemeResolver
  extends Parcelable
{
  public abstract Pair<FileSystem, String> a(a parama, Uri paramUri);
  
  public static abstract class Base
    implements SchemeResolver
  {
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt) {}
  }
  
  public static abstract interface a
  {
    public abstract FileSystem fxR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.SchemeResolver
 * JD-Core Version:    0.7.0.1
 */