package WUP_SECRET_UGC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DelUgcTopicReq
  extends JceStruct
{
  public int source = 0;
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
    String str = this.uid;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.ugc_id;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.source, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     WUP_SECRET_UGC.DelUgcTopicReq
 * JD-Core Version:    0.7.0.1
 */