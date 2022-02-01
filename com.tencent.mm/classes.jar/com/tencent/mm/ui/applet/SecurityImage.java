package com.tencent.mm.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public class SecurityImage
  extends LinearLayout
{
  private ProgressBar FUt = null;
  private ImageView FUu = null;
  private Button FUv = null;
  private EditText FUw = null;
  private b FUx;
  private d ijc = null;
  private String ijg = null;
  private String ijh = null;
  private int iss = 0;
  
  public SecurityImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt, Bitmap paramBitmap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(141601);
    this.ijg = paramString1;
    this.ijh = paramString2;
    this.iss = paramInt;
    if (paramBitmap != null)
    {
      this.FUu.setImageBitmap(paramBitmap);
      AppMethodBeat.o(141601);
      return;
    }
    ad.e("MicroMsg.SecurityImage", "setSecImg failed, decode failed");
    AppMethodBeat.o(141601);
  }
  
  private void c(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    AppMethodBeat.i(141600);
    this.ijg = paramString1;
    this.ijh = paramString2;
    this.iss = paramInt;
    Bitmap localBitmap = f.cl(paramArrayOfByte);
    if (localBitmap != null)
    {
      ad.i("MicroMsg.SecurityImage", "dkwt setSecImg sid:%s key:%s imgBuf:%d [%d %d]", new Object[] { paramString1, paramString2, Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(localBitmap.getWidth()), Integer.valueOf(localBitmap.getHeight()) });
      a(paramInt, localBitmap, paramString1, paramString2);
      AppMethodBeat.o(141600);
      return;
    }
    if (paramArrayOfByte == null) {}
    for (paramInt = -1;; paramInt = paramArrayOfByte.length)
    {
      ad.e("MicroMsg.SecurityImage", "dkwt setSecImg ERROR sid:%s key:%s imgBuf:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
      AppMethodBeat.o(141600);
      return;
    }
  }
  
  private void vJ(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(141599);
    Object localObject = this.FUu;
    if (paramBoolean)
    {
      i = 255;
      ((ImageView)localObject).setAlpha(i);
      localObject = this.FUu;
      if (!paramBoolean) {
        break label77;
      }
    }
    label77:
    for (int i = 0;; i = -5592406)
    {
      ((ImageView)localObject).setBackgroundColor(i);
      localObject = this.FUt;
      i = j;
      if (paramBoolean) {
        i = 4;
      }
      ((ProgressBar)localObject).setVisibility(i);
      AppMethodBeat.o(141599);
      return;
      i = 40;
      break;
    }
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    AppMethodBeat.i(141595);
    this.FUt = ((ProgressBar)findViewById(2131303931));
    this.FUu = ((ImageView)findViewById(2131296986));
    this.FUv = ((Button)findViewById(2131296984));
    this.FUw = ((EditText)findViewById(2131296985));
    this.FUv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(141591);
        SecurityImage.a(SecurityImage.this);
        if (SecurityImage.b(SecurityImage.this) != null) {
          SecurityImage.b(SecurityImage.this).aIs();
        }
        AppMethodBeat.o(141591);
      }
    });
    b(paramInt, paramArrayOfByte, paramString1, paramString2);
    AppMethodBeat.o(141595);
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    AppMethodBeat.i(141596);
    vJ(true);
    c(paramInt, paramArrayOfByte, paramString1, paramString2);
    AppMethodBeat.o(141596);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(141598);
    if (this.ijc != null)
    {
      this.ijc.dismiss();
      this.ijc = null;
    }
    AppMethodBeat.o(141598);
  }
  
  public int getSecCodeType()
  {
    return this.iss;
  }
  
  public String getSecImgCode()
  {
    AppMethodBeat.i(141597);
    if (this.FUw == null)
    {
      AppMethodBeat.o(141597);
      return "";
    }
    String str = this.FUw.getText().toString().trim();
    AppMethodBeat.o(141597);
    return str;
  }
  
  public String getSecImgEncryptKey()
  {
    return this.ijh;
  }
  
  public String getSecImgSid()
  {
    return this.ijg;
  }
  
  public void setNetworkModel(b paramb)
  {
    AppMethodBeat.i(141594);
    if (this.FUx != null) {
      this.FUx.d(null);
    }
    this.FUx = paramb;
    this.FUx.d(this);
    AppMethodBeat.o(141594);
  }
  
  public static final class a
  {
    public static SecurityImage a(Context paramContext, int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2, final DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener, DialogInterface.OnDismissListener paramOnDismissListener, SecurityImage.b paramb)
    {
      AppMethodBeat.i(141593);
      SecurityImage localSecurityImage = (SecurityImage)View.inflate(paramContext, 2131495333, null);
      localSecurityImage.setNetworkModel(paramb);
      localSecurityImage.a(paramInt, paramArrayOfByte, paramString1, paramString2);
      paramContext = new d.a(paramContext);
      paramContext.aau(2131762387);
      paramContext.aaB(2131755700).b(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(141592);
          paramOnClickListener.onClick(paramAnonymousDialogInterface, paramAnonymousInt);
          AppMethodBeat.o(141592);
        }
      });
      paramContext.e(paramOnCancelListener);
      paramContext.gs(localSecurityImage);
      paramContext.wX(true);
      SecurityImage.a(localSecurityImage, paramContext.fft());
      SecurityImage.c(localSecurityImage).setOnDismissListener(paramOnDismissListener);
      SecurityImage.c(localSecurityImage).show();
      AppMethodBeat.o(141593);
      return localSecurityImage;
    }
  }
  
  public static abstract class b
  {
    protected SecurityImage FUA;
    
    public abstract void aIs();
    
    public final void d(SecurityImage paramSecurityImage)
    {
      this.FUA = paramSecurityImage;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.applet.SecurityImage
 * JD-Core Version:    0.7.0.1
 */