import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.List;

final class aepk
  extends AsyncTask<Void, Void, ImageInfo>
{
  aepk(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Context paramContext, String paramString) {}
  
  protected ImageInfo a(Void... paramVarArgs)
  {
    bdda.a(-1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, "image_send_prepare", "sessionInfo.handleScreenPhoto");
    String str = bdda.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    paramVarArgs = new ImageInfo();
    bdda.a(paramVarArgs, "compress_start", "sessionInfo.handleScreenPhoto");
    bdda.a(3, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, str, true, paramVarArgs, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (!bdcs.b(paramVarArgs.b)) {
      return null;
    }
    try
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      aild.a(new String[] { str }, i, false, false, -1, localQQAppInterface);
      return paramVarArgs;
    }
    catch (Exception localException) {}
    return paramVarArgs;
  }
  
  protected void a(ImageInfo paramImageInfo)
  {
    if (paramImageInfo != null)
    {
      Object localObject = new awfm();
      ((awfm)localObject).a(paramImageInfo.b);
      ((awfm)localObject).d(1027);
      ((awfm)localObject).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramImageInfo.h == 2) {}
      for (int i = batv.e;; i = batv.d)
      {
        ((awfm)localObject).c(i);
        ((awfm)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        ((awfm)localObject).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((awfm)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        awfc localawfc = awes.a(2, 1027);
        localawfc.a(((awfm)localObject).a());
        awes.a(localawfc, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramImageInfo);
        bdda.a(this.jdField_a_of_type_AndroidContentContext, (List)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        return;
      }
    }
    bdda.a(-1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, "image_send_prepared_failed", "sessionInfo.handleScreenPhoto");
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695343), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aepk
 * JD-Core Version:    0.7.0.1
 */