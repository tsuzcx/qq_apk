package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Map;

public final class f
{
  public int FkA;
  public boolean FkB;
  public boolean FkC;
  private int FkD;
  public boolean FkE;
  public int FkF;
  public boolean FkG;
  public int Fky;
  public boolean Fkz;
  private int version;
  
  public f(String paramString, Context paramContext)
  {
    AppMethodBeat.i(141159);
    this.version = 0;
    this.Fky = -7829368;
    this.Fkz = false;
    this.FkA = -1593835521;
    this.FkB = false;
    this.FkC = false;
    this.FkD = -16777216;
    this.FkE = false;
    this.FkF = 0;
    this.FkG = false;
    paramString = bx.M(paramString, "chatbg");
    if (paramString == null)
    {
      ae.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed, values is null");
      AppMethodBeat.o(141159);
      return;
    }
    String str = ".".concat(String.valueOf("chatbg"));
    try
    {
      this.version = bu.o(Integer.valueOf((String)paramString.get(str + ".$version")));
      this.Fky = ((int)bu.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$time_color"), 16)), paramContext.getResources().getColor(2131099735)));
      this.Fkz = bu.o(Boolean.valueOf((String)paramString.get(str + ".$time_show_shadow_color")));
      this.FkA = ((int)bu.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$time_shadow_color"), 16)), 0L));
      this.FkB = bu.o(Boolean.valueOf((String)paramString.get(str + ".$time_show_background")));
      this.FkC = bu.o(Boolean.valueOf((String)paramString.get(str + ".$time_light_background")));
      this.FkD = ((int)bu.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$voice_second_color"), 16)), -16777216L));
      this.FkE = bu.o(Boolean.valueOf((String)paramString.get(str + ".$voice_second_show_shadow_color")));
      this.FkF = ((int)bu.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$voice_second_shadow_color"), 16)), 0L));
      this.FkG = bu.o(Boolean.valueOf((String)paramString.get(str + ".$voice_second_show_background")));
      AppMethodBeat.o(141159);
      return;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed");
      ae.printErrStackTrace("MicroMsg.ChatBgAttr", paramString, "", new Object[0]);
      AppMethodBeat.o(141159);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.f
 * JD-Core Version:    0.7.0.1
 */