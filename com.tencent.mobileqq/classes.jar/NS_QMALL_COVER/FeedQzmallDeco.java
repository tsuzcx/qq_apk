package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FeedQzmallDeco
  extends JceStruct
{
  static QzmallCustomBubbleSkin cache_stBubbleSkin;
  static QzmallCustomPassivePraise cache_stCustomPassivePraise;
  static QzmallCustomPraise cache_stCustomPraise;
  static QzmallCustomVip cache_stCustomVip;
  static QzmallFacade cache_stFacade;
  static FacadeDIY cache_stFacadeDIY = new FacadeDIY();
  static QzmallFeedAvatar cache_stFeedAvatar = new QzmallFeedAvatar();
  static QzmallFeedSkin cache_stFeedSkin;
  static QzoneDescription cache_stQzDescription = new QzoneDescription();
  static ReturnToPraise cache_stReturnToPraise;
  static ActYellowDiamond cache_stYellowDiamond;
  public QzmallCustomBubbleSkin stBubbleSkin;
  public QzmallCustomPassivePraise stCustomPassivePraise;
  public QzmallCustomPraise stCustomPraise;
  public QzmallCustomVip stCustomVip;
  public QzmallFacade stFacade;
  public FacadeDIY stFacadeDIY;
  public QzmallFeedAvatar stFeedAvatar;
  public QzmallFeedSkin stFeedSkin;
  public QzoneDescription stQzDescription;
  public ReturnToPraise stReturnToPraise;
  public ActYellowDiamond stYellowDiamond;
  
  static
  {
    cache_stCustomVip = new QzmallCustomVip();
    cache_stCustomPassivePraise = new QzmallCustomPassivePraise();
    cache_stCustomPraise = new QzmallCustomPraise();
    cache_stFeedSkin = new QzmallFeedSkin();
    cache_stFacade = new QzmallFacade();
    cache_stBubbleSkin = new QzmallCustomBubbleSkin();
    cache_stYellowDiamond = new ActYellowDiamond();
    cache_stReturnToPraise = new ReturnToPraise();
  }
  
  public FeedQzmallDeco() {}
  
  public FeedQzmallDeco(QzmallFeedAvatar paramQzmallFeedAvatar, QzmallCustomVip paramQzmallCustomVip, QzmallCustomPassivePraise paramQzmallCustomPassivePraise, QzmallCustomPraise paramQzmallCustomPraise, QzmallFeedSkin paramQzmallFeedSkin, QzmallFacade paramQzmallFacade, QzmallCustomBubbleSkin paramQzmallCustomBubbleSkin, ActYellowDiamond paramActYellowDiamond, ReturnToPraise paramReturnToPraise, FacadeDIY paramFacadeDIY, QzoneDescription paramQzoneDescription)
  {
    this.stFeedAvatar = paramQzmallFeedAvatar;
    this.stCustomVip = paramQzmallCustomVip;
    this.stCustomPassivePraise = paramQzmallCustomPassivePraise;
    this.stCustomPraise = paramQzmallCustomPraise;
    this.stFeedSkin = paramQzmallFeedSkin;
    this.stFacade = paramQzmallFacade;
    this.stBubbleSkin = paramQzmallCustomBubbleSkin;
    this.stYellowDiamond = paramActYellowDiamond;
    this.stReturnToPraise = paramReturnToPraise;
    this.stFacadeDIY = paramFacadeDIY;
    this.stQzDescription = paramQzoneDescription;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stFeedAvatar = ((QzmallFeedAvatar)paramJceInputStream.read(cache_stFeedAvatar, 0, false));
    this.stCustomVip = ((QzmallCustomVip)paramJceInputStream.read(cache_stCustomVip, 1, false));
    this.stCustomPassivePraise = ((QzmallCustomPassivePraise)paramJceInputStream.read(cache_stCustomPassivePraise, 2, false));
    this.stCustomPraise = ((QzmallCustomPraise)paramJceInputStream.read(cache_stCustomPraise, 3, false));
    this.stFeedSkin = ((QzmallFeedSkin)paramJceInputStream.read(cache_stFeedSkin, 4, false));
    this.stFacade = ((QzmallFacade)paramJceInputStream.read(cache_stFacade, 5, false));
    this.stBubbleSkin = ((QzmallCustomBubbleSkin)paramJceInputStream.read(cache_stBubbleSkin, 6, false));
    this.stYellowDiamond = ((ActYellowDiamond)paramJceInputStream.read(cache_stYellowDiamond, 7, false));
    this.stReturnToPraise = ((ReturnToPraise)paramJceInputStream.read(cache_stReturnToPraise, 8, false));
    this.stFacadeDIY = ((FacadeDIY)paramJceInputStream.read(cache_stFacadeDIY, 9, false));
    this.stQzDescription = ((QzoneDescription)paramJceInputStream.read(cache_stQzDescription, 10, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stFeedAvatar != null) {
      paramJceOutputStream.write(this.stFeedAvatar, 0);
    }
    if (this.stCustomVip != null) {
      paramJceOutputStream.write(this.stCustomVip, 1);
    }
    if (this.stCustomPassivePraise != null) {
      paramJceOutputStream.write(this.stCustomPassivePraise, 2);
    }
    if (this.stCustomPraise != null) {
      paramJceOutputStream.write(this.stCustomPraise, 3);
    }
    if (this.stFeedSkin != null) {
      paramJceOutputStream.write(this.stFeedSkin, 4);
    }
    if (this.stFacade != null) {
      paramJceOutputStream.write(this.stFacade, 5);
    }
    if (this.stBubbleSkin != null) {
      paramJceOutputStream.write(this.stBubbleSkin, 6);
    }
    if (this.stYellowDiamond != null) {
      paramJceOutputStream.write(this.stYellowDiamond, 7);
    }
    if (this.stReturnToPraise != null) {
      paramJceOutputStream.write(this.stReturnToPraise, 8);
    }
    if (this.stFacadeDIY != null) {
      paramJceOutputStream.write(this.stFacadeDIY, 9);
    }
    if (this.stQzDescription != null) {
      paramJceOutputStream.write(this.stQzDescription, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.FeedQzmallDeco
 * JD-Core Version:    0.7.0.1
 */