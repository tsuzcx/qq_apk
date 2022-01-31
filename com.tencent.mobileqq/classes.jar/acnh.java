import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

final class acnh
  extends AsyncTask<Void, Void, ImageInfo>
{
  acnh(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Context paramContext, String paramString) {}
  
  protected ImageInfo a(Void... paramVarArgs)
  {
    bacm.a(-1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, "image_send_prepare", "sessionInfo.handleScreenPhoto");
    String str = bacm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    paramVarArgs = new ImageInfo();
    bacm.a(paramVarArgs, "compress_start", "sessionInfo.handleScreenPhoto");
    bacm.a(3, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, str, true, paramVarArgs, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (!bace.b(paramVarArgs.b)) {
      return null;
    }
    try
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      ageh.a(new String[] { str }, i, false, false, -1, localQQAppInterface);
      return paramVarArgs;
    }
    catch (Exception localException) {}
    return paramVarArgs;
  }
  
  protected void a(ImageInfo paramImageInfo)
  {
    if (paramImageInfo != null)
    {
      Object localObject = new atqe();
      ((atqe)localObject).a(paramImageInfo.b);
      ((atqe)localObject).d(1027);
      ((atqe)localObject).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramImageInfo.h == 2) {}
      for (int i = axvn.e;; i = axvn.d)
      {
        ((atqe)localObject).c(i);
        ((atqe)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        ((atqe)localObject).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((atqe)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        atpv localatpv = atpl.a(2, 1027);
        localatpv.a(((atqe)localObject).a());
        atpl.a(localatpv, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramImageInfo);
        bacm.a(this.jdField_a_of_type_AndroidContentContext, (List)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        return;
      }
    }
    bacm.a(-1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, "image_send_prepared_failed", "sessionInfo.handleScreenPhoto");
    bbmy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131629503), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acnh
 * JD-Core Version:    0.7.0.1
 */