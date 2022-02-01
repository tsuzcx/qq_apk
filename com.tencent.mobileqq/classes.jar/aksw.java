import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

class aksw
  extends ayxo
{
  aksw(aksu paramaksu) {}
  
  protected void c(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && ((paramBundle instanceof get_albumlist_num_rsp)))
    {
      long l = ((get_albumlist_num_rsp)paramBundle).album_num;
      ((aktm)this.a.mOtherCommonData).jdField_a_of_type_Long = l;
      paramBundle = this.a.a();
      if (paramBundle != null)
      {
        paramBundle.a(((aktm)this.a.mOtherCommonData).jdField_a_of_type_Long);
        paramBundle.postData();
      }
    }
    ((aktm)this.a.mOtherCommonData).jdField_a_of_type_Boolean = false;
    BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(this.a.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aksw
 * JD-Core Version:    0.7.0.1
 */