package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.d;

public class TagDecrypter
{
  private static final String TAG = "MicroMsg.TagDecrypter";
  private final d des;
  private LruCache<String, String> tagLruCache;
  
  public TagDecrypter(String paramString)
  {
    AppMethodBeat.i(157841);
    this.tagLruCache = new LruCache(256);
    this.des = new d(paramString);
    AppMethodBeat.o(157841);
  }
  
  public String decryptTag(String paramString)
  {
    AppMethodBeat.i(157842);
    String str1 = paramString;
    try
    {
      if (!paramString.startsWith("!")) {
        break label192;
      }
      if (this.tagLruCache.check(paramString))
      {
        str1 = (String)this.tagLruCache.get(paramString);
        AppMethodBeat.o(157842);
        return str1;
      }
      str1 = paramString.substring(1);
      Object localObject2;
      String str2;
      int i;
      Log.printErrStackTrace("MicroMsg.TagDecrypter", localException1, "", new Object[0]);
    }
    catch (Exception localException1)
    {
      try
      {
        localObject2 = str1.split("@");
        if (localObject2.length <= 1) {
          break label209;
        }
        str2 = localObject2[0];
        i = Integer.valueOf(localObject2[0]).intValue();
        localObject2 = str1.substring(str2.length() + 1, str2.length() + 1 + i);
        str2 = str1.substring(i + (str2.length() + 1));
        str2 = this.des.fa((String)localObject2) + str2;
        this.tagLruCache.put(paramString, str2);
        AppMethodBeat.o(157842);
        return str2;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          paramString = (String)localObject1;
          Object localObject1 = localException2;
        }
      }
      localException1 = localException1;
    }
    localObject1 = "[td]".concat(String.valueOf(paramString));
    label192:
    AppMethodBeat.o(157842);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.TagDecrypter
 * JD-Core Version:    0.7.0.1
 */