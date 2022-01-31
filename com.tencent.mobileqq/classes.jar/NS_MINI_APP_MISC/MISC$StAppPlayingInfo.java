package NS_MINI_APP_MISC;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MISC$StAppPlayingInfo
  extends MessageMicro<StAppPlayingInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "playType", "myRank", "friendRank", "appMetaInfo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, StAppPlayingInfo.class);
  public INTERFACE.StApiAppInfo appMetaInfo = new INTERFACE.StApiAppInfo();
  public final PBUInt32Field friendRank = PBField.initUInt32(0);
  public final PBUInt32Field myRank = PBField.initUInt32(0);
  public final PBUInt32Field playType = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_APP_MISC.MISC.StAppPlayingInfo
 * JD-Core Version:    0.7.0.1
 */