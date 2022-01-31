import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class agkh
  implements aesa
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private agkl jdField_a_of_type_Agkl;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  private String jdField_a_of_type_JavaLangString;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int b;
  private int c;
  
  public agkh(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, agkl paramagkl, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
    this.jdField_a_of_type_Agkl = paramagkl;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin;
    long l = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq;
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject, l);
    if ((localObject != null) && ((localObject instanceof bara))) {
      ((bara)localObject).a();
    }
    localObject = new View(BaseApplicationImpl.getApplication());
    aery localaery = aery.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localaery != null) {
      localaery.a((View)localObject, this);
    }
    localObject = azdd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1);
    if (localObject != null) {
      azdd.a((azdx)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void a(View paramView, bass parambass, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq != parambass.jdField_b_of_type_Long)) {
      if (QLog.isColorLevel()) {
        QLog.d("carverW GetUrlAction", 2, " handleMessage return file.uniseq=" + parambass.jdField_b_of_type_Long);
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
                    QLog.d("carverW GetUrlAction", 2, " handleMessage what==" + paramInt1 + ", arg1:" + paramInt2 + " fileType=" + parambass.jdField_b_of_type_Int + " status=" + parambass.d + " msg.id=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
                  }
                } while ((parambass.jdField_b_of_type_Int != 6) && (parambass.jdField_b_of_type_Int != 17) && (parambass.jdField_b_of_type_Int != 9) && (parambass.jdField_b_of_type_Int != 20));
                switch (parambass.d)
                {
                case 2004: 
                default: 
                  return;
                case 2002: 
                  if (QLog.isColorLevel()) {
                    QLog.d("carverW GetUrlAction", 2, "STATUS_RECV_PROCESS: get url finished urls=" + parambass.c + " domain =" + parambass.u + " mMsg=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
                  }
                  break;
                }
              } while (parambass.c == null);
              this.jdField_a_of_type_ArrayOfJavaLangString = parambass.c;
              this.jdField_a_of_type_JavaLangString = parambass.u;
              paramInt1 = 0;
              while (paramInt1 < 1)
              {
                if (!bdnn.a(this.jdField_a_of_type_JavaLangString))
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
            this.jdField_a_of_type_Int = parambass.g;
          } while (!QLog.isColorLevel());
          QLog.d("carverW GetUrlAction", 2, "handleMessage STATUS_RECV_ERROR  error = " + this.jdField_a_of_type_Int);
          return;
          this.jdField_a_of_type_Int = parambass.g;
        } while (!QLog.isColorLevel());
        QLog.d("carverW GetUrlAction", 2, "handleMessage STATUS_FILE_UNSAFE  error = " + this.jdField_a_of_type_Int);
        return;
        this.jdField_a_of_type_Int = parambass.g;
      } while (!QLog.isColorLevel());
      QLog.d("carverW GetUrlAction", 2, "handleMessage STATUS_FILE_EXPIRED  error = " + this.jdField_a_of_type_Int);
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (!MessageForShortVideo.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo)) || (this.jdField_a_of_type_Agkl == null));
    paramView = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    this.jdField_a_of_type_Agkl.a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Int, this.c, paramView, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, parambass.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkh
 * JD-Core Version:    0.7.0.1
 */