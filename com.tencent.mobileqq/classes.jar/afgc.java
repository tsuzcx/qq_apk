import com.tencent.qphone.base.util.QLog;

class afgc
  implements afge
{
  afgc(afgb paramafgb, afgd paramafgd) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      afgb.a(this.jdField_a_of_type_Afgb, this.jdField_a_of_type_Afgd.a());
      this.jdField_a_of_type_Afgd.a();
      return;
    }
    QLog.e("FriendShipViewManager", 1, "director.prepare not ready, cannot play anim, type = " + this.jdField_a_of_type_Afgd.a());
    afgb.a(this.jdField_a_of_type_Afgb, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afgc
 * JD-Core Version:    0.7.0.1
 */