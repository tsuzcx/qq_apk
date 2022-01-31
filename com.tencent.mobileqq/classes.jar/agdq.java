import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class agdq
  implements View.OnClickListener
{
  agdq(agdo paramagdo, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_Agdo.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    paramView.putExtra("individuation_url_type", 40303);
    String str = bdtg.a(this.jdField_a_of_type_Agdo.jdField_a_of_type_AndroidContentContext, "call", "mvip.gongneng.anroid.individuation.web");
    str = str + "&funcallId=" + this.jdField_a_of_type_Int;
    VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_Agdo.jdField_a_of_type_AndroidContentContext, str, 524288L, paramView, true, -1);
    int i = ((amca)this.jdField_a_of_type_Agdo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).g();
    if (i == 2) {
      i = 0;
    }
    for (;;)
    {
      azqs.b(this.jdField_a_of_type_Agdo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004A25", "0X8004A25", 0, 0, "" + i, "", "", "");
      return;
      if (i == 3) {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdq
 * JD-Core Version:    0.7.0.1
 */