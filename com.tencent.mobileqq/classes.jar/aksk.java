import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.activity.DialogActivity;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class aksk
  extends AsyncTask<Void, Integer, Boolean>
{
  WeakReference<QQAppInterface> a;
  
  public aksk(QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramQQAppInterface);
  }
  
  protected Boolean a(Void... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        Object localObject = (QQAppInterface)this.a.get();
        if (localObject == null) {
          return Boolean.valueOf(false);
        }
        if (!((QQAppInterface)localObject).isLogin()) {
          return Boolean.valueOf(false);
        }
        if (!GuardManager.jdField_a_of_type_Boolean) {
          return Boolean.valueOf(false);
        }
        aksf.a((QQAppInterface)localObject);
        if ((!aksf.jdField_a_of_type_Boolean) || (aksf.jdField_c_of_type_Boolean) || (aksf.jdField_a_of_type_AndroidContentIntent == null)) {
          return Boolean.valueOf(false);
        }
        if ((aksf.b != 0) && (Build.VERSION.SDK_INT > aksf.b)) {
          return Boolean.valueOf(false);
        }
        paramVarArgs = ((QQAppInterface)localObject).c();
        if (bcpw.a() == 0)
        {
          i = 1;
          if (i != 0)
          {
            if (!aksf.a((QQAppInterface)localObject)) {
              return Boolean.valueOf(false);
            }
            localObject = PreferenceManager.getDefaultSharedPreferences(((QQAppInterface)localObject).getApp());
            long l3 = System.currentTimeMillis();
            if (aksf.a() == -1L) {
              aksf.a(((SharedPreferences)localObject).getLong("push_open_notify_lasttime", l3));
            }
            long l1 = 0L;
            i = 0;
            int n = ((SharedPreferences)localObject).getInt("push_open_notify_stage", 1);
            int i1 = ((SharedPreferences)localObject).getInt("push_open_notify_stage_count", 0);
            int i2 = ((SharedPreferences)localObject).getInt("push_msg_notify_count", 0);
            if (n == 1)
            {
              l1 = aksf.jdField_c_of_type_Int * aksf.jdField_a_of_type_Long;
              i = aksf.d;
              j = i;
              m = i1;
              l2 = l1;
              k = n;
              if (i1 >= i)
              {
                SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
                n += 1;
                localEditor.putInt("push_open_notify_stage", n);
                localEditor.remove("push_open_notify_stage_count");
                localEditor.commit();
                i1 = 0;
                if (n == 1)
                {
                  l2 = aksf.jdField_c_of_type_Int * aksf.jdField_a_of_type_Long;
                  j = aksf.d;
                  k = n;
                  m = i1;
                }
              }
              else
              {
                if (QLog.isColorLevel()) {
                  QLog.d("PushOpenNotify", 2, new Object[] { "PopOpenMsgNotifation, stage:", Integer.valueOf(k), " stagecount:", Integer.valueOf(m), " count:", Integer.valueOf(i2), " countMax:", Integer.valueOf(j), " pushInteral:", Long.valueOf(l2), " timeDiff:", Long.valueOf(l3 - aksf.a()) });
                }
                if ((l3 - aksf.a() <= l2) && (i2 != 0)) {
                  break label754;
                }
                aksf.a(l3);
                localObject = ((SharedPreferences)localObject).edit();
                i = m + 1;
                ((SharedPreferences.Editor)localObject).putInt("push_open_notify_stage_count", i);
                ((SharedPreferences.Editor)localObject).putInt("push_msg_notify_count", i2 + 1);
                ((SharedPreferences.Editor)localObject).putLong("push_open_notify_lasttime", l3);
                if ((k == 1) && (i == 1))
                {
                  ((SharedPreferences.Editor)localObject).remove(paramVarArgs + "_" + "push_open_notify_count");
                  ((SharedPreferences.Editor)localObject).remove(paramVarArgs + "_" + "push_open_notify_open");
                  ((SharedPreferences.Editor)localObject).remove(paramVarArgs + "_" + "push_open_notify_cancle");
                }
                ((SharedPreferences.Editor)localObject).commit();
                return Boolean.valueOf(true);
              }
            }
            else
            {
              if (n == 2)
              {
                l1 = aksf.e * aksf.jdField_a_of_type_Long;
                i = aksf.f;
                continue;
              }
              if (n != 3) {
                continue;
              }
              l1 = aksf.g * aksf.jdField_a_of_type_Long;
              i = 2147483647;
              continue;
            }
            if (n == 2)
            {
              l2 = aksf.e * aksf.jdField_a_of_type_Long;
              j = aksf.f;
              m = i1;
              k = n;
              continue;
            }
            int j = i;
            int m = i1;
            long l2 = l1;
            int k = n;
            if (n != 3) {
              continue;
            }
            l1 = aksf.g;
            l2 = aksf.jdField_a_of_type_Long;
            l2 = l1 * l2;
            j = 2147483647;
            m = i1;
            k = n;
            continue;
          }
          return Boolean.valueOf(false);
        }
      }
      catch (Exception paramVarArgs)
      {
        return Boolean.valueOf(false);
      }
      label754:
      int i = 0;
    }
  }
  
  protected void a(Boolean paramBoolean)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
      if (paramBoolean.booleanValue())
      {
        if (localQQAppInterface == null) {
          return;
        }
        paramBoolean = new Intent(localQQAppInterface.getApp(), DialogActivity.class);
        paramBoolean.addFlags(268435456);
        paramBoolean.addFlags(536870912);
        paramBoolean.addFlags(67108864);
        paramBoolean.addFlags(131072);
        paramBoolean.putExtra("key_dialog_type", DialogActivity.jdField_c_of_type_Int);
        localQQAppInterface.getApp().startActivity(paramBoolean);
        return;
      }
    }
    catch (Exception paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PushOpenNotify", 2, "popOpenMsgNotifation, exception: ", paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aksk
 * JD-Core Version:    0.7.0.1
 */