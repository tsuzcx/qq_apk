package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WhiteListFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<WhiteListFileSystem> CREATOR;
  private static final Pattern agBp;
  final String[] agBo;
  final FileSystem agvG;
  
  static
  {
    AppMethodBeat.i(238468);
    agBp = Pattern.compile("^[0-9a-f]{32}");
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(238468);
  }
  
  WhiteListFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(238457);
    ah.a(paramParcel, WhiteListFileSystem.class, 1);
    this.agvG = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    this.agBo = paramParcel.createStringArray();
    AppMethodBeat.o(238457);
  }
  
  WhiteListFileSystem(FileSystem paramFileSystem, String[] paramArrayOfString)
  {
    AppMethodBeat.i(238451);
    this.agvG = paramFileSystem;
    this.agBo = new String[paramArrayOfString.length];
    int i = 0;
    if (i < paramArrayOfString.length)
    {
      paramFileSystem = paramArrayOfString[i];
      if ((paramFileSystem == null) || (paramFileSystem.isEmpty())) {
        this.agBo[i] = null;
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramFileSystem.charAt(paramFileSystem.length() - 1) == '*') {
          this.agBo[i] = (paramFileSystem.substring(0, paramFileSystem.length() - 1) + '\000');
        } else {
          this.agBo[i] = paramFileSystem;
        }
      }
    }
    AppMethodBeat.o(238451);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(238473);
    ah.b(paramParcel, WhiteListFileSystem.class, 1);
    paramParcel.writeParcelable(this.agvG, paramInt);
    paramParcel.writeStringArray(this.agBo);
    AppMethodBeat.o(238473);
  }
  
  final class a
    extends f
  {
    final String[] agBo;
    final FileSystem.b agwv;
    final List<FileSystem.b> agxd;
    
    a(FileSystem.b paramb, String[] paramArrayOfString)
    {
      AppMethodBeat.i(238233);
      this.agwv = paramb;
      this.agxd = Collections.singletonList(paramb);
      this.agBo = paramArrayOfString;
      AppMethodBeat.o(238233);
    }
    
    private boolean eD(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(238240);
      String str = paramString;
      if (paramBoolean) {
        str = ah.bEv(paramString);
      }
      if ((str == null) || (str.isEmpty()))
      {
        AppMethodBeat.o(238240);
        return true;
      }
      int i = Arrays.binarySearch(this.agBo, str + '\000');
      if (i >= 0)
      {
        AppMethodBeat.o(238240);
        return true;
      }
      i = -i - 2;
      if (i < 0)
      {
        AppMethodBeat.o(238240);
        return false;
      }
      paramString = this.agBo[i];
      if (paramString.charAt(paramString.length() - 1) == 0)
      {
        if ((str.startsWith(paramString)) && (str.substring(paramString.length()).indexOf('/') == -1))
        {
          AppMethodBeat.o(238240);
          return true;
        }
        AppMethodBeat.o(238240);
        return false;
      }
      if ((str.startsWith(paramString)) && ((str.length() == paramString.length()) || (str.charAt(paramString.length()) == '/')))
      {
        AppMethodBeat.o(238240);
        return true;
      }
      AppMethodBeat.o(238240);
      return false;
    }
    
    public final boolean bDX(String paramString)
    {
      AppMethodBeat.i(238284);
      boolean bool;
      if ((paramString.isEmpty()) || (eD(paramString, false)))
      {
        bool = super.bDX(paramString);
        AppMethodBeat.o(238284);
        return bool;
      }
      if (WhiteListFileSystem.cnN().matcher(paramString).matches())
      {
        bool = super.bDX(paramString);
        AppMethodBeat.o(238284);
        return bool;
      }
      paramString = "Path not in white list: " + paramString + " -> " + this.agwv.jKa().toString();
      Log.e("VFS.WhiteListFileSystem", paramString);
      paramString = new AssertionError(paramString);
      AppMethodBeat.o(238284);
      throw paramString;
    }
    
    public final WritableByteChannel et(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(238276);
      if (eD(paramString, true))
      {
        paramString = super.et(paramString, paramBoolean);
        AppMethodBeat.o(238276);
        return paramString;
      }
      paramString = "Path not in white list: " + paramString + " -> " + this.agwv.jKa().toString();
      Log.e("VFS.WhiteListFileSystem", paramString);
      paramString = new AssertionError(paramString);
      AppMethodBeat.o(238276);
      throw paramString;
    }
    
    public final OutputStream ev(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(238268);
      if (eD(paramString, true))
      {
        paramString = super.ev(paramString, paramBoolean);
        AppMethodBeat.o(238268);
        return paramString;
      }
      paramString = "Path not in white list: " + paramString + " -> " + this.agwv.jKa().toString();
      Log.e("VFS.WhiteListFileSystem", paramString);
      paramString = new AssertionError(paramString);
      AppMethodBeat.o(238268);
      throw paramString;
    }
    
    public final FileSystem jKa()
    {
      return WhiteListFileSystem.this;
    }
    
    public final List<FileSystem.b> jKf()
    {
      return this.agxd;
    }
    
    public final FileSystem.b jk(String paramString, int paramInt)
    {
      return this.agwv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.WhiteListFileSystem
 * JD-Core Version:    0.7.0.1
 */