package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StMainPkgInfo
  extends MessageMicro<StMainPkgInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "fileId", "pages", "file_size", "file_md5" }, new Object[] { "", "", Integer.valueOf(0), "" }, StMainPkgInfo.class);
  public final PBStringField fileId = PBField.initString("");
  public final PBRepeatField<String> file_md5 = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBInt32Field file_size = PBField.initInt32(0);
  public final PBRepeatField<String> pages = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StMainPkgInfo
 * JD-Core Version:    0.7.0.1
 */