import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.QcircleTroopRedDotHelper.1;
import com.tencent.mobileqq.activity.aio.helper.QcircleTroopRedDotHelper.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.List;

public class afsg
  implements afrc, afrs
{
  public static String a;
  public TroopChatPie a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "QcircleTroopRedDotHelper";
  }
  
  public afsg(afqw paramafqw, TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    paramafqw.a(this);
  }
  
  public void a(int paramInt)
  {
    if (!aewz.a()) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 7: 
      aewz.a();
      ThreadManagerV2.excute(new QcircleTroopRedDotHelper.1(this), 160, null, true);
      return;
    }
    aewz.b();
  }
  
  public void a(int paramInt, TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    if ((aewz.a()) && (paramInt == 1) && (!aewz.b())) {
      ThreadManager.excute(new QcircleTroopRedDotHelper.2(this, paramTroopChatPie, paramList), 160, null, true);
    }
  }
  
  public int[] a()
  {
    return new int[] { 7, 13 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afsg
 * JD-Core Version:    0.7.0.1
 */