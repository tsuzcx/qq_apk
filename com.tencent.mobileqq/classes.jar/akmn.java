import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable.1;
import com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable.2;
import com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable.3;
import com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable.5;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;

public class akmn
  implements aklr, aklt, Handler.Callback
{
  private int jdField_a_of_type_Int;
  private aklr jdField_a_of_type_Aklr;
  private aklt jdField_a_of_type_Aklt;
  aklz jdField_a_of_type_Aklz = null;
  private akmm jdField_a_of_type_Akmm;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ArVideoResourceInfo jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo;
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private boolean jdField_a_of_type_Boolean;
  private aklr jdField_b_of_type_Aklr;
  private boolean jdField_b_of_type_Boolean;
  
  public akmn(aklt paramaklt, akmm paramakmm)
  {
    this.jdField_a_of_type_Aklt = paramaklt;
    this.jdField_a_of_type_Akmm = paramakmm;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private aklr a(ArVideoResourceInfo paramArVideoResourceInfo, int paramInt)
  {
    aklv localaklv = a(paramArVideoResourceInfo);
    aklr localaklr = aklx.a(this, localaklv, null);
    QLog.d("AREngine_MultiFragmentAnimRenderable", 1, "create new render here " + localaklr);
    boolean bool;
    if (localaklr != null)
    {
      if ((!TextUtils.isEmpty(paramArVideoResourceInfo.e)) && (bace.a(paramArVideoResourceInfo.e)) && (this.jdField_a_of_type_Akmm.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > paramInt + 1))
      {
        paramArVideoResourceInfo = (ArVideoResourceInfo)this.jdField_a_of_type_Akmm.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(paramInt + 1);
        if ((paramArVideoResourceInfo.jdField_d_of_type_Int == 4) && (!TextUtils.isEmpty(paramArVideoResourceInfo.e)) && (!bace.a(paramArVideoResourceInfo.e)))
        {
          if (QLog.isColorLevel()) {
            QLog.w("AREngine_MultiFragmentAnimRenderable", 2, "preload next online video, " + paramArVideoResourceInfo.jdField_d_of_type_JavaLangString + ", " + paramArVideoResourceInfo.e);
          }
          akwx.a(BaseApplicationImpl.getContext(), paramArVideoResourceInfo);
        }
      }
      if ((localaklv.jdField_a_of_type_Int != 5) || ((localaklv.jdField_a_of_type_Long != 2L) && (localaklv.jdField_a_of_type_Long != 2048L))) {
        break label292;
      }
      bool = true;
      this.jdField_a_of_type_Aklt.a().a();
      this.jdField_a_of_type_Aklt.a().a(bool, localaklv);
      if (localaklv.jdField_a_of_type_Int != 0) {
        break label297;
      }
      paramArVideoResourceInfo = (akmh)localaklv;
      this.jdField_a_of_type_Aklt.a().a(localaklv.b, localaklv.jdField_a_of_type_Int, paramArVideoResourceInfo.a);
    }
    label292:
    label297:
    do
    {
      return localaklr;
      bool = false;
      break;
      if ((localaklv.jdField_a_of_type_Int == 2) || (localaklv.jdField_a_of_type_Int == 3))
      {
        paramArVideoResourceInfo = (akmq)localaklv;
        this.jdField_a_of_type_Aklt.a().a(localaklv.b, localaklv.jdField_a_of_type_Int, paramArVideoResourceInfo.a);
        return localaklr;
      }
    } while (localaklv.jdField_a_of_type_Int != 4);
    paramArVideoResourceInfo = (akmt)localaklv;
    this.jdField_a_of_type_Aklt.a().a(localaklv.b, localaklv.jdField_a_of_type_Int, paramArVideoResourceInfo.a);
    return localaklr;
  }
  
  private aklv a(ArVideoResourceInfo paramArVideoResourceInfo)
  {
    ArCloudConfigInfo localArCloudConfigInfo = new ArCloudConfigInfo();
    localArCloudConfigInfo.jdField_d_of_type_Int = paramArVideoResourceInfo.jdField_d_of_type_Int;
    if ((QLog.isDebugVersion()) && (paramArVideoResourceInfo.jdField_d_of_type_Int != 2) && (paramArVideoResourceInfo.jdField_d_of_type_Int != 3) && (paramArVideoResourceInfo.jdField_d_of_type_Int != 4))
    {
      ThreadManager.getUIHandler().post(new MultiFragmentAnimRenderable.1(this));
      QLog.i("AREngine_MultiFragmentAnimRenderable", 2, "buildARRenderResourceInfoForFragmentAnim animInfo.type=" + paramArVideoResourceInfo.jdField_d_of_type_Int);
    }
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramArVideoResourceInfo);
    localArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject);
    localObject = new ArFeatureInfo();
    ((ArFeatureInfo)localObject).jdField_a_of_type_JavaLangString = paramArVideoResourceInfo.c;
    ((ArFeatureInfo)localObject).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Akmm.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString;
    localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo = ((ArFeatureInfo)localObject);
    localArCloudConfigInfo.jdField_c_of_type_Int = this.jdField_a_of_type_Akmm.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_c_of_type_Int;
    return akwn.a(localArCloudConfigInfo, true, this.jdField_a_of_type_Akmm.jdField_a_of_type_Long, this.jdField_a_of_type_Akmm.jdField_c_of_type_Int, this.jdField_a_of_type_Akmm.jdField_a_of_type_Float, this.jdField_a_of_type_Akmm.b, this.jdField_a_of_type_Akmm.jdField_c_of_type_Float);
  }
  
  private void b()
  {
    ArVideoResourceInfo localArVideoResourceInfo;
    aklr localaklr;
    if ((!this.jdField_a_of_type_Akmm.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_a_of_type_Akmm.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > this.jdField_a_of_type_Int + 1))
    {
      localArVideoResourceInfo = (ArVideoResourceInfo)this.jdField_a_of_type_Akmm.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int + 1);
      localaklr = a(localArVideoResourceInfo, this.jdField_a_of_type_Int + 1);
      if (localaklr == null) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 100L);
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_Aklr = this.jdField_a_of_type_Aklr;
    this.jdField_a_of_type_Aklr = localaklr;
    this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo = localArVideoResourceInfo;
    this.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_Aklt.a(new MultiFragmentAnimRenderable.2(this, localaklr));
  }
  
  public akly a()
  {
    return this.jdField_a_of_type_Aklt.a();
  }
  
  public akwu a()
  {
    return null;
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_Aklt.a();
  }
  
  public Object a(int paramInt)
  {
    return this.jdField_a_of_type_Aklt.a(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aklt.a();
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(aklr paramaklr, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void a(aklz paramaklz)
  {
    if (this.jdField_a_of_type_Aklr != null)
    {
      if ((!this.jdField_a_of_type_Aklr.e()) && (this.jdField_b_of_type_Aklr != null) && (this.jdField_a_of_type_Aklz != null))
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
        if (this.jdField_b_of_type_Aklr != null) {
          this.jdField_b_of_type_Aklr.a(this.jdField_a_of_type_Aklz);
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
    }
    else {
      return;
    }
    if (this.jdField_b_of_type_Aklr != null) {
      this.jdField_a_of_type_Aklt.a(new MultiFragmentAnimRenderable.3(this));
    }
    this.jdField_a_of_type_Aklr.a(paramaklz);
    this.jdField_a_of_type_Aklz = paramaklz;
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo)
  {
    b();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, aklt paramaklt) {}
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_Aklt.a(paramRunnable);
  }
  
  public void a(String paramString) {}
  
  public int b()
  {
    if (this.jdField_a_of_type_Aklr != null)
    {
      if ((!this.jdField_a_of_type_Aklr.e()) && (this.jdField_b_of_type_Aklr != null)) {
        return this.jdField_b_of_type_Aklr.b();
      }
      return this.jdField_a_of_type_Aklr.b();
    }
    return 5;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_MultiFragmentAnimRenderable", 2, "notifyAnimationPlayStatusChange state:" + paramInt1 + " remainTimes:" + paramInt2);
    }
    switch (paramInt1)
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
            return;
          } while (this.jdField_a_of_type_Int != 0);
          this.jdField_a_of_type_Aklt.b(paramInt1, paramInt2);
          return;
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
          return;
          if ((this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo == null) || ((!this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo.c()) && (this.jdField_a_of_type_Akmm.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() != this.jdField_a_of_type_Int + 1))) {
            break;
          }
        } while (((this.jdField_a_of_type_Akmm.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (this.jdField_a_of_type_Akmm.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (paramInt2 > 0)) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Aklr != null));
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Aklt.b(paramInt1, 0);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo.b())) {
          break;
        }
      } while (this.jdField_b_of_type_Boolean);
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Aklt.a(this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo, this);
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo.a()) || (paramInt2 > 0));
    b();
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Aklr != null)
    {
      if ((this.jdField_b_of_type_Aklr != null) && (!this.jdField_a_of_type_Aklr.e())) {
        return this.jdField_b_of_type_Aklr.c();
      }
      return this.jdField_a_of_type_Aklr.c();
    }
    return 2;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_Akmm.jdField_a_of_type_JavaLangString;
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Akmm.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      this.jdField_a_of_type_Int = 0;
      ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)this.jdField_a_of_type_Akmm.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Aklr = a(localArVideoResourceInfo, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo = localArVideoResourceInfo;
    }
    if (this.jdField_a_of_type_Aklr == null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 100L);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_Aklr.c();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Aklr != null) {
      this.jdField_a_of_type_Aklr.d();
    }
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_Aklr != null)
    {
      if ((!this.jdField_a_of_type_Aklr.e()) && (this.jdField_b_of_type_Aklr != null)) {
        return this.jdField_b_of_type_Aklr.d();
      }
      return this.jdField_a_of_type_Aklr.d();
    }
    return false;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Aklr != null) {
      this.jdField_a_of_type_Aklr.e();
    }
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_Aklr != null)
    {
      if ((this.jdField_b_of_type_Aklr != null) && (!this.jdField_a_of_type_Aklr.e())) {
        return this.jdField_b_of_type_Aklr.e();
      }
      return this.jdField_a_of_type_Aklr.e();
    }
    return false;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.w("AREngine_MultiFragmentAnimRenderable", 2, "onDestroy currentRenderable " + this.jdField_a_of_type_Aklr + "  lastRenderable " + this.jdField_b_of_type_Aklr);
    }
    if (this.jdField_a_of_type_Aklr != null)
    {
      this.jdField_a_of_type_Aklr.f();
      this.jdField_a_of_type_Aklr = null;
    }
    if (this.jdField_b_of_type_Aklr != null)
    {
      this.jdField_b_of_type_Aklr.f();
      this.jdField_b_of_type_Aklr = null;
    }
    this.jdField_a_of_type_Aklz = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_Aklt != null) {
        this.jdField_a_of_type_Aklt.a(new MultiFragmentAnimRenderable.5(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akmn
 * JD-Core Version:    0.7.0.1
 */