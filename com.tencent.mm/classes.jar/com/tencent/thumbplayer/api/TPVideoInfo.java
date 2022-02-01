package com.tencent.thumbplayer.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.utils.b;
import java.util.ArrayList;

public class TPVideoInfo
{
  private Builder builder;
  private String definition;
  private ArrayList<TPDownloadParamData> downloadParamList;
  private String fileID;
  private long height;
  private int videoCodecId;
  private long width;
  
  private TPVideoInfo(Builder paramBuilder)
  {
    AppMethodBeat.i(219940);
    this.width = paramBuilder.width;
    this.height = paramBuilder.height;
    this.videoCodecId = paramBuilder.videoCodecId;
    this.fileID = paramBuilder.fileID;
    this.definition = paramBuilder.definition;
    this.downloadParamList = paramBuilder.downloadParamList;
    this.builder = paramBuilder;
    AppMethodBeat.o(219940);
  }
  
  public Builder getBuilder()
  {
    return this.builder;
  }
  
  public String getDefinition()
  {
    return this.definition;
  }
  
  public ArrayList<TPDownloadParamData> getDownloadPraramList()
  {
    return this.downloadParamList;
  }
  
  public long getHeight()
  {
    return this.height;
  }
  
  public String getProxyFileID()
  {
    return this.fileID;
  }
  
  public int getVideoCodecId()
  {
    return this.videoCodecId;
  }
  
  public long getWidth()
  {
    return this.width;
  }
  
  public static class Builder
  {
    private String definition;
    private ArrayList<TPDownloadParamData> downloadParamList;
    private String fileID;
    private long height;
    private int videoCodecId;
    private long width;
    
    public TPVideoInfo build()
    {
      AppMethodBeat.i(219938);
      TPVideoInfo localTPVideoInfo = new TPVideoInfo(this, null);
      AppMethodBeat.o(219938);
      return localTPVideoInfo;
    }
    
    public Builder definition(String paramString)
    {
      this.definition = paramString;
      return this;
    }
    
    public Builder downloadParam(TPDownloadParamData paramTPDownloadParamData)
    {
      AppMethodBeat.i(219937);
      if (b.isEmpty(this.downloadParamList)) {
        this.downloadParamList = new ArrayList();
      }
      for (;;)
      {
        this.downloadParamList.add(paramTPDownloadParamData);
        AppMethodBeat.o(219937);
        return this;
        this.downloadParamList.clear();
      }
    }
    
    public Builder downloadParamList(ArrayList<TPDownloadParamData> paramArrayList)
    {
      this.downloadParamList = paramArrayList;
      return this;
    }
    
    public Builder fileId(String paramString)
    {
      this.fileID = paramString;
      return this;
    }
    
    public Builder size(long paramLong1, long paramLong2)
    {
      this.width = paramLong1;
      this.height = paramLong2;
      return this;
    }
    
    public Builder videoCodecId(int paramInt)
    {
      this.videoCodecId = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPVideoInfo
 * JD-Core Version:    0.7.0.1
 */