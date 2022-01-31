import android.content.Context;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class agyt
  extends agxx
{
  public Emoticon a;
  private String a;
  
  public agyt(Emoticon paramEmoticon)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = paramEmoticon;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.exposeNum;
  }
  
  public URLDrawable.URLDrawableOptions a()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isAPNG)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecLocalData", 2, "getURLDrawableOptions: APNG so loaded use apng image");
      }
      localURLDrawableOptions.mUseApngImage = true;
      localURLDrawableOptions.mPlayGifImage = false;
      localURLDrawableOptions.mMemoryCacheKeySuffix = "useAPNG";
    }
    return localURLDrawableOptions;
  }
  
  public URLDrawable a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (paramURL == null) {
      paramURL = null;
    }
    do
    {
      return paramURL;
      paramURLDrawableOptions = URLDrawable.getDrawable(paramURL, paramURLDrawableOptions);
      paramURL = paramURLDrawableOptions;
    } while (paramURLDrawableOptions.getStatus() == 1);
    paramURLDrawableOptions.setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
    return paramURLDrawableOptions;
  }
  
  public URL a()
  {
    try
    {
      URL localURL1 = new URL("emotion_pic", "fromAIO", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId + "_" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      if (localURL1 == null)
      {
        QLog.e("StickerRecLocalData", 1, "StickerLocalRecData getURL url = null");
        return null;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      URL localURL2;
      for (;;)
      {
        QLog.e("StickerRecLocalData", 1, "StickerLocalRecData getURL url exception e = " + localMalformedURLException.getMessage());
        localURL2 = null;
      }
      return localURL2;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    ((aufn)paramQQAppInterface.getManager(14)).a(this);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super.a(paramQQAppInterface, paramContext, paramSessionInfo);
    acjm.a(paramQQAppInterface, paramContext, paramSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isNewSoundEmoticon())) {
      aufn.a(paramQQAppInterface, "0X800A932", paramSessionInfo.a, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
    }
    ((aufn)paramQQAppInterface.getManager(14)).b(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.clickNum;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_JavaLangString != null) {
      return this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isAPNG) {}
    for (Object localObject = apvx.t.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);; localObject = apvx.s.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId))
    {
      localObject = MD5.getFileMd5((String)localObject);
      if (localObject == null) {
        break;
      }
      this.jdField_a_of_type_JavaLangString = MD5.toMD5((byte[])localObject);
      if (this.jdField_a_of_type_JavaLangString != null) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.toLowerCase();
      }
      return this.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public int c()
  {
    return 2;
  }
  
  public String c()
  {
    if (d()) {
      return "d-";
    }
    return "b-";
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.parseSoundPrintString() != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.parseSoundPrintString().isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agyt
 * JD-Core Version:    0.7.0.1
 */