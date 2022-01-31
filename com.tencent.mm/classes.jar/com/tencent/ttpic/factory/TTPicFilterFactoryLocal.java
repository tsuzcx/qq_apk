package com.tencent.ttpic.factory;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.a.a;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.a.ab;
import com.tencent.filter.m.k;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.filter.ChannelSplitFilter;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.util.e;
import com.tencent.util.g;
import com.tencent.view.c;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;

public class TTPicFilterFactoryLocal
{
  public static String LUT_DIR_ROOT;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(81933);
    TAG = TTPicFilterFactoryLocal.class.getSimpleName();
    LUT_DIR_ROOT = null;
    AppMethodBeat.o(81933);
  }
  
  public static void clearLutFiles()
  {
    AppMethodBeat.i(81931);
    if (LUT_DIR_ROOT == null)
    {
      AppMethodBeat.o(81931);
      return;
    }
    FileUtils.delete(new File(LUT_DIR_ROOT));
    AppMethodBeat.o(81931);
  }
  
  public static BaseFilter creatFilterById(int paramInt)
  {
    AppMethodBeat.i(81930);
    if (LUT_DIR_ROOT == null)
    {
      AppMethodBeat.o(81930);
      return null;
    }
    String str;
    switch (paramInt)
    {
    default: 
      str = null;
      localObject = null;
    }
    while (localObject != null)
    {
      AppMethodBeat.o(81930);
      return localObject;
      localObject = new ab();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/wuxia_lf.png", 33986));
      str = null;
      continue;
      localObject = new ab();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/ziran_lf.png", 33986));
      str = null;
      continue;
      localObject = new ab();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/qiangwei_lf.png", 33986));
      str = null;
      continue;
      localObject = new ab();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/xinye_lf.png", 33986));
      str = null;
      continue;
      localObject = new ab();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/tangguomeigui_lf.png", 33986));
      str = null;
      continue;
      localObject = new ab();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/shuilian_lf.png", 33986));
      str = null;
      continue;
      localObject = new ab();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/youjiali_lf.png", 33986));
      str = null;
      continue;
      localObject = new ChannelSplitFilter();
      str = null;
      continue;
      str = "MIC_PTU_ZIPAI_LIGHTWHITE";
      localObject = null;
      continue;
      str = "MIC_PTU_ZIPAI_LIGHTRED";
      localObject = null;
      continue;
      str = "MIC_PTU_ZIPAI_LIGHT";
      localObject = null;
      continue;
      str = "MIC_PTU_ZIPAI_TEAMILK";
      localObject = null;
      continue;
      localObject = new ab();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/fenbi_lf.png", 33986));
      str = null;
      continue;
      localObject = new ab();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/fennen_lf.png", 33986));
      str = null;
      continue;
      localObject = new ab();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/tianbohe_lf.png", 33986));
      str = null;
      continue;
      str = "MIC_PTU_ZIPAI_GRADIENT_LIPNEW";
      localObject = null;
      continue;
      str = "MIC_PTU_ZIPAI_FAIRYTALE";
      localObject = null;
      continue;
      str = "MIC_PTU_ZIPAI_RICHRED";
      localObject = null;
      continue;
      str = "MIC_PTU_ZIPAI_YOUNG";
      localObject = null;
      continue;
      localObject = new ab();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/zhahuang_lf.png", 33986));
      str = null;
      continue;
      localObject = new ab();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/dongjing_lf.png", 33986));
      str = null;
      continue;
      localObject = new ab();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/chongsheng_lf.png", 33986));
      str = null;
      continue;
      str = "MIC_PTU_ZIPAI_MAPLERED";
      localObject = null;
      continue;
      str = "MIC_PTU_ZIPAI_RICHBLUE";
      localObject = null;
      continue;
      str = "MIC_PTU_ZIPAI_RICHYELLOW";
      localObject = null;
      continue;
      str = "MIC_PTU_ZIPAI_BLACKWHITEZIPAI";
      localObject = null;
      continue;
      localObject = new ab();
      ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/nuanyang_lf.png", 33986));
      str = null;
      continue;
      str = "MIC_PTU_FBBS_LANGMAN";
      localObject = null;
    }
    if (str == null)
    {
      localObject = a.createFilter(paramInt);
      AppMethodBeat.o(81930);
      return localObject;
    }
    Object localObject = lutFilterWithID(str);
    if (localObject == null)
    {
      filter2Image(paramInt, str);
      localObject = a.createFilter(paramInt);
      AppMethodBeat.o(81930);
      return localObject;
    }
    AppMethodBeat.o(81930);
    return localObject;
  }
  
  public static void filter2Image(int paramInt, String paramString)
  {
    AppMethodBeat.i(81929);
    if (LUT_DIR_ROOT == null)
    {
      AppMethodBeat.o(81929);
      return;
    }
    c.dXd().queue(new TTPicFilterFactoryLocal.1(paramInt, paramString));
    AppMethodBeat.o(81929);
  }
  
  public static Bitmap getBitmapFromEncryptedFile(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(81932);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(81932);
      return null;
    }
    try
    {
      if (paramString.startsWith("assets://"))
      {
        paramString = VideoGlobalContext.getContext().getAssets().open(FileUtils.getRealPath(paramString));
        arrayOfByte = e.L(paramString);
      }
    }
    catch (Exception paramString)
    {
      try
      {
        byte[] arrayOfByte;
        g.closeQuietly(paramString);
        for (;;)
        {
          label53:
          if (arrayOfByte == null)
          {
            AppMethodBeat.o(81932);
            return null;
            paramString = new FileInputStream(paramString);
            break;
          }
          paramString = new BitmapFactory.Options();
          paramString.inPreferredConfig = Bitmap.Config.ARGB_8888;
          try
          {
            paramString = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, paramString);
            AppMethodBeat.o(81932);
            return paramString;
          }
          catch (OutOfMemoryError paramString)
          {
            for (;;)
            {
              paramString = localObject;
            }
          }
          paramString = paramString;
          arrayOfByte = null;
        }
      }
      catch (Exception paramString)
      {
        break label53;
      }
    }
  }
  
  public static BaseFilter lutFilterWithBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(81927);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(81927);
      return null;
    }
    ab localab = new ab();
    localab.addParam(new m.k("inputImageTexture2", paramBitmap, 33986, true));
    AppMethodBeat.o(81927);
    return localab;
  }
  
  public static BaseFilter lutFilterWithID(String paramString)
  {
    AppMethodBeat.i(81928);
    if (LUT_DIR_ROOT == null)
    {
      AppMethodBeat.o(81928);
      return null;
    }
    paramString = getBitmapFromEncryptedFile(LUT_DIR_ROOT + File.separator + paramString + ".png2");
    if (paramString == null)
    {
      AppMethodBeat.o(81928);
      return null;
    }
    ab localab = new ab();
    localab.addParam(new m.k("inputImageTexture2", paramString, 33986, true));
    AppMethodBeat.o(81928);
    return localab;
  }
  
  public static Bitmap preloadBaseLUTImage()
  {
    AppMethodBeat.i(81926);
    try
    {
      arrayOfByte = new byte[1048576];
      localObject1 = new byte[64];
      i = 0;
      while (i < 64)
      {
        localObject1[i] = ((byte)Math.round(i * 4.047619F));
        i += 1;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        Object localObject1;
        int n;
        int j;
        Object localObject2 = null;
        continue;
        int i = 0;
        continue;
        while (j < 64)
        {
          int m = i % 8 * 64 * 4 + (n * 64 + j) * 512 * 4;
          int k = 0;
          while (k < 64)
          {
            int i1 = m + 1;
            arrayOfByte[m] = localObject2[k];
            m = i1 + 1;
            arrayOfByte[i1] = localObject2[j];
            i1 = m + 1;
            arrayOfByte[m] = localObject2[i];
            m = i1 + 1;
            arrayOfByte[i1] = -1;
            k += 1;
          }
          j += 1;
        }
        i += 1;
      }
    }
    if (i < 64)
    {
      n = i / 8;
      j = 0;
    }
    else
    {
      localObject1 = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
      ((Bitmap)localObject1).copyPixelsFromBuffer(ByteBuffer.wrap(arrayOfByte));
      AppMethodBeat.o(81926);
      return localObject1;
    }
  }
  
  public static void saveLutOrg()
  {
    AppMethodBeat.i(81925);
    if (LUT_DIR_ROOT == null)
    {
      AppMethodBeat.o(81925);
      return;
    }
    Bitmap localBitmap = preloadBaseLUTImage();
    if (localBitmap == null)
    {
      AppMethodBeat.o(81925);
      return;
    }
    BitmapUtils.saveBitmap2PNG(localBitmap, LUT_DIR_ROOT + File.separator + "LUT_ORG.png");
    AppMethodBeat.o(81925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.factory.TTPicFilterFactoryLocal
 * JD-Core Version:    0.7.0.1
 */