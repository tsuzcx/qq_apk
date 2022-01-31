package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ProfileQzmallDeco
  extends JceStruct
{
  static QzmallAvatar cache_stAvatar;
  static QzmallCustomBanner cache_stCustomBanner;
  static QzmallCustomNavi cache_stCustomNavi = new QzmallCustomNavi();
  static QzmallCustomPlayer cache_stCustomPlayer;
  static QzmallCustomPraise cache_stCustomPraise = new QzmallCustomPraise();
  static QzmallCustomVip cache_stCustomVip = new QzmallCustomVip();
  static QzmallFacade cache_stFacade = new QzmallFacade();
  static QzmallFeedSkin cache_stFeedSkin;
  static QzmallFloat cache_stFloat;
  public QzmallAvatar stAvatar;
  public QzmallCustomBanner stCustomBanner;
  public QzmallCustomNavi stCustomNavi;
  public QzmallCustomPlayer stCustomPlayer;
  public QzmallCustomPraise stCustomPraise;
  public QzmallCustomVip stCustomVip;
  public QzmallFacade stFacade;
  public QzmallFeedSkin stFeedSkin;
  public QzmallFloat stFloat;
  
  static
  {
    cache_stCustomPlayer = new QzmallCustomPlayer();
    cache_stCustomBanner = new QzmallCustomBanner();
    cache_stAvatar = new QzmallAvatar();
    cache_stFloat = new QzmallFloat();
    cache_stFeedSkin = new QzmallFeedSkin();
  }
  
  public ProfileQzmallDeco() {}
  
  public ProfileQzmallDeco(QzmallCustomNavi paramQzmallCustomNavi, QzmallCustomPraise paramQzmallCustomPraise, QzmallCustomPlayer paramQzmallCustomPlayer, QzmallCustomBanner paramQzmallCustomBanner, QzmallAvatar paramQzmallAvatar, QzmallFloat paramQzmallFloat, QzmallFeedSkin paramQzmallFeedSkin, QzmallCustomVip paramQzmallCustomVip, QzmallFacade paramQzmallFacade)
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_QMALL_COVER.ProfileQzmallDeco
 * JD-Core Version:    0.7.0.1
 */