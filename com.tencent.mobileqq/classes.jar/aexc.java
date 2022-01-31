import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aexc
  extends aewe
{
  public aexc(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private List<aexb> b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecLocalEmoticonHandleListener", 2, "local emoticon search start.");
    }
    askd localaskd = (askd)this.a.getManager(14);
    List localList = localaskd.b(paramString, true);
    if ((localList == null) || (localList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecLocalEmoticonHandleListener", 2, "findLocalMatchEmoticons arrEmoticon is null or empty,keyWord: " + bbbd.a(paramString));
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < localList.size())
    {
      Object localObject = (Emoticon)localList.get(i);
      EmoticonPackage localEmoticonPackage = localaskd.a(((Emoticon)localObject).epId);
      if (localEmoticonPackage == null) {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecLocalEmoticonHandleListener", 2, "findLocalMatchEmoticons emoticonPackage is null.");
        }
      }
      label225:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if ((localaskd.a == null) || (!localaskd.a.contains(((Emoticon)localObject).epId)) || (localEmoticonPackage.status != 2)) {
            break label225;
          }
          localArrayList.add(new aexb((Emoticon)localObject));
        }
      } while (!QLog.isColorLevel());
      localObject = new StringBuilder().append("findLocalMatchEmoticons emoticonPackage not match, status: ").append(localEmoticonPackage.status).append(" tabCache.size: ");
      if (localaskd.a != null) {}
      for (int j = localaskd.a.size();; j = -1)
      {
        QLog.d("StickerRecLocalEmoticonHandleListener", 2, j);
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecLocalEmoticonHandleListener", 2, "findLocalMatchEmoticons stickerRecEmotionList.size:" + localArrayList.size() + ",keyWord: " + bbbd.a(paramString));
    }
    return localArrayList;
  }
  
  public List<aexb> a(String paramString)
  {
    return b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aexc
 * JD-Core Version:    0.7.0.1
 */