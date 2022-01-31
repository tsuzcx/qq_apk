import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.data.Groups;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class abis
  implements ants
{
  public abis(GroupManagerActivity paramGroupManagerActivity) {}
  
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
        localObject = new bcpw(this.a);
        ((bcpw)localObject).d(2000);
        ((bcpw)localObject).c(2131720330);
        ((bcpw)localObject).a();
      }
    }
    else
    {
      return;
    }
    GroupManagerActivity.a(this.a, b);
    axqw.b(this.a.app, "CliOper", "", "", "category", "Delete_category", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abis
 * JD-Core Version:    0.7.0.1
 */