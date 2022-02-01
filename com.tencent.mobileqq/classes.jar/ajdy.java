import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ajdy
  extends anyu
{
  ajdy(ajdx paramajdx) {}
  
  private void a(ArrayList<ajfc> paramArrayList)
  {
    if ((paramArrayList != null) && (ajdx.a(this.a) != 80000005) && (paramArrayList.size() == 1)) {
      ajdx.a(this.a, ((ajfc)paramArrayList.get(0)).jdField_b_of_type_Int);
    }
    if ((paramArrayList != null) && (paramArrayList.size() >= 1))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        ajfc localajfc = (ajfc)paramArrayList.next();
        if (localajfc.a == 80000003)
        {
          i = 0;
          while (i < localajfc.jdField_b_of_type_JavaUtilList.size())
          {
            ((AccountSearchPb.record)localajfc.jdField_b_of_type_JavaUtilList.get(i)).number.set(i + 1);
            i += 1;
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (ajdx.a(this.a) != 80000005) {
          ocd.a(ajdx.a(this.a), "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D96", "0X8005D96", 0, 0, ajdx.b(this.a) + "", "", this.a.b, "", false);
        }
      }
      else {
        return;
      }
      ocd.a(ajdx.a(this.a), "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D94", "0X8005D94", 0, 0, "", "", this.a.b, "", false);
      return;
    }
  }
  
  protected void onSearchFriendResult(boolean paramBoolean1, int paramInt1, Object paramObject, int paramInt2, String paramString, boolean paramBoolean2, long paramLong, int paramInt3, List<bcfq> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ajdx.a, 2, "onSearchFriendResult  searchType = " + paramInt1 + " isSuccess = " + paramBoolean1 + " subId = " + paramInt3);
    }
    int j = 0;
    int i;
    ajdz localajdz;
    if (paramInt1 == 87)
    {
      this.a.b();
      i = 1;
      if (ajdx.a(this.a) != null)
      {
        localajdz = ajdx.a(this.a);
        if (i == 0) {
          break label330;
        }
      }
    }
    for (;;)
    {
      localajdz.a(paramInt1, paramBoolean1, paramObject, paramInt2, paramString, paramInt3, paramList);
      do
      {
        for (;;)
        {
          return;
          if (paramInt1 != 88) {
            break label316;
          }
          if (paramLong == ajdx.a(this.a))
          {
            this.a.b();
            if (!paramBoolean2)
            {
              if (ajdx.a(this.a) != null) {
                ajdx.a(this.a).a(ajdx.a(this.a), paramBoolean1, new ArrayList(), paramInt2, paramString, paramInt3, paramList);
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
                  QLog.e(ajdx.a, 2, "", paramObject);
                }
              }
            }
          }
        }
      } while (ajdx.a(this.a) == null);
      ajdx.a(this.a).a(ajdx.a(this.a), paramBoolean1, new ArrayList(), paramInt2, paramString, paramInt3, paramList);
      return;
      label272:
      i = j;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(ajdx.a, 2, "search failed error msg = " + paramString);
      i = j;
      break;
      label316:
      this.a.b();
      i = j;
      break;
      label330:
      paramInt1 = ajdx.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdy
 * JD-Core Version:    0.7.0.1
 */