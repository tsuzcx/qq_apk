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
  public QzmallCustomBubbleSkin stBubbleSkin = null;
  public QzmallCustomPassivePraise stCustomPassivePraise = null;
  public QzmallCustomPraise stCustomPraise = null;
  public QzmallCustomVip stCustomVip = null;
  public QzmallFacade stFacade = null;
  public FacadeDIY stFacadeDIY = null;
  public QzmallFeedAvatar stFeedAvatar = null;
  public QzmallFeedSkin stFeedSkin = null;
  public QzoneDescription stQzDescription = null;
  public ReturnToPraise stReturnToPraise = null;
  public ActYellowDiamond stYellowDiamond = null;
  
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
    Object localObject = this.stFeedAvatar;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.stCustomVip;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.stCustomPassivePraise;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.stCustomPraise;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.stFeedSkin;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
    localObject = this.stFacade;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    localObject = this.stBubbleSkin;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 6);
    }
    localObject = this.stYellowDiamond;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 7);
    }
    localObject = this.stReturnToPraise;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 8);
    }
    localObject = this.stFacadeDIY;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
    localObject = this.stQzDescription;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QMALL_COVER.FeedQzmallDeco
 * JD-Core Version:    0.7.0.1
 */