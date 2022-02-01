package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class CLIENT$StGetWatermarkDictReq
  extends MessageMicro<StGetWatermarkDictReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField clientIP = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBDoubleField fLat = PBField.initDouble(0.0D);
  public final PBDoubleField fLon = PBField.initDouble(0.0D);
  
  static
  {
    Double localDouble = Double.valueOf(0.0D);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 17, 25, 34 }, new String[] { "extInfo", "fLat", "fLon", "clientIP" }, new Object[] { null, localDouble, localDouble, "" }, StGetWatermarkDictReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQ_STORY_CLIENT.CLIENT.StGetWatermarkDictReq
 * JD-Core Version:    0.7.0.1
 */