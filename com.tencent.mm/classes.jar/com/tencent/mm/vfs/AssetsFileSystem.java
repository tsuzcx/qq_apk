package com.tencent.mm.vfs;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

final class AssetsFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<AssetsFileSystem> CREATOR = null;
  private AssetManager APh;
  
  AssetsFileSystem(Context paramContext)
  {
    AppMethodBeat.i(54474);
    this.APh = paramContext.getAssets();
    AppMethodBeat.o(54474);
  }
  
  private void b(String paramString1, String paramString2, ArrayList<FileSystem.a> paramArrayList)
  {
    AppMethodBeat.i(54480);
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      paramString1 = paramString1 + '/' + paramString2;
    }
    for (;;)
    {
      String[] arrayOfString = this.APh.list(paramString1);
      if ((arrayOfString == null) || (arrayOfString.length == 0))
      {
        if (paramString2 != null)
        {
          paramArrayList.add(new FileSystem.a(this, paramString1, paramString2, 0L, 0L, 0L, false));
          AppMethodBeat.o(54480);
        }
      }
      else
      {
        if (paramString2 != null) {
          paramArrayList.add(new FileSystem.a(this, paramString1, paramString2, 0L, 0L, 0L, true));
        }
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          paramString2 = arrayOfString[i];
          if ((paramString2 != null) && (!paramString2.isEmpty())) {
            b(paramString1, paramString2, paramArrayList);
          }
          i += 1;
        }
      }
      AppMethodBeat.o(54480);
      return;
    }
  }
  
  public final boolean A(String paramString, long paramLong)
  {
    return false;
  }
  
  public final OutputStream M(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(54477);
    paramString = new IOException("Cannot open files for writing on read-only file systems");
    AppMethodBeat.o(54477);
    throw paramString;
  }
  
  public final List<FileSystem.a> N(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(54481);
    String str1 = paramString;
    if (paramString.endsWith("/")) {
      str1 = paramString.substring(0, paramString.length() - 1);
    }
    if (paramBoolean) {}
    try
    {
      paramString = new ArrayList();
      b(str1, null, paramString);
      AppMethodBeat.o(54481);
      return paramString;
    }
    catch (IOException paramString)
    {
      ArrayList localArrayList;
      int j;
      int i;
      String str2;
      String str3;
      String[] arrayOfString;
      AppMethodBeat.o(54481);
    }
    paramString = this.APh.list(str1);
    if (paramString == null)
    {
      AppMethodBeat.o(54481);
      return null;
    }
    str1 = str1 + '/';
    localArrayList = new ArrayList(paramString.length);
    j = paramString.length;
    i = 0;
    if (i < j)
    {
      str2 = paramString[i];
      str3 = str1 + str2;
      arrayOfString = this.APh.list(str3);
      if ((arrayOfString != null) && (arrayOfString.length > 0)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localArrayList.add(new FileSystem.a(this, str3, str2, 0L, 0L, 0L, paramBoolean));
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(54481);
    return localArrayList;
    return null;
  }
  
  public final boolean O(String paramString, boolean paramBoolean)
  {
    return false;
  }
  
  public final String P(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public final boolean aV(String paramString1, String paramString2)
  {
    return false;
  }
  
  public final int ajj()
  {
    return 40;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean exists(String paramString)
  {
    AppMethodBeat.i(54478);
    try
    {
      openRead(paramString).close();
      AppMethodBeat.o(54478);
      return true;
    }
    catch (IOException paramString)
    {
      AppMethodBeat.o(54478);
    }
    return false;
  }
  
  public final InputStream openRead(String paramString)
  {
    AppMethodBeat.i(54476);
    paramString = this.APh.open(paramString);
    AppMethodBeat.o(54476);
    return paramString;
  }
  
  public final boolean qD(String paramString)
  {
    return false;
  }
  
  public final String toString()
  {
    return "AssetsFS";
  }
  
  public final FileSystem.b uk(String paramString)
  {
    AppMethodBeat.i(54475);
    paramString = new FileSystem.b();
    AppMethodBeat.o(54475);
    return paramString;
  }
  
  public final FileSystem.a ul(String paramString)
  {
    AppMethodBeat.i(54479);
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
          paramString = new FileSystem.a(this, paramString, (String)localObject, i, 0L, 0L, false);
          AppMethodBeat.o(54479);
          return paramString;
        }
      }
      catch (IOException paramString)
      {
        AppMethodBeat.o(54479);
        return null;
      }
      Object localObject = paramString.substring(j + 1);
    }
  }
  
  public final boolean um(String paramString)
  {
    return false;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(54482);
    paramParcel = new UnsupportedOperationException();
    AppMethodBeat.o(54482);
    throw paramParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.AssetsFileSystem
 * JD-Core Version:    0.7.0.1
 */