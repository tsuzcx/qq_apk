import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class aejc
  implements acwf
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aejg jdField_a_of_type_Aejg;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  private String jdField_a_of_type_JavaLangString;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int b;
  private int c;
  
  public aejc(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, aejg paramaejg, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
    this.jdField_a_of_type_Aejg = paramaejg;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
  }
  
  public void a()
  {
    Object localObject = new View(BaseApplicationImpl.getApplication());
    acwd localacwd = acwd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localacwd != null) {
      localacwd.a((View)localObject, this);
    }
    localObject = axdo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1);
    if (localObject != null) {
      axdo.a((axeg)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void a(View paramView, ayqm paramayqm, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq != paramayqm.jdField_b_of_type_Long)) {
      if (QLog.isColorLevel()) {
        QLog.d("carverW GetUrlAction", 2, " handleMessage return file.uniseq=" + paramayqm.jdField_b_of_type_Long);
      }
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
                do
                {
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d("carverW GetUrlAction", 2, " handleMessage what==" + paramInt1 + ", arg1:" + paramInt2 + " fileType=" + paramayqm.jdField_b_of_type_Int + " status=" + paramayqm.d + " msg.id=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
                  }
                } while ((paramayqm.jdField_b_of_type_Int != 6) && (paramayqm.jdField_b_of_type_Int != 17) && (paramayqm.jdField_b_of_type_Int != 9) && (paramayqm.jdField_b_of_type_Int != 20));
                switch (paramayqm.d)
                {
                case 2004: 
                default: 
                  return;
                case 2002: 
                  if (QLog.isColorLevel()) {
                    QLog.d("carverW GetUrlAction", 2, "STATUS_RECV_PROCESS: get url finished urls=" + paramayqm.c + " domain =" + paramayqm.u + " mMsg=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
                  }
                  break;
                }
              } while (paramayqm.c == null);
              this.jdField_a_of_type_ArrayOfJavaLangString = paramayqm.c;
              this.jdField_a_of_type_JavaLangString = paramayqm.u;
              paramInt1 = 0;
              while (paramInt1 < 1)
              {
                if (!bbjw.a(this.jdField_a_of_type_JavaLangString))
                {
                  paramView = new StringBuilder();
                  String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
                  arrayOfString[paramInt1] = (arrayOfString[paramInt1] + "&txhost=" + this.jdField_a_of_type_JavaLangString);
                }
                paramInt1 += 1;
              }
            } while (!QLog.isColorLevel());
            QLog.d("carverW GetUrlAction", 2, "handleMessage STATUS_RECV_FINISHED");
            return;
            this.jdField_a_of_type_Int = paramayqm.g;
          } while (!QLog.isColorLevel());
          QLog.d("carverW GetUrlAction", 2, "handleMessage STATUS_RECV_ERROR  error = " + this.jdField_a_of_type_Int);
          return;
          this.jdField_a_of_type_Int = paramayqm.g;
        } while (!QLog.isColorLevel());
        QLog.d("carverW GetUrlAction", 2, "handleMessage STATUS_FILE_UNSAFE  error = " + this.jdField_a_of_type_Int);
        return;
        this.jdField_a_of_type_Int = paramayqm.g;
      } while (!QLog.isColorLevel());
      QLog.d("carverW GetUrlAction", 2, "handleMessage STATUS_FILE_EXPIRED  error = " + this.jdField_a_of_type_Int);
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (!MessageForShortVideo.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo)) || (this.jdField_a_of_type_Aejg == null));
    paramView = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    this.jdField_a_of_type_Aejg.a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Int, this.c, paramView, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, paramayqm.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aejc
 * JD-Core Version:    0.7.0.1
 */