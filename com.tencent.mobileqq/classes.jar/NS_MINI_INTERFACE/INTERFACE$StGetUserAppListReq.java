package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class INTERFACE$StGetUserAppListReq
  extends MessageMicro<StGetUserAppListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "extInfo", "uin", "num", "source" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, StGetUserAppListReq.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBUInt64Field num = PBField.initUInt64(0L);
  public final PBInt32Field source = PBField.initInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetUserAppListReq
 * JD-Core Version:    0.7.0.1
 */