package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StFriendRanking
  extends MessageMicro<StFriendRanking>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42 }, new String[] { "gameInfo", "friendsNum", "rankingList", "hasmore", "animationPic" }, new Object[] { null, Integer.valueOf(0), null, Integer.valueOf(0), "" }, StFriendRanking.class);
  public final PBStringField animationPic = PBField.initString("");
  public final PBInt32Field friendsNum = PBField.initInt32(0);
  public INTERFACE.StUserAppInfo gameInfo = new INTERFACE.StUserAppInfo();
  public final PBInt32Field hasmore = PBField.initInt32(0);
  public final PBRepeatMessageField<INTERFACE.StRankingList> rankingList = PBField.initRepeatMessage(INTERFACE.StRankingList.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StFriendRanking
 * JD-Core Version:    0.7.0.1
 */