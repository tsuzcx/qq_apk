import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;

class afqz
  implements aubq<MarkFaceMessage, Void>
{
  afqz(afqr paramafqr, afrf paramafrf) {}
  
  public Void a(MarkFaceMessage paramMarkFaceMessage)
  {
    paramMarkFaceMessage = ((aube)this.jdField_a_of_type_Afqr.a.getManager(14)).a(paramMarkFaceMessage);
    this.jdField_a_of_type_Afrf.jdField_a_of_type_Aptm = paramMarkFaceMessage;
    if ((paramMarkFaceMessage != null) && (paramMarkFaceMessage.a != null)) {
      this.jdField_a_of_type_Afrf.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = ((aube)this.jdField_a_of_type_Afqr.a.getManager(14)).a(paramMarkFaceMessage.a.epId);
    }
    atva.a();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqz
 * JD-Core Version:    0.7.0.1
 */