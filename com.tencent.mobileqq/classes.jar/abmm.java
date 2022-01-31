import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.qq.im.poi.LbsPackStatsCollector;
import com.tencent.mobileqq.armap.config.BaseCheckHandler.ItemConfig;
import com.tencent.mobileqq.armap.config.OpenBoxCheckHander;
import com.tencent.mobileqq.armap.config.OpenBoxCheckHander.OnResCheckResultListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

public class abmm
  implements Handler.Callback
{
  public abmm(OpenBoxCheckHander paramOpenBoxCheckHander) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if ((paramMessage.obj instanceof Object[]))
      {
        Object localObject3 = (Object[])paramMessage.obj;
        if (localObject3.length >= 9)
        {
          paramMessage = (String)localObject3[0];
          Object localObject1 = (String)localObject3[1];
          int i = ((Integer)localObject3[2]).intValue();
          long l1 = ((Long)localObject3[3]).longValue();
          long l2 = ((Long)localObject3[4]).longValue();
          int j = ((Integer)localObject3[5]).intValue();
          Object localObject2 = (String)localObject3[6];
          boolean bool1 = ((Boolean)localObject3[7]).booleanValue();
          localObject3 = (String)localObject3[8];
          if (QLog.isColorLevel()) {
            QLog.d(this.a.d, 2, "url: " + paramMessage + ", md5: " + (String)localObject1);
          }
          if ((TextUtils.isEmpty(paramMessage)) || (TextUtils.isEmpty((CharSequence)localObject1)))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.a.d, 2, "check resource url or md5 is empty.");
            }
            return true;
          }
          if (this.a.b.contains(paramMessage))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.a.d, 2, "check resource mCheckingUrl has contains url");
            }
            return true;
          }
          localObject1 = new BaseCheckHandler.ItemConfig(2, 10, (String)localObject1, paramMessage, new Object[] { Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(j), localObject2, Boolean.valueOf(bool1), localObject3 });
          OpenBoxCheckHander.a(this.a, (BaseCheckHandler.ItemConfig)localObject1);
          this.a.b.add(paramMessage);
          continue;
          localObject1 = (BaseCheckHandler.ItemConfig)paramMessage.obj;
          i = paramMessage.arg1;
          if (localObject1 != null)
          {
            int k;
            boolean bool2;
            OpenBoxCheckHander.OnResCheckResultListener localOnResCheckResultListener;
            if ((this.a.a != null) && (((BaseCheckHandler.ItemConfig)localObject1).jdField_a_of_type_Int == 2) && (((BaseCheckHandler.ItemConfig)localObject1).b == 10) && ((((BaseCheckHandler.ItemConfig)localObject1).jdField_a_of_type_JavaLangObject instanceof Object[])))
            {
              localObject2 = (Object[])((BaseCheckHandler.ItemConfig)localObject1).jdField_a_of_type_JavaLangObject;
              j = ((Integer)localObject2[0]).intValue();
              l1 = ((Long)localObject2[1]).longValue();
              l2 = ((Long)localObject2[2]).longValue();
              k = ((Integer)localObject2[3]).intValue();
              paramMessage = (String)localObject2[4];
              bool2 = ((Boolean)localObject2[5]).booleanValue();
              localObject2 = (String)localObject2[6];
              localObject3 = new File(((BaseCheckHandler.ItemConfig)localObject1).c, "treasure").getAbsolutePath();
              localOnResCheckResultListener = this.a.a;
              if (i != 0) {
                break label608;
              }
            }
            label608:
            for (bool1 = true;; bool1 = false)
            {
              localOnResCheckResultListener.a(bool1, j, l1, l2, k, paramMessage, bool2, (String)localObject3, (String)localObject2);
              if (i != 0) {
                LbsPackStatsCollector.a("actLbsCaiShenResourceFailure", i);
              }
              this.a.b.remove(((BaseCheckHandler.ItemConfig)localObject1).jdField_a_of_type_JavaLangString);
              break;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.a.d, 2, "result itemConfig is null");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abmm
 * JD-Core Version:    0.7.0.1
 */