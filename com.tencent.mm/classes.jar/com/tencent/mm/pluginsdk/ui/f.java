package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

public final class f
{
  public int ESd;
  public boolean ESe;
  public int ESf;
  public boolean ESg;
  public boolean ESh;
  private int ESi;
  public boolean ESj;
  public int ESk;
  public boolean ESl;
  private int version;
  
  public f(String paramString, Context paramContext)
  {
    AppMethodBeat.i(141159);
    this.version = 0;
    this.ESd = -7829368;
    this.ESe = false;
    this.ESf = -1593835521;
    this.ESg = false;
    this.ESh = false;
    this.ESi = -16777216;
    this.ESj = false;
    this.ESk = 0;
    this.ESl = false;
    paramString = bw.M(paramString, "chatbg");
    if (paramString == null)
    {
      ad.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed, values is null");
      AppMethodBeat.o(141159);
      return;
    }
    String str = ".".concat(String.valueOf("chatbg"));
    try
    {
      this.version = bt.n(Integer.valueOf((String)paramString.get(str + ".$version")));
      this.ESd = ((int)bt.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$time_color"), 16)), paramContext.getResources().getColor(2131099735)));
      this.ESe = bt.o(Boolean.valueOf((String)paramString.get(str + ".$time_show_shadow_color")));
      this.ESf = ((int)bt.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$time_shadow_color"), 16)), 0L));
      this.ESg = bt.o(Boolean.valueOf((String)paramString.get(str + ".$time_show_background")));
      this.ESh = bt.o(Boolean.valueOf((String)paramString.get(str + ".$time_light_background")));
      this.ESi = ((int)bt.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$voice_second_color"), 16)), -16777216L));
      this.ESj = bt.o(Boolean.valueOf((String)paramString.get(str + ".$voice_second_show_shadow_color")));
      this.ESk = ((int)bt.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$voice_second_shadow_color"), 16)), 0L));
      this.ESl = bt.o(Boolean.valueOf((String)paramString.get(str + ".$voice_second_show_background")));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.f
 * JD-Core Version:    0.7.0.1
 */