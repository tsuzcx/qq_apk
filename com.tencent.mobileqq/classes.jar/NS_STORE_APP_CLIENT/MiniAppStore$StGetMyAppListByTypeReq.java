package NS_STORE_APP_CLIENT;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MiniAppStore$StGetMyAppListByTypeReq
  extends MessageMicro<StGetMyAppListByTypeReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBUInt32Field uiAppType = PBField.initUInt32(0);
  public final PBUInt32Field uiListType = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "extInfo", "uiAppType", "uiListType" }, new Object[] { null, localInteger, localInteger }, StGetMyAppListByTypeReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_STORE_APP_CLIENT.MiniAppStore.StGetMyAppListByTypeReq
 * JD-Core Version:    0.7.0.1
 */