import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class aelo
{
  private static final SparseIntArray a = new SparseIntArray();
  
  static
  {
    a.put(2, 10);
    a.put(3, 20);
    a.put(4, 30);
  }
  
  public static <T extends aell> List<T> a(QQAppInterface paramQQAppInterface, List<T> paramList)
  {
    paramQQAppInterface = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions stickerRecSearches.size:" + paramList.size());
      }
      Collections.sort(paramList, new aelp());
      if (paramList.size() > 0) {
        paramQQAppInterface.add(paramList.remove(0));
      }
      if (paramList.size() > 0) {
        a(paramList, paramQQAppInterface);
      }
      if (paramList.size() > 0)
      {
        Collections.sort(paramList, new aelq());
        a(paramList, paramQQAppInterface);
      }
      if (QLog.isColorLevel()) {
        paramList = paramQQAppInterface.iterator();
      }
    }
    else
    {
      while (paramList.hasNext())
      {
        aell localaell = (aell)paramList.next();
        QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions item.ClickNum:" + localaell.b() + ",item.ExposeNum: " + localaell.a());
        continue;
        return paramQQAppInterface;
      }
      QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions stickerRecEmotionList.size:" + paramQQAppInterface.size());
    }
    return paramQQAppInterface;
  }
  
  private static <T extends aell> void a(List<T> paramList1, List<T> paramList2)
  {
    if (paramList2 == null) {}
    aell localaell;
    do
    {
      do
      {
        return;
      } while ((paramList1 == null) || (paramList1.isEmpty()));
      for (localaell = (aell)paramList1.remove(0); (a(paramList2, localaell)) && (paramList1.size() > 0); localaell = (aell)paramList1.remove(0)) {}
    } while (a(paramList2, localaell));
    paramList2.add(localaell);
  }
  
  private static <T extends aell> boolean a(List<T> paramList, T paramT)
  {
    if ((paramList == null) || (paramT == null)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (aell)paramList.next();
      if (((aell)localObject2).c() != paramT.c())
      {
        Object localObject3;
        Object localObject1;
        String str;
        if ((((aell)localObject2).c() == 2) && (paramT.c() == 4))
        {
          localObject2 = (aemg)localObject2;
          localObject3 = (aeme)paramT;
          localObject1 = ((aeme)localObject3).a.emoPath;
          localObject3 = ((aeme)localObject3).a.eId;
          str = ((aemg)localObject2).a.epId;
          localObject2 = ((aemg)localObject2).a.eId;
          if ((localObject1 != null) && (((String)localObject1).equals(str)) && (localObject3 != null) && (((String)localObject3).equals(localObject2))) {
            return true;
          }
        }
        else if ((((aell)localObject2).c() == 4) && (paramT.c() == 2))
        {
          localObject1 = (aemg)paramT;
          localObject3 = (aeme)localObject2;
          localObject2 = ((aeme)localObject3).a.emoPath;
          localObject3 = ((aeme)localObject3).a.eId;
          str = ((aemg)localObject1).a.epId;
          localObject1 = ((aemg)localObject1).a.eId;
          if ((localObject2 != null) && (((String)localObject2).equals(str)) && (localObject3 != null) && (((String)localObject3).equals(localObject1))) {
            return true;
          }
        }
        else
        {
          if ((((aell)localObject2).c() == 4) && (paramT.c() == 3) && (((aeme)localObject2).b() != null) && (((aeme)localObject2).b().equals(((aelx)paramT).b()))) {
            return true;
          }
          if ((((aell)localObject2).c() == 3) && (paramT.c() == 4) && (((aeme)paramT).b() != null) && (((aeme)paramT).b().equals(((aelx)localObject2).b()))) {
            return true;
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aelo
 * JD-Core Version:    0.7.0.1
 */