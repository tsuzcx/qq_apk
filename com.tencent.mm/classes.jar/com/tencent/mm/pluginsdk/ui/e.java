package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

public final class e
{
  public int DmY;
  public boolean DmZ;
  public int Dna;
  public boolean Dnb;
  public boolean Dnc;
  private int Dnd;
  public boolean Dne;
  public int Dnf;
  public boolean Dng;
  private int version;
  
  public e(String paramString, Context paramContext)
  {
    AppMethodBeat.i(141159);
    this.version = 0;
    this.DmY = -7829368;
    this.DmZ = false;
    this.Dna = -1593835521;
    this.Dnb = false;
    this.Dnc = false;
    this.Dnd = -16777216;
    this.Dne = false;
    this.Dnf = 0;
    this.Dng = false;
    paramString = bv.L(paramString, "chatbg");
    if (paramString == null)
    {
      ac.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed, values is null");
      AppMethodBeat.o(141159);
      return;
    }
    String str = ".".concat(String.valueOf("chatbg"));
    try
    {
      this.version = bs.m(Integer.valueOf((String)paramString.get(str + ".$version")));
      this.DmY = ((int)bs.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$time_color"), 16)), paramContext.getResources().getColor(2131099735)));
      this.DmZ = bs.l(Boolean.valueOf((String)paramString.get(str + ".$time_show_shadow_color")));
      this.Dna = ((int)bs.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$time_shadow_color"), 16)), 0L));
      this.Dnb = bs.l(Boolean.valueOf((String)paramString.get(str + ".$time_show_background")));
      this.Dnc = bs.l(Boolean.valueOf((String)paramString.get(str + ".$time_light_background")));
      this.Dnd = ((int)bs.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$voice_second_color"), 16)), -16777216L));
      this.Dne = bs.l(Boolean.valueOf((String)paramString.get(str + ".$voice_second_show_shadow_color")));
      this.Dnf = ((int)bs.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$voice_second_shadow_color"), 16)), 0L));
      this.Dng = bs.l(Boolean.valueOf((String)paramString.get(str + ".$voice_second_show_background")));
      AppMethodBeat.o(141159);
      return;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed");
      ac.printErrStackTrace("MicroMsg.ChatBgAttr", paramString, "", new Object[0]);
      AppMethodBeat.o(141159);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.e
 * JD-Core Version:    0.7.0.1
 */