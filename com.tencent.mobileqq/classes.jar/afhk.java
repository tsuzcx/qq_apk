import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.data.AccountDetail;

public class afhk
  extends bgix
{
  public afhk(TroopRequestActivity paramTroopRequestActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong, AccountDetail paramAccountDetail)
  {
    if ((paramBoolean) && (paramAccountDetail != null))
    {
      this.a.j.setText(paramAccountDetail.name);
      this.a.b.setVisibility(0);
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhk
 * JD-Core Version:    0.7.0.1
 */