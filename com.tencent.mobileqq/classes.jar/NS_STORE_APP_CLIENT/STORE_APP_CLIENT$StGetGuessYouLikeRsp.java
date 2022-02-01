package NS_STORE_APP_CLIENT;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class STORE_APP_CLIENT$StGetGuessYouLikeRsp
  extends MessageMicro<StGetGuessYouLikeRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "appList", "isFinish" }, new Object[] { null, null, Integer.valueOf(0) }, StGetGuessYouLikeRsp.class);
  public final PBRepeatMessageField<STORE_APP_CLIENT.StoreAppInfo> appList = PBField.initRepeatMessage(STORE_APP_CLIENT.StoreAppInfo.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBInt32Field isFinish = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StGetGuessYouLikeRsp
 * JD-Core Version:    0.7.0.1
 */