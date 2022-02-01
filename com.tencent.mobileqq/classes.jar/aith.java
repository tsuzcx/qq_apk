import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class aith
  extends anvi
{
  aith(aitg paramaitg) {}
  
  private void a(ArrayList<aiuk> paramArrayList)
  {
    if ((paramArrayList != null) && (aitg.a(this.a) != 80000005) && (paramArrayList.size() == 1)) {
      aitg.a(this.a, ((aiuk)paramArrayList.get(0)).jdField_b_of_type_Int);
    }
    if ((paramArrayList != null) && (paramArrayList.size() >= 1))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        aiuk localaiuk = (aiuk)paramArrayList.next();
        if (localaiuk.a == 80000003)
        {
          i = 0;
          while (i < localaiuk.jdField_b_of_type_JavaUtilList.size())
          {
            ((AccountSearchPb.record)localaiuk.jdField_b_of_type_JavaUtilList.get(i)).number.set(i + 1);
            i += 1;
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (aitg.a(this.a) != 80000005) {
          olh.a(aitg.a(this.a), "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D96", "0X8005D96", 0, 0, aitg.b(this.a) + "", "", this.a.b, "", false);
        }
      }
      else {
        return;
      }
      olh.a(aitg.a(this.a), "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D94", "0X8005D94", 0, 0, "", "", this.a.b, "", false);
      return;
    }
  }
  
  protected void onSearchFriendResult(boolean paramBoolean1, int paramInt1, Object paramObject, int paramInt2, String paramString, boolean paramBoolean2, long paramLong, int paramInt3, List<bcfi> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(aitg.a, 2, "onSearchFriendResult  searchType = " + paramInt1 + " isSuccess = " + paramBoolean1 + " subId = " + paramInt3);
    }
    int j = 0;
    int i;
    aiti localaiti;
    if (paramInt1 == 87)
    {
      this.a.b();
      i = 1;
      if (aitg.a(this.a) != null)
      {
        localaiti = aitg.a(this.a);
        if (i == 0) {
          break label330;
        }
      }
    }
    for (;;)
    {
      localaiti.a(paramInt1, paramBoolean1, paramObject, paramInt2, paramString, paramInt3, paramList);
      do
      {
        for (;;)
        {
          return;
          if (paramInt1 != 88) {
            break label316;
          }
          if (paramLong == aitg.a(this.a))
          {
            this.a.b();
            if (!paramBoolean2)
            {
              if (aitg.a(this.a) != null) {
                aitg.a(this.a).a(aitg.a(this.a), paramBoolean1, new ArrayList(), paramInt2, paramString, paramInt3, paramList);
              }
            }
            else
            {
              if (!paramBoolean1) {
                break label272;
              }
              try
              {
                a((ArrayList)paramObject);
                i = j;
              }
              catch (Exception paramObject)
              {
                if (QLog.isColorLevel()) {
                  QLog.e(aitg.a, 2, "", paramObject);
                }
              }
            }
          }
        }
      } while (aitg.a(this.a) == null);
      aitg.a(this.a).a(aitg.a(this.a), paramBoolean1, new ArrayList(), paramInt2, paramString, paramInt3, paramList);
      return;
      label272:
      i = j;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(aitg.a, 2, "search failed error msg = " + paramString);
      i = j;
      break;
      label316:
      this.a.b();
      i = j;
      break;
      label330:
      paramInt1 = aitg.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aith
 * JD-Core Version:    0.7.0.1
 */