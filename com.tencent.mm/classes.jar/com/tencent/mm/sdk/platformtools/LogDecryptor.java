package com.tencent.mm.sdk.platformtools;

import android.util.Base64;
import com.tencent.mm.b.l;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogDecryptor
{
  private static final Pattern ENCRYPTED_STR_PREFIX_PATTERN = Pattern.compile(newTagPatternDeobfuscate("‚çÜ[0-9]+@"));
  private static final char NEW_OBFUSCATED_MAGIC_CHAR = '‚çÜ';
  private static final char OBFUSCATED_MASK = 'Ì≤∫';
  private static final char OLD_OBFUSCATED_MAGIC_CHAR = 'Ì≤õ';
  private static final String TAG = "MicroMsg.LogDecryptor";
  private final LruCache<String, String> decryptedStrLruCache = new LruCache(256);
  private byte[] key;
  private final TagDecrypter oldTagDecryptor;
  
  public LogDecryptor(String paramString)
  {
    try
    {
      this.key = paramString.getBytes("UTF-8");
      this.oldTagDecryptor = new TagDecrypter(paramString);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        this.key = paramString.getBytes();
      }
    }
  }
  
  private String decryptImpl(String paramString, int paramInt1, int paramInt2)
  {
    String str = paramString.substring(paramInt1, paramInt2);
    if (this.decryptedStrLruCache.checkAndUpTime(str)) {
      return (String)this.decryptedStrLruCache.get(str);
    }
    paramInt1 += 1;
    paramInt2 = paramString.indexOf('@', paramInt1);
    int i = paramInt2 + 1;
    paramString = paramString.substring(i, Integer.parseInt(paramString.substring(paramInt1, paramInt2)) + i);
    try
    {
      paramString = new String(l.d(Base64.decode(paramString, 0), this.key), "UTF-8");
      this.decryptedStrLruCache.put(str, paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.LogDecryptor", paramString, "", new Object[0]);
    }
    return "[TD]".concat(String.valueOf(str));
  }
  
  private static String newTagPatternDeobfuscate(String paramString)
  {
    char c = (char)(paramString.charAt(0) ^ 0xDCBA);
    return c + paramString.substring(1);
  }
  
  public String decryptContent(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return paramString;
    }
    Matcher localMatcher = ENCRYPTED_STR_PREFIX_PATTERN.matcher(paramString);
    int j = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < j) {
      if (localMatcher.find(i))
      {
        if (localMatcher.start() != i) {
          localStringBuilder.append(paramString.substring(i, localMatcher.start()));
        }
        i = localMatcher.start();
        int k = localMatcher.end();
        int m = Integer.parseInt(paramString.substring(i + 1, k - 1));
        localStringBuilder.append(decryptImpl(paramString, i, k + m));
        i = k + m;
      }
      else
      {
        localStringBuilder.append(paramString.substring(i));
      }
    }
    return localStringBuilder.toString();
  }
  
  public String decryptTag(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return paramString;
    }
    switch (paramString.charAt(0) ^ 0xDCBA)
    {
    default: 
      return paramString;
    case '‚çÜ': 
      return decryptImpl(paramString, 0, paramString.length());
    }
    return this.oldTagDecryptor.decryptTag(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.LogDecryptor
 * JD-Core Version:    0.7.0.1
 */