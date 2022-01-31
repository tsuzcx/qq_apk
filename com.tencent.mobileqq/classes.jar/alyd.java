import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class alyd
  extends bdvu
{
  public alyd(SignatureManager paramSignatureManager) {}
  
  public void onCancel(bdvv parambdvv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature", 2, "sigTplResDownloadListener.onCancel| task:" + parambdvv);
    }
  }
  
  @TargetApi(9)
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    if (QLog.isColorLevel()) {
      QLog.d("Signature", 2, "sigTplResDownloadListener.onDone| task:" + parambdvv);
    }
    Object localObject2 = parambdvv.a();
    if (localObject2 != null) {}
    for (int i = ((Bundle)localObject2).getInt("resType");; i = 0)
    {
      switch (i)
      {
      }
      label256:
      label385:
      for (;;)
      {
        return;
        if ((3 == parambdvv.a()) || (parambdvv.a() == 0))
        {
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
          label177:
          Object localObject1;
          if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            parambdvv = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sigResUpt", 0);
            i = parambdvv.getInt("sigTplCfgVerTemp", 0);
            parambdvv = parambdvv.edit();
            parambdvv.putInt("sigTplCfgVer", i);
            if (Build.VERSION.SDK_INT <= 8) {
              parambdvv.commit();
            }
          }
          else
          {
            if (SignatureManager.a(this.a) == null) {
              break label256;
            }
            parambdvv = new File(SignatureManager.b);
            localObject1 = SignatureManager.a(this.a);
            localObject2 = bdox.a("signatureTemplate");
            if (!parambdvv.exists()) {
              break label258;
            }
          }
          label258:
          for (long l = parambdvv.length();; l = -1L)
          {
            ((bavr)localObject1).a((String)localObject2, l);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Signature", 2, "[preDownload]:preDownload individual sign Success");
            return;
            parambdvv.apply();
            break label177;
            break;
          }
          if ((3 == parambdvv.a()) || (parambdvv.a() == 0))
          {
            i = ((Bundle)localObject2).getInt("dynamicType");
            localObject1 = ((Bundle)localObject2).getString("tplId");
            localObject2 = ((Bundle)localObject2).getString("fileName");
            parambdvv = null;
            switch (i)
            {
            }
            for (;;)
            {
              if (parambdvv == null) {
                break label385;
              }
              parambdvv = new File(parambdvv);
              if (!bdvx.a(new File(bdpk.a((String)localObject1, (String)localObject2)), parambdvv, true)) {
                break;
              }
              this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
              return;
              parambdvv = bdpk.a((String)localObject1, "dynamic_aio");
            }
          }
        }
      }
    }
  }
  
  public boolean onStart(bdvv parambdvv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature", 2, "sigTplResDownloadListener.onStart| task:" + parambdvv);
    }
    super.onStart(parambdvv);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alyd
 * JD-Core Version:    0.7.0.1
 */