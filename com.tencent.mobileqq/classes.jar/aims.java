import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoPreviewActivity.ImageAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicBase;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.ae.camera.core.AECircleBroadcastReceiver;
import java.util.ArrayList;
import java.util.HashMap;

public class aims
  extends PhotoPreviewLogicBase<NewPhotoPreviewActivity>
  implements bkon
{
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private AECircleBroadcastReceiver jdField_a_of_type_DovComQqImAeCameraCoreAECircleBroadcastReceiver = new AECircleBroadcastReceiver(this);
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  
  public aims(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaLangString == null) && (Build.VERSION.SDK_INT >= 21) && (this.jdField_b_of_type_Boolean))
    {
      if (!bdee.a())
      {
        QQToast.a(this.mActivity, alpo.a(2131689825), 0).b(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131298914));
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      a(true);
      return;
    }
    if (this.mPhotoCommonData.selectedPhotoList.size() == 0)
    {
      if (a(((NewPhotoPreviewActivity)this.mActivity).getMediaInfo(this.jdField_b_of_type_JavaLangString)))
      {
        QQToast.a(this.mActivity, alpo.a(2131689826), 0).b(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131298914));
        return;
      }
      this.mPhotoCommonData.selectedPhotoList.add(this.jdField_b_of_type_JavaLangString);
    }
    bllk.a(this.jdField_b_of_type_Int, this.mActivity, this.mPhotoCommonData, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Boolean);
    ((NewPhotoPreviewActivity)this.mActivity).finish();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECircleBroadcastReceiver.b(this.mActivity);
    a(false);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.mActivity != null) && (!((NewPhotoPreviewActivity)this.mActivity).isFinishing()))
    {
      if (!paramBoolean) {
        break label81;
      }
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.mActivity, 2131755801);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559438);
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
    label81:
    while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    return (paramLocalMediaInfo != null) && ("image/gif".equals(paramLocalMediaInfo.mMimeType));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_Boolean) {
      a();
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECircleBroadcastReceiver.b(this.mActivity);
    super.doOnDestroy();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = ((NewPhotoPreviewActivity)this.mActivity).adapter.getItem(paramInt);
    this.jdField_b_of_type_JavaLangString = str;
    int i;
    if (((NewPhotoPreviewActivity)this.mActivity).getMediaType(str) == 1)
    {
      i = 1;
      if (i == 0) {
        break label75;
      }
      ((NewPhotoPreviewActivity)this.mActivity).selectLayout.setVisibility(8);
    }
    for (;;)
    {
      return super.getView(paramInt, paramView, paramViewGroup);
      i = 0;
      break;
      label75:
      ((NewPhotoPreviewActivity)this.mActivity).selectLayout.setVisibility(0);
    }
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("choosed_num", 0);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("res_path");
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("isneed_edit", this.jdField_b_of_type_Boolean);
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECircleBroadcastReceiver.a(this.mActivity);
      azfj.a().a("CMD_DOWNLOAD_PTU_BASE_RES", new Bundle());
    }
  }
  
  public void initUI()
  {
    super.initUI();
    ((NewPhotoPreviewActivity)this.mActivity).selectLayout.setVisibility(8);
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setOnClickListener(new aimt(this));
  }
  
  public void onSelectClick(View paramView)
  {
    int i = ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion();
    if (i != -1) {}
    for (String str = (String)this.mPhotoPreviewData.paths.get(i);; str = "")
    {
      LocalMediaInfo localLocalMediaInfo = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo(str);
      int j = bdar.getMediaType(localLocalMediaInfo);
      if (!this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(i)))
      {
        if (this.mPhotoCommonData.needMediaInfo) {
          this.mPhotoCommonData.selectedMediaInfoHashMap.put(str, localLocalMediaInfo);
        }
        if (this.jdField_a_of_type_Int == 9)
        {
          QQToast.a(this.mActivity, alpo.a(2131689827), 0).b(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131298914));
          return;
        }
        if (a(localLocalMediaInfo))
        {
          QQToast.a(this.mActivity, alpo.a(2131689826), 0).b(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131298914));
          return;
        }
        if ((j == 1) && (this.jdField_a_of_type_Int != 0))
        {
          QQToast.a(this.mActivity, alpo.a(2131689828), 0).b(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131298914));
          return;
        }
        if (j != 1) {}
      }
      for (;;)
      {
        super.onSelectClick(paramView);
        this.jdField_a_of_type_Int = this.mPhotoCommonData.selectedPhotoList.size();
        return;
        if (this.mPhotoCommonData.needMediaInfo) {
          this.mPhotoCommonData.selectedMediaInfoHashMap.remove(str);
        }
      }
    }
  }
  
  public void updateButton()
  {
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setClickable(true);
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setBackgroundResource(2130837723);
    super.updateButton();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aims
 * JD-Core Version:    0.7.0.1
 */