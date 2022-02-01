package io.flutter.a.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements io.flutter.embedding.engine.plugins.a, k.c
{
  public Context context;
  public k vCn;
  
  private List<String> bbZ(String paramString)
  {
    AppMethodBeat.i(209390);
    ArrayList localArrayList = new ArrayList();
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramString = this.context.getExternalFilesDirs(paramString);
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (localObject != null) {
          localArrayList.add(localObject.getAbsolutePath());
        }
        i += 1;
      }
    }
    paramString = this.context.getExternalFilesDir(paramString);
    if (paramString != null) {
      localArrayList.add(paramString.getAbsolutePath());
    }
    AppMethodBeat.o(209390);
    return localArrayList;
  }
  
  public final void a(j paramj, k.d paramd)
  {
    Object localObject = null;
    int j = 0;
    AppMethodBeat.i(153351);
    String str = paramj.method;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramd.djR();
        AppMethodBeat.o(153351);
        return;
        if (str.equals("getTemporaryDirectory"))
        {
          i = 0;
          continue;
          if (str.equals("getApplicationDocumentsDirectory"))
          {
            i = 1;
            continue;
            if (str.equals("getStorageDirectory"))
            {
              i = 2;
              continue;
              if (str.equals("getExternalCacheDirectories"))
              {
                i = 3;
                continue;
                if (str.equals("getExternalStorageDirectories"))
                {
                  i = 4;
                  continue;
                  if (str.equals("getApplicationSupportDirectory")) {
                    i = 5;
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    paramd.de(this.context.getCacheDir().getPath());
    AppMethodBeat.o(153351);
    return;
    paramd.de(this.context.getDir("flutter", 0).getPath());
    AppMethodBeat.o(153351);
    return;
    paramj = this.context.getExternalFilesDir(null);
    if (paramj == null) {}
    for (paramj = null;; paramj = paramj.getAbsolutePath())
    {
      paramd.de(paramj);
      AppMethodBeat.o(153351);
      return;
    }
    paramj = new ArrayList();
    if (Build.VERSION.SDK_INT >= 19)
    {
      localObject = this.context.getExternalCacheDirs();
      int k = localObject.length;
      i = j;
      while (i < k)
      {
        str = localObject[i];
        if (str != null) {
          paramj.add(str.getAbsolutePath());
        }
        i += 1;
      }
    }
    localObject = this.context.getExternalCacheDir();
    if (localObject != null) {
      paramj.add(((File)localObject).getAbsolutePath());
    }
    paramd.de(paramj);
    AppMethodBeat.o(153351);
    return;
    paramj = (Integer)paramj.wd("type");
    if (paramj == null) {
      paramj = (j)localObject;
    }
    for (;;)
    {
      paramd.de(bbZ(paramj));
      AppMethodBeat.o(153351);
      return;
      switch (paramj.intValue())
      {
      default: 
        paramj = new IllegalArgumentException("Unknown index: ".concat(String.valueOf(paramj)));
        AppMethodBeat.o(153351);
        throw paramj;
      case 0: 
        paramj = Environment.DIRECTORY_MUSIC;
        break;
      case 1: 
        paramj = Environment.DIRECTORY_PODCASTS;
        break;
      case 2: 
        paramj = Environment.DIRECTORY_RINGTONES;
        break;
      case 3: 
        paramj = Environment.DIRECTORY_ALARMS;
        break;
      case 4: 
        paramj = Environment.DIRECTORY_NOTIFICATIONS;
        break;
      case 5: 
        paramj = Environment.DIRECTORY_PICTURES;
        break;
      case 6: 
        paramj = Environment.DIRECTORY_MOVIES;
        break;
      case 7: 
        paramj = Environment.DIRECTORY_DOWNLOADS;
        break;
      case 8: 
        paramj = Environment.DIRECTORY_DCIM;
        break;
      case 9: 
        if (Build.VERSION.SDK_INT < 19) {
          break label610;
        }
        paramj = Environment.DIRECTORY_DOCUMENTS;
      }
    }
    label610:
    paramj = new IllegalArgumentException("Documents directory is unsupported.");
    AppMethodBeat.o(153351);
    throw paramj;
    paramd.de(this.context.getFilesDir().getPath());
    AppMethodBeat.o(153351);
  }
  
  public final void geT()
  {
    AppMethodBeat.i(209389);
    this.vCn.a(null);
    this.vCn = null;
    AppMethodBeat.o(209389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.a.a.a
 * JD-Core Version:    0.7.0.1
 */