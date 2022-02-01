package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class INTERFACE$StUpdatableMsgShareInfo
  extends MessageMicro<StUpdatableMsgShareInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField chatUin = PBField.initString("");
  public final PBStringField groupId = PBField.initString("");
  public final PBUInt32Field scene = PBField.initUInt32(0);
  public final PBUInt32Field subScene = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "scene", "groupId", "chatUin", "subScene" }, new Object[] { localInteger, "", "", localInteger }, StUpdatableMsgShareInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StUpdatableMsgShareInfo
 * JD-Core Version:    0.7.0.1
 */