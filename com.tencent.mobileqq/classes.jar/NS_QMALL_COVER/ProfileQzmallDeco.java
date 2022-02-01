package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ProfileQzmallDeco
  extends JceStruct
{
  static QzmallAvatar cache_stAvatar;
  static UserCmShowQzoneTrack cache_stCmShowQzoneTrack = new UserCmShowQzoneTrack();
  static QzmallCustomBanner cache_stCustomBanner;
  static QzmallCustomNavi cache_stCustomNavi = new QzmallCustomNavi();
  static QzmallCustomPlayer cache_stCustomPlayer;
  static QzmallCustomPraise cache_stCustomPraise = new QzmallCustomPraise();
  static CustomTrackDeco cache_stCustomTrack;
  static QzmallCustomVip cache_stCustomVip;
  static QzmallFacade cache_stFacade;
  static FacadeDIY cache_stFacadeDIY;
  static FeedNavi cache_stFeedNavi;
  static QzmallFeedSkin cache_stFeedSkin;
  static QzmallFloat cache_stFloat;
  static PolymorphicPraise cache_stPolymorphicPraise;
  static DataForQboss cache_stQbossData;
  static ActYellowDiamond cache_stYellowDiamond;
  public QzmallAvatar stAvatar = null;
  public UserCmShowQzoneTrack stCmShowQzoneTrack = null;
  public QzmallCustomBanner stCustomBanner = null;
  public QzmallCustomNavi stCustomNavi = null;
  public QzmallCustomPlayer stCustomPlayer = null;
  public QzmallCustomPraise stCustomPraise = null;
  public CustomTrackDeco stCustomTrack = null;
  public QzmallCustomVip stCustomVip = null;
  public QzmallFacade stFacade = null;
  public FacadeDIY stFacadeDIY = null;
  public FeedNavi stFeedNavi = null;
  public QzmallFeedSkin stFeedSkin = null;
  public QzmallFloat stFloat = null;
  public PolymorphicPraise stPolymorphicPraise = null;
  public DataForQboss stQbossData = null;
  public ActYellowDiamond stYellowDiamond = null;
  
  static
  {
    cache_stCustomPlayer = new QzmallCustomPlayer();
    cache_stCustomBanner = new QzmallCustomBanner();
    cache_stAvatar = new QzmallAvatar();
    cache_stFloat = new QzmallFloat();
    cache_stFeedSkin = new QzmallFeedSkin();
    cache_stCustomVip = new QzmallCustomVip();
    cache_stFacade = new QzmallFacade();
    cache_stYellowDiamond = new ActYellowDiamond();
    cache_stPolymorphicPraise = new PolymorphicPraise();
    cache_stQbossData = new DataForQboss();
    cache_stFeedNavi = new FeedNavi();
    cache_stFacadeDIY = new FacadeDIY();
    cache_stCustomTrack = new CustomTrackDeco();
  }
  
  public ProfileQzmallDeco() {}
  
  public ProfileQzmallDeco(QzmallCustomNavi paramQzmallCustomNavi, QzmallCustomPraise paramQzmallCustomPraise, QzmallCustomPlayer paramQzmallCustomPlayer, QzmallCustomBanner paramQzmallCustomBanner, QzmallAvatar paramQzmallAvatar, QzmallFloat paramQzmallFloat, QzmallFeedSkin paramQzmallFeedSkin, QzmallCustomVip paramQzmallCustomVip, QzmallFacade paramQzmallFacade, ActYellowDiamond paramActYellowDiamond, PolymorphicPraise paramPolymorphicPraise, DataForQboss paramDataForQboss, FeedNavi paramFeedNavi, FacadeDIY paramFacadeDIY, CustomTrackDeco paramCustomTrackDeco, UserCmShowQzoneTrack paramUserCmShowQzoneTrack)
  {
    this.stCustomNavi = paramQzmallCustomNavi;
    this.stCustomPraise = paramQzmallCustomPraise;
    this.stCustomPlayer = paramQzmallCustomPlayer;
    this.stCustomBanner = paramQzmallCustomBanner;
    this.stAvatar = paramQzmallAvatar;
    this.stFloat = paramQzmallFloat;
    this.stFeedSkin = paramQzmallFeedSkin;
    this.stCustomVip = paramQzmallCustomVip;
    this.stFacade = paramQzmallFacade;
    this.stYellowDiamond = paramActYellowDiamond;
    this.stPolymorphicPraise = paramPolymorphicPraise;
    this.stQbossData = paramDataForQboss;
    this.stFeedNavi = paramFeedNavi;
    this.stFacadeDIY = paramFacadeDIY;
    this.stCustomTrack = paramCustomTrackDeco;
    this.stCmShowQzoneTrack = paramUserCmShowQzoneTrack;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stCustomNavi = ((QzmallCustomNavi)paramJceInputStream.read(cache_stCustomNavi, 0, false));
    this.stCustomPraise = ((QzmallCustomPraise)paramJceInputStream.read(cache_stCustomPraise, 1, false));
    this.stCustomPlayer = ((QzmallCustomPlayer)paramJceInputStream.read(cache_stCustomPlayer, 2, false));
    this.stCustomBanner = ((QzmallCustomBanner)paramJceInputStream.read(cache_stCustomBanner, 3, false));
    this.stAvatar = ((QzmallAvatar)paramJceInputStream.read(cache_stAvatar, 4, false));
    this.stFloat = ((QzmallFloat)paramJceInputStream.read(cache_stFloat, 5, false));
    this.stFeedSkin = ((QzmallFeedSkin)paramJceInputStream.read(cache_stFeedSkin, 6, false));
    this.stCustomVip = ((QzmallCustomVip)paramJceInputStream.read(cache_stCustomVip, 7, false));
    this.stFacade = ((QzmallFacade)paramJceInputStream.read(cache_stFacade, 8, false));
    this.stYellowDiamond = ((ActYellowDiamond)paramJceInputStream.read(cache_stYellowDiamond, 9, false));
    this.stPolymorphicPraise = ((PolymorphicPraise)paramJceInputStream.read(cache_stPolymorphicPraise, 10, false));
    this.stQbossData = ((DataForQboss)paramJceInputStream.read(cache_stQbossData, 11, false));
    this.stFeedNavi = ((FeedNavi)paramJceInputStream.read(cache_stFeedNavi, 12, false));
    this.stFacadeDIY = ((FacadeDIY)paramJceInputStream.read(cache_stFacadeDIY, 13, false));
    this.stCustomTrack = ((CustomTrackDeco)paramJceInputStream.read(cache_stCustomTrack, 14, false));
    this.stCmShowQzoneTrack = ((UserCmShowQzoneTrack)paramJceInputStream.read(cache_stCmShowQzoneTrack, 15, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.stCustomNavi;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.stCustomPraise;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.stCustomPlayer;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.stCustomBanner;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.stAvatar;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
    localObject = this.stFloat;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    localObject = this.stFeedSkin;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 6);
    }
    localObject = this.stCustomVip;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 7);
    }
    localObject = this.stFacade;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 8);
    }
    localObject = this.stYellowDiamond;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
    localObject = this.stPolymorphicPraise;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 10);
    }
    localObject = this.stQbossData;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 11);
    }
    localObject = this.stFeedNavi;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 12);
    }
    localObject = this.stFacadeDIY;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 13);
    }
    localObject = this.stCustomTrack;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 14);
    }
    localObject = this.stCmShowQzoneTrack;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 15);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QMALL_COVER.ProfileQzmallDeco
 * JD-Core Version:    0.7.0.1
 */