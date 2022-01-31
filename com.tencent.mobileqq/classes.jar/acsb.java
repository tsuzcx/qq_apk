import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class acsb
  extends amdg
{
  public acsb(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, bade parambade)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("Conversation.onGetBindSubAccount() return, isSucc=").append(paramBoolean).append(" mSubUin=");
      if (parambade == null)
      {
        localObject1 = null;
        QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
      }
    }
    else
    {
      if ((paramBoolean) && (parambade != null)) {
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
    for (parambade = "data=null";; parambade = "isSucc=false")
    {
      QLog.d("SUB_ACCOUNT", 4, parambade);
      return;
      localObject1 = parambade.c;
      break;
    }
    label113:
    if (parambade.jdField_a_of_type_Int == 1008)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onGetBindSubAccount() delete all subAccountType RU, and add default RU.");
      }
      bacu.a(this.a.a, 0);
    }
    if (parambade.a())
    {
      bacu.a(this.a.a, parambade.a(), 2);
      this.a.a.c = true;
    }
    if (parambade.b())
    {
      localObject1 = parambade.b();
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          bacu.c(this.a.a, (String)localObject2);
        }
      }
    }
    parambade.a();
    this.a.a(0L);
    Conversation.j(this.a);
  }
  
  protected void b(boolean paramBoolean, bade parambade)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() isSucc=" + paramBoolean);
      if (parambade != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() mainAccount=" + parambade.b + " subAccount=" + parambade.c + " errType=" + parambade.jdField_a_of_type_Int + " errMsg=" + parambade.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramBoolean) && (parambade != null) && (parambade.c())) {
      bacu.a(this.a.a, parambade.c(), 1);
    }
    this.a.a(0L);
  }
  
  protected void c(boolean paramBoolean, bade parambade)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() isSucc=" + paramBoolean);
      if (parambade != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() mainAccount=" + parambade.b + " subAccount=" + parambade.c + " errType=" + parambade.jdField_a_of_type_Int + " errMsg=" + parambade.jdField_a_of_type_JavaLangString);
      }
    }
    if (parambade == null) {}
    while ((!paramBoolean) || (parambade.c == null) || (parambade.c.length() <= 4)) {
      return;
    }
    this.a.a.a().c(parambade.c, 7000);
    bacu.c(this.a.a, parambade.c);
    this.a.a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsb
 * JD-Core Version:    0.7.0.1
 */