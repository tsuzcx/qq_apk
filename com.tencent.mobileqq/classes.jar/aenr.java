import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.app.CardObserver;

public class aenr
  extends CardObserver
{
  public aenr(ProfileLabelEditorActivity paramProfileLabelEditorActivity) {}
  
  public void onCardLabelUpdate(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.a.setResult(-1);
      this.a.b(2131719171);
    }
    for (;;)
    {
      this.a.a = false;
      this.a.finish();
      return;
      this.a.b(2131719169);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aenr
 * JD-Core Version:    0.7.0.1
 */