import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ajlz
  implements SeekBar.OnSeekBarChangeListener
{
  public ajlz(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    this.a.c = paramInt;
    if (paramBoolean) {
      NewFlowCameraActivity.a(this.a, this.a.c, false);
    }
    float f = this.a.c / 100.0F;
    if (f != this.a.jdField_a_of_type_Float)
    {
      this.a.jdField_a_of_type_Float = f;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a(false, this.a.jdField_a_of_type_Float, this.a.c);
      }
    }
    if (paramBoolean) {
      NewFlowCameraActivity.a(this.a).setContentDescription(alpo.a(2131707851) + this.a.c + "%");
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if (this.a.jdField_a_of_type_Bhoe != null) {
      this.a.jdField_a_of_type_Bhoe.removeMessages(1011);
    }
    if (this.a.e != null) {
      this.a.e.setVisibility(0);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (this.a.jdField_a_of_type_Float >= 0.0F)
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("beauty_setting", 0);
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localSharedPreferences.edit().putFloat("beauty_radius" + str, this.a.jdField_a_of_type_Float);
      localSharedPreferences.edit().putFloat("beauty_whitenmag" + str, this.a.jdField_a_of_type_Float);
      localSharedPreferences.edit().putInt("beauty_level" + str, paramSeekBar.getProgress());
      localSharedPreferences.edit().commit();
      if (QLog.isColorLevel()) {
        QLog.d("beauty", 2, "onStopTrackingTouch mBeautyValue" + this.a.jdField_a_of_type_Float + " mBeautyProcess=" + paramSeekBar.getProgress());
      }
      if (this.a.jdField_a_of_type_Bhoe != null)
      {
        this.a.jdField_a_of_type_Bhoe.removeMessages(1011);
        this.a.jdField_a_of_type_Bhoe.sendEmptyMessageDelayed(1011, NewFlowCameraActivity.jdField_a_of_type_Long);
      }
      if (this.a.e != null) {
        this.a.e.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlz
 * JD-Core Version:    0.7.0.1
 */