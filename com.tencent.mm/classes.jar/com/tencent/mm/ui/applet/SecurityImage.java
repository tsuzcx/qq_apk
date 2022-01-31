package com.tencent.mm.ui.applet;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.widget.b.c;

public class SecurityImage
  extends LinearLayout
{
  private int gEL = 0;
  private c gwf = null;
  private String gwj = null;
  private String gwk = null;
  private ProgressBar zgP = null;
  private ImageView zgQ = null;
  private Button zgR = null;
  private EditText zgS = null;
  private SecurityImage.b zgT;
  
  public SecurityImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt, Bitmap paramBitmap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(106241);
    this.gwj = paramString1;
    this.gwk = paramString2;
    this.gEL = paramInt;
    if (paramBitmap != null)
    {
      this.zgQ.setImageBitmap(paramBitmap);
      AppMethodBeat.o(106241);
      return;
    }
    ab.e("MicroMsg.SecurityImage", "setSecImg failed, decode failed");
    AppMethodBeat.o(106241);
  }
  
  private void c(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    AppMethodBeat.i(106240);
    this.gwj = paramString1;
    this.gwk = paramString2;
    this.gEL = paramInt;
    Bitmap localBitmap = d.bT(paramArrayOfByte);
    if (localBitmap != null)
    {
      ab.i("MicroMsg.SecurityImage", "dkwt setSecImg sid:%s key:%s imgBuf:%d [%d %d]", new Object[] { paramString1, paramString2, Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(localBitmap.getWidth()), Integer.valueOf(localBitmap.getHeight()) });
      a(paramInt, localBitmap, paramString1, paramString2);
      AppMethodBeat.o(106240);
      return;
    }
    if (paramArrayOfByte == null) {}
    for (paramInt = -1;; paramInt = paramArrayOfByte.length)
    {
      ab.e("MicroMsg.SecurityImage", "dkwt setSecImg ERROR sid:%s key:%s imgBuf:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
      AppMethodBeat.o(106240);
      return;
    }
  }
  
  private void qB(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(106239);
    Object localObject = this.zgQ;
    if (paramBoolean)
    {
      i = 255;
      ((ImageView)localObject).setAlpha(i);
      localObject = this.zgQ;
      if (!paramBoolean) {
        break label77;
      }
    }
    label77:
    for (int i = 0;; i = -5592406)
    {
      ((ImageView)localObject).setBackgroundColor(i);
      localObject = this.zgP;
      i = j;
      if (paramBoolean) {
        i = 4;
      }
      ((ProgressBar)localObject).setVisibility(i);
      AppMethodBeat.o(106239);
      return;
      i = 40;
      break;
    }
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    AppMethodBeat.i(106235);
    this.zgP = ((ProgressBar)findViewById(2131827518));
    this.zgQ = ((ImageView)findViewById(2131827517));
    this.zgR = ((Button)findViewById(2131827519));
    this.zgS = ((EditText)findViewById(2131827520));
    this.zgR.setOnClickListener(new SecurityImage.1(this));
    b(paramInt, paramArrayOfByte, paramString1, paramString2);
    AppMethodBeat.o(106235);
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    AppMethodBeat.i(106236);
    qB(true);
    c(paramInt, paramArrayOfByte, paramString1, paramString2);
    AppMethodBeat.o(106236);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(106238);
    if (this.gwf != null)
    {
      this.gwf.dismiss();
      this.gwf = null;
    }
    AppMethodBeat.o(106238);
  }
  
  public int getSecCodeType()
  {
    return this.gEL;
  }
  
  public String getSecImgCode()
  {
    AppMethodBeat.i(106237);
    if (this.zgS == null)
    {
      AppMethodBeat.o(106237);
      return "";
    }
    String str = this.zgS.getText().toString().trim();
    AppMethodBeat.o(106237);
    return str;
  }
  
  public String getSecImgEncryptKey()
  {
    return this.gwk;
  }
  
  public String getSecImgSid()
  {
    return this.gwj;
  }
  
  public void setNetworkModel(SecurityImage.b paramb)
  {
    AppMethodBeat.i(106234);
    if (this.zgT != null) {
      this.zgT.d(null);
    }
    this.zgT = paramb;
    this.zgT.d(this);
    AppMethodBeat.o(106234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.applet.SecurityImage
 * JD-Core Version:    0.7.0.1
 */