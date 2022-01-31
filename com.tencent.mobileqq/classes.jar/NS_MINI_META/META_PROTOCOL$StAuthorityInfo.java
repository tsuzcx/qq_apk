package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class META_PROTOCOL$StAuthorityInfo
  extends MessageMicro<StAuthorityInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64 }, new String[] { "develop", "experience", "loginAdmin", "dataAnalyze", "developManage", "developSetup", "pauseService", "gameOperate" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StAuthorityInfo.class);
  public final PBUInt32Field dataAnalyze = PBField.initUInt32(0);
  public final PBUInt32Field develop = PBField.initUInt32(0);
  public final PBUInt32Field developManage = PBField.initUInt32(0);
  public final PBUInt32Field developSetup = PBField.initUInt32(0);
  public final PBUInt32Field experience = PBField.initUInt32(0);
  public final PBUInt32Field gameOperate = PBField.initUInt32(0);
  public final PBUInt32Field loginAdmin = PBField.initUInt32(0);
  public final PBUInt32Field pauseService = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_META.META_PROTOCOL.StAuthorityInfo
 * JD-Core Version:    0.7.0.1
 */