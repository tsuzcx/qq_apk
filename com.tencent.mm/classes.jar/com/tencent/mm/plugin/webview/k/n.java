package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.HashMap;

public final class n
{
  public HashMap<String, a> Xtj;
  
  public n()
  {
    AppMethodBeat.i(82381);
    this.Xtj = new HashMap();
    AppMethodBeat.o(82381);
  }
  
  public static void a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(82382);
    e.a locala = new e.a(paramContext);
    locala.NC(false);
    locala.aEN(3);
    locala.bDv(paramContext.getString(c.i.webview_menu_hao_kan_dialog_title));
    if (!Util.isNullOrNil(paramString))
    {
      locala.NA(true);
      locala.be(paramString);
    }
    locala.NB(true);
    locala.bDA(paramContext.getString(c.i.webview_menu_hao_kan_dialog_tips));
    locala.bDC(paramContext.getString(c.i.app_ok));
    locala.aET(paramContext.getResources().getColor(c.c.link_color));
    locala.c(paramOnClickListener);
    locala.bDD(paramContext.getString(c.i.app_cancel));
    paramString = MultiProcessMMKV.getMMKV("key_webview_menu_haokan");
    if (paramString.decodeBool("show_first_tips", true))
    {
      paramString.encode("show_first_tips", false);
      paramString.apply();
      locala.bd(paramContext.getString(c.i.webview_menu_hao_kan_dialog_firt_tips));
    }
    locala.jHH().show();
    AppMethodBeat.o(82382);
  }
  
  public final a bmY(String paramString)
  {
    AppMethodBeat.i(82383);
    paramString = (a)this.Xtj.get(paramString);
    AppMethodBeat.o(82383);
    return paramString;
  }
  
  public static final class a
  {
    public int Xtk;
    public int Xtl;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.n
 * JD-Core Version:    0.7.0.1
 */