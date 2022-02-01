package com.tencent.mm.vfs;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;

public final class AssetsSchemeResolver
  extends SingletonSchemeResolver
{
  public static final a CREATOR;
  private final AssetsFileSystem YBj;
  
  static
  {
    AppMethodBeat.i(13038);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(13038);
  }
  
  private AssetsSchemeResolver()
  {
    AppMethodBeat.i(13036);
    this.YBj = new AssetsFileSystem(h.iWH().mContext);
    AppMethodBeat.o(13036);
  }
  
  public static AssetsSchemeResolver ieW()
  {
    return a.YBl;
  }
  
  public final Pair<FileSystem.b, String> a(l paraml, Uri paramUri)
  {
    AppMethodBeat.i(235922);
    paraml = paramUri.getPath();
    if (paraml == null) {}
    for (paraml = "";; paraml = ad.r(paraml, true, true))
    {
      paraml = Pair.create(this.YBj, paraml);
      AppMethodBeat.o(235922);
      return paraml;
    }
  }
  
  static final class AssetsFileSystem
    extends a
    implements FileSystem
  {
    public static final Parcelable.Creator<AssetsFileSystem> CREATOR = null;
    private final AssetManager YBk;
    
    AssetsFileSystem(Context paramContext)
    {
      AppMethodBeat.i(13024);
      this.YBk = paramContext.getAssets();
      AppMethodBeat.o(13024);
    }
    
    private void b(String paramString1, String paramString2, ArrayList<f> paramArrayList)
    {
      AppMethodBeat.i(13030);
      if ((paramString2 != null) && (!paramString2.isEmpty())) {
        if (paramString1.isEmpty()) {
          paramString1 = paramString2;
        }
      }
      for (;;)
      {
        String[] arrayOfString = this.YBk.list(paramString1);
        if ((arrayOfString == null) || (arrayOfString.length == 0))
        {
          if (paramString2 != null)
          {
            paramArrayList.add(new f(this, paramString1, paramString2, 0L, 0L, 0L, false));
            AppMethodBeat.o(13030);
            return;
            paramString1 = paramString1 + '/' + paramString2;
          }
        }
        else
        {
          if (paramString2 != null) {
            paramArrayList.add(new f(this, paramString1, paramString2, 0L, 0L, 0L, true));
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
        AppMethodBeat.o(13030);
        return;
      }
    }
    
    public final InputStream Tf(String paramString)
    {
      AppMethodBeat.i(13026);
      try
      {
        paramString = this.YBk.open(paramString);
        AppMethodBeat.o(13026);
        return paramString;
      }
      catch (IOException paramString)
      {
        if ((paramString instanceof FileNotFoundException))
        {
          paramString = (FileNotFoundException)paramString;
          AppMethodBeat.o(13026);
          throw paramString;
        }
        paramString = new FileNotFoundException(paramString.getMessage());
        AppMethodBeat.o(13026);
        throw paramString;
      }
    }
    
    protected final long b(String paramString1, FileSystem.b paramb, String paramString2, boolean paramBoolean)
    {
      AppMethodBeat.i(235901);
      paramString1 = new IOException("Not implemented");
      AppMethodBeat.o(235901);
      throw paramString1;
    }
    
    protected final boolean b(String paramString1, FileSystem.b paramb, String paramString2)
    {
      AppMethodBeat.i(235899);
      paramString1 = new IOException("Not implemented");
      AppMethodBeat.o(235899);
      throw paramString1;
    }
    
    public final FileSystem.a bBA(String paramString)
    {
      AppMethodBeat.i(13025);
      paramString = new FileSystem.a();
      AppMethodBeat.o(13025);
      return paramString;
    }
    
    public final boolean bBB(String paramString)
    {
      AppMethodBeat.i(13028);
      try
      {
        Tf(paramString).close();
        AppMethodBeat.o(13028);
        return true;
      }
      catch (IOException paramString)
      {
        AppMethodBeat.o(13028);
      }
      return false;
    }
    
    public final f bBC(String paramString)
    {
      AppMethodBeat.i(235892);
      for (;;)
      {
        int j;
        try
        {
          localObject = Tf(paramString);
          int i = ((InputStream)localObject).available();
          ((InputStream)localObject).close();
          j = paramString.lastIndexOf('/');
          if (j < 0)
          {
            localObject = paramString;
            paramString = new f(this, paramString, (String)localObject, i, 0L, 0L, false);
            AppMethodBeat.o(235892);
            return paramString;
          }
        }
        catch (IOException paramString)
        {
          AppMethodBeat.o(235892);
          return null;
        }
        Object localObject = paramString.substring(j + 1);
      }
    }
    
    public final boolean bBD(String paramString)
    {
      return false;
    }
    
    public final FileSystem.b cp(Map<String, String> paramMap)
    {
      return this;
    }
    
    public final boolean ct(String paramString, long paramLong)
    {
      return false;
    }
    
    public final OutputStream dI(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(13027);
      paramString = new FileNotFoundException("Cannot open files for writing on read-only filesystems");
      AppMethodBeat.o(13027);
      throw paramString;
    }
    
    public final Iterable<f> dJ(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(13031);
      String str1 = paramString;
      if (paramString.endsWith("/")) {
        str1 = paramString.substring(0, paramString.length() - 1);
      }
      if (paramBoolean) {}
      try
      {
        paramString = new ArrayList();
        b(str1, null, paramString);
        AppMethodBeat.o(13031);
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
        AppMethodBeat.o(13031);
      }
      paramString = this.YBk.list(str1);
      if (paramString == null)
      {
        AppMethodBeat.o(13031);
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
        arrayOfString = this.YBk.list(str3);
        if ((arrayOfString != null) && (arrayOfString.length > 0)) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          localArrayList.add(new f(this, str3, str2, 0L, 0L, 0L, paramBoolean));
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(13031);
      return localArrayList;
      return null;
    }
    
    public final boolean dK(String paramString, boolean paramBoolean)
    {
      return false;
    }
    
    public final String dL(String paramString, boolean paramBoolean)
    {
      return null;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean ho(String paramString)
    {
      return false;
    }
    
    public final FileSystem ieX()
    {
      return this;
    }
    
    public final int ieY()
    {
      return 12;
    }
    
    public final String toString()
    {
      return "AssetsFS";
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(13034);
      paramParcel = new UnsupportedOperationException();
      AppMethodBeat.o(13034);
      throw paramParcel;
    }
  }
  
  static class a
    implements Parcelable.Creator<AssetsSchemeResolver>
  {
    static final AssetsSchemeResolver YBl;
    
    static
    {
      AppMethodBeat.i(13035);
      YBl = new AssetsSchemeResolver((byte)0);
      AppMethodBeat.o(13035);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.AssetsSchemeResolver
 * JD-Core Version:    0.7.0.1
 */