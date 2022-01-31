import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import java.util.Map;

class afsa
  extends ajto
{
  afsa(afry paramafry) {}
  
  protected void onGetCommonSwitchFromDetailInfo(boolean paramBoolean, short[] paramArrayOfShort, Map<Short, Short> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onGetCommonSwitchFromDetailInfo isSuccess: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    String str;
    int i;
    short s;
    Short localShort;
    boolean bool;
    if (paramBoolean)
    {
      str = "";
      i = 0;
      paramBoolean = false;
      if ((paramMap != null) && (paramArrayOfShort != null) && (i < paramArrayOfShort.length))
      {
        s = paramArrayOfShort[i];
        localShort = (Short)paramMap.get(Short.valueOf(s));
        afsf localafsf = afry.a(this.a, s);
        bool = paramBoolean;
        if (localafsf != null)
        {
          bool = paramBoolean;
          if (localShort != null)
          {
            bool = paramBoolean;
            if (localafsf.b != localShort.shortValue())
            {
              localafsf.b = localShort.shortValue();
              bool = true;
            }
          }
        }
        if ((localafsf == null) || (!QLog.isColorLevel())) {
          break label377;
        }
        str = String.format(Locale.getDefault(), "%s, [id: %s, value: %s]", new Object[] { str, Short.valueOf(s), localShort });
      }
    }
    label260:
    label374:
    label377:
    for (;;)
    {
      i += 1;
      paramBoolean = bool;
      break;
      if (paramBoolean)
      {
        afry.b(this.a);
        afry.a(this.a);
      }
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onGetCommonSwitchFromDetailInfo, needUpdate: %s, log: %s", new Object[] { Boolean.valueOf(paramBoolean), str }));
      }
      do
      {
        return;
      } while (!QLog.isColorLevel());
      str = "";
      i = 0;
      if ((paramMap != null) && (paramArrayOfShort != null) && (i < paramArrayOfShort.length))
      {
        s = paramArrayOfShort[i];
        localShort = (Short)paramMap.get(Short.valueOf(s));
        if (!QLog.isColorLevel()) {
          break label374;
        }
        str = String.format(Locale.getDefault(), "%s, [id: %s, value: %s]", new Object[] { str, Short.valueOf(s), localShort });
      }
      for (;;)
      {
        i += 1;
        break label260;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onGetCommonSwitchFromDetailInfo,  fail, log: %s", new Object[] { str }));
        return;
      }
    }
  }
  
  protected void onSetCommonSwitchFromDetailInfo(boolean paramBoolean, short paramShort1, short paramShort2)
  {
    if (paramBoolean)
    {
      localafsf = afry.a(this.a, paramShort1);
      if ((localafsf != null) && (localafsf.b != paramShort2))
      {
        localafsf.b = paramShort2;
        afry.b(this.a);
        afry.a(this.a);
        if ((paramShort1 == -23447) && (afry.a(this.a) != null))
        {
          localFriendListHandler = (FriendListHandler)afry.a(this.a).a(1);
          if (localFriendListHandler != null)
          {
            localFriendListHandler.notifyUI(113, true, null);
            if (paramShort2 != 0) {
              break label168;
            }
            if (QLog.isColorLevel()) {
              QLog.d("CTEntryMng", 2, "switch state change to on, force to get service enable state");
            }
            localFriendListHandler.a(null, null, 6, null);
          }
        }
      }
      if ((localafsf != null) && (QLog.isColorLevel())) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onSetCommonSwitchFromDetailInfo suc switch_id: %s, switch_value: %s", new Object[] { Short.valueOf(paramShort1), Short.valueOf(paramShort2) }));
      }
    }
    label168:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        afsf localafsf;
        FriendListHandler localFriendListHandler;
        return;
        this.a.b(false);
      }
    }
    QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onSetCommonSwitchFromDetailInfo fail switch_id: %s, switch_value: %s", new Object[] { Short.valueOf(paramShort1), Short.valueOf(paramShort2) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afsa
 * JD-Core Version:    0.7.0.1
 */