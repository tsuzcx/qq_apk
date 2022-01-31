import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.OneUinHeadInfo;

public class alyu
{
  public int a;
  public long a;
  public ArrayList<alyv> a;
  public long b;
  
  public static alyu a(oidb_0x74b.OneUinHeadInfo paramOneUinHeadInfo)
  {
    Object localObject;
    if (paramOneUinHeadInfo == null) {
      localObject = null;
    }
    alyu localalyu;
    do
    {
      return localObject;
      localalyu = new alyu();
      if (paramOneUinHeadInfo.uint64_uin.has()) {
        localalyu.jdField_a_of_type_Long = paramOneUinHeadInfo.uint64_uin.get();
      }
      if (paramOneUinHeadInfo.uint64_tinyid.has()) {
        localalyu.b = paramOneUinHeadInfo.uint64_tinyid.get();
      }
      localalyu.jdField_a_of_type_Int = ((int)(System.currentTimeMillis() / 1000L));
      localObject = localalyu;
    } while (!paramOneUinHeadInfo.rpt_msg_head_list.has());
    localalyu.jdField_a_of_type_JavaUtilArrayList = alyv.a(paramOneUinHeadInfo.rpt_msg_head_list.get());
    return localalyu;
  }
  
  public static ArrayList<alyu> a(List<oidb_0x74b.OneUinHeadInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      alyu localalyu = a((oidb_0x74b.OneUinHeadInfo)paramList.next());
      if (localalyu != null) {
        localArrayList.add(localalyu);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alyu
 * JD-Core Version:    0.7.0.1
 */