package com.tencent.tav;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.logger.Logger;

public class ResourceLoadUtil
{
  public static final String TAG;
  private static boolean success;
  
  static
  {
    AppMethodBeat.i(188264);
    TAG = ResourceLoadUtil.class.getSimpleName();
    success = false;
    AppMethodBeat.o(188264);
  }
  
  public static boolean isLoaded()
  {
    return success;
  }
  
  public static boolean loadSoSync(String paramString)
  {
    AppMethodBeat.i(188261);
    if (!success)
    {
      if (TextUtils.isEmpty(paramString))
      {
        success = false;
        Logger.e(TAG, "load so path is empty.");
        bool = success;
        AppMethodBeat.o(188261);
        return bool;
      }
      try
      {
        System.load(paramString);
        success = true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        success = false;
        Logger.e(TAG, "loadSoSync: load soPath = ".concat(String.valueOf(paramString)), localUnsatisfiedLinkError);
      }
      catch (RuntimeException localRuntimeException)
      {
        success = false;
        Logger.e(TAG, "loadSoSync: load soPath = ".concat(String.valueOf(paramString)), localRuntimeException);
      }
      catch (Exception localException)
      {
        success = false;
        Logger.e(TAG, "loadSoSync: load soPath = ".concat(String.valueOf(paramString)), localException);
      }
      finally
      {
        Logger.d(TAG, "load " + paramString + ": " + success);
        bool = success;
        AppMethodBeat.o(188261);
        return bool;
      }
    }
    boolean bool = success;
    AppMethodBeat.o(188261);
    return bool;
  }
  
  public static void setLoaded(boolean paramBoolean)
  {
    success = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.ResourceLoadUtil
 * JD-Core Version:    0.7.0.1
 */