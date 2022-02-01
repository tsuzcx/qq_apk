import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import java.util.Map;

class airl
  extends CardObserver
{
  airl(airj paramairj) {}
  
  private void a(short paramShort1, short paramShort2)
  {
    if ((paramShort1 == -23447) && (airj.a(this.a) != null))
    {
      FriendListHandler localFriendListHandler = (FriendListHandler)airj.a(this.a).getBusinessHandler(1);
      if (localFriendListHandler != null)
      {
        localFriendListHandler.notifyUI(113, true, null);
        if (paramShort2 != 0) {
          break label73;
        }
        if (QLog.isColorLevel()) {
          QLog.d("CTEntryMng", 2, "switch state change to on, force to get service enable state");
        }
        localFriendListHandler.getMayKnowRecommend(null, null, 6, null);
      }
    }
    return;
    label73:
    this.a.b(false);
  }
  
  private void a(short[] paramArrayOfShort, Map<Short, Short> paramMap)
  {
    String str;
    int i;
    if (QLog.isColorLevel())
    {
      str = "";
      i = 0;
      if ((paramMap != null) && (paramArrayOfShort != null) && (i < paramArrayOfShort.length))
      {
        short s = paramArrayOfShort[i];
        Short localShort = (Short)paramMap.get(Short.valueOf(s));
        if (!QLog.isColorLevel()) {
          break label124;
        }
        str = String.format(Locale.getDefault(), "%s, [id: %s, value: %s]", new Object[] { str, Short.valueOf(s), localShort });
      }
    }
    label124:
    for (;;)
    {
      i += 1;
      break;
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onGetCommonSwitchFromDetailInfo,  fail, log: %s", new Object[] { str }));
      }
      return;
    }
  }
  
  public void onGetCommonSwitchFromDetailInfo(boolean paramBoolean, short[] paramArrayOfShort, Map<Short, Short> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onGetCommonSwitchFromDetailInfo isSuccess: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    String str;
    int i;
    boolean bool;
    if (paramBoolean)
    {
      str = "";
      i = 0;
      paramBoolean = false;
      if ((paramMap != null) && (paramArrayOfShort != null) && (i < paramArrayOfShort.length))
      {
        short s = paramArrayOfShort[i];
        Short localShort = (Short)paramMap.get(Short.valueOf(s));
        airq localairq = airj.a(this.a, s);
        bool = paramBoolean;
        if (localairq != null)
        {
          bool = paramBoolean;
          if (localShort != null)
          {
            bool = paramBoolean;
            if (localairq.b != localShort.shortValue())
            {
              localairq.b = localShort.shortValue();
              bool = true;
            }
          }
        }
        if ((localairq == null) || (!QLog.isColorLevel())) {
          break label254;
        }
        str = String.format(Locale.getDefault(), "%s, [id: %s, value: %s]", new Object[] { str, Short.valueOf(s), localShort });
      }
    }
    label254:
    for (;;)
    {
      i += 1;
      paramBoolean = bool;
      break;
      if (paramBoolean)
      {
        airj.b(this.a);
        airj.a(this.a);
      }
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onGetCommonSwitchFromDetailInfo, needUpdate: %s, log: %s", new Object[] { Boolean.valueOf(paramBoolean), str }));
      }
      return;
      a(paramArrayOfShort, paramMap);
      return;
    }
  }
  
  public void onSetCommonSwitchFromDetailInfo(boolean paramBoolean, short paramShort1, short paramShort2)
  {
    if (paramBoolean)
    {
      localairq = airj.a(this.a, paramShort1);
      if ((localairq != null) && (localairq.b != paramShort2))
      {
        localairq.b = paramShort2;
        airj.b(this.a);
        airj.a(this.a);
        a(paramShort1, paramShort2);
      }
      if ((localairq != null) && (QLog.isColorLevel())) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onSetCommonSwitchFromDetailInfo suc switch_id: %s, switch_value: %s", new Object[] { Short.valueOf(paramShort1), Short.valueOf(paramShort2) }));
      }
    }
    while (!QLog.isColorLevel())
    {
      airq localairq;
      return;
    }
    QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onSetCommonSwitchFromDetailInfo fail switch_id: %s, switch_value: %s", new Object[] { Short.valueOf(paramShort1), Short.valueOf(paramShort2) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airl
 * JD-Core Version:    0.7.0.1
 */