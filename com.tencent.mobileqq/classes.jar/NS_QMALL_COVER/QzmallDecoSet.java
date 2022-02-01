package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzmallDecoSet
  extends JceStruct
{
  static QzmallCustomPraise cache_stCustomPraise = new QzmallCustomPraise();
  static PolymorphicPraise cache_stPolymorphicPraise = new PolymorphicPraise();
  public QzmallCustomPraise stCustomPraise = null;
  public PolymorphicPraise stPolymorphicPraise = null;
  
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
    Object localObject = this.stCustomPraise;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.stPolymorphicPraise;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QMALL_COVER.QzmallDecoSet
 * JD-Core Version:    0.7.0.1
 */