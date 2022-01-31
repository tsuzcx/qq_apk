import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class aexx
  implements View.OnClickListener
{
  aexx(aexw paramaexw) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(aexw.a(this.a), QQBrowserActivity.class);
    paramView.putExtra("url", String.format("https://openmobile.qq.com/TeamGame/index.html?_wv=1031&uin=%s&team_id=%s&srcSessionType=%d&srcSessionUin=%s", new Object[] { aexw.a(this.a).getAccount(), aexw.a(this.a), Integer.valueOf(aqui.a(aexw.a(this.a).jdField_a_of_type_Int)), aexw.a(this.a).jdField_a_of_type_JavaLangString }));
    aexw.a(this.a).startActivity(paramView);
    bdes.a().a(aexw.a(this.a).getCurrentAccountUin(), "", "", "2000", "2016", "0", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aexx
 * JD-Core Version:    0.7.0.1
 */