package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzmallDecoSet
  extends JceStruct
{
  static QzmallCustomPraise cache_stCustomPraise = new QzmallCustomPraise();
  static PolymorphicPraise cache_stPolymorphicPraise = new PolymorphicPraise();
  public QzmallCustomPraise stCustomPraise;
  public PolymorphicPraise stPolymorphicPraise;
  
  public QzmallDecoSet() {}
  
  public QzmallDecoSet(QzmallCustomPraise paramQzmallCustomPraise, PolymorphicPraise paramPolymorphicPraise)
  {
    this.stCustomPraise = paramQzmallCustomPraise;
    this.stPolymorphicPraise = paramPolymorphicPraise;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stCustomPraise = ((QzmallCustomPraise)paramJceInputStream.read(cache_stCustomPraise, 0, false));
    this.stPolymorphicPraise = ((PolymorphicPraise)paramJceInputStream.read(cache_stPolymorphicPraise, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stCustomPraise != null) {
      paramJceOutputStream.write(this.stCustomPraise, 0);
    }
    if (this.stPolymorphicPraise != null) {
      paramJceOutputStream.write(this.stPolymorphicPraise, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.QzmallDecoSet
 * JD-Core Version:    0.7.0.1
 */