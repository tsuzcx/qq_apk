package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class INTERFACE$StGetExpandAppListRsp
  extends MessageMicro<StGetExpandAppListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field cacheTime = PBField.initUInt32(0);
  public final PBRepeatMessageField<INTERFACE.StExpandItem> expandItemList = PBField.initRepeatMessage(INTERFACE.StExpandItem.class);
  public final PBStringField expandTitle = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBUInt32Field totalNum = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "extInfo", "expandTitle", "expandItemList", "totalNum", "cacheTime" }, new Object[] { null, "", null, localInteger, localInteger }, StGetExpandAppListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetExpandAppListRsp
 * JD-Core Version:    0.7.0.1
 */