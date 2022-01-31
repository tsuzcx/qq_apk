import android.widget.EditText;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV.IOnSizeChangeCallback;

public class aedt
  implements MonitorSizeChangeHSV.IOnSizeChangeCallback
{
  public aedt(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ChooseInterestTagActivity.a(this.a).post(new aedu(this, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aedt
 * JD-Core Version:    0.7.0.1
 */