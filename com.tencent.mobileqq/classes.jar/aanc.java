import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class aanc
  extends ajss
{
  public aanc(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, axau paramaxau)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("Conversation.onGetBindSubAccount() return, isSucc=").append(paramBoolean).append(" mSubUin=");
      if (paramaxau == null)
      {
        localObject1 = null;
        QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
      }
    }
    else
    {
      if ((paramBoolean) && (paramaxau != null)) {
        break label113;
      }
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder().append("Conversation.onGetBindSubAccount() return:");
        if (!paramBoolean) {
          break label107;
        }
      }
    }
    label107:
    for (paramaxau = "data=null";; paramaxau = "isSucc=false")
    {
      QLog.d("SUB_ACCOUNT", 4, paramaxau);
      return;
      localObject1 = paramaxau.c;
      break;
    }
    label113:
    if (paramaxau.jdField_a_of_type_Int == 1008)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onGetBindSubAccount() delete all subAccountType RU, and add default RU.");
      }
      axam.a(this.a.a, 0);
    }
    if (paramaxau.a())
    {
      axam.a(this.a.a, paramaxau.a(), 2);
      this.a.a.c = true;
    }
    if (paramaxau.b())
    {
      localObject1 = paramaxau.b();
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          axam.c(this.a.a, (String)localObject2);
        }
      }
    }
    paramaxau.a();
    this.a.a(0L);
    Conversation.h(this.a);
  }
  
  protected void b(boolean paramBoolean, axau paramaxau)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() isSucc=" + paramBoolean);
      if (paramaxau != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() mainAccount=" + paramaxau.b + " subAccount=" + paramaxau.c + " errType=" + paramaxau.jdField_a_of_type_Int + " errMsg=" + paramaxau.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramBoolean) && (paramaxau != null) && (paramaxau.c())) {
      axam.a(this.a.a, paramaxau.c(), 1);
    }
    this.a.a(0L);
  }
  
  protected void c(boolean paramBoolean, axau paramaxau)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() isSucc=" + paramBoolean);
      if (paramaxau != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() mainAccount=" + paramaxau.b + " subAccount=" + paramaxau.c + " errType=" + paramaxau.jdField_a_of_type_Int + " errMsg=" + paramaxau.jdField_a_of_type_JavaLangString);
      }
    }
    if (paramaxau == null) {}
    while ((!paramBoolean) || (paramaxau.c == null) || (paramaxau.c.length() <= 4)) {
      return;
    }
    this.a.a.a().c(paramaxau.c, 7000);
    axam.c(this.a.a, paramaxau.c);
    this.a.a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aanc
 * JD-Core Version:    0.7.0.1
 */