package NS_MINI_PUBLIC;

import NS_COMM.COMM.Entry;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Head$QAPPHead
  extends MessageMicro<QAPPHead>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 48, 58, 66, 72, 82, 90, 96, 104, 114, 122, 130, 138 }, new String[] { "str_userip", "str_module", "str_cmdname", "uint64_seq", "str_qua", "uint64_loglevel", "str_logdepth", "auth_info", "retcode", "retmsg", "extinfo", "reqFrm", "logSeq", "colorLink", "deviceInfo", "trace", "all_trace" }, new Object[] { "", "", "", Long.valueOf(0L), "", Long.valueOf(0L), "", null, Long.valueOf(0L), "", null, Integer.valueOf(1), Long.valueOf(0L), null, "", null, null }, QAPPHead.class);
  public Head.StAllLinkTrace all_trace = new Head.StAllLinkTrace();
  public Head.AuthInfo auth_info = new Head.AuthInfo();
  public Head.StColorLink colorLink = new Head.StColorLink();
  public final PBStringField deviceInfo = PBField.initString("");
  public final PBRepeatMessageField<COMM.Entry> extinfo = PBField.initRepeatMessage(COMM.Entry.class);
  public final PBUInt64Field logSeq = PBField.initUInt64(0L);
  public final PBEnumField reqFrm = PBField.initEnum(1);
  public final PBInt64Field retcode = PBField.initInt64(0L);
  public final PBStringField retmsg = PBField.initString("");
  public final PBStringField str_cmdname = PBField.initString("");
  public final PBStringField str_logdepth = PBField.initString("");
  public final PBStringField str_module = PBField.initString("");
  public final PBStringField str_qua = PBField.initString("");
  public final PBStringField str_userip = PBField.initString("");
  public Head.StLinkTrace trace = new Head.StLinkTrace();
  public final PBUInt64Field uint64_loglevel = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_PUBLIC.Head.QAPPHead
 * JD-Core Version:    0.7.0.1
 */