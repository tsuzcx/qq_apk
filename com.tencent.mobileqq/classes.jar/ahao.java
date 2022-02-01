import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

public class ahao
  implements afbb
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ahas jdField_a_of_type_Ahas;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  private String jdField_a_of_type_JavaLangString;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int b;
  private int c;
  
  public ahao(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, ahas paramahas, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
    this.jdField_a_of_type_Ahas = paramahas;
    this.jdField_a_of_type_Long = paramLong;
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  private void a(FileMsg paramFileMsg)
  {
    switch (paramFileMsg.status)
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
              this.jdField_a_of_type_Int = paramFileMsg.errorCode;
            } while (!QLog.isColorLevel());
            QLog.d("carverW GetUrlAction", 2, "handleMessage STATUS_RECV_ERROR  error = " + this.jdField_a_of_type_Int);
            return;
            this.jdField_a_of_type_Int = paramFileMsg.errorCode;
          } while (!QLog.isColorLevel());
          QLog.d("carverW GetUrlAction", 2, "handleMessage STATUS_FILE_UNSAFE  error = " + this.jdField_a_of_type_Int);
          return;
          this.jdField_a_of_type_Int = paramFileMsg.errorCode;
        } while (!QLog.isColorLevel());
        QLog.d("carverW GetUrlAction", 2, "handleMessage STATUS_FILE_EXPIRED  error = " + this.jdField_a_of_type_Int);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("carverW GetUrlAction", 2, "STATUS_RECV_PROCESS: get url finished urls=" + paramFileMsg.urls + " domain =" + paramFileMsg.domain + " mMsg=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
        }
      } while (paramFileMsg.urls == null);
      this.jdField_a_of_type_ArrayOfJavaLangString = paramFileMsg.urls;
      this.jdField_a_of_type_JavaLangString = paramFileMsg.domain;
      int i = 0;
      while (i < 1)
      {
        if (!StringUtil.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          localObject = new StringBuilder();
          String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
          arrayOfString[i] = (arrayOfString[i] + "&txhost=" + this.jdField_a_of_type_JavaLangString);
        }
        i += 1;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (!MessageForShortVideo.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo)) || (this.jdField_a_of_type_Ahas == null));
    Object localObject = ShortVideoUtils.getShortVideoSavePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    this.jdField_a_of_type_Ahas.a(this.jdField_a_of_type_Long, this.b, this.c, (String)localObject, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, paramFileMsg.fileType, null);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin;
    long l = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq;
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor((String)localObject, l);
    if ((localObject != null) && ((localObject instanceof BaseDownloadProcessor))) {
      ((BaseDownloadProcessor)localObject).cancel();
    }
    localObject = new View(BaseApplicationImpl.getApplication());
    afaz localafaz = afaz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localafaz != null) {
      localafaz.a((View)localObject, this);
    }
    localObject = bbqf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1);
    if (localObject != null) {
      bbqf.a((bbqx)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq != paramFileMsg.uniseq)) {
      if (QLog.isColorLevel()) {
        QLog.d("carverW GetUrlAction", 2, " handleMessage return file.uniseq=" + paramFileMsg.uniseq);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("carverW GetUrlAction", 2, " handleMessage what==" + paramInt1 + ", arg1:" + paramInt2 + " fileType=" + paramFileMsg.fileType + " status=" + paramFileMsg.status + " msg.id=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      }
    } while ((paramFileMsg.fileType != 6) && (paramFileMsg.fileType != 17) && (paramFileMsg.fileType != 9) && (paramFileMsg.fileType != 20));
    a(paramFileMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahao
 * JD-Core Version:    0.7.0.1
 */