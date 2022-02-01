import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class adzn
  extends anvp
{
  public adzn(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, bdei parambdei)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("Conversation.onGetBindSubAccount() return, isSucc=").append(paramBoolean).append(" mSubUin=");
      if (parambdei == null)
      {
        localObject1 = null;
        QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
      }
    }
    else
    {
      if ((paramBoolean) && (parambdei != null)) {
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
    for (parambdei = "data=null";; parambdei = "isSucc=false")
    {
      QLog.d("SUB_ACCOUNT", 4, parambdei);
      return;
      localObject1 = parambdei.c;
      break;
    }
    label113:
    if (parambdei.jdField_a_of_type_Int == 1008)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onGetBindSubAccount() delete all subAccountType RU, and add default RU.");
      }
      bddy.a(this.a.a, 0);
    }
    if (parambdei.a())
    {
      bddy.a(this.a.a, parambdei.a(), 2);
      this.a.a.c = true;
    }
    if (parambdei.b())
    {
      localObject1 = parambdei.b();
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          bddy.c(this.a.a, (String)localObject2);
        }
      }
    }
    parambdei.a();
    this.a.a(0L);
    Conversation.m(this.a);
  }
  
  protected void b(boolean paramBoolean, bdei parambdei)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() isSucc=" + paramBoolean);
      if (parambdei != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() mainAccount=" + parambdei.b + " subAccount=" + parambdei.c + " errType=" + parambdei.jdField_a_of_type_Int + " errMsg=" + parambdei.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramBoolean) && (parambdei != null) && (parambdei.c())) {
      bddy.a(this.a.a, parambdei.c(), 1);
    }
    this.a.a(0L);
  }
  
  protected void c(boolean paramBoolean, bdei parambdei)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() isSucc=" + paramBoolean);
      if (parambdei != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() mainAccount=" + parambdei.b + " subAccount=" + parambdei.c + " errType=" + parambdei.jdField_a_of_type_Int + " errMsg=" + parambdei.jdField_a_of_type_JavaLangString);
      }
    }
    if (parambdei == null) {}
    while ((!paramBoolean) || (parambdei.c == null) || (parambdei.c.length() <= 4)) {
      return;
    }
    this.a.a.a().c(parambdei.c, 7000);
    bddy.c(this.a.a, parambdei.c);
    this.a.a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzn
 * JD-Core Version:    0.7.0.1
 */