import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class adac
  implements Runnable
{
  public adac(QfileLocalFileMediaTabView paramQfileLocalFileMediaTabView) {}
  
  public void run()
  {
    HashMap localHashMap1 = new HashMap();
    Object localObject = FMSettings.a().a();
    if ((QfileLocalFileMediaTabView.a(this.a) & 0x1) > 0)
    {
      FileCategoryUtil.a(true, FMSettings.a().b(), ".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", ".mpg", localHashMap1, null);
      if (localObject != null) {
        FileCategoryUtil.a(true, (String)localObject, ".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", ".mpg", localHashMap1, null);
      }
      FileCategoryUtil.a(localHashMap1);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.a.a);
    HashMap localHashMap2 = new HashMap();
    if ((QfileLocalFileMediaTabView.a(this.a) & 0x2) > 0)
    {
      FileCategoryUtil.a(true, FMSettings.a().b(), ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|", "", localHashMap2, null);
      if (localObject != null) {
        FileCategoryUtil.a(true, (String)localObject, ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|", "", localHashMap2, null);
      }
      FileCategoryUtil.a(localHashMap2);
    }
    localObject = localHashMap2.keySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.addAll((Collection)localHashMap2.get((String)((Iterator)localObject).next()));
    }
    localObject = localHashMap1.keySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.addAll((Collection)localHashMap1.get((String)((Iterator)localObject).next()));
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = localArrayList.iterator();
    FileInfo localFileInfo;
    while (localIterator.hasNext())
    {
      localFileInfo = (FileInfo)localIterator.next();
      if (localFileInfo == null)
      {
        localIterator.remove();
      }
      else
      {
        localObject = localFileInfo.a();
        if ((localObject != null) && (((String)localObject).length() != 0))
        {
          if ((((String)localObject).equalsIgnoreCase("camera") != true) && (((String)localObject).equalsIgnoreCase("Video") != true)) {
            break label405;
          }
          localObject = "Camera";
        }
      }
    }
    label405:
    for (;;)
    {
      if (!localLinkedHashMap.containsKey(localObject)) {
        localLinkedHashMap.put(localObject, new ArrayList());
      }
      if (((List)localLinkedHashMap.get(localObject)).contains(localFileInfo)) {
        break;
      }
      ((List)localLinkedHashMap.get(localObject)).add(localFileInfo);
      break;
      QfileLocalFileMediaTabView.a(this.a, new adad(this, localArrayList, localHashMap2, localHashMap1, localLinkedHashMap));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adac
 * JD-Core Version:    0.7.0.1
 */