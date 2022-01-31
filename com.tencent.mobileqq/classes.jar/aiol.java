import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

class aiol
  extends ajvj
{
  aiol(aiod paramaiod) {}
  
  public void a(long paramLong)
  {
    if (paramLong == 0L) {}
    String str1;
    String str2;
    do
    {
      do
      {
        return;
      } while (!this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)));
      str1 = (String)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      str2 = bbcz.c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong));
      if ((!TextUtils.isEmpty(str2)) && (!str2.equals(str1))) {
        aiod.a(this.a, false);
      }
    } while (!QLog.isColorLevel());
    QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "checkIfNeedUpdate [uin: %d, pre: %s, cur: %s]", new Object[] { Long.valueOf(paramLong), str1, str2 }));
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if (paramBoolean) {
      a(paramLong);
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      if (!(paramObject instanceof ArrayList)) {
        break label70;
      }
    }
    label70:
    for (paramObject = (ArrayList)paramObject;; paramObject = null)
    {
      if ((paramObject != null) && (paramObject.size() > 0))
      {
        paramObject = paramObject.iterator();
        while (paramObject.hasNext())
        {
          Object localObject = paramObject.next();
          if ((localObject instanceof Long)) {
            a(((Long)localObject).longValue());
          }
        }
      }
      return;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {}
    try
    {
      a(Long.parseLong(paramString));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aiol
 * JD-Core Version:    0.7.0.1
 */