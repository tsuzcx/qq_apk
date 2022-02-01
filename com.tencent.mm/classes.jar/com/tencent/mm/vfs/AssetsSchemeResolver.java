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
  private final AssetsFileSystem RaT;
  
  static
  {
    AppMethodBeat.i(13038);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(13038);
  }
  
  private AssetsSchemeResolver()
  {
    AppMethodBeat.i(13036);
    this.RaT = new AssetsFileSystem(g.hRR().mContext);
    AppMethodBeat.o(13036);
  }
  
  public static AssetsSchemeResolver hdP()
  {
    return a.RaV;
  }
  
  public final Pair<FileSystem.b, String> a(k paramk, Uri paramUri)
  {
    AppMethodBeat.i(187626);
    paramk = paramUri.getPath();
    if (paramk == null) {}
    for (paramk = "";; paramk = aa.q(paramk, true, true))
    {
      paramk = Pair.create(this.RaT, paramk);
      AppMethodBeat.o(187626);
      return paramk;
    }
  }
  
  static final class AssetsFileSystem
    extends a
    implements FileSystem
  {
    public static final Parcelable.Creator<AssetsFileSystem> CREATOR = null;
    private final AssetManager RaU;
    
    AssetsFileSystem(Context paramContext)
    {
      AppMethodBeat.i(13024);
      this.RaU = paramContext.getAssets();
      AppMethodBeat.o(13024);
    }
    
    private void c(String paramString1, String paramString2, ArrayList<e> paramArrayList)
    {
      AppMethodBeat.i(13030);
      if ((paramString2 != null) && (!paramString2.isEmpty())) {
        if (paramString1.isEmpty()) {
          paramString1 = paramString2;
        }
      }
      for (;;)
      {
        String[] arrayOfString = this.RaU.list(paramString1);
        if ((arrayOfString == null) || (arrayOfString.length == 0))
        {
          if (paramString2 != null)
          {
            paramArrayList.add(new e(this, paramString1, paramString2, 0L, 0L, 0L, false));
            AppMethodBeat.o(13030);
            return;
            paramString1 = paramString1 + '/' + paramString2;
          }
        }
        else
        {
          if (paramString2 != null) {
            paramArrayList.add(new e(this, paramString1, paramString2, 0L, 0L, 0L, true));
          }
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            paramString2 = arrayOfString[i];
            if ((paramString2 != null) && (!paramString2.isEmpty())) {
              c(paramString1, paramString2, paramArrayList);
            }
            i += 1;
          }
        }
        AppMethodBeat.o(13030);
        return;
      }
    }
    
    protected final boolean b(String paramString1, FileSystem.b paramb, String paramString2)
    {
      AppMethodBeat.i(187624);
      paramString1 = new IOException("Not implemented");
      AppMethodBeat.o(187624);
      throw paramString1;
    }
    
    public final FileSystem.a boK(String paramString)
    {
      AppMethodBeat.i(13025);
      paramString = new FileSystem.a();
      AppMethodBeat.o(13025);
      return paramString;
    }
    
    public final boolean boL(String paramString)
    {
      AppMethodBeat.i(13028);
      try
      {
        openRead(paramString).close();
        AppMethodBeat.o(13028);
        return true;
      }
      catch (IOException paramString)
      {
        AppMethodBeat.o(13028);
      }
      return false;
    }
    
    public final e boM(String paramString)
    {
      AppMethodBeat.i(187623);
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
            paramString = new e(this, paramString, (String)localObject, i, 0L, 0L, false);
            AppMethodBeat.o(187623);
            return paramString;
          }
        }
        catch (IOException paramString)
        {
          AppMethodBeat.o(187623);
          return null;
        }
        Object localObject = paramString.substring(j + 1);
      }
    }
    
    public final boolean boN(String paramString)
    {
      return false;
    }
    
    public final FileSystem.b cj(Map<String, String> paramMap)
    {
      return this;
    }
    
    public final boolean ck(String paramString, long paramLong)
    {
      return false;
    }
    
    protected final long d(String paramString1, FileSystem.b paramb, String paramString2)
    {
      AppMethodBeat.i(187625);
      paramString1 = new IOException("Not implemented");
      AppMethodBeat.o(187625);
      throw paramString1;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final OutputStream dw(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(13027);
      paramString = new FileNotFoundException("Cannot open files for writing on read-only filesystems");
      AppMethodBeat.o(13027);
      throw paramString;
    }
    
    public final Iterable<e> dx(String paramString, boolean paramBoolean)
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
        c(str1, null, paramString);
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
      paramString = this.RaU.list(str1);
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
        arrayOfString = this.RaU.list(str3);
        if ((arrayOfString != null) && (arrayOfString.length > 0)) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          localArrayList.add(new e(this, str3, str2, 0L, 0L, 0L, paramBoolean));
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(13031);
      return localArrayList;
      return null;
    }
    
    public final boolean dy(String paramString, boolean paramBoolean)
    {
      return false;
    }
    
    public final String dz(String paramString, boolean paramBoolean)
    {
      return null;
    }
    
    public final boolean gC(String paramString)
    {
      return false;
    }
    
    public final FileSystem hdQ()
    {
      return this;
    }
    
    public final int hdR()
    {
      return 12;
    }
    
    public final InputStream openRead(String paramString)
    {
      AppMethodBeat.i(13026);
      try
      {
        paramString = this.RaU.open(paramString);
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
  
  static final class a
    implements Parcelable.Creator<AssetsSchemeResolver>
  {
    static final AssetsSchemeResolver RaV;
    
    static
    {
      AppMethodBeat.i(13035);
      RaV = new AssetsSchemeResolver((byte)0);
      AppMethodBeat.o(13035);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.AssetsSchemeResolver
 * JD-Core Version:    0.7.0.1
 */