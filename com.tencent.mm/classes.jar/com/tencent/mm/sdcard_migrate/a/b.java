package com.tencent.mm.sdcard_migrate.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.d;

public final class b
{
  public static c a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(257244);
    paramContext = b(paramContext, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2);
    AppMethodBeat.o(257244);
    return paramContext;
  }
  
  public static void a(Context paramContext, Dialog paramDialog)
  {
    AppMethodBeat.i(257233);
    if ((paramContext instanceof MMActivity))
    {
      ((MMActivity)paramContext).addDialog(paramDialog);
      if (((paramContext instanceof d)) && ((paramDialog instanceof c))) {
        ((c)paramDialog).iOnDialogDismissListener = ((d)paramContext);
      }
    }
    AppMethodBeat.o(257233);
  }
  
  public static c b(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(257240);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(257240);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.buk(null);
    locala.bul(paramString);
    locala.ayk(a.k.app_ok).a(paramOnClickListener);
    locala.KB(false);
    paramString = locala.iTq();
    paramString.show();
    a(paramContext, paramString);
    AppMethodBeat.o(257240);
    return paramString;
  }
  
  private static c b(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(257251);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(257251);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.buk(null);
    locala.bul(paramString1);
    locala.bum(paramString2).a(paramOnClickListener1);
    locala.bun(paramString3).b(paramOnClickListener2);
    locala.KB(false);
    paramString1 = locala.iTq();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(257251);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.a.b
 * JD-Core Version:    0.7.0.1
 */