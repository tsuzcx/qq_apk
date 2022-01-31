import android.os.AsyncTask;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.io.IOException;

public class abgw
  extends AsyncTask
{
  public abgw(CardPicGalleryActivity paramCardPicGalleryActivity, URLDrawable paramURLDrawable, String paramString) {}
  
  protected String a(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(this.jdField_a_of_type_JavaLangString);
      if (paramVarArgs != null)
      {
        ImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity, paramVarArgs);
        return this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity.getString(2131434565) + " " + paramVarArgs;
      }
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity.getString(2131434566);
      return paramVarArgs;
    }
    catch (IOException paramVarArgs)
    {
      return this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity.getString(2131434566);
    }
    catch (OutOfMemoryError paramVarArgs) {}
    return this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity.getString(2131434566);
  }
  
  protected void a(String paramString)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity, paramString, 0).b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abgw
 * JD-Core Version:    0.7.0.1
 */