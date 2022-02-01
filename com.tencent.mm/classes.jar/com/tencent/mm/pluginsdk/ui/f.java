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
  public int RbV;
  public boolean RbW;
  public int RbX;
  public boolean RbY;
  public boolean RbZ;
  private int Rca;
  public boolean Rcb;
  public int Rcc;
  public boolean Rcd;
  private int version;
  
  public f(String paramString, Context paramContext)
  {
    AppMethodBeat.i(141159);
    this.version = 0;
    this.RbV = -7829368;
    this.RbW = false;
    this.RbX = -1593835521;
    this.RbY = false;
    this.RbZ = false;
    this.Rca = -16777216;
    this.Rcb = false;
    this.Rcc = 0;
    this.Rcd = false;
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
      this.RbV = ((int)Util.nullAs(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$time_color"), 16)), paramContext.getResources().getColor(a.d.FG_2)));
      this.RbW = Util.nullAsFalse(Boolean.valueOf((String)paramString.get(str + ".$time_show_shadow_color")));
      this.RbX = ((int)Util.nullAs(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$time_shadow_color"), 16)), 0L));
      this.RbY = Util.nullAsFalse(Boolean.valueOf((String)paramString.get(str + ".$time_show_background")));
      this.RbZ = Util.nullAsFalse(Boolean.valueOf((String)paramString.get(str + ".$time_light_background")));
      this.Rca = ((int)Util.nullAs(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$voice_second_color"), 16)), -16777216L));
      this.Rcb = Util.nullAsFalse(Boolean.valueOf((String)paramString.get(str + ".$voice_second_show_shadow_color")));
      this.Rcc = ((int)Util.nullAs(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$voice_second_shadow_color"), 16)), 0L));
      this.Rcd = Util.nullAsFalse(Boolean.valueOf((String)paramString.get(str + ".$voice_second_show_background")));
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