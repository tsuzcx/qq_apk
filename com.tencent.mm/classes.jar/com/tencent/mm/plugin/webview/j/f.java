package com.tencent.mm.plugin.webview.j;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.HashMap;

public final class f
{
  public HashMap<String, a> CPl;
  
  public f()
  {
    AppMethodBeat.i(82381);
    this.CPl = new HashMap();
    AppMethodBeat.o(82381);
  }
  
  public static void a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(82382);
    d.a locala = new d.a(paramContext);
    locala.yf(false);
    locala.acI(3);
    locala.aRH(paramContext.getString(2131766123));
    if (!bs.isNullOrNil(paramString))
    {
      locala.yd(true);
      locala.au(paramString);
    }
    locala.ye(true);
    locala.aRM(paramContext.getString(2131766122));
    locala.aRO(paramContext.getString(2131755835));
    locala.acO(paramContext.getResources().getColor(2131100547));
    locala.b(paramOnClickListener);
    locala.aRP(paramContext.getString(2131755691));
    paramString = aw.aKT("key_webview_menu_haokan");
    if (paramString.decodeBool("show_first_tips", true))
    {
      paramString.encode("show_first_tips", false);
      paramString.apply();
      locala.at(paramContext.getString(2131766121));
    }
    locala.fvp().show();
    AppMethodBeat.o(82382);
  }
  
  public final a aEa(String paramString)
  {
    AppMethodBeat.i(82383);
    paramString = (a)this.CPl.get(paramString);
    AppMethodBeat.o(82383);
    return paramString;
  }
  
  public static final class a
  {
    public int CPm;
    public int permission;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.f
 * JD-Core Version:    0.7.0.1
 */