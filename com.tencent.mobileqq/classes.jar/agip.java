import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity.10.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class agip
  extends ajxj
{
  public agip(BindNumberActivity paramBindNumberActivity) {}
  
  public void onGetFriendsHasBindPhone(boolean paramBoolean, int paramInt, List<String> paramList)
  {
    if (QLog.isColorLevel()) {
      if (paramList != null) {
        break label95;
      }
    }
    label95:
    for (Object localObject = "null";; localObject = Integer.valueOf(paramList.size()))
    {
      QLog.i("BindNumberActivity", 2, String.format("onGetFriendsHasBindPhone [%s, %s, %s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), localObject }));
      if (paramBoolean) {
        this.a.runOnUiThread(new BindNumberActivity.10.1(this, paramInt, paramList));
      }
      this.a.app.removeObserver(this.a.a);
      this.a.a = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agip
 * JD-Core Version:    0.7.0.1
 */