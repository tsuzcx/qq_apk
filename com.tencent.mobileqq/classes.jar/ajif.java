import com.tencent.mobileqq.activity.contact.addfriendverifi.AddFriendBlockedInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ajif
  implements anui
{
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  public void a(boolean paramBoolean, List<AddFriendBlockedInfo> paramList, String paramString) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.obsever", 2, " onUpdate() type =" + paramInt + " isSuccess = " + paramBoolean);
    }
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendVerification.obsever", 2, " default type =" + paramInt);
      }
      return;
    case 1: 
      b(paramBoolean, null);
      return;
    case 2: 
      a(paramBoolean, null);
      return;
    case 3: 
      paramObject = (Object[])paramObject;
      boolean bool1 = ((Boolean)paramObject[0]).booleanValue();
      boolean bool2 = ((Boolean)paramObject[1]).booleanValue();
      paramObject = (String)paramObject[2];
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendVerification.obsever", 2, " isShowEntrance =" + bool1 + " isShowRedPoint =" + bool2);
      }
      a(paramBoolean, bool1, bool2, paramObject);
      return;
    case 4: 
      paramObject = (Object[])paramObject;
      List localList = (List)paramObject[0];
      String str = (String)paramObject[1];
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append(" blockedInfos =");
        if (localList == null) {
          break label297;
        }
      }
      label297:
      for (paramObject = Integer.valueOf(localList.size());; paramObject = " is null")
      {
        QLog.d("NewFriendVerification.obsever", 2, paramObject);
        a(paramBoolean, localList, str);
        return;
      }
    }
    paramObject = (Object[])paramObject;
    a(((Boolean)paramObject[0]).booleanValue(), (String)paramObject[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajif
 * JD-Core Version:    0.7.0.1
 */