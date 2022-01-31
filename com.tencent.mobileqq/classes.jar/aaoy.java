import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class aaoy
  extends ajhi
{
  public aaoy(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionInfoCardActivity", 2, "onGetFlyTicket: " + paramBoolean);
    }
    if (!paramBoolean)
    {
      switch (paramInt)
      {
      default: 
        paramString1 = ajjy.a(2131637561);
      }
      for (;;)
      {
        this.a.a(2130839278, paramString1);
        return;
        paramString1 = ajjy.a(2131637576);
        continue;
        paramString1 = ajjy.a(2131637572);
      }
    }
    SharedPreferences.Editor localEditor = this.a.getSharedPreferences("qrcode", 0).edit();
    localEditor.putLong("discussionvalidtime" + DiscussionInfoCardActivity.a(this.a), paramLong1);
    localEditor.putString("discussion" + DiscussionInfoCardActivity.a(this.a), paramString2);
    localEditor.putString("discussionfullSig" + DiscussionInfoCardActivity.a(this.a), paramString1);
    localEditor.commit();
    this.a.jdField_a_of_type_Long = paramLong1;
    this.a.b = paramString2;
    this.a.c = paramString1;
    this.a.jdField_a_of_type_Boolean = true;
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if ((paramBoolean) && (paramLong == Long.valueOf(DiscussionInfoCardActivity.a(this.a)).longValue()))
    {
      DiscussionInfoCardActivity.c(this.a);
      this.a.a(2, this.a.getString(2131624099));
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionInfoCardActivity", 2, "onCollectDiscussion isSuccess:" + paramBoolean + " uin:" + paramLong);
    }
    if ((paramBoolean) && (paramLong != null) && (String.valueOf(paramLong).equals(DiscussionInfoCardActivity.a(this.a))))
    {
      awqx.b(this.a.app, "CliOper", "", "", "discuss", "discuss_common", 0, 0, "", "", "", "");
      if (!this.a.isFinishing())
      {
        paramLong = this.a.app.getApp().getSharedPreferences(this.a.app.getCurrentAccountUin(), 0);
        if (paramLong.getBoolean("multi_chat_set_common_use_key", true))
        {
          this.a.jdField_a_of_type_AndroidAppDialog = babr.a(this.a, 230, this.a.getString(2131628785), this.a.getString(2131628784), 2131625035, 2131653983, new aaoz(this), null);
          this.a.jdField_a_of_type_AndroidAppDialog.show();
          paramLong.edit().putBoolean("multi_chat_set_common_use_key", false).commit();
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong1, Long paramLong2)
  {
    if ((paramBoolean) && (paramLong1 != null) && (String.valueOf(paramLong1).equals(DiscussionInfoCardActivity.a(this.a))))
    {
      DiscussionInfoCardActivity.c(this.a);
      return;
    }
    bbmy.a(this.a, 1, this.a.getString(2131626283), 0).b(this.a.getTitleBarHeight());
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (ArrayList)paramObject;
    int i = paramObject.indexOf(DiscussionInfoCardActivity.a(this.a));
    if (i != -1)
    {
      paramObject = (Boolean)paramObject.get(i + 1);
      if ((paramBoolean) && (paramObject.booleanValue()))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = DiscussionInfoCardActivity.a(this.a).a(DiscussionInfoCardActivity.a(this.a));
        DiscussionInfoCardActivity.c(this.a);
        this.a.a();
        this.a.i();
        DiscussionInfoCardActivity.d(this.a);
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (DiscussionInfoCardActivity.a(this.a).equals(paramString))
    {
      if (!paramBoolean) {
        break label154;
      }
      paramString = DiscussionInfoCardActivity.a(this.a).a(paramString);
      if (paramString != null)
      {
        DiscussionInfoCardActivity.a(this.a, paramString.discussionName);
        DiscussionInfoCardActivity.a(this.a, DiscussionInfoCardActivity.b(this.a));
      }
      if ((DiscussionInfoCardActivity.a(this.a) != null) && (DiscussionInfoCardActivity.a(this.a).isShowing()) && (!this.a.isFinishing()))
      {
        DiscussionInfoCardActivity.a(this.a).a(this.a.getString(2131625108));
        DiscussionInfoCardActivity.a(this.a).d(2130839291);
        DiscussionInfoCardActivity.a(this.a).b(false);
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(17, 1500L);
      }
    }
    label154:
    do
    {
      return;
      DiscussionInfoCardActivity.a(this.a, DiscussionInfoCardActivity.b(this.a));
    } while ((DiscussionInfoCardActivity.a(this.a) == null) || (!DiscussionInfoCardActivity.a(this.a).isShowing()) || (this.a.isFinishing()));
    DiscussionInfoCardActivity.a(this.a).a(this.a.getString(2131625106));
    DiscussionInfoCardActivity.a(this.a).d(2130839291);
    DiscussionInfoCardActivity.a(this.a).b(false);
    this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(17, 1500L);
  }
  
  protected void a(Object[] paramArrayOfObject)
  {
    String str = (String)paramArrayOfObject[0];
    int i = ((Integer)paramArrayOfObject[1]).intValue();
    paramArrayOfObject = (String)paramArrayOfObject[2];
    if ((paramArrayOfObject == null) || (paramArrayOfObject.trim().equals(""))) {
      paramArrayOfObject = this.a.getString(2131627623);
    }
    for (;;)
    {
      if ((DiscussionInfoCardActivity.a(this.a).equals(str)) && (!this.a.isFinishing()))
      {
        if ((10001 == i) || (10002 == i)) {
          babr.a(this.a, 230, null, paramArrayOfObject, new aapa(this, str), null).show();
        }
      }
      else {
        return;
      }
      this.a.a(1, paramArrayOfObject);
      return;
    }
  }
  
  protected void b(boolean paramBoolean, Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionInfoCardActivity", 2, "onUncollectDiscussion isSuccess:" + paramBoolean + " uin:" + paramLong);
    }
    if ((paramBoolean) && (paramLong != null) && (String.valueOf(paramLong).equals(DiscussionInfoCardActivity.a(this.a)))) {}
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (DiscussionInfoCardActivity.a(this.a).equals(paramString))
    {
      if (!paramBoolean) {
        break label112;
      }
      if ((DiscussionInfoCardActivity.a(this.a) != null) && (DiscussionInfoCardActivity.a(this.a).isShowing()) && (!this.a.isFinishing()))
      {
        DiscussionInfoCardActivity.a(this.a).a(this.a.getString(2131626629));
        DiscussionInfoCardActivity.a(this.a).d(2130839291);
        DiscussionInfoCardActivity.a(this.a).b(false);
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16, 1500L);
      }
    }
    label112:
    while ((DiscussionInfoCardActivity.a(this.a) == null) || (!DiscussionInfoCardActivity.a(this.a).isShowing()) || (this.a.isFinishing())) {
      return;
    }
    DiscussionInfoCardActivity.a(this.a).a(this.a.getString(2131626626));
    DiscussionInfoCardActivity.a(this.a).d(2130839278);
    DiscussionInfoCardActivity.a(this.a).b(false);
    this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(17, 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaoy
 * JD-Core Version:    0.7.0.1
 */