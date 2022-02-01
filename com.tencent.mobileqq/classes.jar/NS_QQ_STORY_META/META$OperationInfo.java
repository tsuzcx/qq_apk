package NS_QQ_STORY_META;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class META$OperationInfo
  extends MessageMicro<OperationInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "extInfo", "opActionType", "opUser", "opTime" }, new Object[] { null, Integer.valueOf(1), null, Integer.valueOf(0) }, OperationInfo.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBEnumField opActionType = PBField.initEnum(1);
  public final PBUInt32Field opTime = PBField.initUInt32(0);
  public META.StUser opUser = new META.StUser();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQ_STORY_META.META.OperationInfo
 * JD-Core Version:    0.7.0.1
 */