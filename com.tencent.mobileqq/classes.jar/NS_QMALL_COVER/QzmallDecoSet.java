package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzmallDecoSet
  extends JceStruct
{
  static QzmallCustomPraise cache_stCustomPraise = new QzmallCustomPraise();
  public QzmallCustomPraise stCustomPraise;
  
  public QzmallDecoSet() {}
  
  public QzmallDecoSet(QzmallCustomPraise paramQzmallCustomPraise)
  {
    this.stCustomPraise = paramQzmallCustomPraise;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stCustomPraise = ((QzmallCustomPraise)paramJceInputStream.read(cache_stCustomPraise, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stCustomPraise != null) {
      paramJceOutputStream.write(this.stCustomPraise, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.QzmallDecoSet
 * JD-Core Version:    0.7.0.1
 */