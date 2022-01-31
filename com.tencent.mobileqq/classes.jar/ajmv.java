import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.45;

public class ajmv
  implements DialogInterface.OnClickListener
{
  public ajmv(NewFlowCameraActivity.45 param45) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.this$0.getIntent();
    paramDialogInterface.putExtra("flow_back", 0);
    this.a.this$0.setResult(1001, paramDialogInterface);
    this.a.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajmv
 * JD-Core Version:    0.7.0.1
 */