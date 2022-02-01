package NS_MINI_BOOK_SHELF;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniBookShelf$StUpdateBookShelfReadTimeReq
  extends MessageMicro<StUpdateBookShelfReadTimeReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "appid", "category", "contentId" }, new Object[] { "", "", "" }, StUpdateBookShelfReadTimeReq.class);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField category = PBField.initString("");
  public final PBStringField contentId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_BOOK_SHELF.MiniBookShelf.StUpdateBookShelfReadTimeReq
 * JD-Core Version:    0.7.0.1
 */