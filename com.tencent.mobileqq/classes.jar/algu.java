import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.view.ApolloGameInfoFragment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

class algu
  implements View.OnClickListener
{
  algu(algr paramalgr, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString != null))
    {
      paramView = "http://lgame.qq.com/html/feedback/index?gameid=" + this.jdField_a_of_type_Int + "&_wv=2&openid=" + this.jdField_a_of_type_JavaLangString;
      Intent localIntent = new Intent(this.jdField_a_of_type_Algr.a.getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
      VasWebviewUtil.openQQBrowserActivity(this.jdField_a_of_type_Algr.a.getActivity(), paramView, -1L, localIntent, false, -1);
      return;
    }
    QLog.e("apollo_cmGame_ApolloGameInfoFragment", 1, "[setGameIdAndOpenId] openId is null or is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     algu
 * JD-Core Version:    0.7.0.1
 */