package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.mm.a.g;
import com.tencent.mm.as.o;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.e.a;

public class CdnImageView
  extends MMImageView
  implements a
{
  private static final String qJd = com.tencent.mm.compatible.util.e.bkH + "wallet/images/";
  private int eIB;
  private int eIC;
  private ah handler = new CdnImageView.1(this);
  private String sbV;
  private boolean sbW;
  private boolean sbX = false;
  private String url = null;
  
  public CdnImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CdnImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CdnImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void b(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    this.url = paramString1;
    this.eIB = paramInt1;
    this.eIC = paramInt2;
    this.sbV = paramString2;
    if (!bk.bl(this.sbV))
    {
      paramString2 = com.tencent.mm.sdk.platformtools.c.YW(this.sbV);
      if ((paramString2 != null) && (paramString2.getWidth() > 0) && (paramString2.getHeight() > 0))
      {
        setImageBitmap(paramString2);
        setImageBitmapCompleted(paramString2);
      }
    }
    do
    {
      return;
      if ((paramString1 == null) || (paramString1.length() == 0))
      {
        setVisibility(8);
        return;
      }
      if (!paramString1.startsWith("http")) {
        break;
      }
      o.OI();
      paramString2 = com.tencent.mm.as.c.jK(paramString1);
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (this.eIB > 0)
        {
          paramString1 = paramString2;
          if (this.eIC > 0) {
            paramString1 = com.tencent.mm.sdk.platformtools.c.a(paramString2, this.eIB, this.eIC, true, false);
          }
        }
        paramString2 = paramString1;
        if (this.sbW)
        {
          paramString2 = paramString1;
          if (paramString1 != null) {
            paramString2 = com.tencent.mm.sdk.platformtools.c.a(paramString1, false, paramString1.getWidth() * 0.5F);
          }
        }
        setImageBitmap(paramString2);
        setImageBitmapCompleted(paramString2);
        return;
      }
    } while ((this.sbX) && (cmG()));
    if (paramInt3 > 0) {
      setImageResource(paramInt3);
    }
    for (;;)
    {
      com.tencent.mm.sdk.f.e.post(new CdnImageView.a(paramString1, this.handler), "CdnImageView_download");
      return;
      setImageBitmap(null);
    }
    if (!com.tencent.mm.vfs.e.bK(paramString1))
    {
      setVisibility(8);
      return;
    }
    if ((this.eIB <= 0) || (this.eIC <= 0)) {}
    for (paramString1 = com.tencent.mm.sdk.platformtools.c.YW(paramString1); paramString1 == null; paramString1 = com.tencent.mm.sdk.platformtools.c.e(paramString1, this.eIB, this.eIC, true))
    {
      setVisibility(8);
      return;
    }
    paramString2 = paramString1;
    if (this.sbW)
    {
      paramString2 = paramString1;
      if (paramString1 != null) {
        paramString2 = com.tencent.mm.sdk.platformtools.c.a(paramString1, false, paramString1.getWidth() * 0.5F);
      }
    }
    setImageBitmap(paramString2);
    setImageBitmapCompleted(paramString2);
  }
  
  private boolean cmG()
  {
    try
    {
      Object localObject1 = getCacheFilePath();
      y.d("MicroMsg.CdnImageView", "useSdcardCache, path: %s", new Object[] { localObject1 });
      if (com.tencent.mm.vfs.e.bK((String)localObject1))
      {
        Object localObject2 = com.tencent.mm.sdk.platformtools.c.YW((String)localObject1);
        y.d("MicroMsg.CdnImageView", "get bitmap from cache path: %s", new Object[] { localObject2 });
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (this.eIB > 0)
          {
            localObject1 = localObject2;
            if (this.eIC > 0) {
              localObject1 = com.tencent.mm.sdk.platformtools.c.a((Bitmap)localObject2, this.eIC, this.eIB, true, false);
            }
          }
          localObject2 = localObject1;
          if (this.sbW)
          {
            localObject2 = localObject1;
            if (localObject1 != null) {
              localObject2 = com.tencent.mm.sdk.platformtools.c.a((Bitmap)localObject1, false, ((Bitmap)localObject1).getWidth() * 0.5F);
            }
          }
          setImageBitmap((Bitmap)localObject2);
          setImageBitmapCompleted((Bitmap)localObject2);
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.CdnImageView", localException, "setBitmapFromLocalCache error: %s", new Object[] { localException.getMessage() });
    }
    return false;
  }
  
  private String getCacheFilePath()
  {
    if (!bk.bl(this.sbV)) {
      return this.sbV;
    }
    com.tencent.mm.vfs.e.nb(qJd);
    return qJd + g.o(this.url.getBytes());
  }
  
  public final void ah(String paramString, int paramInt1, int paramInt2)
  {
    j(paramString, paramInt1, paramInt2, -1);
  }
  
  public final void dl(String paramString, int paramInt)
  {
    j(paramString, 0, 0, paramInt);
  }
  
  public final void fT(String paramString1, String paramString2)
  {
    b(paramString1, -1, 0, 0, paramString2);
  }
  
  public final void j(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramString, paramInt1, paramInt2, paramInt3, null);
  }
  
  public void setImageBitmapCompleted(Bitmap paramBitmap) {}
  
  public void setImgSavedPath(String paramString)
  {
    this.sbV = paramString;
  }
  
  public void setRoundCorner(boolean paramBoolean)
  {
    this.sbW = paramBoolean;
  }
  
  public void setUrl(String paramString)
  {
    j(paramString, 0, 0, -1);
  }
  
  public void setUseSdcardCache(boolean paramBoolean)
  {
    this.sbX = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.CdnImageView
 * JD-Core Version:    0.7.0.1
 */