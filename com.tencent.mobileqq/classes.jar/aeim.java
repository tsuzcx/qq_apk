import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class aeim
  extends aoib
{
  public aeim(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, bdxd parambdxd)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("Conversation.onGetBindSubAccount() return, isSucc=").append(paramBoolean).append(" mSubUin=");
      if (parambdxd == null)
      {
        localObject1 = null;
        QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
      }
    }
    else
    {
      if ((paramBoolean) && (parambdxd != null)) {
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
    for (parambdxd = "data=null";; parambdxd = "isSucc=false")
    {
      QLog.d("SUB_ACCOUNT", 4, parambdxd);
      return;
      localObject1 = parambdxd.c;
      break;
    }
    label113:
    if (parambdxd.jdField_a_of_type_Int == 1008)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onGetBindSubAccount() delete all subAccountType RU, and add default RU.");
      }
      bdwt.a(this.a.a, 0);
    }
    if (parambdxd.a())
    {
      bdwt.a(this.a.a, parambdxd.a(), 2);
      this.a.a.c = true;
    }
    if (parambdxd.b())
    {
      localObject1 = parambdxd.b();
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          bdwt.c(this.a.a, (String)localObject2);
        }
      }
    }
    parambdxd.a();
    this.a.a(0L);
    Conversation.o(this.a);
  }
  
  protected void b(boolean paramBoolean, bdxd parambdxd)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() isSucc=" + paramBoolean);
      if (parambdxd != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() mainAccount=" + parambdxd.b + " subAccount=" + parambdxd.c + " errType=" + parambdxd.jdField_a_of_type_Int + " errMsg=" + parambdxd.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramBoolean) && (parambdxd != null) && (parambdxd.c())) {
      bdwt.a(this.a.a, parambdxd.c(), 1);
    }
    this.a.a(0L);
  }
  
  protected void c(boolean paramBoolean, bdxd parambdxd)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() isSucc=" + paramBoolean);
      if (parambdxd != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() mainAccount=" + parambdxd.b + " subAccount=" + parambdxd.c + " errType=" + parambdxd.jdField_a_of_type_Int + " errMsg=" + parambdxd.jdField_a_of_type_JavaLangString);
      }
    }
    if (parambdxd == null) {}
    while ((!paramBoolean) || (parambdxd.c == null) || (parambdxd.c.length() <= 4)) {
      return;
    }
    this.a.a.a().c(parambdxd.c, 7000);
    bdwt.c(this.a.a, parambdxd.c);
    this.a.a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeim
 * JD-Core Version:    0.7.0.1
 */