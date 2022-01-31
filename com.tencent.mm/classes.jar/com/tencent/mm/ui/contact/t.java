package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;

public final class t
{
  public static final int AdS;
  public static final int AdT;
  public static int AdU;
  public static int AdV;
  public static final int AdW;
  public static final int AdX;
  public static final int AdY;
  public static final int AdZ;
  public static final int Aea;
  public static final int Aeb;
  public static final int Aec;
  
  static
  {
    AppMethodBeat.i(114745);
    AdS = F(new int[] { 256, 16, 1, 2, 4 });
    AdT = F(new int[] { 16, 1, 2, 4, 64, 16384 });
    AdU = F(new int[] { 16, 1, 2, 4, 64, 16384, 16777216 });
    AdV = F(new int[] { 16, 1, 2, 4, 64, 4096, 16777216 });
    AdW = F(new int[] { AdS, 64, 16384, 4096, 16777216 });
    AdX = F(new int[] { 16, 2, 16384, 4 });
    AdY = F(new int[] { AdS, 16384, 64, 4096, 16777216 });
    AdZ = F(new int[] { AdS, 16384, 64, 131072, 8192, 16777216 });
    Aea = F(new int[] { 16, 32, 1, 4, 2, 64 });
    Aeb = F(new int[] { 1, 2, 4, 64, 256, 16384 });
    Aec = F(new int[] { AdU, 131072 });
    AppMethodBeat.o(114745);
  }
  
  public static int F(int... paramVarArgs)
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
  
  public static HashSet<String> dMg()
  {
    AppMethodBeat.i(114740);
    HashSet localHashSet = new HashSet();
    localHashSet.add("weixin");
    AppMethodBeat.o(114740);
    return localHashSet;
  }
  
  public static HashSet<String> dMh()
  {
    AppMethodBeat.i(114742);
    HashSet localHashSet = new HashSet();
    localHashSet.add("officialaccounts");
    localHashSet.add("newsapp");
    String[] arrayOfString = com.tencent.mm.model.t.fll;
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
    AppMethodBeat.o(114742);
    return localHashSet;
  }
  
  public static boolean dMi()
  {
    AppMethodBeat.i(114744);
    int i = ((a)g.E(a.class)).Nq().getInt("ShowOpenImInGroup", 0);
    ab.i("MMSelectContactLogic", "config_val %s ", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(114744);
      return false;
    }
    AppMethodBeat.o(114744);
    return true;
  }
  
  public static boolean hI(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  public static int hJ(int paramInt1, int paramInt2)
  {
    return (paramInt2 ^ 0xFFFFFFFF) & paramInt1;
  }
  
  public static void i(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(114741);
    paramHashSet.remove("filehelper");
    AppMethodBeat.o(114741);
  }
  
  public static void init()
  {
    AppMethodBeat.i(114743);
    if (!dMi())
    {
      if (hI(AdU, 16777216)) {
        AdU &= 0xFEFFFFFF;
      }
      if (hI(AdV, 16777216))
      {
        AdV &= 0xFEFFFFFF;
        AppMethodBeat.o(114743);
      }
    }
    else
    {
      if (!hI(AdU, 16777216)) {
        AdU = F(new int[] { AdU, 16777216 });
      }
      if (!hI(AdV, 16777216)) {
        AdV = F(new int[] { AdV, 16777216 });
      }
    }
    AppMethodBeat.o(114743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.t
 * JD-Core Version:    0.7.0.1
 */