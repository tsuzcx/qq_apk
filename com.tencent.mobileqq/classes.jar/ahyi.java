import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ahyi
  extends amsu
{
  ahyi(ahyh paramahyh) {}
  
  private void a(ArrayList<ahzl> paramArrayList)
  {
    if ((paramArrayList != null) && (ahyh.a(this.a) != 80000005) && (paramArrayList.size() == 1)) {
      ahyh.a(this.a, ((ahzl)paramArrayList.get(0)).jdField_b_of_type_Int);
    }
    if ((paramArrayList != null) && (paramArrayList.size() >= 1))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        ahzl localahzl = (ahzl)paramArrayList.next();
        if (localahzl.a == 80000003)
        {
          i = 0;
          while (i < localahzl.jdField_b_of_type_JavaUtilList.size())
          {
            ((AccountSearchPb.record)localahzl.jdField_b_of_type_JavaUtilList.get(i)).number.set(i + 1);
            i += 1;
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (ahyh.a(this.a) != 80000005) {
          odq.a(ahyh.a(this.a), "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D96", "0X8005D96", 0, 0, ahyh.b(this.a) + "", "", this.a.b, "", false);
        }
      }
      else {
        return;
      }
      odq.a(ahyh.a(this.a), "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D94", "0X8005D94", 0, 0, "", "", this.a.b, "", false);
      return;
    }
  }
  
  protected void onSearchFriendResult(boolean paramBoolean1, int paramInt1, Object paramObject, int paramInt2, String paramString, boolean paramBoolean2, long paramLong, int paramInt3, List<bays> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ahyh.a, 2, "onSearchFriendResult  searchType = " + paramInt1 + " isSuccess = " + paramBoolean1 + " subId = " + paramInt3);
    }
    int j = 0;
    int i;
    ahyj localahyj;
    if (paramInt1 == 87)
    {
      this.a.b();
      i = 1;
      if (ahyh.a(this.a) != null)
      {
        localahyj = ahyh.a(this.a);
        if (i == 0) {
          break label330;
        }
      }
    }
    for (;;)
    {
      localahyj.a(paramInt1, paramBoolean1, paramObject, paramInt2, paramString, paramInt3, paramList);
      do
      {
        for (;;)
        {
          return;
          if (paramInt1 != 88) {
            break label316;
          }
          if (paramLong == ahyh.a(this.a))
          {
            this.a.b();
            if (!paramBoolean2)
            {
              if (ahyh.a(this.a) != null) {
                ahyh.a(this.a).a(ahyh.a(this.a), paramBoolean1, new ArrayList(), paramInt2, paramString, paramInt3, paramList);
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
                  QLog.e(ahyh.a, 2, "", paramObject);
                }
              }
            }
          }
        }
      } while (ahyh.a(this.a) == null);
      ahyh.a(this.a).a(ahyh.a(this.a), paramBoolean1, new ArrayList(), paramInt2, paramString, paramInt3, paramList);
      return;
      label272:
      i = j;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(ahyh.a, 2, "search failed error msg = " + paramString);
      i = j;
      break;
      label316:
      this.a.b();
      i = j;
      break;
      label330:
      paramInt1 = ahyh.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyi
 * JD-Core Version:    0.7.0.1
 */