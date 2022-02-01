import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ScBypassCb$StScBypassCbReq
  extends MessageMicro<StScBypassCbReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBUInt32Field beat_common = PBField.initUInt32(0);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public final PBUInt32Field hitReason = PBField.initUInt32(0);
  public final PBStringField msgid = PBField.initString("");
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  public final PBUInt32Field src = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56 }, new String[] { "msgid", "puin", "cmd", "hitReason", "beat_common", "appid", "src" }, new Object[] { "", Long.valueOf(0L), localInteger, localInteger, localInteger, localInteger, localInteger }, StScBypassCbReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ScBypassCb.StScBypassCbReq
 * JD-Core Version:    0.7.0.1
 */