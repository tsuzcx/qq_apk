package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import java.util.List;
import java.util.Map;

public abstract interface SchemeResolver
  extends Parcelable
{
  public abstract Pair<FileSystem, String> a(b paramb, Uri paramUri);
  
  public static abstract class Base
    implements SchemeResolver
  {
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt) {}
  }
  
  public static class a
  {
    public final FileSystem LjM;
    public final String Lla;
    public final String basePath;
    
    a(String paramString1, String paramString2, FileSystem paramFileSystem)
    {
      this.basePath = paramString1;
      this.Lla = paramString2;
      this.LjM = paramFileSystem;
    }
  }
  
  public static abstract interface b
  {
    public abstract Map<String, FileSystem> fOD();
    
    public abstract List<SchemeResolver.a> fOE();
    
    public abstract Map<String, String> fOF();
    
    public abstract FileSystem fOG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.SchemeResolver
 * JD-Core Version:    0.7.0.1
 */