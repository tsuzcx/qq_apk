import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.qphone.base.util.QLog;

class aihh
  implements ajan
{
  aihh(aihg paramaihg) {}
  
  public void a(int paramInt)
  {
    QLog.d("sava_ChatPieApolloViewController", 1, "sava_native_log preLoadApolloEngine onSoLoadComplete ret:" + paramInt);
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "sava_native_log preLoadApolloEngine onSoLoadComplete");
      }
      if (aihg.a(this.a))
      {
        QLog.i("sava_ChatPieApolloViewController", 1, "onSoLoadComplete but AIO destroy!");
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloRender != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.preLoadDirector();
        aihg.a(this.a);
      }
    }
    ajam.b(this.a.jdField_a_of_type_Ajan);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aihh
 * JD-Core Version:    0.7.0.1
 */