package com.tencent.youtu.ytagreflectlivecheck.jni.model;

import java.util.ArrayList;

public class ReflectColorData
{
  public long begin_time;
  public long changepoint_time;
  public ArrayList<Long> changepoint_time_list;
  public int config_begin;
  public int frame_num;
  public int height;
  public ArrayList<ColorImgData> images_data;
  public int landmark_num;
  public String log;
  public float offset_sys;
  public String reflect_video;
  public String version;
  public int width;
  
  public long getBegin_time()
  {
    return this.begin_time;
  }
  
  public long getChangepoint_time()
  {
    return this.changepoint_time;
  }
  
  public int getConfig_begin()
  {
    return this.config_begin;
  }
  
  public int getFrame_num()
  {
    return this.frame_num;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public ArrayList<ColorImgData> getImages_data()
  {
    return this.images_data;
  }
  
  public int getLandmark_num()
  {
    return this.landmark_num;
  }
  
  public String getLog()
  {
    return this.log;
  }
  
  public float getOffset_sys()
  {
    return this.offset_sys;
  }
  
  public String getReflect_video()
  {
    return this.reflect_video;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void setBegin_time(long paramLong)
  {
    this.begin_time = paramLong;
  }
  
  public void setChangepoint_time(long paramLong)
  {
    this.changepoint_time = paramLong;
  }
  
  public void setConfig_begin(int paramInt)
  {
    this.config_begin = paramInt;
  }
  
  public void setFrame_num(int paramInt)
  {
    this.frame_num = paramInt;
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setImages_data(ArrayList<ColorImgData> paramArrayList)
  {
    this.images_data = paramArrayList;
  }
  
  public void setLandmark_num(int paramInt)
  {
    this.landmark_num = paramInt;
  }
  
  public void setLog(String paramString)
  {
    this.log = paramString;
  }
  
  public void setOffset_sys(float paramFloat)
  {
    this.offset_sys = paramFloat;
  }
  
  public void setReflectVideo(String paramString)
  {
    this.reflect_video = paramString;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectColorData
 * JD-Core Version:    0.7.0.1
 */