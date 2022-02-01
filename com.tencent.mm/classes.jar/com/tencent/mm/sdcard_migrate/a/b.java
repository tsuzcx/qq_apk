package com.tencent.mm.sdcard_migrate.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

@JgClassChecked(author=20, fComment="checked", lastDate="201400504", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public final class b
{
  public static void a(Context paramContext, Dialog paramDialog)
  {
    AppMethodBeat.i(211107);
    if ((paramContext instanceof MMActivity))
    {
      ((MMActivity)paramContext).addDialog(paramDialog);
      if (((paramContext instanceof com.tencent.mm.ui.widget.a.c)) && ((paramDialog instanceof c))) {
        ((c)paramDialog).iOnDialogDismissListener = ((com.tencent.mm.ui.widget.a.c)paramContext);
      }
    }
    AppMethodBeat.o(211107);
  }
  
  public static c c(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(211108);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(211108);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.aPS(paramString2);
    locala.aPT(paramString1);
    locala.fjF().a(paramOnClickListener);
    locala.fjG();
    paramString1 = locala.fjH();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(211108);
    return paramString1;
  }
  
  public static c c(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(211109);
    paramContext = d(paramContext, paramString1, paramString2, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2);
    AppMethodBeat.o(211109);
    return paramContext;
  }
  
  private static c d(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(211110);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(211110);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.aPS(paramString2);
    locala.aPT(paramString1);
    locala.aPU(paramString3).a(paramOnClickListener1);
    locala.aPV(paramString4).b(paramOnClickListener2);
    locala.fjG();
    paramString1 = locala.fjH();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(211110);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.a.b
 * JD-Core Version:    0.7.0.1
 */