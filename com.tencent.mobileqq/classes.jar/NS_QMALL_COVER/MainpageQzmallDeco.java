package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MainpageQzmallDeco
  extends JceStruct
{
  static QzmallCustomVip cache_stCustomVip = new QzmallCustomVip();
  static QzmallVipWidget cache_stVipWidget = new QzmallVipWidget();
  static ActYellowDiamond cache_stYellowDiamond = new ActYellowDiamond();
  public QzmallCustomVip stCustomVip;
  public QzmallVipWidget stVipWidget;
  public ActYellowDiamond stYellowDiamond;
  
  public MainpageQzmallDeco() {}
  
  public MainpageQzmallDeco(QzmallCustomVip paramQzmallCustomVip, QzmallVipWidget paramQzmallVipWidget, ActYellowDiamond paramActYellowDiamond)
  {
    this.stCustomVip = paramQzmallCustomVip;
    this.stVipWidget = paramQzmallVipWidget;
    this.stYellowDiamond = paramActYellowDiamond;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stCustomVip = ((QzmallCustomVip)paramJceInputStream.read(cache_stCustomVip, 0, false));
    this.stVipWidget = ((QzmallVipWidget)paramJceInputStream.read(cache_stVipWidget, 1, false));
    this.stYellowDiamond = ((ActYellowDiamond)paramJceInputStream.read(cache_stYellowDiamond, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stCustomVip != null) {
      paramJceOutputStream.write(this.stCustomVip, 0);
    }
    if (this.stVipWidget != null) {
      paramJceOutputStream.write(this.stVipWidget, 1);
    }
    if (this.stYellowDiamond != null) {
      paramJceOutputStream.write(this.stYellowDiamond, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.MainpageQzmallDeco
 * JD-Core Version:    0.7.0.1
 */