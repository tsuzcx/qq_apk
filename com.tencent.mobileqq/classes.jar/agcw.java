import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;

public class agcw
  extends zep
{
  agfw jdField_a_of_type_Agfw = new agcx(this);
  
  public agcw(AIOGalleryActivity paramAIOGalleryActivity) {}
  
  public zdy a(Activity paramActivity, zec paramzec)
  {
    return new agej(paramActivity, paramzec, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Agft, AIOGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity));
  }
  
  public zec a(Activity paramActivity)
  {
    return new ages(true);
  }
  
  public zed a(Activity paramActivity, zec paramzec)
  {
    ages localages = (ages)paramzec;
    localages.e = paramActivity.getIntent().getBooleanExtra("extra.IS_FROM_NEW_TROOP_CHAT_HISTORY", false);
    if (localages.e) {
      azmj.b(null, "dc00899", "Grp_chatRecord", "", "chatRecor_pic", "pic_exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_JavaLangString, "", "", "");
    }
    localages.d(4);
    localages.a();
    return new aget(paramActivity, paramzec, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Agft, AIOGalleryActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity));
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Agft == null)
    {
      BinderWarpper localBinderWarpper = (BinderWarpper)paramActivity.getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (localBinderWarpper == null) {
        break label160;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Agft = agfu.a(localBinderWarpper.a);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Agft.a(this.jdField_a_of_type_Agfw);
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryActivity", 2, "IAIOImageProvider is " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Agft);
      }
    }
    boolean bool = paramActivity.getIntent().getBooleanExtra("extra.IS_GOTO_IMAGELIST", false);
    super.a(paramActivity);
    if (bool)
    {
      this.jdField_a_of_type_Boolean = paramActivity.getIntent().getBooleanExtra("extra.NO_FIRST_ENTER_ANIMATION", false);
      super.a();
      if ((this.jdField_a_of_type_Zed != null) && ((this.jdField_a_of_type_Zed instanceof aget))) {
        ((aget)this.jdField_a_of_type_Zed).n();
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
 * Qualified Name:     agcw
 * JD-Core Version:    0.7.0.1
 */