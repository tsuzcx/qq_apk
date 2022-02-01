package com.tencent.tav.asset;

import com.tencent.tav.coremedia.CMTime;
import java.util.Date;
import java.util.Locale;

public class MetadataItem
{
  protected String dataType;
  private byte[] dataValue;
  private Date dateValue;
  protected CMTime duration;
  protected String extendedLanguageTag;
  protected String identifier;
  protected Locale locale;
  private Integer numberValue;
  private Date startDate;
  private String stringValue;
  protected CMTime time;
  protected Object value;
  
  public String getDataType()
  {
    return this.dataType;
  }
  
  public CMTime getDuration()
  {
    return this.duration;
  }
  
  public String getExtendedLanguageTag()
  {
    return this.extendedLanguageTag;
  }
  
  public String getIdentifier()
  {
    return this.identifier;
  }
  
  public Locale getLocale()
  {
    return this.locale;
  }
  
  public CMTime getTime()
  {
    return this.time;
  }
  
  public Object getValue()
  {
    return this.value;
  }
  
  public class MutableMetadataItem
    extends MetadataItem
  {
    public MutableMetadataItem() {}
    
    public void setDataType(String paramString)
    {
      this.dataType = paramString;
    }
    
    public void setDuration(CMTime paramCMTime)
    {
      this.duration = paramCMTime;
    }
    
    public void setExtendedLanguageTag(String paramString)
    {
      this.extendedLanguageTag = paramString;
    }
    
    public void setIdentifier(String paramString)
    {
      this.identifier = paramString;
    }
    
    public void setLocale(Locale paramLocale)
    {
      this.locale = paramLocale;
    }
    
    public void setTime(CMTime paramCMTime)
    {
      this.time = paramCMTime;
    }
    
    public void setValue(Object paramObject)
    {
      this.value = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.asset.MetadataItem
 * JD-Core Version:    0.7.0.1
 */