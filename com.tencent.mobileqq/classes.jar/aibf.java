import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;

public class aibf
  extends abkg
{
  aiec jdField_a_of_type_Aiec = new aibg(this);
  
  public aibf(AIOGalleryActivity paramAIOGalleryActivity) {}
  
  public abjp a(Activity paramActivity, abjt paramabjt)
  {
    return new aics(paramActivity, paramabjt, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Aidz, AIOGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity));
  }
  
  public abjt a(Activity paramActivity)
  {
    return new aicx(true);
  }
  
  public abju a(Activity paramActivity, abjt paramabjt)
  {
    aicx localaicx = (aicx)paramabjt;
    localaicx.e = paramActivity.getIntent().getBooleanExtra("extra.IS_FROM_NEW_TROOP_CHAT_HISTORY", false);
    if (localaicx.e) {
      bdll.b(null, "dc00899", "Grp_chatRecord", "", "chatRecor_pic", "pic_exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_JavaLangString, "", "", "");
    }
    localaicx.d(4);
    localaicx.a();
    return new aicy(paramActivity, paramabjt, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Aidz, AIOGalleryActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity));
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Aidz == null)
    {
      BinderWarpper localBinderWarpper = (BinderWarpper)paramActivity.getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (localBinderWarpper == null) {
        break label160;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Aidz = aiea.a(localBinderWarpper.a);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Aidz.a(this.jdField_a_of_type_Aiec);
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryActivity", 2, "IAIOImageProvider is " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Aidz);
      }
    }
    boolean bool = paramActivity.getIntent().getBooleanExtra("extra.IS_GOTO_IMAGELIST", false);
    super.a(paramActivity);
    if (bool)
    {
      this.jdField_a_of_type_Boolean = paramActivity.getIntent().getBooleanExtra("extra.NO_FIRST_ENTER_ANIMATION", false);
      super.a();
      if ((this.jdField_a_of_type_Abju != null) && ((this.jdField_a_of_type_Abju instanceof aicy))) {
        ((aicy)this.jdField_a_of_type_Abju).p();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aibf
 * JD-Core Version:    0.7.0.1
 */