package NS_BG_VOICE_LOGIC_APP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class tGetBGVoiceWebappReq
  extends JceStruct
{
  public long lLoginUin;
  public String strQUA = "";
  
  public tGetBGVoiceWebappReq() {}
  
  public tGetBGVoiceWebappReq(long paramLong, String paramString)
  {
    this.lLoginUin = paramLong;
    this.strQUA = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lLoginUin = paramJceInputStream.read(this.lLoginUin, 0, false);
    this.strQUA = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lLoginUin, 0);
    if (this.strQUA != null) {
      paramJceOutputStream.write(this.strQUA, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_BG_VOICE_LOGIC_APP.tGetBGVoiceWebappReq
 * JD-Core Version:    0.7.0.1
 */