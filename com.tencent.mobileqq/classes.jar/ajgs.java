import android.text.TextUtils;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ajgs
  extends TroopObserver
{
  public ajgs(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    super.a(paramBoolean, paramString1, paramString2, paramInt, paramString3, paramString4);
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onGetHomeworkTroopIdentity: isSuccess:" + paramBoolean + ", identity:" + paramInt + ", course:" + paramString3);
    }
    if (!PublishHomeWorkFragment.a(this.a))
    {
      if (!PublishHomeWorkFragment.b(this.a)) {
        PublishHomeWorkFragment.a(this.a, paramString3);
      }
      switch (paramInt)
      {
      default: 
        PublishHomeWorkFragment.a(this.a, "");
        PublishHomeWorkFragment.a(this.a, false);
        PublishHomeWorkFragment.b(this.a, paramString3);
        PublishHomeWorkFragment.c(this.a, paramString4);
        if (PublishHomeWorkFragment.a(this.a) == null)
        {
          paramString2 = "";
          label176:
          paramString4 = PublishHomeWorkFragment.b(this.a);
          if (!PublishHomeWorkFragment.c(this.a)) {
            break label496;
          }
          if (PublishHomeWorkFragment.c(this.a) != null) {
            break label485;
          }
          paramString1 = "";
          label208:
          TroopReportor.a("Grp_edu", "homework", "CreateHw_Show", 0, 0, new String[] { paramString2, paramString4, paramString1 });
          if (!paramBoolean) {
            break label523;
          }
          PublishHomeWorkFragment.d(this.a, paramString3);
          if (PublishHomeWorkFragment.e(this.a) == null) {
            PublishHomeWorkFragment.d(this.a, "");
          }
          if (!TextUtils.isEmpty(PublishHomeWorkFragment.e(this.a)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PublishHomeWorkFragment", 2, "检测到你是" + PublishHomeWorkFragment.e(this.a) + "老师，将按照需求定制入口");
            }
            paramString1 = this.a.a(PublishHomeWorkFragment.e(this.a));
            if (paramString1 != null)
            {
              PublishHomeWorkFragment.a(this.a).clear();
              PublishHomeWorkFragment.a(this.a).addAll(paramString1);
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      QLog.i("PublishHomeWorkFragment", 1, "init data success");
      PublishHomeWorkFragment.b(this.a);
      return;
      PublishHomeWorkFragment.a(this.a, "classteacher");
      PublishHomeWorkFragment.a(this.a, true);
      break;
      PublishHomeWorkFragment.a(this.a, "teacher");
      PublishHomeWorkFragment.a(this.a, true);
      break;
      PublishHomeWorkFragment.a(this.a, "parent");
      PublishHomeWorkFragment.a(this.a, false);
      break;
      PublishHomeWorkFragment.a(this.a, "student");
      PublishHomeWorkFragment.a(this.a, false);
      break;
      paramString2 = PublishHomeWorkFragment.a(this.a);
      break label176;
      label485:
      paramString1 = PublishHomeWorkFragment.c(this.a);
      break label208;
      label496:
      if (PublishHomeWorkFragment.d(this.a) == null)
      {
        paramString1 = "";
        break label208;
      }
      paramString1 = PublishHomeWorkFragment.d(this.a);
      break label208;
      label523:
      QQToast.a(this.a.getActivity(), "获取教师身份失败", 0).a();
    }
  }
  
  public void b(boolean paramBoolean, long paramLong, int paramInt)
  {
    super.b(paramBoolean, paramLong, paramInt);
    this.a.b();
    if (paramBoolean)
    {
      PublishHomeWorkFragment.a(this.a);
      return;
    }
    if (paramInt == 10022)
    {
      PublishHomeWorkFragment.a(this.a, 1, null, null);
      return;
    }
    if (paramInt == 1002)
    {
      PublishHomeWorkFragment.a(this.a, 2, null, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PublishHomeWorkFragment", 2, "UPLOAD_ERROR_UNKNOWN_ERROR: server error " + paramInt);
    }
    PublishHomeWorkFragment.a(this.a, 3, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgs
 * JD-Core Version:    0.7.0.1
 */