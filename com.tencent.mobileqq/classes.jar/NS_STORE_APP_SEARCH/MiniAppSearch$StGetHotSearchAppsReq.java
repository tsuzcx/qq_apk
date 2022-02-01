package NS_STORE_APP_SEARCH;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class MiniAppSearch$StGetHotSearchAppsReq
  extends MessageMicro<StGetHotSearchAppsReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "from" }, new Object[] { null, Integer.valueOf(1) }, StGetHotSearchAppsReq.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBEnumField from = PBField.initEnum(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_STORE_APP_SEARCH.MiniAppSearch.StGetHotSearchAppsReq
 * JD-Core Version:    0.7.0.1
 */