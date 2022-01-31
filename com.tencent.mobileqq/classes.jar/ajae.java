import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public class ajae
  extends TroopObserver
{
  public ajae(TroopBatchAddFriendMgr paramTroopBatchAddFriendMgr) {}
  
  protected void a(String paramString, boolean paramBoolean, List paramList, int paramInt, long paramLong)
  {
    paramList = (Long)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((paramList == null) || (paramList.longValue() == 0L)) {
      return;
    }
    if (QLog.isColorLevel()) {
      if (!paramBoolean) {
        break label99;
      }
    }
    label99:
    for (paramInt = 1;; paramInt = 0)
    {
      QLog.i("TroopBatchAddFriendMgr", 2, String.format("onUpdateTroopGetMemberList suc:%d troopUin:%s", new Object[] { Integer.valueOf(paramInt), paramString }));
      if ((!paramBoolean) || (paramList.longValue() != paramLong) || (paramLong <= 0L)) {
        break;
      }
      this.a.a(paramString);
      return;
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, long paramLong, int paramInt, boolean paramBoolean3, HashMap paramHashMap)
  {
    Object localObject2 = (Long)this.a.b.get(paramString1);
    if ((localObject2 == null) || (((Long)localObject2).longValue() == 0L)) {
      break label31;
    }
    label31:
    while ((!paramString2.equals(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (paramLong != ((Long)localObject2).longValue())) {
      return;
    }
    int i;
    if (QLog.isColorLevel())
    {
      if (!paramBoolean1) {
        break label259;
      }
      i = 1;
      label73:
      if (!paramBoolean2) {
        break label265;
      }
    }
    label259:
    label265:
    for (Object localObject1 = "true";; localObject1 = "false")
    {
      QLog.i("TroopBatchAddFriendMgr", 2, String.format("onGetBatchCmnFrdsCnt suc:%d. troopUin:%s fromUin:%s isLastBatch:%s", new Object[] { Integer.valueOf(i), paramString1, paramString2, localObject1 }));
      if (!paramBoolean1) {
        break;
      }
      if (!paramBoolean2) {
        break label272;
      }
      if (!paramBoolean3)
      {
        localObject1 = PreferenceManager.getDefaultSharedPreferences(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
        localObject2 = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1 });
        ((SharedPreferences)localObject1).edit().putLong((String)localObject2, paramLong).apply();
      }
      ((TroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(102, true, new Object[] { paramString1, paramString2, Long.valueOf(paramLong), Boolean.valueOf(paramBoolean3), paramHashMap });
      return;
      i = 0;
      break label73;
    }
    label272:
    if (paramBoolean3) {
      ((TroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(102, true, new Object[] { paramString1, paramString2, Long.valueOf(paramLong), Boolean.valueOf(paramBoolean3), paramHashMap });
    }
    int j = paramInt + 50;
    for (;;)
    {
      try
      {
        paramString2 = (List)this.a.c.get(paramString1);
        if (paramString2.size() <= paramInt) {
          break;
        }
        i = j;
        if (j > paramString2.size()) {
          i = paramString2.size();
        }
        paramHashMap = paramString2.subList(paramInt, i);
        if (i == paramString2.size())
        {
          paramBoolean1 = true;
          this.a.a(paramString1, paramHashMap, i, (Long)localObject2, paramBoolean1, paramBoolean3);
          return;
        }
      }
      finally {}
      paramBoolean1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajae
 * JD-Core Version:    0.7.0.1
 */