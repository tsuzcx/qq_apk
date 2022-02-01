package com.tencent.youtu.ytagreflectlivecheck.requester;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class LiveStyleRequester$SeleceData
{
  public LiveStyleRequester.LiveStyleAndroidData android_data;
  public int change_point_num;
  public int platform;
  public int protocal;
  public String reflect_param;
  public String version;
  
  public LiveStyleRequester$SeleceData(float paramFloat)
  {
    AppMethodBeat.i(43402);
    this.platform = 2;
    this.protocal = 1;
    this.version = "3.6.4.3";
    this.reflect_param = " version 2 ";
    this.change_point_num = 2;
    this.android_data = new LiveStyleRequester.LiveStyleAndroidData();
    this.android_data.lux = paramFloat;
    AppMethodBeat.o(43402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.SeleceData
 * JD-Core Version:    0.7.0.1
 */