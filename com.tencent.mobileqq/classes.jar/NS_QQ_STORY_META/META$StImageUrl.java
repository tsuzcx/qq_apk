package NS_QQ_STORY_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class META$StImageUrl
  extends MessageMicro<StImageUrl>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field height = PBField.initUInt32(0);
  public final PBUInt32Field levelType = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
  public final PBUInt32Field width = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "levelType", "url", "width", "height" }, new Object[] { localInteger, "", localInteger, localInteger }, StImageUrl.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQ_STORY_META.META.StImageUrl
 * JD-Core Version:    0.7.0.1
 */