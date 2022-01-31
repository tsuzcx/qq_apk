package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class e
{
  public int rZj = -7829368;
  public boolean rZk = false;
  public int rZl = -1593835521;
  public boolean rZm = false;
  public boolean rZn = false;
  public int rZo = -16777216;
  public boolean rZp = false;
  public int rZq = 0;
  public boolean rZr = false;
  private int version = 0;
  
  public e(String paramString)
  {
    paramString = bn.s(paramString, "chatbg");
    if (paramString == null)
    {
      y.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed, values is null");
      return;
    }
    String str = "." + "chatbg";
    try
    {
      this.version = bk.g(Integer.valueOf((String)paramString.get(str + ".$version")));
      this.rZj = ((int)bk.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$time_color"), 16)), -7829368L));
      this.rZk = bk.d(Boolean.valueOf((String)paramString.get(str + ".$time_show_shadow_color")));
      this.rZl = ((int)bk.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$time_shadow_color"), 16)), 0L));
      this.rZm = bk.d(Boolean.valueOf((String)paramString.get(str + ".$time_show_background")));
      this.rZn = bk.d(Boolean.valueOf((String)paramString.get(str + ".$time_light_background")));
      this.rZo = ((int)bk.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$voice_second_color"), 16)), -16777216L));
      this.rZp = bk.d(Boolean.valueOf((String)paramString.get(str + ".$voice_second_show_shadow_color")));
      this.rZq = ((int)bk.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$voice_second_shadow_color"), 16)), 0L));
      this.rZr = bk.d(Boolean.valueOf((String)paramString.get(str + ".$voice_second_show_background")));
      return;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed");
      y.printErrStackTrace("MicroMsg.ChatBgAttr", paramString, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.e
 * JD-Core Version:    0.7.0.1
 */