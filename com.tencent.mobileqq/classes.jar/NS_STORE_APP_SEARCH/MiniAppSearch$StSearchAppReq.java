package NS_STORE_APP_SEARCH;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppSearch$StSearchAppReq
  extends MessageMicro<StSearchAppReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "query", "appType", "from" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(1) }, StSearchAppReq.class);
  public final PBEnumField appType = PBField.initEnum(0);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBEnumField from = PBField.initEnum(1);
  public final PBStringField query = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_STORE_APP_SEARCH.MiniAppSearch.StSearchAppReq
 * JD-Core Version:    0.7.0.1
 */