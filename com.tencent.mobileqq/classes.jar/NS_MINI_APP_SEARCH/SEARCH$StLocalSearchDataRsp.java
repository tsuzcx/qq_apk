package NS_MINI_APP_SEARCH;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SEARCH$StLocalSearchDataRsp
  extends MessageMicro<StLocalSearchDataRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "extInfo", "status", "items" }, new Object[] { null, Integer.valueOf(0), null }, StLocalSearchDataRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBRepeatMessageField<SEARCH.StAppSearchItem> items = PBField.initRepeatMessage(SEARCH.StAppSearchItem.class);
  public final PBInt32Field status = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_APP_SEARCH.SEARCH.StLocalSearchDataRsp
 * JD-Core Version:    0.7.0.1
 */