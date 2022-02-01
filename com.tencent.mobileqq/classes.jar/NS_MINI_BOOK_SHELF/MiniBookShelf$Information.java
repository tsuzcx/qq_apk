package NS_MINI_BOOK_SHELF;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MiniBookShelf$Information
  extends MessageMicro<Information>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField contentId = PBField.initString("");
  public final PBEnumField existStatus = PBField.initEnum(0);
  public final PBStringField msg = PBField.initString("");
  public final PBUInt32Field status = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "contentId", "status", "msg", "existStatus" }, new Object[] { "", localInteger, "", localInteger }, Information.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_BOOK_SHELF.MiniBookShelf.Information
 * JD-Core Version:    0.7.0.1
 */