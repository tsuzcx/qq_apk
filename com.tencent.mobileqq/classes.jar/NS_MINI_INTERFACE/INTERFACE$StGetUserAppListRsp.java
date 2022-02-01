package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class INTERFACE$StGetUserAppListRsp
  extends MessageMicro<StGetUserAppListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<INTERFACE.StCacheController> cacheLst = PBField.initRepeatMessage(INTERFACE.StCacheController.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBRepeatMessageField<INTERFACE.StUserAppInfo> fixApps = PBField.initRepeatMessage(INTERFACE.StUserAppInfo.class);
  public final PBInt32Field isFinish = PBField.initInt32(0);
  public final PBRepeatMessageField<INTERFACE.StMotionPicInfo> motionPics = PBField.initRepeatMessage(INTERFACE.StMotionPicInfo.class);
  public final PBUInt32Field putTopCount = PBField.initUInt32(0);
  public final PBInt32Field showStore = PBField.initInt32(0);
  public final PBInt32Field showUserAppList = PBField.initInt32(0);
  public final PBInt64Field totalNum = PBField.initInt64(0L);
  public final PBRepeatMessageField<INTERFACE.StUserAppInfo> userAppList = PBField.initRepeatMessage(INTERFACE.StUserAppInfo.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 56, 64, 74, 82 }, new String[] { "extInfo", "userAppList", "totalNum", "isFinish", "cacheLst", "showStore", "putTopCount", "showUserAppList", "fixApps", "motionPics" }, new Object[] { null, null, Long.valueOf(0L), localInteger, null, localInteger, localInteger, localInteger, null, null }, StGetUserAppListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetUserAppListRsp
 * JD-Core Version:    0.7.0.1
 */