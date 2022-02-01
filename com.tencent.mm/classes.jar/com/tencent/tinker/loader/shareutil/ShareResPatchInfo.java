package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShareResPatchInfo
{
  public ArrayList<String> addRes = new ArrayList();
  public String arscBaseCrc = null;
  public ArrayList<String> deleteRes = new ArrayList();
  public HashMap<String, LargeModeInfo> largeModMap = new HashMap();
  public ArrayList<String> largeModRes = new ArrayList();
  public ArrayList<String> modRes = new ArrayList();
  public HashSet<Pattern> patterns = new HashSet();
  public String resArscMd5 = null;
  public HashMap<String, File> storeRes = new HashMap();
  
  public static boolean checkFileInPattern(HashSet<Pattern> paramHashSet, String paramString)
  {
    if (!paramHashSet.isEmpty())
    {
      paramHashSet = paramHashSet.iterator();
      while (paramHashSet.hasNext()) {
        if (((Pattern)paramHashSet.next()).matcher(paramString).matches()) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean checkResPatchInfo(ShareResPatchInfo paramShareResPatchInfo)
  {
    if (paramShareResPatchInfo == null) {}
    do
    {
      return false;
      paramShareResPatchInfo = paramShareResPatchInfo.resArscMd5;
    } while ((paramShareResPatchInfo == null) || (paramShareResPatchInfo.length() != 32));
    return true;
  }
  
  private static Pattern convertToPatternString(String paramString)
  {
    String str = paramString;
    if (paramString.contains(".")) {
      str = paramString.replaceAll("\\.", "\\\\.");
    }
    paramString = str;
    if (str.contains("?")) {
      paramString = str.replaceAll("\\?", "\\.");
    }
    str = paramString;
    if (paramString.contains("*")) {
      str = paramString.replace("*", ".*");
    }
    return Pattern.compile(str);
  }
  
  public static void parseAllResPatchInfo(String paramString, ShareResPatchInfo paramShareResPatchInfo)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    paramString = paramString.split("\n");
    int i = 0;
    label21:
    String[] arrayOfString;
    int j;
    if (i < paramString.length)
    {
      arrayOfString = paramString[i];
      j = i;
      if (arrayOfString != null)
      {
        j = i;
        if (arrayOfString.length() > 0)
        {
          if (!arrayOfString.startsWith("resources_out.zip")) {
            break label94;
          }
          arrayOfString = arrayOfString.split(",", 3);
          paramShareResPatchInfo.arscBaseCrc = arrayOfString[1];
          paramShareResPatchInfo.resArscMd5 = arrayOfString[2];
          j = i;
        }
      }
    }
    label94:
    do
    {
      i = j + 1;
      break label21;
      break;
      if (arrayOfString.startsWith("pattern:"))
      {
        k = Integer.parseInt(arrayOfString.split(":", 2)[1]);
        for (;;)
        {
          j = i;
          if (k <= 0) {
            break;
          }
          paramShareResPatchInfo.patterns.add(convertToPatternString(paramString[(i + 1)]));
          i += 1;
          k -= 1;
        }
      }
      if (arrayOfString.startsWith("add:"))
      {
        k = Integer.parseInt(arrayOfString.split(":", 2)[1]);
        for (;;)
        {
          j = i;
          if (k <= 0) {
            break;
          }
          paramShareResPatchInfo.addRes.add(paramString[(i + 1)]);
          i += 1;
          k -= 1;
        }
      }
      if (arrayOfString.startsWith("modify:"))
      {
        k = Integer.parseInt(arrayOfString.split(":", 2)[1]);
        for (;;)
        {
          j = i;
          if (k <= 0) {
            break;
          }
          paramShareResPatchInfo.modRes.add(paramString[(i + 1)]);
          i += 1;
          k -= 1;
        }
      }
      if (arrayOfString.startsWith("large modify:"))
      {
        k = Integer.parseInt(arrayOfString.split(":", 2)[1]);
        for (;;)
        {
          j = i;
          if (k <= 0) {
            break;
          }
          arrayOfString = paramString[(i + 1)].split(",", 3);
          String str = arrayOfString[0];
          LargeModeInfo localLargeModeInfo = new LargeModeInfo();
          localLargeModeInfo.md5 = arrayOfString[1];
          localLargeModeInfo.crc = Long.parseLong(arrayOfString[2]);
          paramShareResPatchInfo.largeModRes.add(str);
          paramShareResPatchInfo.largeModMap.put(str, localLargeModeInfo);
          i += 1;
          k -= 1;
        }
      }
      if (arrayOfString.startsWith("delete:"))
      {
        k = Integer.parseInt(arrayOfString.split(":", 2)[1]);
        for (;;)
        {
          j = i;
          if (k <= 0) {
            break;
          }
          paramShareResPatchInfo.deleteRes.add(paramString[(i + 1)]);
          i += 1;
          k -= 1;
        }
      }
      j = i;
    } while (!arrayOfString.startsWith("store:"));
    int k = Integer.parseInt(arrayOfString.split(":", 2)[1]);
    for (;;)
    {
      j = i;
      if (k <= 0) {
        break;
      }
      paramShareResPatchInfo.storeRes.put(paramString[(i + 1)], null);
      i += 1;
      k -= 1;
    }
  }
  
  public static void parseResPatchInfoFirstLine(String paramString, ShareResPatchInfo paramShareResPatchInfo)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    String str = paramString.split("\n")[0];
    if ((str == null) || (str.length() <= 0)) {
      throw new TinkerRuntimeException("res meta Corrupted:".concat(String.valueOf(paramString)));
    }
    paramString = str.split(",", 3);
    paramShareResPatchInfo.arscBaseCrc = paramString[1];
    paramShareResPatchInfo.resArscMd5 = paramString[2];
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("resArscMd5:" + this.resArscMd5 + "\n");
    localStringBuffer.append("arscBaseCrc:" + this.arscBaseCrc + "\n");
    Iterator localIterator = this.patterns.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Pattern)localIterator.next();
      localStringBuffer.append("pattern:" + localObject + "\n");
    }
    localIterator = this.addRes.iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localStringBuffer.append("addedSet:" + (String)localObject + "\n");
    }
    localIterator = this.modRes.iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localStringBuffer.append("modifiedSet:" + (String)localObject + "\n");
    }
    localIterator = this.largeModRes.iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localStringBuffer.append("largeModifiedSet:" + (String)localObject + "\n");
    }
    localIterator = this.deleteRes.iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localStringBuffer.append("deletedSet:" + (String)localObject + "\n");
    }
    localIterator = this.storeRes.keySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localStringBuffer.append("storeSet:" + (String)localObject + "\n");
    }
    return localStringBuffer.toString();
  }
  
  public static class LargeModeInfo
  {
    public long crc;
    public File file = null;
    public String md5 = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareResPatchInfo
 * JD-Core Version:    0.7.0.1
 */