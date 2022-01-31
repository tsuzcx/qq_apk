package NS_MINI_APP_SEARCH;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class SEARCH$StAppSearchItem
  extends MessageMicro<StAppSearchItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "appid", "appname", "appIcon", "desc", "showMask" }, new Object[] { "", "", "", "", Integer.valueOf(0) }, StAppSearchItem.class);
  public final PBStringField appIcon = PBField.initString("");
  public final PBStringField appid = PBField.initString("");
  public final PBStringField appname = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public final PBInt32Field showMask = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_APP_SEARCH.SEARCH.StAppSearchItem
 * JD-Core Version:    0.7.0.1
 */