package NS_STORE_APP_CLIENT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class STORE_APP_CLIENT$StRankingList
  extends MessageMicro<StRankingList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField avatar = PBField.initString("");
  public final PBStringField nick = PBField.initString("");
  public final PBInt32Field ranks = PBField.initInt32(0);
  public final PBInt32Field score = PBField.initInt32(0);
  public final PBStringField uid = PBField.initString("");
  public final PBStringField unit = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50 }, new String[] { "nick", "avatar", "ranks", "score", "unit", "uid" }, new Object[] { "", "", localInteger, localInteger, "", "" }, StRankingList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StRankingList
 * JD-Core Version:    0.7.0.1
 */