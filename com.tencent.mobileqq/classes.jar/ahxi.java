import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ahxi
  extends ajqr
  implements andr
{
  private volatile int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private final int jdField_b_of_type_Int = 1;
  private Bundle jdField_b_of_type_AndroidOsBundle;
  private final int c = 90000;
  
  public ahxi()
  {
    ThreadManager.post(new VipSpecialCareHandler.1(this), 8, null, true);
  }
  
  private final void a(int paramInt)
  {
    int i = this.jdField_a_of_type_Int - 1;
    this.jdField_a_of_type_Int = i;
    if (i != 0)
    {
      a("-->warning:special care set,uncorrect state,seq=" + this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = 0;
    }
    try
    {
      Bundle localBundle = this.jdField_b_of_type_AndroidOsBundle;
      i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      localBundle.putInt("error", i);
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", this.jdField_b_of_type_AndroidOsBundle);
      a(this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipSpecialCareHandler", 2, paramString);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null) {
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    }
  }
  
  public void a(Bundle paramBundle) {}
  
  public final void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle1;
    this.jdField_b_of_type_AndroidOsBundle = paramBundle2;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle1, Bundle paramBundle2)
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      a("-->current request is ongoing,can't do request yet");
      paramBundle2.putInt("error", -1);
      paramBundle1.putBundle("response", paramBundle2);
      a(paramBundle1);
      return;
    }
    this.jdField_a_of_type_Int += 1;
    a("-->do request,seq=" + this.jdField_a_of_type_Int);
    ArrayList localArrayList;
    for (;;)
    {
      try
      {
        a(paramBundle1, paramBundle2);
        if ((!"sepcial_care_delete_ring".equals(paramString)) && (!"special_care_set_ring".equals(paramString))) {
          break;
        }
        paramBundle1 = paramBundle1.getBundle("request");
        int i = paramBundle1.getInt("id", 1);
        paramBundle2 = paramBundle1.getString("uin");
        paramBundle1 = paramBundle2;
        if (paramBundle2 == null) {
          paramBundle1 = "";
        }
        paramBundle2 = new ArrayList();
        paramBundle2.add(paramBundle1);
        localArrayList = new ArrayList();
        localArrayList.add(String.valueOf(i));
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 90000L);
        }
        if (!"special_care_set_ring".equals(paramString)) {
          break label288;
        }
        if (i == 1)
        {
          ahwj.a(paramBundle2, 2, localArrayList, paramQQAppInterface);
          paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
          paramString = "specialcare_already_set" + paramBundle1;
          paramQQAppInterface.edit().putBoolean(paramString, true).commit();
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        this.jdField_a_of_type_Int = 0;
        return;
      }
      ahwj.a(paramBundle2, 3, localArrayList, paramQQAppInterface);
    }
    label288:
    ahwj.a(paramBundle2, 4, localArrayList, paramQQAppInterface);
  }
  
  public void a(Object paramObject)
  {
    if (paramObject != null) {
      switch (((Integer)paramObject).intValue())
      {
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
      a(0);
      return;
      a("-->method_type_open_switch");
      continue;
      a("-->method_type_set_sound");
      continue;
      a("-->method_type_delete_sound");
    }
  }
  
  public void b(Object paramObject)
  {
    int i = -1;
    if (paramObject != null)
    {
      i = ((Integer)paramObject).intValue();
      if (i != 10010) {
        break label48;
      }
      a("-->error:set quota limit");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
      a(i);
      return;
      label48:
      a("-->error:" + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahxi
 * JD-Core Version:    0.7.0.1
 */