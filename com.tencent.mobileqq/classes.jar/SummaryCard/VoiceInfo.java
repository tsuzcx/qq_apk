package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class VoiceInfo
  extends JceStruct
{
  static byte[] cache_vVoiceId;
  public byte bRead = 2;
  public short shDuration = 0;
  public String strUrl = "";
  public byte[] vVoiceId = null;
  
  public VoiceInfo() {}
  
  public VoiceInfo(byte[] paramArrayOfByte, short paramShort, byte paramByte, String paramString)
  {
    this.vVoiceId = paramArrayOfByte;
    this.shDuration = paramShort;
    this.bRead = paramByte;
    this.strUrl = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vVoiceId == null)
    {
      cache_vVoiceId = (byte[])new byte[1];
      ((byte[])cache_vVoiceId)[0] = 0;
    }
    this.vVoiceId = ((byte[])paramJceInputStream.read(cache_vVoiceId, 0, false));
    this.shDuration = paramJceInputStream.read(this.shDuration, 1, false);
    this.bRead = paramJceInputStream.read(this.bRead, 2, false);
    this.strUrl = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.vVoiceId;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 0);
    }
    paramJceOutputStream.write(this.shDuration, 1);
    paramJceOutputStream.write(this.bRead, 2);
    localObject = this.strUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCard.VoiceInfo
 * JD-Core Version:    0.7.0.1
 */