package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import java.util.ArrayList;

public class YtLivenessNetProtoHelper$LiveStyleRequester$SeleceData
{
  public YtLivenessNetProtoHelper.LiveStyleRequester.LiveStyleAndroidData android_data;
  public int change_point_num;
  public String client_version;
  public String config;
  public int platform;
  public int protocal;
  public String reflect_param;
  public ArrayList<YtLivenessNetProtoHelper.SensorData> sensor_data;
  public String version;
  
  public YtLivenessNetProtoHelper$LiveStyleRequester$SeleceData(float paramFloat, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(218186);
    this.platform = 2;
    this.protocal = 1;
    this.version = "3.6.9.2";
    this.change_point_num = 2;
    this.android_data = new YtLivenessNetProtoHelper.LiveStyleRequester.LiveStyleAndroidData();
    this.android_data.lux = paramFloat;
    this.change_point_num = paramInt;
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      this.reflect_param = paramString1;
    }
    if ((paramString3 != null) && (paramString3.length() > 0)) {
      this.config = paramString3;
    }
    this.client_version = paramString2;
    AppMethodBeat.o(218186);
  }
  
  public String getConfig()
  {
    return this.config;
  }
  
  public void setConfig(String paramString)
  {
    this.config = paramString;
  }
  
  public String toString()
  {
    AppMethodBeat.i(218201);
    String str = "".concat(Integer.toString(this.platform)).concat(Integer.toString(this.protocal)).concat(this.client_version).concat(this.android_data.toString());
    YtLogger.d(YtLivenessNetProtoHelper.access$000(), "select_data_str: ".concat(String.valueOf(str)));
    AppMethodBeat.o(218201);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.YtLivenessNetProtoHelper.LiveStyleRequester.SeleceData
 * JD-Core Version:    0.7.0.1
 */