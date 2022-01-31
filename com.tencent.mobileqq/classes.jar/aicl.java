import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;
import java.net.URLEncoder;

class aicl
  implements View.OnClickListener
{
  public int a;
  public View a;
  public ImageView a;
  public TextView a;
  public PressEffectImageView a;
  public View b;
  
  aicl(aick paramaick) {}
  
  public void onClick(View paramView)
  {
    String str2 = this.jdField_a_of_type_Aick.a(this.jdField_a_of_type_Int);
    if (paramView == this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectImageView)
    {
      if (this.jdField_a_of_type_Aick.jdField_a_of_type_Ajrt != null) {
        this.jdField_a_of_type_Aick.jdField_a_of_type_Ajrt.a(this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_Aick.a();
    }
    while (paramView != this.jdField_a_of_type_AndroidViewView) {
      return;
    }
    String str1 = amfg.a().c;
    paramView = str1;
    if (TextUtils.isEmpty(str1)) {
      paramView = "https://sou.qq.com/kandian/kd.html?_bid=3216&_wv=3&_wwv=1293&_wvSb=0&keyword=$KEYWORD$&from=$FROM$";
    }
    paramView = paramView.replace("$KEYWORD$", str2);
    if ((this.jdField_a_of_type_Aick.jdField_a_of_type_Int == 25) || (this.jdField_a_of_type_Aick.jdField_a_of_type_Int == 10)) {}
    for (paramView = paramView.replace("$FROM$", "kandian_history");; paramView = paramView.replace("$FROM$", avsv.a(this.jdField_a_of_type_Aick.jdField_a_of_type_Int)))
    {
      paramView = paramView.replace("$SEARCHID$", "" + URLEncoder.encode(UniteSearchActivity.c));
      avwf.a(this.jdField_a_of_type_Aick.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aick.jdField_a_of_type_AndroidContentContext, paramView);
      this.jdField_a_of_type_Aick.jdField_a_of_type_Ajrt.a(str2);
      avsv.a(null, new ReportModelDC02528().module("all_result").action("clk_search_his").ver2(avsv.a(this.jdField_a_of_type_Aick.jdField_a_of_type_Int)).ver4(str2).ver7("{experiment_id:" + avsv.b + "}"));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aicl
 * JD-Core Version:    0.7.0.1
 */