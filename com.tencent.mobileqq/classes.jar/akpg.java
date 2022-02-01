import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import java.util.ArrayList;

public class akpg
  extends akmu
{
  boolean a;
  
  protected akpg(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  protected void d()
  {
    if ("FromFastImage".equals(this.jdField_a_of_type_Akmr.from))
    {
      bdla.b(null, "CliOper", "", "", "0X8004D93", "0X8004D93", 0, 0, "", "", "", "");
      aklj.d();
    }
    if ("FromCamera".equals(this.jdField_a_of_type_Akmr.from)) {
      aklj.b();
    }
    super.d();
    bdla.b(null, "CliOper", "", "", "0X8005147", "0X8005147", 0, 0, "", "", "", "");
  }
  
  public void initData(Intent paramIntent)
  {
    this.jdField_a_of_type_Akmr.c = true;
    super.initData(paramIntent);
    Object localObject = (BinderWarpper)paramIntent.getParcelableExtra("binder_presendService");
    if (localObject != null)
    {
      if (PresendPicMgr.a(null) != null) {
        PresendPicMgr.a(null).b();
      }
      localObject = PresendPicMgr.b(azjn.a(((BinderWarpper)localObject).a));
      if (!"FromFastImage".equals(this.jdField_a_of_type_Akmr.from)) {
        break label238;
      }
    }
    label238:
    for (this.jdField_a_of_type_Akmr.f = 1037;; this.jdField_a_of_type_Akmr.f = 1008)
    {
      String str = (String)paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS").get(0);
      if (((NewPhotoPreviewActivity)this.mActivity).getMediaType(str) != 1)
      {
        ((PresendPicMgr)localObject).a(str, this.jdField_a_of_type_Akmr.f, 10);
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPreviewActivity", 2, "  initData , presendMgr = " + localObject + ",picpath = " + str + ",from = " + this.jdField_a_of_type_Akmr.from + ",mBusiType = " + this.jdField_a_of_type_Akmr.f);
        }
      }
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("callFromFastImage", false);
      if ("FromFastImage".equals(this.jdField_a_of_type_Akmr.from)) {
        aklj.c();
      }
      if ("FromCamera".equals(this.jdField_a_of_type_Akmr.from)) {
        aklj.a();
      }
      return;
    }
  }
  
  public void initUI()
  {
    super.initUI();
    ((NewPhotoPreviewActivity)this.mActivity).backToPhotoListBtn.setText(2131694650);
    ((NewPhotoPreviewActivity)this.mActivity).cancelTv.setVisibility(4);
    ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setVisibility(8);
    ((NewPhotoPreviewActivity)this.mActivity).selectLayout.setVisibility(8);
  }
  
  public void onBackPressed(boolean paramBoolean)
  {
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
    if (localPresendPicMgr != null) {
      if (!"FromCamera".equals(this.jdField_a_of_type_Akmr.from)) {
        break label44;
      }
    }
    label44:
    for (int i = 1016;; i = 1017)
    {
      localPresendPicMgr.a(i);
      ((NewPhotoPreviewActivity)this.mActivity).finish();
      return;
    }
  }
  
  public void onMagicStickClick(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Akmr.a != null)
    {
      bdla.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_Boolean) {
        bdla.b(null, "CliOper", "", "", "0X8004D95", "0X8004D95", 0, 0, "", "", "", "");
      }
    }
    super.onMagicStickClick(paramView, paramInt1, paramBundle, paramInt2, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akpg
 * JD-Core Version:    0.7.0.1
 */