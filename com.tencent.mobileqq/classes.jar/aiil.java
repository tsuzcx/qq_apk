import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import mqq.app.AppRuntime;

public class aiil
  extends aihn
{
  public Emoticon a;
  private String a;
  
  public aiil(Emoticon paramEmoticon)
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
  
  public String a()
  {
    String str = null;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool;
    if ((localObject instanceof QQAppInterface))
    {
      bool = ((asih)((AppRuntime)localObject).getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      if (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isAPNG) {
        break label137;
      }
      localObject = EmoticonUtils.emoticonEncryptExtensionApngUrl.replace("[eIdSub]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId.substring(0, 2)).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      if (!bool) {
        break label125;
      }
      str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.extensionWidth);
      localObject = ((String)localObject).replace("[width]", str);
      if (!bool) {
        break label131;
      }
    }
    label131:
    for (str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.extensionHeight);; str = "200")
    {
      str = ((String)localObject).replace("[height]", str);
      return str;
      label125:
      str = "200";
      break;
    }
    label137:
    localObject = EmoticonUtils.emoticonEncryptExtensionUrl.replace("[eIdSub]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId.substring(0, 2)).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
    if (bool)
    {
      str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.extensionWidth);
      localObject = ((String)localObject).replace("[width]", str);
      if (!bool) {
        break label222;
      }
    }
    label222:
    for (str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.extensionHeight);; str = "200")
    {
      return ((String)localObject).replace("[height]", str);
      str = "200";
      break;
    }
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
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    ((awyr)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(this);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super.a(paramQQAppInterface, paramContext, paramSessionInfo);
    admh.a(paramQQAppInterface, paramContext, paramSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isNewSoundEmoticon())) {
      awyr.a(paramQQAppInterface, "0X800A932", paramSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
    }
    ((awyr)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.clickNum;
  }
  
  public int c()
  {
    return 2;
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_JavaLangString != null) {
      return this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isAPNG) {}
    for (Object localObject = EmoticonUtils.emoticonAPNGPath.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);; localObject = EmoticonUtils.emoticonEncryptPath.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId))
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
  
  public String d()
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
 * Qualified Name:     aiil
 * JD-Core Version:    0.7.0.1
 */