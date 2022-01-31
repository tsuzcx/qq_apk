package com.tencent.mm.ui.contact;

import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;

public final class s
{
  public static final int vMA = v(new int[] { vMs, 131072 });
  public static final int vMq = v(new int[] { 256, 16, 1, 2, 4 });
  public static final int vMr = v(new int[] { 16, 1, 2, 4, 64, 16384 });
  public static int vMs = v(new int[] { 16, 1, 2, 4, 64, 16384, 16777216 });
  public static int vMt = v(new int[] { 16, 1, 2, 4, 64, 4096, 16777216 });
  public static final int vMu = v(new int[] { vMq, 64, 16384, 4096, 16777216 });
  public static final int vMv = v(new int[] { 16, 2, 16384, 4 });
  public static final int vMw = v(new int[] { vMq, 16384, 64, 4096, 16777216 });
  public static final int vMx = v(new int[] { vMq, 16384, 64, 131072, 8192, 16777216 });
  public static final int vMy = v(new int[] { 16, 32, 1, 4, 2, 64 });
  public static final int vMz = v(new int[] { 1, 2, 4, 64, 256, 16384 });
  
  public static HashSet<String> cHO()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("weixin");
    return localHashSet;
  }
  
  public static HashSet<String> cHP()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("officialaccounts");
    localHashSet.add("newsapp");
    String[] arrayOfString = com.tencent.mm.model.s.dVc;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localHashSet.add(arrayOfString[i]);
      i += 1;
    }
    localHashSet.add("weibo");
    localHashSet.add("qqmail");
    localHashSet.add("fmessage");
    localHashSet.add("tmessage");
    localHashSet.add("floatbottle");
    localHashSet.add("lbsapp");
    localHashSet.add("shakeapp");
    localHashSet.add("medianote");
    localHashSet.add("qqfriend");
    localHashSet.add("readerapp");
    localHashSet.add("newsapp");
    localHashSet.add("blogapp");
    localHashSet.add("facebookapp");
    localHashSet.add("masssendapp");
    localHashSet.add("meishiapp");
    localHashSet.add("feedsapp");
    localHashSet.add("voipapp");
    localHashSet.add("filehelper");
    localHashSet.add("officialaccounts");
    localHashSet.add("helper_entry");
    localHashSet.add("pc_share");
    localHashSet.add("cardpackage");
    localHashSet.add("voicevoipapp");
    localHashSet.add("voiceinputapp");
    localHashSet.add("linkedinplugin");
    localHashSet.add("appbrandcustomerservicemsg");
    return localHashSet;
  }
  
  public static boolean cHQ()
  {
    int i = ((a)g.r(a.class)).AA().getInt("ShowOpenImInGroup", 0);
    y.i("MMSelectContactLogic", "config_val %s ", new Object[] { Integer.valueOf(i) });
    return i != 0;
  }
  
  public static boolean fA(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  public static int fB(int paramInt1, int paramInt2)
  {
    return (paramInt2 ^ 0xFFFFFFFF) & paramInt1;
  }
  
  public static void h(HashSet<String> paramHashSet)
  {
    paramHashSet.remove("filehelper");
  }
  
  public static void init()
  {
    if (!cHQ())
    {
      if (fA(vMs, 16777216)) {
        vMs &= 0xFEFFFFFF;
      }
      if (fA(vMt, 16777216)) {
        vMt &= 0xFEFFFFFF;
      }
    }
    do
    {
      return;
      if (!fA(vMs, 16777216)) {
        vMs = v(new int[] { vMs, 16777216 });
      }
    } while (fA(vMt, 16777216));
    vMt = v(new int[] { vMt, 16777216 });
  }
  
  public static int v(int... paramVarArgs)
  {
    int k = paramVarArgs.length;
    int j = 0;
    int m;
    for (int i = 0; j < k; i = m | i)
    {
      m = paramVarArgs[j];
      j += 1;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.s
 * JD-Core Version:    0.7.0.1
 */