import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.qphone.base.util.QLog;

public class ahxf
  extends amuv
{
  public ahxf(AddContactsView paramAddContactsView) {}
  
  protected void a(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_ArrayOfJavaLangString = paramLBSInfo.a();
    }
    if ((this.a.jdField_a_of_type_ArrayOfJavaLangString == null) || (this.a.jdField_a_of_type_ArrayOfJavaLangString.length != 4)) {
      this.a.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "-1", "-1", "-1", "-1" };
    }
    if (this.a.c) {
      this.a.f();
    }
    if (!"-1".equals(this.a.jdField_a_of_type_ArrayOfJavaLangString[0]))
    {
      this.a.jdField_a_of_type_ArrayOfJavaLangString[3] = "0";
      this.a.jdField_a_of_type_Ampm.a(this.a.jdField_a_of_type_ArrayOfJavaLangString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "onGetUserLocation|isSuccess : " + paramBoolean + ", autoReqLocation : " + this.a.c + ", locationCodes[0] : " + this.a.jdField_a_of_type_ArrayOfJavaLangString[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxf
 * JD-Core Version:    0.7.0.1
 */