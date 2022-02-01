package com.tencent.youtu.ytagreflectlivecheck.jni;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.data.YTActReflectData;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.DataPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.EncodeReflectData;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.RawImgData;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ActionReflectReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ColorImgData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.FaceFrame;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.PersonLive;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.PersonLiveReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectColorData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectLiveReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.YTImageInfo;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class JNIUtils
{
  private static final String TAG = "LightLiveCheck";
  public String color_data = "";
  public byte[] compare_image = null;
  public byte[] live_image = null;
  public int platform = 2;
  public ReflectColorData reflect_data = null;
  public String session_id = null;
  
  public static ActionReflectReq getActionReflectLiveReq(FullPack paramFullPack, EncodeReflectData paramEncodeReflectData, YTActReflectData paramYTActReflectData, String paramString)
  {
    AppMethodBeat.i(43366);
    ActionReflectReq localActionReflectReq = new ActionReflectReq();
    localActionReflectReq.app_id = YTAGReflectLiveCheckInterface.mAppId;
    localActionReflectReq.color_data = paramString;
    localActionReflectReq.platform = 2;
    localActionReflectReq.select_data = paramYTActReflectData.select_data;
    localActionReflectReq.reflect_data = translation(paramFullPack.AGin);
    if (paramFullPack != null) {
      localActionReflectReq.reflect_data = translation(paramFullPack.AGin);
    }
    if (paramEncodeReflectData != null)
    {
      localActionReflectReq.encode_reflect_data = new String(paramEncodeReflectData.encode_reflect_data);
      localActionReflectReq.reserve = new String(paramEncodeReflectData.reserve);
    }
    localActionReflectReq.live_image = new YTImageInfo(paramYTActReflectData.best);
    localActionReflectReq.eye_image = new YTImageInfo(paramYTActReflectData.eye);
    localActionReflectReq.mouth_image = new YTImageInfo(paramYTActReflectData.mouth);
    localActionReflectReq.compare_image = null;
    localActionReflectReq.mode = 1;
    localActionReflectReq.session_id = null;
    AppMethodBeat.o(43366);
    return localActionReflectReq;
  }
  
  public static ReflectLiveReq getReflectLiveReq(FullPack paramFullPack, EncodeReflectData paramEncodeReflectData, String paramString)
  {
    AppMethodBeat.i(43367);
    ReflectLiveReq localReflectLiveReq = new ReflectLiveReq();
    localReflectLiveReq.color_data = paramString;
    localReflectLiveReq.platform = 2;
    if (paramFullPack != null)
    {
      localReflectLiveReq.reflect_data = translation(paramFullPack.AGin);
      localReflectLiveReq.live_image = new String(Base64.encode(paramFullPack.frames, 2));
    }
    if (paramEncodeReflectData != null)
    {
      localReflectLiveReq.encode_reflect_data = new String(paramEncodeReflectData.encode_reflect_data);
      localReflectLiveReq.reserve = new String(paramEncodeReflectData.reserve);
      localReflectLiveReq.live_image = new String(paramEncodeReflectData.live_image);
    }
    localReflectLiveReq.compare_image = null;
    localReflectLiveReq.session_id = null;
    localReflectLiveReq.app_id = YTAGReflectLiveCheckInterface.mAppId;
    AppMethodBeat.o(43367);
    return localReflectLiveReq;
  }
  
  public static Timeval getTimeval()
  {
    AppMethodBeat.i(43365);
    long l = System.nanoTime() / 1000L;
    Timeval localTimeval = new Timeval(l / 1000000L, (int)(l % 1000000L));
    AppMethodBeat.o(43365);
    return localTimeval;
  }
  
  private static ColorImgData translation(RawImgData paramRawImgData)
  {
    AppMethodBeat.i(43372);
    ColorImgData localColorImgData = new ColorImgData();
    localColorImgData.setImage(new String(Base64.encode(paramRawImgData.frameBuffer, 2)));
    localColorImgData.setCapture_time(paramRawImgData.captureTime);
    localColorImgData.setX(paramRawImgData.x);
    localColorImgData.setY(paramRawImgData.y);
    AppMethodBeat.o(43372);
    return localColorImgData;
  }
  
  private static FaceFrame translation(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(43370);
    FaceFrame localFaceFrame = new FaceFrame();
    localFaceFrame.setImage(new String(Base64.encode(paramArrayOfByte, 2)));
    AppMethodBeat.o(43370);
    return localFaceFrame;
  }
  
  private static PersonLive translation(DataPack paramDataPack, byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(43369);
    PersonLive localPersonLive = new PersonLive();
    localPersonLive.setReflect_data(translation(paramDataPack));
    localPersonLive.setColor_data(paramString);
    localPersonLive.setPlatform(2);
    paramDataPack = new ArrayList();
    paramDataPack.add(translation(paramArrayOfByte));
    localPersonLive.setFrames(paramDataPack);
    AppMethodBeat.o(43369);
    return localPersonLive;
  }
  
  public static PersonLiveReq translation(FullPack paramFullPack, String paramString)
  {
    AppMethodBeat.i(43368);
    PersonLiveReq localPersonLiveReq = new PersonLiveReq();
    localPersonLiveReq.setApp_id("starimeliu");
    localPersonLiveReq.setBusiness_name("starimeliu");
    localPersonLiveReq.setPerson_id("starimeliu");
    localPersonLiveReq.setLivedata(translation(paramFullPack.AGin, paramFullPack.frames, paramString));
    localPersonLiveReq.setLive_type(2);
    localPersonLiveReq.setReq_type("live");
    AppMethodBeat.o(43368);
    return localPersonLiveReq;
  }
  
  private static ReflectColorData translation(DataPack paramDataPack)
  {
    AppMethodBeat.i(43371);
    ReflectColorData localReflectColorData = new ReflectColorData();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramDataPack.videoData.length)
    {
      localArrayList.add(translation(paramDataPack.videoData[i]));
      i += 1;
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
      label133:
      localReflectColorData.setConfig_begin(paramDataPack.config_begin);
      AppMethodBeat.o(43371);
      return localReflectColorData;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label133;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.jni.JNIUtils
 * JD-Core Version:    0.7.0.1
 */