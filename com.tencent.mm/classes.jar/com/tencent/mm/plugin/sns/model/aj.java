package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.f;
import com.tencent.mm.plugin.story.api.f.a;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class aj
{
  public static int Qum = 30;
  public static boolean Qun = false;
  public static boolean Quo = false;
  public static boolean Qup = false;
  public static int Quq = 50;
  public static boolean Qur = true;
  
  public static void hfX()
  {
    AppMethodBeat.i(309408);
    Qum = ((c)h.ax(c.class)).a(c.a.zff, 30);
    Qun = ((e)h.az(e.class)).getStoryBasicConfig().a(f.a.Sih);
    Quo = ((e)h.az(e.class)).getStoryBasicConfig().a(f.a.Sig);
    Qup = ((e)h.az(e.class)).getStoryBasicConfig().a(f.a.Sii);
    Quq = ((c)h.ax(c.class)).a(c.a.zfo, 50);
    if (((c)h.ax(c.class)).a(c.a.zfp, 1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Qur = bool;
      AppMethodBeat.o(309408);
      return;
    }
  }
  
  public static void hfY()
  {
    AppMethodBeat.i(309410);
    Qum = ((c)h.ax(c.class)).a(c.a.zff, 30);
    Qun = ((e)h.az(e.class)).getStoryBasicConfig().a(f.a.Sih);
    Quo = ((e)h.az(e.class)).getStoryBasicConfig().a(f.a.Sig);
    Qup = ((e)h.az(e.class)).getStoryBasicConfig().a(f.a.Sii);
    if (((c)h.ax(c.class)).a(c.a.zfp, 1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Qur = bool;
      AppMethodBeat.o(309410);
      return;
    }
  }
  
  public static boolean hfZ()
  {
    AppMethodBeat.i(309413);
    boolean bool = ((c)h.ax(c.class)).a(c.a.zxl, true);
    AppMethodBeat.o(309413);
    return bool;
  }
  
  public static boolean hga()
  {
    AppMethodBeat.i(309415);
    boolean bool = ((c)h.ax(c.class)).a(c.a.zxh, false);
    AppMethodBeat.o(309415);
    return bool;
  }
  
  public static boolean hgb()
  {
    AppMethodBeat.i(309416);
    if ((((c)h.ax(c.class)).a(c.a.zxi, false)) && (MultiProcessMMKV.getDefault().getInt("sns_with_together_at_contact_red", 0) == 0))
    {
      AppMethodBeat.o(309416);
      return true;
    }
    AppMethodBeat.o(309416);
    return false;
  }
  
  public static boolean hgc()
  {
    AppMethodBeat.i(309419);
    if (MultiProcessMMKV.getDefault().getInt("sns_with_together_red", 0) == 1)
    {
      AppMethodBeat.o(309419);
      return true;
    }
    AppMethodBeat.o(309419);
    return false;
  }
  
  public static boolean hgd()
  {
    AppMethodBeat.i(309420);
    if (MultiProcessMMKV.getDefault().getInt("sns_with_together_red", 0) == 0)
    {
      AppMethodBeat.o(309420);
      return true;
    }
    AppMethodBeat.o(309420);
    return false;
  }
  
  public static boolean hge()
  {
    AppMethodBeat.i(309421);
    boolean bool = ((c)h.ax(c.class)).a(c.a.zxm, false);
    AppMethodBeat.o(309421);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aj
 * JD-Core Version:    0.7.0.1
 */