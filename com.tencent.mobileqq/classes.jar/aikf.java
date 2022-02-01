import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class aikf
  extends aiiq
{
  public aikf(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private static boolean a(List<String> paramList, String paramString)
  {
    if ((paramList != null) && (paramList.size() > 0) && (!TextUtils.isEmpty(paramString)))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (((String)paramList.next()).equals(paramString)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public List<aike> a(String paramString, aijx paramaijx, SessionInfo paramSessionInfo)
  {
    if ((paramaijx == null) || (!paramaijx.jdField_a_of_type_Boolean)) {}
    do
    {
      return null;
      localObject1 = paramaijx.jdField_a_of_type_JavaUtilList;
    } while ((localObject1 == null) || (((List)localObject1).size() == 0));
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (aikd)((Iterator)localObject1).next();
      if (a(((aikd)localObject2).jdField_a_of_type_JavaUtilList, paramString))
      {
        new aikc().a(this.a, paramSessionInfo, paramString);
        if ((((aikd)localObject2).b != null) && (((aikd)localObject2).b.size() > 0))
        {
          localObject2 = ((aikd)localObject2).b.iterator();
          while (((Iterator)localObject2).hasNext()) {
            localArrayList.add(new aike((aikb)((Iterator)localObject2).next(), paramSessionInfo, paramString));
          }
        }
      }
    }
    if (paramaijx.jdField_a_of_type_Int == 1) {
      Collections.shuffle(localArrayList);
    }
    return localArrayList;
  }
  
  public List<aike> a(String paramString, SessionInfo paramSessionInfo)
  {
    return a(paramString, aijy.a(this.a.getApp(), this.a.c()), paramSessionInfo);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikf
 * JD-Core Version:    0.7.0.1
 */