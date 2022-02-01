import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.CardObserver;

public class adgy
  extends CardObserver
{
  public adgy(AddRequestActivity paramAddRequestActivity) {}
  
  public void onImpeach(boolean paramBoolean, String paramString)
  {
    if (!this.a.a.equals(paramString)) {
      return;
    }
    if (paramBoolean)
    {
      this.a.a(2130839651, this.a.getString(2131690720));
      return;
    }
    this.a.a(2130839636, this.a.getString(2131690718));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adgy
 * JD-Core Version:    0.7.0.1
 */