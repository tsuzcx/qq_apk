package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedbackReport$FeedbackRequest
  extends MessageMicro<FeedbackRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bid_info", "user_info", "content_items" }, new Object[] { null, null, null }, FeedbackRequest.class);
  public FeedbackReport.BidInfo bid_info = new FeedbackReport.BidInfo();
  public final PBRepeatMessageField<FeedbackReport.ContentFeedbackItem> content_items = PBField.initRepeatMessage(FeedbackReport.ContentFeedbackItem.class);
  public FeedbackReport.UserInfo user_info = new FeedbackReport.UserInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.FeedbackReport.FeedbackRequest
 * JD-Core Version:    0.7.0.1
 */