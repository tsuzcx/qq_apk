package NS_STORE_APP_SEARCH;

import NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StRankingList;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppSearch$SearchExtInfo
  extends MessageMicro<SearchExtInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "appid", "pkRank", "coupon" }, new Object[] { "", null, null }, SearchExtInfo.class);
  public final PBStringField appid = PBField.initString("");
  public final PBRepeatMessageField<MiniAppSearch.CouponInfo> coupon = PBField.initRepeatMessage(MiniAppSearch.CouponInfo.class);
  public final PBRepeatMessageField<STORE_APP_CLIENT.StRankingList> pkRank = PBField.initRepeatMessage(STORE_APP_CLIENT.StRankingList.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_STORE_APP_SEARCH.MiniAppSearch.SearchExtInfo
 * JD-Core Version:    0.7.0.1
 */