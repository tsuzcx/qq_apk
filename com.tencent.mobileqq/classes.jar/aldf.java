import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.qphone.base.util.QLog;

public class aldf
  implements Handler.Callback
{
  private int jdField_a_of_type_Int = -1;
  public alcv a;
  public alcw a;
  private alcx jdField_a_of_type_Alcx;
  public alcy a;
  public aleb a;
  public alee a;
  public alek a;
  public alen a;
  private aleq jdField_a_of_type_Aleq = new aldk(this);
  private Context jdField_a_of_type_AndroidContentContext;
  public ServiceConnection a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("RemoteArConfigManager");
  public ARCommonConfigInfo a;
  public ArConfigInfo a;
  public ArEffectConfig a;
  public boolean a;
  volatile boolean b = false;
  boolean c = false;
  
  public aldf()
  {
    this.jdField_a_of_type_AndroidContentServiceConnection = new aldg(this);
    this.jdField_a_of_type_Alen = new aldh(this);
    this.jdField_a_of_type_Alee = new aldi(this);
    this.jdField_a_of_type_Alek = new aldj(this);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
  }
  
  public ARCommonConfigInfo a()
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
    }
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        localObject2 = null;
        localObject1 = null;
      } while (this.jdField_a_of_type_Aleb == null);
      try
      {
        localObject1 = this.jdField_a_of_type_Aleb.a();
        localObject2 = localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("ArConfig_RemoteArConfigManager", 1, "getARCommonConfigInfo fail!", localException);
        }
      }
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("ArConfig_RemoteArConfigManager", 2, String.format("getARCommonConfigInfo arCommonConfigInfo=%s", new Object[] { localObject2 }));
    return localObject2;
  }
  
  public ArConfigInfo a()
  {
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo != null) {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
    }
    for (;;)
    {
      return localObject2;
      localObject2 = null;
      Object localObject1 = localObject2;
      if (this.jdField_a_of_type_Aleb != null) {}
      try
      {
        localObject1 = this.jdField_a_of_type_Aleb.a();
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ArConfig_RemoteArConfigManager", 2, "getArConfig|info=" + localObject1);
        return localObject1;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("ArConfig_RemoteArConfigManager", 2, "getArConfig|RemoteException e= " + localRemoteException);
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  public ArEffectConfig a()
  {
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig != null) {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig;
    }
    for (;;)
    {
      return localObject2;
      Object localObject3 = null;
      localObject2 = null;
      if (this.jdField_a_of_type_Aleb == null) {
        continue;
      }
      try
      {
        localObject1 = this.jdField_a_of_type_Aleb.a();
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ArConfig_RemoteArConfigManager", 2, "getEffectConfig|info=" + localObject1);
        return localObject1;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          Object localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d("ArConfig_RemoteArConfigManager", 2, "getEffectConfig|RemoteException e= " + localRemoteException);
            localObject1 = localObject3;
          }
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      b();
      this.jdField_a_of_type_Boolean = false;
    }
    if ((!this.b) || (this.jdField_a_of_type_AndroidContentContext != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
      this.b = false;
      this.jdField_a_of_type_AndroidContentContext = null;
      this.jdField_a_of_type_Alcv = null;
      this.jdField_a_of_type_Alcw = null;
      this.jdField_a_of_type_Alcx = null;
      this.jdField_a_of_type_Alcy = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Aleb != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_RemoteArConfigManager", 2, "downloadFaceResources type " + paramInt);
      }
    }
    try
    {
      this.jdField_a_of_type_Aleb.a(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ArConfig_RemoteArConfigManager", 2, "downloadFaceResources|RemoteException e= " + localRemoteException);
    }
  }
  
  public void a(Context paramContext, alcv paramalcv, alcy paramalcy)
  {
    a(paramContext, false, paramalcv, null, null, paramalcy);
  }
  
  public void a(Context paramContext, boolean paramBoolean, alcv paramalcv, alcw paramalcw, alcx paramalcx, alcy paramalcy)
  {
    if (paramContext == null) {
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramBoolean;
    paramContext = new Intent(this.jdField_a_of_type_AndroidContentContext, ArConfigService.class);
    this.jdField_a_of_type_AndroidContentContext.bindService(paramContext, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
    this.b = true;
    if (paramalcv != null) {
      this.jdField_a_of_type_Alcv = paramalcv;
    }
    if (paramalcw != null) {
      this.jdField_a_of_type_Alcw = paramalcw;
    }
    this.jdField_a_of_type_Alcx = paramalcx;
    this.jdField_a_of_type_Alcy = paramalcy;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (this.jdField_a_of_type_Aleb != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_Aleb.a();
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("ArConfig_RemoteArConfigManager", 2, "isFaceResConfigReady " + bool1);
        bool2 = bool1;
      }
      return bool2;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        boolean bool1 = bool3;
        if (QLog.isColorLevel())
        {
          QLog.d("ArConfig_RemoteArConfigManager", 2, "isFaceResConfigReady|RemoteException e= " + localRemoteException);
          bool1 = bool3;
        }
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aleb != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_RemoteArConfigManager", 2, "cancelDownload");
      }
    }
    try
    {
      this.jdField_a_of_type_Aleb.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ArConfig_RemoteArConfigManager", 2, "cancelDownload|RemoteException e= " + localRemoteException);
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onToolScannerActivityStateChanged state:" + paramInt + "  mConfigManager:" + this.jdField_a_of_type_Aleb);
    }
    if (this.jdField_a_of_type_Aleb != null) {
      try
      {
        this.jdField_a_of_type_Aleb.c(paramInt);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
        return;
      }
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Aleb != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_Aleb.c();
      return bool1;
    }
    catch (Exception localException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("ArConfig_RemoteArConfigManager", 2, "isArSoReady fail!", localException);
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aleb != null) {}
    try
    {
      this.jdField_a_of_type_Aleb.c();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ArConfig_RemoteArConfigManager", 2, "downloadArSo fail!", localException);
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Aleb != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_RemoteArConfigManager", 2, "downloadMiniResource type " + paramInt);
      }
    }
    try
    {
      this.jdField_a_of_type_Aleb.b(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ArConfig_RemoteArConfigManager", 2, "downloadMiniResource|RemoteException e= " + localRemoteException);
    }
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (this.jdField_a_of_type_Aleb != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_Aleb.b();
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("ArConfig_RemoteArConfigManager", 2, "isMiniResConfigReady " + bool1);
        bool2 = bool1;
      }
      return bool2;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        boolean bool1 = bool3;
        if (QLog.isColorLevel())
        {
          QLog.d("ArConfig_RemoteArConfigManager", 2, "isMiniResConfigReady|RemoteException e= " + localRemoteException);
          bool1 = bool3;
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            for (;;)
                            {
                              return false;
                              if (this.jdField_a_of_type_Alcv != null)
                              {
                                this.jdField_a_of_type_Alcv.a();
                                return false;
                                if (this.jdField_a_of_type_Alcv != null)
                                {
                                  paramMessage = paramMessage.obj;
                                  if ((paramMessage instanceof ArConfigInfo))
                                  {
                                    this.jdField_a_of_type_Alcv.a((ArConfigInfo)paramMessage);
                                    return false;
                                    if (this.jdField_a_of_type_Alcv != null)
                                    {
                                      paramMessage = paramMessage.obj;
                                      if ((paramMessage instanceof ArEffectConfig))
                                      {
                                        this.jdField_a_of_type_Alcv.a((ArEffectConfig)paramMessage);
                                        return false;
                                        if (this.jdField_a_of_type_Alcv != null) {
                                          try
                                          {
                                            if ((paramMessage.obj instanceof ARCommonConfigInfo))
                                            {
                                              this.jdField_a_of_type_Alcv.a((ARCommonConfigInfo)paramMessage.obj);
                                              return false;
                                            }
                                          }
                                          catch (Exception paramMessage)
                                          {
                                            QLog.e("ArConfig_RemoteArConfigManager", 1, "handleMessage AR_COMMON_CONFIG_UPDATE fail.", paramMessage);
                                            return false;
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          } while (this.jdField_a_of_type_Alcv == null);
                          this.jdField_a_of_type_Alcv.b();
                          this.jdField_a_of_type_Boolean = false;
                          return false;
                        } while (this.jdField_a_of_type_Alcv == null);
                        i = paramMessage.arg1;
                        j = paramMessage.arg2;
                        this.jdField_a_of_type_Alcv.a(i, j);
                        return false;
                      } while ((this.jdField_a_of_type_Alcv == null) || (!(paramMessage.obj instanceof Integer)));
                      this.jdField_a_of_type_Alcv.a(((Integer)paramMessage.obj).intValue());
                      this.jdField_a_of_type_Boolean = false;
                      return false;
                    } while (this.jdField_a_of_type_Alcw == null);
                    i = paramMessage.arg1;
                    this.jdField_a_of_type_Alcw.j_(i);
                    return false;
                  } while (this.jdField_a_of_type_Alcw == null);
                  i = paramMessage.arg1;
                  j = paramMessage.arg2;
                  this.jdField_a_of_type_Alcw.a(i, j);
                  return false;
                } while (this.jdField_a_of_type_Alcw == null);
                i = paramMessage.arg1;
                j = paramMessage.arg2;
                this.jdField_a_of_type_Alcw.b(i, j);
                return false;
              } while (this.jdField_a_of_type_Alcx == null);
              this.jdField_a_of_type_Alcx.c();
              return false;
            } while (this.jdField_a_of_type_Alcx == null);
            this.jdField_a_of_type_Alcx.d();
            return false;
          } while (this.jdField_a_of_type_Alcx == null);
          this.jdField_a_of_type_Alcx.b(paramMessage.arg1);
          return false;
        } while (this.jdField_a_of_type_Alcy == null);
        i = paramMessage.arg1;
        this.jdField_a_of_type_Alcy.a(i);
        return false;
      } while (this.jdField_a_of_type_Alcy == null);
      i = paramMessage.arg1;
      j = paramMessage.arg2;
      this.jdField_a_of_type_Alcy.a(i, j);
      return false;
    } while (this.jdField_a_of_type_Alcy == null);
    int i = paramMessage.arg1;
    int j = paramMessage.arg2;
    this.jdField_a_of_type_Alcy.b(i, j);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aldf
 * JD-Core Version:    0.7.0.1
 */