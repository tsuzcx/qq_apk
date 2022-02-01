package NS_STORE_APP_SEARCH;

import NS_COMM.COMM.StCommonExt;
import NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StoreAppInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppSearch$StGetHotSearchAppsRsp
  extends MessageMicro<StGetHotSearchAppsRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<STORE_APP_CLIENT.StoreAppInfo> appList = PBField.initRepeatMessage(STORE_APP_CLIENT.StoreAppInfo.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField guessTitle = PBField.initString("");
  public final PBRepeatMessageField<STORE_APP_CLIENT.StoreAppInfo> guessYouList = PBField.initRepeatMessage(STORE_APP_CLIENT.StoreAppInfo.class);
  public final PBEnumField sort = PBField.initEnum(0);
  public final PBRepeatField<Integer> sortList = PBField.initRepeat(PBEnumField.__repeatHelper__);
  public final PBStringField title = PBField.initString("");
  public final PBStringField watchTitle = PBField.initString("");
  public final PBRepeatMessageField<MiniAppSearch.StHotWatching> watchingList = PBField.initRepeatMessage(MiniAppSearch.StHotWatching.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 34, 42, 50, 56, 66, 74, 80 }, new String[] { "extInfo", "title", "appList", "watchTitle", "watchingList", "sort", "guessYouList", "guessTitle", "sortList" }, new Object[] { null, "", null, "", null, localInteger, null, "", localInteger }, StGetHotSearchAppsRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_STORE_APP_SEARCH.MiniAppSearch.StGetHotSearchAppsRsp
 * JD-Core Version:    0.7.0.1
 */