package com.tencent.mm.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.k;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;

public final class SecurityImage$a
{
  public static SecurityImage a(Context paramContext, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString1, String paramString2, final DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener, DialogInterface.OnDismissListener paramOnDismissListener, SecurityImage.b paramb)
  {
    SecurityImage localSecurityImage = (SecurityImage)View.inflate(paramContext, a.h.security_image, null);
    localSecurityImage.setNetworkModel(paramb);
    localSecurityImage.uSo = ((ProgressBar)localSecurityImage.findViewById(a.g.refresh_mini_pb));
    localSecurityImage.uSp = ((ImageView)localSecurityImage.findViewById(a.g.authcode_iv));
    localSecurityImage.uSq = ((Button)localSecurityImage.findViewById(a.g.authcode_change_btn));
    localSecurityImage.uSr = ((EditText)localSecurityImage.findViewById(a.g.authcode_et));
    localSecurityImage.uSq.setOnClickListener(new SecurityImage.1(localSecurityImage));
    localSecurityImage.a(paramInt2, paramArrayOfByte, paramString1, paramString2);
    paramContext = new c.a(paramContext);
    paramContext.Ip(paramInt1);
    paramContext.Is(a.k.app_continue).a(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramOnClickListener.onClick(paramAnonymousDialogInterface, paramAnonymousInt);
      }
    });
    paramContext.e(paramOnCancelListener);
    paramContext.ei(localSecurityImage);
    paramContext.nW(true);
    SecurityImage.a(localSecurityImage, paramContext.aoP());
    SecurityImage.c(localSecurityImage).setOnDismissListener(paramOnDismissListener);
    SecurityImage.c(localSecurityImage).show();
    return localSecurityImage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.applet.SecurityImage.a
 * JD-Core Version:    0.7.0.1
 */