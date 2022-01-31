import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelMediaTabView;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class acgm
  implements Runnable
{
  public acgm(QfileLocalFileDelMediaTabView paramQfileLocalFileDelMediaTabView) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    FileCategoryUtil.a(false, FMSettings.a().b(), ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", "", localHashMap, null);
    Object localObject1 = FMSettings.a().a();
    if (localObject1 != null) {
      FileCategoryUtil.a(false, (String)localObject1, ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", "", localHashMap, null);
    }
    localObject1 = new HashMap();
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      String str = this.a.a((String)localObject2);
      localObject2 = (List)localHashMap.get(localObject2);
      if (!((HashMap)localObject1).containsKey(str)) {
        ((HashMap)localObject1).put(str, new ArrayList());
      }
      ((List)((HashMap)localObject1).get(str)).addAll((Collection)localObject2);
    }
    FileCategoryUtil.a((Map)localObject1);
    QfileLocalFileDelMediaTabView.a(this.a, new acgn(this, (HashMap)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acgm
 * JD-Core Version:    0.7.0.1
 */