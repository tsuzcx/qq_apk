import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.VideoHeadInfo;

public class alyv
{
  public int a;
  public String a;
  
  public static alyv a(oidb_0x74b.VideoHeadInfo paramVideoHeadInfo)
  {
    Object localObject;
    if (paramVideoHeadInfo == null) {
      localObject = null;
    }
    alyv localalyv;
    do
    {
      return localObject;
      localalyv = new alyv();
      if (paramVideoHeadInfo.str_url.has()) {
        localalyv.jdField_a_of_type_JavaLangString = paramVideoHeadInfo.str_url.get();
      }
      localObject = localalyv;
    } while (!paramVideoHeadInfo.uint32_video_size.has());
    localalyv.jdField_a_of_type_Int = paramVideoHeadInfo.uint32_video_size.get();
    return localalyv;
  }
  
  public static ArrayList<alyv> a(List<oidb_0x74b.VideoHeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      alyv localalyv = a((oidb_0x74b.VideoHeadInfo)paramList.next());
      if (localalyv != null) {
        localArrayList.add(localalyv);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alyv
 * JD-Core Version:    0.7.0.1
 */