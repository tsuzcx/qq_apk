package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

public final class e
{
  public int BUI;
  public boolean BUJ;
  public int BUK;
  public boolean BUL;
  public boolean BUM;
  private int BUN;
  public boolean BUO;
  public int BUP;
  public boolean BUQ;
  private int version;
  
  public e(String paramString, Context paramContext)
  {
    AppMethodBeat.i(141159);
    this.version = 0;
    this.BUI = -7829368;
    this.BUJ = false;
    this.BUK = -1593835521;
    this.BUL = false;
    this.BUM = false;
    this.BUN = -16777216;
    this.BUO = false;
    this.BUP = 0;
    this.BUQ = false;
    paramString = bw.K(paramString, "chatbg");
    if (paramString == null)
    {
      ad.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed, values is null");
      AppMethodBeat.o(141159);
      return;
    }
    String str = ".".concat(String.valueOf("chatbg"));
    try
    {
      this.version = bt.l(Integer.valueOf((String)paramString.get(str + ".$version")));
      this.BUI = ((int)bt.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$time_color"), 16)), paramContext.getResources().getColor(2131099735)));
      this.BUJ = bt.l(Boolean.valueOf((String)paramString.get(str + ".$time_show_shadow_color")));
      this.BUK = ((int)bt.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$time_shadow_color"), 16)), 0L));
      this.BUL = bt.l(Boolean.valueOf((String)paramString.get(str + ".$time_show_background")));
      this.BUM = bt.l(Boolean.valueOf((String)paramString.get(str + ".$time_light_background")));
      this.BUN = ((int)bt.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$voice_second_color"), 16)), -16777216L));
      this.BUO = bt.l(Boolean.valueOf((String)paramString.get(str + ".$voice_second_show_shadow_color")));
      this.BUP = ((int)bt.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$voice_second_shadow_color"), 16)), 0L));
      this.BUQ = bt.l(Boolean.valueOf((String)paramString.get(str + ".$voice_second_show_background")));
      AppMethodBeat.o(141159);
      return;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed");
      ad.printErrStackTrace("MicroMsg.ChatBgAttr", paramString, "", new Object[0]);
      AppMethodBeat.o(141159);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.e
 * JD-Core Version:    0.7.0.1
 */