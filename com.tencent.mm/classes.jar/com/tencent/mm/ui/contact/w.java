package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;

public final class w
{
  public static final int affn;
  public static final int affo;
  public static int affp;
  public static int affq;
  public static int affr;
  public static final int affs;
  public static final int afft;
  public static final int affu;
  public static final int affv;
  public static final int affw;
  public static final int affx;
  public static final int affy;
  
  static
  {
    AppMethodBeat.i(133757);
    affn = R(new int[] { 256, 16, 1, 2, 4 });
    affo = R(new int[] { 16, 1, 2, 4, 64, 16384 });
    affp = R(new int[] { 16, 1, 2, 4, 64, 16384, 16777216 });
    affq = R(new int[] { 16, 1, 2, 4, 16384, 16777216 });
    affr = R(new int[] { 16, 1, 2, 4, 64, 4096, 16777216 });
    affs = R(new int[] { affn, 64, 16384, 4096, 16777216 });
    afft = R(new int[] { 16, 2, 16384, 4 });
    affu = R(new int[] { affn, 16384, 64, 4096, 16777216 });
    affv = R(new int[] { affn, 16384, 64, 131072, 8192, 16777216 });
    affw = R(new int[] { 16, 32, 1, 4, 2, 64 });
    affx = R(new int[] { 1, 2, 4, 64, 256, 16384 });
    affy = R(new int[] { affp, 131072 });
    AppMethodBeat.o(133757);
  }
  
  public static int R(int... paramVarArgs)
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
  
  public static boolean hasAttr(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  public static void init()
  {
    AppMethodBeat.i(133755);
    if (!jyX())
    {
      if (hasAttr(affp, 16777216)) {
        affp &= 0xFEFFFFFF;
      }
      if (hasAttr(affr, 16777216))
      {
        affr &= 0xFEFFFFFF;
        AppMethodBeat.o(133755);
      }
    }
    else
    {
      if (!hasAttr(affp, 16777216)) {
        affp = R(new int[] { affp, 16777216 });
      }
      if (!hasAttr(affr, 16777216)) {
        affr = R(new int[] { affr, 16777216 });
      }
    }
    AppMethodBeat.o(133755);
  }
  
  public static void j(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(133753);
    paramHashSet.remove("filehelper");
    AppMethodBeat.o(133753);
  }
  
  public static HashSet<String> jyV()
  {
    AppMethodBeat.i(133752);
    HashSet localHashSet = new HashSet();
    localHashSet.add("weixin");
    AppMethodBeat.o(133752);
    return localHashSet;
  }
  
  public static HashSet<String> jyW()
  {
    AppMethodBeat.i(133754);
    HashSet localHashSet = new HashSet();
    localHashSet.add("officialaccounts");
    localHashSet.add("newsapp");
    String[] arrayOfString = ab.oko;
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
    localHashSet.add("conversationboxservice");
    AppMethodBeat.o(133754);
    return localHashSet;
  }
  
  public static boolean jyX()
  {
    AppMethodBeat.i(133756);
    int i = ((a)h.ax(a.class)).aRC().getInt("ShowOpenImInGroup", 0);
    Log.i("MMSelectContactLogic", "config_val %s ", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(133756);
      return false;
    }
    AppMethodBeat.o(133756);
    return true;
  }
  
  public static void k(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(252851);
    paramHashSet.remove("conversationboxservice");
    AppMethodBeat.o(252851);
  }
  
  public static int ow(int paramInt1, int paramInt2)
  {
    return (paramInt2 ^ 0xFFFFFFFF) & paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.w
 * JD-Core Version:    0.7.0.1
 */