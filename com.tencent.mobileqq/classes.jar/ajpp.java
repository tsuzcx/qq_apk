import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2.23;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr;

public class ajpp
  implements DialogInterface.OnClickListener
{
  public ajpp(FlowCameraActivity2.23 param23) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.this$0.getIntent();
    paramDialogInterface.putExtra("flow_back", 0);
    this.a.this$0.setResult(1001, paramDialogInterface);
    paramDialogInterface = null;
    if (this.a.this$0.f) {
      paramDialogInterface = this.a.this$0.a.jdField_a_of_type_Ajtl;
    }
    this.a.this$0.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.a.this$0.d, this.a.this$0.e, this.a.this$0.m, this.a.this$0.f, paramDialogInterface);
    this.a.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpp
 * JD-Core Version:    0.7.0.1
 */