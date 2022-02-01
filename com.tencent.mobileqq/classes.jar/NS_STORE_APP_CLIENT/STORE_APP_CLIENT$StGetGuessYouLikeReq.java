package NS_STORE_APP_CLIENT;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class STORE_APP_CLIENT$StGetGuessYouLikeReq
  extends MessageMicro<StGetGuessYouLikeReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "count" }, new Object[] { null, Integer.valueOf(0) }, StGetGuessYouLikeReq.class);
  public final PBInt32Field count = PBField.initInt32(0);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StGetGuessYouLikeReq
 * JD-Core Version:    0.7.0.1
 */