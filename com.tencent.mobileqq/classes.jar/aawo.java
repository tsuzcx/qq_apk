import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class aawo
  extends akhb
{
  public aawo(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, ayay paramayay)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("Conversation.onGetBindSubAccount() return, isSucc=").append(paramBoolean).append(" mSubUin=");
      if (paramayay == null)
      {
        localObject1 = null;
        QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
      }
    }
    else
    {
      if ((paramBoolean) && (paramayay != null)) {
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
    for (paramayay = "data=null";; paramayay = "isSucc=false")
    {
      QLog.d("SUB_ACCOUNT", 4, paramayay);
      return;
      localObject1 = paramayay.c;
      break;
    }
    label113:
    if (paramayay.jdField_a_of_type_Int == 1008)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onGetBindSubAccount() delete all subAccountType RU, and add default RU.");
      }
      ayaq.a(this.a.a, 0);
    }
    if (paramayay.a())
    {
      ayaq.a(this.a.a, paramayay.a(), 2);
      this.a.a.c = true;
    }
    if (paramayay.b())
    {
      localObject1 = paramayay.b();
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          ayaq.c(this.a.a, (String)localObject2);
        }
      }
    }
    paramayay.a();
    this.a.a(0L);
    Conversation.h(this.a);
  }
  
  protected void b(boolean paramBoolean, ayay paramayay)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() isSucc=" + paramBoolean);
      if (paramayay != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() mainAccount=" + paramayay.b + " subAccount=" + paramayay.c + " errType=" + paramayay.jdField_a_of_type_Int + " errMsg=" + paramayay.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramBoolean) && (paramayay != null) && (paramayay.c())) {
      ayaq.a(this.a.a, paramayay.c(), 1);
    }
    this.a.a(0L);
  }
  
  protected void c(boolean paramBoolean, ayay paramayay)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() isSucc=" + paramBoolean);
      if (paramayay != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() mainAccount=" + paramayay.b + " subAccount=" + paramayay.c + " errType=" + paramayay.jdField_a_of_type_Int + " errMsg=" + paramayay.jdField_a_of_type_JavaLangString);
      }
    }
    if (paramayay == null) {}
    while ((!paramBoolean) || (paramayay.c == null) || (paramayay.c.length() <= 4)) {
      return;
    }
    this.a.a.a().c(paramayay.c, 7000);
    ayaq.c(this.a.a, paramayay.c);
    this.a.a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aawo
 * JD-Core Version:    0.7.0.1
 */