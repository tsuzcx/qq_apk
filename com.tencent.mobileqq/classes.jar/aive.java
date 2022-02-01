import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aive
  implements View.OnClickListener
{
  aive(aivd paramaivd) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(aivd.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://openmobile.qq.com/TeamGame/index.html?_wv=1031&uin=%s&team_id=%s&srcSessionType=%d&srcSessionUin=%s", new Object[] { aivd.a(this.a).getAccount(), aivd.a(this.a), Integer.valueOf(avoj.a(aivd.a(this.a).jdField_a_of_type_Int)), aivd.a(this.a).jdField_a_of_type_JavaLangString }));
    aivd.a(this.a).startActivity(localIntent);
    bjqh.a().a(aivd.a(this.a).getCurrentAccountUin(), "", "", "2000", "2016", "0", false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aive
 * JD-Core Version:    0.7.0.1
 */