import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ConversationInfo;

public class allx
  implements acoi
{
  public int a(String paramString, StringBuilder paramStringBuilder)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {
      return 0;
    }
    int i = almj.a(localQQAppInterface);
    if (localQQAppInterface.getConversationFacade().b(AppConstants.TEMP_MSG_BOX_UIN, 10011)) {
      paramStringBuilder.append(String.format(paramString, new Object[] { AppConstants.TEMP_MSG_BOX_UIN, Integer.valueOf(10011), Integer.valueOf(i) }));
    }
    return i;
  }
  
  public boolean a(ConversationInfo paramConversationInfo)
  {
    return false;
  }
  
  public boolean a(ConversationInfo paramConversationInfo, boolean[] paramArrayOfBoolean)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {
      return false;
    }
    localObject = (almg)((QQAppInterface)localObject).getManager(QQManagerFactory.TEMP_MSG_BOX);
    if ((((almg)localObject).a(paramConversationInfo.uin, paramConversationInfo.type)) || (((almg)localObject).b(paramConversationInfo.uin, paramConversationInfo.type)) || (paramConversationInfo.type == 10011) || (paramConversationInfo.type == 10012) || (TextUtils.equals(paramConversationInfo.uin, AppConstants.FILTER_MSG_UIN)) || (TextUtils.equals(paramConversationInfo.uin, AppConstants.TEMP_MSG_BOX_UIN)))
    {
      paramArrayOfBoolean[0] = true;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allx
 * JD-Core Version:    0.7.0.1
 */