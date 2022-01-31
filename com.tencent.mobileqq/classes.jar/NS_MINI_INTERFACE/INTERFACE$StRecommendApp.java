package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StRecommendApp
  extends MessageMicro<StRecommendApp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "appId", "exposuredNum", "pullTime" }, new Object[] { "", Integer.valueOf(0), Long.valueOf(0L) }, StRecommendApp.class);
  public final PBStringField appId = PBField.initString("");
  public final PBInt32Field exposuredNum = PBField.initInt32(0);
  public final PBInt64Field pullTime = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StRecommendApp
 * JD-Core Version:    0.7.0.1
 */