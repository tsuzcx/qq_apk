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

public class akgn
  extends bbwt
{
  public akgn(SignatureManager paramSignatureManager) {}
  
  public void onCancel(bbwu parambbwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature", 2, "sigTplResDownloadListener.onCancel| task:" + parambbwu);
    }
  }
  
  @TargetApi(9)
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    if (QLog.isColorLevel()) {
      QLog.d("Signature", 2, "sigTplResDownloadListener.onDone| task:" + parambbwu);
    }
    Object localObject2 = parambbwu.a();
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
        if ((3 == parambbwu.a()) || (parambbwu.a() == 0))
        {
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
          label177:
          Object localObject1;
          if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            parambbwu = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sigResUpt", 0);
            i = parambbwu.getInt("sigTplCfgVerTemp", 0);
            parambbwu = parambbwu.edit();
            parambbwu.putInt("sigTplCfgVer", i);
            if (Build.VERSION.SDK_INT <= 8) {
              parambbwu.commit();
            }
          }
          else
          {
            if (SignatureManager.a(this.a) == null) {
              break label256;
            }
            parambbwu = new File(SignatureManager.b);
            localObject1 = SignatureManager.a(this.a);
            localObject2 = bbqd.a("signatureTemplate");
            if (!parambbwu.exists()) {
              break label258;
            }
          }
          label258:
          for (long l = parambbwu.length();; l = -1L)
          {
            ((ayxs)localObject1).a((String)localObject2, l);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Signature", 2, "[preDownload]:preDownload individual sign Success");
            return;
            parambbwu.apply();
            break label177;
            break;
          }
          if ((3 == parambbwu.a()) || (parambbwu.a() == 0))
          {
            i = ((Bundle)localObject2).getInt("dynamicType");
            localObject1 = ((Bundle)localObject2).getString("tplId");
            localObject2 = ((Bundle)localObject2).getString("fileName");
            parambbwu = null;
            switch (i)
            {
            }
            for (;;)
            {
              if (parambbwu == null) {
                break label385;
              }
              parambbwu = new File(parambbwu);
              if (!bbww.a(new File(bbqq.a((String)localObject1, (String)localObject2)), parambbwu, true)) {
                break;
              }
              this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
              return;
              parambbwu = bbqq.a((String)localObject1, "dynamic_aio");
            }
          }
        }
      }
    }
  }
  
  public boolean onStart(bbwu parambbwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature", 2, "sigTplResDownloadListener.onStart| task:" + parambbwu);
    }
    super.onStart(parambbwu);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akgn
 * JD-Core Version:    0.7.0.1
 */