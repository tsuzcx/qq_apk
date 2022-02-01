package com.tencent.mm.plugin.sns.ui.helper;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.g;
import com.tencent.mm.ad.i;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/helper/ThirdAppJumpHelper;", "", "()V", "APP_TYPE_SECOND_CUP", "", "KEY_APP_TYPE", "KEY_MSG_EXT", "KEY_SECOND_CUT_EXT_INFO", "TAG", "createSecondCutJson", "extMsg", "getJumpJSON", "appId", "tryUnescapeXml", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a RKs;
  
  static
  {
    AppMethodBeat.i(308134);
    RKs = new a();
    AppMethodBeat.o(308134);
  }
  
  public static String baW(String paramString)
  {
    AppMethodBeat.i(308123);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; (i == 0) && (n.a((CharSequence)paramString, (CharSequence)"miaojianExtInfo", false)); i = 0)
    {
      paramString = baX(paramString);
      AppMethodBeat.o(308123);
      return paramString;
    }
    AppMethodBeat.o(308123);
    return "";
  }
  
  private static String baX(String paramString)
  {
    AppMethodBeat.i(308126);
    try
    {
      String str = new i(paramString).optString("miaojianExtInfo");
      if (!TextUtils.isEmpty((CharSequence)str))
      {
        i locali = new i();
        locali.m("APP_TYPE", "APP_TYPE_SECOND_CUP");
        locali.m("MSG_EXT", str);
        str = locali.toString();
        s.s(str, "jsonObj.toString()");
        AppMethodBeat.o(308126);
        return str;
      }
    }
    catch (g localg)
    {
      Log.e("MicroMsg.ThirdAppJumpHelper", "parse SecondCutSimpleStyle JSON error");
      paramString = baY(paramString);
      AppMethodBeat.o(308126);
      return paramString;
    }
    AppMethodBeat.o(308126);
    return "";
  }
  
  private static String baY(String paramString)
  {
    AppMethodBeat.i(308131);
    try
    {
      if (TextUtils.isEmpty((CharSequence)paramString))
      {
        AppMethodBeat.o(308131);
        return "";
      }
      paramString = new i(o.Po(paramString)).optString("miaojianExtInfo");
      if (!TextUtils.isEmpty((CharSequence)paramString))
      {
        i locali = new i();
        locali.m("APP_TYPE", "APP_TYPE_SECOND_CUP");
        locali.m("MSG_EXT", paramString);
        paramString = locali.toString();
        s.s(paramString, "jsonObj.toString()");
        AppMethodBeat.o(308131);
        return paramString;
      }
    }
    catch (g paramString)
    {
      Log.e("MicroMsg.ThirdAppJumpHelper", "parse SecondCutSimpleStyle JSON error");
      AppMethodBeat.o(308131);
      return "";
    }
    AppMethodBeat.o(308131);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.helper.a
 * JD-Core Version:    0.7.0.1
 */