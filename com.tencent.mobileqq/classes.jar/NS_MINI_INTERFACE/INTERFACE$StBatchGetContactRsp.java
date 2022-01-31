package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class INTERFACE$StBatchGetContactRsp
  extends MessageMicro<StBatchGetContactRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "contactList" }, new Object[] { null }, StBatchGetContactRsp.class);
  public final PBRepeatMessageField<INTERFACE.StContactInfo> contactList = PBField.initRepeatMessage(INTERFACE.StContactInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StBatchGetContactRsp
 * JD-Core Version:    0.7.0.1
 */