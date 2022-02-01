package NS_MINI_BOOK_SHELF;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class MiniBookShelf$StInsertBookShelfRsp
  extends MessageMicro<StInsertBookShelfRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "info" }, new Object[] { null }, StInsertBookShelfRsp.class);
  public final PBRepeatMessageField<MiniBookShelf.Information> info = PBField.initRepeatMessage(MiniBookShelf.Information.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_BOOK_SHELF.MiniBookShelf.StInsertBookShelfRsp
 * JD-Core Version:    0.7.0.1
 */