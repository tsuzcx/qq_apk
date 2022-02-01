import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class aity
  extends aisj
{
  public aity(QQAppInterface paramQQAppInterface)
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
  
  public List<aitx> a(String paramString, aitq paramaitq, SessionInfo paramSessionInfo)
  {
    if ((paramaitq == null) || (!paramaitq.jdField_a_of_type_Boolean)) {}
    do
    {
      return null;
      localObject1 = paramaitq.jdField_a_of_type_JavaUtilList;
    } while ((localObject1 == null) || (((List)localObject1).size() == 0));
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (aitw)((Iterator)localObject1).next();
      if (a(((aitw)localObject2).jdField_a_of_type_JavaUtilList, paramString))
      {
        new aitv().a(this.a, paramSessionInfo, paramString);
        if ((((aitw)localObject2).b != null) && (((aitw)localObject2).b.size() > 0))
        {
          localObject2 = ((aitw)localObject2).b.iterator();
          while (((Iterator)localObject2).hasNext()) {
            localArrayList.add(new aitx((aitu)((Iterator)localObject2).next(), paramSessionInfo, paramString));
          }
        }
      }
    }
    if (paramaitq.jdField_a_of_type_Int == 1) {
      Collections.shuffle(localArrayList);
    }
    return localArrayList;
  }
  
  public List<aitx> a(String paramString, SessionInfo paramSessionInfo)
  {
    return a(paramString, aitr.a(this.a.getApp(), this.a.c()), paramSessionInfo);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aity
 * JD-Core Version:    0.7.0.1
 */