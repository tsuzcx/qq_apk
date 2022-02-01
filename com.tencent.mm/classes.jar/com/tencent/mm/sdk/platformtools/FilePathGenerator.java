package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public class FilePathGenerator
{
  public static final String ANDROID_DIR_SEP = "/";
  public static final int HASH_TYPE_ALL_MD5 = 2;
  public static final int HASH_TYPE_HEAD_2_BYTE = 1;
  public static final String NO_MEDIA_FILENAME = ".nomedia";
  private static final String TAG = "MicroMsg.FilePathGenerator";
  
  public static boolean checkMkdir(String paramString)
  {
    AppMethodBeat.i(157532);
    boolean bool = s.boN(paramString);
    AppMethodBeat.o(157532);
    return bool;
  }
  
  public static String defGenPathWithOld(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    AppMethodBeat.i(230293);
    paramString1 = defGenPathWithOld(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, true);
    AppMethodBeat.o(230293);
    return paramString1;
  }
  
  public static String defGenPathWithOld(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(230292);
    paramString1 = paramString1 + paramString3 + paramString4 + paramString5;
    paramString2 = genPath(paramString2, paramString3, paramString4, paramString5, paramInt, paramBoolean);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(230292);
      return null;
    }
    paramString3 = new o(paramString2);
    paramString4 = new o(paramString1);
    if (paramString3.exists())
    {
      AppMethodBeat.o(230292);
      return paramString2;
    }
    if (paramString4.exists()) {
      FilesCopy.copy(paramString1, paramString2, false);
    }
    AppMethodBeat.o(230292);
    return paramString2;
  }
  
  private static String genByAllMd5(String paramString)
  {
    AppMethodBeat.i(230291);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(230291);
      return null;
    }
    paramString = genByHead2Byte(g.getMessageDigest(paramString.getBytes()));
    AppMethodBeat.o(230291);
    return paramString;
  }
  
  private static String genByHead2Byte(String paramString)
  {
    AppMethodBeat.i(157531);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157531);
      return null;
    }
    if (paramString.length() <= 4)
    {
      AppMethodBeat.o(157531);
      return null;
    }
    paramString = paramString.substring(0, 2) + "/" + paramString.substring(2, 4) + "/";
    AppMethodBeat.o(157531);
    return paramString;
  }
  
  public static String genPath(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(157534);
    paramString1 = genPath(paramString1, paramString2, paramString3, paramString4, paramInt, true);
    AppMethodBeat.o(157534);
    return paramString1;
  }
  
  public static String genPath(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(157533);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(157533);
      return null;
    }
    if (!paramString1.endsWith("/"))
    {
      AppMethodBeat.o(157533);
      return null;
    }
    String str = "";
    if (paramInt == 1) {
      str = genByHead2Byte(paramString3);
    }
    while (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(157533);
      return null;
      if (paramInt == 2) {
        str = genByAllMd5(paramString3);
      }
    }
    paramString1 = paramString1 + str;
    if ((paramBoolean) && (!checkMkdir(paramString1)))
    {
      AppMethodBeat.o(157533);
      return null;
    }
    paramString1 = paramString1 + Util.nullAsNil(paramString2) + paramString3 + Util.nullAsNil(paramString4);
    AppMethodBeat.o(157533);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.FilePathGenerator
 * JD-Core Version:    0.7.0.1
 */