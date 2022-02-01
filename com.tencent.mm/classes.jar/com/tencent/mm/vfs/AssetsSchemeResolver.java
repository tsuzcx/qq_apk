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
  private final AssetsFileSystem LFD;
  
  static
  {
    AppMethodBeat.i(13038);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(13038);
  }
  
  private AssetsSchemeResolver()
  {
    AppMethodBeat.i(13036);
    this.LFD = new AssetsFileSystem(e.fSU().mContext);
    AppMethodBeat.o(13036);
  }
  
  public static AssetsSchemeResolver fSJ()
  {
    return a.LFF;
  }
  
  public final Pair<FileSystem.b, String> a(g paramg, Uri paramUri)
  {
    AppMethodBeat.i(193353);
    paramg = paramUri.getPath();
    if (paramg == null) {}
    for (paramg = "";; paramg = w.o(paramg, true, true))
    {
      paramg = Pair.create(this.LFD, paramg);
      AppMethodBeat.o(193353);
      return paramg;
    }
  }
  
  static final class AssetsFileSystem
    extends a
    implements FileSystem
  {
    public static final Parcelable.Creator<AssetsFileSystem> CREATOR = null;
    private AssetManager LFE;
    
    AssetsFileSystem(Context paramContext)
    {
      AppMethodBeat.i(13024);
      this.LFE = paramContext.getAssets();
      AppMethodBeat.o(13024);
    }
    
    private void c(String paramString1, String paramString2, ArrayList<c> paramArrayList)
    {
      AppMethodBeat.i(13030);
      if ((paramString2 != null) && (!paramString2.isEmpty())) {
        if (paramString1.isEmpty()) {
          paramString1 = paramString2;
        }
      }
      for (;;)
      {
        String[] arrayOfString = this.LFE.list(paramString1);
        if ((arrayOfString == null) || (arrayOfString.length == 0))
        {
          if (paramString2 != null)
          {
            paramArrayList.add(new c(this, paramString1, paramString2, 0L, 0L, 0L, false));
            AppMethodBeat.o(13030);
            return;
            paramString1 = paramString1 + '/' + paramString2;
          }
        }
        else
        {
          if (paramString2 != null) {
            paramArrayList.add(new c(this, paramString1, paramString2, 0L, 0L, 0L, true));
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
    
    public final boolean Dc(String paramString)
    {
      return false;
    }
    
    public final FileSystem.a aZF(String paramString)
    {
      AppMethodBeat.i(13025);
      paramString = new FileSystem.a();
      AppMethodBeat.o(13025);
      return paramString;
    }
    
    public final boolean aZG(String paramString)
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
    
    public final c aZH(String paramString)
    {
      AppMethodBeat.i(193350);
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
            paramString = new c(this, paramString, (String)localObject, i, 0L, 0L, false);
            AppMethodBeat.o(193350);
            return paramString;
          }
        }
        catch (IOException paramString)
        {
          AppMethodBeat.o(193350);
          return null;
        }
        Object localObject = paramString.substring(j + 1);
      }
    }
    
    public final boolean aZI(String paramString)
    {
      return false;
    }
    
    protected final boolean b(String paramString1, FileSystem.b paramb, String paramString2)
    {
      AppMethodBeat.i(193351);
      paramString1 = new IOException("Not implemented");
      AppMethodBeat.o(193351);
      throw paramString1;
    }
    
    public final FileSystem.b cd(Map<String, String> paramMap)
    {
      return this;
    }
    
    public final boolean cp(String paramString, long paramLong)
    {
      return false;
    }
    
    protected final long d(String paramString1, FileSystem.b paramb, String paramString2)
    {
      AppMethodBeat.i(193352);
      paramString1 = new IOException("Not implemented");
      AppMethodBeat.o(193352);
      throw paramString1;
    }
    
    public final OutputStream db(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(13027);
      paramString = new FileNotFoundException("Cannot open files for writing on read-only filesystems");
      AppMethodBeat.o(13027);
      throw paramString;
    }
    
    public final Iterable<c> dc(String paramString, boolean paramBoolean)
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
      paramString = this.LFE.list(str1);
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
        arrayOfString = this.LFE.list(str3);
        if ((arrayOfString != null) && (arrayOfString.length > 0)) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          localArrayList.add(new c(this, str3, str2, 0L, 0L, 0L, paramBoolean));
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(13031);
      return localArrayList;
      return null;
    }
    
    public final boolean dd(String paramString, boolean paramBoolean)
    {
      return false;
    }
    
    public final String de(String paramString, boolean paramBoolean)
    {
      return null;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final FileSystem fSK()
    {
      return this;
    }
    
    public final int fSL()
    {
      return 12;
    }
    
    public final InputStream openRead(String paramString)
    {
      AppMethodBeat.i(13026);
      try
      {
        paramString = this.LFE.open(paramString);
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
    static final AssetsSchemeResolver LFF;
    
    static
    {
      AppMethodBeat.i(13035);
      LFF = new AssetsSchemeResolver((byte)0);
      AppMethodBeat.o(13035);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.AssetsSchemeResolver
 * JD-Core Version:    0.7.0.1
 */