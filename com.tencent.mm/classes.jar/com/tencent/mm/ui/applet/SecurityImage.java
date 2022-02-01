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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public class SecurityImage
  extends LinearLayout
{
  private ProgressBar JhY = null;
  private ImageView JhZ = null;
  private Button Jia = null;
  private EditText Jib = null;
  private b Jic;
  private d jcs = null;
  private String jcw = null;
  private String jcx = null;
  private int jlF = 0;
  
  public SecurityImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt, Bitmap paramBitmap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(141601);
    this.jcw = paramString1;
    this.jcx = paramString2;
    this.jlF = paramInt;
    if (paramBitmap != null)
    {
      this.JhZ.setImageBitmap(paramBitmap);
      AppMethodBeat.o(141601);
      return;
    }
    ad.e("MicroMsg.SecurityImage", "setSecImg failed, decode failed");
    AppMethodBeat.o(141601);
  }
  
  private void c(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    AppMethodBeat.i(141600);
    this.jcw = paramString1;
    this.jcx = paramString2;
    this.jlF = paramInt;
    Bitmap localBitmap = g.cr(paramArrayOfByte);
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
  
  private void xy(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(141599);
    Object localObject = this.JhZ;
    if (paramBoolean)
    {
      i = 255;
      ((ImageView)localObject).setAlpha(i);
      localObject = this.JhZ;
      if (!paramBoolean) {
        break label77;
      }
    }
    label77:
    for (int i = 0;; i = -5592406)
    {
      ((ImageView)localObject).setBackgroundColor(i);
      localObject = this.JhY;
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
    this.JhY = ((ProgressBar)findViewById(2131303931));
    this.JhZ = ((ImageView)findViewById(2131296986));
    this.Jia = ((Button)findViewById(2131296984));
    this.Jib = ((EditText)findViewById(2131296985));
    this.Jia.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(141591);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/applet/SecurityImage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        SecurityImage.a(SecurityImage.this);
        if (SecurityImage.b(SecurityImage.this) != null) {
          SecurityImage.b(SecurityImage.this).aSv();
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
    xy(true);
    c(paramInt, paramArrayOfByte, paramString1, paramString2);
    AppMethodBeat.o(141596);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(141598);
    if (this.jcs != null)
    {
      this.jcs.dismiss();
      this.jcs = null;
    }
    AppMethodBeat.o(141598);
  }
  
  public int getSecCodeType()
  {
    return this.jlF;
  }
  
  public String getSecImgCode()
  {
    AppMethodBeat.i(141597);
    if (this.Jib == null)
    {
      AppMethodBeat.o(141597);
      return "";
    }
    String str = this.Jib.getText().toString().trim();
    AppMethodBeat.o(141597);
    return str;
  }
  
  public String getSecImgEncryptKey()
  {
    return this.jcx;
  }
  
  public String getSecImgSid()
  {
    return this.jcw;
  }
  
  public void setNetworkModel(b paramb)
  {
    AppMethodBeat.i(141594);
    if (this.Jic != null) {
      this.Jic.d(null);
    }
    this.Jic = paramb;
    this.Jic.d(this);
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
      paramContext.afe(2131762387);
      paramContext.afl(2131755700).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(141592);
          paramOnClickListener.onClick(paramAnonymousDialogInterface, paramAnonymousInt);
          AppMethodBeat.o(141592);
        }
      });
      paramContext.e(paramOnCancelListener);
      paramContext.gY(localSecurityImage);
      paramContext.yR(true);
      SecurityImage.a(localSecurityImage, paramContext.fMb());
      SecurityImage.c(localSecurityImage).setOnDismissListener(paramOnDismissListener);
      SecurityImage.c(localSecurityImage).show();
      AppMethodBeat.o(141593);
      return localSecurityImage;
    }
  }
  
  public static abstract class b
  {
    protected SecurityImage Jif;
    
    public abstract void aSv();
    
    public final void d(SecurityImage paramSecurityImage)
    {
      this.Jif = paramSecurityImage;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.applet.SecurityImage
 * JD-Core Version:    0.7.0.1
 */