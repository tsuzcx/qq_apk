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
  public static c a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(204655);
    paramContext = b(paramContext, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2);
    AppMethodBeat.o(204655);
    return paramContext;
  }
  
  public static void a(Context paramContext, Dialog paramDialog)
  {
    AppMethodBeat.i(204653);
    if ((paramContext instanceof MMActivity))
    {
      ((MMActivity)paramContext).addDialog(paramDialog);
      if (((paramContext instanceof com.tencent.mm.ui.widget.a.c)) && ((paramDialog instanceof c))) {
        ((c)paramDialog).iOnDialogDismissListener = ((com.tencent.mm.ui.widget.a.c)paramContext);
      }
    }
    AppMethodBeat.o(204653);
  }
  
  public static c b(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(204654);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(204654);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.bhS(null);
    locala.bhT(paramString);
    locala.gxl().a(paramOnClickListener);
    locala.AI(false);
    paramString = locala.gxm();
    paramString.show();
    a(paramContext, paramString);
    AppMethodBeat.o(204654);
    return paramString;
  }
  
  private static c b(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(204656);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(204656);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.bhS(null);
    locala.bhT(paramString1);
    locala.bhU(paramString2).a(paramOnClickListener1);
    locala.bhV(paramString3).b(paramOnClickListener2);
    locala.AI(false);
    paramString1 = locala.gxm();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(204656);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.a.b
 * JD-Core Version:    0.7.0.1
 */