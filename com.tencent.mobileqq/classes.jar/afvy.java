import android.text.TextUtils;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

class afvy
  implements auls
{
  afvy(afvt paramafvt, String paramString, afwd paramafwd) {}
  
  public void a()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Afwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + this.jdField_a_of_type_Afwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
      this.jdField_a_of_type_Afwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(8);
    }
  }
  
  public void a(aulp paramaulp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "dealVideoSaveUI onSaveComplete");
    }
    if (paramaulp != null)
    {
      if (paramaulp.jdField_a_of_type_Int != 0) {
        break label112;
      }
      aulq.a(this.jdField_a_of_type_Afvt.a);
    }
    for (;;)
    {
      paramaulp.jdField_a_of_type_Aulo.b(this);
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Afwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + this.jdField_a_of_type_Afwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
        this.jdField_a_of_type_Afwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(8);
      }
      return;
      label112:
      aulq.b(this.jdField_a_of_type_Afvt.a);
    }
  }
  
  public void a(aulp paramaulp, int paramInt)
  {
    this.jdField_a_of_type_Afvt.a(this.jdField_a_of_type_Afwd, paramInt, false);
  }
  
  public void b(aulp paramaulp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afvy
 * JD-Core Version:    0.7.0.1
 */