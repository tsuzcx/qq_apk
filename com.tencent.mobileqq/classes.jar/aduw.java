import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;

public class aduw
  extends CardObserver
{
  public aduw(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (paramObject != null) && (DiscussionInfoCardActivity.a(this.a) != null)) {
        DiscussionInfoCardActivity.a(this.a).notifyDataSetChanged();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aduw
 * JD-Core Version:    0.7.0.1
 */