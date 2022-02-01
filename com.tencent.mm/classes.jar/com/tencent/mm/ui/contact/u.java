package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;

public final class u
{
  public static final int PWR;
  public static final int PWS;
  public static int PWT;
  public static int PWU;
  public static final int PWV;
  public static final int PWW;
  public static final int PWX;
  public static final int PWY;
  public static final int PWZ;
  public static final int PXa;
  public static final int PXb;
  
  static
  {
    AppMethodBeat.i(133757);
    PWR = Q(new int[] { 256, 16, 1, 2, 4 });
    PWS = Q(new int[] { 16, 1, 2, 4, 64, 16384 });
    PWT = Q(new int[] { 16, 1, 2, 4, 64, 16384, 16777216 });
    PWU = Q(new int[] { 16, 1, 2, 4, 64, 4096, 16777216 });
    PWV = Q(new int[] { PWR, 64, 16384, 4096, 16777216 });
    PWW = Q(new int[] { 16, 2, 16384, 4 });
    PWX = Q(new int[] { PWR, 16384, 64, 4096, 16777216 });
    PWY = Q(new int[] { PWR, 16384, 64, 131072, 8192, 16777216 });
    PWZ = Q(new int[] { 16, 32, 1, 4, 2, 64 });
    PXa = Q(new int[] { 1, 2, 4, 64, 256, 16384 });
    PXb = Q(new int[] { PWT, 131072 });
    AppMethodBeat.o(133757);
  }
  
  public static int Q(int... paramVarArgs)
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
  
  public static HashSet<String> gVb()
  {
    AppMethodBeat.i(133752);
    HashSet localHashSet = new HashSet();
    localHashSet.add("weixin");
    AppMethodBeat.o(133752);
    return localHashSet;
  }
  
  public static HashSet<String> gVc()
  {
    AppMethodBeat.i(133754);
    HashSet localHashSet = new HashSet();
    localHashSet.add("officialaccounts");
    localHashSet.add("newsapp");
    String[] arrayOfString = ab.iCO;
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
    AppMethodBeat.o(133754);
    return localHashSet;
  }
  
  public static boolean gVd()
  {
    AppMethodBeat.i(133756);
    int i = ((a)g.af(a.class)).aqJ().getInt("ShowOpenImInGroup", 0);
    Log.i("MMSelectContactLogic", "config_val %s ", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(133756);
      return false;
    }
    AppMethodBeat.o(133756);
    return true;
  }
  
  public static void h(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(133753);
    paramHashSet.remove("filehelper");
    AppMethodBeat.o(133753);
  }
  
  public static boolean hasAttr(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  public static void init()
  {
    AppMethodBeat.i(133755);
    if (!gVd())
    {
      if (hasAttr(PWT, 16777216)) {
        PWT &= 0xFEFFFFFF;
      }
      if (hasAttr(PWU, 16777216))
      {
        PWU &= 0xFEFFFFFF;
        AppMethodBeat.o(133755);
      }
    }
    else
    {
      if (!hasAttr(PWT, 16777216)) {
        PWT = Q(new int[] { PWT, 16777216 });
      }
      if (!hasAttr(PWU, 16777216)) {
        PWU = Q(new int[] { PWU, 16777216 });
      }
    }
    AppMethodBeat.o(133755);
  }
  
  public static int ll(int paramInt1, int paramInt2)
  {
    return (paramInt2 ^ 0xFFFFFFFF) & paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.u
 * JD-Core Version:    0.7.0.1
 */