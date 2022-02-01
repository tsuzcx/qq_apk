package NS_QMALL_COVER;

import NS_MOBILE_CUSTOM.FloatItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzmallFloat
  extends JceStruct
{
  static FloatItem cache_stFloatItem = new FloatItem();
  public FloatItem stFloatItem = null;
  
  public QzmallFloat() {}
  
  public QzmallFloat(FloatItem paramFloatItem)
  {
    this.stFloatItem = paramFloatItem;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stFloatItem = ((FloatItem)paramJceInputStream.read(cache_stFloatItem, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stFloatItem != null) {
      paramJceOutputStream.write(this.stFloatItem, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.QzmallFloat
 * JD-Core Version:    0.7.0.1
 */