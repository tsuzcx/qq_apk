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
  public static c a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(195875);
    String str1;
    if (paramInt1 > 0)
    {
      str1 = paramContext.getString(paramInt1);
      if (paramInt2 <= 0) {
        break label65;
      }
    }
    label65:
    for (String str2 = paramContext.getString(paramInt2);; str2 = "")
    {
      paramContext = c(paramContext, str1, str2, paramContext.getString(paramInt3), paramContext.getString(paramInt4), paramOnClickListener1, paramOnClickListener2);
      AppMethodBeat.o(195875);
      return paramContext;
      str1 = "";
      break;
    }
  }
  
  public static void a(Context paramContext, Dialog paramDialog)
  {
    AppMethodBeat.i(195872);
    if ((paramContext instanceof MMActivity))
    {
      ((MMActivity)paramContext).addDialog(paramDialog);
      if (((paramContext instanceof com.tencent.mm.ui.widget.a.c)) && ((paramDialog instanceof c))) {
        ((c)paramDialog).iOnDialogDismissListener = ((com.tencent.mm.ui.widget.a.c)paramContext);
      }
    }
    AppMethodBeat.o(195872);
  }
  
  public static c c(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(195873);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(195873);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.aKn(paramString2);
    locala.aKo(paramString1);
    locala.eUc().a(paramOnClickListener);
    locala.eUd();
    paramString1 = locala.eUe();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(195873);
    return paramString1;
  }
  
  private static c c(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(195874);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(195874);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.aKn(paramString2);
    locala.aKo(paramString1);
    locala.aKp(paramString3).a(paramOnClickListener1);
    locala.GpN.GoI = paramString4;
    locala.GpN.GoQ = paramOnClickListener2;
    locala.eUd();
    paramString1 = locala.eUe();
    paramString1.show();
    a(paramContext, paramString1);
    AppMethodBeat.o(195874);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.a.b
 * JD-Core Version:    0.7.0.1
 */