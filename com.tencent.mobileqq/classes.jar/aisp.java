import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class aisp
  extends anmu
{
  aisp(aiso paramaiso) {}
  
  private void a(ArrayList<aitt> paramArrayList)
  {
    if ((paramArrayList != null) && (aiso.a(this.a) != 80000005) && (paramArrayList.size() == 1)) {
      aiso.a(this.a, ((aitt)paramArrayList.get(0)).jdField_b_of_type_Int);
    }
    if ((paramArrayList != null) && (paramArrayList.size() >= 1))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        aitt localaitt = (aitt)paramArrayList.next();
        if (localaitt.a == 80000003)
        {
          i = 0;
          while (i < localaitt.jdField_b_of_type_JavaUtilList.size())
          {
            ((AccountSearchPb.record)localaitt.jdField_b_of_type_JavaUtilList.get(i)).number.set(i + 1);
            i += 1;
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (aiso.a(this.a) != 80000005) {
          oat.a(aiso.a(this.a), "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D96", "0X8005D96", 0, 0, aiso.b(this.a) + "", "", this.a.b, "", false);
        }
      }
      else {
        return;
      }
      oat.a(aiso.a(this.a), "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D94", "0X8005D94", 0, 0, "", "", this.a.b, "", false);
      return;
    }
  }
  
  protected void onSearchFriendResult(boolean paramBoolean1, int paramInt1, Object paramObject, int paramInt2, String paramString, boolean paramBoolean2, long paramLong, int paramInt3, List<bbmx> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(aiso.a, 2, "onSearchFriendResult  searchType = " + paramInt1 + " isSuccess = " + paramBoolean1 + " subId = " + paramInt3);
    }
    int j = 0;
    int i;
    aisq localaisq;
    if (paramInt1 == 87)
    {
      this.a.b();
      i = 1;
      if (aiso.a(this.a) != null)
      {
        localaisq = aiso.a(this.a);
        if (i == 0) {
          break label330;
        }
      }
    }
    for (;;)
    {
      localaisq.a(paramInt1, paramBoolean1, paramObject, paramInt2, paramString, paramInt3, paramList);
      do
      {
        for (;;)
        {
          return;
          if (paramInt1 != 88) {
            break label316;
          }
          if (paramLong == aiso.a(this.a))
          {
            this.a.b();
            if (!paramBoolean2)
            {
              if (aiso.a(this.a) != null) {
                aiso.a(this.a).a(aiso.a(this.a), paramBoolean1, new ArrayList(), paramInt2, paramString, paramInt3, paramList);
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
                  QLog.e(aiso.a, 2, "", paramObject);
                }
              }
            }
          }
        }
      } while (aiso.a(this.a) == null);
      aiso.a(this.a).a(aiso.a(this.a), paramBoolean1, new ArrayList(), paramInt2, paramString, paramInt3, paramList);
      return;
      label272:
      i = j;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(aiso.a, 2, "search failed error msg = " + paramString);
      i = j;
      break;
      label316:
      this.a.b();
      i = j;
      break;
      label330:
      paramInt1 = aiso.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisp
 * JD-Core Version:    0.7.0.1
 */