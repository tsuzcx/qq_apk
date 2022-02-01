package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class CLIENT$StGetWatermarkDictRsp
  extends MessageMicro<StGetWatermarkDictRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "vecWatermarkDict" }, new Object[] { null, null }, StGetWatermarkDictRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBRepeatMessageField<CLIENT.StWatermarkDict> vecWatermarkDict = PBField.initRepeatMessage(CLIENT.StWatermarkDict.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQ_STORY_CLIENT.CLIENT.StGetWatermarkDictRsp
 * JD-Core Version:    0.7.0.1
 */