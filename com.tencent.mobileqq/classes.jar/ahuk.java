import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class ahuk
  implements afyl
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ahuo jdField_a_of_type_Ahuo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  private String jdField_a_of_type_JavaLangString;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int b;
  private int c;
  
  public ahuk(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, ahuo paramahuo, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
    this.jdField_a_of_type_Ahuo = paramahuo;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
  }
  
  private void a(bduk parambduk)
  {
    switch (parambduk.d)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
              } while (!QLog.isColorLevel());
              QLog.d("carverW GetUrlAction", 2, "handleMessage STATUS_RECV_FINISHED");
              return;
              this.jdField_a_of_type_Int = parambduk.g;
            } while (!QLog.isColorLevel());
            QLog.d("carverW GetUrlAction", 2, "handleMessage STATUS_RECV_ERROR  error = " + this.jdField_a_of_type_Int);
            return;
            this.jdField_a_of_type_Int = parambduk.g;
          } while (!QLog.isColorLevel());
          QLog.d("carverW GetUrlAction", 2, "handleMessage STATUS_FILE_UNSAFE  error = " + this.jdField_a_of_type_Int);
          return;
          this.jdField_a_of_type_Int = parambduk.g;
        } while (!QLog.isColorLevel());
        QLog.d("carverW GetUrlAction", 2, "handleMessage STATUS_FILE_EXPIRED  error = " + this.jdField_a_of_type_Int);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("carverW GetUrlAction", 2, "STATUS_RECV_PROCESS: get url finished urls=" + parambduk.c + " domain =" + parambduk.u + " mMsg=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
        }
      } while (parambduk.c == null);
      this.jdField_a_of_type_ArrayOfJavaLangString = parambduk.c;
      this.jdField_a_of_type_JavaLangString = parambduk.u;
      int i = 0;
      while (i < 1)
      {
        if (!bgsp.a(this.jdField_a_of_type_JavaLangString))
        {
          localObject = new StringBuilder();
          String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
          arrayOfString[i] = (arrayOfString[i] + "&txhost=" + this.jdField_a_of_type_JavaLangString);
        }
        i += 1;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (!MessageForShortVideo.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo)) || (this.jdField_a_of_type_Ahuo == null));
    Object localObject = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    this.jdField_a_of_type_Ahuo.a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Int, this.c, (String)localObject, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, parambduk.jdField_b_of_type_Int, null);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin;
    long l = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq;
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject, l);
    if ((localObject != null) && ((localObject instanceof bdsr))) {
      ((bdsr)localObject).a();
    }
    localObject = new View(BaseApplicationImpl.getApplication());
    afyj localafyj = afyj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localafyj != null) {
      localafyj.a((View)localObject, this);
    }
    localObject = bcec.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1);
    if (localObject != null) {
      bcec.a((bcev)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void a(View paramView, bduk parambduk, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq != parambduk.jdField_b_of_type_Long)) {
      if (QLog.isColorLevel()) {
        QLog.d("carverW GetUrlAction", 2, " handleMessage return file.uniseq=" + parambduk.jdField_b_of_type_Long);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("carverW GetUrlAction", 2, " handleMessage what==" + paramInt1 + ", arg1:" + paramInt2 + " fileType=" + parambduk.jdField_b_of_type_Int + " status=" + parambduk.d + " msg.id=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      }
    } while ((parambduk.jdField_b_of_type_Int != 6) && (parambduk.jdField_b_of_type_Int != 17) && (parambduk.jdField_b_of_type_Int != 9) && (parambduk.jdField_b_of_type_Int != 20));
    a(parambduk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahuk
 * JD-Core Version:    0.7.0.1
 */