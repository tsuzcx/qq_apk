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
    AppMethodBeat.i(211891);
    if ((paramContext instanceof MMActivity))
    {
      ((MMActivity)paramContext).addDialog(paramDialog);
      if (((paramContext instanceof com.tencent.mm.ui.widget.a.c)) && ((paramDialog instanceof c))) {
        ((c)paramDialog).iOnDialogDismissListener = ((com.tencent.mm.ui.widget.a.c)paramContext);
      }
    }
    AppMethodBeat.o(211891);
  }
  
  public static c c(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(211892);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(211892);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.aRp(paramString2);
    locala.aRq(paramString1);
    locala.fnx().a(paramOnClickListener);
    locala.fny();
    paramString1 = locala.fnz();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(211892);
    return paramString1;
  }
  
  public static c c(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(211893);
    paramContext = d(paramContext, paramString1, paramString2, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2);
    AppMethodBeat.o(211893);
    return paramContext;
  }
  
  private static c d(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(211894);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(211894);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.aRp(paramString2);
    locala.aRq(paramString1);
    locala.aRr(paramString3).a(paramOnClickListener1);
    locala.aRs(paramString4).b(paramOnClickListener2);
    locala.fny();
    paramString1 = locala.fnz();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(211894);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.a.b
 * JD-Core Version:    0.7.0.1
 */