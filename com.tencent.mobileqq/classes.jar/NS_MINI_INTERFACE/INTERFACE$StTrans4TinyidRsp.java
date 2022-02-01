package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class INTERFACE$StTrans4TinyidRsp
  extends MessageMicro<StTrans4TinyidRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "tinyidOpenids" }, new Object[] { null }, StTrans4TinyidRsp.class);
  public final PBRepeatMessageField<INTERFACE.StTinyidOpenidPair> tinyidOpenids = PBField.initRepeatMessage(INTERFACE.StTinyidOpenidPair.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StTrans4TinyidRsp
 * JD-Core Version:    0.7.0.1
 */