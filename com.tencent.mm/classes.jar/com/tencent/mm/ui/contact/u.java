package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashSet;

public final class u
{
  public static final int GWA;
  public static final int GWB;
  public static int GWC;
  public static int GWD;
  public static final int GWE;
  public static final int GWF;
  public static final int GWG;
  public static final int GWH;
  public static final int GWI;
  public static final int GWJ;
  public static final int GWK;
  
  static
  {
    AppMethodBeat.i(133757);
    GWA = I(new int[] { 256, 16, 1, 2, 4 });
    GWB = I(new int[] { 16, 1, 2, 4, 64, 16384 });
    GWC = I(new int[] { 16, 1, 2, 4, 64, 16384, 16777216 });
    GWD = I(new int[] { 16, 1, 2, 4, 64, 4096, 16777216 });
    GWE = I(new int[] { GWA, 64, 16384, 4096, 16777216 });
    GWF = I(new int[] { 16, 2, 16384, 4 });
    GWG = I(new int[] { GWA, 16384, 64, 4096, 16777216 });
    GWH = I(new int[] { GWA, 16384, 64, 131072, 8192, 16777216 });
    GWI = I(new int[] { 16, 32, 1, 4, 2, 64 });
    GWJ = I(new int[] { 1, 2, 4, 64, 256, 16384 });
    GWK = I(new int[] { GWC, 131072 });
    AppMethodBeat.o(133757);
  }
  
  public static int I(int... paramVarArgs)
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
  
  public static HashSet<String> fbL()
  {
    AppMethodBeat.i(133752);
    HashSet localHashSet = new HashSet();
    localHashSet.add("weixin");
    AppMethodBeat.o(133752);
    return localHashSet;
  }
  
  public static HashSet<String> fbM()
  {
    AppMethodBeat.i(133754);
    HashSet localHashSet = new HashSet();
    localHashSet.add("officialaccounts");
    localHashSet.add("newsapp");
    String[] arrayOfString = w.gMw;
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
  
  public static boolean fbN()
  {
    AppMethodBeat.i(133756);
    int i = ((a)g.ab(a.class)).Zd().getInt("ShowOpenImInGroup", 0);
    ad.i("MMSelectContactLogic", "config_val %s ", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(133756);
      return false;
    }
    AppMethodBeat.o(133756);
    return true;
  }
  
  public static boolean hasAttr(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  public static void i(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(133753);
    paramHashSet.remove("filehelper");
    AppMethodBeat.o(133753);
  }
  
  public static void init()
  {
    AppMethodBeat.i(133755);
    if (!fbN())
    {
      if (hasAttr(GWC, 16777216)) {
        GWC &= 0xFEFFFFFF;
      }
      if (hasAttr(GWD, 16777216))
      {
        GWD &= 0xFEFFFFFF;
        AppMethodBeat.o(133755);
      }
    }
    else
    {
      if (!hasAttr(GWC, 16777216)) {
        GWC = I(new int[] { GWC, 16777216 });
      }
      if (!hasAttr(GWD, 16777216)) {
        GWD = I(new int[] { GWD, 16777216 });
      }
    }
    AppMethodBeat.o(133755);
  }
  
  public static int jw(int paramInt1, int paramInt2)
  {
    return (paramInt2 ^ 0xFFFFFFFF) & paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.u
 * JD-Core Version:    0.7.0.1
 */