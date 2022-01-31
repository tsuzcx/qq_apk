import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class aaws
  extends akhc
{
  public aaws(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, ayaw paramayaw)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("Conversation.onGetBindSubAccount() return, isSucc=").append(paramBoolean).append(" mSubUin=");
      if (paramayaw == null)
      {
        localObject1 = null;
        QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
      }
    }
    else
    {
      if ((paramBoolean) && (paramayaw != null)) {
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
    for (paramayaw = "data=null";; paramayaw = "isSucc=false")
    {
      QLog.d("SUB_ACCOUNT", 4, paramayaw);
      return;
      localObject1 = paramayaw.c;
      break;
    }
    label113:
    if (paramayaw.jdField_a_of_type_Int == 1008)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onGetBindSubAccount() delete all subAccountType RU, and add default RU.");
      }
      ayao.a(this.a.a, 0);
    }
    if (paramayaw.a())
    {
      ayao.a(this.a.a, paramayaw.a(), 2);
      this.a.a.c = true;
    }
    if (paramayaw.b())
    {
      localObject1 = paramayaw.b();
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          ayao.c(this.a.a, (String)localObject2);
        }
      }
    }
    paramayaw.a();
    this.a.a(0L);
    Conversation.h(this.a);
  }
  
  protected void b(boolean paramBoolean, ayaw paramayaw)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() isSucc=" + paramBoolean);
      if (paramayaw != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() mainAccount=" + paramayaw.b + " subAccount=" + paramayaw.c + " errType=" + paramayaw.jdField_a_of_type_Int + " errMsg=" + paramayaw.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramBoolean) && (paramayaw != null) && (paramayaw.c())) {
      ayao.a(this.a.a, paramayaw.c(), 1);
    }
    this.a.a(0L);
  }
  
  protected void c(boolean paramBoolean, ayaw paramayaw)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() isSucc=" + paramBoolean);
      if (paramayaw != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() mainAccount=" + paramayaw.b + " subAccount=" + paramayaw.c + " errType=" + paramayaw.jdField_a_of_type_Int + " errMsg=" + paramayaw.jdField_a_of_type_JavaLangString);
      }
    }
    if (paramayaw == null) {}
    while ((!paramBoolean) || (paramayaw.c == null) || (paramayaw.c.length() <= 4)) {
      return;
    }
    this.a.a.a().c(paramayaw.c, 7000);
    ayao.c(this.a.a, paramayaw.c);
    this.a.a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaws
 * JD-Core Version:    0.7.0.1
 */