import com.tencent.mobileqq.activity.AgeSelectionActivity;
import com.tencent.qphone.base.util.QLog;

public class acrd
  implements acva
{
  public acrd(AgeSelectionActivity paramAgeSelectionActivity) {}
  
  public void a()
  {
    if ((AgeSelectionActivity.a(this.a) != null) && (AgeSelectionActivity.a(this.a).isShowing())) {
      AgeSelectionActivity.a(this.a).dismiss();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.b = paramInt1;
    this.a.c = paramInt2;
    this.a.d = paramInt3;
    if (QLog.isColorLevel()) {
      QLog.d("AgeSelectionActivity", 2, String.format("onBirthdayChange newBirthdayYear:%s,newBirthdayMonth:%s,newBirthdayDay:%s", new Object[] { Integer.valueOf(this.a.b), Integer.valueOf(this.a.c), Integer.valueOf(this.a.d) }));
    }
    AgeSelectionActivity.a(this.a, this.a.b, this.a.c, this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acrd
 * JD-Core Version:    0.7.0.1
 */