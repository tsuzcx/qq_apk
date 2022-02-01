import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.Conversation.42.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class ajxw
  extends aoef
{
  public ajxw(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, bdxt parambdxt)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("Conversation.onGetBindSubAccount() return, isSucc=").append(paramBoolean).append(" mSubUin=");
      if (parambdxt == null)
      {
        localObject1 = null;
        QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
      }
    }
    else
    {
      if ((paramBoolean) && (parambdxt != null)) {
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
    for (parambdxt = "data=null";; parambdxt = "isSucc=false")
    {
      QLog.d("SUB_ACCOUNT", 4, parambdxt);
      return;
      localObject1 = parambdxt.c;
      break;
    }
    label113:
    if (parambdxt.jdField_a_of_type_Int == 1008)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onGetBindSubAccount() delete all subAccountType RU, and add default RU.");
      }
      bdxj.a(this.a.a, 0);
    }
    if (parambdxt.a())
    {
      bdxj.a(this.a.a, parambdxt.a(), 2);
      this.a.a.mFirstGetSubAccountName = true;
    }
    if (parambdxt.b())
    {
      localObject1 = parambdxt.b();
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          bdxj.c(this.a.a, (String)localObject2);
        }
      }
    }
    parambdxt.a();
    this.a.a(0L);
    Conversation.n(this.a);
  }
  
  protected void b(boolean paramBoolean, bdxt parambdxt)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() isSucc=" + paramBoolean);
      if (parambdxt != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() mainAccount=" + parambdxt.b + " subAccount=" + parambdxt.c + " errType=" + parambdxt.jdField_a_of_type_Int + " errMsg=" + parambdxt.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramBoolean) && (parambdxt != null) && (parambdxt.c())) {
      bdxj.a(this.a.a, parambdxt.c(), 1);
    }
    for (;;)
    {
      this.a.a(0L);
      return;
      if ((parambdxt != null) && (!TextUtils.isEmpty(parambdxt.jdField_a_of_type_JavaLangString))) {
        ThreadManager.getUIHandler().post(new Conversation.42.1(this, parambdxt));
      }
    }
  }
  
  protected void c(boolean paramBoolean, bdxt parambdxt)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() isSucc=" + paramBoolean);
      if (parambdxt != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() mainAccount=" + parambdxt.b + " subAccount=" + parambdxt.c + " errType=" + parambdxt.jdField_a_of_type_Int + " errMsg=" + parambdxt.jdField_a_of_type_JavaLangString);
      }
    }
    if (parambdxt == null) {}
    while ((!paramBoolean) || (parambdxt.c == null) || (parambdxt.c.length() <= 4)) {
      return;
    }
    this.a.a.getMessageFacade().setReaded(parambdxt.c, 7000);
    bdxj.c(this.a.a, parambdxt.c);
    this.a.a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxw
 * JD-Core Version:    0.7.0.1
 */