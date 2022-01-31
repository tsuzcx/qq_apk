package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class LiveInfo
  extends JceStruct
{
  public int iRecording;
  public long iRelativeTime;
  public String strAuthorUin = "";
  public String strRoomId = "";
  
  public LiveInfo() {}
  
  public LiveInfo(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    this.strAuthorUin = paramString1;
    this.strRoomId = paramString2;
    this.iRecording = paramInt;
    this.iRelativeTime = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strAuthorUin = paramJceInputStream.readString(0, false);
    this.strRoomId = paramJceInputStream.readString(1, false);
    this.iRecording = paramJceInputStream.read(this.iRecording, 2, false);
    this.iRelativeTime = paramJceInputStream.read(this.iRelativeTime, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strAuthorUin != null) {
      paramJceOutputStream.write(this.strAuthorUin, 0);
    }
    if (this.strRoomId != null) {
      paramJceOutputStream.write(this.strRoomId, 1);
    }
    paramJceOutputStream.write(this.iRecording, 2);
    paramJceOutputStream.write(this.iRelativeTime, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.LiveInfo
 * JD-Core Version:    0.7.0.1
 */