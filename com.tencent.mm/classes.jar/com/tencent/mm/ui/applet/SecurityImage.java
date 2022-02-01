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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public class SecurityImage
  extends LinearLayout
{
  private ProgressBar ONB = null;
  private ImageView ONC = null;
  private Button OND = null;
  private EditText ONE = null;
  private b ONF;
  private d kdo = null;
  private String kds = null;
  private String kdt = null;
  private int kmJ = 0;
  
  public SecurityImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void Bu(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(141599);
    Object localObject = this.ONC;
    if (paramBoolean)
    {
      i = 255;
      ((ImageView)localObject).setAlpha(i);
      localObject = this.ONC;
      if (!paramBoolean) {
        break label77;
      }
    }
    label77:
    for (int i = 0;; i = -5592406)
    {
      ((ImageView)localObject).setBackgroundColor(i);
      localObject = this.ONB;
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
  
  private void a(int paramInt, Bitmap paramBitmap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(141601);
    this.kds = paramString1;
    this.kdt = paramString2;
    this.kmJ = paramInt;
    if (paramBitmap != null)
    {
      this.ONC.setImageBitmap(paramBitmap);
      AppMethodBeat.o(141601);
      return;
    }
    Log.e("MicroMsg.SecurityImage", "setSecImg failed, decode failed");
    AppMethodBeat.o(141601);
  }
  
  private void c(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    AppMethodBeat.i(141600);
    this.kds = paramString1;
    this.kdt = paramString2;
    this.kmJ = paramInt;
    Bitmap localBitmap = BitmapUtil.decodeByteArray(paramArrayOfByte);
    if (localBitmap != null)
    {
      Log.i("MicroMsg.SecurityImage", "dkwt setSecImg sid:%s key:%s imgBuf:%d [%d %d]", new Object[] { paramString1, paramString2, Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(localBitmap.getWidth()), Integer.valueOf(localBitmap.getHeight()) });
      a(paramInt, localBitmap, paramString1, paramString2);
      AppMethodBeat.o(141600);
      return;
    }
    if (paramArrayOfByte == null) {}
    for (paramInt = -1;; paramInt = paramArrayOfByte.length)
    {
      Log.e("MicroMsg.SecurityImage", "dkwt setSecImg ERROR sid:%s key:%s imgBuf:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
      AppMethodBeat.o(141600);
      return;
    }
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    AppMethodBeat.i(141595);
    this.ONB = ((ProgressBar)findViewById(2131306780));
    this.ONC = ((ImageView)findViewById(2131297104));
    this.OND = ((Button)findViewById(2131297102));
    this.ONE = ((EditText)findViewById(2131297103));
    this.OND.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(141591);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/ui/applet/SecurityImage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        SecurityImage.a(SecurityImage.this);
        if (SecurityImage.b(SecurityImage.this) != null) {
          SecurityImage.b(SecurityImage.this).bnH();
        }
        a.a(this, "com/tencent/mm/ui/applet/SecurityImage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(141591);
      }
    });
    b(paramInt, paramArrayOfByte, paramString1, paramString2);
    AppMethodBeat.o(141595);
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    AppMethodBeat.i(141596);
    Bu(true);
    c(paramInt, paramArrayOfByte, paramString1, paramString2);
    AppMethodBeat.o(141596);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(141598);
    if (this.kdo != null)
    {
      this.kdo.dismiss();
      this.kdo = null;
    }
    AppMethodBeat.o(141598);
  }
  
  public int getSecCodeType()
  {
    return this.kmJ;
  }
  
  public String getSecImgCode()
  {
    AppMethodBeat.i(141597);
    if (this.ONE == null)
    {
      AppMethodBeat.o(141597);
      return "";
    }
    String str = this.ONE.getText().toString().trim();
    AppMethodBeat.o(141597);
    return str;
  }
  
  public String getSecImgEncryptKey()
  {
    return this.kdt;
  }
  
  public String getSecImgSid()
  {
    return this.kds;
  }
  
  public void setNetworkModel(b paramb)
  {
    AppMethodBeat.i(141594);
    if (this.ONF != null) {
      this.ONF.d(null);
    }
    this.ONF = paramb;
    this.ONF.d(this);
    AppMethodBeat.o(141594);
  }
  
  public static final class a
  {
    public static SecurityImage a(Context paramContext, int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2, final DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener, DialogInterface.OnDismissListener paramOnDismissListener, SecurityImage.b paramb)
    {
      AppMethodBeat.i(141593);
      SecurityImage localSecurityImage = (SecurityImage)View.inflate(paramContext, 2131496194, null);
      localSecurityImage.setNetworkModel(paramb);
      localSecurityImage.a(paramInt, paramArrayOfByte, paramString1, paramString2);
      paramContext = new d.a(paramContext);
      paramContext.aoO(2131764453);
      paramContext.aoV(2131755771).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(141592);
          paramOnClickListener.onClick(paramAnonymousDialogInterface, paramAnonymousInt);
          AppMethodBeat.o(141592);
        }
      });
      paramContext.f(paramOnCancelListener);
      paramContext.hs(localSecurityImage);
      paramContext.Dk(true);
      SecurityImage.a(localSecurityImage, paramContext.hbn());
      SecurityImage.c(localSecurityImage).setOnDismissListener(paramOnDismissListener);
      SecurityImage.c(localSecurityImage).show();
      AppMethodBeat.o(141593);
      return localSecurityImage;
    }
  }
  
  public static abstract class b
  {
    protected SecurityImage ONI;
    
    public abstract void bnH();
    
    public final void d(SecurityImage paramSecurityImage)
    {
      this.ONI = paramSecurityImage;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.applet.SecurityImage
 * JD-Core Version:    0.7.0.1
 */