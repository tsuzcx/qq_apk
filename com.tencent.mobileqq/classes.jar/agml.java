import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ScanningSurfaceView;
import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.binhai.BinHaiConstants.FrameAnimConfig;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;

class agml
  implements Runnable
{
  agml(agmj paramagmj, boolean paramBoolean, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, String paramString2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      ScanTorchActivity.b(this.jdField_a_of_type_Agmj.a, this.jdField_a_of_type_JavaLangString);
      ScanTorchActivity.e(this.jdField_a_of_type_Agmj.a, this.jdField_a_of_type_Int);
      ScanTorchActivity.f(this.jdField_a_of_type_Agmj.a, 0);
      ScanTorchActivity.g(this.jdField_a_of_type_Agmj.a, this.jdField_b_of_type_Int);
      ScanTorchActivity.h(this.jdField_a_of_type_Agmj.a, 1);
      ScanTorchActivity.d(this.jdField_a_of_type_Agmj.a, 1000L * this.c);
      ScanTorchActivity.r(this.jdField_a_of_type_Agmj.a, true);
      localObject = this.jdField_a_of_type_Agmj.a;
      boolean bool;
      if (this.d == 1)
      {
        bool = true;
        ScanTorchActivity.s((ScanTorchActivity)localObject, bool);
        ScanTorchActivity.e(this.jdField_a_of_type_Agmj.a, this.jdField_a_of_type_Long);
        ScanTorchActivity.f(this.jdField_a_of_type_Agmj.a, this.jdField_b_of_type_Long);
        ScanTorchActivity.t(this.jdField_a_of_type_Agmj.a, false);
        this.jdField_a_of_type_Agmj.a.o();
        if ((ScanTorchActivity.a(this.jdField_a_of_type_Agmj.a) == null) || (ScanTorchActivity.a(this.jdField_a_of_type_Agmj.a).getVisibility() != 0)) {
          break label552;
        }
        ScanTorchActivity.u(this.jdField_a_of_type_Agmj.a, true);
        ScanTorchActivity.a(this.jdField_a_of_type_Agmj.a).setVisibility(8);
        label250:
        if (ScanTorchActivity.b(this.jdField_a_of_type_Agmj.a) != null) {
          ScanTorchActivity.b(this.jdField_a_of_type_Agmj.a).setVisibility(8);
        }
        if (ScanTorchActivity.c(this.jdField_a_of_type_Agmj.a) != null) {
          ScanTorchActivity.c(this.jdField_a_of_type_Agmj.a).setVisibility(8);
        }
        if ((this.jdField_a_of_type_Agmj.a.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView == null) || (this.jdField_a_of_type_Agmj.a.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.getVisibility() != 0)) {
          break label567;
        }
        ScanTorchActivity.v(this.jdField_a_of_type_Agmj.a, true);
        this.jdField_a_of_type_Agmj.a.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.setVisibility(8);
        label362:
        ScanTorchActivity.a(this.jdField_a_of_type_Agmj.a).b(ScanTorchActivity.b(this.jdField_a_of_type_Agmj.a), 9, 0, null);
        if (ScanTorchActivity.a(this.jdField_a_of_type_Agmj.a) == null) {
          break label582;
        }
        QLog.d("ScanTorchActivity", 1, "onRespJoinActivity welcome config=" + ScanTorchActivity.a(this.jdField_a_of_type_Agmj.a));
        label436:
        if ((ScanTorchActivity.n(this.jdField_a_of_type_Agmj.a)) || (ScanTorchActivity.a(this.jdField_a_of_type_Agmj.a) == null) || (ScanTorchActivity.a(this.jdField_a_of_type_Agmj.a).jdField_a_of_type_Int != 1) || (ScanTorchActivity.a(this.jdField_a_of_type_Agmj.a).c <= 0)) {
          break label593;
        }
        this.jdField_a_of_type_Agmj.a.a(true, ScanTorchActivity.a(this.jdField_a_of_type_Agmj.a), new agmm(this), new agmo(this));
      }
      for (;;)
      {
        ThreadManager.post(new agmp(this), 5, null, false);
        return;
        bool = false;
        break;
        label552:
        ScanTorchActivity.u(this.jdField_a_of_type_Agmj.a, false);
        break label250;
        label567:
        ScanTorchActivity.v(this.jdField_a_of_type_Agmj.a, false);
        break label362;
        label582:
        QLog.d("ScanTorchActivity", 1, "onRespJoinActivity welcome config=null");
        break label436;
        label593:
        ScanTorchActivity.a(this.jdField_a_of_type_Agmj.a).b(ScanTorchActivity.b(this.jdField_a_of_type_Agmj.a), 10, 0, this.jdField_a_of_type_JavaLangString);
      }
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    for (Object localObject = "网络请求超时，\n请稍后再试。";; localObject = this.jdField_b_of_type_JavaLangString)
    {
      this.jdField_a_of_type_Agmj.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(336, localObject).sendToTarget();
      ScanTorchActivity.a(this.jdField_a_of_type_Agmj.a).b(ScanTorchActivity.b(this.jdField_a_of_type_Agmj.a), 10, 1, this.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agml
 * JD-Core Version:    0.7.0.1
 */