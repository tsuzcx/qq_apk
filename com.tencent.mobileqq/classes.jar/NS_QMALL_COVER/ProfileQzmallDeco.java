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
  public QzmallAvatar stAvatar;
  public UserCmShowQzoneTrack stCmShowQzoneTrack;
  public QzmallCustomBanner stCustomBanner;
  public QzmallCustomNavi stCustomNavi;
  public QzmallCustomPlayer stCustomPlayer;
  public QzmallCustomPraise stCustomPraise;
  public CustomTrackDeco stCustomTrack;
  public QzmallCustomVip stCustomVip;
  public QzmallFacade stFacade;
  public FacadeDIY stFacadeDIY;
  public FeedNavi stFeedNavi;
  public QzmallFeedSkin stFeedSkin;
  public QzmallFloat stFloat;
  public PolymorphicPraise stPolymorphicPraise;
  public DataForQboss stQbossData;
  public ActYellowDiamond stYellowDiamond;
  
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
    if (this.stCustomNavi != null) {
      paramJceOutputStream.write(this.stCustomNavi, 0);
    }
    if (this.stCustomPraise != null) {
      paramJceOutputStream.write(this.stCustomPraise, 1);
    }
    if (this.stCustomPlayer != null) {
      paramJceOutputStream.write(this.stCustomPlayer, 2);
    }
    if (this.stCustomBanner != null) {
      paramJceOutputStream.write(this.stCustomBanner, 3);
    }
    if (this.stAvatar != null) {
      paramJceOutputStream.write(this.stAvatar, 4);
    }
    if (this.stFloat != null) {
      paramJceOutputStream.write(this.stFloat, 5);
    }
    if (this.stFeedSkin != null) {
      paramJceOutputStream.write(this.stFeedSkin, 6);
    }
    if (this.stCustomVip != null) {
      paramJceOutputStream.write(this.stCustomVip, 7);
    }
    if (this.stFacade != null) {
      paramJceOutputStream.write(this.stFacade, 8);
    }
    if (this.stYellowDiamond != null) {
      paramJceOutputStream.write(this.stYellowDiamond, 9);
    }
    if (this.stPolymorphicPraise != null) {
      paramJceOutputStream.write(this.stPolymorphicPraise, 10);
    }
    if (this.stQbossData != null) {
      paramJceOutputStream.write(this.stQbossData, 11);
    }
    if (this.stFeedNavi != null) {
      paramJceOutputStream.write(this.stFeedNavi, 12);
    }
    if (this.stFacadeDIY != null) {
      paramJceOutputStream.write(this.stFacadeDIY, 13);
    }
    if (this.stCustomTrack != null) {
      paramJceOutputStream.write(this.stCustomTrack, 14);
    }
    if (this.stCmShowQzoneTrack != null) {
      paramJceOutputStream.write(this.stCmShowQzoneTrack, 15);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.ProfileQzmallDeco
 * JD-Core Version:    0.7.0.1
 */