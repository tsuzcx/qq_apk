package NS_QQ_STORY_META;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class META$StCommonCmdAndBuf
  extends MessageMicro<StCommonCmdAndBuf>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiBuf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField cmd = PBField.initEnum(1);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "cmd", "busiBuf" }, new Object[] { Integer.valueOf(1), localByteStringMicro }, StCommonCmdAndBuf.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQ_STORY_META.META.StCommonCmdAndBuf
 * JD-Core Version:    0.7.0.1
 */