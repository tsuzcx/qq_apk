import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;

final class aeia
  extends AsyncTask<Void, Void, Integer>
{
  aeia(Context paramContext, int paramInt, URLDrawable paramURLDrawable, QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, PicMessageExtraData paramPicMessageExtraData) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.downloadImediatly(false);
    }
    URLDrawable.removeMemoryCacheByUrl(this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString());
    if (this.jdField_a_of_type_ComTencentImageURLDrawable.getTag() == null) {
      return Integer.valueOf(1);
    }
    paramVarArgs = ((MessageForPic)this.jdField_a_of_type_ComTencentImageURLDrawable.getTag()).path;
    paramVarArgs = aehw.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs);
    if (paramVarArgs != null)
    {
      aehw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare, paramVarArgs);
      return Integer.valueOf(2);
    }
    paramVarArgs = this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString();
    if (!ayoi.b(paramVarArgs))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryUtils", 2, "addCustomEmotionFromDownLoad fail, has file");
      }
      return Integer.valueOf(1);
    }
    File localFile = ayoi.a(paramVarArgs);
    if (localFile != null) {}
    for (paramVarArgs = SecUtil.getFileMd5(localFile.getAbsolutePath());; paramVarArgs = null)
    {
      if ((paramVarArgs == null) || ("".equals(paramVarArgs)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryUtils", 2, "addCustomEmotionFromDownLoad fail, md5 is null");
        }
        return Integer.valueOf(1);
      }
      bbdx.c(ajsd.bh + ".nomedia");
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      int i;
      StringBuilder localStringBuilder;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null) && (this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData.isDiyDouTu()))
      {
        i = 1;
        if (i == 0) {
          break label364;
        }
        localStringBuilder = new StringBuilder().append("_diydoutu@");
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData.emojiId)) {
          break label353;
        }
        str1 = "0";
      }
      label266:
      label353:
      label364:
      for (String str1 = str1;; str1 = "")
      {
        paramVarArgs = ajsd.bh + akvt.a(str2) + paramVarArgs + str1 + ".jpg";
        try
        {
          bbdx.a(localFile, new File(paramVarArgs));
          return Integer.valueOf(aehw.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare, this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData));
        }
        catch (Exception paramVarArgs)
        {
          QLog.d("AIOGalleryUtils", 1, paramVarArgs, new Object[0]);
          return Integer.valueOf(1);
        }
        i = 0;
        break;
        str1 = this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData.emojiId;
        break label266;
      }
    }
  }
  
  protected void a(Integer paramInteger)
  {
    if (paramInteger.intValue() == 1)
    {
      bcql.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 2131695182, 0).b(this.jdField_a_of_type_Int);
      askf.c("2004", 1);
    }
    while (paramInteger.intValue() != 2) {
      return;
    }
    bcql.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 1, 2131689687, 0).b(this.jdField_a_of_type_Int);
    askf.c("2003", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeia
 * JD-Core Version:    0.7.0.1
 */