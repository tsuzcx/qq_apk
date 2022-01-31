package com.tencent.mm.plugin.webview.f;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class c
{
  public HashMap<String, a> vtY;
  
  public c()
  {
    AppMethodBeat.i(10139);
    this.vtY = new HashMap();
    AppMethodBeat.o(10139);
  }
  
  public static void a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(10140);
    com.tencent.mm.ui.widget.b.c.a locala = new com.tencent.mm.ui.widget.b.c.a(paramContext);
    locala.rG(false);
    locala.Re(3);
    locala.avm(paramContext.getString(2131305887));
    if (!bo.isNullOrNil(paramString))
    {
      locala.rE(true);
      locala.ai(paramString);
    }
    locala.rF(true);
    locala.avq(paramContext.getString(2131305886));
    locala.avs(paramContext.getString(2131297018));
    locala.Rk(paramContext.getResources().getColor(2131690214));
    locala.a(paramOnClickListener);
    locala.avt(paramContext.getString(2131296888));
    paramString = as.eu("key_webview_menu_haokan", 2);
    if (paramString.decodeBool("show_first_tips", true))
    {
      paramString.encode("show_first_tips", false);
      paramString.apply();
      locala.ah(paramContext.getString(2131305885));
    }
    locala.aLZ().show();
    AppMethodBeat.o(10140);
  }
  
  public final a ajo(String paramString)
  {
    AppMethodBeat.i(10141);
    paramString = (a)this.vtY.get(paramString);
    AppMethodBeat.o(10141);
    return paramString;
  }
  
  public static final class a
  {
    public int permission;
    public String title;
    public int vtZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.c
 * JD-Core Version:    0.7.0.1
 */