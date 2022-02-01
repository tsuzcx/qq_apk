package com.tencent.mm.plugin.sns.ui.helper;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.g;
import com.tencent.mm.ad.i;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/sns/ui/helper/ThirdAppJumpHelper;", "", "()V", "APP_TYPE_SECOND_CUP", "", "KEY_APP_TYPE", "KEY_MSG_EXT", "KEY_SECOND_CUT_EXT_INFO", "TAG", "createSecondCutJson", "extMsg", "getJumpJSON", "appId", "tryUnescapeXml", "plugin-sns_release"})
public final class a
{
  public static final a LkD;
  
  static
  {
    AppMethodBeat.i(243079);
    LkD = new a();
    AppMethodBeat.o(243079);
  }
  
  public static String bcq(String paramString)
  {
    AppMethodBeat.i(243070);
    try
    {
      String str = new i(paramString).optString("miaojianExtInfo");
      if (!TextUtils.isEmpty((CharSequence)str))
      {
        i locali = new i();
        locali.g("APP_TYPE", "APP_TYPE_SECOND_CUP");
        locali.g("MSG_EXT", str);
        str = locali.toString();
        p.j(str, "jsonObj.toString()");
        AppMethodBeat.o(243070);
        return str;
      }
    }
    catch (g localg)
    {
      Log.e("MicroMsg.ThirdAppJumpHelper", "parse SecondCutSimpleStyle JSON error");
      paramString = bcr(paramString);
      AppMethodBeat.o(243070);
      return paramString;
    }
    AppMethodBeat.o(243070);
    return "";
  }
  
  private static String bcr(String paramString)
  {
    AppMethodBeat.i(243073);
    try
    {
      if (TextUtils.isEmpty((CharSequence)paramString))
      {
        AppMethodBeat.o(243073);
        return "";
      }
      paramString = new i(o.Xm(paramString)).optString("miaojianExtInfo");
      if (!TextUtils.isEmpty((CharSequence)paramString))
      {
        i locali = new i();
        locali.g("APP_TYPE", "APP_TYPE_SECOND_CUP");
        locali.g("MSG_EXT", paramString);
        paramString = locali.toString();
        p.j(paramString, "jsonObj.toString()");
        AppMethodBeat.o(243073);
        return paramString;
      }
    }
    catch (g paramString)
    {
      Log.e("MicroMsg.ThirdAppJumpHelper", "parse SecondCutSimpleStyle JSON error");
      AppMethodBeat.o(243073);
      return "";
    }
    AppMethodBeat.o(243073);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.helper.a
 * JD-Core Version:    0.7.0.1
 */