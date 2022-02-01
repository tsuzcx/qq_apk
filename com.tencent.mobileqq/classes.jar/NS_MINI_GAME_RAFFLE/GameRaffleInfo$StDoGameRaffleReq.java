package NS_MINI_GAME_RAFFLE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GameRaffleInfo$StDoGameRaffleReq
  extends MessageMicro<StDoGameRaffleReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "appid", "uin" }, new Object[] { "", "" }, StDoGameRaffleReq.class);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_GAME_RAFFLE.GameRaffleInfo.StDoGameRaffleReq
 * JD-Core Version:    0.7.0.1
 */