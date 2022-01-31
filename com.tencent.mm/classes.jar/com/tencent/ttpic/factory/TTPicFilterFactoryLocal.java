package com.tencent.ttpic.factory;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.a.a;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.a.x;
import com.tencent.filter.m.k;
import com.tencent.filter.m.o;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.filter.ChannelSplitFilter;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoDeviceUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.util.e;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;

public class TTPicFilterFactoryLocal
{
  public static String LUT_DIR = "lut";
  private static String LUT_DIR_ROOT = null;
  
  public static void clearLutFiles()
  {
    if (LUT_DIR_ROOT == null)
    {
      File localFile = VideoDeviceUtil.getExternalFilesDir(VideoGlobalContext.getContext(), LUT_DIR);
      if ((localFile != null) && (localFile.exists()) && (localFile.canWrite())) {
        LUT_DIR_ROOT = localFile.getPath();
      }
    }
    if (LUT_DIR_ROOT == null) {
      return;
    }
    VideoFileUtil.delete(new File(LUT_DIR_ROOT));
  }
  
  public static BaseFilter creatFilterById(int paramInt)
  {
    Object localObject;
    if (LUT_DIR_ROOT == null)
    {
      localObject = VideoDeviceUtil.getExternalFilesDir(VideoGlobalContext.getContext(), LUT_DIR);
      if ((localObject != null) && (((File)localObject).exists()) && (((File)localObject).canWrite())) {
        LUT_DIR_ROOT = ((File)localObject).getPath();
      }
    }
    String str;
    switch (paramInt)
    {
    default: 
      str = null;
      localObject = null;
      if (localObject == null) {
        break;
      }
    }
    BaseFilter localBaseFilter;
    do
    {
      return localObject;
      localObject = new x();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/wuxia_lf.png", 33986));
      str = null;
      break;
      localObject = new x();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/ziran_lf.png", 33986));
      str = null;
      break;
      localObject = new x();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/qiangwei_lf.png", 33986));
      str = null;
      break;
      localObject = new x();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/xinye_lf.png", 33986));
      str = null;
      break;
      localObject = new x();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/tangguomeigui_lf.png", 33986));
      str = null;
      break;
      localObject = new x();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/shuilian_lf.png", 33986));
      str = null;
      break;
      localObject = new x();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/youjiali_lf.png", 33986));
      str = null;
      break;
      localObject = new ChannelSplitFilter();
      str = null;
      break;
      str = "MIC_PTU_ZIPAI_LIGHTWHITE";
      localObject = null;
      break;
      str = "MIC_PTU_ZIPAI_LIGHTRED";
      localObject = null;
      break;
      str = "MIC_PTU_ZIPAI_LIGHT";
      localObject = null;
      break;
      str = "MIC_PTU_ZIPAI_TEAMILK";
      localObject = null;
      break;
      localObject = new x();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/fenbi_lf.png", 33986));
      str = null;
      break;
      localObject = new x();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/fennen_lf.png", 33986));
      str = null;
      break;
      localObject = new x();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/tianbohe_lf.png", 33986));
      str = null;
      break;
      str = "MIC_PTU_ZIPAI_GRADIENT_LIPNEW";
      localObject = null;
      break;
      str = "MIC_PTU_ZIPAI_FAIRYTALE";
      localObject = null;
      break;
      str = "MIC_PTU_ZIPAI_RICHRED";
      localObject = null;
      break;
      str = "MIC_PTU_ZIPAI_YOUNG";
      localObject = null;
      break;
      localObject = new x();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/zhahuang_lf.png", 33986));
      str = null;
      break;
      localObject = new x();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/dongjing_lf.png", 33986));
      str = null;
      break;
      localObject = new x();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/chongsheng_lf.png", 33986));
      str = null;
      break;
      str = "MIC_PTU_ZIPAI_MAPLERED";
      localObject = null;
      break;
      str = "MIC_PTU_ZIPAI_RICHBLUE";
      localObject = null;
      break;
      str = "MIC_PTU_ZIPAI_RICHYELLOW";
      localObject = null;
      break;
      str = "MIC_PTU_ZIPAI_BLACKWHITEZIPAI";
      localObject = null;
      break;
      localObject = new x();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/nuanyang_lf.png", 33986));
      str = null;
      break;
      str = "MIC_PTU_FBBS_LANGMAN";
      localObject = null;
      break;
      if (str == null) {
        return a.dY(paramInt);
      }
      localBaseFilter = lutFilterWithID(str);
      localObject = localBaseFilter;
    } while (localBaseFilter != null);
    filter2Image(paramInt, str);
    return a.dY(paramInt);
  }
  
  public static void filter2Image(int paramInt, String paramString)
  {
    if (LUT_DIR_ROOT == null) {
      return;
    }
    com.tencent.view.c localc = com.tencent.view.c.cRn();
    paramString = new TTPicFilterFactoryLocal.1(paramInt, paramString);
    localc.handler.post(paramString);
  }
  
  public static Bitmap getBitmapFromEncryptedFile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        if (paramString.startsWith("assets://"))
        {
          paramString = VideoGlobalContext.getContext().getAssets().open(FileUtils.getRealPath(paramString));
          label32:
          arrayOfByte = com.tencent.util.c.decryptFile(paramString);
        }
      }
      catch (Exception paramString)
      {
        try
        {
          byte[] arrayOfByte;
          e.closeQuietly(paramString);
          label41:
          while (arrayOfByte != null)
          {
            paramString = new BitmapFactory.Options();
            paramString.inPreferredConfig = Bitmap.Config.ARGB_8888;
            try
            {
              paramString = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, paramString);
              return paramString;
            }
            catch (OutOfMemoryError paramString)
            {
              return null;
            }
            paramString = new FileInputStream(paramString);
            break label32;
            paramString = paramString;
            arrayOfByte = null;
          }
        }
        catch (Exception paramString)
        {
          break label41;
        }
      }
    }
  }
  
  public static BaseFilter lutFilterWithBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    x localx = new x();
    localx.addParam(new m.k("inputImageTexture2", paramBitmap, 33986, true));
    return localx;
  }
  
  public static BaseFilter lutFilterWithID(String paramString)
  {
    if (LUT_DIR_ROOT == null) {}
    do
    {
      return null;
      paramString = VideoBitmapUtil.getBitmapFromEncryptedFile(LUT_DIR_ROOT + File.separator + paramString + ".png2");
    } while (paramString == null);
    x localx = new x();
    localx.addParam(new m.k("inputImageTexture2", paramString, 33986, true));
    return localx;
  }
  
  public static Bitmap preloadBaseLUTImage()
  {
    for (;;)
    {
      Object localObject;
      int n;
      int j;
      try
      {
        byte[] arrayOfByte = new byte[1048576];
        localObject = new byte[64];
        i = 0;
        if (i < 64)
        {
          localObject[i] = ((byte)Math.round(i * 4.047619F));
          i += 1;
          continue;
          if (i < 64)
          {
            n = i / 8;
            j = 0;
            break label95;
          }
          localObject = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
          ((Bitmap)localObject).copyPixelsFromBuffer(ByteBuffer.wrap(arrayOfByte));
          return localObject;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        return null;
      }
      int i = 0;
      continue;
      label95:
      while (j < 64)
      {
        int m = i % 8 * 64 * 4 + (n * 64 + j) * 512 * 4;
        int k = 0;
        while (k < 64)
        {
          int i1 = m + 1;
          localOutOfMemoryError[m] = localObject[k];
          m = i1 + 1;
          localOutOfMemoryError[i1] = localObject[j];
          i1 = m + 1;
          localOutOfMemoryError[m] = localObject[i];
          m = i1 + 1;
          localOutOfMemoryError[i1] = -1;
          k += 1;
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  public static void saveLutOrg()
  {
    if (LUT_DIR_ROOT == null) {}
    Bitmap localBitmap;
    do
    {
      return;
      localBitmap = preloadBaseLUTImage();
    } while (localBitmap == null);
    VideoBitmapUtil.saveBitmap2PNG(localBitmap, LUT_DIR_ROOT + File.separator + "LUT_ORG.png");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.factory.TTPicFilterFactoryLocal
 * JD-Core Version:    0.7.0.1
 */