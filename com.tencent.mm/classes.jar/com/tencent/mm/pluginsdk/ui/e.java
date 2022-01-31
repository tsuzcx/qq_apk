package com.tencent.mm.pluginsdk.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class e
{
  public int vQa;
  public boolean vQb;
  public int vQc;
  public boolean vQd;
  public boolean vQe;
  private int vQf;
  public boolean vQg;
  public int vQh;
  public boolean vQi;
  private int version;
  
  public e(String paramString)
  {
    AppMethodBeat.i(105839);
    this.version = 0;
    this.vQa = -7829368;
    this.vQb = false;
    this.vQc = -1593835521;
    this.vQd = false;
    this.vQe = false;
    this.vQf = -16777216;
    this.vQg = false;
    this.vQh = 0;
    this.vQi = false;
    paramString = br.F(paramString, "chatbg");
    if (paramString == null)
    {
      ab.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed, values is null");
      AppMethodBeat.o(105839);
      return;
    }
    String str = ".".concat(String.valueOf("chatbg"));
    try
    {
      this.version = bo.g(Integer.valueOf((String)paramString.get(str + ".$version")));
      this.vQa = ((int)bo.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$time_color"), 16)), -7829368L));
      this.vQb = bo.e(Boolean.valueOf((String)paramString.get(str + ".$time_show_shadow_color")));
      this.vQc = ((int)bo.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$time_shadow_color"), 16)), 0L));
      this.vQd = bo.e(Boolean.valueOf((String)paramString.get(str + ".$time_show_background")));
      this.vQe = bo.e(Boolean.valueOf((String)paramString.get(str + ".$time_light_background")));
      this.vQf = ((int)bo.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$voice_second_color"), 16)), -16777216L));
      this.vQg = bo.e(Boolean.valueOf((String)paramString.get(str + ".$voice_second_show_shadow_color")));
      this.vQh = ((int)bo.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$voice_second_shadow_color"), 16)), 0L));
      this.vQi = bo.e(Boolean.valueOf((String)paramString.get(str + ".$voice_second_show_background")));
      AppMethodBeat.o(105839);
      return;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed");
      ab.printErrStackTrace("MicroMsg.ChatBgAttr", paramString, "", new Object[0]);
      AppMethodBeat.o(105839);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.e
 * JD-Core Version:    0.7.0.1
 */