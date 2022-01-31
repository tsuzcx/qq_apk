import android.app.Activity;
import android.content.Context;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;

public class akng
  implements aknb, Handler.Callback
{
  protected bhow a;
  WeakReference<Activity> a;
  private WeakReference<QQAppInterface> b;
  
  public akng(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Bhow = new bhow(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.b = new WeakReference(paramQQAppInterface);
  }
  
  public int a()
  {
    return 100;
  }
  
  public aknh a(long paramLong, String paramString1, String paramString2)
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
      alep.a(paramLong, localQQAppInterface, paramString1, paramString2);
      return new aknh();
    }
    if ("cs.report_data_2_compass.local".equals(paramString1))
    {
      alep.a(localQQAppInterface, paramString2);
      return new aknh();
    }
    if ("cs.report_data_2_backstage.local".equals(paramString1))
    {
      alep.b(localQQAppInterface, paramString2);
      return new aknh();
    }
    if ("cs.report_flow_data.local".equals(paramString1))
    {
      alep.c(localQQAppInterface, paramString2);
      return new aknh();
    }
    if ("cs.encrypt_data.local".equals(paramString1))
    {
      alep.a(paramLong, localQQAppInterface, paramString2);
      return new aknh();
    }
    if ("cs.decrypt_data.local".equals(paramString1))
    {
      alep.b(paramLong, localQQAppInterface, paramString2);
      return new aknh();
    }
    if ("cs.get_server_ip_port.local".equals(paramString1))
    {
      alep.b(paramLong, localQQAppInterface, paramString1, paramString2);
      return new aknh();
    }
    if ("cs.save_recommend_ip.local".equals(paramString1))
    {
      alep.a(localQQAppInterface, paramString2);
      return new aknh();
    }
    if ("cs.apolloGameWebMessage.local".equals(paramString1))
    {
      alep.a(paramString2);
      return new aknh();
    }
    if ("cs.openFloatTransparentView.local".equals(paramString1))
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        alep.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString2);
        return new aknh();
      }
    }
    else if ("cs.openWebView.local".equals(paramString1))
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        alep.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString2);
        return new aknh();
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
        return akwt.a(paramString2, localQQAppInterface, i, paramString1);
      }
      if ("cs.script_get_action_data.local".equals(paramString1))
      {
        ApolloGameUtil.a(paramLong, localQQAppInterface, paramString2);
        return null;
      }
    }
    return null;
  }
  
  public aknh a(String paramString)
  {
    aknh localaknh = new aknh();
    String str = ApolloUtil.a(paramString, "tips");
    int i = ApolloUtil.a(paramString, "length");
    if (TextUtils.isEmpty(str)) {
      return localaknh;
    }
    paramString = this.jdField_a_of_type_Bhow.obtainMessage(255);
    paramString.obj = str;
    paramString.arg1 = i;
    paramString.sendToTarget();
    return localaknh;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bhow.removeCallbacksAndMessages(null);
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
      QQToast.a(localBaseApplication, localCharSequence, i).a();
      return false;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akng
 * JD-Core Version:    0.7.0.1
 */