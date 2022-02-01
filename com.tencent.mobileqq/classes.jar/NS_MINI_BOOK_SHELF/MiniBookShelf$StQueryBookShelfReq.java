package NS_MINI_BOOK_SHELF;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniBookShelf$StQueryBookShelfReq
  extends MessageMicro<StQueryBookShelfReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "appid", "contentIds" }, new Object[] { "", "" }, StQueryBookShelfReq.class);
  public final PBStringField appid = PBField.initString("");
  public final PBRepeatField<String> contentIds = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_BOOK_SHELF.MiniBookShelf.StQueryBookShelfReq
 * JD-Core Version:    0.7.0.1
 */