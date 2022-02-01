package com.tencent.youtu.ytagreflectlivecheck.jni.model;

public class PersonLiveReq
{
  private String app_id;
  private String business_name;
  private int live_type;
  private PersonLive livedata;
  private String person_id;
  private String req_type;
  
  public PersonLiveReq() {}
  
  public PersonLiveReq(String paramString1, String paramString2, String paramString3, PersonLive paramPersonLive, int paramInt, String paramString4)
  {
    this.app_id = paramString1;
    this.business_name = paramString2;
    this.person_id = paramString3;
    this.livedata = paramPersonLive;
    this.live_type = paramInt;
    this.req_type = paramString4;
  }
  
  public String getApp_id()
  {
    return this.app_id;
  }
  
  public String getBusiness_name()
  {
    return this.business_name;
  }
  
  public int getLive_type()
  {
    return this.live_type;
  }
  
  public PersonLive getLivedata()
  {
    return this.livedata;
  }
  
  public String getPerson_id()
  {
    return this.person_id;
  }
  
  public String getReq_type()
  {
    return this.req_type;
  }
  
  public void setApp_id(String paramString)
  {
    this.app_id = paramString;
  }
  
  public void setBusiness_name(String paramString)
  {
    this.business_name = paramString;
  }
  
  public void setLive_type(int paramInt)
  {
    this.live_type = paramInt;
  }
  
  public void setLivedata(PersonLive paramPersonLive)
  {
    this.livedata = paramPersonLive;
  }
  
  public void setPerson_id(String paramString)
  {
    this.person_id = paramString;
  }
  
  public void setReq_type(String paramString)
  {
    this.req_type = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.jni.model.PersonLiveReq
 * JD-Core Version:    0.7.0.1
 */