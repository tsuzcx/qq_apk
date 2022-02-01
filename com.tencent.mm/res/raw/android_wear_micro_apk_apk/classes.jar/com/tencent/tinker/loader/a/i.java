package com.tencent.tinker.loader.a;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;

public final class i
{
  public String apN = null;
  public String apO = null;
  public ArrayList<String> apP = new ArrayList();
  public ArrayList<String> apQ = new ArrayList();
  public ArrayList<String> apR = new ArrayList();
  public HashMap<String, File> apS = new HashMap();
  public ArrayList<String> apT = new ArrayList();
  public HashMap<String, Object> apU = new HashMap();
  public HashSet<Pattern> apV = new HashSet();
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("resArscMd5:" + this.apO + "\n");
    localStringBuffer.append("arscBaseCrc:" + this.apN + "\n");
    Iterator localIterator = this.apV.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Pattern)localIterator.next();
      localStringBuffer.append("pattern:" + localObject + "\n");
    }
    localIterator = this.apP.iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localStringBuffer.append("addedSet:" + (String)localObject + "\n");
    }
    localIterator = this.apR.iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localStringBuffer.append("modifiedSet:" + (String)localObject + "\n");
    }
    localIterator = this.apT.iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localStringBuffer.append("largeModifiedSet:" + (String)localObject + "\n");
    }
    localIterator = this.apQ.iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localStringBuffer.append("deletedSet:" + (String)localObject + "\n");
    }
    localIterator = this.apS.keySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localStringBuffer.append("storeSet:" + (String)localObject + "\n");
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.a.i
 * JD-Core Version:    0.7.0.1
 */