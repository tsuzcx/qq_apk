package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzoneWeisiReqcommendRsp
  extends JceStruct
{
  public int index;
  
  public QzoneWeisiReqcommendRsp() {}
  
  public QzoneWeisiReqcommendRsp(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.index = paramJceInputStream.read(this.index, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.index, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_VIDEO.QzoneWeisiReqcommendRsp
 * JD-Core Version:    0.7.0.1
 */