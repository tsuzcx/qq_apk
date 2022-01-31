package NS_STORE_APP_SEARCH;

import NS_COMM.COMM.StCommonExt;
import NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StoreAppInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppSearch$StGetHotSearchAppsRsp
  extends MessageMicro<StGetHotSearchAppsRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 34 }, new String[] { "extInfo", "title", "appList" }, new Object[] { null, "", null }, StGetHotSearchAppsRsp.class);
  public final PBRepeatMessageField<STORE_APP_CLIENT.StoreAppInfo> appList = PBField.initRepeatMessage(STORE_APP_CLIENT.StoreAppInfo.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_STORE_APP_SEARCH.MiniAppSearch.StGetHotSearchAppsRsp
 * JD-Core Version:    0.7.0.1
 */