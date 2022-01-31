package com.tencent.youtu.ytagreflectlivecheck.jni;

import android.util.Base64;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.DataPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.RawImgData;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ColorImgData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.FaceFrame;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.PersonLive;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.PersonLiveReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectColorData;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class JNIUtils
{
  private static final String TAG = "LightLiveCheck";
  
  public static Timeval getTimeval()
  {
    long l = System.nanoTime() / 1000L;
    return new Timeval(l / 1000000L, (int)(l % 1000000L));
  }
  
  private static ColorImgData translation(RawImgData paramRawImgData)
  {
    ColorImgData localColorImgData = new ColorImgData();
    localColorImgData.setImage(new String(Base64.encode(paramRawImgData.frameBuffer, 2)));
    localColorImgData.setCapture_time(paramRawImgData.captureTime);
    localColorImgData.setX(paramRawImgData.x);
    localColorImgData.setY(paramRawImgData.y);
    return localColorImgData;
  }
  
  private static FaceFrame translation(byte[] paramArrayOfByte)
  {
    FaceFrame localFaceFrame = new FaceFrame();
    localFaceFrame.setImage(new String(Base64.encode(paramArrayOfByte, 2)));
    return localFaceFrame;
  }
  
  private static PersonLive translation(DataPack paramDataPack, byte[] paramArrayOfByte, String paramString)
  {
    PersonLive localPersonLive = new PersonLive();
    localPersonLive.setReflect_data(translation(paramDataPack, 0));
    localPersonLive.setColor_data(paramString);
    localPersonLive.setPlatform(2);
    paramDataPack = new ArrayList();
    paramDataPack.add(translation(paramArrayOfByte));
    localPersonLive.setFrames(paramDataPack);
    return localPersonLive;
  }
  
  public static PersonLiveReq translation(FullPack paramFullPack, String paramString)
  {
    PersonLiveReq localPersonLiveReq = new PersonLiveReq();
    localPersonLiveReq.setApp_id("starimeliu");
    localPersonLiveReq.setBusiness_name("starimeliu");
    localPersonLiveReq.setPerson_id("starimeliu");
    localPersonLiveReq.setLivedata(translation(paramFullPack.AGin, paramFullPack.frames, paramString));
    localPersonLiveReq.setLive_type(2);
    localPersonLiveReq.setReq_type("live");
    return localPersonLiveReq;
  }
  
  private static ReflectColorData translation(DataPack paramDataPack, int paramInt)
  {
    ReflectColorData localReflectColorData = new ReflectColorData();
    ArrayList localArrayList = new ArrayList();
    paramInt = 0;
    while (paramInt < paramDataPack.videoData.length)
    {
      localArrayList.add(translation(paramDataPack.videoData[paramInt]));
      paramInt += 1;
    }
    localReflectColorData.setImages_data(localArrayList);
    localReflectColorData.setBegin_time(paramDataPack.beginTime);
    localReflectColorData.setChangepoint_time(paramDataPack.changePointTime);
    localReflectColorData.setOffset_sys(paramDataPack.offsetSys);
    localReflectColorData.setFrame_num(paramDataPack.frameNum);
    localReflectColorData.setLandmark_num(paramDataPack.landMarkNum);
    localReflectColorData.setWidth(paramDataPack.width);
    localReflectColorData.setHeight(paramDataPack.height);
    try
    {
      localReflectColorData.setLog(new String(paramDataPack.log, "UTF-8"));
      label126:
      localReflectColorData.setConfig_begin(paramDataPack.config_begin);
      return localReflectColorData;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label126;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.jni.JNIUtils
 * JD-Core Version:    0.7.0.1
 */