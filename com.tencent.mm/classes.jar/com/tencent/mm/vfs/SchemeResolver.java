package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.Parcelable;
import android.util.Pair;

public abstract interface SchemeResolver
  extends Parcelable, d<a>
{
  public static abstract interface a
  {
    public abstract Pair<FileSystem.b, String> a(o paramo, Uri paramUri);
    
    public abstract SchemeResolver jKK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.SchemeResolver
 * JD-Core Version:    0.7.0.1
 */