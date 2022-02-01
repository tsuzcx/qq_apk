package NS_MINI_APP_SEARCH;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class SEARCH$StSearchMiniAppReq
  extends MessageMicro<StSearchMiniAppReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "query", "pageSize" }, new Object[] { null, "", Integer.valueOf(0) }, StSearchMiniAppReq.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBInt32Field pageSize = PBField.initInt32(0);
  public final PBStringField query = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_APP_SEARCH.SEARCH.StSearchMiniAppReq
 * JD-Core Version:    0.7.0.1
 */