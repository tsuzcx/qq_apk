package NS_STORE_APP_SEARCH;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppSearch$StHotWatching
  extends MessageMicro<StHotWatching>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "hotWords", "url" }, new Object[] { "", "" }, StHotWatching.class);
  public final PBStringField hotWords = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_STORE_APP_SEARCH.MiniAppSearch.StHotWatching
 * JD-Core Version:    0.7.0.1
 */