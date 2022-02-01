package NS_MINI_AD;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MiniAppAd$ContextInfo
  extends MessageMicro<ContextInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field article_id = PBField.initUInt64(0L);
  public final PBRepeatField<Long> existed_mini_program_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBBytesField page_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field public_id = PBField.initUInt64(0L);
  public final PBUInt32Field source_from = PBField.initUInt32(0);
  public final PBUInt32Field tribe_id_tag = PBField.initUInt32(0);
  public final PBUInt32Field tribe_tag = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56 }, new String[] { "public_id", "article_id", "tribe_tag", "tribe_id_tag", "source_from", "page_url", "existed_mini_program_ids" }, new Object[] { localLong, localLong, localInteger, localInteger, localInteger, localByteStringMicro, localLong }, ContextInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_AD.MiniAppAd.ContextInfo
 * JD-Core Version:    0.7.0.1
 */