import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;

class ahcn
  implements awnd<MarkFaceMessage, Void>
{
  ahcn(ahch paramahch, ahcu paramahcu) {}
  
  public Void a(MarkFaceMessage paramMarkFaceMessage)
  {
    paramMarkFaceMessage = ((awmr)this.jdField_a_of_type_Ahch.a.getManager(14)).a(paramMarkFaceMessage);
    this.jdField_a_of_type_Ahcu.jdField_a_of_type_Asbq = paramMarkFaceMessage;
    if ((paramMarkFaceMessage != null) && (paramMarkFaceMessage.a != null)) {
      this.jdField_a_of_type_Ahcu.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = ((awmr)this.jdField_a_of_type_Ahch.a.getManager(14)).a(paramMarkFaceMessage.a.epId);
    }
    awgs.a();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahcn
 * JD-Core Version:    0.7.0.1
 */