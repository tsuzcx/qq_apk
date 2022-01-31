import android.net.NetworkInfo;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.subtitles.EncodeRunnable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class ahll
  implements ahly
{
  private static ahll jdField_a_of_type_Ahll;
  private static String jdField_a_of_type_JavaLangString = "AudioTranslator";
  private long jdField_a_of_type_Long;
  private ahmu jdField_a_of_type_Ahmu;
  private avbq jdField_a_of_type_Avbq;
  private WeakReference<AudioCapture> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public static ahll a()
  {
    try
    {
      if (jdField_a_of_type_Ahll == null) {
        jdField_a_of_type_Ahll = new ahll();
      }
      return jdField_a_of_type_Ahll;
    }
    finally {}
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Ahmu == null) {
      return;
    }
    this.jdField_a_of_type_Ahmu.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new ahlm(this);
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Ahmu.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "tryReconnect, start");
    }
    try
    {
      if (this.jdField_a_of_type_Ahmu == null) {
        return;
      }
      if (this.jdField_a_of_type_Ahmu.jdField_a_of_type_JavaLangRefWeakReference == null) {
        return;
      }
    }
    finally {}
    e();
  }
  
  /* Error */
  private void a(ahmu paramahmu, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: iload_2
    //   10: ifeq +58 -> 68
    //   13: iload_3
    //   14: ifgt +11 -> 25
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    //   25: aload_1
    //   26: getfield 94	ahmu:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   29: ifnonnull +17 -> 46
    //   32: aload_1
    //   33: new 96	android/os/Handler
    //   36: dup
    //   37: invokestatic 102	com/tencent/mobileqq/app/ThreadManager:getSubThreadLooper	()Landroid/os/Looper;
    //   40: invokespecial 105	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   43: putfield 94	ahmu:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   46: aload_1
    //   47: getfield 94	ahmu:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   50: new 107	com/tencent/mobileqq/activity/richmedia/subtitles/AudioTranslator$3
    //   53: dup
    //   54: aload_0
    //   55: iload_3
    //   56: invokespecial 109	com/tencent/mobileqq/activity/richmedia/subtitles/AudioTranslator$3:<init>	(Lahll;I)V
    //   59: iload_3
    //   60: i2l
    //   61: invokevirtual 113	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   64: pop
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: aload_1
    //   69: getfield 94	ahmu:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   72: ifnull +16 -> 88
    //   75: aload_1
    //   76: getfield 94	ahmu:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   79: aconst_null
    //   80: invokevirtual 117	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   83: aload_1
    //   84: aconst_null
    //   85: putfield 94	ahmu:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   88: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq -26 -> 65
    //   94: getstatic 23	ahll:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   97: iconst_2
    //   98: ldc 119
    //   100: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: goto -38 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	ahll
    //   0	106	1	paramahmu	ahmu
    //   0	106	2	paramBoolean	boolean
    //   0	106	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   6	8	20	finally
    //   17	19	20	finally
    //   21	23	20	finally
    //   25	46	20	finally
    //   46	65	20	finally
    //   65	67	20	finally
    //   68	88	20	finally
    //   88	103	20	finally
  }
  
  public static boolean a(boolean paramBoolean)
  {
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    if (localNetworkInfo == null) {}
    boolean bool;
    do
    {
      return false;
      bool = localNetworkInfo.isConnected();
      if (!paramBoolean) {
        break;
      }
    } while (!AppNetConnInfo.isWifiConn());
    return true;
    return bool;
  }
  
  private void b()
  {
    try
    {
      if (this.jdField_a_of_type_Avbq != null) {
        return;
      }
      this.jdField_a_of_type_Avbq = new ahln(this);
      QQStoryContext.a().addObserver(this.jdField_a_of_type_Avbq);
      return;
    }
    finally {}
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void c()
  {
    String str1 = "";
    try
    {
      if (this.jdField_a_of_type_Ahmu == null) {
        return;
      }
      if (this.jdField_a_of_type_Ahmu.jdField_b_of_type_Int != 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, " changesession state error:" + this.jdField_a_of_type_Ahmu.jdField_b_of_type_Int);
        }
        return;
      }
    }
    finally {}
    boolean bool = this.jdField_a_of_type_Ahmu.jdField_a_of_type_Boolean;
    String str2;
    if (this.jdField_a_of_type_Ahmu.jdField_a_of_type_Long != -1L) {
      str2 = String.valueOf(this.jdField_a_of_type_Ahmu.jdField_a_of_type_Long);
    }
    ((avbo)QQStoryContext.a().getBusinessHandler(0)).a(str2, "TransInfo.ChangeSession", null, 0, 0, bool);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "changesession start:" + bool + " sessionid:" + str2);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    boolean bool;
    try
    {
      if (this.jdField_a_of_type_Ahmu == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checksession state:" + this.jdField_a_of_type_Ahmu.jdField_b_of_type_Int + "  withenglish:" + paramBoolean + " old:" + this.jdField_a_of_type_Ahmu.jdField_a_of_type_Boolean);
      }
      bool = this.jdField_a_of_type_Ahmu.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Ahmu.jdField_a_of_type_Boolean = paramBoolean;
      if (this.jdField_a_of_type_Ahmu.jdField_b_of_type_Int == 1)
      {
        if (this.jdField_a_of_type_Ahmu.jdField_a_of_type_Boolean != bool) {
          this.jdField_a_of_type_Ahmu.jdField_b_of_type_Boolean = true;
        }
        return;
      }
    }
    finally {}
    if (this.jdField_a_of_type_Ahmu.jdField_b_of_type_Int == 3)
    {
      if (this.jdField_a_of_type_Ahmu.jdField_a_of_type_Boolean != bool) {
        c();
      }
      return;
    }
    this.jdField_a_of_type_Ahmu.jdField_b_of_type_Int = 1;
    ((avbo)QQStoryContext.a().getBusinessHandler(0)).a(null, "TransInfoCreate.CreateSession", null, 0, 0, paramBoolean);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "send create session cmd");
    }
  }
  
  private void d()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Ahmu == null) {
          return;
        }
        if (this.jdField_a_of_type_Ahmu.jdField_b_of_type_Int == 0) {
          break label172;
        }
        i = 1;
        if (this.jdField_a_of_type_Ahmu.jdField_a_of_type_Long != -1L)
        {
          l = this.jdField_a_of_type_Ahmu.jdField_a_of_type_Long;
          String str1 = String.valueOf(this.jdField_a_of_type_Ahmu.jdField_a_of_type_Long);
          this.jdField_a_of_type_Ahmu.jdField_b_of_type_Int = 0;
          this.jdField_a_of_type_Ahmu.jdField_a_of_type_Long = -1L;
          this.jdField_a_of_type_Ahmu.jdField_a_of_type_Int = 0;
          this.jdField_a_of_type_Ahmu.jdField_a_of_type_Auwq = null;
          if (i != 0)
          {
            ((avbo)QQStoryContext.a().getBusinessHandler(0)).a(l);
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "send stop tcp cmd:" + str1);
            }
          }
          a(this.jdField_a_of_type_Ahmu, false, 0);
          return;
        }
      }
      finally {}
      String str2 = "";
      long l = 0L;
      continue;
      label172:
      int i = 0;
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "restart begin");
    }
    try
    {
      if (this.jdField_a_of_type_Ahmu == null) {
        return;
      }
      if (this.jdField_a_of_type_Ahmu.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        ahlo localahlo = (ahlo)this.jdField_a_of_type_Ahmu.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localahlo != null) {
          a(localahlo, this.jdField_a_of_type_Ahmu.jdField_a_of_type_Boolean, this.jdField_a_of_type_Ahmu.jdField_c_of_type_Boolean, true);
        }
      }
      return;
    }
    finally {}
  }
  
  private void f()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Ahmu == null) {
          return;
        }
        if (this.jdField_a_of_type_Ahmu.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable != null) {
          break;
        }
        this.jdField_a_of_type_Ahmu.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable = new EncodeRunnable(this, this.jdField_a_of_type_Ahmu.jdField_c_of_type_Int);
        EncodeRunnable localEncodeRunnable1 = this.jdField_a_of_type_Ahmu.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable;
        if (!this.jdField_a_of_type_Ahmu.jdField_c_of_type_Boolean)
        {
          localEncodeRunnable1.a(bool1);
          if (this.jdField_a_of_type_Ahmu.jdField_b_of_type_Int == 3) {
            this.jdField_a_of_type_Ahmu.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable.a(this.jdField_a_of_type_Ahmu.jdField_a_of_type_Long, this.jdField_a_of_type_Ahmu.jdField_a_of_type_Int);
          }
          this.jdField_a_of_type_Ahmu.jdField_a_of_type_JavaLangThread = ThreadManager.newFreeThread(this.jdField_a_of_type_Ahmu.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable, "TransAudio", 8);
          this.jdField_a_of_type_Ahmu.jdField_a_of_type_JavaLangThread.start();
          return;
        }
      }
      finally {}
      bool1 = false;
    }
    if ((this.jdField_a_of_type_Ahmu.jdField_a_of_type_JavaLangThread.isAlive()) && (!this.jdField_a_of_type_Ahmu.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "encode thread is running");
      }
      return;
    }
    this.jdField_a_of_type_Ahmu.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable.a();
    this.jdField_a_of_type_Ahmu.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable = null;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "create new EncodeThread ");
    }
    this.jdField_a_of_type_Ahmu.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable = new EncodeRunnable(this, this.jdField_a_of_type_Ahmu.jdField_c_of_type_Int);
    EncodeRunnable localEncodeRunnable2 = this.jdField_a_of_type_Ahmu.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable;
    if (!this.jdField_a_of_type_Ahmu.jdField_c_of_type_Boolean) {}
    for (bool1 = bool2;; bool1 = false)
    {
      localEncodeRunnable2.a(bool1);
      if (this.jdField_a_of_type_Ahmu.jdField_b_of_type_Int == 3) {
        this.jdField_a_of_type_Ahmu.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable.a(this.jdField_a_of_type_Ahmu.jdField_a_of_type_Long, this.jdField_a_of_type_Ahmu.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_Ahmu.jdField_a_of_type_JavaLangThread = ThreadManager.newFreeThread(this.jdField_a_of_type_Ahmu.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable, "TransAudio", 8);
      this.jdField_a_of_type_Ahmu.jdField_a_of_type_JavaLangThread.start();
      return;
    }
  }
  
  public void a(long paramLong, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null) {
      return;
    }
    String str1 = "";
    try
    {
      if (this.jdField_a_of_type_Ahmu == null) {
        return;
      }
    }
    finally {}
    if (this.jdField_a_of_type_Ahmu.jdField_b_of_type_Int != 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onEncodePackage, state not match:" + this.jdField_a_of_type_Ahmu.jdField_b_of_type_Int);
      }
      return;
    }
    if (this.jdField_a_of_type_Ahmu.jdField_a_of_type_Long != paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onEncodePackage, session not match:" + this.jdField_a_of_type_Ahmu.jdField_a_of_type_Long + "-" + paramLong);
      }
      return;
    }
    boolean bool = this.jdField_a_of_type_Ahmu.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Ahmu.jdField_a_of_type_Long != -1L) {
      str1 = String.valueOf(this.jdField_a_of_type_Ahmu.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Ahmu.jdField_b_of_type_Long = System.currentTimeMillis();
    avbo localavbo = (avbo)QQStoryContext.a().getBusinessHandler(0);
    String str2 = "";
    if (this.jdField_a_of_type_Ahmu.jdField_a_of_type_Auwq != null) {
      str2 = this.jdField_a_of_type_Ahmu.jdField_a_of_type_Auwq.jdField_a_of_type_JavaLangString;
    }
    for (int i = this.jdField_a_of_type_Ahmu.jdField_a_of_type_Auwq.jdField_a_of_type_Int;; i = 0)
    {
      localavbo.a(str1, "TransInfo.RawData", str2, i, paramByteBuffer.array(), 0, paramByteBuffer.limit(), bool, 2);
      return;
    }
  }
  
  public void a(ahlo paramahlo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    try
    {
      if (this.jdField_a_of_type_Ahmu == null) {
        return;
      }
      this.jdField_a_of_type_Ahmu.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramahlo);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "start, state:" + this.jdField_a_of_type_Ahmu.jdField_b_of_type_Int + " withenglish:" + paramBoolean1 + " rocordmode:" + paramBoolean2 + " resumecapture:" + paramBoolean3);
      }
      this.jdField_a_of_type_Ahmu.jdField_c_of_type_Boolean = paramBoolean2;
      c(paramBoolean1);
      this.jdField_a_of_type_Ahmu.jdField_a_of_type_JavaUtilHashMap.clear();
      f();
      b(true);
      if ((paramBoolean3) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
      {
        paramahlo = (AudioCapture)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramahlo != null) {
          paramahlo.d();
        }
      }
      this.jdField_a_of_type_Ahmu.jdField_c_of_type_Long = System.currentTimeMillis();
      return;
    }
    finally {}
  }
  
  public void a(AudioCapture paramAudioCapture)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "registAudioRecord :" + paramAudioCapture);
    }
    if (paramAudioCapture == null) {}
    try
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      a(false, this.jdField_c_of_type_Boolean);
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    finally {}
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAudioCapture);
    if ((this.jdField_a_of_type_Ahmu != null) && (this.jdField_a_of_type_Ahmu.jdField_a_of_type_JavaLangRefWeakReference != null)) {
      e();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "stop, pausecapture:" + paramBoolean1 + " canrestart:" + paramBoolean2);
    }
    try
    {
      b(false);
      if (this.jdField_a_of_type_Ahmu == null) {
        return;
      }
      if ((paramBoolean1) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
      {
        AudioCapture localAudioCapture = (AudioCapture)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localAudioCapture != null) {
          localAudioCapture.b();
        }
      }
      if (!paramBoolean2) {
        this.jdField_a_of_type_Ahmu.jdField_a_of_type_JavaLangRefWeakReference = null;
      }
      if ((this.jdField_a_of_type_Ahmu != null) && (this.jdField_a_of_type_Ahmu.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "stop begin:" + this.jdField_a_of_type_Ahmu.jdField_b_of_type_Int);
        }
        this.jdField_a_of_type_Ahmu.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable.a();
        this.jdField_a_of_type_Ahmu.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable = null;
      }
      d();
      return;
    }
    finally {}
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!a()) {}
    EncodeRunnable localEncodeRunnable;
    do
    {
      do
      {
        return;
      } while (paramInt2 <= 0);
      try
      {
        if (this.jdField_a_of_type_Ahmu == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "transcontext is null");
          }
          return;
        }
      }
      finally {}
      localEncodeRunnable = this.jdField_a_of_type_Ahmu.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable;
    } while (localEncodeRunnable == null);
    localEncodeRunnable.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "init, samplerate:" + paramInt1 + " channel:" + paramInt2 + " format:" + paramInt3);
    }
    try
    {
      if (this.jdField_a_of_type_Ahmu != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "create error, transcontext not null!");
        }
        return false;
      }
      this.jdField_a_of_type_Ahmu = new ahmu();
      this.jdField_a_of_type_Ahmu.jdField_c_of_type_Int = paramInt1;
      this.jdField_a_of_type_Ahmu.d = paramInt2;
      this.jdField_a_of_type_Ahmu.e = paramInt3;
      b();
      a();
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahll
 * JD-Core Version:    0.7.0.1
 */