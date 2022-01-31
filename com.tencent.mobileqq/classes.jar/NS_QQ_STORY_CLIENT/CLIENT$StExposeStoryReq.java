package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class CLIENT$StExposeStoryReq
  extends MessageMicro<StExposeStoryReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "feedPosterUin", "feedId" }, new Object[] { null, "", "" }, StExposeStoryReq.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField feedId = PBField.initString("");
  public final PBStringField feedPosterUin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QQ_STORY_CLIENT.CLIENT.StExposeStoryReq
 * JD-Core Version:    0.7.0.1
 */