import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

class aiqr
  extends avvd
{
  aiqr(aiqq paramaiqq) {}
  
  protected void c(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && ((paramBundle instanceof get_albumlist_num_rsp)))
    {
      long l = ((get_albumlist_num_rsp)paramBundle).album_num;
      this.a.mPhotoCommonData.jdField_a_of_type_Long = l;
      paramBundle = this.a.a();
      if (paramBundle != null)
      {
        paramBundle.a(this.a.mPhotoCommonData.jdField_a_of_type_Long);
        paramBundle.postData();
      }
    }
    this.a.mPhotoCommonData.jdField_a_of_type_Boolean = false;
    BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(this.a.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqr
 * JD-Core Version:    0.7.0.1
 */