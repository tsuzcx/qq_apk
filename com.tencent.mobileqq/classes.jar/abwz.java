import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emoticonview.CommonUsedSystemEmojiManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x13Rsp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class abwz
  implements Runnable
{
  public abwz(CommonUsedSystemEmojiManager paramCommonUsedSystemEmojiManager) {}
  
  public void run()
  {
    for (;;)
    {
      synchronized (this.a.a)
      {
        File localFile = new File(BaseApplicationImpl.sApplication.getFilesDir(), "commonusedSystemEmojiInfoFile_v3_" + BaseApplicationImpl.sApplication.getRuntime().getAccount());
        EmosmPb.SubCmd0x13Rsp localSubCmd0x13Rsp = new EmosmPb.SubCmd0x13Rsp();
        Object localObject1 = CommonUsedSystemEmojiManager.a(this.a);
        if (localObject1 == null)
        {
          localObject1 = new ArrayList();
          localSubCmd0x13Rsp.itemlist.set((List)localObject1);
          if ((QLog.isColorLevel()) && (((List)localObject1).size() > 0))
          {
            StringBuilder localStringBuilder = new StringBuilder("saveSystemEmojiInfoToFile : itemsInfo = ");
            int i = 0;
            if (i < ((List)localObject1).size())
            {
              EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)((List)localObject1).get(i);
              localStringBuilder.append(";type = " + localSmallYellowItem.type.get()).append(";id = " + localSmallYellowItem.id.get()).append(";ts = " + localSmallYellowItem.ts.get());
              i += 1;
              continue;
            }
            QLog.d("CommonUsedSystemEmojiManager", 2, localStringBuilder.toString());
          }
          FileUtils.a(localFile.getAbsolutePath(), localSubCmd0x13Rsp.toByteArray(), false);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abwz
 * JD-Core Version:    0.7.0.1
 */