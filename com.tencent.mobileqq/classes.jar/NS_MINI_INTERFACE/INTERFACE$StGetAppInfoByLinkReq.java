package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StGetAppInfoByLinkReq
  extends MessageMicro<StGetAppInfoByLinkReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "link", "linkType" }, new Object[] { null, "", Integer.valueOf(0) }, StGetAppInfoByLinkReq.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField link = PBField.initString("");
  public final PBInt32Field linkType = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByLinkReq
 * JD-Core Version:    0.7.0.1
 */