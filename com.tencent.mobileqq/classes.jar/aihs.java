import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class aihs
{
  private static final SparseIntArray a = new SparseIntArray();
  
  static
  {
    a.put(2, 10);
    a.put(3, 20);
    a.put(4, 30);
  }
  
  public static <T extends aihp> List<T> a(QQAppInterface paramQQAppInterface, List<T> paramList)
  {
    paramQQAppInterface = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions stickerRecSearches.size:" + paramList.size());
      }
      a(paramList, paramQQAppInterface);
      a(paramList);
      if (paramList.size() > 0) {
        paramQQAppInterface.add(paramList.remove(0));
      }
      if (paramList.size() > 0) {
        b(paramList, paramQQAppInterface);
      }
      if (paramList.size() > 0)
      {
        Collections.sort(paramList, new aiht());
        b(paramList, paramQQAppInterface);
      }
      if (QLog.isColorLevel()) {
        paramList = paramQQAppInterface.iterator();
      }
    }
    else
    {
      while (paramList.hasNext())
      {
        aihp localaihp = (aihp)paramList.next();
        QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions item.ClickNum:" + localaihp.b() + ",item.ExposeNum: " + localaihp.a());
        continue;
        return paramQQAppInterface;
      }
      QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions stickerRecEmotionList.size:" + paramQQAppInterface.size());
    }
    return paramQQAppInterface;
  }
  
  public static <T extends aihp> void a(List<T> paramList)
  {
    Collections.sort(paramList, new aihu());
  }
  
  public static <T extends aihp> void a(List<T> paramList1, List<T> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList1.iterator();
    while (localIterator.hasNext())
    {
      aihp localaihp = (aihp)localIterator.next();
      if (localaihp.c() == 5)
      {
        paramList2.add(localaihp);
        localArrayList.add(localaihp);
      }
    }
    paramList1.removeAll(localArrayList);
  }
  
  private static <T extends aihp> boolean a(List<T> paramList, T paramT)
  {
    if ((paramList == null) || (paramT == null)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (aihp)paramList.next();
      if (((aihp)localObject2).c() != paramT.c())
      {
        Object localObject3;
        Object localObject1;
        String str;
        if ((((aihp)localObject2).c() == 2) && (paramT.c() == 4))
        {
          localObject2 = (aiil)localObject2;
          localObject3 = (aiij)paramT;
          localObject1 = ((aiij)localObject3).a.emoPath;
          localObject3 = ((aiij)localObject3).a.eId;
          str = ((aiil)localObject2).a.epId;
          localObject2 = ((aiil)localObject2).a.eId;
          if ((localObject1 != null) && (((String)localObject1).equals(str)) && (localObject3 != null) && (((String)localObject3).equals(localObject2))) {
            return true;
          }
        }
        else if ((((aihp)localObject2).c() == 4) && (paramT.c() == 2))
        {
          localObject1 = (aiil)paramT;
          localObject3 = (aiij)localObject2;
          localObject2 = ((aiij)localObject3).a.emoPath;
          localObject3 = ((aiij)localObject3).a.eId;
          str = ((aiil)localObject1).a.epId;
          localObject1 = ((aiil)localObject1).a.eId;
          if ((localObject2 != null) && (((String)localObject2).equals(str)) && (localObject3 != null) && (((String)localObject3).equals(localObject1))) {
            return true;
          }
        }
        else
        {
          if ((((aihp)localObject2).c() == 4) && (paramT.c() == 3) && (((aiij)localObject2).c() != null) && (((aiij)localObject2).c().equals(((aiib)paramT).c()))) {
            return true;
          }
          if ((((aihp)localObject2).c() == 3) && (paramT.c() == 4) && (((aiij)paramT).c() != null) && (((aiij)paramT).c().equals(((aiib)localObject2).c()))) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private static <T extends aihp> void b(List<T> paramList1, List<T> paramList2)
  {
    if (paramList2 == null) {}
    aihp localaihp;
    do
    {
      do
      {
        return;
      } while ((paramList1 == null) || (paramList1.isEmpty()));
      for (localaihp = (aihp)paramList1.remove(0); (a(paramList2, localaihp)) && (paramList1.size() > 0); localaihp = (aihp)paramList1.remove(0)) {}
    } while (a(paramList2, localaihp));
    paramList2.add(localaihp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aihs
 * JD-Core Version:    0.7.0.1
 */