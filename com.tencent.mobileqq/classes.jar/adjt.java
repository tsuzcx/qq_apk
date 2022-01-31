import android.os.Bundle;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class adjt
  extends allb
{
  public adjt(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  protected void onGetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2 != this.a.d.a()))
    {
      this.a.d.setOnCheckedChangeListener(null);
      this.a.d.setChecked(paramBoolean2);
      this.a.d.setOnCheckedChangeListener(this.a);
    }
  }
  
  protected void onImpeach(boolean paramBoolean, String paramString)
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(paramString)) {
      return;
    }
    this.a.f();
    if (paramBoolean)
    {
      this.a.a(2131690676, 2);
      return;
    }
    this.a.a(2131690674, 1);
  }
  
  protected void onSetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2 != this.a.d.a()))
    {
      this.a.d.setOnCheckedChangeListener(null);
      this.a.d.setChecked(paramBoolean2);
      this.a.d.setOnCheckedChangeListener(this.a);
    }
  }
  
  protected void onSetDetailInfo(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if (((paramBoolean) && (paramInt == 0)) || ((!paramBoolean) && (paramInt == 34))) {}
    for (;;)
    {
      if (this.a.jdField_a_of_type_AndroidOsBundle == null) {
        this.a.jdField_a_of_type_AndroidOsBundle = new Bundle();
      }
      if (paramCard != null) {
        this.a.jdField_a_of_type_AndroidOsBundle.putShort("key_personality_label_switch", paramCard.switch_disable_personality_label);
      }
      return;
      this.a.a(2131695605, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adjt
 * JD-Core Version:    0.7.0.1
 */