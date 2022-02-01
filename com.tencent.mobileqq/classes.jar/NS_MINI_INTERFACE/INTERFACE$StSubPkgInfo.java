package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StSubPkgInfo
  extends MessageMicro<StSubPkgInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField dowLoadUrl = PBField.initString("");
  public final PBInt32Field file_size = PBField.initInt32(0);
  public final PBInt32Field independent = PBField.initInt32(0);
  public final PBStringField subPkgName = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "subPkgName", "dowLoadUrl", "independent", "file_size" }, new Object[] { "", "", localInteger, localInteger }, StSubPkgInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StSubPkgInfo
 * JD-Core Version:    0.7.0.1
 */