package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StApiRightController
  extends MessageMicro<StApiRightController>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "whiteLst", "blackLst", "secondApiRights" }, new Object[] { "", "", null }, StApiRightController.class);
  public final PBRepeatField<String> blackLst = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatMessageField<INTERFACE.StApiRightItem> secondApiRights = PBField.initRepeatMessage(INTERFACE.StApiRightItem.class);
  public final PBRepeatField<String> whiteLst = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StApiRightController
 * JD-Core Version:    0.7.0.1
 */