package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MainpageQzmallDeco
  extends JceStruct
{
  static UserCmShowQzoneTrack cache_stCmShowQzoneTrack = new UserCmShowQzoneTrack();
  static CustomTrackDeco cache_stCustomTrack;
  static QzmallCustomVip cache_stCustomVip = new QzmallCustomVip();
  static DataForQboss cache_stQbossData;
  static StrangerSkin cache_stStrangerSkin;
  static QzmallVipWidget cache_stVipWidget = new QzmallVipWidget();
  static ActYellowDiamond cache_stYellowDiamond = new ActYellowDiamond();
  public UserCmShowQzoneTrack stCmShowQzoneTrack;
  public CustomTrackDeco stCustomTrack;
  public QzmallCustomVip stCustomVip;
  public DataForQboss stQbossData;
  public StrangerSkin stStrangerSkin;
  public QzmallVipWidget stVipWidget;
  public ActYellowDiamond stYellowDiamond;
  
  static
  {
    cache_stQbossData = new DataForQboss();
    cache_stCustomTrack = new CustomTrackDeco();
    cache_stStrangerSkin = new StrangerSkin();
  }
  
  public MainpageQzmallDeco() {}
  
  public MainpageQzmallDeco(QzmallCustomVip paramQzmallCustomVip, QzmallVipWidget paramQzmallVipWidget, ActYellowDiamond paramActYellowDiamond, DataForQboss paramDataForQboss, CustomTrackDeco paramCustomTrackDeco, StrangerSkin paramStrangerSkin, UserCmShowQzoneTrack paramUserCmShowQzoneTrack)
  {
    this.stCustomVip = paramQzmallCustomVip;
    this.stVipWidget = paramQzmallVipWidget;
    this.stYellowDiamond = paramActYellowDiamond;
    this.stQbossData = paramDataForQboss;
    this.stCustomTrack = paramCustomTrackDeco;
    this.stStrangerSkin = paramStrangerSkin;
    this.stCmShowQzoneTrack = paramUserCmShowQzoneTrack;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stCustomVip = ((QzmallCustomVip)paramJceInputStream.read(cache_stCustomVip, 0, false));
    this.stVipWidget = ((QzmallVipWidget)paramJceInputStream.read(cache_stVipWidget, 1, false));
    this.stYellowDiamond = ((ActYellowDiamond)paramJceInputStream.read(cache_stYellowDiamond, 2, false));
    this.stQbossData = ((DataForQboss)paramJceInputStream.read(cache_stQbossData, 3, false));
    this.stCustomTrack = ((CustomTrackDeco)paramJceInputStream.read(cache_stCustomTrack, 4, false));
    this.stStrangerSkin = ((StrangerSkin)paramJceInputStream.read(cache_stStrangerSkin, 5, false));
    this.stCmShowQzoneTrack = ((UserCmShowQzoneTrack)paramJceInputStream.read(cache_stCmShowQzoneTrack, 6, false));
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
    if (this.stQbossData != null) {
      paramJceOutputStream.write(this.stQbossData, 3);
    }
    if (this.stCustomTrack != null) {
      paramJceOutputStream.write(this.stCustomTrack, 4);
    }
    if (this.stStrangerSkin != null) {
      paramJceOutputStream.write(this.stStrangerSkin, 5);
    }
    if (this.stCmShowQzoneTrack != null) {
      paramJceOutputStream.write(this.stCmShowQzoneTrack, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.MainpageQzmallDeco
 * JD-Core Version:    0.7.0.1
 */