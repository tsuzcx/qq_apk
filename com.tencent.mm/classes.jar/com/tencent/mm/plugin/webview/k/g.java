package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.HashMap;

public final class g
{
  public HashMap<String, a> JBy;
  
  public g()
  {
    AppMethodBeat.i(82381);
    this.JBy = new HashMap();
    AppMethodBeat.o(82381);
  }
  
  public static void a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(82382);
    d.a locala = new d.a(paramContext);
    locala.Dk(false);
    locala.aoR(3);
    locala.bon(paramContext.getString(2131768594));
    if (!Util.isNullOrNil(paramString))
    {
      locala.Di(true);
      locala.aB(paramString);
    }
    locala.Dj(true);
    locala.bos(paramContext.getString(2131768593));
    locala.bou(paramContext.getString(2131755921));
    locala.aoX(paramContext.getResources().getColor(2131100685));
    locala.c(paramOnClickListener);
    locala.bov(paramContext.getString(2131755761));
    paramString = MultiProcessMMKV.getMMKV("key_webview_menu_haokan");
    if (paramString.decodeBool("show_first_tips", true))
    {
      paramString.encode("show_first_tips", false);
      paramString.apply();
      locala.aA(paramContext.getString(2131768592));
    }
    locala.hbn().show();
    AppMethodBeat.o(82382);
  }
  
  public final a bbo(String paramString)
  {
    AppMethodBeat.i(82383);
    paramString = (a)this.JBy.get(paramString);
    AppMethodBeat.o(82383);
    return paramString;
  }
  
  public static final class a
  {
    public int JBz;
    public int permission;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.g
 * JD-Core Version:    0.7.0.1
 */