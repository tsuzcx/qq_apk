import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.data.Card;

public class acud
  extends alpq
{
  public acud(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
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
 * Qualified Name:     acud
 * JD-Core Version:    0.7.0.1
 */