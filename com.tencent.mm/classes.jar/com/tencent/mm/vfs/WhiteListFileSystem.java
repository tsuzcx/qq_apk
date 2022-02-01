package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

class WhiteListFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<WhiteListFileSystem> CREATOR;
  final FileSystem YBI;
  final String[] YFH;
  
  static
  {
    AppMethodBeat.i(196286);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(196286);
  }
  
  WhiteListFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(196276);
    ad.a(paramParcel, WhiteListFileSystem.class, 1);
    this.YBI = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    this.YFH = paramParcel.createStringArray();
    AppMethodBeat.o(196276);
  }
  
  WhiteListFileSystem(FileSystem paramFileSystem, String[] paramArrayOfString)
  {
    AppMethodBeat.i(196273);
    this.YBI = paramFileSystem;
    this.YFH = new String[paramArrayOfString.length];
    int i = 0;
    if (i < paramArrayOfString.length)
    {
      paramFileSystem = paramArrayOfString[i];
      if ((paramFileSystem == null) || (paramFileSystem.isEmpty())) {
        this.YFH[i] = null;
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramFileSystem.charAt(paramFileSystem.length() - 1) == '*') {
          this.YFH[i] = (paramFileSystem.substring(0, paramFileSystem.length() - 1) + '\000');
        } else {
          this.YFH[i] = paramFileSystem;
        }
      }
    }
    AppMethodBeat.o(196273);
  }
  
  public final FileSystem.b cp(Map<String, String> paramMap)
  {
    AppMethodBeat.i(196281);
    if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED) && ((BuildInfo.CLIENT_VERSION_INT & 0xFF) >= 48))
    {
      paramMap = this.YBI.cp(paramMap);
      AppMethodBeat.o(196281);
      return paramMap;
    }
    TreeSet localTreeSet = new TreeSet();
    Object localObject = this.YFH;
    int j = localObject.length;
    int i = 0;
    String str;
    while (i < j)
    {
      str = ad.ad(localObject[i], paramMap);
      if ((str != null) && (!str.isEmpty()) && (!str.equals(""))) {
        localTreeSet.add(ad.r(str, true, true));
      }
      i += 1;
    }
    Iterator localIterator = localTreeSet.iterator();
    localObject = null;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if ((localObject != null) && (str.startsWith((String)localObject)) && (str.charAt(((String)localObject).length()) == '/')) {
        localIterator.remove();
      } else {
        localObject = str;
      }
    }
    paramMap = new a(this.YBI.cp(paramMap), (String[])localTreeSet.toArray(new String[0]));
    AppMethodBeat.o(196281);
    return paramMap;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(196285);
    ad.b(paramParcel, WhiteListFileSystem.class, 1);
    paramParcel.writeParcelable(this.YBI, paramInt);
    paramParcel.writeStringArray(this.YFH);
    AppMethodBeat.o(196285);
  }
  
  final class a
    extends d
  {
    final FileSystem.b YBJ;
    final List<FileSystem.b> YCf;
    final String[] YFH;
    
    a(FileSystem.b paramb, String[] paramArrayOfString)
    {
      AppMethodBeat.i(211146);
      this.YBJ = paramb;
      this.YCf = Collections.singletonList(paramb);
      this.YFH = paramArrayOfString;
      AppMethodBeat.o(211146);
    }
    
    public final boolean bBD(String paramString)
    {
      int j = 1;
      AppMethodBeat.i(211150);
      int i;
      if (!paramString.isEmpty())
      {
        i = Arrays.binarySearch(this.YFH, paramString + '\000');
        if (i < 0) {
          break label65;
        }
        i = j;
      }
      while (i != 0)
      {
        boolean bool = super.bBD(paramString);
        AppMethodBeat.o(211150);
        return bool;
        label65:
        i = -i - 2;
        if (i >= 0)
        {
          String str = this.YFH[i];
          if (str.charAt(str.length() - 1) == 0)
          {
            if (paramString.startsWith(str))
            {
              i = j;
              if (paramString.substring(str.length()).indexOf('/') == -1) {
                continue;
              }
            }
            i = 0;
            continue;
          }
          if (paramString.startsWith(str))
          {
            i = j;
            if (paramString.length() == str.length()) {
              continue;
            }
            i = j;
            if (paramString.charAt(str.length()) == '/') {
              continue;
            }
          }
        }
        i = 0;
      }
      Log.w("VFS.WhiteListFileSystem", "Path not in white list: " + paramString + " -> " + this.YBJ.ieX().toString());
      AppMethodBeat.o(211150);
      return false;
    }
    
    public final FileSystem.b hX(String paramString, int paramInt)
    {
      return this.YBJ;
    }
    
    public final FileSystem ieX()
    {
      return WhiteListFileSystem.this;
    }
    
    public final List<FileSystem.b> ifa()
    {
      return this.YCf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.WhiteListFileSystem
 * JD-Core Version:    0.7.0.1
 */