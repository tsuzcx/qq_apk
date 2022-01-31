import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class aewh
{
  private static final SparseIntArray a = new SparseIntArray();
  
  static
  {
    a.put(2, 10);
    a.put(3, 20);
    a.put(4, 30);
  }
  
  public static <T extends aewe> List<T> a(QQAppInterface paramQQAppInterface, List<T> paramList)
  {
    paramQQAppInterface = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions stickerRecSearches.size:" + paramList.size());
      }
      Collections.sort(paramList, new aewi());
      if (paramList.size() > 0) {
        paramQQAppInterface.add(paramList.remove(0));
      }
      if (paramList.size() > 0) {
        a(paramList, paramQQAppInterface);
      }
      if (paramList.size() > 0)
      {
        Collections.sort(paramList, new aewj());
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
        aewe localaewe = (aewe)paramList.next();
        QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions item.ClickNum:" + localaewe.b() + ",item.ExposeNum: " + localaewe.a());
        continue;
        return paramQQAppInterface;
      }
      QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions stickerRecEmotionList.size:" + paramQQAppInterface.size());
    }
    return paramQQAppInterface;
  }
  
  private static <T extends aewe> void a(List<T> paramList1, List<T> paramList2)
  {
    if (paramList2 == null) {}
    aewe localaewe;
    do
    {
      do
      {
        return;
      } while ((paramList1 == null) || (paramList1.isEmpty()));
      for (localaewe = (aewe)paramList1.remove(0); (a(paramList2, localaewe)) && (paramList1.size() > 0); localaewe = (aewe)paramList1.remove(0)) {}
    } while (a(paramList2, localaewe));
    paramList2.add(localaewe);
  }
  
  private static <T extends aewe> boolean a(List<T> paramList, T paramT)
  {
    if ((paramList == null) || (paramT == null)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (aewe)paramList.next();
      if (((aewe)localObject2).c() != paramT.c())
      {
        Object localObject3;
        Object localObject1;
        String str;
        if ((((aewe)localObject2).c() == 2) && (paramT.c() == 4))
        {
          localObject2 = (aewz)localObject2;
          localObject3 = (aewx)paramT;
          localObject1 = ((aewx)localObject3).a.emoPath;
          localObject3 = ((aewx)localObject3).a.eId;
          str = ((aewz)localObject2).a.epId;
          localObject2 = ((aewz)localObject2).a.eId;
          if ((localObject1 != null) && (((String)localObject1).equals(str)) && (localObject3 != null) && (((String)localObject3).equals(localObject2))) {
            return true;
          }
        }
        else if ((((aewe)localObject2).c() == 4) && (paramT.c() == 2))
        {
          localObject1 = (aewz)paramT;
          localObject3 = (aewx)localObject2;
          localObject2 = ((aewx)localObject3).a.emoPath;
          localObject3 = ((aewx)localObject3).a.eId;
          str = ((aewz)localObject1).a.epId;
          localObject1 = ((aewz)localObject1).a.eId;
          if ((localObject2 != null) && (((String)localObject2).equals(str)) && (localObject3 != null) && (((String)localObject3).equals(localObject1))) {
            return true;
          }
        }
        else
        {
          if ((((aewe)localObject2).c() == 4) && (paramT.c() == 3) && (((aewx)localObject2).b() != null) && (((aewx)localObject2).b().equals(((aewq)paramT).b()))) {
            return true;
          }
          if ((((aewe)localObject2).c() == 3) && (paramT.c() == 4) && (((aewx)paramT).b() != null) && (((aewx)paramT).b().equals(((aewq)localObject2).b()))) {
            return true;
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aewh
 * JD-Core Version:    0.7.0.1
 */