package addcontacts;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;

public final class AccountSearchPb$Location
  extends MessageMicro<Location>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBDoubleField double_latitude = PBField.initDouble(0.0D);
  public final PBDoubleField double_longitude = PBField.initDouble(0.0D);
  
  static
  {
    Double localDouble = Double.valueOf(0.0D);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 9, 17 }, new String[] { "double_latitude", "double_longitude" }, new Object[] { localDouble, localDouble }, Location.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     addcontacts.AccountSearchPb.Location
 * JD-Core Version:    0.7.0.1
 */