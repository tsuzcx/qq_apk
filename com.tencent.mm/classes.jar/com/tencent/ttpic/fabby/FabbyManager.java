package com.tencent.ttpic.fabby;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.manager.FeatureManager;
import com.tencent.ttpic.util.ResourcePathMapper;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoPrefsUtil;
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
  private static final String RAPID_PROTO = "deploy_m5_512_512_bin.rapidnetproto";
  private static final String RAPID_PROTO_SMALL = "deploy_m6.rapidnetproto";
  public static boolean USE_SMALL_IMAGE = false;
  public static boolean USE_SMALL_MODEL;
  private static FabbyManager instance = null;
  public static boolean sChooseGPU_Segment = false;
  private boolean INIT_SEGMENT_LIB;
  private boolean gpuSupportOpenCL;
  public SegmenterLib lib;
  private boolean mIsModelCopySuccess;
  private boolean mIsProtoCopySuccess;
  private int mModelCopyType;
  private String mModelPath;
  private String mProtoPath;
  
  static
  {
    USE_SMALL_MODEL = false;
  }
  
  private FabbyManager()
  {
    AppMethodBeat.i(81862);
    this.mModelPath = "";
    this.mProtoPath = "";
    this.mIsProtoCopySuccess = true;
    this.mIsModelCopySuccess = true;
    this.mModelCopyType = 0;
    this.INIT_SEGMENT_LIB = false;
    copyCLFile();
    initSegmentLib();
    AppMethodBeat.o(81862);
  }
  
  private void copyCLFile()
  {
    AppMethodBeat.i(81866);
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
      localIOException.close();
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(81866);
      return;
    }
    ((OutputStream)localObject).close();
    AppMethodBeat.o(81866);
  }
  
  public static FabbyManager getInstance()
  {
    AppMethodBeat.i(81864);
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new FabbyManager();
      }
      if (!instance.getInitSegmentLib()) {
        instance.initSegmentLib();
      }
      FabbyManager localFabbyManager = instance;
      AppMethodBeat.o(81864);
      return localFabbyManager;
    }
    finally
    {
      AppMethodBeat.o(81864);
    }
  }
  
  public static void init()
  {
    AppMethodBeat.i(81863);
    getInstance();
    AppMethodBeat.o(81863);
  }
  
  private void initSegmentLib()
  {
    AppMethodBeat.i(81865);
    if (!FeatureManager.isSegmentationReady())
    {
      AppMethodBeat.o(81865);
      return;
    }
    File localFile2 = VideoGlobalContext.getContext().getFilesDir();
    File localFile1;
    label52:
    label71:
    Object localObject;
    if (USE_SMALL_MODEL)
    {
      str = "RPNSegmenter_m6.rapidnetmodel";
      localFile1 = new File(localFile2, str);
      if (!USE_SMALL_MODEL) {
        break label246;
      }
      str = "deploy_m6.rapidnetproto";
      localFile2 = new File(localFile2, str);
      if (!USE_SMALL_MODEL) {
        break label252;
      }
      str = "RPNSegmenter_m6.rapidnetmodel";
      str = ResourcePathMapper.getModelResPath(str);
      if ((str == null) || (str.startsWith("assets://"))) {
        break label264;
      }
      localObject = new StringBuilder().append(str);
      if (!USE_SMALL_MODEL) {
        break label258;
      }
      str = "RPNSegmenter_m6.rapidnetmodel";
      label111:
      this.mIsModelCopySuccess = FileUtils.copyFile(str, localFile1.getAbsolutePath());
      this.mModelCopyType = 2;
      localObject = VideoGlobalContext.getContext();
      if (!USE_SMALL_MODEL) {
        break label306;
      }
    }
    label258:
    label264:
    label306:
    for (String str = "deploy_m6.rapidnetproto";; str = "deploy_m5_512_512_bin.rapidnetproto")
    {
      this.mIsProtoCopySuccess = FileUtils.copyAssets((Context)localObject, str, localFile2.getAbsolutePath());
      this.mModelPath = localFile1.getAbsolutePath();
      this.mProtoPath = localFile2.getAbsolutePath();
      this.lib = new SegmenterLib(localFile2.getAbsolutePath(), localFile1.getAbsolutePath());
      this.lib.setNativePtr(this.lib.getNativePtr());
      this.gpuSupportOpenCL = this.lib.isGPUSupportOpenCL();
      compileKernel();
      this.INIT_SEGMENT_LIB = true;
      AppMethodBeat.o(81865);
      return;
      str = "RPNSegmenter_m5.rapidnetmodel";
      break;
      label246:
      str = "deploy_m5_512_512_bin.rapidnetproto";
      break label52;
      label252:
      str = "RPNSegmenter_m5.rapidnetmodel";
      break label71;
      str = "RPNSegmenter_m5.rapidnetmodel";
      break label111;
      localObject = VideoGlobalContext.getContext();
      if (USE_SMALL_MODEL) {}
      for (str = "RPNSegmenter_m6.rapidnetmodel";; str = "RPNSegmenter_m5.rapidnetmodel")
      {
        this.mIsModelCopySuccess = FileUtils.copyAssets((Context)localObject, str, localFile1.getAbsolutePath());
        this.mModelCopyType = 1;
        break;
      }
    }
  }
  
  public boolean IsInitSuccess()
  {
    AppMethodBeat.i(81876);
    if (this.lib != null)
    {
      boolean bool = this.lib.isInitSuccess();
      AppMethodBeat.o(81876);
      return bool;
    }
    AppMethodBeat.o(81876);
    return false;
  }
  
  public void clearSegmentBuffer()
  {
    AppMethodBeat.i(81875);
    if (this.lib != null) {
      this.lib.clearSegmentBuffer();
    }
    AppMethodBeat.o(81875);
  }
  
  public int compileKernel()
  {
    AppMethodBeat.i(81867);
    int i = this.lib.compileKernel();
    AppMethodBeat.o(81867);
    return i;
  }
  
  public int copyBufferToTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(81874);
    paramInt1 = this.lib.copyBufferToTexture(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(81874);
    return paramInt1;
  }
  
  public int copyTextureToBuffer(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(81872);
    paramInt1 = this.lib.copyTextureToBuffer(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(81872);
    return paramInt1;
  }
  
  public int getErrorCode()
  {
    AppMethodBeat.i(81877);
    if (this.lib != null)
    {
      int i = this.lib.getErrorCode();
      AppMethodBeat.o(81877);
      return i;
    }
    AppMethodBeat.o(81877);
    return 0;
  }
  
  public int getErrorType()
  {
    AppMethodBeat.i(81878);
    if (this.lib != null)
    {
      int i = this.lib.getErrorType();
      AppMethodBeat.o(81878);
      return i;
    }
    AppMethodBeat.o(81878);
    return 0;
  }
  
  public boolean getInitSegmentLib()
  {
    return this.INIT_SEGMENT_LIB;
  }
  
  public boolean getIsModelCopySuccess()
  {
    return this.mIsModelCopySuccess;
  }
  
  public boolean getIsProtoCopySuccess()
  {
    return this.mIsProtoCopySuccess;
  }
  
  public int getModelCopyType()
  {
    return this.mModelCopyType;
  }
  
  public String getModelPath()
  {
    return this.mModelPath;
  }
  
  public String getProtoPath()
  {
    return this.mProtoPath;
  }
  
  public boolean isGPUSupportOpenCL()
  {
    AppMethodBeat.i(81869);
    boolean bool = VideoPrefsUtil.getDefaultPrefs().getBoolean("prefs_key_segment_on_cpu", false);
    if ((this.gpuSupportOpenCL) && (!bool))
    {
      AppMethodBeat.o(81869);
      return true;
    }
    AppMethodBeat.o(81869);
    return false;
  }
  
  public Bitmap segment(Bitmap paramBitmap)
  {
    AppMethodBeat.i(81868);
    paramBitmap = this.lib.segment(paramBitmap);
    AppMethodBeat.o(81868);
    return paramBitmap;
  }
  
  public void segmentOnBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(81871);
    this.lib.segmentOnBitmap(paramBitmap1, paramBitmap2, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(81871);
  }
  
  public int segmentOnTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(81870);
    paramInt1 = this.lib.segmentOnTexture(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramInt5, paramInt6);
    AppMethodBeat.o(81870);
    return paramInt1;
  }
  
  public int segmentOnTextureV2(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(81873);
    paramInt1 = this.lib.segmentOnTextureV2(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(81873);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.fabby.FabbyManager
 * JD-Core Version:    0.7.0.1
 */