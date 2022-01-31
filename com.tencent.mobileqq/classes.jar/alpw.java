import android.os.AsyncTask;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import java.io.IOException;

public class alpw
  extends AsyncTask<Void, Void, String>
{
  public alpw(CardPicGalleryActivity paramCardPicGalleryActivity, URLDrawable paramURLDrawable, String paramString) {}
  
  protected String a(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(this.jdField_a_of_type_JavaLangString);
      if (paramVarArgs != null)
      {
        bacm.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity, paramVarArgs);
        return this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity.getString(2131629509) + " " + paramVarArgs;
      }
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity.getString(2131629508);
      return paramVarArgs;
    }
    catch (IOException paramVarArgs)
    {
      return this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity.getString(2131629508);
    }
    catch (OutOfMemoryError paramVarArgs) {}
    return this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity.getString(2131629508);
  }
  
  protected void a(String paramString)
  {
    bbmy.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity, paramString, 0).b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     alpw
 * JD-Core Version:    0.7.0.1
 */