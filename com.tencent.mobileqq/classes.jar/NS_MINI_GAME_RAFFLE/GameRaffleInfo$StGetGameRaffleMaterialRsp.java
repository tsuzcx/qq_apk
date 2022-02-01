package NS_MINI_GAME_RAFFLE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GameRaffleInfo$StGetGameRaffleMaterialRsp
  extends MessageMicro<StGetGameRaffleMaterialRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field active_id = PBField.initUInt32(0);
  public final PBStringField backBtn = PBField.initString("");
  public final PBStringField openedPackImg = PBField.initString("");
  public final PBUInt32Field promotion_id = PBField.initUInt32(0);
  public final PBStringField raffleImg = PBField.initString("");
  public final PBEnumField ret = PBField.initEnum(0);
  public final PBStringField shareBtn = PBField.initString("");
  public final PBStringField shareImg = PBField.initString("");
  public final PBStringField watchAdBtn = PBField.initString("");
  public final PBStringField wishingImg = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 64, 72, 82 }, new String[] { "ret", "raffleImg", "shareImg", "shareBtn", "openedPackImg", "backBtn", "wishingImg", "promotion_id", "active_id", "watchAdBtn" }, new Object[] { localInteger, "", "", "", "", "", "", localInteger, localInteger, "" }, StGetGameRaffleMaterialRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_GAME_RAFFLE.GameRaffleInfo.StGetGameRaffleMaterialRsp
 * JD-Core Version:    0.7.0.1
 */