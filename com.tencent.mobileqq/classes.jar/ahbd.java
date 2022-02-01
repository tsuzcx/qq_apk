import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;

class ahbd
  implements awzd<MarkFaceMessage, Void>
{
  ahbd(ahaw paramahaw, ahbj paramahbj) {}
  
  public Void a(MarkFaceMessage paramMarkFaceMessage)
  {
    paramMarkFaceMessage = ((awyr)this.jdField_a_of_type_Ahaw.a.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramMarkFaceMessage);
    this.jdField_a_of_type_Ahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = paramMarkFaceMessage;
    if ((paramMarkFaceMessage != null) && (paramMarkFaceMessage.emoticon != null)) {
      this.jdField_a_of_type_Ahbj.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = ((awyr)this.jdField_a_of_type_Ahaw.a.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramMarkFaceMessage.emoticon.epId);
    }
    awsw.a();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbd
 * JD-Core Version:    0.7.0.1
 */