package WUP_SECRET_UGC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReportUgcTopicReq
  extends JceStruct
{
  public String content = "";
  public long time = 0L;
  public String ugc_id = "";
  public String uid = "";
  
  public ReportUgcTopicReq() {}
  
  public ReportUgcTopicReq(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    this.uid = paramString1;
    this.ugc_id = paramString2;
    this.content = paramString3;
    this.time = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uid = paramJceInputStream.readString(0, false);
    this.ugc_id = paramJceInputStream.readString(1, false);
    this.content = paramJceInputStream.readString(2, false);
    this.time = paramJceInputStream.read(this.time, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.uid;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.ugc_id;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.content;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    paramJceOutputStream.write(this.time, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     WUP_SECRET_UGC.ReportUgcTopicReq
 * JD-Core Version:    0.7.0.1
 */