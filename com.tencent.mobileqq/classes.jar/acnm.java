import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class acnm
  extends alyr
{
  public acnm(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, azyv paramazyv)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("Conversation.onGetBindSubAccount() return, isSucc=").append(paramBoolean).append(" mSubUin=");
      if (paramazyv == null)
      {
        localObject1 = null;
        QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
      }
    }
    else
    {
      if ((paramBoolean) && (paramazyv != null)) {
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
    for (paramazyv = "data=null";; paramazyv = "isSucc=false")
    {
      QLog.d("SUB_ACCOUNT", 4, paramazyv);
      return;
      localObject1 = paramazyv.c;
      break;
    }
    label113:
    if (paramazyv.jdField_a_of_type_Int == 1008)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onGetBindSubAccount() delete all subAccountType RU, and add default RU.");
      }
      azyl.a(this.a.a, 0);
    }
    if (paramazyv.a())
    {
      azyl.a(this.a.a, paramazyv.a(), 2);
      this.a.a.c = true;
    }
    if (paramazyv.b())
    {
      localObject1 = paramazyv.b();
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          azyl.c(this.a.a, (String)localObject2);
        }
      }
    }
    paramazyv.a();
    this.a.a(0L);
    Conversation.j(this.a);
  }
  
  protected void b(boolean paramBoolean, azyv paramazyv)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() isSucc=" + paramBoolean);
      if (paramazyv != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() mainAccount=" + paramazyv.b + " subAccount=" + paramazyv.c + " errType=" + paramazyv.jdField_a_of_type_Int + " errMsg=" + paramazyv.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramBoolean) && (paramazyv != null) && (paramazyv.c())) {
      azyl.a(this.a.a, paramazyv.c(), 1);
    }
    this.a.a(0L);
  }
  
  protected void c(boolean paramBoolean, azyv paramazyv)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() isSucc=" + paramBoolean);
      if (paramazyv != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() mainAccount=" + paramazyv.b + " subAccount=" + paramazyv.c + " errType=" + paramazyv.jdField_a_of_type_Int + " errMsg=" + paramazyv.jdField_a_of_type_JavaLangString);
      }
    }
    if (paramazyv == null) {}
    while ((!paramBoolean) || (paramazyv.c == null) || (paramazyv.c.length() <= 4)) {
      return;
    }
    this.a.a.a().c(paramazyv.c, 7000);
    azyl.c(this.a.a, paramazyv.c);
    this.a.a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acnm
 * JD-Core Version:    0.7.0.1
 */