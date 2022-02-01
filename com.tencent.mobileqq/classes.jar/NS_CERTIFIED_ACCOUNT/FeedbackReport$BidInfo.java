package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedbackReport$BidInfo
  extends MessageMicro<BidInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bid", "bsign" }, new Object[] { "", "" }, BidInfo.class);
  public final PBStringField bid = PBField.initString("");
  public final PBStringField bsign = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.FeedbackReport.BidInfo
 * JD-Core Version:    0.7.0.1
 */