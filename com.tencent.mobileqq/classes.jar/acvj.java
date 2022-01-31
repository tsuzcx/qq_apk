import android.content.Intent;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class acvj
{
  private static int jdField_a_of_type_Int;
  private static BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private long jdField_a_of_type_Long;
  private acvl jdField_a_of_type_Acvl;
  private acvm jdField_a_of_type_Acvm;
  private bafb jdField_a_of_type_Bafb;
  public boolean a;
  
  private boolean a(List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MergeForwardRevokeHelper", 2, "containCurMsg  mOriginUniSeq:" + this.jdField_a_of_type_Long);
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if (QLog.isColorLevel()) {
          QLog.d("MergeForwardRevokeHelper", 2, "containCurMsg  mr.uniseq:" + localMessageRecord.uniseq);
        }
        if (localMessageRecord.uniseq == this.jdField_a_of_type_Long) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void d(BaseActivity paramBaseActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)paramBaseActivity.getWindow().getDecorView();
    ImageView localImageView = new ImageView(paramBaseActivity);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localImageView.setImageResource(2130844319);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localViewGroup.addView(localImageView, localLayoutParams);
    if (this.jdField_a_of_type_Bafb != null) {
      this.jdField_a_of_type_Bafb.dismiss();
    }
    this.jdField_a_of_type_Bafb = babr.a(paramBaseActivity, 230).setMessage(ajjy.a(2131640765)).setPositiveButton(paramBaseActivity.getString(2131628445), new acvk(this, paramBaseActivity));
    this.jdField_a_of_type_Bafb.show();
    if (this.jdField_a_of_type_Acvl != null) {
      this.jdField_a_of_type_Acvl.a();
    }
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    jdField_a_of_type_Int += 1;
    if (QLog.isColorLevel()) {
      QLog.d("MergeForwardRevokeHelper", 2, "onCreate");
    }
    if ((paramBaseActivity.getIntent() != null) && (paramBaseActivity.getAppInterface() != null))
    {
      AppInterface localAppInterface = paramBaseActivity.getAppInterface();
      acvm localacvm = new acvm(this, paramBaseActivity, null);
      this.jdField_a_of_type_Acvm = localacvm;
      localAppInterface.addObserver(localacvm);
      this.jdField_a_of_type_Long = paramBaseActivity.getIntent().getLongExtra("origin_merge_structing_msg_uniseq", -1L);
    }
  }
  
  public void b(BaseActivity paramBaseActivity)
  {
    jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    if (QLog.isColorLevel()) {
      QLog.d("MergeForwardRevokeHelper", 2, "onResume");
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c(BaseActivity paramBaseActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MergeForwardRevokeHelper", 2, "onDestroy");
    }
    if (paramBaseActivity.getAppInterface() != null) {
      paramBaseActivity.getAppInterface().removeObserver(this.jdField_a_of_type_Acvm);
    }
    if ((this.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Bafb.isShowing())) {
      this.jdField_a_of_type_Bafb.dismiss();
    }
    this.jdField_a_of_type_Bafb = null;
    int i = jdField_a_of_type_Int - 1;
    jdField_a_of_type_Int = i;
    if (i <= 0) {
      jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acvj
 * JD-Core Version:    0.7.0.1
 */