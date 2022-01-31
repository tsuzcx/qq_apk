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
  public String aml = null;
  public String amm = null;
  public ArrayList<String> amn = new ArrayList();
  public ArrayList<String> amo = new ArrayList();
  public ArrayList<String> amp = new ArrayList();
  public HashMap<String, File> amq = new HashMap();
  public ArrayList<String> amr = new ArrayList();
  public HashMap<String, Object> ams = new HashMap();
  public HashSet<Pattern> amt = new HashSet();
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("resArscMd5:" + this.amm + "\n");
    localStringBuffer.append("arscBaseCrc:" + this.aml + "\n");
    Iterator localIterator = this.amt.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Pattern)localIterator.next();
      localStringBuffer.append("pattern:" + localObject + "\n");
    }
    localIterator = this.amn.iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localStringBuffer.append("addedSet:" + (String)localObject + "\n");
    }
    localIterator = this.amp.iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localStringBuffer.append("modifiedSet:" + (String)localObject + "\n");
    }
    localIterator = this.amr.iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localStringBuffer.append("largeModifiedSet:" + (String)localObject + "\n");
    }
    localIterator = this.amo.iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localStringBuffer.append("deletedSet:" + (String)localObject + "\n");
    }
    localIterator = this.amq.keySet().iterator();
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