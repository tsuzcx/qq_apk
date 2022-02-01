import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aill
  implements View.OnClickListener
{
  aill(ailk paramailk) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(ailk.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://openmobile.qq.com/TeamGame/index.html?_wv=1031&uin=%s&team_id=%s&srcSessionType=%d&srcSessionUin=%s", new Object[] { ailk.a(this.a).getAccount(), ailk.a(this.a), Integer.valueOf(auwj.a(ailk.a(this.a).jdField_a_of_type_Int)), ailk.a(this.a).jdField_a_of_type_JavaLangString }));
    ailk.a(this.a).startActivity(localIntent);
    bipi.a().a(ailk.a(this.a).getCurrentAccountUin(), "", "", "2000", "2016", "0", false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aill
 * JD-Core Version:    0.7.0.1
 */