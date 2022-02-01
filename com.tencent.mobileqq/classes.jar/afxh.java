import com.tencent.qphone.base.util.QLog;

class afxh
  implements afxj
{
  afxh(afxg paramafxg, afxi paramafxi) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      afxg.a(this.jdField_a_of_type_Afxg, this.jdField_a_of_type_Afxi.a());
      this.jdField_a_of_type_Afxi.a();
      return;
    }
    QLog.e("FriendShipViewManager", 1, "director.prepare not ready, cannot play anim, type = " + this.jdField_a_of_type_Afxi.a());
    afxg.a(this.jdField_a_of_type_Afxg, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afxh
 * JD-Core Version:    0.7.0.1
 */