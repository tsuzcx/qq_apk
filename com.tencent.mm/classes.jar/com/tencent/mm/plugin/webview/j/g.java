package com.tencent.mm.plugin.webview.j;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.HashMap;

public final class g
{
  public HashMap<String, a> Etn;
  
  public g()
  {
    AppMethodBeat.i(82381);
    this.Etn = new HashMap();
    AppMethodBeat.o(82381);
  }
  
  public static void a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(82382);
    d.a locala = new d.a(paramContext);
    locala.yR(false);
    locala.afh(3);
    locala.aXF(paramContext.getString(2131766123));
    if (!bt.isNullOrNil(paramString))
    {
      locala.yP(true);
      locala.au(paramString);
    }
    locala.yQ(true);
    locala.aXK(paramContext.getString(2131766122));
    locala.aXM(paramContext.getString(2131755835));
    locala.afn(paramContext.getResources().getColor(2131100547));
    locala.c(paramOnClickListener);
    locala.aXN(paramContext.getString(2131755691));
    paramString = ax.aQz("key_webview_menu_haokan");
    if (paramString.decodeBool("show_first_tips", true))
    {
      paramString.encode("show_first_tips", false);
      paramString.apply();
      locala.at(paramContext.getString(2131766121));
    }
    locala.fMb().show();
    AppMethodBeat.o(82382);
  }
  
  public final a aJC(String paramString)
  {
    AppMethodBeat.i(82383);
    paramString = (a)this.Etn.get(paramString);
    AppMethodBeat.o(82383);
    return paramString;
  }
  
  public static final class a
  {
    public int Eto;
    public int permission;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.g
 * JD-Core Version:    0.7.0.1
 */