package NS_STORE_APP_CLIENT;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class MiniAppStore$StGetRecommendCardDetailRsp
  extends MessageMicro<StGetRecommendCardDetailRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "stAppRecommendCard" }, new Object[] { null, null }, StGetRecommendCardDetailRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public MiniAppStore.StAppRecommendCard stAppRecommendCard = new MiniAppStore.StAppRecommendCard();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_STORE_APP_CLIENT.MiniAppStore.StGetRecommendCardDetailRsp
 * JD-Core Version:    0.7.0.1
 */