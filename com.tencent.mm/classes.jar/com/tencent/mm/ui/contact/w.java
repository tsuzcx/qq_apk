package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;

public final class w
{
  public static final int XtJ;
  public static final int XtK;
  public static int XtL;
  public static int XtM;
  public static final int XtN;
  public static final int XtO;
  public static final int XtP;
  public static final int XtQ;
  public static final int XtR;
  public static final int XtS;
  public static final int XtT;
  
  static
  {
    AppMethodBeat.i(133757);
    XtJ = P(new int[] { 256, 16, 1, 2, 4 });
    XtK = P(new int[] { 16, 1, 2, 4, 64, 16384 });
    XtL = P(new int[] { 16, 1, 2, 4, 64, 16384, 16777216 });
    XtM = P(new int[] { 16, 1, 2, 4, 64, 4096, 16777216 });
    XtN = P(new int[] { XtJ, 64, 16384, 4096, 16777216 });
    XtO = P(new int[] { 16, 2, 16384, 4 });
    XtP = P(new int[] { XtJ, 16384, 64, 4096, 16777216 });
    XtQ = P(new int[] { XtJ, 16384, 64, 131072, 8192, 16777216 });
    XtR = P(new int[] { 16, 32, 1, 4, 2, 64 });
    XtS = P(new int[] { 1, 2, 4, 64, 256, 16384 });
    XtT = P(new int[] { XtL, 131072 });
    AppMethodBeat.o(133757);
  }
  
  public static int P(int... paramVarArgs)
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
  
  public static void h(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(133753);
    paramHashSet.remove("filehelper");
    AppMethodBeat.o(133753);
  }
  
  public static HashSet<String> hVh()
  {
    AppMethodBeat.i(133752);
    HashSet localHashSet = new HashSet();
    localHashSet.add("weixin");
    AppMethodBeat.o(133752);
    return localHashSet;
  }
  
  public static HashSet<String> hVi()
  {
    AppMethodBeat.i(133754);
    HashSet localHashSet = new HashSet();
    localHashSet.add("officialaccounts");
    localHashSet.add("newsapp");
    String[] arrayOfString = ab.lsO;
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
  
  public static boolean hVj()
  {
    AppMethodBeat.i(133756);
    int i = ((a)h.ae(a.class)).axc().getInt("ShowOpenImInGroup", 0);
    Log.i("MMSelectContactLogic", "config_val %s ", new Object[] { Integer.valueOf(i) });
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
  
  public static void init()
  {
    AppMethodBeat.i(133755);
    if (!hVj())
    {
      if (hasAttr(XtL, 16777216)) {
        XtL &= 0xFEFFFFFF;
      }
      if (hasAttr(XtM, 16777216))
      {
        XtM &= 0xFEFFFFFF;
        AppMethodBeat.o(133755);
      }
    }
    else
    {
      if (!hasAttr(XtL, 16777216)) {
        XtL = P(new int[] { XtL, 16777216 });
      }
      if (!hasAttr(XtM, 16777216)) {
        XtM = P(new int[] { XtM, 16777216 });
      }
    }
    AppMethodBeat.o(133755);
  }
  
  public static int mC(int paramInt1, int paramInt2)
  {
    return (paramInt2 ^ 0xFFFFFFFF) & paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.w
 * JD-Core Version:    0.7.0.1
 */