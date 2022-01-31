import android.content.Context;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class agtv
  extends agti
{
  private CameraEmotionData jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public agtv(QQAppInterface paramQQAppInterface, CameraEmotionData paramCameraEmotionData)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData = paramCameraEmotionData;
    this.jdField_a_of_type_JavaLangString = ((apjm)paramQQAppInterface.getManager(333)).a(paramCameraEmotionData);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.exposeNum;
  }
  
  public URLDrawable.URLDrawableOptions a()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mExtraInfo = this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.url;
    return localURLDrawableOptions;
  }
  
  public URLDrawable a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (paramURL == null) {
      return null;
    }
    return super.a(paramURL, paramURLDrawableOptions);
  }
  
  public String a()
  {
    return null;
  }
  
  public URL a()
  {
    try
    {
      URL localURL1 = new URL("protocol_vas_extension_image", "BUSINESS_CAMERA_EMO_PANEL_DYNAMIC", this.jdField_a_of_type_JavaLangString);
      if (localURL1 == null)
      {
        QLog.e("StickerRecCameraData", 1, "StickerLocalRecData getURL url = null");
        return null;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      URL localURL2;
      for (;;)
      {
        QLog.e("StickerRecCameraData", 1, "StickerLocalRecData getURL url exception e = " + localMalformedURLException.getMessage());
        localURL2 = null;
      }
      return localURL2;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    ((apjf)paramQQAppInterface.getManager(334)).c(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    if (((paramContext instanceof BaseActivity)) && (aupu.a(paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramContext = (BaseActivity)paramContext;
      QQToast.a(paramQQAppInterface.getApp(), alpo.a(2131714772), 0).b(paramContext.getTitleBarHeight());
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    acex.a(paramQQAppInterface, paramContext, paramSessionInfo, this.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.strContext, null);
    ((apjf)paramQQAppInterface.getManager(334)).b(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.clickNum;
  }
  
  public String b()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.md5;
    if (str != null) {
      return str.toLowerCase();
    }
    return null;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int c()
  {
    return 3;
  }
  
  public String c()
  {
    return "a-";
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agtv
 * JD-Core Version:    0.7.0.1
 */