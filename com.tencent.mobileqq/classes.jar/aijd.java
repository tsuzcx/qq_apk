import android.app.Activity;
import android.content.Context;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;

public class aijd
  implements aiiy, Handler.Callback
{
  protected befq a;
  WeakReference<Activity> a;
  private WeakReference<QQAppInterface> b;
  
  public aijd(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Befq = new befq(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.b = new WeakReference(paramQQAppInterface);
  }
  
  public int a()
  {
    return 100;
  }
  
  public aije a(long paramLong, String paramString1, String paramString2)
  {
    if (this.b == null) {
      return null;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
    if (localQQAppInterface == null) {
      return null;
    }
    if ("general_cmd_ui_show_toast".equals(paramString1)) {
      return a(paramString2);
    }
    if ("cs.get_dress_path.local".equals(paramString1))
    {
      aizc.a(paramLong, localQQAppInterface, paramString1, paramString2);
      return new aije();
    }
    if ("cs.report_data_2_compass.local".equals(paramString1))
    {
      aizc.a(localQQAppInterface, paramString2);
      return new aije();
    }
    if ("cs.report_data_2_backstage.local".equals(paramString1))
    {
      aizc.b(localQQAppInterface, paramString2);
      return new aije();
    }
    if ("cs.report_flow_data.local".equals(paramString1))
    {
      aizc.c(localQQAppInterface, paramString2);
      return new aije();
    }
    if ("cs.encrypt_data.local".equals(paramString1))
    {
      aizc.a(paramLong, localQQAppInterface, paramString2);
      return new aije();
    }
    if ("cs.decrypt_data.local".equals(paramString1))
    {
      aizc.b(paramLong, localQQAppInterface, paramString2);
      return new aije();
    }
    if ("cs.get_server_ip_port.local".equals(paramString1))
    {
      aizc.b(paramLong, localQQAppInterface, paramString1, paramString2);
      return new aije();
    }
    if ("cs.save_recommend_ip.local".equals(paramString1))
    {
      aizc.a(localQQAppInterface, paramString2);
      return new aije();
    }
    if ("cs.apolloGameWebMessage.local".equals(paramString1))
    {
      aizc.a(paramString2);
      return new aije();
    }
    if ("cs.openFloatTransparentView.local".equals(paramString1))
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        aizc.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString2);
        return new aije();
      }
    }
    else if ("cs.openWebView.local".equals(paramString1))
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        aizc.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString2);
        return new aije();
      }
    }
    else
    {
      if ("cs.script_get_nickname.local".equals(paramString1))
      {
        QQMessageFacade localQQMessageFacade = localQQAppInterface.a();
        int j = -1;
        String str = "";
        paramString1 = str;
        int i = j;
        if (localQQMessageFacade != null)
        {
          paramString1 = str;
          i = j;
          if (localQQMessageFacade.a())
          {
            paramString1 = str;
            i = j;
            if (!TextUtils.isEmpty(localQQMessageFacade.a()))
            {
              paramString1 = localQQMessageFacade.a();
              i = localQQMessageFacade.a();
            }
          }
        }
        return aisl.a(paramString2, localQQAppInterface, i, paramString1);
      }
      if ("cs.script_get_action_data.local".equals(paramString1))
      {
        ApolloGameUtil.a(paramLong, localQQAppInterface, paramString2);
        return null;
      }
    }
    return null;
  }
  
  public aije a(String paramString)
  {
    aije localaije = new aije();
    String str = ApolloUtil.a(paramString, "tips");
    int i = ApolloUtil.a(paramString, "length");
    if (TextUtils.isEmpty(str)) {
      return localaije;
    }
    paramString = this.jdField_a_of_type_Befq.obtainMessage(255);
    paramString.obj = str;
    paramString.arg1 = i;
    paramString.sendToTarget();
    return localaije;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Befq.removeCallbacksAndMessages(null);
  }
  
  public boolean a(Activity paramActivity)
  {
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 1;
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
    } while (!(paramMessage.obj instanceof String));
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    CharSequence localCharSequence = (CharSequence)paramMessage.obj;
    if (paramMessage.arg1 == 1) {}
    for (;;)
    {
      bbmy.a(localBaseApplication, localCharSequence, i).a();
      return false;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aijd
 * JD-Core Version:    0.7.0.1
 */