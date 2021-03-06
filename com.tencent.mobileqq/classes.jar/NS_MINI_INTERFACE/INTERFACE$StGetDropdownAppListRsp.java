package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class INTERFACE$StGetDropdownAppListRsp
  extends MessageMicro<StGetDropdownAppListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<INTERFACE.StCacheController> cacheLst = PBField.initRepeatMessage(INTERFACE.StCacheController.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBRepeatMessageField<INTERFACE.StUserAppInfo> fixApps = PBField.initRepeatMessage(INTERFACE.StUserAppInfo.class);
  public final PBInt32Field freshInternal = PBField.initInt32(0);
  public final PBInt32Field isFinished = PBField.initInt32(0);
  public final PBRepeatMessageField<INTERFACE.StModuleInfo> modules = PBField.initRepeatMessage(INTERFACE.StModuleInfo.class);
  public INTERFACE.StOperationApp operationApp = new INTERFACE.StOperationApp();
  public final PBInt32Field realRecommdInternal = PBField.initInt32(0);
  public INTERFACE.StSearchModuleInfo searchInfo = new INTERFACE.StSearchModuleInfo();
  public final PBInt32Field showStore = PBField.initInt32(0);
  public final PBInt32Field showUserAppList = PBField.initInt32(0);
  public final PBInt32Field useOld = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50, 56, 64, 72, 82, 88, 98 }, new String[] { "extInfo", "modules", "cacheLst", "showStore", "showUserAppList", "fixApps", "isFinished", "freshInternal", "realRecommdInternal", "searchInfo", "useOld", "operationApp" }, new Object[] { null, null, null, localInteger, localInteger, null, localInteger, localInteger, localInteger, null, localInteger, null }, StGetDropdownAppListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetDropdownAppListRsp
 * JD-Core Version:    0.7.0.1
 */