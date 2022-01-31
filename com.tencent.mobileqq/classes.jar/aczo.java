import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aczo
  implements aplf
{
  public aczo(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "RemoveListener which = " + paramInt);
    }
    paramInt -= 1;
    byte b;
    if ((paramInt >= 0) && (paramInt < this.a.a.size()))
    {
      Object localObject = (Groups)this.a.a.get(paramInt);
      b = (byte)((Groups)localObject).group_id;
      if (QLog.isColorLevel())
      {
        QLog.d("GroupManagerActivity", 2, "RemoveListener remove groupId :" + b);
        QLog.d("GroupManagerActivity", 2, "RemoveListener remove friend_count :" + ((Groups)localObject).group_friend_count);
      }
      if (b == 0)
      {
        localObject = new QQToast(this.a);
        ((QQToast)localObject).d(2000);
        ((QQToast)localObject).c(2131720877);
        ((QQToast)localObject).a();
      }
    }
    else
    {
      return;
    }
    GroupManagerActivity.a(this.a, b);
    azmj.b(this.a.app, "CliOper", "", "", "category", "Delete_category", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aczo
 * JD-Core Version:    0.7.0.1
 */