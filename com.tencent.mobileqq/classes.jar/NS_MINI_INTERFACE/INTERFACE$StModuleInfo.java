package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StModuleInfo
  extends MessageMicro<StModuleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 56, 66, 74, 80, 90, 98, 106, 112, 122, 128 }, new String[] { "title", "userAppList", "moduleType", "useOld", "jumpMoreApp", "isFinished", "appTotalNum", "desc", "ranks", "freshInternal", "titleIcon", "backgroundPic", "dittoDsl", "subTypes", "jumpLink", "PopupType" }, new Object[] { "", null, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), "", null, Integer.valueOf(0), "", "", "", Integer.valueOf(0), "", Integer.valueOf(0) }, StModuleInfo.class);
  public final PBEnumField PopupType = PBField.initEnum(0);
  public final PBInt32Field appTotalNum = PBField.initInt32(0);
  public final PBStringField backgroundPic = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public final PBStringField dittoDsl = PBField.initString("");
  public final PBInt32Field freshInternal = PBField.initInt32(0);
  public final PBInt32Field isFinished = PBField.initInt32(0);
  public final PBStringField jumpLink = PBField.initString("");
  public INTERFACE.StUserAppInfo jumpMoreApp = new INTERFACE.StUserAppInfo();
  public final PBInt32Field moduleType = PBField.initInt32(0);
  public final PBRepeatMessageField<INTERFACE.StFriendRanking> ranks = PBField.initRepeatMessage(INTERFACE.StFriendRanking.class);
  public final PBInt32Field subTypes = PBField.initInt32(0);
  public final PBStringField title = PBField.initString("");
  public final PBStringField titleIcon = PBField.initString("");
  public final PBInt32Field useOld = PBField.initInt32(0);
  public final PBRepeatMessageField<INTERFACE.StUserAppInfo> userAppList = PBField.initRepeatMessage(INTERFACE.StUserAppInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StModuleInfo
 * JD-Core Version:    0.7.0.1
 */