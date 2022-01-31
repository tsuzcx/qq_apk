import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aguf
  extends agth
{
  public aguf(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private List<ague> b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecLocalEmoticonHandleListener", 2, "local emoticon search start.");
    }
    aube localaube = (aube)this.a.getManager(14);
    List localList = localaube.b(paramString, true);
    if ((localList == null) || (localList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecLocalEmoticonHandleListener", 2, "findLocalMatchEmoticons arrEmoticon is null or empty,keyWord: " + bdal.a(paramString));
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < localList.size())
    {
      Object localObject = (Emoticon)localList.get(i);
      EmoticonPackage localEmoticonPackage = localaube.a(((Emoticon)localObject).epId);
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
          if ((localaube.a == null) || (!localaube.a.contains(((Emoticon)localObject).epId)) || (localEmoticonPackage.status != 2)) {
            break label225;
          }
          localArrayList.add(new ague((Emoticon)localObject));
        }
      } while (!QLog.isColorLevel());
      localObject = new StringBuilder().append("findLocalMatchEmoticons emoticonPackage not match, status: ").append(localEmoticonPackage.status).append(" tabCache.size: ");
      if (localaube.a != null) {}
      for (int j = localaube.a.size();; j = -1)
      {
        QLog.d("StickerRecLocalEmoticonHandleListener", 2, j);
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecLocalEmoticonHandleListener", 2, "findLocalMatchEmoticons stickerRecEmotionList.size:" + localArrayList.size() + ",keyWord: " + bdal.a(paramString));
    }
    return localArrayList;
  }
  
  public List<ague> a(String paramString)
  {
    return b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aguf
 * JD-Core Version:    0.7.0.1
 */