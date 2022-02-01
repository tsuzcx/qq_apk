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

final class afcr
  extends AsyncTask<Void, Void, ImageInfo>
{
  afcr(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Context paramContext, String paramString) {}
  
  protected ImageInfo a(Void... paramVarArgs)
  {
    bfvo.a(-1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, true, "image_send_prepare", "sessionInfo.handleScreenPhoto");
    String str = bfvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    paramVarArgs = new ImageInfo();
    bfvo.a(paramVarArgs, "compress_start", "sessionInfo.handleScreenPhoto");
    bfvo.a(3, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, str, true, paramVarArgs, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    if (!FileUtils.fileExistsAndNotEmpty(paramVarArgs.b)) {
      return null;
    }
    try
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType;
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      ajpv.a(new String[] { str }, i, false, false, -1, localQQAppInterface);
      return paramVarArgs;
    }
    catch (Exception localException) {}
    return paramVarArgs;
  }
  
  protected void a(ImageInfo paramImageInfo)
  {
    if (paramImageInfo != null)
    {
      Object localObject = new ayec();
      ((ayec)localObject).a(paramImageInfo.b);
      ((ayec)localObject).d(1027);
      ((ayec)localObject).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      if (paramImageInfo.h == 2) {}
      for (int i = TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_RAW_PHOTO;; i = TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_PHOTO)
      {
        ((ayec)localObject).c(i);
        ((ayec)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin);
        ((ayec)localObject).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((ayec)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
        ayds localayds = aydj.a(2, 1027);
        localayds.a(((ayec)localObject).a());
        aydj.a(localayds, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramImageInfo);
        bfvo.a(this.jdField_a_of_type_AndroidContentContext, (List)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
        return;
      }
    }
    bfvo.a(-1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, true, "image_send_prepared_failed", "sessionInfo.handleScreenPhoto");
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694480), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afcr
 * JD-Core Version:    0.7.0.1
 */