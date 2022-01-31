import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aexa
  extends aewc
{
  public aexa(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private List<aewz> b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecLocalEmoticonHandleListener", 2, "local emoticon search start.");
    }
    askf localaskf = (askf)this.a.getManager(14);
    List localList = localaskf.b(paramString, true);
    if ((localList == null) || (localList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecLocalEmoticonHandleListener", 2, "findLocalMatchEmoticons arrEmoticon is null or empty,keyWord: " + bbbr.a(paramString));
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < localList.size())
    {
      Object localObject = (Emoticon)localList.get(i);
      EmoticonPackage localEmoticonPackage = localaskf.a(((Emoticon)localObject).epId);
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
          if ((localaskf.a == null) || (!localaskf.a.contains(((Emoticon)localObject).epId)) || (localEmoticonPackage.status != 2)) {
            break label225;
          }
          localArrayList.add(new aewz((Emoticon)localObject));
        }
      } while (!QLog.isColorLevel());
      localObject = new StringBuilder().append("findLocalMatchEmoticons emoticonPackage not match, status: ").append(localEmoticonPackage.status).append(" tabCache.size: ");
      if (localaskf.a != null) {}
      for (int j = localaskf.a.size();; j = -1)
      {
        QLog.d("StickerRecLocalEmoticonHandleListener", 2, j);
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecLocalEmoticonHandleListener", 2, "findLocalMatchEmoticons stickerRecEmotionList.size:" + localArrayList.size() + ",keyWord: " + bbbr.a(paramString));
    }
    return localArrayList;
  }
  
  public List<aewz> a(String paramString)
  {
    return b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aexa
 * JD-Core Version:    0.7.0.1
 */