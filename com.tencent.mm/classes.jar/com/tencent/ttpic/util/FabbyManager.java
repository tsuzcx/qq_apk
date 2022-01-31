package com.tencent.ttpic.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.SourcePathUtil;
import com.tencent.youtu.android.segmenter.SegmenterLib;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FabbyManager
{
  private static final String RAPID_MODE = "RPNSegmenter_m5.rapidnetmodel";
  private static final String RAPID_MODE_SMALL = "RPNSegmenter_m6.rapidnetmodel";
  private static final String RAPID_PROTO = "deploy_498.rapidnetproto";
  private static final String RAPID_PROTO_SMALL = "deploy_m6.rapidnetproto";
  public static boolean USE_SMALL_IMAGE = false;
  public static boolean USE_SMALL_MODEL;
  private static FabbyManager instance = null;
  private boolean INIT_SEGMENT_LIB = false;
  private boolean gpuSupportOpenCL;
  public SegmenterLib lib;
  
  static
  {
    USE_SMALL_MODEL = false;
  }
  
  private FabbyManager()
  {
    copyCLFile();
    initSegmentLib();
  }
  
  private void copyCLFile()
  {
    Object localObject = VideoGlobalContext.getContext();
    try
    {
      InputStream localInputStream = ((Context)localObject).getAssets().open("fabbysdk.cl");
      localObject = new FileOutputStream(new File(((Context)localObject).getDir("execdir", 0), "fabbysdk.cl"));
      byte[] arrayOfByte = new byte[65535];
      for (;;)
      {
        int i = localInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        ((OutputStream)localObject).write(arrayOfByte, 0, i);
      }
      localInputStream.close();
      ((OutputStream)localObject).close();
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public static FabbyManager getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new FabbyManager();
      }
      if (!instance.getInitSegmentLib()) {
        instance.initSegmentLib();
      }
      return instance;
    }
    finally {}
  }
  
  public static void init()
  {
    getInstance();
  }
  
  private void initSegmentLib()
  {
    if (!SourcePathUtil.isLoadBgCutSo()) {
      return;
    }
    File localFile2 = VideoGlobalContext.getContext().getFilesDir();
    File localFile1;
    label42:
    Context localContext;
    if (USE_SMALL_MODEL)
    {
      str = "RPNSegmenter_m6.rapidnetmodel";
      localFile1 = new File(localFile2, str);
      if (!USE_SMALL_MODEL) {
        break label163;
      }
      str = "deploy_m6.rapidnetproto";
      localFile2 = new File(localFile2, str);
      localContext = VideoGlobalContext.getContext();
      if (!USE_SMALL_MODEL) {
        break label169;
      }
      str = "RPNSegmenter_m6.rapidnetmodel";
      label66:
      VideoFileUtil.copyAssets(localContext, str, localFile1.getAbsolutePath());
      localContext = VideoGlobalContext.getContext();
      if (!USE_SMALL_MODEL) {
        break label175;
      }
    }
    label163:
    label169:
    label175:
    for (String str = "deploy_m6.rapidnetproto";; str = "deploy_498.rapidnetproto")
    {
      VideoFileUtil.copyAssets(localContext, str, localFile2.getAbsolutePath());
      this.lib = new SegmenterLib(localFile2.getAbsolutePath(), localFile1.getAbsolutePath());
      this.lib.setNativePtr(this.lib.getNativePtr());
      this.gpuSupportOpenCL = this.lib.isGPUSupportOpenCL();
      compileKernel();
      this.INIT_SEGMENT_LIB = true;
      return;
      str = "RPNSegmenter_m5.rapidnetmodel";
      break;
      str = "deploy_498.rapidnetproto";
      break label42;
      str = "RPNSegmenter_m5.rapidnetmodel";
      break label66;
    }
  }
  
  public void clearSegmentBuffer()
  {
    this.lib.clearSegmentBuffer();
  }
  
  public int compileKernel()
  {
    return this.lib.compileKernel();
  }
  
  public int copyBufferToTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.lib.copyBufferToTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public int copyTextureToBuffer(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.lib.copyTextureToBuffer(paramInt1, paramInt2, paramInt3);
  }
  
  public boolean getInitSegmentLib()
  {
    return this.INIT_SEGMENT_LIB;
  }
  
  public boolean isGPUSupportOpenCL()
  {
    boolean bool2 = false;
    boolean bool3 = VideoPrefsUtil.getDefaultPrefs().getBoolean("prefs_key_segment_on_cpu", false);
    boolean bool1 = bool2;
    if (this.gpuSupportOpenCL)
    {
      bool1 = bool2;
      if (!bool3) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public Bitmap segment(Bitmap paramBitmap)
  {
    return this.lib.segment(paramBitmap);
  }
  
  public void segmentOnBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.lib.segmentOnBitmap(paramBitmap1, paramBitmap2, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int segmentOnTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    return this.lib.segmentOnTexture(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramInt5, paramInt6);
  }
  
  public int segmentOnTextureV2(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return this.lib.segmentOnTextureV2(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.util.FabbyManager
 * JD-Core Version:    0.7.0.1
 */