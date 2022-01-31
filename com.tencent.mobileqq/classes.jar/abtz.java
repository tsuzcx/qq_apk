import android.os.Bundle;
import android.util.Pair;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class abtz
  extends CardObserver
{
  public abtz(MessengerService paramMessengerService) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    long l2 = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("MessengerService.onCardDownload", 2, "received onCardDownload");
    }
    Object localObject;
    long l1;
    int i;
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Card)))
    {
      paramObject = (Card)paramObject;
      localObject = (QQAppInterface)MessengerService.h(this.a);
      if ((localObject != null) && (Utils.a(((QQAppInterface)localObject).getCurrentAccountUin(), paramObject.uin))) {
        if ((paramObject.templateRet == 0) || (paramObject.templateRet == 101107) || (paramObject.templateRet == 101108))
        {
          l1 = paramObject.lCurrentBgId;
          l2 = paramObject.lCurrentStyleId;
          i = 0;
        }
      }
    }
    for (;;)
    {
      paramObject = new Bundle();
      paramObject.putLong("currentId", l1);
      paramObject.putLong("styleId", l2);
      paramObject.putInt("result", i);
      if ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localObject = (Bundle)this.a.jdField_a_of_type_JavaUtilList.remove(0);
        ((Bundle)localObject).putBundle("response", paramObject);
        this.a.a((Bundle)localObject);
      }
      return;
      i = -1;
      l1 = 0L;
      continue;
      i = -1;
      l1 = 0L;
      continue;
      QLog.e("Q.emoji.web.MessengerService", 1, "onCardDownload fail isSuccess = " + paramBoolean + "data = " + paramObject);
      i = -1;
      l1 = 0L;
    }
  }
  
  public void e(boolean paramBoolean, Object paramObject)
  {
    int i = -1;
    String str = "";
    if ((paramBoolean) && (paramObject != null)) {
      if ((paramObject instanceof Card)) {
        i = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.web.MessengerService", 2, "onSetCardTemplateReturn...resultCode=" + i);
      }
      if (this.a.jdField_a_of_type_AndroidOsBundle != null)
      {
        paramObject = new Bundle();
        this.a.jdField_a_of_type_AndroidOsBundle.putString("cmd", "card_setSummaryCard");
        paramObject.putInt("result", i);
        paramObject.putString("message", str);
        this.a.jdField_a_of_type_AndroidOsBundle.putBundle("response", paramObject);
        this.a.a(this.a.jdField_a_of_type_AndroidOsBundle);
        this.a.jdField_a_of_type_AndroidOsBundle = null;
      }
      return;
      if ((paramObject instanceof Pair))
      {
        paramObject = (Pair)paramObject;
        i = ((Integer)paramObject.first).intValue();
        str = (String)paramObject.second;
        continue;
        QLog.e("Q.emoji.web.MessengerService", 1, "onSetCardTemplateReturn fail isSuccess = " + paramBoolean + "obj = " + paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abtz
 * JD-Core Version:    0.7.0.1
 */