import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;

public class aegg
  extends xpw
{
  aeje jdField_a_of_type_Aeje = new aegh(this);
  
  public aegg(AIOGalleryActivity paramAIOGalleryActivity) {}
  
  public xpf a(Activity paramActivity, xpj paramxpj)
  {
    return new aeht(paramActivity, paramxpj, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Aejb, AIOGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity));
  }
  
  public xpj a(Activity paramActivity)
  {
    return new aeic(true);
  }
  
  public xpk a(Activity paramActivity, xpj paramxpj)
  {
    aeic localaeic = (aeic)paramxpj;
    localaeic.e = paramActivity.getIntent().getBooleanExtra("extra.IS_FROM_NEW_TROOP_CHAT_HISTORY", false);
    if (localaeic.e) {
      axqy.b(null, "dc00899", "Grp_chatRecord", "", "chatRecor_pic", "pic_exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_JavaLangString, "", "", "");
    }
    localaeic.d(4);
    localaeic.a();
    return new aeid(paramActivity, paramxpj, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Aejb, AIOGalleryActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity));
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Aejb == null)
    {
      BinderWarpper localBinderWarpper = (BinderWarpper)paramActivity.getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (localBinderWarpper == null) {
        break label160;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Aejb = aejc.a(localBinderWarpper.a);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Aejb.a(this.jdField_a_of_type_Aeje);
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryActivity", 2, "IAIOImageProvider is " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Aejb);
      }
    }
    boolean bool = paramActivity.getIntent().getBooleanExtra("extra.IS_GOTO_IMAGELIST", false);
    super.a(paramActivity);
    if (bool)
    {
      this.jdField_a_of_type_Boolean = paramActivity.getIntent().getBooleanExtra("extra.NO_FIRST_ENTER_ANIMATION", false);
      super.a();
      if ((this.jdField_a_of_type_Xpk != null) && ((this.jdField_a_of_type_Xpk instanceof aeid))) {
        ((aeid)this.jdField_a_of_type_Xpk).n();
      }
    }
    return;
    label160:
    throw new IllegalArgumentException("can't find Binder in Intent..");
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aegg
 * JD-Core Version:    0.7.0.1
 */