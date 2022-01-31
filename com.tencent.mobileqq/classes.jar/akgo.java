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

public class akgo
  extends bbwf
{
  public akgo(SignatureManager paramSignatureManager) {}
  
  public void onCancel(bbwg parambbwg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature", 2, "sigTplResDownloadListener.onCancel| task:" + parambbwg);
    }
  }
  
  @TargetApi(9)
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    if (QLog.isColorLevel()) {
      QLog.d("Signature", 2, "sigTplResDownloadListener.onDone| task:" + parambbwg);
    }
    Object localObject2 = parambbwg.a();
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
        if ((3 == parambbwg.a()) || (parambbwg.a() == 0))
        {
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
          label177:
          Object localObject1;
          if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            parambbwg = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sigResUpt", 0);
            i = parambbwg.getInt("sigTplCfgVerTemp", 0);
            parambbwg = parambbwg.edit();
            parambbwg.putInt("sigTplCfgVer", i);
            if (Build.VERSION.SDK_INT <= 8) {
              parambbwg.commit();
            }
          }
          else
          {
            if (SignatureManager.a(this.a) == null) {
              break label256;
            }
            parambbwg = new File(SignatureManager.b);
            localObject1 = SignatureManager.a(this.a);
            localObject2 = bbpp.a("signatureTemplate");
            if (!parambbwg.exists()) {
              break label258;
            }
          }
          label258:
          for (long l = parambbwg.length();; l = -1L)
          {
            ((ayxq)localObject1).a((String)localObject2, l);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Signature", 2, "[preDownload]:preDownload individual sign Success");
            return;
            parambbwg.apply();
            break label177;
            break;
          }
          if ((3 == parambbwg.a()) || (parambbwg.a() == 0))
          {
            i = ((Bundle)localObject2).getInt("dynamicType");
            localObject1 = ((Bundle)localObject2).getString("tplId");
            localObject2 = ((Bundle)localObject2).getString("fileName");
            parambbwg = null;
            switch (i)
            {
            }
            for (;;)
            {
              if (parambbwg == null) {
                break label385;
              }
              parambbwg = new File(parambbwg);
              if (!bbwi.a(new File(bbqc.a((String)localObject1, (String)localObject2)), parambbwg, true)) {
                break;
              }
              this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
              return;
              parambbwg = bbqc.a((String)localObject1, "dynamic_aio");
            }
          }
        }
      }
    }
  }
  
  public boolean onStart(bbwg parambbwg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature", 2, "sigTplResDownloadListener.onStart| task:" + parambbwg);
    }
    super.onStart(parambbwg);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akgo
 * JD-Core Version:    0.7.0.1
 */