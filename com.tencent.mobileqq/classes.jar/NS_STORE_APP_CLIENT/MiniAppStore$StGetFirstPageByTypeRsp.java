package NS_STORE_APP_CLIENT;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class MiniAppStore$StGetFirstPageByTypeRsp
  extends MessageMicro<StGetFirstPageByTypeRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "vecAppInfo", "vecAppRecommendCard" }, new Object[] { null, null, null }, StGetFirstPageByTypeRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBRepeatMessageField<INTERFACE.StUserAppInfo> vecAppInfo = PBField.initRepeatMessage(INTERFACE.StUserAppInfo.class);
  public final PBRepeatMessageField<MiniAppStore.StAppRecommendCard> vecAppRecommendCard = PBField.initRepeatMessage(MiniAppStore.StAppRecommendCard.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_STORE_APP_CLIENT.MiniAppStore.StGetFirstPageByTypeRsp
 * JD-Core Version:    0.7.0.1
 */