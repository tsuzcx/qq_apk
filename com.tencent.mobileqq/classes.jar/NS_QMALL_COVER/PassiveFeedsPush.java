package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PassiveFeedsPush
  extends JceStruct
{
  static QzmallCustomBubbleSkin cache_stBubbleSkin = new QzmallCustomBubbleSkin();
  public QzmallCustomBubbleSkin stBubbleSkin = null;
  
  public PassiveFeedsPush() {}
  
  public PassiveFeedsPush(QzmallCustomBubbleSkin paramQzmallCustomBubbleSkin)
  {
    this.stBubbleSkin = paramQzmallCustomBubbleSkin;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stBubbleSkin = ((QzmallCustomBubbleSkin)paramJceInputStream.read(cache_stBubbleSkin, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stBubbleSkin != null) {
      paramJceOutputStream.write(this.stBubbleSkin, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.PassiveFeedsPush
 * JD-Core Version:    0.7.0.1
 */