import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class aewj
{
  private static final SparseIntArray a = new SparseIntArray();
  
  static
  {
    a.put(2, 10);
    a.put(3, 20);
    a.put(4, 30);
  }
  
  public static <T extends aewg> List<T> a(QQAppInterface paramQQAppInterface, List<T> paramList)
  {
    paramQQAppInterface = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions stickerRecSearches.size:" + paramList.size());
      }
      Collections.sort(paramList, new aewk());
      if (paramList.size() > 0) {
        paramQQAppInterface.add(paramList.remove(0));
      }
      if (paramList.size() > 0) {
        a(paramList, paramQQAppInterface);
      }
      if (paramList.size() > 0)
      {
        Collections.sort(paramList, new aewl());
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
        aewg localaewg = (aewg)paramList.next();
        QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions item.ClickNum:" + localaewg.b() + ",item.ExposeNum: " + localaewg.a());
        continue;
        return paramQQAppInterface;
      }
      QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions stickerRecEmotionList.size:" + paramQQAppInterface.size());
    }
    return paramQQAppInterface;
  }
  
  private static <T extends aewg> void a(List<T> paramList1, List<T> paramList2)
  {
    if (paramList2 == null) {}
    aewg localaewg;
    do
    {
      do
      {
        return;
      } while ((paramList1 == null) || (paramList1.isEmpty()));
      for (localaewg = (aewg)paramList1.remove(0); (a(paramList2, localaewg)) && (paramList1.size() > 0); localaewg = (aewg)paramList1.remove(0)) {}
    } while (a(paramList2, localaewg));
    paramList2.add(localaewg);
  }
  
  private static <T extends aewg> boolean a(List<T> paramList, T paramT)
  {
    if ((paramList == null) || (paramT == null)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (aewg)paramList.next();
      if (((aewg)localObject2).c() != paramT.c())
      {
        Object localObject3;
        Object localObject1;
        String str;
        if ((((aewg)localObject2).c() == 2) && (paramT.c() == 4))
        {
          localObject2 = (aexb)localObject2;
          localObject3 = (aewz)paramT;
          localObject1 = ((aewz)localObject3).a.emoPath;
          localObject3 = ((aewz)localObject3).a.eId;
          str = ((aexb)localObject2).a.epId;
          localObject2 = ((aexb)localObject2).a.eId;
          if ((localObject1 != null) && (((String)localObject1).equals(str)) && (localObject3 != null) && (((String)localObject3).equals(localObject2))) {
            return true;
          }
        }
        else if ((((aewg)localObject2).c() == 4) && (paramT.c() == 2))
        {
          localObject1 = (aexb)paramT;
          localObject3 = (aewz)localObject2;
          localObject2 = ((aewz)localObject3).a.emoPath;
          localObject3 = ((aewz)localObject3).a.eId;
          str = ((aexb)localObject1).a.epId;
          localObject1 = ((aexb)localObject1).a.eId;
          if ((localObject2 != null) && (((String)localObject2).equals(str)) && (localObject3 != null) && (((String)localObject3).equals(localObject1))) {
            return true;
          }
        }
        else
        {
          if ((((aewg)localObject2).c() == 4) && (paramT.c() == 3) && (((aewz)localObject2).b() != null) && (((aewz)localObject2).b().equals(((aews)paramT).b()))) {
            return true;
          }
          if ((((aewg)localObject2).c() == 3) && (paramT.c() == 4) && (((aewz)paramT).b() != null) && (((aewz)paramT).b().equals(((aews)localObject2).b()))) {
            return true;
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aewj
 * JD-Core Version:    0.7.0.1
 */