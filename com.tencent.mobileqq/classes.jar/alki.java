import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.VideoHeadInfo;

public class alki
{
  public int a;
  public String a;
  
  public static alki a(oidb_0x74b.VideoHeadInfo paramVideoHeadInfo)
  {
    Object localObject;
    if (paramVideoHeadInfo == null) {
      localObject = null;
    }
    alki localalki;
    do
    {
      return localObject;
      localalki = new alki();
      if (paramVideoHeadInfo.str_url.has()) {
        localalki.jdField_a_of_type_JavaLangString = paramVideoHeadInfo.str_url.get();
      }
      localObject = localalki;
    } while (!paramVideoHeadInfo.uint32_video_size.has());
    localalki.jdField_a_of_type_Int = paramVideoHeadInfo.uint32_video_size.get();
    return localalki;
  }
  
  public static ArrayList<alki> a(List<oidb_0x74b.VideoHeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      alki localalki = a((oidb_0x74b.VideoHeadInfo)paramList.next());
      if (localalki != null) {
        localArrayList.add(localalki);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alki
 * JD-Core Version:    0.7.0.1
 */