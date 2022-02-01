package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QidInfoItem
  extends JceStruct
{
  public int has_qid = 0;
  public String qid = "";
  
  public QidInfoItem() {}
  
  public QidInfoItem(int paramInt, String paramString)
  {
    this.has_qid = paramInt;
    this.qid = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.has_qid = paramJceInputStream.read(this.has_qid, 0, false);
    this.qid = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.has_qid, 0);
    String str = this.qid;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MQQ.QidInfoItem
 * JD-Core Version:    0.7.0.1
 */