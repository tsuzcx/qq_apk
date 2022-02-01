package com.tencent.mm.plugin.sns.ad.landingpage.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.l;
import com.tencent.mm.ui.base.s;

public final class a
  extends s
{
  private a(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt, 0);
    AppMethodBeat.i(263813);
    paramContext = getWindow();
    if (paramContext != null)
    {
      paramContext.addFlags(8);
      paramContext.getDecorView().setSystemUiVisibility(4102);
    }
    AppMethodBeat.o(263813);
  }
  
  public static s aH(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(263814);
    if ((paramContext instanceof Activity))
    {
      String str = "";
      if (paramInt > 0) {
        str = paramContext.getString(paramInt);
      }
      paramContext = new a(paramContext, a.l.mmalertdialog);
      if (!TextUtils.isEmpty(str)) {
        paramContext.setMessage(str);
      }
      paramContext.setCancelable(true);
      paramContext.setOnCancelListener(null);
      paramContext.setCanceledOnTouchOutside(false);
      AppMethodBeat.o(263814);
      return paramContext;
    }
    AppMethodBeat.o(263814);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.a.a
 * JD-Core Version:    0.7.0.1
 */