import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahug
  implements View.OnClickListener
{
  ahug(ahue paramahue, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_Ahue.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("individuation_url_type", 40303);
    String str = bhyk.a(this.jdField_a_of_type_Ahue.jdField_a_of_type_AndroidContentContext, "call", "mvip.gongneng.anroid.individuation.web");
    str = str + "&funcallId=" + this.jdField_a_of_type_Int;
    VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_Ahue.jdField_a_of_type_AndroidContentContext, str, 524288L, localIntent, true, -1);
    int i = ((aogu)this.jdField_a_of_type_Ahue.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).g();
    if (i == 2) {
      i = 0;
    }
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_Ahue.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004A25", "0X8004A25", 0, 0, "" + i, "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 3) {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahug
 * JD-Core Version:    0.7.0.1
 */