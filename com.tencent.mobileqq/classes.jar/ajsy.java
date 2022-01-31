import com.tencent.qphone.base.util.QLog;
import com.tencent.troop.group_activity_info.GroupActInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tencent.qun.group_activity.group_activity.GroupAct;

public class ajsy
  implements ajte
{
  private final String a = "BizTroopObserver";
  
  public void a(int paramInt1, int paramInt2, Map<String, Integer> paramMap, String paramString) {}
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, String paramString) {}
  
  protected void a(balb parambalb) {}
  
  protected void a(Object paramObject) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, ArrayList<baif> paramArrayList, int paramInt4) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, Boolean paramBoolean1) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString) {}
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, List<group_activity_info.GroupActInfo> paramList) {}
  
  protected void a(boolean paramBoolean, List<group_activity.GroupAct> paramList) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void b(Object paramObject) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void c(Object paramObject) {}
  
  protected void c(boolean paramBoolean, Object paramObject) {}
  
  protected void d(boolean paramBoolean, Object paramObject) {}
  
  protected void e(boolean paramBoolean, Object paramObject) {}
  
  protected void f(boolean paramBoolean, Object paramObject) {}
  
  protected void g(boolean paramBoolean, Object paramObject) {}
  
  protected void h(boolean paramBoolean, Object paramObject) {}
  
  protected void i(boolean paramBoolean, Object paramObject) {}
  
  protected void j(boolean paramBoolean, Object paramObject) {}
  
  protected void k(boolean paramBoolean, Object paramObject) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    int i = 0;
    if ((paramObject instanceof Object[])) {}
    for (Object localObject = (Object[])paramObject;; localObject = null)
    {
      switch (paramInt)
      {
      case 3: 
      case 4: 
      case 5: 
      case 7: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 19: 
      case 23: 
      case 25: 
      case 26: 
      case 34: 
      case 35: 
      case 37: 
      default: 
      case 2: 
      case 9: 
      case 6: 
      case 8: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 20: 
      case 18: 
        do
        {
          do
          {
            do
            {
              return;
              c(paramBoolean, paramObject);
              return;
              a(paramObject);
              return;
            } while (localObject == null);
            if (paramBoolean)
            {
              a(paramBoolean, (String)localObject[0], ((Boolean)localObject[1]).booleanValue(), (List)localObject[2]);
              return;
            }
            a(paramBoolean, (String)localObject[0], ((Boolean)localObject[1]).booleanValue(), null);
            return;
            d(paramBoolean, paramObject);
            return;
            e(paramBoolean, paramObject);
            return;
            a(paramBoolean, (List)paramObject);
            return;
          } while (localObject == null);
          if (paramBoolean)
          {
            a(true, ((Integer)localObject[0]).intValue(), ((Integer)localObject[1]).intValue(), ((Integer)localObject[2]).intValue(), (ArrayList)localObject[3], 0);
            return;
          }
          a(false, ((Integer)localObject[2]).intValue(), 0, 0, null, ((Integer)localObject[4]).intValue());
          return;
          b(paramObject);
          return;
          c(paramObject);
          return;
        } while (localObject == null);
        if ((localObject.length != 5) || (localObject[4] == null)) {
          break;
        }
      }
      for (paramObject = (String)localObject[4];; paramObject = null)
      {
        a((String)localObject[0], ((Integer)localObject[1]).intValue(), ((Integer)localObject[2]).intValue(), (String)localObject[3], paramObject);
        return;
        if ((localObject == null) || (localObject.length <= 0))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("BizTroopObserver", 2, "onUpdate(), case BizTroopHandler.TYPE_SET_COMMONLY_USED_TROOP_LIST, array is null or empty ...");
          return;
        }
        if ((localObject[0] instanceof Integer))
        {
          paramInt = ((Integer)localObject[0]).intValue();
          if ((localObject[1] instanceof Integer)) {
            i = ((Integer)localObject[1]).intValue();
          }
          if (!(localObject[2] instanceof Map)) {
            break label592;
          }
          paramObject = (Map)localObject[2];
          label557:
          if (!(localObject[3] instanceof String)) {
            break label597;
          }
        }
        label592:
        label597:
        for (localObject = (String)localObject[3];; localObject = null)
        {
          a(paramInt, i, paramObject, (String)localObject);
          return;
          paramInt = -1;
          break;
          paramObject = null;
          break label557;
        }
        f(paramBoolean, paramObject);
        return;
        g(paramBoolean, paramObject);
        return;
        if ((localObject == null) || (localObject.length == 0))
        {
          a(false, -1L, "");
          return;
        }
        a(paramBoolean, ((Long)localObject[0]).longValue(), (String)localObject[1]);
        return;
        j(paramBoolean, paramObject);
        return;
        if (QLog.isDevelopLevel()) {
          QLog.d("BizTroopObserver", 4, "TroopHandler.TYPE_TROOP_GAG_STATUS");
        }
        a((balb)paramObject);
        return;
        a(paramBoolean, ((Boolean)paramObject).booleanValue());
        return;
        k(paramBoolean, paramObject);
        return;
        if (localObject == null) {
          break;
        }
        a(paramBoolean, ((Long)localObject[0]).longValue(), ((Long)localObject[1]).longValue());
        return;
        if (localObject == null) {
          break;
        }
        a(paramBoolean, ((Integer)localObject[1]).intValue(), ((Integer)localObject[2]).intValue());
        return;
        if (localObject == null) {
          break;
        }
        b(paramBoolean, ((Boolean)localObject[1]).booleanValue());
        return;
        a(paramBoolean, paramObject);
        return;
        b(paramBoolean, paramObject);
        return;
        if ((paramBoolean) && (localObject != null))
        {
          a(((Long)localObject[0]).longValue(), ((Long)localObject[1]).longValue(), ((Long)localObject[2]).longValue(), (String)localObject[3]);
          return;
        }
        a(-1L, -1L, -1L, "");
        return;
        h(paramBoolean, paramObject);
        return;
        i(paramBoolean, paramObject);
        return;
        if ((localObject != null) && (localObject.length >= 1)) {}
        for (paramInt = ((Integer)localObject[0]).intValue(); (paramBoolean) && (localObject != null) && (localObject.length >= 4); paramInt = 2131696433)
        {
          a(paramBoolean, paramInt, (String)localObject[1], (String)localObject[2], (Boolean)localObject[3]);
          return;
        }
        a(paramBoolean, paramInt, null, null, Boolean.valueOf(true));
        return;
        if (localObject == null) {
          break;
        }
        if (localObject.length >= 4) {}
        for (paramInt = ((Integer)localObject[3]).intValue();; paramInt = 0)
        {
          a(paramBoolean, (String)localObject[0], (String)localObject[1], (String)localObject[2], paramInt);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajsy
 * JD-Core Version:    0.7.0.1
 */