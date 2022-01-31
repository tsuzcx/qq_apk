import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class agzr
  implements View.OnClickListener
{
  agzr(agzq paramagzq) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(agzq.a(this.a), QQBrowserActivity.class);
    paramView.putExtra("url", String.format("https://openmobile.qq.com/TeamGame/index.html?_wv=1031&uin=%s&team_id=%s&srcSessionType=%d&srcSessionUin=%s", new Object[] { agzq.a(this.a).getAccount(), agzq.a(this.a), Integer.valueOf(aspf.a(agzq.a(this.a).jdField_a_of_type_Int)), agzq.a(this.a).jdField_a_of_type_JavaLangString }));
    agzq.a(this.a).startActivity(paramView);
    bfhz.a().a(agzq.a(this.a).getCurrentAccountUin(), "", "", "2000", "2016", "0", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agzr
 * JD-Core Version:    0.7.0.1
 */