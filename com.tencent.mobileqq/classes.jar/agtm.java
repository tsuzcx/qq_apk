import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class agtm
{
  private static final SparseIntArray a = new SparseIntArray();
  
  static
  {
    a.put(2, 10);
    a.put(3, 20);
    a.put(4, 30);
  }
  
  public static <T extends agtj> List<T> a(QQAppInterface paramQQAppInterface, List<T> paramList)
  {
    paramQQAppInterface = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions stickerRecSearches.size:" + paramList.size());
      }
      Collections.sort(paramList, new agtn());
      if (paramList.size() > 0) {
        paramQQAppInterface.add(paramList.remove(0));
      }
      if (paramList.size() > 0) {
        a(paramList, paramQQAppInterface);
      }
      if (paramList.size() > 0)
      {
        Collections.sort(paramList, new agto());
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
        agtj localagtj = (agtj)paramList.next();
        QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions item.ClickNum:" + localagtj.b() + ",item.ExposeNum: " + localagtj.a());
        continue;
        return paramQQAppInterface;
      }
      QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions stickerRecEmotionList.size:" + paramQQAppInterface.size());
    }
    return paramQQAppInterface;
  }
  
  private static <T extends agtj> void a(List<T> paramList1, List<T> paramList2)
  {
    if (paramList2 == null) {}
    agtj localagtj;
    do
    {
      do
      {
        return;
      } while ((paramList1 == null) || (paramList1.isEmpty()));
      for (localagtj = (agtj)paramList1.remove(0); (a(paramList2, localagtj)) && (paramList1.size() > 0); localagtj = (agtj)paramList1.remove(0)) {}
    } while (a(paramList2, localagtj));
    paramList2.add(localagtj);
  }
  
  private static <T extends agtj> boolean a(List<T> paramList, T paramT)
  {
    if ((paramList == null) || (paramT == null)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (agtj)paramList.next();
      if (((agtj)localObject2).c() != paramT.c())
      {
        Object localObject3;
        Object localObject1;
        String str;
        if ((((agtj)localObject2).c() == 2) && (paramT.c() == 4))
        {
          localObject2 = (ague)localObject2;
          localObject3 = (aguc)paramT;
          localObject1 = ((aguc)localObject3).a.emoPath;
          localObject3 = ((aguc)localObject3).a.eId;
          str = ((ague)localObject2).a.epId;
          localObject2 = ((ague)localObject2).a.eId;
          if ((localObject1 != null) && (((String)localObject1).equals(str)) && (localObject3 != null) && (((String)localObject3).equals(localObject2))) {
            return true;
          }
        }
        else if ((((agtj)localObject2).c() == 4) && (paramT.c() == 2))
        {
          localObject1 = (ague)paramT;
          localObject3 = (aguc)localObject2;
          localObject2 = ((aguc)localObject3).a.emoPath;
          localObject3 = ((aguc)localObject3).a.eId;
          str = ((ague)localObject1).a.epId;
          localObject1 = ((ague)localObject1).a.eId;
          if ((localObject2 != null) && (((String)localObject2).equals(str)) && (localObject3 != null) && (((String)localObject3).equals(localObject1))) {
            return true;
          }
        }
        else
        {
          if ((((agtj)localObject2).c() == 4) && (paramT.c() == 3) && (((aguc)localObject2).b() != null) && (((aguc)localObject2).b().equals(((agtv)paramT).b()))) {
            return true;
          }
          if ((((agtj)localObject2).c() == 3) && (paramT.c() == 4) && (((aguc)paramT).b() != null) && (((aguc)paramT).b().equals(((agtv)localObject2).b()))) {
            return true;
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agtm
 * JD-Core Version:    0.7.0.1
 */