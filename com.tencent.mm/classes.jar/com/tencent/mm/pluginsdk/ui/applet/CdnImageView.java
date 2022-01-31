package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.at.c;
import com.tencent.mm.at.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.f.a;

public class CdnImageView
  extends MMImageView
  implements a
{
  private static final String uxL;
  private int eRu;
  private int eRv;
  private ak handler;
  private String url;
  private String vTd;
  private String vTe;
  private boolean vTf;
  private boolean vTg;
  
  static
  {
    AppMethodBeat.i(79730);
    uxL = com.tencent.mm.compatible.util.e.eQz + "wallet/images/";
    AppMethodBeat.o(79730);
  }
  
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
    AppMethodBeat.i(79718);
    this.url = null;
    this.vTg = false;
    this.handler = new CdnImageView.1(this);
    AppMethodBeat.o(79718);
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(79724);
    this.url = paramString1;
    this.eRu = paramInt1;
    this.eRv = paramInt2;
    this.vTd = paramString2;
    if (!bo.isNullOrNil(this.vTd))
    {
      paramString2 = com.tencent.mm.sdk.platformtools.d.aoV(this.vTd);
      if ((paramString2 != null) && (paramString2.getWidth() > 0) && (paramString2.getHeight() > 0))
      {
        setImageBitmap(paramString2);
        setImageBitmapCompleted(paramString2);
        AppMethodBeat.o(79724);
        return;
      }
    }
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      setVisibility(8);
      AppMethodBeat.o(79724);
      return;
    }
    if (paramString1.startsWith("http"))
    {
      er(paramString1, paramInt3);
      AppMethodBeat.o(79724);
      return;
    }
    aml(paramString1);
    AppMethodBeat.o(79724);
  }
  
  private void aml(String paramString)
  {
    AppMethodBeat.i(79726);
    if (!com.tencent.mm.vfs.e.cN(paramString))
    {
      setVisibility(8);
      AppMethodBeat.o(79726);
      return;
    }
    if ((this.eRu <= 0) || (this.eRv <= 0)) {}
    for (paramString = com.tencent.mm.sdk.platformtools.d.aoV(paramString); paramString == null; paramString = com.tencent.mm.sdk.platformtools.d.d(paramString, this.eRu, this.eRv, true))
    {
      setVisibility(8);
      AppMethodBeat.o(79726);
      return;
    }
    Object localObject = paramString;
    if (this.vTf)
    {
      localObject = paramString;
      if (paramString != null) {
        localObject = com.tencent.mm.sdk.platformtools.d.a(paramString, false, paramString.getWidth() * 0.5F);
      }
    }
    setImageBitmap((Bitmap)localObject);
    setImageBitmapCompleted((Bitmap)localObject);
    AppMethodBeat.o(79726);
  }
  
  private boolean dnw()
  {
    AppMethodBeat.i(79727);
    try
    {
      Object localObject1 = getCacheFilePath();
      ab.d("MicroMsg.CdnImageView", "useSdcardCache, path: %s", new Object[] { localObject1 });
      if (com.tencent.mm.vfs.e.cN((String)localObject1))
      {
        Object localObject2 = com.tencent.mm.sdk.platformtools.d.aoV((String)localObject1);
        ab.d("MicroMsg.CdnImageView", "get bitmap from cache path: %s", new Object[] { localObject2 });
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (this.eRu > 0)
          {
            localObject1 = localObject2;
            if (this.eRv > 0) {
              localObject1 = com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject2, this.eRv, this.eRu, true, false);
            }
          }
          localObject2 = localObject1;
          if (this.vTf)
          {
            localObject2 = localObject1;
            if (localObject1 != null) {
              localObject2 = com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject1, false, ((Bitmap)localObject1).getWidth() * 0.5F);
            }
          }
          setImageBitmap((Bitmap)localObject2);
          setImageBitmapCompleted((Bitmap)localObject2);
          AppMethodBeat.o(79727);
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.CdnImageView", localException, "setBitmapFromLocalCache error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(79727);
    }
    return false;
  }
  
  private void er(String paramString, int paramInt)
  {
    AppMethodBeat.i(79728);
    o.ahB();
    Object localObject = c.lK(paramString);
    if (localObject != null)
    {
      paramString = (String)localObject;
      if (this.eRu > 0)
      {
        paramString = (String)localObject;
        if (this.eRv > 0) {
          paramString = com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject, this.eRu, this.eRv, true, false);
        }
      }
      localObject = paramString;
      if (this.vTf)
      {
        localObject = paramString;
        if (paramString != null) {
          localObject = com.tencent.mm.sdk.platformtools.d.a(paramString, false, paramString.getWidth() * 0.5F);
        }
      }
      setImageBitmap((Bitmap)localObject);
      setImageBitmapCompleted((Bitmap)localObject);
      AppMethodBeat.o(79728);
      return;
    }
    if ((this.vTg) && (dnw()))
    {
      AppMethodBeat.o(79728);
      return;
    }
    if (paramInt > 0) {
      setImageResource(paramInt);
    }
    for (;;)
    {
      com.tencent.mm.sdk.g.d.post(new CdnImageView.a(paramString, this.handler), "CdnImageView_download");
      AppMethodBeat.o(79728);
      return;
      setImageBitmap(null);
    }
  }
  
  private String getCacheFilePath()
  {
    AppMethodBeat.i(79725);
    String str;
    if (!bo.isNullOrNil(this.vTd)) {
      str = this.vTd;
    }
    for (;;)
    {
      AppMethodBeat.o(79725);
      return str;
      if (!bo.isNullOrNil(this.vTe))
      {
        str = this.vTe + g.w(this.url.getBytes());
      }
      else
      {
        com.tencent.mm.vfs.e.um(uxL);
        str = uxL + g.w(this.url.getBytes());
      }
    }
  }
  
  public final void ax(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79721);
    o(paramString, paramInt1, paramInt2, -1);
    AppMethodBeat.o(79721);
  }
  
  public final void eq(String paramString, int paramInt)
  {
    AppMethodBeat.i(79720);
    o(paramString, 0, 0, paramInt);
    AppMethodBeat.o(79720);
  }
  
  public final void hV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79722);
    a(paramString1, -1, 0, 0, paramString2);
    AppMethodBeat.o(79722);
  }
  
  public final void o(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(79723);
    a(paramString, paramInt1, paramInt2, paramInt3, null);
    AppMethodBeat.o(79723);
  }
  
  public void setImageBitmapCompleted(Bitmap paramBitmap) {}
  
  public void setImgSavedDir(String paramString)
  {
    this.vTe = paramString;
  }
  
  public void setImgSavedPath(String paramString)
  {
    this.vTd = paramString;
  }
  
  public void setRoundCorner(boolean paramBoolean)
  {
    this.vTf = paramBoolean;
  }
  
  public void setUrl(String paramString)
  {
    AppMethodBeat.i(79719);
    o(paramString, 0, 0, -1);
    AppMethodBeat.o(79719);
  }
  
  public void setUseSdcardCache(boolean paramBoolean)
  {
    this.vTg = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.CdnImageView
 * JD-Core Version:    0.7.0.1
 */