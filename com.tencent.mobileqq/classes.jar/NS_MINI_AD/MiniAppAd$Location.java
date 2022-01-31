package NS_MINI_AD;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MiniAppAd$Location
  extends MessageMicro<Location>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "latitude", "longitude", "coordinates_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Location.class);
  public final PBUInt32Field coordinates_type = PBField.initUInt32(0);
  public final PBInt32Field latitude = PBField.initInt32(0);
  public final PBInt32Field longitude = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_AD.MiniAppAd.Location
 * JD-Core Version:    0.7.0.1
 */