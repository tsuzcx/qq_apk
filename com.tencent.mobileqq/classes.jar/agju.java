import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.QcircleTroopRedDotHelper.1;
import com.tencent.mobileqq.activity.aio.helper.QcircleTroopRedDotHelper.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.List;

public class agju
  implements agin, agjd
{
  public static String a;
  public TroopChatPie a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "QcircleTroopRedDotHelper";
  }
  
  public agju(agih paramagih, TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    paramagih.a(this);
  }
  
  public void a(int paramInt)
  {
    if (!afok.a()) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 8: 
      afok.a();
      ThreadManagerV2.excute(new QcircleTroopRedDotHelper.1(this), 160, null, true);
      return;
    }
    afok.b();
  }
  
  public void a(int paramInt, TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    if ((afok.a()) && (paramInt == 1) && (!afok.b())) {
      ThreadManager.excute(new QcircleTroopRedDotHelper.2(this, paramTroopChatPie, paramList), 160, null, true);
    }
  }
  
  public int[] a()
  {
    return new int[] { 8, 14 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agju
 * JD-Core Version:    0.7.0.1
 */