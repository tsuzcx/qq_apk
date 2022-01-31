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

public class ajse
  extends batl
{
  public ajse(SignatureManager paramSignatureManager) {}
  
  public void onCancel(batm parambatm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature", 2, "sigTplResDownloadListener.onCancel| task:" + parambatm);
    }
  }
  
  @TargetApi(9)
  public void onDone(batm parambatm)
  {
    super.onDone(parambatm);
    if (QLog.isColorLevel()) {
      QLog.d("Signature", 2, "sigTplResDownloadListener.onDone| task:" + parambatm);
    }
    Object localObject2 = parambatm.a();
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
        if ((3 == parambatm.a()) || (parambatm.a() == 0))
        {
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
          label177:
          Object localObject1;
          if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            parambatm = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sigResUpt", 0);
            i = parambatm.getInt("sigTplCfgVerTemp", 0);
            parambatm = parambatm.edit();
            parambatm.putInt("sigTplCfgVer", i);
            if (Build.VERSION.SDK_INT <= 8) {
              parambatm.commit();
            }
          }
          else
          {
            if (SignatureManager.a(this.a) == null) {
              break label256;
            }
            parambatm = new File(SignatureManager.b);
            localObject1 = SignatureManager.a(this.a);
            localObject2 = bant.a("signatureTemplate");
            if (!parambatm.exists()) {
              break label258;
            }
          }
          label258:
          for (long l = parambatm.length();; l = -1L)
          {
            ((axxj)localObject1).a((String)localObject2, l);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Signature", 2, "[preDownload]:preDownload individual sign Success");
            return;
            parambatm.apply();
            break label177;
            break;
          }
          if ((3 == parambatm.a()) || (parambatm.a() == 0))
          {
            i = ((Bundle)localObject2).getInt("dynamicType");
            localObject1 = ((Bundle)localObject2).getString("tplId");
            localObject2 = ((Bundle)localObject2).getString("fileName");
            parambatm = null;
            switch (i)
            {
            }
            for (;;)
            {
              if (parambatm == null) {
                break label385;
              }
              parambatm = new File(parambatm);
              if (!bato.a(new File(baog.a((String)localObject1, (String)localObject2)), parambatm, true)) {
                break;
              }
              this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
              return;
              parambatm = baog.a((String)localObject1, "dynamic_aio");
            }
          }
        }
      }
    }
  }
  
  public boolean onStart(batm parambatm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature", 2, "sigTplResDownloadListener.onStart| task:" + parambatm);
    }
    super.onStart(parambatm);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajse
 * JD-Core Version:    0.7.0.1
 */