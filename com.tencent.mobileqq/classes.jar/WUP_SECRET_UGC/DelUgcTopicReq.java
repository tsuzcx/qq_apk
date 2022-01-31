package WUP_SECRET_UGC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DelUgcTopicReq
  extends JceStruct
{
  public int source;
  public String ugc_id = "";
  public String uid = "";
  
  public DelUgcTopicReq() {}
  
  public DelUgcTopicReq(String paramString1, String paramString2, int paramInt)
  {
    this.uid = paramString1;
    this.ugc_id = paramString2;
    this.source = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uid = paramJceInputStream.readString(0, false);
    this.ugc_id = paramJceInputStream.readString(1, false);
    this.source = paramJceInputStream.read(this.source, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.uid != null) {
      paramJceOutputStream.write(this.uid, 0);
    }
    if (this.ugc_id != null) {
      paramJceOutputStream.write(this.ugc_id, 1);
    }
    paramJceOutputStream.write(this.source, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     WUP_SECRET_UGC.DelUgcTopicReq
 * JD-Core Version:    0.7.0.1
 */