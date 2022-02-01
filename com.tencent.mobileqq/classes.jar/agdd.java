import com.tencent.qphone.base.util.QLog;

class agdd
  implements agdf
{
  agdd(agdc paramagdc, agde paramagde) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      agdc.a(this.jdField_a_of_type_Agdc, this.jdField_a_of_type_Agde.a());
      this.jdField_a_of_type_Agde.a();
      return;
    }
    QLog.e("FriendShipViewManager", 1, "director.prepare not ready, cannot play anim, type = " + this.jdField_a_of_type_Agde.a());
    agdc.a(this.jdField_a_of_type_Agdc, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdd
 * JD-Core Version:    0.7.0.1
 */