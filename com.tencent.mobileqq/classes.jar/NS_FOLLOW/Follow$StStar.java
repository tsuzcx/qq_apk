package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class Follow$StStar
  extends MessageMicro<StStar>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 17 }, new String[] { "star", "weight" }, new Object[] { "", Double.valueOf(0.0D) }, StStar.class);
  public final PBStringField star = PBField.initString("");
  public final PBDoubleField weight = PBField.initDouble(0.0D);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_FOLLOW.Follow.StStar
 * JD-Core Version:    0.7.0.1
 */