import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.OneUinHeadInfo;

public class alkg
{
  public int a;
  public long a;
  public ArrayList<alkh> a;
  public long b;
  
  public static alkg a(oidb_0x74b.OneUinHeadInfo paramOneUinHeadInfo)
  {
    Object localObject;
    if (paramOneUinHeadInfo == null) {
      localObject = null;
    }
    alkg localalkg;
    do
    {
      return localObject;
      localalkg = new alkg();
      if (paramOneUinHeadInfo.uint64_uin.has()) {
        localalkg.jdField_a_of_type_Long = paramOneUinHeadInfo.uint64_uin.get();
      }
      if (paramOneUinHeadInfo.uint64_tinyid.has()) {
        localalkg.b = paramOneUinHeadInfo.uint64_tinyid.get();
      }
      localalkg.jdField_a_of_type_Int = ((int)(System.currentTimeMillis() / 1000L));
      localObject = localalkg;
    } while (!paramOneUinHeadInfo.rpt_msg_head_list.has());
    localalkg.jdField_a_of_type_JavaUtilArrayList = alkh.a(paramOneUinHeadInfo.rpt_msg_head_list.get());
    return localalkg;
  }
  
  public static ArrayList<alkg> a(List<oidb_0x74b.OneUinHeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      alkg localalkg = a((oidb_0x74b.OneUinHeadInfo)paramList.next());
      if (localalkg != null) {
        localArrayList.add(localalkg);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alkg
 * JD-Core Version:    0.7.0.1
 */