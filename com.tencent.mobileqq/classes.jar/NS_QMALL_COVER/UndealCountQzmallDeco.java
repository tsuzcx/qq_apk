package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UndealCountQzmallDeco
  extends JceStruct
{
  static QzmallCustomVip cache_stCustomVip = new QzmallCustomVip();
  public QzmallCustomVip stCustomVip = null;
  
  public UndealCountQzmallDeco() {}
  
  public UndealCountQzmallDeco(QzmallCustomVip paramQzmallCustomVip)
  {
    this.stCustomVip = paramQzmallCustomVip;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stCustomVip = ((QzmallCustomVip)paramJceInputStream.read(cache_stCustomVip, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    QzmallCustomVip localQzmallCustomVip = this.stCustomVip;
    if (localQzmallCustomVip != null) {
      paramJceOutputStream.write(localQzmallCustomVip, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QMALL_COVER.UndealCountQzmallDeco
 * JD-Core Version:    0.7.0.1
 */