package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class f
{
  public int XYa;
  public boolean XYb;
  public int XYc;
  public boolean XYd;
  public boolean XYe;
  private int XYf;
  public boolean XYg;
  public int XYh;
  public boolean XYi;
  private int version;
  
  public f(String paramString, Context paramContext)
  {
    AppMethodBeat.i(141159);
    this.version = 0;
    this.XYa = -7829368;
    this.XYb = false;
    this.XYc = -1593835521;
    this.XYd = false;
    this.XYe = false;
    this.XYf = -16777216;
    this.XYg = false;
    this.XYh = 0;
    this.XYi = false;
    paramString = XmlParser.parseXml(paramString, "chatbg", null);
    if (paramString == null)
    {
      Log.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed, values is null");
      AppMethodBeat.o(141159);
      return;
    }
    String str = ".".concat(String.valueOf("chatbg"));
    try
    {
      this.version = Util.nullAsNil(Integer.valueOf((String)paramString.get(str + ".$version")));
      this.XYa = ((int)Util.nullAs(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$time_color"), 16)), paramContext.getResources().getColor(a.d.FG_2)));
      this.XYb = Util.nullAsFalse(Boolean.valueOf((String)paramString.get(str + ".$time_show_shadow_color")));
      this.XYc = ((int)Util.nullAs(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$time_shadow_color"), 16)), 0L));
      this.XYd = Util.nullAsFalse(Boolean.valueOf((String)paramString.get(str + ".$time_show_background")));
      this.XYe = Util.nullAsFalse(Boolean.valueOf((String)paramString.get(str + ".$time_light_background")));
      this.XYf = ((int)Util.nullAs(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$voice_second_color"), 16)), -16777216L));
      this.XYg = Util.nullAsFalse(Boolean.valueOf((String)paramString.get(str + ".$voice_second_show_shadow_color")));
      this.XYh = ((int)Util.nullAs(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$voice_second_shadow_color"), 16)), 0L));
      this.XYi = Util.nullAsFalse(Boolean.valueOf((String)paramString.get(str + ".$voice_second_show_background")));
      AppMethodBeat.o(141159);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed");
      Log.printErrStackTrace("MicroMsg.ChatBgAttr", paramString, "", new Object[0]);
      AppMethodBeat.o(141159);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.f
 * JD-Core Version:    0.7.0.1
 */