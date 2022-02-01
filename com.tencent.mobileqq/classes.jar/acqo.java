import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.CardObserver;

public class acqo
  extends CardObserver
{
  public acqo(AddRequestActivity paramAddRequestActivity) {}
  
  public void onImpeach(boolean paramBoolean, String paramString)
  {
    if (!this.a.a.equals(paramString)) {
      return;
    }
    if (paramBoolean)
    {
      this.a.a(2130839630, this.a.getString(2131690643));
      return;
    }
    this.a.a(2130839615, this.a.getString(2131690641));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqo
 * JD-Core Version:    0.7.0.1
 */