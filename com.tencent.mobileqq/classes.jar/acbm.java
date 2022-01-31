import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.data.AccountDetail;

public class acbm
  extends azhw
{
  public acbm(TroopRequestActivity paramTroopRequestActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong, AccountDetail paramAccountDetail)
  {
    if ((paramBoolean) && (paramAccountDetail != null))
    {
      this.a.j.setText(paramAccountDetail.name);
      this.a.b.setVisibility(0);
      this.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acbm
 * JD-Core Version:    0.7.0.1
 */