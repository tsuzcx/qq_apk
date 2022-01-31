package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StCheckDownloadRightReq
  extends MessageMicro<StCheckDownloadRightReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "link" }, new Object[] { null, "" }, StCheckDownloadRightReq.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField link = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StCheckDownloadRightReq
 * JD-Core Version:    0.7.0.1
 */