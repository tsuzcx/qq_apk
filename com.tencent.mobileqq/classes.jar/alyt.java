import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.OneUinHeadInfo;

public class alyt
{
  public int a;
  public long a;
  public ArrayList<alyu> a;
  public long b;
  
  public static alyt a(oidb_0x74b.OneUinHeadInfo paramOneUinHeadInfo)
  {
    Object localObject;
    if (paramOneUinHeadInfo == null) {
      localObject = null;
    }
    alyt localalyt;
    do
    {
      return localObject;
      localalyt = new alyt();
      if (paramOneUinHeadInfo.uint64_uin.has()) {
        localalyt.jdField_a_of_type_Long = paramOneUinHeadInfo.uint64_uin.get();
      }
      if (paramOneUinHeadInfo.uint64_tinyid.has()) {
        localalyt.b = paramOneUinHeadInfo.uint64_tinyid.get();
      }
      localalyt.jdField_a_of_type_Int = ((int)(System.currentTimeMillis() / 1000L));
      localObject = localalyt;
    } while (!paramOneUinHeadInfo.rpt_msg_head_list.has());
    localalyt.jdField_a_of_type_JavaUtilArrayList = alyu.a(paramOneUinHeadInfo.rpt_msg_head_list.get());
    return localalyt;
  }
  
  public static ArrayList<alyt> a(List<oidb_0x74b.OneUinHeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      alyt localalyt = a((oidb_0x74b.OneUinHeadInfo)paramList.next());
      if (localalyt != null) {
        localArrayList.add(localalyt);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alyt
 * JD-Core Version:    0.7.0.1
 */