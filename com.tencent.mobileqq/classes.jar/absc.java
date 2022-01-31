import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.qphone.base.util.QLog;

public class absc
  extends aqkn
{
  public absc(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onBandIntimateRelationship");
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(this.a.a.a))) {
      QLog.d("intimate_relationship", 1, String.format("onBandIntimateRelationship return, friendUin: %s", new Object[] { paramString }));
    }
    while (!paramBoolean) {
      return;
    }
    ProfileCardMoreActivity.a(this.a);
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "ProfileCard onDisbandIntimateRelationship");
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(this.a.a.a))) {
      QLog.d("intimate_relationship", 1, String.format("ProfileCard onDisbandIntimateRelationship, friendUin: %s", new Object[] { paramString }));
    }
    while (!paramBoolean1) {
      return;
    }
    ProfileCardMoreActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     absc
 * JD-Core Version:    0.7.0.1
 */