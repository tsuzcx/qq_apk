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
  public String BvZ = null;
  public String Bwa = null;
  public ArrayList<String> Bwb = new ArrayList();
  public ArrayList<String> Bwc = new ArrayList();
  public ArrayList<String> Bwd = new ArrayList();
  public HashMap<String, File> Bwe = new HashMap();
  public ArrayList<String> Bwf = new ArrayList();
  public HashMap<String, LargeModeInfo> Bwg = new HashMap();
  public HashSet<Pattern> Bwh = new HashSet();
  
  public static void a(String paramString, ShareResPatchInfo paramShareResPatchInfo)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    String[] arrayOfString = paramString.split("\n");
    int i = 0;
    label22:
    int j;
    if (i < arrayOfString.length)
    {
      paramString = arrayOfString[i];
      j = i;
      if (paramString != null)
      {
        j = i;
        if (paramString.length() > 0)
        {
          if (!paramString.startsWith("resources_out.zip")) {
            break label89;
          }
          paramString = paramString.split(",", 3);
          paramShareResPatchInfo.BvZ = paramString[1];
          paramShareResPatchInfo.Bwa = paramString[2];
          j = i;
        }
      }
    }
    label89:
    label223:
    do
    {
      Object localObject;
      String str;
      for (;;)
      {
        i = j + 1;
        break label22;
        break;
        if (!paramString.startsWith("pattern:")) {
          break label223;
        }
        j = Integer.parseInt(paramString.split(":", 2)[1]);
        while (j > 0)
        {
          localObject = paramShareResPatchInfo.Bwh;
          str = arrayOfString[(i + 1)];
          paramString = str;
          if (str.contains(".")) {
            paramString = str.replaceAll("\\.", "\\\\.");
          }
          str = paramString;
          if (paramString.contains("?")) {
            str = paramString.replaceAll("\\?", "\\.");
          }
          paramString = str;
          if (str.contains("*")) {
            paramString = str.replace("*", ".*");
          }
          ((HashSet)localObject).add(Pattern.compile(paramString));
          i += 1;
          j -= 1;
        }
        j = i;
      }
      if (paramString.startsWith("add:"))
      {
        k = Integer.parseInt(paramString.split(":", 2)[1]);
        for (;;)
        {
          j = i;
          if (k <= 0) {
            break;
          }
          paramShareResPatchInfo.Bwb.add(arrayOfString[(i + 1)]);
          i += 1;
          k -= 1;
        }
      }
      if (paramString.startsWith("modify:"))
      {
        k = Integer.parseInt(paramString.split(":", 2)[1]);
        for (;;)
        {
          j = i;
          if (k <= 0) {
            break;
          }
          paramShareResPatchInfo.Bwd.add(arrayOfString[(i + 1)]);
          i += 1;
          k -= 1;
        }
      }
      if (paramString.startsWith("large modify:"))
      {
        k = Integer.parseInt(paramString.split(":", 2)[1]);
        for (;;)
        {
          j = i;
          if (k <= 0) {
            break;
          }
          paramString = arrayOfString[(i + 1)].split(",", 3);
          str = paramString[0];
          localObject = new LargeModeInfo();
          ((LargeModeInfo)localObject).cqq = paramString[1];
          ((LargeModeInfo)localObject).Bwi = Long.parseLong(paramString[2]);
          paramShareResPatchInfo.Bwf.add(str);
          paramShareResPatchInfo.Bwg.put(str, localObject);
          i += 1;
          k -= 1;
        }
      }
      if (paramString.startsWith("delete:"))
      {
        k = Integer.parseInt(paramString.split(":", 2)[1]);
        for (;;)
        {
          j = i;
          if (k <= 0) {
            break;
          }
          paramShareResPatchInfo.Bwc.add(arrayOfString[(i + 1)]);
          i += 1;
          k -= 1;
        }
      }
      j = i;
    } while (!paramString.startsWith("store:"));
    int k = Integer.parseInt(paramString.split(":", 2)[1]);
    for (;;)
    {
      j = i;
      if (k <= 0) {
        break;
      }
      paramShareResPatchInfo.Bwe.put(arrayOfString[(i + 1)], null);
      i += 1;
      k -= 1;
    }
  }
  
  public static boolean a(ShareResPatchInfo paramShareResPatchInfo)
  {
    if (paramShareResPatchInfo == null) {}
    do
    {
      return false;
      paramShareResPatchInfo = paramShareResPatchInfo.Bwa;
    } while ((paramShareResPatchInfo == null) || (paramShareResPatchInfo.length() != 32));
    return true;
  }
  
  public static boolean a(HashSet<Pattern> paramHashSet, String paramString)
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
  
  public static void b(String paramString, ShareResPatchInfo paramShareResPatchInfo)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    String str = paramString.split("\n")[0];
    if ((str == null) || (str.length() <= 0)) {
      throw new TinkerRuntimeException("res meta Corrupted:".concat(String.valueOf(paramString)));
    }
    paramString = str.split(",", 3);
    paramShareResPatchInfo.BvZ = paramString[1];
    paramShareResPatchInfo.Bwa = paramString[2];
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("resArscMd5:" + this.Bwa + "\n");
    localStringBuffer.append("arscBaseCrc:" + this.BvZ + "\n");
    Iterator localIterator = this.Bwh.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Pattern)localIterator.next();
      localStringBuffer.append("pattern:" + localObject + "\n");
    }
    localIterator = this.Bwb.iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localStringBuffer.append("addedSet:" + (String)localObject + "\n");
    }
    localIterator = this.Bwd.iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localStringBuffer.append("modifiedSet:" + (String)localObject + "\n");
    }
    localIterator = this.Bwf.iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localStringBuffer.append("largeModifiedSet:" + (String)localObject + "\n");
    }
    localIterator = this.Bwc.iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localStringBuffer.append("deletedSet:" + (String)localObject + "\n");
    }
    localIterator = this.Bwe.keySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localStringBuffer.append("storeSet:" + (String)localObject + "\n");
    }
    return localStringBuffer.toString();
  }
  
  public static class LargeModeInfo
  {
    public long Bwi;
    public String cqq = null;
    public File file = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareResPatchInfo
 * JD-Core Version:    0.7.0.1
 */