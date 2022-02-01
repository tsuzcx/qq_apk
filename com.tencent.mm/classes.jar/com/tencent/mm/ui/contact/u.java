package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashSet;

public final class u
{
  public static final int IwO;
  public static final int IwP;
  public static int IwQ;
  public static int IwR;
  public static final int IwS;
  public static final int IwT;
  public static final int IwU;
  public static final int IwV;
  public static final int IwW;
  public static final int IwX;
  public static final int IwY;
  
  static
  {
    AppMethodBeat.i(133757);
    IwO = I(new int[] { 256, 16, 1, 2, 4 });
    IwP = I(new int[] { 16, 1, 2, 4, 64, 16384 });
    IwQ = I(new int[] { 16, 1, 2, 4, 64, 16384, 16777216 });
    IwR = I(new int[] { 16, 1, 2, 4, 64, 4096, 16777216 });
    IwS = I(new int[] { IwO, 64, 16384, 4096, 16777216 });
    IwT = I(new int[] { 16, 2, 16384, 4 });
    IwU = I(new int[] { IwO, 16384, 64, 4096, 16777216 });
    IwV = I(new int[] { IwO, 16384, 64, 131072, 8192, 16777216 });
    IwW = I(new int[] { 16, 32, 1, 4, 2, 64 });
    IwX = I(new int[] { 1, 2, 4, 64, 256, 16384 });
    IwY = I(new int[] { IwQ, 131072 });
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
  
  public static HashSet<String> frC()
  {
    AppMethodBeat.i(133752);
    HashSet localHashSet = new HashSet();
    localHashSet.add("weixin");
    AppMethodBeat.o(133752);
    return localHashSet;
  }
  
  public static HashSet<String> frD()
  {
    AppMethodBeat.i(133754);
    HashSet localHashSet = new HashSet();
    localHashSet.add("officialaccounts");
    localHashSet.add("newsapp");
    String[] arrayOfString = w.hmW;
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
  
  public static boolean frE()
  {
    AppMethodBeat.i(133756);
    int i = ((a)g.ab(a.class)).ZY().getInt("ShowOpenImInGroup", 0);
    ac.i("MMSelectContactLogic", "config_val %s ", new Object[] { Integer.valueOf(i) });
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
    if (!frE())
    {
      if (hasAttr(IwQ, 16777216)) {
        IwQ &= 0xFEFFFFFF;
      }
      if (hasAttr(IwR, 16777216))
      {
        IwR &= 0xFEFFFFFF;
        AppMethodBeat.o(133755);
      }
    }
    else
    {
      if (!hasAttr(IwQ, 16777216)) {
        IwQ = I(new int[] { IwQ, 16777216 });
      }
      if (!hasAttr(IwR, 16777216)) {
        IwR = I(new int[] { IwR, 16777216 });
      }
    }
    AppMethodBeat.o(133755);
  }
  
  public static int jI(int paramInt1, int paramInt2)
  {
    return (paramInt2 ^ 0xFFFFFFFF) & paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.u
 * JD-Core Version:    0.7.0.1
 */