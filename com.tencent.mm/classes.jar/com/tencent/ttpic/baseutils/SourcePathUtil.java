package com.tencent.ttpic.baseutils;

public class SourcePathUtil
{
  private static String mBeautyPath;
  private static String mBgCutCpuPath = null;
  private static String mBgCutGpuPath;
  private static String mFilterSourcePath = null;
  private static boolean mIsLoadBeautySo = false;
  private static boolean mIsLoadBgCutSo = false;
  
  static
  {
    mBeautyPath = null;
    mBgCutGpuPath = null;
  }
  
  public static String getFilterSourcePath()
  {
    return mFilterSourcePath;
  }
  
  public static boolean isHasFilterSource()
  {
    return mFilterSourcePath != null;
  }
  
  public static boolean isLoadBeautySo()
  {
    return (mBeautyPath != null) && (mIsLoadBeautySo);
  }
  
  public static boolean isLoadBgCutSo()
  {
    return ((mBgCutGpuPath != null) || (mBgCutCpuPath != null)) && (mIsLoadBgCutSo);
  }
  
  public static void loadBeautySo()
  {
    try
    {
      System.load(mBeautyPath);
      mIsLoadBeautySo = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      mIsLoadBeautySo = false;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      mIsLoadBeautySo = false;
      return;
    }
    catch (Exception localException)
    {
      mIsLoadBeautySo = false;
    }
  }
  
  public static void loadBgCutSo()
  {
    for (;;)
    {
      try
      {
        System.loadLibrary("YTCommon");
        System.loadLibrary("nnpack");
        System.load(mBgCutGpuPath);
        mIsLoadBgCutSo = true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        LogUtils.e(localUnsatisfiedLinkError);
        mIsLoadBgCutSo = false;
        if (mIsLoadBgCutSo) {
          continue;
        }
        try
        {
          System.load(mBgCutCpuPath);
          mIsLoadBgCutSo = true;
          return;
        }
        catch (Exception localException2)
        {
          mIsLoadBgCutSo = false;
          return;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        LogUtils.e(localRuntimeException);
        mIsLoadBgCutSo = false;
        if (mIsLoadBgCutSo) {
          continue;
        }
        try
        {
          System.load(mBgCutCpuPath);
          mIsLoadBgCutSo = true;
          return;
        }
        catch (Exception localException3)
        {
          mIsLoadBgCutSo = false;
          return;
        }
      }
      catch (Exception localException4)
      {
        LogUtils.e(localException4);
        mIsLoadBgCutSo = false;
        if (mIsLoadBgCutSo) {
          continue;
        }
        try
        {
          System.load(mBgCutCpuPath);
          mIsLoadBgCutSo = true;
          return;
        }
        catch (Exception localException5)
        {
          mIsLoadBgCutSo = false;
          return;
        }
      }
      finally
      {
        if (mIsLoadBgCutSo) {
          break label156;
        }
      }
      try
      {
        System.load(mBgCutCpuPath);
        mIsLoadBgCutSo = true;
        return;
      }
      catch (Exception localException1)
      {
        mIsLoadBgCutSo = false;
        return;
      }
    }
    try
    {
      System.load(mBgCutCpuPath);
      mIsLoadBgCutSo = true;
      label156:
      throw localObject;
    }
    catch (Exception localException6)
    {
      for (;;)
      {
        mIsLoadBgCutSo = false;
      }
    }
  }
  
  public static void setBeautySoPath(String paramString)
  {
    mBeautyPath = paramString;
  }
  
  public static void setBgCutCpuSoPath(String paramString)
  {
    mBgCutCpuPath = paramString;
  }
  
  public static void setBgCutGpuSoPath(String paramString)
  {
    mBgCutGpuPath = paramString;
  }
  
  public static void setFilterSourcePath(String paramString)
  {
    mFilterSourcePath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.SourcePathUtil
 * JD-Core Version:    0.7.0.1
 */