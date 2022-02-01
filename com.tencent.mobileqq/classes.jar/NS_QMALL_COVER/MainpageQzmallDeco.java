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
  public UserCmShowQzoneTrack stCmShowQzoneTrack = null;
  public CustomTrackDeco stCustomTrack = null;
  public QzmallCustomVip stCustomVip = null;
  public DataForQboss stQbossData = null;
  public StrangerSkin stStrangerSkin = null;
  public QzmallVipWidget stVipWidget = null;
  public ActYellowDiamond stYellowDiamond = null;
  
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
    Object localObject = this.stCustomVip;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.stVipWidget;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.stYellowDiamond;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.stQbossData;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.stCustomTrack;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
    localObject = this.stStrangerSkin;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    localObject = this.stCmShowQzoneTrack;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QMALL_COVER.MainpageQzmallDeco
 * JD-Core Version:    0.7.0.1
 */