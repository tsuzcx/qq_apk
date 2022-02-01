package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class f
{
  public int Kbq;
  public boolean Kbr;
  public int Kbs;
  public boolean Kbt;
  public boolean Kbu;
  private int Kbv;
  public boolean Kbw;
  public int Kbx;
  public boolean Kby;
  private int version;
  
  public f(String paramString, Context paramContext)
  {
    AppMethodBeat.i(141159);
    this.version = 0;
    this.Kbq = -7829368;
    this.Kbr = false;
    this.Kbs = -1593835521;
    this.Kbt = false;
    this.Kbu = false;
    this.Kbv = -16777216;
    this.Kbw = false;
    this.Kbx = 0;
    this.Kby = false;
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
      this.Kbq = ((int)Util.nullAs(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$time_color"), 16)), paramContext.getResources().getColor(2131099749)));
      this.Kbr = Util.nullAsFalse(Boolean.valueOf((String)paramString.get(str + ".$time_show_shadow_color")));
      this.Kbs = ((int)Util.nullAs(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$time_shadow_color"), 16)), 0L));
      this.Kbt = Util.nullAsFalse(Boolean.valueOf((String)paramString.get(str + ".$time_show_background")));
      this.Kbu = Util.nullAsFalse(Boolean.valueOf((String)paramString.get(str + ".$time_light_background")));
      this.Kbv = ((int)Util.nullAs(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$voice_second_color"), 16)), -16777216L));
      this.Kbw = Util.nullAsFalse(Boolean.valueOf((String)paramString.get(str + ".$voice_second_show_shadow_color")));
      this.Kbx = ((int)Util.nullAs(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$voice_second_shadow_color"), 16)), 0L));
      this.Kby = Util.nullAsFalse(Boolean.valueOf((String)paramString.get(str + ".$voice_second_show_background")));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.f
 * JD-Core Version:    0.7.0.1
 */