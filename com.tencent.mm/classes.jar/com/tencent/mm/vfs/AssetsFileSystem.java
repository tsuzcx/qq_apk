package com.tencent.mm.vfs;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

final class AssetsFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<AssetsFileSystem> CREATOR = null;
  private Context mContext;
  
  AssetsFileSystem(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final OutputStream I(String paramString, boolean paramBoolean)
  {
    throw new IOException("Cannot open files for writing on read-only file systems");
  }
  
  public final List<FileSystem.a> J(String paramString, boolean paramBoolean)
  {
    try
    {
      String[] arrayOfString = this.mContext.getAssets().list(paramString);
      ArrayList localArrayList = new ArrayList(arrayOfString.length);
      int j = arrayOfString.length;
      int i = 0;
      if (i < j)
      {
        String str = arrayOfString[i];
        int k = str.lastIndexOf('/');
        if (k < 0) {}
        for (paramString = str;; paramString = str.substring(k + 1))
        {
          localArrayList.add(new FileSystem.a(this, str, paramString, 0L, 0L, 0L, false));
          i += 1;
          break;
        }
      }
      return localArrayList;
    }
    catch (IOException paramString) {}
    return null;
  }
  
  public final boolean K(String paramString, boolean paramBoolean)
  {
    return false;
  }
  
  public final String L(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public final int Qd()
  {
    return 8;
  }
  
  public final boolean aC(String paramString1, String paramString2)
  {
    return false;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean exists(String paramString)
  {
    try
    {
      openRead(paramString).close();
      return true;
    }
    catch (IOException paramString) {}
    return false;
  }
  
  public final boolean jJ(String paramString)
  {
    return false;
  }
  
  public final FileSystem.b mZ(String paramString)
  {
    return new FileSystem.b();
  }
  
  public final FileSystem.a na(String paramString)
  {
    for (;;)
    {
      int j;
      try
      {
        localObject = openRead(paramString);
        int i = ((InputStream)localObject).available();
        ((InputStream)localObject).close();
        j = paramString.lastIndexOf('/');
        if (j < 0)
        {
          localObject = paramString;
          return new FileSystem.a(this, paramString, (String)localObject, i, 0L, 0L, false);
        }
      }
      catch (IOException paramString)
      {
        return null;
      }
      Object localObject = paramString.substring(j + 1);
    }
  }
  
  public final boolean nb(String paramString)
  {
    return false;
  }
  
  public final InputStream openRead(String paramString)
  {
    return this.mContext.getAssets().open(paramString);
  }
  
  public final boolean r(String paramString, long paramLong)
  {
    return false;
  }
  
  public final String toString()
  {
    return "AssetsFS";
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.AssetsFileSystem
 * JD-Core Version:    0.7.0.1
 */