package ClientRecordUpload;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.HashMap;
import java.util.Map;

public final class ClientRecordUploadReq
  extends JceStruct
  implements Cloneable
{
  static Map<String, String> cache_extendinfo = new HashMap();
  public long duration = 0L;
  public Map<String, String> extendinfo = null;
  public String m3u8_name = "";
  public long room_id = 0L;
  public long version = 1L;
  
  static
  {
    cache_extendinfo.put("", "");
  }
  
  public ClientRecordUploadReq() {}
  
  public ClientRecordUploadReq(long paramLong1, long paramLong2, Map<String, String> paramMap, String paramString, long paramLong3)
  {
    this.version = paramLong1;
    this.room_id = paramLong2;
    this.extendinfo = paramMap;
    this.m3u8_name = paramString;
    this.duration = paramLong3;
  }
  
  public String className()
  {
    return "ClientRecordUpload.ClientRecordUploadReq";
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.version, "version");
    paramStringBuilder.display(this.room_id, "room_id");
    paramStringBuilder.display(this.extendinfo, "extendinfo");
    paramStringBuilder.display(this.m3u8_name, "m3u8_name");
    paramStringBuilder.display(this.duration, "duration");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.version, true);
    paramStringBuilder.displaySimple(this.room_id, true);
    paramStringBuilder.displaySimple(this.extendinfo, true);
    paramStringBuilder.displaySimple(this.m3u8_name, true);
    paramStringBuilder.displaySimple(this.duration, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (ClientRecordUploadReq)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.version, paramObject.version))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.room_id, paramObject.room_id))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.extendinfo, paramObject.extendinfo))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.m3u8_name, paramObject.m3u8_name))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.duration, paramObject.duration)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "ClientRecordUpload.ClientRecordUploadReq";
  }
  
  public long getDuration()
  {
    return this.duration;
  }
  
  public Map<String, String> getExtendinfo()
  {
    return this.extendinfo;
  }
  
  public String getM3u8_name()
  {
    return this.m3u8_name;
  }
  
  public long getRoom_id()
  {
    return this.room_id;
  }
  
  public long getVersion()
  {
    return this.version;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.version = paramJceInputStream.read(this.version, 0, true);
    this.room_id = paramJceInputStream.read(this.room_id, 1, true);
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 2, false));
    this.m3u8_name = paramJceInputStream.readString(3, false);
    this.duration = paramJceInputStream.read(this.duration, 4, false);
  }
  
  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public void setExtendinfo(Map<String, String> paramMap)
  {
    this.extendinfo = paramMap;
  }
  
  public void setM3u8_name(String paramString)
  {
    this.m3u8_name = paramString;
  }
  
  public void setRoom_id(long paramLong)
  {
    this.room_id = paramLong;
  }
  
  public void setVersion(long paramLong)
  {
    this.version = paramLong;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.version, 0);
    paramJceOutputStream.write(this.room_id, 1);
    Object localObject = this.extendinfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 2);
    }
    localObject = this.m3u8_name;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.duration, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ClientRecordUpload.ClientRecordUploadReq
 * JD-Core Version:    0.7.0.1
 */