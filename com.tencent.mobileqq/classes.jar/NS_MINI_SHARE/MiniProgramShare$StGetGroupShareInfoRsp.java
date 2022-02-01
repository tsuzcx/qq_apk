package NS_MINI_SHARE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniProgramShare$StGetGroupShareInfoRsp
  extends MessageMicro<StGetGroupShareInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "encryptedData", "iv" }, new Object[] { null, "", "" }, StGetGroupShareInfoRsp.class);
  public final PBStringField encryptedData = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField iv = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_SHARE.MiniProgramShare.StGetGroupShareInfoRsp
 * JD-Core Version:    0.7.0.1
 */