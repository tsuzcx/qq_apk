package com.tencent.mm.ui.applet;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.y;

public class SecurityImage
  extends LinearLayout
{
  private String feA = null;
  private String feB = null;
  private com.tencent.mm.ui.widget.a.c few = null;
  private int fns = 0;
  ProgressBar uSo = null;
  ImageView uSp = null;
  Button uSq = null;
  EditText uSr = null;
  private SecurityImage.b uSs;
  
  public SecurityImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void mY(boolean paramBoolean)
  {
    int j = 0;
    Object localObject = this.uSp;
    if (paramBoolean)
    {
      i = 255;
      ((ImageView)localObject).setAlpha(i);
      localObject = this.uSp;
      if (!paramBoolean) {
        break label67;
      }
    }
    label67:
    for (int i = 0;; i = -5592406)
    {
      ((ImageView)localObject).setBackgroundColor(i);
      localObject = this.uSo;
      i = j;
      if (paramBoolean) {
        i = 4;
      }
      ((ProgressBar)localObject).setVisibility(i);
      return;
      i = 40;
      break;
    }
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    mY(true);
    this.feA = paramString1;
    this.feB = paramString2;
    this.fns = paramInt;
    Bitmap localBitmap = com.tencent.mm.sdk.platformtools.c.bu(paramArrayOfByte);
    if (localBitmap != null)
    {
      y.i("MicroMsg.SecurityImage", "dkwt setSecImg sid:%s key:%s imgBuf:%d [%d %d]", new Object[] { paramString1, paramString2, Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(localBitmap.getWidth()), Integer.valueOf(localBitmap.getHeight()) });
      this.feA = paramString1;
      this.feB = paramString2;
      this.fns = paramInt;
      if (localBitmap != null)
      {
        this.uSp.setImageBitmap(localBitmap);
        return;
      }
      y.e("MicroMsg.SecurityImage", "setSecImg failed, decode failed");
      return;
    }
    if (paramArrayOfByte == null) {}
    for (paramInt = -1;; paramInt = paramArrayOfByte.length)
    {
      y.e("MicroMsg.SecurityImage", "dkwt setSecImg ERROR sid:%s key:%s imgBuf:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
      return;
    }
  }
  
  public final void dismiss()
  {
    if (this.few != null)
    {
      this.few.dismiss();
      this.few = null;
    }
  }
  
  public int getSecCodeType()
  {
    return this.fns;
  }
  
  public String getSecImgCode()
  {
    if (this.uSr == null) {
      return "";
    }
    return this.uSr.getText().toString().trim();
  }
  
  public String getSecImgEncryptKey()
  {
    return this.feB;
  }
  
  public String getSecImgSid()
  {
    return this.feA;
  }
  
  public void setNetworkModel(SecurityImage.b paramb)
  {
    if (this.uSs != null) {
      this.uSs.uSv = null;
    }
    this.uSs = paramb;
    this.uSs.uSv = this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.applet.SecurityImage
 * JD-Core Version:    0.7.0.1
 */