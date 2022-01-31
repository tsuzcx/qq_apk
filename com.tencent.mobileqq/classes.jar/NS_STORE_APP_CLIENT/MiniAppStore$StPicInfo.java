package NS_STORE_APP_CLIENT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MiniAppStore$StPicInfo
  extends MessageMicro<StPicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "strUrl", "uiWidth", "uiHeight" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, StPicInfo.class);
  public final PBStringField strUrl = PBField.initString("");
  public final PBUInt32Field uiHeight = PBField.initUInt32(0);
  public final PBUInt32Field uiWidth = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_STORE_APP_CLIENT.MiniAppStore.StPicInfo
 * JD-Core Version:    0.7.0.1
 */