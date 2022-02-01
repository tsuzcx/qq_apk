package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.Parcelable;
import android.util.Pair;

public abstract interface SchemeResolver
  extends Parcelable
{
  public abstract a hel();
  
  public static abstract interface a
  {
    public abstract Pair<FileSystem.b, String> a(k paramk, Uri paramUri);
    
    public abstract SchemeResolver hem();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.SchemeResolver
 * JD-Core Version:    0.7.0.1
 */