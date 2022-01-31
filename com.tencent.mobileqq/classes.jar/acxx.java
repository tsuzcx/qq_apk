import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

final class acxx
  extends AsyncTask<Void, Void, ImageInfo>
{
  acxx(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Context paramContext, String paramString) {}
  
  protected ImageInfo a(Void... paramVarArgs)
  {
    bbef.a(-1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, "image_send_prepare", "sessionInfo.handleScreenPhoto");
    String str = bbef.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    paramVarArgs = new ImageInfo();
    bbef.a(paramVarArgs, "compress_start", "sessionInfo.handleScreenPhoto");
    bbef.a(3, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, str, true, paramVarArgs, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (!bbdx.b(paramVarArgs.b)) {
      return null;
    }
    try
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      agqd.a(new String[] { str }, i, false, false, -1, localQQAppInterface);
      return paramVarArgs;
    }
    catch (Exception localException) {}
    return paramVarArgs;
  }
  
  protected void a(ImageInfo paramImageInfo)
  {
    if (paramImageInfo != null)
    {
      Object localObject = new auoe();
      ((auoe)localObject).a(paramImageInfo.b);
      ((auoe)localObject).d(1027);
      ((auoe)localObject).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramImageInfo.h == 2) {}
      for (int i = ayvw.e;; i = ayvw.d)
      {
        ((auoe)localObject).c(i);
        ((auoe)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        ((auoe)localObject).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((auoe)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        aunv localaunv = aunl.a(2, 1027);
        localaunv.a(((auoe)localObject).a());
        aunl.a(localaunv, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramImageInfo);
        bbef.a(this.jdField_a_of_type_AndroidContentContext, (List)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        return;
      }
    }
    bbef.a(-1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, "image_send_prepared_failed", "sessionInfo.handleScreenPhoto");
    bcql.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695185), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acxx
 * JD-Core Version:    0.7.0.1
 */