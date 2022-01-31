import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.qphone.base.util.QLog;

class aklk
  implements alga
{
  aklk(aklj paramaklj) {}
  
  public void a(int paramInt)
  {
    QLog.d("sava_ChatPieApolloViewController", 1, "sava_native_log preLoadApolloEngine onSoLoadComplete ret:" + paramInt);
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "sava_native_log preLoadApolloEngine onSoLoadComplete");
      }
      if (aklj.a(this.a))
      {
        QLog.i("sava_ChatPieApolloViewController", 1, "onSoLoadComplete but AIO destroy!");
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloRender != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.preLoadDirector();
        aklj.a(this.a);
      }
    }
    alfz.b(this.a.jdField_a_of_type_Alga);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aklk
 * JD-Core Version:    0.7.0.1
 */