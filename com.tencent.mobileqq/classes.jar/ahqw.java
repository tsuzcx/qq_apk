import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;

public class ahqw
  extends aawb
{
  ahts jdField_a_of_type_Ahts = new ahqx(this);
  
  public ahqw(AIOGalleryActivity paramAIOGalleryActivity) {}
  
  public aavk a(Activity paramActivity, aavo paramaavo)
  {
    return new ahsj(paramActivity, paramaavo, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Ahtp, AIOGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity));
  }
  
  public aavo a(Activity paramActivity)
  {
    return new ahsn(true);
  }
  
  public aavp a(Activity paramActivity, aavo paramaavo)
  {
    ahsn localahsn = (ahsn)paramaavo;
    localahsn.e = paramActivity.getIntent().getBooleanExtra("extra.IS_FROM_NEW_TROOP_CHAT_HISTORY", false);
    if (localahsn.e) {
      bdla.b(null, "dc00899", "Grp_chatRecord", "", "chatRecor_pic", "pic_exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_JavaLangString, "", "", "");
    }
    localahsn.d(4);
    localahsn.a();
    return new ahso(paramActivity, paramaavo, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Ahtp, AIOGalleryActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity));
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Ahtp == null)
    {
      BinderWarpper localBinderWarpper = (BinderWarpper)paramActivity.getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (localBinderWarpper == null) {
        break label160;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Ahtp = ahtq.a(localBinderWarpper.a);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Ahtp.a(this.jdField_a_of_type_Ahts);
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryActivity", 2, "IAIOImageProvider is " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Ahtp);
      }
    }
    boolean bool = paramActivity.getIntent().getBooleanExtra("extra.IS_GOTO_IMAGELIST", false);
    super.a(paramActivity);
    if (bool)
    {
      this.jdField_a_of_type_Boolean = paramActivity.getIntent().getBooleanExtra("extra.NO_FIRST_ENTER_ANIMATION", false);
      super.a();
      if ((this.jdField_a_of_type_Aavp != null) && ((this.jdField_a_of_type_Aavp instanceof ahso))) {
        ((ahso)this.jdField_a_of_type_Aavp).p();
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
 * Qualified Name:     ahqw
 * JD-Core Version:    0.7.0.1
 */