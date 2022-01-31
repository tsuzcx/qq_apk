package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.bc;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lr
  implements lt
{
  private ni a;
  private ls b;
  private lp c;
  private volatile ExecutorService d;
  
  public lr(Context paramContext)
  {
    AppMethodBeat.i(149210);
    this.d = null;
    this.a = ni.a(paramContext);
    this.b = new ls(a(paramContext));
    this.c = new lp();
    this.d = Executors.newSingleThreadExecutor();
    AppMethodBeat.o(149210);
  }
  
  private int a(Context paramContext)
  {
    AppMethodBeat.i(149219);
    int j = paramContext.getResources().getDisplayMetrics().heightPixels;
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    j = (int)(j * 1.0D / 256.0D + 0.5D);
    i = (int)(i * 1.0D / 256.0D + 0.5D);
    AppMethodBeat.o(149219);
    return j * 262144 * i * 3;
  }
  
  private Bitmap a(bc parambc)
  {
    AppMethodBeat.i(149215);
    if (parambc == null)
    {
      AppMethodBeat.o(149215);
      return null;
    }
    BitmapFactory.Options localOptions = c();
    Bitmap localBitmap = this.b.a();
    if (localBitmap != null) {
      localOptions.inBitmap = localBitmap;
    }
    parambc.a(localOptions);
    parambc = this.a.a(parambc);
    AppMethodBeat.o(149215);
    return parambc;
  }
  
  private void a(bc parambc, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149216);
    parambc = this.c.a(parambc.a(), parambc.b(), parambc.c());
    if (parambc == null)
    {
      AppMethodBeat.o(149216);
      return;
    }
    parambc = parambc.getBytes();
    Arrays.fill(paramArrayOfByte, (byte)0);
    System.arraycopy(parambc, 0, paramArrayOfByte, 0, parambc.length);
    AppMethodBeat.o(149216);
  }
  
  private boolean a(String paramString)
  {
    AppMethodBeat.i(149218);
    if ((paramString != null) && (paramString.length() > 0))
    {
      paramString = Pattern.compile("version=\\d+").matcher(paramString);
      if (paramString.find())
      {
        paramString = paramString.group();
        if (Integer.parseInt(paramString.substring(paramString.indexOf("=") + 1)) == lm.a())
        {
          AppMethodBeat.o(149218);
          return true;
        }
        AppMethodBeat.o(149218);
        return false;
      }
    }
    AppMethodBeat.o(149218);
    return false;
  }
  
  private BitmapFactory.Options c()
  {
    AppMethodBeat.i(149217);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    localOptions.inSampleSize = 1;
    localOptions.outWidth = 256;
    localOptions.outHeight = 256;
    localOptions.inMutable = true;
    AppMethodBeat.o(149217);
    return localOptions;
  }
  
  public Bitmap a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149211);
    bc localbc = new bc(paramInt1, paramInt2, paramInt3, 1);
    Object localObject = this.b.a(localbc.toString());
    if (localObject != null)
    {
      AppMethodBeat.o(149211);
      return localObject;
    }
    localObject = c();
    Bitmap localBitmap = this.b.a();
    if (localBitmap != null) {
      ((BitmapFactory.Options)localObject).inBitmap = localBitmap;
    }
    localbc.a((BitmapFactory.Options)localObject);
    localObject = a(localbc);
    if (localObject != null)
    {
      this.b.a(localbc.toString(), (Bitmap)localObject);
      AppMethodBeat.o(149211);
      return localObject;
    }
    a(localbc, paramArrayOfByte);
    AppMethodBeat.o(149211);
    return null;
  }
  
  public void a()
  {
    AppMethodBeat.i(149213);
    this.b.b();
    this.a.a(1);
    AppMethodBeat.o(149213);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149212);
    bc localbc = new bc(paramInt1, paramInt2, paramInt3, 1);
    if (!a(paramString))
    {
      AppMethodBeat.o(149212);
      return;
    }
    Object localObject = c();
    Bitmap localBitmap = this.b.a();
    if (localBitmap != null) {
      ((BitmapFactory.Options)localObject).inBitmap = localBitmap;
    }
    localObject = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject);
    if (localObject != null)
    {
      this.b.a(localbc.toString(), (Bitmap)localObject);
      this.d.execute(new lr.1(this, paramString, paramArrayOfByte, localbc));
    }
    AppMethodBeat.o(149212);
  }
  
  public void b()
  {
    AppMethodBeat.i(149214);
    this.b.c();
    AppMethodBeat.o(149214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.lr
 * JD-Core Version:    0.7.0.1
 */