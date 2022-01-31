import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileImageAvatar.1;
import com.tencent.mobileqq.activity.FriendProfileImageAvatar.3;
import com.tencent.mobileqq.activity.FriendProfileImageAvatar.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Setting;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import mqq.os.MqqHandler;

public class aawl
  extends aawn
  implements Handler.Callback, back
{
  int jdField_a_of_type_Int;
  private ajjh jdField_a_of_type_Ajjh = new aawm(this);
  String jdField_a_of_type_JavaLangString;
  public URL a;
  public MqqHandler a;
  public boolean a;
  public boolean b;
  public boolean c = false;
  
  public aawl(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaNetURL = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler = new babk(Looper.getMainLooper(), this);
  }
  
  public int a()
  {
    return 1;
  }
  
  public aawp a(int paramInt)
  {
    return this.jdField_a_of_type_Aawp;
  }
  
  public Drawable a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Aawp != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Aawp.d)) {
          localObject1 = azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_Aawp.d);
        }
      }
    }
    return localObject1;
  }
  
  public void a(int paramInt)
  {
    int i = paramInt;
    if (paramInt > 0) {
      i = 0;
    }
    this.jdField_b_of_type_Int = i;
    this.jdField_a_of_type_Aawp = a(i);
    if (this.jdField_a_of_type_Aawp != null)
    {
      a(this.jdField_a_of_type_Aawp, true);
      c(this.jdField_a_of_type_Aawp);
    }
  }
  
  public void a(aawp paramaawp)
  {
    this.jdField_a_of_type_Aawp = paramaawp;
  }
  
  void a(aawp paramaawp, boolean paramBoolean)
  {
    int i = paramaawp.jdField_a_of_type_Int;
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean) && ((paramaawp.jdField_a_of_type_Int == 0) || (paramaawp.jdField_a_of_type_Int == 3)))
    {
      this.jdField_a_of_type_Boolean = true;
      ThreadManager.postImmediately(new FriendProfileImageAvatar.1(this, paramaawp), null, false);
    }
    if (paramaawp.jdField_a_of_type_Int == 0) {
      paramaawp.jdField_a_of_type_Int = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.Avatar", 2, "load: uin=" + paramaawp.d + ",state=" + paramaawp.jdField_a_of_type_Int + ", bState=" + i + ", bGetHeadInfo=" + this.jdField_a_of_type_Boolean + ", isFromClickEvent=" + paramBoolean);
      }
      return;
      if ((!paramBoolean) && (paramaawp.jdField_a_of_type_Int == 3))
      {
        paramaawp.jdField_a_of_type_Int = 4;
        if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(4, 400L);
        }
      }
    }
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    paramBaseActivity.removeObserver(this.jdField_a_of_type_Ajjh);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_MqqOsMqqHandler = null;
  }
  
  public void a(BaseActivity paramBaseActivity, aawp paramaawp)
  {
    paramaawp.jdField_a_of_type_JavaLangString = null;
    paramaawp.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(false, this.jdField_b_of_type_JavaLangString);
    paramaawp.c = azyk.b(this.jdField_b_of_type_JavaLangString);
    b(paramaawp);
    this.jdField_a_of_type_Aawp = paramaawp;
  }
  
  void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      asfl.a("Q.profilecard.Avatar", "downloadHDAvatar", new Object[] { paramString });
    }
    if (this.c)
    {
      if (asfl.a()) {
        asfl.a("Q.profilecard.Avatar", "downloadHDAvatar makingHDUrl return 1", new Object[0]);
      }
      return;
    }
    ThreadManager.post(new FriendProfileImageAvatar.3(this, paramString), 5, null, true);
  }
  
  void a(String paramString1, byte paramByte, String paramString2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Aawp.jdField_a_of_type_Boolean = true;
    c(this.jdField_a_of_type_Aawp);
    if (this.jdField_b_of_type_Boolean)
    {
      if (asfl.a()) {
        asfl.a("Q.profilecard.Avatar", "downloadHDAvatar is downloading and return 1", new Object[0]);
      }
      return;
    }
    ThreadManager.post(new FriendProfileImageAvatar.4(this, paramString1, paramByte, paramString2), 5, null, true);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "onHttpStart() url = " + paramString);
    }
    if ((this.jdField_a_of_type_JavaNetURL != null) && (this.jdField_a_of_type_JavaNetURL.toString().equals(paramString)))
    {
      paramString = Message.obtain();
      paramString.what = 2;
      paramString.arg1 = paramInt;
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramString);
      }
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_JavaNetURL != null) && (this.jdField_a_of_type_JavaNetURL.toString().equals(paramString)))
    {
      if ((this.jdField_a_of_type_MqqOsMqqHandler != null) && (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1))) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
      }
      paramString = Message.obtain();
      paramString.what = 1;
      paramString.arg1 = ((int)((float)paramLong2 / (float)paramLong1 * 100.0F));
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramString);
      }
    }
  }
  
  void b(aawp paramaawp)
  {
    for (;;)
    {
      try
      {
        int i = paramaawp.jdField_a_of_type_Int;
        if (apdh.a(paramaawp.c))
        {
          paramaawp.jdField_a_of_type_Int = 6;
          paramaawp.jdField_a_of_type_Boolean = false;
          if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
            this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(4);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.Avatar", 2, "updateState: uin=" + paramaawp.d + ",state=" + paramaawp.jdField_a_of_type_Int + ", beforeState=" + i);
          }
          return;
        }
        if (apdh.a(paramaawp.jdField_b_of_type_JavaLangString)) {
          paramaawp.jdField_a_of_type_Int = 3;
        } else {
          paramaawp.jdField_a_of_type_Int = 0;
        }
      }
      finally {}
    }
  }
  
  public void b(BaseActivity paramBaseActivity)
  {
    paramBaseActivity.addObserver(this.jdField_a_of_type_Ajjh);
  }
  
  public void b(String paramString, int paramInt) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    Setting localSetting = null;
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.Avatar", 2, "refresh progress : " + paramMessage.arg1);
        }
        this.jdField_a_of_type_Aawp.jdField_b_of_type_Int = paramMessage.arg1;
        c(this.jdField_a_of_type_Aawp);
        return true;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.Avatar", 2, "start progress : " + paramMessage.arg1);
        }
        this.jdField_a_of_type_Aawp.jdField_b_of_type_Int = 0;
        c(this.jdField_a_of_type_Aawp);
        return true;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.Avatar", 2, "end result : " + paramMessage.arg1);
        }
        this.jdField_a_of_type_Aawp.jdField_b_of_type_Int = 100;
        this.jdField_a_of_type_Aawp.jdField_a_of_type_Boolean = false;
        b(this.jdField_a_of_type_Aawp);
        if (paramMessage.arg1 == 1)
        {
          c(this.jdField_a_of_type_Aawp);
          return true;
        }
        this.jdField_a_of_type_Aawp.jdField_a_of_type_Int = 5;
        c(this.jdField_a_of_type_Aawp);
      } while (this.jdField_a_of_type_Int >= 3);
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_JavaLangString = null;
      return true;
      a(this.jdField_b_of_type_JavaLangString);
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.Avatar", 2, "MSG_DOWNLOAD_HD_AVATAR " + paramMessage.obj);
      }
      if ((paramMessage.obj instanceof Setting)) {
        localSetting = (Setting)paramMessage.obj;
      }
      if ((localSetting != null) && (!localSetting.url.equals(this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_JavaLangString = localSetting.url;
        a(localSetting.uin, localSetting.bFaceFlags, localSetting.url);
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.profilecard.Avatar", 2, "MSG_DOWNLOAD_HD_AVATAR | has download path = " + this.jdField_a_of_type_JavaLangString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aawl
 * JD-Core Version:    0.7.0.1
 */