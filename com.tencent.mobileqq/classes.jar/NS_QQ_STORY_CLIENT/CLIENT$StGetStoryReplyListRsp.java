package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM.StCommonExt;
import NS_QQ_STORY_META.META.StReply;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CLIENT$StGetStoryReplyListRsp
  extends MessageMicro<StGetStoryReplyListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "vecReply", "totalNum", "isFinish" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0) }, StGetStoryReplyListRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBUInt32Field isFinish = PBField.initUInt32(0);
  public final PBUInt32Field totalNum = PBField.initUInt32(0);
  public final PBRepeatMessageField<META.StReply> vecReply = PBField.initRepeatMessage(META.StReply.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QQ_STORY_CLIENT.CLIENT.StGetStoryReplyListRsp
 * JD-Core Version:    0.7.0.1
 */