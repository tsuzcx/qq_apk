package NS_MINI_GAME_RAFFLE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GameRaffleInfo$StDoGameRaffleRsp
  extends MessageMicro<StDoGameRaffleRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "state", "pack", "onlinePrizeImg", "active_id" }, new Object[] { Integer.valueOf(0), null, "", Integer.valueOf(0) }, StDoGameRaffleRsp.class);
  public final PBUInt32Field active_id = PBField.initUInt32(0);
  public final PBStringField onlinePrizeImg = PBField.initString("");
  public GameRaffleInfo.Pack pack = new GameRaffleInfo.Pack();
  public final PBEnumField state = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_GAME_RAFFLE.GameRaffleInfo.StDoGameRaffleRsp
 * JD-Core Version:    0.7.0.1
 */