import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.POITaskInfo;

public class abha
  implements Runnable
{
  public abha(ARMapActivity paramARMapActivity, boolean paramBoolean, String paramString, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      RelativeLayout.LayoutParams localLayoutParams;
      if (this.jdField_a_of_type_JavaLangString.equals("right")) {
        if ((this.jdField_a_of_type_Int == POITaskInfo.g) || (this.jdField_a_of_type_Int == POITaskInfo.k))
        {
          this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.a.setImageResource(2130842328);
          if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity)))
          {
            localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(77.0F, this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.getResources()), AIOUtils.a(70.0F, this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.getResources()));
            localLayoutParams.addRule(11);
            localLayoutParams.addRule(10);
            localLayoutParams.topMargin = AIOUtils.a(90.0F, this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.getResources());
            localLayoutParams.rightMargin = AIOUtils.a(12.0F, this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.getResources());
            this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.a.setLayoutParams(localLayoutParams);
            ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, "right");
          }
        }
      }
      label366:
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.a.setVisibility(0);
        return;
        this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.a.setImageResource(2130842329);
        break;
        if (this.jdField_a_of_type_JavaLangString.equals("left"))
        {
          if ((this.jdField_a_of_type_Int == POITaskInfo.g) || (this.jdField_a_of_type_Int == POITaskInfo.k)) {
            this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.a.setImageResource(2130842326);
          }
          for (;;)
          {
            if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity))) {
              break label366;
            }
            localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(77.0F, this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.getResources()), AIOUtils.a(70.0F, this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.getResources()));
            localLayoutParams.addRule(9);
            localLayoutParams.addRule(10);
            localLayoutParams.topMargin = AIOUtils.a(90.0F, this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.getResources());
            localLayoutParams.leftMargin = AIOUtils.a(12.0F, this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.getResources());
            this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.a.setLayoutParams(localLayoutParams);
            ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, "left");
            break;
            this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.a.setImageResource(2130842327);
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abha
 * JD-Core Version:    0.7.0.1
 */