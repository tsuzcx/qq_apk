import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ambf
  implements View.OnClickListener
{
  ambf(ambe paramambe, akbw paramakbw, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_Ambe.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", this.jdField_a_of_type_Akbw.b);
    localIntent.putExtra("isShowAd", false);
    this.jdField_a_of_type_Ambe.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    if ((this.jdField_a_of_type_Ambe.jdField_a_of_type_AndroidContentContext instanceof AvatarPendantActivity)) {
      ((AvatarPendantActivity)this.jdField_a_of_type_Ambe.jdField_a_of_type_AndroidContentContext).a = -1L;
    }
    if (this.jdField_a_of_type_Int == 1) {
      VasWebviewUtil.reportCommercialDrainage("", "faceaddon", "0X8008486", "", 1, 0, 0, "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bcst.b(this.jdField_a_of_type_Ambe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006334", "0X8006334", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ambf
 * JD-Core Version:    0.7.0.1
 */