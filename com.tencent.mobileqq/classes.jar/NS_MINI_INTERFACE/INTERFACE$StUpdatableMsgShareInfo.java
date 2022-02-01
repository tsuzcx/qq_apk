package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class INTERFACE$StUpdatableMsgShareInfo
  extends MessageMicro<StUpdatableMsgShareInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "scene", "groupId", "chatUin", "subScene" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0) }, StUpdatableMsgShareInfo.class);
  public final PBStringField chatUin = PBField.initString("");
  public final PBStringField groupId = PBField.initString("");
  public final PBUInt32Field scene = PBField.initUInt32(0);
  public final PBUInt32Field subScene = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StUpdatableMsgShareInfo
 * JD-Core Version:    0.7.0.1
 */