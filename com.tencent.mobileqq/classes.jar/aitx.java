import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class aitx
  extends aisk
{
  int jdField_a_of_type_Int;
  aitu jdField_a_of_type_Aitu;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  String jdField_a_of_type_JavaLangString;
  
  public aitx(aitu paramaitu, SessionInfo paramSessionInfo, String paramString)
  {
    this.jdField_a_of_type_Aitu = paramaitu;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return 0;
  }
  
  @NotNull
  public Intent a(SessionInfo paramSessionInfo, String paramString)
  {
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putExtra("PicContants.NEED_COMPRESS", false);
    localIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("troop_uin", paramSessionInfo.b);
    localIntent.putExtra("key_confess_topicid", paramSessionInfo.e);
    localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    localIntent.putExtra("send_in_background", true);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
    localIntent.putExtra("PicContants.NEED_COMPRESS", false);
    localIntent.putExtra("quick_send_original_md5", this.jdField_a_of_type_Aitu.b);
    localIntent.putExtra("quick_send_original_size", this.jdField_a_of_type_Aitu.jdField_a_of_type_Long);
    localIntent.putExtra("quick_send_thumb_md5", this.jdField_a_of_type_Aitu.b);
    localIntent.putExtra("quick_send_is_ad_emo", true);
    localIntent.putExtra("quick_send_ad_emo_jump_url", this.jdField_a_of_type_Aitu.c);
    localIntent.putExtra("quick_send_ad_emo_desc_str", this.jdField_a_of_type_Aitu.d);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1047);
    localIntent.putExtra("HOT_PIC_HAS_EXTRA", true);
    return localIntent;
  }
  
  public URLDrawable.URLDrawableOptions a()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mExtraInfo = this;
    return localURLDrawableOptions;
  }
  
  public URLDrawable a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (paramURL == null) {
      return null;
    }
    paramURL = URLDrawable.getDrawable(paramURL, paramURLDrawableOptions);
    paramURL.setTag(new int[] { 0, 0, (int)paramURLDrawableOptions.mGifRoundCorner });
    return paramURL;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Aitu != null) {
      return this.jdField_a_of_type_Aitu.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public URL a()
  {
    try
    {
      if ((this.jdField_a_of_type_Aitu != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aitu.b)))
      {
        URL localURL1 = new URL("sticker_recommended_pic", "fromAIO", this.jdField_a_of_type_Aitu.b);
        if (localURL1 != null) {
          return ???;
        }
        QLog.e("StickerRecAdData", 1, "getURL url = null");
        return null;
      }
    }
    catch (Exception localException)
    {
      URL localURL2;
      for (;;)
      {
        QLog.e("StickerRecAdData", 1, "getProtocolURL error ", localException);
        localURL2 = null;
      }
      return localURL2;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecAdData", 2, "onEmoticonWillShow, index = " + paramInt);
    }
    this.jdField_a_of_type_Int = paramInt;
    new aitv().a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, a(), paramInt, this.jdField_a_of_type_Aitu.b, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecAdData", 2, "sendEmoticon");
    }
    if (this.jdField_a_of_type_Aitu == null) {}
    do
    {
      return;
      new aitv().b(paramQQAppInterface, paramSessionInfo, a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Aitu.b, this.jdField_a_of_type_JavaLangString);
      paramSessionInfo = a(paramSessionInfo, aiti.d(e()));
      if ((paramContext instanceof BaseActivity)) {
        ThreadManager.post(new SendPhotoTask((BaseActivity)paramContext, paramSessionInfo, null), 8, null, false);
      }
      paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.sendMessage(paramQQAppInterface.obtainMessage(92));
  }
  
  public int b()
  {
    return 0;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Aitu != null) {
      return this.jdField_a_of_type_Aitu.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public int c()
  {
    return 5;
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_Aitu != null) {
      return this.jdField_a_of_type_Aitu.b;
    }
    return null;
  }
  
  public String d()
  {
    return null;
  }
  
  public String e()
  {
    if (this.jdField_a_of_type_Aitu != null) {
      return this.jdField_a_of_type_Aitu.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitx
 * JD-Core Version:    0.7.0.1
 */