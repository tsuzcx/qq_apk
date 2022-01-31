import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class agvc
  implements View.OnClickListener
{
  agvc(agvb paramagvb) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(agvb.a(this.a), QQBrowserActivity.class);
    paramView.putExtra("url", String.format("https://openmobile.qq.com/TeamGame/index.html?_wv=1031&uin=%s&team_id=%s&srcSessionType=%d&srcSessionUin=%s", new Object[] { agvb.a(this.a).getAccount(), agvb.a(this.a), Integer.valueOf(askw.a(agvb.a(this.a).jdField_a_of_type_Int)), agvb.a(this.a).jdField_a_of_type_JavaLangString }));
    agvb.a(this.a).startActivity(paramView);
    bfdq.a().a(agvb.a(this.a).getCurrentAccountUin(), "", "", "2000", "2016", "0", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agvc
 * JD-Core Version:    0.7.0.1
 */