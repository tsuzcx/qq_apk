package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class Coffee
{
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(50259);
    TAG = Coffee.class.getSimpleName();
    try
    {
      System.loadLibrary("pitu_tools");
      AppMethodBeat.o(50259);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      LogUtils.e(localUnsatisfiedLinkError);
      AppMethodBeat.o(50259);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      LogUtils.e(localRuntimeException);
      AppMethodBeat.o(50259);
      return;
    }
    catch (Exception localException)
    {
      LogUtils.e(localException);
      AppMethodBeat.o(50259);
    }
  }
  
  public static byte[] drink(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(50257);
    LogUtils.v("Coffee", "drink(), sign = %s", new Object[] { paramString });
    byte[] arrayOfByte = nDrink(paramArrayOfByte, paramArrayOfByte.length, paramString);
    if ((arrayOfByte[0] == 120) && (arrayOfByte[1] == -100))
    {
      paramArrayOfByte = new Inflater();
      paramString = new ByteArrayOutputStream();
      try
      {
        paramArrayOfByte.setInput(arrayOfByte, 0, arrayOfByte.length);
        arrayOfByte = new byte[1024];
        while (!paramArrayOfByte.finished()) {
          paramString.write(arrayOfByte, 0, paramArrayOfByte.inflate(arrayOfByte));
        }
        AppMethodBeat.o(50257);
      }
      catch (DataFormatException localDataFormatException)
      {
        paramArrayOfByte.end();
        for (;;)
        {
          paramArrayOfByte = paramString.toByteArray();
          AppMethodBeat.o(50257);
          return paramArrayOfByte;
          paramArrayOfByte.end();
        }
      }
      finally
      {
        paramArrayOfByte.end();
        AppMethodBeat.o(50257);
      }
    }
    return localDataFormatException;
  }
  
  public static InputStream drinkACupOfCoffee(InputStream paramInputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(50256);
    paramInputStream = IOUtils.toByteArray(paramInputStream);
    if (paramBoolean) {}
    for (paramInputStream = drink_ios(paramInputStream, getDefaultSign());; paramInputStream = drink(paramInputStream, getDefaultSign()))
    {
      paramInputStream = IOUtils.toInputStream(paramInputStream);
      AppMethodBeat.o(50256);
      return paramInputStream;
    }
  }
  
  public static byte[] drink_ios(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(50258);
    LogUtils.v("Coffee", "drink(), sign = %s", new Object[] { paramString });
    byte[] arrayOfByte = nDrinkios(paramArrayOfByte, paramArrayOfByte.length, paramString);
    if ((arrayOfByte[0] == 120) && (arrayOfByte[1] == -100))
    {
      paramArrayOfByte = new Inflater();
      paramString = new ByteArrayOutputStream();
      try
      {
        paramArrayOfByte.setInput(arrayOfByte, 0, arrayOfByte.length);
        arrayOfByte = new byte[1024];
        while (!paramArrayOfByte.finished()) {
          paramString.write(arrayOfByte, 0, paramArrayOfByte.inflate(arrayOfByte));
        }
        AppMethodBeat.o(50258);
      }
      catch (DataFormatException localDataFormatException)
      {
        paramArrayOfByte.end();
        for (;;)
        {
          paramArrayOfByte = paramString.toByteArray();
          AppMethodBeat.o(50258);
          return paramArrayOfByte;
          paramArrayOfByte.end();
        }
      }
      finally
      {
        paramArrayOfByte.end();
        AppMethodBeat.o(50258);
      }
    }
    return localDataFormatException;
  }
  
  public static native String getDefaultSign();
  
  public static native boolean isSign(String paramString);
  
  private static native byte[] nDrink(byte[] paramArrayOfByte, int paramInt, String paramString);
  
  private static native byte[] nDrinkios(byte[] paramArrayOfByte, int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.Coffee
 * JD-Core Version:    0.7.0.1
 */