package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashSet;

public final class u
{
  public static final int KnA;
  public static final int KnB;
  public static final int KnC;
  public static final int KnD;
  public static final int KnE;
  public static final int KnF;
  public static final int KnG;
  public static final int Knw;
  public static final int Knx;
  public static int Kny;
  public static int Knz;
  
  static
  {
    AppMethodBeat.i(133757);
    Knw = I(new int[] { 256, 16, 1, 2, 4 });
    Knx = I(new int[] { 16, 1, 2, 4, 64, 16384 });
    Kny = I(new int[] { 16, 1, 2, 4, 64, 16384, 16777216 });
    Knz = I(new int[] { 16, 1, 2, 4, 64, 4096, 16777216 });
    KnA = I(new int[] { Knw, 64, 16384, 4096, 16777216 });
    KnB = I(new int[] { 16, 2, 16384, 4 });
    KnC = I(new int[] { Knw, 16384, 64, 4096, 16777216 });
    KnD = I(new int[] { Knw, 16384, 64, 131072, 8192, 16777216 });
    KnE = I(new int[] { 16, 32, 1, 4, 2, 64 });
    KnF = I(new int[] { 1, 2, 4, 64, 256, 16384 });
    KnG = I(new int[] { Kny, 131072 });
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
  
  public static HashSet<String> fIp()
  {
    AppMethodBeat.i(133752);
    HashSet localHashSet = new HashSet();
    localHashSet.add("weixin");
    AppMethodBeat.o(133752);
    return localHashSet;
  }
  
  public static HashSet<String> fIq()
  {
    AppMethodBeat.i(133754);
    HashSet localHashSet = new HashSet();
    localHashSet.add("officialaccounts");
    localHashSet.add("newsapp");
    String[] arrayOfString = w.hFm;
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
  
  public static boolean fIr()
  {
    AppMethodBeat.i(133756);
    int i = ((a)g.ab(a.class)).acA().getInt("ShowOpenImInGroup", 0);
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
    if (!fIr())
    {
      if (hasAttr(Kny, 16777216)) {
        Kny &= 0xFEFFFFFF;
      }
      if (hasAttr(Knz, 16777216))
      {
        Knz &= 0xFEFFFFFF;
        AppMethodBeat.o(133755);
      }
    }
    else
    {
      if (!hasAttr(Kny, 16777216)) {
        Kny = I(new int[] { Kny, 16777216 });
      }
      if (!hasAttr(Knz, 16777216)) {
        Knz = I(new int[] { Knz, 16777216 });
      }
    }
    AppMethodBeat.o(133755);
  }
  
  public static int jU(int paramInt1, int paramInt2)
  {
    return (paramInt2 ^ 0xFFFFFFFF) & paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.u
 * JD-Core Version:    0.7.0.1
 */