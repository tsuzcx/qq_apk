package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BarrageDeco
  extends JceStruct
{
  static QzmallCustomVip cache_stCustomVip = new QzmallCustomVip();
  public QzmallCustomVip stCustomVip;
  
  public BarrageDeco() {}
  
  public BarrageDeco(QzmallCustomVip paramQzmallCustomVip)
  {
    this.stCustomVip = paramQzmallCustomVip;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stCustomVip = ((QzmallCustomVip)paramJceInputStream.read(cache_stCustomVip, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stCustomVip != null) {
      paramJceOutputStream.write(this.stCustomVip, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.BarrageDeco
 * JD-Core Version:    0.7.0.1
 */