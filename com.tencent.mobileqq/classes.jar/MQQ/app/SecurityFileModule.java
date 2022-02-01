package mqq.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;

public class SecurityFileModule
  extends QIPCModule
{
  public static final String ACTION_GET_BUSINESS_ROOT_PATH = "ACTION_GET_BUSINESS_ROOT_PATH";
  public static final String BUNDLE_KEY_RETURN_FILE_PATH = "BUNDLE_KEY_RETURN_FILE_PATH";
  public static final String BUNDLE_KEY_SECURITY_FILE_HELPER_CLASS_NAME = "BUNDLE_KEY_SECURITY_FILE_HELPER_CLASS_NAME";
  public static final String NAME = "SecurityFileModule";
  public static SecurityFileModule mInstance;
  
  public SecurityFileModule(String paramString)
  {
    super(paramString);
  }
  
  public static SecurityFileModule getInstance()
  {
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new SecurityFileModule("SecurityFileModule");
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("action = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", params = ");
      localStringBuilder.append(paramBundle);
      QLog.d("SecurityFileModule", 2, localStringBuilder.toString());
    }
    if ("ACTION_GET_BUSINESS_ROOT_PATH".equals(paramString))
    {
      if (paramBundle != null)
      {
        paramString = paramBundle.getString("BUNDLE_KEY_SECURITY_FILE_HELPER_CLASS_NAME");
        if (!TextUtils.isEmpty(paramString)) {
          try
          {
            paramBundle = Class.forName(paramString);
            if (QLog.isColorLevel()) {
              QLog.d("SecurityFileModule", 2, new Object[] { "className=", paramString, " realClassName=", paramBundle.getName() });
            }
            paramString = (ISecurityFileHelper)paramBundle.newInstance();
          }
          catch (InstantiationException paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SecurityFileModule", 2, paramString.getMessage());
            }
          }
          catch (IllegalAccessException paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SecurityFileModule", 2, paramString.getMessage());
            }
          }
          catch (ClassNotFoundException paramString)
          {
            QLog.d("SecurityFileModule", 1, paramString.getMessage());
          }
        }
      }
      paramString = null;
      if (QLog.isColorLevel())
      {
        if (paramString == null)
        {
          paramBundle = "helper = null ";
        }
        else
        {
          paramBundle = new StringBuilder();
          paramBundle.append("helper=");
          paramBundle.append(paramString.declareBusinessFileName());
          paramBundle = paramBundle.toString();
        }
        QLog.d("SecurityFileModule", 2, paramBundle);
      }
      paramBundle = ((SecurityFileFrameworkManagerImpl)MobileQQ.sMobileQQ.waitAppRuntime(null).getManager(8)).getUINRootFile(paramString);
      if (QLog.isColorLevel())
      {
        if (paramBundle == null)
        {
          paramString = "result = null";
        }
        else
        {
          paramString = new StringBuilder();
          paramString.append("result = ");
          paramString.append(paramBundle.getAbsolutePath());
          paramString = paramString.toString();
        }
        QLog.d("SecurityFileModule", 2, paramString);
      }
      paramString = new Bundle();
      if (paramBundle == null) {
        paramString.putString("BUNDLE_KEY_RETURN_FILE_PATH", "");
      } else {
        paramString.putString("BUNDLE_KEY_RETURN_FILE_PATH", paramBundle.getAbsolutePath());
      }
      return EIPCResult.createSuccessResult(paramString);
    }
    paramBundle = new StringBuilder();
    paramBundle.append("Action=");
    paramBundle.append(paramString);
    paramBundle.append(" Not Found");
    return EIPCResult.createExceptionResult(new Throwable(paramBundle.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.SecurityFileModule
 * JD-Core Version:    0.7.0.1
 */