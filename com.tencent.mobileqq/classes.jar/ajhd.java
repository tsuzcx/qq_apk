import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class ajhd
  implements ajoe
{
  ajhd(ajhc paramajhc) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloGameActivity.b, 2, new Object[] { "createShortcut result:", Integer.valueOf(paramInt) });
    }
    if (this.a.jdField_a_of_type_Ajod != null) {
      this.a.jdField_a_of_type_Ajod.a(paramInt);
    }
    VipUtils.a(null, "cmshow", "Apollo", "sendToDesktopSusessful", 0, paramInt, new String[] { String.valueOf(this.a.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajhd
 * JD-Core Version:    0.7.0.1
 */