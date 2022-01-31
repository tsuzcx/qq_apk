import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;

public class abzi
  extends ClickableSpan
{
  public int a;
  public Bundle a;
  public String a;
  
  public abzi(AddRequestActivity paramAddRequestActivity, int paramInt, String paramString, Bundle paramBundle)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {}
    for (paramView = paramView.getContext(); paramView == null; paramView = null) {
      return;
    }
    Object localObject;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      bclo.a(paramView, this.jdField_a_of_type_AndroidOsBundle, 2);
      return;
    case 2: 
      try
      {
        localObject = new Intent(paramView, DiscussionInfoCardActivity.class);
        ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        paramView.startActivity((Intent)localObject);
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
    }
    try
    {
      localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_AndroidOsBundle.getString("key_profile_uin"), this.jdField_a_of_type_AndroidOsBundle.getInt("key_profile_pa", 25));
      ((ProfileActivity.AllInOne)localObject).h = 109;
      ((ProfileActivity.AllInOne)localObject).d = this.jdField_a_of_type_AndroidOsBundle.getInt("key_profile_chatability");
      ProfileActivity.b(paramView, (ProfileActivity.AllInOne)localObject);
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abzi
 * JD-Core Version:    0.7.0.1
 */