package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MainpageQzmallDeco
  extends JceStruct
{
  static QzmallCustomVip cache_stCustomVip = new QzmallCustomVip();
  static QzmallVipWidget cache_stVipWidget = new QzmallVipWidget();
  public QzmallCustomVip stCustomVip;
  public QzmallVipWidget stVipWidget;
  
  public MainpageQzmallDeco() {}
  
  public MainpageQzmallDeco(QzmallCustomVip paramQzmallCustomVip, QzmallVipWidget paramQzmallVipWidget)
  {
    this.stCustomVip = paramQzmallCustomVip;
    this.stVipWidget = paramQzmallVipWidget;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stCustomVip = ((QzmallCustomVip)paramJceInputStream.read(cache_stCustomVip, 0, false));
    this.stVipWidget = ((QzmallVipWidget)paramJceInputStream.read(cache_stVipWidget, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stCustomVip != null) {
      paramJceOutputStream.write(this.stCustomVip, 0);
    }
    if (this.stVipWidget != null) {
      paramJceOutputStream.write(this.stVipWidget, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_QMALL_COVER.MainpageQzmallDeco
 * JD-Core Version:    0.7.0.1
 */