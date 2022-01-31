import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.troop.homework.HomeworkInfo;
import com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ajoz
  extends TroopObserver
{
  public ajoz(SubmitHomeWorkFragment paramSubmitHomeWorkFragment) {}
  
  public void a(boolean paramBoolean, HomeworkInfo paramHomeworkInfo)
  {
    super.a(paramBoolean, paramHomeworkInfo);
    this.a.a();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("获取作业信息");
      if (!paramBoolean) {
        break label124;
      }
    }
    for (String str = "成功";; str = "失败")
    {
      QLog.d("SubmitHomeWorkFragment", 2, str);
      if ((!paramBoolean) || (paramHomeworkInfo == null) || (paramHomeworkInfo.b == null)) {
        break;
      }
      SubmitHomeWorkFragment.a(this.a, paramHomeworkInfo);
      paramHomeworkInfo = paramHomeworkInfo.b;
      try
      {
        paramHomeworkInfo = new JSONObject(paramHomeworkInfo).getJSONArray("c");
        paramHomeworkInfo = new JSONObject().put("c", paramHomeworkInfo).toString();
        SubmitHomeWorkFragment.a(this.a, paramHomeworkInfo);
        return;
      }
      catch (Exception paramHomeworkInfo)
      {
        label124:
        SubmitHomeWorkFragment.a(this.a, 3, null, null, null);
        return;
      }
    }
    SubmitHomeWorkFragment.a(this.a, 3, null, null, null);
    SubmitHomeWorkFragment.a(this.a, null);
    this.a.getActivity().finish();
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    super.b(paramBoolean, paramInt);
    this.a.a();
    if (paramBoolean)
    {
      SubmitHomeWorkFragment.a(this.a);
      return;
    }
    if (paramInt == 1002)
    {
      SubmitHomeWorkFragment.a(this.a, 2, null, null, null);
      return;
    }
    if (paramInt == 10022)
    {
      SubmitHomeWorkFragment.a(this.a, 1, null, null, null);
      return;
    }
    SubmitHomeWorkFragment.a(this.a, 3, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajoz
 * JD-Core Version:    0.7.0.1
 */