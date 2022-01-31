import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.intervideo.groupvideo.GVideoStateGetListener;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager;
import com.tencent.mobileqq.intervideo.groupvideo.VideoStateInfo;
import com.tencent.mobileqq.troop.utils.TroopVideoManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class adjw
  implements GVideoStateGetListener
{
  public adjw(GroupVideoManager paramGroupVideoManager) {}
  
  public void a(List paramList)
  {
    if (GroupVideoManager.a(this.a) == null) {}
    do
    {
      return;
      Object localObject = new HashMap(GroupVideoManager.a(this.a).a().d);
      QQGAudioMsgHandler localQQGAudioMsgHandler = GroupVideoManager.a(this.a).a();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        VideoStateInfo localVideoStateInfo = (VideoStateInfo)paramList.next();
        long[] arrayOfLong = new long[localVideoStateInfo.jdField_a_of_type_JavaUtilList.size()];
        int i = 0;
        while (i < arrayOfLong.length)
        {
          arrayOfLong[i] = ((Long)localVideoStateInfo.jdField_a_of_type_JavaUtilList.get(i)).longValue();
          i += 1;
        }
        ((TroopVideoManager)GroupVideoManager.a(this.a).getManager(163)).a(localVideoStateInfo.jdField_a_of_type_Long);
        localQQGAudioMsgHandler.a(1, String.valueOf(localVideoStateInfo.jdField_a_of_type_Long), localVideoStateInfo.jdField_a_of_type_Int, arrayOfLong, 14);
        ((Map)localObject).remove(String.valueOf(localVideoStateInfo.jdField_a_of_type_Long));
      }
      paramList = ((Map)localObject).entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject = (Map.Entry)paramList.next();
        if (((Integer)((Map.Entry)localObject).getValue()).intValue() == 14) {
          localQQGAudioMsgHandler.a(1, (String)((Map.Entry)localObject).getKey(), 0, null, 14);
        }
      }
      paramList = GroupVideoManager.a(this.a).getHandler(Conversation.class);
    } while (paramList == null);
    paramList.sendEmptyMessage(1009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adjw
 * JD-Core Version:    0.7.0.1
 */