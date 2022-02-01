package NS_QQ_STORY_CONFIG;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class CONFIG$StGetStoryConfigRsp
  extends MessageMicro<StGetStoryConfigRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "intConf" }, new Object[] { null, null }, StGetStoryConfigRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBRepeatMessageField<CONFIG.StIntConf> intConf = PBField.initRepeatMessage(CONFIG.StIntConf.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQ_STORY_CONFIG.CONFIG.StGetStoryConfigRsp
 * JD-Core Version:    0.7.0.1
 */