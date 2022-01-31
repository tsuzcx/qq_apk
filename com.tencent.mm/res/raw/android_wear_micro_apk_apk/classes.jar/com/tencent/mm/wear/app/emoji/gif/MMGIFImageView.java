package com.tencent.mm.wear.app.emoji.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.wear.a.c.d;
import java.io.IOException;
import java.io.InputStream;

public class MMGIFImageView
  extends ImageView
{
  private int acB = 2130837533;
  private int acC = 2130837567;
  private boolean acD = true;
  private boolean acE = false;
  private String acF;
  private float acj = 0.0F;
  
  public MMGIFImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MMGIFImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMGIFImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = getResources();
    if ((paramAttributeSet != null) && (paramContext != null))
    {
      paramInt = paramAttributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "src", -1);
      if ((paramInt > 0) && ("drawable".equals(paramContext.getResourceTypeName(paramInt)))) {
        a(paramContext, paramInt, true);
      }
      paramInt = paramAttributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", -1);
      if ((paramInt > 0) && ("drawable".equals(paramContext.getResourceTypeName(paramInt)))) {
        a(paramContext, paramInt, false);
      }
    }
  }
  
  private void a(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    try
    {
      if (!q.D(null)) {
        this.acF = null;
      }
      for (paramResources = c.mD().a(null, paramResources, paramInt); paramBoolean; paramResources = new b(paramResources, paramInt))
      {
        setImageDrawable(paramResources);
        return;
      }
      return;
    }
    catch (IOException paramResources)
    {
      d.a("MicroMsg.GIF.MMGIFImageView", "setMMGIFResource failed. %s", new Object[] { paramResources.toString() });
      if (paramBoolean)
      {
        super.setImageResource(paramInt);
        return;
        setBackgroundDrawable(paramResources);
        return;
      }
      super.setBackgroundResource(paramInt);
    }
  }
  
  private void mC()
  {
    d.c("MicroMsg.GIF.MMGIFImageView", "init", new Object[0]);
    this.acD = true;
    if (this.acD) {
      if (this.acB > 0) {
        super.setImageResource(this.acB);
      }
    }
    while (this.acC <= 0) {
      return;
    }
    super.setImageResource(this.acC);
  }
  
  /* Error */
  public final void G(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: invokestatic 78	com/tencent/mm/sdk/platformtools/q:D	(Ljava/lang/String;)Z
    //   4: ifne +26 -> 30
    //   7: aload_0
    //   8: aconst_null
    //   9: putfield 80	com/tencent/mm/wear/app/emoji/gif/MMGIFImageView:acF	Ljava/lang/String;
    //   12: invokestatic 86	com/tencent/mm/wear/app/emoji/gif/c:mD	()Lcom/tencent/mm/wear/app/emoji/gif/c;
    //   15: aload_0
    //   16: getfield 80	com/tencent/mm/wear/app/emoji/gif/MMGIFImageView:acF	Ljava/lang/String;
    //   19: aload_1
    //   20: invokevirtual 142	com/tencent/mm/wear/app/emoji/gif/c:m	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/wear/app/emoji/gif/b;
    //   23: astore_2
    //   24: aload_0
    //   25: aload_2
    //   26: invokevirtual 93	com/tencent/mm/wear/app/emoji/gif/MMGIFImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   29: return
    //   30: new 95	com/tencent/mm/wear/app/emoji/gif/b
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 144	com/tencent/mm/wear/app/emoji/gif/b:<init>	(Ljava/lang/String;)V
    //   38: astore_2
    //   39: goto -15 -> 24
    //   42: astore 4
    //   44: aload 4
    //   46: invokevirtual 148	com/tencent/mm/wear/app/emoji/gif/MMGIFException:getErrorCode	()I
    //   49: bipush 103
    //   51: if_icmpne +65 -> 116
    //   54: new 150	java/io/FileInputStream
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 151	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   62: astore_2
    //   63: aload_2
    //   64: astore_1
    //   65: aload_2
    //   66: invokestatic 156	com/tencent/mm/wear/a/f/b:a	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   69: astore_3
    //   70: aload_3
    //   71: ifnull +19 -> 90
    //   74: aload_2
    //   75: astore_1
    //   76: aload_3
    //   77: sipush 320
    //   80: invokevirtual 161	android/graphics/Bitmap:setDensity	(I)V
    //   83: aload_2
    //   84: astore_1
    //   85: aload_0
    //   86: aload_3
    //   87: invokevirtual 165	com/tencent/mm/wear/app/emoji/gif/MMGIFImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   90: aload_2
    //   91: invokevirtual 170	java/io/InputStream:close	()V
    //   94: return
    //   95: astore_1
    //   96: return
    //   97: astore_3
    //   98: aconst_null
    //   99: astore_2
    //   100: aload_2
    //   101: astore_1
    //   102: ldc 100
    //   104: aload_3
    //   105: invokestatic 173	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   108: aload_2
    //   109: ifnull +7 -> 116
    //   112: aload_2
    //   113: invokevirtual 170	java/io/InputStream:close	()V
    //   116: ldc 100
    //   118: aload 4
    //   120: invokestatic 173	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   123: ldc 100
    //   125: ldc 175
    //   127: iconst_1
    //   128: anewarray 104	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: aload 4
    //   135: invokevirtual 176	com/tencent/mm/wear/app/emoji/gif/MMGIFException:toString	()Ljava/lang/String;
    //   138: aastore
    //   139: invokestatic 113	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aload_0
    //   143: invokespecial 178	com/tencent/mm/wear/app/emoji/gif/MMGIFImageView:mC	()V
    //   146: return
    //   147: astore_2
    //   148: aconst_null
    //   149: astore_1
    //   150: aload_1
    //   151: ifnull +7 -> 158
    //   154: aload_1
    //   155: invokevirtual 170	java/io/InputStream:close	()V
    //   158: aload_2
    //   159: athrow
    //   160: astore_1
    //   161: ldc 100
    //   163: aload_1
    //   164: invokestatic 173	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   167: goto -25 -> 142
    //   170: astore_1
    //   171: goto -55 -> 116
    //   174: astore_1
    //   175: goto -17 -> 158
    //   178: astore_2
    //   179: goto -29 -> 150
    //   182: astore_3
    //   183: goto -83 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	MMGIFImageView
    //   0	186	1	paramString	String
    //   23	90	2	localObject1	Object
    //   147	12	2	localObject2	Object
    //   178	1	2	localObject3	Object
    //   69	18	3	localBitmap	Bitmap
    //   97	8	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   182	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   42	92	4	localMMGIFException	MMGIFException
    // Exception table:
    //   from	to	target	type
    //   0	24	42	com/tencent/mm/wear/app/emoji/gif/MMGIFException
    //   24	29	42	com/tencent/mm/wear/app/emoji/gif/MMGIFException
    //   30	39	42	com/tencent/mm/wear/app/emoji/gif/MMGIFException
    //   90	94	95	java/io/IOException
    //   44	63	97	java/io/FileNotFoundException
    //   44	63	147	finally
    //   0	24	160	java/lang/Exception
    //   24	29	160	java/lang/Exception
    //   30	39	160	java/lang/Exception
    //   112	116	170	java/io/IOException
    //   154	158	174	java/io/IOException
    //   65	70	178	finally
    //   76	83	178	finally
    //   85	90	178	finally
    //   102	108	178	finally
    //   65	70	182	java/io/FileNotFoundException
    //   76	83	182	java/io/FileNotFoundException
    //   85	90	182	java/io/FileNotFoundException
  }
  
  public final void a(InputStream paramInputStream, String paramString)
  {
    try
    {
      if (!q.D(paramString)) {
        this.acF = paramString;
      }
      for (paramString = c.mD().a(this.acF, paramInputStream);; paramString = new b(paramInputStream))
      {
        setImageDrawable(paramString);
        return;
      }
      return;
    }
    catch (MMGIFException paramString)
    {
      if (paramString.getErrorCode() == 103)
      {
        paramInputStream = com.tencent.mm.wear.a.f.b.a(paramInputStream);
        if (paramInputStream != null)
        {
          paramInputStream.setDensity(320);
          setImageBitmap(paramInputStream);
        }
      }
      else
      {
        d.a("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", new Object[] { paramString.toString() });
        mC();
        return;
      }
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        d.a("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", new Object[] { paramInputStream.toString() });
      }
    }
  }
  
  public final void a(byte[] paramArrayOfByte, String paramString)
  {
    d.c("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray", new Object[0]);
    try
    {
      if (!q.D(paramString)) {
        this.acF = paramString;
      }
      for (paramString = c.mD().c(this.acF, paramArrayOfByte);; paramString = new b(paramArrayOfByte))
      {
        setImageDrawable(paramString);
        return;
      }
      return;
    }
    catch (MMGIFException paramString)
    {
      if (paramString.getErrorCode() == 103)
      {
        paramArrayOfByte = com.tencent.mm.wear.a.f.b.c(paramArrayOfByte, 0, 0);
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.setDensity(320);
          setImageBitmap(paramArrayOfByte);
        }
      }
      else
      {
        d.a("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", new Object[] { paramString.toString() });
        mC();
        return;
      }
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        d.a("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", new Object[] { paramArrayOfByte.toString() });
      }
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    a(getResources(), paramInt, false);
  }
  
  public void setImageResource(int paramInt)
  {
    a(getResources(), paramInt, true);
  }
  
  public final void start()
  {
    if ((getDrawable() != null) && ((getDrawable() instanceof b))) {
      ((b)getDrawable()).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.emoji.gif.MMGIFImageView
 * JD-Core Version:    0.7.0.1
 */