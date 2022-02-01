package NS_MINI_APP_MISC;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MISC$StAppPlayingInfo
  extends MessageMicro<StAppPlayingInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public INTERFACE.StApiAppInfo appMetaInfo = new INTERFACE.StApiAppInfo();
  public final PBUInt32Field friendRank = PBField.initUInt32(0);
  public final PBUInt32Field myRank = PBField.initUInt32(0);
  public final PBUInt32Field playType = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "playType", "myRank", "friendRank", "appMetaInfo" }, new Object[] { localInteger, localInteger, localInteger, null }, StAppPlayingInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_APP_MISC.MISC.StAppPlayingInfo
 * JD-Core Version:    0.7.0.1
 */