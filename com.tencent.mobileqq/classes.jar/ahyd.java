import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahyd
  implements View.OnClickListener
{
  ahyd(ahyc paramahyc) {}
  
  public void onClick(View paramView)
  {
    odv localodv = (odv)paramView.getTag();
    Object localObject = (amxz)this.a.a.a.getManager(56);
    if ((localObject != null) && (((amxz)localObject).c(localodv.jdField_a_of_type_JavaLangString) != null)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        localObject = new Intent(this.a.a.a(), ChatActivity.class);
        if (localodv.jdField_a_of_type_Boolean)
        {
          ((Intent)localObject).putExtra("uintype", 1008);
          ((Intent)localObject).putExtra("uin", localodv.jdField_a_of_type_JavaLangString);
          ((Intent)localObject).putExtra("uinname", localodv.b);
          ((Intent)localObject).putExtra("start_time", System.currentTimeMillis());
          this.a.a.a().startActivity((Intent)localObject);
          if (!ahyc.a(this.a)) {
            break label376;
          }
        }
      }
      label376:
      for (localObject = "houtai";; localObject = "duan")
      {
        odq.a(this.a.a.a, localodv.jdField_a_of_type_JavaLangString, "0X8007404", "0X8007404", 0, 0, "", "", (String)localObject, "");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder("clickRecommendAccount->");
          localStringBuilder.append("source:").append((String)localObject);
          localStringBuilder.append(", puin:").append(localodv.jdField_a_of_type_JavaLangString);
          localStringBuilder.append(", isFollow:").append(bool);
          QLog.d("ClassificationSearchFragment", 2, localStringBuilder.toString());
        }
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        ((Intent)localObject).putExtra("uintype", 1024);
        break;
        if (localodv.jdField_a_of_type_Boolean)
        {
          localObject = new Intent(this.a.a.a(), AccountDetailActivity.class);
          ((Intent)localObject).putExtra("uintype", 1008);
          ((Intent)localObject).putExtra("source", 118);
        }
        for (;;)
        {
          ((Intent)localObject).putExtra("uin", localodv.jdField_a_of_type_JavaLangString);
          ((Intent)localObject).addFlags(67108864);
          this.a.a.a().startActivity((Intent)localObject);
          break;
          localObject = npt.a(this.a.a.a(), null, "", false, -1, false, -1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyd
 * JD-Core Version:    0.7.0.1
 */