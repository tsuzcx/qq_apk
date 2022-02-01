package NS_MINI_APP_SEARCH;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SEARCH$StSearchMiniAppRsp
  extends MessageMicro<StSearchMiniAppRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "extInfo", "items", "hasmore", "highlightWords" }, new Object[] { null, null, Boolean.valueOf(false), "" }, StSearchMiniAppRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBBoolField hasmore = PBField.initBool(false);
  public final PBRepeatField<String> highlightWords = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatMessageField<SEARCH.StAppSearchItem> items = PBField.initRepeatMessage(SEARCH.StAppSearchItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_APP_SEARCH.SEARCH.StSearchMiniAppRsp
 * JD-Core Version:    0.7.0.1
 */