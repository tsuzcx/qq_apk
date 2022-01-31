import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class aldc
  implements alke
{
  aldc(aldb paramaldb) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloGameActivity.b, 2, new Object[] { "createShortcut result:", Integer.valueOf(paramInt) });
    }
    if (this.a.jdField_a_of_type_Alkd != null) {
      this.a.jdField_a_of_type_Alkd.a(paramInt);
    }
    VipUtils.a(null, "cmshow", "Apollo", "sendToDesktopSusessful", 0, paramInt, new String[] { String.valueOf(this.a.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aldc
 * JD-Core Version:    0.7.0.1
 */