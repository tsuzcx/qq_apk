import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class agmy
  implements agma
{
  private ahzy a;
  
  public agmy(ahzy paramahzy)
  {
    this.a = paramahzy;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    SessionInfo localSessionInfo;
    do
    {
      return;
      localObject = this.a.b;
      localSessionInfo = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if ((localObject != null) && ((localSessionInfo.jdField_a_of_type_Int == 1024) || (((bjft)localObject).a(localSessionInfo.jdField_a_of_type_JavaLangString)))) {
        ((bjft)localObject).a(localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int);
      }
      if ((localObject != null) && (((bjft)localObject).a(localSessionInfo.jdField_a_of_type_JavaLangString))) {
        ((bjhb)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(null, localSessionInfo.jdField_a_of_type_JavaLangString, false);
      }
    } while ((!(this.a instanceof ahxt)) && (!nki.b(localSessionInfo.jdField_a_of_type_JavaLangString)));
    if (localObject == null) {}
    for (Object localObject = "";; localObject = ((bjft)localObject).a(localSessionInfo.jdField_a_of_type_JavaLangString))
    {
      bcst.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Qidian", localSessionInfo.jdField_a_of_type_JavaLangString, "0X8009787", "CloseAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, "8.4.1", "");
      return;
    }
  }
  
  public int[] a()
  {
    return new int[] { 13 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmy
 * JD-Core Version:    0.7.0.1
 */