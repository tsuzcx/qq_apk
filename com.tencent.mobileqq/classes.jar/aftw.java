import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.List;

final class aftw
  extends AsyncTask<Void, Void, ImageInfo>
{
  aftw(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Context paramContext, String paramString) {}
  
  protected ImageInfo a(Void... paramVarArgs)
  {
    bheg.a(-1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, true, "image_send_prepare", "sessionInfo.handleScreenPhoto");
    String str = bheg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    paramVarArgs = new ImageInfo();
    bheg.a(paramVarArgs, "compress_start", "sessionInfo.handleScreenPhoto");
    bheg.a(3, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, str, true, paramVarArgs, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    if (!FileUtils.fileExistsAndNotEmpty(paramVarArgs.b)) {
      return null;
    }
    try
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType;
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      aklj.a(new String[] { str }, i, false, false, -1, localQQAppInterface);
      return paramVarArgs;
    }
    catch (Exception localException) {}
    return paramVarArgs;
  }
  
  protected void a(ImageInfo paramImageInfo)
  {
    if (paramImageInfo != null)
    {
      Object localObject = new azko();
      ((azko)localObject).a(paramImageInfo.b);
      ((azko)localObject).d(1027);
      ((azko)localObject).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      if (paramImageInfo.h == 2) {}
      for (int i = TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_RAW_PHOTO;; i = TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_PHOTO)
      {
        ((azko)localObject).c(i);
        ((azko)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin);
        ((azko)localObject).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((azko)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
        azke localazke = azjv.a(2, 1027);
        localazke.a(((azko)localObject).a());
        azjv.a(localazke, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramImageInfo);
        bheg.a(this.jdField_a_of_type_AndroidContentContext, (List)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
        return;
      }
    }
    bheg.a(-1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, true, "image_send_prepared_failed", "sessionInfo.handleScreenPhoto");
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694681), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aftw
 * JD-Core Version:    0.7.0.1
 */