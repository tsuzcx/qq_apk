import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

class akma
  extends ayrb
{
  akma(akly paramakly) {}
  
  protected void onGetQZoneAlbumListNum(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && ((paramBundle instanceof get_albumlist_num_rsp)))
    {
      long l = ((get_albumlist_num_rsp)paramBundle).album_num;
      ((akmq)this.a.mOtherCommonData).jdField_a_of_type_Long = l;
      paramBundle = this.a.a();
      if (paramBundle != null)
      {
        paramBundle.a(((akmq)this.a.mOtherCommonData).jdField_a_of_type_Long);
        paramBundle.postData();
      }
    }
    ((akmq)this.a.mOtherCommonData).jdField_a_of_type_Boolean = false;
    BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(this.a.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akma
 * JD-Core Version:    0.7.0.1
 */