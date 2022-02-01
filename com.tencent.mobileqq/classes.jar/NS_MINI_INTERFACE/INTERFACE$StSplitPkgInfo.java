package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StSplitPkgInfo
  extends MessageMicro<StSplitPkgInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField fileId = PBField.initString("");
  public final PBInt32Field file_size = PBField.initInt32(0);
  public final PBInt32Field independent = PBField.initInt32(0);
  public final PBRepeatField<String> pages = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField subPkgName = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "subPkgName", "fileId", "independent", "pages", "file_size" }, new Object[] { "", "", localInteger, "", localInteger }, StSplitPkgInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StSplitPkgInfo
 * JD-Core Version:    0.7.0.1
 */