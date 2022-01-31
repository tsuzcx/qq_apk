package NS_STORE_APP_CLIENT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MiniAppStore$StVideoInfo
  extends MessageMicro<StVideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48 }, new String[] { "strVideoUrl", "strCoverUrl", "uiDuration", "uiWidth", "uiHeight", "uiSize" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StVideoInfo.class);
  public final PBStringField strCoverUrl = PBField.initString("");
  public final PBStringField strVideoUrl = PBField.initString("");
  public final PBUInt32Field uiDuration = PBField.initUInt32(0);
  public final PBUInt32Field uiHeight = PBField.initUInt32(0);
  public final PBUInt32Field uiSize = PBField.initUInt32(0);
  public final PBUInt32Field uiWidth = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_STORE_APP_CLIENT.MiniAppStore.StVideoInfo
 * JD-Core Version:    0.7.0.1
 */