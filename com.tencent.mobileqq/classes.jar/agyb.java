import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class agyb
{
  private static final SparseIntArray a = new SparseIntArray();
  
  static
  {
    a.put(2, 10);
    a.put(3, 20);
    a.put(4, 30);
  }
  
  public static <T extends agxy> List<T> a(QQAppInterface paramQQAppInterface, List<T> paramList)
  {
    paramQQAppInterface = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions stickerRecSearches.size:" + paramList.size());
      }
      Collections.sort(paramList, new agyc());
      if (paramList.size() > 0) {
        paramQQAppInterface.add(paramList.remove(0));
      }
      if (paramList.size() > 0) {
        a(paramList, paramQQAppInterface);
      }
      if (paramList.size() > 0)
      {
        Collections.sort(paramList, new agyd());
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
        agxy localagxy = (agxy)paramList.next();
        QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions item.ClickNum:" + localagxy.b() + ",item.ExposeNum: " + localagxy.a());
        continue;
        return paramQQAppInterface;
      }
      QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions stickerRecEmotionList.size:" + paramQQAppInterface.size());
    }
    return paramQQAppInterface;
  }
  
  private static <T extends agxy> void a(List<T> paramList1, List<T> paramList2)
  {
    if (paramList2 == null) {}
    agxy localagxy;
    do
    {
      do
      {
        return;
      } while ((paramList1 == null) || (paramList1.isEmpty()));
      for (localagxy = (agxy)paramList1.remove(0); (a(paramList2, localagxy)) && (paramList1.size() > 0); localagxy = (agxy)paramList1.remove(0)) {}
    } while (a(paramList2, localagxy));
    paramList2.add(localagxy);
  }
  
  private static <T extends agxy> boolean a(List<T> paramList, T paramT)
  {
    if ((paramList == null) || (paramT == null)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (agxy)paramList.next();
      if (((agxy)localObject2).c() != paramT.c())
      {
        Object localObject3;
        Object localObject1;
        String str;
        if ((((agxy)localObject2).c() == 2) && (paramT.c() == 4))
        {
          localObject2 = (agyt)localObject2;
          localObject3 = (agyr)paramT;
          localObject1 = ((agyr)localObject3).a.emoPath;
          localObject3 = ((agyr)localObject3).a.eId;
          str = ((agyt)localObject2).a.epId;
          localObject2 = ((agyt)localObject2).a.eId;
          if ((localObject1 != null) && (((String)localObject1).equals(str)) && (localObject3 != null) && (((String)localObject3).equals(localObject2))) {
            return true;
          }
        }
        else if ((((agxy)localObject2).c() == 4) && (paramT.c() == 2))
        {
          localObject1 = (agyt)paramT;
          localObject3 = (agyr)localObject2;
          localObject2 = ((agyr)localObject3).a.emoPath;
          localObject3 = ((agyr)localObject3).a.eId;
          str = ((agyt)localObject1).a.epId;
          localObject1 = ((agyt)localObject1).a.eId;
          if ((localObject2 != null) && (((String)localObject2).equals(str)) && (localObject3 != null) && (((String)localObject3).equals(localObject1))) {
            return true;
          }
        }
        else
        {
          if ((((agxy)localObject2).c() == 4) && (paramT.c() == 3) && (((agyr)localObject2).b() != null) && (((agyr)localObject2).b().equals(((agyk)paramT).b()))) {
            return true;
          }
          if ((((agxy)localObject2).c() == 3) && (paramT.c() == 4) && (((agyr)paramT).b() != null) && (((agyr)paramT).b().equals(((agyk)localObject2).b()))) {
            return true;
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agyb
 * JD-Core Version:    0.7.0.1
 */