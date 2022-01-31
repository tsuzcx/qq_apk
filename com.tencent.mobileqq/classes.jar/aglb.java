import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.qphone.base.util.QLog;

public class aglb
  implements Runnable
{
  public aglb(PicPreDownloader paramPicPreDownloader, MessageForPic paramMessageForPic, int paramInt) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "productAysnc(): cannot predownload");
      }
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, -1);
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null) || (!(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic instanceof MessageForPic))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, this.jdField_a_of_type_Int, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aglb
 * JD-Core Version:    0.7.0.1
 */