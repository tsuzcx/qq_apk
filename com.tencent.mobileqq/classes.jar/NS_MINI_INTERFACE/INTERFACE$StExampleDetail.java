package NS_MINI_INTERFACE;

import NS_COMM.COMM.Entry;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StExampleDetail
  extends MessageMicro<StExampleDetail>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "title", "contents" }, new Object[] { "", null }, StExampleDetail.class);
  public final PBRepeatMessageField<COMM.Entry> contents = PBField.initRepeatMessage(COMM.Entry.class);
  public final PBStringField title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StExampleDetail
 * JD-Core Version:    0.7.0.1
 */