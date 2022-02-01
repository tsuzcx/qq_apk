import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ScBypassCb$StScBypassCbRsp
  extends MessageMicro<StScBypassCbRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret", "errmsg" }, new Object[] { Integer.valueOf(0), "" }, StScBypassCbRsp.class);
  public final PBStringField errmsg = PBField.initString("");
  public final PBUInt32Field ret = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ScBypassCb.StScBypassCbRsp
 * JD-Core Version:    0.7.0.1
 */