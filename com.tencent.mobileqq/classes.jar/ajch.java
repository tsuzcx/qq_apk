import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ajch
  extends anbq
{
  public ajch(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, bcqu parambcqu)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("Conversation.onGetBindSubAccount() return, isSucc=").append(paramBoolean).append(" mSubUin=");
      if (parambcqu == null)
      {
        localObject1 = null;
        QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
      }
    }
    else
    {
      if ((paramBoolean) && (parambcqu != null)) {
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
    for (parambcqu = "data=null";; parambcqu = "isSucc=false")
    {
      QLog.d("SUB_ACCOUNT", 4, parambcqu);
      return;
      localObject1 = parambcqu.c;
      break;
    }
    label113:
    if (parambcqu.jdField_a_of_type_Int == 1008)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onGetBindSubAccount() delete all subAccountType RU, and add default RU.");
      }
      bcqk.a(this.a.a, 0);
    }
    if (parambcqu.a())
    {
      bcqk.a(this.a.a, parambcqu.a(), 2);
      this.a.a.mFirstGetSubAccountName = true;
    }
    if (parambcqu.b())
    {
      localObject1 = parambcqu.b();
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          bcqk.c(this.a.a, (String)localObject2);
        }
      }
    }
    parambcqu.a();
    this.a.a(0L);
    Conversation.n(this.a);
  }
  
  protected void b(boolean paramBoolean, bcqu parambcqu)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() isSucc=" + paramBoolean);
      if (parambcqu != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() mainAccount=" + parambcqu.b + " subAccount=" + parambcqu.c + " errType=" + parambcqu.jdField_a_of_type_Int + " errMsg=" + parambcqu.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramBoolean) && (parambcqu != null) && (parambcqu.c())) {
      bcqk.a(this.a.a, parambcqu.c(), 1);
    }
    this.a.a(0L);
  }
  
  protected void c(boolean paramBoolean, bcqu parambcqu)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() isSucc=" + paramBoolean);
      if (parambcqu != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() mainAccount=" + parambcqu.b + " subAccount=" + parambcqu.c + " errType=" + parambcqu.jdField_a_of_type_Int + " errMsg=" + parambcqu.jdField_a_of_type_JavaLangString);
      }
    }
    if (parambcqu == null) {}
    while ((!paramBoolean) || (parambcqu.c == null) || (parambcqu.c.length() <= 4)) {
      return;
    }
    this.a.a.getMessageFacade().setReaded(parambcqu.c, 7000);
    bcqk.c(this.a.a, parambcqu.c);
    this.a.a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajch
 * JD-Core Version:    0.7.0.1
 */