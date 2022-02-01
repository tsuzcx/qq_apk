package com.tencent.mm.plugin.textstatus.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.util.c;

public final class p
{
  public static boolean FXw;
  private static String FXx;
  public static boolean UrK;
  
  static
  {
    AppMethodBeat.i(222816);
    c localc = c.QYz;
    FXw = c.hdg();
    UrK = true;
    FXx = "#([^\\n\\s\\t#@\\,，\\.。]{1,32})";
    AppMethodBeat.o(222816);
  }
  
  public static boolean fvC()
  {
    AppMethodBeat.i(222806);
    if (FXw) {
      c localc = c.QYz;
    }
    for (int i = Util.getInt(c.axY(c.np("textstatus", "openTextStatus")), 0); (UrK) && (((b)g.af(b.class)).a(b.a.spb, i) == 1); i = 1)
    {
      AppMethodBeat.o(222806);
      return true;
    }
    AppMethodBeat.o(222806);
    return false;
  }
  
  public static boolean fvD()
  {
    AppMethodBeat.i(222807);
    if (!fvC())
    {
      AppMethodBeat.o(222807);
      return false;
    }
    if (FXw) {
      c localc = c.QYz;
    }
    for (int i = Util.getInt(c.axY(c.np("textstatus", "isPlanetOpen")), 0); ((b)g.af(b.class)).a(b.a.spc, i) == 1; i = 0)
    {
      AppMethodBeat.o(222807);
      return true;
    }
    AppMethodBeat.o(222807);
    return false;
  }
  
  public static void fvE()
  {
    AppMethodBeat.i(222808);
    g.aAh().azQ().set(ar.a.Oow, Boolean.TRUE);
    AppMethodBeat.o(222808);
  }
  
  public static boolean fvF()
  {
    AppMethodBeat.i(222809);
    if (!fvC())
    {
      AppMethodBeat.o(222809);
      return false;
    }
    if (g.aAh().azQ().getBoolean(ar.a.Oow, false))
    {
      AppMethodBeat.o(222809);
      return false;
    }
    if (FXw) {
      c localc = c.QYz;
    }
    for (int i = Util.getInt(c.axY(c.np("textstatus", "isNewTipsOpen")), 0); ((b)g.af(b.class)).a(b.a.spd, i) == 1; i = 0)
    {
      AppMethodBeat.o(222809);
      return true;
    }
    AppMethodBeat.o(222809);
    return false;
  }
  
  public static String fvG()
  {
    AppMethodBeat.i(222810);
    if (!fvC())
    {
      str = FXx;
      AppMethodBeat.o(222810);
      return str;
    }
    String str = ((b)g.af(b.class)).a(b.a.spf, FXx);
    AppMethodBeat.o(222810);
    return str;
  }
  
  public static boolean fvH()
  {
    AppMethodBeat.i(222811);
    if (!fvC())
    {
      AppMethodBeat.o(222811);
      return false;
    }
    if (FXw) {
      c localc = c.QYz;
    }
    for (int i = Util.getInt(c.axY(c.np("textstatus", "isIconOpenInContact")), 0); ((b)g.af(b.class)).a(b.a.sph, i) == 1; i = 1)
    {
      AppMethodBeat.o(222811);
      return true;
    }
    AppMethodBeat.o(222811);
    return false;
  }
  
  public static boolean fvI()
  {
    AppMethodBeat.i(222812);
    if (!fvC())
    {
      AppMethodBeat.o(222812);
      return false;
    }
    if (FXw) {
      c localc = c.QYz;
    }
    for (int i = Util.getInt(c.axY(c.np("textstatus", "isIconOpenInGroup")), 0); ((b)g.af(b.class)).a(b.a.spi, i) == 1; i = 0)
    {
      AppMethodBeat.o(222812);
      return true;
    }
    AppMethodBeat.o(222812);
    return false;
  }
  
  public static boolean fvJ()
  {
    AppMethodBeat.i(222813);
    if (!fvC())
    {
      AppMethodBeat.o(222813);
      return false;
    }
    if (FXw) {
      c localc = c.QYz;
    }
    for (int i = Util.getInt(c.axY(c.np("textstatus", "isIconOpenInSnsFeeds")), 0); ((b)g.af(b.class)).a(b.a.spj, i) == 1; i = 0)
    {
      AppMethodBeat.o(222813);
      return true;
    }
    AppMethodBeat.o(222813);
    return false;
  }
  
  public static boolean fvK()
  {
    AppMethodBeat.i(222814);
    if (!fvC())
    {
      AppMethodBeat.o(222814);
      return false;
    }
    if (FXw) {
      c localc = c.QYz;
    }
    for (int i = Util.getInt(c.axY(c.np("textstatus", "isIconOpenInSnsCommentAndLike")), 0); ((b)g.af(b.class)).a(b.a.spk, i) == 1; i = 0)
    {
      AppMethodBeat.o(222814);
      return true;
    }
    AppMethodBeat.o(222814);
    return false;
  }
  
  public static boolean fvL()
  {
    AppMethodBeat.i(222815);
    if (!fvC())
    {
      AppMethodBeat.o(222815);
      return false;
    }
    if (FXw) {
      c localc = c.QYz;
    }
    for (int i = Util.getInt(c.axY(c.np("textstatus", "isIconOpenInNewMsg")), 0); ((b)g.af(b.class)).a(b.a.spl, i) == 1; i = 0)
    {
      AppMethodBeat.o(222815);
      return true;
    }
    AppMethodBeat.o(222815);
    return false;
  }
  
  public static int gWK()
  {
    AppMethodBeat.i(258633);
    if (!fvC())
    {
      AppMethodBeat.o(258633);
      return 0;
    }
    AppMethodBeat.o(258633);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.p
 * JD-Core Version:    0.7.0.1
 */