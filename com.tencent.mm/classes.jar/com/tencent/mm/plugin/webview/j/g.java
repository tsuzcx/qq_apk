package com.tencent.mm.plugin.webview.j;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.HashMap;

public final class g
{
  public HashMap<String, a> ELH;
  
  public g()
  {
    AppMethodBeat.i(82381);
    this.ELH = new HashMap();
    AppMethodBeat.o(82381);
  }
  
  public static void a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(82382);
    d.a locala = new d.a(paramContext);
    locala.zf(false);
    locala.afQ(3);
    locala.aZh(paramContext.getString(2131766123));
    if (!bu.isNullOrNil(paramString))
    {
      locala.zd(true);
      locala.at(paramString);
    }
    locala.ze(true);
    locala.aZm(paramContext.getString(2131766122));
    locala.aZo(paramContext.getString(2131755835));
    locala.afW(paramContext.getResources().getColor(2131100547));
    locala.c(paramOnClickListener);
    locala.aZp(paramContext.getString(2131755691));
    paramString = ay.aRW("key_webview_menu_haokan");
    if (paramString.decodeBool("show_first_tips", true))
    {
      paramString.encode("show_first_tips", false);
      paramString.apply();
      locala.as(paramContext.getString(2131766121));
    }
    locala.fQv().show();
    AppMethodBeat.o(82382);
  }
  
  public final a aKY(String paramString)
  {
    AppMethodBeat.i(82383);
    paramString = (a)this.ELH.get(paramString);
    AppMethodBeat.o(82383);
    return paramString;
  }
  
  public static final class a
  {
    public int ELI;
    public int permission;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.g
 * JD-Core Version:    0.7.0.1
 */