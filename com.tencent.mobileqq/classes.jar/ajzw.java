import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.1;
import com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.2;
import com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.3;
import com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.4;
import com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.5;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class ajzw
  extends bocn
  implements View.OnClickListener
{
  private MediaRecorder jdField_a_of_type_AndroidMediaMediaRecorder;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bixr jdField_a_of_type_Bixr;
  private Runnable jdField_a_of_type_JavaLangRunnable = new QFaceUnlockCameraCaptureUnit.1(this);
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private Button jdField_d_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private String jdField_d_of_type_JavaLangString;
  private int e = 155;
  private int f = 211;
  
  public ajzw(bqai parambqai, bqah parambqah)
  {
    super(parambqai, parambqah);
  }
  
  private Camera.Size a(List<Camera.Size> paramList1, List<Camera.Size> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null))
    {
      paramList2 = null;
      return paramList2;
    }
    HashSet localHashSet = new HashSet(paramList1);
    Iterator localIterator = paramList2.iterator();
    paramList1 = null;
    int i = -1;
    for (;;)
    {
      paramList2 = paramList1;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList2 = (Camera.Size)localIterator.next();
      if (localHashSet.contains(paramList2))
      {
        int j = paramList2.width * paramList2.height;
        if (j > i)
        {
          i = j;
          paramList1 = paramList2;
        }
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new QFaceUnlockCameraCaptureUnit.4(this, paramBoolean));
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaRecorder != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setPreviewDisplay(null);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOnErrorListener(null);
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFaceUnlockCameraCaptureUnit", 0, "releaseRecord begin");
      }
      this.jdField_a_of_type_AndroidMediaMediaRecorder.release();
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidOsHandler.post(new QFaceUnlockCameraCaptureUnit.5(this));
      }
      if (QLog.isColorLevel()) {
        QLog.i("QFaceUnlockCameraCaptureUnit", 0, "releaseRecord end");
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        QLog.e("QFaceUnlockCameraCaptureUnit", 1, "releaseRecord failed, IllegalStateException: " + localIllegalStateException.getMessage());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QFaceUnlockCameraCaptureUnit", 1, "releaseRecord failed, Exception: " + localException.getMessage());
      }
    }
    this.jdField_a_of_type_AndroidMediaMediaRecorder = null;
  }
  
  private void l()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_AndroidWidgetButton.setText(2131698104);
    this.jdField_d_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_d_of_type_Int = 0;
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void n()
  {
    ThreadManager.getSubThreadHandler().post(new QFaceUnlockCameraCaptureUnit.3(this));
  }
  
  protected int a()
  {
    return 2131559170;
  }
  
  public View a()
  {
    View localView = super.a();
    ((TextView)localView.findViewById(2131364153)).setOnClickListener(this);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setFunctionFlag(3);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.f();
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131374091));
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_d_of_type_AndroidWidgetButton.setText(2131698104);
    this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_d_of_type_Int = 0;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131366837));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131366272));
    int i = agej.a(this.e, a().getResources());
    this.jdField_a_of_type_Bixr = new bixr();
    this.jdField_a_of_type_Bixr.a(agej.a(this.e + this.f, a().getResources()));
    this.jdField_a_of_type_Bixr.a(i);
    this.jdField_a_of_type_Bixr.b(1);
    if (Build.VERSION.SDK_INT > 15) {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackground(this.jdField_a_of_type_Bixr);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377955));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131376425));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131366275));
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
      return localView;
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(this.jdField_a_of_type_Bixr);
    }
  }
  
  protected bbhn a()
  {
    bbhn localbbhn = super.a();
    localbbhn.l(3);
    localbbhn.i(1);
    localbbhn.a(false);
    return localbbhn;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("QFaceUnlockCameraCaptureUnit", 0, "onActivityResult");
    }
  }
  
  public void a(Bundle paramBundle)
  {
    a().getWindow().setFlags(1024, 1024);
    a().requestWindowFeature(1);
    super.a(paramBundle);
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bqai.a().getIntent().getStringExtra("key_face_unlock_code");
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_c_of_type_JavaLangString = "6978";
      QLog.e("QFaceUnlockCameraCaptureUnit", 1, "verification code is null, use default code");
    }
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    super.a(paramVideoCaptureResult);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    ThreadManager.getUIHandler().post(new QFaceUnlockCameraCaptureUnit.2(this));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    super.a(paramBoolean, paramString);
    if (paramBoolean)
    {
      this.jdField_d_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    QLog.e("QFaceUnlockCameraCaptureUnit", 1, "Camera start fail!");
  }
  
  public boolean a()
  {
    return super.a();
  }
  
  public void c()
  {
    super.c();
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.i("QFaceUnlockCameraCaptureUnit", 0, "onActivityPause");
    }
    b(false);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.i("QFaceUnlockCameraCaptureUnit", 0, "onDestroy");
    }
  }
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.i("QFaceUnlockCameraCaptureUnit", 0, "onActivityResume");
    }
  }
  
  public void g()
  {
    int i = 0;
    l();
    if (aqql.d()) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(8);
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
        if (this.jdField_c_of_type_Boolean) {
          i = 8;
        }
        localViewGroup.setVisibility(i);
      }
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
    }
  }
  
  public void h()
  {
    super.h();
  }
  
  protected void i()
  {
    super.i();
  }
  
  public void j() {}
  
  public void k() {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364153)
    {
      a().finish();
      a().overridePendingTransition(2130772037, 2130772243);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131374091: 
        if (this.jdField_c_of_type_Int == 0)
        {
          this.jdField_c_of_type_Int = 1;
          this.jdField_d_of_type_AndroidWidgetButton.setText(2131698106);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          n();
        }
        else if (this.jdField_c_of_type_Int == 1)
        {
          this.jdField_d_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_c_of_type_Int = 2;
          b(true);
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzw
 * JD-Core Version:    0.7.0.1
 */