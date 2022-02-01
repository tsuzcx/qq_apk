import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;

class agim
  implements avtc<MarkFaceMessage, Void>
{
  agim(agif paramagif, agis paramagis) {}
  
  public Void a(MarkFaceMessage paramMarkFaceMessage)
  {
    paramMarkFaceMessage = ((avsq)this.jdField_a_of_type_Agif.a.getManager(14)).a(paramMarkFaceMessage);
    this.jdField_a_of_type_Agis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = paramMarkFaceMessage;
    if ((paramMarkFaceMessage != null) && (paramMarkFaceMessage.emoticon != null)) {
      this.jdField_a_of_type_Agis.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = ((avsq)this.jdField_a_of_type_Agif.a.getManager(14)).a(paramMarkFaceMessage.emoticon.epId);
    }
    avmr.a();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agim
 * JD-Core Version:    0.7.0.1
 */