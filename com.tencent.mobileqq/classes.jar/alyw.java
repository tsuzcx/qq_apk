import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.VideoHeadInfo;

public class alyw
{
  public int a;
  public String a;
  
  public static alyw a(oidb_0x74b.VideoHeadInfo paramVideoHeadInfo)
  {
    Object localObject;
    if (paramVideoHeadInfo == null) {
      localObject = null;
    }
    alyw localalyw;
    do
    {
      return localObject;
      localalyw = new alyw();
      if (paramVideoHeadInfo.str_url.has()) {
        localalyw.jdField_a_of_type_JavaLangString = paramVideoHeadInfo.str_url.get();
      }
      localObject = localalyw;
    } while (!paramVideoHeadInfo.uint32_video_size.has());
    localalyw.jdField_a_of_type_Int = paramVideoHeadInfo.uint32_video_size.get();
    return localalyw;
  }
  
  public static ArrayList<alyw> a(List<oidb_0x74b.VideoHeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      alyw localalyw = a((oidb_0x74b.VideoHeadInfo)paramList.next());
      if (localalyw != null) {
        localArrayList.add(localalyw);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alyw
 * JD-Core Version:    0.7.0.1
 */