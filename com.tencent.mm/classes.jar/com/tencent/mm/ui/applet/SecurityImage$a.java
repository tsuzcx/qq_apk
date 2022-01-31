package com.tencent.mm.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;

public final class SecurityImage$a
{
  public static SecurityImage a(Context paramContext, int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2, final DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener, DialogInterface.OnDismissListener paramOnDismissListener, SecurityImage.b paramb)
  {
    AppMethodBeat.i(106233);
    SecurityImage localSecurityImage = (SecurityImage)View.inflate(paramContext, 2130970638, null);
    localSecurityImage.setNetworkModel(paramb);
    localSecurityImage.a(paramInt, paramArrayOfByte, paramString1, paramString2);
    paramContext = new c.a(paramContext);
    paramContext.Rb(2131302484);
    paramContext.Ri(2131296894).a(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(106232);
        paramOnClickListener.onClick(paramAnonymousDialogInterface, paramAnonymousInt);
        AppMethodBeat.o(106232);
      }
    });
    paramContext.e(paramOnCancelListener);
    paramContext.fu(localSecurityImage);
    paramContext.rG(true);
    SecurityImage.a(localSecurityImage, paramContext.aLZ());
    SecurityImage.c(localSecurityImage).setOnDismissListener(paramOnDismissListener);
    SecurityImage.c(localSecurityImage).show();
    AppMethodBeat.o(106233);
    return localSecurityImage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.applet.SecurityImage.a
 * JD-Core Version:    0.7.0.1
 */