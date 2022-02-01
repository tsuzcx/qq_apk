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

public final class f
{
  public HashMap<String, a> Bxd;
  
  public f()
  {
    AppMethodBeat.i(82381);
    this.Bxd = new HashMap();
    AppMethodBeat.o(82381);
  }
  
  public static void a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(82382);
    d.a locala = new d.a(paramContext);
    locala.wX(false);
    locala.aax(3);
    locala.aMf(paramContext.getString(2131766123));
    if (!bt.isNullOrNil(paramString))
    {
      locala.wV(true);
      locala.at(paramString);
    }
    locala.wW(true);
    locala.aMk(paramContext.getString(2131766122));
    locala.aMm(paramContext.getString(2131755835));
    locala.aaD(paramContext.getResources().getColor(2131100547));
    locala.b(paramOnClickListener);
    locala.aMn(paramContext.getString(2131755691));
    paramString = ax.aFC("key_webview_menu_haokan");
    if (paramString.decodeBool("show_first_tips", true))
    {
      paramString.encode("show_first_tips", false);
      paramString.apply();
      locala.as(paramContext.getString(2131766121));
    }
    locala.fft().show();
    AppMethodBeat.o(82382);
  }
  
  public final a ayJ(String paramString)
  {
    AppMethodBeat.i(82383);
    paramString = (a)this.Bxd.get(paramString);
    AppMethodBeat.o(82383);
    return paramString;
  }
  
  public static final class a
  {
    public int Bxe;
    public int permission;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.f
 * JD-Core Version:    0.7.0.1
 */