import com.tencent.qphone.base.util.QLog;

class acpw
  implements acpy
{
  acpw(acpv paramacpv, acpx paramacpx) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      acpv.a(this.jdField_a_of_type_Acpv, this.jdField_a_of_type_Acpx.a());
      this.jdField_a_of_type_Acpx.a();
      return;
    }
    QLog.e("FriendShipViewManager", 1, "director.prepare not ready, cannot play anim, type = " + this.jdField_a_of_type_Acpx.a());
    acpv.a(this.jdField_a_of_type_Acpv, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acpw
 * JD-Core Version:    0.7.0.1
 */