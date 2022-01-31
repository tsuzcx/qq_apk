package com.tencent.ttpic.util.youtu;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.util.VideoCacheUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.util.g;
import java.io.File;
import java.io.InputStream;

public class VideoFaceDetector
{
  private static final String TAG = VideoFaceDetector.class.getSimpleName();
  private long mNativeObjPtr;
  private boolean rpnRet = true;
  
  private boolean copyModelFiles(String[] paramArrayOfString, String paramString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      String str = paramArrayOfString[i];
      if (!VideoFileUtil.copyAssets(VideoGlobalContext.getContext(), "detector/" + str, paramString + File.separator + str)) {
        this.rpnRet = false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean initModel(String paramString)
  {
    try
    {
      paramString = VideoGlobalContext.getContext().getAssets().open("ufat.bin");
      paramString.read(new byte[paramString.available()]);
      paramString.close();
      return false;
    }
    catch (Exception paramString)
    {
      return false;
    }
    catch (UnsatisfiedLinkError paramString) {}
    return false;
  }
  
  public void destroy() {}
  
  public void doFaceDetect(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public void doFaceDetectByY(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public FaceStatus[] doTrack(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public FaceStatus[] doTrack3D(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float paramFloat)
  {
    return null;
  }
  
  public FaceStatus[] doTrackByY(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public int init()
  {
    Object localObject = new String[6];
    localObject[0] = "net_1.rpnmodel";
    localObject[1] = "net_1_bin.rpnproto";
    localObject[2] = "net_2.rpnmodel";
    localObject[3] = "net_2_bin.rpnproto";
    localObject[4] = "net_3.rpnmodel";
    localObject[5] = "net_3_bin.rpnproto";
    String str2 = VideoCacheUtil.getTempDiskCacheDir().toString();
    this.rpnRet = copyModelFiles((String[])localObject, str2);
    String str1 = str2;
    if (!new File(str2).exists())
    {
      str1 = VideoGlobalContext.getContext().getCacheDir().toString();
      this.rpnRet = copyModelFiles((String[])localObject, str1);
    }
    str2 = str1 + File.separator + "ccnf_patches_1_my36n.txt";
    localObject = str1 + File.separator + "pdm_82_aligned_my36n.txt";
    String str3 = str1 + File.separator + "pdm.txt";
    String str4 = str1 + File.separator + "pdm_82.txt";
    String str5 = str1 + File.separator + "meshBasis.bin";
    String str6 = str1 + File.separator + "rotBasis.bin";
    new StringBuilder().append(str1).append(File.separator);
    int i = 0;
    boolean bool1 = VideoFileUtil.copyAssets(VideoGlobalContext.getContext(), "ccnf_patches_1_my36n.txt", str2);
    boolean bool2 = VideoFileUtil.copyAssets(VideoGlobalContext.getContext(), "pdm_82_aligned_my36n.txt", (String)localObject);
    boolean bool3 = VideoFileUtil.copyAssets(VideoGlobalContext.getContext(), "pdm.txt", str3);
    boolean bool4 = VideoFileUtil.copyAssets(VideoGlobalContext.getContext(), "pdm_82.txt", str4);
    boolean bool5 = VideoFileUtil.copyAssets(VideoGlobalContext.getContext(), "meshBasis.bin", str5);
    boolean bool6 = VideoFileUtil.copyAssets(VideoGlobalContext.getContext(), "rotBasis.bin", str6);
    if ((!bool1) || (!bool2) || (!bool3) || (!bool4) || (!bool5) || (!bool6) || (!this.rpnRet)) {
      i = -1000;
    }
    if (!initModel(str1 + File.separator))
    {
      i = -1002;
      g.i("VideoFaceDetector", "nativeInit failed");
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.VideoFaceDetector
 * JD-Core Version:    0.7.0.1
 */